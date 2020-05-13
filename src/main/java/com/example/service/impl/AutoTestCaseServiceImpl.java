package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.second.AutoTestCaseMapper;
import com.example.enums.CaseEnum;
import com.example.model.AutoTestCase;
import com.example.model.AutoTestCaseWithBLOBs;
import com.example.service.AutoTestCaseService;
import com.example.util.ApiTestUtils;
import com.example.vo.ResponseResult;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yicg
 * @createTime 2020年04月01日 14:54:00
 * @Description
 */

@Slf4j
@Service
public class AutoTestCaseServiceImpl implements AutoTestCaseService {

    @Autowired
    private AutoTestCaseMapper autoTestCaseMapper;

    /**
     * 调用登录接口
     * @param id
     * @return
     */
    @Override
    public ResponseResult loginCase(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);
        //用例状态初始化
        updateAutoTestCaseBeforeTest(id);

        String response=ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        JSONObject result=JSON.parseObject(response);
        if(ApiTestUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            throw new RuntimeException("用例执行失败...");
        }
        return ResponseResult.createBySuccessMessage(result);
    }


    @Override
    public ResponseResult AutoTestCaseById(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs=autoTestCaseMapper.selectByPrimaryKey(id);
        //用例状态初始化
        updateAutoTestCaseBeforeTest(id);

        String response=ApiTestUtils.doHttpRequest(autoTestCaseWithBLOBs);
        JSONObject result=JSON.parseObject(response);
        if(ApiTestUtils.resultCode==HttpStatus.SC_OK){
            updateAutoTestCaseAfterTest(id,response,CaseEnum.SUCCESS.getMessage());
        }else {
            updateAutoTestCaseAfterTest(id,response,CaseEnum.FAIL.getMessage());
            throw new RuntimeException("用例执行失败...");
        }
        return ResponseResult.createBySuccessMessage(result);

    }

    /**
     * 批量执行用例
     * @param ids
     * @return
     */
    @Override
    public ResponseResult AutoTestCaseByListIds(List<Integer> ids) {
        List<AutoTestCase> list=autoTestCaseMapper.findAutoTestCaseIdList(ids);
        List<ResponseResult> responseResultList= Lists.newArrayList();
        for (AutoTestCase autoTestCase:list){
        // responseResultList.add(AutoTestCaseById(autoTestCase.getId()));
            //调用登录
            if(autoTestCase.getId()==22){
                //直接注册，不要登录
                responseResultList.add(AutoTestCaseById(autoTestCase.getId()));
            }
            if(autoTestCase.getId()==15){
                //直接登录
                loginCase(autoTestCase.getId());
                return ResponseResult.createBySuccessMessage("初始化登录成功！！！");
            }else {
                //先登录在操作其他
                loginCase(15);
                responseResultList.add(AutoTestCaseById(autoTestCase.getId()));
            }
        }
        return ResponseResult.createBySuccessMessage(responseResultList);
    }













    /**
     * 测试用例执行前初始化执行状态
     * @param id
     * @return
     */
    private int updateAutoTestCaseBeforeTest(int id) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setState(CaseEnum.UNKNOW.getMessage());
        autoTestCaseWithBLOBs.setActualResult("null");
        autoTestCaseWithBLOBs.setId(id);
        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例id:{},执行结果:{}",id,"用例状态初始化成功.....");
        }else {log.error("用例id:{},执行结果:{}","用例状态初始化失败.....");
            throw new RuntimeException("用例编号id"+id+"用例状态初始化失败");
        }
        return i;
    }

    /**
     * 用例执行后更新状态到库
     * @param id
     * @param response
     * @param state
     * @return
     */
    private int updateAutoTestCaseAfterTest(int id,String response,String state) {
        AutoTestCaseWithBLOBs autoTestCaseWithBLOBs = new AutoTestCaseWithBLOBs();
        autoTestCaseWithBLOBs.setId(id);
        autoTestCaseWithBLOBs.setActualResult(response);
        autoTestCaseWithBLOBs.setState(state);

        int i=autoTestCaseMapper.updateByPrimaryKeySelective(autoTestCaseWithBLOBs);
        if(i>0){
            log.info("用例id:{},执行结果:{}",id,"用例执行状态修改成功.....");
        }else {
            log.error("用例id:{},执行结果:{}",id,"用例执行状态修改失败.....");
            throw new RuntimeException("用例编号id"+id+"用例执行状态修改失败");
        }
        return i;
    }




}

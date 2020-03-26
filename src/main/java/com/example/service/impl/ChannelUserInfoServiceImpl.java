package com.example.service.impl;

import com.example.dao.*;
import com.example.model.*;
import com.example.service.ChannelUserInfoService;
import com.example.util.RandomUtils;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yicg
 * @createTime 2020年03月24日 17:46:00
 * @Description
 */
@Service
public class ChannelUserInfoServiceImpl implements ChannelUserInfoService {

    @Autowired
    private ChannelUserInfoMapper channelUserInfoMapper;


    @Autowired
    private ChannelBankInfoMapper bankInfoMapper;

    @Autowired
    private ChannelDeviceInfoMapper deviceInfoMapper;

    @Autowired
    private ChannelFaceResultInfoMapper faceResultInfoMapper;

    @Autowired
    private ChannelOcrInfoMapper ocrInfoMapper;

    @Autowired
    private ChannelRelationInfoMapper relationInfoMapper;


    @Override
    public ResponseResult updateChannelUserInfo() {
        ChannelUserInfo channelUserInfo=new ChannelUserInfo();
        channelUserInfo.setUid(RandomUtils.randomUtil(11));
        channelUserInfo.setIdCardNo("330"+RandomUtils.randomUtil(15));
        channelUserInfo.setMobileNo(RandomUtils.phoneUtil());
        channelUserInfo.setUserName("TESER"+RandomUtils.randomUtil(3));

        channelUserInfo.setCardInvalidDate("20300"+RandomUtils.randomUtil(1)+"1"+RandomUtils.randomUtil(1));
        channelUserInfo.setEduType(RandomUtils.randomUtil(2));
        channelUserInfo.setNationality(RandomUtils.randomUtil(5));
        channelUserInfo.setCompanyAddress("中国上海");
        channelUserInfo.setPermanentAddress("北京");
        channelUserInfo.setProvince("江苏省");
        channelUserInfo.setCity("南京市");
        channelUserInfo.setArea("玄武区");


        channelUserInfoMapper.updateAll(channelUserInfo);

        return ResponseResult.createBySuccess("脚本执行完成");
    }


    @Override
    public ResponseResult updateInfoByUid(String uid) {
        ChannelOcrInfoWithBLOBs ocrInfo=new ChannelOcrInfoWithBLOBs();
        ChannelBankInfo bankInfo=new ChannelBankInfo();
        ChannelDeviceInfo deviceInfo=new ChannelDeviceInfo();

        ChannelFaceResultInfo resultInfo=new ChannelFaceResultInfo();
        ChannelRelationInfo relationInfo1=new ChannelRelationInfo();
        ChannelRelationInfo relationInfo2=new ChannelRelationInfo();

        ChannelUserInfo userInfo=channelUserInfoMapper.selectByUid(uid);
        String UID=userInfo.getUid();
        String id_card_no=userInfo.getIdCardNo();
        String mobile_no=userInfo.getMobileNo();
        String user_name=userInfo.getUserName();
        String card_invalid_date=userInfo.getCardInvalidDate();
        String company_name=userInfo.getCompanyName();
        String company_address=userInfo.getCompanyAddress();
        String permanent_address=userInfo.getPermanentAddress();
        String province=userInfo.getProvince();
        String city=userInfo.getCity();
        String area=userInfo.getArea();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        df.format(new Date());

        //银行卡信息表
        bankInfo.setUid(uid);
        bankInfo.setBankCardNo("621081257000018156"+RandomUtils.randomBankUtil());
        bankInfo.setMobile(mobile_no);
        bankInfo.setCardName(user_name);
        bankInfo.setCardType("1");
        bankInfo.setBankName("建设银行");
        bankInfo.setBankShortCd("CCB");
        bankInfo.setCardBinNo("621081");
        bankInfo.setCardLength(19);
        bankInfo.setBankNo("CMBCCNBS");
        //设备信息
        deviceInfo.setUid(uid);
        deviceInfo.setIp("61.131.207."+RandomUtils.randomBankUtil());
        deviceInfo.setImei("6113120774567"+RandomUtils.randomBankUtil());
        deviceInfo.setInternetType("WIFI");
        deviceInfo.setWifiId("4567643213"+RandomUtils.randomBankUtil());
        deviceInfo.setWifiName("test-wifi");
        deviceInfo.setLatitude(Double.valueOf("32."+RandomUtils.randomBankUtil()));
        deviceInfo.setLongitude(Double.valueOf("114."+RandomUtils.randomBankUtil()));
        deviceInfo.setMac("B8:C7:4A:68:6C:"+RandomUtils.randomBankUtil());
        deviceInfo.setPhoneModel("HUAWEI");
        deviceInfo.setPhoneMarker("荣耀");
        deviceInfo.setOs("Android");
        deviceInfo.setApplyDate(new Date());
        deviceInfo.setVersion(1);

        //人脸识别信息
        resultInfo.setUid(uid);
        resultInfo.setThreshold(RandomUtils.randomBankUtil());
        resultInfo.setFaceCmpScore(RandomUtils.randomBankUtil());
        resultInfo.setFaceAuthTimes(RandomUtils.randomBankUtil());
        resultInfo.setAliveTimes(RandomUtils.randomBankUtil());
        resultInfo.setDetail("脚本添加");
        resultInfo.setApplyDate(new Date());
        resultInfo.setVersion(1);

        //ocr表
        ocrInfo.setUid(uid);
        ocrInfo.setName(user_name);
        ocrInfo.setCardIdNo(id_card_no);
        ocrInfo.setCardInvalidDate(card_invalid_date);
        ocrInfo.setAddress(province);
        ocrInfo.setFetchPhotoMethod("auto");
        ocrInfo.setDetail("auto test");

        //第一关系人信息表
        relationInfo1.setUid(uid);
        relationInfo1.setRelationLevel(1);
        relationInfo1.setRelationName("第一联系人");
        relationInfo1.setMobileNo("1531706310"+RandomUtils.randomBankUtil());
        relationInfo1.setRelation("PARENT");
        //第二关系人信息表
        relationInfo2.setUid(uid);
        relationInfo2.setRelationLevel(2);
        relationInfo2.setRelationName("第二联系人");
        relationInfo2.setMobileNo("1531706310"+RandomUtils.randomBankUtil());
        relationInfo2.setRelation("FRIEND");


        if(StringUtils.isEmpty(bankInfoMapper.selectByUid(uid))){
            bankInfoMapper.insertSelective(bankInfo);
        }bankInfoMapper.updateByUid(bankInfo);
        if(StringUtils.isEmpty(deviceInfoMapper.selectByUid(uid))){
            deviceInfoMapper.insertSelective(deviceInfo);
        }deviceInfoMapper.updateByUid(deviceInfo);
        if(StringUtils.isEmpty(faceResultInfoMapper.selectByUid(uid))){
            faceResultInfoMapper.insertSelective(resultInfo);
        }faceResultInfoMapper.updateByUid(resultInfo);
        if(StringUtils.isEmpty(ocrInfoMapper.selectByUid(uid))){
            ocrInfoMapper.insertSelective(ocrInfo);
        }ocrInfoMapper.updateByUid(ocrInfo);
        if(relationInfoMapper.selectByUid(uid).size()==0){
            relationInfoMapper.insertSelective(relationInfo1);
            relationInfoMapper.insertSelective(relationInfo2);
        }else
            if(StringUtils.isEmpty(relationInfoMapper.selectByUidAndRelationLevel(uid,1))){
            relationInfoMapper.insertSelective(relationInfo1);
          } else if (StringUtils.isEmpty(relationInfoMapper.selectByUidAndRelationLevel(uid,2))){
            relationInfoMapper.insertSelective(relationInfo2);
        }

        return ResponseResult.createBySuccess("执行成功");
    }


}

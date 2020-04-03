package com.example.common.auto;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:06:00
 * @Description
 */
@Component
public class AutoTestCaseFeatureComponent {


    public static HashMap<String, String> paramMap = new HashMap<String, String>();

    static {
        if (paramMap.size() == 0) {
            paramMap.put("input.user.userName", InPutFieldCodeEnum.USERNAME.name());
            paramMap.put("input.user.passWord", InPutFieldCodeEnum.PASSWORD.name());

        }

    }
}

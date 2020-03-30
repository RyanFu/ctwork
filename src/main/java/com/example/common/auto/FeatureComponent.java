package com.example.common.auto;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:06:00
 * @Description
 */
@Component
public class FeatureComponent {


    public static HashMap<String, Object> paramMap = new HashMap<String, Object>();

    static {
        if (paramMap.size() == 0) {
            paramMap.put("input.user.userName", InPutFieldCode.USERNAME.name());
            paramMap.put("input.user.passWord", InPutFieldCode.PASSWORD.name());

        }

    }
}

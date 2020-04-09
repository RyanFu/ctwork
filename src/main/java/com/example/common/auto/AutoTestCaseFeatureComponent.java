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
            paramMap.put("input.user.answer", InPutFieldCodeEnum.ANSWER.name());
            paramMap.put("input.user.email", InPutFieldCodeEnum.EMAIL.name());
            paramMap.put("input.user.password", InPutFieldCodeEnum.PASSWORD.name());
            paramMap.put("input.user.phone", InPutFieldCodeEnum.PHONE.name());
            paramMap.put("input.user.question", InPutFieldCodeEnum.QUESTION.name());
            paramMap.put("input.user.role", InPutFieldCodeEnum.ROLE.name());
            paramMap.put("input.user.username", InPutFieldCodeEnum.USERNAME.name());

        }

    }
}

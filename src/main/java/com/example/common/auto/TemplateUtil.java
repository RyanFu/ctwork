package com.example.common.auto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yicg
 * @createTime 2020年03月30日 16:15:00
 * @Description
 */
@Slf4j
public class TemplateUtil {




    /**
     * 替换模版参数
     *
     * @param bodyPattern
     * @param param
     * @return
     */
    public static String makeParamter(String bodyPattern, Map<String, String> param, HashMap<String, String> converMap) {

        List<String> ls = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(\\$\\{[^\\}]+})");
        Matcher matcher = pattern.matcher(bodyPattern);
        while (matcher.find()) {
            String key = matcher.group();
            String convertKey = converMap.get(formatParamCode(key));
            log.info(" body pattern key = " + key + " convert to  " + convertKey);
            convertKey = (convertKey == null ? key : convertKey);
            String value = param.get(convertKey);
            bodyPattern = bodyPattern.replace(key, value == null ? "" : value);
        }

        return bodyPattern;
    }

    public static String formatParamCode(String paramCode) {
        return paramCode.replaceAll("\\$", "").replaceAll("\\{", "").replaceAll("\\}", "");
    }

}

package com.example.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Author: yicg
 * @Date: 2019/7/23 13:58
 * @Version 1.0
 */
public class MergeJSONObjects {

    /**
     * json串合并
     *
     *
     * json1:
     * {
     *     "Crunchify": "Java Company",
     *     "Yahoo": "Web Company",
     *     "Google": "Search Company"
     * }
     * json2:
     * {
     *     "Linkedin": "Professional Network Company",
     *     "Facebook": "Social Network Company",
     *     "Twitter": "Another Social Company"
     * }
     *
     * mergedJSON:
     * {
     *     "Crunchify": "Java Company",
     *     "Linkedin": "Professional Network Company",
     *     "Yahoo": "Web Company",
     *     "Facebook": "Social Network Company",
     *     "Google": "Search Company",
     *     "Twitter": "Another Social Company"
     * }
     * @param json1
     * @param json2
     * @return
     */
    public static JSONObject mergeJSONObjects(JSONObject json1, JSONObject json2) {
        JSONObject mergedJSON = new JSONObject();
        try {
            mergedJSON = new JSONObject(json1, JSONObject.getNames(json1));
            for (String crunchifyKey : JSONObject.getNames(json2)) {
                mergedJSON.put(crunchifyKey, json2.get(crunchifyKey));
            }

        } catch (JSONException e) {
            throw new RuntimeException("JSON Exception" + e);
        }
        return mergedJSON;
    }
}

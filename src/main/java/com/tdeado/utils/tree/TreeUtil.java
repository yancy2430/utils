package com.tdeado.utils.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeUtil {
    /**
     * Java list转无限级树 自定义字段
     * @param dbList
     * @param parentcode
     * @return
     */
    public static List<Map<String, Object>> getLevelData(List<Map<String, Object>> dbList, String parentcode,String idField,String upidField,String sonField) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Map<String, Object> data : dbList) {
            if (String.valueOf(data.get(upidField)).equals(parentcode)) {
                List<Map<String, Object>> childList = getLevelData(dbList, (String) data.get(idField),idField,upidField,sonField);
                data.put(sonField, childList);
                resultList.add(data);
            }
        }
        return resultList;
    }
    /**
     * Java list转无限级树 默认字段
     * @param dbList
     * @param parentcode
     * @return
     */
    public static List<Map<String, Object>> getLevelData(List<Map<String, Object>> dbList, String parentcode) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Map<String, Object> data : dbList) {
            String upid2 = String.valueOf(data.get("upid"));
            if (upid2.split("\\.")[0].equals(parentcode)) {
                List<Map<String, Object>> childList = getLevelData(dbList, String.valueOf(data.get("id")).split("\\.")[0]);
                data.put("list", childList);
                resultList.add(data);
            }
        }
        return resultList;
    }
}

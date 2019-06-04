package com.tdeado.utils.json;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonUtil {
    private static GsonUtil ourInstance = new GsonUtil();


    private static Gson gson = new Gson();
    public static GsonUtil getInstance() {
        return ourInstance;
    }

    private GsonUtil() {

    }

    /**
     * 参数转json
     * @param string
     * @return
     */
    public static String paramTojson(String string){
        Map<String,String> stringMap = new HashMap<String, String>();
        String[] strs = string.split("&");
        for (String str : strs) {
            String[] sts = new String[]{"",""};
            String[] st = str.split("=");
            if (st.length==1){
                sts[0] = st[0];
            }else {
                sts[0] = st[0];
                sts[1] = st[1];
            }
            stringMap.put(sts[0],sts[1]);
        }
        return gson.toJson(stringMap);
    }
    /**
     * bean转json
     * @param string
     * @return
     */
    public static String beanTojson(Object string){
        return gson.toJson(string);
    }
    /**
     * bean转参数
     * @param object
     * @return
     */
    public static String beanToParam(Object object){
        return jsonToParam(gson.toJson(object));
    }
    /**
     * json转参数
     * @param string
     * @return
     */
    public static String jsonToParam(String string){
        Map<String,String> map = gson.fromJson(string, Map.class);
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str+=entry.getKey()+"="+entry.getValue()+"&";
        }
        str = str.substring(0,str.length()-1);
        return str;
    }
   /**
     * json转list
     * @param string
     * @return
     */
    public static List<?> jsonToList(String string){
        List<?> list= gson.fromJson(string, new TypeToken<List<?>>() {}.getType());
        return list;
    }
    /**
     * json转bean
     * @param string
     * @return
     */
    public static Object jsonTobean(String string,Class<?> t){
        return gson.fromJson(string,t);
    }
    /**
     * json转bean
     * @param string
     * @return
     */
    public static Object jsonTobean(String string, Type t){
        return gson.fromJson(string,t);
    }
}

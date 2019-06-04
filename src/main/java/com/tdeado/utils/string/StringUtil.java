package com.tdeado.utils.string;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {



    /**
     * 下划线转驼峰
     *
     * @param content
     * @param firstUpperCase
     * @return
     */
    public static String underLineToCamel(String content, boolean firstUpperCase) {
        if (content == null || content.length() == 0) {
            return "";
        }

        if (!isNeedChange(content)) {
            return content;
        }

        String result = Stream.of(content.split("_")).map(m -> {
            String text = m;
            text = text.substring(0, 1).toUpperCase() + text.substring(1);
            return text;
        }).collect(Collectors.joining());
        if (firstUpperCase) {
            return result.substring(0, 1).toLowerCase() + result.substring(1);
        } else {
            return result;
        }
    }
    /**
     * 驼峰转下划线
     * @return
     */
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    /**
     * 首字母大写
     *
     * @param content
     * @return 首字母大写字符串
     */
    public static String capitalized(String content) {
        if (content == null || content.length() == 0) {
            return "";
        }
        return content.substring(0, 1).toUpperCase()+ content.substring(1);
    }

    public static void main(String[] args) {
        System.err.println(capitalized(underLineToCamel("work_order",true)));
    }

    private static boolean isNeedChange(String content) {
        return content.contains("_");
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str 字符串
     * @return 是否是数字
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

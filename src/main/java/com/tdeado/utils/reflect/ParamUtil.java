package com.tdeado.utils.reflect;

import com.tdeado.utils.string.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 通过反射构造筛选参数
 */
public class ParamUtil<T> {
    public T init(Map<String, String> map, T ben){

        Class clazz = ben.getClass();
        try {
            for (Map.Entry<String, String> m : map.entrySet()) {
                System.out.println("key:" + m.getKey() + " value:" + m.getValue());
                if (StringUtils.isNotBlank(m.getValue())) {
                    if (StringUtil.isNumeric(m.getValue())) {
                        try {
                            Method method2 =  clazz.getMethod(m.getKey(),Integer.class);
                            method2.invoke(ben, Integer.parseInt(m.getValue()));
                        }catch (NoSuchMethodException e){
                            Method method2 =  clazz.getMethod("fuzzy"+StringUtil.capitalized(m.getKey()),String[].class);
                            method2.invoke(ben,new Object[]{new String[]{m.getValue()}});
                        }
                    }else {
                        Method method2 =  clazz.getMethod("fuzzy"+StringUtil.capitalized(m.getKey()),String[].class);
                        method2.invoke(ben,new Object[]{new String[]{m.getValue()}});
                    }
                }
            }

            return ben;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;

    }

}
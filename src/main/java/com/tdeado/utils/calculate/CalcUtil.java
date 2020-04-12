package com.tdeado.utils.calculate;

import org.apache.commons.jexl3.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcUtil {

    private static final String INTEGER = "[1-9]\\d*";
    private static final String DECIMAL = "\\d+\\.\\d*?[0-9]+\\d*";
    private static final String GLOBAL_SEARCH = ".*";

    private static String currentExpression;

    private static final CalcUtil calcUtil;

    static {
        calcUtil = new CalcUtil();
    }

    private CalcUtil() {
    }

    /**
     * 获取计算器对象
     *
     * @return
     */
    public static CalcUtil getCalculator() {
        return calcUtil;
    }

    /**
     * 计算表达式
     *
     * @param expression
     * @return
     */
    public static String calcExpression(String expression) {
        Map<String, Object> childStrMap = CalcUtil.getCalculator().parseExpression(expression);

        JexlEngine jexlEngine = new JexlBuilder().create();
        JexlExpression jexlExpression = jexlEngine.createExpression(currentExpression);
        JexlContext content = new MapContext(childStrMap);

        return jexlExpression.evaluate(content).toString();
    }


    /**
     * 解析表达式
     *
     * @param expression
     * @return
     */
    public Map<String, Object> parseExpression(String expression) {
        Map<String, Object> childStrMap = new HashMap<>();

        if (expression != null) {
            currentExpression = expression;
            List<List> strList = new ArrayList<>();
            if (isStrExits(expression, this.DECIMAL)) {
                List<String> childStrings = extractStrings(currentExpression, this.DECIMAL);
                currentExpression = replaceChildString(childStrings, childStrMap, currentExpression);
            }
            if (isStrExits(expression, this.INTEGER)) {
                List<String> childStrings = extractStrings(currentExpression, this.INTEGER);
                currentExpression = replaceChildString(childStrings, childStrMap, currentExpression);
            }
        }
        return childStrMap;
    }

    /**
     * 替换子串
     *
     * @param expression
     */
    private String replaceChildString(List<String> childStringList, Map<String, Object> childStrMap, String expression) {
        if (expression != null) {
            for (int i = 0; i < childStringList.size(); i++) {
                String child = childStringList.get(i);
                if (expression.contains(child)) {
                    String uuid = UUID.randomUUID().toString().replace("-","").replaceAll("[0-9]","");
                    expression = expression.replaceFirst(child, uuid);
                    childStrMap.put(uuid, new BigDecimal(child));
                }
            }
        }
        return expression;
    }


    /**
     * 判断字符串中是否包含正则表达式对应子串
     *
     * @param expression
     * @param pattern
     * @return
     */
    private boolean isStrExits(String expression, String pattern) {
        pattern = this.GLOBAL_SEARCH + pattern + this.GLOBAL_SEARCH;
        return Pattern.matches(pattern, expression);
    }

    /**
     * 抽取所有符合正则表达式的值
     *
     * @param expression
     * @param pattern
     * @return
     */
    private List<String> extractStrings(String expression, String pattern) {
        List<String> matchStrs = new ArrayList<>();

        if (expression != null && pattern != null) {
            Pattern patten = Pattern.compile(pattern);
            Matcher matcher = patten.matcher(expression);

            while (matcher.find()) {
                matchStrs.add(matcher.group());
            }
        }
        return matchStrs;
    }
}
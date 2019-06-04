package com.tdeado.utils.random;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

import static com.tdeado.utils.encrypt.Md5Util.getMD5;

public class RandomUtil {
    //随机数字
    public final static int NUMBER_TYPE = 0;
    //随机字母
    public final static int STRING_TYPE = 1;
    //随机混合字符串
    public final static int HYBRID_TYPE = 2;
    private static String key = "1383722663";

    /**
     * 生成32位字符串
     * @return
     */
    public static String create32RandomString() {
        for (int i = 0; i <= 100; i++) {
            String sources = "0123456789abcdefghijklmnopqrstuvwxyz"; // 加上一些字母，就可以生成pc站的验证码了
            Random rand = new Random();
            StringBuffer flag = new StringBuffer();
            for (int j = 0; j < 6; j++) {
                flag.append(sources.charAt(rand.nextInt(9)) + "");
            }
            key = flag.toString();
        }
        key = getMD5(key + new Date().toString());
        return key;
    }

    /**
     * 随机数生成
     * @param length 长度
     * @param type 数据类型
     * @return
     */
    public static String createRandomString(int length, int type) {
        String sourcesNum = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        String sourcesStr = "abcdefghijklmnopqrstuvwxyz"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < length; j++) {
            switch (type) {
                case HYBRID_TYPE:
                    flag.append((sourcesNum+sourcesStr).charAt(rand.nextInt(36)));
                    break;
                case STRING_TYPE:
                    flag.append(sourcesStr.charAt(rand.nextInt(26)));
                    break;
                case NUMBER_TYPE:
                    flag.append(sourcesNum.charAt(rand.nextInt(9)));
                    break;
            }
        }
        key = flag.toString();
        return key;
    }

}

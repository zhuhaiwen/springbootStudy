package com.founder.utils.StringHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuhw
 * @date 2018/6/19 15:54
 */
public class StringHelper {
    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static void main(String[] args) {
        String a = "?565656";
        System.out.println(isSpecialChar(a));
    }
}

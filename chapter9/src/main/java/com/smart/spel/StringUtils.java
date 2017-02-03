/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

/**
 * @author : linkx(topiter@163.com)
 * @date: 2015/8/1
 */
public class StringUtils {
    public static String reverseString(String input) {
        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < input.length(); i++)
            backwards.append(input.charAt(input.length() - 1 - i));

        return backwards.toString();

    }
}

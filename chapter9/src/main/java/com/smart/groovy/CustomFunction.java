package com.smart.groovy;

import groovy.lang.Script;

import java.lang.reflect.Method;


public class CustomFunction extends Script  {



    @Override
    public Object run() {
        //show usage
        Method[] methods = CustomFunction.class.getDeclaredMethods();
        StringBuilder sb=new StringBuilder();
        for (Method method : methods) {
            sb.append(method);
        }
        return sb.substring(0, sb.length()-1);
    }



    public static Object nvl(Object str, Object val) {
        return str == null || "".equals(str) ? val : str;
    }



}
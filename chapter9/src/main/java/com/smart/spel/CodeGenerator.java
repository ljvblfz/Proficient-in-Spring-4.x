package com.smart.spel;


import java.util.Date;

public class CodeGenerator {

    public static String getDim1(){
        return String.valueOf(new Date().getYear()+1900);
    }

    public static String getDim2(){
        return String.valueOf(new Date().getMonth()+1);
    }

    public static String getDim3(){
        return String.valueOf(new Date().getDay());
    }
}

package com.smart.i18n;

import org.testng.annotations.*;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.testng.Assert.*;

public class MessageFormatTest {

    @Test
    public void format() {
        //①信息格式化串
        String pattern1 = "{0}，你好！你于{1}在工商银行存入{2} 元。";
        String pattern2 = "At {1,time,short} On{1,date,long}，{0} paid {2,number, currency}.";

        //②用于动态替换占位符的参数
        Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};

        //③使用默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);

        //④使用指定的本地化对象格式化信息
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);

    }
}

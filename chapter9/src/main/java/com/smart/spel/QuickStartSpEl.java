/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author : linkx(topiter@163.com)
 * @date: 2015/8/1
 */
public class QuickStartSpEl {

    //The following code introduces the SpEL API to evaluate the literal string expression Hello World
    public static void hello() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    //As an example of method invocation, we call the concat method on the string literal.
    public static void concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    //As an example of calling a JavaBean property, the String property Bytes can be called as shown below.
    public static void bytes() {
        ExpressionParser parser = new SpelExpressionParser();
        // invokes getBytes()
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(new String(bytes));

        exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println("长度：" + length);
    }

    //The String’s constructor can be called instead of using a string literal.
    public static void constructor() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);

    }

    public static void object() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        //1
        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        System.out.println(name);
        //2
        name = (String) exp.getValue(tesla);
        System.out.println(name);


        exp = parser.parseExpression("name == \"Nikola Tesla\"");
        boolean result = exp.getValue(context, Boolean.class); // evaluates to true
        System.out.println(result);
    }

    public static void m2() {
    }

    public static void m3() {
    }

    public static void m4() {
    }

    public static void main(String[] args) {
        hello();
        concat();
        bytes();
        constructor();
        object();
    }


}

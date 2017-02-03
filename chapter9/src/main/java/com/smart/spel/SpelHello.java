package com.smart.spel;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelHello {
    public static void main(String[] args) {
        ExpressionParser parser =new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello'+' World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}

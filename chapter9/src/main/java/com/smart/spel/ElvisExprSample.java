package com.smart.spel;

import com.smart.PlaceOfBirth;
import com.smart.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

public class ElvisExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);

        String userName = parser.parseExpression("UserName?:'用户名为空'").getValue(context, String.class);
        System.out.println(userName); // tom
        user.setUserName(null);
        userName = parser.parseExpression("UserName?:'用户名为空'").getValue(context, String.class);
        System.out.println(userName); // 用户名为空

    }
}

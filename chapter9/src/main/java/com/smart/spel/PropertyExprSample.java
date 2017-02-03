package com.smart.spel;

import com.smart.PlaceOfBirth;
import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        String username = parser.parseExpression("userName").getValue(context,String.class);
        String city = (String)parser.parseExpression("placeOfBirth.city").getValue(context);
        int credits = (Integer) parser.parseExpression("credits + 10").getValue(context);
        System.out.println("username = "+username);
        System.out.println("city = "+city);
        System.out.println("credits = "+credits);



        class Simple{
            public List<Boolean> booleanList= new ArrayList<Boolean>();
        }
        Simple simple= new Simple();
        simple.booleanList.add(true);
//创建请值上下文
        StandardEvaluationContext simpleContext= new StandardEvaluationContext(simple);
//会自动将"false"转换为Boolean型
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false1");
//b将被设置为false
        Boolean b=simple.booleanList.get(0);

    }

}

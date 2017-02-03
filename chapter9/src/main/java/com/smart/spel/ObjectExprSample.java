package com.smart.spel;

import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;
import java.lang.String;


public class ObjectExprSample {
    public static void main(String[] args) {
        User  user = new User("tom");
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        context.setVariable("newUserName","jony");
        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println(user.getUserName()); //jony


        List<Integer> credits= new ArrayList<Integer>();
        credits.addAll(Arrays.asList(150,100,90,50,110,130,70));
        context.setVariable("credits",credits);
        List<Boolean> creditsGreater100=
               (List<Boolean>)parser.parseExpression("#credits.![#this>100]").getValue(context);


        Map<String,Integer> creditsMap = new HashMap();
        creditsMap.put("aTom",95);
        creditsMap.put("bJony",110);
        creditsMap.put("cMorin",85);
        creditsMap.put("dMose",120);
        creditsMap.put("eMorrow",60);
        context.setVariable("credits",creditsMap);
        List creditsGreater100Map=
                (List)parser.parseExpression("#credits.![value>90]").getValue(context);

        Object value = parser.parseExpression("#credits.^[value>90]").getValue(context);
        Object value2 = parser.parseExpression("#credits.$[value>90]").getValue(context);

        parser.parseExpression("userName='anyli'").getValue(context);
        System.out.println(user.getUserName());//anyli


         user = parser.parseExpression("new com.smart.User('tom')").getValue(User.class);
        System.out.println(user.getUserName());//tom


        Class dateClass=parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        Class stringClass=parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        Class userClass=parser.parseExpression("T(com.smart.User)").getValue(Class.class);
        System.out.println(dateClass==java.util.Date.class);
        System.out.println(stringClass==java.lang.String.class);
        System.out.println(userClass == com.smart.User.class);

        Object randomValue = parser.parseExpression("T(java.lang.Math).random()").getValue();
        System.out.println(randomValue);

    }

}

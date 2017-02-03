package com.smart.spel;

import com.smart.PlaceOfBirth;
import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

public class CollectionExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("tom");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("中国","厦门"));
        user.setInterestsArray(new String[]{"Java","C++"});
        Map interestsMap = new HashMap();
        interestsMap.put("interest1","Java");
        interestsMap.put("interest2","C++");
        user.setInterestsMap(interestsMap);
        List<String> interestsList = new ArrayList();
        interestsList.add("Java");
        interestsList.add("C++");
        user.setInterestsList(interestsList);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        int[] array1 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        int[][] array2 = (int[][]) parser.parseExpression("new int[2][3]").getValue(context);

        //int[][] array3= (int[][]) parser.parseExpression("new int[2][3]{{1,2,3},{4,5,6}}").getValue(context);

        List list = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        List listOfLists = (List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context);


        Map userInfo = (Map) parser.parseExpression("{userName:'tom',credits:100 }").getValue(context);
        List userInfo2 = (List) parser.parseExpression("{{userName:'tom',credits:100 },{userName:'tom',credits:100 }}").getValue(context);


        String interest1 = (String)parser.parseExpression("interestsArray[0]").getValue(context);
        String interest2 = (String)parser.parseExpression("interestsList[0]").getValue(context);
        String interest3 = (String)parser.parseExpression("interestsMap['interest1']").getValue(context);
    }

}

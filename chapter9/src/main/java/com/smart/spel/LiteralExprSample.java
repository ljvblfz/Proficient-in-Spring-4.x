/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

import com.smart.PlaceOfBirth;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import java.util.*;

public class LiteralExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //String
        String helloWorld = (String) parser.parseExpression("\"Hello World\"").getValue();
        //double
        double doubleNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        //int
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        //bool
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        //null
        Object nullValue = parser.parseExpression("null").getValue();

        System.out.println("Hello World = "+ helloWorld);
        System.out.println("6.0221415E+23 = "+ doubleNumber);
        System.out.println("0x7FFFFFFF = "+ maxValue);
        System.out.println("true = "+ trueValue);
        System.out.println("null = "+ nullValue);
    }




    public static void type() {
        ExpressionParser parser = new SpelExpressionParser();

        String helloWorld = (String) parser.parseExpression("\"Hello World\".indexOf('World')").getValue();

        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();

        // evals to 2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        Object nullValue = parser.parseExpression("null").getValue();

        System.out.println("Hello World = "+ helloWorld);
        System.out.println("6.0221415E+23 = "+ avogadrosNumber);
        System.out.println("0x7FFFFFFF = "+ maxValue);
        System.out.println("true = "+ trueValue);
        System.out.println("null = "+ nullValue);
    }

    public static  void object(){
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        tesla.setPlaceOfBirth(new PlaceOfBirth("New York"));
        tesla.setInventions(new String[]{"发明1","发明2","发明3","发明4","发明5","发明6"});
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(tesla);
        int year = (Integer) parser.parseExpression("Birthdate.Year + 1900").getValue(context);
        String city = (String) parser.parseExpression("placeOfBirth.City").getValue(context);
        System.out.println("year = "+year);
        System.out.println("city = "+city);


        // evaluates to "Induction motor"
        String invention = parser.parseExpression("inventions[3]").getValue(
                context, String.class);
        System.out.println("invention = "+invention);


        Society society = new Society();
        society.getMembers().add(invention);
        // Members List
        StandardEvaluationContext societyContext = new StandardEvaluationContext(society);
        // evaluates to "Nikola Tesla"
        //String name = parser.parseExpression("members[0].name").getValue(
         //       societyContext, String.class);
        // List and Array navigation
        // evaluates to "Wireless communication"
        // invention = parser.parseExpression("members[0].inventions[6]").getValue(
        //        societyContext, String.class);
        //System.out.println("name = "+name);
       // System.out.println("invention = "+invention);

        // Officer's Dictionary
        //Inventor pupin = parser.parseExpression("Officers[president]").getValue(
       //         societyContext, Inventor.class);
        // evaluates to "Idvor"
       // city = parser.parseExpression("Officers[president].PlaceOfBirth.City").getValue(
        //        societyContext, String.class);
         // setting values
       // parser.parseExpression("Officers[advisors][0].PlaceOfBirth.Country").setValue(
       //         societyContext, "Croatia");

    }

    public static  void collection(){
        // evaluates to a Java list containing the four numbers
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        List listOfLists = (List) parser.parseExpression("{{a,b},{x,y}}").getValue(context);

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
// Array with initializer
        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
// Multi dimensional array
        int[][] numbers3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
    }

    public static void methods(){
        ExpressionParser parser = new SpelExpressionParser();
        // string literal, evaluates to "bc"
        String c = parser.parseExpression("\"hello world\".substring(2, 3)").getValue(String.class);

        System.out.println("substring = "+c);

    }
    private static  void operators(){


    }

}

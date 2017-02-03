/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * @author : linkx(topiter@163.com)
 * @date: 2015/8/1
 */
public class EvaluationContextSample {

    static class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }


    public static void main(String[] args) {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        // false is passed in here as a string. SpEL and the conversion service will
       // correctly recognize that it needs to be a Boolean and convert it
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");
        // b will be false
        Boolean b = simple.booleanList.get(0);

        System.out.println(b);
    }
}

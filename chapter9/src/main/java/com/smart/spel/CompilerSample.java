package com.smart.spel;


import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class CompilerSample {

    public static void main(String[] args) {
        User user = new User();
        SpelParserConfiguration configuration =
                new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, CompilerSample.class.getClassLoader());
        EvaluationContext context = new StandardEvaluationContext(user);
        SpelExpressionParser parser = new SpelExpressionParser(configuration);
        String expression = "isVipMember('tom') && isVipMember('jony')";
        SpelExpression spelExpression = parser.parseRaw(expression);
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}

package com.smart.spel;

import org.springframework.expression.ParserContext;

public class TemplatedParserContext implements ParserContext {

    public String getExpressionPrefix(){
        return "${";
    }
    public String getExpressionSuffix(){

        return "}";
    }
    public boolean isTemplate(){
        return true;
    }
}

package com.smart.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class ExprSupport {
    private static final Object lock = new Object();
    private static final GroovyShell shell;
    private static Hashtable<String, Script> cache = new Hashtable<String, Script>();

    static {
        CompilerConfiguration cfg = new CompilerConfiguration();
        cfg.setScriptBaseClass(CustomFunction.class.getName());
        shell = new GroovyShell(cfg);
    }

    public static Object parseExpr(String expr) {
        Script s = getScriptFromCache(expr);
        return s.run();
    }

    public static Object parseExpr(String expr, Map<?, ?> map) {
        Binding binding = new Binding(map);
        Script script = getScriptFromCache(expr);
        script.setBinding(binding);
        return script.run();
    }

    private static Script getScriptFromCache(String expr) {
        if (cache.contains(expr)) {
            return cache.get(expr);
        }
        synchronized (lock) {
            if (cache.contains(expr)) {
                return cache.get(expr);
            }
            Script script = shell.parse(expr);
            cache.put(expr, script);
            return script;
        }
    }


    public static void main(String[] args) {
        // eg. get one row from db
        Map<String, Object> row = new HashMap<String, Object>();
        row.put("id", 42);
        row.put("name", "");
        //带绑定数据参数的调用方式
        System.out.println(ExprSupport.parseExpr("nvl(id,0)", row));
        System.out.println(ExprSupport.parseExpr("nvl(name,'anonymous')", row));
        //不带绑定数据参数的调用方式，这个是groovy的内置能力
        System.out.println(ExprSupport.parseExpr("1+2"));
    }



}
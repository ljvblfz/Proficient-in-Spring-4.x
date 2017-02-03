package com.smart.groovy;


public class LogDao {
    private String dataProvider;
    public void saveLog(){}

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void init(){
        System.out.println("initMethod....");
    }
    public void destory(){
        System.out.println("destoryMethod....");
    }
}

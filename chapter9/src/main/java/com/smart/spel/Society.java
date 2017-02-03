/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2015 
 */
package com.smart.spel;

import java.util.*;

/**
 * @author : linkx(topiter@163.com)
 * @date: 2015/8/1
 */
public class Society {
    private String name;
    public static String Advisors = "advisors";
    public static String President = "president";
    private List<Inventor> members = new ArrayList<Inventor>();
    private Map officers = new HashMap();

    public List getMembers() {
        return members;
    }
    public Map getOfficers() {
        return officers;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isMember(String name) {
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

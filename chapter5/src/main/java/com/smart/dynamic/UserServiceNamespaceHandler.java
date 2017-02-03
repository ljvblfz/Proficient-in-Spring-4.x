/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2014 
 */
package com.smart.dynamic;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class UserServiceNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user-service", new UserServiceDefinitionParser());
    }
}

package com.smart.dynamic;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactoryBean  implements BeanFactoryPostProcessor   {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {

        //①将ConfigurableListableBeanFactory转化为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;

        //②通过BeanDefinitionBuilder创建Bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);

        //③设置属性userDao,此属性引用已经定义的bean:userDao
        beanDefinitionBuilder.addPropertyReference("userDao","userDao");

        //④注册Bean定义
        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getRawBeanDefinition());

        //⑤直接注册一个Bean实例
        beanFactory.registerSingleton("userService2",new UserService());
    }

}

package com.smart.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
/**
 * 说明：需要测试某个切点函数时，取消相应的注解就可以了。
 * @author 陈雄华
 *
 */
@Aspect
public class TestAspect implements Ordered{
//    @Before("execution(public * *(..))")
//	public void allPublicFun(){
//	    System.out.println("allPublicFun() executed!");	
//	}
//    @AfterReturning("execution(* *To(..))")
//    public void allToFun(){
//    	System.out.println("allToFun() executed!");
//    }
//    @Before("execution(* com.smart.aspectj.fun.Waiter.*(..))")
//    public void allWaiterFun(){
//    	System.out.println("allWaiterFun() executed!");
//    }
//    @Before("execution(* com.smart.aspectj.fun.Waiter+.*(..))")
//    public void allChildClassFun(){
//    	System.out.println("allChildClassFun() executed!");
//    }
//	@Before("execution(* joke(Object,int)))")
	@Before("args(Object,*)")
    public void jokeFun(){
    	System.out.println("jokeFun() executed!");
    }
//    @AfterReturning("@annotation(com.smart.anno.NeedTest)")
//    public void atAnnotaionTest(){
//    	System.out.println("atAnnotaionTest() executed!");
//    }
//    @AfterReturning("args(String)")
//    public void argsTest(){
//    	System.out.println("argsTest() executed!");
//    }   
//    @AfterReturning("@args(Monitorable)")
//    public void atArgsTest(){
//    	System.out.println("atArgsTest() executed!");
//    }
//    @Before("within(com.smart.aspectj.fun.Waiter)")
//    public void withinTest(){
//    	System.out.println("withinTest() executed!");
//    }
//    @Before("@within(com.smart.aspectj.fun.Monitorable)")
//	public void atWithinTest() {
//		System.out.println("atWithinTest() executed!");
//	} 
	@AfterReturning("this(com.smart.Seller)")
	public void thisTest(){
		System.out.println("thisTest() executed!");
	}
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
}

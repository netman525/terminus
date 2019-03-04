package io.terminus.aop.jdkproxy;

import io.terminus.aop.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class JdkProxy implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("before jdk dynamic jdkproxy");
        Object object;
        try {
            object = method.invoke(this.realSubject, args);
        }catch (Exception e){
            System.out.println("e:" + e);
            throw e;
        }finally {
            System.out.println("after jdk dynamic jdkproxy");
        }
        return object;
    }
}

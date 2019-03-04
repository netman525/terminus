package io.terminus.aop.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy
    ) throws Throwable{
        System.out.println("before cglib dynamic proxy");
        Object object;
        try {
            object = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println("ex:" + e);
            throw e;
        } finally {
            System.out.println("after cglib dynamic proxy");
        }
        return object;
    }
}

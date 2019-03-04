package io.terminus.aop;

import io.terminus.aop.impl.RealSubject;
import io.terminus.aop.jdkproxy.JdkProxy;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class JdkProxyClient {

    public static void main(String[] args){
        //输出 jdk代理 动态生成的.class 字节码到 com.sun.proxy中
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //创建动态类的实例
        Subject proxySubject = (Subject) Proxy.newProxyInstance(JdkProxyClient.class.getClassLoader(),
                                                                new Class[]{Subject.class},
                                                                new JdkProxy(new RealSubject()));

        proxySubject.dosomething();
        System.out.println("------------------------");
        proxySubject.hello("stone");
    }
}

package io.terminus.aop;

import io.terminus.aop.cglibproxy.CglibProxy;
import io.terminus.aop.impl.RealSubject;
import net.sf.cglib.proxy.Enhancer;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class CglibProxyClient {

    public static void main(String[] args){
        // 创建一个类生成器 ClassGenerator
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());

        // 创建动态代理类的实例
        RealSubject proxySubject = (RealSubject) enhancer.create();
        proxySubject.dosomething();
        System.out.println("------------------------");
        proxySubject.hello("stone");
    }
}

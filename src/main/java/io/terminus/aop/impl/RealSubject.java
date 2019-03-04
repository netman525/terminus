package io.terminus.aop.impl;

import io.terminus.aop.Subject;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class RealSubject implements Subject {
    @Override
    public void dosomething(){
        System.out.println("real subject execute something");
    }

    @Override
    public void hello(String name){
        System.out.println("hello : " + name);
    }
}

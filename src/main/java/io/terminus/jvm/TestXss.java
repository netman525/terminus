package io.terminus.jvm;

/**
 * Description:
 *
 * @author <a href="mailto:maoling.ml@alibaba-inc.com">maoling.ml</a>
 * @date Create on 2019/3/4
 * @since version1.0 Copyright 2019 terminus.io All Rights Reserved.
 */
public class TestXss {
    private static long count = 0;

    public static void main(String[] args){
        infinitelyRecursiveMethod(1);

    }

    public static void infinitelyRecursiveMethod(long a){
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }
}

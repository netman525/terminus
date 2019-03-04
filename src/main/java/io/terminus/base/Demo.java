package io.terminus.base;

class SubClass extends SuperClass {
    public String name = "SubClass";
}

class SuperClass {
    public String name = "SuperClass";
}

/**
 * @author
 */
public class Demo {

    public static void main(String[] args){
        SuperClass clz = new SubClass();
        //你觉得这里输出什么?
        System.out.println(clz.name);

        SuperClass clz2 = new SuperClass();
        //你觉得这里输出什么?
        System.out.println(clz2.name);


        int a = 7;
        int b = 3;
        int c = 0;
        while((a--) > (++b)){
            c++;
        }
        System.out.println(c);
    }
}
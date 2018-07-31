package com.founder;

/**
 * @author zhuhw
 * @date 2018/7/23 11:04
 */
public class TestThreadLocal {

    private static ThreadLocal<Long> longLocal = new ThreadLocal<>();
    private static ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longLocal.get();
    }

    public String getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal test = new TestThreadLocal();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong() + "***");
                System.out.println(test.getString() + "***");
                final TestThreadLocal test1 = new TestThreadLocal();
                test1.set();
                System.out.println(test1.getLong() + "////");
                System.out.println(test1.getString() + "////");
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}

package com.founder;

/**
 * @author zhuhw
 * @date 2018/6/7 15:40
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            StringBuilder builder = new StringBuilder("abc");
            System.out.println(builder.append("4546").toString());
            Integer a= 10/0;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("你好");
        }
        finally {
            System.out.println("489");

        }
        System.out.println("hello world");
    }

}

package ua.test;

/**
 * Created by Mykhailo_Hodovaniuk on 2/13/14.
 */
public class Test {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    private String w1;
    private String w2;

    public String getW3() {
        return w3;
    }

    public void setW3(String w3) {
        this.w3 = w3;
    }

    private String w3;


    public Test(int a){
        this.a=a;
    }

//    public Test(String w1){
//        this.w1=w1;
//    }

    public void say(){
        System.out.println(a+w1+w2+w3+b);
    }
    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public String getW2() {
        return w2;
    }

    public void setW2(String w2) {
        this.w2 = w2;
    }
}

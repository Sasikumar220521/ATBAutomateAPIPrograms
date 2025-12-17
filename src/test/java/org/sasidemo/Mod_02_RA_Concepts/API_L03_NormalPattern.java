package org.sasidemo.Mod_02_RA_Concepts;

public class API_L03_NormalPattern {
    public void step1(){
        System.out.println("Step1 done");
    }
    public void step2(){
        System.out.println("Step2 done");
    }
    public void step3(String param1){
        System.out.println("Step3 done " + param1);
    }

    public static void main(String[] args) {
        API_L03_NormalPattern l3 = new API_L03_NormalPattern();
        l3.step1();
        l3.step2();
        l3.step3("S3");
    }
}

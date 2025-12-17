package org.sasidemo.Mod_02_RA_Concepts;

public class API_L04_BuilderPattern {

    public API_L04_BuilderPattern step1(){
        System.out.println("Step1 done");
        return this;
    }
    public API_L04_BuilderPattern step2(){
        System.out.println("Step2 done");
        return this;
    }
    public API_L04_BuilderPattern step3(String param1){
        System.out.println("Step3 done " + param1);
        return this;
    }

    public static void main(String[] args) {
        API_L04_BuilderPattern l3 = new API_L04_BuilderPattern();
        l3.step1().step2().step3("S3");
    }
}

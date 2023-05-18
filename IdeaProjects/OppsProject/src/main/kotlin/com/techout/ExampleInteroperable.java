package com.techout;
import com.techouts.ExampleInter;
import com.techouts.MyKotlinFile;

public class ExampleInteroperable {
    private String name;
    private String mailId;
    private Long MobileNo;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return "name";
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        MobileNo = mobileNo;
    }
    public String toString(){
        return "name :"+getName()+" mailId : " +getMailId() +" mobileNo : "+getMobileNo()+" ";
    }
    public static void main(String[] agrs){
        ExampleInteroperable e1=new ExampleInteroperable();
        e1.setName("Shravani");
        e1.setMailId("Sravani@gmail.com");
        e1.setMobileNo(9087654321l);
        System.out.println(e1);
        ExampleInter obj=new ExampleInter();
        //calling kotlin code in java
        obj.swap();
        System.out.println();
        //calling kotlin code in java with same java class name
        int area=MyKotlinFile.area(20,30);
        System.out.println();
        int volume=MyKotlinFile.volume(12,40);



    }
    public int sumOfArray(int[]array){
        int result=0;
        for(int i:array)
            result+=i;
        return result;

        }
        public void varagrsexample(String message,int...values) {
        System.out.println("message from varargsExample "+message);
        int result=0;
        for(int i:values)
        System.out.print(" "+i+" ");
        for(int i:values)
            result+=i;
        System.out.println();
        System.out.println("sum of varargs values is "+result);

        }


}

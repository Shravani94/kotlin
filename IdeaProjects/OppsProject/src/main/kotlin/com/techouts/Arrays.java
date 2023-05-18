package com.techouts;

public class Arrays {
    public static void mani(String[]args) {
        int[] arr1= {1,2,2,3,4,4,5};
        String arr2="";
        for(int i=0;i<arr1.length-1;i++) {
            for(int j=0;j<arr1.length-1;j++) {
                if(arr1[i]==arr1[j+1]){
                    arr2=arr2+(arr1[i]+arr1[j+1]);
                }
            }

        }
        char[] arr3=arr2.toCharArray();
        System.out.println(arr3);


    }

}

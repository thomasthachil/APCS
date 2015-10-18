package com.company;

public class Main {

    public static void main(String[] args) {
	int[] nums = new int[]{1,2,3,4,5,6,7,8};
        mixUp(nums);
    }

    public static void mixUp(int[] a)
    {
        // Move every other integer in the array to the back
        for (int i=0; i < a.length; i++)
        {
            for (int j=i; j < a.length-1; j++) {
                int tempNum = a[j];
                a[j] = a[j+1];
                a[j+1] = tempNum;
                if(a[j] == a[a.length-1])
                    break;
            }
        }
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }

    }
}

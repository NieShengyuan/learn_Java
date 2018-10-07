/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 求符合连续正整数的立方和等于某一个正整数的立方问题的解
 * 思路：
 * 1、先建立一个存储右值立方的数组，下标为所求正整数
 * 2、起始数据从0开始，100截止
 * 3、长度从1开始，500截止
 * 
 * 结果：
 起始数据--结束数据--右值
0--1--1
3--5--6
3--22--40
6--30--60
6--69--180
11--14--20
11--109--330
15--34--70
耗时：3764ms
 */
package com.sethnie.thread;
import java.util.ArrayList;
import java.util.List;

public class GetNums { 
    public static void main(String[] args) {
        double[] arr = new double[500];
        List<Object> list = new ArrayList<Object>(); 
        int searchWord=0;
        double left_Num = 0;
        long d1 = System.currentTimeMillis();
        
       //建立数据索引库，直接二分法匹配
        for(int i=0;i<500;i++){
            arr[i] = Math.pow(i, 3);
        }
        //循环更换起始数据值的大小和链的长度
        for(int start=0;start<100;start++) {
            for(int len=2;len<500;len++) {
                left_Num = data(start,len);
                searchWord = binarySearch(arr,left_Num);
                if(searchWord!=-1 && left_Num==arr[searchWord]) {//找到数据
                    System.out.println("-------->"+start+"-"+(start+len-1)+"-"+searchWord);
                    list.add(start+"--"+(start+len-1)+"--"+searchWord);//起始位置+位数+匹配结果
                }
                System.out.println(start+"-"+(start+len));
            }
        }
        long d2 = System.currentTimeMillis();
     
        System.out.println("------------finsh-------------------");
        System.out.println("起始数据-"+"-结束数据-"+"-右值");
        for(int k=0;k<list.size();k++) {
            System.out.println(list.get(k));
        }
        System.out.println("耗时："+(d2-d1)+"ms");
    }
        
    public static double data(int start,int num) {
        /*int start  起始数据
         *int num    数据长度
         * */
        double x =0;
        for(int i=num;i>0;i--) {
            x  = x + (long)(Math.pow(start+i-1, 3));
        }
        return x;
    }
    
    public static int binarySearch(double[] array, double value){
        /*二分法查找
         * */
        double low = 0;
        double high = array.length - 1;
        while(low <= high){
            double middle = (low + high) / 2;
            if(value == array[(int)middle]){
                return (int)middle;         //返回查询到的索引位置
            }
            if(value > array[(int)middle]){
                low = (int)middle + 1;
            }
            if(value < array[(int)middle]){
                high = (int)middle - 1;
            }
        }
        return -1;     //上面循环完毕，说明未找到，返回-1
    }
}

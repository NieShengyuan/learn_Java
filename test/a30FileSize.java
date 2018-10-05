/**
 * @version: 
 * @Description: 获取指定目录下文件的大小
 * @auther: SethNie
 * @date: 
 */
package TestIO;

import java.io.File;

public class a30FileSize {
    public static void main(String[] args) {
        File src = new File("E:\\JavaProject\\test\\TestIo");
        count(src);
        System.out.println(len);
        
    }
    
    private static long len = 0;
    public static void count(File src) {
        //获取大小
        if(null!=src && src.exists()) {
            if(src.isFile()) {
                len+=src.length();
            }else {
                for (File s:src.listFiles()) {
                    count(s);
                }
            }
        }
    }
    
    
}

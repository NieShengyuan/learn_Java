package TestIO;
/*
 * //打印子孙级目录和文件的名称
 * */
import java.io.File;

public class a29IO {
    
    public static void main(String[] args) {
        File src = new File("E:\\JavaProject\\test\\TestIo");
        printName(src, 0);
    }
    
    //打印子孙级目录和文件的名称
    public static void printName(File src,int deep) {
        for(int i=0;i<deep;i++) {
            System.out.print("  ");
        }
        //打印名称
        System.out.println(src.getName());
        if(null ==src || !src.exists()) {//递归头
            return;
        }else if(src.isDirectory()){
            for(File s:src.listFiles()) {
                printName(s, deep+1);
            }
            
        }
        
        
    }
}

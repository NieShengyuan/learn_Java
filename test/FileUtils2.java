/**
 * @version: v1.0
 * @Description: 
 * @author: SethNie
 * @date: 下午6:11:00
 */
package TestIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author Administrator
 *
 */
public class FileUtils2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("t.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.png");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    public static void copy(InputStream is,OutputStream os) {
       
        try {
           
            byte[] flush = new byte[1024];//缓冲容器
            int len = -1;//接收长度
            
            while((len=is.read(flush))!=-1) {
                os.write(flush, 0, len);
            }

            os.flush();
               
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
         // 4、释放资源
            close(is, os);
        }

    }
    public static void close(Cloneable...ios) {
        for(Cloneable io:ios) {
            try {
                if(null!=io) {
                    ((ByteArrayInputStream) io).close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
    public static void close(InputStream is,OutputStream os) {
        try {
            if(null!=os) {
                os.close();
                System.out.println("finsh");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            if(null!=is) {
                is.close();
                System.out.println("finsh2");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

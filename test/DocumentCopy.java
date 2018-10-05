/**
 * @version: v1.0
 * @Description: 分段读取
 * @author: SethNie
 * @date: 下午2:52:40
 *CopyFile
 * 
 */
package TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class DocumentCopy {

    public static void main(String[] args) {
        // 1、创建源
        File src = new File("abc.txt");//源文件
        File dest = new File("dest31.txt");
        // 2、选择流
        Reader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(src);
             writer = new FileWriter(dest,false);
            // 3、操作()
            char[] flush = new char[10];//缓冲容器
            int len = -1;//接收长度
            
            while((len=reader.read(flush))!=-1) {
                writer.write(flush);
            }

            writer.flush();
               
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
         // 4、释放资源
            try {
                if(null!=writer) {
                    writer.close();
                    System.out.println("finsh");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try {
                if(null!=reader) {
                    reader.close();
                    System.out.println("finsh2");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

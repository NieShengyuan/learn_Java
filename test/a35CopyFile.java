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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class a35CopyFile {

    public static void main(String[] args) {
        // 1、创建源
        File src = new File("t.png");//源文件
        File dest = new File("tesla1.png");
        // 2、选择流
        try (InputStream is = new FileInputStream(src);
                OutputStream os = new FileOutputStream(dest,false)){
           
            // 3、操作()
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
        }

    }

}

/**
 * @version: v1.0
 * @Description: 分段读取
 * @author: SethNie
 * @date: 下午2:52:40
 * 标准步骤
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
package TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class a33TestIO2 {
    
    public static void main(String[] args) throws IOException {
        // 1、创建源
        File src = new File("abc.txt");
        
        // 2、选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
         // 3、操作（分段读取）
            byte[] flush = new byte[1024*10];//缓冲容器
            int len = -1;//接收长度
            while((len=is.read(flush))!=-1) {
                //字节数组-->字符串（解码）
                String str = new String(flush,0,len);
                System.out.println(str+"--"+len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
         // 4、释放资源先打开的后关闭
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

}

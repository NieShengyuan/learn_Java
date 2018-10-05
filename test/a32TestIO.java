/**
 * @version: v1.0
 * @Description: 
 * @author: SethNie
 * @date: 下午2:52:40
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

public class a32TestIO {
    
    public static void main(String[] args) throws IOException {
        // 1、创建源
        File src = new File("abc.txt");
        // 2、选择流
        try {
            InputStream is = new FileInputStream(src);
         // 3、操作
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data4);
            System.out.println((char)data3);
            
         // 4、释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // 4、释放资源
    }

}

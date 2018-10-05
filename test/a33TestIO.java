/**
 * @version: v1.0
 * @Description: 
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


public class a33TestIO {
    
    public static void main(String[] args) throws IOException {
        // 1、创建源
        File src = new File("abc.txt");
        
        // 2、选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
         // 3、操作
            int temp;
            while((temp=is.read())!=-1) {
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
         // 4、释放资源
            if(null!=is) {
                is.close();
            }
            
        }
    }

}

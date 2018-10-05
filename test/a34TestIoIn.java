/**
 * @version: v1.0
 * @Description: 分段读取
 * @author: SethNie
 * @date: 下午2:52:40
 * 标准步骤--
 * 1、创建源
 * 2、选择流
 * 3、操作()
 * 4、释放资源
 */
package TestIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a34TestIoIn {

    public static void main(String[] args) {
        // 1、创建源
        File dest = new File("dest.txt");
        // 2、选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,true);
            //os = new FileOutputStream(dest,false);//内容覆盖
            // 3、操作()
            String msg="IO is so easy\r\n";
            byte[] datas = msg.getBytes();//字符串-->字节数组（编码）
            os.write(datas, 0, datas.length);
            os.flush();
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
         // 4、释放资源
            if(null!=os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

/**
 * @version: v1.0
 * @Description: 使用面向对象：统计文件夹的大小
 * @author: SethNie
 * @date: 上午11:06:11
 */
package TestIO;
import java.io.File;

public class a31FileSizeOop {
  //大小
    private long len;
    //文件夹路径
    private String path;
    //文件个数 
    private int fileNum;
    private int docNum=-1;
    //源
    private File src;

    public a31FileSizeOop(String path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }
    public long getLen() {
        return len;
    }
    public int getFileNum() {
        return fileNum;
    }
    public int getDocNum() {
        return docNum;
    }
    //统计大小
    private void count(File src) {
        // 获取大小
        if (null != src && src.exists()) {
            if (src.isFile()) {
                len += src.length();
                this.fileNum++;
            } else {
                this.docNum++;
                for (File s : src.listFiles()) {
                    count(s);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        a31FileSizeOop dir = new a31FileSizeOop("E:/JavaProject/test/TestIo");
        System.out.println(dir.getLen()+"--"+dir.fileNum+"--"+dir.docNum);
        a31FileSizeOop dir2 = new a31FileSizeOop("E:/JavaProject");
        System.out.println(dir2.getLen()+"--"+dir2.fileNum+"--"+dir2.docNum);
    }
}

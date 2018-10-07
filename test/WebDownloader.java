/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description:下载
 */
package com.sethnie.thread;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class WebDownloader {
    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException e) {
            System.out.println("ingel url");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

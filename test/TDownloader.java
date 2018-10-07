/**
 * @version: v1.0
 * @author: SethNie
 * @date: 2018年10月7日
 * @Description: 
 */
package com.sethnie.thread;

/**
 * @author Administrator
 *
 */
public class TDownloader extends Thread{
    private String url;//远程路径
    private String name;//存储名称
    
    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
    }
    
    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=229863920,848518507&fm=11&gp=0.jpg","t1.jpg");
        TDownloader td2 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538887566093&di=755cece3c1c0f4e8bd082ab4d21fa887&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz%2FD2TA5b3y9a3yW191EhGzCFZ0SkGGaGIes8dVy6vNZWZic97pCcOKMicOlEK59SebjmaoM2riaA34WUblnCZ86YTwA%2F0","t2.jpg");
        TDownloader td3 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538887566089&di=535f3ed6e416835b93e95c73f1987152&imgtype=0&src=http%3A%2F%2Fgeekcar.com%2Fwp-content%2Fuploads%2F2015%2F08%2F2015-tesla-model-x-photos-and-info-news-car-and-driver-photo-441390-s-original.jpg","t3.jpg");

        //启动三个线程,手动启动顺序与运行顺序无关
        td1.start();
        td2.start();
        td3.start();
        
    }
   
}

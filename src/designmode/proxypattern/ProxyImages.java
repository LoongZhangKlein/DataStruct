package designmode.proxypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-16-17:36
 */
public class ProxyImages implements Images{
    private RealImages realImages;
    private String imagesName;
    public ProxyImages(String imagesName){
        this.imagesName=imagesName;
        System.out.println("验证执行顺序"+imagesName);
    }
    @Override
    public void display() {
        if (realImages==null){
            realImages=new RealImages(imagesName);
        }
        realImages.display();
    }
}

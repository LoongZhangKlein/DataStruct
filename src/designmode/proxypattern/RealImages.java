package designmode.proxypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-16-17:33
 */
public class RealImages implements Images{
    private String fileName;
    public RealImages(String images){
        this.fileName =images;
        loadFormDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("这里是真实的图片类"+ fileName);
    }
    private void loadFormDisk(String fileName){
        System.out.println("加载默桌面"+ fileName);
    }
}

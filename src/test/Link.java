package test;

public class Link {
    public Object data;
    public Link next;
    public Link previous;
    public Link(Object data) {
        super();
        this.data = data;
    }
    //打印结点的数据域
    public void displayLink() {
        System.out.print("{"+ data + "} ");
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

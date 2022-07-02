package collection.MyLinkList;

public class SingleLink {
    public Object data;
    public SingleLink next;
    private SingleLink head;


    public SingleLink(Object data) {
        this.data = data;
          head=new SingleLink(null);
    }
    public SingleLink() {
        this.data = data;
          head=new SingleLink(null);
    }
    public void add(Object object){
    SingleLink temp=head;
        while (true) {
            if (temp.next==null){
                break;
            }
            temp=temp.next;

        }
        SingleLink objLink = new SingleLink();
        objLink.data=object;
        temp.next=objLink;

    }



    @Override
    public String toString() {
        return "[" + data +
                ']';
    }
}

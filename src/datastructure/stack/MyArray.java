package datastructure.stack;

public class MyArray {
    private int size;
    private Object[] obj;
    public MyArray(){
        obj=new Object[3];
        this.size=obj.length;
    }
    public int getSize(){
        return size;
    }
    public Object[] getObjArray(){
        return obj;
    }
}

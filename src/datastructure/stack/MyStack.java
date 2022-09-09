package datastructure.stack;


import com.sun.org.apache.xpath.internal.objects.XObject;

public class MyStack {
    private static final double times = 1.5;
    private Object[] objArray;
    private int size;

    public MyStack() {
        objArray = new Object[10];
    }

    /**
     * 动态扩容
     *
     * @param objArray
     * @return
     */
    private void addCapacity(Object[] objArray) {
        Object[] newArrays = new Object[(int) (objArray.length * times)];
        /**
         *
         */
        System.arraycopy(objArray, 0, newArrays, 0, objArray.length);
        objArray = newArrays;
    }

    public void add(Object obj) {
        if (size == objArray.length) {
            addCapacity(objArray);
        }
        objArray[size++] = obj;
    }

    public void add(int index, Object obj) {
        //越界判断
        if (index < 0 || index > size) {
            throw new RuntimeException("下标异常");
        }
        // 找到待插入的位置
        if (size + 1 > objArray.length) {
            addCapacity(objArray);
        }
        for (int i = size; i >= index; i--) {
            objArray[i + 1] = objArray[i];
        }
        objArray[index] = obj;
        size++;
    }


    public Object pop() {
        Object temp=objArray[size-1];
        objArray[size-1]=null;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public Object peek(){
        return objArray[size-1];
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(objArray[i] + "---");
        }
        System.out.println();
    }
}

package arithmetic.search.hashsearch;

public class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;
    // todo 感觉这地方不大对  初始化数组长度了都
    /**
     * 其实是取模的时候取余数组的长度
     */
    public HashTable(int size) {
        this.size=size;
        empLinkedLists = new EmpLinkedList[size];
    }

    /**
     * 实现哈希数组的条件
     *
     * @param emp
     */
    public void add(Emp emp) {
        int numb = hashFunction(Integer.parseInt(emp.id));
        // 将对应的链
        empLinkedLists[numb].add(emp);
    }
    public int hashFunction(int id) {
        return id%size;
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list();
        } 
    }



}

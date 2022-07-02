package arithmetic.search.hashsearch;

public class Test {
    public static void main(String[] args) {
        Emp emp = new Emp("1","张三");
        Emp emp1 = new Emp("2","张三");
        Emp emp2= new Emp("3","张三");
        EmpLinkedList empLinkedList = new EmpLinkedList();
        empLinkedList.add(emp);
        empLinkedList.add(emp1);
        empLinkedList.add(emp2);

    }
}

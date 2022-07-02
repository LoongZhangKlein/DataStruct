package arithmetic.search.hashsearch;

public class EmpLinkedList {
    private Emp head=null;
    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp pointer=head;
        while (true){
            if (pointer.next==null){
                break;
            }
            pointer=pointer.next;

        }
        pointer.next=emp;
    }


    public void list(){
        if (head==null){
            System.out.println("list is null");
        }
        Emp pointer=head;
        while (true){
            System.out.println(pointer);
            if (pointer.next==null){
                break;
            }
            pointer=pointer.next;
        }
    }
}

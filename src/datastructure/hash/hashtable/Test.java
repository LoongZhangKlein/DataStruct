package datastructure.hash.hashtable;



import java.util.Hashtable;


public class Test {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(8);
        for (int i = 0; i < 10; i++) {
            hashTable.add(i);
        }
        hashTable.display();
        hashTable.remove(4);
        System.out.println("==========");
        hashTable.display();
        hashTable.update(9,19);
        hashTable.display();
    }
}

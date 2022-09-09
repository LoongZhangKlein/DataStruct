package datastructure.LinkedList.circlelinked.mycirclelinked;

public class Test {
    public static void main(String[] args) {
        MyCircleLinked myCircleLinked = new MyCircleLinked();
        for (int i = 1; i < 6; i++) {
            myCircleLinked.add(i);
        }
        for (int i = 1; i < 6; i++) {
            myCircleLinked.pop(1,2);
        }

        //myCircleLinked.display();
    }
}

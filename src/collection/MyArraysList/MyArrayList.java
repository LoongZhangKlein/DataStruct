package collection.MyArraysList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author DragonZhang
 */
public class MyArrayList {
    Object[] objects;
    private int count = 0;

    public MyArrayList() {
        objects = new Object[0];
    }

    public void addCapacity() {
        if (count == 0) {
            objects = new Object[10];
        } else {
            int capacity = objects.length / 2 + objects.length;
            Object[] newObject = new Object[capacity];
            for (int i = 0; i < objects.length; i++) {
                newObject[i] = objects[i];
            }
            objects = newObject;
        }
    }

    public boolean flag() {
        if (count == objects.length - 1||count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object get(int index) {
        return objects[index];
    }

    public int size() {
        return count;
    }

    public void add(Object object) {
        if (flag()) {
            addCapacity();
        }
        objects[count] = object;
        count++;
    }

    public void add(int index, Object object) {
        count++;
        if (flag()) {
            addCapacity();
        }
        int newIndex = index;
        int nowCount = count - index - 1;
        Object[] o = new Object[nowCount];
        for (int i = 0; i < o.length; i++) {
            o[i] = objects[newIndex];
            newIndex++;
        }
        objects[index] = object;
        System.arraycopy(o, 0,  objects,index+1, o.length);

    }

    public boolean addAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            objects[count] = iterator.next();
            count++;
        }
        return true;
    }

    public boolean addAll(int index, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            objects[count] = iterator.next();
            count++;
        }
        return true;
    }

    public boolean remove(Object object) {
        count++;
        for (int i = 0; i < count; i++) {
            // 记录下标
            int flag = i;
            if (object.equals(objects[i])) {
                for (int j = i; j < objects.length; j++) {
                    if (j + 1 < objects.length) {
                        objects[j] = objects[j + 1];
                    }

                }

            }
        }
        return true;
    }

    @Override
    public String toString() {
        Object[] objectsToStr = new Object[count];
        for (int j = 0; j < size(); j++) {
            objectsToStr[j] = objects[j];

        }
        return Arrays.toString(objectsToStr);
    }




}

package designmodel.observerpattern;

import java.util.ArrayList;
import java.util.List;

class Subject {
    /**
     * 此集合用来存放观察者
     */
    private List<MyObserver> observerList = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // is core
        notifyAllObservers();
    }

    // 添加观察者
    public void attach(MyObserver myObserver) {
        observerList.add(myObserver);
    }

    // 更新所有观察者
    public void notifyAllObservers() {
        observerList.stream().forEach(observer -> {
            observer.update();
        });
    }
}
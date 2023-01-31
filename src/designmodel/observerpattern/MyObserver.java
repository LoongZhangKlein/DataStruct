package designmodel.observerpattern;

abstract class MyObserver{
       protected Subject subject;
       public abstract void update();
    }
package top.chenjipdc.design.patterns;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/27 4:37 下午
 */
public class DP14_Observer {
}


enum Event {
    MOUSE("鼠标事件"),
    KEYBOARD("键盘事件"),
    OTHER("其他事件");
    private String name;

    Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Observer {
    void listen(Event event);
}

class SimpleEventObserver implements Observer {

    @Override
    public void listen(Event event) {
        System.out.println("SimpleObserver收到：" + event.getName());
    }
}

class MyEventObserver implements Observer {

    @Override
    public void listen(Event event) {
        System.out.println("MyObserver收到：" + event.getName() + " 搞点事情");
    }
}

abstract class AbstractEventCenter {

    protected final Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    abstract void publish(Event event);

}

class SimpleEventCenter extends AbstractEventCenter {

    @Override
    void publish(Event event) {
        for (Observer observer : observers) {
            observer.listen(event);
        }
    }
}
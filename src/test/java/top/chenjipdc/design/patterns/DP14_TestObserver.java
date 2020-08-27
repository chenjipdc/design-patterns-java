package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/27 4:37 下午
 */
public class DP14_TestObserver {

    @Test
    public void testObserver(){
        SimpleEventCenter eventCenter = new SimpleEventCenter();
        eventCenter.addObserver(new SimpleEventObserver());
        eventCenter.addObserver(new MyEventObserver());

        eventCenter.publish(Event.KEYBOARD);
        System.out.println("===============");
        eventCenter.publish(Event.MOUSE);
        System.out.println("===============");
        eventCenter.publish(Event.OTHER);
    }
}

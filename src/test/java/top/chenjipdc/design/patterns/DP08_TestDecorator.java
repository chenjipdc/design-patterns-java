package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/19 9:37 上午
 */
public class DP08_TestDecorator {

    @Test
    public void testDecorator(){
        Lamp lamp = new Led();
        lamp = new LampColorDecorator(lamp);
        lamp = new LampLightnessDecorator(lamp);

        lamp.on();
    }
}

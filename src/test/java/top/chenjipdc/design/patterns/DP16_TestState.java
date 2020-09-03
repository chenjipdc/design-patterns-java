package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/9/3 1:28 下午
 */
public class DP16_TestState {

    @Test
    public void testState(){
        HttpContext context = new HttpContext();
        context.setState(new ConnectState());
        context.connect();
        context.response();
        context.closed();

        System.out.println("-----------");

        HttpContext context1 = new HttpContext();
        context1.setState(new ConnectState());
        context1.connect();
        context1.timeout();
        context1.connect();
        context1.closed();
    }
}

package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/26 10:01 上午
 */
public class DP13_TestCommand {

    @Test
    public void testCommand(){
        Receiver receiver = new Receiver();
        DoitCommand doitCommand = new DoitCommand(receiver);
        ClosedCommand closedCommand = new ClosedCommand(receiver);

        new Sender(doitCommand).call();
        System.out.println("======================");
        new Sender(closedCommand).call();
    }
}

package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/26 10:01 上午
 *
 * 适用情况：
 * 1、系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 2、系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 3、系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
 * 4、系统需要将一组操作组合在一起，即支持宏命令。
 */
public class DP13_Command {
}

interface ICommand {
    void doit();
}

class Receiver {
    public void action(){
        System.out.println("Receiver action");
    }

    public void closed(){
        System.out.println("Receiver closed");
    }
}

class DoitCommand implements ICommand{

    private final Receiver receiver;

    public DoitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void doit() {
        System.out.println("DoitCommand doit");
        receiver.action();
    }
}

class ClosedCommand implements ICommand {

    private final Receiver receiver;

    public ClosedCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void doit() {
        System.out.println("ClosedCommand doit");
        receiver.closed();
    }
}

class Sender {
    private final ICommand command;

    public Sender(ICommand command) {
        this.command = command;
    }

    public void call(){
        System.out.println("Sender call");
        command.doit();
    }
}
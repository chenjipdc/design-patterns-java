package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/9/3 1:28 下午
 *
 * (1) 对象的行为依赖于它的状态（如某些属性值），状态的改变将导致行为的变化。
 *
 * (2) 在代码中包含大量与对象状态有关的条件语句，这些条件语句的出现，会导致代码的可维护性和灵活性变差，
 * 不能方便地增加和删除状态，并且导致客户类与类库之间的耦合增强。
 */
public class DP16_State {
}

interface HttpHandle {
    void connect();
    void response();
    void timeout();
    void closed();
}

abstract class AbstractState implements HttpHandle{
    protected HttpContext context;

    public void setContext(HttpContext context) {
        this.context = context;
    }
}

class ConnectState extends AbstractState {

    @Override
    public void connect() {
        context.setState(new ResponseState());
        System.out.println("连接成功");
    }

    @Override
    public void response() {
        context.setState(new ClosedState());
        System.out.println("还未建立连接，不能响应数据，关闭连接");
    }

    @Override
    public void timeout() {
        context.setState(new TimeoutState());
        System.out.println("连接超时");
    }

    @Override
    public void closed() {
        context.setState(this);
        System.out.println("还未建立连接，不能关闭");
    }
}

class ResponseState extends AbstractState {

    @Override
    public void connect() {
        context.setState(this);
        System.out.println("连接已建立");
    }

    @Override
    public void response() {
        context.setState(new ClosedState());
        System.out.println("响应数据");
    }

    @Override
    public void timeout() {
        context.setState(new TimeoutState());
        System.out.println("数据响应超时");
    }

    @Override
    public void closed() {
        context.setState(new ClosedState());
        System.out.println("数据未响应");
    }
}

class TimeoutState extends AbstractState {

    @Override
    public void connect() {
        context.setState(new ClosedState());
        System.out.println("超时");
    }

    @Override
    public void response() {
        context.setState(new ClosedState());
        System.out.println("超时");
    }

    @Override
    public void timeout() {
        context.setState(new ClosedState());
        System.out.println("超时");
    }

    @Override
    public void closed() {
        context.setState(new ClosedState());
        System.out.println("关闭连接");
    }
}

class ClosedState extends AbstractState {

    @Override
    public void connect() {
        System.out.println("正在关闭连接，不能重新连接");
    }

    @Override
    public void response() {
        System.out.println("正在关闭连接，不能响应");
    }

    @Override
    public void timeout() {
        context.setState(new TimeoutState());
        System.out.println("关闭连接超时");
    }

    @Override
    public void closed() {
        System.out.println("关闭连接");
    }
}

class HttpContext implements HttpHandle{
    private AbstractState state;

    public void setState(AbstractState state) {
        this.state = state;
    }

    @Override
    public void connect() {
        this.state.setContext(this);
        this.state.connect();
    }

    @Override
    public void response() {
        this.state.setContext(this);
        this.state.response();
    }

    @Override
    public void timeout() {
        this.state.setContext(this);
        this.state.timeout();
    }

    @Override
    public void closed() {
        this.state.setContext(this);
        this.state.closed();

    }
}
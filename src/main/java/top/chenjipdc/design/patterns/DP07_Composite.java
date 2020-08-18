package top.chenjipdc.design.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/18 9:57 上午
 *
 * 组合模式，又称"整体-部分（Part-Whole）"模式。
 *
 * 使用场景：
 * 1、在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，客户端可以一致地对待它们。
 * 2、在一个使用面向对象语言开发的系统中需要处理一个树形结构。
 * 3、在一个系统中能够分离出叶子对象和容器对象，而且它们的类型不固定，需要增加一些新的类型。
 */
public class DP07_Composite {
}

class Message {
    String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}

/**
 * ios     android      web
 *  \        |           /
 *   \       |          /
 *     \     |       /
 *          研发
 *           \      销售    运营
 *             \     |     /
 *               \   |    /
 *                 \ |  /
 *                  总部
 */
abstract class Department {

    protected List<Department> departments = new ArrayList<>();

    public void addDepartment(Department...dps){
        departments.addAll(Arrays.asList(dps));
    }

    public void removeDepartment(Department...dps){
        departments.removeAll(Arrays.asList(dps));
    }

    /**
     * 发送消息
     * @param msg
     */
    abstract protected void sendMsg(Message msg);

}

class Company extends Department {

    @Override
    protected void sendMsg(Message msg) {
        System.out.println("====== 公司总部给各部门发送消息 ======");
        departments.forEach(it -> it.sendMsg(msg));
    }
}

class Development extends Department {

    @Override
    protected void sendMsg(Message msg) {
        System.out.println("----- 研发部给各部门发送消息 -----");
        departments.forEach(it -> it.sendMsg(msg));
    }
}

class Ios extends Development {
    @Override
    protected void sendMsg(Message msg) {
        System.out.println("研发部ios发送消息：" + msg);
    }
}

class Android extends Development {
    @Override
    protected void sendMsg(Message msg) {
        System.out.println("研发部android发送消息：" + msg);
    }
}

class Web extends Development {
    @Override
    protected void sendMsg(Message msg) {
        System.out.println("研发部web发送消息：" + msg);
    }
}

class Sales extends Department {

    @Override
    protected void sendMsg(Message msg) {
        System.out.println("给销售部门发通知：" + msg);
    }
}

class Dbo extends Department {

    @Override
    protected void sendMsg(Message msg) {
        System.out.println("给运营部门发通知：" + msg);
    }
}
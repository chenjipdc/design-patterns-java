package top.chenjipdc.design.patterns;


import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/31 9:43 上午
 *
 * (1) 系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解。
 *
 * (2) 一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象。
 *
 * (3) 想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。可以通过引入中介者类来实现，
 * 在中介者中定义对象交互的公共行为，如果需要改变行为则可以增加新的具体 中介者类。
 */
public class DP15_TestMediator {

    @Test
    public void testMediator() {
        DP15_Mediator.ChaosMediator mediator = new DP15_Mediator.ChaosMediator();

        DP15_Mediator.Button button = new DP15_Mediator.Button();
        DP15_Mediator.Label label = new DP15_Mediator.Label();
        DP15_Mediator.TextView textView = new DP15_Mediator.TextView();
        DP15_Mediator.TextField textField = new DP15_Mediator.TextField();
        DP15_Mediator.CheckBox checkBox = new DP15_Mediator.CheckBox();

        button.setMediator(mediator);
        checkBox.setMediator(mediator);

        mediator.setButton(button);
        mediator.setLabel(label);
        mediator.setTextView(textView);
        mediator.setTextField(textField);
        mediator.setCheckBox(checkBox);

        button.change();
        System.out.println("-----------");
        checkBox.change();
    }
}
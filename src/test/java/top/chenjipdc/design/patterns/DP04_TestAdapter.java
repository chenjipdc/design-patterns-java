package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/10 3:27 下午
 */
public class DP04_TestAdapter {

    /**
     * 对象适配
     */
    @Test
    public void testTargetAdapter(){
        TargetAdapter.DrawAdapter drawAdapter = new TargetAdapter.DrawAdapter();
        drawAdapter.neeDraw();
    }

    /**
     * 类适配，单向。
     * 注：双向很少用到，就不写了。
     */
    @Test
    public void testClassAdapter(){
        ClassAdapter.Target target = new ClassAdapter.DefaultTarget();
        target.doService();

        System.out.println("软件开发了一段时间，发现默认的实现性能不行了，但又不想改以前的代码");
        target = new ClassAdapter.ServiceAdapter();
        target.doService();
    }

    /**
     * 缺省适配
     */
    @Test
    public void testDefaultAdapter(){
        DefaultAdapter.MouseListener upDown = new DefaultAdapter.UpDownMouseListener();
        System.out.println("=========== 我只关心上下事件 ===========");
        upDown.left();
        upDown.up();
        upDown.down();

        System.out.println("\n=========== 我只关心左右事件 ===========");
        DefaultAdapter.LeftRightMouseListener leftRight = new DefaultAdapter.LeftRightMouseListener();
        leftRight.left();
        leftRight.up();
        leftRight.right();
    }
}

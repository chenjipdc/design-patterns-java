package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/17 9:48 上午
 */
public class DP06_TestBridge {

    @Test
    public void testBridge1(){
        Color redColor = new RedColor();
        Color blackColor = new BlackColor();

        Pen pen = new Brush(redColor);
        pen.paint();
        System.out.println("换个颜色试试");
        pen.setColor(blackColor);
        pen.paint();

        System.out.println("=================");
        System.out.println("我不喜欢这支笔，换支笔试试");
        pen = new Pencil(blackColor);
        pen.paint();
        System.out.println("再换个颜色试试");
        pen.setColor(redColor);
        pen.paint();
    }
}

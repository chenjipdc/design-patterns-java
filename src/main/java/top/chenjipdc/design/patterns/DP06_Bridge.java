package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/17 9:47 上午
 *
 * 解决类继承爆炸，将继承关系转换为动态组合关系，这样更加灵活，更易于扩展。
 */
public class DP06_Bridge {
}

interface Color {
    String color();
}

abstract class Pen {
    /**
     * 这里持有color对象
     */
    protected Color color;

    public Pen(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 这里使用抽象方法
     */
    abstract public void paint();
}

/**
 * 需要什么颜色，实现什么颜色即可。不需要继承一堆。
 */
class RedColor implements Color {

    @Override
    public String color() {
        return "红色";
    }
}

class BlackColor implements Color {

    @Override
    public String color() {
        return "黑色";
    }
}

/**
 * 需要什么笔自己实现画法paint
 */
class Pencil extends Pen {

    public Pencil(Color color) {
        super(color);
    }

    @Override
    public void paint() {
        System.out.println("我是铅笔，使用了" + color.color() + "画了个🍑");
    }
}

class Brush extends Pen {

    public Brush(Color color) {
        super(color);
    }

    @Override
    public void paint() {
        System.out.println("我是毛笔，使用了" + color.color() + "写了\"hello word\"");
    }
}



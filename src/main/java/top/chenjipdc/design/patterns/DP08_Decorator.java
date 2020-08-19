package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/19 9:37 上午
 *
 * 装饰模式降低了系统的耦合度，可以动态增加或删除对象的职责，并使得需要装饰的具体构
 * 件类和具体装饰类可以独立变化，以便增加新的具体构件类和具体装饰类。
 * 在软件开发中， 装饰模式应用较为广泛，例如在JavaIO中的输入流和输出流的设计、javax.swing包中一些图形界面构件功能的增强等地方都运用了装饰模式。
 */
public class DP08_Decorator {
}

abstract class Lamp {
    /**
     * 打开电灯
     */
    abstract void on();
}

class Led extends Lamp {

    @Override
    void on() {
        System.out.println("打开LED灯");
    }
}

class LampDecorator extends Lamp {
    private final Lamp lamp;

    LampDecorator(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    void on() {
        lamp.on();
    }
}

class LampColorDecorator extends LampDecorator {

    LampColorDecorator(Lamp lamp) {
        super(lamp);
    }

    @Override
    void on() {
        System.out.println("改变灯的颜色");
        super.on();
    }
}

class LampLightnessDecorator extends LampDecorator {

    LampLightnessDecorator(Lamp lamp) {
        super(lamp);
    }

    @Override
    void on() {
        System.out.println("改变灯的亮度");
        super.on();
    }
}
package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/9 2:50 下午
 *
 * 适配器模式，用于兼容。
 * 如：不同电压下，通过电源线，使电器在不同电压下正常工作。
 *
 * 以下情况下可以使用：
 * - 你想使用一个已经存在的类，而它的接口不符合你的要求。
 * - 你想创建一个可以复用的类，该类可以与其他不相关的类或者不可预见的类（即那些接口可能不一定兼容的类）协同工作。
 * -（仅适用于对象Adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配他们的接口。对象适配器可以适配它们的父接口。
 */
public class DP04_Adapter {
}

/**
 * 对象适配器，比较常用
 */
class TargetAdapter {

    interface Draw {
        /**
         * 绘制方法
         */
        void draw();
    }

    static class DrawAdapter {
        /**
         * 可以任意更换draw，而不需要DrawAdapter使用者更改任何代码。
         */
        private final Draw draw;

        public DrawAdapter() {
            draw = new Triangle();
//            draw = new Line();
        }

        public void neeDraw(){
            draw.draw();
        }
    }

    static class Triangle implements Draw {

        @Override
        public void draw() {
            System.out.println("画出了三角形");
        }
    }

    static class Line implements Draw {

        @Override
        public void draw() {
            System.out.println("画出了直线");
        }
    }

}


/**
 * 类适配器，java使用较少，因为限制较多。
 * 因为java不能多继承，final的类也不能继承。
 */
class ClassAdapter {

    interface Target {
        void doService();
    }

    static class DefaultTarget implements Target {

        @Override
        public void doService() {
            System.out.println("使用默认方法，性能性能平平");
        }
    }

    static class SpecialService {
        public void doSpecialService() {
            System.out.println("使用这个方法性能更优");
        }
    }

    static class ServiceAdapter extends SpecialService implements Target {

        private final SpecialService specialService;

        public ServiceAdapter() {
            specialService = new SpecialService();
        }

        @Override
        public void doService() {
            specialService.doSpecialService();
        }
    }
}

/**
 * 缺省适配器，就是实现了某个接口的abstract类，里面的方法都是空实现（任何事都不做）。
 */
class DefaultAdapter {

    /**
     * 鼠标事件
     */
    interface MouseListener {
        void stop();
        void left();
        void right();
        void up();
        void down();
    }

    static abstract class  AbstractMouseListenerAdapter implements MouseListener {

        @Override
        public void stop() {
            System.out.println("stop 什么也不做");
        }

        @Override
        public void left() {
            System.out.println("left 什么也不做");
        }

        @Override
        public void right() {
            System.out.println("right 什么也不做");
        }

        @Override
        public void up() {
            System.out.println("up 什么也不做");
        }

        @Override
        public void down() {
            System.out.println("down 什么也不做");
        }
    }

    static class LeftRightMouseListener extends AbstractMouseListenerAdapter {
        @Override
        public void left() {
            System.out.println("向左移动事件");
        }

        @Override
        public void right() {
            System.out.println("向右移动事件");
        }
    }

    static class UpDownMouseListener extends AbstractMouseListenerAdapter {
        @Override
        public void up() {
            System.out.println("向上移动事件");
        }

        @Override
        public void down() {
            System.out.println("向下移动事件");
        }
    }

}

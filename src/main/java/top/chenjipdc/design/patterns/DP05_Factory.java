package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/11 9:38 上午
 */
public class DP05_Factory {
}


interface Drawer {
    /**
     * 开始绘制
     */
    void display();
}

class DrawerLine implements Drawer {

    @Override
    public void display() {
        System.out.println("画了条直线");
    }
}

class DrawerPoint implements Drawer {

    @Override
    public void display() {
        System.out.println("画了个点");
    }
}

enum EnumDrawer {
    /**
     * 画线
     */
    LINE,

    /**
     * 画点
     */
    POINT
}


class SimpleFactory {
    public static Drawer createDrawer(EnumDrawer enumDrawer) {
        switch (enumDrawer) {
            case LINE:
                return new DrawerLine();
            case POINT:
                return new DrawerPoint();
            default:
                return null;
        }
    }
}


class AbsFactory {

    static class DrawerBean {
        /**
         * 通过配置文件获取具体工厂类
         *
         * @return
         */
        public static DrawerFactory getBean(){
            // 一通配置文件解析最终得到类名称，如：DrawerLineFactory
            try {
                return DrawerLineFactory.class.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    
    static abstract class DrawerFactory {
        abstract Drawer createDrawer();

        public void display(){
            createDrawer().display();
        }
    }

    static class DrawerLineFactory extends DrawerFactory {

        @Override
        Drawer createDrawer() {
            return new DrawerLine();
        }
    }

    static class DrawerPointFactory extends DrawerFactory {

        @Override
        Drawer createDrawer() {
            return new DrawerPoint();
        }
    }

}

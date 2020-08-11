package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/11 10:12 上午
 */
public class DP05_TestFactory {

    @Test
    public void testSimpleFactory(){
        for (EnumDrawer enumDrawer : EnumDrawer.values()) {
            Drawer drawer = SimpleFactory.createDrawer(enumDrawer);
            assert drawer != null;
            drawer.display();
            System.out.println("------------");
        }
    }

    @Test
    public void testAbstractFactory(){
        AbsFactory.DrawerFactory drawerFactory = AbsFactory.DrawerBean.getBean();
        assert drawerFactory != null;
        drawerFactory.display();
    }
}

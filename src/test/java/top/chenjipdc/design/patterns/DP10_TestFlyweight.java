package top.chenjipdc.design.patterns;

import org.junit.Test;

import java.util.Random;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/21 1:30 下午
 */
public class DP10_TestFlyweight {

    @Test
    public void testFlyweight(){

        Doc doc = new Doc();
        Component img1 = ComponentFactory.getComponent(Type.IMG,
                "xxoo.jpg");
        Component img2 = ComponentFactory.getComponent(Type.IMG,
                "xxoo.png");
        Component img3 = ComponentFactory.getComponent(Type.IMG,
                "xxoo.png");
        Component text1 = ComponentFactory.getComponent(Type.TEXT, "这是 == ooo");
        Component text2 = ComponentFactory.getComponent(Type.TEXT, "这是 -- xxx");
        Component text3 = ComponentFactory.getComponent(Type.TEXT, "这是 == ooo");
        System.out.println(img2 == img3);
        System.out.println(text1 == text3);

        doc.addComponent(img1, img2, text1, img3, text2, text1, text3, img1);

        Xy xy = new Xy(1,
                2);
        doc.display(xy);

        System.out.println("\n修改下共享属性");
        img2.setStr("xxoo_1.png");
        doc.display(xy);

        System.out.println("\n修改下外部传递属性");
        Random random = new Random();
        for (Component component : doc.getComponents()) {
            component.display(new Xy(random.nextInt() % 10, random.nextInt() % 10 + 10));
        }
    }
}

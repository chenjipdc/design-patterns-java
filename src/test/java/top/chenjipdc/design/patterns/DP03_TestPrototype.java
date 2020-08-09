package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/9 2:30 下午
 */
public class DP03_TestPrototype {

    /**
     * 使用clone不完全，属性修改会影响到之前的对象
     */
    @Test
    public void testClone(){
        MonkeyKing monkeyKing = new MonkeyKing();
        monkeyKing.setName("美猴王");
        monkeyKing.getAttrs().add(("分身"));
        System.out.println(monkeyKing);
        System.out.println();

        MonkeyKing monkeyKingClone = monkeyKing.clone();
        monkeyKingClone.setName("孙悟空");
        monkeyKingClone.getAttrs().add("72变");
        System.out.println(monkeyKingClone);
        System.out.println();

        System.out.println(monkeyKing);
        assert !monkeyKing.equals(monkeyKingClone);
    }


    /**
     * 自定义copy避免了属性修改会影响到之前的对象
     */
    @Test
    public void testCopy(){
        MonkeyKing monkeyKing = new MonkeyKing();
        monkeyKing.setName("六耳猕猴");
        monkeyKing.getAttrs().add(("分身"));
        System.out.println(monkeyKing);
        System.out.println();

        MonkeyKing monkeyKingCopy = monkeyKing.copy();
        monkeyKingCopy.setName("孙悟空");
        monkeyKingCopy.getAttrs().add("72变");
        System.out.println(monkeyKingCopy);
        System.out.println();

        System.out.println(monkeyKing);
        assert !monkeyKing.equals(monkeyKingCopy);
    }
}

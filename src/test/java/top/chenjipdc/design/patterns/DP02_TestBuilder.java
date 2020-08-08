package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/8 9:12 上午
 */
public class DP02_TestBuilder {

    @Test
    public void testBuilder1(){
        AnimalBuilder animalBuilder = new AnimalBuilder();
        animalBuilder.name("狗");
        animalBuilder.part1("会咬人");
        animalBuilder.part2("有尾巴");
        animalBuilder.part3("四条腿");
        animalBuilder.part4("有毛");
        animalBuilder.part5("会叫");

        Animal dog = animalBuilder.build();
        System.out.println(dog);
    }
}

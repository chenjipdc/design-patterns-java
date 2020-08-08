package top.chenjipdc.design.patterns;

import lombok.Data;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/8 9:12 上午
 *
 * 适用于一个类较为复杂，由较多部分构成。
 */
public class DP02_Builder {
}

@Data
class Animal {
    private String name;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
}

class AnimalBuilder {

    Animal animal;

    public AnimalBuilder() {
        animal = new Animal();
    }

    public AnimalBuilder part1(String part){
        animal.setPart1(part);
        return this;
    }

    public AnimalBuilder name(String part){
        animal.setName(part);
        return this;
    }

    public AnimalBuilder part2(String part){
        animal.setPart2(part);
        return this;
    }

    public AnimalBuilder part3(String part){
        animal.setPart3(part);
        return this;
    }

    public AnimalBuilder part4(String part){
        animal.setPart4(part);
        return this;
    }

    public AnimalBuilder part5(String part){
        animal.setPart5(part);
        return this;
    }

    public Animal build(){
        return animal;
    }
}


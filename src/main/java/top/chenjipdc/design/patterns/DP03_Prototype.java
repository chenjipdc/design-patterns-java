package top.chenjipdc.design.patterns;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/9 2:18 下午
 *
 * 使用clone快速创建新的对象，跟分身一样。
 */
public class DP03_Prototype {
}

@Getter
@Setter
@ToString
class MonkeyKing implements Cloneable {
    private String name;
    private Set<String> attrs = new HashSet<>();

    /**
     * 重写clone
     *
     * @return
     */
    @Override
    public MonkeyKing clone(){
        try {
            return (MonkeyKing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 或者和自己实现一个copy方法
     * @return
     */
    public MonkeyKing copy(){
        MonkeyKing monkeyKing = new MonkeyKing();
        monkeyKing.name = name;
        monkeyKing.attrs = new HashSet<>(attrs);
        return monkeyKing;
    }
}

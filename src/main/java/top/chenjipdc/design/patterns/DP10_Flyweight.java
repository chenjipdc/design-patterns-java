package top.chenjipdc.design.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/21 1:30 下午
 *
 * 运用共享技术有效地支持大量细粒度对象的复用。
 * 通常与其他模式结合，如工厂模式。
 *
 * (1) 一个系统有大量相同或者相似的对象，造成内存的大量耗费。
 * (2) 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
 * (3) 在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源， 因此，应当在需要多次重复使用享元对象时才值得使用享元模式。
 *
 * 类似池化技术
 */
public class DP10_Flyweight {
}

class ComponentFactory {

    private static final ComponentFactory INSTANCE = new ComponentFactory();

    public HashMap<String, Img> imgPool = new HashMap<>();
    public HashMap<String, Text> textPool = new HashMap<>();

    public static Component getComponent(Type type, String str){
        switch (type){
            case IMG:
                return getImg(str);
            case TEXT:
                return getText(str);
            default:
                return null;
        }
    }

    public static Img getImg(String str){
        if (INSTANCE.imgPool.containsKey(str)){
            return INSTANCE.imgPool.get(str);
        }
        Img img = new Img(str);
        INSTANCE.imgPool.put(str, img);
        return img;
    }

    public static Text getText(String str){
        if (INSTANCE.textPool.containsKey(str)){
            return INSTANCE.textPool.get(str);
        }
        Text text = new Text(str);
        INSTANCE.textPool.put(str, text);
        return text;
    }

    public ComponentFactory getInstance(){
        return INSTANCE;
    }
}

enum Type {
    /**
     * image
     */
    IMG,

    /**
     * text
     */
    TEXT
}

class Doc {
    private final List<Component> components = new ArrayList<>();

    public void addComponent(Component...components){
        this.components.addAll(Arrays.asList(components));
    }

    public List<Component> getComponents() {
        return components;
    }

    public void display(Xy xy){
        for (Component component : components) {
            component.display(xy);
        }
    }
}

class Xy {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

abstract class Component {

    protected String str;

    public void setStr(String str){
        this.str = str;
    }

    public Component(String str) {
        this.str = str;
    }

    /**
     * 显示
     */
    abstract public void display(Xy xy);
}

class Img extends Component{

    public Img(String str) {
        super(str);
    }

    @Override
    public void display(Xy xy) {
        System.out.println("> 显示图片名称为：" + str + " 显示位置为: x=" + xy.getX() + " y=" + xy.getY());
    }
}

class Text extends Component{

    public Text(String str) {
        super(str);
    }

    @Override
    public void display(Xy xy) {
        System.out.println("》显示文本为：" + str + " 显示位置为: x=" + xy.getX() + " y=" + xy.getY());
    }
}
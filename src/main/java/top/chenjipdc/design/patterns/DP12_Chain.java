package top.chenjipdc.design.patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/25 9:34 上午
 */
public class DP12_Chain {
}

class StrWrapper {
    private String str;

    public StrWrapper(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

interface FilterChain {

    void doFilter(StrWrapper str);
}

interface Filter {
    void doFilter(StrWrapper str, FilterChain chain);
}

class PasswordFilter implements Filter {

    @Override
    public void doFilter(StrWrapper str, FilterChain chain) {
        String newStr = str.getStr().replace("password", "******");
        System.out.println("password chain: " + newStr);
        str.setStr(newStr);
        chain.doFilter(str);
    }
}

class BlackFilter implements Filter {

    @Override
    public void doFilter(StrWrapper str, FilterChain chain) {
        String newStr = str.getStr().replace("卧槽", "*");
        System.out.println("black chain: " + newStr);
        str.setStr(newStr);
        chain.doFilter(str);
    }
}

class HappyFilter implements Filter {

    @Override
    public void doFilter(StrWrapper str, FilterChain chain) {
        String newStr = "😄" + str.getStr() + "😄";
        System.out.println("happy chain: " + newStr);
        str.setStr(newStr);
        chain.doFilter(str);
    }
}

class BreakFilter implements Filter {

    @Override
    public void doFilter(StrWrapper str, FilterChain chain) {
        if (str.getStr().contains("break")){
            return;
        }
        chain.doFilter(str);
    }
}

class SensitiveFilterChain implements FilterChain {
    private final List<Filter> filters = new ArrayList<>();
    private Iterator<Filter> filterIterator = filters.iterator();

    public void addFilter(Filter filter){
        filters.add(filter);
        filterIterator = filters.iterator();
    }

    private Filter nextFilter(){
        if (filterIterator.hasNext()){
            return filterIterator.next();
        }
        return null;
    }

    @Override
    public void doFilter(StrWrapper str) {
        Filter filter = nextFilter();
        if (filter != null){
            filter.doFilter(str, this);
        }
    }
}
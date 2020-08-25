package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/25 9:35 上午
 */
public class DP12_TestChain {

    @Test
    public void testChain(){
        SensitiveFilterChain filterChain = new SensitiveFilterChain();

        filterChain.addFilter(new HappyFilter());
        filterChain.addFilter(new PasswordFilter());
        filterChain.addFilter(new BlackFilter());

        StrWrapper strWrapper = new StrWrapper("卧槽了，这里有密码是password,break");
        filterChain.doFilter(strWrapper);
        System.out.println("过滤后结果：" + strWrapper.getStr());
    }

}

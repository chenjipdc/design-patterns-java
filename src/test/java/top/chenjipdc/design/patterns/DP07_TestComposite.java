package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/18 9:57 上午
 */
public class DP07_TestComposite {

    @Test
    public void testComposite(){
        Company company = new Company();

        Sales sales = new Sales();

        Dbo dbo = new Dbo();

        Development development = new Development();
        Ios ios = new Ios();
        Android android = new Android();
        Web web = new Web();
        development.addDepartment(ios, android, web);

        company.addDepartment(sales, dbo, development);

        company.sendMsg(new Message("这周五休息，不用上班。"));
    }
}

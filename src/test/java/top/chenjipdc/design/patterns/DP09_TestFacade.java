package top.chenjipdc.design.patterns;

import org.junit.Test;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/20 1:41 下午
 */
public class DP09_TestFacade {

    @Test
    public void testFacade() {
        String src = "en.txt";
        String dest = "de.txt";
        FileEncryptFacade fileEncryptFacade = new FileEncryptFacade(
                new TextFileReaderWriter(),
                new TextFileReaderWriter(),
                new AesEncrypt()
        );
        fileEncryptFacade.fileEncrypt(src, dest);
        fileEncryptFacade.fileDecrypt(dest, src);

        System.out.println("换一种算法");
        fileEncryptFacade.setEncryptFacade(new RsaEncrypt());
        fileEncryptFacade.fileEncrypt(src, dest);
        fileEncryptFacade.fileDecrypt(dest, src);
    }
}
package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/20 1:41 下午
 *
 * 为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 *
 * 使用场景：
 * 1、当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
 * 2、客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦，从而提高子系统的独立性和可移植性。
 * 3、在层次化结构中，可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联系，而通过外观类建立联系，降低层之间的耦合度。
 */
public class DP09_Facade {
}

interface FileReader {
    byte[] read(String filename);
}

interface FileWriter {
    boolean write(String filename, byte[] bytes);
}

class TextFileReaderWriter implements FileReader, FileWriter {

    @Override
    public byte[] read(String filename) {
        return filename.getBytes();
    }

    @Override
    public boolean write(String filename, byte[] bytes) {
        return true;
    }
}

abstract class AbstractEncryptFacade {
    abstract public byte[] encrypt(byte[] bytes);

    abstract public byte[] decrypt(byte[] bytes);
}

class AesEncrypt extends AbstractEncryptFacade {

    @Override
    public byte[] encrypt(byte[] bytes) {
        return ("使用aes加密数据：" + new String(bytes)).getBytes();
    }

    @Override
    public byte[] decrypt(byte[] bytes) {
        return ("使用aes解密数据：" + new String(bytes)).getBytes();
    }
}

class RsaEncrypt extends AbstractEncryptFacade {
    @Override
    public byte[] encrypt(byte[] bytes) {
        return ("使用rsa加密数据：" + new String(bytes)).getBytes();
    }

    @Override
    public byte[] decrypt(byte[] bytes) {
        return ("使用rsa解密数据：" + new String(bytes)).getBytes();
    }
}

class FileEncryptFacade {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private AbstractEncryptFacade encryptFacade;

    public FileEncryptFacade(FileReader fileReader, FileWriter fileWriter, AbstractEncryptFacade encryptFacade) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.encryptFacade = encryptFacade;
    }

    public void setEncryptFacade(AbstractEncryptFacade encryptFacade) {
        this.encryptFacade = encryptFacade;
    }

    public void fileEncrypt(String src, String dest){
        byte[] read = fileReader.read(src);
        byte[] encrypt = encryptFacade.encrypt(read);
        System.out.println(new String(encrypt));
        fileWriter.write(dest, encrypt);
    }

    public void fileDecrypt(String src, String dest){
        byte[] read = fileReader.read(src);
        byte[] decrypt = encryptFacade.decrypt(read);
        System.out.println(new String(decrypt));
        fileWriter.write(dest, decrypt);
    }
}
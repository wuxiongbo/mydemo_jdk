package asm.asm;

import asm.decorator.AccountImpl;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
//import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class SecureAccountGenerator {

    private static AccountGeneratorClassLoader classLoader =  new AccountGeneratorClassLoader();

    private static Class secureAccountClass;

    public AccountImpl generateSecureAccount()
            throws ClassFormatError,InstantiationException, IllegalAccessException, IOException {
        if (null == secureAccountClass) {
//            ClassReader cr = new ClassReader("asm.decorator.AccountImpl");
//            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
//            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
//            byte[] data = cw.toByteArray();

//
//            File file = new File("D:\\workspace\\wxb\\demo\\target\\classes\\asm\\decorator\\AccountImpl$EnhancedByASM.class");
//            FileOutputStream fout = new FileOutputStream(file);
//            fout.write(data);


//            secureAccountClass = classLoader.defineClassFromClassFile("asm.decorator.AccountImpl$EnhancedByASM",data);
        }
        return (AccountImpl) secureAccountClass.newInstance();
    }

    private static class AccountGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className,
                                              byte[] classFile) throws ClassFormatError {
            return defineClass(className, classFile, 0, classFile.length);
        }
    }

}

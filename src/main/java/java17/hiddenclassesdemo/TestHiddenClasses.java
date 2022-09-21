package java17.hiddenclassesdemo;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static java.util.Base64.getDecoder;

/**
 * <p>调用隐藏类</p>
 *
 * @author wuxiongbo
 * @date 2022/7/7 16:56
 */
public class TestHiddenClasses {
    public static void main(String[] args) throws Throwable {
        test2();
    }

    // 将类隐藏为 Base64编码
    public static void test() throws IOException {
        String filePath = "/Users/10027088/Documents/workspace/mycode/mydemo_jdk/target/classes/java17/JEP371HiddenClasses.class";
        byte[] b = Files.readAllBytes(Paths.get(filePath));
        System.out.println(Base64.getEncoder().encodeToString(b));
    }


    public static void test2() throws Throwable {
        // 1. 加载encode之后的隐藏类
        String CLASS_INFO = "yv66vgAAAD0AFAoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAP5L2g55yL5LiN6KeB5oiRBwAKAQAaamF2YTE3L0pFUDM3MUhpZGRlbkNsYXNzZXMBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAHExqYXZhMTcvSkVQMzcxSGlkZGVuQ2xhc3NlczsBAAVoZWxsbwEAFCgpTGphdmEvbGFuZy9TdHJpbmc7AQAKU291cmNlRmlsZQEAGEpFUDM3MUhpZGRlbkNsYXNzZXMuamF2YQAhAAkAAgAAAAAAAgABAAUABgABAAsAAAAvAAEAAQAAAAUqtwABsQAAAAIADAAAAAYAAQAAAAkADQAAAAwAAQAAAAUADgAPAAAACQAQABEAAQALAAAAGwABAAAAAAADEgewAAAAAQAMAAAABgABAAAACwABABIAAAACABM=";
        byte[] classInBytes = getDecoder().decode(CLASS_INFO);

        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes, true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();

        // 输出类名
        System.out.println("类名："+proxy.getName());

        // 输出类有哪些函数
        for (Method method : proxy.getDeclaredMethods()) {
            System.out.println("方法名："+method.getName());

        }
        // 2. 调用hello函数
        MethodHandle mh = MethodHandles.lookup().findStatic(proxy, "hello", MethodType.methodType(String.class));
        String result = (String) mh.invokeExact();
        System.out.println(result);
    }

}

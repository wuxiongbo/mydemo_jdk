package reflect.proxy.cglib.methodproxysource.cglib;


import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.core.WeakCacheKey;
import net.sf.cglib.proxy.Enhancer;
import org.objectweb.asm.Type;

/**
 * @author Xander Wu
 * @date 2022/10/26 15:42
 */
/* compiled from: <generated> */
/* renamed from: net.sf.cglib.proxy.Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72 */
/* loaded from: Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72.class */
public class Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72 extends KeyFactory implements Enhancer.EnhancerKey {
    private String FIELD_0;
    private String[] FIELD_1;
    private WeakCacheKey FIELD_2;
    private Type[] FIELD_3;
    private boolean FIELD_4;
    private boolean FIELD_5;
    private Long FIELD_6;

    public Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72() {
    }

    /**
     * 生成唯一key（用于从缓存中获取代理类实例）
     * @param str
     * @param strArr
     * @param weakCacheKey
     * @param typeArr
     * @param z
     * @param z2
     * @param l
     * @return
     */
    @Override
    public Object newInstance(String str, String[] strArr, WeakCacheKey weakCacheKey, Type[] typeArr, boolean z, boolean z2, Long l) {
        return new Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72(str, strArr, weakCacheKey, typeArr, z, z2, l);
    }

    public Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72(String str, String[] strArr, WeakCacheKey weakCacheKey, Type[] typeArr, boolean z, boolean z2, Long l) {
        this.FIELD_0 = str;
        this.FIELD_1 = strArr;
        this.FIELD_2 = weakCacheKey;
        this.FIELD_3 = typeArr;
        this.FIELD_4 = z;
        this.FIELD_5 = z2;
        this.FIELD_6 = l;
    }

    @Override
    public int hashCode() {
        String str = this.FIELD_0;
        int hashCode = (19289 * 641371) + (str != null ? str.hashCode() : 0);
        String[] strArr = this.FIELD_1;
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str2 = strArr[i];
                hashCode = (hashCode * 641371) + (str2 != null ? str2.hashCode() : 0);
            }
        }
        WeakCacheKey weakCacheKey = this.FIELD_2;
        int hashCode2 = (hashCode * 641371) + (weakCacheKey != null ? weakCacheKey.hashCode() : 0);
        Type[] typeArr = this.FIELD_3;
        if (typeArr != null) {
            for (int i2 = 0; i2 < typeArr.length; i2++) {
                Type type = typeArr[i2];
                hashCode2 = (hashCode2 * 641371) + (type != null ? type.hashCode() : 0);
            }
        }
        int i3 = (((hashCode2 * 641371) + (!this.FIELD_4 ? 1 : 0)) * 641371) + (!this.FIELD_5 ? 1 : 0);
        Long l = this.FIELD_6;
        return (i3 * 641371) + (l != null ? l.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72)) {
            return false;
        }
        String str = this.FIELD_0;
        String str2 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_0;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (str == null || !str.equals(str2)) {
            return false;
        }
        String[] strArr = this.FIELD_1;
        String[] strArr2 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_1;
        if (strArr2 == null) {
            if (strArr != null) {
                return false;
            }
        } else if (strArr == null || strArr2.length != strArr.length) {
            return false;
        } else {
            for (int i = 0; i < strArr2.length; i++) {
                String str3 = strArr2[i];
                String str4 = strArr[i];
                if (str4 == null) {
                    if (str3 != null) {
                        return false;
                    }
                } else if (str3 == null || !str3.equals(str4)) {
                    return false;
                }
            }
        }
        WeakCacheKey weakCacheKey = this.FIELD_2;
        WeakCacheKey weakCacheKey2 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_2;
        if (weakCacheKey2 == null) {
            if (weakCacheKey != null) {
                return false;
            }
        } else if (weakCacheKey == null || !weakCacheKey.equals(weakCacheKey2)) {
            return false;
        }
        Type[] typeArr = this.FIELD_3;
        Type[] typeArr2 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_3;
        if (typeArr2 == null) {
            if (typeArr != null) {
                return false;
            }
        } else if (typeArr == null || typeArr2.length != typeArr.length) {
            return false;
        } else {
            for (int i2 = 0; i2 < typeArr2.length; i2++) {
                Type type = typeArr2[i2];
                Type type2 = typeArr[i2];
                if (type2 == null) {
                    if (type != null) {
                        return false;
                    }
                } else if (type == null || !type.equals(type2)) {
                    return false;
                }
            }
        }
        if (!(this.FIELD_4 == ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_4 && this.FIELD_5 == ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_5)) {
            return false;
        }
        Long l = this.FIELD_6;
        Long l2 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72) obj).FIELD_6;
        return l2 == null ? l == null : l != null && l.equals(l2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:35:0x00fd in {1, 4, 5, 11, 12, 13, 16, 17, 20, 21, 27, 28, 29, 32, 33, 39, 40} preds:[]
        	at jadx.core.dex.visitors.blocks.BlockProcessor.calcImmediateDominators(BlockProcessor.java:275)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:227)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:50)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.p000sf.cglib.proxy.Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$7fb24d72.toString():java.lang.String");
    }
}
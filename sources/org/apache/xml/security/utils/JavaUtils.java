package org.apache.xml.security.utils;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JavaUtils {

    /* renamed from: a  reason: collision with root package name */
    static Log f72779a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72780b;

    static {
        Class cls = f72780b;
        if (cls == null) {
            cls = a("org.apache.xml.security.utils.JavaUtils");
            f72780b = cls;
        }
        f72779a = LogFactory.getLog(cls.getName());
    }

    private JavaUtils() {
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static byte[] a(InputStream inputStream) {
        UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
        byte[] bArr = new byte[TarConstants.EOF_BLOCK];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return unsyncByteArrayOutputStream.a();
            }
            unsyncByteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

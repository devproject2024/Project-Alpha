package org.apache.xml.security.c14n;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.w3c.dom.Node;

public class Canonicalizer {

    /* renamed from: a  reason: collision with root package name */
    static boolean f72564a = false;

    /* renamed from: b  reason: collision with root package name */
    static Map f72565b;

    /* renamed from: c  reason: collision with root package name */
    protected CanonicalizerSpi f72566c = null;

    private Canonicalizer(String str) {
        try {
            this.f72566c = (CanonicalizerSpi) b(str).newInstance();
            this.f72566c.f72567a = true;
        } catch (Exception unused) {
            throw new InvalidCanonicalizerException("signature.Canonicalizer.UnknownCanonicalizer", new Object[]{str});
        }
    }

    public static final Canonicalizer a(String str) {
        return new Canonicalizer(str);
    }

    public static void a() {
        if (!f72564a) {
            f72565b = new HashMap(10);
            f72564a = true;
        }
    }

    public static void a(String str, String str2) {
        Class b2 = b(str);
        if (b2 == null) {
            try {
                f72565b.put(str, Class.forName(str2));
            } catch (ClassNotFoundException unused) {
                throw new RuntimeException("c14n class not found");
            }
        } else {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, b2});
        }
    }

    private static Class b(String str) {
        return (Class) f72565b.get(str);
    }

    public void a(OutputStream outputStream) {
        this.f72566c.a(outputStream);
    }

    public byte[] a(Node node) {
        return this.f72566c.a(node);
    }

    public byte[] a(Node node, String str) {
        return this.f72566c.a(node, str);
    }
}

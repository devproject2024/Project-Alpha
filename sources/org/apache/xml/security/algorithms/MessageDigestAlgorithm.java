package org.apache.xml.security.algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Document;

public class MessageDigestAlgorithm extends Algorithm {

    /* renamed from: b  reason: collision with root package name */
    static ThreadLocal f72535b = new ThreadLocal() {
        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    MessageDigest f72536a = null;

    private MessageDigestAlgorithm(Document document, MessageDigest messageDigest, String str) {
        super(document, str);
        this.f72536a = messageDigest;
    }

    public static MessageDigestAlgorithm a(Document document, String str) {
        return new MessageDigestAlgorithm(document, b(str), str);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(bArr, bArr2);
    }

    private static MessageDigest b(String str) {
        MessageDigest messageDigest;
        MessageDigest messageDigest2 = (MessageDigest) ((Map) f72535b.get()).get(str);
        if (messageDigest2 != null) {
            return messageDigest2;
        }
        String a2 = JCEMapper.a(str);
        if (a2 != null) {
            String a3 = JCEMapper.a();
            if (a3 == null) {
                try {
                    messageDigest = MessageDigest.getInstance(a2);
                } catch (NoSuchAlgorithmException e2) {
                    throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e2.getLocalizedMessage()});
                } catch (NoSuchProviderException e3) {
                    throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e3.getLocalizedMessage()});
                }
            } else {
                messageDigest = MessageDigest.getInstance(a2, a3);
            }
            ((Map) f72535b.get()).put(str, messageDigest);
            return messageDigest;
        }
        throw new XMLSignatureException("algorithms.NoSuchMap", new Object[]{str});
    }

    public void a(byte b2) {
        this.f72536a.update(b2);
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f72536a.update(bArr, i2, i3);
    }

    public byte[] b() {
        return this.f72536a.digest();
    }

    public void c() {
        this.f72536a.reset();
    }

    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    public String e() {
        return "DigestMethod";
    }
}

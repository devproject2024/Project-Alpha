package org.apache.xml.security.algorithms.implementations;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;

public abstract class SignatureBaseRSA extends SignatureAlgorithmSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72552a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72553b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72554c;

    /* renamed from: d  reason: collision with root package name */
    private Signature f72555d = null;

    public class SignatureRSAMD5 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-md5";
        }
    }

    public class SignatureRSARIPEMD160 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160";
        }
    }

    public class SignatureRSASHA1 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        }
    }

    public class SignatureRSASHA256 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
        }
    }

    public class SignatureRSASHA384 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
        }
    }

    public class SignatureRSASHA512 extends SignatureBaseRSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
        }
    }

    static {
        Class cls = f72553b;
        if (cls == null) {
            cls = a("org.apache.xml.security.algorithms.implementations.SignatureBaseRSA");
            f72553b = cls;
        }
        f72552a = LogFactory.getLog(cls.getName());
    }

    public SignatureBaseRSA() {
        String a2 = JCEMapper.a(d());
        if (f72552a.isDebugEnabled()) {
            f72552a.debug("Created SignatureRSA using ".concat(String.valueOf(a2)));
        }
        String a3 = JCEMapper.a();
        if (a3 == null) {
            try {
                this.f72555d = Signature.getInstance(a2);
            } catch (NoSuchAlgorithmException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e2.getLocalizedMessage()});
            } catch (NoSuchProviderException e3) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e3.getLocalizedMessage()});
            }
        } else {
            this.f72555d = Signature.getInstance(a2, a3);
        }
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public String a() {
        return this.f72555d.getAlgorithm();
    }

    public void a(byte b2) {
        try {
            this.f72555d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(Key key) {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class cls = f72554c;
            if (cls == null) {
                cls = a("java.security.PublicKey");
                f72554c = cls;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, cls.getName()});
        }
        try {
            this.f72555d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f72555d;
            try {
                this.f72555d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f72552a.isDebugEnabled()) {
                    f72552a.debug("Exception when reinstantiating Signature:".concat(String.valueOf(e3)));
                }
                this.f72555d = signature;
            }
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr) {
        try {
            this.f72555d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        try {
            this.f72555d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public String b() {
        return this.f72555d.getProvider().getName();
    }

    public boolean b(byte[] bArr) {
        try {
            return this.f72555d.verify(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public abstract String d();
}

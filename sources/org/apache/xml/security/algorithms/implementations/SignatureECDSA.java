package org.apache.xml.security.algorithms.implementations;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.io.IOException;
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
import org.apache.xml.security.utils.Base64;

public abstract class SignatureECDSA extends SignatureAlgorithmSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72560a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72561b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72562c;

    /* renamed from: d  reason: collision with root package name */
    private Signature f72563d = null;

    public class SignatureECDSASHA1 extends SignatureECDSA {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha1";
        }
    }

    static {
        Class cls = f72561b;
        if (cls == null) {
            cls = a("org.apache.xml.security.algorithms.implementations.SignatureECDSA");
            f72561b = cls;
        }
        f72560a = LogFactory.getLog(cls.getName());
    }

    public SignatureECDSA() {
        String a2 = JCEMapper.a(d());
        if (f72560a.isDebugEnabled()) {
            f72560a.debug("Created SignatureECDSA using ".concat(String.valueOf(a2)));
        }
        String a3 = JCEMapper.a();
        if (a3 == null) {
            try {
                this.f72563d = Signature.getInstance(a2);
            } catch (NoSuchAlgorithmException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e2.getLocalizedMessage()});
            } catch (NoSuchProviderException e3) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e3.getLocalizedMessage()});
            }
        } else {
            this.f72563d = Signature.getInstance(a2, a3);
        }
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static byte[] c(byte[] bArr) {
        if (bArr.length >= 48) {
            int length = bArr.length / 2;
            int i2 = length;
            while (i2 > 0 && bArr[length - i2] == 0) {
                i2--;
            }
            int i3 = length - i2;
            int i4 = bArr[i3] < 0 ? i2 + 1 : i2;
            int i5 = length;
            while (i5 > 0 && bArr[(length * 2) - i5] == 0) {
                i5--;
            }
            int i6 = (length * 2) - i5;
            int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
            int i8 = i4 + 6 + i7;
            byte[] bArr2 = new byte[i8];
            bArr2[0] = TarHeader.LF_NORMAL;
            int i9 = i4 + 4;
            bArr2[1] = (byte) (i9 + i7);
            bArr2[2] = 2;
            bArr2[3] = (byte) i4;
            System.arraycopy(bArr, i3, bArr2, i9 - i2, i2);
            bArr2[i9] = 2;
            bArr2[i4 + 5] = (byte) i7;
            System.arraycopy(bArr, i6, bArr2, i8 - i5, i5);
            return bArr2;
        }
        throw new IOException("Invalid XMLDSIG format of ECDSA signature");
    }

    public String a() {
        return this.f72563d.getAlgorithm();
    }

    public void a(byte b2) {
        try {
            this.f72563d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(Key key) {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class cls = f72562c;
            if (cls == null) {
                cls = a("java.security.PublicKey");
                f72562c = cls;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, cls.getName()});
        }
        try {
            this.f72563d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f72563d;
            try {
                this.f72563d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f72560a.isDebugEnabled()) {
                    f72560a.debug("Exception when reinstantiating Signature:".concat(String.valueOf(e3)));
                }
                this.f72563d = signature;
            }
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr) {
        try {
            this.f72563d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        try {
            this.f72563d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public String b() {
        return this.f72563d.getProvider().getName();
    }

    public boolean b(byte[] bArr) {
        try {
            byte[] c2 = c(bArr);
            if (f72560a.isDebugEnabled()) {
                Log log = f72560a;
                StringBuffer stringBuffer = new StringBuffer("Called ECDSA.verify() on ");
                stringBuffer.append(Base64.b(bArr));
                log.debug(stringBuffer.toString());
            }
            return this.f72563d.verify(c2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new XMLSignatureException("empty", (Exception) e3);
        }
    }

    public abstract String d();
}

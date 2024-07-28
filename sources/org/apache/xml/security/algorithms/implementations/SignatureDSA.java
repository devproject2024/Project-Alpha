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

public class SignatureDSA extends SignatureAlgorithmSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72556a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72557b;

    /* renamed from: c  reason: collision with root package name */
    static Class f72558c;

    /* renamed from: d  reason: collision with root package name */
    private Signature f72559d = null;

    static {
        Class cls = f72557b;
        if (cls == null) {
            cls = a("org.apache.xml.security.algorithms.implementations.SignatureDSA");
            f72557b = cls;
        }
        f72556a = LogFactory.getLog(cls.getName());
    }

    public SignatureDSA() {
        String a2 = JCEMapper.a("http://www.w3.org/2000/09/xmldsig#dsa-sha1");
        if (f72556a.isDebugEnabled()) {
            f72556a.debug("Created SignatureDSA using ".concat(String.valueOf(a2)));
        }
        String a3 = JCEMapper.a();
        if (a3 == null) {
            try {
                this.f72559d = Signature.getInstance(a2);
            } catch (NoSuchAlgorithmException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e2.getLocalizedMessage()});
            } catch (NoSuchProviderException e3) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e3.getLocalizedMessage()});
            }
        } else {
            this.f72559d = Signature.getInstance(a2, a3);
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
        if (bArr.length == 40) {
            int i2 = 20;
            int i3 = 20;
            while (i3 > 0 && bArr[20 - i3] == 0) {
                i3--;
            }
            int i4 = 20 - i3;
            int i5 = bArr[i4] < 0 ? i3 + 1 : i3;
            while (i2 > 0 && bArr[40 - i2] == 0) {
                i2--;
            }
            int i6 = 40 - i2;
            int i7 = bArr[i6] < 0 ? i2 + 1 : i2;
            int i8 = i5 + 6 + i7;
            byte[] bArr2 = new byte[i8];
            bArr2[0] = TarHeader.LF_NORMAL;
            int i9 = i5 + 4;
            bArr2[1] = (byte) (i9 + i7);
            bArr2[2] = 2;
            bArr2[3] = (byte) i5;
            System.arraycopy(bArr, i4, bArr2, i9 - i3, i3);
            bArr2[i9] = 2;
            bArr2[i5 + 5] = (byte) i7;
            System.arraycopy(bArr, i6, bArr2, i8 - i2, i2);
            return bArr2;
        }
        throw new IOException("Invalid XMLDSIG format of DSA signature");
    }

    public String a() {
        return this.f72559d.getAlgorithm();
    }

    public void a(byte b2) {
        try {
            this.f72559d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(Key key) {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class cls = f72558c;
            if (cls == null) {
                cls = a("java.security.PublicKey");
                f72558c = cls;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, cls.getName()});
        }
        try {
            this.f72559d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f72559d;
            try {
                this.f72559d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f72556a.isDebugEnabled()) {
                    f72556a.debug("Exception when reinstantiating Signature:".concat(String.valueOf(e3)));
                }
                this.f72559d = signature;
            }
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr) {
        try {
            this.f72559d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        try {
            this.f72559d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public String b() {
        return this.f72559d.getProvider().getName();
    }

    public boolean b(byte[] bArr) {
        try {
            if (f72556a.isDebugEnabled()) {
                Log log = f72556a;
                StringBuffer stringBuffer = new StringBuffer("Called DSA.verify() on ");
                stringBuffer.append(Base64.b(bArr));
                log.debug(stringBuffer.toString());
            }
            return this.f72559d.verify(c(bArr));
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        } catch (IOException e3) {
            throw new XMLSignatureException("empty", (Exception) e3);
        }
    }
}

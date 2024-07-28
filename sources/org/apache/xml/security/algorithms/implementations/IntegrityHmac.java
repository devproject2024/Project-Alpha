package org.apache.xml.security.algorithms.implementations;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import net.one97.paytm.upi.util.UpiConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public abstract class IntegrityHmac extends SignatureAlgorithmSpi {

    /* renamed from: a  reason: collision with root package name */
    static Log f72546a;

    /* renamed from: c  reason: collision with root package name */
    static Class f72547c;

    /* renamed from: d  reason: collision with root package name */
    static Class f72548d;

    /* renamed from: b  reason: collision with root package name */
    int f72549b = 0;

    /* renamed from: e  reason: collision with root package name */
    private Mac f72550e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f72551f = false;

    public class IntegrityHmacMD5 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-md5";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return 128;
        }
    }

    public class IntegrityHmacRIPEMD160 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-ripemd160";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return 160;
        }
    }

    public class IntegrityHmacSHA1 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2000/09/xmldsig#hmac-sha1";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return 160;
        }
    }

    public class IntegrityHmacSHA256 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha256";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        }
    }

    public class IntegrityHmacSHA384 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha384";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return 384;
        }
    }

    public class IntegrityHmacSHA512 extends IntegrityHmac {
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha512";
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return 512;
        }
    }

    static {
        Class cls = f72547c;
        if (cls == null) {
            cls = a("org.apache.xml.security.algorithms.implementations.IntegrityHmac$IntegrityHmacSHA1");
            f72547c = cls;
        }
        f72546a = LogFactory.getLog(cls.getName());
    }

    public IntegrityHmac() {
        String a2 = JCEMapper.a(d());
        if (f72546a.isDebugEnabled()) {
            f72546a.debug("Created IntegrityHmacSHA1 using ".concat(String.valueOf(a2)));
        }
        try {
            this.f72550e = Mac.getInstance(a2);
        } catch (NoSuchAlgorithmException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a2, e2.getLocalizedMessage()});
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
        f72546a.debug("engineGetJCEAlgorithmString()");
        return this.f72550e.getAlgorithm();
    }

    public void a(byte b2) {
        try {
            this.f72550e.update(b2);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(Key key) {
        if (!(key instanceof SecretKey)) {
            String name = key.getClass().getName();
            Class cls = f72548d;
            if (cls == null) {
                cls = a("javax.crypto.SecretKey");
                f72548d = cls;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, cls.getName()});
        }
        try {
            this.f72550e.init(key);
        } catch (InvalidKeyException e2) {
            Mac mac = this.f72550e;
            try {
                this.f72550e = Mac.getInstance(mac.getAlgorithm());
            } catch (Exception e3) {
                if (f72546a.isDebugEnabled()) {
                    f72546a.debug("Exception when reinstantiating Mac:".concat(String.valueOf(e3)));
                }
                this.f72550e = mac;
            }
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(Element element) {
        super.a(element);
        if (element != null) {
            Text b2 = XMLUtils.b(element.getFirstChild(), "HMACOutputLength", 0);
            if (b2 != null) {
                this.f72549b = Integer.parseInt(b2.getData());
                this.f72551f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("element null");
    }

    public void a(byte[] bArr) {
        try {
            this.f72550e.update(bArr);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        try {
            this.f72550e.update(bArr, i2, i3);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public String b() {
        return this.f72550e.getProvider().getName();
    }

    public boolean b(byte[] bArr) {
        try {
            if (!this.f72551f || this.f72549b >= e()) {
                return MessageDigestAlgorithm.a(this.f72550e.doFinal(), bArr);
            }
            if (f72546a.isDebugEnabled()) {
                Log log = f72546a;
                StringBuffer stringBuffer = new StringBuffer("HMACOutputLength must not be less than ");
                stringBuffer.append(e());
                log.debug(stringBuffer.toString());
            }
            throw new XMLSignatureException("algorithms.HMACOutputLengthMin", new Object[]{String.valueOf(e())});
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public void c() {
        this.f72549b = 0;
        this.f72551f = false;
        this.f72550e.reset();
    }

    public abstract String d();

    /* access modifiers changed from: package-private */
    public abstract int e();
}

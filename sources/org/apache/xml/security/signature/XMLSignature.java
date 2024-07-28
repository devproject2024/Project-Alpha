package org.apache.xml.security.signature;

import com.paytmmoney.lite.mod.util.PMConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

public final class XMLSignature extends SignatureElementProxy {

    /* renamed from: a  reason: collision with root package name */
    static Log f72698a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72699b;

    /* renamed from: c  reason: collision with root package name */
    private SignedInfo f72700c = null;

    /* renamed from: d  reason: collision with root package name */
    private KeyInfo f72701d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f72702e = false;

    /* renamed from: f  reason: collision with root package name */
    private Element f72703f;

    /* renamed from: g  reason: collision with root package name */
    private int f72704g = 0;

    static {
        Class cls = f72699b;
        if (cls == null) {
            cls = a("org.apache.xml.security.signature.XMLSignature");
            f72699b = cls;
        }
        f72698a = LogFactory.getLog(cls.getName());
    }

    public XMLSignature(Element element, String str) {
        super(element, str);
        Element a2 = XMLUtils.a(element.getFirstChild());
        if (a2 != null) {
            this.f72700c = new SignedInfo(a2, str);
            this.f72703f = XMLUtils.a(XMLUtils.a(element.getFirstChild()).getNextSibling());
            Element element2 = this.f72703f;
            if (element2 != null) {
                Element a3 = XMLUtils.a(element2.getNextSibling());
                if (a3 != null && a3.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && a3.getLocalName().equals("KeyInfo")) {
                    this.f72701d = new KeyInfo(a3, str);
                }
                this.f72704g = 1;
                return;
            }
            throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignatureValue", PMConstants.SIGNATURE});
        }
        throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignedInfo", PMConstants.SIGNATURE});
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public final SignedInfo a() {
        return this.f72700c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a6, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6 A[ExcHandler: XMLSignatureException (r8v3 'e' org.apache.xml.security.signature.XMLSignatureException A[CUSTOM_DECLARE]), Splitter:B:2:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.security.Key r8) {
        /*
            r7 = this;
            java.lang.String r0 = "empty"
            r1 = 0
            if (r8 == 0) goto L_0x00a8
            org.apache.xml.security.signature.SignedInfo r2 = r7.a()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            org.apache.xml.security.algorithms.SignatureAlgorithm r3 = r2.c()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            org.apache.commons.logging.Log r4 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            boolean r4 = r4.isDebugEnabled()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            if (r4 == 0) goto L_0x0069
            org.apache.commons.logging.Log r4 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = "SignatureMethodURI = "
            r5.<init>(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = r3.a()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r5.append(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r5 = r5.toString()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r4.debug(r5)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            org.apache.commons.logging.Log r4 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = "jceSigAlgorithm    = "
            r5.<init>(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = r3.b()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r5.append(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r5 = r5.toString()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r4.debug(r5)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            org.apache.commons.logging.Log r4 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = "jceSigProvider     = "
            r5.<init>(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r6 = r3.c()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r5.append(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r5 = r5.toString()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r4.debug(r5)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            org.apache.commons.logging.Log r4 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r5 = "PublicKey = "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            r4.debug(r5)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
        L_0x0069:
            r4 = 0
            r3.a((java.security.Key) r8)     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            org.apache.xml.security.utils.SignerOutputStream r8 = new org.apache.xml.security.utils.SignerOutputStream     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            org.apache.xml.security.utils.UnsyncBufferedOutputStream r5 = new org.apache.xml.security.utils.UnsyncBufferedOutputStream     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            r5.<init>(r8)     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            r2.a((java.io.OutputStream) r5)     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            r5.close()     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            byte[] r4 = r7.b()     // Catch:{ IOException -> 0x0087, XMLSecurityException -> 0x0082, XMLSignatureException -> 0x00a6 }
            goto L_0x008a
        L_0x0082:
            r8 = move-exception
            r3.f()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            throw r8     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
        L_0x0087:
            r3.f()     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
        L_0x008a:
            boolean r8 = r3.b((byte[]) r4)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            if (r8 != 0) goto L_0x0098
            org.apache.commons.logging.Log r8 = f72698a     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            java.lang.String r2 = "Signature verification failed."
            r8.warn(r2)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            return r1
        L_0x0098:
            boolean r8 = r7.f72702e     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            boolean r8 = r2.b(r8)     // Catch:{ XMLSignatureException -> 0x00a6, XMLSecurityException -> 0x009f }
            return r8
        L_0x009f:
            r8 = move-exception
            org.apache.xml.security.signature.XMLSignatureException r1 = new org.apache.xml.security.signature.XMLSignatureException
            r1.<init>((java.lang.String) r0, (java.lang.Exception) r8)
            throw r1
        L_0x00a6:
            r8 = move-exception
            throw r8
        L_0x00a8:
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r2 = "Didn't get a key"
            r8[r1] = r2
            org.apache.xml.security.signature.XMLSignatureException r1 = new org.apache.xml.security.signature.XMLSignatureException
            r1.<init>((java.lang.String) r0, (java.lang.Object[]) r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.signature.XMLSignature.a(java.security.Key):boolean");
    }

    public final byte[] b() {
        try {
            return Base64.a(this.f72703f);
        } catch (Base64DecodingException e2) {
            throw new XMLSignatureException("empty", (Exception) e2);
        }
    }

    public final String e() {
        return PMConstants.SIGNATURE;
    }
}

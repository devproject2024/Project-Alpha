package org.apache.xml.security.utils.resolver.implementations;

import com.alipay.iap.android.webapp.sdk.provider.BaseJSApiPermissionProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;

public class ResolverDirectHTTP extends ResourceResolverSpi {

    /* renamed from: d  reason: collision with root package name */
    static Log f72810d;

    /* renamed from: e  reason: collision with root package name */
    static Class f72811e;

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f72812f = {"http.proxy.host", "http.proxy.port", "http.proxy.username", "http.proxy.password", "http.basic.username", "http.basic.password"};

    static {
        Class cls = f72811e;
        if (cls == null) {
            cls = c("org.apache.xml.security.utils.resolver.implementations.ResolverDirectHTTP");
            f72811e = cls;
        }
        f72810d = LogFactory.getLog(cls.getName());
    }

    private URI a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0188, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0189, code lost:
        r2 = r20;
        r3 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x018e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0198, code lost:
        throw new org.apache.xml.security.utils.resolver.ResourceResolverException("generic.EmptyMessage", (java.lang.Exception) r0, r20, r21);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018e A[ExcHandler: IOException (r0v2 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.xml.security.signature.XMLSignatureInput a(org.w3c.dom.Attr r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "generic.EmptyMessage"
            java.lang.String[] r0 = f72812f     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            r5 = 0
            r0 = r0[r5]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r0 = r1.a((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String[] r6 = f72812f     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r7 = 1
            r6 = r6[r7]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r6 = r1.a((java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r0 == 0) goto L_0x0020
            if (r6 == 0) goto L_0x0020
            r8 = 1
            goto L_0x0021
        L_0x0020:
            r8 = 0
        L_0x0021:
            java.lang.String r9 = ":"
            java.lang.String r10 = "http.proxyPort"
            java.lang.String r11 = "http.proxyHost"
            java.lang.String r12 = "http.proxySet"
            r13 = 0
            if (r8 == 0) goto L_0x0065
            org.apache.commons.logging.Log r14 = f72810d     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            boolean r14 = r14.isDebugEnabled()     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            if (r14 == 0) goto L_0x004d
            org.apache.commons.logging.Log r14 = f72810d     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.String r7 = "Use of HTTP proxy enabled: "
            r15.<init>(r7)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            r15.append(r0)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            r15.append(r9)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            r15.append(r6)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.String r7 = r15.toString()     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            r14.debug(r7)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
        L_0x004d:
            java.lang.String r7 = java.lang.System.getProperty(r12)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.String r14 = java.lang.System.getProperty(r11)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.String r15 = java.lang.System.getProperty(r10)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.String r5 = "true"
            java.lang.System.setProperty(r12, r5)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.System.setProperty(r11, r0)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            java.lang.System.setProperty(r10, r6)     // Catch:{ MalformedURLException -> 0x0199, IOException -> 0x018e }
            goto L_0x0068
        L_0x0065:
            r7 = r13
            r14 = r7
            r15 = r14
        L_0x0068:
            if (r7 == 0) goto L_0x0071
            if (r14 == 0) goto L_0x0071
            if (r15 == 0) goto L_0x0071
            r16 = 1
            goto L_0x0073
        L_0x0071:
            r16 = 0
        L_0x0073:
            java.lang.String r0 = r20.getNodeValue()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            org.apache.xml.utils.URI r0 = r1.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            org.apache.xml.utils.URI r5 = new org.apache.xml.utils.URI     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r5.setFragment(r13)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.net.URL r6 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r5 = r5.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6.<init>(r5)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.net.URLConnection r5 = r6.openConnection()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String[] r13 = f72812f     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r17 = 2
            r13 = r13[r17]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r13 = r1.a((java.lang.String) r13)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String[] r17 = f72812f     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r18 = 3
            r2 = r17[r18]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = r1.a((java.lang.String) r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r13 == 0) goto L_0x00cd
            if (r2 == 0) goto L_0x00cd
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.append(r13)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.append(r9)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.append(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = r3.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            byte[] r2 = r2.getBytes()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = org.apache.xml.security.utils.Base64.b((byte[]) r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r3 = "Proxy-Authorization"
            r5.setRequestProperty(r3, r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
        L_0x00cd:
            java.lang.String r2 = "WWW-Authenticate"
            java.lang.String r2 = r5.getHeaderField(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r2 == 0) goto L_0x0126
            java.lang.String r3 = "Basic"
            boolean r2 = r2.startsWith(r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r2 == 0) goto L_0x0126
            java.lang.String[] r2 = f72812f     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3 = 4
            r2 = r2[r3]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = r1.a((java.lang.String) r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String[] r3 = f72812f     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r13 = 5
            r3 = r3[r13]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r3 = r1.a((java.lang.String) r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r2 == 0) goto L_0x0126
            if (r3 == 0) goto L_0x0126
            java.net.URLConnection r5 = r6.openConnection()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6.<init>()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6.append(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6.append(r9)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6.append(r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = r6.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            byte[] r2 = r2.getBytes()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = org.apache.xml.security.utils.Base64.b((byte[]) r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r3 = "Authorization"
            java.lang.String r6 = "Basic "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r2 = r6.concat(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r5.setRequestProperty(r3, r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
        L_0x0126:
            java.lang.String r2 = "Content-Type"
            java.lang.String r2 = r5.getHeaderField(r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r9 = 0
        L_0x013a:
            int r13 = r3.read(r6)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r13 < 0) goto L_0x0148
            r1 = 0
            r5.write(r6, r1, r13)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            int r9 = r9 + r13
            r1 = r19
            goto L_0x013a
        L_0x0148:
            org.apache.commons.logging.Log r1 = f72810d     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r6 = "Fetched "
            r3.<init>(r6)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.append(r9)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r6 = " bytes from URI "
            r3.append(r6)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r6 = r0.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r3.append(r6)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r1.debug(r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            org.apache.xml.security.signature.XMLSignatureInput r1 = new org.apache.xml.security.signature.XMLSignatureInput     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            byte[] r3 = r5.toByteArray()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r1.<init>((byte[]) r3)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.String r0 = r0.toString()     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r1.b((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            r1.a((java.lang.String) r2)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            if (r8 == 0) goto L_0x0187
            if (r16 == 0) goto L_0x0187
            java.lang.System.setProperty(r12, r7)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.System.setProperty(r11, r14)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
            java.lang.System.setProperty(r10, r15)     // Catch:{ MalformedURLException -> 0x0188, IOException -> 0x018e }
        L_0x0187:
            return r1
        L_0x0188:
            r0 = move-exception
            r2 = r20
            r3 = r21
            goto L_0x019a
        L_0x018e:
            r0 = move-exception
            org.apache.xml.security.utils.resolver.ResourceResolverException r1 = new org.apache.xml.security.utils.resolver.ResourceResolverException
            r2 = r20
            r3 = r21
            r1.<init>((java.lang.String) r4, (java.lang.Exception) r0, (org.w3c.dom.Attr) r2, (java.lang.String) r3)
            throw r1
        L_0x0199:
            r0 = move-exception
        L_0x019a:
            org.apache.xml.security.utils.resolver.ResourceResolverException r1 = new org.apache.xml.security.utils.resolver.ResourceResolverException
            r1.<init>((java.lang.String) r4, (java.lang.Exception) r0, (org.w3c.dom.Attr) r2, (java.lang.String) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.resolver.implementations.ResolverDirectHTTP.a(org.w3c.dom.Attr, java.lang.String):org.apache.xml.security.signature.XMLSignatureInput");
    }

    public boolean a() {
        return true;
    }

    public boolean b(Attr attr, String str) {
        Log log;
        String str2;
        if (attr == null) {
            log = f72810d;
            str2 = "quick fail, uri == null";
        } else {
            String nodeValue = attr.getNodeValue();
            if (nodeValue.equals("") || nodeValue.charAt(0) == '#') {
                log = f72810d;
                str2 = "quick fail for empty URIs and local ones";
            } else {
                if (f72810d.isDebugEnabled()) {
                    f72810d.debug("I was asked whether I can resolve ".concat(String.valueOf(nodeValue)));
                }
                if (!nodeValue.startsWith(BaseJSApiPermissionProvider.PROTOCOL_HTTP) && (str == null || !str.startsWith(BaseJSApiPermissionProvider.PROTOCOL_HTTP))) {
                    if (f72810d.isDebugEnabled()) {
                        f72810d.debug("I state that I can't resolve ".concat(String.valueOf(nodeValue)));
                    }
                    return false;
                } else if (!f72810d.isDebugEnabled()) {
                    return true;
                } else {
                    f72810d.debug("I state that I can resolve ".concat(String.valueOf(nodeValue)));
                    return true;
                }
            }
        }
        log.debug(str2);
        return false;
    }
}

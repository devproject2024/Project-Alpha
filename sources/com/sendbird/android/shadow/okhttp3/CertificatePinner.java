package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okio.ByteString;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<a> pins;

    CertificatePinner(Set<a> set, CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        if (!Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) || !this.pins.equals(certificatePinner.pins)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        return ((certificateChainCleaner2 != null ? certificateChainCleaner2.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    public final void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<a> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = findMatchingPins.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    a aVar = findMatchingPins.get(i3);
                    if (aVar.f45020c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = sha256(x509Certificate);
                        }
                        if (aVar.f45021d.equals(byteString)) {
                            return;
                        }
                    } else if (aVar.f45020c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = sha1(x509Certificate);
                        }
                        if (aVar.f45021d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + aVar.f45020c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(AppConstants.COLON);
            int size4 = findMatchingPins.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(findMatchingPins.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        if (r14.regionMatches(false, r3 + 1, r2.f45019b, 0, r2.f45019b.length()) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.sendbird.android.shadow.okhttp3.CertificatePinner.a> findMatchingPins(java.lang.String r14) {
        /*
            r13 = this;
            java.util.List r0 = java.util.Collections.emptyList()
            java.util.Set<com.sendbird.android.shadow.okhttp3.CertificatePinner$a> r1 = r13.pins
            java.util.Iterator r1 = r1.iterator()
        L_0x000a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r1.next()
            com.sendbird.android.shadow.okhttp3.CertificatePinner$a r2 = (com.sendbird.android.shadow.okhttp3.CertificatePinner.a) r2
            java.lang.String r3 = r2.f45018a
            java.lang.String r4 = "*."
            boolean r3 = r3.startsWith(r4)
            r4 = 1
            if (r3 == 0) goto L_0x004b
            r3 = 46
            int r3 = r14.indexOf(r3)
            int r5 = r14.length()
            int r5 = r5 - r3
            int r5 = r5 - r4
            java.lang.String r6 = r2.f45019b
            int r6 = r6.length()
            if (r5 != r6) goto L_0x0049
            r8 = 0
            int r9 = r3 + 1
            java.lang.String r10 = r2.f45019b
            r11 = 0
            java.lang.String r3 = r2.f45019b
            int r12 = r3.length()
            r7 = r14
            boolean r3 = r7.regionMatches(r8, r9, r10, r11, r12)
            if (r3 == 0) goto L_0x0049
            goto L_0x0051
        L_0x0049:
            r4 = 0
            goto L_0x0051
        L_0x004b:
            java.lang.String r3 = r2.f45019b
            boolean r4 = r14.equals(r3)
        L_0x0051:
            if (r4 == 0) goto L_0x000a
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x005e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x005e:
            r0.add(r2)
            goto L_0x000a
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.CertificatePinner.findMatchingPins(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner2) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + sha256((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f45018a;

        /* renamed from: b  reason: collision with root package name */
        final String f45019b;

        /* renamed from: c  reason: collision with root package name */
        final String f45020c;

        /* renamed from: d  reason: collision with root package name */
        final ByteString f45021d;

        a(String str, String str2) {
            String str3;
            this.f45018a = str;
            if (str.startsWith("*.")) {
                str3 = HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                str3 = HttpUrl.get("http://".concat(String.valueOf(str))).host();
            }
            this.f45019b = str3;
            if (str2.startsWith("sha1/")) {
                this.f45020c = "sha1/";
                this.f45021d = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.f45020c = "sha256/";
                this.f45021d = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(String.valueOf(str2)));
            }
            if (this.f45021d == null) {
                throw new IllegalArgumentException("pins must be base64: ".concat(String.valueOf(str2)));
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f45018a.equals(aVar.f45018a) && this.f45020c.equals(aVar.f45020c) && this.f45021d.equals(aVar.f45021d);
        }

        public final int hashCode() {
            return ((((this.f45018a.hashCode() + 527) * 31) + this.f45020c.hashCode()) * 31) + this.f45021d.hashCode();
        }

        public final String toString() {
            return this.f45020c + this.f45021d.base64();
        }
    }

    public static final class Builder {
        private final List<a> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            if (str != null) {
                for (String aVar : strArr) {
                    this.pins.add(new a(str, aVar));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public final CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), (CertificateChainCleaner) null);
        }
    }
}

package com.squareup.okhttp;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.okhttp.internal.Util;
import i.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final Map<String, Set<f>> hostnameToPins;

    private CertificatePinner(Builder builder) {
        this.hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    public final void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Set<f> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (!findMatchingPins.contains(sha1((X509Certificate) list.get(i2)))) {
                    i2++;
                } else {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(pin(x509Certificate));
                sb.append(": ");
                sb.append(x509Certificate.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(AppConstants.COLON);
            for (f base64 : findMatchingPins) {
                sb.append("\n    sha1/");
                sb.append(base64.base64());
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    public final Set<f> findMatchingPins(String str) {
        Set<f> set;
        Set<f> set2 = this.hostnameToPins.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            set = this.hostnameToPins.get("*." + str.substring(indexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 == null || set == null) {
            return set2 != null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set2);
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + sha1((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static f sha1(X509Certificate x509Certificate) {
        return Util.sha1(f.of(x509Certificate.getPublicKey().getEncoded()));
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public final Map<String, Set<f>> hostnameToPins = new LinkedHashMap();

        public final Builder add(String str, String... strArr) {
            if (str != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Set put = this.hostnameToPins.put(str, Collections.unmodifiableSet(linkedHashSet));
                if (put != null) {
                    linkedHashSet.addAll(put);
                }
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str2 = strArr[i2];
                    if (str2.startsWith("sha1/")) {
                        f decodeBase64 = f.decodeBase64(str2.substring(5));
                        if (decodeBase64 != null) {
                            linkedHashSet.add(decodeBase64);
                            i2++;
                        } else {
                            throw new IllegalArgumentException("pins must be base64: ".concat(String.valueOf(str2)));
                        }
                    } else {
                        throw new IllegalArgumentException("pins must start with 'sha1/': ".concat(String.valueOf(str2)));
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("hostname == null");
        }

        public final CertificatePinner build() {
            return new CertificatePinner(this);
        }
    }
}

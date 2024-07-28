package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    /* access modifiers changed from: private */
    public final String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;
    /* access modifiers changed from: private */
    public final String[] tlsVersions;

    private ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public final boolean isTls() {
        return this.tls;
    }

    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuites;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i2 = 0;
        while (true) {
            String[] strArr2 = this.cipherSuites;
            if (i2 >= strArr2.length) {
                return Util.immutableList((T[]) cipherSuiteArr);
            }
            cipherSuiteArr[i2] = CipherSuite.forJavaName(strArr2[i2]);
            i2++;
        }
    }

    public final List<TlsVersion> tlsVersions() {
        TlsVersion[] tlsVersionArr = new TlsVersion[this.tlsVersions.length];
        int i2 = 0;
        while (true) {
            String[] strArr = this.tlsVersions;
            if (i2 >= strArr.length) {
                return Util.immutableList((T[]) tlsVersionArr);
            }
            tlsVersionArr[i2] = TlsVersion.forJavaName(strArr[i2]);
            i2++;
        }
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    /* access modifiers changed from: package-private */
    public final void apply(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z);
        sSLSocket.setEnabledProtocols(supportedSpec.tlsVersions);
        String[] strArr = supportedSpec.cipherSuites;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    private ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.cipherSuites != null) {
            strArr = (String[]) Util.intersect(String.class, this.cipherSuites, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        if (!z || !Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            strArr2 = strArr;
        } else {
            if (strArr == null) {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            strArr2 = new String[(strArr.length + 1)];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr2.length - 1] = "TLS_FALLBACK_SCSV";
        }
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        return new Builder(this).cipherSuites(strArr2).tlsVersions((String[]) Util.intersect(String.class, this.tlsVersions, enabledProtocols)).build();
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.tls) {
            return false;
        }
        if (!nonEmptyIntersection(this.tlsVersions, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.cipherSuites != null) {
            return nonEmptyIntersection(this.cipherSuites, sSLSocket.getEnabledCipherSuites());
        } else if (sSLSocket.getEnabledCipherSuites().length > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean nonEmptyIntersection(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String contains : strArr) {
                if (contains(strArr2, contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static <T> boolean contains(T[] tArr, T t) {
        for (T equal : tArr) {
            if (Util.equal(t, equal)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.tls;
        if (z != connectionSpec.tls) {
            return false;
        }
        return !z || (Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public final int hashCode() {
        if (this.tls) {
            return ((((Arrays.hashCode(this.cipherSuites) + 527) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (this.supportsTlsExtensions ^ true ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        List<CipherSuite> cipherSuites2 = cipherSuites();
        if (cipherSuites2 == null) {
            str = "[use default]";
        } else {
            str = cipherSuites2.toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + tlsVersions() + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] cipherSuites;
        /* access modifiers changed from: private */
        public boolean supportsTlsExtensions;
        /* access modifiers changed from: private */
        public boolean tls;
        /* access modifiers changed from: private */
        public String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public final Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i2 = 0; i2 < cipherSuiteArr.length; i2++) {
                    strArr[i2] = cipherSuiteArr[i2].javaName;
                }
                this.cipherSuites = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final Builder cipherSuites(String... strArr) {
            if (this.tls) {
                if (strArr == null) {
                    this.cipherSuites = null;
                } else {
                    this.cipherSuites = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (tlsVersionArr.length != 0) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i2 = 0; i2 < tlsVersionArr.length; i2++) {
                    strArr[i2] = tlsVersionArr[i2].javaName;
                }
                this.tlsVersions = strArr;
                return this;
            } else {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
        }

        public final Builder tlsVersions(String... strArr) {
            if (this.tls) {
                if (strArr == null) {
                    this.tlsVersions = null;
                } else {
                    this.tlsVersions = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}

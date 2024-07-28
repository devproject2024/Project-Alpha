package com.alipay.mobile.nebulacore.android;

import android.net.http.SslCertificate;
import android.net.http.SslError;

class AndroidSslError extends SslError {
    private SslError sslError;

    public String getUrl() {
        return null;
    }

    AndroidSslError(int i2, SslCertificate sslCertificate, SslError sslError2) {
        super(i2, sslCertificate);
        if (sslError2 == null) {
            this.sslError = new NullSslError(i2, sslCertificate);
        } else {
            this.sslError = sslError2;
        }
    }

    public SslCertificate getCertificate() {
        return this.sslError.getCertificate();
    }

    public boolean addError(int i2) {
        SslError sslError2 = this.sslError;
        return sslError2 != null && sslError2.addError(i2);
    }

    public boolean hasError(int i2) {
        return this.sslError.hasError(i2);
    }

    public int getPrimaryError() {
        return this.sslError.getPrimaryError();
    }

    class NullSslError extends SslError {
        public boolean addError(int i2) {
            return false;
        }

        public String getUrl() {
            return null;
        }

        public boolean hasError(int i2) {
            return false;
        }

        public String toString() {
            return "Null SslError instance";
        }

        public NullSslError(int i2, SslCertificate sslCertificate) {
            super(i2, sslCertificate);
        }

        public int getPrimaryError() {
            return super.getPrimaryError();
        }
    }
}

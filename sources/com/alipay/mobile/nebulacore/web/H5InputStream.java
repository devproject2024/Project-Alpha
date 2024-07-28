package com.alipay.mobile.nebulacore.web;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5FallbackStreamProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class H5InputStream extends InputStream {
    public static final String TAG = "H5InputStream";
    private HttpURLConnection conn;
    private H5InputListener listener;
    public InputStream realStream;
    public int statusCode;
    private String urlString;
    private boolean useNetsdk = true;

    public interface H5InputListener {
        void onInputClose(H5InputStream h5InputStream);

        void onInputException();

        void onInputOpen(H5InputStream h5InputStream);
    }

    public H5InputStream(String str, H5InputListener h5InputListener) {
        this.urlString = str;
        this.listener = h5InputListener;
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("androidFallbackNetwork");
        if (!TextUtils.isEmpty(configWithProcessCache)) {
            if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(configWithProcessCache)) {
                this.useNetsdk = true;
            } else if (H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(configWithProcessCache)) {
                this.useNetsdk = false;
            }
        }
        this.realStream = initStream();
    }

    public int read() throws IOException {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }

    public int available() throws IOException {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            return inputStream.available();
        }
        return super.available();
    }

    public void close() throws IOException {
        H5Log.d(TAG, "close ".concat(String.valueOf(this)));
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            inputStream.close();
        } else {
            super.close();
        }
        HttpURLConnection httpURLConnection = this.conn;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.conn = null;
        H5InputListener h5InputListener = this.listener;
        if (h5InputListener != null) {
            h5InputListener.onInputClose(this);
        }
    }

    public void mark(int i2) {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            inputStream.mark(i2);
        } else {
            super.mark(i2);
        }
    }

    public boolean markSupported() {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return super.markSupported();
    }

    public synchronized void reset() throws IOException {
        if (this.realStream != null) {
            this.realStream.reset();
        } else {
            super.reset();
        }
    }

    public long skip(long j) throws IOException {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return super.skip(j);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InputStream inputStream = this.realStream;
        if (inputStream != null) {
            return inputStream.read(bArr, i2, i3);
        }
        return super.read(bArr, i2, i3);
    }

    private InputStream initStream() {
        BufferedInputStream bufferedInputStream = null;
        try {
            H5FallbackStreamProvider h5FallbackStreamProvider = (H5FallbackStreamProvider) H5Utils.getProvider(H5FallbackStreamProvider.class.getName());
            if (!this.useNetsdk || h5FallbackStreamProvider == null) {
                H5Log.d(TAG, "useUrlConnection get fallback content");
                this.conn = (HttpURLConnection) new URL(this.urlString).openConnection();
                this.statusCode = this.conn.getResponseCode();
                H5Log.d(TAG, "statusCode " + this.statusCode);
                bufferedInputStream = new BufferedInputStream(this.conn.getInputStream());
            } else {
                H5Log.d(TAG, "useNetsdk get fallback content");
                bufferedInputStream = new BufferedInputStream(h5FallbackStreamProvider.getFallbackInputStream(this.urlString));
            }
            if (this.listener != null) {
                this.listener.onInputOpen(this);
            }
        } catch (Exception e2) {
            H5Log.e(TAG, this.urlString + " failed to init stream ", e2);
            H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log("H5_FallbackException", (String) null, (String) null, (String) null, "fallback request failed," + this.urlString + " failed to init stream " + e2);
            }
            H5InputListener h5InputListener = this.listener;
            if (h5InputListener != null) {
                h5InputListener.onInputException();
            }
        }
        return bufferedInputStream;
    }
}

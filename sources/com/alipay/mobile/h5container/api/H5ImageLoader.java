package com.alipay.mobile.h5container.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.net.URL;
import java.net.URLConnection;

public class H5ImageLoader implements Runnable {
    public static final String TAG = "H5ImageLoader";
    private static final int TIMEOUT = 10000;
    /* access modifiers changed from: private */
    public H5ImageListener listener;
    private String url;

    public H5ImageLoader(String str, H5ImageListener h5ImageListener) {
        this.url = str;
        this.listener = h5ImageListener;
    }

    public void run() {
        if (this.listener != null && !TextUtils.isEmpty(this.url)) {
            H5Log.d(TAG, "load image " + this.url);
            try {
                URLConnection openConnection = new URL(this.url).openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                H5Log.d(TAG, "load image length " + openConnection.getContentLength());
                final Bitmap decodeStream = BitmapFactory.decodeStream(openConnection.getInputStream());
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        H5Log.d(H5ImageLoader.TAG, "listener.onImage");
                        H5ImageLoader.this.listener.onImage(decodeStream);
                    }
                });
            } catch (Throwable th) {
                H5Log.e(TAG, "load image exception.", th);
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        if (H5ImageLoader.this.listener != null) {
                            H5ImageLoader.this.listener.onImage((Bitmap) null);
                        }
                    }
                });
            }
        }
    }
}

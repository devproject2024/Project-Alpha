package com.paytm.network.b;

import com.android.volley.toolbox.ImageLoader;
import com.paytm.network.f;

public enum h {
    INSTANCE;
    
    private a mBitmapMemoryCache;
    private ImageLoader mImageLoader;

    public final void initImageCache() {
        this.mBitmapMemoryCache = new a(getCacheSize());
        this.mImageLoader = new ImageLoader(f.a(), this.mBitmapMemoryCache);
    }

    public final ImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    private int getCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
    }

    public final void evictAll() {
        a aVar = this.mBitmapMemoryCache;
        if (aVar != null) {
            aVar.evictAll();
        }
    }

    public final void remove(String str, int i2, int i3) {
        a aVar = this.mBitmapMemoryCache;
        if (aVar != null) {
            aVar.remove(getCacheKey(str, i2, i3));
        }
    }

    private static String getCacheKey(String str, int i2, int i3) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i2);
        sb.append("#H");
        sb.append(i3);
        sb.append(str);
        return sb.toString();
    }
}

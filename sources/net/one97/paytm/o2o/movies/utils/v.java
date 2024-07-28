package net.one97.paytm.o2o.movies.utils;

import com.android.volley.toolbox.ImageLoader;
import java.util.HashMap;
import java.util.Map;

public enum v {
    INSTANCE;
    
    private ImageLoader mImageLoader;
    /* access modifiers changed from: private */
    public final HashMap<String, Map<String, String>> mRequestHeaders;

    public final void loadImage(String str, ImageLoader.ImageListener imageListener) {
        loadImage$default(this, str, imageListener, (Map) null, 4, (Object) null);
    }

    public final void loadImage(String str, ImageLoader.ImageListener imageListener, int i2, int i3) {
        loadImage$default(this, str, imageListener, i2, i3, (Map) null, 16, (Object) null);
    }

    public final ImageLoader getMImageLoader() {
        return this.mImageLoader;
    }

    public final void loadImage(String str, ImageLoader.ImageListener imageListener, Map<String, String> map) {
        if (str != null && imageListener != null) {
            if (map != null) {
                this.mRequestHeaders.put(str, map);
            }
            ImageLoader imageLoader = this.mImageLoader;
            if (imageLoader != null) {
                imageLoader.get(str, imageListener);
            }
        }
    }

    public final void loadImage(String str, ImageLoader.ImageListener imageListener, int i2, int i3, Map<String, String> map) {
        if (str != null && imageListener != null) {
            if (map != null) {
                this.mRequestHeaders.put(str, map);
            }
            ImageLoader imageLoader = this.mImageLoader;
            if (imageLoader != null) {
                imageLoader.get(str, imageListener, i2, i3);
            }
        }
    }

    private final int getCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
    }
}

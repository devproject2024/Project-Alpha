package net.one97.paytm.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.paytm.network.f;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.utils.ai;

public enum ai {
    INSTANCE;
    
    private h mBitmapMemoryCache;
    private ImageLoader mImageLoader;

    public final void initImageCache() {
        try {
            this.mBitmapMemoryCache = new h(getCacheSize());
            this.mImageLoader = new ImageLoader(f.a(), this.mBitmapMemoryCache) {
                /* access modifiers changed from: private */
                public /* synthetic */ void a(String str, Bitmap bitmap) {
                    onGetImageSuccess(str, bitmap);
                }

                public final Request<Bitmap> makeImageRequest(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2) {
                    return new ImageRequest(str, new Response.Listener(str2) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onResponse(Object obj) {
                            ai.AnonymousClass1.this.a(this.f$1, (Bitmap) obj);
                        }
                    }, i2, i3, Bitmap.Config.RGB_565, new Response.ErrorListener(str2) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            ai.AnonymousClass1.this.a(this.f$1, volleyError);
                        }
                    }) {
                        public final Map<String, String> getHeaders() {
                            HashMap hashMap = new HashMap();
                            hashMap.put("ClientId", "paytm");
                            return hashMap;
                        }
                    };
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a(String str, VolleyError volleyError) {
                    onGetImageError(str, volleyError);
                }
            };
        } catch (IllegalStateException e2) {
            q.b(e2.getMessage());
        }
    }

    public final ImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public final Bitmap getBitmap(String str) {
        return this.mBitmapMemoryCache.getBitmap(str);
    }

    private int getCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
    }

    public final void evictAll() {
        h hVar = this.mBitmapMemoryCache;
        if (hVar != null) {
            hVar.evictAll();
        }
    }

    public final void remove(String str, int i2, int i3) {
        h hVar = this.mBitmapMemoryCache;
        if (hVar != null) {
            hVar.remove(getCacheKey(str, i2, i3));
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

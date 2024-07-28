package net.one97.paytm.widget;

import android.content.Context;
import android.os.AsyncTask;
import com.android.volley.Cache;
import com.android.volley.toolbox.DiskBasedCache;
import com.paytm.utility.q;
import java.io.File;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    Cache f72435a;

    public i(final Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                synchronized (i.this) {
                    File file = new File(context.getCacheDir().getPath() + File.separator + "paytm-webview-cache");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    i.this.f72435a = new DiskBasedCache(file, 5242880);
                    i.this.f72435a.initialize();
                    i.this.notifyAll();
                }
            }
        });
    }

    private void a() {
        synchronized (this) {
            if (this.f72435a == null) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public final void a(String str, byte[] bArr, String str2) {
        a();
        if (this.f72435a != null) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = str2;
            this.f72435a.put(str, entry);
        }
    }

    public final Cache.Entry a(String str) {
        a();
        Cache cache = this.f72435a;
        if (cache != null) {
            return cache.get(str);
        }
        return null;
    }
}

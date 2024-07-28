package com.bumptech.glide.load.b.b;

import android.content.Context;
import com.bumptech.glide.load.b.b.d;
import java.io.File;

public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache");
    }

    private f(final Context context, final String str) {
        super(new d.a() {
            public final File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str = str;
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        });
    }
}

package net.one97.paytm.appManager.storage.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;

public abstract class AppManagerDb extends j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile AppManagerDb f49055a;

    public abstract a a();

    public static AppManagerDb a(Context context) {
        Class<AppManagerDb> cls = AppManagerDb.class;
        if (f49055a == null) {
            synchronized (cls) {
                if (f49055a == null) {
                    f49055a = i.a(context.getApplicationContext(), cls, "appManagerDB").a().c();
                }
            }
        }
        return f49055a;
    }
}

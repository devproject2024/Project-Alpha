package com.paytm.erroranalytics.data.datasource.dao.sqlite;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import com.paytm.erroranalytics.data.datasource.dao.a;

public abstract class AppDataBase extends j {

    /* renamed from: a  reason: collision with root package name */
    private static AppDataBase f42801a;

    public abstract a a();

    public static synchronized AppDataBase a(Context context) {
        AppDataBase appDataBase;
        Class<AppDataBase> cls = AppDataBase.class;
        synchronized (cls) {
            if (f42801a == null) {
                f42801a = i.a(context.getApplicationContext(), cls, "paytm_error_analytics").c();
            }
            appDataBase = f42801a;
        }
        return appDataBase;
    }
}

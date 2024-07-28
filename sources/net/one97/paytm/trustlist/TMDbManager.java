package net.one97.paytm.trustlist;

import android.database.sqlite.SQLiteOpenHelper;
import net.one97.paytm.app.CJRJarvisApplication;

public class TMDbManager {

    /* renamed from: b  reason: collision with root package name */
    private static TMDbManager f65168b;

    /* renamed from: a  reason: collision with root package name */
    SQLiteOpenHelper f65169a = new TrustManagerDb(CJRJarvisApplication.getAppContext());

    private TMDbManager() {
    }

    public static TMDbManager a() {
        if (f65168b == null) {
            f65168b = new TMDbManager();
        }
        return f65168b;
    }
}

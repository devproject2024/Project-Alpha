package com.google.androidbrowserhelper.trusted.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import androidx.browser.customtabs.f;
import androidx.browser.customtabs.h;
import java.io.File;
import java.io.FileOutputStream;

public class b {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f37640c = (!b.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public a f37641a;

    /* renamed from: b  reason: collision with root package name */
    public final AsyncTask<Void, Void, Boolean> f37642b = new AsyncTask<Void, Void, Boolean>() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            if (b.this.f37641a != null && !isCancelled()) {
                b.this.f37641a.onFinished(bool.booleanValue());
            }
        }

        private Boolean a() {
            FileOutputStream fileOutputStream;
            if (isCancelled()) {
                return Boolean.FALSE;
            }
            File file = new File(b.this.f37643d.getFilesDir(), "twa_splash");
            if (!file.exists() && !file.mkdir()) {
                return Boolean.FALSE;
            }
            File file2 = new File(file, "splash_image.png");
            SharedPreferences sharedPreferences = b.this.f37643d.getSharedPreferences("splashImagePrefs", 0);
            long b2 = b();
            if (file2.exists() && b2 == sharedPreferences.getLong("lastUpdateTime", 0)) {
                return Boolean.valueOf(a(file2));
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
                if (isCancelled()) {
                    Boolean bool = Boolean.FALSE;
                    fileOutputStream.close();
                    return bool;
                }
                b.this.f37644e.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                sharedPreferences.edit().putLong("lastUpdateTime", b2).commit();
                if (isCancelled()) {
                    Boolean bool2 = Boolean.FALSE;
                    fileOutputStream.close();
                    return bool2;
                }
                Boolean valueOf = Boolean.valueOf(a(file2));
                fileOutputStream.close();
                return valueOf;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        private boolean a(File file) {
            return h.a(b.this.f37643d, file, b.this.f37645f, b.this.f37647h, b.this.f37646g);
        }

        private long b() {
            try {
                return b.this.f37643d.getPackageManager().getPackageInfo(b.this.f37643d.getPackageName(), 0).lastUpdateTime;
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f37643d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f37644e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f37645f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final f f37646g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f37647h;

    public interface a {
        void onFinished(boolean z);
    }

    public b(Context context, Bitmap bitmap, String str, f fVar, String str2) {
        this.f37643d = context.getApplicationContext();
        this.f37644e = bitmap;
        this.f37645f = str;
        this.f37646g = fVar;
        this.f37647h = str2;
    }
}

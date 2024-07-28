package com.google.zxing.client.android;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.google.zxing.a;
import com.google.zxing.e;
import com.google.zxing.u;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final CaptureActivity f40227a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<e, Object> f40228b = new EnumMap(e.class);

    /* renamed from: c  reason: collision with root package name */
    private Handler f40229c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f40230d = new CountDownLatch(1);

    public h(CaptureActivity captureActivity, Collection<a> collection, Map<e, ?> map, String str, u uVar) {
        this.f40227a = captureActivity;
        if (map != null) {
            this.f40228b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(e.f40193a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(e.f40194b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(e.f40195c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(e.f40196d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(e.f40197e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(e.f40198f);
            }
        }
        this.f40228b.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f40228b.put(e.CHARACTER_SET, str);
        }
        this.f40228b.put(e.NEED_RESULT_POINT_CALLBACK, uVar);
        new StringBuilder("Hints: ").append(this.f40228b);
    }

    public final Handler a() {
        try {
            this.f40230d.await();
        } catch (InterruptedException unused) {
        }
        return this.f40229c;
    }

    public final void run() {
        Looper.prepare();
        this.f40229c = new f(this.f40227a, this.f40228b);
        this.f40230d.countDown();
        Looper.loop();
    }
}

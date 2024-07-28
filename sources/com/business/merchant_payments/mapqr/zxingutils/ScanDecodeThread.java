package com.business.merchant_payments.mapqr.zxingutils;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.zxingutils.f;
import com.business.merchant_payments.mapqr.view.ScanActivityZxing;
import com.google.zxing.a;
import com.google.zxing.e;
import com.google.zxing.u;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class ScanDecodeThread extends Thread {
    public static final String BARCODE_BITMAP = "barcode_bitmap";
    public static final String BARCODE_SCALED_FACTOR = "barcode_scaled_factor";
    public final ScanActivityZxing fragment;
    public Handler handler;
    public final CountDownLatch handlerInitLatch = new CountDownLatch(1);
    public final Map<e, Object> hints;

    public ScanDecodeThread(ScanActivityZxing scanActivityZxing, Collection<a> collection, Map<e, ?> map, String str, u uVar) {
        this.fragment = scanActivityZxing;
        EnumMap enumMap = new EnumMap(e.class);
        this.hints = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(scanActivityZxing);
            collection = EnumSet.noneOf(a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(f.f7418a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(f.f7419b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(f.f7420c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(f.f7421d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(f.f7422e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(f.f7423f);
            }
        }
        this.hints.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.hints.put(e.CHARACTER_SET, str);
        }
        this.hints.put(e.NEED_RESULT_POINT_CALLBACK, uVar);
        LogUtility.i("DecodeThread", "Hints: " + this.hints);
    }

    public final Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (InterruptedException unused) {
        }
        return this.handler;
    }

    public final void run() {
        Looper.prepare();
        this.handler = new ScanDecodeHandler(this.fragment, this.hints);
        this.handlerInitLatch.countDown();
        Looper.loop();
    }
}

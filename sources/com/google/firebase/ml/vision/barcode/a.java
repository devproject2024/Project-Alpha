package com.google.firebase.ml.vision.barcode;

import android.util.SparseArray;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.bg;
import com.google.firebase.ml.vision.barcode.internal.e;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray<bg.n.a> f39110a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<bg.n.b> f39111b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final e f39112c;

    public a(e eVar) {
        this.f39112c = (e) s.a(eVar);
    }

    public final String a() {
        return this.f39112c.a();
    }

    static {
        f39110a.put(-1, bg.n.a.FORMAT_UNKNOWN);
        f39110a.put(1, bg.n.a.FORMAT_CODE_128);
        f39110a.put(2, bg.n.a.FORMAT_CODE_39);
        f39110a.put(4, bg.n.a.FORMAT_CODE_93);
        f39110a.put(8, bg.n.a.FORMAT_CODABAR);
        f39110a.put(16, bg.n.a.FORMAT_DATA_MATRIX);
        f39110a.put(32, bg.n.a.FORMAT_EAN_13);
        f39110a.put(64, bg.n.a.FORMAT_EAN_8);
        f39110a.put(128, bg.n.a.FORMAT_ITF);
        f39110a.put(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, bg.n.a.FORMAT_QR_CODE);
        f39110a.put(512, bg.n.a.FORMAT_UPC_A);
        f39110a.put(TarConstants.EOF_BLOCK, bg.n.a.FORMAT_UPC_E);
        f39110a.put(EmiUtil.EMI_PLAN_REQUEST_CODE, bg.n.a.FORMAT_PDF417);
        f39110a.put(4096, bg.n.a.FORMAT_AZTEC);
        f39111b.put(0, bg.n.b.TYPE_UNKNOWN);
        f39111b.put(1, bg.n.b.TYPE_CONTACT_INFO);
        f39111b.put(2, bg.n.b.TYPE_EMAIL);
        f39111b.put(3, bg.n.b.TYPE_ISBN);
        f39111b.put(4, bg.n.b.TYPE_PHONE);
        f39111b.put(5, bg.n.b.TYPE_PRODUCT);
        f39111b.put(6, bg.n.b.TYPE_SMS);
        f39111b.put(7, bg.n.b.TYPE_TEXT);
        f39111b.put(8, bg.n.b.TYPE_URL);
        f39111b.put(9, bg.n.b.TYPE_WIFI);
        f39111b.put(10, bg.n.b.TYPE_GEO);
        f39111b.put(11, bg.n.b.TYPE_CALENDAR_EVENT);
        f39111b.put(12, bg.n.b.TYPE_DRIVER_LICENSE);
    }
}

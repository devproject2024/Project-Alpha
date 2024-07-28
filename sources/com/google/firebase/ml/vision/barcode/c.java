package com.google.firebase.ml.vision.barcode;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.internal.firebase_ml.ep;
import com.google.android.gms.internal.firebase_ml.ex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, ex> f39114b;

    /* renamed from: a  reason: collision with root package name */
    public final int f39115a;

    private c(int i2) {
        this.f39115a = i2;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f39116a = 0;

        public final a a(int... iArr) {
            this.f39116a = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
            for (int i2 = 0; i2 <= 0; i2++) {
                this.f39116a = iArr[0] | this.f39116a;
            }
            return this;
        }

        public final c a() {
            return new c(this.f39116a, (byte) 0);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof c) && this.f39115a == ((c) obj).f39115a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f39115a)});
    }

    public final ep.a a() {
        ArrayList arrayList = new ArrayList();
        if (this.f39115a == 0) {
            arrayList.addAll(f39114b.values());
        } else {
            for (Map.Entry next : f39114b.entrySet()) {
                if ((this.f39115a & ((Integer) next.getKey()).intValue()) != 0) {
                    arrayList.add((ex) next.getValue());
                }
            }
        }
        return (ep.a) ep.a.a().a(arrayList).i();
    }

    /* synthetic */ c(int i2, byte b2) {
        this(i2);
    }

    static {
        HashMap hashMap = new HashMap();
        f39114b = hashMap;
        hashMap.put(1, ex.CODE_128);
        f39114b.put(2, ex.CODE_39);
        f39114b.put(4, ex.CODE_93);
        f39114b.put(8, ex.CODABAR);
        f39114b.put(16, ex.DATA_MATRIX);
        f39114b.put(32, ex.EAN_13);
        f39114b.put(64, ex.EAN_8);
        f39114b.put(128, ex.ITF);
        f39114b.put(Integer.valueOf(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS), ex.QR_CODE);
        f39114b.put(512, ex.UPC_A);
        f39114b.put(Integer.valueOf(TarConstants.EOF_BLOCK), ex.UPC_E);
        f39114b.put(Integer.valueOf(EmiUtil.EMI_PLAN_REQUEST_CODE), ex.PDF417);
        f39114b.put(4096, ex.AZTEC);
    }
}

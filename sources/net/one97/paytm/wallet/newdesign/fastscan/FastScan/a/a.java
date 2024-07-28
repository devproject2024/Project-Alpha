package net.one97.paytm.wallet.newdesign.fastscan.FastScan.a;

import android.os.Bundle;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f70879a = new a();

    private a() {
    }

    public static net.one97.paytm.wallet.newdesign.fastscan.a a(boolean z, boolean z2, boolean z3, boolean z4) {
        return a(z, z2, z3, z4, (String) null, (Boolean) null, (Boolean) null);
    }

    public static net.one97.paytm.wallet.newdesign.fastscan.a a(boolean z, boolean z2, boolean z3, boolean z4, String str, Boolean bool, Boolean bool2) {
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.a aVar = new net.one97.paytm.wallet.newdesign.fastscan.FastScan.a();
        Bundle bundle = new Bundle();
        bundle.putBoolean(UpiConstants.KEY_IS_SCAN_ONLY, z);
        bundle.putBoolean("read_text", z3);
        bundle.putBoolean("barcode_only", z2);
        if (bool2 != null) {
            bool2.booleanValue();
            bundle.putBoolean("is_from_login", bool2.booleanValue());
        }
        if (bool != null) {
            bool.booleanValue();
            bundle.putBoolean("isShowInvoke", bool.booleanValue());
        }
        if (str != null) {
            bundle.putString("qrCodeId", str);
        }
        bundle.putBoolean("isFromMiddleScan", z4);
        aVar.setArguments(bundle);
        return aVar;
    }
}

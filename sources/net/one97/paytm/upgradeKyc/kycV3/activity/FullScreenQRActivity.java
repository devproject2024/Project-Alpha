package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.view.View;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;

public final class FullScreenQRActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f66106a;

    public final View a(int i2) {
        if (this.f66106a == null) {
            this.f66106a = new HashMap();
        }
        View view = (View) this.f66106a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66106a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int a() {
        return R.layout.full_screen_qr_activity;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = r4.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            android.content.Intent r4 = r3.getIntent()
            if (r4 == 0) goto L_0x0016
            android.os.Bundle r4 = r4.getExtras()
            if (r4 == 0) goto L_0x0016
            java.lang.String r0 = "qrCode"
            java.lang.String r4 = r4.getString(r0)
            goto L_0x0017
        L_0x0016:
            r4 = 0
        L_0x0017:
            if (r4 != 0) goto L_0x001c
            kotlin.g.b.k.a()
        L_0x001c:
            int r0 = net.one97.paytm.upgradeKyc.R.id.qr_code
            android.view.View r0 = r3.a(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = 0
            r2 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r4 = com.google.zxing.client.android.d.a.a(r4, r2, r2, r1)
            r0.setImageBitmap(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.activity.FullScreenQRActivity.onCreate(android.os.Bundle):void");
    }
}

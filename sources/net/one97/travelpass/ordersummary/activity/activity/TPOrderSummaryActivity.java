package net.one97.travelpass.ordersummary.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.travelpass.R;
import net.one97.travelpass.b.ai;
import net.one97.travelpass.ordersummary.c.a;

public final class TPOrderSummaryActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private ai f30494a;

    /* renamed from: b  reason: collision with root package name */
    private String f30495b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f30496c = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    private CJRParcelTrackingInfo f30497d;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f30494a = (ai) f.a(this, R.layout.travel_pass_order_summary);
        Intent intent = getIntent();
        this.f30495b = intent != null ? intent.getStringExtra("order_id") : null;
        Intent intent2 = getIntent();
        boolean z = false;
        this.f30496c = intent2 != null ? Boolean.valueOf(intent2.getBooleanExtra(AppConstants.IS_CANCEL, false)) : null;
        Intent intent3 = getIntent();
        this.f30497d = intent3 != null ? (CJRParcelTrackingInfo) intent3.getParcelableExtra("tracking_info") : null;
        Intent intent4 = getIntent();
        k.a((Object) intent4, "intent");
        Serializable serializableExtra = intent4.getSerializableExtra("extra_home_data");
        if (!(serializableExtra instanceof CJRItem)) {
            serializableExtra = null;
        }
        CJRItem cJRItem = (CJRItem) serializableExtra;
        if (cJRItem != null) {
            try {
                CharSequence url = cJRItem.getURL();
                if (url == null || url.length() == 0) {
                    z = true;
                }
                if (!z) {
                    this.f30495b = Uri.parse(cJRItem.getURL()).getQueryParameter("order_id");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Fragment aVar = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putString("order_id", this.f30495b);
        Boolean bool = this.f30496c;
        if (bool == null) {
            k.a();
        }
        bundle2.putBoolean(AppConstants.IS_CANCEL, bool.booleanValue());
        bundle2.putParcelable("tracking_info", this.f30497d);
        aVar.setArguments(bundle2);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        q a2 = supportFragmentManager.a();
        k.a((Object) a2, "fragmentManager.beginTransaction()");
        a2.a(R.id.fragment_container, aVar);
        a2.b();
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            super.onActivityResult(r5, r6, r7)
            androidx.fragment.app.j r0 = r4.getSupportFragmentManager()
            java.lang.String r1 = "getSupportFragmentManager()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r0 = r0.g()
            java.lang.String r1 = "fragmentManager.getFragments()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            if (r0 == 0) goto L_0x0031
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.isVisible()
            if (r3 == 0) goto L_0x001c
            goto L_0x0032
        L_0x0031:
            r2 = r1
        L_0x0032:
            boolean r0 = r2 instanceof net.one97.travelpass.ordersummary.c.a
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            net.one97.travelpass.ordersummary.c.a r1 = (net.one97.travelpass.ordersummary.c.a) r1
            if (r1 == 0) goto L_0x003f
            r1.onActivityResult(r5, r6, r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ordersummary.activity.activity.TPOrderSummaryActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }
}

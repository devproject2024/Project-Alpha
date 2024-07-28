package com.travel.sale;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.travel.R;
import com.travel.c.ac;
import com.travel.common.TravelBaseActivity;
import com.travel.sale.f;
import com.travel.utils.q;
import java.util.HashMap;
import kotlin.g.b.k;

public final class TravelSalesActivity extends TravelBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private ac f25711a;

    /* renamed from: b  reason: collision with root package name */
    private String f25712b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f25713c;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f25713c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this.f25713c == null) {
            this.f25713c = new HashMap();
        }
        View view = (View) this.f25713c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f25713c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        q.a(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f25711a = (ac) f.a(this, R.layout.travel_sales_view);
        if (getIntent().hasExtra("campaignId")) {
            this.f25712b = getIntent().getStringExtra("campaignId");
        }
        CharSequence charSequence = this.f25712b;
        if (!(charSequence == null || charSequence.length() == 0)) {
            f.a aVar = f.n;
            String str = this.f25712b;
            if (str == null) {
                k.a();
            }
            k.c(str, "campaignIdVal");
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(f.ag, str);
            f fVar = new f();
            fVar.setArguments(bundle2);
            j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            androidx.fragment.app.q a2 = supportFragmentManager.a();
            k.a((Object) a2, "fragmentManager.beginTransaction()");
            a2.a(R.id.sales_fragment_container, (Fragment) fVar);
            a2.b();
        }
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
            boolean r0 = r2 instanceof com.travel.sale.f
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            com.travel.sale.f r1 = (com.travel.sale.f) r1
            if (r1 == 0) goto L_0x003f
            r1.onActivityResult(r5, r6, r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.TravelSalesActivity.onActivityResult(int, int, android.content.Intent):void");
    }
}

package com.travel;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.travel.c.aa;
import com.travel.common.TravelBaseActivity;
import com.travel.utils.q;
import java.util.HashMap;
import kotlin.g.b.k;

public final class TravelGenericNavActivity extends TravelBaseActivity implements e {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f21409a;

    /* renamed from: b  reason: collision with root package name */
    private aa f21410b;

    /* renamed from: c  reason: collision with root package name */
    private String f21411c;

    /* renamed from: d  reason: collision with root package name */
    private String f21412d;

    /* renamed from: e  reason: collision with root package name */
    private String f21413e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f21414f;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f21414f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this.f21414f == null) {
            this.f21414f = new HashMap();
        }
        View view = (View) this.f21414f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f21414f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        q.a(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            r7 = r6
            android.app.Activity r7 = (android.app.Activity) r7
            int r0 = com.travel.R.layout.travel_generic_nav_activity
            androidx.databinding.ViewDataBinding r7 = androidx.databinding.f.a(r7, r0)
            com.travel.c.aa r7 = (com.travel.c.aa) r7
            r6.f21410b = r7
            com.travel.c.aa r7 = r6.f21410b
            if (r7 == 0) goto L_0x0022
            android.widget.ImageView r7 = r7.f22830a
            if (r7 == 0) goto L_0x0022
            com.travel.TravelGenericNavActivity$a r0 = new com.travel.TravelGenericNavActivity$a
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x0022:
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "deeplink"
            r1 = 0
            if (r7 == 0) goto L_0x0030
            boolean r7 = r7.hasExtra(r0)
            goto L_0x0031
        L_0x0030:
            r7 = 0
        L_0x0031:
            if (r7 == 0) goto L_0x0064
            android.content.Intent r7 = r6.getIntent()
            if (r7 == 0) goto L_0x003e
            java.lang.String r7 = r7.getStringExtra(r0)
            goto L_0x003f
        L_0x003e:
            r7 = 0
        L_0x003f:
            r6.f21411c = r7
            java.lang.String r7 = r6.f21411c
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.net.Uri$Builder r7 = r7.buildUpon()
            android.net.Uri r7 = r7.build()
            java.lang.String r2 = "uri"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            java.lang.String r2 = r7.getHost()
            r6.f21412d = r2
            java.lang.String r2 = "url"
            java.lang.String r7 = r7.getQueryParameter(r2)
            r6.f21413e = r7
        L_0x0064:
            android.content.res.Resources r7 = r6.getResources()
            int r2 = com.travel.R.string.generic_screen_header
            java.lang.String r7 = r7.getString(r2)
            java.lang.String r2 = "resources.getString(R.st…ng.generic_screen_header)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            r6.a(r7)
            java.lang.String r7 = r6.f21412d
            java.lang.String r2 = "url_type"
            if (r7 != 0) goto L_0x007f
            goto L_0x0157
        L_0x007f:
            int r3 = r7.hashCode()
            java.lang.String r4 = "tab"
            switch(r3) {
                case -485371922: goto L_0x010a;
                case 1295914: goto L_0x00e6;
                case 682739243: goto L_0x00bb;
                case 785443125: goto L_0x008b;
                default: goto L_0x0089;
            }
        L_0x0089:
            goto L_0x0157
        L_0x008b:
            java.lang.String r0 = "citybus"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0157
            java.lang.String r7 = com.travel.travels.a.b.a()
            androidx.fragment.app.Fragment r7 = com.travel.utils.e.c(r7)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = r6.f21411c
            java.lang.String r5 = "deeplink-data"
            r0.putString(r5, r3)
            java.lang.String r3 = r6.f21412d
            r0.putString(r2, r3)
            r0.putBoolean(r4, r1)
            java.lang.String r1 = "cityBusFragment"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            r7.setArguments(r0)
            r6.f21409a = r7
            goto L_0x016d
        L_0x00bb:
            java.lang.String r0 = "travelpass"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0157
            java.lang.String r7 = com.travel.travels.a.b.b()
            androidx.fragment.app.Fragment r7 = com.travel.utils.e.c(r7)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = r6.f21412d
            r0.putString(r2, r3)
            r0.putBoolean(r4, r1)
            java.lang.String r1 = "travelPassFragment"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            r7.setArguments(r0)
            r6.f21409a = r7
            goto L_0x016d
        L_0x00e6:
            java.lang.String r1 = "travelcampaign"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0157
            com.travel.sale.f r7 = new com.travel.sale.f
            r7.<init>()
            androidx.fragment.app.Fragment r7 = (androidx.fragment.app.Fragment) r7
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = r6.f21413e
            if (r2 != 0) goto L_0x0101
            java.lang.String r2 = r6.f21411c
        L_0x0101:
            r1.putString(r0, r2)
            r7.setArguments(r1)
            r6.f21409a = r7
            goto L_0x016d
        L_0x010a:
            java.lang.String r0 = "homepage"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0157
            com.travel.d.a()
            com.travel.common.b r7 = com.travel.d.b()
            androidx.fragment.app.Fragment r7 = r7.b()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            if (r7 == 0) goto L_0x014f
            java.lang.String r2 = "bundle_extra_clp_parallax_animation_required"
            r0.putBoolean(r2, r1)
            java.lang.String r2 = "bundle_extra_secondary_home_user_visible"
            r0.putBoolean(r2, r1)
            r1 = 1
            java.lang.String r2 = "first_tab_home"
            r0.putBoolean(r2, r1)
            java.lang.String r2 = r6.f21413e
            java.lang.String r3 = "EXTRA_STORE_FRONT_ALTERNATE_URL"
            r0.putString(r3, r2)
            java.lang.String r2 = r6.f21413e
            if (r2 != 0) goto L_0x0141
            java.lang.String r2 = r6.f21411c
        L_0x0141:
            java.lang.String r3 = "store_front_url_key"
            r0.putString(r3, r2)
            java.lang.String r2 = "DISABLE_PAGINATION"
            r0.putBoolean(r2, r1)
            r7.setArguments(r0)
        L_0x014f:
            java.lang.String r0 = "offerFragment"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r6.f21409a = r7
            goto L_0x016d
        L_0x0157:
            com.travel.d.a r7 = new com.travel.d.a
            r7.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r6.f21412d
            r0.putString(r2, r1)
            r7.setArguments(r0)
            androidx.fragment.app.Fragment r7 = (androidx.fragment.app.Fragment) r7
            r6.f21409a = r7
        L_0x016d:
            androidx.fragment.app.Fragment r7 = r6.f21409a
            if (r7 != 0) goto L_0x0174
            kotlin.g.b.k.a()
        L_0x0174:
            androidx.fragment.app.j r0 = r6.getSupportFragmentManager()
            java.lang.String r1 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.fragment.app.q r0 = r0.a()
            java.lang.String r1 = "fragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = com.travel.R.id.generic_fragment_container
            r0.a((int) r1, (androidx.fragment.app.Fragment) r7)
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.TravelGenericNavActivity.onCreate(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelGenericNavActivity f21415a;

        a(TravelGenericNavActivity travelGenericNavActivity) {
            this.f21415a = travelGenericNavActivity;
        }

        public final void onClick(View view) {
            this.f21415a.finish();
        }
    }

    public final void a(String str) {
        TextView textView;
        k.c(str, H5Logger.HEADER);
        aa aaVar = this.f21410b;
        if (aaVar != null && (textView = aaVar.f22832c) != null) {
            textView.setText(str);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        Fragment fragment = this.f21409a;
        if (fragment != null) {
            fragment.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}

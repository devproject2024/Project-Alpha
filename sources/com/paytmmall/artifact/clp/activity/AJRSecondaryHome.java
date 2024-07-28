package com.paytmmall.artifact.clp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.utility.b;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.clp.b.a;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.d.t;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Map;

public class AJRSecondaryHome extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f15578a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRHomePageItem f15579b;

    /* renamed from: c  reason: collision with root package name */
    private q f15580c;

    /* renamed from: d  reason: collision with root package name */
    private j f15581d;

    /* renamed from: e  reason: collision with root package name */
    private a f15582e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f15583f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f15584g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f15585h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f15586i;
    /* access modifiers changed from: private */
    public String j;
    private String k = "";
    private String l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_activity_secondary_home);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        this.f15581d = getSupportFragmentManager();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("extra_home_data")) {
            this.f15579b = (CJRHomePageItem) com.paytmmall.artifact.e.a.a((Object) intent.getSerializableExtra("extra_home_data"), CJRHomePageItem.class);
            this.f15583f = intent.getStringExtra("qrcode_id");
            this.l = getIntent().getStringExtra("qrcode_order_id");
            this.f15584g = intent.getStringExtra("affiliateID");
            this.f15585h = intent.getStringExtra("timestamp");
            this.f15586i = intent.getStringExtra("deeplink");
            this.j = intent.getStringExtra("source");
        }
        if (this.f15583f != null) {
            this.f15578a = new HashMap();
            this.f15578a.put("qrcode_id", this.f15583f);
            this.f15578a.put("qrcode_order_id", this.l);
            this.f15578a.put("affiliateID", this.f15584g);
            this.f15578a.put("timestamp", this.f15585h);
            this.f15578a.put("deeplink", this.f15586i);
        }
        StringBuilder sb = new StringBuilder();
        CJRHomePageItem cJRHomePageItem = this.f15579b;
        final String str = "";
        sb.append(cJRHomePageItem != null ? cJRHomePageItem.getName() : str);
        sb.append(" Home List");
        CJRHomePageItem cJRHomePageItem2 = this.f15579b;
        setTitle(cJRHomePageItem2 != null ? cJRHomePageItem2.getName() : " ");
        CJRHomePageItem cJRHomePageItem3 = this.f15579b;
        if (cJRHomePageItem3 != null) {
            cJRHomePageItem3.getName();
        }
        if (!isFinishing()) {
            this.f15580c = this.f15581d.a();
            String url = this.f15579b.getURL() != null ? this.f15579b.getURL() : str;
            if (t.b() != null) {
                str = b.s(t.b(), url);
            }
            if (!TextUtils.isEmpty(str.trim())) {
                this.f15582e = a.a((HashMap<String, Object>) new HashMap<String, Object>() {
                    {
                        put("url", str);
                        put(CLPConstants.ARGUMENT_IS_BOTTOM_TAB, Boolean.FALSE);
                        put("bundle_extra_category_item", AJRSecondaryHome.this.f15579b);
                        put(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, Boolean.FALSE);
                        put("bundle_extra_secondary_home", Boolean.TRUE);
                        put("bundle_extra_clp_parallax_animation_required", Boolean.FALSE);
                        put("qrcode_id", AJRSecondaryHome.this.f15583f);
                        put("affiliateID", AJRSecondaryHome.this.f15584g);
                        put("deeplink", AJRSecondaryHome.this.f15586i);
                        put("timestamp", AJRSecondaryHome.this.f15585h);
                        put("source", AJRSecondaryHome.this.j);
                        put("title_required", Boolean.TRUE);
                        put(CLPConstants.IS_SECONDARY_HOME_CLP, Boolean.TRUE);
                    }
                });
                if (this.f15579b == null) {
                    this.f15579b = new CJRHomePageItem();
                }
                q qVar = this.f15580c;
                int i2 = R.id.frame_root_container;
                a aVar = this.f15582e;
                qVar.a(i2, aVar.getCLPFragment(aVar), "homepage_secondary");
                this.f15580c.c();
            }
        }
        if (t.c() == null || t.e() == null) {
            finish();
        } else {
            t.e().setCrashlyticsEmailAndIdentifier();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 111 && (aVar = this.f15582e) != null) {
            aVar.onActivityResult(i2, i3, intent);
        }
    }
}

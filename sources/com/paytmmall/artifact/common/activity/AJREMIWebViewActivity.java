package com.paytmmall.artifact.common.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.g;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.l;

public class AJREMIWebViewActivity extends AJRWebViewActivity {
    public void onBackPressed() {
        if (this.f15639c) {
            a();
            return;
        }
        if (!this.f15645i) {
            setResult(0, b());
        }
        if (this.f15638b.canGoBack() && this.f15644h != null) {
            if (this.f15640d.isEmpty()) {
                this.f15638b.loadUrl((String) this.f15643g.get(this.j));
                return;
            } else if (this.f15644h.contains("zestmoney")) {
                g.a((Context) this, "", getResources().getString(R.string.zestmoney_backbtn_click_msg), (g.b) new g.b() {
                    public final void a() {
                        AJREMIWebViewActivity.class.getName();
                        new StringBuilder("EMI : URL : ").append((String) AJREMIWebViewActivity.this.f15643g.get("emi-details"));
                        boolean z = c.f15691a;
                        AJREMIWebViewActivity.this.f15638b.loadUrl((String) AJREMIWebViewActivity.this.f15643g.get("emi-details"), AJREMIWebViewActivity.this.f15640d);
                    }
                });
                return;
            } else if (!this.f15644h.contains("emi-details")) {
                this.f15638b.goBack();
                return;
            }
        }
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 111 && i3 == -1) {
            this.f15640d.put(AppConstants.SSO_TOKEN, l.a((Context) this));
            if (!this.f15643g.containsKey("emi-details") || TextUtils.isEmpty((CharSequence) this.f15643g.get("emi-details"))) {
                this.f15638b.loadUrl(this.j, this.f15640d);
            } else {
                this.f15638b.loadUrl((String) this.f15643g.get("emi-details"), this.f15640d);
            }
            this.f15641e = true;
        } else if (i2 == 8899 && this.f15642f != null) {
            Uri data = (intent == null || i3 != -1) ? null : intent.getData();
            if (data != null) {
                this.f15642f.onReceiveValue(new Uri[]{data});
                this.f15642f = null;
                return;
            }
            this.f15642f.onReceiveValue((Object) null);
            this.f15642f = null;
        }
    }
}

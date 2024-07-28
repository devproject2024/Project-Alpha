package net.one97.paytm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.j.a;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.p.a;
import net.one97.paytm.paytm_finance.R;

public class AuthorizedMerchantActivity extends CJRActionBarBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f51795a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f51796b;

    /* renamed from: c  reason: collision with root package name */
    private View f51797c;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_authorized_merchant);
        setTitle(getString(R.string.link_app_merchants));
        o();
        p();
        this.f51796b = (RelativeLayout) findViewById(R.id.lyt_linked_merchant);
        this.f51795a = (RelativeLayout) findViewById(R.id.lyt_active_subscription);
        this.f51797c = findViewById(R.id.lyt_separator);
        a.b("/linked apps and subscriptions", "", (Context) this);
        this.f51796b.setOnClickListener(this);
        this.f51795a.setOnClickListener(this);
        OauthModule.b().sendGAMultipleLabelEvent(this, "apps_linked_with_paytm", "apps_linked_with_paytm_screen_loaded", (ArrayList<String>) null, (String) null, "/apps_linked_with_paytm", p.f56796a);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lyt_active_subscription) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_account_subscriptions_tab_name", "Active Subscriptions");
            a.b("user_account_subscriptions_tab_name_selected", (Map<String, Object>) hashMap, (Context) this);
            a.C0166a aVar = net.one97.paytm.p.a.f12661b;
            net.one97.paytm.p.a a2 = a.C0166a.a(this);
            if (a2 != null) {
                startActivity(a2.a());
            }
        } else if (id == R.id.lyt_linked_merchant) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("user_account_subscriptions_tab_name", "Apps linked with Paytm Wallet");
            net.one97.paytm.j.a.b("user_account_subscriptions_tab_name_selected", (Map<String, Object>) hashMap2, (Context) this);
            startActivity(new Intent(this, LinkedMerchantActivity.class));
        }
    }
}

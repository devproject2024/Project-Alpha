package net.one97.paytm;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.Map;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.e;

public class AJRUpdateMessage extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f51766a;

    /* renamed from: b  reason: collision with root package name */
    private Button f51767b;

    /* renamed from: c  reason: collision with root package name */
    private int f51768c;

    /* renamed from: d  reason: collision with root package name */
    private String f51769d;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.update_message_activity, (ViewGroup) null));
        this.f51768c = a.u(this);
        r();
        setTitle(getString(R.string.app_upgrade_required));
        o();
        p();
        if (this.z != null) {
            this.z.setDrawerLockMode(1);
        }
        this.f51766a = (TextView) findViewById(R.id.update_message);
        this.f51767b = (Button) findViewById(R.id.update_app_btn);
        TextView textView = this.f51766a;
        int i2 = this.f51768c;
        textView.setPadding(i2, i2, i2, i2);
        b.c((TextView) this.f51767b);
        this.f51769d = getIntent().getStringExtra("url_type");
        this.f51767b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRUpdateMessage.a(AJRUpdateMessage.this);
            }
        });
        try {
            Map<String, Map<String, String>> l = c.a().l();
            if (l == null) {
                return;
            }
            if (l.containsKey(this.f51769d)) {
                Map map = l.get(this.f51769d);
                if (map != null) {
                    a((String) map.get("message"), (String) map.get("show_update"), (String) map.get("title"));
                    return;
                }
                return;
            }
            Map map2 = l.get("default");
            if (map2 != null) {
                a((String) map2.get("message"), (String) map2.get("show_update"), (String) map2.get("title"));
            }
        } catch (Exception unused) {
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    private void a(String str, String str2, String str3) {
        this.f51766a.setText(str);
        setTitle(str3);
        if (str2 == null || !str2.equalsIgnoreCase("true")) {
            this.f51767b.setVisibility(8);
        } else {
            this.f51767b.setVisibility(0);
        }
    }

    private void b() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    static /* synthetic */ void a(AJRUpdateMessage aJRUpdateMessage) {
        try {
            if (e.f69723a.a(aJRUpdateMessage).a("com.android.vending")) {
                aJRUpdateMessage.b();
            } else if (e.f69723a.a(aJRUpdateMessage).a("com.huawei.appmarket")) {
                aJRUpdateMessage.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://appgallery.huawei.com/#/app/C101964205")));
            } else if (e.f69723a.a(aJRUpdateMessage).a("com.sec.android.app.samsungapps")) {
                aJRUpdateMessage.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("appbazaar://details/indus/62224?source=external_paytm&source_type=external")));
            } else if (e.f69723a.a(aJRUpdateMessage).a("com.oppo.market")) {
                e.f69723a.a(aJRUpdateMessage).a(aJRUpdateMessage.getPackageName(), "com.oppo.market");
            } else if (e.f69723a.a(aJRUpdateMessage).a("com.vivo.appstore")) {
                e.f69723a.a(aJRUpdateMessage).a(aJRUpdateMessage.getPackageName(), "com.vivo.appstore");
            } else if (e.f69723a.a(aJRUpdateMessage).a("com.xiaomi.mipicks")) {
                aJRUpdateMessage.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mimarket://details?id=net.one97.paytm")));
            } else {
                aJRUpdateMessage.b();
            }
        } catch (Exception unused) {
            aJRUpdateMessage.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + aJRUpdateMessage.getPackageName())));
        }
    }
}

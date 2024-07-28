package net.one97.paytm.wallet.dialog.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import com.paytm.utility.b;
import kotlin.g.b.k;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;

public final class a extends net.one97.paytm.p2mNewDesign.c.a {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f70264b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f70265c;

    /* renamed from: d  reason: collision with root package name */
    private String f70266d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f70267e = ((CheckBox) findViewById(R.id.checkbox));

    public a(Activity activity, int i2, String str, boolean z) {
        super(activity, i2);
        setContentView(R.layout.lyt_gallery_scan_alert_dialog);
        this.f70264b = activity;
        this.f70266d = str;
        this.f70265c = z;
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R.id.title_layout);
        String h2 = b.h((Context) this.f70264b);
        if ("null".equals(h2) || h2 == null) {
            appCompatTextView.setText(this.f70264b.getString(R.string.hey_with_exclamation));
        } else {
            String A = b.A(h2);
            appCompatTextView.setText(String.format(this.f70264b.getString(R.string.hey_first_name), new Object[]{A}));
        }
        ((AppCompatTextView) findViewById(R.id.gallery_alert_desc1)).setText(String.format(this.f70264b.getString(R.string.gallery_alert_info1), new Object[]{this.f70266d}));
        findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.c(view);
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        findViewById(R.id.lyt_checkbox).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (this.f70267e.isChecked()) {
            net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
            String str = this.f70265c ? "flow_through_scan_icon" : "flow_through_pay_icon";
            Context a2 = net.one97.paytm.wallet.a.a.a();
            k.a((Object) a2, "getContext()");
            net.one97.paytm.wallet.a.a.a("offline_payments", "gallery_security_pop_not_show_again", str, a2, "home/pay-send/post-scan");
            be.a(this.f70264b.getApplicationContext()).a("show_gallery_alert", false, false);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        CheckBox checkBox = this.f70267e;
        checkBox.setChecked(!checkBox.isChecked());
    }
}

package net.one97.paytm.wallet.dialog.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.f.c;
import net.one97.paytm.wallet.R;

public final class b extends net.one97.paytm.p2mNewDesign.c.a {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f70268b;

    /* renamed from: c  reason: collision with root package name */
    private final String f70269c;

    /* renamed from: d  reason: collision with root package name */
    private final String f70270d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final c f70271e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Activity activity, int i2, String str, String str2, c cVar) {
        super(activity, i2);
        k.c(activity, "mActivity");
        k.c(cVar, "listner");
        this.f70268b = activity;
        this.f70269c = str;
        this.f70270d = str2;
        this.f70271e = cVar;
        setContentView(R.layout.merchant_pay_mode_limit_dialog);
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R.id.title_layout);
        String h2 = com.paytm.utility.b.h((Context) this.f70268b);
        if (!(!k.a((Object) "null", (Object) h2)) || h2 == null) {
            k.a((Object) appCompatTextView, "tv");
            appCompatTextView.setText(this.f70268b.getString(R.string.hey_with_exclamation));
        } else {
            String A = com.paytm.utility.b.A(h2);
            k.a((Object) appCompatTextView, "tv");
            aa aaVar = aa.f47921a;
            String string = this.f70268b.getString(R.string.hey_first_name);
            k.a((Object) string, "mActivity.getString(R.string.hey_first_name)");
            String format = String.format(string, Arrays.copyOf(new Object[]{A}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            appCompatTextView.setText(format);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) findViewById(R.id.gallery_alert_desc1);
        k.a((Object) appCompatTextView2, "gallery_alert_desc1");
        aa aaVar2 = aa.f47921a;
        String string2 = this.f70268b.getString(R.string.gallery_alert_info1);
        k.a((Object) string2, "mActivity.getString(R.string.gallery_alert_info1)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.f70269c}, 1));
        k.a((Object) format2, "java.lang.String.format(format, *args)");
        appCompatTextView2.setText(format2);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) findViewById(R.id.tvDesc);
        k.a((Object) appCompatTextView3, "tvDesc");
        appCompatTextView3.setText(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w(this.f70270d));
        ((AppCompatButton) findViewById(R.id.ok_button)).setOnClickListener(new a(this));
        ((AppCompatImageView) findViewById(R.id.iv_close)).setOnClickListener(new C1416b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70272a;

        a(b bVar) {
            this.f70272a = bVar;
        }

        public final void onClick(View view) {
            this.f70272a.dismiss();
            this.f70272a.f70271e.a();
        }
    }

    /* renamed from: net.one97.paytm.wallet.dialog.a.b$b  reason: collision with other inner class name */
    static final class C1416b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70273a;

        C1416b(b bVar) {
            this.f70273a = bVar;
        }

        public final void onClick(View view) {
            this.f70273a.dismiss();
            this.f70273a.f70271e.b();
        }
    }
}

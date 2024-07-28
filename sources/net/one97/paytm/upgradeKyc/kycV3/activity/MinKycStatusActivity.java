package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.f;
import net.one97.paytm.upgradeKyc.utils.j;

public final class MinKycStatusActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f66144a;

    public final View a(int i2) {
        if (this.f66144a == null) {
            this.f66144a = new HashMap();
        }
        View view = (View) this.f66144a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66144a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int a() {
        return R.layout.min_kyc_status_lyt;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        aa aaVar = aa.f47921a;
        String string = getResources().getString(R.string.note_full_kyc_mandate);
        k.a((Object) string, "resources.getString(R.st…ng.note_full_kyc_mandate)");
        String format = String.format(string, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getResources().getString(R.string.know_more_kyc) + "</a> "}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        TextView textView = (TextView) a(R.id.note_tv);
        k.a((Object) textView, "note_tv");
        if (Build.VERSION.SDK_INT >= 24) {
            charSequence = Html.fromHtml(format, 0);
        } else {
            charSequence = Html.fromHtml(format);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Context context = this;
        textView.setLinkTextColor(androidx.core.content.b.c(context, R.color.paytm_blue));
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new b(this));
        if (p.a(j.n(context), "EKYC_OTP", true)) {
            TextView textView2 = (TextView) a(R.id.status_desc_tv);
            k.a((Object) textView2, "status_desc_tv");
            textView2.setText(getString(R.string.min_ekyc_status_desc, new Object[]{j.g(context)}));
            TextView textView3 = (TextView) a(R.id.min_kyc_status_tv);
            k.a((Object) textView3, "min_kyc_status_tv");
            textView3.setText(getString(R.string.ekyc_expired));
        } else if (p.a(j.n(context), "MIN_KYC", true)) {
            TextView textView4 = (TextView) a(R.id.status_desc_tv);
            k.a((Object) textView4, "status_desc_tv");
            textView4.setText(getString(R.string.min_kyc_status_desc, new Object[]{j.g(context)}));
            TextView textView5 = (TextView) a(R.id.min_kyc_status_tv);
            k.a((Object) textView5, "min_kyc_status_tv");
            textView5.setText(getString(R.string.min_kyc_expired));
        }
        ((Button) a(R.id.complete_kyc_now_btn)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycStatusActivity f66145a;

        a(MinKycStatusActivity minKycStatusActivity) {
            this.f66145a = minKycStatusActivity;
        }

        public final void onClick(View view) {
            MinKycStatusActivity.a(this.f66145a);
        }
    }

    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycStatusActivity f66146a;

        b(MinKycStatusActivity minKycStatusActivity) {
            this.f66146a = minKycStatusActivity;
        }

        public final void a(String str) {
            k.c(str, "url");
            if (p.a((CharSequence) str, (CharSequence) "https://www.google.com", true)) {
                e.a aVar = e.f66028b;
                Intent intent = new Intent(this.f66146a, Class.forName(e.a.b().d()));
                d.a aVar2 = d.f66026a;
                intent.putExtra("url", d.a.a() != null ? d.a("keyKycRbiDirectiveUrl") : null);
                intent.putExtra("Close", true);
                this.f66146a.startActivity(intent);
            }
        }
    }

    public static final /* synthetic */ void a(MinKycStatusActivity minKycStatusActivity) {
        minKycStatusActivity.startActivity(new Intent(minKycStatusActivity, InPersonVerification.class));
        minKycStatusActivity.finish();
    }
}

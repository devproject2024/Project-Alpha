package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.helper.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class AmSupportedCardActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f49316a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f49317b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f49318c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.am_layout_supported_payoptions);
        View findViewById = findViewById(R.id.debit_card_layout);
        k.a((Object) findViewById, "findViewById(R.id.debit_card_layout)");
        this.f49316a = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.credit_card_layout);
        k.a((Object) findViewById2, "findViewById(R.id.credit_card_layout)");
        this.f49317b = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ppbl_layout);
        k.a((Object) findViewById3, "findViewById(R.id.ppbl_layout)");
        this.f49318c = (LinearLayout) findViewById3;
        String f2 = a.f50546a.a().f("aam_debitCardOptions");
        if (f2 != null) {
            CharSequence charSequence = f2;
            if (!TextUtils.isEmpty(charSequence)) {
                List<String> a2 = p.a(charSequence, new String[]{"|"});
                if (a2 == null) {
                    k.a();
                }
                for (String a3 : a2) {
                    List<String> a4 = p.a((CharSequence) a3, new String[]{AppConstants.COLON});
                    String str = a4.get(0);
                    String str2 = a4.get(1);
                    LinearLayout linearLayout = this.f49316a;
                    if (linearLayout == null) {
                        k.a("mDebitCardslayout");
                    }
                    a(linearLayout, str, str2);
                }
            }
        }
        if (a.f50546a.a().g("isCCAllowedForAutoAm")) {
            String f3 = a.f50546a.a().f("aam_creditCardOptions");
            if (f3 != null) {
                CharSequence charSequence2 = f3;
                if (!TextUtils.isEmpty(charSequence2)) {
                    for (String a5 : p.a(charSequence2, new String[]{"|"})) {
                        List<String> a6 = p.a((CharSequence) a5, new String[]{AppConstants.COLON});
                        String str3 = a6.get(0);
                        String str4 = a6.get(1);
                        LinearLayout linearLayout2 = this.f49317b;
                        if (linearLayout2 == null) {
                            k.a("mcreditCardslayout");
                        }
                        a(linearLayout2, str3, str4);
                    }
                }
            }
            View findViewById4 = findViewById(R.id.tv_creditCard);
            k.a((Object) findViewById4, "findViewById<TextView>(R.id.tv_creditCard)");
            ((TextView) findViewById4).setVisibility(0);
        }
        String f4 = a.f50546a.a().f("aam_bankAccountOptions");
        if (!TextUtils.isEmpty(f4)) {
            LinearLayout linearLayout3 = this.f49318c;
            if (linearLayout3 == null) {
                k.a("mPPBllayout");
            }
            if (f4 == null) {
                k.a();
            }
            a(linearLayout3, f4, SDKConstants.AI_KEY_PPBL);
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(a.f50546a.a().a(context));
    }

    public final void backClicked(View view) {
        k.c(view, "view");
        b.c((Activity) this);
        onBackPressed();
    }

    private final void a(LinearLayout linearLayout, String str, String str2) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.am_supported_card_row, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_bank_name);
        k.a((Object) textView, "tv_bank");
        textView.setText(str);
        a((ImageView) inflate.findViewById(R.id.ic_bank), str2);
        linearLayout.addView(inflate);
    }

    private final void a(ImageView imageView, String str) {
        switch (str.hashCode()) {
            case -1081267614:
                if (str.equals("master")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.master_card_new));
                        return;
                    }
                    return;
                }
                break;
            case 2143:
                if (str.equals("CB")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.citi_bank));
                        return;
                    }
                    return;
                }
                break;
            case 2329:
                if (str.equals("IB")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.icici_bank_new));
                        return;
                    }
                    return;
                }
                break;
            case 66871:
                if (str.equals("CNB")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.canara_bank));
                        return;
                    }
                    return;
                }
                break;
            case 74528:
                if (str.equals("KMB")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.kotak_bank));
                        return;
                    }
                    return;
                }
                break;
            case 81906:
                if (str.equals("SCB")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.sc_bank));
                        return;
                    }
                    return;
                }
                break;
            case 2462282:
                if (str.equals(SDKConstants.AI_KEY_PPBL)) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.paytm_logo_circle));
                        return;
                    }
                    return;
                }
                break;
            case 2997727:
                if (str.equals("amex")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.american_bank));
                        return;
                    }
                    return;
                }
                break;
            case 3197625:
                if (str.equals("hdfc")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.hdfc_bank_icon));
                        return;
                    }
                    return;
                }
                break;
            case 3619905:
                if (str.equals("visa")) {
                    if (imageView != null) {
                        imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.visa_new));
                        return;
                    }
                    return;
                }
                break;
        }
        if (imageView != null) {
            imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.uam_other_bank_card_icon));
        }
    }
}

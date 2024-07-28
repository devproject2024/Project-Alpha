package net.one97.paytm.upgradeKyc.editprofile.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.helper.c;
import net.one97.paytm.upi.util.UpiConstants;

public final class e extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f65961a;

    /* renamed from: b  reason: collision with root package name */
    private String f65962b;

    /* renamed from: c  reason: collision with root package name */
    private CersaiDetails f65963c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f65964d;

    private View a(int i2) {
        if (this.f65964d == null) {
            this.f65964d = new HashMap();
        }
        View view = (View) this.f65964d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65964d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ void a() {
    }

    public final void onClick(View view) {
        if (k.a((Object) view, (Object) (ConstraintLayout) a(R.id.kyc_add_doc_banner_parent)) || k.a((Object) view, (Object) (TextView) a(R.id.add_doc_banner_main_tv))) {
            String str = this.f65962b;
            if (str == null || !p.a(str, "aadhaar", true)) {
                String str2 = this.f65962b;
                if (str2 == null || !p.a(str2, "pan", true)) {
                    String str3 = this.f65962b;
                    if (str3 != null && p.a(str3, "updateCersai", true)) {
                        Intent intent = new Intent(getActivity(), StandAloneCersaiActivity.class);
                        CersaiDetails cersaiDetails = this.f65963c;
                        if (cersaiDetails != null) {
                            intent.putExtra("aadhaarData", cersaiDetails);
                        }
                        startActivity(intent);
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            activity.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
                b();
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Serializable serializable = null;
            this.f65961a = arguments != null ? arguments.getString("updateDocBannerDocText") : null;
            Bundle arguments2 = getArguments();
            this.f65962b = arguments2 != null ? arguments2.getString("updateDocBannerPurposeCode") : null;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                serializable = arguments3.getSerializable("aadhaarData");
            }
            this.f65963c = (CersaiDetails) serializable;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_add_document_details_banner, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (!TextUtils.isEmpty(this.f65962b) && p.a(this.f65962b, "aadhaar", false)) {
            aa aaVar = aa.f47921a;
            String string = getResources().getString(R.string.kyc_add_aadhaar_banner);
            k.a((Object) string, "resources.getString(R.st…g.kyc_add_aadhaar_banner)");
            String format = String.format(string, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.updateaadhaar.com\"><br>" + getResources().getString(R.string.kyc_add_now_text) + "</a> "}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            TextView textView = (TextView) a(R.id.add_doc_banner_main_tv);
            k.a((Object) textView, "add_doc_banner_main_tv");
            a(textView, format);
        } else if (TextUtils.isEmpty(this.f65962b) || !p.a(this.f65962b, "pan", false)) {
            if (TextUtils.isEmpty(this.f65962b)) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.add_doc_banner_kyc_arrow_iv);
                k.a((Object) appCompatImageView, "add_doc_banner_kyc_arrow_iv");
                appCompatImageView.setVisibility(8);
            } else {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.add_doc_banner_kyc_arrow_iv);
                k.a((Object) appCompatImageView2, "add_doc_banner_kyc_arrow_iv");
                appCompatImageView2.setVisibility(0);
            }
            aa aaVar2 = aa.f47921a;
            String string2 = getResources().getString(R.string.update_cersai_text);
            k.a((Object) string2, "resources.getString(R.string.update_cersai_text)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.cersaiguidelines.com\">" + getResources().getString(R.string.rbi_guideline_pt_fiveseven) + "</a> "}, 1));
            k.a((Object) format2, "java.lang.String.format(format, *args)");
            TextView textView2 = (TextView) a(R.id.add_doc_banner_main_tv);
            k.a((Object) textView2, "add_doc_banner_main_tv");
            a(textView2, format2);
        } else {
            aa aaVar3 = aa.f47921a;
            String string3 = getResources().getString(R.string.kyc_add_pan_banner);
            k.a((Object) string3, "resources.getString(R.string.kyc_add_pan_banner)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.updatepan.com\">" + getResources().getString(R.string.kyc_add_now_text) + "</a> "}, 1));
            k.a((Object) format3, "java.lang.String.format(format, *args)");
            TextView textView3 = (TextView) a(R.id.add_doc_banner_main_tv);
            k.a((Object) textView3, "add_doc_banner_main_tv");
            a(textView3, format3);
        }
        View.OnClickListener onClickListener = this;
        ((ConstraintLayout) a(R.id.kyc_add_doc_banner_parent)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.add_doc_banner_main_tv)).setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: private */
    public final void b() {
        startActivity(d.a().b(getActivity()));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void a(TextView textView, String str) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 24) {
            charSequence = Html.fromHtml(str, 0);
        } else {
            charSequence = Html.fromHtml(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        textView.setLinkTextColor(b.c(context, R.color.paytm_blue));
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new a(this));
    }

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f65965a;

        a(e eVar) {
            this.f65965a = eVar;
        }

        public final void a(String str) {
            k.c(str, "url");
            CharSequence charSequence = str;
            if (p.a(charSequence, (CharSequence) "https://www.cersaiguidelines.com", true)) {
                Intent a2 = d.a().a(this.f65965a.getActivity());
                if (this.f65965a.getActivity() != null) {
                    a2.putExtra("url", d.a().C());
                }
                a2.putExtra("title", this.f65965a.getString(R.string.rbi_directive));
                a2.putExtra(UpiConstants.FROM, this.f65965a.getString(R.string.link_your_aadhaar));
                a2.putExtra("Close", true);
                this.f65965a.startActivity(a2);
            } else if (p.a(charSequence, (CharSequence) "https://www.updatepan.com", true)) {
                this.f65965a.b();
            } else if (p.a(charSequence, (CharSequence) "https://www.updateaadhaar.com", true)) {
                e.a();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65964d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

package net.one97.paytm.upgradeKyc.d;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.util.UpiConstants;

public final class i extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65698a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65699b;

    private View a(int i2) {
        if (this.f65699b == null) {
            this.f65699b = new HashMap();
        }
        View view = (View) this.f65699b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65699b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final i a(String str) {
        return a.a(str);
    }

    public final void onClick(View view) {
        if ((view != null && view.getId() == R.id.ok_i_understant_btn) || (view != null && view.getId() == R.id.cross_iv)) {
            dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.cersai_know_more_rbi_directive_lyt, viewGroup, false);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i a(String str) {
            k.c(str, "comingFrom");
            i iVar = new i();
            Bundle bundle = new Bundle();
            bundle.putString("coming_from_screen", str);
            iVar.setArguments(bundle);
            return iVar;
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.ok_i_understant_btn)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.cross_iv)).setOnClickListener(onClickListener);
        Bundle arguments = getArguments();
        Context context = null;
        String string = arguments != null ? arguments.getString("coming_from_screen") : null;
        CharSequence charSequence2 = string;
        if (!TextUtils.isEmpty(charSequence2) && p.a(string, "nonAadhaarPageFooter", false)) {
            TextView textView = (TextView) a(R.id.kyc_again_rbi_requires_tv);
            k.a((Object) textView, "kyc_again_rbi_requires_tv");
            textView.setText(getString(R.string.rbi_requires_min_kyc_validity_text));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                context = activity.getApplicationContext();
            }
            String g2 = j.g(context);
            if (!TextUtils.isEmpty(g2)) {
                TextView textView2 = (TextView) a(R.id.kyc_valid_till_tv);
                k.a((Object) textView2, "kyc_valid_till_tv");
                textView2.setVisibility(0);
                if (j.d(getActivity()) == 1) {
                    TextView textView3 = (TextView) a(R.id.kyc_valid_till_tv);
                    k.a((Object) textView3, "kyc_valid_till_tv");
                    textView3.setText(getString(R.string.kyc_expired_label, g2));
                } else {
                    TextView textView4 = (TextView) a(R.id.kyc_valid_till_tv);
                    k.a((Object) textView4, "kyc_valid_till_tv");
                    textView4.setText(getString(R.string.your_kyc_valid_till, g2));
                }
            }
            View a2 = a(R.id.kyc_acnt_status_separator);
            k.a((Object) a2, "kyc_acnt_status_separator");
            a2.setVisibility(0);
            TextView textView5 = (TextView) a(R.id.kyc_again_therefore_cersai_tv);
            k.a((Object) textView5, "kyc_again_therefore_cersai_tv");
            textView5.setVisibility(0);
            TextView textView6 = (TextView) a(R.id.kyc_again_therefore_cersai_tv);
            k.a((Object) textView6, "kyc_again_therefore_cersai_tv");
            textView6.setText(getString(R.string.physical_verification_required));
            Button button = (Button) a(R.id.ok_i_understant_btn);
            k.a((Object) button, "ok_i_understant_btn");
            button.setVisibility(8);
            ImageView imageView = (ImageView) a(R.id.fullKycIv);
            k.a((Object) imageView, "fullKycIv");
            imageView.setVisibility(0);
        } else if (!TextUtils.isEmpty(charSequence2) && p.a(string, "cersaiPageFooter", false)) {
            aa aaVar = aa.f47921a;
            String string2 = getResources().getString(R.string.rbi_requires_cersai);
            k.a((Object) string2, "resources.getString(R.string.rbi_requires_cersai)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getResources().getString(R.string.rbi_directive) + "</a> "}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            TextView textView7 = (TextView) a(R.id.kyc_again_rbi_requires_tv);
            k.a((Object) textView7, "kyc_again_rbi_requires_tv");
            if (Build.VERSION.SDK_INT >= 24) {
                charSequence = Html.fromHtml(format, 0);
            } else {
                charSequence = Html.fromHtml(format);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            textView7.setLinkTextColor(androidx.core.content.b.c(context2, R.color.paytm_blue));
            textView7.setText(spannableStringBuilder);
            textView7.setMovementMethod(new b(this));
            TextView textView8 = (TextView) a(R.id.kyc_valid_till_tv);
            k.a((Object) textView8, "kyc_valid_till_tv");
            textView8.setVisibility(8);
            View a3 = a(R.id.kyc_acnt_status_separator);
            k.a((Object) a3, "kyc_acnt_status_separator");
            a3.setVisibility(8);
            TextView textView9 = (TextView) a(R.id.kyc_again_therefore_cersai_tv);
            k.a((Object) textView9, "kyc_again_therefore_cersai_tv");
            textView9.setVisibility(0);
            TextView textView10 = (TextView) a(R.id.kyc_again_therefore_cersai_tv);
            k.a((Object) textView10, "kyc_again_therefore_cersai_tv");
            textView10.setText(getString(R.string.therefore_we_are_required_kyc));
            Button button2 = (Button) a(R.id.ok_i_understant_btn);
            k.a((Object) button2, "ok_i_understant_btn");
            button2.setVisibility(0);
            ImageView imageView2 = (ImageView) a(R.id.fullKycIv);
            k.a((Object) imageView2, "fullKycIv");
            imageView2.setVisibility(8);
        }
    }

    public static final class b extends net.one97.paytm.upgradeKyc.utils.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f65700a;

        b(i iVar) {
            this.f65700a = iVar;
        }

        public final void a(String str) {
            k.c(str, "url");
            if (p.a((CharSequence) str, (CharSequence) "https://www.google.com", true)) {
                e.a aVar = e.f66028b;
                Intent intent = new Intent(this.f65700a.getActivity(), Class.forName(e.a.b().d()));
                if (this.f65700a.getActivity() != null) {
                    d.a aVar2 = d.f66026a;
                    intent.putExtra("url", d.a.a() != null ? d.a("keyKycRbiDirectiveUrl") : null);
                }
                intent.putExtra("title", this.f65700a.getString(R.string.rbi_directive));
                intent.putExtra(UpiConstants.FROM, this.f65700a.getString(R.string.link_your_aadhaar));
                intent.putExtra("Close", true);
                this.f65700a.startActivity(intent);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65699b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

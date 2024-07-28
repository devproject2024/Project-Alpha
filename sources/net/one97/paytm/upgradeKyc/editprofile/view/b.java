package net.one97.paytm.upgradeKyc.editprofile.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;

public final class b extends h implements View.OnClickListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    a f65917a;

    /* renamed from: b  reason: collision with root package name */
    CersaiDetails f65918b;

    /* renamed from: c  reason: collision with root package name */
    private final String f65919c = "1200004";

    /* renamed from: d  reason: collision with root package name */
    private final String f65920d = "1200021";

    /* renamed from: e  reason: collision with root package name */
    private final String f65921e = "1000510";

    /* renamed from: f  reason: collision with root package name */
    private d f65922f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.editprofile.e.b f65923g;

    /* renamed from: h  reason: collision with root package name */
    private LottieAnimationView f65924h;

    /* renamed from: i  reason: collision with root package name */
    private Activity f65925i;
    private HashMap j;

    private View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str) {
        k.c(str, "dob");
        TextView textView = (TextView) a(R.id.kyc_dob_value_tv);
        k.a((Object) textView, "kyc_dob_value_tv");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.kyc_dob_tv);
        k.a((Object) textView2, "kyc_dob_tv");
        textView2.setVisibility(0);
        ((TextView) a(R.id.kyc_dob_value_tv)).setText(str);
    }

    public final void b(CersaiDetails cersaiDetails) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            c cVar = (c) parentFragment;
            e eVar = new e();
            k.a((Object) cVar.getChildFragmentManager().a(), "childFragmentManager.beginTransaction()");
            Bundle bundle = new Bundle();
            bundle.putString("updateDocBannerDocText", cVar.getString(R.string.update_cersai_text));
            bundle.putString("updateDocBannerPurposeCode", "updateCersai");
            if (cersaiDetails != null) {
                bundle.putSerializable("aadhaarData", cersaiDetails);
            }
            eVar.setArguments(bundle);
            View a2 = a(R.id.divider_after_address_details);
            k.a((Object) a2, "divider_after_address_details");
            a2.setVisibility(8);
            View a3 = a(R.id.divider_after_kyc_details);
            k.a((Object) a3, "divider_after_kyc_details");
            a3.setVisibility(8);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.editprofile.view.KycProfileFragment");
    }

    public final void a(CersaiDetails cersaiDetails) {
        k.c(cersaiDetails, "cersaiInfo");
        this.f65918b = cersaiDetails;
        View a2 = a(R.id.divider_after_address_details);
        k.a((Object) a2, "divider_after_address_details");
        a2.setVisibility(0);
        View a3 = a(R.id.divider_after_kyc_details);
        k.a((Object) a3, "divider_after_kyc_details");
        a3.setVisibility(0);
        this.f65922f = new d();
        q a4 = getChildFragmentManager().a();
        k.a((Object) a4, "childFragmentManager.beginTransaction()");
        if (cersaiDetails != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("aadhaarData", cersaiDetails);
            d dVar = this.f65922f;
            if (dVar != null) {
                dVar.setArguments(bundle);
            }
        }
        int i2 = R.id.kyc_details_address_container;
        d dVar2 = this.f65922f;
        if (dVar2 == null) {
            k.a();
        }
        a4.a(i2, (Fragment) dVar2).b();
        this.f65917a = new a();
        if (cersaiDetails != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("aadhaarData", cersaiDetails);
            a aVar = this.f65917a;
            if (aVar != null) {
                aVar.setArguments(bundle2);
            }
        }
        q a5 = getChildFragmentManager().a();
        k.a((Object) a5, "childFragmentManager.beginTransaction()");
        int i3 = R.id.kyc_details_cersai_container;
        a aVar2 = this.f65917a;
        if (aVar2 == null) {
            k.a();
        }
        a5.a(i3, (Fragment) aVar2).b();
    }

    public final void a(String str, boolean z) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            k.c("pan", "panOrAadhaar");
            e eVar = new e();
            j fragmentManager = getFragmentManager();
            q a2 = fragmentManager != null ? fragmentManager.a() : null;
            Bundle bundle = new Bundle();
            if (p.a("pan", "aadhaar", true)) {
                bundle.putString("updateDocBannerDocText", getString(R.string.kyc_add_aadhaar_banner));
            } else if (p.a("pan", "pan", true)) {
                bundle.putString("updateDocBannerDocText", getString(R.string.kyc_add_pan_banner));
            }
            bundle.putString("updateDocBannerPurposeCode", "pan");
            eVar.setArguments(bundle);
            if (a2 != null) {
                a2.a(R.id.add_doc_banner_fragment_container, (Fragment) eVar).b();
                return;
            }
            return;
        }
        TextView textView = (TextView) a(R.id.kyc_details_pan_value_tv);
        k.a((Object) textView, "kyc_details_pan_value_tv");
        textView.setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.edit_profile_pan_tick_iv);
        k.a((Object) appCompatImageView, "edit_profile_pan_tick_iv");
        appCompatImageView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.pan_number_tv);
        k.a((Object) textView2, "pan_number_tv");
        textView2.setVisibility(0);
        ((TextView) a(R.id.kyc_details_pan_value_tv)).setText(charSequence);
        if (z) {
            ((AppCompatImageView) a(R.id.edit_profile_pan_tick_iv)).setImageResource(R.drawable.ic_kyc_badge);
        } else {
            ((AppCompatImageView) a(R.id.edit_profile_pan_tick_iv)).setImageResource(R.drawable.ic_timeline_pending);
        }
    }

    public final void a() {
        TextView textView = (TextView) a(R.id.kyc_details_pan_value_tv);
        k.a((Object) textView, "kyc_details_pan_value_tv");
        textView.setVisibility(8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.edit_profile_pan_tick_iv);
        k.a((Object) appCompatImageView, "edit_profile_pan_tick_iv");
        appCompatImageView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.pan_number_tv);
        k.a((Object) textView2, "pan_number_tv");
        textView2.setVisibility(8);
    }

    public final void b(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            ((TextView) a(R.id.kyc_details_full_name_value_tv)).setText(charSequence);
        }
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (p.a(str, "M", true)) {
            ((TextView) a(R.id.kyc_gender_value_tv)).setText(com.paytm.utility.b.A("male"));
        } else if (p.a(str, AppConstants.FEED_SUB_TYPE, true)) {
            ((TextView) a(R.id.kyc_gender_value_tv)).setText(com.paytm.utility.b.A("female"));
        }
    }

    public final void b() {
        net.one97.paytm.common.widgets.a.b(this.f65924h);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f65925i = (Activity) context;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.b bVar = this;
        a.C1308a aVar = net.one97.paytm.upgradeKyc.editprofile.d.a.f65816b;
        Context a2 = d.b().a();
        k.a((Object) a2, "HomeHelper.getAppLaunchM…).getApplicationContext()");
        net.one97.paytm.upgradeKyc.editprofile.d.a a3 = a.C1308a.a(a2);
        if (a3 == null) {
            k.a();
        }
        this.f65923g = new net.one97.paytm.upgradeKyc.editprofile.e.b(bVar, a3);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_kyc_details_edit_profile, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View.OnClickListener onClickListener = this;
        ((TextView) a(R.id.contact_us_tv)).setOnClickListener(onClickListener);
        this.f65924h = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
        ((TextView) a(R.id.contact_us_tv)).setOnClickListener(onClickListener);
        Group group = (Group) a(R.id.group_kyc_lyt);
        k.a((Object) group, "group_kyc_lyt");
        group.setVisibility(8);
        Group group2 = (Group) a(R.id.group_non_kyc_lyt);
        k.a((Object) group2, "group_non_kyc_lyt");
        group2.setVisibility(8);
        a(R.id.non_kyc_transprent_view).setOnClickListener(onClickListener);
        View a2 = a(R.id.non_kyc_transprent_view);
        k.a((Object) a2, "non_kyc_transprent_view");
        a2.setVisibility(8);
    }

    public final void onClick(View view) {
        if (k.a((Object) view, (Object) a(R.id.non_kyc_transprent_view))) {
            startActivity(d.a().d((Activity) getContext()));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else if (k.a((Object) view, (Object) (TextView) a(R.id.contact_us_tv))) {
            Bundle bundle = new Bundle();
            bundle.putString("verticalid", this.f65921e);
            bundle.putString("l1issueid", this.f65919c);
            bundle.putString("l2issueid", this.f65920d);
            d.a().a((Context) getActivity(), bundle);
            x xVar = x.f47997a;
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.upgradeKyc.editprofile.e.b bVar = this.f65923g;
        if (bVar != null && bVar.f65828a != null) {
            if (bVar.f65828a != null) {
                net.one97.paytm.upgradeKyc.editprofile.d.a.a();
            }
            bVar.f65828a = null;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

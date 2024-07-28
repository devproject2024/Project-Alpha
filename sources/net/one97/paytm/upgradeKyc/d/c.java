package net.one97.paytm.upgradeKyc.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.KycFlowActivity;
import net.one97.paytm.upgradeKyc.activity.KycVisitActivity;
import net.one97.paytm.upgradeKyc.d.i;
import net.one97.paytm.upgradeKyc.d.k;
import net.one97.paytm.upgradeKyc.f.g;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.helper.f;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;

public final class c extends h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f65666b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ArrayList<PayTMPartnerListModal.Response> f65667a;

    /* renamed from: c  reason: collision with root package name */
    private String f65668c;

    /* renamed from: d  reason: collision with root package name */
    private String f65669d;

    /* renamed from: e  reason: collision with root package name */
    private String f65670e;

    /* renamed from: f  reason: collision with root package name */
    private String f65671f;

    /* renamed from: g  reason: collision with root package name */
    private String f65672g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f65673h;

    private View b(int i2) {
        if (this.f65673h == null) {
            this.f65673h = new HashMap();
        }
        View view = (View) this.f65673h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65673h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
        if (k.a((Object) view, (Object) b(R.id.kyc_point_lyt_container))) {
            e.a aVar = e.f66028b;
            f b2 = e.a.b();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b2.a(context, "in_person_verification", "visit_nearby_points_clicked", new ArrayList(), "", "/kyc-wallet-upgrade/aadhaar-otp/ekyc-success", "kyc");
            Intent intent = new Intent(getActivity(), KycVisitActivity.class);
            Bundle bundle = new Bundle();
            ArrayList<PayTMPartnerListModal.Response> arrayList = this.f65667a;
            if (arrayList != null) {
                bundle.putSerializable("kyc_center_list", arrayList);
                bundle.putString("doc_type", this.f65670e);
                bundle.putString("doc_number", this.f65671f);
                bundle.putString("vertical", this.f65668c);
            }
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (k.a((Object) view, (Object) b(R.id.kyc_doorstep_lyt_container))) {
            e.a aVar2 = e.f66028b;
            f b3 = e.a.b();
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            b3.a(context2, "in_person_verification", "doorstep_verification_clicked", new ArrayList(), "", "/kyc-wallet-upgrade/aadhaar-otp/ekyc-success", "kyc");
            Intent intent2 = new Intent(getActivity(), KycFlowActivity.class);
            intent2.putExtra("kyc_flow_purpose", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("doc_type", this.f65670e);
            bundle2.putString("doc_number", this.f65671f);
            bundle2.putString("vertical", this.f65668c);
            bundle2.putString("call_back_url", this.f65669d);
            ArrayList<PayTMPartnerListModal.Response> arrayList2 = this.f65667a;
            if (arrayList2 != null) {
                bundle2.putSerializable("kyc_center_list", arrayList2);
            }
            intent2.putExtras(bundle2);
            startActivity(intent2);
        } else if (k.a((Object) view, (Object) (TextView) b(R.id.ekyc_complete_know_more_tv))) {
            e.a aVar3 = e.f66028b;
            f b4 = e.a.b();
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            k.a((Object) context3, "context!!");
            b4.a(context3, "kyc_aadhaar_otp", "ekyc_benefits_know_more_clicked", new ArrayList(), "", "/kyc-wallet-upgrade/aadhaar-otp/ekyc-success", "kyc");
            FragmentActivity activity = getActivity();
            if (j.d(activity != null ? activity.getApplicationContext() : null) == 1) {
                e eVar = new e();
                androidx.fragment.app.j fragmentManager = getFragmentManager();
                if (fragmentManager == null) {
                    k.a();
                }
                eVar.show(fragmentManager, eVar.getTag());
                return;
            }
            k.a aVar4 = k.f65705a;
            String str = this.f65672g;
            k kVar = new k();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("isKycDone", 1);
            if (!TextUtils.isEmpty(str)) {
                bundle3.putString("kycExpiryDate", str);
            }
            bundle3.putBoolean("shouldShowUpgradeCTA", false);
            kVar.setArguments(bundle3);
            androidx.fragment.app.j fragmentManager2 = getFragmentManager();
            if (fragmentManager2 != null) {
                kVar.show(fragmentManager2, kVar.getTag());
            }
        } else if (kotlin.g.b.k.a((Object) view, (Object) (TextView) b(R.id.kyc_again_know_more_tv))) {
            e.a aVar5 = e.f66028b;
            f b5 = e.a.b();
            Context context4 = getContext();
            if (context4 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context4, "context!!");
            b5.a(context4, "kyc_aadhaar_otp", "why_inperson_verification_know_more_clicked", new ArrayList(), "", "/kyc-wallet-upgrade/aadhaar-otp/ekyc-success", "kyc");
            i.a aVar6 = i.f65698a;
            i a2 = i.a.a("nonAadhaarPageFooter");
            androidx.fragment.app.j fragmentManager3 = getFragmentManager();
            if (fragmentManager3 != null) {
                a2.show(fragmentManager3, a2.getTag());
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null || (serializable = arguments.getSerializable("kyc_additional_info")) == null || serializable != null) {
                Bundle arguments2 = getArguments();
                String str = null;
                this.f65668c = arguments2 != null ? arguments2.getString("vertical") : null;
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    str = arguments3.getString("call_back_url");
                }
                this.f65669d = str;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KYCDetail");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        e.a aVar = e.f66028b;
        f b2 = e.a.b();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        b2.a("/kyc-wallet-upgrade/aadhaar-otp/ekyc-success", "kyc", (Context) activity);
        return layoutInflater.inflate(R.layout.fragment_ekyc_complete_action_six, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        KYCDetail kYCDetail;
        Serializable serializable;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Context context = null;
        if (arguments == null || (serializable = arguments.getSerializable("kyc_additional_info")) == null) {
            kYCDetail = null;
        } else if (serializable != null) {
            kYCDetail = (KYCDetail) serializable;
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KYCDetail");
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getPOIType() : null)) {
            this.f65670e = kYCDetail != null ? kYCDetail.getPOIType() : null;
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getPoINumber() : null)) {
            this.f65671f = kYCDetail != null ? kYCDetail.getPoINumber() : null;
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getKycExpiryTime() : null)) {
            this.f65672g = kYCDetail != null ? kYCDetail.getKycExpiryTime() : null;
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getExpired() : null)) {
            if (p.a(kYCDetail != null ? kYCDetail.getExpired() : null, "true", true)) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    context = activity.getApplicationContext();
                }
                j.b(context, 1);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            if (androidx.core.content.b.a((Context) activity2, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 110);
            } else {
                a();
            }
        } else {
            a();
        }
        View.OnClickListener onClickListener = this;
        b(R.id.kyc_point_lyt_container).setOnClickListener(onClickListener);
        b(R.id.kyc_doorstep_lyt_container).setOnClickListener(onClickListener);
        ((TextView) b(R.id.ekyc_complete_know_more_tv)).setOnClickListener(onClickListener);
        ((TextView) b(R.id.kyc_again_know_more_tv)).setOnClickListener(onClickListener);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 110) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                a(0);
            } else {
                a();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* renamed from: net.one97.paytm.upgradeKyc.d.c$c  reason: collision with other inner class name */
    public static final class C1299c implements net.one97.paytm.upgradeKyc.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65675a;

        C1299c(c cVar) {
            this.f65675a = cVar;
        }

        public final void a() {
            com.paytm.utility.b.p();
        }

        public final void b() {
            com.paytm.utility.b.k(this.f65675a.getContext(), this.f65675a.getString(R.string.please_wait));
        }

        public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList) {
            kotlin.g.b.k.c(arrayList, "centerList");
            c cVar = this.f65675a;
            cVar.f65667a = arrayList;
            ArrayList<PayTMPartnerListModal.Response> arrayList2 = cVar.f65667a;
            Integer valueOf = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            cVar.a(valueOf.intValue());
        }

        public final void a(NetworkCustomError networkCustomError) {
            FragmentActivity activity = this.f65675a.getActivity();
            if (activity != null && networkCustomError != null) {
                l.a();
                l.a((Context) activity, networkCustomError);
            }
        }
    }

    private final void a(double d2, double d3) {
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            new net.one97.paytm.upgradeKyc.f.e(context, d2, d3, new C1299c(this)).a();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 220 && i3 == -1) {
            a();
        }
        if (i2 == 220 && i3 == 0) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            new net.one97.paytm.upgradeKyc.f.e(context, 0.0d, 0.0d, new d(this)).a();
        }
    }

    public static final class d implements net.one97.paytm.upgradeKyc.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65676a;

        d(c cVar) {
            this.f65676a = cVar;
        }

        public final void a() {
            com.paytm.utility.b.p();
        }

        public final void b() {
            com.paytm.utility.b.k(this.f65676a.getContext(), this.f65676a.getString(R.string.please_wait));
        }

        public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList) {
            kotlin.g.b.k.c(arrayList, "centerList");
            c cVar = this.f65676a;
            cVar.f65667a = arrayList;
            ArrayList<PayTMPartnerListModal.Response> arrayList2 = cVar.f65667a;
            Integer valueOf = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            cVar.a(valueOf.intValue());
        }

        public final void a(NetworkCustomError networkCustomError) {
            if (this.f65676a.getActivity() != null && networkCustomError != null) {
                l.a();
                FragmentActivity activity = this.f65676a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                l.a((Context) activity, networkCustomError);
            }
        }
    }

    private void a() {
        e.a aVar = e.f66028b;
        String s = com.paytm.utility.b.s(e.a.b().a());
        kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b2 = p.b(s);
        e.a aVar2 = e.f66028b;
        String t = com.paytm.utility.b.t(e.a.b().a());
        kotlin.g.b.k.a((Object) t, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b3 = p.b(t);
        if (b2 == null || b3 == null) {
            a(0.0d, 0.0d);
        } else {
            a(b2.doubleValue(), b3.doubleValue());
        }
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65674a;

        b(c cVar) {
            this.f65674a = cVar;
        }

        public final void a(ScreenTabModel screenTabModel) {
            kotlin.g.b.k.c(screenTabModel, "model");
            if (TextUtils.isEmpty(screenTabModel.getTab1()) && TextUtils.isEmpty(screenTabModel.getTab2())) {
                c.b(this.f65674a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && !TextUtils.isEmpty(screenTabModel.getTab2())) {
                c.b(this.f65674a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "request", true)) {
                c.a(this.f65674a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "dynamic", true)) {
                c.c(this.f65674a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "dynamic", true)) {
                c.c(this.f65674a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "request", true)) {
                c.a(this.f65674a);
            }
            c.d(this.f65674a);
        }

        public final void a(NetworkCustomError networkCustomError) {
            if (this.f65674a.getActivity() != null && networkCustomError != null) {
                l.a();
                FragmentActivity activity = this.f65674a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                if (!l.a((Context) activity, networkCustomError)) {
                    com.paytm.utility.b.p();
                    c.d(this.f65674a);
                    c.b(this.f65674a);
                }
            }
        }

        public final void a() {
            com.paytm.utility.b.p();
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            new net.one97.paytm.upgradeKyc.f.h(context, i2, new b(this)).a();
        }
    }

    public static final /* synthetic */ void a(c cVar) {
        View b2 = cVar.b(R.id.kyc_point_lyt_container);
        kotlin.g.b.k.a((Object) b2, "kyc_point_lyt_container");
        b2.setVisibility(8);
        ImageView imageView = (ImageView) cVar.b(R.id.kyc_point_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView, "kyc_point_right_arrow_iv");
        imageView.setVisibility(8);
        TextView textView = (TextView) cVar.b(R.id.carry_doc_tv);
        kotlin.g.b.k.a((Object) textView, "carry_doc_tv");
        textView.setVisibility(8);
        TextView textView2 = (TextView) cVar.b(R.id.visit_kyc_tv);
        kotlin.g.b.k.a((Object) textView2, "visit_kyc_tv");
        textView2.setVisibility(8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) cVar.b(R.id.kyc_point_iv);
        kotlin.g.b.k.a((Object) appCompatImageView, "kyc_point_iv");
        appCompatImageView.setVisibility(8);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) cVar.b(R.id.kyc_doorstep_iv);
        kotlin.g.b.k.a((Object) appCompatImageView2, "kyc_doorstep_iv");
        appCompatImageView2.setVisibility(0);
        TextView textView3 = (TextView) cVar.b(R.id.doorstep_kyc_tv);
        kotlin.g.b.k.a((Object) textView3, "doorstep_kyc_tv");
        textView3.setVisibility(0);
        TextView textView4 = (TextView) cVar.b(R.id.agent_visit_tv);
        kotlin.g.b.k.a((Object) textView4, "agent_visit_tv");
        textView4.setVisibility(0);
        ImageView imageView2 = (ImageView) cVar.b(R.id.doorstep_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView2, "doorstep_right_arrow_iv");
        imageView2.setVisibility(0);
        View b3 = cVar.b(R.id.kyc_doorstep_lyt_container);
        kotlin.g.b.k.a((Object) b3, "kyc_doorstep_lyt_container");
        b3.setVisibility(0);
    }

    public static final /* synthetic */ void b(c cVar) {
        View b2 = cVar.b(R.id.kyc_point_lyt_container);
        kotlin.g.b.k.a((Object) b2, "kyc_point_lyt_container");
        b2.setVisibility(0);
        ImageView imageView = (ImageView) cVar.b(R.id.kyc_point_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView, "kyc_point_right_arrow_iv");
        imageView.setVisibility(0);
        TextView textView = (TextView) cVar.b(R.id.carry_doc_tv);
        kotlin.g.b.k.a((Object) textView, "carry_doc_tv");
        textView.setVisibility(0);
        if (!TextUtils.isEmpty(cVar.f65670e)) {
            TextView textView2 = (TextView) cVar.b(R.id.carry_doc_tv);
            kotlin.g.b.k.a((Object) textView2, "carry_doc_tv");
            textView2.setText(cVar.getString(R.string.carry_doc_to_point, cVar.f65670e));
        } else {
            TextView textView3 = (TextView) cVar.b(R.id.carry_doc_tv);
            kotlin.g.b.k.a((Object) textView3, "carry_doc_tv");
            textView3.setText(cVar.getString(R.string.carry_document_to_point));
        }
        TextView textView4 = (TextView) cVar.b(R.id.visit_kyc_tv);
        kotlin.g.b.k.a((Object) textView4, "visit_kyc_tv");
        textView4.setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) cVar.b(R.id.kyc_point_iv);
        kotlin.g.b.k.a((Object) appCompatImageView, "kyc_point_iv");
        appCompatImageView.setVisibility(0);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) cVar.b(R.id.kyc_doorstep_iv);
        kotlin.g.b.k.a((Object) appCompatImageView2, "kyc_doorstep_iv");
        appCompatImageView2.setVisibility(0);
        TextView textView5 = (TextView) cVar.b(R.id.doorstep_kyc_tv);
        kotlin.g.b.k.a((Object) textView5, "doorstep_kyc_tv");
        textView5.setVisibility(0);
        TextView textView6 = (TextView) cVar.b(R.id.agent_visit_tv);
        kotlin.g.b.k.a((Object) textView6, "agent_visit_tv");
        textView6.setVisibility(0);
        ImageView imageView2 = (ImageView) cVar.b(R.id.doorstep_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView2, "doorstep_right_arrow_iv");
        imageView2.setVisibility(0);
        View b3 = cVar.b(R.id.kyc_doorstep_lyt_container);
        kotlin.g.b.k.a((Object) b3, "kyc_doorstep_lyt_container");
        b3.setVisibility(0);
    }

    public static final /* synthetic */ void c(c cVar) {
        View b2 = cVar.b(R.id.kyc_point_lyt_container);
        kotlin.g.b.k.a((Object) b2, "kyc_point_lyt_container");
        b2.setVisibility(0);
        ImageView imageView = (ImageView) cVar.b(R.id.kyc_point_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView, "kyc_point_right_arrow_iv");
        imageView.setVisibility(0);
        TextView textView = (TextView) cVar.b(R.id.carry_doc_tv);
        kotlin.g.b.k.a((Object) textView, "carry_doc_tv");
        textView.setVisibility(0);
        TextView textView2 = (TextView) cVar.b(R.id.visit_kyc_tv);
        kotlin.g.b.k.a((Object) textView2, "visit_kyc_tv");
        textView2.setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) cVar.b(R.id.kyc_point_iv);
        kotlin.g.b.k.a((Object) appCompatImageView, "kyc_point_iv");
        appCompatImageView.setVisibility(0);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) cVar.b(R.id.kyc_doorstep_iv);
        kotlin.g.b.k.a((Object) appCompatImageView2, "kyc_doorstep_iv");
        appCompatImageView2.setVisibility(8);
        TextView textView3 = (TextView) cVar.b(R.id.doorstep_kyc_tv);
        kotlin.g.b.k.a((Object) textView3, "doorstep_kyc_tv");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) cVar.b(R.id.agent_visit_tv);
        kotlin.g.b.k.a((Object) textView4, "agent_visit_tv");
        textView4.setVisibility(8);
        ImageView imageView2 = (ImageView) cVar.b(R.id.doorstep_right_arrow_iv);
        kotlin.g.b.k.a((Object) imageView2, "doorstep_right_arrow_iv");
        imageView2.setVisibility(8);
        View b3 = cVar.b(R.id.kyc_doorstep_lyt_container);
        kotlin.g.b.k.a((Object) b3, "kyc_doorstep_lyt_container");
        b3.setVisibility(8);
    }

    public static final /* synthetic */ void d(c cVar) {
        FragmentActivity activity = cVar.getActivity();
        Context context = null;
        String g2 = j.g(activity != null ? activity.getApplicationContext() : null);
        CharSequence charSequence = g2;
        if (!TextUtils.isEmpty(charSequence)) {
            cVar.f65672g = g2;
            if (!TextUtils.isEmpty(charSequence)) {
                TextView textView = (TextView) cVar.b(R.id.ekyc_complete_know_more_tv);
                kotlin.g.b.k.a((Object) textView, "ekyc_complete_know_more_tv");
                textView.setVisibility(0);
                TextView textView2 = (TextView) cVar.b(R.id.valid_till_tv);
                kotlin.g.b.k.a((Object) textView2, "valid_till_tv");
                textView2.setVisibility(0);
                TextView textView3 = (TextView) cVar.b(R.id.valid_till_tv);
                kotlin.g.b.k.a((Object) textView3, "valid_till_tv");
                textView3.setText(cVar.getString(R.string.valid_till_date, g2));
            }
        } else if (!TextUtils.isEmpty(cVar.f65672g)) {
            cVar.f65672g = net.one97.paytm.upgradeKyc.utils.c.a(cVar.f65672g);
            TextView textView4 = (TextView) cVar.b(R.id.ekyc_complete_know_more_tv);
            kotlin.g.b.k.a((Object) textView4, "ekyc_complete_know_more_tv");
            textView4.setVisibility(0);
            TextView textView5 = (TextView) cVar.b(R.id.valid_till_tv);
            kotlin.g.b.k.a((Object) textView5, "valid_till_tv");
            textView5.setVisibility(0);
            String a2 = net.one97.paytm.upgradeKyc.utils.c.a(cVar.f65672g);
            TextView textView6 = (TextView) cVar.b(R.id.valid_till_tv);
            kotlin.g.b.k.a((Object) textView6, "valid_till_tv");
            textView6.setText(cVar.getString(R.string.valid_till_date, a2));
            FragmentActivity activity2 = cVar.getActivity();
            j.d(activity2 != null ? activity2.getApplicationContext() : null, cVar.f65672g);
        } else {
            TextView textView7 = (TextView) cVar.b(R.id.ekyc_complete_know_more_tv);
            kotlin.g.b.k.a((Object) textView7, "ekyc_complete_know_more_tv");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) cVar.b(R.id.valid_till_tv);
            kotlin.g.b.k.a((Object) textView8, "valid_till_tv");
            textView8.setVisibility(8);
        }
        FragmentActivity activity3 = cVar.getActivity();
        if (j.d(activity3 != null ? activity3.getApplicationContext() : null) == 1) {
            FragmentActivity activity4 = cVar.getActivity();
            if (activity4 != null) {
                context = activity4.getApplicationContext();
            }
            String g3 = j.g(context);
            kotlin.g.b.k.a((Object) g3, "KycSharedPrefs.getKeyKyc…vity?.applicationContext)");
            TextView textView9 = (TextView) cVar.b(R.id.your_ekyc_tv);
            kotlin.g.b.k.a((Object) textView9, "your_ekyc_tv");
            textView9.setText(cVar.getString(R.string.your_kyc_has_expired_on, g3));
            TextView textView10 = (TextView) cVar.b(R.id.valid_till_tv);
            kotlin.g.b.k.a((Object) textView10, "valid_till_tv");
            textView10.setVisibility(8);
            TextView textView11 = (TextView) cVar.b(R.id.ekyc_complete_know_more_tv);
            kotlin.g.b.k.a((Object) textView11, "ekyc_complete_know_more_tv");
            textView11.setVisibility(0);
            ((TextView) cVar.b(R.id.your_ekyc_tv)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pending_copy, 0);
        }
        TextView textView12 = (TextView) cVar.b(R.id.your_ekyc_tv);
        kotlin.g.b.k.a((Object) textView12, "your_ekyc_tv");
        textView12.setVisibility(0);
        View b2 = cVar.b(R.id.ekyc_success_separator);
        kotlin.g.b.k.a((Object) b2, "ekyc_success_separator");
        b2.setVisibility(0);
        TextView textView13 = (TextView) cVar.b(R.id.select_a_method_tv);
        kotlin.g.b.k.a((Object) textView13, "select_a_method_tv");
        textView13.setVisibility(0);
        View b3 = cVar.b(R.id.kyc_again_footer_lyt);
        kotlin.g.b.k.a((Object) b3, "kyc_again_footer_lyt");
        b3.setVisibility(0);
        if (j.d(cVar.getActivity()) == 1) {
            TextView textView14 = (TextView) cVar.b(R.id.select_a_method_tv);
            kotlin.g.b.k.a((Object) textView14, "select_a_method_tv");
            textView14.setText(cVar.getString(R.string.select_method_to_complete));
            return;
        }
        TextView textView15 = (TextView) cVar.b(R.id.select_a_method_tv);
        kotlin.g.b.k.a((Object) textView15, "select_a_method_tv");
        textView15.setText(cVar.getString(R.string.select_a_method_to_extend_validity_of_your_kyc_and_get_more_benefits));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65673h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

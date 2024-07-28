package net.one97.paytm.upgradeKyc.d;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.KycVisitActivity;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;

public final class h extends net.one97.paytm.i.h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PayTMPartnerListModal.Response> f65692a;

    /* renamed from: b  reason: collision with root package name */
    private String f65693b;

    /* renamed from: c  reason: collision with root package name */
    private String f65694c;

    /* renamed from: d  reason: collision with root package name */
    private String f65695d;

    /* renamed from: e  reason: collision with root package name */
    private String f65696e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f65697f;

    private View a(int i2) {
        if (this.f65697f == null) {
            this.f65697f = new HashMap();
        }
        View view = (View) this.f65697f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65697f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str = null;
            this.f65695d = arguments != null ? arguments.getString("vertical") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("call_back_url");
            }
            this.f65696e = str;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.kyc_processing_instant_kyc_nearby_lyt, viewGroup, false);
    }

    public final void onClick(View view) {
        q qVar = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.view_point_btn;
        if (valueOf != null && valueOf.intValue() == i2) {
            Intent intent = new Intent(getActivity(), KycVisitActivity.class);
            Bundle bundle = new Bundle();
            ArrayList<PayTMPartnerListModal.Response> arrayList = this.f65692a;
            if (arrayList != null) {
                bundle.putSerializable("kyc_center_list", arrayList);
                bundle.putString("doc_type", this.f65693b);
                bundle.putString("doc_number", this.f65694c);
                bundle.putString("vertical", this.f65695d);
            }
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        int i3 = R.id.lyt_doorstep;
        if (valueOf != null && valueOf.intValue() == i3) {
            s sVar = new s();
            sVar.setArguments(getArguments());
            j fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                qVar = fragmentManager.a();
            }
            if (qVar != null) {
                qVar.b(R.id.fragment_container, sVar, "RequestVistFrag").a("").c();
                return;
            }
            return;
        }
        int i4 = R.id.lyt_instant_kyc;
        if (valueOf != null && valueOf.intValue() == i4) {
            Intent intent2 = new Intent(getActivity(), UpgradeKycActivity.class);
            intent2.setFlags(67108864);
            intent2.putExtra("coming_from_screen", h.class.getName());
            startActivity(intent2);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        KYCDetail kYCDetail;
        Serializable serializable;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable2 = null;
        if (arguments == null || (serializable = arguments.getSerializable("kyc_additional_info")) == null) {
            kYCDetail = null;
        } else if (serializable != null) {
            kYCDetail = (KYCDetail) serializable;
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.KYCDetail");
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getPOIType() : null)) {
            this.f65693b = kYCDetail != null ? kYCDetail.getPOIType() : null;
        }
        if (!TextUtils.isEmpty(kYCDetail != null ? kYCDetail.getPoINumber() : null)) {
            this.f65694c = kYCDetail != null ? kYCDetail.getPoINumber() : null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            serializable2 = arguments2.getSerializable("kyc_center_list");
        }
        this.f65692a = (ArrayList) serializable2;
        View.OnClickListener onClickListener = this;
        a(R.id.lyt_instant_kyc).setOnClickListener(onClickListener);
        a(R.id.lyt_doorstep).setOnClickListener(onClickListener);
        ((Button) a(R.id.view_point_btn)).setOnClickListener(onClickListener);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65697f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

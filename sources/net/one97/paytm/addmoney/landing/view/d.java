package net.one97.paytm.addmoney.landing.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.a;
import net.one97.paytm.addmoney.common.model.CJRAddmoneyActivateWallet;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.i.f;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends f implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<TncData> f48631a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f48632b;

    public final View a(int i2) {
        if (this.f48632b == null) {
            this.f48632b = new HashMap();
        }
        View view = (View) this.f48632b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f48632b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(false);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        ArrayList<TncData> tncDataList;
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        if (iJRPaytmDataModel instanceof KYCFetchTnc) {
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
            if (kYCFetchTnc.getStatus() == null) {
                return;
            }
            if (p.a(kYCFetchTnc.getStatus(), "error", true)) {
                if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), kYCFetchTnc.getMessage());
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
                }
            } else if (p.a(kYCFetchTnc.getStatus(), "success", true) && (tncDataList = kYCFetchTnc.getTncDataList()) != null && (!tncDataList.isEmpty())) {
                ArrayList<TncData> tncDataList2 = kYCFetchTnc.getTncDataList();
                k.a((Object) tncDataList2, "p0.tncDataList");
                this.f48631a = tncDataList2;
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (!p.a(kYCTncAccept.getStatus(), "success", true) || !k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
            } else if (getActivity() != null) {
                String f2 = net.one97.paytm.helper.a.f50546a.a().f("createWalletUrl");
                if (URLUtil.isValidUrl(f2)) {
                    Map hashMap = new HashMap();
                    String a2 = com.paytm.utility.d.a(getActivity());
                    k.a((Object) a2, "CJRNetUtility.getSSOToken(activity)");
                    hashMap.put("session_token", a2);
                    hashMap.put("Accept", "application/json");
                    hashMap.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(com.paytm.utility.b.n(getContext()))) {
                        jSONObject.put("custId", Integer.parseInt(com.paytm.utility.b.n(getContext())));
                    }
                    a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
                    com.paytm.network.a l = a.C0848a.b().a(f2).a((Map<String, String>) hashMap).b(jSONObject.toString()).a((IJRPaytmDataModel) new CJRAddmoneyActivateWallet((String) null, (String) null, 3, (g) null)).f().a((com.paytm.network.listener.b) this).c(d.class.getName()).l();
                    if (com.paytm.utility.b.c((Context) getActivity())) {
                        l.a();
                    } else {
                        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.no_internet));
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRAddmoneyActivateWallet) {
            String msg = ((CJRAddmoneyActivateWallet) iJRPaytmDataModel).getMsg();
            if (msg == null || !p.a(msg, "SUCCESS", true)) {
                a(false);
            } else {
                a(true);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.am_activate_wallet_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            String f2 = net.one97.paytm.helper.a.f50546a.a().f("fetchTncActivateWalletUrl");
            if (URLUtil.isValidUrl(f2)) {
                String e2 = com.paytm.utility.b.e((Context) getActivity(), f2);
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(getActivity());
                k.a((Object) a2, "CJRNetUtility.getSSOToken(activity)");
                hashMap.put("session_token", a2);
                hashMap.put("Accept", "application/json");
                hashMap.put("Content-Type", "application/json");
                a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
                com.paytm.network.a l = a.C0848a.a().a(e2).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KYCFetchTnc()).f().a((com.paytm.network.listener.b) this).c(d.class.getName()).l();
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    l.a();
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.no_internet));
                }
            }
        }
        ((ImageView) a(R.id.cross_btn)).setOnClickListener(new a(this));
        ((TextView) a(R.id.activate_wallet_tv)).setOnClickListener(new c(this));
        ((TextView) a(R.id.tnc_tv)).setOnClickListener(new C0853d(this));
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(b.f48634a);
        return onCreateDialog;
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f48634a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) findViewById);
                    k.a((Object) from, "BottomSheetBehavior.from<View>(bottomSheet)");
                    from.setState(3);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f48635a;

        c(d dVar) {
            this.f48635a = dVar;
        }

        public final void onClick(View view) {
            if (!this.f48635a.f48631a.isEmpty()) {
                CheckBox checkBox = (CheckBox) this.f48635a.a(R.id.tnc_cb);
                k.a((Object) checkBox, "tnc_cb");
                if (checkBox.isChecked()) {
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f48635a.a(R.id.wallet_loader));
                    d.a(this.f48635a);
                    return;
                }
                Snackbar.a((View) (ConstraintLayout) this.f48635a.a(R.id.activate_wallet_parent_lyt), (CharSequence) this.f48635a.getString(R.string.am_accept_tnc), -1).c();
                return;
            }
            Snackbar.a((View) (ConstraintLayout) this.f48635a.a(R.id.activate_wallet_parent_lyt), (CharSequence) this.f48635a.getString(R.string.please_wait), -1).c();
        }
    }

    /* renamed from: net.one97.paytm.addmoney.landing.view.d$d  reason: collision with other inner class name */
    static final class C0853d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f48636a;

        C0853d(d dVar) {
            this.f48636a = dVar;
        }

        public final void onClick(View view) {
            if (!this.f48636a.f48631a.isEmpty()) {
                d.b(this.f48636a);
            } else {
                Snackbar.a((View) (ConstraintLayout) this.f48636a.a(R.id.activate_wallet_parent_lyt), (CharSequence) this.f48636a.getString(R.string.please_wait), -1).c();
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f48633a;

        a(d dVar) {
            this.f48633a = dVar;
        }

        public final void onClick(View view) {
            this.f48633a.dismiss();
        }
    }

    private final void a(boolean z) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_activated", z);
        cVar.setArguments(bundle);
        j fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            k.a();
        }
        cVar.show(fragmentManager, cVar.getClass().getName());
        dismiss();
    }

    public static final /* synthetic */ void a(d dVar) {
        if (dVar.getActivity() != null) {
            String f2 = net.one97.paytm.helper.a.f50546a.a().f("acceptTncActivateWalletUrl");
            if (URLUtil.isValidUrl(f2)) {
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(dVar.getActivity());
                k.a((Object) a2, "CJRNetUtility.getSSOToken(activity)");
                hashMap.put("session_token", a2);
                hashMap.put("Accept", "application/json");
                hashMap.put("Content-Type", "application/json");
                String m = com.paytm.utility.b.m();
                k.a((Object) m, "CJRAppCommonUtility.getAuthorizationValue()");
                hashMap.put("Authorization", m);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                TncData tncData = dVar.f48631a.get(0);
                k.a((Object) tncData, "tncArrayList[0]");
                jSONObject.put("code", tncData.getCode());
                TncData tncData2 = dVar.f48631a.get(0);
                k.a((Object) tncData2, "tncArrayList[0]");
                jSONObject.put("version", tncData2.getVersion());
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mode", "clickthrough");
                jSONObject2.put("tnCList", jSONArray);
                a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
                com.paytm.network.a l = a.C0848a.c().a(f2).a((Map<String, String>) hashMap).b(jSONObject2.toString()).a((IJRPaytmDataModel) new KYCTncAccept()).f().a((com.paytm.network.listener.b) dVar).c(d.class.getName()).l();
                if (com.paytm.utility.b.c((Context) dVar.getActivity())) {
                    l.a();
                } else {
                    com.paytm.utility.b.b((Context) dVar.getActivity(), dVar.getString(R.string.error), dVar.getString(R.string.no_internet));
                }
            }
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = dVar.getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Intent j = a2.j(activity);
        TncData tncData = dVar.f48631a.get(0);
        k.a((Object) tncData, "tncArrayList[0]");
        j.putExtra("url", tncData.getUrl());
        j.putExtra("title", dVar.getString(R.string.terms_and_conditions_title));
        dVar.startActivity(j);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f48632b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

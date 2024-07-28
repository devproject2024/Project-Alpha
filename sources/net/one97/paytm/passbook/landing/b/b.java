package net.one97.paytm.passbook.landing.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRActivateWallet;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.r;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.google.android.material.bottomsheet.b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<TncData> f57587a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f57588b;

    public final View a(int i2) {
        if (this.f57588b == null) {
            this.f57588b = new HashMap();
        }
        View view = (View) this.f57588b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57588b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a(false);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.passbook.utility.a.b((LottieAnimationView) a(R.id.wallet_loader));
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
            } else if (p.a(kYCFetchTnc.getStatus(), "success", true)) {
                ArrayList<TncData> tncDataList = kYCFetchTnc.getTncDataList();
                if (tncDataList == null || !(!tncDataList.isEmpty())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
                    return;
                }
                ArrayList<TncData> tncDataList2 = kYCFetchTnc.getTncDataList();
                k.a((Object) tncDataList2, "p0.tncDataList");
                this.f57587a = tncDataList2;
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (!p.a(kYCTncAccept.getStatus(), "success", true) || !k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
                return;
            }
            k.a((Object) e.a(), "GTMLoader.getInstance()");
            String v = e.v();
            if (URLUtil.isValidUrl(v)) {
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
                com.paytm.network.a l = new com.paytm.network.b().a((Context) getActivity()).a(v).a((Map<String, String>) hashMap).a(a.C0715a.POST).b(jSONObject.toString()).a(a.c.PASSBOOK).a(a.b.SILENT).a((IJRPaytmDataModel) new CJRActivateWallet((String) null, (String) null, 3, (g) null)).f().a((com.paytm.network.listener.b) this).c(b.class.getName()).l();
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    l.a();
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.no_internet));
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRActivateWallet) {
            String msg = ((CJRActivateWallet) iJRPaytmDataModel).getMsg();
            if (msg == null || !p.a(msg, "SUCCESS", true)) {
                a(false);
                return;
            }
            a(true);
            r.INSTANCE.setIsWalletActivated("inProgress");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_wallet_activate_bottom_sheet_lyt, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String w = e.w();
        if (URLUtil.isValidUrl(w)) {
            String e2 = com.paytm.utility.b.e((Context) getActivity(), w);
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(getActivity());
            k.a((Object) a2, "CJRNetUtility.getSSOToken(activity)");
            hashMap.put("session_token", a2);
            hashMap.put("Accept", "application/json");
            hashMap.put("Content-Type", "application/json");
            com.paytm.network.a l = new com.paytm.network.b().a((Context) getActivity()).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PASSBOOK).a(a.b.SILENT).a((IJRPaytmDataModel) new KYCFetchTnc()).f().a((com.paytm.network.listener.b) this).c(b.class.getName()).l();
            if (com.paytm.utility.b.c((Context) getActivity())) {
                l.a();
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.no_internet));
            }
        }
        ((TextView) a(R.id.activate_wallet_tv)).setOnClickListener(new c(this));
        ((TextView) a(R.id.tnc_tv)).setOnClickListener(new d(this));
        ((ImageView) a(R.id.cross_btn)).setOnClickListener(new a(this));
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(C1088b.f57590a);
        return onCreateDialog;
    }

    /* renamed from: net.one97.paytm.passbook.landing.b.b$b  reason: collision with other inner class name */
    static final class C1088b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C1088b f57590a = new C1088b();

        C1088b() {
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
        final /* synthetic */ b f57591a;

        c(b bVar) {
            this.f57591a = bVar;
        }

        public final void onClick(View view) {
            if (!this.f57591a.f57587a.isEmpty()) {
                CheckBox checkBox = (CheckBox) this.f57591a.a(R.id.tnc_cb);
                k.a((Object) checkBox, "tnc_cb");
                if (checkBox.isChecked()) {
                    net.one97.paytm.passbook.utility.a.a((LottieAnimationView) this.f57591a.a(R.id.wallet_loader));
                    b.a(this.f57591a);
                    return;
                }
                Snackbar.a((View) (ConstraintLayout) this.f57591a.a(R.id.activate_wallet_parent_lyt), (CharSequence) this.f57591a.getString(R.string.accept_tnc), -1).c();
                return;
            }
            Snackbar.a((View) (ConstraintLayout) this.f57591a.a(R.id.activate_wallet_parent_lyt), (CharSequence) this.f57591a.getString(R.string.please_wait), -1).c();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57592a;

        d(b bVar) {
            this.f57592a = bVar;
        }

        public final void onClick(View view) {
            b.b(this.f57592a);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57589a;

        a(b bVar) {
            this.f57589a = bVar;
        }

        public final void onClick(View view) {
            this.f57589a.dismiss();
        }
    }

    private final void a(boolean z) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_activated", z);
        aVar.setArguments(bundle);
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            aVar.show(fragmentManager, aVar.getClass().getName());
        }
        dismiss();
    }

    public static final /* synthetic */ void a(b bVar) {
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String x = e.x();
        if (URLUtil.isValidUrl(x)) {
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(bVar.getActivity());
            k.a((Object) a2, "CJRNetUtility.getSSOToken(activity)");
            hashMap.put("session_token", a2);
            hashMap.put("Accept", "application/json");
            hashMap.put("Content-Type", "application/json");
            String m = com.paytm.utility.b.m();
            k.a((Object) m, "CJRAppCommonUtility.getAuthorizationValue()");
            hashMap.put("Authorization", m);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            TncData tncData = bVar.f57587a.get(0);
            k.a((Object) tncData, "tncArrayList[0]");
            jSONObject.put("code", tncData.getCode());
            TncData tncData2 = bVar.f57587a.get(0);
            k.a((Object) tncData2, "tncArrayList[0]");
            jSONObject.put("version", tncData2.getVersion());
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mode", "clickthrough");
            jSONObject2.put("tnCList", jSONArray);
            com.paytm.network.a l = new com.paytm.network.b().a((Context) bVar.getActivity()).a(x).a((Map<String, String>) hashMap).a(a.C0715a.PUT).b(jSONObject2.toString()).a(a.c.PASSBOOK).a(a.b.SILENT).a((IJRPaytmDataModel) new KYCTncAccept()).f().a((com.paytm.network.listener.b) bVar).c(b.class.getName()).l();
            if (com.paytm.utility.b.c((Context) bVar.getActivity())) {
                l.a();
            } else {
                com.paytm.utility.b.b((Context) bVar.getActivity(), bVar.getString(R.string.error), bVar.getString(R.string.no_internet));
            }
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        TncData tncData = bVar.f57587a.get(0);
        k.a((Object) tncData, "tncArrayList[0]");
        net.one97.paytm.passbook.d.b().a((Context) bVar.getActivity(), tncData.getUrl(), bVar.getString(R.string.terms_and_conditions_title));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57588b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

package net.one97.paytm.savedPaymentItem;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.b;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRDisableOneClickResponse;
import net.one97.paytm.common.entity.shopping.CJRSavedCards;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.recharge.model.CJRDeleteCard;
import net.one97.paytm.savedPaymentItem.a;
import net.one97.paytm.savedPaymentItem.c;
import net.one97.paytm.savedPaymentItem.d;
import net.one97.paytm.u;
import net.one97.paytm.upi.util.HorizontalDividerItemDecoration;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends net.one97.paytm.i.a implements View.OnClickListener, a.C1284a, c.a, d.a, u {

    /* renamed from: a  reason: collision with root package name */
    CJRSavedCards f65023a = new CJRSavedCards();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public b f65024b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f65025c;

    /* renamed from: d  reason: collision with root package name */
    TextView f65026d;

    /* renamed from: e  reason: collision with root package name */
    boolean f65027e = true;

    /* renamed from: f  reason: collision with root package name */
    private b f65028f;

    /* renamed from: g  reason: collision with root package name */
    private a f65029g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f65030h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f65031i;
    private ImageView j;
    /* access modifiers changed from: private */
    public d k;
    private String l;
    private String m;
    private String n;

    public interface a {
        void a();
    }

    public void onServerDataLoaded() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lyt_fragment_savedcards, (ViewGroup) null);
        this.f65026d = (TextView) inflate.findViewById(R.id.tv_add_new_card);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.list_view_saved_cards);
        this.f65030h = (RelativeLayout) inflate.findViewById(R.id.delete_card_error_slider);
        this.j = (ImageView) inflate.findViewById(R.id.delete_card_error_remove_icon);
        this.f65031i = (TextView) inflate.findViewById(R.id.delete_card_error_text);
        this.f65025c = (LinearLayout) inflate.findViewById(R.id.lyt_no_saved_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration(getActivity(), androidx.core.content.b.a((Context) getActivity(), (int) R.drawable.upi_divider), com.paytm.utility.b.a(24.0f, (Context) getActivity())));
        this.f65024b = new b(getActivity(), this.f65023a, this);
        recyclerView.setAdapter(this.f65024b);
        this.f65026d.setOnClickListener(this);
        ((RelativeLayout) inflate.findViewById(R.id.no_card_add_new)).setOnClickListener(this);
        this.j.setOnClickListener(this);
        setRetainInstance(true);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f65029g = (a) activity;
        }
        if (this.f65028f == null) {
            this.f65028f = new b();
        }
        this.f65028f.f52339a = activity;
    }

    public void onDetach() {
        super.onDetach();
        b bVar = this.f65028f;
        if (bVar != null) {
            bVar.f52339a = null;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_card_button:
            case R.id.no_card_add_new:
            case R.id.tv_add_new_card:
                if (this.f65028f != null && getActivity() != null) {
                    new a(getActivity(), this).show();
                    return;
                }
                return;
            case R.id.delete_card_error_remove_icon:
            case R.id.ok_btn:
                this.f65030h.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public final void a() {
        b bVar = this.f65028f;
        if (bVar.f52339a != null && !bVar.f52339a.isFinishing()) {
            try {
                bVar.f52340b = "1";
                if (bVar.f52339a == null) {
                    return;
                }
                if (!bVar.f52339a.isFinishing()) {
                    JSONObject c2 = bVar.c();
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    String b2 = com.paytm.utility.b.b((Context) bVar.f52339a, net.one97.paytm.helper.a.b().f("cartVerify"));
                    if (com.paytm.utility.b.c((Context) bVar.f52339a)) {
                        bVar.a();
                        com.paytm.network.b b3 = net.one97.paytm.addmoney.common.a.b();
                        b3.f42885i = new CJRRechargeCart();
                        b3.f42884h = c2.toString();
                        b3.f42880d = b2;
                        b3.j = bVar;
                        b3.f42882f = hashMap;
                        b3.l().a();
                        return;
                    }
                    bVar.b();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        this.l = str;
        this.m = str2;
        this.n = str3;
    }

    private void b() {
        this.l = null;
        this.m = null;
        this.n = null;
    }

    private String c(String str) {
        net.one97.paytm.j.c.a();
        String i2 = net.one97.paytm.j.c.i();
        String b2 = t.b((Context) getActivity());
        try {
            return Uri.parse(i2).buildUpon().appendQueryParameter("JsonData", "{\"SSOToken\":\"" + b2 + "\",\"SavedCardId\":\"" + str + "\"}").build().toString();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
            return null;
        }
    }

    public final void a(int i2, String str, String str2, String str3, String str4, String str5) {
        if (getActivity() != null) {
            this.k = new d(getActivity(), this, i2, str, str2, str3, str4, str5);
            this.k.show();
        }
    }

    public final void b(final int i2, final String str, String str2, String str3, String str4, String str5) {
        String b2 = t.b((Context) getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(StringSet.token, b2);
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("vscp_deenroll_url", (String) null);
        String deEnrollmentData = CJRJarvisApplication.a(getContext()).getDeEnrollmentData(str, str2, str3, str4, str5);
        new JSONObject();
        new JSONObject();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(StringSet.token, b2);
            jSONObject2.put("head", jSONObject);
            jSONObject2.put("body", new JSONObject(deEnrollmentData));
            int i3 = i2;
            String str6 = str;
            final String str7 = str2;
            AnonymousClass1 r0 = new com.paytm.network.listener.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    CJRDisableOneClickResponse cJRDisableOneClickResponse = (CJRDisableOneClickResponse) iJRPaytmDataModel;
                    if (cJRDisableOneClickResponse.getBodyObject() != null && cJRDisableOneClickResponse.getBodyObject().getResultInfo() != null) {
                        HashMap<String, String> resultInfo = cJRDisableOneClickResponse.getBodyObject().getResultInfo();
                        if (!TextUtils.isEmpty(resultInfo.get("resultStatus")) && "S".equalsIgnoreCase(resultInfo.get("resultStatus")) && !TextUtils.isEmpty(resultInfo.get("resultMsg"))) {
                            if (e.this.k != null && e.this.k.isShowing()) {
                                e.this.k.dismiss();
                            }
                            e eVar = e.this;
                            net.one97.paytm.j.c.a();
                            eVar.a(net.one97.paytm.j.c.a("disable_oc_success", e.this.getResources().getString(R.string.disable_oc_success)), true);
                            CJRJarvisApplication.a(e.this.getContext()).clearEnrollment(str, str7, "", com.paytm.utility.a.a(e.this.getContext()));
                            e.this.f65024b.notifyItemChanged(i2);
                        } else if ((e.this.isAdded() && !e.this.isRemoving()) || e.this.k.isShowing()) {
                            e.this.k.b();
                        }
                    } else if ((e.this.isAdded() && !e.this.isRemoving()) || e.this.k.isShowing()) {
                        e.this.k.b();
                    }
                }
            };
            if (!TextUtils.isEmpty(deEnrollmentData)) {
                com.paytm.network.a a3 = net.one97.paytm.common.b.d.a(getActivity(), a2, r0, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject2.toString().replace("\\", ""), new CJRDisableOneClickResponse(), a.c.PAYMENTS, a.b.SILENT);
                if (com.paytm.utility.a.m(getActivity())) {
                    a3.a();
                } else if (getActivity() != null) {
                    showNetworkDialogNew(a3);
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        if (isAdded() && !isRemoving()) {
            b();
            a(getResources().getString(R.string.delete_card_error_msg), false);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onApiSuccess(iJRPaytmDataModel);
        if (iJRPaytmDataModel instanceof CJRDeleteCard) {
            CJRDeleteCard cJRDeleteCard = (CJRDeleteCard) iJRPaytmDataModel;
            if (cJRDeleteCard.getStatus() == null || TextUtils.isEmpty(cJRDeleteCard.getStatus())) {
                if (cJRDeleteCard.getErrorMessage() == null || TextUtils.isEmpty(cJRDeleteCard.getErrorMessage())) {
                    a(getResources().getString(R.string.delete_card_error_msg), false);
                } else {
                    a(cJRDeleteCard.getErrorMessage(), false);
                }
            } else if (cJRDeleteCard.getStatus().equalsIgnoreCase("success")) {
                this.f65029g.a();
                VisaSCP a2 = CJRJarvisApplication.a(getContext());
                if (a2 != null) {
                    a2.clearEnrollment(this.l, this.m, "", com.paytm.utility.a.a(getContext()));
                }
            }
            b();
        }
    }

    public final void a(String str, boolean z) {
        this.f65030h.setVisibility(0);
        this.f65031i.setText(str);
        if (z) {
            this.f65030h.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_fff5e5));
            this.f65031i.setTextColor(androidx.core.content.b.c(getContext(), R.color.color_1d252d));
            this.j.setVisibility(8);
            return;
        }
        this.f65030h.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.custom));
        this.f65031i.setTextColor(androidx.core.content.b.c(getContext(), R.color.white));
        this.j.setVisibility(0);
    }

    public final void a(String str) {
        if (getActivity() != null) {
            new c(getActivity(), str, this).show();
        }
    }

    public final void b(String str) {
        if (com.paytm.utility.a.m(getActivity())) {
            t.b((Context) getActivity());
            HashMap hashMap = new HashMap();
            net.one97.paytm.common.b.d.a(getActivity(), c(str), this, (Map<String, String>) null, hashMap, a.C0715a.POST, (String) null, new CJRDeleteCard(), a.c.PAYMENTS, a.b.SILENT).a();
        } else if (getActivity() != null) {
            net.one97.paytm.j.c.a();
            showNetworkDialogNew(net.one97.paytm.common.b.d.a(getActivity(), net.one97.paytm.j.c.i(), this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRDeleteCard(), a.c.PAYMENTS, a.b.USER_FACING));
        }
    }
}

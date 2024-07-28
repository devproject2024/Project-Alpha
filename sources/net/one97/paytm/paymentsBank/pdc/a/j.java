package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.VolleyError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPromocodeActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCSelectAtmActivity;
import net.one97.paytm.paymentsBank.pdc.d.b.b;
import net.one97.paytm.paymentsBank.pdc.view.d;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.widget.PhysicalDebitCardView;
import net.one97.paytm.upi.util.UpiUtils;

public class j extends l implements View.OnClickListener, d {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f18621a;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f18622c;

    /* renamed from: d  reason: collision with root package name */
    private PhysicalDebitCardView f18623d;

    /* renamed from: e  reason: collision with root package name */
    private PhysicalDebitCardView f18624e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18625f;

    /* renamed from: g  reason: collision with root package name */
    private CheckBox f18626g;

    /* renamed from: h  reason: collision with root package name */
    private CheckBox f18627h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f18628i;
    private TextView j;
    private b k;
    private net.one97.paytm.bankCommon.f.d l;
    private TextView m;
    private CustProductList n;
    private String o;
    private String p;
    private View q;

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f18629a;

        /* renamed from: b  reason: collision with root package name */
        String f18630b;
    }

    public final void a(String str) {
    }

    public static j a() {
        return new j();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pdc_atm_product_select, (ViewGroup) null);
        this.j = (RoboTextView) inflate.findViewById(R.id.txt_applied_promo_info);
        this.m = (TextView) inflate.findViewById(R.id.txt_cash_back_info);
        this.f18628i = (RelativeLayout) inflate.findViewById(R.id.lyt_promo_applied);
        this.f18625f = (TextView) inflate.findViewById(R.id.activity_pdc_select_atm_promocodetxt);
        this.f18621a = (ViewGroup) inflate.findViewById(R.id.activity_pdc_select_atm_personlised_layout);
        this.f18622c = (ViewGroup) inflate.findViewById(R.id.activity_pdc_select_atm_nonpersonlised_layout);
        this.f18623d = (PhysicalDebitCardView) inflate.findViewById(R.id.activity_pdc_select_atm_personlised_cardview);
        this.f18624e = (PhysicalDebitCardView) inflate.findViewById(R.id.activity_pdc_select_atm_non_personlised_cardview);
        this.f18626g = (CheckBox) inflate.findViewById(R.id.activity_pdc_select_atm_personlised_checkbox);
        this.f18627h = (CheckBox) inflate.findViewById(R.id.activity_pdc_select_atm_nonpersonlised_checkbox);
        this.q = inflate.findViewById(R.id.select_card_root_layout);
        ((ImageView) inflate.findViewById(R.id.img_remove_promo)).setOnClickListener(this);
        this.f18621a.setOnClickListener(this);
        this.f18622c.setOnClickListener(this);
        ((AppCompatButton) inflate.findViewById(R.id.activity_pdc_select_atm_proceedbtn)).setOnClickListener(this);
        this.f18625f.setOnClickListener(this);
        Context context = getContext();
        if (!(getArguments() == null || getArguments().getSerializable("CUST_PRODUCT") == null)) {
            this.n = (CustProductList) getArguments().getSerializable("CUST_PRODUCT");
            this.f18623d.setCardNumber(this.n.getVdcMaskedCardNum());
            this.f18623d.setCardMasking(true);
            this.f18624e.setCardNumber(this.n.getVdcMaskedCardNum());
            this.f18624e.setCardMasking(true);
            o.a().getNameFromKyc(getContext(), new net.one97.paytm.bankCommon.f.d() {
                public final void onFragmentAction(int i2, Object obj) {
                    j.this.a(i2, obj);
                }
            });
        }
        getActivity();
        this.k = new net.one97.paytm.paymentsBank.pdc.d.a.b(this, new net.one97.paytm.paymentsBank.pdc.c.a.b());
        this.f18626g.setChecked(true);
        this.f18627h.setChecked(false);
        if (getActivity() instanceof net.one97.paytm.bankCommon.f.d) {
            this.l = (net.one97.paytm.bankCommon.f.d) getActivity();
        }
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
            getActivity().finish();
        } else {
            this.k.a(context);
            if (this.p != null) {
                this.k.a(this.o);
            } else {
                this.f18621a.performClick();
            }
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        String str = (String) obj;
        this.f18623d.setCardName(str);
        this.f18624e.setCardName(str);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getView();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.activity_pdc_select_atm_personlised_layout) {
            this.f18626g.setChecked(true);
            this.f18627h.setChecked(false);
            this.o = net.one97.paytm.payments.b.b.a.f17207a;
            this.p = "PersonalisedCard";
            this.k.a(net.one97.paytm.payments.b.b.a.f17207a);
        } else if (id == R.id.activity_pdc_select_atm_nonpersonlised_layout) {
            this.f18626g.setChecked(false);
            this.f18627h.setChecked(true);
            this.o = net.one97.paytm.payments.b.b.a.f17208b;
            this.p = "NonPersonalisedCard";
            this.k.a(net.one97.paytm.payments.b.b.a.f17208b);
        } else if (id == R.id.activity_pdc_select_atm_proceedbtn) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
            } else {
                this.k.a();
            }
        } else if (id == R.id.activity_pdc_select_atm_promocodetxt) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
            } else {
                this.k.b();
            }
        } else if (id == R.id.img_remove_promo) {
            this.f18628i.setVisibility(8);
            this.f18625f.setVisibility(0);
            this.k.a("", "");
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        c();
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage())) {
            if (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401)) {
                f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
            }
        }
    }

    public final void b() {
        a(getActivity(), getString(R.string.pb_please_wait));
    }

    public final void e() {
        c();
    }

    public final void a(VolleyError volleyError) {
        f.a((Activity) getActivity(), (Exception) volleyError, (String) null);
    }

    public final void b(String str) {
        Intent intent = new Intent(getActivity(), PDCPromocodeActivity.class);
        intent.putExtra("productid", str);
        String str2 = str.equals(net.one97.paytm.payments.b.b.a.f17208b) ? ((a) this.f18622c.getTag()).f18629a : "";
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        intent.putExtra("amount", str2);
        startActivityForResult(intent, 3747);
    }

    public final void a(String str, String str2, String str3) {
        if (isResumed()) {
            Bundle bundle = new Bundle();
            if (str.equals(net.one97.paytm.payments.b.b.a.f17208b)) {
                bundle.putString("pdc_product_id", str);
                a aVar = (a) this.f18622c.getTag();
                bundle.putString("pdc_title", aVar.f18630b);
                bundle.putString("pdc_price", aVar.f18629a);
            }
            bundle.putString(PayUtility.PROMO_CODE, str2);
            bundle.putString("promocodeMsg", str3);
            bundle.putString("image_url", (String) null);
            bundle.putSerializable("CUST_PRODUCT", this.n);
            FragmentActivity activity = getActivity();
            if (activity instanceof PDCSelectAtmActivity) {
                ((PDCSelectAtmActivity) activity).a(bundle, true);
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.k.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 3747 && i3 == -1 && intent != null) {
            net.one97.paytm.bankCommon.f.d dVar = this.l;
            if (dVar != null) {
                dVar.onFragmentAction(3747, intent);
            }
            String stringExtra = intent.getStringExtra(Utility.EVENT_CATEGORY_PROMOCODE);
            String stringExtra2 = intent.getStringExtra("promocodeText");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.k.a(stringExtra, stringExtra2);
                this.f18628i.setVisibility(0);
                this.f18625f.setVisibility(8);
                this.m.setText(stringExtra2);
                this.j.setText(stringExtra);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }
}

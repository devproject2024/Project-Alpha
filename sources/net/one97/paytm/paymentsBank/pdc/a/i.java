package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.VolleyError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.bankCommon.f.a;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.c;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.paymentsBank.pdc.activity.PDCAddNewAddress;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPromocodeActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCSuccessActivity;
import net.one97.paytm.paymentsBank.pdc.view.b;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.widget.PhysicalDebitCardView;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class i extends l implements View.OnClickListener, a, d, b {

    /* renamed from: a  reason: collision with root package name */
    PBCJRAddress f18612a;

    /* renamed from: c  reason: collision with root package name */
    private String f18613c;

    /* renamed from: d  reason: collision with root package name */
    private d f18614d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<PBCJRAddress> f18615e;

    /* renamed from: f  reason: collision with root package name */
    private c f18616f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.pdc.d.b.a f18617g;

    /* renamed from: h  reason: collision with root package name */
    private String f18618h;

    /* renamed from: i  reason: collision with root package name */
    private String f18619i;
    private PBCJRAddress j;
    private String k;
    private View l;
    private CustProductList m;
    private LottieAnimationView n;
    private View o;
    private int p = -1;

    public static i a() {
        return new i();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pdc_address_select, (ViewGroup) null);
        net.one97.paytm.bankCommon.mapping.c.a("/bank/savings-account/debit-card/request", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof d) {
            this.f18614d = (d) getActivity();
        }
        View view = getView();
        getContext();
        ((TextView) view.findViewById(R.id.title)).setText(R.string.pb_pdc_low_bal_header);
        view.findViewById(R.id.btn_back).setOnClickListener(this);
        getView().findViewById(R.id.fragment_pdc_address_select_photo_sel_title);
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.fragment_pdc_address_select_proceed_btn);
        appCompatButton.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.atm_price);
        ((TextView) view.findViewById(R.id.atm_card_charges_tv)).setOnClickListener(this);
        this.o = view.findViewById(R.id.addressLoaderLyt);
        this.n = (LottieAnimationView) view.findViewById(R.id.addressLoader);
        this.l = view.findViewById(R.id.no_address_layout);
        this.l.setOnClickListener(this);
        ((TextView) view.findViewById(R.id.add_new_btn)).setText("+ " + getString(R.string.pb_pdc_add_new));
        view.findViewById(R.id.fragment_pdc_address_select_add_new).setOnClickListener(this);
        view.findViewById(R.id.tncTv).setOnClickListener(this);
        PhysicalDebitCardView physicalDebitCardView = (PhysicalDebitCardView) view.findViewById(R.id.fragment_pdc_address_select_pdcv);
        if (getArguments() != null) {
            String string = getArguments().getString("pdc_title");
            if (!TextUtils.isEmpty(string)) {
                ((TextView) view.findViewById(R.id.fragment_pdc_address_select_title)).setText(string);
            }
            this.f18618h = getArguments().getString("pdc_price");
            textView.setText(String.format(getResources().getString(R.string.pb_simple_amount), new Object[]{this.f18618h}));
            appCompatButton.setText(getString(R.string.pdc_proceed_to_pay_rupee, this.f18618h));
            this.f18619i = getArguments().getString("pdc_product_id");
            if (net.one97.paytm.payments.b.b.a.f17208b.equals(this.f18619i)) {
                ((TextView) view.findViewById(R.id.fragment_pdc_address_select_photo_sel_title)).setText(R.string.your_rupay_card_selected);
                view.findViewById(R.id.fragment_pdc_address_select_change_photo_tv).setVisibility(8);
            } else {
                view.findViewById(R.id.fragment_pdc_address_select_change_photo_tv).setVisibility(0);
            }
            if (getArguments().getSerializable("CUST_PRODUCT") != null) {
                this.m = (CustProductList) getArguments().getSerializable("CUST_PRODUCT");
                physicalDebitCardView.setCardNumber(this.m.getVdcMaskedCardNum());
                physicalDebitCardView.setCardMasking(true);
                o.a().getNameFromKyc(getContext(), new d() {
                    public final void onFragmentAction(int i2, Object obj) {
                        PhysicalDebitCardView.this.setCardName((String) obj);
                    }
                });
            }
        }
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.fragment_pdc_address_select_rv);
        this.f18615e = new ArrayList<>();
        this.f18616f = new c(getContext(), this.f18615e, this) {
            /* renamed from: a */
            public final c.a onCreateViewHolder(ViewGroup viewGroup, int i2) {
                c.a a2 = super.onCreateViewHolder(viewGroup, i2);
                a2.itemView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.a.this.f17304a.setChecked(true);
                    }
                });
                return a2;
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView.setAdapter(this.f18616f);
        this.f18617g = new net.one97.paytm.paymentsBank.pdc.d.a.a(this);
        this.o.setVisibility(0);
        f.a(this.n);
        this.f18617g.a(getContext());
    }

    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.fragment_pdc_address_select_proceed_btn) {
            if (this.j != null) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "atm_card_proceed_to_pay_clicked", "", "", "/bank/savings-account/debit-card/request", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                String name = this.j.getName();
                PBCJRAddress pBCJRAddress = this.j;
                if (!TextUtils.isEmpty(pBCJRAddress.getFulladdress())) {
                    str = pBCJRAddress.getFulladdress();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pBCJRAddress.getAddress1());
                    if (!TextUtils.isEmpty(pBCJRAddress.getAddress2())) {
                        sb.append(", ");
                        sb.append(pBCJRAddress.getAddress2());
                    }
                    if (!TextUtils.isEmpty(pBCJRAddress.getCity())) {
                        sb.append(", ");
                        sb.append(pBCJRAddress.getCity());
                    }
                    if (!TextUtils.isEmpty(pBCJRAddress.getState())) {
                        sb.append(", ");
                        sb.append(pBCJRAddress.getState());
                    }
                    if (!TextUtils.isEmpty(pBCJRAddress.getPin())) {
                        sb.append(" - ");
                        sb.append(pBCJRAddress.getPin());
                    }
                    str = sb.toString();
                }
                d a2 = d.a(name, str, this.j.getMobile() == null ? "" : this.j.getMobile());
                a2.f18609a = this;
                a2.show(getChildFragmentManager(), d.class.getSimpleName());
                return;
            }
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.please_select_address));
        } else if (id == R.id.no_address_layout || id == R.id.fragment_pdc_address_select_add_new) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
                return;
            }
            Intent intent = new Intent(getActivity(), PDCAddNewAddress.class);
            intent.putExtra("address1Length", 65);
            intent.putExtra("address2Length", 40);
            intent.putExtra("saveAdressOnserver", true);
            startActivityForResult(intent, 35463);
        } else if (id == R.id.activity_pdc_select_atm_promocodetxt) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
                return;
            }
            Intent intent2 = new Intent(getActivity(), PDCPromocodeActivity.class);
            intent2.putExtra("productid", this.f18619i);
            intent2.putExtra("amount", TextUtils.isEmpty(this.f18618h) ? "0" : this.f18618h);
            startActivityForResult(intent2, 32747);
        } else if (id == R.id.tncTv) {
            this.f18617g.b(getActivity());
        } else if (id == R.id.atm_card_charges_tv) {
            getActivity();
            g.a();
            o.a().openWebViewActivity(getActivity(), net.one97.paytm.bankCommon.utils.d.a("ratesAndChargesForDebitCardUrl"), getString(R.string.pb_pdc_rate_and_charges));
        } else if (id == R.id.btn_back) {
            getActivity().onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 35463 && i3 == -1) {
            if (intent.hasExtra("kyc_new_address_ID")) {
                this.k = intent.getStringExtra("kyc_new_address_ID");
                PBCJRAddress pBCJRAddress = (PBCJRAddress) intent.getSerializableExtra("new_address");
                pBCJRAddress.setIsChecked(true);
                a(pBCJRAddress);
            }
        } else if (i2 == 34437 && i3 == -1) {
            String stringExtra = intent.getStringExtra("order_id");
            if (!TextUtils.isEmpty(stringExtra)) {
                Intent intent2 = new Intent(getActivity(), PDCSuccessActivity.class);
                intent2.putExtra(UpiConstants.FROM, "Payment");
                intent2.putExtra("order_id", stringExtra);
                intent2.putExtra("redirectTo", "manageDebitCardPage");
                intent2.putExtra("CUST_PRODUCT", intent.getSerializableExtra("CUST_PRODUCT"));
                startActivity(intent2);
                getActivity().finish();
            }
        } else if (i2 == 32747) {
            if (i3 == -1 && intent != null) {
                d dVar = this.f18614d;
                if (dVar != null) {
                    dVar.onFragmentAction(32747, intent);
                }
                intent.getStringExtra(Utility.EVENT_CATEGORY_PROMOCODE);
                intent.getStringExtra("promocodeText");
            }
        } else if (i2 == 110 && i3 == -1) {
            this.f18617g.a(getContext(), intent.getStringExtra("accessToken"), this.f18619i, this.f18618h, this.f18613c, this.j);
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void b() {
        if (getActivity() != null && isResumed() && !getActivity().isFinishing()) {
            a(getContext(), getString(R.string.pb_please_wait));
        }
    }

    public final void e() {
        c();
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.paytm.utility.b.b(getContext(), getResources().getString(R.string.error), str);
        } else {
            com.paytm.utility.b.b(getContext(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
        }
    }

    public final void a(VolleyError volleyError) {
        this.o.setVisibility(8);
        f.b(this.n);
        f.a((Activity) getActivity(), (Exception) volleyError, (String) null);
    }

    public final void f() {
        com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
    }

    public final void a(ArrayList<PBCJRAddress> arrayList) {
        if (isAdded()) {
            this.f18615e.clear();
            this.j = null;
            ArrayList<PBCJRAddress> arrayList2 = this.f18615e;
            ArrayList arrayList3 = new ArrayList();
            Iterator<PBCJRAddress> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                PBCJRAddress next = it2.next();
                if (!(next.getAddress1() == null || next.getAddress1().length() > 65 || next.getAddress1().trim().length() == 0 || next.getAddress2() == null || next.getAddress2().length() > 40 || next.getAddress2().trim().length() == 0)) {
                    if (TextUtils.isEmpty(this.k) || !this.k.equals(next.getId())) {
                        arrayList3.add(next);
                    } else {
                        this.f18612a = next;
                    }
                }
            }
            PBCJRAddress pBCJRAddress = this.f18612a;
            if (pBCJRAddress != null) {
                arrayList3.add(0, pBCJRAddress);
            }
            arrayList2.addAll(arrayList3);
            this.o.setVisibility(8);
            f.b(this.n);
            if (this.f18615e.size() > 0) {
                this.l.setVisibility(8);
                getView().findViewById(R.id.fragment_pdc_address_select_add_new).setVisibility(0);
            } else {
                this.l.setVisibility(0);
                getView().findViewById(R.id.fragment_pdc_address_select_add_new).setVisibility(8);
            }
            if (this.f18615e.size() == 1) {
                this.f18615e.get(0).setIsChecked(true);
                this.j = this.f18615e.get(0);
            }
            this.f18616f.notifyDataSetChanged();
        }
    }

    public final void a(int i2, int i3) {
        this.j = this.f18615e.get(i3);
        try {
            this.f18616f.notifyItemChanged(i2);
            this.f18616f.notifyItemChanged(i3);
        } catch (Exception unused) {
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(getActivity(), PDCSuccessActivity.class);
            intent.putExtra(UpiConstants.FROM, "Payment");
            intent.putExtra("order_id", str);
            intent.putExtra("redirectTo", "manageDebitCardPage");
            intent.putExtra("CUST_PRODUCT", this.m);
            intent.putExtra("pdc_price", this.f18618h);
            intent.putExtra("extra_address", this.j.getAddress1() + " " + this.j.getAddress2() + ", " + this.j.getCity() + ", " + this.j.getState() + "-" + this.j.getPin());
            intent.putExtra("extra_mobile", this.j.getMobile());
            intent.putExtra("extra_name", this.j.getName());
            startActivity(intent);
            getActivity().finish();
        }
    }

    public final void b(ArrayList<PBTncData> arrayList) {
        if (isResumed() && arrayList != null && arrayList.size() > 0) {
            net.one97.paytm.paymentsBank.g.a.a(arrayList).show(getActivity().getSupportFragmentManager(), "KycTNCFragment");
        }
    }

    public final void a(PBCJRAddress pBCJRAddress) {
        if (isAdded()) {
            f.b(this.n);
            if (pBCJRAddress == null && this.f18615e.size() == 0) {
                this.l.setVisibility(0);
                getView().findViewById(R.id.fragment_pdc_address_select_add_new).setVisibility(8);
                return;
            }
            this.j = null;
            this.o.setVisibility(8);
            int i2 = this.p;
            if (i2 != -1) {
                this.f18615e.get(i2).setIsChecked(false);
            }
            if (this.f18615e.size() == 0) {
                this.f18615e.add(pBCJRAddress);
            } else {
                this.f18615e.add(0, pBCJRAddress);
            }
            this.l.setVisibility(8);
            getView().findViewById(R.id.fragment_pdc_address_select_add_new).setVisibility(0);
            this.f18615e.get(0).setIsChecked(true);
            this.p = 0;
            this.j = this.f18615e.get(0);
            this.f18616f.notifyDataSetChanged();
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c();
        this.o.setVisibility(8);
        f.b(this.n);
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage())) {
            if (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401)) {
                f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
            }
        }
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 106) {
            Intent intent = new Intent(getActivity(), PDCPasscodePinActivity.class);
            intent.putExtra("ENTER_HEADER", "pdcPasscodeValidation");
            startActivityForResult(intent, 110);
        }
    }
}

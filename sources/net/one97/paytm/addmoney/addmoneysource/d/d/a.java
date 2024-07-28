package net.one97.paytm.addmoney.addmoneysource.d.d;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.d.a.a;
import net.one97.paytm.addmoney.addmoneysource.d.b.a.b;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.f;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public class a extends h implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public e f48257a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a.C0842a f48258b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f48259c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f48260d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f48261e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f48262f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f48263g;

    /* renamed from: h  reason: collision with root package name */
    private View f48264h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f48265i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public EditText k;
    private int l;
    /* access modifiers changed from: private */
    public int m;
    private double n;
    private String o;
    private String p;
    private String q;
    private String r;
    /* access modifiers changed from: private */
    public String s;
    private String t;
    private String u;
    private UpiBaseDataModel v;
    private UpiProfileDefaultBank w;
    private f x;
    private boolean y;
    private BroadcastReceiver z = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            int intExtra;
            int f2;
            if (intent != null && intent.getAction().equals("payment_item_selected")) {
                int intExtra2 = intent.getIntExtra("payment_item_type", -1);
                if (intExtra2 != a.this.m && intExtra2 != -1 && (f2 = a.this.f48258b.f()) != -1) {
                    a.this.f48258b.b(f2);
                }
            } else if (intent != null && intent.getAction().equals("payment_item_validate_selection_status_upi") && (intExtra = intent.getIntExtra("payment_item_type", -1)) != -1 && intExtra == a.this.m) {
                boolean booleanExtra = intent.getBooleanExtra("payment_item_is_valid", false);
                b c2 = a.this.f48259c;
                if (booleanExtra && c2.f48273d != -1) {
                    if (c2.f48272c == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
                        Intent intent2 = new Intent("payment_item_selected");
                        intent2.putExtra("payment_item_type", c2.f48272c);
                        androidx.localbroadcastmanager.a.a.a(c2.f48270a).a(intent2);
                    }
                    c2.f48271b.b(c2.f48273d);
                }
                c2.f48273d = -1;
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getArguments().getInt("destinationAddMoney", PaymentDestinationType.NO_CARD.getNumVal());
        this.n = getArguments().getDouble("amount");
        this.o = getArguments().getString("ppb_account_number");
        this.p = getArguments().getString("ppb_account_name");
        this.q = getArguments().getString("ppb_account_ifsc");
        this.r = getArguments().getString("ppb_account_balance");
        this.m = getArguments().getInt("item_type");
        if (this.m == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
            IntentFilter intentFilter = new IntentFilter("payment_item_selected");
            intentFilter.addAction("payment_item_validate_selection_status_upi");
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.z, intentFilter);
        }
        this.y = getArguments().getBoolean("destroy_self", false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        double d2 = this.n;
        Context context = getContext();
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        this.f48258b = new net.one97.paytm.addmoney.addmoneysource.d.c.a(this, d2, b.a((net.one97.paytm.addmoney.addmoneysource.d.b.a.a) net.one97.paytm.addmoney.addmoneysource.d.b.a.a.a.a(context), (net.one97.paytm.addmoney.addmoneysource.d.b.a.a) net.one97.paytm.addmoney.addmoneysource.d.b.a.b.a.a(context)), new net.one97.paytm.addmoney.utils.a(getContext(), getParentFragment()), this.l, this.m);
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_source_upi, viewGroup, false);
        this.f48260d = (TextView) inflate.findViewById(R.id.tv_add_bank_account);
        this.f48261e = (TextView) inflate.findViewById(R.id.tv_create_vpa);
        this.f48264h = inflate.findViewById(R.id.v_divider);
        this.f48265i = (LinearLayout) inflate.findViewById(R.id.ll_enter_upi);
        this.j = (LinearLayout) inflate.findViewById(R.id.ll_proceed_securely);
        this.k = (EditText) inflate.findViewById(R.id.et_upi_address);
        this.f48263g = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f48262f = (RecyclerView) inflate.findViewById(R.id.rv_bank_list);
        this.f48262f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f48259c = new b(getActivity(), this.f48258b, this.m, this.l);
        this.f48262f.setAdapter(this.f48259c);
        if (this.m == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
            this.f48264h.setVisibility(8);
        }
        this.f48258b.a();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.z != null && this.m == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.z);
            this.z = null;
        }
        this.f48258b.b();
    }

    public final void b() {
        this.f48262f.setVisibility(8);
        this.f48264h.setVisibility(8);
        this.f48260d.setVisibility(8);
        this.f48265i.setVisibility(8);
        this.f48261e.setVisibility(0);
        this.f48261e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.d(a.this);
                if (!a.this.isAdded()) {
                    return;
                }
                if (!com.paytm.utility.b.c((Context) a.this.getActivity())) {
                    com.paytm.utility.b.b((Context) a.this.getActivity(), a.this.getString(R.string.uam_error), a.this.getString(R.string.uam_check_network));
                    return;
                }
                if (UpiUtils.isInActiveProfileExist(a.this.getContext())) {
                    a aVar = a.this;
                    aVar.startActivity(UpiUtils.getUpiLandingPageActivityIntent(aVar.getContext()));
                } else {
                    a.this.startActivity(new Intent(a.this.getActivity(), UpiSelectBankActivity.class));
                }
                if (a.this.isAdded()) {
                    a.this.getActivity().finish();
                }
            }
        });
    }

    public final void b(boolean z2) {
        if (z2) {
            this.f48262f.setVisibility(8);
            this.f48264h.setVisibility(8);
            this.f48260d.setVisibility(0);
        } else {
            this.f48262f.setVisibility(0);
            this.f48264h.setVisibility(8);
            this.f48260d.setVisibility(8);
        }
        this.f48260d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!com.paytm.utility.b.c((Context) a.this.getActivity())) {
                    com.paytm.utility.b.b((Context) a.this.getActivity(), a.this.getString(R.string.uam_error), a.this.getString(R.string.uam_check_network));
                } else {
                    AccountProviderActivity.a((Fragment) a.this, 1002);
                }
            }
        });
    }

    public final void c() {
        this.f48265i.setVisibility(0);
        this.f48262f.setVisibility(8);
        this.f48264h.setVisibility(8);
        this.f48260d.setVisibility(8);
        this.f48261e.setVisibility(8);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.e(a.this)) {
                    a aVar = a.this;
                    String unused = aVar.s = aVar.k.getText().toString();
                    a.this.f48258b.a(a.this.s, a.this.d());
                }
            }
        });
    }

    public final double d() {
        this.n = this.f48257a.s().doubleValue();
        return this.n;
    }

    public final void a(String str) {
        if (isAdded()) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        this.w = upiProfileDefaultBank;
        UpiProfileDefaultBank upiProfileDefaultBank2 = this.w;
        if (upiProfileDefaultBank2 != null) {
            this.s = upiProfileDefaultBank2.getVirtualAddress();
            this.v = this.w.getDebitBank();
            if (!isAdded()) {
                return;
            }
            if (this.l == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                Intent c2 = net.one97.paytm.helper.a.b().c((Activity) getActivity());
                c2.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                c2.putExtra("amount", Double.toString(this.n));
                c2.putExtra(UpiConstants.EXTRA_PAYER_VPA, this.s);
                c2.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, this.o);
                c2.putExtra("payee_name", this.p);
                c2.putExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P, this.q);
                c2.putExtra("bank_item_object", this.v);
                c2.putExtra("add_money_to_ppb", true);
                c2.putExtra("hide_isa_fd", g.a().l);
                startActivityForResult(c2, 1001);
                getActivity().finish();
            } else if (this.l == PaymentDestinationType.TO_WALLET.getNumVal()) {
                this.f48258b.e();
            }
        }
    }

    public final void a(HashMap<String, String> hashMap) {
        CJRRechargePayment cJRRechargePayment = c.a().f48962e;
        if (!TextUtils.isEmpty(this.u)) {
            hashMap.put(PayUtility.MPIN, this.u);
            hashMap.put("SEQ_NUMBER", this.t);
            UpiProfileDefaultBank upiProfileDefaultBank = this.w;
            if (!(upiProfileDefaultBank == null || upiProfileDefaultBank.getDebitBank() == null)) {
                hashMap.put("ACCOUNT_NUMBER", this.w.getDebitBank().getAccount());
                hashMap.put("BANK_NAME", this.w.getDebitBank().getBankName());
                hashMap.put("CREDIT_BLOCK", this.w.getDebitBank().getCredsAsJson());
            }
            hashMap.put("device_id", UpiUtils.getDeviceId(getContext().getApplicationContext()));
        }
        cJRRechargePayment.setmPGParams(hashMap);
        cJRRechargePayment.setmPGUrlToHit(net.one97.paytm.helper.a.b().f("processTxnAddMoneyURL") + "?mid=" + c.a().f48959b + "&orderId=" + c.a().f48960c);
        Intent f2 = net.one97.paytm.helper.a.b().f((Activity) getActivity());
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("uam_add_money", true);
        startActivityForResult(f2, 1004);
    }

    public final void a() {
        this.f48262f.setVisibility(8);
        this.f48264h.setVisibility(8);
        if (isAdded()) {
            Toast.makeText(getActivity(), "Error while fetching UPI details. Please try again", 0).show();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            AddMoneyUtils.a(this.f48263g);
        } else {
            AddMoneyUtils.b(this.f48263g);
        }
    }

    public final void d(boolean z2) {
        try {
            if (this.x == null) {
                this.x = new f(getActivity());
            }
            if (!TextUtils.isEmpty((CharSequence) null)) {
                this.x.f48967a = null;
            }
            if (!TextUtils.isEmpty((CharSequence) null)) {
                this.x.f48968b = null;
            }
            if (z2) {
                this.x.a();
            } else {
                this.x.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(int i2) {
        b bVar = this.f48259c;
        if (bVar != null) {
            bVar.notifyItemChanged(i2);
        }
    }

    public final void a(int i2) {
        b bVar = this.f48259c;
        if (bVar != null) {
            bVar.notifyItemRangeRemoved(0, i2);
        }
    }

    public final void b(int i2) {
        b bVar = this.f48259c;
        if (bVar != null) {
            bVar.notifyItemRangeInserted(0, i2);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i4 = i2;
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            String str7 = "";
            if (i4 != 1001 || intent2 == null) {
                if (i4 == 1002) {
                    BankVpaCreationActivity.a((Fragment) this, (AccountProviderBody.AccountProvider) intent2.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), str7, 1003);
                } else if (i4 == 1003) {
                    this.f48258b.a();
                } else if (i4 == 1005) {
                    this.u = intent2.getStringExtra("upi_mpin");
                    if (TextUtils.isEmpty(this.u)) {
                        Toast.makeText(getActivity(), "Please enter MPIN", 0).show();
                    } else {
                        this.f48258b.e();
                    }
                } else if (i4 == 1004) {
                    String stringExtra = intent2.getStringExtra("retry_allowed");
                    String stringExtra2 = intent2.getStringExtra("error_message");
                    if (!TextUtils.isEmpty(stringExtra) && "true".equalsIgnoreCase(stringExtra)) {
                        com.paytm.utility.b.b(getContext(), "Error", stringExtra2);
                    } else if (this.y) {
                        getActivity().setResult(-1);
                        getActivity().finish();
                    } else {
                        Intent intent3 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                        intent3.putExtra("destinationAddMoney", this.l);
                        intent3.putExtra("sourceAddMoney", SourceCardType.BHIM_UPI.getNumVal());
                        intent3.putExtra("sourceUpiAddress", this.s);
                        BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) this.v;
                        if (bankAccount != null) {
                            String account = bankAccount.getAccount();
                            str2 = bankAccount.getBankName();
                            str = bankAccount.getIfsc();
                            String bankLogoUrl = bankAccount.getBankLogoUrl();
                            str3 = account;
                            str7 = bankLogoUrl;
                        } else {
                            str3 = str7;
                            str2 = str3;
                            str = str2;
                        }
                        if (TextUtils.isEmpty(str7)) {
                            str7 = UpiRequestBuilder.getBankIconUrl(getContext().getApplicationContext(), str);
                        }
                        intent3.putExtra("sourceName", str2);
                        intent3.putExtra("sourceDesc", UpiUtils.maskNumber(str3));
                        intent3.putExtra("sourceImage", str7);
                        intent3.putExtra("Amount", this.n);
                        intent3.putExtra("mid", intent2.getStringExtra("merchant_id"));
                        intent3.putExtra("orderId", intent2.getStringExtra("order_id"));
                        startActivity(intent3);
                        getActivity().finish();
                    }
                }
            } else if (!isAdded()) {
            } else {
                if (this.y) {
                    getActivity().setResult(-1);
                    getActivity().finish();
                    return;
                }
                Intent intent4 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                intent4.putExtra("sourceAddMoney", SourceCardType.BHIM_UPI.getNumVal());
                intent4.putExtra("destinationAddMoney", this.l);
                intent4.putExtra("account_no", this.o);
                intent4.putExtra("available_balance", this.r);
                intent4.putExtra("Amount", this.n);
                intent4.putExtra("sourceUpiAddress", this.s);
                intent4.putExtra("payment_response_object", intent2.getSerializableExtra("payment_response_object"));
                BankAccountDetails.BankAccount bankAccount2 = (BankAccountDetails.BankAccount) this.v;
                if (bankAccount2 != null) {
                    String account2 = bankAccount2.getAccount();
                    str5 = bankAccount2.getBankName();
                    str4 = bankAccount2.getIfsc();
                    String bankLogoUrl2 = bankAccount2.getBankLogoUrl();
                    str6 = account2;
                    str7 = bankLogoUrl2;
                } else {
                    str6 = str7;
                    str5 = str6;
                    str4 = str5;
                }
                if (TextUtils.isEmpty(str7)) {
                    str7 = UpiRequestBuilder.getBankIconUrl(getContext().getApplicationContext(), str4);
                }
                intent4.putExtra("sourceDesc", UpiUtils.maskNumber(str6));
                intent4.putExtra("sourceName", str5);
                intent4.putExtra("payment_bank_ifsc", str4);
                intent4.putExtra("sourceImage", str7);
                intent4.putExtra("mid", intent2.getStringExtra("merchant_id"));
                intent4.putExtra("orderId", intent2.getStringExtra("order_id"));
                startActivity(intent4);
                getActivity().finish();
            }
        } else if (this.y) {
            getActivity().setResult(0);
            getActivity().finish();
        }
    }

    public final void c(boolean z2) {
        if (this.f48258b.d() == PaymentDestinationType.TO_WALLET.ordinal()) {
            d.a((Context) getActivity(), "add_money_wallet", "proceed_securely_clicked", "/add-money/wallet", "upi", z2 ? "primary" : "secondary");
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }

    static /* synthetic */ void d(a aVar) {
        if (aVar.l == PaymentDestinationType.TO_WALLET.ordinal()) {
            d.a((Context) aVar.getActivity(), "add_money_bank", "add_bank_account_clicked", "/add-money/wallet", (String) null, (String) null);
        }
    }

    static /* synthetic */ boolean e(a aVar) {
        String obj = aVar.k.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            Toast.makeText(aVar.getContext(), aVar.getString(R.string.uam_empty_vpa_error), 0).show();
            return false;
        } else if (obj.length() > 255) {
            Toast.makeText(aVar.getContext(), aVar.getString(R.string.uam_vpa_length_breach), 0).show();
            aVar.k.setError(aVar.getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (obj.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            Toast.makeText(aVar.getContext(), aVar.getString(R.string.uam_invalid_upi), 0).show();
            return false;
        }
    }
}

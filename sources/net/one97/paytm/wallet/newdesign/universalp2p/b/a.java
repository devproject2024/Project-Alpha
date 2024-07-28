package net.one97.paytm.wallet.newdesign.universalp2p.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.universalp2p.UserPaymentInstrumentationResDataModel;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.d.e;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.f.g;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import net.one97.paytm.wallet.p2p.P2PLandingPageActivity;
import net.one97.paytm.wallet.utility.h;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private b.c f71378a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f71379b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f71380c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f71381d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f71382e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f71383f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f71384g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71385h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71386i;
    private TextView j;
    private TextView k;
    /* access modifiers changed from: private */
    public Button l;
    private ImageView m;
    private e n;
    private LottieAnimationView o;
    private String p;
    private net.one97.paytm.wallet.newdesign.universalp2p.c.a q;
    /* access modifiers changed from: private */
    public Context r;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f71379b = b.a((Activity) getActivity());
        if (getArguments() != null) {
            this.f71378a = (b.c) getArguments().getSerializable("uni_p2p_btm_sheet_pymt_instmnt");
            this.f71380c = getArguments().getString("uni_p2p_btm_sheet_amount");
            this.p = getArguments().getString("uni_p2p_btm_sheet_mode");
            this.f71381d = getArguments().getString("uni_p2p_btm_sheet_comments");
            this.f71383f = getArguments().getString("uni_p2p_btm_sheet_mobile_number");
            this.f71382e = getArguments().getString("uni_p2p_btm_sheet_name");
        }
        getActivity();
        this.q = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        net.one97.paytm.wallet.newdesign.universalp2p.c.a aVar = this.q;
        String str = this.f71380c;
        aVar.f71396h = str;
        aVar.f71397i = str;
        b.c cVar = this.f71378a;
        aVar.m = (cVar == null || cVar.getPaymentInstrumentationType() == null) ? "error" : this.f71378a.getPaymentInstrumentationType().name();
        this.q.f71391c = a.C1450a.PROCEED_TO_PAY;
        this.q.f71390b = a.b.WAlLET_SEND_MONEY;
    }

    public void setupDialog(Dialog dialog, int i2) {
        IJRDataModel iJRDataModel;
        super.setupDialog(dialog, i2);
        IJRDataModel iJRDataModel2 = null;
        View inflate = View.inflate(getContext(), R.layout.uni_p2p_confirmation_btm_sheet_fragment, (ViewGroup) null);
        this.f71384g = (TextView) inflate.findViewById(R.id.tv_uni_p2p_recipient_name);
        this.f71385h = (TextView) inflate.findViewById(R.id.tv_uni_p2p_recipient_amount);
        this.f71386i = (TextView) inflate.findViewById(R.id.tv_uni_p2p_recipient_address_metadata);
        this.j = (TextView) inflate.findViewById(R.id.tv_uni_p2p_recipient_address);
        this.k = (TextView) inflate.findViewById(R.id.tv_uni_p2p_source_address);
        this.o = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        this.m = (ImageView) inflate.findViewById(R.id.iv_uni_p2p_cancel_confirmation);
        this.m.setOnClickListener(this);
        this.l = (Button) inflate.findViewById(R.id.uni_p2p_btn_confirm);
        this.l.setOnClickListener(this);
        this.f71385h.setText(getString(R.string.uni_p2p_will_receive_amt, this.f71380c));
        b.c cVar = this.f71378a;
        if (cVar != null) {
            b bVar = this.f71379b;
            int i3 = b.AnonymousClass3.f71411a[cVar.getPaymentInstrumentationType().ordinal()];
            if (i3 == 1) {
                iJRDataModel = bVar.f71403f;
            } else if (i3 == 2) {
                iJRDataModel = bVar.f71402e;
            }
            iJRDataModel2 = iJRDataModel;
        }
        int i4 = AnonymousClass2.f71388a[this.f71378a.getPaymentInstrumentationType().ordinal()];
        if (i4 == 1) {
            this.j.setVisibility(0);
            UserVpaInfo userVpaInfo = (UserVpaInfo) iJRDataModel2;
            UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel = this.f71379b.f71400c;
            if (userPaymentInstrumentationResDataModel != null && userPaymentInstrumentationResDataModel.getResponse() != null && userPaymentInstrumentationResDataModel.getResponse().getUpi() != null) {
                this.f71384g.setText(userPaymentInstrumentationResDataModel.getResponse().getUpi().getName());
                this.f71386i.setText(getString(R.string.uni_p2p_recipient_address_metadata_upi, userPaymentInstrumentationResDataModel.getResponse().getUpi().getVpa()));
                this.j.setVisibility(8);
            } else if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getBank() == null)) {
                this.f71384g.setText(userPaymentInstrumentationResDataModel.getResponse().getBank().getName());
                this.f71386i.setText(getString(R.string.uni_p2p_recipient_address_metadata_bank));
                this.j.setText(this.f71383f);
            }
            this.k.setText(getString(R.string.uni_p2p_source_address_bank, userVpaInfo.getBankName(), userVpaInfo.getAccountNum()));
        } else if (i4 == 2) {
            this.j.setVisibility(0);
            UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel2 = this.f71379b.f71400c;
            if (userPaymentInstrumentationResDataModel2 == null) {
                userPaymentInstrumentationResDataModel2 = this.f71379b.f71401d;
            }
            String str = this.f71382e;
            if (str != null && !str.isEmpty()) {
                this.f71384g.setText(this.f71382e);
            } else if (userPaymentInstrumentationResDataModel2 == null || userPaymentInstrumentationResDataModel2.getResponse() == null || userPaymentInstrumentationResDataModel2.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel2.getResponse().getWallet().getName())) {
                this.f71384g.setText("Receiver");
            } else {
                this.f71384g.setText(userPaymentInstrumentationResDataModel2.getResponse().getWallet().getName());
            }
            this.f71386i.setText(getString(R.string.uni_p2p_recipient_address_metadata_wallet));
            if (userPaymentInstrumentationResDataModel2 == null || userPaymentInstrumentationResDataModel2.getResponse() == null || userPaymentInstrumentationResDataModel2.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel2.getResponse().getWallet().getMobile())) {
                this.j.setText(this.f71383f);
            } else {
                this.j.setText(userPaymentInstrumentationResDataModel2.getResponse().getWallet().getMobile());
            }
            this.k.setText(getString(R.string.uni_p2p_source_address_wallet));
        } else if (i4 == 3) {
            this.j.setVisibility(0);
            CustProductList custProductList = (CustProductList) iJRDataModel2;
            UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel3 = this.f71379b.f71400c;
            if (!(userPaymentInstrumentationResDataModel3 == null || userPaymentInstrumentationResDataModel3.getResponse() == null || userPaymentInstrumentationResDataModel3.getResponse().getBank() == null)) {
                this.f71384g.setText(userPaymentInstrumentationResDataModel3.getResponse().getBank().getName());
                this.f71386i.setText(getString(R.string.uni_p2p_recipient_address_metadata_bank));
                this.j.setText(this.f71383f);
                this.k.setText(getString(R.string.uni_p2p_source_address_bank, "Paytm Payments Bank", custProductList.getIsaAccNum()));
            }
        }
        this.n = new e();
        this.n.b(this.p);
        this.n.a((Activity) getActivity(), "P2P_TRANSFER", (g) new g() {
            public final void a() {
                a.this.l.setClickable(false);
            }

            public final void b() {
                a.this.l.setClickable(true);
            }

            public final void a(IJRDataModel iJRDataModel) {
                net.one97.paytm.f.b.a().c();
                if (iJRDataModel instanceof CJRSendMoney) {
                    CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRDataModel;
                    String statusCode = cJRSendMoney.getStatusCode();
                    String status = cJRSendMoney.getStatus();
                    UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel = a.this.f71379b.f71400c;
                    if (userPaymentInstrumentationResDataModel == null) {
                        userPaymentInstrumentationResDataModel = a.this.f71379b.f71401d;
                    }
                    if (!"SUCCESS".equalsIgnoreCase(status) || !"SS_0001".equalsIgnoreCase(statusCode)) {
                        String unused = a.this.f71381d = cJRSendMoney.getStatusMessage();
                    } else {
                        k.a();
                        ArrayList<IJRDataModel> a2 = k.a(a.this.getActivity());
                        if (a2 != null) {
                            a2.size();
                        }
                        String c2 = a.this.f71383f;
                        if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile()))) {
                            c2 = userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile();
                        }
                        String a3 = net.one97.paytm.wallet.utility.a.a(a.this.getActivity().getApplicationContext(), c2);
                        if (TextUtils.isEmpty(a3)) {
                            a3 = a.this.f71382e;
                            if (!(!TextUtils.isEmpty(a3) || userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getWallet().getName()))) {
                                a3 = userPaymentInstrumentationResDataModel.getResponse().getWallet().getName();
                            }
                        }
                        if (TextUtils.isEmpty(a3)) {
                            String unused2 = a.this.f71383f;
                        }
                    }
                    Intent intent = new Intent(a.this.r, P2PLandingPageActivity.class);
                    String c3 = a.this.f71383f;
                    if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile()))) {
                        c3 = userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile();
                    }
                    if (a.this.f71382e != null && !a.this.f71382e.isEmpty()) {
                        intent.putExtra("uni_p2p_landing_intent_extra_name", a.this.f71382e);
                    }
                    intent.putExtra("uni_p2p_landing_intent_extra_comment", a.this.f71381d);
                    intent.putExtra("uni_p2p_landing_intent_extra_mobile_no", c3);
                    intent.putExtra("uni_p2p_landing_intent_extra_success", cJRSendMoney.getStatus());
                    intent.putExtra("uni_p2p_landing_intent_extra_amount", a.this.f71380c);
                    intent.putExtra("uni_p2p_landing_intent_extra_image_url", a.this.f71379b.m);
                    intent.putExtra("uni_p2p_landing_intent_extra_transaction_id", cJRSendMoney.getResponse().getwalletSysTransactionID());
                    intent.putExtra("uni_p2p_landing_intent_extra_beneficiary_flag", cJRSendMoney.getResponse().isBeneficiaryAdded());
                    a.this.getActivity().startActivity(intent);
                    a.this.getActivity().setResult(-1);
                    a.this.getActivity().finish();
                }
            }
        });
        dialog.setContentView(inflate);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.uni_p2p_btn_confirm) {
            a(this.f71378a);
        } else if (view.getId() == R.id.iv_uni_p2p_cancel_confirmation) {
            dismiss();
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.b.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f71388a = new int[b.d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d[] r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f71388a = r0
                int[] r0 = f71388a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f71388a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f71388a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.PPB     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.b.a.AnonymousClass2.<clinit>():void");
        }
    }

    private void a(b.c cVar) {
        net.one97.paytm.common.widgets.a.a(this.o);
        this.l.setAlpha(0.8f);
        this.l.setClickable(false);
        if (com.paytm.utility.b.r((Context) getActivity())) {
            int i2 = AnonymousClass2.f71388a[cVar.getPaymentInstrumentationType().ordinal()];
            if (i2 == 1) {
                a();
            } else if (i2 == 2) {
                b();
            } else if (i2 == 3) {
                c();
            }
        } else {
            net.one97.paytm.wallet.utility.a.a((Fragment) this);
        }
    }

    private void a() {
        this.q.f71389a = a.e.SEND_MONEY;
        String str = this.f71381d;
        if (str == null || str.isEmpty()) {
            this.f71381d = getString(R.string.upi_ppb_comment_default);
        }
        UserVpaInfo userVpaInfo = (UserVpaInfo) this.f71379b.a(this.f71378a);
        UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel = this.f71379b.f71400c;
        Intent moneyTransferIntent = net.one97.paytm.wallet.communicator.b.a().getMoneyTransferIntent(getActivity());
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, true);
        moneyTransferIntent.putExtra("amount", this.f71380c);
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, this.f71383f);
        if (!this.f71381d.isEmpty()) {
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P, this.f71381d);
        }
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYER_VPA, userVpaInfo.getVpa());
        if (userPaymentInstrumentationResDataModel != null && userPaymentInstrumentationResDataModel.getResponse() != null && userPaymentInstrumentationResDataModel.getResponse().getUpi() != null) {
            moneyTransferIntent.putExtra("payee_name", userPaymentInstrumentationResDataModel.getResponse().getUpi().getName());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, userPaymentInstrumentationResDataModel.getResponse().getUpi().getVpa());
            this.q.f71393e = a.d.UPI_TO_PAYTM_UPI;
        } else if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getBank() == null)) {
            moneyTransferIntent.putExtra("payee_name", userPaymentInstrumentationResDataModel.getResponse().getBank().getName());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P, userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, userPaymentInstrumentationResDataModel.getResponse().getBank().getAccountNumber());
            if (TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc()) || !userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc().contains("PYTM")) {
                this.q.f71393e = a.d.UPI_TO_OBA;
            } else {
                this.q.f71393e = a.d.UPI_TO_PPB;
            }
        }
        this.q.a((Context) getActivity());
        getActivity().startActivity(moneyTransferIntent);
        getActivity().setResult(-1);
        getActivity().finish();
    }

    private void b() {
        if (!TextUtils.isEmpty(this.f71380c)) {
            this.q.f71389a = a.e.WALLET_PAY;
            this.q.f71393e = a.d.P2P;
            String str = this.f71383f;
            UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel = this.f71379b.f71400c;
            if (userPaymentInstrumentationResDataModel == null) {
                userPaymentInstrumentationResDataModel = this.f71379b.f71401d;
            }
            if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getWallet() == null || TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile()))) {
                str = userPaymentInstrumentationResDataModel.getResponse().getWallet().getMobile();
            }
            d();
            this.n.a(str, this.f71380c, this.f71381d, true);
            this.q.a((Context) getActivity());
        }
    }

    private void c() {
        this.q.f71389a = a.e.SEND_MONEY;
        String str = this.f71381d;
        if (str == null || str.isEmpty()) {
            this.f71381d = getString(R.string.upi_ppb_comment_default);
        }
        UserPaymentInstrumentationResDataModel userPaymentInstrumentationResDataModel = this.f71379b.f71400c;
        Intent moneyTransferIntent = net.one97.paytm.wallet.communicator.b.a().getMoneyTransferIntent(getActivity());
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, true);
        moneyTransferIntent.putExtra("amount", this.f71380c);
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, this.f71383f);
        if (!this.f71381d.isEmpty()) {
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P, this.f71381d);
        }
        if (!(userPaymentInstrumentationResDataModel == null || userPaymentInstrumentationResDataModel.getResponse() == null || userPaymentInstrumentationResDataModel.getResponse().getBank() == null)) {
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P, userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc());
            moneyTransferIntent.putExtra("payee_name", userPaymentInstrumentationResDataModel.getResponse().getBank().getName());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, userPaymentInstrumentationResDataModel.getResponse().getBank().getAccountNumber());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FOR_IMPS_FROM_UNIV_P2P, true);
            if (TextUtils.isEmpty(userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc()) || !userPaymentInstrumentationResDataModel.getResponse().getBank().getIfsc().contains("PYTM")) {
                this.q.f71393e = a.d.PPB_TO_OBA;
            } else {
                this.q.f71393e = a.d.PPB_TO_PPB;
            }
        }
        d();
        this.q.a((Context) getActivity());
        getActivity().startActivity(moneyTransferIntent);
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 301) {
            a(this.f71378a);
        }
    }

    private void d() {
        net.one97.paytm.f.b.a().a(this.r, this.f71382e, this.f71383f, false, h.P2P.getValue(), com.paytm.utility.b.s((Context) getActivity()), com.paytm.utility.b.t((Context) getActivity()));
    }

    public void onAttach(Context context) {
        this.r = context;
        super.onAttach(context);
    }
}

package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.SenderDisplayInformation;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.a;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.a;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.moneytransferv4.g.b;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends net.one97.paytm.i.f implements n.c, a.b {

    /* renamed from: h  reason: collision with root package name */
    public static final a f55101h = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final int f55102a = 3;

    /* renamed from: b  reason: collision with root package name */
    public q f55103b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.moneytransferv4.accountsbottomsheet.c f55104c;

    /* renamed from: d  reason: collision with root package name */
    public a f55105d;

    /* renamed from: e  reason: collision with root package name */
    public int f55106e = -1;

    /* renamed from: f  reason: collision with root package name */
    public PaymentCombinationAPIResponse f55107f;

    /* renamed from: g  reason: collision with root package name */
    public String f55108g = "";

    /* renamed from: i  reason: collision with root package name */
    private final int f55109i;
    private final int j = 1;
    private final int k = 2;
    private final int l = 4;
    private final int m = 5;
    private final int n = 6;
    private final String o = "paytmmp://payment_bank?featuretype=bank_landing";
    private final int p = 7;
    private UPICheckBalanceHelper q;
    private int r;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c s;
    private UpiProfileDefaultBank t;
    private TextView u;
    private HashMap v;

    public static final /* synthetic */ a a(b bVar) {
        a aVar = bVar.f55105d;
        if (aVar == null) {
            k.a("vpaListAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ UpiProfileDefaultBank b(b bVar) {
        UpiProfileDefaultBank upiProfileDefaultBank = bVar.t;
        if (upiProfileDefaultBank == null) {
            k.a("selectedBankAccount");
        }
        return upiProfileDefaultBank;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
            k.c(paymentCombinationAPIResponse, Payload.RESPONSE);
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putSerializable("pcr", paymentCombinationAPIResponse);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final void a(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pcr", paymentCombinationAPIResponse);
        setArguments(bundle);
    }

    public final void onCreate(Bundle bundle) {
        List<PaymentOptionItem> paymentOptionList;
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("pcr") : null;
        if (serializable != null) {
            this.f55107f = (PaymentCombinationAPIResponse) serializable;
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                k.a();
            }
            this.s = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c) am.a(parentFragment).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c.class);
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.f55107f;
            if (paymentCombinationAPIResponse == null) {
                k.a("paymentCombinationAPIResponse");
            }
            if (paymentCombinationAPIResponse != null && (paymentOptionList = paymentCombinationAPIResponse.getPaymentOptionList()) != null) {
                a.b bVar = this;
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.s;
                if (cVar == null) {
                    k.a();
                }
                this.f55105d = new a(paymentOptionList, bVar, cVar.p);
                if (this.f55106e != -1) {
                    a aVar = this.f55105d;
                    if (aVar == null) {
                        k.a("vpaListAdapter");
                    }
                    aVar.f55070e = this.f55106e;
                    aVar.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new c(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55112a;

        c(b bVar) {
            this.f55112a = bVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (this.f55112a.isAdded()) {
                if (dialogInterface != null) {
                    FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        frameLayout.setBackgroundColor(this.f55112a.getResources().getColor(R.color.transparent));
                        from.setState(3);
                        from.setPeekHeight(200);
                        from.setHideable(true);
                        from.setSkipCollapsed(true);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        y<String> f2;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.mt_v4_all_accounts_bottomsheet_fragment, viewGroup, false);
        net.one97.paytm.moneytransfer.c.y a2 = net.one97.paytm.moneytransfer.c.y.a(inflate);
        k.a((Object) a2, "MtV4AllAccountsBottomshe…ragmentBinding.bind(view)");
        RecyclerView recyclerView = a2.f53877b;
        k.a((Object) recyclerView, "accountsRecyclerView");
        a aVar = this.f55105d;
        if (aVar == null) {
            k.a("vpaListAdapter");
        }
        recyclerView.setAdapter(aVar);
        RecyclerView recyclerView2 = a2.f53877b;
        k.a((Object) recyclerView2, "binding.accountsRecyclerView");
        a2.a().addOnLayoutChangeListener(new f(recyclerView2));
        TextView textView = a2.l;
        k.a((Object) textView, "upiId");
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.f55107f;
        if (paymentCombinationAPIResponse == null) {
            k.a("paymentCombinationAPIResponse");
        }
        SenderInfo senderInfo = paymentCombinationAPIResponse.getSenderInfo();
        if (senderInfo == null || (str = senderInfo.getPhoneNumber()) == null) {
            str = com.paytm.utility.a.b(getContext());
        }
        textView.setText(str);
        this.u = a2.j;
        d();
        PaymentCombinationAPIResponse paymentCombinationAPIResponse2 = this.f55107f;
        if (paymentCombinationAPIResponse2 == null) {
            k.a("paymentCombinationAPIResponse");
        }
        if (paymentCombinationAPIResponse2.getSenderInfo() != null) {
            PaymentCombinationAPIResponse paymentCombinationAPIResponse3 = this.f55107f;
            if (paymentCombinationAPIResponse3 == null) {
                k.a("paymentCombinationAPIResponse");
            }
            SenderInfo senderInfo2 = paymentCombinationAPIResponse3.getSenderInfo();
            String str3 = null;
            if (!TextUtils.isEmpty(senderInfo2 != null ? senderInfo2.getName() : null)) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse4 = this.f55107f;
                if (paymentCombinationAPIResponse4 == null) {
                    k.a("paymentCombinationAPIResponse");
                }
                SenderInfo senderInfo3 = paymentCombinationAPIResponse4.getSenderInfo();
                if (senderInfo3 != null) {
                    str3 = senderInfo3.getName();
                }
            } else {
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.s;
                if (!(cVar == null || (f2 = cVar.f()) == null)) {
                    str3 = f2.getValue();
                }
                str3 = net.one97.paytm.upi.f.a(str3);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = com.paytm.utility.b.j(getContext());
            }
            TextView textView2 = a2.f53884i;
            k.a((Object) textView2, "name");
            textView2.setText(net.one97.paytm.upi.f.a(str3));
            PaymentCombinationAPIResponse paymentCombinationAPIResponse5 = this.f55107f;
            if (paymentCombinationAPIResponse5 == null) {
                k.a("paymentCombinationAPIResponse");
            }
            SenderInfo senderInfo4 = paymentCombinationAPIResponse5.getSenderInfo();
            if (senderInfo4 == null || (str2 = senderInfo4.getPicture()) == null) {
                str2 = com.paytm.utility.b.al(getContext());
            }
            if (!TextUtils.isEmpty(str2)) {
                w.a().a(str2).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a(a2.f53882g);
            } else if (!TextUtils.isEmpty(str3)) {
                TextView textView3 = a2.f53881f;
                k.a((Object) textView3, "contactInitials");
                textView3.setText(UpiUtils.getNameInitials(str3));
            } else {
                a2.f53882g.setPadding(10, 10, 10, 10);
                ImageView imageView = a2.f53882g;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.paytm_logo_money_transfer));
            }
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setOnClickListener(new C0998b(this, a2));
        }
        if (this.f55105d != null) {
            a aVar2 = this.f55105d;
            if (aVar2 == null) {
                k.a("vpaListAdapter");
            }
            if (aVar2.f55073h) {
                net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_ONE_DISABLED_COMBO, CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
            }
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), CJRGTMConstants.MT_V4_BOTTOMSHEET);
        ao aoVar = this;
        q qVar = this.f55103b;
        if (qVar == null) {
            k.a("viewModelFactory");
        }
        ai a3 = new al(aoVar, (al.b) qVar).a(net.one97.paytm.moneytransferv4.accountsbottomsheet.c.class);
        k.a((Object) a3, "ViewModelProvider(this, …eetViewModel::class.java]");
        this.f55104c = (net.one97.paytm.moneytransferv4.accountsbottomsheet.c) a3;
        net.one97.paytm.moneytransferv4.accountsbottomsheet.c cVar2 = this.f55104c;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        cVar2.b();
        return inflate;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b$b  reason: collision with other inner class name */
    static final class C0998b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.y f55111b;

        C0998b(b bVar, net.one97.paytm.moneytransfer.c.y yVar) {
            this.f55110a = bVar;
            this.f55111b = yVar;
        }

        public final void onClick(View view) {
            if (this.f55110a.isAdded() && this.f55110a.f55106e != -1) {
                List<PaymentOptionItem> list = b.a(this.f55110a).f55074i;
                if (this.f55110a.f55106e < list.size()) {
                    b bVar = this.f55110a;
                    b.a(bVar, list.get(bVar.f55106e));
                }
            }
        }
    }

    static final class f implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f55121a;

        f(RecyclerView recyclerView) {
            this.f55121a = recyclerView;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (i3 != i7 || i5 != i9) {
                RecyclerView.LayoutManager layoutManager = this.f55121a.getLayoutManager();
                int i10 = 0;
                View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(0) : null;
                RecyclerView.a adapter = this.f55121a.getAdapter();
                if (adapter != null) {
                    i10 = adapter.getItemCount();
                }
                if (findViewByPosition != null && i10 > 3) {
                    net.one97.paytm.upi.f.a((View) this.f55121a, (int) (((double) findViewByPosition.getHeight()) * 3.6d));
                }
            }
        }
    }

    public final void d() {
        if (isAdded()) {
            PaymentOptionItem i2 = i();
            if (i2 != null) {
                String combinationName = i2.getCombinationName();
                String str = null;
                if (combinationName != null) {
                    switch (combinationName.hashCode()) {
                        case -770941420:
                            if (combinationName.equals("UPI_RE_REGISTRATION")) {
                                TextView textView = this.u;
                                if (textView != null) {
                                    Context context = getContext();
                                    if (context != null) {
                                        str = context.getString(R.string.mt_v4_reactivate);
                                    }
                                    textView.setText(str);
                                    return;
                                }
                                return;
                            }
                            break;
                        case -704144125:
                            if (combinationName.equals("BANK_ACCOUNT_OPENING")) {
                                TextView textView2 = this.u;
                                if (textView2 != null) {
                                    Context context2 = getContext();
                                    if (context2 != null) {
                                        str = context2.getString(R.string.mt_v4_open_savings_account);
                                    }
                                    textView2.setText(str);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 370508577:
                            if (combinationName.equals("UPI_NEW_BANK_ACCOUNT_ADDITION")) {
                                return;
                            }
                            break;
                        case 407411180:
                            if (combinationName.equals("UPI_ONBOARDING")) {
                                if (UpiUtils.isInActiveProfileExist(getContext())) {
                                    TextView textView3 = this.u;
                                    if (textView3 != null) {
                                        Context context3 = getContext();
                                        if (context3 != null) {
                                            str = context3.getString(R.string.mt_v4_reactivate);
                                        }
                                        textView3.setText(str);
                                        return;
                                    }
                                    return;
                                }
                                TextView textView4 = this.u;
                                if (textView4 != null) {
                                    Context context4 = getContext();
                                    if (context4 != null) {
                                        str = context4.getString(R.string.mt_v4_link_account);
                                    }
                                    textView4.setText(str);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
                SourcePayment sourcePayment = i2.getSourcePayment();
                if (sourcePayment != null) {
                    str = sourcePayment.getPaymentInstrumentStatus();
                }
                if (str != null && str.hashCode() == -891611359 && str.equals("ENABLED")) {
                    b(i2);
                    return;
                }
                return;
            }
            b(i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r4.getSourcePayment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(net.one97.paytm.common.entity.p2p.PaymentOptionItem r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000e
            net.one97.paytm.common.entity.p2p.SourcePayment r1 = r4.getSourcePayment()
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.getPaymentType()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            java.lang.String r2 = "WALLET"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0041
            if (r4 == 0) goto L_0x0024
            net.one97.paytm.common.entity.p2p.SourcePayment r1 = r4.getSourcePayment()
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.getPaymentInstrumentStatus()
            goto L_0x0025
        L_0x0024:
            r1 = r0
        L_0x0025:
            java.lang.String r2 = "ENABLED"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0041
            android.widget.TextView r1 = r3.u
            java.lang.String r2 = r3.f55108g
            if (r4 == 0) goto L_0x003d
            net.one97.paytm.common.entity.p2p.SourcePayment r4 = r4.getSourcePayment()
            if (r4 == 0) goto L_0x003d
            java.lang.String r0 = r4.getBalance()
        L_0x003d:
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r0)
            return
        L_0x0041:
            r3.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b.b(net.one97.paytm.common.entity.p2p.PaymentOptionItem):void");
    }

    private final void e() {
        if (isAdded()) {
            m.a(this.u, this.f55108g);
        }
    }

    /* access modifiers changed from: private */
    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (this.q == null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.q = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.j)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UPICheckBalanceHelper uPICheckBalanceHelper = this.q;
        if (uPICheckBalanceHelper != null) {
            uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
    }

    public final void Z_() {
        a aVar = this.f55105d;
        if (aVar == null) {
            k.a("vpaListAdapter");
        }
        aVar.a();
    }

    public final void b() {
        a aVar = this.f55105d;
        if (aVar == null) {
            k.a("vpaListAdapter");
        }
        aVar.f55068c = false;
        aVar.notifyItemChanged(aVar.f55069d);
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        SourcePayment sourcePayment;
        k.c(str3, "accountType");
        if (isResumed()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(\n             …alance)\n                )");
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.s;
                if (cVar != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank = this.t;
                    if (upiProfileDefaultBank == null) {
                        k.a("selectedBankAccount");
                    }
                    BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                    k.a((Object) debitBank, "selectedBankAccount.debitBank");
                    String account = debitBank.getAccount();
                    k.a((Object) account, "selectedBankAccount.debitBank.account");
                    cVar.a(account, str4);
                }
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
                    UpiProfileDefaultBank upiProfileDefaultBank2 = this.t;
                    if (upiProfileDefaultBank2 == null) {
                        k.a("selectedBankAccount");
                    }
                    BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank2.getDebitBank();
                    k.a((Object) debitBank2, "selectedBankAccount.debitBank");
                    String account2 = debitBank2.getAccount();
                    k.a((Object) account2, "selectedBankAccount.debitBank.account");
                    bVar.a(account2, str4);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
                }
            } else {
                str4 = getString(R.string.mt_v4_available_balance, UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(R.string.mt_v4…String(availableBalance))");
                net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar2 = this.s;
                if (cVar2 != null) {
                    UpiProfileDefaultBank upiProfileDefaultBank3 = this.t;
                    if (upiProfileDefaultBank3 == null) {
                        k.a("selectedBankAccount");
                    }
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank3.getDebitBank();
                    k.a((Object) debitBank3, "selectedBankAccount.debitBank");
                    String account3 = debitBank3.getAccount();
                    k.a((Object) account3, "selectedBankAccount.debitBank.account");
                    cVar2.a(account3, str4);
                }
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    net.one97.paytm.moneytransferv4.home.presentation.a.b bVar2 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment2;
                    UpiProfileDefaultBank upiProfileDefaultBank4 = this.t;
                    if (upiProfileDefaultBank4 == null) {
                        k.a("selectedBankAccount");
                    }
                    BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank4.getDebitBank();
                    k.a((Object) debitBank4, "selectedBankAccount.debitBank");
                    String account4 = debitBank4.getAccount();
                    k.a((Object) account4, "selectedBankAccount.debitBank.account");
                    bVar2.a(account4, str4);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.home.presentation.payment.MoneyTransferV4PaymentFragment");
                }
            }
            a aVar = this.f55105d;
            if (aVar == null) {
                k.a("vpaListAdapter");
            }
            if (aVar != null) {
                k.c(str4, "balance");
                if (aVar.f55069d != -1) {
                    PaymentOptionItem paymentOptionItem = aVar.f55074i.get(aVar.f55069d);
                    if (!(paymentOptionItem == null || (sourcePayment = paymentOptionItem.getSourcePayment()) == null)) {
                        sourcePayment.getBankAccountNumber();
                    }
                    aVar.notifyItemChanged(aVar.f55069d);
                }
            }
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
        }
    }

    public final void a(n.b bVar) {
        k.c(bVar, "errorUPI");
        if (isResumed()) {
            if (bVar == n.b.INCORRECT_MPIN) {
                a(false);
            } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
                a(true);
            } else {
                UpiUtils.handleCheckBalanceError(getActivity(), bVar);
            }
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, CJRGTMConstants.MT_V4_BOTTOMSHEET, bVar.name(), "");
        }
    }

    private final void a(boolean z) {
        if (isAdded()) {
            j childFragmentManager = getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new g(this), childFragmentManager, z);
        }
    }

    public static final class g implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55122a;

        g(b bVar) {
            this.f55122a = bVar;
        }

        public final void onReEnterClicked() {
            b bVar = this.f55122a;
            bVar.a(b.b(bVar));
            net.one97.paytm.moneytransfer.utils.f.a(this.f55122a.getContext(), "mt_p2p_new_v1", "UPI_pin_reentered", CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
        }

        public final void onCreateNewPinClicked() {
            b bVar = this.f55122a;
            BankAccountDetails.BankAccount debitBank = b.b(bVar).getDebitBank();
            k.a((Object) debitBank, "selectedBankAccount.debitBank");
            k.c(debitBank, "bankAccount");
            Intent intent = new Intent(bVar.getActivity(), SetMPINActivity.class);
            List a2 = kotlin.a.k.a(debitBank);
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c cVar = bVar.f55104c;
            if (cVar == null) {
                k.a("viewModel");
            }
            UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, cVar.a()).setBankAccountList(a2).build();
            k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
            intent.putExtra("user_upi_details", build);
            intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
            bVar.startActivityForResult(intent, bVar.f55102a);
            net.one97.paytm.moneytransfer.utils.f.a(bVar.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
            net.one97.paytm.moneytransfer.utils.f.a(this.f55122a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        y<String> e2;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == this.f55109i) {
            h();
        } else if (i2 == this.f55102a) {
            h();
        } else if (i2 == this.k) {
            h();
        } else {
            String str = null;
            if (i2 == this.l) {
                Serializable serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
                if (serializableExtra != null) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                    Fragment fragment = this;
                    net.one97.paytm.moneytransferv4.home.presentation.viewmodel.c cVar = this.s;
                    if (!(cVar == null || (e2 = cVar.e()) == null)) {
                        str = e2.getValue();
                    }
                    BankVpaCreationActivity.a(fragment, accountProvider, str, this.m);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            } else if (i2 == this.m) {
                h();
            } else if (i2 == this.n) {
                h();
            } else if (i2 == this.p) {
                h();
            } else if (i2 == 288) {
                if (intent != null) {
                    Serializable serializableExtra2 = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                    if (!(serializableExtra2 instanceof AccountProviderBody.AccountProvider)) {
                        serializableExtra2 = null;
                    }
                    AccountProviderBody.AccountProvider accountProvider2 = (AccountProviderBody.AccountProvider) serializableExtra2;
                    if (accountProvider2 != null) {
                        UpiRegistrationActivity.a((Fragment) this, accountProvider2, UpiConstants.UPI_ONBOARDING_SELF_DESTROY, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
                    }
                }
            } else if (i2 == 352) {
                h();
            }
        }
    }

    private final void f() {
        if (isResumed()) {
            dismiss();
        }
    }

    public final void a(PaymentOptionItem paymentOptionItem, int i2) {
        k.c(paymentOptionItem, "paymentOptionItem");
        a aVar = this.f55105d;
        if (aVar == null) {
            k.a("vpaListAdapter");
        }
        aVar.a();
        b.a aVar2 = net.one97.paytm.moneytransferv4.g.b.f55426a;
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.f55107f;
        if (paymentCombinationAPIResponse == null) {
            k.a("paymentCombinationAPIResponse");
        }
        UpiProfileDefaultBank a2 = b.a.a(paymentCombinationAPIResponse, paymentOptionItem);
        k.c(a2, "upiProfileDefaultBank");
        this.t = a2;
        if (isResumed()) {
            this.r = i2;
            if (com.paytm.utility.a.m(getContext())) {
                UpiProfileDefaultBank.PAYMENT_MODE paymentMode = a2.getPaymentMode();
                if (paymentMode != null) {
                    int i3 = c.f55123a[paymentMode.ordinal()];
                    if (i3 == 1) {
                        a(a2);
                    } else if (i3 == 2) {
                        a(a2);
                    }
                }
            } else {
                m.d((Activity) getActivity());
            }
        }
    }

    public final void a(PaymentOptionItem paymentOptionItem) {
        k.c(paymentOptionItem, "paymentOptionItem");
        b.a aVar = net.one97.paytm.moneytransferv4.g.b.f55426a;
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.f55107f;
        if (paymentCombinationAPIResponse == null) {
            k.a("paymentCombinationAPIResponse");
        }
        UpiProfileDefaultBank a2 = b.a.a(paymentCombinationAPIResponse, paymentOptionItem);
        if (!isResumed()) {
            return;
        }
        if (com.paytm.utility.a.m(getContext())) {
            int i2 = this.k;
            Intent intent = new Intent(getActivity(), SetMPINActivity.class);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.getDebitBank());
            intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, a2.getVirtualAddress()).setBankAccountList(arrayList).build());
            intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, false);
            startActivityForResult(intent, i2);
            return;
        }
        m.d((Activity) getActivity());
    }

    private final void g() {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, this.n);
    }

    public final void a(View view, PaymentOptionItem paymentOptionItem, CircularProgressBar circularProgressBar) {
        k.c(view, "view");
        k.c(paymentOptionItem, "paymentOptionItem");
        k.c(circularProgressBar, "arrowPositionView");
        circularProgressBar.setIndeterminate(true);
        circularProgressBar.setProgress(0.0f);
        if (paymentOptionItem.getSenderDisplayInformation() != null) {
            int right = circularProgressBar.getRight() - (circularProgressBar.getWidth() / 2);
            a.C0999a a2 = new a.C0999a(view, R.style.Tooltip2).a().b().a(R.dimen.dimen_0dp);
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c cVar = this.f55104c;
            if (cVar == null) {
                k.a("viewModel");
            }
            a.C0999a a3 = a2.a(cVar.c());
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c cVar2 = this.f55104c;
            if (cVar2 == null) {
                k.a("viewModel");
            }
            String n2 = cVar2.f55020a.n();
            k.a((Object) n2, "registrationRepository.isKYCUser");
            a.C0999a a4 = a3.a(n2).b(right).a(paymentOptionItem.getSenderDisplayInformation()).a((a.c) new d(this, circularProgressBar, view, paymentOptionItem)).a((a.b) new e(this, circularProgressBar, view, paymentOptionItem));
            k.a((Object) a4, "Tooltip.Builder(view, R.…ick(it)\n                }");
            a4.c();
            Context context = view.getContext();
            String combinationName = paymentOptionItem.getCombinationName();
            if (combinationName == null) {
                combinationName = "";
            }
            String str = combinationName;
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c cVar3 = this.f55104c;
            if (cVar3 == null) {
                k.a("viewModel");
            }
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_INFO_CLICKED, CJRGTMConstants.MT_V4_BOTTOMSHEET, str, String.valueOf(cVar3.c()));
        }
    }

    static final class d implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CircularProgressBar f55114b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f55115c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PaymentOptionItem f55116d;

        d(b bVar, CircularProgressBar circularProgressBar, View view, PaymentOptionItem paymentOptionItem) {
            this.f55113a = bVar;
            this.f55114b = circularProgressBar;
            this.f55115c = view;
            this.f55116d = paymentOptionItem;
        }

        public final void a() {
            this.f55114b.setIndeterminate(false);
            this.f55114b.setProgress(100.0f);
        }
    }

    static final class e implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f55117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CircularProgressBar f55118b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f55119c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PaymentOptionItem f55120d;

        e(b bVar, CircularProgressBar circularProgressBar, View view, PaymentOptionItem paymentOptionItem) {
            this.f55117a = bVar;
            this.f55118b = circularProgressBar;
            this.f55119c = view;
            this.f55120d = paymentOptionItem;
        }

        public final void a(SenderDisplayInformation senderDisplayInformation) {
            b.a(this.f55117a, senderDisplayInformation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r7.equals("UPI_RE_REGISTRATION") != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r7 = r8.getCombinationName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r7 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (r7.equals("UPI_ONBOARDING") != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r7.equals("UPI_NEW_BANK_ACCOUNT_ADDITION") != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        if (r7.equals("BANK_ACCOUNT_OPENING") != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7, net.one97.paytm.common.entity.p2p.PaymentOptionItem r8) {
        /*
            r6 = this;
            java.lang.String r0 = "paymentOptionItem"
            kotlin.g.b.k.c(r8, r0)
            r6.f55106e = r7
            r6.d()
            java.lang.String r7 = r8.getCombinationName()
            if (r7 != 0) goto L_0x0011
            goto L_0x0047
        L_0x0011:
            int r0 = r7.hashCode()
            switch(r0) {
                case -770941420: goto L_0x0034;
                case -704144125: goto L_0x002b;
                case 370508577: goto L_0x0022;
                case 407411180: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0047
        L_0x0019:
            java.lang.String r0 = "UPI_ONBOARDING"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0047
            goto L_0x003c
        L_0x0022:
            java.lang.String r0 = "UPI_NEW_BANK_ACCOUNT_ADDITION"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0047
            goto L_0x003c
        L_0x002b:
            java.lang.String r0 = "BANK_ACCOUNT_OPENING"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0047
            goto L_0x003c
        L_0x0034:
            java.lang.String r0 = "UPI_RE_REGISTRATION"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0047
        L_0x003c:
            java.lang.String r7 = r8.getCombinationName()
            if (r7 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            r4 = r7
            goto L_0x0095
        L_0x0047:
            net.one97.paytm.common.entity.p2p.SourcePayment r7 = r8.getSourcePayment()
            r0 = 0
            if (r7 == 0) goto L_0x0053
            java.lang.String r1 = r7.getPaymentInstrumentStatus()
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            if (r1 != 0) goto L_0x0057
            goto L_0x0089
        L_0x0057:
            int r2 = r1.hashCode()
            r3 = -891611359(0xffffffffcadb1721, float:-7179152.5)
            if (r2 == r3) goto L_0x0061
            goto L_0x0089
        L_0x0061:
            java.lang.String r2 = "ENABLED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0089
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r6.f55107f
            if (r1 != 0) goto L_0x0072
            java.lang.String r2 = "paymentCombinationAPIResponse"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0072:
            net.one97.paytm.common.entity.p2p.ReceiverInfo r1 = r1.getReceiverInfo()
            if (r1 == 0) goto L_0x0089
            androidx.fragment.app.Fragment r2 = r6.getParentFragment()
            boolean r3 = r2 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b
            if (r3 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r0 = r2
        L_0x0082:
            net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) r0
            if (r0 == 0) goto L_0x0089
            r0.a((net.one97.paytm.common.entity.p2p.PaymentOptionItem) r8, (net.one97.paytm.common.entity.p2p.ReceiverInfo) r1)
        L_0x0089:
            if (r7 == 0) goto L_0x0092
            java.lang.String r7 = r7.getPaymentType()
            if (r7 == 0) goto L_0x0092
            goto L_0x0045
        L_0x0092:
            java.lang.String r7 = ""
            goto L_0x0045
        L_0x0095:
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.moneytransferv4.accountsbottomsheet.c r7 = r6.f55104c
            if (r7 != 0) goto L_0x00a3
            java.lang.String r8 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00a3:
            boolean r7 = r7.c()
            java.lang.String r5 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "mt_p2p_new_v1"
            java.lang.String r2 = "source_ac_list_item_clicked"
            java.lang.String r3 = "/mt_p2p_bottomsheet"
            net.one97.paytm.moneytransfer.utils.f.a(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b.a(int, net.one97.paytm.common.entity.p2p.PaymentOptionItem):void");
    }

    private final void a(SenderDisplayInformation senderDisplayInformation) {
        String cta;
        if (senderDisplayInformation != null && (cta = senderDisplayInformation.getCta()) != null) {
            b(cta);
        }
    }

    private final void b(String str) {
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        b2.a((Context) activity, str);
    }

    private final void h() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b)) {
            parentFragment = null;
        }
        net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = (net.one97.paytm.moneytransferv4.home.presentation.a.b) parentFragment;
        if (bVar != null) {
            bVar.m();
        }
    }

    public final void a(String str) {
        k.c(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        if (this.f55105d != null) {
            a aVar = this.f55105d;
            if (aVar == null) {
                k.a("vpaListAdapter");
            }
            k.c(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
            int i2 = 0;
            for (Object next : aVar.f55074i) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                SourcePayment sourcePayment = ((PaymentOptionItem) next).getSourcePayment();
                if (k.a((Object) str, (Object) sourcePayment != null ? sourcePayment.getBankAccountNumber() : null)) {
                    SourcePayment sourcePayment2 = aVar.f55074i.get(i2).getSourcePayment();
                    if (sourcePayment2 != null) {
                        sourcePayment2.setBalance(aVar.k.get(str));
                    }
                    aVar.notifyItemChanged(i2, "");
                }
                i2 = i3;
            }
        }
    }

    private final PaymentOptionItem i() {
        List<PaymentOptionItem> paymentOptionList;
        int i2;
        if (this.f55107f == null) {
            return null;
        }
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.f55107f;
        if (paymentCombinationAPIResponse == null) {
            k.a("paymentCombinationAPIResponse");
        }
        if (paymentCombinationAPIResponse == null || (paymentOptionList = paymentCombinationAPIResponse.getPaymentOptionList()) == null || (i2 = this.f55106e) < 0 || i2 >= paymentOptionList.size()) {
            return null;
        }
        return paymentOptionList.get(this.f55106e);
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        if (!jVar.h() && !jVar.i()) {
            super.show(jVar, str);
        }
    }

    public final void c() {
        com.paytm.b.a.a aVar;
        boolean z;
        Context applicationContext;
        Context applicationContext2;
        Context context = getContext();
        com.paytm.b.a.a aVar2 = null;
        if (context == null || (applicationContext2 = context.getApplicationContext()) == null) {
            aVar = null;
        } else {
            l.a aVar3 = l.f54175a;
            aVar = l.a.a(applicationContext2);
        }
        boolean z2 = false;
        if (aVar != null) {
            z = aVar.b("is_upi_user", false, true);
        } else {
            z = false;
        }
        if (z) {
            Context context2 = getContext();
            if (!(context2 == null || (applicationContext = context2.getApplicationContext()) == null)) {
                l.a aVar4 = l.f54175a;
                aVar2 = l.a.a(applicationContext);
            }
            if (aVar2 != null) {
                z2 = aVar2.b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
            }
            if (!z2) {
                int i2 = this.f55109i;
                Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
                intent.putExtra("redirect", 80);
                intent.setFlags(536870912);
                startActivityForResult(intent, i2);
            } else if (com.paytm.utility.a.m(getContext())) {
                AccountProviderActivity.a((Fragment) this, this.l);
            } else {
                m.d((Activity) getActivity());
            }
        } else if (UpiUtils.isInActiveProfileExist(getContext())) {
            startActivity(UpiUtils.getUpiLandingPageActivityIntent(getActivity()));
        } else {
            Intent intent2 = new Intent(getActivity(), UpiSelectBankActivity.class);
            intent2.setFlags(536870912);
            intent2.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
            startActivity(intent2);
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, CJRGTMConstants.MT_V4_BOTTOMSHEET, "", "");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b r10, net.one97.paytm.common.entity.p2p.PaymentOptionItem r11) {
        /*
            androidx.fragment.app.Fragment r0 = r10.getParentFragment()
            boolean r1 = r0 instanceof net.one97.paytm.moneytransferv4.home.presentation.a.b
            r2 = 0
            if (r1 != 0) goto L_0x000a
            r0 = r2
        L_0x000a:
            net.one97.paytm.moneytransferv4.home.presentation.a.b r0 = (net.one97.paytm.moneytransferv4.home.presentation.a.b) r0
            if (r0 == 0) goto L_0x0149
            if (r11 == 0) goto L_0x0015
            java.lang.String r1 = r11.getCombinationName()
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            java.lang.String r3 = "Reactivate"
            if (r1 != 0) goto L_0x001c
            goto L_0x0137
        L_0x001c:
            int r4 = r1.hashCode()
            java.lang.String r5 = "paymentCombinationAPIResponse"
            switch(r4) {
                case -2065608805: goto L_0x011c;
                case -1387319219: goto L_0x00cf;
                case -770941420: goto L_0x00c3;
                case -704144125: goto L_0x00b4;
                case -174015080: goto L_0x0097;
                case 370508577: goto L_0x008f;
                case 407411180: goto L_0x006d;
                case 487575503: goto L_0x0050;
                case 982230829: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0137
        L_0x0027:
            java.lang.String r2 = "BANK-BANK"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0137
            net.one97.paytm.moneytransferv4.g.b$a r1 = net.one97.paytm.moneytransferv4.g.b.f55426a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.f55107f
            if (r1 != 0) goto L_0x0038
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0038:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = net.one97.paytm.moneytransferv4.g.b.a.a(r1, r11)
            java.lang.String r1 = "upiProfileDefaultBank"
            kotlin.g.b.k.c(r11, r1)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.SAVINGS_ACCOUNT
            r0.f55446i = r1
            r0.f55444g = r11
            r0.g()
            r10.f()
            goto L_0x0137
        L_0x0050:
            java.lang.String r2 = "UPI-UPI"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0137
            net.one97.paytm.moneytransferv4.g.b$a r1 = net.one97.paytm.moneytransferv4.g.b.f55426a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.f55107f
            if (r1 != 0) goto L_0x0061
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0061:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = net.one97.paytm.moneytransferv4.g.b.a.a(r1, r11)
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r11)
            r10.f()
            goto L_0x0137
        L_0x006d:
            java.lang.String r11 = "UPI_ONBOARDING"
            boolean r11 = r1.equals(r11)
            if (r11 == 0) goto L_0x0137
            android.content.Context r11 = r0.getContext()
            boolean r11 = net.one97.paytm.upi.util.UpiUtils.isInActiveProfileExist(r11)
            if (r11 == 0) goto L_0x0084
            r10.g()
            goto L_0x0139
        L_0x0084:
            androidx.fragment.app.Fragment r10 = (androidx.fragment.app.Fragment) r10
            r11 = 288(0x120, float:4.04E-43)
            net.one97.paytm.upi.registration.view.AccountProviderActivity.a((androidx.fragment.app.Fragment) r10, (int) r11)
            java.lang.String r3 = "Link bank account"
            goto L_0x0139
        L_0x008f:
            java.lang.String r10 = "UPI_NEW_BANK_ACCOUNT_ADDITION"
            boolean r10 = r1.equals(r10)
            goto L_0x0137
        L_0x0097:
            java.lang.String r2 = "UPI-WALLET"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0137
            net.one97.paytm.moneytransferv4.g.b$a r1 = net.one97.paytm.moneytransferv4.g.b.f55426a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.f55107f
            if (r1 != 0) goto L_0x00a8
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00a8:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = net.one97.paytm.moneytransferv4.g.b.a.a(r1, r11)
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r11)
            r10.f()
            goto L_0x0137
        L_0x00b4:
            java.lang.String r11 = "BANK_ACCOUNT_OPENING"
            boolean r11 = r1.equals(r11)
            if (r11 == 0) goto L_0x0137
            java.lang.String r11 = r10.o
            r10.b((java.lang.String) r11)
            goto L_0x0137
        L_0x00c3:
            java.lang.String r11 = "UPI_RE_REGISTRATION"
            boolean r11 = r1.equals(r11)
            if (r11 == 0) goto L_0x0137
            r10.g()
            goto L_0x0139
        L_0x00cf:
            java.lang.String r3 = "WALLET-WALLET"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0137
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.f55107f
            if (r1 != 0) goto L_0x00de
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00de:
            if (r1 == 0) goto L_0x00e5
            net.one97.paytm.common.entity.p2p.ReceiverInfo r1 = r1.getReceiverInfo()
            goto L_0x00e6
        L_0x00e5:
            r1 = r2
        L_0x00e6:
            if (r1 != 0) goto L_0x00eb
            kotlin.g.b.k.a()
        L_0x00eb:
            java.lang.String r3 = "paymentOptionItem"
            kotlin.g.b.k.c(r11, r3)
            java.lang.String r3 = "receiverInfo"
            kotlin.g.b.k.c(r1, r3)
            r0.l = r11
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$d r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.d.WALLET
            r0.f55446i = r1
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$a r1 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.a.WALLET
            r0.f55439b = r1
            r0.g()
            r10.f()
            java.lang.String r10 = r10.f55108g
            if (r11 == 0) goto L_0x0113
            net.one97.paytm.common.entity.p2p.SourcePayment r11 = r11.getSourcePayment()
            if (r11 == 0) goto L_0x0113
            java.lang.String r2 = r11.getBalance()
        L_0x0113:
            boolean r10 = net.one97.paytm.moneytransfer.utils.m.b((java.lang.String) r10, (java.lang.String) r2)
            if (r10 == 0) goto L_0x0137
            java.lang.String r3 = "Add & pay"
            goto L_0x0139
        L_0x011c:
            java.lang.String r2 = "UPI-BANK"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0137
            net.one97.paytm.moneytransferv4.g.b$a r1 = net.one97.paytm.moneytransferv4.g.b.f55426a
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r1 = r10.f55107f
            if (r1 != 0) goto L_0x012d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x012d:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = net.one97.paytm.moneytransferv4.g.b.a.a(r1, r11)
            r0.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r11)
            r10.f()
        L_0x0137:
            java.lang.String r3 = "Pay"
        L_0x0139:
            r8 = r3
            android.content.Context r4 = r0.getContext()
            java.lang.String r5 = "mt_p2p_new_v1"
            java.lang.String r6 = "pay_bottomsheet_clicked"
            java.lang.String r7 = "/mt_p2p_bottomsheet"
            java.lang.String r9 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r4, r5, r6, r7, r8, r9)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b.a(net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b, net.one97.paytm.common.entity.p2p.PaymentOptionItem):void");
    }

    public static final /* synthetic */ void a(b bVar, SenderDisplayInformation senderDisplayInformation) {
        if (bVar.isAdded()) {
            String str = null;
            if (!TextUtils.isEmpty(senderDisplayInformation != null ? senderDisplayInformation.getDeeplinkType() : null)) {
                if (senderDisplayInformation != null) {
                    str = senderDisplayInformation.getDeeplinkType();
                }
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != 1783174408) {
                        if (hashCode == 2114948837 && str.equals("FULL_KYC")) {
                            bVar.a(senderDisplayInformation);
                        }
                    } else if (str.equals("MIN_KYC")) {
                        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                        Class<?> cls = Class.forName(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).j());
                        k.a((Object) cls, "Class.forName(className)");
                        if (cls != null) {
                            bVar.startActivityForResult(new Intent(bVar.getActivity(), cls), bVar.p);
                        }
                    }
                }
            } else if (bVar.getActivity() != null) {
                bVar.a(senderDisplayInformation);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

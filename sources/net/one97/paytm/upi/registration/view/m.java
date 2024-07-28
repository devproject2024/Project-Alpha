package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.j;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.c.d;
import net.one97.paytm.upi.registration.view.l;
import net.one97.paytm.upi.registration.view.r;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class m extends Fragment implements l.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68969a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f68970b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f68971c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f68972d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68973e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68974f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.upi.registration.c.d f68975g;

    /* renamed from: h  reason: collision with root package name */
    private d.b f68976h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<BankAccountDetails.BankAccount> f68977i = new ArrayList<>();
    private String j;
    private final int k = 10;
    private final int l = 12;
    private AccountProviderBody.AccountProvider m;
    private l n;
    private HashMap o;

    static final class d<T> implements z<j<d.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f68980a;

        d(m mVar) {
            this.f68980a = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.l lVar;
            j jVar = (j) obj;
            if (jVar != null) {
                lVar = jVar.f67004a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                int i2 = n.f68986c[lVar.ordinal()];
                if (i2 == 1) {
                    m.c(this.f68980a);
                    d.a aVar = (d.a) jVar.f67005b;
                    if (aVar != null) {
                        m.a(this.f68980a, aVar);
                    }
                } else if (i2 == 2) {
                    m.c(this.f68980a);
                    UpiCustomVolleyError upiCustomVolleyError = jVar.f67006c;
                    if (upiCustomVolleyError != null) {
                        m.b(this.f68980a, upiCustomVolleyError);
                    }
                } else if (i2 == 3) {
                    m.b(this.f68980a);
                }
            }
        }
    }

    static final class e<T> implements z<j<List<? extends BankAccountDetails.BankAccount>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.upi.registration.c.d f68981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f68982b;

        e(net.one97.paytm.upi.registration.c.d dVar, m mVar) {
            this.f68981a = dVar;
            this.f68982b = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.l lVar;
            j jVar = (j) obj;
            if (jVar != null) {
                lVar = jVar.f67004a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                int i2 = n.f68985b[lVar.ordinal()];
                if (i2 == 1) {
                    m.b(this.f68982b);
                } else if (i2 == 2) {
                    ResultType resulttype = jVar.f67005b;
                    if (resulttype == null) {
                        k.a();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (BankAccountDetails.BankAccount tempAccRefId : (List) resulttype) {
                        arrayList.add(tempAccRefId.getTempAccRefId());
                    }
                    net.one97.paytm.upi.registration.c.d dVar = this.f68981a;
                    k.c(arrayList, "accountRefIds");
                    y<j<d.b>> yVar = dVar.f68554b;
                    if (yVar != null) {
                        j.a aVar = j.f67003d;
                        yVar.setValue(j.a.a());
                    }
                    net.one97.paytm.upi.profile.b.b bVar = dVar.f68553a;
                    if (bVar != null) {
                        bVar.a((a.C1382a) new d.g(dVar), "", (ArrayList<String>) arrayList);
                    }
                } else if (i2 == 3) {
                    m.c(this.f68982b);
                    m.a(this.f68982b, jVar.f67006c);
                }
            }
        }
    }

    static final class f<T> implements z<j<d.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f68983a;

        f(m mVar) {
            this.f68983a = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.l lVar;
            j jVar = (j) obj;
            if (jVar != null) {
                lVar = jVar.f67004a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                int i2 = n.f68984a[lVar.ordinal()];
                if (i2 == 1) {
                    m.b(this.f68983a);
                } else if (i2 == 2) {
                    m.c(this.f68983a);
                    m.a(this.f68983a, (d.b) jVar.f67005b);
                } else if (i2 == 3) {
                    m.c(this.f68983a);
                    m.a(this.f68983a, jVar.f67006c);
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static m a(ArrayList<BankAccountDetails.BankAccount> arrayList, String str) {
            k.c(arrayList, "bankList");
            k.c(str, "vpa");
            m mVar = new m();
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.ARG_BANK_LIST, arrayList);
            bundle.putString("vpa", str);
            mVar.setArguments(bundle);
            return mVar;
        }
    }

    private void a(boolean z) {
        TextView textView = this.f68973e;
        if (textView == null) {
            k.a("mTvConfirm");
        }
        textView.setEnabled(z);
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable(UpiConstants.ARG_BANK_LIST) : null;
            if (serializable != null) {
                this.f68977i = (ArrayList) serializable;
                Bundle arguments2 = getArguments();
                if (arguments2 == null || (str = arguments2.getString("vpa")) == null) {
                    str = "";
                }
                this.j = str;
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> /* = java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> */");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LiveData<j<d.a>> liveData;
        y<j<d.b>> yVar;
        LayoutInflater layoutInflater2 = layoutInflater;
        k.c(layoutInflater2, "inflater");
        int i2 = 0;
        View inflate = layoutInflater2.inflate(R.layout.fragment_sign_up_add_bank, viewGroup, false);
        this.f68975g = (net.one97.paytm.upi.registration.c.d) am.a((Fragment) this).a(net.one97.paytm.upi.registration.c.d.class);
        View findViewById = inflate.findViewById(R.id.rv_bank_account_list);
        k.a((Object) findViewById, "view.findViewById(R.id.rv_bank_account_list)");
        this.f68970b = (RecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.loader_container);
        k.a((Object) findViewById2, "view.findViewById(R.id.loader_container)");
        this.f68971c = (RelativeLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.progress_loader);
        k.a((Object) findViewById3, "view.findViewById(R.id.progress_loader)");
        this.f68972d = (LottieAnimationView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.tv_title);
        k.a((Object) findViewById4, "view.findViewById(R.id.tv_title)");
        this.f68974f = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tv_confirm);
        k.a((Object) findViewById5, "view.findViewById(R.id.tv_confirm)");
        this.f68973e = (TextView) findViewById5;
        RecyclerView recyclerView = this.f68970b;
        if (recyclerView == null) {
            k.a("mRvBankList");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((ImageView) inflate.findViewById(R.id.iv_back)).setOnClickListener(new b(this));
        net.one97.paytm.upi.registration.c.d dVar = this.f68975g;
        if (!(dVar == null || (yVar = dVar.f68554b) == null)) {
            yVar.observe(this, new f(this));
        }
        net.one97.paytm.upi.registration.c.d dVar2 = this.f68975g;
        if (dVar2 != null) {
            dVar2.f68556d.observe(this, new e(dVar2, this));
        }
        net.one97.paytm.upi.registration.c.d dVar3 = this.f68975g;
        if (!(dVar3 == null || (liveData = dVar3.f68559g) == null)) {
            liveData.observe(this, new d(this));
        }
        TextView textView = this.f68973e;
        if (textView == null) {
            k.a("mTvConfirm");
        }
        textView.setOnClickListener(new c(this));
        this.n = new l(this.f68977i, getActivity(), this);
        RecyclerView recyclerView2 = this.f68970b;
        if (recyclerView2 == null) {
            k.a("mRvBankList");
        }
        recyclerView2.setAdapter(this.n);
        if (UpiUtils.isPaytmFirstApp()) {
            View findViewById6 = inflate.findViewById(R.id.i_bottom_strip);
            k.a((Object) findViewById6, "view.findViewById<Relati…out>(R.id.i_bottom_strip)");
            ((RelativeLayout) findViewById6).setVisibility(4);
            View findViewById7 = inflate.findViewById(R.id.motif_iv);
            k.a((Object) findViewById7, "view.findViewById<ImageView>(R.id.motif_iv)");
            ((ImageView) findViewById7).setVisibility(8);
        }
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68977i;
        if (arrayList != null) {
            i2 = arrayList.size();
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", String.valueOf(i2), "", "", GAConstants.SCREEN_NAME.UPI_ONB_BANK_ACCOUNT_DISCOVERED, "wallet");
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_MULTIPLE_ACC_LINK, "");
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f68978a;

        b(m mVar) {
            this.f68978a = mVar;
        }

        public final void onClick(View view) {
            this.f68978a.b();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f68979a;

        c(m mVar) {
            this.f68979a = mVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.upi.registration.c.d a2 = this.f68979a.f68975g;
            if (a2 != null) {
                a2.a();
            }
            if (this.f68979a.getActivity() instanceof SignUpAddBankActivity) {
                FragmentActivity activity = this.f68979a.getActivity();
                if (activity != null) {
                    ((SignUpAddBankActivity) activity).b(0);
                    CJRSendGTMTag.sendNewCustomGTMEvents(this.f68979a.getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_AC_LINKED_PROCEED_CLICKED, "", "", "", GAConstants.SCREEN_NAME.UPI_MULTIPLE_ACC_LINK, "");
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
            }
        }
    }

    public final void b() {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "multiple_link_bank_account_back_arrow", "", "", "", "/bhim-upi/signup/multiplelinkaccount", "wallet");
        if (getActivity() instanceof SignUpAddBankActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((SignUpAddBankActivity) activity).b(3);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
            }
        }
        net.one97.paytm.upi.registration.c.d dVar = this.f68975g;
        if (dVar != null) {
            dVar.a();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<BankAccountDetails.BankAccount> arrayList;
        super.onActivityResult(i2, i3, intent);
        String str = null;
        if (i2 == this.k) {
            if (i3 == -1) {
                if (intent != null) {
                    str = intent.getStringExtra(UpiConstants.EXTRA_SELECTED_BANK);
                }
                CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "mpin_set_success_onboarding", str, "", "", "/bhim-upi/signup/multiplelinkaccount", "wallet");
                if (getActivity() instanceof SignUpAddBankActivity) {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        androidx.fragment.app.j supportFragmentManager = ((SignUpAddBankActivity) activity).getSupportFragmentManager();
                        r.a aVar = r.f69034a;
                        r rVar = new r();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(rVar.f69036c, (Serializable) 3);
                        rVar.setArguments(bundle);
                        UpiUtils.replaceFragmentToActivity(supportFragmentManager, rVar, R.id.container, true);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
                }
                return;
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "mpin_set_failed_onboarding", "", "", "", "/bhim-upi/signup/multiplelinkaccount", "wallet");
            d.b bVar = this.f68976h;
            if (bVar == null || (arrayList = bVar.f68565a) == null) {
                arrayList = new ArrayList<>();
            }
            if (getActivity() instanceof SignUpAddBankActivity) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    SignUpAddBankActivity signUpAddBankActivity = (SignUpAddBankActivity) activity2;
                    String str2 = this.j;
                    if (str2 == null) {
                        k.a("vpa");
                    }
                    k.c(arrayList, "bankList");
                    androidx.fragment.app.j supportFragmentManager2 = signUpAddBankActivity.getSupportFragmentManager();
                    r.a aVar2 = r.f69034a;
                    k.c(arrayList, "bankList");
                    r rVar2 = new r();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(rVar2.f69035b, arrayList);
                    bundle2.putSerializable(rVar2.f69036c, (Serializable) 1);
                    bundle2.putSerializable(rVar2.f69037d, str2);
                    rVar2.setArguments(bundle2);
                    UpiUtils.replaceFragmentToActivity(supportFragmentManager2, rVar2, R.id.container, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
            }
        } else if (i2 == this.l && i3 == -1) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
            if (!(serializableExtra instanceof AccountProviderBody.AccountProvider)) {
                serializableExtra = null;
            }
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
            if (accountProvider != null) {
                this.m = accountProvider;
                net.one97.paytm.upi.registration.c.d dVar = this.f68975g;
                if (dVar != null) {
                    String str3 = this.j;
                    if (str3 == null) {
                        k.a("vpa");
                    }
                    k.c(accountProvider, "account");
                    k.c(str3, "vpa");
                    y<j<List<BankAccountDetails.BankAccount>>> yVar = dVar.f68555c;
                    j.a aVar3 = j.f67003d;
                    yVar.setValue(j.a.a());
                    net.one97.paytm.upi.profile.b.b bVar2 = dVar.f68553a;
                    if (bVar2 != null) {
                        bVar2.a(accountProvider.getIfsc(), str3, (a.C1382a) new d.c(dVar), dVar.f68557e);
                    }
                }
            }
        }
    }

    public final void a() {
        AccountProviderActivity.a((Fragment) this, this.l);
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.ADD_BANK_ACC_CLICKED_LINK_ACC_SCREEN, "", "", "", GAConstants.SCREEN_NAME.UPI_MULTIPLE_ACC_LINK, "");
    }

    public final void a(int i2, BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        net.one97.paytm.upi.registration.c.d dVar = this.f68975g;
        if (dVar != null) {
            String str = this.j;
            if (str == null) {
                k.a("vpa");
            }
            k.c(str, "vpa");
            k.c(bankAccount, "bankAccount");
            y<j<d.a>> yVar = dVar.f68558f;
            j.a aVar = j.f67003d;
            yVar.setValue(j.a.a());
            UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, str).setBankAccountList(kotlin.a.k.a(bankAccount)).setSelectedBankIdx(0).build();
            net.one97.paytm.upi.profile.b.b bVar = dVar.f68553a;
            if (bVar != null) {
                bVar.a(build, (a.C1382a) new d.C1393d(dVar, i2), dVar.f68557e, "");
            }
        }
    }

    public static final /* synthetic */ void b(m mVar) {
        mVar.a(false);
        RecyclerView recyclerView = mVar.f68970b;
        if (recyclerView == null) {
            k.a("mRvBankList");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((l) adapter).a(true);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankAdapter");
    }

    public static final /* synthetic */ void c(m mVar) {
        RecyclerView recyclerView = mVar.f68970b;
        if (recyclerView == null) {
            k.a("mRvBankList");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((l) adapter).a(false);
            mVar.a(true);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankAdapter");
    }

    public static final /* synthetic */ void a(m mVar, d.b bVar) {
        ArrayList<BankAccountDetails.BankAccount> arrayList;
        mVar.f68976h = bVar;
        if (bVar != null) {
            arrayList = bVar.f68565a;
        } else {
            arrayList = null;
        }
        if (arrayList != null && !bVar.f68565a.isEmpty()) {
            int size = mVar.f68977i.size();
            mVar.f68977i.addAll(bVar.f68565a);
            RecyclerView recyclerView = mVar.f68970b;
            if (recyclerView == null) {
                k.a("mRvBankList");
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeInserted(size, mVar.f68977i.size());
            }
        }
    }

    public static final /* synthetic */ void a(m mVar, UpiCustomVolleyError upiCustomVolleyError) {
        String str;
        if (upiCustomVolleyError != null) {
            str = upiCustomVolleyError.getmErrorCode();
            k.a((Object) str, "error.getmErrorCode()");
            if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                i a2 = i.a();
                k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                new UpiCustomVolleyError();
                m.class.getName();
                a2.b().e(mVar.getActivity());
            } else if (p.a(upiCustomVolleyError.getmErrorCode(), "XH", true)) {
                int i2 = R.string.upi_add_bank_no_acc_found;
                Object[] objArr = new Object[2];
                objArr[0] = "+" + UpiUtils.getMobile(mVar.getContext());
                AccountProviderBody.AccountProvider accountProvider = mVar.m;
                if (accountProvider == null) {
                    k.a();
                }
                objArr[1] = accountProvider.getAccountProvider();
                String string = mVar.getString(i2, objArr);
                k.a((Object) string, "getString(R.string.upi_a…ccount!!.accountProvider)");
                CustomDialog.showAlert(mVar.getActivity(), "Error", string);
            } else {
                String alertMessage = upiCustomVolleyError.getAlertMessage();
                if (TextUtils.isEmpty(alertMessage)) {
                    alertMessage = mVar.getString(R.string.upi_some_went_wrong);
                }
                Context context = mVar.getContext();
                CJRSendGTMTag.sendNewCustomGTMEvents(context, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "bank_account_linked_failed_onboarding", upiCustomVolleyError.getAlertMessage() + upiCustomVolleyError.getmErrorCode(), "", "", "/bhim-upi/signup/multiplelinkaccount", "wallet");
                CustomDialog.showAlert(mVar.getActivity(), "Error", alertMessage);
            }
        } else {
            CustomDialog.showAlert(mVar.getActivity(), "Error", mVar.getString(R.string.upi_some_went_wrong));
            str = "";
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(mVar.getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_FAILURE, "", str, "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
    }

    public static final /* synthetic */ void a(m mVar, d.a aVar) {
        if (aVar.f68563b) {
            l lVar = mVar.n;
            if (lVar != null) {
                int i2 = aVar.f68562a;
                BankAccountDetails.BankAccount remove = lVar.f68949c.remove(i2);
                k.a((Object) remove, "adapterBankList.removeAt(position)");
                if (remove != null) {
                    lVar.notifyItemRemoved(i2);
                    return;
                }
                return;
            }
            return;
        }
        String str = aVar.f68564c;
        if (k.a((Object) "88", (Object) str) || k.a((Object) "80", (Object) str)) {
            Toast.makeText(mVar.getContext(), R.string.upi_delete_default_bank, 1).show();
        } else if (k.a((Object) "102", (Object) str)) {
            Toast.makeText(mVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
        } else if (k.a((Object) "INT-1199", (Object) str)) {
            Toast.makeText(mVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
        } else {
            Toast.makeText(mVar.getContext(), R.string.something_went_wrong, 1).show();
        }
    }

    public static final /* synthetic */ void b(m mVar, UpiCustomVolleyError upiCustomVolleyError) {
        String str = upiCustomVolleyError.getmErrorCode();
        k.a((Object) str, "error.getmErrorCode()");
        if (TextUtils.isEmpty(str) || !k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
            Toast.makeText(mVar.getContext(), R.string.upi_some_went_wrong, 1).show();
        } else {
            CustomDialog.showAlert(mVar.getContext(), mVar.getResources().getString(R.string.no_connection), mVar.getResources().getString(R.string.no_internet));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

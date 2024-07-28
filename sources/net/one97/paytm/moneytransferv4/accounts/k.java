package net.one97.paytm.moneytransferv4.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.w;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.a.a.a;
import net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity;
import net.one97.paytm.moneytransferv4.accounts.h;
import net.one97.paytm.moneytransferv4.accounts.i;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class k extends net.one97.paytm.moneytransferv4.b.a implements h.b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f54987b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f54988a;

    /* renamed from: c  reason: collision with root package name */
    private i f54989c;

    /* renamed from: e  reason: collision with root package name */
    private h f54990e;

    /* renamed from: f  reason: collision with root package name */
    private UPICheckBalanceHelper f54991f;

    /* renamed from: g  reason: collision with root package name */
    private final int f54992g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private final int f54993h = 1001;

    /* renamed from: i  reason: collision with root package name */
    private BankAccountDetails.BankAccount f54994i;
    private HashMap j;

    public final void c() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    static final class f<T> implements z<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f54999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f55000b;

        f(k kVar, m mVar) {
            this.f54999a = kVar;
            this.f55000b = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            int i2 = l.f55004a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                net.one97.paytm.moneytransfer.c.g gVar = this.f55000b.f53788d;
                kotlin.g.b.k.a((Object) gVar, "binding.selfShimmerLayout");
                ShimmerFrameLayout a2 = gVar.a();
                kotlin.g.b.k.a((Object) a2, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.b(a2);
                RecyclerView recyclerView = this.f55000b.f53786b;
                kotlin.g.b.k.a((Object) recyclerView, "binding.selfAccountList");
                net.one97.paytm.upi.f.b((View) recyclerView);
                List<? extends BankAccountDetails.BankAccount> list = (List) cVar.f54033b;
                if (list == null) {
                    list = new ArrayList<>();
                }
                h b2 = k.b(this.f54999a);
                kotlin.g.b.k.c(list, "newList");
                b2.f54943g = list;
                b2.notifyDataSetChanged();
                Button button = this.f55000b.f53787c;
                kotlin.g.b.k.a((Object) button, "binding.selfAccountProceed");
                button.setVisibility(0);
            } else if (i2 == 2) {
                this.f54999a.a(cVar.f54034c);
                RecyclerView recyclerView2 = this.f55000b.f53786b;
                kotlin.g.b.k.a((Object) recyclerView2, "binding.selfAccountList");
                net.one97.paytm.upi.f.b((View) recyclerView2);
                net.one97.paytm.moneytransfer.c.g gVar2 = this.f55000b.f53788d;
                kotlin.g.b.k.a((Object) gVar2, "binding.selfShimmerLayout");
                ShimmerFrameLayout a3 = gVar2.a();
                kotlin.g.b.k.a((Object) a3, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.b(a3);
            } else if (i2 == 3) {
                RecyclerView recyclerView3 = this.f55000b.f53786b;
                kotlin.g.b.k.a((Object) recyclerView3, "binding.selfAccountList");
                net.one97.paytm.upi.f.a((View) recyclerView3);
                net.one97.paytm.moneytransfer.c.g gVar3 = this.f55000b.f53788d;
                kotlin.g.b.k.a((Object) gVar3, "binding.selfShimmerLayout");
                ShimmerFrameLayout a4 = gVar3.a();
                kotlin.g.b.k.a((Object) a4, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.a(a4);
            }
        }
    }

    static final class g<T> implements z<i.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f55001a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f55002b;

        g(k kVar, m mVar) {
            this.f55001a = kVar;
            this.f55002b = mVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            i.a aVar = (i.a) obj;
            if (aVar instanceof i.a.C0994a) {
                k.b(this.f55001a).f54942f = true;
                Button button = this.f55002b.f53787c;
                kotlin.g.b.k.a((Object) button, "binding.selfAccountProceed");
                button.setText(this.f55001a.getResources().getString(R.string.mt_v4_self_account_button_text));
            } else if (aVar instanceof i.a.b) {
                k.b(this.f55001a).f54942f = false;
                Button button2 = this.f55002b.f53787c;
                kotlin.g.b.k.a((Object) button2, "binding.selfAccountProceed");
                button2.setText(this.f55001a.getResources().getString(R.string.proceed));
            } else if (aVar instanceof i.a.e) {
                a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                i.a.e eVar = (i.a.e) aVar;
                net.one97.paytm.moneytransfer.utils.m.a(R.id.container, (Fragment) a.C0982a.a(eVar.f54979c, this.f55001a.getActivity(), eVar.f54977a, eVar.f54978b), "BeneficiaryHistoryFragment", this.f55001a.getFragmentManager());
                net.one97.paytm.moneytransfer.utils.f.a(this.f55001a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_SELF_AC_CLICKED, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
            } else if (aVar instanceof i.a.d) {
                k.c(this.f55001a);
            } else if (aVar instanceof i.a.c) {
                this.f55001a.b();
            } else if (aVar instanceof i.a.f) {
                k.e(this.f55001a);
            }
        }
    }

    public static final /* synthetic */ i a(k kVar) {
        i iVar = kVar.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return iVar;
    }

    public static final /* synthetic */ h b(k kVar) {
        h hVar = kVar.f54990e;
        if (hVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        return hVar;
    }

    public static final /* synthetic */ BankAccountDetails.BankAccount f(k kVar) {
        BankAccountDetails.BankAccount bankAccount = kVar.f54994i;
        if (bankAccount == null) {
            kotlin.g.b.k.a("selectedBankAccount");
        }
        return bankAccount;
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_to_self_account, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        m a2 = m.a(view);
        kotlin.g.b.k.a((Object) a2, "FragmentToSelfAccountBinding.bind(view)");
        TextView textView = a2.f53790f;
        kotlin.g.b.k.a((Object) textView, "binding.subHeading");
        net.one97.paytm.upi.f.c((View) textView);
        TextView textView2 = a2.f53791g;
        kotlin.g.b.k.a((Object) textView2, "binding.title");
        textView2.setText(getString(R.string.mt_v4_self_account_title));
        ao aoVar = this;
        q qVar = this.f54988a;
        if (qVar == null) {
            kotlin.g.b.k.a("viewModelFactory");
        }
        ai a3 = new al(aoVar, (al.b) qVar).a(i.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProvider(this, …ntsViewModel::class.java]");
        this.f54989c = (i) a3;
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        iVar.c();
        i iVar2 = this.f54989c;
        if (iVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        iVar2.f54965b.observe(getViewLifecycleOwner(), new f(this, a2));
        i iVar3 = this.f54989c;
        if (iVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        iVar3.f54966c.observe(getViewLifecycleOwner(), new g(this, a2));
        RecyclerView recyclerView = a2.f53786b;
        kotlin.g.b.k.a((Object) recyclerView, "binding.selfAccountList");
        this.f54990e = new h(w.INSTANCE, this);
        h hVar = this.f54990e;
        if (hVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        recyclerView.setAdapter(hVar);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        a2.f53787c.setOnClickListener(new c(this));
        a2.f53789e.setOnClickListener(new d(this));
        a2.f53785a.setOnClickListener(new e(this));
        net.one97.paytm.moneytransfer.utils.f.a(view.getContext(), CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f54996a;

        c(k kVar) {
            this.f54996a = kVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransfer.model.c value;
            List list;
            i a2 = k.a(this.f54996a);
            String str = a2.f54970g;
            if (str.hashCode() != 0 || !str.equals("")) {
                String str2 = a2.f54970g;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                int b2 = a2.b(str2);
                BankAccountDetails.BankAccount bankAccount = null;
                if (!(b2 == -1 || (value = a2.f54964a.getValue()) == null || (list = (List) value.f54033b) == null)) {
                    bankAccount = (BankAccountDetails.BankAccount) list.get(b2);
                }
                if (bankAccount != null) {
                    y<i.a> yVar = a2.f54966c;
                    String a3 = a2.a();
                    PaymentManager paymentManager = PaymentManager.f54783a;
                    yVar.setValue(new i.a.e(bankAccount, a3, PaymentManager.a(bankAccount)));
                }
            } else if (a2.d()) {
                a2.f54966c.setValue(i.a.c.f54975a);
            } else {
                a2.f54966c.setValue(i.a.d.f54976a);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f54997a;

        d(k kVar) {
            this.f54997a = kVar;
        }

        public final void onClick(View view) {
            k.a(this.f54997a).f54966c.setValue(i.a.f.f54980a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f54998a;

        e(k kVar) {
            this.f54998a = kVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f54998a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            net.one97.paytm.moneytransfer.utils.f.a(this.f54998a.getContext(), "mt_p2p_new_v1", "back_button_clicked", CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        this.f54994i = bankAccount;
        if (this.f54991f == null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            this.f54991f = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, new b(this)).setDeviceBindingRequestCode(Integer.valueOf(this.f54992g)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank(bankAccount);
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        upiProfileDefaultBank.setVirtualAddress(iVar.a());
        UPICheckBalanceHelper uPICheckBalanceHelper = this.f54991f;
        if (uPICheckBalanceHelper == null) {
            kotlin.g.b.k.a();
        }
        uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
    }

    public static final class b implements n.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f54995a;

        b(k kVar) {
            this.f54995a = kVar;
        }

        public final void a(n.b bVar) {
            kotlin.g.b.k.c(bVar, "errorUPI");
            if (this.f54995a.isAdded()) {
                if (bVar == n.b.INCORRECT_MPIN) {
                    k.a(this.f54995a, false);
                } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
                    k.a(this.f54995a, true);
                } else {
                    UpiUtils.handleCheckBalanceError(this.f54995a.getActivity(), bVar);
                }
                net.one97.paytm.moneytransfer.utils.f.a(this.f54995a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, bVar.name(), "");
            }
        }

        public final void a(String str, String str2, String str3) {
            String str4;
            kotlin.g.b.k.c(str3, "accountType");
            if (this.f54995a.isAdded()) {
                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                    str4 = this.f54995a.getString(R.string.mt_balance_credit_limit_bold, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                    kotlin.g.b.k.a((Object) str4, "getString(R.string.mt_ba…String(availableBalance))");
                } else {
                    str4 = this.f54995a.getString(R.string.mt_available_balance_bold, UpiAppUtils.priceToString(str2));
                    kotlin.g.b.k.a((Object) str4, "getString(R.string.mt_av…String(availableBalance))");
                }
                h b2 = k.b(this.f54995a);
                kotlin.g.b.k.c(str4, "balance");
                b2.f54940d = str4;
                b2.notifyItemChanged(b2.f54939c, Integer.valueOf(b2.f54939c));
                net.one97.paytm.moneytransfer.utils.f.a(this.f54995a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
            }
        }

        public final void b() {
            k.b(this.f54995a).a(false);
        }

        public final void Z_() {
            k.b(this.f54995a).a(true);
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount, boolean z) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        List a2 = kotlin.a.k.a(bankAccount);
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, iVar.a()).setBankAccountList(a2).build();
        kotlin.g.b.k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
        intent.putExtra("user_upi_details", build);
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z);
        startActivityForResult(intent, 10);
        if (!z) {
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
        }
    }

    public static final class h implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f55003a;

        h(k kVar) {
            this.f55003a = kVar;
        }

        public final void onReEnterClicked() {
            k kVar = this.f55003a;
            kVar.a(k.f(kVar));
            net.one97.paytm.moneytransfer.utils.f.a(this.f55003a.getContext(), "mt_p2p_new_v1", "UPI_pin_reentered", CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
        }

        public final void onCreateNewPinClicked() {
            k kVar = this.f55003a;
            kVar.a(k.f(kVar), true);
            net.one97.paytm.moneytransfer.utils.f.a(this.f55003a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
        }
    }

    public final void a() {
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        iVar.a("");
    }

    /* access modifiers changed from: private */
    public final void b() {
        if (com.paytm.utility.a.m(getContext())) {
            AccountProviderActivity.a((Fragment) this, 31);
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, CJRGTMConstants.MT_V4_TRANSFER_TO_SELF_SCREEN_NAME, "", "");
            return;
        }
        net.one97.paytm.moneytransfer.utils.m.d((Activity) getActivity());
    }

    public final void a(BankAccountDetails.BankAccount bankAccount, ImageView imageView) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        kotlin.g.b.k.c(imageView, "bankImageView");
        AccountSettingsActivity.a aVar = AccountSettingsActivity.f54861b;
        Fragment fragment = this;
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String a2 = iVar.a();
        kotlin.g.b.k.c(fragment, "fragment");
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        kotlin.g.b.k.c(a2, "primaryVpa");
        kotlin.g.b.k.c(imageView, "bankImageView");
        Intent intent = new Intent(fragment.getContext(), AccountSettingsActivity.class);
        intent.putExtra("bank_account", bankAccount);
        intent.putExtra("primary_vpa", a2);
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        androidx.core.app.b a3 = androidx.core.app.b.a(activity, imageView, "bankImage");
        kotlin.g.b.k.a((Object) a3, "ActivityOptionsCompat.ma…nkImageView, \"bankImage\")");
        fragment.startActivityForResult(intent, 7231, a3.a());
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "refId");
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        iVar.a(str);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f54993h && i3 == -1) {
            b();
        } else if (i2 == 31 && i3 == -1) {
            Object obj = null;
            Object serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
            if (serializableExtra instanceof AccountProviderBody.AccountProvider) {
                obj = serializableExtra;
            }
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) obj;
            if (accountProvider != null) {
                Fragment fragment = this;
                i iVar = this.f54989c;
                if (iVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                BankVpaCreationActivity.a(fragment, accountProvider, iVar.a(), 34);
            }
        } else if (i2 == 34 && i3 == -1) {
            i iVar2 = this.f54989c;
            if (iVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            iVar2.c();
        } else if (i2 == 7231 && i3 == -1) {
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializableExtra2 = intent.getSerializableExtra("bank_account");
            if (serializableExtra2 != null) {
                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) serializableExtra2;
                h hVar = this.f54990e;
                if (hVar == null) {
                    kotlin.g.b.k.a("adapter");
                }
                kotlin.g.b.k.c(bankAccount, "bankAccount");
                hVar.f54941e.remove(bankAccount.getAccRefId());
                Collection arrayList = new ArrayList();
                for (Object next : hVar.f54943g) {
                    if (!kotlin.g.b.k.a((Object) ((BankAccountDetails.BankAccount) next).getAccRefId(), (Object) bankAccount.getAccRefId())) {
                        arrayList.add(next);
                    }
                }
                hVar.f54943g = (List) arrayList;
                hVar.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount");
        } else if (i2 == 10 && i3 == -1) {
            i iVar3 = this.f54989c;
            if (iVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            iVar3.c();
        } else if (i2 == 113 && i3 == -1 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public final void onResume() {
        super.onResume();
        i iVar = this.f54989c;
        if (iVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (iVar.f54971h) {
            iVar.c();
        } else {
            iVar.f54971h = true;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void c(k kVar) {
        Intent intent = new Intent(kVar.getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        kVar.startActivityForResult(intent, kVar.f54993h);
    }

    public static final /* synthetic */ void e(k kVar) {
        Intent intent = new Intent(kVar.getContext(), UPISettingsActivity.class);
        intent.setFlags(67108864);
        kVar.startActivityForResult(intent, 113);
    }

    public static final /* synthetic */ void a(k kVar, boolean z) {
        if (kVar.isAdded()) {
            j childFragmentManager = kVar.getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new h(kVar), childFragmentManager, z);
        }
    }
}

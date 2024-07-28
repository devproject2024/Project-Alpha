package net.one97.paytm.moneytransferv4.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.i;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.LockableBottomSheetBehavior;
import net.one97.paytm.moneytransferv4.accounts.a;
import net.one97.paytm.moneytransferv4.accounts.f;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.passbook.view.d;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends net.one97.paytm.moneytransferv4.b.a implements a.b, f.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f54902b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f54903a;

    /* renamed from: c  reason: collision with root package name */
    private i f54904c;

    /* renamed from: e  reason: collision with root package name */
    private a f54905e;

    /* renamed from: f  reason: collision with root package name */
    private UPICheckBalanceHelper f54906f;

    /* renamed from: g  reason: collision with root package name */
    private final int f54907g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private final int f54908h = 1001;

    /* renamed from: i  reason: collision with root package name */
    private BankAccountDetails.BankAccount f54909i;
    private i j;
    private HashMap k;

    public final void c() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class g<T> implements z<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54916a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f54917b;

        g(b bVar, i iVar) {
            this.f54916a = bVar;
            this.f54917b = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            int i2 = c.f54919a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                net.one97.paytm.moneytransfer.c.h hVar = this.f54917b.f53761i;
                k.a((Object) hVar, "binding.selfShimmerLayout");
                ShimmerFrameLayout a2 = hVar.a();
                k.a((Object) a2, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.b(a2);
                RecyclerView recyclerView = this.f54917b.f53760h;
                k.a((Object) recyclerView, "binding.selfAccountList");
                net.one97.paytm.upi.f.b((View) recyclerView);
                List<? extends BankAccountDetails.BankAccount> list = (List) cVar.f54033b;
                if (list == null) {
                    list = new ArrayList<>();
                }
                a a3 = b.a(this.f54916a);
                k.c(list, "newList");
                a3.f54885h = list;
                a3.notifyDataSetChanged();
            } else if (i2 == 2) {
                this.f54916a.a(cVar.f54034c);
                RecyclerView recyclerView2 = this.f54917b.f53760h;
                k.a((Object) recyclerView2, "binding.selfAccountList");
                net.one97.paytm.upi.f.b((View) recyclerView2);
                net.one97.paytm.moneytransfer.c.h hVar2 = this.f54917b.f53761i;
                k.a((Object) hVar2, "binding.selfShimmerLayout");
                ShimmerFrameLayout a4 = hVar2.a();
                k.a((Object) a4, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.b(a4);
            } else if (i2 == 3) {
                RecyclerView recyclerView3 = this.f54917b.f53760h;
                k.a((Object) recyclerView3, "binding.selfAccountList");
                net.one97.paytm.upi.f.a((View) recyclerView3);
                net.one97.paytm.moneytransfer.c.h hVar3 = this.f54917b.f53761i;
                k.a((Object) hVar3, "binding.selfShimmerLayout");
                ShimmerFrameLayout a5 = hVar3.a();
                k.a((Object) a5, "binding.selfShimmerLayout.root");
                net.one97.paytm.upi.f.a(a5);
            }
        }
    }

    public static final /* synthetic */ a a(b bVar) {
        a aVar = bVar.f54905e;
        if (aVar == null) {
            k.a("adapter");
        }
        return aVar;
    }

    public static final /* synthetic */ BankAccountDetails.BankAccount e(b bVar) {
        BankAccountDetails.BankAccount bankAccount = bVar.f54909i;
        if (bankAccount == null) {
            k.a("selectedBankAccount");
        }
        return bankAccount;
    }

    /* access modifiers changed from: private */
    public final i d() {
        i iVar = this.j;
        if (iVar == null) {
            k.a();
        }
        return iVar;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_acc_bal_and_history, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.j = i.a(view);
        i d2 = d();
        ao aoVar = this;
        q qVar = this.f54903a;
        if (qVar == null) {
            k.a("viewModelFactory");
        }
        ai a2 = new al(aoVar, (al.b) qVar).a(i.class);
        k.a((Object) a2, "ViewModelProvider(this, …ntsViewModel::class.java]");
        this.f54904c = (i) a2;
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        iVar.c();
        i iVar2 = this.f54904c;
        if (iVar2 == null) {
            k.a("viewModel");
        }
        iVar2.f54965b.observe(getViewLifecycleOwner(), new g(this, d2));
        RecyclerView recyclerView = d().f53760h;
        k.a((Object) recyclerView, "binding.selfAccountList");
        this.f54905e = new a(w.INSTANCE, this);
        a aVar = this.f54905e;
        if (aVar == null) {
            k.a("adapter");
        }
        recyclerView.setAdapter(aVar);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        d().f53754b.setOnClickListener(new d(this));
        d().f53756d.setOnClickListener(new e(this));
        BottomSheetBehavior from = BottomSheetBehavior.from(d().j);
        if (from != null) {
            LockableBottomSheetBehavior lockableBottomSheetBehavior = (LockableBottomSheetBehavior) from;
            lockableBottomSheetBehavior.f54778a = false;
            lockableBottomSheetBehavior.setHideable(true);
            lockableBottomSheetBehavior.setState(5);
            lockableBottomSheetBehavior.setBottomSheetCallback(new f(this));
            net.one97.paytm.upi.passbook.view.d dVar = new net.one97.paytm.upi.passbook.view.d();
            dVar.a((d.a) new C0990b(this));
            Bundle bundle2 = new Bundle();
            bundle2.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
            dVar.setArguments(bundle2);
            getChildFragmentManager().a().a(R.id.passbookContainer, dVar, b.class.getName()).c();
            net.one97.paytm.moneytransfer.utils.f.a(view.getContext(), CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.LockableBottomSheetBehavior<androidx.cardview.widget.CardView!>");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54912a;

        d(b bVar) {
            this.f54912a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f54912a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            net.one97.paytm.moneytransfer.utils.f.a(this.f54912a.getContext(), "mt_p2p_new_v1", "back_button_clicked", CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54913a;

        e(b bVar) {
            this.f54913a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f54913a).b(!b.a(this.f54913a).f54882e);
            if (b.a(this.f54913a).f54882e) {
                TextView textView = this.f54913a.d().f53756d;
                k.a((Object) textView, "binding.editTextView");
                textView.setText(this.f54913a.getString(R.string.done));
                LinearLayout linearLayout = this.f54913a.d().f53758f;
                k.a((Object) linearLayout, "binding.passbookLayout");
                net.one97.paytm.upi.f.a((View) linearLayout, false);
                LinearLayout linearLayout2 = this.f54913a.d().f53759g;
                k.a((Object) linearLayout2, "binding.searchLayout");
                net.one97.paytm.upi.f.a((View) linearLayout2, false);
                this.f54913a.a(false);
                net.one97.paytm.moneytransfer.utils.f.a(this.f54913a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_EDIT_CLICKED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
                return;
            }
            this.f54913a.f();
            TextView textView2 = this.f54913a.d().f53756d;
            k.a((Object) textView2, "binding.editTextView");
            textView2.setText(this.f54913a.getString(R.string.mt_edit));
            net.one97.paytm.moneytransfer.utils.f.a(this.f54913a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_DONE_CLICKED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
        }
    }

    public static final class f extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54914a;

        public final void onSlide(View view, float f2) {
            k.c(view, "p0");
        }

        f(b bVar) {
            this.f54914a = bVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "p0");
            if (i2 == 5) {
                TextView textView = this.f54914a.d().f53756d;
                k.a((Object) textView, "binding.editTextView");
                textView.setText(this.f54914a.getString(R.string.mt_edit));
                this.f54914a.d().f53760h.setPadding(0, (int) this.f54914a.getResources().getDimension(R.dimen.dimen_16dp), 0, (int) this.f54914a.getResources().getDimension(R.dimen.dimen_40dp));
            } else if (i2 == 3) {
                this.f54914a.d().j.post(new a(this));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f54915a;

            a(f fVar) {
                this.f54915a = fVar;
            }

            public final void run() {
                CardView cardView = this.f54915a.f54914a.d().j;
                k.a((Object) cardView, "binding.settingsBottomSheet");
                this.f54915a.f54914a.d().f53760h.setPadding(0, (int) this.f54915a.f54914a.getResources().getDimension(R.dimen.dimen_16dp), 0, cardView.getHeight() + ((int) this.f54915a.f54914a.getResources().getDimension(R.dimen.dimen_40dp)));
            }
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        String str;
        k.c(bankAccount, "bankAccount");
        this.f54909i = bankAccount;
        if (this.f54906f == null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.f54906f = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, new c(this)).setDeviceBindingRequestCode(Integer.valueOf(this.f54907g)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank(bankAccount);
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        upiProfileDefaultBank.setVirtualAddress(iVar.a());
        UPICheckBalanceHelper uPICheckBalanceHelper = this.f54906f;
        if (uPICheckBalanceHelper == null) {
            k.a();
        }
        uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
        BankAccountDetails.BankAccount bankAccount2 = this.f54909i;
        if (bankAccount2 == null) {
            k.a("selectedBankAccount");
        }
        if (bankAccount2.getBankName() != null) {
            BankAccountDetails.BankAccount bankAccount3 = this.f54909i;
            if (bankAccount3 == null) {
                k.a("selectedBankAccount");
            }
            str = bankAccount3.getBankName();
        } else {
            str = "";
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, str, "");
    }

    public static final class c implements n.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54911a;

        c(b bVar) {
            this.f54911a = bVar;
        }

        public final void a(n.b bVar) {
            k.c(bVar, "errorUPI");
            if (this.f54911a.isAdded()) {
                if (bVar == n.b.INCORRECT_MPIN) {
                    b.a(this.f54911a, false);
                } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
                    b.a(this.f54911a, true);
                } else {
                    UpiUtils.handleCheckBalanceError(this.f54911a.getActivity(), bVar);
                }
                net.one97.paytm.moneytransfer.utils.f.a(this.f54911a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, bVar.name(), "");
            }
        }

        public final void a(String str, String str2, String str3) {
            String str4;
            k.c(str3, "accountType");
            if (this.f54911a.isAdded()) {
                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                    str4 = this.f54911a.getString(R.string.mt_balance_credit_limit_bold, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                    k.a((Object) str4, "getString(R.string.mt_ba…String(availableBalance))");
                } else {
                    str4 = this.f54911a.getString(R.string.mt_available_balance_bold, UpiAppUtils.priceToString(str2));
                    k.a((Object) str4, "getString(R.string.mt_av…String(availableBalance))");
                }
                a a2 = b.a(this.f54911a);
                k.c(str4, "balance");
                a2.f54880c = str4;
                a2.notifyItemChanged(a2.f54879b, Integer.valueOf(a2.f54879b));
                net.one97.paytm.moneytransfer.utils.f.a(this.f54911a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
            }
        }

        public final void b() {
            if (this.f54911a.isAdded()) {
                b.a(this.f54911a).a(false);
            }
        }

        public final void Z_() {
            if (this.f54911a.isAdded()) {
                b.a(this.f54911a).a(true);
            }
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount, boolean z) {
        k.c(bankAccount, "bankAccount");
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        List a2 = kotlin.a.k.a(bankAccount);
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, iVar.a()).setBankAccountList(a2).build();
        k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
        intent.putExtra("user_upi_details", build);
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z);
        startActivityForResult(intent, 10);
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
    }

    public static final class h implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54918a;

        h(b bVar) {
            this.f54918a = bVar;
        }

        public final void onReEnterClicked() {
            b bVar = this.f54918a;
            bVar.a(b.e(bVar));
            net.one97.paytm.moneytransfer.utils.f.a(this.f54918a.getContext(), "mt_p2p_new_v1", "UPI_pin_reentered", CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
        }

        public final void onCreateNewPinClicked() {
            b bVar = this.f54918a;
            bVar.a(b.e(bVar), true);
            net.one97.paytm.moneytransfer.utils.f.a(this.f54918a.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
        }
    }

    public final void a() {
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        if (iVar.d()) {
            e();
        } else {
            Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            startActivityForResult(intent, this.f54908h);
        }
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
    }

    private final void e() {
        if (com.paytm.utility.a.m(getContext())) {
            AccountProviderActivity.a((Fragment) this, 31);
            net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, "", "");
            return;
        }
        m.d((Activity) getActivity());
    }

    public final void b(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        ArrayList arrayList = new ArrayList();
        arrayList.add(bankAccount);
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, iVar.a()).setBankAccountList(arrayList).build();
        f.b bVar = f.f54924c;
        k.a((Object) build, "userUpiDetails");
        f.a aVar = this;
        k.c(build, "userUpiDetails");
        k.c(aVar, "listener");
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, build);
        fVar.setArguments(bundle);
        k.c(aVar, "listener");
        fVar.f54926b = aVar;
        getChildFragmentManager().a().b(R.id.settingsContainer, fVar).d();
        BottomSheetBehavior from = BottomSheetBehavior.from(d().j);
        k.a((Object) from, "BottomSheetBehavior.from…ding.settingsBottomSheet)");
        from.setState(3);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f54908h && i3 == -1) {
            e();
        } else if (i2 == 31 && i3 == -1) {
            Object obj = null;
            Object serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
            if (serializableExtra instanceof AccountProviderBody.AccountProvider) {
                obj = serializableExtra;
            }
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) obj;
            if (accountProvider != null) {
                Fragment fragment = this;
                i iVar = this.f54904c;
                if (iVar == null) {
                    k.a("viewModel");
                }
                BankVpaCreationActivity.a(fragment, accountProvider, iVar.a(), 34);
            }
        } else if (i2 == 34 && i3 == -1) {
            i iVar2 = this.f54904c;
            if (iVar2 == null) {
                k.a("viewModel");
            }
            iVar2.c();
        } else if (i2 == 10 && i3 == -1) {
            i iVar3 = this.f54904c;
            if (iVar3 == null) {
                k.a("viewModel");
            }
            iVar3.c();
        }
    }

    public final void c(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        a aVar = this.f54905e;
        if (aVar == null) {
            k.a("adapter");
        }
        k.c(bankAccount, "bankAccount");
        ((BankAccountDetails.BankAccount) aVar.f54885h.get(aVar.f54884g)).setPrimaryAccount(Boolean.FALSE);
        Iterator<? extends BankAccountDetails.BankAccount> it2 = aVar.f54885h.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (k.a((Object) bankAccount.getAccRefId(), (Object) ((BankAccountDetails.BankAccount) it2.next()).getAccRefId())) {
                break;
            } else {
                i2++;
            }
        }
        ((BankAccountDetails.BankAccount) aVar.f54885h.get(i2)).setPrimaryAccount(Boolean.TRUE);
        aVar.f54884g = i2;
        aVar.b(false);
        f();
        a(CJRGTMConstants.MT_V4_PRIMARY_ACCOUNT_CHANGED);
    }

    public final void d(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        a aVar = this.f54905e;
        if (aVar == null) {
            k.a("adapter");
        }
        aVar.b(false);
        i iVar = this.f54904c;
        if (iVar == null) {
            k.a("viewModel");
        }
        iVar.c();
        f();
        a("remove a/c");
    }

    public final void b() {
        d().f53756d.callOnClick();
        a("create new upi pin");
    }

    private final void a(String str) {
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_EDIT_ITEM_CLICKED, CJRGTMConstants.MT_V4_ACCOUNT_BALANCE_HISTORY_SCREEN_NAME, str, "");
    }

    /* access modifiers changed from: private */
    public final void f() {
        a(true);
        LinearLayout linearLayout = d().f53758f;
        k.a((Object) linearLayout, "binding.passbookLayout");
        net.one97.paytm.upi.f.a((View) linearLayout, true);
        LinearLayout linearLayout2 = d().f53759g;
        k.a((Object) linearLayout2, "binding.searchLayout");
        net.one97.paytm.upi.f.a((View) linearLayout2, true);
        BottomSheetBehavior from = BottomSheetBehavior.from(d().j);
        k.a((Object) from, "BottomSheetBehavior.from…ding.settingsBottomSheet)");
        from.setState(5);
    }

    public final void onDestroyView() {
        this.j = null;
        super.onDestroyView();
        c();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accounts.b$b  reason: collision with other inner class name */
    static final class C0990b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54910a;

        C0990b(b bVar) {
            this.f54910a = bVar;
        }

        public final void a() {
            this.f54910a.a(false);
            Fragment c2 = this.f54910a.getChildFragmentManager().c(R.id.passbookContainer);
            if (c2 != null) {
                this.f54910a.getChildFragmentManager().a().a(c2).c();
            }
            LinearLayout linearLayout = this.f54910a.d().f53758f;
            k.a((Object) linearLayout, "binding.passbookLayout");
            net.one97.paytm.upi.f.a((View) linearLayout, false);
            LinearLayout linearLayout2 = this.f54910a.d().f53759g;
            k.a((Object) linearLayout2, "binding.searchLayout");
            net.one97.paytm.upi.f.a((View) linearLayout2, false);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        CollapsingToolbarLayout collapsingToolbarLayout = d().f53755c;
        k.a((Object) collapsingToolbarLayout, "(binding.collapsingToolbar)");
        ViewGroup.LayoutParams layoutParams = collapsingToolbarLayout.getLayoutParams();
        if (!(layoutParams instanceof AppBarLayout.LayoutParams)) {
            layoutParams = null;
        }
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        AppBarLayout appBarLayout = d().f53753a;
        k.a((Object) appBarLayout, "binding.appBar");
        appBarLayout.getLayoutParams();
        if (z) {
            if (layoutParams2 != null) {
                layoutParams2.a(1);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.a(0);
        }
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.isAdded()) {
            j childFragmentManager = bVar.getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new h(bVar), childFragmentManager, z);
        }
    }
}

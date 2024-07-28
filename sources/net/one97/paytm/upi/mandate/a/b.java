package net.one97.paytm.upi.mandate.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.e.ab;
import net.one97.paytm.upi.mandate.a.d;
import net.one97.paytm.upi.mandate.utils.m;
import net.one97.paytm.upi.mandate.utils.o;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class b extends f implements View.OnClickListener, n.c, d.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f67019c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final int f67020a = 1221;

    /* renamed from: b  reason: collision with root package name */
    UpiProfileDefaultBank f67021b;

    /* renamed from: d  reason: collision with root package name */
    private final int f67022d;

    /* renamed from: e  reason: collision with root package name */
    private final int f67023e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f67024f = 2;

    /* renamed from: g  reason: collision with root package name */
    private final int f67025g = 3;

    /* renamed from: h  reason: collision with root package name */
    private final int f67026h = 4;

    /* renamed from: i  reason: collision with root package name */
    private final int f67027i = 1222;
    private net.one97.paytm.upi.mandate.confirmation.c j;
    private d k;
    private UPICheckBalanceHelper l;
    private C1350b m;
    private HashMap n;

    /* renamed from: net.one97.paytm.upi.mandate.a.b$b  reason: collision with other inner class name */
    public interface C1350b {
        void a(UpiProfileDefaultBank upiProfileDefaultBank);
    }

    static final class d<T> implements z<net.one97.paytm.upi.mandate.data.a<List<? extends UpiProfileDefaultBank>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ab f67030b;

        d(b bVar, ab abVar) {
            this.f67029a = bVar;
            this.f67030b = abVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.mandate.data.a aVar = (net.one97.paytm.upi.mandate.data.a) obj;
            boolean z = true;
            if (c.f67032a[aVar.f67117a.ordinal()] == 1) {
                b.a(this.f67029a).a((List<UpiProfileDefaultBank>) (List) aVar.f67118b);
                Collection collection = (Collection) aVar.f67118b;
                if (collection != null && !collection.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    b.a(this.f67029a, this.f67030b);
                }
            }
        }
    }

    public static final /* synthetic */ d a(b bVar) {
        d dVar = bVar.k;
        if (dVar == null) {
            k.a("vpaListAdapter");
        }
        return dVar;
    }

    public static final /* synthetic */ UpiProfileDefaultBank b(b bVar) {
        UpiProfileDefaultBank upiProfileDefaultBank = bVar.f67021b;
        if (upiProfileDefaultBank == null) {
            k.a("selectedBankAccount");
        }
        return upiProfileDefaultBank;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof C1350b) {
            this.m = (C1350b) context;
        }
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
        final /* synthetic */ b f67028a;

        c(b bVar) {
            this.f67028a = bVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f67028a.getResources().getColor(R.color.transparent));
                    from.setState(3);
                    from.setHideable(true);
                    from.setSkipCollapsed(true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.recurring_accounts_bottomsheet_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ab a2 = ab.a(view);
        k.a((Object) a2, "RecurringAccountsBottoms…ragmentBinding.bind(view)");
        String string = requireArguments().getString("TYPE");
        if (string == null) {
            k.a();
        }
        this.k = new d(string);
        d dVar = this.k;
        if (dVar == null) {
            k.a("vpaListAdapter");
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        String string2 = arguments.getString("Account");
        if (string2 == null) {
            k.a();
        }
        dVar.b(string2);
        RecyclerView recyclerView = a2.f66729b;
        k.a((Object) recyclerView, "accountsRecyclerView");
        d dVar2 = this.k;
        if (dVar2 == null) {
            k.a("vpaListAdapter");
        }
        recyclerView.setAdapter(dVar2);
        d dVar3 = this.k;
        if (dVar3 == null) {
            k.a("vpaListAdapter");
        }
        dVar3.a((d.a) this);
        a2.f66731d.setOnClickListener(this);
        a2.f66732e.f66794c.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.upi_ic_security_shield, 0, 0, 0);
        ai a3 = am.a((Fragment) this, (al.b) new o()).a(net.one97.paytm.upi.mandate.confirmation.c.class);
        k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.j = (net.one97.paytm.upi.mandate.confirmation.c) a3;
        net.one97.paytm.upi.mandate.confirmation.c cVar = this.j;
        if (cVar == null) {
            k.a("viewModel");
        }
        cVar.a((m) null, (String) null);
        net.one97.paytm.upi.mandate.confirmation.c cVar2 = this.j;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        cVar2.f67096a.observe(getViewLifecycleOwner(), new d(this, a2));
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.addBankAccount;
        if (valueOf != null && valueOf.intValue() == i2) {
            PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context!!.applicationContext");
            if (companion.getPref(applicationContext).b("is_upi_user", false, true)) {
                PaytmUpiPrefUtil.Companion companion2 = PaytmUpiPrefUtil.Companion;
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "context!!");
                Context applicationContext2 = context2.getApplicationContext();
                k.a((Object) applicationContext2, "context!!.applicationContext");
                if (!companion2.getPref(applicationContext2).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true)) {
                    int i3 = this.f67022d;
                    Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
                    intent.putExtra("redirect", 80);
                    intent.setFlags(536870912);
                    startActivityForResult(intent, i3);
                } else if (com.paytm.utility.a.m(getContext())) {
                    AccountProviderActivity.a((Fragment) this, this.f67027i);
                } else {
                    UpiUtils.showNoNetworkErrorDialog(getActivity());
                }
            } else if (!UpiUtils.isInActiveProfileExist(getContext())) {
                Intent intent2 = new Intent(getActivity(), UpiSelectBankActivity.class);
                intent2.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                intent2.setFlags(536870912);
                startActivityForResult(intent2, 352);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            Serializable serializable = null;
            if (i2 == this.f67027i) {
                if (intent != null) {
                    serializable = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                }
                if (serializable != null) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializable;
                    Fragment fragment = this;
                    net.one97.paytm.upi.mandate.confirmation.c cVar = this.j;
                    if (cVar == null) {
                        k.a("viewModel");
                    }
                    BankVpaCreationActivity.a(fragment, accountProvider, cVar.a().getVirtualAddress(), this.f67026h);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            } else if (i2 == this.f67026h || i2 == this.f67025g || i2 == this.f67020a) {
                net.one97.paytm.upi.mandate.confirmation.c cVar2 = this.j;
                if (cVar2 == null) {
                    k.a("viewModel");
                }
                cVar2.a((m) null, (String) null);
            }
        } else if (i2 == this.f67023e) {
            Toast.makeText(getActivity(), R.string.upi_check_balance_error, 1).show();
        }
    }

    /* access modifiers changed from: private */
    public final void d(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (this.l == null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.l = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(Integer.valueOf(this.f67024f)).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
        }
        UPICheckBalanceHelper uPICheckBalanceHelper = this.l;
        if (uPICheckBalanceHelper == null) {
            k.a();
        }
        uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
    }

    public final void Z_() {
        d dVar = this.k;
        if (dVar == null) {
            k.a("vpaListAdapter");
        }
        dVar.a();
    }

    public final void b() {
        d dVar = this.k;
        if (dVar == null) {
            k.a("vpaListAdapter");
        }
        dVar.b();
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        k.c(str3, "accountType");
        if (isResumed()) {
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(\n             …alance)\n                )");
            } else {
                str4 = getString(R.string.upi_new_balance, UpiAppUtils.priceToString(str2));
                k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
            }
            d dVar = this.k;
            if (dVar == null) {
                k.a("vpaListAdapter");
            }
            if (dVar != null) {
                dVar.a(str4);
            }
        }
    }

    public final void a(n.b bVar) {
        k.c(bVar, "errorUPI");
        if (!isResumed()) {
            return;
        }
        if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    private final void a(boolean z) {
        if (isAdded()) {
            j childFragmentManager = getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new e(this), childFragmentManager, z);
        }
    }

    public static final class e implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67031a;

        e(b bVar) {
            this.f67031a = bVar;
        }

        public final void onReEnterClicked() {
            b bVar = this.f67031a;
            bVar.d(b.b(bVar));
        }

        public final void onCreateNewPinClicked() {
            b bVar = this.f67031a;
            BankAccountDetails.BankAccount debitBank = b.b(bVar).getDebitBank();
            k.a((Object) debitBank, "selectedBankAccount.debitBank");
            k.c(debitBank, "bankAccount");
            Intent intent = new Intent(bVar.getActivity(), SetMPINActivity.class);
            List a2 = kotlin.a.k.a(debitBank);
            UpiProfileDefaultBank upiProfileDefaultBank = bVar.f67021b;
            if (upiProfileDefaultBank == null) {
                k.a("selectedBankAccount");
            }
            UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(a2).build();
            k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
            intent.putExtra("user_upi_details", build);
            intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
            bVar.startActivityForResult(intent, bVar.f67020a);
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        C1350b bVar = this.m;
        if (bVar != null) {
            bVar.a(upiProfileDefaultBank);
        }
        if (isResumed()) {
            dismiss();
        }
    }

    public final void b(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, "upiProfileDefaultBank");
        this.f67021b = upiProfileDefaultBank;
        if (!isResumed()) {
            return;
        }
        if (com.paytm.utility.a.m(getContext())) {
            UpiProfileDefaultBank.PAYMENT_MODE paymentMode = upiProfileDefaultBank.getPaymentMode();
            if (paymentMode != null) {
                int i2 = c.f67033b[paymentMode.ordinal()];
                if (i2 == 1) {
                    d(upiProfileDefaultBank);
                } else if (i2 == 2) {
                    d(upiProfileDefaultBank);
                }
            }
        } else {
            UpiUtils.showNoNetworkErrorDialog(getActivity());
        }
    }

    public final void c(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (!isResumed()) {
            return;
        }
        if (com.paytm.utility.a.m(getContext())) {
            int i2 = this.f67025g;
            Intent intent = new Intent(getActivity(), SetMPINActivity.class);
            ArrayList arrayList = new ArrayList();
            if (upiProfileDefaultBank == null) {
                k.a();
            }
            arrayList.add(upiProfileDefaultBank.getDebitBank());
            intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
            intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, false);
            startActivityForResult(intent, i2);
            return;
        }
        UpiUtils.showNoNetworkErrorDialog(getActivity());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(String str, String str2) {
            k.c(str, "account");
            k.c(str2, "type");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putString("Account", str);
            bundle.putString("TYPE", str2);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, ab abVar) {
        TextView textView = abVar.j;
        k.a((Object) textView, "name");
        net.one97.paytm.upi.mandate.confirmation.c cVar = bVar.j;
        if (cVar == null) {
            k.a("viewModel");
        }
        BankAccountDetails.BankAccount debitBank = cVar.a().getDebitBank();
        k.a((Object) debitBank, "viewModel.primaryBank.debitBank");
        textView.setText(net.one97.paytm.upi.f.a(debitBank.getCustomerName()));
        TextView textView2 = abVar.m;
        k.a((Object) textView2, "upiId");
        net.one97.paytm.upi.mandate.confirmation.c cVar2 = bVar.j;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        textView2.setText(cVar2.a().getVirtualAddress());
        TextView textView3 = abVar.f66733f;
        k.a((Object) textView3, "contactInitials");
        net.one97.paytm.upi.mandate.confirmation.c cVar3 = bVar.j;
        if (cVar3 == null) {
            k.a("viewModel");
        }
        BankAccountDetails.BankAccount debitBank2 = cVar3.a().getDebitBank();
        k.a((Object) debitBank2, "viewModel.primaryBank.debitBank");
        textView3.setText(UpiUtils.getNameInitials(net.one97.paytm.upi.f.a(debitBank2.getCustomerName())));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

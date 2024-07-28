package net.one97.paytm.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.w;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.InstrumentMeta;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.contacts.entities.beans.VPADetails;
import net.one97.paytm.contacts.sync.ContactSyncLifeObserver;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.m.c;
import net.one97.paytm.m.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.n;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.a.a.a;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.moneytransferv4.invite.d;
import net.one97.paytm.moneytransferv4.search.SearchTitleModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UserActionEvent;
import net.one97.paytm.utils.ae;

public final class d extends net.one97.paytm.upi.b.b implements c.e, PaymentManager.a, net.one97.paytm.moneytransferv4.b.a.a.d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f53161b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f53162a;

    /* renamed from: e  reason: collision with root package name */
    private f f53163e;

    /* renamed from: f  reason: collision with root package name */
    private c f53164f;

    /* renamed from: g  reason: collision with root package name */
    private final int f53165g = 1007;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.moneytransferv4.b.a.a.a.d.b f53166h;

    /* renamed from: i  reason: collision with root package name */
    private final z<UserActionEvent.Action> f53167i = new c(this);
    private HashMap j;

    public final void a(InstrumentMeta instrumentMeta) {
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
    }

    public final void k() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        k();
    }

    static final class b<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53168a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f53169b;

        b(d dVar, Activity activity) {
            this.f53168a = dVar;
            this.f53169b = activity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                if (fVar.f55797b != null && (fVar.f55797b instanceof PaymentCombinationAPIResponse)) {
                    IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                    if (iJRPaytmDataModel != null) {
                        PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRPaytmDataModel;
                        if (paymentCombinationAPIResponse.getCategory() != null && p.a(paymentCombinationAPIResponse.getCategory(), "P2P", true)) {
                            PaymentManager paymentManager = PaymentManager.f54783a;
                            PaymentManager.a(paymentCombinationAPIResponse, (PaymentManager.a) this.f53168a);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse");
                }
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR && fVar.f55798c != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", true);
                ae aeVar = ae.f69602a;
                net.one97.paytm.network.g gVar = fVar.f55798c;
                if (gVar == null) {
                    kotlin.g.b.k.a();
                }
                if (ae.a(gVar.f55799a)) {
                    ae aeVar2 = ae.f69602a;
                    Activity activity = this.f53169b;
                    net.one97.paytm.network.g gVar2 = fVar.f55798c;
                    if (gVar2 == null) {
                        kotlin.g.b.k.a();
                    }
                    ae.a(activity, gVar2.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                }
            }
        }
    }

    static final class c<T> implements z<UserActionEvent.Action> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53170a;

        c(d dVar) {
            this.f53170a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            UserActionEvent.Action action = (UserActionEvent.Action) obj;
            if ((action != null ? action.getData() : null) != null) {
                String type = action.getType();
                if (kotlin.g.b.k.a((Object) type, (Object) UserActionEvent.ActionType.DECLINE.name())) {
                    d.f(this.f53170a).a(action.getData());
                } else if (kotlin.g.b.k.a((Object) type, (Object) UserActionEvent.ActionType.SPAM.name())) {
                    d.f(this.f53170a).a(action.getData());
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.moneytransfer.model.c<List<? extends Object>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53175a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f53176b;

        h(d dVar, n nVar) {
            this.f53175a = dVar;
            this.f53176b = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            d dVar = this.f53175a;
            n nVar = this.f53176b;
            kotlin.g.b.k.a((Object) cVar, Payload.RESPONSE);
            d.a(dVar, nVar, cVar);
        }
    }

    static final class i<T> implements z<net.one97.paytm.moneytransfer.model.c<List<? extends Object>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53177a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f53178b;

        i(d dVar, n nVar) {
            this.f53177a = dVar;
            this.f53178b = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            d dVar = this.f53177a;
            n nVar = this.f53178b;
            kotlin.g.b.k.a((Object) cVar, "it");
            d.a(dVar, nVar, cVar);
        }
    }

    static final class j<T> implements z<ArrayList<UpiPendingRequestModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53179a;

        j(d dVar) {
            this.f53179a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            d dVar = this.f53179a;
            kotlin.g.b.k.a((Object) arrayList, "it");
            d.a(dVar, arrayList);
        }
    }

    public d() {
        super(R.layout.fragment_transfer_to_bank_account);
    }

    public static final /* synthetic */ f e(d dVar) {
        f fVar = dVar.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        return fVar;
    }

    public static final /* synthetic */ net.one97.paytm.moneytransferv4.b.a.a.a.d.b f(d dVar) {
        net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = dVar.f53166h;
        if (bVar == null) {
            kotlin.g.b.k.a("collectRequestAdapter");
        }
        return bVar;
    }

    public final void a(ContactDetail contactDetail, int i2) {
        kotlin.g.b.k.c(contactDetail, "contact");
        kotlin.g.b.k.c(contactDetail, "contact");
    }

    public final void a(ContactsResponse contactsResponse, String str) {
        kotlin.g.b.k.c(contactsResponse, "beneficiaryEntity");
        kotlin.g.b.k.c(contactsResponse, "beneficiaryEntity");
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC);
        n a2 = n.a(view);
        kotlin.g.b.k.a((Object) a2, "FragmentTransferToBankAccountBinding.bind(view)");
        RecyclerView recyclerView = a2.f53794b;
        kotlin.g.b.k.a((Object) recyclerView, "binding.collectRecyclerView");
        net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = new net.one97.paytm.moneytransferv4.b.a.a.a.d.b(new ArrayList());
        bVar.a((net.one97.paytm.moneytransferv4.b.a.a.d) this);
        this.f53166h = bVar;
        net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar2 = this.f53166h;
        if (bVar2 == null) {
            kotlin.g.b.k.a("collectRequestAdapter");
        }
        recyclerView.setAdapter(bVar2);
        Fragment fragment = this;
        q qVar = this.f53162a;
        if (qVar == null) {
            kotlin.g.b.k.a("viewModelFactory");
        }
        ai a3 = am.a(fragment, (al.b) qVar).a(f.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f53163e = (f) a3;
        f fVar = this.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        String string = getString(R.string.mt_to_your_bank_acc);
        kotlin.g.b.k.a((Object) string, "getString(R.string.mt_to_your_bank_acc)");
        String string2 = getString(R.string.mt_to_saved_acc);
        kotlin.g.b.k.a((Object) string2, "getString(R.string.mt_to_saved_acc)");
        kotlin.g.b.k.c(string, "firstTitle");
        kotlin.g.b.k.c(string2, "secondTitle");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(fVar), (kotlin.d.f) null, (CoroutineStart) null, new f.a(fVar, string, string2, (kotlin.d.d) null), 3, (Object) null);
        f fVar2 = this.f53163e;
        if (fVar2 == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        fVar2.q.a((a.C1379a) new f.b(fVar2), "", "");
        f fVar3 = this.f53163e;
        if (fVar3 == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        String string3 = getString(R.string.mt_to_your_bank_acc);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.mt_to_your_bank_acc)");
        String string4 = getString(R.string.mt_to_saved_acc);
        kotlin.g.b.k.a((Object) string4, "getString(R.string.mt_to_saved_acc)");
        fVar3.a(string3, string4).observe(getViewLifecycleOwner(), new h(this, a2));
        f fVar4 = this.f53163e;
        if (fVar4 == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        fVar4.n.observe(getViewLifecycleOwner(), new i(this, a2));
        f fVar5 = this.f53163e;
        if (fVar5 == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        fVar5.o.observe(getViewLifecycleOwner(), new j(this));
        RecyclerView recyclerView2 = a2.f53795c;
        kotlin.g.b.k.a((Object) recyclerView2, "binding.recyclerView");
        if (this.f53164f == null) {
            if (this.f53163e == null) {
                kotlin.g.b.k.a("transferToBankAccountViewModel");
            }
            String string5 = getString(R.string.mt_to_your_bank_acc);
            kotlin.g.b.k.a((Object) string5, "getString(R.string.mt_to_your_bank_acc)");
            String string6 = getString(R.string.mt_to_saved_acc);
            kotlin.g.b.k.a((Object) string6, "getString(R.string.mt_to_saved_acc)");
            ResultType resulttype = f.b(string5, string6).f54033b;
            if (resulttype == null) {
                kotlin.g.b.k.a();
            }
            this.f53164f = new c((List) resulttype, this);
        }
        c cVar = this.f53164f;
        if (cVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        recyclerView2.setAdapter(cVar);
        a2.f53797e.setOnClickListener(new C0952d(this));
        a2.f53793a.setOnClickListener(new e(this));
        a2.f53798f.setOnClickListener(new f(this));
        a2.f53796d.setOnClickListener(new g(this));
        UserActionEvent.INSTANCE.getActionLiveData().observeForever(this.f53167i);
        getLifecycle().a(new ContactSyncLifeObserver());
        net.one97.paytm.contacts.utils.c cVar2 = net.one97.paytm.contacts.utils.c.f50249c;
        Context requireContext = requireContext();
        kotlin.g.b.k.a((Object) requireContext, "requireContext()");
        cVar2.a(requireContext, e.C0905e.MONEY_TRANSFER.getType(), e.b.PHONEBOOK.getType());
    }

    /* renamed from: net.one97.paytm.m.d$d  reason: collision with other inner class name */
    static final class C0952d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53171a;

        C0952d(d dVar) {
            this.f53171a = dVar;
        }

        public final void onClick(View view) {
            d.a(this.f53171a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53172a;

        e(d dVar) {
            this.f53172a = dVar;
        }

        public final void onClick(View view) {
            d.b(this.f53172a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53173a;

        f(d dVar) {
            this.f53173a = dVar;
        }

        public final void onClick(View view) {
            d.c(this.f53173a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53174a;

        g(d dVar) {
            this.f53174a = dVar;
        }

        public final void onClick(View view) {
            d.d(this.f53174a);
        }
    }

    public final void onResume() {
        super.onResume();
        j();
    }

    public final void j() {
        f fVar = this.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        fVar.c();
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
        if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    public static final class k implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f53180a;

        k(d dVar) {
            this.f53180a = dVar;
        }

        public final void onReEnterClicked() {
            net.one97.paytm.moneytransfer.utils.e.a(this.f53180a, "mt_p2p_new_v1", "UPI_pin_reentered", GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
            d dVar = this.f53180a;
            dVar.a(d.e(dVar).b());
        }

        public final void onCreateNewPinClicked() {
            net.one97.paytm.moneytransfer.utils.e.a(this.f53180a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
            d dVar = this.f53180a;
            dVar.a(d.e(dVar).b(), true);
        }
    }

    private final void a(boolean z) {
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        IncorrectUpiPinBottomSheet.Companion.show(new k(this), childFragmentManager, z);
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (isAdded()) {
            net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                str4 = getString(R.string.mt_balance_credit_limit_bold, UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(R.string.mt_ba…String(availableBalance))");
            } else {
                str4 = getString(R.string.mt_available_balance_bold, UpiAppUtils.priceToString(str2));
                kotlin.g.b.k.a((Object) str4, "getString(R.string.mt_av…String(availableBalance))");
            }
            c cVar = this.f53164f;
            if (cVar == null) {
                kotlin.g.b.k.a("adapter");
            }
            kotlin.g.b.k.c(str4, "balance");
            cVar.f53140c = str4;
            cVar.notifyItemChanged(cVar.f53139b, Integer.valueOf(cVar.f53139b));
        }
    }

    public final void b() {
        c cVar = this.f53164f;
        if (cVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        cVar.a(false);
    }

    public final void Z_() {
        c cVar = this.f53164f;
        if (cVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        cVar.a(true);
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", "check_balance_clicked", GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", (String) null, 32);
        f fVar = this.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        kotlin.g.b.k.c(bankAccount, "<set-?>");
        fVar.f54972i = bankAccount;
        f fVar2 = this.f53163e;
        if (fVar2 == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        String a2 = fVar2.a();
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        kotlin.g.b.k.c(a2, "primaryVpa");
        if (this.f66596d == null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            UPICheckBalanceHelper.UPICheckBalanceBuilder tag = new UPICheckBalanceHelper.UPICheckBalanceBuilder(context, this).setDeviceBindingRequestCode(80).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).setScreenName(getClass().getName()).setTag(getClass().getName());
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.g.b.k.a((Object) viewLifecycleOwner, "viewLifecycleOwner");
            this.f66596d = tag.setLifecycleOwner(viewLifecycleOwner).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank(bankAccount);
        upiProfileDefaultBank.setVirtualAddress(a2);
        UPICheckBalanceHelper uPICheckBalanceHelper = this.f66596d;
        if (uPICheckBalanceHelper == null) {
            kotlin.g.b.k.a("upiCheckBalanceHelper");
        }
        uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
    }

    public final void a(BankAccountDetails.BankAccount bankAccount, boolean z) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        if (!z) {
            net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
        }
        f fVar = this.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        String a2 = fVar.a();
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        kotlin.g.b.k.c(a2, "primaryVpa");
        Intent intent = new Intent(getContext(), SetMPINActivity.class);
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, a2).setBankAccountList(kotlin.a.k.a(bankAccount)).build();
        kotlin.g.b.k.a((Object) build, "UserUpiDetails\n\t\t\t.Build…AccountList(list).build()");
        intent.putExtra("user_upi_details", build);
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z);
        startActivityForResult(intent, this.f66595c);
    }

    public final void b(BankAccountDetails.BankAccount bankAccount) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_SELF_AC_CLICKED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", (String) null, 32);
        PaymentManager paymentManager = PaymentManager.f54783a;
        PaymentManager.PaymentUiModel a2 = PaymentManager.a(bankAccount);
        int i2 = R.id.container;
        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
        Activity requireActivity = requireActivity();
        f fVar = this.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        m.a(i2, (Fragment) a.C0982a.a(a2, requireActivity, bankAccount, fVar.a()), "TransferToBankAccountFragment", getFragmentManager());
    }

    public final void b(ContactsResponse contactsResponse, String str) {
        kotlin.g.b.k.c(contactsResponse, "contactsResponse");
        net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_BENEFICIARY_CLICKED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", (String) null, 32);
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            PaymentManager paymentManager = PaymentManager.f54783a;
            PaymentManager.PaymentUiModel a2 = PaymentManager.a(contactsResponse);
            int i2 = R.id.container;
            a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
            m.a(i2, (Fragment) a.C0982a.a(a2, getActivity(), 12), "BeneficiaryHistoryFragment", getFragmentManager());
            return;
        }
        FragmentActivity requireActivity = requireActivity();
        kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
        Activity activity = requireActivity;
        String name = contactsResponse.getName();
        String a3 = net.one97.paytm.moneytransfer.utils.p.a(activity, str);
        net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
        kotlin.g.b.k.a((Object) a3, "filterMobileNumberP2P");
        aVar2.a(activity, a3, "MT_HOME_CONTACTS", name).observe(getViewLifecycleOwner(), new b(this, activity));
    }

    public final void a(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        int i2 = R.id.container;
        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
        m.a(i2, (Fragment) a.C0982a.a(paymentFlow), "BeneficiaryHistoryFragment", getFragmentManager());
    }

    public final void a(String str, String str2) {
        m.a(requireContext(), str, str2);
    }

    public final void i() {
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        FragmentActivity requireActivity = requireActivity();
        kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
        Intent a2 = net.one97.paytm.wallet.utility.d.a(requireActivity);
        net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
        a2.putExtra(net.one97.paytm.contacts.utils.e.h(), e.C0905e.MONEY_TRANSFER_VIEW_ALL.getType());
        startActivityForResult(a2, this.f53165g);
        net.one97.paytm.moneytransfer.utils.e.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_BENEFICIARY_VIEW_ALL_CLICKED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", (String) null, 32);
    }

    public final void a(UpiPendingRequestModel upiPendingRequestModel) {
        kotlin.g.b.k.c(upiPendingRequestModel, "upiPendingRequestModel");
        q.a aVar = net.one97.paytm.upi.q.f68356a;
        Context requireContext = requireContext();
        kotlin.g.b.k.a((Object) requireContext, "requireContext()");
        q.a.a(upiPendingRequestModel, requireContext, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC);
    }

    public final void h() {
        Intent intent = new Intent(getActivity(), UpiPassbookActivity.class);
        intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
        startActivity(intent);
    }

    public final void a(BaseUpiResponse baseUpiResponse, String str, boolean z) {
        kotlin.g.b.k.c(baseUpiResponse, "baseUpiResponse");
        kotlin.g.b.k.c(str, "txId");
        UserActionEvent.INSTANCE.setAction(new UserActionEvent.Action(UserActionEvent.ActionType.DECLINE.name(), str));
    }

    public final void b(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        int i2 = R.id.container;
        d.a aVar = net.one97.paytm.moneytransferv4.invite.d.f55674a;
        m.a(i2, (Fragment) d.a.a(paymentFlow), "BeneficiaryHistoryFragment", getFragmentManager());
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f53165g && i3 == -1) {
            if (intent != null) {
                net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.g())) {
                    net.one97.paytm.contacts.utils.e eVar2 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.g());
                    if (serializableExtra != null) {
                        PaymentManager paymentManager = PaymentManager.f54783a;
                        PaymentManager.a((PaymentCombinationAPIResponse) serializableExtra, (PaymentManager.a) this);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse");
                }
                net.one97.paytm.contacts.utils.e eVar3 = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.i())) {
                    net.one97.paytm.contacts.utils.e eVar4 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra2 = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.i());
                    if (serializableExtra2 != null) {
                        int i4 = R.id.container;
                        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                        PaymentManager paymentManager2 = PaymentManager.f54783a;
                        m.a(i4, (Fragment) a.C0982a.a(PaymentManager.a((ContactDetail) serializableExtra2), (Activity) null, 14), "BeneficiaryHistoryFragment", getFragmentManager());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
                }
                net.one97.paytm.contacts.utils.e eVar5 = net.one97.paytm.contacts.utils.e.f50261a;
                if (intent.hasExtra(net.one97.paytm.contacts.utils.e.j())) {
                    net.one97.paytm.contacts.utils.e eVar6 = net.one97.paytm.contacts.utils.e.f50261a;
                    Serializable serializableExtra3 = intent.getSerializableExtra(net.one97.paytm.contacts.utils.e.j());
                    if (serializableExtra3 != null) {
                        int i5 = R.id.container;
                        a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                        PaymentManager paymentManager3 = PaymentManager.f54783a;
                        m.a(i5, (Fragment) a.C0982a.a(PaymentManager.a((VPADetails) serializableExtra3), (Activity) null, 14), "BeneficiaryHistoryFragment", getFragmentManager());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.VPADetails");
                }
            }
        } else if (i2 == 2010 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
            String stringExtra2 = intent.getStringExtra("ifsc_code");
            CharSequence charSequence = stringExtra;
            boolean z = false;
            if (charSequence == null || p.a(charSequence)) {
                CharSequence charSequence2 = stringExtra2;
                if (charSequence2 == null || p.a(charSequence2)) {
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            net.one97.paytm.moneytransferv4.b bVar = new net.one97.paytm.moneytransferv4.b();
            Bundle bundle = new Bundle();
            bundle.putBoolean("came_from_self_acc", true);
            bundle.putString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, stringExtra);
            bundle.putString("ifsc_code", stringExtra2);
            bVar.setArguments(bundle);
            requireFragmentManager().a().a(R.id.container, (Fragment) bVar).a((String) null).b();
        }
    }

    public final void onDestroy() {
        UserActionEvent.INSTANCE.getActionLiveData().removeObserver(this.f53167i);
        UserActionEvent.INSTANCE.getActionLiveData().setValue(null);
        super.onDestroy();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(d dVar) {
        net.one97.paytm.moneytransferv4.b bVar = new net.one97.paytm.moneytransferv4.b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("came_from_self_acc", true);
        bVar.setArguments(bundle);
        dVar.requireFragmentManager().a().a(R.id.container, (Fragment) bVar).a((String) null).b();
    }

    public static final /* synthetic */ void b(d dVar) {
        net.one97.paytm.moneytransfer.utils.e.a(dVar, "mt_p2p_new_v1", "back_button_clicked", GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, (String) null, (String) null, (String) null, 56);
        dVar.requireActivity().onBackPressed();
    }

    public static final /* synthetic */ void c(d dVar) {
        net.one97.paytm.moneytransfer.utils.e.a(dVar, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SETTINGS_CLICKED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", (String) null, 32);
        f fVar = dVar.f53163e;
        if (fVar == null) {
            kotlin.g.b.k.a("transferToBankAccountViewModel");
        }
        if (fVar.p.e()) {
            f fVar2 = dVar.f53163e;
            if (fVar2 == null) {
                kotlin.g.b.k.a("transferToBankAccountViewModel");
            }
            if (!fVar2.p.h()) {
                q.a aVar = net.one97.paytm.upi.q.f68356a;
                FragmentActivity activity = dVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                q.a.a(activity);
                return;
            }
            Intent intent = new Intent(dVar.getContext(), UPISettingsActivity.class);
            intent.setFlags(67108864);
            dVar.startActivityForResult(intent, UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
        } else if (UpiUtils.isInActiveProfileExist(dVar.getContext())) {
            dVar.startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(dVar.getContext()), UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
        } else {
            dVar.startActivity(new Intent(dVar.getContext(), UpiSelectBankActivity.class));
        }
    }

    public static final /* synthetic */ void d(d dVar) {
        try {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            Intent intent = new Intent(dVar.getActivity(), Class.forName(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).d()));
            intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
            intent.putExtra("read_text", true);
            dVar.startActivityForResult(intent, 2010);
        } catch (ClassNotFoundException unused) {
        }
    }

    public static final /* synthetic */ void a(d dVar, net.one97.paytm.moneytransfer.c.n nVar, net.one97.paytm.moneytransfer.model.c cVar) {
        c cVar2;
        List<? extends Object> list;
        int i2 = e.f53181a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            TextView textView = nVar.f53797e;
            kotlin.g.b.k.a((Object) textView, "binding.searchView");
            textView.setClickable(true);
            cVar2 = dVar.f53164f;
            if (cVar2 == null) {
                kotlin.g.b.k.a("adapter");
            }
            ResultType resulttype = cVar.f54033b;
            if (resulttype == null) {
                kotlin.g.b.k.a();
            }
            list = (List) resulttype;
        } else if (i2 == 2) {
            TextView textView2 = nVar.f53797e;
            kotlin.g.b.k.a((Object) textView2, "binding.searchView");
            textView2.setClickable(true);
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            boolean z = false;
            dVar.a(upiCustomVolleyError, false);
            cVar2 = dVar.f53164f;
            if (cVar2 == null) {
                kotlin.g.b.k.a("adapter");
            }
            f fVar = dVar.f53163e;
            if (fVar == null) {
                kotlin.g.b.k.a("transferToBankAccountViewModel");
            }
            String string = dVar.getString(R.string.mt_to_saved_acc);
            kotlin.g.b.k.a((Object) string, "getString(R.string.mt_to_saved_acc)");
            kotlin.g.b.k.c(string, "secondTitle");
            list = new ArrayList<>();
            Collection collection = fVar.m;
            if (!(collection == null || collection.isEmpty()) || !fVar.l) {
                Collection collection2 = fVar.m;
                if (collection2 == null || collection2.isEmpty()) {
                    z = true;
                }
                if (z) {
                    list.add(new SearchTitleModel(string));
                    list.add(new b());
                } else {
                    list.add(new SearchTitleModel(string));
                    list.addAll(fVar.m);
                    list.add(new a());
                }
            } else {
                list = w.INSTANCE;
            }
        } else {
            return;
        }
        kotlin.g.b.k.c(list, "data");
        cVar2.f53142e = list;
        cVar2.notifyDataSetChanged();
    }

    public static final /* synthetic */ void a(d dVar, ArrayList arrayList) {
        net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = dVar.f53166h;
        if (bVar == null) {
            kotlin.g.b.k.a("collectRequestAdapter");
        }
        bVar.a((ArrayList<UpiPendingRequestModel>) arrayList);
    }
}

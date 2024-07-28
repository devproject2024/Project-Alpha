package net.one97.paytm.moneytransferv4.accounts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.accounts.i;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstants;

public final class f extends h {

    /* renamed from: c  reason: collision with root package name */
    public static final b f54924c = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f54925a;

    /* renamed from: b  reason: collision with root package name */
    a f54926b;

    /* renamed from: d  reason: collision with root package name */
    private i f54927d;

    /* renamed from: e  reason: collision with root package name */
    private UserUpiDetails f54928e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f54929f;

    public interface a {
        void b();

        void c(BankAccountDetails.BankAccount bankAccount);

        void d(BankAccountDetails.BankAccount bankAccount);
    }

    static final class c<T> implements z<net.one97.paytm.moneytransfer.model.c<d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54930a;

        c(f fVar) {
            this.f54930a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            f fVar = this.f54930a;
            k.a((Object) cVar, Payload.RESPONSE);
            f.a(fVar, cVar);
        }
    }

    static final class d<T> implements z<net.one97.paytm.moneytransfer.model.c<UserUpiDetails>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54931a;

        d(f fVar) {
            this.f54931a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            f fVar = this.f54931a;
            k.a((Object) cVar, Payload.RESPONSE);
            f.b(fVar, cVar);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        o.a().a(this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
        if (serializable != null) {
            this.f54928e = (UserUpiDetails) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UserUpiDetails");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_account_settings, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.moneytransfer.c.c a2 = net.one97.paytm.moneytransfer.c.c.a(view);
        k.a((Object) a2, "BottomSheetAccountSettingsBinding.bind(view)");
        Fragment fragment = this;
        q qVar = this.f54925a;
        if (qVar == null) {
            k.a("viewModelFactory");
        }
        ai a3 = am.a(fragment, (al.b) qVar).a(i.class);
        k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f54927d = (i) a3;
        a2.f53717a.setOnClickListener(new e(this));
        a2.f53719c.setOnClickListener(new C0991f(this));
        a2.f53722f.setOnClickListener(new g(this));
        FrameLayout frameLayout = a2.f53719c;
        k.a((Object) frameLayout, "primaryAccountContainer");
        View view2 = frameLayout;
        UserUpiDetails userUpiDetails = this.f54928e;
        if (userUpiDetails == null) {
            k.a("userUpiDetails");
        }
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
        k.a((Object) selectedBankAccount, "userUpiDetails.selectedBankAccount");
        net.one97.paytm.upi.f.a(view2, !selectedBankAccount.getPrimaryAccount().booleanValue());
        View view3 = a2.f53718b;
        k.a((Object) view3, "divider1");
        UserUpiDetails userUpiDetails2 = this.f54928e;
        if (userUpiDetails2 == null) {
            k.a("userUpiDetails");
        }
        BankAccountDetails.BankAccount selectedBankAccount2 = userUpiDetails2.getSelectedBankAccount();
        k.a((Object) selectedBankAccount2, "userUpiDetails.selectedBankAccount");
        net.one97.paytm.upi.f.a(view3, !selectedBankAccount2.getPrimaryAccount().booleanValue());
        i iVar = this.f54927d;
        if (iVar == null) {
            k.a("viewModel");
        }
        iVar.f54968e.observe(getViewLifecycleOwner(), new c(this));
        i iVar2 = this.f54927d;
        if (iVar2 == null) {
            k.a("viewModel");
        }
        iVar2.f54969f.observe(getViewLifecycleOwner(), new d(this));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54932a;

        e(f fVar) {
            this.f54932a = fVar;
        }

        public final void onClick(View view) {
            f.a(this.f54932a);
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accounts.f$f  reason: collision with other inner class name */
    static final class C0991f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54933a;

        C0991f(f fVar) {
            this.f54933a = fVar;
        }

        public final void onClick(View view) {
            f.b(this.f54933a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54934a;

        g(f fVar) {
            this.f54934a = fVar;
        }

        public final void onClick(View view) {
            f.c(this.f54934a);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10 && i3 == -1) {
            Toast.makeText(getContext(), R.string.upi_reset_mpin_success, 0).show();
            a aVar = this.f54926b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final void onDestroy() {
        this.f54926b = null;
        super.onDestroy();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        Intent intent = new Intent(fVar.getContext(), SetMPINActivity.class);
        UserUpiDetails userUpiDetails = fVar.f54928e;
        if (userUpiDetails == null) {
            k.a("userUpiDetails");
        }
        intent.putExtra("user_upi_details", userUpiDetails);
        fVar.startActivityForResult(intent, 10);
    }

    public static final /* synthetic */ void b(f fVar) {
        i iVar = fVar.f54927d;
        if (iVar == null) {
            k.a("viewModel");
        }
        UserUpiDetails userUpiDetails = fVar.f54928e;
        if (userUpiDetails == null) {
            k.a("userUpiDetails");
        }
        k.c(userUpiDetails, "userUpiDetails");
        y<net.one97.paytm.moneytransfer.model.c<UserUpiDetails>> yVar = iVar.f54969f;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        iVar.j.a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT, userUpiDetails, new i.c(iVar, userUpiDetails), iVar.f54967d, "");
    }

    public static final /* synthetic */ void c(f fVar) {
        i iVar = fVar.f54927d;
        if (iVar == null) {
            k.a("viewModel");
        }
        UserUpiDetails userUpiDetails = fVar.f54928e;
        if (userUpiDetails == null) {
            k.a("userUpiDetails");
        }
        String vpa = userUpiDetails.getVpa();
        k.a((Object) vpa, "userUpiDetails.vpa");
        UserUpiDetails userUpiDetails2 = fVar.f54928e;
        if (userUpiDetails2 == null) {
            k.a("userUpiDetails");
        }
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails2.getSelectedBankAccount();
        k.a((Object) selectedBankAccount, "userUpiDetails.selectedBankAccount");
        iVar.a(vpa, selectedBankAccount);
    }

    public static final /* synthetic */ void a(f fVar, net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = g.f54936b[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).dismissLoader();
            ResultType resulttype = cVar.f54033b;
            if (resulttype == null) {
                k.a();
            }
            d dVar = (d) resulttype;
            if (dVar.f54920a) {
                a aVar = fVar.f54926b;
                if (aVar != null) {
                    UserUpiDetails userUpiDetails = fVar.f54928e;
                    if (userUpiDetails == null) {
                        k.a("userUpiDetails");
                    }
                    BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
                    k.a((Object) selectedBankAccount, "userUpiDetails.selectedBankAccount");
                    aVar.d(selectedBankAccount);
                    return;
                }
                return;
            }
            String str = dVar.f54921b;
            if (k.a((Object) "88", (Object) str) || k.a((Object) "80", (Object) str)) {
                Toast.makeText(fVar.getContext(), R.string.upi_delete_default_bank, 1).show();
            } else if (k.a((Object) "102", (Object) str)) {
                Toast.makeText(fVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
            } else if (k.a((Object) "INT-1199", (Object) str)) {
                Toast.makeText(fVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
            } else {
                Toast.makeText(fVar.getContext(), R.string.something_went_wrong, 1).show();
            }
        } else if (i2 == 2) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).dismissLoader();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                k.a();
            }
            String str2 = upiCustomVolleyError.getmErrorCode();
            k.a((Object) str2, "error.getmErrorCode()");
            if (TextUtils.isEmpty(str2) || !k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str2)) {
                Toast.makeText(fVar.getContext(), R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(fVar.getContext(), fVar.getResources().getString(R.string.no_connection), fVar.getResources().getString(R.string.no_internet));
            }
        } else if (i2 == 3) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).showLoader();
        }
    }

    public static final /* synthetic */ void b(f fVar, net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = g.f54935a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).dismissLoader();
            ResultType resulttype = cVar.f54033b;
            if (resulttype == null) {
                k.a();
            }
            UserUpiDetails userUpiDetails = (UserUpiDetails) resulttype;
            Context context = fVar.getContext();
            if (context != null) {
                net.one97.paytm.upi.f.a(context, R.string.upi_default_bank_account_change_success, 0);
            }
            a aVar = fVar.f54926b;
            if (aVar != null) {
                BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
                k.a((Object) selectedBankAccount, "data.selectedBankAccount");
                aVar.c(selectedBankAccount);
            }
        } else if (i2 == 2) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).dismissLoader();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                k.a();
            }
            if (k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) upiCustomVolleyError.getmErrorCode())) {
                CustomDialog.showAlert(fVar.getContext(), fVar.getResources().getString(R.string.no_connection), fVar.getResources().getString(R.string.no_internet));
            } else if (!TextUtils.isEmpty(upiCustomVolleyError.getAlertTitle())) {
                Toast.makeText(fVar.getContext(), upiCustomVolleyError.getAlertMessage(), 1).show();
            } else {
                Toast.makeText(fVar.getContext(), fVar.getString(R.string.upi_default_bank_account_change_failed), 1).show();
            }
        } else if (i2 == 3) {
            CustomWalletLoaderDialog.getInstance(fVar.getContext()).showLoader();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f54929f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

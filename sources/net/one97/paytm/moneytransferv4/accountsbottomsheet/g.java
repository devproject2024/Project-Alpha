package net.one97.paytm.moneytransferv4.accountsbottomsheet;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.aj;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.utils.o;
import net.one97.paytm.moneytransferv4.accounts.i;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiConstants;

public final class g extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f55055b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f55056a;

    /* renamed from: c  reason: collision with root package name */
    private BankAccountDetails.BankAccount f55057c;

    /* renamed from: d  reason: collision with root package name */
    private String f55058d = "";

    /* renamed from: e  reason: collision with root package name */
    private i f55059e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f55060f;

    static final class e<T> implements z<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.accounts.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f55064a;

        e(g gVar) {
            this.f55064a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            g gVar = this.f55064a;
            k.a((Object) cVar, Payload.RESPONSE);
            g.a(gVar, cVar);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a().a(this);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new d(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f55063a;

        d(g gVar) {
            this.f55063a = gVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    frameLayout.setBackgroundColor(this.f55063a.getResources().getColor(R.color.transparent));
                    from.setState(3);
                    from.setPeekHeight(500);
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
        View inflate = layoutInflater.inflate(R.layout.mt_v4_payee_self_account_fragment, viewGroup, false);
        aj a2 = aj.a(inflate);
        k.a((Object) a2, "MtV4PayeeSelfAccountFragmentBinding.bind(view)");
        Bundle arguments = getArguments();
        String str = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("bankAccount_object") : null;
        if (serializable != null) {
            this.f55057c = (BankAccountDetails.BankAccount) serializable;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("primary_vpa", "");
            }
            if (str == null) {
                k.a();
            }
            this.f55058d = str;
            ao aoVar = this;
            q qVar = this.f55056a;
            if (qVar == null) {
                k.a("viewModelFactory");
            }
            ai a3 = new al(aoVar, (al.b) qVar).a(i.class);
            k.a((Object) a3, "ViewModelProvider(this, …ntsViewModel::class.java]");
            this.f55059e = (i) a3;
            i iVar = this.f55059e;
            if (iVar == null) {
                k.a("viewModel");
            }
            iVar.f54968e.observe(this, new e(this));
            a2.f53662b.setOnClickListener(new b(this));
            a2.f53666f.setOnClickListener(new c(this));
            return inflate;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f55061a;

        b(g gVar) {
            this.f55061a = gVar;
        }

        public final void onClick(View view) {
            g.a(this.f55061a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f55062a;

        c(g gVar) {
            this.f55062a = gVar;
        }

        public final void onClick(View view) {
            m.e((Activity) this.f55062a.getActivity());
            this.f55062a.dismiss();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10 && i3 == -1) {
            Toast.makeText(getContext(), R.string.upi_reset_mpin_success, 0).show();
        }
    }

    public static final /* synthetic */ void a(g gVar, net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = h.f55065a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            CustomWalletLoaderDialog.getInstance(gVar.getContext()).dismissLoader();
            ResultType resulttype = cVar.f54033b;
            if (resulttype == null) {
                k.a();
            }
            net.one97.paytm.moneytransferv4.accounts.d dVar = (net.one97.paytm.moneytransferv4.accounts.d) resulttype;
            if (dVar.f54920a) {
                gVar.dismiss();
                return;
            }
            String str = dVar.f54921b;
            if (k.a((Object) "88", (Object) str) || k.a((Object) "80", (Object) str)) {
                Toast.makeText(gVar.getContext(), R.string.upi_delete_default_bank, 1).show();
            } else if (k.a((Object) "102", (Object) str)) {
                Toast.makeText(gVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
            } else if (k.a((Object) "INT-1199", (Object) str)) {
                Toast.makeText(gVar.getContext(), R.string.upi_delete_default_bank_vpa, 1).show();
            } else {
                Toast.makeText(gVar.getContext(), R.string.something_went_wrong, 1).show();
            }
        } else if (i2 == 2) {
            CustomWalletLoaderDialog.getInstance(gVar.getContext()).dismissLoader();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                k.a();
            }
            String str2 = upiCustomVolleyError.getmErrorCode();
            k.a((Object) str2, "error.getmErrorCode()");
            if (TextUtils.isEmpty(str2) || !k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str2)) {
                Toast.makeText(gVar.getContext(), R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(gVar.getContext(), gVar.getResources().getString(R.string.no_connection), gVar.getResources().getString(R.string.no_internet));
            }
        } else if (i2 == 3) {
            CustomWalletLoaderDialog.getInstance(gVar.getContext()).showLoader();
        }
    }

    public static final /* synthetic */ void a(g gVar) {
        if (gVar.isAdded()) {
            Intent intent = new Intent(gVar.getActivity(), SetMPINActivity.class);
            ArrayList arrayList = new ArrayList();
            BankAccountDetails.BankAccount bankAccount = gVar.f55057c;
            if (bankAccount == null) {
                k.a("bankAccount");
            }
            arrayList.add(bankAccount);
            intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, gVar.f55058d).setBankAccountList(arrayList).build());
            gVar.startActivityForResult(intent, 10);
            gVar.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55060f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

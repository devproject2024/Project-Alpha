package net.one97.paytm.upi.registration.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.e.af;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.c.c;
import net.one97.paytm.upi.registration.view.m;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class e extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68830a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final int f68831b = 15;

    /* renamed from: c  reason: collision with root package name */
    private final String f68832c = "upi_onb_fetch_accounts_time";

    /* renamed from: d  reason: collision with root package name */
    private af f68833d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.registration.c.c f68834e;

    /* renamed from: f  reason: collision with root package name */
    private final io.reactivex.rxjava3.b.b f68835f = new io.reactivex.rxjava3.b.b();

    /* renamed from: g  reason: collision with root package name */
    private HashMap f68836g;

    static final class d<T> implements z<c.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68841a;

        d(e eVar) {
            this.f68841a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c.b bVar = (c.b) obj;
            e eVar = this.f68841a;
            k.a((Object) bVar, "t");
            e.a(eVar, bVar);
        }
    }

    /* renamed from: net.one97.paytm.upi.registration.view.e$e  reason: collision with other inner class name */
    static final class C1396e<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68842a;

        C1396e(e eVar) {
            this.f68842a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            c.a.C1391a aVar = c.a.f68541a;
            int a2 = c.a.f68548h;
            if (num != null && num.intValue() == a2) {
                e.b(this.f68842a);
            }
        }
    }

    static final class f<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68843a;

        f(e eVar) {
            this.f68843a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                e.a(this.f68843a);
            }
        }
    }

    static final class g<T> implements q<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.c f68844a;

        g(x.c cVar) {
            this.f68844a = cVar;
        }

        public final /* synthetic */ boolean test(Object obj) {
            return ((Long) obj).longValue() <= ((long) this.f68844a.element);
        }
    }

    public static final /* synthetic */ af d(e eVar) {
        af afVar = eVar.f68833d;
        if (afVar == null) {
            k.a("viewBinding");
        }
        return afVar;
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
        setCancelable(false);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.registration.c.c.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ntsViewModel::class.java)");
        this.f68834e = (net.one97.paytm.upi.registration.c.c) a2;
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_FETCH_ACCOUNTS, "");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new c(this));
            aVar.setCanceledOnTouchOutside(false);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68839a;

        c(e eVar) {
            this.f68839a = eVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    final BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    Context context = this.f68839a.getContext();
                    if (context != null) {
                        frameLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.transparent));
                    }
                    from.setBottomSheetCallback(new BottomSheetBehavior.a() {
                        public final void onSlide(View view, float f2) {
                            k.c(view, "bottomSheet");
                        }

                        public final void onStateChanged(View view, int i2) {
                            k.c(view, "bottomSheet");
                            if (i2 == 1) {
                                from.setState(3);
                            }
                        }
                    });
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.upi_fetch_bank_accounts_fragment, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…agment, container, false)");
        af a2 = af.a(inflate);
        k.a((Object) a2, "UpiFetchBankAccountsFragmentBinding.bind(view)");
        this.f68833d = a2;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.upi.registration.c.c cVar = this.f68834e;
        if (cVar == null) {
            k.a("fetchBankAccountsViewModel");
        }
        cVar.f68534a.observe(getViewLifecycleOwner(), new f(this));
        net.one97.paytm.upi.registration.c.c cVar2 = this.f68834e;
        if (cVar2 == null) {
            k.a("fetchBankAccountsViewModel");
        }
        cVar2.f68538e.observe(getViewLifecycleOwner(), new d(this));
        net.one97.paytm.upi.registration.c.c cVar3 = this.f68834e;
        if (cVar3 == null) {
            k.a("fetchBankAccountsViewModel");
        }
        cVar3.f68539f.observe(getViewLifecycleOwner(), new C1396e(this));
        net.one97.paytm.upi.registration.c.c cVar4 = this.f68834e;
        if (cVar4 == null) {
            k.a("fetchBankAccountsViewModel");
        }
        cVar4.f68537d.c(new c.d(cVar4), cVar4.f68535b);
    }

    public static final class b extends io.reactivex.rxjava3.g.c<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f68837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f68838b;

        public final void onError(Throwable th) {
            k.c(th, "e");
        }

        b(e eVar, int i2) {
            this.f68837a = eVar;
            this.f68838b = i2;
        }

        public final /* synthetic */ void onNext(Object obj) {
            Long l = (Long) obj;
            e.c(this.f68837a);
            long longValue = ((long) this.f68838b) - (l != null ? l.longValue() : 0);
            if (longValue >= 10) {
                TextView textView = e.d(this.f68837a).f66755c;
                k.a((Object) textView, "viewBinding.pollingTimer");
                textView.setText(String.valueOf(longValue));
                return;
            }
            TextView textView2 = e.d(this.f68837a).f66755c;
            k.a((Object) textView2, "viewBinding.pollingTimer");
            textView2.setText("0".concat(String.valueOf(longValue)));
        }

        public final void onComplete() {
            e.e(this.f68837a);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.f68835f.a();
        HashMap hashMap = this.f68836g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private final void a() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (!valueOf.booleanValue() && isAdded()) {
                dismiss();
            }
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "back_button_clicked", "", "", "", GAConstants.SCREEN_NAME.UPI_FETCH_ACCOUNTS, "");
    }

    public static final /* synthetic */ void a(e eVar) {
        x.c cVar = new x.c();
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        cVar.element = a2.c().a(eVar.f68832c, eVar.f68831b);
        if (cVar.element <= 0) {
            cVar.element = eVar.f68831b;
        }
        io.reactivex.rxjava3.g.c cVar2 = (io.reactivex.rxjava3.g.c) p.interval(1, TimeUnit.SECONDS).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).takeWhile(new g(cVar)).subscribeWith(new b(eVar, cVar.element));
        if (cVar2 != null) {
            eVar.f68835f.a((io.reactivex.rxjava3.b.c) cVar2);
        }
    }

    public static final /* synthetic */ void a(e eVar, c.b bVar) {
        UpiProfileModel.ProfileDetails profileDetails = bVar.f68550b;
        ArrayList<BankAccountDetails.BankAccount> arrayList = null;
        ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetails != null ? profileDetails.getBankAccountList() : null;
        if (bankAccountList == null || !(!bankAccountList.isEmpty())) {
            FragmentActivity activity = eVar.getActivity();
            if (!(activity instanceof SignUpAddBankActivity)) {
                activity = null;
            }
            SignUpAddBankActivity signUpAddBankActivity = (SignUpAddBankActivity) activity;
            if (signUpAddBankActivity != null) {
                signUpAddBankActivity.a(bVar.f68549a);
            }
            eVar.a();
            return;
        }
        FragmentActivity activity2 = eVar.getActivity();
        if (!(activity2 instanceof SignUpAddBankActivity)) {
            activity2 = null;
        }
        SignUpAddBankActivity signUpAddBankActivity2 = (SignUpAddBankActivity) activity2;
        if (signUpAddBankActivity2 != null) {
            k.c(bVar, "fetchAccountModel");
            j supportFragmentManager = signUpAddBankActivity2.getSupportFragmentManager();
            m.a aVar = m.f68969a;
            UpiProfileModel.ProfileDetails profileDetails2 = bVar.f68550b;
            if (profileDetails2 != null) {
                arrayList = profileDetails2.getBankAccountList();
            }
            if (arrayList == null) {
                k.a();
            }
            UpiUtils.replaceFragmentToActivity(supportFragmentManager, m.a.a(arrayList, bVar.f68549a), R.id.container, true);
        }
        eVar.a();
    }

    public static final /* synthetic */ void b(e eVar) {
        eVar.a();
        if (eVar.getActivity() instanceof SignUpAddBankActivity) {
            FragmentActivity activity = eVar.getActivity();
            if (activity != null) {
                ((SignUpAddBankActivity) activity).b(1);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
        }
    }

    public static final /* synthetic */ void c(e eVar) {
        af afVar = eVar.f68833d;
        if (afVar == null) {
            k.a("viewBinding");
        }
        TextView textView = afVar.f66755c;
        k.a((Object) textView, "viewBinding.pollingTimer");
        net.one97.paytm.upi.f.b((View) textView);
    }

    public static final /* synthetic */ void e(e eVar) {
        if (eVar.isAdded()) {
            af afVar = eVar.f68833d;
            if (afVar == null) {
                k.a("viewBinding");
            }
            TextView textView = afVar.f66753a;
            k.a((Object) textView, "viewBinding.fetchAccounts");
            textView.setText(eVar.getString(R.string.upi_creating_profile));
            eVar.f68835f.a();
            af afVar2 = eVar.f68833d;
            if (afVar2 == null) {
                k.a("viewBinding");
            }
            TextView textView2 = afVar2.f66755c;
            k.a((Object) textView2, "viewBinding.pollingTimer");
            net.one97.paytm.upi.f.a((View) textView2);
            net.one97.paytm.upi.registration.c.c cVar = eVar.f68834e;
            if (cVar == null) {
                k.a("fetchBankAccountsViewModel");
            }
            cVar.f68537d.d(cVar, cVar.f68535b, cVar.f68536c);
        }
    }
}

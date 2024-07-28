package net.one97.paytm.moneytransfer.view.fragments;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.h;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class j extends f implements View.OnClickListener, h.b {

    /* renamed from: a  reason: collision with root package name */
    boolean f54493a;

    /* renamed from: b  reason: collision with root package name */
    private final int f54494b;

    /* renamed from: c  reason: collision with root package name */
    private final int f54495c = 1;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f54496d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f54497e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public h f54498f;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends UpiProfileDefaultBank> f54499g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.viewmodel.a f54500h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.viewmodel.b f54501i;
    private int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank l;
    private HashMap m;

    static final class b<T> implements z<net.one97.paytm.moneytransfer.model.c<b.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f54503a;

        b(j jVar) {
            this.f54503a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            j jVar = this.f54503a;
            if (cVar == null) {
                k.a();
            }
            j.a(jVar, cVar);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.MoneyTransferBottomSheetDialogStyle);
        this.f54500h = (net.one97.paytm.moneytransfer.viewmodel.a) am.a((Fragment) this).a(net.one97.paytm.moneytransfer.viewmodel.a.class);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        this.f54501i = (net.one97.paytm.moneytransfer.viewmodel.b) am.a(activity).a(net.one97.paytm.moneytransfer.viewmodel.b.class);
    }

    public final void a(Integer num) {
        if (num == null) {
            k.a();
        }
        this.j = num.intValue();
        h hVar = this.f54498f;
        if (hVar != null) {
            hVar.a(num.intValue());
        }
    }

    public final void a(List<? extends UpiProfileDefaultBank> list) {
        k.c(list, "vpaList");
        this.f54499g = list;
    }

    public final void b(List<? extends UpiProfileDefaultBank> list) {
        k.c(list, "vpaList");
        this.f54499g = list;
        h hVar = this.f54498f;
        if (hVar != null) {
            hVar.a((List<UpiProfileDefaultBank>) list);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.universal_money_transfer_vpa_list_bottomsheet, viewGroup, false);
        k.a((Object) inflate, "view");
        View.OnClickListener onClickListener = this;
        inflate.findViewById(R.id.close_sheet_iv).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.link_another_tv).setOnClickListener(onClickListener);
        inflate.findViewById(R.id.bottom_sheet_button).setOnClickListener(onClickListener);
        this.f54497e = (TextView) inflate.findViewById(R.id.tranfer_from_tv);
        if (m.b()) {
            View findViewById = inflate.findViewById(R.id.rel_bottom);
            k.a((Object) findViewById, "view.findViewById<RelativeLayout>(R.id.rel_bottom)");
            ((RelativeLayout) findViewById).setVisibility(8);
        }
        if (this.f54493a) {
            TextView textView = this.f54497e;
            if (textView != null) {
                textView.setText(getString(R.string.upi_pay_from));
            }
        } else {
            TextView textView2 = this.f54497e;
            if (textView2 != null) {
                textView2.setText(getString(R.string.univ_money_trnsfr_transfer_money_from));
            }
        }
        net.one97.paytm.moneytransfer.viewmodel.a aVar = this.f54500h;
        if (!(aVar == null || (yVar = aVar.f54659b) == null)) {
            yVar.observe(this, new b(this));
        }
        this.f54496d = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f54498f = new h(this.f54499g);
        h hVar = this.f54498f;
        if (hVar != null) {
            hVar.a((h.b) this);
        }
        h hVar2 = this.f54498f;
        if (hVar2 != null) {
            hVar2.a(this.j);
        }
        RecyclerView recyclerView = this.f54496d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.f54496d;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f54498f);
        }
        return inflate;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f54502a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f54502a = new a();

        a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
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

    public final void onClick(View view) {
        com.paytm.b.a.a aVar;
        boolean z;
        Context applicationContext;
        Context applicationContext2;
        if (view == null || view.getId() != R.id.close_sheet_iv) {
            com.paytm.b.a.a aVar2 = null;
            if (view != null && view.getId() == R.id.link_another_tv) {
                Context context = getContext();
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
                        b(this.f54494b);
                    } else if (com.paytm.utility.a.m(getContext())) {
                        AccountProviderActivity.a((Fragment) this, 31);
                    } else {
                        m.d((Activity) getActivity());
                    }
                } else if (UpiUtils.isInActiveProfileExist(getContext())) {
                    startActivity(UpiUtils.getUpiLandingPageActivityIntent(getActivity()));
                } else {
                    Intent intent = new Intent(getActivity(), UpiSelectBankActivity.class);
                    intent.setFlags(536870912);
                    intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
                    startActivity(intent);
                }
            } else if (view != null && view.getId() == R.id.bottom_sheet_button) {
                a();
                Fragment parentFragment = getParentFragment();
                if (!(parentFragment instanceof n)) {
                    parentFragment = null;
                }
                n nVar = (n) parentFragment;
                if (nVar != null) {
                    nVar.g();
                }
            }
        } else {
            a();
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        if (upiProfileDefaultBank == null) {
            k.a();
        }
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        startActivityForResult(intent, 10);
    }

    public final void a(int i2) {
        this.j = i2;
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof n)) {
            parentFragment = null;
        }
        n nVar = (n) parentFragment;
        if (nVar != null) {
            nVar.f54549b = i2;
            nVar.b(false);
            nVar.a(i2);
            nVar.j();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        UpiAppUtils.hideKeyboard(getActivity());
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof n)) {
            parentFragment = null;
        }
        n nVar = (n) parentFragment;
        if (nVar != null) {
            nVar.a(true);
        }
    }

    private final void a() {
        if (getActivity() != null) {
            UpiAppUtils.hideKeyboard(getActivity());
            dismiss();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0 = (r0 = (r0 = r0.q).getValue()).getIca();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2, int r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0049
            r1.k = r3
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank$PAYMENT_MODE r3 = r2.getPaymentMode()
            if (r3 != 0) goto L_0x000b
            return
        L_0x000b:
            int[] r0 = net.one97.paytm.moneytransfer.view.fragments.k.f54505a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 1
            if (r3 == r0) goto L_0x003e
            r0 = 2
            if (r3 == r0) goto L_0x001a
            goto L_0x0049
        L_0x001a:
            net.one97.paytm.moneytransfer.viewmodel.a r3 = r1.f54500h
            if (r3 == 0) goto L_0x0049
            net.one97.paytm.moneytransfer.viewmodel.b r0 = r1.f54501i
            if (r0 == 0) goto L_0x0039
            androidx.lifecycle.y<net.one97.paytm.common.entity.PPBCurrentAccountModel> r0 = r0.q
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.common.entity.PPBCurrentAccountModel r0 = (net.one97.paytm.common.entity.PPBCurrentAccountModel) r0
            if (r0 == 0) goto L_0x0039
            net.one97.paytm.common.entity.PPBCurrentAccountModel$Ica r0 = r0.getIca()
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = r0.getCaId()
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            r3.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r2, (java.lang.String) r0)
            return
        L_0x003e:
            r1.l = r2
            net.one97.paytm.moneytransfer.viewmodel.a r3 = r1.f54500h
            if (r3 == 0) goto L_0x0049
            java.lang.String r0 = ""
            r3.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r2, (java.lang.String) r0)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.j.a(net.one97.paytm.upi.common.upi.UpiProfileDefaultBank, int):void");
    }

    private final void a(boolean z) {
        if (isAdded()) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new c(this), childFragmentManager, z);
        }
    }

    public static final class c implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f54504a;

        c(j jVar) {
            this.f54504a = jVar;
        }

        public final void onReEnterClicked() {
            if (this.f54504a.l == null) {
                Toast.makeText(this.f54504a.getContext(), R.string.some_went_wrong, 0).show();
                return;
            }
            h b2 = this.f54504a.f54498f;
            if (b2 != null) {
                b2.b(this.f54504a.k);
            }
            net.one97.paytm.moneytransfer.viewmodel.a d2 = this.f54504a.f54500h;
            if (d2 != null) {
                UpiProfileDefaultBank a2 = this.f54504a.l;
                if (a2 == null) {
                    k.a();
                }
                d2.a(a2, "");
            }
        }

        public final void onCreateNewPinClicked() {
            if (this.f54504a.l == null) {
                Toast.makeText(this.f54504a.getContext(), R.string.some_went_wrong, 0).show();
                return;
            }
            j jVar = this.f54504a;
            UpiProfileDefaultBank a2 = jVar.l;
            if (a2 == null) {
                k.a();
            }
            j.a(jVar, a2);
        }
    }

    private void b(int i2) {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            super.onActivityResult(r4, r5, r6)
            r0 = -1
            if (r5 != r0) goto L_0x00aa
            int r5 = r3.f54494b
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity"
            if (r4 != r5) goto L_0x0026
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r4 = r4 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r4 == 0) goto L_0x00c7
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x0020
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r4 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r4
            r4.p()
            return
        L_0x0020:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r0)
            throw r4
        L_0x0026:
            int r5 = r3.f54495c
            r1 = 0
            if (r4 != r5) goto L_0x003b
            net.one97.paytm.moneytransfer.view.a.h r4 = r3.f54498f
            if (r4 == 0) goto L_0x0035
            int r5 = r3.k
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r4.c(r5)
        L_0x0035:
            int r4 = r3.k
            r3.a((net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1, (int) r4)
            return
        L_0x003b:
            r5 = 10
            if (r4 != r5) goto L_0x0059
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r4 = r4 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r4 == 0) goto L_0x00c7
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x0053
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r4 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r4
            r4.p()
            return
        L_0x0053:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r0)
            throw r4
        L_0x0059:
            r5 = 31
            r2 = 34
            if (r4 != r5) goto L_0x008d
            if (r6 == 0) goto L_0x0068
            java.lang.String r4 = "account_provider"
            java.io.Serializable r4 = r6.getSerializableExtra(r4)
            goto L_0x0069
        L_0x0068:
            r4 = r1
        L_0x0069:
            if (r4 == 0) goto L_0x0085
            net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProvider r4 = (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r4
            r5 = r3
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            net.one97.paytm.moneytransfer.viewmodel.b r6 = r3.f54501i
            if (r6 == 0) goto L_0x0081
            androidx.lifecycle.y r6 = r6.b()
            if (r6 == 0) goto L_0x0081
            java.lang.Object r6 = r6.getValue()
            r1 = r6
            java.lang.String r1 = (java.lang.String) r1
        L_0x0081:
            net.one97.paytm.upi.profile.view.BankVpaCreationActivity.a((androidx.fragment.app.Fragment) r5, (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r4, (java.lang.String) r1, (int) r2)
            return
        L_0x0085:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider"
            r4.<init>(r5)
            throw r4
        L_0x008d:
            if (r4 != r2) goto L_0x00a9
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r4 = r4 instanceof net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity
            if (r4 == 0) goto L_0x00c7
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x00a3
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity r4 = (net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity) r4
            r4.p()
            goto L_0x00a9
        L_0x00a3:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r0)
            throw r4
        L_0x00a9:
            return
        L_0x00aa:
            int r5 = r3.f54495c
            if (r4 != r5) goto L_0x00c7
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.moneytransfer.R.string.upi_check_balance_error
            r6 = 1
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r6)
            r4.show()
            net.one97.paytm.moneytransfer.view.a.h r4 = r3.f54498f
            if (r4 == 0) goto L_0x00c7
            java.lang.String r5 = ""
            r4.a((java.lang.String) r5)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.j.onActivityResult(int, int, android.content.Intent):void");
    }

    public static final /* synthetic */ void a(j jVar, net.one97.paytm.moneytransfer.model.c cVar) {
        String str;
        h hVar;
        if (cVar != null) {
            int i2 = k.f54506b[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                return;
            }
            if (i2 == 2) {
                ResultType resulttype = cVar.f54033b;
                if (resulttype == null) {
                    k.a();
                }
                b.a aVar = (b.a) resulttype;
                if (aVar != null) {
                    Integer num = aVar.f54688d;
                    if (num != null && num.intValue() == 0) {
                        if (!TextUtils.isEmpty(aVar.f54685a)) {
                            if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f54687c) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(aVar.f54687c) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                                str = jVar.getString(R.string.upi_balance_credit_limit, UpiAppUtils.priceToString(aVar.f54686b), UpiAppUtils.priceToString(aVar.f54685a));
                                k.a((Object) str, "getString(\n             …                        )");
                            } else {
                                str = jVar.getString(R.string.upi_new_balance, UpiAppUtils.priceToString(aVar.f54685a));
                                k.a((Object) str, "getString(\n             …                        )");
                            }
                            h hVar2 = jVar.f54498f;
                            if (hVar2 != null) {
                                hVar2.a(str);
                                return;
                            }
                            return;
                        }
                        h hVar3 = jVar.f54498f;
                        if (hVar3 != null) {
                            hVar3.a("");
                        }
                        Toast.makeText(jVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                    } else if (num != null && num.intValue() == 2) {
                        Fragment parentFragment = jVar.getParentFragment();
                        if (parentFragment != null) {
                            n nVar = (n) parentFragment;
                            if (nVar != null) {
                                nVar.a(MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG);
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransfer.view.fragments.MoneyTransferPaymentFragment");
                    } else if (num != null && num.intValue() == 1) {
                        jVar.b(jVar.f54495c);
                    } else if (num != null && num.intValue() == 3) {
                        d.a aVar2 = d.f53996a;
                        net.one97.paytm.moneytransfer.d.a b2 = d.b(d.a.a());
                        FragmentActivity activity = jVar.getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        k.a((Object) activity, "activity!!");
                        new NetworkCustomError();
                        b2.a((Activity) activity, (String) null, true);
                    } else if (num != null && num.intValue() == 4) {
                        jVar.a(false);
                        h hVar4 = jVar.f54498f;
                        if (hVar4 != null) {
                            hVar4.a("");
                        }
                    } else if (num != null && num.intValue() == 6) {
                        jVar.a(true);
                        h hVar5 = jVar.f54498f;
                        if (hVar5 != null) {
                            hVar5.a("");
                        }
                    } else if (num != null && num.intValue() == 5) {
                        Toast.makeText(jVar.getActivity(), R.string.upi_check_balance_error, 1).show();
                        h hVar6 = jVar.f54498f;
                        if (hVar6 != null) {
                            hVar6.a("");
                        }
                    }
                }
            } else if (i2 == 3) {
                h hVar7 = jVar.f54498f;
                if (hVar7 != null) {
                    hVar7.a("");
                }
                Toast.makeText(jVar.getActivity(), R.string.upi_check_balance_error, 1).show();
            } else if (i2 == 4 && (hVar = jVar.f54498f) != null) {
                hVar.a("");
            }
        }
    }

    public static final /* synthetic */ void a(j jVar, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(jVar.getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        if (upiProfileDefaultBank == null) {
            k.a();
        }
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
        jVar.startActivityForResult(intent, 10);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.b.d;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.activity.ICAAccountOpeningActivity;
import net.one97.paytm.bankOpen.ica.d.f;
import net.one97.paytm.bankOpen.ica.model.ICAStatusResponse;

public final class h extends net.one97.paytm.bankCommon.d.b {

    /* renamed from: b  reason: collision with root package name */
    private f f16541b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f16542c;

    private View a(int i2) {
        if (this.f16542c == null) {
            this.f16542c = new HashMap();
        }
        View view = (View) this.f16542c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16542c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16545a;

        c(h hVar) {
            this.f16545a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar == null) {
            } else {
                if (cVar.f16216a == d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        ICAStatusResponse iCAStatusResponse = (ICAStatusResponse) t;
                        CharSequence leadStatus = iCAStatusResponse.getLeadStatus();
                        if (leadStatus == null || p.a(leadStatus)) {
                            return;
                        }
                        if (iCAStatusResponse.getLeadStatus().equals("NOT_APPLIED") || iCAStatusResponse.getLeadStatus().equals("LEAD")) {
                            net.one97.paytm.bankCommon.h.c.a(this.f16545a.getContext());
                            h.a(this.f16545a, iCAStatusResponse.getLeadStatus());
                        } else if (iCAStatusResponse.getLeadStatus().equals("NOT_ALLOWED")) {
                            com.paytm.utility.b.b((Context) this.f16545a.getActivity(), this.f16545a.getString(R.string.alert), this.f16545a.getString(R.string.pb_not_eligible_apply));
                        } else if (iCAStatusResponse.getLeadStatus().equals("ACTIVE")) {
                            net.one97.paytm.bankCommon.h.c.c(this.f16545a.getContext());
                            FragmentActivity activity = this.f16545a.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        } else if (iCAStatusResponse.getLeadStatus().equals("TRACK")) {
                            h.a(this.f16545a, iCAStatusResponse.getLeadStatus());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICAStatusResponse");
                    }
                } else if (cVar.f16216a == d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        net.one97.paytm.bankCommon.utils.f.a((Context) this.f16545a.getActivity(), networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_combined_open_fragment, (ViewGroup) null, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r6, r0)
            super.onViewCreated(r6, r7)
            r6 = r5
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            androidx.lifecycle.al r6 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r6)
            java.lang.Class<net.one97.paytm.bankOpen.ica.d.f> r7 = net.one97.paytm.bankOpen.ica.d.f.class
            androidx.lifecycle.ai r6 = r6.a(r7)
            java.lang.String r7 = "ViewModelProviders.of(th…ICAViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.bankOpen.ica.d.f r6 = (net.one97.paytm.bankOpen.ica.d.f) r6
            r5.f16541b = r6
            r5.getActivity()
            net.one97.paytm.bankCommon.utils.d r6 = net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r7 = "GTMLoader.getInstance(activity)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r6 = net.one97.paytm.bankCommon.utils.d.g()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x00ac
            r5.getActivity()
            net.one97.paytm.bankCommon.utils.d r6 = net.one97.paytm.bankCommon.mapping.g.a()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r6 = net.one97.paytm.bankCommon.utils.d.g()
            java.lang.String r7 = "GTMLoader.getInstance(activity).savingAccInterest"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            kotlin.m.l r7 = new kotlin.m.l
            java.lang.String r2 = "##"
            r7.<init>((java.lang.String) r2)
            java.util.List r6 = r7.split(r6, r0)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x008c
            int r7 = r6.size()
            java.util.ListIterator r7 = r6.listIterator(r7)
        L_0x0067:
            boolean r2 = r7.hasPrevious()
            if (r2 == 0) goto L_0x008c
            java.lang.Object r2 = r7.previous()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x007d
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            if (r2 != 0) goto L_0x0067
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            int r7 = r7.nextIndex()
            int r7 = r7 + r1
            java.util.List r6 = kotlin.a.k.b(r6, (int) r7)
            goto L_0x0090
        L_0x008c:
            kotlin.a.w r6 = kotlin.a.w.INSTANCE
            java.util.List r6 = (java.util.List) r6
        L_0x0090:
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.String[] r7 = new java.lang.String[r0]
            java.lang.Object[] r6 = r6.toArray(r7)
            if (r6 == 0) goto L_0x00a4
            java.lang.String[] r6 = (java.lang.String[]) r6
            int r7 = r6.length
            if (r7 <= r1) goto L_0x00ac
            r7 = r6[r0]
            r6 = r6[r1]
            goto L_0x00b0
        L_0x00a4:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<T>"
            r6.<init>(r7)
            throw r6
        L_0x00ac:
            java.lang.String r7 = "4%"
            java.lang.String r6 = "7.03%"
        L_0x00b0:
            int r2 = net.one97.paytm.bankOpen.R.id.pb_sv_bank_promotion_title1_tv
            android.view.View r2 = r5.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "pb_sv_bank_promotion_title1_tv"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.bankOpen.R.string.pb_bank_promotion_title1
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r7
            java.lang.String r7 = r5.getString(r3, r4)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            int r7 = net.one97.paytm.bankOpen.R.id.pb_sv_bank_promotion_title2_tv
            android.view.View r7 = r5.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r2 = "pb_sv_bank_promotion_title2_tv"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            int r2 = net.one97.paytm.bankOpen.R.string.pb_bank_promotion_title2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r6
            java.lang.String r6 = r5.getString(r2, r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
            int r6 = net.one97.paytm.bankOpen.R.id.btn_sv_open
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatButton r6 = (androidx.appcompat.widget.AppCompatButton) r6
            net.one97.paytm.bankOpen.ica.b.h$a r7 = new net.one97.paytm.bankOpen.ica.b.h$a
            r7.<init>(r5)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            int r6 = net.one97.paytm.bankOpen.R.id.btn_ca_open
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatButton r6 = (androidx.appcompat.widget.AppCompatButton) r6
            net.one97.paytm.bankOpen.ica.b.h$b r7 = new net.one97.paytm.bankOpen.ica.b.h$b
            r7.<init>(r5)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.b.h.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16543a;

        a(h hVar) {
            this.f16543a = hVar;
        }

        public final void onClick(View view) {
            h.a(this.f16543a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f16544a;

        b(h hVar) {
            this.f16544a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f16544a);
        }
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onResponse(iJRPaytmDataModel);
        W_();
        if (isResumed()) {
            if (iJRPaytmDataModel instanceof BankStatusModel) {
                BankStatusModel bankStatusModel = (BankStatusModel) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(bankStatusModel.getErrorMessage())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), bankStatusModel.getErrorMessage());
                } else if (TextUtils.isEmpty(bankStatusModel.getAccountStatus())) {
                } else {
                    if (k.a((Object) bankStatusModel.getAccountStatus(), (Object) "NOT_ELIGIBLE")) {
                        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.alert), getString(R.string.pb_not_eligible_apply));
                    } else if (k.a((Object) bankStatusModel.getAccountStatus(), (Object) "NOT_APPLIED") || k.a((Object) bankStatusModel.getAccountStatus(), (Object) "LEAD")) {
                        if (getActivity() != null && isResumed()) {
                            HashMap hashMap = new HashMap();
                            String simpleName = getClass().getSimpleName();
                            k.a((Object) simpleName, "javaClass.simpleName");
                            hashMap.put("screen_name", simpleName);
                            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.bankOpen.a.a.a(getContext(), "ISA", (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
                            if (com.paytm.utility.b.c(getContext())) {
                                a(getContext(), getString(R.string.pb_please_wait));
                                Context context = getContext();
                                if (context != null) {
                                    context.getApplicationContext();
                                }
                                net.one97.paytm.bankCommon.g.c.a();
                                net.one97.paytm.bankCommon.g.c.a(a2);
                                return;
                            }
                            a(a2);
                        }
                    } else if (k.a((Object) bankStatusModel.getAccountStatus(), (Object) "FAILED") || k.a((Object) bankStatusModel.getAccountStatus(), (Object) "IN_PROGRESS") || k.a((Object) bankStatusModel.getAccountStatus(), (Object) "INITIATED") || k.a((Object) bankStatusModel.getAccountStatus(), (Object) "PENDING")) {
                        net.one97.paytm.bankOpen.c a3 = net.one97.paytm.bankOpen.f.a();
                        k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
                        net.one97.paytm.bankCommon.h.b.k(a3.getApplicationContext());
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        activity.finish();
                    } else if (k.a((Object) bankStatusModel.getAccountStatus(), (Object) "ISSUED")) {
                        net.one97.paytm.bankOpen.c a4 = net.one97.paytm.bankOpen.f.a();
                        k.a((Object) a4, "PaymentBankAccOpenHelper.getImplListener()");
                        net.one97.paytm.bankCommon.h.b.l(a4.getApplicationContext());
                        FragmentActivity activity2 = getActivity();
                        if (activity2 == null) {
                            k.a();
                        }
                        activity2.finish();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CustProductStatus) {
                CustProductStatus custProductStatus = (CustProductStatus) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(custProductStatus.getProduct()) && p.a(custProductStatus.getProduct(), "ISA", true)) {
                    if (!TextUtils.isEmpty(custProductStatus.getPasscode())) {
                        String passcode = custProductStatus.getPasscode();
                        if (passcode == null) {
                            k.a();
                        }
                        if (p.a(passcode, "Y", true)) {
                            FragmentActivity activity3 = getActivity();
                            if (activity3 == null) {
                                k.a();
                            }
                            net.one97.paytm.bankCommon.h.b.a((Context) activity3, true);
                        } else {
                            FragmentActivity activity4 = getActivity();
                            if (activity4 == null) {
                                k.a();
                            }
                            net.one97.paytm.bankCommon.h.b.a((Context) activity4, false);
                        }
                    }
                    if (!TextUtils.isEmpty(custProductStatus.getKYC())) {
                        FragmentActivity activity5 = getActivity();
                        if (activity5 == null) {
                            k.a();
                        }
                        net.one97.paytm.bankCommon.h.b.b((Context) activity5, custProductStatus.getKYC());
                    }
                    if (!TextUtils.isEmpty(custProductStatus.getNominee())) {
                        net.one97.paytm.bankCommon.h.b.d((Context) getActivity(), custProductStatus.getNominee());
                    }
                    if (!TextUtils.isEmpty(custProductStatus.getAadhaarRec())) {
                        FragmentActivity activity6 = getActivity();
                        if (activity6 == null) {
                            k.a();
                        }
                        net.one97.paytm.bankCommon.h.b.e((Context) activity6, custProductStatus.getAadhaarRec());
                    }
                    if (!TextUtils.isEmpty(custProductStatus.getPanRec())) {
                        FragmentActivity activity7 = getActivity();
                        if (activity7 == null) {
                            k.a();
                        }
                        net.one97.paytm.bankCommon.h.b.f(activity7, custProductStatus.getPanRec());
                    }
                    if (!TextUtils.isEmpty(custProductStatus.getForm60Rec())) {
                        FragmentActivity activity8 = getActivity();
                        if (activity8 == null) {
                            k.a();
                        }
                        net.one97.paytm.bankCommon.h.b.g(activity8, custProductStatus.getForm60Rec());
                    }
                    if (getActivity() == null || !(getActivity() instanceof e)) {
                        a((e) null);
                    } else {
                        a((e) getActivity());
                    }
                }
            }
        }
    }

    private final void a(e eVar) {
        net.one97.paytm.bankOpen.d.b.a(getActivity(), eVar);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("vertical")) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                if (k.a((Object) "kyc", arguments2.get("vertical")) && getActivity() != null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    activity.finish();
                }
            }
        }
    }

    public static final /* synthetic */ void a(h hVar) {
        HashMap hashMap = new HashMap();
        String simpleName = hVar.getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.bankOpen.a.a.a(hVar.getContext(), hVar, hVar, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (com.paytm.utility.b.c(hVar.getContext())) {
            Context context = hVar.getContext();
            Context context2 = hVar.getContext();
            hVar.a(context, context2 != null ? context2.getString(R.string.pb_please_wait) : null);
            Context context3 = hVar.getContext();
            if (context3 != null) {
                context3.getApplicationContext();
            }
            net.one97.paytm.bankCommon.g.c.a();
            net.one97.paytm.bankCommon.g.c.a(a2);
            return;
        }
        hVar.a(a2);
    }

    public static final /* synthetic */ void b(h hVar) {
        if (hVar.f16541b == null) {
            k.a("viewModel");
        }
        f.a().observe(hVar, new c(hVar));
    }

    public static final /* synthetic */ void a(h hVar, String str) {
        Intent intent = new Intent(hVar.getActivity(), ICAAccountOpeningActivity.class);
        intent.putExtra("icastatus", str);
        FragmentActivity activity = hVar.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        FragmentActivity activity2 = hVar.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16542c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

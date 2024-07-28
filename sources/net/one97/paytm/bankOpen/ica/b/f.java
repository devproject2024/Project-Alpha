package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.bankCommon.e.a;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBKYCFetchTnc;
import net.one97.paytm.bankCommon.model.PBKYCTncAccept;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.activity.ICALoanAddActivity;
import net.one97.paytm.bankOpen.ica.c.a;
import net.one97.paytm.bankOpen.ica.d.b;
import net.one97.paytm.bankOpen.ica.model.CAQuestionDetailResponse;
import net.one97.paytm.bankOpen.ica.model.ICALoanModel;
import net.one97.paytm.bankOpen.ica.model.ICAPostPaidTnc;
import net.one97.paytm.bankOpen.ica.model.Option;
import net.one97.paytm.bankOpen.ica.model.Question;
import net.one97.paytm.bankOpen.ica.view.stepview.BankStepsView;

public final class f extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16485b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final int n = 100;
    /* access modifiers changed from: private */
    public static final int o = 102;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16486c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f16487d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f16488e;

    /* renamed from: f  reason: collision with root package name */
    private b f16489f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.bankOpen.ica.d.b f16490g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f16491h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.bankCommon.f.d f16492i;
    /* access modifiers changed from: private */
    public ArrayList<PBTncData> j;
    /* access modifiers changed from: private */
    public ArrayList<PBTncData> k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    private HashMap p;

    public final View a(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.b.f$f  reason: collision with other inner class name */
    static final class C0239f<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16510a;

        C0239f(f fVar) {
            this.f16510a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
            r6 = (net.one97.paytm.bankCommon.model.PBTncData) r6.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.bankCommon.b.c r6 = (net.one97.paytm.bankCommon.b.c) r6
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                r0.e()
                if (r6 == 0) goto L_0x012e
                if (r6 == 0) goto L_0x012d
                net.one97.paytm.bankCommon.b.d r0 = r6.f16216a
                net.one97.paytm.bankCommon.b.d r1 = net.one97.paytm.bankCommon.b.d.SUCCESS
                r2 = 8
                java.lang.String r3 = "ppTncLyt"
                if (r0 != r1) goto L_0x00fb
                T r6 = r6.f16217b
                if (r6 == 0) goto L_0x00f3
                net.one97.paytm.bankOpen.ica.model.ICAPostPaidTnc r6 = (net.one97.paytm.bankOpen.ica.model.ICAPostPaidTnc) r6
                java.lang.String r0 = r6.getStatus()
                r1 = 1
                if (r0 == 0) goto L_0x0062
                java.lang.String r0 = r6.getStatus()
                java.lang.String r4 = "error"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
                if (r0 == 0) goto L_0x0062
                java.lang.String r0 = r6.getMessage()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0051
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.content.Context r0 = (android.content.Context) r0
                net.one97.paytm.bankOpen.ica.b.f r1 = r5.f16510a
                int r4 = net.one97.paytm.bankOpen.R.string.error
                java.lang.String r1 = r1.getString(r4)
                java.lang.String r6 = r6.getMessage()
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r6)
            L_0x0051:
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                int r0 = net.one97.paytm.bankOpen.R.id.ppTncLyt
                android.view.View r6 = r6.a((int) r0)
                android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
                r6.setVisibility(r2)
                return
            L_0x0062:
                java.lang.String r0 = r6.getStatus()
                if (r0 == 0) goto L_0x00f2
                java.lang.String r0 = r6.getStatus()
                java.lang.String r2 = "success"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
                if (r0 == 0) goto L_0x00f2
                java.util.ArrayList r0 = r6.getTncDataList()
                if (r0 == 0) goto L_0x00d2
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                java.util.ArrayList r6 = r6.getTncDataList()
                r0.k = r6
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                int r0 = net.one97.paytm.bankOpen.R.id.ppTncLyt
                android.view.View r6 = r6.a((int) r0)
                android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
                r0 = 0
                r6.setVisibility(r0)
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                java.util.ArrayList r6 = r6.k
                if (r6 == 0) goto L_0x00a9
                java.lang.Object r6 = r6.get(r0)
                net.one97.paytm.bankCommon.model.PBTncData r6 = (net.one97.paytm.bankCommon.model.PBTncData) r6
                if (r6 == 0) goto L_0x00a9
                java.lang.String r6 = r6.getDescription()
                goto L_0x00aa
            L_0x00a9:
                r6 = 0
            L_0x00aa:
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                int r1 = net.one97.paytm.bankOpen.R.id.pptncTv
                android.view.View r0 = r0.a((int) r1)
                com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
                java.lang.String r1 = "pptncTv"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r0.setText(r6)
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                int r0 = net.one97.paytm.bankOpen.R.id.pptncTv
                android.view.View r6 = r6.a((int) r0)
                com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
                net.one97.paytm.bankOpen.ica.b.f$f$1 r0 = new net.one97.paytm.bankOpen.ica.b.f$f$1
                r0.<init>(r5)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r6.setOnClickListener(r0)
            L_0x00d2:
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                boolean r6 = r6.m
                if (r6 == 0) goto L_0x00e5
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                r6.m = false
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                net.one97.paytm.bankOpen.ica.b.f.o(r6)
                return
            L_0x00e5:
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                boolean r6 = r6.l
                if (r6 == 0) goto L_0x00f2
                net.one97.paytm.bankOpen.ica.b.f r6 = r5.f16510a
                net.one97.paytm.bankOpen.ica.b.f.h(r6)
            L_0x00f2:
                return
            L_0x00f3:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICAPostPaidTnc"
                r6.<init>(r0)
                throw r6
            L_0x00fb:
                net.one97.paytm.bankCommon.b.d r0 = r6.f16216a
                net.one97.paytm.bankCommon.b.d r1 = net.one97.paytm.bankCommon.b.d.ERROR
                if (r0 != r1) goto L_0x012d
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                int r1 = net.one97.paytm.bankOpen.R.id.ppTncLyt
                android.view.View r0 = r0.a((int) r1)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                r0.setVisibility(r2)
                java.lang.Throwable r6 = r6.f16218c
                if (r6 == 0) goto L_0x0125
                com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
                net.one97.paytm.bankOpen.ica.b.f r0 = r5.f16510a
                android.content.Context r0 = r0.getContext()
                int r1 = r6.getStatusCode()
                net.one97.paytm.bankCommon.utils.f.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r6, (int) r1)
                goto L_0x012d
            L_0x0125:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError"
                r6.<init>(r0)
                throw r6
            L_0x012d:
                return
            L_0x012e:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.b.f.C0239f.onChanged(java.lang.Object):void");
        }
    }

    static final class g<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16512a;

        g(f fVar) {
            this.f16512a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            this.f16512a.e();
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar == null) {
            } else {
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    this.f16512a.f16491h = true;
                    T t = cVar.f16217b;
                    if (t != null) {
                        CAQuestionDetailResponse cAQuestionDetailResponse = (CAQuestionDetailResponse) t;
                        if (cAQuestionDetailResponse.getQuestionList() != null) {
                            for (Question next : cAQuestionDetailResponse.getQuestionList()) {
                                next.getOptions();
                                ArrayList arrayList = new ArrayList();
                                for (Option add : next.getOptions()) {
                                    arrayList.add(add);
                                }
                                f.a(this.f16512a, next.getText(), arrayList);
                            }
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.CAQuestionDetailResponse");
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        net.one97.paytm.bankCommon.utils.f.a(this.f16512a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16513a;

        h(f fVar) {
            this.f16513a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            PBTncData pBTncData;
            String description;
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            this.f16513a.e();
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar == null) {
            } else {
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        PBKYCFetchTnc pBKYCFetchTnc = (PBKYCFetchTnc) t;
                        if (pBKYCFetchTnc.getStatus() == null || !kotlin.m.p.a(pBKYCFetchTnc.getStatus(), "error", true)) {
                            if (pBKYCFetchTnc.getStatus() != null && kotlin.m.p.a(pBKYCFetchTnc.getStatus(), "success", true)) {
                                if (pBKYCFetchTnc.getTncDataList() != null) {
                                    this.f16513a.j = pBKYCFetchTnc.getTncDataList();
                                    LinearLayout linearLayout = (LinearLayout) this.f16513a.a(R.id.tncLyt);
                                    kotlin.g.b.k.a((Object) linearLayout, "tncLyt");
                                    linearLayout.setVisibility(0);
                                    ArrayList c2 = this.f16513a.j;
                                    if (!(c2 == null || (pBTncData = (PBTncData) c2.get(0)) == null || (description = pBTncData.getDescription()) == null)) {
                                        RoboTextView roboTextView = (RoboTextView) this.f16513a.a(R.id.tncTv);
                                        kotlin.g.b.k.a((Object) roboTextView, "tncTv");
                                        roboTextView.setText(description);
                                    }
                                    ((RoboTextView) this.f16513a.a(R.id.tncTv)).setOnClickListener(new View.OnClickListener(this) {

                                        /* renamed from: a  reason: collision with root package name */
                                        final /* synthetic */ h f16514a;

                                        {
                                            this.f16514a = r1;
                                        }

                                        public final void onClick(View view) {
                                            f.o(this.f16514a.f16513a);
                                        }
                                    });
                                }
                                if (this.f16513a.f16487d) {
                                    this.f16513a.f16487d = false;
                                    f.o(this.f16513a);
                                    return;
                                }
                                this.f16513a.m();
                            }
                        } else if (!TextUtils.isEmpty(pBKYCFetchTnc.getMessage())) {
                            com.paytm.utility.b.b((Context) this.f16513a.getActivity(), this.f16513a.getString(R.string.error), pBKYCFetchTnc.getMessage());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.model.PBKYCFetchTnc");
                    }
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        net.one97.paytm.bankCommon.utils.f.a(this.f16513a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    static final class o<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16521a;

        o(f fVar) {
            this.f16521a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            this.f16521a.e();
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar == null) {
            } else {
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        PBKYCTncAccept pBKYCTncAccept = (PBKYCTncAccept) t;
                        if (pBKYCTncAccept.getStatus() == null || !kotlin.m.p.a(pBKYCTncAccept.getStatus(), "error", true)) {
                            if (pBKYCTncAccept.getStatus() != null && kotlin.m.p.a(pBKYCTncAccept.getStatus(), "success", true) && kotlin.g.b.k.a((Object) pBKYCTncAccept.getResponseCode(), (Object) "2004")) {
                                this.f16521a.f16488e = true;
                                ((Button) this.f16521a.a(R.id.save_btn)).performClick();
                            }
                        } else if (!TextUtils.isEmpty(pBKYCTncAccept.getMessage())) {
                            com.paytm.utility.b.b((Context) this.f16521a.getActivity(), this.f16521a.getString(R.string.error), pBKYCTncAccept.getMessage());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.model.PBKYCTncAccept");
                    }
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        net.one97.paytm.bankCommon.utils.f.a(this.f16521a.getContext(), networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.bankCommon.f.d g(f fVar) {
        net.one97.paytm.bankCommon.f.d dVar = fVar.f16492i;
        if (dVar == null) {
            kotlin.g.b.k.a("fragmentActionListener");
        }
        return dVar;
    }

    public static final /* synthetic */ b l(f fVar) {
        b bVar = fVar.f16489f;
        if (bVar == null) {
            kotlin.g.b.k.a("loanAdapter");
        }
        return bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_acc_business_detail_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((BankStepsView) a(R.id.stepsViewBank)).a(R.color.gray, R.color.dark_blue, R.color.paytm_primary_color, R.color.gray);
        ((BankStepsView) a(R.id.stepsViewBank)).setSteps(4, 2);
        ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(new i(this));
        this.f16487d = false;
        this.f16486c = false;
        this.m = false;
        this.l = false;
        this.f16488e = false;
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.bankOpen.ica.d.b.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ilsViewModel::class.java)");
        this.f16490g = (net.one97.paytm.bankOpen.ica.d.b) a2;
        ((RadioGroup) a(R.id.rgLoan)).setOnCheckedChangeListener(new j(this));
        ((Button) a(R.id.save_btn)).setOnClickListener(new k(this));
        ((TextView) a(R.id.add_loan_tv)).setOnClickListener(new l(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.loanRv);
        kotlin.g.b.k.a((Object) recyclerView, "loanRv");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        k();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_2dp);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dimen_5dp);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        int c2 = androidx.core.content.b.c(context, R.color.paytm_blue_selected);
        ((RecyclerView) a(R.id.loanRv)).addItemDecoration(new net.one97.paytm.bankOpen.ica.view.a(dimensionPixelSize, dimensionPixelSize * 4, dimensionPixelSize2, c2, c2));
        j();
        l();
        a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
        ArrayList<ICALoanModel> c3 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.c() : null;
        if (c3 == null) {
            kotlin.g.b.k.a();
        }
        if (!c3.isEmpty()) {
            RadioButton radioButton = (RadioButton) a(R.id.rbYesLoan);
            kotlin.g.b.k.a((Object) radioButton, "rbYesLoan");
            radioButton.setChecked(true);
            b bVar = this.f16489f;
            if (bVar == null) {
                kotlin.g.b.k.a("loanAdapter");
            }
            kotlin.g.b.k.c(c3, "loanList");
            ArrayList<ICALoanModel> arrayList = bVar.f16494b;
            if (arrayList == null) {
                kotlin.g.b.k.a("optionList");
            }
            if (arrayList == null) {
                bVar.f16494b = new ArrayList<>();
            }
            ArrayList<ICALoanModel> arrayList2 = bVar.f16494b;
            if (arrayList2 == null) {
                kotlin.g.b.k.a("optionList");
            }
            arrayList2.addAll(c3);
            bVar.notifyDataSetChanged();
            return;
        }
        a.C0240a aVar2 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
        if (a.C0240a.a() == null) {
            kotlin.g.b.k.a();
        }
        if (!net.one97.paytm.bankOpen.ica.c.a.f()) {
            RadioButton radioButton2 = (RadioButton) a(R.id.rbNoLoan);
            kotlin.g.b.k.a((Object) radioButton2, "rbNoLoan");
            radioButton2.setChecked(true);
            return;
        }
        RadioButton radioButton3 = (RadioButton) a(R.id.rbYesLoan);
        kotlin.g.b.k.a((Object) radioButton3, "rbYesLoan");
        radioButton3.setChecked(true);
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16515a;

        i(f fVar) {
            this.f16515a = fVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16515a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class j implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16516a;

        j(f fVar) {
            this.f16516a = fVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            RadioButton radioButton = (RadioButton) this.f16516a.a(R.id.rbYesLoan);
            kotlin.g.b.k.a((Object) radioButton, "rbYesLoan");
            if (i2 == radioButton.getId()) {
                TextView textView = (TextView) this.f16516a.a(R.id.add_loan_tv);
                kotlin.g.b.k.a((Object) textView, "add_loan_tv");
                textView.setVisibility(0);
                RecyclerView recyclerView = (RecyclerView) this.f16516a.a(R.id.loanRv);
                kotlin.g.b.k.a((Object) recyclerView, "loanRv");
                recyclerView.setVisibility(0);
                a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() != null) {
                    net.one97.paytm.bankOpen.ica.c.a.a(true);
                }
                this.f16516a.i();
                return;
            }
            RadioButton radioButton2 = (RadioButton) this.f16516a.a(R.id.rbNoLoan);
            kotlin.g.b.k.a((Object) radioButton2, "rbNoLoan");
            if (i2 == radioButton2.getId()) {
                TextView textView2 = (TextView) this.f16516a.a(R.id.add_loan_tv);
                kotlin.g.b.k.a((Object) textView2, "add_loan_tv");
                textView2.setVisibility(8);
                RecyclerView recyclerView2 = (RecyclerView) this.f16516a.a(R.id.loanRv);
                kotlin.g.b.k.a((Object) recyclerView2, "loanRv");
                recyclerView2.setVisibility(8);
                a.C0240a aVar2 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() != null) {
                    net.one97.paytm.bankOpen.ica.c.a.a(false);
                }
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16517a;

        k(f fVar) {
            this.f16517a = fVar;
        }

        public final void onClick(View view) {
            if (!f.b(this.f16517a)) {
                return;
            }
            if (this.f16517a.j == null) {
                this.f16517a.l();
            } else if (this.f16517a.k == null) {
                this.f16517a.m();
            } else if (!this.f16517a.f16488e) {
                f.h(this.f16517a);
            } else if (f.g(this.f16517a) != null) {
                f.g(this.f16517a).onFragmentAction(107, (Object) null);
            }
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16518a;

        l(f fVar) {
            this.f16518a = fVar;
        }

        public final void onClick(View view) {
            a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() == null) {
                return;
            }
            if (net.one97.paytm.bankOpen.ica.c.a.c().size() >= 10) {
                com.paytm.utility.b.a((Context) this.f16518a.getActivity(), this.f16518a.getString(R.string.pb_ca_please_accept_tnc));
            } else {
                f.a(this.f16518a, (ICALoanModel) null, -1);
            }
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.bankCommon.f.d) {
            this.f16492i = (net.one97.paytm.bankCommon.f.d) context;
        }
    }

    private void a(String str, ArrayList<Option> arrayList, String str2) {
        kotlin.g.b.k.c(str, "question");
        kotlin.g.b.k.c(arrayList, "options");
        x.e eVar = new x.e();
        eVar.element = getLayoutInflater().inflate(R.layout.pb_ca_question_spinner_layout, (ViewGroup) null);
        x.e eVar2 = new x.e();
        T findViewById = ((View) eVar.element).findViewById(R.id.question_et);
        if (findViewById != null) {
            eVar2.element = (EditText) findViewById;
            View findViewById2 = ((View) eVar.element).findViewById(R.id.question_title);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setText(str);
                View view = (View) eVar.element;
                kotlin.g.b.k.a((Object) view, "view");
                view.setTag(1);
                CharSequence charSequence = str2;
                if (!TextUtils.isEmpty(charSequence)) {
                    ((EditText) eVar2.element).setText(charSequence);
                } else {
                    ((EditText) eVar2.element).setText(getString(R.string.pb_ca_select_any));
                }
                x.e eVar3 = eVar2;
                x.e eVar4 = eVar;
                String str3 = str;
                ArrayList<Option> arrayList2 = arrayList;
                ((View) eVar.element).setOnClickListener(new d(this, eVar3, eVar4, str3, arrayList2));
                ((EditText) eVar2.element).setOnClickListener(new e(this, eVar3, eVar4, str3, arrayList2));
                ((LinearLayout) a(R.id.questionLayout)).addView((View) eVar.element);
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.EditText");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f16501b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f16502c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f16503d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f16504e;

        d(f fVar, x.e eVar, x.e eVar2, String str, ArrayList arrayList) {
            this.f16500a = fVar;
            this.f16501b = eVar;
            this.f16502c = eVar2;
            this.f16503d = str;
            this.f16504e = arrayList;
        }

        public final void onClick(View view) {
            View view2 = (View) this.f16502c.element;
            kotlin.g.b.k.a((Object) view2, "view");
            TextView textView = (TextView) view2.findViewById(R.id.error_tv);
            kotlin.g.b.k.a((Object) textView, "view.error_tv");
            f.a(this.f16500a, (EditText) this.f16501b.element, textView, this.f16503d, this.f16504e);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f16506b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f16507c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f16508d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f16509e;

        e(f fVar, x.e eVar, x.e eVar2, String str, ArrayList arrayList) {
            this.f16505a = fVar;
            this.f16506b = eVar;
            this.f16507c = eVar2;
            this.f16508d = str;
            this.f16509e = arrayList;
        }

        public final void onClick(View view) {
            View view2 = (View) this.f16507c.element;
            kotlin.g.b.k.a((Object) view2, "view");
            TextView textView = (TextView) view2.findViewById(R.id.error_tv);
            kotlin.g.b.k.a((Object) textView, "view.error_tv");
            f.a(this.f16505a, (EditText) this.f16506b.element, textView, this.f16508d, this.f16509e);
        }
    }

    public static final class q implements net.one97.paytm.bankCommon.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f16526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f16527b;

        q(EditText editText, TextView textView) {
            this.f16526a = editText;
            this.f16527b = textView;
        }

        public final void onFragmentAction(int i2, Object obj) {
            if (obj != null) {
                kotlin.o oVar = (kotlin.o) obj;
                this.f16526a.setText(((Option) oVar.getSecond()).getText());
                this.f16527b.setText("");
                this.f16527b.setVisibility(8);
                a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() != null) {
                    net.one97.paytm.bankOpen.ica.c.a.a((String) oVar.getFirst(), (Option) oVar.getSecond());
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Pair<kotlin.String, net.one97.paytm.bankOpen.ica.model.Option>");
        }
    }

    public final void onDestroy() {
        e();
        super.onDestroy();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 100 && i3 == -1) {
            Integer.valueOf(-1);
            ArrayList<ICALoanModel> arrayList = null;
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("loan_position", -1)) : null;
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("loan") : null;
            if (serializableExtra != null) {
                ICALoanModel iCALoanModel = (ICALoanModel) serializableExtra;
                k();
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.intValue() >= 0) {
                    a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                    if (a.C0240a.a() != null) {
                        net.one97.paytm.bankOpen.ica.c.a.a(valueOf.intValue(), iCALoanModel);
                    }
                } else {
                    a.C0240a aVar2 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                    if (a.C0240a.a() != null) {
                        Serializable serializableExtra2 = intent.getSerializableExtra("loan");
                        if (serializableExtra2 != null) {
                            net.one97.paytm.bankOpen.ica.c.a.a((ICALoanModel) serializableExtra2);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICALoanModel");
                        }
                    }
                }
                b bVar = this.f16489f;
                if (bVar == null) {
                    kotlin.g.b.k.a("loanAdapter");
                }
                a.C0240a aVar3 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() != null) {
                    arrayList = net.one97.paytm.bankOpen.ica.c.a.c();
                }
                if (arrayList == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.c(arrayList, "options");
                ArrayList<ICALoanModel> arrayList2 = bVar.f16494b;
                if (arrayList2 == null) {
                    kotlin.g.b.k.a("optionList");
                }
                arrayList2.clear();
                ArrayList<ICALoanModel> arrayList3 = bVar.f16494b;
                if (arrayList3 == null) {
                    kotlin.g.b.k.a("optionList");
                }
                arrayList3.addAll(arrayList);
                bVar.notifyDataSetChanged();
                i();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICALoanModel");
        }
    }

    /* access modifiers changed from: private */
    public final void i() {
        a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
        if (a.C0240a.a() == null) {
            return;
        }
        if (net.one97.paytm.bankOpen.ica.c.a.c().size() > 0) {
            ((TextView) a(R.id.add_loan_tv)).setText(R.string.pb_ca_add_another_loan);
        } else {
            ((TextView) a(R.id.add_loan_tv)).setText(R.string.pb_ca_add_loan);
        }
    }

    private final void j() {
        d();
        if (this.f16490g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.bankOpen.ica.d.b.a().observe(getViewLifecycleOwner(), new g(this));
    }

    public static final class p implements net.one97.paytm.bankCommon.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16522a;

        p(f fVar) {
            this.f16522a = fVar;
        }

        public final void onFragmentAction(int i2, Object obj) {
            androidx.fragment.app.j supportFragmentManager;
            a aVar = f.f16485b;
            if (i2 == f.n) {
                x.e eVar = new x.e();
                if (obj != null) {
                    eVar.element = (kotlin.o) obj;
                    x.e eVar2 = new x.e();
                    eVar2.element = new b();
                    Bundle bundle = new Bundle();
                    bundle.putString("first_btn_txt", this.f16522a.getString(R.string.pb_ca_yes_del));
                    bundle.putString("second_btn_txt", this.f16522a.getString(R.string.cancel));
                    bundle.putString("title", this.f16522a.getString(R.string.pb_ca_are_you_confirm_loan_del));
                    ((b) eVar2.element).setArguments(bundle);
                    net.one97.paytm.bankCommon.f.d aVar2 = new a(this, eVar, eVar2);
                    kotlin.g.b.k.c(aVar2, "listener");
                    ((b) eVar2.element).f16478a = aVar2;
                    FragmentActivity activity = this.f16522a.getActivity();
                    if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                        ((b) eVar2.element).show(supportFragmentManager, "deletedialog");
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Pair<kotlin.Int, net.one97.paytm.bankOpen.ica.model.ICALoanModel>");
            }
            a aVar3 = f.f16485b;
            if (i2 != f.o) {
                return;
            }
            if (obj != null) {
                kotlin.o oVar = (kotlin.o) obj;
                f.a(this.f16522a, (ICALoanModel) oVar.getSecond(), ((Number) oVar.getFirst()).intValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Pair<kotlin.Int, net.one97.paytm.bankOpen.ica.model.ICALoanModel>");
        }

        public static final class a implements net.one97.paytm.bankCommon.f.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ p f16523a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.e f16524b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.e f16525c;

            a(p pVar, x.e eVar, x.e eVar2) {
                this.f16523a = pVar;
                this.f16524b = eVar;
                this.f16525c = eVar2;
            }

            public final void onFragmentAction(int i2, Object obj) {
                if (i2 == 103) {
                    a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                    if (a.C0240a.a() != null) {
                        net.one97.paytm.bankOpen.ica.c.a.a(((Number) ((kotlin.o) this.f16524b.element).getFirst()).intValue());
                    }
                    b l = f.l(this.f16523a.f16522a);
                    int intValue = ((Number) ((kotlin.o) this.f16524b.element).getFirst()).intValue();
                    ArrayList<ICALoanModel> arrayList = l.f16494b;
                    if (arrayList == null) {
                        kotlin.g.b.k.a("optionList");
                    }
                    arrayList.remove(intValue);
                    l.notifyItemRemoved(intValue);
                    this.f16523a.f16522a.i();
                    com.paytm.utility.b.a((Context) this.f16523a.f16522a.getActivity(), this.f16523a.f16522a.getString(R.string.pb_ca_loan_deleted));
                } else if (i2 == 104) {
                    ((b) this.f16525c.element).dismiss();
                }
            }
        }
    }

    private final void k() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f16489f = new b(activity, new p(this));
            RecyclerView recyclerView = (RecyclerView) a(R.id.loanRv);
            kotlin.g.b.k.a((Object) recyclerView, "loanRv");
            b bVar = this.f16489f;
            if (bVar == null) {
                kotlin.g.b.k.a("loanAdapter");
            }
            recyclerView.setAdapter(bVar);
            return;
        }
        throw new u("null cannot be cast to non-null type android.content.Context");
    }

    public static final class c extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            kotlin.g.b.k.c(view, "itemView");
        }
    }

    public static final class b extends RecyclerView.a<c> {

        /* renamed from: a  reason: collision with root package name */
        public Context f16493a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<ICALoanModel> f16494b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public net.one97.paytm.bankCommon.f.d f16495c;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            c cVar = (c) vVar;
            kotlin.g.b.k.c(cVar, "holder");
            ArrayList<ICALoanModel> arrayList = this.f16494b;
            if (arrayList == null) {
                kotlin.g.b.k.a("optionList");
            }
            ICALoanModel iCALoanModel = arrayList.get(i2);
            kotlin.g.b.k.a((Object) iCALoanModel, "optionList.get(position)");
            ICALoanModel iCALoanModel2 = iCALoanModel;
            View view = cVar.itemView;
            kotlin.g.b.k.a((Object) view, "holder.itemView");
            TextView textView = (TextView) view.findViewById(R.id.loan_title_tv);
            kotlin.g.b.k.a((Object) textView, "holder.itemView.loan_title_tv");
            textView.setText(iCALoanModel2.getBankName() + StringUtility.NEW_LINE + iCALoanModel2.getTypeOfLoan());
            StringBuilder sb = new StringBuilder();
            Context context = this.f16493a;
            if (context == null) {
                kotlin.g.b.k.a("context");
            }
            sb.append(context.getString(R.string.pb_ca_current_outstanding_principal));
            sb.append("- ");
            Context context2 = this.f16493a;
            if (context2 == null) {
                kotlin.g.b.k.a("context");
            }
            sb.append(context2.getString(R.string.si_rupee));
            View view2 = cVar.itemView;
            kotlin.g.b.k.a((Object) view2, "holder.itemView");
            TextView textView2 = (TextView) view2.findViewById(R.id.cop_tv);
            kotlin.g.b.k.a((Object) textView2, "holder.itemView.cop_tv");
            textView2.setText(sb.toString() + net.one97.paytm.bankCommon.mapping.a.ac(iCALoanModel2.getCurrentPrincipalOutstanding()));
            StringBuilder sb2 = new StringBuilder();
            Context context3 = this.f16493a;
            if (context3 == null) {
                kotlin.g.b.k.a("context");
            }
            sb2.append(context3.getString(R.string.pb_ca_loan_amt_sanction));
            sb2.append("- ");
            Context context4 = this.f16493a;
            if (context4 == null) {
                kotlin.g.b.k.a("context");
            }
            sb2.append(context4.getString(R.string.si_rupee));
            View view3 = cVar.itemView;
            kotlin.g.b.k.a((Object) view3, "holder.itemView");
            TextView textView3 = (TextView) view3.findViewById(R.id.loan_amt_tv);
            kotlin.g.b.k.a((Object) textView3, "holder.itemView.loan_amt_tv");
            textView3.setText(sb2.toString() + net.one97.paytm.bankCommon.mapping.a.ac(iCALoanModel2.getLoanAmount()));
            View view4 = cVar.itemView;
            kotlin.g.b.k.a((Object) view4, "holder.itemView");
            TextView textView4 = (TextView) view4.findViewById(R.id.account_num_tv);
            kotlin.g.b.k.a((Object) textView4, "holder.itemView.account_num_tv");
            StringBuilder sb3 = new StringBuilder();
            Context context5 = this.f16493a;
            if (context5 == null) {
                kotlin.g.b.k.a("context");
            }
            sb3.append(context5.getString(R.string.pb_ca_acc_no_loan_item));
            sb3.append(AppConstants.COLON);
            sb3.append(iCALoanModel2.getAccountNumber());
            textView4.setText(sb3.toString());
            View view5 = cVar.itemView;
            kotlin.g.b.k.a((Object) view5, "holder.itemView");
            TextView textView5 = (TextView) view5.findViewById(R.id.ifsc_tv);
            kotlin.g.b.k.a((Object) textView5, "holder.itemView.ifsc_tv");
            StringBuilder sb4 = new StringBuilder();
            Context context6 = this.f16493a;
            if (context6 == null) {
                kotlin.g.b.k.a("context");
            }
            sb4.append(context6.getString(R.string.si_ifsc));
            sb4.append(AppConstants.COLON);
            sb4.append(iCALoanModel2.getIfscCode());
            textView5.setText(sb4.toString());
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            kotlin.g.b.k.c(viewGroup, "parent");
            Context context = this.f16493a;
            if (context == null) {
                kotlin.g.b.k.a("context");
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.pb_ca_loan_list_item, viewGroup, false);
            x.e eVar = new x.e();
            kotlin.g.b.k.a((Object) inflate, "view");
            eVar.element = new c(inflate);
            View view = ((c) eVar.element).itemView;
            kotlin.g.b.k.a((Object) view, "holder.itemView");
            ((AppCompatImageView) view.findViewById(R.id.edit_iv)).setOnClickListener(new a(this, eVar));
            View view2 = ((c) eVar.element).itemView;
            kotlin.g.b.k.a((Object) view2, "holder.itemView");
            ((AppCompatImageView) view2.findViewById(R.id.delete_iv)).setOnClickListener(new C0238b(this, eVar));
            return (c) eVar.element;
        }

        public final ArrayList<ICALoanModel> a() {
            ArrayList<ICALoanModel> arrayList = this.f16494b;
            if (arrayList == null) {
                kotlin.g.b.k.a("optionList");
            }
            return arrayList;
        }

        public final net.one97.paytm.bankCommon.f.d b() {
            net.one97.paytm.bankCommon.f.d dVar = this.f16495c;
            if (dVar == null) {
                kotlin.g.b.k.a("fragmentActionListener");
            }
            return dVar;
        }

        public b(Context context, net.one97.paytm.bankCommon.f.d dVar) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(dVar, "fa");
            this.f16493a = context;
            this.f16495c = dVar;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f16496a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.e f16497b;

            a(b bVar, x.e eVar) {
                this.f16496a = bVar;
                this.f16497b = eVar;
            }

            public final void onClick(View view) {
                kotlin.o oVar = new kotlin.o(Integer.valueOf(((c) this.f16497b.element).getAdapterPosition()), this.f16496a.a().get(((c) this.f16497b.element).getAdapterPosition()));
                net.one97.paytm.bankCommon.f.d b2 = this.f16496a.b();
                a aVar = f.f16485b;
                b2.onFragmentAction(f.o, oVar);
            }
        }

        /* renamed from: net.one97.paytm.bankOpen.ica.b.f$b$b  reason: collision with other inner class name */
        static final class C0238b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f16498a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.e f16499b;

            C0238b(b bVar, x.e eVar) {
                this.f16498a = bVar;
                this.f16499b = eVar;
            }

            public final void onClick(View view) {
                kotlin.o oVar = new kotlin.o(Integer.valueOf(((c) this.f16499b.element).getAdapterPosition()), this.f16498a.a().get(((c) this.f16499b.element).getAdapterPosition()));
                net.one97.paytm.bankCommon.f.d b2 = this.f16498a.b();
                a aVar = f.f16485b;
                b2.onFragmentAction(f.n, oVar);
            }
        }

        public final int getItemCount() {
            ArrayList<ICALoanModel> arrayList = this.f16494b;
            if (arrayList == null) {
                kotlin.g.b.k.a("optionList");
            }
            return arrayList.size();
        }
    }

    static final class n implements a.C0225a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16520a;

        n(f fVar) {
            this.f16520a = fVar;
        }

        public final void a() {
            CheckBox checkBox = (CheckBox) this.f16520a.a(R.id.tncChkbox);
            kotlin.g.b.k.a((Object) checkBox, "tncChkbox");
            checkBox.setChecked(true);
        }
    }

    static final class m implements a.C0225a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f16519a;

        m(f fVar) {
            this.f16519a = fVar;
        }

        public final void a() {
            this.f16519a.l = true;
            CheckBox checkBox = (CheckBox) this.f16519a.a(R.id.pptncChkbox);
            kotlin.g.b.k.a((Object) checkBox, "pptncChkbox");
            checkBox.setChecked(true);
        }
    }

    /* access modifiers changed from: private */
    public final void l() {
        d();
        net.one97.paytm.bankOpen.ica.d.b bVar = this.f16490g;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        bVar.b().observe(getViewLifecycleOwner(), new h(this));
    }

    /* access modifiers changed from: private */
    public final void m() {
        if (this.k != null) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ppTncLyt);
            kotlin.g.b.k.a((Object) linearLayout, "ppTncLyt");
            linearLayout.setVisibility(0);
            return;
        }
        d();
        net.one97.paytm.bankOpen.ica.d.b bVar = this.f16490g;
        if (bVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        g.b aVar2 = new b.a(bVar);
        g.a bVar2 = new b.C0242b(bVar);
        kotlin.g.b.k.c(aVar2, "responseListener");
        kotlin.g.b.k.c(bVar2, "errorListener");
        kotlin.g.b.k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String E = net.one97.paytm.bankCommon.utils.d.E();
        if (URLUtil.isValidUrl(E)) {
            net.one97.paytm.bankOpen.c a2 = net.one97.paytm.bankOpen.f.a();
            kotlin.g.b.k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
            Context applicationContext = a2.getApplicationContext();
            String e2 = com.paytm.utility.b.e(applicationContext, E);
            Map<String, String> e3 = net.one97.paytm.bankCommon.mapping.d.e(applicationContext);
            HashMap hashMap = new HashMap();
            String simpleName = aVar.getClass().getSimpleName();
            kotlin.g.b.k.a((Object) simpleName, "javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            ICAPostPaidTnc iCAPostPaidTnc = new ICAPostPaidTnc();
            if (com.paytm.utility.b.c(applicationContext)) {
                kotlin.g.b.k.a((Object) applicationContext, "mContext");
                applicationContext.getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.a(e2, aVar2, bVar2, iCAPostPaidTnc, e3, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap));
            } else {
                bVar2.onErrorResponse(-1, iCAPostPaidTnc, new NetworkCustomError());
            }
        }
        bVar.f16591b.observe(getViewLifecycleOwner(), new C0239f(this));
    }

    public static final /* synthetic */ boolean b(f fVar) {
        ArrayList<ICALoanModel> c2;
        if (!fVar.f16491h) {
            fVar.j();
            return false;
        }
        LinearLayout linearLayout = (LinearLayout) fVar.a(R.id.questionLayout);
        kotlin.g.b.k.a((Object) linearLayout, "questionLayout");
        if (linearLayout.getChildCount() > 0) {
            LinearLayout linearLayout2 = (LinearLayout) fVar.a(R.id.questionLayout);
            kotlin.g.b.k.a((Object) linearLayout2, "questionLayout");
            int childCount = linearLayout2.getChildCount() - 1;
            if (childCount >= 0) {
                int i2 = 0;
                while (true) {
                    View childAt = ((LinearLayout) fVar.a(R.id.questionLayout)).getChildAt(i2);
                    kotlin.g.b.k.a((Object) childAt, "view");
                    if (Integer.parseInt(childAt.getTag().toString()) == 1) {
                        View findViewById = childAt.findViewById(R.id.question_et);
                        if (findViewById == null) {
                            throw new u("null cannot be cast to non-null type android.widget.EditText");
                        } else if (kotlin.m.p.a(((EditText) findViewById).getText().toString(), fVar.getString(R.string.pb_ca_select_any), true)) {
                            View findViewById2 = childAt.findViewById(R.id.question_title);
                            if (findViewById2 != null) {
                                TextView textView = (TextView) childAt.findViewById(R.id.error_tv);
                                kotlin.g.b.k.a((Object) textView, "view.error_tv");
                                textView.setText(fVar.getString(R.string.pb_ca_please_fill) + " " + ((TextView) findViewById2).getText());
                                TextView textView2 = (TextView) childAt.findViewById(R.id.error_tv);
                                kotlin.g.b.k.a((Object) textView2, "view.error_tv");
                                textView2.setVisibility(0);
                                return false;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    }
                    if (i2 == childCount) {
                        break;
                    }
                    i2++;
                }
            }
        }
        RadioButton radioButton = (RadioButton) fVar.a(R.id.rbYesLoan);
        kotlin.g.b.k.a((Object) radioButton, "rbYesLoan");
        if (radioButton.isChecked()) {
            a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (!(a.C0240a.a() == null || (c2 = net.one97.paytm.bankOpen.ica.c.a.c()) == null || c2.size() != 0)) {
                com.paytm.utility.b.a((Context) fVar.getActivity(), fVar.getString(R.string.pb_ca_please_enter_loan));
                return false;
            }
        }
        CheckBox checkBox = (CheckBox) fVar.a(R.id.tncChkbox);
        kotlin.g.b.k.a((Object) checkBox, "tncChkbox");
        if (!checkBox.isChecked()) {
            LinearLayout linearLayout3 = (LinearLayout) fVar.a(R.id.tncLyt);
            kotlin.g.b.k.a((Object) linearLayout3, "tncLyt");
            if (linearLayout3.getVisibility() == 0) {
                com.paytm.utility.b.a((Context) fVar.getActivity(), fVar.getString(R.string.pb_ca_please_accept_tnc));
                return false;
            }
        }
        LinearLayout linearLayout4 = (LinearLayout) fVar.a(R.id.tncLyt);
        kotlin.g.b.k.a((Object) linearLayout4, "tncLyt");
        if (linearLayout4.getVisibility() == 8) {
            fVar.l();
            return false;
        }
        CheckBox checkBox2 = (CheckBox) fVar.a(R.id.pptncChkbox);
        kotlin.g.b.k.a((Object) checkBox2, "pptncChkbox");
        if (!checkBox2.isChecked()) {
            LinearLayout linearLayout5 = (LinearLayout) fVar.a(R.id.ppTncLyt);
            kotlin.g.b.k.a((Object) linearLayout5, "ppTncLyt");
            if (linearLayout5.getVisibility() == 0) {
                com.paytm.utility.b.a((Context) fVar.getActivity(), fVar.getString(R.string.pb_ca_please_accept_tnc));
                return false;
            }
        }
        LinearLayout linearLayout6 = (LinearLayout) fVar.a(R.id.ppTncLyt);
        kotlin.g.b.k.a((Object) linearLayout6, "ppTncLyt");
        if (linearLayout6.getVisibility() != 8) {
            return true;
        }
        fVar.m();
        return false;
    }

    public static final /* synthetic */ void h(f fVar) {
        fVar.d();
        if (fVar.f16490g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        ArrayList<PBTncData> arrayList = fVar.j;
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        ArrayList<PBTncData> arrayList2 = fVar.k;
        if (arrayList2 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.bankOpen.ica.d.b.a(arrayList, arrayList2).observe(fVar.getViewLifecycleOwner(), new o(fVar));
    }

    public static final /* synthetic */ void a(f fVar, ICALoanModel iCALoanModel, int i2) {
        Intent intent = new Intent(fVar.getActivity(), ICALoanAddActivity.class);
        if (iCALoanModel != null) {
            intent.putExtra("loan", iCALoanModel);
            intent.putExtra("loan_position", i2);
        }
        fVar.startActivityForResult(intent, 100);
    }

    public static final /* synthetic */ void a(f fVar, EditText editText, TextView textView, String str, ArrayList arrayList) {
        androidx.fragment.app.j supportFragmentManager;
        a aVar = new a();
        net.one97.paytm.bankCommon.f.d qVar = new q(editText, textView);
        kotlin.g.b.k.c(qVar, "buttonListener");
        aVar.f16457a = qVar;
        kotlin.g.b.k.c(str, "questionText");
        kotlin.g.b.k.c(arrayList, "answerList");
        aVar.f16458b = str;
        aVar.f16459c = arrayList;
        FragmentActivity activity = fVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            aVar.show(supportFragmentManager, "answerbottomsheet");
        }
    }

    public static final /* synthetic */ void a(f fVar, String str, ArrayList arrayList) {
        a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
        Option a2 = a.C0240a.a() != null ? net.one97.paytm.bankOpen.ica.c.a.a(str) : null;
        if (a2 == null) {
            fVar.a(str, (ArrayList<Option>) arrayList, (String) null);
        } else {
            fVar.a(str, (ArrayList<Option>) arrayList, a2.getText());
        }
    }

    public static final /* synthetic */ void o(f fVar) {
        ArrayList<PBTncData> arrayList = fVar.j;
        if (arrayList != null) {
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (arrayList.size() > 0) {
                net.one97.paytm.bankCommon.e.a a2 = net.one97.paytm.bankCommon.e.a.a(fVar.j);
                a2.a((a.C0225a) new n(fVar));
                FragmentActivity activity = fVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                a2.show(activity.getSupportFragmentManager(), "KycTNCFragment");
            }
        }
    }

    public static final /* synthetic */ void r(f fVar) {
        ArrayList<PBTncData> arrayList = fVar.k;
        if (arrayList != null) {
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (arrayList.size() > 0) {
                net.one97.paytm.bankCommon.e.a a2 = net.one97.paytm.bankCommon.e.a.a(fVar.k);
                a2.a((a.C0225a) new m(fVar));
                FragmentActivity activity = fVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                a2.show(activity.getSupportFragmentManager(), "KycTNCFragment");
            }
        }
    }
}

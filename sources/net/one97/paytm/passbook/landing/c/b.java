package net.one97.paytm.passbook.landing.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.PaymentHistoryPagination;
import net.one97.paytm.passbook.beans.PaymentHistoryResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.landing.a.a;
import net.one97.paytm.passbook.landing.g.c;
import net.one97.paytm.passbook.mapping.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends h implements View.OnClickListener, a.c, net.one97.paytm.passbook.landing.d.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.landing.a.a f57604a;

    /* renamed from: b  reason: collision with root package name */
    public int f57605b = 1;

    /* renamed from: c  reason: collision with root package name */
    public String f57606c;

    /* renamed from: d  reason: collision with root package name */
    private c f57607d;

    /* renamed from: e  reason: collision with root package name */
    private PaymentHistoryResponse f57608e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.passbook.landing.f.c f57609f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f57610g;

    public final View a(int i2) {
        if (this.f57610g == null) {
            this.f57610g = new HashMap();
        }
        View view = (View) this.f57610g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57610g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<f<? extends PaymentHistoryResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57611a;

        a(b bVar) {
            this.f57611a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            b bVar = this.f57611a;
            k.a((Object) fVar, "it");
            b.a(bVar, fVar);
        }
    }

    public final net.one97.paytm.passbook.landing.a.a b() {
        net.one97.paytm.passbook.landing.a.a aVar = this.f57604a;
        if (aVar == null) {
            k.a("adapter");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_payment_history_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f57609f = new net.one97.paytm.passbook.landing.f.c(this);
        ai a2 = am.a((Fragment) this).a(c.class);
        k.a((Object) a2, "ViewModelProviders.of(th…oryViewModel::class.java)");
        this.f57607d = (c) a2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f57604a = new net.one97.paytm.passbook.landing.a.a(this, this);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView, "rvPassbookEntries");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView2, "rvPassbookEntries");
        net.one97.paytm.passbook.landing.a.a aVar = this.f57604a;
        if (aVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(aVar);
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rvPassbookEntries);
        net.one97.paytm.passbook.landing.a.a aVar2 = this.f57604a;
        if (aVar2 == null) {
            k.a("adapter");
        }
        recyclerView3.addItemDecoration(new net.one97.paytm.passbook.search.b.a(aVar2));
        c();
        c cVar = this.f57607d;
        if (cVar == null) {
            k.a("paymentHistoryViewModel");
        }
        cVar.f57758a.observe(this, new a(this));
        ((TextView) a(R.id.btnRetry)).setOnClickListener(this);
        net.one97.paytm.passbook.landing.f.c cVar2 = this.f57609f;
        if (cVar2 == null) {
            k.a("mUIHandler");
        }
        if (!d.b().a("passUTHFiltersEnabled", false)) {
            View a3 = cVar2.f57735a.a(R.id.paymentHistoryHeader);
            k.a((Object) a3, "mPaymentHistoryFragment.paymentHistoryHeader");
            AppCompatImageView appCompatImageView = (AppCompatImageView) a3.findViewById(R.id.ivPaymentHistoryFilter);
            k.a((Object) appCompatImageView, "mPaymentHistoryFragment.…er.ivPaymentHistoryFilter");
            appCompatImageView.setVisibility(8);
        }
    }

    /* renamed from: net.one97.paytm.passbook.landing.c.b$b  reason: collision with other inner class name */
    public static final class C1090b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57612a;

        C1090b(b bVar) {
            this.f57612a = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f57612a.c();
        }
    }

    private static JSONObject a(byte[] bArr) {
        try {
            return new JSONObject(new String(bArr, kotlin.m.d.f47971a));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void a() {
        if (this.f57608e != null) {
            PaymentHistoryResponse paymentHistoryResponse = this.f57608e;
            if (paymentHistoryResponse == null) {
                k.a("paymentHistoryResponse");
            }
            PaymentHistoryPagination paginationParams = paymentHistoryResponse.getPaginationParams();
            if (paginationParams != null) {
                a(paginationParams.getTransactionDateEpoch(), this.f57605b, paginationParams.getPageTxnId(), paginationParams.getPaginationStreamSource());
            }
        }
    }

    private final void a(String str, int i2, String str2, String str3) {
        Context context = getContext();
        if (context != null) {
            k.a((Object) context, "it");
            if (net.one97.paytm.passbook.utility.f.a(context)) {
                c cVar = this.f57607d;
                if (cVar == null) {
                    k.a("paymentHistoryViewModel");
                }
                cVar.a(str, i2, str2, str3, this.f57606c);
                a(true);
            }
        }
    }

    private static void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    private final void a(boolean z) {
        if (this.f57605b <= 1) {
            net.one97.paytm.passbook.landing.f.c cVar = this.f57609f;
            if (cVar == null) {
                k.a("mUIHandler");
            }
            cVar.a(z, (ShimmerFrameLayout) a(R.id.paymentHistoryShimmerLayout));
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderBottom);
        k.a((Object) lottieAnimationView, "loaderBottom");
        a(lottieAnimationView, z);
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.btnRetry) {
            View a2 = a(R.id.ilDataFetchError);
            k.a((Object) a2, "ilDataFetchError");
            a2.setVisibility(8);
            c();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            c();
        }
    }

    public final void c() {
        int i2 = this.f57605b;
        if (i2 <= 1) {
            a((String) null, i2, (String) null, (String) null);
        } else {
            a();
        }
    }

    public final void d() {
        this.f57605b = 1;
        if (this.f57609f == null) {
            k.a("mUIHandler");
        }
        net.one97.paytm.passbook.landing.a.a aVar = this.f57604a;
        if (aVar == null) {
            k.a("adapter");
        }
        int i2 = aVar.f57545d;
        this.f57606c = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : "cashback" : "add_money" : "money_received" : "money_sent";
        net.one97.paytm.passbook.landing.a.a aVar2 = this.f57604a;
        if (aVar2 == null) {
            k.a("adapter");
        }
        aVar2.f57544c = "";
        aVar2.f57543b.clear();
        aVar2.notifyDataSetChanged();
        a((String) null, this.f57605b, (String) null, (String) null);
        a(true);
        View a2 = a(R.id.ilDataFetchError);
        k.a((Object) a2, "ilDataFetchError");
        a2.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.paytm.network.model.NetworkCustomError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: com.paytm.network.model.NetworkCustomError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: com.paytm.network.model.NetworkCustomError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v24, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r13v6, types: [net.one97.paytm.passbook.beans.PaymentHistoryRootHeader, net.one97.paytm.passbook.beans.PaymentHistoryTransactionHeader] */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.passbook.landing.c.b r16, net.one97.paytm.passbook.mapping.a.f r17) {
        /*
            r0 = r16
            r1 = r17
            r2 = 0
            r0.a((boolean) r2)
            net.one97.paytm.passbook.mapping.a.j r3 = r1.f57886a
            net.one97.paytm.passbook.mapping.a.j r4 = net.one97.paytm.passbook.mapping.a.j.SUCCESS
            java.lang.String r5 = "rvPassbookEntries"
            java.lang.String r6 = "mUIHandler"
            java.lang.String r8 = "adapter"
            java.lang.String r9 = "ilDataFetchError"
            r10 = 1
            if (r3 != r4) goto L_0x037d
            T r3 = r1.f57887b
            net.one97.paytm.passbook.beans.PaymentHistoryResponse r3 = (net.one97.paytm.passbook.beans.PaymentHistoryResponse) r3
            if (r3 == 0) goto L_0x0377
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r4 = r0.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            r12 = 8
            r4.setVisibility(r12)
            java.lang.String r4 = r3.getStatus()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0298
            java.lang.String r4 = r3.getStatus()
            java.lang.String r13 = "failure"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r13, (boolean) r10)
            if (r4 == 0) goto L_0x0298
            java.lang.String r4 = r3.getResponseCode()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0298
            java.lang.String r4 = r3.getMessage()
            r13 = r4
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0062
            int r4 = net.one97.paytm.passbook.R.string.pass_payment_history_list_default_failure_msg
            java.lang.String r4 = r0.getString(r4)
        L_0x0062:
            net.one97.paytm.passbook.landing.f.c r13 = r0.f57609f
            if (r13 != 0) goto L_0x0069
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0069:
            java.lang.String r14 = r3.getResponseCode()
            java.lang.Integer r3 = r3.getHttpCode()
            int r15 = r0.f57605b
            if (r15 != r10) goto L_0x026c
            net.one97.paytm.passbook.landing.c.b r15 = r13.f57735a
            int r11 = net.one97.paytm.passbook.R.id.rvPassbookEntries
            android.view.View r11 = r15.a((int) r11)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            java.lang.String r15 = "mPaymentHistoryFragment.rvPassbookEntries"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r15)
            r11.setVisibility(r2)
            net.one97.paytm.passbook.landing.c.b r11 = r13.f57735a
            net.one97.paytm.passbook.landing.a.a r11 = r11.b()
            r11.a()
            net.one97.paytm.passbook.landing.c.b r11 = r13.f57735a
            int r15 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r11 = r11.a((int) r15)
            java.lang.String r15 = "mPaymentHistoryFragment.ilDataFetchError"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r15)
            r11.setVisibility(r2)
            net.one97.paytm.passbook.landing.c.b r11 = r13.f57735a
            net.one97.paytm.passbook.landing.a.a r11 = r11.b()
            int r11 = r11.f57545d
            java.lang.String r10 = "mPaymentHistoryFragment.…aFetchError.tvClearFilter"
            java.lang.String r7 = "mPaymentHistoryFragment.ilDataFetchError.btnRetry"
            if (r11 == 0) goto L_0x012f
            net.one97.paytm.passbook.landing.c.b r3 = r13.f57735a
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r3 = r3.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            int r4 = net.one97.paytm.passbook.R.id.tvErrorMsg
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.passbook.R.string.pass_payment_hist_filter_error
            r3.setText(r4)
            net.one97.paytm.passbook.landing.c.b r3 = r13.f57735a
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r3 = r3.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            int r4 = net.one97.paytm.passbook.R.id.ivError
            android.view.View r3 = r3.findViewById(r4)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r4 = net.one97.paytm.passbook.R.drawable.pass_payment_history_no_txns
            r3.setImageResource(r4)
            net.one97.paytm.passbook.landing.c.b r3 = r13.f57735a
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r3 = r3.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            int r4 = net.one97.paytm.passbook.R.id.tvClearFilter
            android.view.View r3 = r3.findViewById(r4)
            androidx.appcompat.widget.AppCompatTextView r3 = (androidx.appcompat.widget.AppCompatTextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            r3.setVisibility(r2)
            net.one97.paytm.passbook.landing.c.b r3 = r13.f57735a
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r3 = r3.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            int r4 = net.one97.paytm.passbook.R.id.btnRetry
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            r3.setVisibility(r12)
            net.one97.paytm.passbook.landing.c.b r3 = r13.f57735a
            int r4 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r3 = r3.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            int r4 = net.one97.paytm.passbook.R.id.tvClearFilter
            android.view.View r3 = r3.findViewById(r4)
            androidx.appcompat.widget.AppCompatTextView r3 = (androidx.appcompat.widget.AppCompatTextView) r3
            net.one97.paytm.passbook.landing.f.c$a r4 = new net.one97.paytm.passbook.landing.f.c$a
            r4.<init>(r13)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
            goto L_0x0377
        L_0x012f:
            net.one97.paytm.passbook.landing.c.b r11 = r13.f57735a
            int r2 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r2 = r11.a((int) r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            int r11 = net.one97.paytm.passbook.R.id.tvClearFilter
            android.view.View r2 = r2.findViewById(r11)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r10)
            r2.setVisibility(r12)
            if (r14 == 0) goto L_0x01d9
            if (r3 == 0) goto L_0x01d9
            int r2 = r3.intValue()
            r10 = 200(0xc8, float:2.8E-43)
            if (r2 != r10) goto L_0x01b6
            java.lang.String r2 = "4002"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4003"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4007"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4008"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4009"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4011"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01d9
            java.lang.String r2 = "4014"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x018d
            goto L_0x01d9
        L_0x018d:
            java.lang.String r2 = "4004"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01c6
            java.lang.String r2 = "4005"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01c6
            java.lang.String r2 = "4006"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01c6
            java.lang.String r2 = "4010"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x01c6
            java.lang.String r2 = "4015"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x01d9
            goto L_0x01d8
        L_0x01b6:
            int r2 = r3.intValue()
            r10 = 400(0x190, float:5.6E-43)
            if (r2 != r10) goto L_0x01c8
            java.lang.String r2 = "4001"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x01d9
        L_0x01c6:
            r2 = 0
            goto L_0x01da
        L_0x01c8:
            int r2 = r3.intValue()
            r10 = 401(0x191, float:5.62E-43)
            if (r2 != r10) goto L_0x01d9
            java.lang.String r2 = "4012"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x01d9
        L_0x01d8:
            goto L_0x01c6
        L_0x01d9:
            r2 = 1
        L_0x01da:
            if (r2 == 0) goto L_0x01f7
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            int r10 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r2 = r2.a((int) r10)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            int r10 = net.one97.paytm.passbook.R.id.btnRetry
            android.view.View r2 = r2.findViewById(r10)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            r7 = 0
            r2.setVisibility(r7)
            goto L_0x0210
        L_0x01f7:
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            int r10 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r2 = r2.a((int) r10)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            int r10 = net.one97.paytm.passbook.R.id.btnRetry
            android.view.View r2 = r2.findViewById(r10)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            r2.setVisibility(r12)
        L_0x0210:
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            int r7 = net.one97.paytm.passbook.R.id.tvErrorMsg
            android.view.View r2 = r2.a((int) r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r7 = "mPaymentHistoryFragment.tvErrorMsg"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            if (r14 == 0) goto L_0x0377
            if (r3 == 0) goto L_0x0377
            int r2 = r3.intValue()
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x0252
            java.lang.String r2 = "4010"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0252
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            int r3 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r2 = r2.a((int) r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            int r3 = net.one97.paytm.passbook.R.id.ivError
            android.view.View r2 = r2.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r3 = net.one97.paytm.passbook.R.drawable.pass_payment_history_no_txns
            r2.setImageResource(r3)
            goto L_0x0377
        L_0x0252:
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            int r3 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r2 = r2.a((int) r3)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            int r3 = net.one97.paytm.passbook.R.id.ivError
            android.view.View r2 = r2.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r3 = net.one97.paytm.passbook.R.drawable.pass_payment_hist_technical_error
            r2.setImageResource(r3)
            goto L_0x0377
        L_0x026c:
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            android.content.Context r2 = r2.getContext()
            if (r2 == 0) goto L_0x027b
            int r3 = net.one97.paytm.passbook.R.string.error
            java.lang.String r11 = r2.getString(r3)
            goto L_0x027c
        L_0x027b:
            r11 = 0
        L_0x027c:
            net.one97.paytm.passbook.landing.c.b r2 = r13.f57735a
            android.content.Context r2 = r2.getContext()
            if (r2 == 0) goto L_0x028b
            int r3 = net.one97.paytm.passbook.R.string.pass_try_again_btn_txt
            java.lang.String r2 = r2.getString(r3)
            goto L_0x028c
        L_0x028b:
            r2 = 0
        L_0x028c:
            net.one97.paytm.passbook.landing.f.c$b r3 = new net.one97.paytm.passbook.landing.f.c$b
            r3.<init>(r13)
            android.content.DialogInterface$OnClickListener r3 = (android.content.DialogInterface.OnClickListener) r3
            r13.a(r11, r4, r2, r3)
            goto L_0x0377
        L_0x0298:
            net.one97.paytm.passbook.landing.a.a r2 = r0.f57604a
            if (r2 != 0) goto L_0x029f
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x029f:
            java.util.ArrayList<net.one97.paytm.passbook.beans.PaymentHistoryTransaction> r2 = r2.f57543b
            int r2 = r2.size()
            if (r2 != 0) goto L_0x02d6
            java.util.ArrayList r2 = r3.getTxns()
            if (r2 == 0) goto L_0x02d6
            int r2 = r2.size()
            if (r2 != 0) goto L_0x02d6
            int r2 = net.one97.paytm.passbook.R.id.rvPassbookEntries
            android.view.View r2 = r0.a((int) r2)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r4 = 0
            r2.setVisibility(r4)
            r0.f57608e = r3
            int r2 = net.one97.paytm.passbook.R.id.rlNoData
            android.view.View r2 = r0.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r3 = "rlNoData"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r2.setVisibility(r4)
            goto L_0x0377
        L_0x02d6:
            int r2 = r0.f57605b
            r4 = 1
            int r2 = r2 + r4
            r0.f57605b = r2
            r0.f57608e = r3
            net.one97.paytm.passbook.landing.a.a r2 = r0.f57604a
            if (r2 != 0) goto L_0x02e5
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x02e5:
            net.one97.paytm.passbook.beans.PaymentHistoryResponse r3 = r0.f57608e
            java.lang.String r4 = "paymentHistoryResponse"
            if (r3 != 0) goto L_0x02ee
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02ee:
            kotlin.g.b.k.c(r3, r4)
            r2.f57542a = r3
            java.util.ArrayList r3 = r3.getTxns()
            if (r3 == 0) goto L_0x0372
            java.util.Iterator r3 = r3.iterator()
        L_0x02fd:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0372
            java.lang.Object r4 = r3.next()
            net.one97.paytm.passbook.beans.PaymentHistoryTransactionItems r4 = (net.one97.paytm.passbook.beans.PaymentHistoryTransactionItems) r4
            java.util.ArrayList<net.one97.paytm.passbook.beans.PaymentHistoryTransaction> r7 = r2.f57543b
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0323
            java.util.ArrayList<net.one97.paytm.passbook.beans.PaymentHistoryTransaction> r7 = r2.f57543b
            net.one97.paytm.passbook.beans.PaymentHistoryTransaction r10 = new net.one97.paytm.passbook.beans.PaymentHistoryTransaction
            net.one97.paytm.passbook.beans.PaymentHistoryRootHeader r11 = new net.one97.paytm.passbook.beans.PaymentHistoryRootHeader
            java.lang.String r12 = "Sample Text"
            r11.<init>(r12)
            r12 = 0
            r10.<init>(r11, r12, r12)
            r7.add(r10)
        L_0x0323:
            java.lang.String r7 = r2.f57544c
            java.lang.String r10 = r4.getDateLabel()
            java.lang.String r11 = "MMMM yyyy"
            java.lang.String r12 = "yyyy-MM-dd"
            java.lang.String r10 = net.one97.paytm.passbook.mapping.a.l(r10, r12, r11)
            if (r10 == 0) goto L_0x0338
            java.lang.String r10 = net.one97.paytm.upi.f.a((java.lang.String) r10)
            goto L_0x0339
        L_0x0338:
            r10 = 0
        L_0x0339:
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r10)
            r10 = 1
            r7 = r7 ^ r10
            if (r7 == 0) goto L_0x0366
            java.lang.String r7 = r4.getDateLabel()
            java.lang.String r7 = net.one97.paytm.passbook.mapping.a.l(r7, r12, r11)
            if (r7 == 0) goto L_0x0350
            java.lang.String r11 = net.one97.paytm.upi.f.a((java.lang.String) r7)
            goto L_0x0351
        L_0x0350:
            r11 = 0
        L_0x0351:
            java.util.ArrayList<net.one97.paytm.passbook.beans.PaymentHistoryTransaction> r7 = r2.f57543b
            net.one97.paytm.passbook.beans.PaymentHistoryTransaction r10 = new net.one97.paytm.passbook.beans.PaymentHistoryTransaction
            net.one97.paytm.passbook.beans.PaymentHistoryTransactionHeader r12 = new net.one97.paytm.passbook.beans.PaymentHistoryTransactionHeader
            r12.<init>(r11)
            r13 = 0
            r10.<init>(r13, r12, r13)
            r7.add(r10)
            if (r11 == 0) goto L_0x0367
            r2.f57544c = r11
            goto L_0x0367
        L_0x0366:
            r13 = 0
        L_0x0367:
            java.util.ArrayList<net.one97.paytm.passbook.beans.PaymentHistoryTransaction> r7 = r2.f57543b
            net.one97.paytm.passbook.beans.PaymentHistoryTransaction r10 = new net.one97.paytm.passbook.beans.PaymentHistoryTransaction
            r10.<init>(r13, r13, r4)
            r7.add(r10)
            goto L_0x02fd
        L_0x0372:
            r13 = 0
            r2.notifyDataSetChanged()
            goto L_0x0378
        L_0x0377:
            r13 = 0
        L_0x0378:
            T r1 = r1.f57887b
            if (r1 != 0) goto L_0x045b
            goto L_0x0385
        L_0x037d:
            r13 = 0
            net.one97.paytm.passbook.mapping.a.d<? extends T> r1 = r1.f57888c
            if (r1 == 0) goto L_0x0385
            com.paytm.network.model.NetworkCustomError r11 = r1.f57879a
            goto L_0x0386
        L_0x0385:
            r11 = r13
        L_0x0386:
            if (r11 == 0) goto L_0x038f
            int r1 = r11.getStatusCode()
            r2 = -1
            if (r1 == r2) goto L_0x0399
        L_0x038f:
            if (r11 == 0) goto L_0x0399
            int r1 = r11.getStatusCode()
            r2 = 410(0x19a, float:5.75E-43)
            if (r1 == r2) goto L_0x03ad
        L_0x0399:
            if (r11 == 0) goto L_0x03a3
            int r1 = r11.getStatusCode()
            r2 = 401(0x191, float:5.62E-43)
            if (r1 == r2) goto L_0x03ad
        L_0x03a3:
            if (r11 == 0) goto L_0x03c2
            int r1 = r11.getStatusCode()
            r2 = 403(0x193, float:5.65E-43)
            if (r1 != r2) goto L_0x03c2
        L_0x03ad:
            androidx.fragment.app.FragmentActivity r1 = r16.getActivity()
            android.app.Activity r1 = (android.app.Activity) r1
            java.lang.Class r0 = r16.getClass()
            r0.getName()
            java.lang.Exception r11 = (java.lang.Exception) r11
            r0 = 1
            r2 = 0
            net.one97.paytm.passbook.utility.j.a(r1, r11, r2, r0)
            return
        L_0x03c2:
            if (r11 == 0) goto L_0x03da
            com.paytm.network.model.NetworkResponse r1 = r11.networkResponse
            if (r1 == 0) goto L_0x03da
            byte[] r1 = r1.data
            if (r1 == 0) goto L_0x03da
            org.json.JSONObject r1 = a((byte[]) r1)
            if (r1 == 0) goto L_0x03da
            java.lang.String r2 = "message"
            java.lang.String r1 = r1.optString(r2)
            r11 = r1
            goto L_0x03db
        L_0x03da:
            r11 = r13
        L_0x03db:
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03ea
            int r1 = net.one97.paytm.passbook.R.string.pass_payment_history_list_default_failure_msg
            java.lang.String r11 = r0.getString(r1)
        L_0x03ea:
            int r1 = r0.f57605b
            r2 = 1
            if (r1 != r2) goto L_0x043e
            int r1 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r1 = r0.a((int) r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            r2 = 0
            r1.setVisibility(r2)
            int r1 = net.one97.paytm.passbook.R.id.ilDataFetchError
            android.view.View r1 = r0.a((int) r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            int r2 = net.one97.paytm.passbook.R.id.ivError
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = net.one97.paytm.passbook.R.drawable.pass_payment_hist_technical_error
            r1.setImageResource(r2)
            int r1 = net.one97.paytm.passbook.R.id.tvErrorMsg
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "tvErrorMsg"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            int r1 = net.one97.paytm.passbook.R.id.rvPassbookEntries
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r2 = 0
            r1.setVisibility(r2)
            net.one97.paytm.passbook.landing.a.a r0 = r0.f57604a
            if (r0 != 0) goto L_0x043a
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x043a:
            r0.a()
            return
        L_0x043e:
            net.one97.paytm.passbook.landing.f.c r1 = r0.f57609f
            if (r1 != 0) goto L_0x0445
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0445:
            int r2 = net.one97.paytm.passbook.R.string.error
            java.lang.String r2 = r0.getString(r2)
            int r3 = net.one97.paytm.passbook.R.string.pass_try_again_btn_txt
            java.lang.String r3 = r0.getString(r3)
            net.one97.paytm.passbook.landing.c.b$b r4 = new net.one97.paytm.passbook.landing.c.b$b
            r4.<init>(r0)
            android.content.DialogInterface$OnClickListener r4 = (android.content.DialogInterface.OnClickListener) r4
            r1.a(r2, r11, r3, r4)
        L_0x045b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.c.b.a(net.one97.paytm.passbook.landing.c.b, net.one97.paytm.passbook.mapping.a.f):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57610g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

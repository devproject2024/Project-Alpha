package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal;
import net.one97.paytm.paymentsBank.fragment.h;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import org.json.JSONObject;

public class CashFromNearestPaytmActivity extends PaytmActivity implements View.OnClickListener, net.one97.paytm.bankCommon.f.d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f18228a;

    /* renamed from: b  reason: collision with root package name */
    private PayTMPartnerListModal f18229b;

    /* renamed from: c  reason: collision with root package name */
    private a.C0310a f18230c;

    /* renamed from: d  reason: collision with root package name */
    private NestedScrollView f18231d;

    /* renamed from: e  reason: collision with root package name */
    private h f18232e;

    /* renamed from: f  reason: collision with root package name */
    private View f18233f;

    /* renamed from: g  reason: collision with root package name */
    private a f18234g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.c f18235h;

    public enum c {
        CASH_POINT,
        PAYMENT_POINT,
        KYC_POINT
    }

    public enum f {
        DISTANCE_WISE_SORT,
        OPENING_TIME_SORT,
        CLOSING_TIME_SORT
    }

    public enum g {
        ASC,
        DESC
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearest_paytm_ka_atm);
        this.f18228a = (RecyclerView) findViewById(R.id.rv_nearest);
        this.f18231d = (NestedScrollView) findViewById(R.id.nestedScrollView);
        this.f18233f = findViewById(R.id.no_nearby_lyt);
        ((TextView) findViewById(R.id.tv_how_does_this_work)).setOnClickListener(this);
        this.f18228a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f18228a.setNestedScrollingEnabled(false);
        this.f18230c = new a.C0310a(this, new ArrayList());
        this.f18228a.setAdapter(this.f18230c);
        this.f18234g = new a(this);
        this.f18231d.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                CashFromNearestPaytmActivity.this.e();
            }
        });
        findViewById(R.id.iv_back_arrow).setOnClickListener(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CashFromNearestPaytmActivity.this.a(view);
            }
        });
        if (!net.one97.paytm.bankCommon.h.b.I(this)) {
            this.f18234g.a();
            net.one97.paytm.bankCommon.h.b.J(this);
            return;
        }
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        NestedScrollView nestedScrollView = this.f18231d;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.f18231d.getHeight() + this.f18231d.getScrollY()) == 0) {
            c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(this, CashWithdrawnActivity.class);
        intent.putExtra("slfd_meta_response", new SlfdMetaApiResponseModel());
        intent.putExtra("name", getString(R.string.paytm_payments_bank));
        intent.putExtra("isbankbranch", true);
        startActivityForResult(intent, 123);
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f18232e = new h(this);
        this.f18232e.f18513a = getString(R.string.please_wait_progress_msg);
        this.f18235h = new net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.c(this);
        if (!this.f18235h.a()) {
            this.f18235h.b();
        }
    }

    public void onResume() {
        super.onResume();
        b();
    }

    /* access modifiers changed from: private */
    public void b() {
        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.c cVar = this.f18235h;
        if (cVar != null && cVar.a() && this.f18230c.getItemCount() == 0 && this.f18235h.c()) {
            this.f18232e.a();
            this.f18235h.a(this);
        }
    }

    public void onDestroy() {
        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.c cVar = this.f18235h;
        if (cVar != null) {
            cVar.f18293b = null;
            cVar.f18292a = null;
        }
        super.onDestroy();
    }

    private void c() {
        this.f18232e.a();
        a aVar = this.f18234g;
        $$Lambda$CashFromNearestPaytmActivity$Kma3wyTGf7nGrKTrSseKur7qytg r4 = new g.b() {
            public final void onResponse(Object obj) {
                CashFromNearestPaytmActivity.this.a(obj);
            }
        };
        $$Lambda$CashFromNearestPaytmActivity$Ac0b6bP14GA984UfsOFWtHPGOf4 r5 = new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                CashFromNearestPaytmActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        int itemCount = this.f18230c.getItemCount();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", aVar.getClass().getSimpleName());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", com.paytm.utility.a.q(aVar.f18236a));
        net.one97.paytm.bankCommon.utils.d.a();
        String a2 = net.one97.paytm.bankCommon.utils.d.a("nearbyBCAndBranch");
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://kyc-staging.paytmbank.com/v1/nearby/points?filters=iscashoutpoint";
        }
        PayTMPartnerListModal payTMPartnerListModal = new PayTMPartnerListModal();
        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.d dVar = aVar.f18237b;
        String s = com.paytm.utility.b.s(dVar.f18301b.getApplicationContext());
        k.a((Object) s, "CJRAppCommonUtility.getL…ivity.applicationContext)");
        Double b2 = p.b(s);
        String t = com.paytm.utility.b.t(dVar.f18301b.getApplicationContext());
        k.a((Object) t, "CJRAppCommonUtility.getL…ivity.applicationContext)");
        Double b3 = p.b(t);
        if (b2 == null || b3 == null) {
            dVar.f18300a[0] = net.one97.paytm.bankCommon.h.b.E(dVar.f18301b);
            dVar.f18300a[1] = net.one97.paytm.bankCommon.h.b.F(dVar.f18301b);
        } else {
            dVar.f18300a[0] = b2.doubleValue();
            dVar.f18300a[1] = b3.doubleValue();
        }
        double d2 = dVar.f18300a[0];
        double d3 = dVar.f18300a[1];
        String cVar = c.KYC_POINT.toString();
        b bVar = new b();
        bVar.f18249a = new b.a();
        a aVar2 = aVar;
        bVar.f18249a.f18260g = new ArrayList(1);
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put(f.OPENING_TIME_SORT.toString(), g.ASC.toString());
        bVar.f18249a.f18259f = hashMap3;
        bVar.f18249a.f18257d = Integer.valueOf(itemCount);
        bVar.f18249a.f18258e = 20;
        b.C0312b bVar2 = new b.C0312b();
        bVar2.f18262a = "SERVICE";
        bVar2.f18263b = cVar;
        bVar.f18249a.f18260g.add(0, bVar2);
        b.a aVar3 = bVar.f18249a;
        aVar3.f18254a = String.valueOf(d2);
        b.a aVar4 = bVar.f18249a;
        aVar4.f18255b = String.valueOf(d3);
        e.a();
        String jSONObject = e.a(bVar).toString();
        k.a((Object) jSONObject, "body.toString()");
        net.one97.paytm.bankCommon.g.b bVar3 = new net.one97.paytm.bankCommon.g.b(a2, r4, r5, payTMPartnerListModal, hashMap, jSONObject, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        aVar2.f18236a.getApplicationContext();
        new net.one97.paytm.bankCommon.g.c();
        net.one97.paytm.bankCommon.g.c.a(bVar3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        this.f18232e.b();
        if (obj instanceof PayTMPartnerListModal) {
            this.f18229b = (PayTMPartnerListModal) obj;
            if (this.f18229b.getResponse() != null) {
                a.C0310a aVar = this.f18230c;
                ArrayList<PayTMPartnerListModal.Response> response = this.f18229b.getResponse();
                if (aVar.f18239a == null) {
                    aVar.f18239a = new ArrayList();
                }
                if (response != null && response.size() > 0) {
                    aVar.f18239a.addAll(response);
                    aVar.notifyItemInserted(aVar.f18239a.size() - response.size());
                }
                this.f18228a.setVisibility(0);
                this.f18233f.setVisibility(8);
            } else if (this.f18230c.getItemCount() == 0) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), this.f18229b.getStatusMessage());
                this.f18228a.setVisibility(8);
                this.f18233f.setVisibility(0);
            } else if (!"GE_0001".equalsIgnoreCase(this.f18229b.getStatusCode())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), this.f18229b.getStatusMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f18232e.b();
        net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.tv_know_more && view.getId() != R.id.tv_view_interest_table) {
            if (view.getId() == R.id.iv_back_arrow) {
                onBackPressed();
            } else if (view.getId() == R.id.tv_how_does_this_work) {
                this.f18234g.a();
            }
        }
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 != 100) {
            return;
        }
        if ("disabled".equalsIgnoreCase((String) obj)) {
            d();
        } else {
            c();
        }
    }

    private void d() {
        if (this.f18230c.getItemCount() == 0) {
            this.f18228a.setVisibility(8);
            this.f18233f.setVisibility(0);
        }
        this.f18232e.b();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 1) {
            if (i2 == 100 && iArr.length > 0) {
                for (int i3 : iArr) {
                    if (i3 != 0) {
                        d();
                        return;
                    }
                }
                this.f18235h.a(this);
            }
        } else if (iArr.length > 0 && iArr[0] == 0) {
            this.f18230c.a();
        }
    }

    public static class d extends net.one97.paytm.i.f implements View.OnClickListener {
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new h(getActivity()).f18513a = getString(R.string.please_wait_progress_msg);
        }

        public void setupDialog(Dialog dialog, int i2) {
            super.setupDialog(dialog, i2);
            getDialog().setOnShowListener($$Lambda$CashFromNearestPaytmActivity$d$TrlwwBmXnF11zscHENeEtYDO2s.INSTANCE);
            View inflate = View.inflate(getContext(), R.layout.home_customer_initiated_cw_bs, (ViewGroup) null);
            inflate.findViewById(R.id.iv_close).setOnClickListener(this);
            inflate.findViewById(R.id.btn).setOnClickListener(this);
            dialog.setContentView(inflate);
        }

        public void onClick(View view) {
            if (view.getId() == R.id.iv_close) {
                dismiss();
                ((CashFromNearestPaytmActivity) getActivity()).a();
                ((CashFromNearestPaytmActivity) getActivity()).b();
            } else if (view.getId() != R.id.btn) {
            } else {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    if (!(getActivity() instanceof CashFromNearestPaytmActivity)) {
                        startActivity(new Intent(getActivity(), CashFromNearestPaytmActivity.class));
                    } else {
                        ((CashFromNearestPaytmActivity) getActivity()).a();
                        ((CashFromNearestPaytmActivity) getActivity()).b();
                    }
                    dismiss();
                    return;
                }
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.network_error_message));
            }
        }

        public void onAttach(Context context) {
            super.onAttach(context);
        }

        public int getTheme() {
            return R.style.BottomSheetDialogTheme;
        }
    }

    public static class b {
        @com.google.gsonhtcfix.a.b(a = "request")

        /* renamed from: a  reason: collision with root package name */
        public a f18249a;
        @com.google.gsonhtcfix.a.b(a = "ipAddress")

        /* renamed from: b  reason: collision with root package name */
        public String f18250b = "127.0.0.1";
        @com.google.gsonhtcfix.a.b(a = "platformName")

        /* renamed from: c  reason: collision with root package name */
        public String f18251c = "PayTM";
        @com.google.gsonhtcfix.a.b(a = "channel")

        /* renamed from: d  reason: collision with root package name */
        public String f18252d = "";
        @com.google.gsonhtcfix.a.b(a = "version")

        /* renamed from: e  reason: collision with root package name */
        public String f18253e = "";

        public class a {
            @com.google.gsonhtcfix.a.b(a = "latitude")

            /* renamed from: a  reason: collision with root package name */
            public String f18254a;
            @com.google.gsonhtcfix.a.b(a = "longitude")

            /* renamed from: b  reason: collision with root package name */
            public String f18255b;
            @com.google.gsonhtcfix.a.b(a = "distance")

            /* renamed from: c  reason: collision with root package name */
            public Double f18256c = Double.valueOf(10.0d);
            @com.google.gsonhtcfix.a.b(a = "startLimit")

            /* renamed from: d  reason: collision with root package name */
            public Integer f18257d;
            @com.google.gsonhtcfix.a.b(a = "endLimit")

            /* renamed from: e  reason: collision with root package name */
            public Integer f18258e;
            @com.google.gsonhtcfix.a.b(a = "sortBy")

            /* renamed from: f  reason: collision with root package name */
            public HashMap<String, String> f18259f;
            @com.google.gsonhtcfix.a.b(a = "searchFilter")

            /* renamed from: g  reason: collision with root package name */
            public List<C0312b> f18260g;

            public a() {
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$b$b  reason: collision with other inner class name */
        public class C0312b {
            @com.google.gsonhtcfix.a.b(a = "filterType")

            /* renamed from: a  reason: collision with root package name */
            public String f18262a;
            @com.google.gsonhtcfix.a.b(a = "value")

            /* renamed from: b  reason: collision with root package name */
            public String f18263b;

            public C0312b() {
            }
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private static volatile e f18265a;

        public static e a() {
            if (f18265a == null) {
                synchronized (e.class) {
                    if (f18265a == null) {
                        f18265a = new e();
                    }
                }
            }
            return f18265a;
        }

        public static JSONObject a(b bVar) {
            try {
                return new JSONObject(new com.google.gsonhtcfix.f().a((Object) bVar));
            } catch (Exception unused) {
                return new JSONObject();
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        FragmentActivity f18236a;

        /* renamed from: b  reason: collision with root package name */
        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.d f18237b;

        public a(FragmentActivity fragmentActivity) {
            this.f18236a = fragmentActivity;
            this.f18237b = new net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.d(fragmentActivity);
        }

        public final void a() {
            new d().show(this.f18236a.getSupportFragmentManager(), "dialogCW");
        }

        /* renamed from: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a  reason: collision with other inner class name */
        public static class C0310a extends RecyclerView.a<C0311a> {

            /* renamed from: c  reason: collision with root package name */
            private static DecimalFormat f18238c = new DecimalFormat("0.00");

            /* renamed from: a  reason: collision with root package name */
            List<PayTMPartnerListModal.Response> f18239a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public String f18240b;

            /* renamed from: d  reason: collision with root package name */
            private Context f18241d;

            public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                C0311a aVar = (C0311a) vVar;
                if (this.f18239a.size() > 0) {
                    PayTMPartnerListModal.Response response = this.f18239a.get(i2);
                    aVar.f18242a.setText(response.getCashPointsDetail().getDisplayName());
                    TextView textView = aVar.f18243b;
                    ArrayList<String> address = response.getCashPointsDetail().getAddress();
                    StringBuilder sb = new StringBuilder();
                    if (address != null && address.size() > 0) {
                        int size = address.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (!TextUtils.isEmpty(address.get(i3))) {
                                sb.append(address.get(i3));
                            }
                            if (i3 < size - 1) {
                                sb.append(" ");
                            }
                        }
                    }
                    textView.setText(sb.toString());
                    aVar.f18244c.setText(a(response.getCashPointsDetail().getServicesOffered()));
                    TextView textView2 = aVar.f18245d;
                    textView2.setText(f18238c.format(response.getDistanceFromLocation()) + " km");
                    aVar.itemView.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009d: INVOKE  
                          (wrap: android.view.View : 0x0096: IGET  (r0v7 android.view.View) = 
                          (r7v1 'aVar' net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a$a)
                         net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity.a.a.a.itemView android.view.View)
                          (wrap: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4 : 0x009a: CONSTRUCTOR  (r1v10 net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4) = 
                          (r6v0 'this' net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a A[THIS])
                          (r8v2 'response' net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response)
                         call: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4.<init>(net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a, net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response):void type: CONSTRUCTOR)
                         android.view.View.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void, dex: classes11.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009a: CONSTRUCTOR  (r1v10 net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4) = 
                          (r6v0 'this' net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a A[THIS])
                          (r8v2 'response' net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response)
                         call: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4.<init>(net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a, net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response):void type: CONSTRUCTOR in method: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void, dex: classes11.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 66 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 72 more
                        */
                    /*
                        this = this;
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a$a r7 = (net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity.a.C0310a.C0311a) r7
                        java.util.List<net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response> r0 = r6.f18239a
                        int r0 = r0.size()
                        if (r0 <= 0) goto L_0x00b4
                        java.util.List<net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response> r0 = r6.f18239a
                        java.lang.Object r8 = r0.get(r8)
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$Response r8 = (net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal.Response) r8
                        android.widget.TextView r0 = r7.f18242a
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$CashPointsDetail r1 = r8.getCashPointsDetail()
                        java.lang.String r1 = r1.getDisplayName()
                        r0.setText(r1)
                        android.widget.TextView r0 = r7.f18243b
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$CashPointsDetail r1 = r8.getCashPointsDetail()
                        java.util.ArrayList r1 = r1.getAddress()
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        if (r1 == 0) goto L_0x005e
                        int r3 = r1.size()
                        if (r3 <= 0) goto L_0x005e
                        int r3 = r1.size()
                        r4 = 0
                    L_0x003b:
                        if (r4 >= r3) goto L_0x005e
                        java.lang.Object r5 = r1.get(r4)
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        boolean r5 = android.text.TextUtils.isEmpty(r5)
                        if (r5 != 0) goto L_0x0052
                        java.lang.Object r5 = r1.get(r4)
                        java.lang.String r5 = (java.lang.String) r5
                        r2.append(r5)
                    L_0x0052:
                        int r5 = r3 + -1
                        if (r4 >= r5) goto L_0x005b
                        java.lang.String r5 = " "
                        r2.append(r5)
                    L_0x005b:
                        int r4 = r4 + 1
                        goto L_0x003b
                    L_0x005e:
                        java.lang.String r1 = r2.toString()
                        r0.setText(r1)
                        android.widget.TextView r0 = r7.f18244c
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model.PayTMPartnerListModal$CashPointsDetail r1 = r8.getCashPointsDetail()
                        java.util.List r1 = r1.getServicesOffered()
                        java.lang.String r1 = a((java.util.List<java.lang.String>) r1)
                        r0.setText(r1)
                        android.widget.TextView r0 = r7.f18245d
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.text.DecimalFormat r2 = f18238c
                        java.lang.Double r3 = r8.getDistanceFromLocation()
                        java.lang.String r2 = r2.format(r3)
                        r1.append(r2)
                        java.lang.String r2 = " km"
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.setText(r1)
                        android.view.View r0 = r7.itemView
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4 r1 = new net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$g9Gnly9nwj06MkQWD6Bj_itGlE4
                        r1.<init>(r6, r8)
                        r0.setOnClickListener(r1)
                        android.widget.LinearLayout r0 = r7.f18247f
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$k5d3_Iq2m1T6QzdzxDwJV5Gfpdk r1 = new net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$k5d3_Iq2m1T6QzdzxDwJV5Gfpdk
                        r1.<init>(r6, r8)
                        r0.setOnClickListener(r1)
                        android.widget.LinearLayout r7 = r7.f18246e
                        net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$dNKjFQDvAnNifCxvs20dM92vnyo r0 = new net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.-$$Lambda$CashFromNearestPaytmActivity$a$a$dNKjFQDvAnNifCxvs20dM92vnyo
                        r0.<init>(r6, r8)
                        r7.setOnClickListener(r0)
                    L_0x00b4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity.a.C0310a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
                }

                public C0310a(Context context, List<PayTMPartnerListModal.Response> list) {
                    this.f18241d = context;
                    this.f18239a.addAll(list);
                }

                private static boolean a(PayTMPartnerListModal.Response response) {
                    for (String equalsIgnoreCase : response.getCashPointsDetail().getServicesOffered()) {
                        if ("ISBANKBRANCH".equalsIgnoreCase(equalsIgnoreCase)) {
                            return true;
                        }
                    }
                    return false;
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void c(PayTMPartnerListModal.Response response, View view) {
                    Intent intent = new Intent(this.f18241d, CashWithdrawnActivity.class);
                    intent.putExtra("name", response.getCashPointsDetail().getDisplayName());
                    intent.putExtra("isbankbranch", a(response));
                    intent.putExtra("slfd_meta_response", new SlfdMetaApiResponseModel());
                    ((Activity) this.f18241d).startActivityForResult(intent, 123);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void b(PayTMPartnerListModal.Response response, View view) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(response.getCashPointsDetail().getLocation().getLat());
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(response.getCashPointsDetail().getLocation().getLon());
                        String sb4 = sb3.toString();
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + sb2 + AppConstants.COMMA + sb4));
                        intent.setPackage("com.google.android.apps.maps");
                        this.f18241d.startActivity(intent);
                    } catch (Exception unused) {
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a(PayTMPartnerListModal.Response response, View view) {
                    try {
                        this.f18240b = response.getCashPointsDetail().getContactNo().get(0);
                        if (androidx.core.content.b.a(this.f18241d, "android.permission.CALL_PHONE") != 0) {
                            androidx.core.app.a.a((Activity) this.f18241d, new String[]{"android.permission.CALL_PHONE"}, 1);
                        } else {
                            a();
                        }
                    } catch (Exception unused) {
                    }
                }

                private static String a(List<String> list) {
                    for (String equalsIgnoreCase : list) {
                        if ("ISCASHOUTPOINT".equalsIgnoreCase(equalsIgnoreCase)) {
                            return "CASHOUT POINT";
                        }
                    }
                    return "KYC POINT";
                }

                public final void a() {
                    Intent intent = new Intent("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:" + this.f18240b));
                    this.f18241d.startActivity(intent);
                }

                public final int getItemCount() {
                    return this.f18239a.size();
                }

                /* renamed from: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity$a$a$a  reason: collision with other inner class name */
                public class C0311a extends RecyclerView.v {

                    /* renamed from: a  reason: collision with root package name */
                    TextView f18242a;

                    /* renamed from: b  reason: collision with root package name */
                    TextView f18243b;

                    /* renamed from: c  reason: collision with root package name */
                    TextView f18244c;

                    /* renamed from: d  reason: collision with root package name */
                    TextView f18245d;

                    /* renamed from: e  reason: collision with root package name */
                    LinearLayout f18246e;

                    /* renamed from: f  reason: collision with root package name */
                    LinearLayout f18247f;

                    public C0311a(View view) {
                        super(view);
                        this.f18242a = (TextView) view.findViewById(R.id.tv_cht_name);
                        this.f18243b = (TextView) view.findViewById(R.id.tv_aadrs);
                        this.f18244c = (TextView) view.findViewById(R.id.tv_tag);
                        this.f18245d = (TextView) view.findViewById(R.id.tv_km);
                        this.f18246e = (LinearLayout) view.findViewById(R.id.ll_call);
                        this.f18247f = (LinearLayout) view.findViewById(R.id.ll_map);
                    }
                }

                public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                    return new C0311a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearest_paytm_ka_atm_row, viewGroup, false));
                }
            }
        }
    }

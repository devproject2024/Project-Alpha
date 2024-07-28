package net.one97.paytm.paymentsBank.chequebook.landing.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.landing.a.a;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a implements com.paytm.network.listener.b, a.C0270a {

    /* renamed from: a  reason: collision with root package name */
    final a.b f17536a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17537b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17538c;

    /* renamed from: d  reason: collision with root package name */
    private h f17539d;

    /* renamed from: e  reason: collision with root package name */
    private ChequeBookDetailResponse f17540e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17541f;

    /* renamed from: g  reason: collision with root package name */
    private final g f17542g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f17543h;

    public a(g gVar, a.b bVar, Context context) {
        k.c(bVar, "cbListView");
        k.c(context, "mContext");
        this.f17542g = gVar;
        this.f17536a = bVar;
        this.f17543h = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17537b = simpleName;
    }

    public final void a(String str, String str2) {
        com.paytm.network.a aVar;
        k.c(str, "cbNumber");
        k.c(str2, StringSet.token);
        g gVar = this.f17542g;
        if (gVar != null) {
            com.paytm.network.listener.b bVar = this;
            String string = this.f17543h.getString(R.string.cb_block_reason);
            k.a((Object) string, "mContext.getString(R.string.cb_block_reason)");
            k.c(bVar, "apiListener");
            k.c(str2, "bankScopeToken");
            k.c(string, "blockReason");
            k.c(str, "chqId");
            k.c("cb_landing_screen", SDKConstants.EVENT_KEY_SCREEN_NAME);
            String stringFromGTM = o.a().getStringFromGTM("stop_cb_url");
            Map hashMap = new HashMap();
            e eVar = e.f17951a;
            hashMap.put(e.a(), str2);
            hashMap.put("Accept", "application/json");
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            e eVar2 = e.f17951a;
            jSONObject.put(e.E(), UpiConstants.B2C_ANDROID);
            e eVar3 = e.f17951a;
            jSONObject.put(e.F(), string);
            e eVar4 = e.f17951a;
            jSONObject.put(e.H(), str);
            e eVar5 = e.f17951a;
            String G = e.G();
            e eVar6 = e.f17951a;
            jSONObject.put(G, e.I());
            aVar = new com.paytm.network.b().a(gVar.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c("cb_landing_screen").a(a.C0715a.PUT).a(stringFromGTM).b(jSONObject.toString()).a((Map<String, String>) hashMap).a(true).a((IJRPaytmDataModel) new CbStopPaymentResponse((String) null, (String) null, (String) null, (String) null, (String) null, 31, (kotlin.g.b.g) null)).a(bVar).l();
        } else {
            aVar = null;
        }
        if (!com.paytm.utility.b.c(this.f17543h)) {
            a.b bVar2 = this.f17536a;
            String string2 = this.f17543h.getString(R.string.error);
            k.a((Object) string2, "mContext.getString(R.string.error)");
            String string3 = this.f17543h.getString(R.string.pb_something_wrong_try_again);
            k.a((Object) string3, "mContext.getString(R.str…omething_wrong_try_again)");
            bVar2.a(string2, string3);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r2 = r2.getCbList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r3 = this;
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r3.f17540e
            if (r0 == 0) goto L_0x004b
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x004b
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x004b
            r3.f17538c = r1
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r3.f17540e
            if (r0 == 0) goto L_0x0028
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.paymentsBank.chequebook.model.b r2 = new net.one97.paytm.paymentsBank.chequebook.model.b
            r2.<init>()
            r0.add(r2)
        L_0x0028:
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r0 = r3.f17536a
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r2 = r3.f17540e
            if (r2 == 0) goto L_0x003d
            java.util.List r2 = r2.getCbList()
            if (r2 == 0) goto L_0x003d
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            if (r2 != 0) goto L_0x0043
            kotlin.g.b.k.a()
        L_0x0043:
            int r2 = r2.intValue()
            int r2 = r2 - r1
            r0.c(r2)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.landing.b.a.d():void");
    }

    public final boolean c() {
        return this.f17538c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r0 = r0.getCbList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.recyclerview.widget.RecyclerView.v r7, int r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0137
            boolean r0 = r7 instanceof net.one97.paytm.paymentsBank.chequebook.landing.view.a.c
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r6.f17540e
            r1 = 0
            if (r0 == 0) goto L_0x001a
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x001a
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            if (r0 != 0) goto L_0x0020
            kotlin.g.b.k.a()
        L_0x0020:
            int r0 = r0.intValue()
            if (r8 > r0) goto L_0x0137
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r6.f17540e
            if (r0 == 0) goto L_0x0037
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r0.get(r8)
            r1 = r0
            net.one97.paytm.paymentsBank.chequebook.model.b r1 = (net.one97.paytm.paymentsBank.chequebook.model.b) r1
        L_0x0037:
            if (r1 == 0) goto L_0x0137
            r0 = r7
            net.one97.paytm.paymentsBank.chequebook.landing.view.a$c r0 = (net.one97.paytm.paymentsBank.chequebook.landing.view.a.c) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r3 = r6.f17543h
            int r4 = net.one97.paytm.paymentsBank.R.string.pb_cheque_book
            java.lang.String r3 = r3.getString(r4)
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            java.lang.String r4 = r1.b()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "mName"
            kotlin.g.b.k.c(r2, r4)
            android.widget.TextView r4 = r0.f17568a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
            java.lang.String r2 = r1.a()
            java.lang.String r4 = "dd/MM/yy"
            java.lang.String r2 = net.one97.paytm.paymentsBank.utils.j.a((java.lang.String) r2, (java.lang.String) r4)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "Issued on "
            java.lang.String r2 = r4.concat(r2)
            java.lang.String r4 = "mDate"
            kotlin.g.b.k.c(r2, r4)
            android.widget.TextView r4 = r0.f17570c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r4 = r6.f17543h
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_cb_leaves
            java.lang.String r4 = r4.getString(r5)
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = r1.d()
            r2.append(r3)
            java.lang.String r3 = "-"
            r2.append(r3)
            java.lang.String r3 = r1.e()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "mLeavesDetails"
            kotlin.g.b.k.c(r2, r3)
            android.widget.TextView r3 = r0.f17569b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            java.lang.String r2 = r1.c()
            java.lang.String r3 = "BLOCKED"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0111
            android.widget.ImageView r2 = r0.f17573f
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(r2)
            android.widget.TextView r2 = r0.f17571d
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(r2)
            java.lang.String r2 = "Payment Stopped"
            java.lang.String r3 = "mLeavesLeft"
            kotlin.g.b.k.c(r2, r3)
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r2)
            if (r3 == 0) goto L_0x011f
            android.widget.TextView r3 = r0.f17571d
            android.widget.TextView r4 = r0.f17571d
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.paymentsBank.R.drawable.pb_cb_stopped_bg
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            r3.setBackground(r4)
            android.widget.TextView r3 = r0.f17571d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            android.widget.TextView r2 = r0.f17571d
            java.lang.String r3 = "#fd5c5c"
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setTextColor(r3)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r0.f17572e
            r3 = 1060320051(0x3f333333, float:0.7)
            r2.setAlpha(r3)
            goto L_0x011f
        L_0x0111:
            android.widget.TextView r2 = r0.f17571d
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(r2)
            android.widget.ImageView r2 = r0.f17573f
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(r2)
        L_0x011f:
            android.widget.ImageView r2 = r0.f17573f
            net.one97.paytm.paymentsBank.chequebook.landing.b.a$a r3 = new net.one97.paytm.paymentsBank.chequebook.landing.b.a$a
            r3.<init>(r6, r8, r1, r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
            android.view.View r7 = r0.f17574g
            net.one97.paytm.paymentsBank.chequebook.landing.b.a$b r8 = new net.one97.paytm.paymentsBank.chequebook.landing.b.a$b
            r8.<init>(r6, r1)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.landing.b.a.a(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.landing.b.a$a  reason: collision with other inner class name */
    static final class C0271a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17544a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17545b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.model.b f17546c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f17547d;

        C0271a(a aVar, int i2, net.one97.paytm.paymentsBank.chequebook.model.b bVar, RecyclerView.v vVar) {
            this.f17544a = aVar;
            this.f17545b = i2;
            this.f17546c = bVar;
            this.f17547d = vVar;
        }

        public final void onClick(View view) {
            a.b bVar = this.f17544a.f17536a;
            int i2 = this.f17545b;
            String b2 = this.f17546c.b();
            k.a((Object) b2, "cbresponse.chequeBookNumber");
            View view2 = this.f17547d.itemView;
            k.a((Object) view2, "holder.itemView");
            bVar.a(i2, b2, view2);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.model.b f17549b;

        b(a aVar, net.one97.paytm.paymentsBank.chequebook.model.b bVar) {
            this.f17548a = aVar;
            this.f17549b = bVar;
        }

        public final void onClick(View view) {
            a.b bVar = this.f17548a.f17536a;
            String b2 = this.f17549b.b();
            k.a((Object) b2, "cbresponse.chequeBookNumber");
            bVar.a(b2, k.a((Object) this.f17549b.c(), (Object) "BLOCKED"));
        }
    }

    public final void a() {
        net.one97.paytm.paymentsBank.chequebook.model.a cbListPaging;
        Boolean a2;
        Context context = this.f17543h;
        if (context != null) {
            this.f17539d = h.a(context);
            String a3 = this.f17539d != null ? h.a("CB_KEY_CB_LIST_RESPONSE") : null;
            if (a3 == null) {
                k.a();
            }
            this.f17540e = (ChequeBookDetailResponse) new f().a(a3, ChequeBookDetailResponse.class);
            if (TextUtils.isEmpty(a3)) {
                this.f17541f = true;
            }
            ChequeBookDetailResponse chequeBookDetailResponse = this.f17540e;
            this.f17536a.b(!((chequeBookDetailResponse == null || (cbListPaging = chequeBookDetailResponse.getCbListPaging()) == null || (a2 = cbListPaging.a()) == null) ? false : a2.booleanValue()));
        }
        this.f17536a.c();
    }

    public final void a(String str) {
        k.c(str, "offset");
        g gVar = this.f17542g;
        com.paytm.network.a a2 = gVar != null ? gVar.a(this.f17543h, str, (com.paytm.network.listener.b) this, "cb_landing_screen") : null;
        if (com.paytm.utility.b.c(this.f17543h) && a2 != null) {
            a2.a();
        }
    }

    public final void b() {
        h.a();
    }

    public final int e() {
        List<net.one97.paytm.paymentsBank.chequebook.model.b> cbList;
        ChequeBookDetailResponse chequeBookDetailResponse = this.f17540e;
        if (chequeBookDetailResponse == null || (cbList = chequeBookDetailResponse.getCbList()) == null) {
            return 0;
        }
        return cbList.size();
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f17536a.a(false);
        if (networkCustomError != null) {
            com.paytm.utility.b.b(this.f17543h, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r4 = r4.getCbList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r7) {
        /*
            r6 = this;
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r0 = r6.f17536a
            r1 = 0
            r0.a(r1)
            boolean r0 = r7 instanceof net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse
            if (r0 == 0) goto L_0x0033
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r0 = r6.f17536a
            r0.a(r1)
            android.content.Context r0 = r6.f17543h
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.paymentsBank.chequebook.utils.h r0 = net.one97.paytm.paymentsBank.chequebook.utils.h.a((android.content.Context) r0)
            r6.f17539d = r0
        L_0x0019:
            net.one97.paytm.paymentsBank.chequebook.utils.h r0 = r6.f17539d
            if (r0 == 0) goto L_0x002d
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.String r7 = r0.b(r7)
            android.content.Context r0 = r6.f17543h
            java.lang.String r1 = "CB_KEY_FIN_RESPONSE"
            net.one97.paytm.paymentsBank.chequebook.utils.h.a(r1, r7, r0)
        L_0x002d:
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r7 = r6.f17536a
            r7.b()
            return
        L_0x0033:
            boolean r0 = r7 instanceof net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse
            r2 = 1
            if (r0 == 0) goto L_0x00f2
            boolean r0 = r6.f17538c
            if (r0 == 0) goto L_0x009d
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r6.f17540e
            if (r0 == 0) goto L_0x009d
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x009d
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x009d
            r6.f17538c = r1
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r6.f17540e
            r3 = 0
            if (r0 == 0) goto L_0x007d
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x007d
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r4 = r6.f17540e
            if (r4 == 0) goto L_0x006f
            java.util.List r4 = r4.getCbList()
            if (r4 == 0) goto L_0x006f
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0070
        L_0x006f:
            r4 = r3
        L_0x0070:
            if (r4 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            int r4 = r4.intValue()
            int r4 = r4 - r2
            r0.remove(r4)
        L_0x007d:
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r0 = r6.f17536a
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r4 = r6.f17540e
            if (r4 == 0) goto L_0x0091
            java.util.List r4 = r4.getCbList()
            if (r4 == 0) goto L_0x0091
            int r3 = r4.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0091:
            if (r3 != 0) goto L_0x0096
            kotlin.g.b.k.a()
        L_0x0096:
            int r3 = r3.intValue()
            r0.b((int) r3)
        L_0x009d:
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r0 = r6.f17540e
            if (r0 == 0) goto L_0x00ac
            java.util.List r0 = r0.getCbList()
            if (r0 == 0) goto L_0x00ac
            int r0 = r0.size()
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r3 = r6.f17540e
            if (r3 == 0) goto L_0x00c8
            java.util.List r3 = r3.getCbList()
            if (r3 == 0) goto L_0x00c8
            r4 = r7
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r4 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse) r4
            java.util.List r4 = r4.getCbList()
            java.lang.String r5 = "p0.cbList"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.Collection r4 = (java.util.Collection) r4
            r3.addAll(r4)
        L_0x00c8:
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse r7 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse) r7
            java.util.List r3 = r7.getCbList()
            if (r3 == 0) goto L_0x00d5
            int r3 = r3.size()
            goto L_0x00d6
        L_0x00d5:
            r3 = 0
        L_0x00d6:
            net.one97.paytm.paymentsBank.chequebook.model.a r7 = r7.getCbListPaging()
            if (r7 == 0) goto L_0x00e6
            java.lang.Boolean r7 = r7.a()
            if (r7 == 0) goto L_0x00e6
            boolean r1 = r7.booleanValue()
        L_0x00e6:
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r7 = r6.f17536a
            r1 = r1 ^ r2
            r7.b((boolean) r1)
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r7 = r6.f17536a
            r7.a((int) r0, (int) r3)
            return
        L_0x00f2:
            boolean r0 = r7 instanceof net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse
            if (r0 == 0) goto L_0x012c
            net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse r7 = (net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse) r7
            java.lang.String r7 = r7.getStatus()
            if (r7 == 0) goto L_0x010d
            java.lang.String r0 = "success"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r2)
            if (r7 != r2) goto L_0x010d
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r7 = r6.f17536a
            r7.d()
            return
        L_0x010d:
            net.one97.paytm.paymentsBank.chequebook.landing.a.a$b r7 = r6.f17536a
            android.content.Context r0 = r6.f17543h
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "mContext.getString(R.string.error)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r1 = r6.f17543h
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "mContext.getString(R.str…omething_wrong_try_again)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r7.a((java.lang.String) r0, (java.lang.String) r1)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.landing.b.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }
}

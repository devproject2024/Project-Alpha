package net.one97.paytm.recharge.presentation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRCardDetails;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.domain.entities.CJRSavedInstrument;
import net.one97.paytm.recharge.presentation.d.c;
import net.one97.paytm.recharge.presentation.d.d;
import net.one97.paytm.recharge.presentation.f.f;

public final class h extends RecyclerView.a<f> implements d {

    /* renamed from: g  reason: collision with root package name */
    public static final a f64607g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public int f64608a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64609b;

    /* renamed from: c  reason: collision with root package name */
    public int f64610c;

    /* renamed from: d  reason: collision with root package name */
    public CJRPaymentModes f64611d = new CJRPaymentModes((String) null, (String) null, (ArrayList) null, false, (CJRFetchBalanceResponse) null, false, 63, (g) null);

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<CJRSavedInstrument> f64612e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<CJRPaymentModes> f64613f;

    /* renamed from: h  reason: collision with root package name */
    private String f64614h;

    /* renamed from: i  reason: collision with root package name */
    private String f64615i;
    private String j;
    private String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final c u;

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f1, code lost:
        if (kotlin.m.p.a(r6.l, r6.f64614h, false) == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0159, code lost:
        if (kotlin.m.p.a(r6.l, r6.f64614h, false) != false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a9, code lost:
        if (kotlin.m.p.a(r0, r6.n, true) == true) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ab, code lost:
        ((net.one97.paytm.recharge.presentation.f.k) r7).a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r7, int r8) {
        /*
            r6 = this;
            net.one97.paytm.recharge.presentation.f.f r7 = (net.one97.paytm.recharge.presentation.f.f) r7
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r7, r0)
            int r0 = r6.getItemViewType(r8)
            r1 = 2
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x0108
            r1 = 3
            java.lang.String r5 = "cjrPaymentModes!![newPosition]"
            if (r0 == r1) goto L_0x009f
            r1 = 4
            if (r0 == r1) goto L_0x002b
            r8 = 5
            if (r0 == r8) goto L_0x0025
            boolean r8 = r6.f64609b
            if (r8 != 0) goto L_0x0107
            r7.a(r2)
            goto L_0x0107
        L_0x0025:
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r8 = r6.f64611d
            r7.a(r8)
            return
        L_0x002b:
            int r0 = r6.a()
            int r8 = r8 - r0
            int r0 = r6.f64610c
            int r8 = r8 - r0
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPaymentModes> r0 = r6.f64613f
            if (r0 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            java.lang.Object r0 = r0.get(r8)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r0 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r0
            r7.a(r0)
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPaymentModes> r1 = r6.f64613f
            java.lang.Object r8 = r1.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r8 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r8
            java.lang.String r8 = r8.getPaymentMode()
            java.lang.String r1 = "BANK_MANDATE"
            boolean r8 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r4)
            if (r8 == 0) goto L_0x0107
            net.one97.paytm.recharge.presentation.f.g r7 = (net.one97.paytm.recharge.presentation.f.g) r7
            r7.a(r0)
            java.lang.String r8 = r0.getPaymentMode()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0085
            java.lang.String r8 = r0.getPaymentMode()
            java.lang.String r1 = r6.o
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r3)
            if (r8 == 0) goto L_0x0085
            java.lang.String r8 = r6.o
            java.lang.String r1 = r6.f64615i
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r3)
            if (r8 == 0) goto L_0x0085
            r7.a((boolean) r4)
            return
        L_0x0085:
            java.lang.String r8 = r0.getPaymentMode()
            java.lang.String r0 = r6.o
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 == 0) goto L_0x009e
            java.lang.String r8 = r6.o
            java.lang.String r0 = r6.f64615i
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 != 0) goto L_0x009e
            r7.a((boolean) r3)
        L_0x009e:
            return
        L_0x009f:
            int r0 = r6.a()
            int r8 = r8 - r0
            int r0 = r6.f64610c
            int r8 = r8 - r0
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPaymentModes> r0 = r6.f64613f
            if (r0 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            java.lang.Object r8 = r0.get(r8)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r8 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r8
            java.lang.String r0 = r8.getPaymentMode()
            java.lang.String r1 = "PPBL"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x0107
            net.one97.paytm.recharge.presentation.f.k r7 = (net.one97.paytm.recharge.presentation.f.k) r7
            r7.a(r8)
            java.lang.String r0 = r8.getPaymentMode()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ee
            java.lang.String r0 = r8.getPaymentMode()
            java.lang.String r1 = r6.o
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = r6.o
            java.lang.String r1 = r6.f64615i
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x00ee
            r7.a((boolean) r4)
            return
        L_0x00ee:
            java.lang.String r8 = r8.getPaymentMode()
            java.lang.String r0 = r6.o
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 == 0) goto L_0x0107
            java.lang.String r8 = r6.o
            java.lang.String r0 = r6.f64615i
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r3)
            if (r8 != 0) goto L_0x0107
            r7.a((boolean) r3)
        L_0x0107:
            return
        L_0x0108:
            int r0 = r6.f64610c
            int r8 = r8 - r0
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            if (r0 != 0) goto L_0x0112
            kotlin.g.b.k.a()
        L_0x0112:
            java.lang.Object r0 = r0.get(r8)
            r7.a(r0)
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x012c
            java.lang.String r0 = r0.getCardId()
            goto L_0x012d
        L_0x012c:
            r0 = r2
        L_0x012d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015b
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x0148
            java.lang.String r0 = r0.getCardId()
            goto L_0x0149
        L_0x0148:
            r0 = r2
        L_0x0149:
            java.lang.String r1 = r6.l
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x015b
            java.lang.String r0 = r6.l
            java.lang.String r1 = r6.f64614h
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 != 0) goto L_0x01ab
        L_0x015b:
            java.lang.String r0 = r6.m
            if (r0 == 0) goto L_0x01b1
            java.lang.String r1 = r6.j
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != r4) goto L_0x01b1
            java.lang.String r0 = r6.n
            if (r0 == 0) goto L_0x01b1
            java.lang.String r1 = r6.k
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != r4) goto L_0x01b1
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x0186
            java.lang.String r0 = r0.getFirstFourDigits()
            goto L_0x0187
        L_0x0186:
            r0 = r2
        L_0x0187:
            java.lang.String r1 = r6.m
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 == 0) goto L_0x01b1
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x01b1
            java.lang.String r0 = r0.getLastFourDigit()
            if (r0 == 0) goto L_0x01b1
            java.lang.String r1 = r6.n
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != r4) goto L_0x01b1
        L_0x01ab:
            net.one97.paytm.recharge.presentation.f.k r7 = (net.one97.paytm.recharge.presentation.f.k) r7
            r7.a((boolean) r4)
            return
        L_0x01b1:
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x01c4
            java.lang.String r0 = r0.getCardId()
            goto L_0x01c5
        L_0x01c4:
            r0 = r2
        L_0x01c5:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01f3
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x01e0
            java.lang.String r0 = r0.getCardId()
            goto L_0x01e1
        L_0x01e0:
            r0 = r2
        L_0x01e1:
            java.lang.String r1 = r6.l
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x01f3
            java.lang.String r0 = r6.l
            java.lang.String r1 = r6.f64614h
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r3)
            if (r0 == 0) goto L_0x0241
        L_0x01f3:
            java.lang.String r0 = r6.m
            if (r0 == 0) goto L_0x020b
            java.lang.String r1 = r6.j
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != r4) goto L_0x020b
            java.lang.String r0 = r6.n
            if (r0 == 0) goto L_0x020b
            java.lang.String r1 = r6.k
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 == r4) goto L_0x0247
        L_0x020b:
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r0 = r0.getCardDetails()
            if (r0 == 0) goto L_0x021d
            java.lang.String r2 = r0.getFirstFourDigits()
        L_0x021d:
            java.lang.String r0 = r6.m
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r4)
            if (r0 == 0) goto L_0x0247
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r6.f64612e
            java.lang.Object r8 = r0.get(r8)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r8 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r8
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r8 = r8.getCardDetails()
            if (r8 == 0) goto L_0x0247
            java.lang.String r8 = r8.getLastFourDigit()
            if (r8 == 0) goto L_0x0247
            java.lang.String r0 = r6.n
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r4)
            if (r8 != r4) goto L_0x0247
        L_0x0241:
            net.one97.paytm.recharge.presentation.f.k r7 = (net.one97.paytm.recharge.presentation.f.k) r7
            r7.a((boolean) r3)
        L_0x0247:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.a.h.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        f fVar;
        k.c(viewGroup, "parent");
        if (i2 == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_saved_card, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…aved_card, parent, false)");
            fVar = new net.one97.paytm.recharge.presentation.f.k(inflate, this.l, this.m, this.n, this.o, this, this.q, this.r, this.u);
        } else if (i2 == 3) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_saved_card, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…aved_card, parent, false)");
            fVar = new net.one97.paytm.recharge.presentation.f.k(inflate2, this.l, this.m, this.n, this.o, this, this.q, this.r, this.u);
        } else if (i2 == 4) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emandate, viewGroup, false);
            k.a((Object) inflate3, "LayoutInflater.from(pare…_emandate, parent, false)");
            fVar = new net.one97.paytm.recharge.presentation.f.g(inflate3, this.p, this, this.q, this.r, this.u);
        } else if (i2 != 5) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_add_new_card, viewGroup, false);
            k.a((Object) inflate4, "LayoutInflater.from(pare…_new_card, parent, false)");
            fVar = new b(inflate4, this, this.q, this.r, this.u);
        } else {
            View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emandate_selected, viewGroup, false);
            k.a((Object) inflate5, "LayoutInflater.from(pare…_selected, parent, false)");
            fVar = new net.one97.paytm.recharge.presentation.f.h(inflate5, this, this.f64615i, this.s, this.t, this.p);
        }
        return fVar;
    }

    public h(String str, String str2, String str3, String str4, String str5, ArrayList<CJRSavedInstrument> arrayList, ArrayList<CJRPaymentModes> arrayList2, String str6, String str7, String str8, String str9, c cVar) {
        k.c(cVar, "ijrPaymentOptionActionListener");
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.f64612e = arrayList;
        this.f64613f = arrayList2;
        this.q = str6;
        this.r = str7;
        this.s = str8;
        this.t = str9;
        this.u = cVar;
        String str10 = "";
        this.j = str10;
        this.k = str10;
        this.f64614h = this.l;
        String str11 = this.n;
        this.k = str11 == null ? str10 : str11;
        String str12 = this.m;
        this.j = str12 != null ? str12 : str10;
        this.f64615i = this.o;
        this.f64610c = p.a(SDKConstants.TYPE_BANK_MANDATE, this.p, true) ? 1 : 0;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getItemCount() {
        ArrayList<CJRSavedInstrument> arrayList = this.f64612e;
        int i2 = 0;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<CJRPaymentModes> arrayList2 = this.f64613f;
        if (arrayList2 != null) {
            i2 = arrayList2.size();
        }
        return size + i2 + 1 + this.f64610c;
    }

    public final int getItemViewType(int i2) {
        int i3 = this.f64610c;
        if (i3 > i2) {
            return 5;
        }
        ArrayList<CJRSavedInstrument> arrayList = this.f64612e;
        if (arrayList != null && i2 - i3 < arrayList.size()) {
            return 2;
        }
        if (this.f64613f != null && i2 >= 0 && (i2 - a()) - this.f64610c < this.f64613f.size()) {
            int a2 = (i2 - a()) - this.f64610c;
            if (p.a(SDKConstants.AI_KEY_PPBL, this.f64613f.get(a2).getPaymentMode(), true)) {
                return 3;
            }
            if (p.a(SDKConstants.TYPE_BANK_MANDATE, this.f64613f.get(a2).getPaymentMode(), true)) {
                return 4;
            }
        }
        return 1;
    }

    public final int a() {
        ArrayList<CJRSavedInstrument> arrayList = this.f64612e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void a(int i2, int i3) {
        String str;
        String str2;
        if (i3 == 2) {
            ArrayList<CJRSavedInstrument> arrayList = this.f64612e;
            if (arrayList == null) {
                k.a();
            }
            CJRCardDetails cardDetails = arrayList.get(i2 - this.f64610c).getCardDetails();
            this.f64614h = cardDetails != null ? cardDetails.getCardId() : null;
            ArrayList<CJRSavedInstrument> arrayList2 = this.f64612e;
            if (arrayList2 == null) {
                k.a();
            }
            CJRCardDetails cardDetails2 = arrayList2.get(i2 - this.f64610c).getCardDetails();
            if (cardDetails2 == null || (str = cardDetails2.getLastFourDigit()) == null) {
                str = "";
            }
            this.k = str;
            ArrayList<CJRSavedInstrument> arrayList3 = this.f64612e;
            if (arrayList3 == null) {
                k.a();
            }
            CJRCardDetails cardDetails3 = arrayList3.get(i2 - this.f64610c).getCardDetails();
            if (cardDetails3 == null || (str2 = cardDetails3.getFirstFourDigits()) == null) {
                str2 = "";
            }
            this.j = str2;
            this.f64615i = "";
            this.f64609b = false;
        } else if (i3 == 3) {
            this.f64614h = "";
            this.f64615i = this.o;
            this.f64609b = false;
            this.j = "";
            this.k = "";
        } else if (i3 == 4) {
            this.f64614h = "";
            this.j = "";
            this.k = "";
            this.f64615i = this.o;
            this.f64609b = false;
        } else if (i3 != 5) {
            this.f64614h = "";
            this.j = "";
            this.k = "";
            this.f64615i = "";
            this.f64609b = true;
        } else {
            this.f64614h = "";
            this.j = "";
            this.k = "";
            this.f64615i = this.o;
            this.f64609b = false;
            if (this.f64608a == -1) {
                this.f64608a = i2;
                return;
            }
        }
        if (this.f64608a != i2) {
            int itemCount = getItemCount();
            int i4 = this.f64608a;
            if (i4 >= 0 && itemCount > i4) {
                int itemViewType = getItemViewType(i4);
                if (itemViewType == 2) {
                    ArrayList<CJRSavedInstrument> arrayList4 = this.f64612e;
                    if (arrayList4 == null) {
                        k.a();
                    }
                    arrayList4.get(this.f64608a - this.f64610c).setSelected(false);
                } else if (itemViewType == 3) {
                    int a2 = (this.f64608a - a()) - this.f64610c;
                    ArrayList<CJRPaymentModes> arrayList5 = this.f64613f;
                    if (arrayList5 == null) {
                        k.a();
                    }
                    arrayList5.get(a2).setSelected(false);
                } else if (itemViewType == 4) {
                    int a3 = (this.f64608a - a()) - this.f64610c;
                    ArrayList<CJRPaymentModes> arrayList6 = this.f64613f;
                    if (arrayList6 == null) {
                        k.a();
                    }
                    arrayList6.get(a3).setSelected(false);
                } else if (itemViewType == 5) {
                    this.f64611d.setSelected(false);
                }
            }
        }
        notifyDataSetChanged();
        this.f64608a = i2;
    }
}

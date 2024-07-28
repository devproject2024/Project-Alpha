package net.one97.paytm.vipcashback.c;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.CashbackAllCards;
import net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.vipcashback.c.a.b;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;

public final class d extends ai {

    /* renamed from: a  reason: collision with root package name */
    public b f20727a;

    /* renamed from: b  reason: collision with root package name */
    public f f20728b;

    /* renamed from: c  reason: collision with root package name */
    public y<PostTxnScratchCardWrapper> f20729c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<com.paytm.network.a> f20730d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<NetworkCustomError> f20731e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<h<Object>> f20732f = new y<>();
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f20733g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public LiveData<String> f20734h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20735i;
    private String j;
    private String k;
    private String l;
    private int m;
    private List<Integer> n;
    /* access modifiers changed from: private */
    public int o;
    private boolean p;
    private VIPCashBackOfferV4 q;
    private ArrayList<ScratchCard> r;

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20736a;

        a(d dVar) {
            this.f20736a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            int i2 = hVar.f20893a;
            if (i2 == 101) {
                T t = hVar.f20894b;
                if (t instanceof CashbackAllCards) {
                    d.a(this.f20736a, (CashbackAllCards) t);
                    return "result";
                } else if (!(t instanceof CashBackBaseMyOfferModalV4)) {
                    return "result";
                } else {
                    d.a(this.f20736a, (CashBackBaseMyOfferModalV4) t);
                    return "result";
                }
            } else if (i2 != 102) {
                if (i2 != 104) {
                    return "result";
                }
                y d2 = this.f20736a.f20730d;
                T t2 = hVar.f20894b;
                if (t2 != null) {
                    d2.setValue((com.paytm.network.a) t2);
                    return "result";
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
            } else if (hVar.f20894b instanceof CashbackAllCards) {
                d dVar = this.f20736a;
                int unused = dVar.o;
                dVar.a();
                return "result";
            } else if (!(hVar.f20894b instanceof CashBackBaseMyOfferModalV4)) {
                return "result";
            } else {
                this.f20736a.f20733g.setValue(Boolean.FALSE);
                return "result";
            }
        }
    }

    public d() {
        LiveData<String> a2 = ah.a(this.f20732f, new a(this));
        k.a((Object) a2, "Transformations.map(apiR… }\n        \"result\"\n    }");
        this.f20734h = a2;
    }

    public final boolean a(String str, String str2, String str3) {
        List<Integer> list;
        this.j = str;
        this.k = str2;
        this.l = str3;
        if (this.f20728b != null) {
            if (this.f20728b == null) {
                k.a("mGTMHelper");
            }
            list = f.w();
        } else {
            list = new ArrayList<>();
        }
        this.n = list;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            List<Integer> list2 = this.n;
            if ((list2 != null ? list2.size() : 0) > this.m) {
                b bVar = this.f20727a;
                if (bVar == null) {
                    k.a("repository");
                }
                y<h<Object>> yVar = this.f20732f;
                List<Integer> list3 = this.n;
                Integer num = list3 != null ? list3.get(this.m) : null;
                if (num == null) {
                    k.a();
                }
                bVar.a(yVar, num.intValue(), this.m, str, str2, str3);
                this.m++;
                return true;
            }
        }
        return false;
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            str5 = str5 + "&transaction_type=" + str;
        }
        if (!TextUtils.isEmpty(str3)) {
            str5 = str5 + "&category_id=" + str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            str5 = str5 + "&merchant_category=" + str4;
        }
        if (TextUtils.isEmpty(str2)) {
            return str5;
        }
        return str5 + "&vertical_id=" + str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cd, code lost:
        if (r10.f20735i == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r1 = r1.getTxnLinked();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r10 = this;
            net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper r0 = new net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper
            r0.<init>()
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r1 = r10.r
            r0.scratchCards = r1
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r1 = r10.q
            r0.vipCashBackOfferV4 = r1
            r2 = 0
            if (r1 == 0) goto L_0x0015
            java.lang.String r1 = r1.getStatus()
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            net.one97.paytm.vipcashback.d.a$i$a r3 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.i.f20810c
            r4 = 0
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r4)
            r3 = 1
            if (r1 != 0) goto L_0x00b9
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r1 = r10.q
            if (r1 == 0) goto L_0x0033
            net.one97.paytm.cashback.posttxn.TxnLinked r1 = r1.getTxnLinked()
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = r1.getStage()
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r5 = r10.q
            if (r5 == 0) goto L_0x0080
            net.one97.paytm.cashback.posttxn.InfoV4 r5 = r5.getInfo()
            if (r5 == 0) goto L_0x0080
            java.util.ArrayList r5 = r5.getTransactions()
            if (r5 == 0) goto L_0x0080
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x0051:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x007c
            java.lang.Object r7 = r5.next()
            r8 = r7
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r8 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r8
            java.lang.String r9 = "it"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = r8.getStage()
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r1)
            if (r9 == 0) goto L_0x0075
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r8 = r8.getStages()
            if (r8 == 0) goto L_0x0075
            r8 = 1
            goto L_0x0076
        L_0x0075:
            r8 = 0
        L_0x0076:
            if (r8 == 0) goto L_0x0051
            r6.add(r7)
            goto L_0x0051
        L_0x007c:
            r1 = r6
            java.util.List r1 = (java.util.List) r1
            goto L_0x0081
        L_0x0080:
            r1 = r2
        L_0x0081:
            if (r1 == 0) goto L_0x0088
            int r5 = r1.size()
            goto L_0x0089
        L_0x0088:
            r5 = 0
        L_0x0089:
            if (r5 <= 0) goto L_0x009a
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r1.get(r4)
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r1 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r1
            if (r1 == 0) goto L_0x009a
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r1 = r1.getStages()
            goto L_0x009b
        L_0x009a:
            r1 = r2
        L_0x009b:
            if (r1 == 0) goto L_0x00a2
            java.lang.String r5 = r1.getStageStatus()
            goto L_0x00a3
        L_0x00a2:
            r5 = r2
        L_0x00a3:
            net.one97.paytm.vipcashback.d.a$k$a r6 = net.one97.paytm.vipcashback.d.a.k.f20825a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.k.f20827c
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00b9
            if (r1 == 0) goto L_0x00b5
            java.util.ArrayList r2 = r1.getGratification()
        L_0x00b5:
            if (r2 == 0) goto L_0x00b9
            r1 = 1
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            if (r1 == 0) goto L_0x00d0
            int r1 = r10.o
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r2 = r10.r
            if (r2 == 0) goto L_0x00c7
            int r2 = r2.size()
            goto L_0x00c8
        L_0x00c7:
            r2 = 0
        L_0x00c8:
            int r1 = r1 + r2
            if (r1 > 0) goto L_0x00d1
            boolean r1 = r10.f20735i
            if (r1 == 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r3 = 0
        L_0x00d1:
            r0.isStageComplete = r3
            boolean r1 = r10.p
            r0.openLandingScreen = r1
            androidx.lifecycle.y<net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper> r1 = r10.f20729c
            r1.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.c.d.a():void");
    }

    public static final /* synthetic */ void a(d dVar, CashbackAllCards cashbackAllCards) {
        String str;
        ScratchCard scratchCard;
        dVar.r = new ArrayList<>();
        ArrayList<ScratchCard> scratchCardList = cashbackAllCards.data.getScratchCardList();
        boolean z = true;
        if (cashbackAllCards.getStatus() == 1 && scratchCardList != null) {
            Iterator<ScratchCard> it2 = scratchCardList.iterator();
            while (true) {
                str = null;
                if (!it2.hasNext()) {
                    break;
                }
                ScratchCard next = it2.next();
                if (next != null) {
                    str = next.getScratchCardStatus();
                }
                a.j.C0391a aVar = a.j.f20817a;
                if (!k.a((Object) str, (Object) a.j.f20821e)) {
                    a.j.C0391a aVar2 = a.j.f20817a;
                    if (!k.a((Object) str, (Object) a.j.f20824h)) {
                    }
                }
                ArrayList<ScratchCard> arrayList = dVar.r;
                if (arrayList != null) {
                    arrayList.remove(next);
                }
                ArrayList<ScratchCard> arrayList2 = dVar.r;
                if (arrayList2 != null) {
                    arrayList2.add(0, next);
                }
            }
            ArrayList<ScratchCard> arrayList3 = dVar.r;
            if ((arrayList3 != null ? arrayList3.size() : 0) > 0) {
                ArrayList<ScratchCard> arrayList4 = dVar.r;
                if (!(arrayList4 == null || (scratchCard = arrayList4.get(0)) == null)) {
                    str = scratchCard.getScratchCardStatus();
                }
                a.j.C0391a aVar3 = a.j.f20817a;
                p.a(str, a.j.f20824h, false);
                ArrayList<ScratchCard> arrayList5 = dVar.r;
                if (arrayList5 != null) {
                    arrayList5.size();
                }
                dVar.a();
                return;
            }
            if (dVar.o != 0) {
                z = false;
            }
            dVar.p = z;
            dVar.a();
        } else if (cashbackAllCards.getErrors() != null && cashbackAllCards.getErrors().size() > 0) {
            dVar.a();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x003a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x00f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.vipcashback.c.d r10, net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4 r11) {
        /*
            boolean r0 = r11 instanceof net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4
            if (r0 == 0) goto L_0x0262
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r0 = r11.getData()
            r1 = 0
            r10.o = r1
            int r2 = r11.getStatus()
            r3 = 1
            if (r2 != r3) goto L_0x0206
            if (r0 == 0) goto L_0x0206
            net.one97.paytm.cashback.posttxn.TxnLinked r2 = r0.getTxnLinked()
            r4 = 0
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.getStage()
            goto L_0x0021
        L_0x0020:
            r2 = r4
        L_0x0021:
            net.one97.paytm.cashback.posttxn.InfoV4 r0 = r0.getInfo()
            if (r0 == 0) goto L_0x007c
            java.util.ArrayList r0 = r0.getTransactions()
            if (r0 == 0) goto L_0x007c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0078
            java.lang.Object r6 = r0.next()
            r7 = r6
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r7 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r7
            java.lang.String r8 = "txn"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r8 = r7.getStage()
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0071
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r7 = r7.getStages()
            if (r7 == 0) goto L_0x0071
            java.lang.String r7 = r7.getStageProgressConstruct()
            if (r7 == 0) goto L_0x0071
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x006c
            r7 = 1
            goto L_0x006d
        L_0x006c:
            r7 = 0
        L_0x006d:
            if (r7 != r3) goto L_0x0071
            r7 = 1
            goto L_0x0072
        L_0x0071:
            r7 = 0
        L_0x0072:
            if (r7 == 0) goto L_0x003a
            r5.add(r6)
            goto L_0x003a
        L_0x0078:
            r0 = r5
            java.util.List r0 = (java.util.List) r0
            goto L_0x007d
        L_0x007c:
            r0 = r4
        L_0x007d:
            if (r0 == 0) goto L_0x0084
            int r2 = r0.size()
            goto L_0x0085
        L_0x0084:
            r2 = 0
        L_0x0085:
            if (r2 <= 0) goto L_0x0090
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r0 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r0
            goto L_0x0091
        L_0x0090:
            r0 = r4
        L_0x0091:
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r11 = r11.getData()
            r10.q = r11
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r11 = r10.q
            if (r11 == 0) goto L_0x00a0
            java.lang.String r11 = r11.getStatus()
            goto L_0x00a1
        L_0x00a0:
            r11 = r4
        L_0x00a1:
            net.one97.paytm.vipcashback.d.a$i$a r2 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r2 = net.one97.paytm.vipcashback.d.a.i.f20810c
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r2, (boolean) r1)
            if (r11 == 0) goto L_0x00b1
            r10.a()
            return
        L_0x00b1:
            if (r0 == 0) goto L_0x0202
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r11 = r0.getStages()
            if (r11 == 0) goto L_0x0202
            java.lang.String r11 = r11.getStageStatus()
            if (r11 == 0) goto L_0x0202
            net.one97.paytm.vipcashback.d.a$k$a r2 = net.one97.paytm.vipcashback.d.a.k.f20825a
            java.lang.String r2 = net.one97.paytm.vipcashback.d.a.k.f20827c
            boolean r11 = r11.equals(r2)
            if (r11 != r3) goto L_0x0202
            java.lang.String r11 = ""
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r2 = r0.getStages()
            if (r2 == 0) goto L_0x00d8
            java.util.ArrayList r2 = r2.getGratification()
            goto L_0x00d9
        L_0x00d8:
            r2 = r4
        L_0x00d9:
            if (r2 == 0) goto L_0x01c0
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r2 = r0.getStages()
            if (r2 == 0) goto L_0x00e6
            java.util.ArrayList r2 = r2.getGratification()
            goto L_0x00e7
        L_0x00e6:
            r2 = r4
        L_0x00e7:
            if (r2 != 0) goto L_0x00ec
            kotlin.g.b.k.a()
        L_0x00ec:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
        L_0x00f9:
            boolean r6 = r2.hasNext()
            java.lang.String r7 = "gratificationItem.scratchCardInfo"
            if (r6 == 0) goto L_0x0135
            java.lang.Object r6 = r2.next()
            r8 = r6
            net.one97.paytm.cashback.posttxn.GratificationItem r8 = (net.one97.paytm.cashback.posttxn.GratificationItem) r8
            if (r8 == 0) goto L_0x010f
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r9 = r8.getScratchCardInfo()
            goto L_0x0110
        L_0x010f:
            r9 = r4
        L_0x0110:
            if (r9 == 0) goto L_0x012e
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r8 = r8.getScratchCardInfo()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            java.lang.String r7 = r8.getUnlockText()
            if (r7 == 0) goto L_0x012e
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0129
            r7 = 1
            goto L_0x012a
        L_0x0129:
            r7 = 0
        L_0x012a:
            if (r7 != 0) goto L_0x012e
            r7 = 1
            goto L_0x012f
        L_0x012e:
            r7 = 0
        L_0x012f:
            if (r7 == 0) goto L_0x00f9
            r5.add(r6)
            goto L_0x00f9
        L_0x0135:
            java.util.List r5 = (java.util.List) r5
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r2 = r5.isEmpty()
            r2 = r2 ^ r3
            r10.f20735i = r2
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r0 = r0.getStages()
            if (r0 == 0) goto L_0x014b
            java.util.ArrayList r0 = r0.getGratification()
            goto L_0x014c
        L_0x014b:
            r0 = r4
        L_0x014c:
            if (r0 != 0) goto L_0x0151
            kotlin.g.b.k.a()
        L_0x0151:
            java.util.Iterator r0 = r0.iterator()
        L_0x0155:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01c0
            java.lang.Object r2 = r0.next()
            net.one97.paytm.cashback.posttxn.GratificationItem r2 = (net.one97.paytm.cashback.posttxn.GratificationItem) r2
            if (r2 == 0) goto L_0x0168
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r5 = r2.getScratchCardInfo()
            goto L_0x0169
        L_0x0168:
            r5 = r4
        L_0x0169:
            if (r5 == 0) goto L_0x01ad
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r5 = r2.getScratchCardInfo()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            java.lang.String r5 = r5.getUnlockText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0183
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0181
            goto L_0x0183
        L_0x0181:
            r5 = 0
            goto L_0x0184
        L_0x0183:
            r5 = 1
        L_0x0184:
            if (r5 == 0) goto L_0x01ad
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            if (r2 == 0) goto L_0x0192
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r2 = r2.getScratchCardInfo()
            goto L_0x0193
        L_0x0192:
            r2 = r4
        L_0x0193:
            java.lang.String r6 = "gratificationItem?.scratchCardInfo"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r2 = r2.getId()
            r5.append(r2)
            r2 = 44
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r11 = kotlin.g.b.k.a((java.lang.String) r11, (java.lang.Object) r2)
            goto L_0x0155
        L_0x01ad:
            if (r2 == 0) goto L_0x01b4
            net.one97.paytm.cashback.posttxn.GameGratification r2 = r2.getGameGratification()
            goto L_0x01b5
        L_0x01b4:
            r2 = r4
        L_0x01b5:
            if (r2 == 0) goto L_0x01ba
            r10.f20735i = r3
            goto L_0x0155
        L_0x01ba:
            int r2 = r10.o
            int r2 = r2 + r3
            r10.o = r2
            goto L_0x0155
        L_0x01c0:
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01ce
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01cc
            goto L_0x01ce
        L_0x01cc:
            r0 = 0
            goto L_0x01cf
        L_0x01ce:
            r0 = 1
        L_0x01cf:
            if (r0 != 0) goto L_0x01fe
            int r0 = r11.length()
            if (r0 <= r3) goto L_0x01fe
            int r0 = r11.length()
            int r0 = r0 - r3
            if (r11 == 0) goto L_0x01f6
            java.lang.String r11 = r11.substring(r1, r0)
            java.lang.String r0 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            net.one97.paytm.vipcashback.c.a.b r0 = r10.f20727a
            if (r0 != 0) goto L_0x01f0
            java.lang.String r1 = "repository"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01f0:
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r10 = r10.f20732f
            r0.a(r10, r11)
            return
        L_0x01f6:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
            r10.<init>(r11)
            throw r10
        L_0x01fe:
            r10.a()
            return
        L_0x0202:
            r10.a()
            return
        L_0x0206:
            java.util.ArrayList r0 = r11.getErrors()
            if (r0 == 0) goto L_0x025b
            java.util.ArrayList r0 = r11.getErrors()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x025b
            java.util.ArrayList r0 = r11.getErrors()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r2 = "response.errors.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal r0 = (net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r0
            java.lang.Integer r0 = r0.getStatus()
            if (r0 != 0) goto L_0x022c
            goto L_0x025b
        L_0x022c:
            int r0 = r0.intValue()
            r2 = 404(0x194, float:5.66E-43)
            if (r0 != r2) goto L_0x025b
            java.util.ArrayList r11 = r11.getErrors()
            java.lang.Object r11 = r11.get(r1)
            java.lang.String r0 = "response.errors.get(\n   …      0\n                )"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal r11 = (net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r11
            java.lang.String r11 = r11.getErrorCode()
            java.lang.String r0 = "SUCASH_4001"
            boolean r11 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (boolean) r1)
            if (r11 == 0) goto L_0x025b
            java.lang.String r11 = r10.j
            java.lang.String r0 = r10.k
            java.lang.String r1 = r10.l
            boolean r11 = r10.a(r11, r0, r1)
            if (r11 != 0) goto L_0x0262
        L_0x025b:
            androidx.lifecycle.y<java.lang.Boolean> r10 = r10.f20733g
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r10.setValue(r11)
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.c.d.a(net.one97.paytm.vipcashback.c.d, net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4):void");
    }
}

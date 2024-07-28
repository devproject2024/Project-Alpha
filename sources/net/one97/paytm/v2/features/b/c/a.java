package net.one97.paytm.v2.features.b.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.CashbackDealData;
import net.one97.paytm.cashback.posttxn.CashbackStageItemV4;
import net.one97.paytm.cashback.posttxn.GameGratification;
import net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal;
import net.one97.paytm.cashback.posttxn.GratificationItem;
import net.one97.paytm.cashback.posttxn.ScratchCardInfo;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.common.entity.vipcashback.ScratchCardModel;
import net.one97.paytm.v2.a.d;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public d f20102a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ScratchCardData> f20103b;

    /* renamed from: c  reason: collision with root package name */
    public y<NetworkCustomError> f20104c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<com.paytm.network.a> f20105d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<ArrayList<ScratchCardData>> f20106e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<ScratchCardData> f20107f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<ScratchCard> f20108g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<h<Object>> f20109h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<Boolean> f20110i = new y<>();
    public y<h<Object>> j = new y<>();
    public LiveData<x> k;
    private ArrayList<ScratchCard> l;
    private VIPCashBackOfferV4 m;
    private y<CashbackDealData> n = new y<>();

    /* renamed from: net.one97.paytm.v2.features.b.c.a$a  reason: collision with other inner class name */
    static final class C0359a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20111a;

        C0359a(a aVar) {
            this.f20111a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            int i2 = hVar.f20893a;
            if (i2 == 101) {
                T t = hVar.f20894b;
                if (t instanceof ScratchCardModel) {
                    a.a(this.f20111a, (ScratchCardModel) t);
                } else if (t instanceof CashBackBaseMyOfferModalV4) {
                    a.a(this.f20111a, (CashBackBaseMyOfferModalV4) t);
                }
            } else if (i2 != 102) {
                if (i2 == 104) {
                    y c2 = this.f20111a.f20105d;
                    T t2 = hVar.f20894b;
                    if (t2 != null) {
                        c2.setValue((com.paytm.network.a) t2);
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
                    }
                }
            } else if (!(hVar.f20894b instanceof ScratchCardModel)) {
                if (hVar.f20894b instanceof CashBackBaseMyOfferModalV4) {
                    this.f20111a.j.setValue(hVar);
                } else {
                    y b2 = this.f20111a.f20104c;
                    Throwable th = hVar.f20895c;
                    if (th != null) {
                        b2.setValue((NetworkCustomError) th);
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                    }
                }
            }
            return x.f47997a;
        }
    }

    public a() {
        LiveData<x> a2 = ah.a(this.f20109h, new C0359a(this));
        k.a((Object) a2, "Transformations.map(apiR… }\n        \"result\"\n    }");
        this.k = a2;
    }

    public final void a(VIPCashBackOfferV4 vIPCashBackOfferV4, ArrayList<ScratchCard> arrayList) {
        this.l = arrayList;
        this.m = vIPCashBackOfferV4;
        this.f20107f.setValue(null);
        this.f20108g.setValue(null);
        a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getTxnLinked();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r8 = this;
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r0 = r8.m
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.cashback.posttxn.TxnLinked r0 = r0.getTxnLinked()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getStage()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r2 = r8.m
            r3 = 0
            if (r2 == 0) goto L_0x005e
            net.one97.paytm.cashback.posttxn.InfoV4 r2 = r2.getInfo()
            if (r2 == 0) goto L_0x005e
            java.util.ArrayList r2 = r2.getTransactions()
            if (r2 == 0) goto L_0x005e
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x002f:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x005a
            java.lang.Object r5 = r2.next()
            r6 = r5
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r6 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r6
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getStage()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x0053
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r6 = r6.getStages()
            if (r6 == 0) goto L_0x0053
            r6 = 1
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            if (r6 == 0) goto L_0x002f
            r4.add(r5)
            goto L_0x002f
        L_0x005a:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            if (r0 == 0) goto L_0x0066
            int r2 = r0.size()
            goto L_0x0067
        L_0x0066:
            r2 = 0
        L_0x0067:
            if (r2 <= 0) goto L_0x0078
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r0 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r0
            if (r0 == 0) goto L_0x0078
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r0 = r0.getStages()
            goto L_0x0079
        L_0x0078:
            r0 = r1
        L_0x0079:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r4 = r8.l
            if (r4 == 0) goto L_0x00d0
            if (r4 != 0) goto L_0x0087
            kotlin.g.b.k.a()
        L_0x0087:
            java.util.Iterator r4 = r4.iterator()
        L_0x008b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d0
            java.lang.Object r5 = r4.next()
            net.one97.paytm.common.entity.vipcashback.ScratchCard r5 = (net.one97.paytm.common.entity.vipcashback.ScratchCard) r5
            java.lang.String r6 = "item"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = r8.a((net.one97.paytm.common.entity.vipcashback.ScratchCard) r5)
            if (r6 == 0) goto L_0x008b
            java.lang.String r7 = r5.getCardHeadline()
            if (r7 != 0) goto L_0x00a9
            r7 = r1
        L_0x00a9:
            r6.cardHeadline = r7
            java.lang.Boolean r7 = r5.getLuckyDraw()
            if (r7 == 0) goto L_0x00b6
            boolean r7 = r7.booleanValue()
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r6.luckyDraw = r7
            java.lang.String r7 = r5.getRedemptionMaxAmount()
            if (r7 != 0) goto L_0x00c4
            r7 = r1
        L_0x00c4:
            r6.redemptionMaxAmount = r7
            java.lang.String r5 = r5.getId()
            r6.scratchCardId = r5
            r2.add(r6)
            goto L_0x008b
        L_0x00d0:
            if (r0 == 0) goto L_0x00d7
            java.lang.String r3 = r0.getStageStatus()
            goto L_0x00d8
        L_0x00d7:
            r3 = r1
        L_0x00d8:
            net.one97.paytm.vipcashback.d.a$k$a r4 = net.one97.paytm.vipcashback.d.a.k.f20825a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.k.f20827c
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00fe
            if (r0 == 0) goto L_0x00ea
            java.util.ArrayList r1 = r0.getGratification()
        L_0x00ea:
            if (r1 == 0) goto L_0x00fe
            java.util.ArrayList r1 = a((net.one97.paytm.cashback.posttxn.CashbackStageItemV4) r0)
            java.util.Collection r1 = (java.util.Collection) r1
            r2.addAll(r1)
            java.util.ArrayList r0 = r8.b((net.one97.paytm.cashback.posttxn.CashbackStageItemV4) r0)
            java.util.Collection r0 = (java.util.Collection) r0
            r2.addAll(r0)
        L_0x00fe:
            int r0 = r2.size()
            if (r0 > 0) goto L_0x010c
            androidx.lifecycle.y<java.lang.Boolean> r0 = r8.f20110i
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.setValue(r1)
            return
        L_0x010c:
            r8.f20103b = r2
            androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCardData>> r0 = r8.f20106e
            r0.setValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.a():void");
    }

    private static ArrayList<ScratchCardData> a(CashbackStageItemV4 cashbackStageItemV4) {
        ArrayList<GratificationItem> gratification = cashbackStageItemV4 != null ? cashbackStageItemV4.getGratification() : null;
        ArrayList<ScratchCardData> arrayList = new ArrayList<>();
        if (gratification != null) {
            Iterator<GratificationItem> it2 = gratification.iterator();
            while (it2.hasNext()) {
                GratificationItem next = it2.next();
                k.a((Object) next, "gratification");
                if (next.getScratchCardInfo() != null) {
                    ScratchCardInfo scratchCardInfo = next.getScratchCardInfo();
                    k.a((Object) scratchCardInfo, "gratification.scratchCardInfo");
                    CharSequence unlockText = scratchCardInfo.getUnlockText();
                    if (!(unlockText == null || unlockText.length() == 0)) {
                        ScratchCardData scratchCardData = new ScratchCardData();
                        scratchCardData.isLockedCard = true;
                        ScratchCardInfo scratchCardInfo2 = next.getScratchCardInfo();
                        k.a((Object) scratchCardInfo2, "gratification.scratchCardInfo");
                        scratchCardData.description = scratchCardInfo2.getUnlockText();
                        ScratchCardInfo scratchCardInfo3 = next.getScratchCardInfo();
                        k.a((Object) scratchCardInfo3, "gratification.scratchCardInfo");
                        scratchCardData.scratchCardId = scratchCardInfo3.getId();
                        arrayList.add(scratchCardData);
                    }
                }
                if (next.getGameGratification() != null) {
                    ScratchCardData scratchCardData2 = new ScratchCardData();
                    scratchCardData2.isGame = true;
                    GameGratification gameGratification = next.getGameGratification();
                    k.a((Object) gameGratification, "gratification.gameGratification");
                    scratchCardData2.description = gameGratification.getUnlock_text();
                    GameGratification gameGratification2 = next.getGameGratification();
                    k.a((Object) gameGratification2, "gratification.gameGratification");
                    scratchCardData2.scratchCardImage = gameGratification2.getOffer_image_url();
                    arrayList.add(scratchCardData2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a6, code lost:
        if (r3.equals(net.one97.paytm.vipcashback.d.a.f.f20794c) != true) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ba, code lost:
        if (r3.equals(net.one97.paytm.vipcashback.d.a.f.f20793b) != true) goto L_0x00bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final net.one97.paytm.common.entity.vipcashback.ScratchCardData a(net.one97.paytm.common.entity.vipcashback.ScratchCard r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x0017
            java.lang.String r2 = r6.getDisplayType()
            if (r2 == 0) goto L_0x0017
            net.one97.paytm.vipcashback.d.a$e$a r3 = net.one97.paytm.vipcashback.d.a.e.f20790a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.e.f20791b
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 != 0) goto L_0x0017
            return r0
        L_0x0017:
            if (r6 == 0) goto L_0x0039
            java.lang.String r2 = r6.getScratchCardStatus()
            if (r2 == 0) goto L_0x0039
            net.one97.paytm.vipcashback.d.a$j$a r3 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.j.f20824h
            boolean r2 = r2.equals(r3)
            if (r2 != r1) goto L_0x0039
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r0.isLockedCard = r1
            java.lang.String r6 = r6.getUnlockText()
            r0.description = r6
            return r0
        L_0x0039:
            java.lang.String r2 = "COLLECTIBLE"
            if (r6 == 0) goto L_0x0062
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x0062
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0062
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r3 = r6.getRedemptionMetaData()
            if (r3 == 0) goto L_0x0062
            java.lang.String r3 = r3.getAmount()
            if (r3 == 0) goto L_0x0062
            java.lang.String r4 = "0"
            boolean r3 = r3.equals(r4)
            if (r3 != r1) goto L_0x0062
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = b((net.one97.paytm.common.entity.vipcashback.ScratchCard) r6)
            return r6
        L_0x0062:
            if (r6 == 0) goto L_0x007b
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x007b
            net.one97.paytm.vipcashback.d.a$f$a r4 = net.one97.paytm.vipcashback.d.a.f.f20792a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.f.f20795d
            boolean r3 = r3.equals(r4)
            if (r3 != r1) goto L_0x007b
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = d(r6)
            return r6
        L_0x007b:
            if (r6 == 0) goto L_0x0094
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x0094
            net.one97.paytm.vipcashback.d.a$f$a r4 = net.one97.paytm.vipcashback.d.a.f.f20792a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.f.f20796e
            boolean r3 = r3.equals(r4)
            if (r3 != r1) goto L_0x0094
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = c((net.one97.paytm.common.entity.vipcashback.ScratchCard) r6)
            return r6
        L_0x0094:
            if (r6 == 0) goto L_0x00a8
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00a8
            net.one97.paytm.vipcashback.d.a$f$a r4 = net.one97.paytm.vipcashback.d.a.f.f20792a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.f.f20794c
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00a8:
            if (r6 == 0) goto L_0x00bc
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00bc
            net.one97.paytm.vipcashback.d.a$f$a r4 = net.one97.paytm.vipcashback.d.a.f.f20792a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.f.f20793b
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00bc:
            if (r6 == 0) goto L_0x00cc
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00cc
            java.lang.String r4 = "COINS"
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00cc:
            if (r6 == 0) goto L_0x00dc
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00dc
            java.lang.String r4 = "UPI"
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00dc:
            if (r6 == 0) goto L_0x00ec
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00ec
            java.lang.String r4 = "PPBL"
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00ec:
            if (r6 == 0) goto L_0x00fc
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x00fc
            java.lang.String r4 = "GV_CASHBACK"
            boolean r3 = r3.equals(r4)
            if (r3 == r1) goto L_0x010c
        L_0x00fc:
            if (r6 == 0) goto L_0x0111
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x0111
            java.lang.String r4 = "PG_CASHBACK"
            boolean r3 = r3.equals(r4)
            if (r3 != r1) goto L_0x0111
        L_0x010c:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = f(r6)
            return r6
        L_0x0111:
            if (r6 == 0) goto L_0x0124
            java.lang.String r3 = r6.getRedemptionType()
            if (r3 == 0) goto L_0x0124
            boolean r2 = r3.equals(r2)
            if (r2 != r1) goto L_0x0124
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r6 = r5.e(r6)
            return r6
        L_0x0124:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.a(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (r2.equals(net.one97.paytm.vipcashback.d.a.h.f20804c) != true) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (r2.equals(net.one97.paytm.vipcashback.d.a.h.f20803b) != true) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if (r2.equals(net.one97.paytm.vipcashback.d.a.h.f20807f) != true) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCardData> b(net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r8) {
        /*
            r7 = this;
            java.util.ArrayList r8 = r8.getGratification()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x000d:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0225
            java.lang.Object r1 = r8.next()
            net.one97.paytm.cashback.posttxn.GratificationItem r1 = (net.one97.paytm.cashback.posttxn.GratificationItem) r1
            java.lang.String r2 = "gratification"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r2 = r1.getScratchCardInfo()
            if (r2 != 0) goto L_0x000d
            java.lang.String r2 = r1.getRedemptionType()
            r3 = 1
            if (r2 == 0) goto L_0x0047
            java.lang.String r4 = "COLLECTIBLE"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0047
            net.one97.paytm.cashback.posttxn.GameGratification r2 = r1.getGameGratification()
            if (r2 != 0) goto L_0x0047
            java.lang.String r2 = r1.getBonusAmount()
            if (r2 == 0) goto L_0x0047
            java.lang.String r4 = "0"
            boolean r2 = r2.equals(r4)
            if (r2 == r3) goto L_0x000d
        L_0x0047:
            java.lang.String r2 = r1.getRedemptionType()
            java.lang.String r4 = "coins"
            r5 = 0
            if (r2 == 0) goto L_0x005c
            net.one97.paytm.vipcashback.d.a$h$a r6 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.h.f20804c
            boolean r2 = r2.equals(r6)
            if (r2 == r3) goto L_0x009a
        L_0x005c:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x006e
            net.one97.paytm.vipcashback.d.a$h$a r6 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.h.f20803b
            boolean r2 = r2.equals(r6)
            if (r2 == r3) goto L_0x009a
        L_0x006e:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x007a
            boolean r2 = r2.equals(r4)
            if (r2 == r3) goto L_0x009a
        L_0x007a:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x008c
            net.one97.paytm.vipcashback.d.a$h$a r6 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.h.f20807f
            boolean r2 = r2.equals(r6)
            if (r2 == r3) goto L_0x009a
        L_0x008c:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x0104
            java.lang.String r6 = "gvcashback"
            boolean r2 = r2.equals(r6)
            if (r2 != r3) goto L_0x0104
        L_0x009a:
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r2 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r2.<init>()
            net.one97.paytm.vipcashback.d.a$i$a r6 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r2.state = r6
            if (r1 == 0) goto L_0x00ae
            java.lang.String r6 = r1.getProgressText()
            goto L_0x00af
        L_0x00ae:
            r6 = r5
        L_0x00af:
            r2.mWinningText = r6
            if (r1 == 0) goto L_0x00b8
            java.lang.String r6 = r1.getBonusAmount()
            goto L_0x00b9
        L_0x00b8:
            r6 = r5
        L_0x00b9:
            r2.mCashBackAmount = r6
            if (r1 == 0) goto L_0x00c2
            java.lang.String r6 = r1.getFrontendRedemptionType()
            goto L_0x00c3
        L_0x00c2:
            r6 = r5
        L_0x00c3:
            r2.frontEndRedemptionType = r6
            if (r1 == 0) goto L_0x00cc
            java.lang.String r6 = r1.getRedemptionText()
            goto L_0x00cd
        L_0x00cc:
            r6 = r5
        L_0x00cd:
            r2.redemptionText = r6
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r6 = r7.m
            if (r6 == 0) goto L_0x00e3
            net.one97.paytm.cashback.posttxn.InfoV4 r6 = r6.getInfo()
            if (r6 == 0) goto L_0x00e3
            net.one97.paytm.cashback.posttxn.Campaign r6 = r6.getCampaign()
            if (r6 == 0) goto L_0x00e3
            java.lang.String r5 = r6.getOfferTextOverride()
        L_0x00e3:
            r2.offerName = r5
            net.one97.paytm.vipcashback.d.a$h$a r5 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r5 = net.one97.paytm.vipcashback.d.a.h.f20804c
            r2.redemptionType = r5
            if (r1 == 0) goto L_0x00fc
            java.lang.String r1 = r1.getRedemptionType()
            if (r1 == 0) goto L_0x00fc
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r3 = 0
        L_0x00fd:
            r2.keepRupeeSign = r3
            r0.add(r2)
            goto L_0x000d
        L_0x0104:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x018f
            net.one97.paytm.vipcashback.d.a$h$a r4 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.h.f20805d
            boolean r2 = r2.equals(r4)
            if (r2 != r3) goto L_0x018f
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r2 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r2.<init>()
            net.one97.paytm.vipcashback.d.a$i$a r4 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r2.state = r4
            if (r1 == 0) goto L_0x012a
            net.one97.paytm.cashback.posttxn.CashbackCrossPromoData r4 = r1.getCashbackCrossPromoData()
            goto L_0x012b
        L_0x012a:
            r4 = r5
        L_0x012b:
            if (r4 == 0) goto L_0x0132
            java.lang.String r6 = r4.getCrossPromocodeIcon()
            goto L_0x0133
        L_0x0132:
            r6 = r5
        L_0x0133:
            r2.mThumbnail = r6
            if (r1 == 0) goto L_0x013c
            java.lang.String r6 = r1.getProgressText()
            goto L_0x013d
        L_0x013c:
            r6 = r5
        L_0x013d:
            r2.mWinningText = r6
            if (r1 == 0) goto L_0x0146
            java.lang.String r6 = r1.getBonusAmount()
            goto L_0x0147
        L_0x0146:
            r6 = r5
        L_0x0147:
            r2.mCashBackAmount = r6
            if (r4 == 0) goto L_0x0150
            java.lang.String r6 = r4.getFrontendRedemptionType()
            goto L_0x0151
        L_0x0150:
            r6 = r5
        L_0x0151:
            r2.frontEndRedemptionType = r6
            net.one97.paytm.vipcashback.d.a$h$a r6 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.h.f20805d
            r2.redemptionType = r6
            r2.isAssured = r3
            java.lang.String r3 = "crossPromo"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.lang.String r3 = r4.getCrossPromoCode()
            r2.detailId = r3
            java.lang.String r3 = r4.getSiteId()
            r2.siteId = r3
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r3 = r7.m
            if (r3 == 0) goto L_0x0182
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r3.getInfo()
            if (r3 == 0) goto L_0x0182
            net.one97.paytm.cashback.posttxn.Campaign r3 = r3.getCampaign()
            if (r3 == 0) goto L_0x0182
            java.lang.String r5 = r3.getOfferTextOverride()
        L_0x0182:
            r2.offerName = r5
            java.lang.String r1 = r1.getRedemptionText()
            r2.redemptionText = r1
            r0.add(r2)
            goto L_0x000d
        L_0x018f:
            java.lang.String r2 = r1.getRedemptionType()
            if (r2 == 0) goto L_0x000d
            net.one97.paytm.vipcashback.d.a$h$a r4 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.h.f20806e
            boolean r2 = r2.equals(r4)
            if (r2 != r3) goto L_0x000d
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r2 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r2.<init>()
            net.one97.paytm.vipcashback.d.a$i$a r4 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r2.state = r4
            if (r1 == 0) goto L_0x01b5
            net.one97.paytm.cashback.posttxn.CashbackDealData r4 = r1.getCashbackDealData()
            goto L_0x01b6
        L_0x01b5:
            r4 = r5
        L_0x01b6:
            if (r4 == 0) goto L_0x01bd
            java.lang.String r6 = r4.getDealIcon()
            goto L_0x01be
        L_0x01bd:
            r6 = r5
        L_0x01be:
            r2.mThumbnail = r6
            if (r1 == 0) goto L_0x01c7
            java.lang.String r6 = r1.getProgressText()
            goto L_0x01c8
        L_0x01c7:
            r6 = r5
        L_0x01c8:
            r2.mWinningText = r6
            if (r1 == 0) goto L_0x01d1
            java.lang.String r6 = r1.getBonusAmount()
            goto L_0x01d2
        L_0x01d1:
            r6 = r5
        L_0x01d2:
            r2.mCashBackAmount = r6
            if (r4 == 0) goto L_0x01db
            java.lang.String r6 = r4.getFrontendRedemptionType()
            goto L_0x01dc
        L_0x01db:
            r6 = r5
        L_0x01dc:
            r2.frontEndRedemptionType = r6
            net.one97.paytm.vipcashback.d.a$h$a r6 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r6 = net.one97.paytm.vipcashback.d.a.h.f20806e
            r2.redemptionType = r6
            r2.isAssured = r3
            java.lang.String r6 = "dealData"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r4 = r4.getId()
            r2.detailId = r4
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r4 = r7.m
            if (r4 == 0) goto L_0x0207
            net.one97.paytm.cashback.posttxn.InfoV4 r4 = r4.getInfo()
            if (r4 == 0) goto L_0x0207
            net.one97.paytm.cashback.posttxn.Campaign r4 = r4.getCampaign()
            if (r4 == 0) goto L_0x0207
            java.lang.String r5 = r4.getOfferTextOverride()
        L_0x0207:
            r2.offerName = r5
            java.lang.String r4 = r1.getRedemptionText()
            r2.redemptionText = r4
            if (r1 == 0) goto L_0x0220
            java.lang.String r1 = r1.getRedemptionStatus()
            if (r1 == 0) goto L_0x0220
            net.one97.paytm.vipcashback.d.a$g$a r4 = net.one97.paytm.vipcashback.d.a.g.f20797a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.g.f20800d
            kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
        L_0x0220:
            r0.add(r2)
            goto L_0x000d
        L_0x0225:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.b(net.one97.paytm.cashback.posttxn.CashbackStageItemV4):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r4 = r7.getRedemptionMetaData();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.vipcashback.ScratchCardData b(net.one97.paytm.common.entity.vipcashback.ScratchCard r7) {
        /*
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r1 = 1
            r0.isBetterLuck = r1
            r2 = 0
            if (r7 == 0) goto L_0x001f
            java.lang.String r3 = r7.getScratchCardStatus()
            if (r3 == 0) goto L_0x001f
            net.one97.paytm.vipcashback.d.a$j$a r4 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.j.f20821e
            boolean r3 = r3.equals(r4)
            if (r3 != r1) goto L_0x001f
            r3 = 1
            goto L_0x0020
        L_0x001f:
            r3 = 0
        L_0x0020:
            r0.isScratchCard = r3
            net.one97.paytm.vipcashback.d.a$i$a r3 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r0.state = r3
            r3 = 0
            if (r7 == 0) goto L_0x0038
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r4 = r7.getRedemptionMetaData()
            if (r4 == 0) goto L_0x0038
            java.lang.String r4 = r4.getRedemptionIconUrl()
            goto L_0x0039
        L_0x0038:
            r4 = r3
        L_0x0039:
            r0.mThumbnail = r4
            java.lang.String r4 = ""
            if (r7 == 0) goto L_0x0045
            java.lang.String r5 = r7.getWinningText()
            if (r5 != 0) goto L_0x0046
        L_0x0045:
            r5 = r4
        L_0x0046:
            r0.redemptionText = r5
            java.lang.String r5 = r0.redemptionText
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0057
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r5 = 0
            goto L_0x0058
        L_0x0057:
            r5 = 1
        L_0x0058:
            if (r5 == 0) goto L_0x0067
            if (r7 == 0) goto L_0x0064
            java.lang.String r5 = r7.getFlipText()
            if (r5 != 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r4 = r5
        L_0x0064:
            r0.redemptionText = r4
            goto L_0x0095
        L_0x0067:
            java.lang.String r5 = r0.redemptionText
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "\n"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            if (r7 == 0) goto L_0x008c
            java.lang.String r5 = r7.getFlipText()
            if (r5 != 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r4 = r5
        L_0x008c:
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r0.redemptionText = r4
        L_0x0095:
            if (r7 == 0) goto L_0x009c
            java.lang.String r4 = r7.getFrontendRedemptionType()
            goto L_0x009d
        L_0x009c:
            r4 = r3
        L_0x009d:
            r0.frontEndRedemptionType = r4
            if (r7 == 0) goto L_0x00ab
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r4 = r7.getRedemptionMetaData()
            if (r4 == 0) goto L_0x00ab
            boolean r2 = r4.isFlip()
        L_0x00ab:
            if (r2 == 0) goto L_0x00b9
            r0.isFlip = r1
            if (r7 == 0) goto L_0x00b6
            java.lang.String r1 = r7.getFlipCtaText()
            goto L_0x00b7
        L_0x00b6:
            r1 = r3
        L_0x00b7:
            r0.redemptionCTA = r1
        L_0x00b9:
            if (r7 == 0) goto L_0x00bf
            java.lang.String r3 = r7.getReferenceId()
        L_0x00bf:
            r0.refrenceId = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.b(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r2.equals(net.one97.paytm.vipcashback.d.a.j.f20821e) == true) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r2 = r4.getExtraInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.vipcashback.ScratchCardData c(net.one97.paytm.common.entity.vipcashback.ScratchCard r4) {
        /*
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r1 = 1
            if (r4 == 0) goto L_0x001b
            java.lang.String r2 = r4.getScratchCardStatus()
            if (r2 == 0) goto L_0x001b
            net.one97.paytm.vipcashback.d.a$j$a r3 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.j.f20821e
            boolean r2 = r2.equals(r3)
            if (r2 != r1) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r0.isScratchCard = r1
            net.one97.paytm.vipcashback.d.a$i$a r1 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r0.state = r1
            r1 = 0
            if (r4 == 0) goto L_0x0034
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r2 = r4.getExtraInfo()
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = r2.getDealIcon()
            goto L_0x0035
        L_0x0034:
            r2 = r1
        L_0x0035:
            if (r2 != 0) goto L_0x0044
            if (r4 == 0) goto L_0x0051
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r2 = r4.getRedemptionMetaData()
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = r2.getRedemptionIconUrl()
            goto L_0x0052
        L_0x0044:
            if (r4 == 0) goto L_0x0051
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r2 = r4.getExtraInfo()
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = r2.getDealIcon()
            goto L_0x0052
        L_0x0051:
            r2 = r1
        L_0x0052:
            r0.mThumbnail = r2
            if (r4 == 0) goto L_0x005b
            java.lang.String r2 = r4.getWinningText()
            goto L_0x005c
        L_0x005b:
            r2 = r1
        L_0x005c:
            r0.mWinningText = r2
            if (r4 == 0) goto L_0x006b
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r2 = r4.getRedemptionMetaData()
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = r2.getAmount()
            goto L_0x006c
        L_0x006b:
            r2 = r1
        L_0x006c:
            r0.mCashBackAmount = r2
            if (r4 == 0) goto L_0x0075
            java.lang.String r2 = r4.getFrontendRedemptionType()
            goto L_0x0076
        L_0x0075:
            r2 = r1
        L_0x0076:
            r0.frontEndRedemptionType = r2
            net.one97.paytm.vipcashback.d.a$h$a r2 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r2 = net.one97.paytm.vipcashback.d.a.h.f20806e
            r0.redemptionType = r2
            if (r4 == 0) goto L_0x008c
            net.one97.paytm.common.entity.vipcashback.SourceMetaData r2 = r4.getSourceMetaData()
            if (r2 == 0) goto L_0x008c
            java.lang.String r1 = r2.getOfferName()
        L_0x008c:
            r0.offerName = r1
            a((net.one97.paytm.common.entity.vipcashback.ScratchCardData) r0, (net.one97.paytm.common.entity.vipcashback.ScratchCard) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.c(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r2.equals(net.one97.paytm.vipcashback.d.a.j.f20821e) == true) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r2 = r4.getExtraInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.vipcashback.ScratchCardData d(net.one97.paytm.common.entity.vipcashback.ScratchCard r4) {
        /*
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r1 = 1
            if (r4 == 0) goto L_0x001b
            java.lang.String r2 = r4.getScratchCardStatus()
            if (r2 == 0) goto L_0x001b
            net.one97.paytm.vipcashback.d.a$j$a r3 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.j.f20821e
            boolean r2 = r2.equals(r3)
            if (r2 != r1) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r0.isScratchCard = r1
            net.one97.paytm.vipcashback.d.a$i$a r1 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r1 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r0.state = r1
            r1 = 0
            if (r4 == 0) goto L_0x0034
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r2 = r4.getExtraInfo()
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = r2.getCross_promocode_icon()
            goto L_0x0035
        L_0x0034:
            r2 = r1
        L_0x0035:
            if (r2 != 0) goto L_0x0044
            if (r4 == 0) goto L_0x0051
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r2 = r4.getRedemptionMetaData()
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = r2.getRedemptionIconUrl()
            goto L_0x0052
        L_0x0044:
            if (r4 == 0) goto L_0x0051
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r2 = r4.getExtraInfo()
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = r2.getCross_promocode_icon()
            goto L_0x0052
        L_0x0051:
            r2 = r1
        L_0x0052:
            r0.mThumbnail = r2
            if (r4 == 0) goto L_0x005b
            java.lang.String r2 = r4.getWinningText()
            goto L_0x005c
        L_0x005b:
            r2 = r1
        L_0x005c:
            r0.mWinningText = r2
            if (r4 == 0) goto L_0x006b
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r2 = r4.getRedemptionMetaData()
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = r2.getAmount()
            goto L_0x006c
        L_0x006b:
            r2 = r1
        L_0x006c:
            r0.mCashBackAmount = r2
            if (r4 == 0) goto L_0x0075
            java.lang.String r2 = r4.getFrontendRedemptionType()
            goto L_0x0076
        L_0x0075:
            r2 = r1
        L_0x0076:
            r0.frontEndRedemptionType = r2
            net.one97.paytm.vipcashback.d.a$h$a r2 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r2 = net.one97.paytm.vipcashback.d.a.h.f20805d
            r4.setRedemptionType(r2)
            if (r4 == 0) goto L_0x008d
            net.one97.paytm.common.entity.vipcashback.SourceMetaData r2 = r4.getSourceMetaData()
            if (r2 == 0) goto L_0x008d
            java.lang.String r1 = r2.getOfferName()
        L_0x008d:
            r0.offerName = r1
            a((net.one97.paytm.common.entity.vipcashback.ScratchCardData) r0, (net.one97.paytm.common.entity.vipcashback.ScratchCard) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.d(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(net.one97.paytm.common.entity.vipcashback.ScratchCardData r3, net.one97.paytm.common.entity.vipcashback.ScratchCard r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0008
            java.lang.String r1 = r4.getEarnedFor()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r1 == 0) goto L_0x003a
            if (r4 == 0) goto L_0x0012
            java.lang.String r1 = r4.getRedemptionText()
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r1 == 0) goto L_0x003a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            if (r4 == 0) goto L_0x0021
            java.lang.String r2 = r4.getEarnedFor()
            goto L_0x0022
        L_0x0021:
            r2 = r0
        L_0x0022:
            r1.append(r2)
            java.lang.String r2 = ". "
            r1.append(r2)
            if (r4 == 0) goto L_0x0031
            java.lang.String r2 = r4.getRedemptionText()
            goto L_0x0032
        L_0x0031:
            r2 = r0
        L_0x0032:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L_0x0060
        L_0x003a:
            if (r4 == 0) goto L_0x0041
            java.lang.String r1 = r4.getEarnedFor()
            goto L_0x0042
        L_0x0041:
            r1 = r0
        L_0x0042:
            if (r1 == 0) goto L_0x004d
            if (r4 == 0) goto L_0x004b
            java.lang.String r1 = r4.getEarnedFor()
            goto L_0x0060
        L_0x004b:
            r1 = r0
            goto L_0x0060
        L_0x004d:
            if (r4 == 0) goto L_0x0054
            java.lang.String r1 = r4.getRedemptionText()
            goto L_0x0055
        L_0x0054:
            r1 = r0
        L_0x0055:
            if (r1 == 0) goto L_0x005e
            if (r4 == 0) goto L_0x004b
            java.lang.String r1 = r4.getRedemptionText()
            goto L_0x0060
        L_0x005e:
            java.lang.String r1 = ""
        L_0x0060:
            r3.redemptionText = r1
            if (r4 == 0) goto L_0x0069
            java.lang.String r1 = r4.getRedemptionCtaText()
            goto L_0x006a
        L_0x0069:
            r1 = r0
        L_0x006a:
            r3.redemptionCTA = r1
            if (r4 == 0) goto L_0x0072
            java.lang.String r0 = r4.getRedemptionCtaDeeplink()
        L_0x0072:
            r3.redemptionCTADeeplink = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.a(net.one97.paytm.common.entity.vipcashback.ScratchCardData, net.one97.paytm.common.entity.vipcashback.ScratchCard):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r4 = r6.getRedemptionMetaData();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final net.one97.paytm.common.entity.vipcashback.ScratchCardData e(net.one97.paytm.common.entity.vipcashback.ScratchCard r6) {
        /*
            r5 = this;
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x001d
            java.lang.String r3 = r6.getScratchCardStatus()
            if (r3 == 0) goto L_0x001d
            net.one97.paytm.vipcashback.d.a$j$a r4 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.j.f20821e
            boolean r3 = r3.equals(r4)
            if (r3 != r2) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            r0.isScratchCard = r3
            net.one97.paytm.vipcashback.d.a$i$a r3 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r0.state = r3
            r3 = 0
            if (r6 == 0) goto L_0x0036
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r4 = r6.getRedemptionMetaData()
            if (r4 == 0) goto L_0x0036
            java.lang.String r4 = r4.getRedemptionIconUrl()
            goto L_0x0037
        L_0x0036:
            r4 = r3
        L_0x0037:
            r0.mThumbnail = r4
            if (r6 == 0) goto L_0x0040
            java.lang.String r4 = r6.getWinningText()
            goto L_0x0041
        L_0x0040:
            r4 = r3
        L_0x0041:
            r0.mWinningText = r4
            if (r6 == 0) goto L_0x004a
            java.lang.String r4 = r6.getFrontendRedemptionType()
            goto L_0x004b
        L_0x004a:
            r4 = r3
        L_0x004b:
            r0.frontEndRedemptionType = r4
            if (r6 == 0) goto L_0x005a
            net.one97.paytm.common.entity.vipcashback.SourceMetaData r4 = r6.getSourceMetaData()
            if (r4 == 0) goto L_0x005a
            java.lang.String r4 = r4.getOfferName()
            goto L_0x005b
        L_0x005a:
            r4 = r3
        L_0x005b:
            r0.offerName = r4
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r4 = r5.m
            if (r4 == 0) goto L_0x0075
            net.one97.paytm.cashback.posttxn.InfoV4 r4 = r4.getInfo()
            if (r4 == 0) goto L_0x0075
            net.one97.paytm.cashback.posttxn.Campaign r4 = r4.getCampaign()
            if (r4 == 0) goto L_0x0075
            int r3 = r4.getId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
        L_0x0075:
            r0.campaignId = r3
            a((net.one97.paytm.common.entity.vipcashback.ScratchCardData) r0, (net.one97.paytm.common.entity.vipcashback.ScratchCard) r6)
            r0.keepRupeeSign = r1
            java.lang.String r3 = "COLLECTIBLE"
            r0.redemptionType = r3
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r3 = r6.getRedemptionMetaData()
            java.lang.String r4 = "scratchCardInfo.redemptionMetaData"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getDeeplink()
            r0.deeplink = r3
            if (r6 == 0) goto L_0x00c5
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r3 = r6.getExtraInfo()
            if (r3 == 0) goto L_0x00c5
            java.lang.String r3 = r3.getCollectibleDisplayType()
            if (r3 == 0) goto L_0x00c5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00a6
            r1 = 1
        L_0x00a6:
            if (r1 != r2) goto L_0x00c5
            net.one97.paytm.common.entity.vipcashback.ScratchCardExtraInfo r6 = r6.getExtraInfo()
            java.lang.String r1 = "scratchCardInfo.extraInfo"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            java.lang.String r6 = r6.getCollectibleDisplayType()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r1 = "STICKER"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r6 = android.text.TextUtils.equals(r6, r1)
            if (r6 == 0) goto L_0x00c5
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r0.isStickerType = r6
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.e(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.vipcashback.ScratchCardData f(net.one97.paytm.common.entity.vipcashback.ScratchCard r5) {
        /*
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L_0x001d
            java.lang.String r3 = r5.getScratchCardStatus()
            if (r3 == 0) goto L_0x001d
            net.one97.paytm.vipcashback.d.a$j$a r4 = net.one97.paytm.vipcashback.d.a.j.f20817a
            java.lang.String r4 = net.one97.paytm.vipcashback.d.a.j.f20821e
            boolean r3 = r3.equals(r4)
            if (r3 != r2) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            r0.isScratchCard = r3
            net.one97.paytm.vipcashback.d.a$i$a r3 = net.one97.paytm.vipcashback.d.a.i.f20808a
            java.lang.String r3 = net.one97.paytm.vipcashback.d.a.i.f20815h
            r0.state = r3
            r3 = 0
            if (r5 == 0) goto L_0x0043
            java.lang.String r4 = r5.getIconUrl()
            if (r4 == 0) goto L_0x0043
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x003b
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            if (r4 != r2) goto L_0x0043
            java.lang.String r4 = r5.getIconUrl()
            goto L_0x0051
        L_0x0043:
            if (r5 == 0) goto L_0x0050
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r4 = r5.getRedemptionMetaData()
            if (r4 == 0) goto L_0x0050
            java.lang.String r4 = r4.getRedemptionIconUrl()
            goto L_0x0051
        L_0x0050:
            r4 = r3
        L_0x0051:
            r0.mThumbnail = r4
            if (r5 == 0) goto L_0x005a
            java.lang.String r4 = r5.getWinningText()
            goto L_0x005b
        L_0x005a:
            r4 = r3
        L_0x005b:
            r0.mWinningText = r4
            if (r5 == 0) goto L_0x006a
            net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r4 = r5.getRedemptionMetaData()
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r4.getAmount()
            goto L_0x006b
        L_0x006a:
            r4 = r3
        L_0x006b:
            r0.mCashBackAmount = r4
            if (r5 == 0) goto L_0x0074
            java.lang.String r4 = r5.getFrontendRedemptionType()
            goto L_0x0075
        L_0x0074:
            r4 = r3
        L_0x0075:
            r0.frontEndRedemptionType = r4
            if (r5 == 0) goto L_0x0083
            net.one97.paytm.common.entity.vipcashback.SourceMetaData r4 = r5.getSourceMetaData()
            if (r4 == 0) goto L_0x0083
            java.lang.String r3 = r4.getOfferName()
        L_0x0083:
            r0.offerName = r3
            a((net.one97.paytm.common.entity.vipcashback.ScratchCardData) r0, (net.one97.paytm.common.entity.vipcashback.ScratchCard) r5)
            if (r5 == 0) goto L_0x0099
            java.lang.String r5 = r5.getRedemptionType()
            if (r5 == 0) goto L_0x0099
            java.lang.String r3 = "COINS"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0099
            r1 = 1
        L_0x0099:
            r0.keepRupeeSign = r1
            net.one97.paytm.vipcashback.d.a$h$a r5 = net.one97.paytm.vipcashback.d.a.h.f20802a
            java.lang.String r5 = net.one97.paytm.vipcashback.d.a.h.f20804c
            r0.redemptionType = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.f(net.one97.paytm.common.entity.vipcashback.ScratchCard):net.one97.paytm.common.entity.vipcashback.ScratchCardData");
    }

    public static final /* synthetic */ void a(a aVar, ScratchCardModel scratchCardModel) {
        int indexOf;
        ScratchCard data = scratchCardModel.getData();
        if (scratchCardModel.getStatus() == 1) {
            String str = null;
            if ((data != null ? data.getScratchCardStatus() : null) != null) {
                if (data != null) {
                    str = data.getScratchCardStatus();
                }
                a.j.C0391a aVar2 = a.j.f20817a;
                if (!k.a((Object) str, (Object) a.j.f20819c)) {
                    a.j.C0391a aVar3 = a.j.f20817a;
                    if (!k.a((Object) str, (Object) a.j.f20818b)) {
                        a.j.C0391a aVar4 = a.j.f20817a;
                        if (k.a((Object) str, (Object) a.j.f20820d)) {
                            ArrayList<ScratchCard> arrayList = aVar.l;
                            if (arrayList != null) {
                                arrayList.remove(data);
                                return;
                            }
                            return;
                        }
                        ArrayList<ScratchCard> arrayList2 = aVar.l;
                        if (arrayList2 != null && (indexOf = arrayList2.indexOf(data)) >= 0) {
                            arrayList2.remove(indexOf);
                            arrayList2.add(indexOf, data);
                        }
                        ArrayList<ScratchCardData> arrayList3 = aVar.f20103b;
                        if (arrayList3 != null) {
                            ScratchCardData scratchCardData = new ScratchCardData();
                            scratchCardData.scratchCardId = data.getId();
                            int indexOf2 = arrayList3.indexOf(scratchCardData);
                            if (indexOf2 >= 0) {
                                arrayList3.remove(indexOf2);
                                ScratchCardData a2 = aVar.a(data);
                                if (a2 != null) {
                                    a2.scratchCardId = data.getId();
                                    arrayList3.add(indexOf2, a2);
                                    aVar.f20107f.setValue(a2);
                                }
                                aVar.f20108g.setValue(data);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (scratchCardModel.getErrors() != null && scratchCardModel.getErrors().size() > 0) {
            y<NetworkCustomError> yVar = aVar.f20104c;
            d.a aVar5 = net.one97.paytm.vipcashback.f.d.f20859a;
            GetVIPCashBackErrorModal getVIPCashBackErrorModal = scratchCardModel.getErrors().get(0);
            k.a((Object) getVIPCashBackErrorModal, "response.errors[0]");
            yVar.setValue(d.a.a(getVIPCashBackErrorModal));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.v2.features.b.c.a r8, net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4 r9) {
        /*
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4
            if (r0 == 0) goto L_0x0184
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r0 = r9.getData()
            int r9 = r9.getStatus()
            r1 = 1
            if (r9 != r1) goto L_0x0184
            if (r0 == 0) goto L_0x0184
            net.one97.paytm.cashback.posttxn.TxnLinked r9 = r0.getTxnLinked()
            r2 = 0
            if (r9 == 0) goto L_0x001d
            java.lang.String r9 = r9.getStage()
            goto L_0x001e
        L_0x001d:
            r9 = r2
        L_0x001e:
            net.one97.paytm.cashback.posttxn.InfoV4 r3 = r0.getInfo()
            if (r3 == 0) goto L_0x005b
            java.util.ArrayList r3 = r3.getTransactions()
            if (r3 == 0) goto L_0x005b
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0037:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0057
            java.lang.Object r5 = r3.next()
            r6 = r5
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r6 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r6
            java.lang.String r7 = "txn"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r6 = r6.getStage()
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0037
            r4.add(r5)
            goto L_0x0037
        L_0x0057:
            r9 = r4
            java.util.List r9 = (java.util.List) r9
            goto L_0x005c
        L_0x005b:
            r9 = r2
        L_0x005c:
            r3 = 0
            if (r9 == 0) goto L_0x0064
            int r4 = r9.size()
            goto L_0x0065
        L_0x0064:
            r4 = 0
        L_0x0065:
            if (r4 <= 0) goto L_0x0070
            if (r9 == 0) goto L_0x0070
            java.lang.Object r9 = r9.get(r3)
            net.one97.paytm.cashback.posttxn.CashBackTransactionV4 r9 = (net.one97.paytm.cashback.posttxn.CashBackTransactionV4) r9
            goto L_0x0071
        L_0x0070:
            r9 = r2
        L_0x0071:
            if (r9 == 0) goto L_0x0157
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r4 = r9.getStages()
            if (r4 == 0) goto L_0x0157
            java.lang.String r4 = r4.getStageStatus()
            if (r4 == 0) goto L_0x0157
            net.one97.paytm.vipcashback.d.a$k$a r5 = net.one97.paytm.vipcashback.d.a.k.f20825a
            java.lang.String r5 = net.one97.paytm.vipcashback.d.a.k.f20827c
            boolean r4 = r4.equals(r5)
            if (r4 != r1) goto L_0x0157
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r4 = r9.getStages()
            if (r4 == 0) goto L_0x0096
            java.util.ArrayList r4 = r4.getGratification()
            goto L_0x0097
        L_0x0096:
            r4 = r2
        L_0x0097:
            if (r4 == 0) goto L_0x0184
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r4 = r9.getStages()
            if (r4 == 0) goto L_0x00aa
            java.util.ArrayList r4 = r4.getGratification()
            if (r4 == 0) goto L_0x00aa
            int r4 = r4.size()
            goto L_0x00ab
        L_0x00aa:
            r4 = 0
        L_0x00ab:
            if (r4 <= 0) goto L_0x0184
            net.one97.paytm.cashback.posttxn.CashbackStageItemV4 r4 = r9.getStages()
            if (r4 == 0) goto L_0x00c0
            java.util.ArrayList r4 = r4.getGratification()
            if (r4 == 0) goto L_0x00c0
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.cashback.posttxn.GratificationItem r4 = (net.one97.paytm.cashback.posttxn.GratificationItem) r4
            goto L_0x00c1
        L_0x00c0:
            r4 = r2
        L_0x00c1:
            if (r4 == 0) goto L_0x00c8
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r5 = r4.getScratchCardInfo()
            goto L_0x00c9
        L_0x00c8:
            r5 = r2
        L_0x00c9:
            if (r5 == 0) goto L_0x011c
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r0 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r0.<init>()
            r0.isLockedCard = r1
            java.lang.String r9 = r9.getTxn_id()
            r0.refrenceId = r9
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r9 = r4.getScratchCardInfo()
            java.lang.String r2 = "gratificationItem.scratchCardInfo"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            java.lang.String r9 = r9.getId()
            r0.scratchCardId = r9
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r9 = r4.getScratchCardInfo()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            java.lang.String r9 = r9.getUnlockText()
            if (r9 == 0) goto L_0x010e
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0100
            int r9 = r9.length()
            if (r9 != 0) goto L_0x00ff
            goto L_0x0100
        L_0x00ff:
            r1 = 0
        L_0x0100:
            if (r1 != 0) goto L_0x010e
            net.one97.paytm.cashback.posttxn.ScratchCardInfo r9 = r4.getScratchCardInfo()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            java.lang.String r9 = r9.getUnlockText()
            goto L_0x0110
        L_0x010e:
            java.lang.String r9 = ""
        L_0x0110:
            r0.description = r9
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8 = r8.j
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.a(r0)
            r8.setValue(r9)
            return
        L_0x011c:
            if (r4 == 0) goto L_0x0122
            net.one97.paytm.cashback.posttxn.GameGratification r2 = r4.getGameGratification()
        L_0x0122:
            if (r2 == 0) goto L_0x0156
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r9 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r9.<init>()
            r9.isGame = r1
            java.lang.String r0 = r0.getId()
            r9.gameId = r0
            net.one97.paytm.cashback.posttxn.GameGratification r0 = r4.getGameGratification()
            java.lang.String r1 = "gratificationItem.gameGratification"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getUnlock_text()
            r9.description = r0
            net.one97.paytm.cashback.posttxn.GameGratification r0 = r4.getGameGratification()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getOffer_image_url()
            r9.scratchCardImage = r0
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8 = r8.j
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.a(r9)
            r8.setValue(r9)
        L_0x0156:
            return
        L_0x0157:
            java.lang.String r9 = r0.getDisplayMessage()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0165
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0166
        L_0x0165:
            r3 = 1
        L_0x0166:
            if (r3 != 0) goto L_0x0184
            net.one97.paytm.common.entity.vipcashback.ScratchCardData r9 = new net.one97.paytm.common.entity.vipcashback.ScratchCardData
            r9.<init>()
            r9.isBetterLuck = r1
            java.lang.String r1 = r0.getImageUrl()
            r9.mThumbnail = r1
            java.lang.String r0 = r0.getDisplayMessage()
            r9.redemptionText = r0
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r8 = r8.j
            net.one97.paytm.vipcashback.f.h r9 = net.one97.paytm.vipcashback.f.h.a(r9)
            r8.setValue(r9)
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.c.a.a(net.one97.paytm.v2.features.b.c.a, net.one97.paytm.common.entity.vipcashback.CashBackBaseMyOfferModalV4):void");
    }
}

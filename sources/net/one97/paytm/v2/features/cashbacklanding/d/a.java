package net.one97.paytm.v2.features.cashbacklanding.d;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.v2.b.b;
import net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData;
import net.one97.paytm.v2.features.cashbackoffers.b.f;
import net.one97.paytm.vipcashback.f.h;

public final class a extends ai implements net.one97.paytm.v2.features.cashbackoffers.c.a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20239a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    String f20240b;

    /* renamed from: c  reason: collision with root package name */
    String f20241c;

    /* renamed from: d  reason: collision with root package name */
    String f20242d = "ACTIVE_OFFER,NEW_OFFER";

    /* renamed from: e  reason: collision with root package name */
    public f f20243e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<CardOfferData> f20244f = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public b f20245g = new b();

    /* renamed from: h  reason: collision with root package name */
    boolean f20246h;

    /* renamed from: i  reason: collision with root package name */
    private LiveData<String> f20247i;

    public final LiveData<String> a() {
        return null;
    }

    /* renamed from: net.one97.paytm.v2.features.cashbacklanding.d.a$a  reason: collision with other inner class name */
    static final class C0364a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20248a;

        C0364a(a aVar) {
            this.f20248a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:77:0x013d, code lost:
            r9 = r11;
         */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x0242  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0253  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object apply(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                net.one97.paytm.vipcashback.f.h r1 = (net.one97.paytm.vipcashback.f.h) r1
                int r2 = r1.f20893a
                switch(r2) {
                    case 101: goto L_0x0033;
                    case 102: goto L_0x0026;
                    case 103: goto L_0x000d;
                    case 104: goto L_0x0026;
                    default: goto L_0x000b;
                }
            L_0x000b:
                goto L_0x0258
            L_0x000d:
                net.one97.paytm.v2.features.cashbacklanding.d.a r2 = r0.f20248a
                java.util.ArrayList r2 = r2.f20239a
                int r2 = r2.size()
                if (r2 != 0) goto L_0x0258
                net.one97.paytm.v2.features.cashbacklanding.d.a r2 = r0.f20248a
                net.one97.paytm.v2.b.b r2 = r2.f20245g
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r2 = r2.f20054a
                r2.setValue(r1)
                goto L_0x0258
            L_0x0026:
                net.one97.paytm.v2.features.cashbacklanding.d.a r2 = r0.f20248a
                net.one97.paytm.v2.b.b r2 = r2.f20245g
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r2 = r2.f20054a
                r2.setValue(r1)
                goto L_0x0258
            L_0x0033:
                T r1 = r1.f20894b
                boolean r2 = r1 instanceof net.one97.paytm.common.entity.vipcashback.CashbackMergeCardBase
                if (r2 == 0) goto L_0x0258
                net.one97.paytm.v2.features.cashbacklanding.d.a r3 = r0.f20248a
                net.one97.paytm.v2.b.b r4 = r3.f20245g
                androidx.lifecycle.y<java.lang.Boolean> r4 = r4.f20056c
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                r4.setValue(r5)
                if (r2 == 0) goto L_0x0258
                net.one97.paytm.common.entity.vipcashback.CashbackMergeCardBase r1 = (net.one97.paytm.common.entity.vipcashback.CashbackMergeCardBase) r1
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r2 = r1.getData()
                r4 = 0
                if (r2 == 0) goto L_0x0054
                java.util.ArrayList r2 = r2.getCardOfferDataList()
                goto L_0x0055
            L_0x0054:
                r2 = r4
            L_0x0055:
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r5 = r1.getData()
                if (r5 == 0) goto L_0x0060
                java.util.ArrayList r5 = r5.getExcludedIds()
                goto L_0x0061
            L_0x0060:
                r5 = r4
            L_0x0061:
                java.lang.String r6 = ","
                r7 = 0
                if (r5 == 0) goto L_0x0093
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r5 = r1.getData()
                if (r5 == 0) goto L_0x0077
                java.util.ArrayList r5 = r5.getExcludedIds()
                if (r5 == 0) goto L_0x0077
                int r5 = r5.size()
                goto L_0x0078
            L_0x0077:
                r5 = 0
            L_0x0078:
                if (r5 <= 0) goto L_0x0093
                r5 = r6
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r8 = r1.getData()
                if (r8 != 0) goto L_0x0086
                kotlin.g.b.k.a()
            L_0x0086:
                java.util.ArrayList r8 = r8.getExcludedIds()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.lang.String r5 = android.text.TextUtils.join(r5, r8)
                r3.f20240b = r5
                goto L_0x0095
            L_0x0093:
                r3.f20240b = r4
            L_0x0095:
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r5 = r1.getData()
                if (r5 == 0) goto L_0x00a0
                java.lang.String r5 = r5.getBeforeTime()
                goto L_0x00a1
            L_0x00a0:
                r5 = r4
            L_0x00a1:
                r3.f20241c = r5
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r5 = r1.getData()
                if (r5 == 0) goto L_0x00ae
                java.util.ArrayList r5 = r5.getRemainingTypes()
                goto L_0x00af
            L_0x00ae:
                r5 = r4
            L_0x00af:
                if (r5 == 0) goto L_0x00dc
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r5 = r1.getData()
                if (r5 == 0) goto L_0x00c2
                java.util.ArrayList r5 = r5.getRemainingTypes()
                if (r5 == 0) goto L_0x00c2
                int r5 = r5.size()
                goto L_0x00c3
            L_0x00c2:
                r5 = 0
            L_0x00c3:
                if (r5 <= 0) goto L_0x00dc
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo r1 = r1.getData()
                if (r1 == 0) goto L_0x00d2
                java.util.ArrayList r1 = r1.getRemainingTypes()
                goto L_0x00d3
            L_0x00d2:
                r1 = r4
            L_0x00d3:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.lang.String r1 = android.text.TextUtils.join(r6, r1)
                r3.f20242d = r1
                goto L_0x00de
            L_0x00dc:
                r3.f20242d = r4
            L_0x00de:
                if (r2 == 0) goto L_0x023a
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r5 = r2.iterator()
            L_0x00e9:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x01ed
                java.lang.Object r6 = r5.next()
                net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData r6 = (net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData) r6
                java.lang.String r8 = r6.getCardType()
                java.lang.String r9 = ""
                if (r8 != 0) goto L_0x00ff
                goto L_0x01c6
            L_0x00ff:
                int r10 = r8.hashCode()
                switch(r10) {
                    case -1897800923: goto L_0x01ab;
                    case -849374531: goto L_0x0179;
                    case 456978799: goto L_0x0140;
                    case 702290883: goto L_0x0108;
                    default: goto L_0x0106;
                }
            L_0x0106:
                goto L_0x01c6
            L_0x0108:
                java.lang.String r10 = "ACTIVE_OFFER"
                boolean r8 = r8.equals(r10)
                if (r8 == 0) goto L_0x01c6
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20769b
                net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r10 = r6.getActiveOfferData()
                if (r10 == 0) goto L_0x0122
                java.lang.String r10 = r10.getId()
                if (r10 != 0) goto L_0x0123
            L_0x0122:
                r10 = r9
            L_0x0123:
                net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r11 = r6.getActiveOfferData()
                if (r11 == 0) goto L_0x01d9
                net.one97.paytm.cashback.posttxn.InfoV4 r11 = r11.getInfo()
                if (r11 == 0) goto L_0x01d9
                net.one97.paytm.cashback.posttxn.Campaign r11 = r11.getCampaign()
                if (r11 == 0) goto L_0x01d9
                java.lang.String r11 = r11.getNewOffersImageUrl()
                if (r11 != 0) goto L_0x013d
                goto L_0x01d9
            L_0x013d:
                r9 = r11
                goto L_0x01d9
            L_0x0140:
                java.lang.String r10 = "UNSCRATCHED_CARD"
                boolean r8 = r8.equals(r10)
                if (r8 == 0) goto L_0x01c6
                net.one97.paytm.common.entity.vipcashback.ScratchCard r8 = r6.getUnscratchedCardData()
                if (r8 == 0) goto L_0x0166
                net.one97.paytm.vipcashback.f.d$a r8 = net.one97.paytm.vipcashback.f.d.f20859a
                net.one97.paytm.common.entity.vipcashback.ScratchCard r8 = r6.getUnscratchedCardData()
                if (r8 != 0) goto L_0x0159
                kotlin.g.b.k.a()
            L_0x0159:
                boolean r8 = net.one97.paytm.vipcashback.f.d.a.a((net.one97.paytm.common.entity.vipcashback.ScratchCard) r8)
                if (r8 == 0) goto L_0x0166
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20770c
                goto L_0x016c
            L_0x0166:
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.l
            L_0x016c:
                net.one97.paytm.common.entity.vipcashback.ScratchCard r10 = r6.getUnscratchedCardData()
                if (r10 == 0) goto L_0x01d8
                java.lang.String r10 = r10.getId()
                if (r10 != 0) goto L_0x01d9
                goto L_0x01d8
            L_0x0179:
                java.lang.String r10 = "NEW_OFFER"
                boolean r8 = r8.equals(r10)
                if (r8 == 0) goto L_0x01c6
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20773f
                net.one97.paytm.cashback.posttxn.Campaign r10 = r6.getNewOfferData()
                if (r10 == 0) goto L_0x0196
                int r10 = r10.getId()
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                goto L_0x0197
            L_0x0196:
                r10 = r4
            L_0x0197:
                java.lang.String r10 = java.lang.String.valueOf(r10)
                if (r10 != 0) goto L_0x019e
                r10 = r9
            L_0x019e:
                net.one97.paytm.cashback.posttxn.Campaign r11 = r6.getNewOfferData()
                if (r11 == 0) goto L_0x01d9
                java.lang.String r11 = r11.getNewOffersImageUrl()
                if (r11 != 0) goto L_0x013d
                goto L_0x01d9
            L_0x01ab:
                java.lang.String r10 = "LOCKED_CARD"
                boolean r8 = r8.equals(r10)
                if (r8 == 0) goto L_0x01c6
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20772e
                net.one97.paytm.common.entity.vipcashback.ScratchCard r10 = r6.getLockedCardData()
                if (r10 == 0) goto L_0x01d8
                java.lang.String r10 = r10.getId()
                if (r10 != 0) goto L_0x01d9
                goto L_0x01d8
            L_0x01c6:
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20770c
                net.one97.paytm.common.entity.vipcashback.ScratchCard r10 = r6.getUnscratchedCardData()
                if (r10 == 0) goto L_0x01d8
                java.lang.String r10 = r10.getId()
                if (r10 != 0) goto L_0x01d9
            L_0x01d8:
                r10 = r9
            L_0x01d9:
                r15 = r8
                r13 = r9
                r12 = r10
                net.one97.paytm.v2.features.cashbacklanding.model.a r8 = new net.one97.paytm.v2.features.cashbacklanding.model.a
                java.lang.String r14 = r6.getMessage()
                r16 = 0
                r11 = r8
                r11.<init>(r12, r13, r14, r15, r16)
                r1.add(r8)
                goto L_0x00e9
            L_0x01ed:
                boolean r4 = r3.f20246h
                if (r4 == 0) goto L_0x01ff
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData> r4 = r3.f20244f
                r4.clear()
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r4 = r3.f20239a
                if (r4 == 0) goto L_0x01fd
                r4.clear()
            L_0x01fd:
                r3.f20246h = r7
            L_0x01ff:
                int r4 = r2.size()
                if (r4 <= 0) goto L_0x020c
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CardOfferData> r4 = r3.f20244f
                java.util.Collection r2 = (java.util.Collection) r2
                r4.addAll(r2)
            L_0x020c:
                int r2 = r1.size()
                if (r2 == 0) goto L_0x0227
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r2 = r3.f20239a
                java.util.Collection r1 = (java.util.Collection) r1
                r2.addAll(r1)
                net.one97.paytm.v2.b.b r1 = r3.f20245g
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r1 = r1.f20054a
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r2 = r3.f20239a
                net.one97.paytm.vipcashback.f.h r2 = net.one97.paytm.vipcashback.f.h.a(r2)
                r1.setValue(r2)
                goto L_0x023a
            L_0x0227:
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r1 = r3.f20239a
                int r1 = r1.size()
                if (r1 != 0) goto L_0x023a
                net.one97.paytm.v2.b.b r1 = r3.f20245g
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r1 = r1.f20054a
                net.one97.paytm.vipcashback.f.h r2 = net.one97.paytm.vipcashback.f.h.b()
                r1.setValue(r2)
            L_0x023a:
                net.one97.paytm.v2.b.b r1 = r3.f20245g
                androidx.lifecycle.y<java.lang.Boolean> r1 = r1.f20058e
                java.lang.String r2 = r3.f20242d
                if (r2 == 0) goto L_0x0253
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                r3 = 1
                if (r2 != 0) goto L_0x024c
                r7 = 1
            L_0x024c:
                r2 = r7 ^ 1
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                goto L_0x0255
            L_0x0253:
                java.lang.Boolean r2 = java.lang.Boolean.FALSE
            L_0x0255:
                r1.setValue(r2)
            L_0x0258:
                java.lang.String r1 = "result"
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.d.a.C0364a.apply(java.lang.Object):java.lang.Object");
        }
    }

    public a() {
        LiveData<String> a2 = ah.a(this.f20245g.f20055b, new C0364a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20247i = a2;
    }

    public final void a(String str) {
        k.c(str, "offerTag");
        this.f20242d = "ACTIVE_OFFER,NEW_OFFER";
        this.f20246h = true;
        this.f20245g.f20058e.setValue(Boolean.FALSE);
        b(str);
    }

    public final LiveData<h<Object>> b() {
        return this.f20245g.f20054a;
    }

    public final LiveData<Boolean> c() {
        return this.f20245g.f20056c;
    }

    public final LiveData<String> d() {
        return this.f20247i;
    }

    public final void b(String str) {
        k.c(str, "offerTag");
        f fVar = this.f20243e;
        if (fVar == null) {
            k.a("repository");
        }
        fVar.a(this.f20245g.f20055b, (String) null, (String) null, this.f20242d);
    }

    public final LiveData<Boolean> e() {
        return this.f20245g.f20058e;
    }

    public final void f() {
        this.f20245g.f20056c.setValue(Boolean.TRUE);
        f fVar = this.f20243e;
        if (fVar == null) {
            k.a("repository");
        }
        fVar.a(this.f20245g.f20055b, this.f20240b, this.f20241c, this.f20242d);
    }

    public final LiveData<Object> a(int i2) {
        y yVar = new y();
        if (i2 >= 0 && i2 < this.f20244f.size() && this.f20244f.get(i2).getLockedCardData() == null) {
            yVar.setValue(this.f20244f.get(i2));
        }
        return yVar;
    }
}

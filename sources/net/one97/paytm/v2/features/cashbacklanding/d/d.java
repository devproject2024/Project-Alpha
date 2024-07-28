package net.one97.paytm.v2.features.cashbacklanding.d;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.h;

public final class d extends ai implements net.one97.paytm.v2.features.cashbackoffers.c.a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ScratchCard> f20267a = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20268b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    String f20269c;

    /* renamed from: d  reason: collision with root package name */
    String f20270d;

    /* renamed from: e  reason: collision with root package name */
    public b f20271e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.v2.b.b f20272f = new net.one97.paytm.v2.b.b();

    /* renamed from: g  reason: collision with root package name */
    boolean f20273g;

    /* renamed from: h  reason: collision with root package name */
    private LiveData<String> f20274h;

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20275a;

        a(d dVar) {
            this.f20275a = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
            if ((java.lang.Long.parseLong(r10) - r12) < ((long) r14)) goto L_0x0147;
         */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x022d  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0234  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x027c  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x0283  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x02a3 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object apply(java.lang.Object r22) {
            /*
                r21 = this;
                r0 = r21
                r1 = r22
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
                goto L_0x0302
            L_0x000d:
                net.one97.paytm.v2.features.cashbacklanding.d.d r2 = r0.f20275a
                java.util.ArrayList r2 = r2.f20268b
                int r2 = r2.size()
                if (r2 != 0) goto L_0x0302
                net.one97.paytm.v2.features.cashbacklanding.d.d r2 = r0.f20275a
                net.one97.paytm.v2.b.b r2 = r2.f20272f
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r2 = r2.f20054a
                r2.setValue(r1)
                goto L_0x0302
            L_0x0026:
                net.one97.paytm.v2.features.cashbacklanding.d.d r2 = r0.f20275a
                net.one97.paytm.v2.b.b r2 = r2.f20272f
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r2 = r2.f20054a
                r2.setValue(r1)
                goto L_0x0302
            L_0x0033:
                T r1 = r1.f20894b
                net.one97.paytm.v2.features.cashbacklanding.d.d r2 = r0.f20275a
                net.one97.paytm.v2.b.b r3 = r2.f20272f
                androidx.lifecycle.y<java.lang.Boolean> r3 = r3.f20056c
                java.lang.Boolean r4 = java.lang.Boolean.FALSE
                r3.setValue(r4)
                boolean r3 = r1 instanceof net.one97.paytm.common.entity.vipcashback.CashbackAllCards
                if (r3 == 0) goto L_0x0302
                net.one97.paytm.common.entity.vipcashback.CashbackAllCards r1 = (net.one97.paytm.common.entity.vipcashback.CashbackAllCards) r1
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r3 = r1.data
                java.util.ArrayList r3 = r3.getGratificationSummary()
                r4 = 0
                if (r3 == 0) goto L_0x0054
                int r3 = r3.size()
                goto L_0x0055
            L_0x0054:
                r3 = 0
            L_0x0055:
                r5 = 0
                if (r3 <= 0) goto L_0x0075
                net.one97.paytm.v2.b.b r3 = r2.f20272f
                androidx.lifecycle.y<java.lang.String> r3 = r3.f20057d
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r6 = r1.data
                java.util.ArrayList r6 = r6.getGratificationSummary()
                if (r6 == 0) goto L_0x0071
                java.lang.Object r6 = r6.get(r4)
                net.one97.paytm.common.entity.vipcashback.GratificationSummaryData r6 = (net.one97.paytm.common.entity.vipcashback.GratificationSummaryData) r6
                if (r6 == 0) goto L_0x0071
                java.lang.String r6 = r6.getTotalAmount()
                goto L_0x0072
            L_0x0071:
                r6 = r5
            L_0x0072:
                r3.setValue(r6)
            L_0x0075:
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r3 = r1.data
                if (r3 != 0) goto L_0x007c
                kotlin.g.b.k.a()
            L_0x007c:
                java.util.ArrayList r3 = r3.getExcludedIds()
                if (r3 == 0) goto L_0x0098
                java.lang.String r3 = ","
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r6 = r1.data
                if (r6 != 0) goto L_0x008d
                kotlin.g.b.k.a()
            L_0x008d:
                java.util.ArrayList r6 = r6.getExcludedIds()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.lang.String r3 = android.text.TextUtils.join(r3, r6)
                goto L_0x0099
            L_0x0098:
                r3 = r5
            L_0x0099:
                r2.f20269c = r3
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r3 = r1.data
                if (r3 != 0) goto L_0x00a2
                kotlin.g.b.k.a()
            L_0x00a2:
                java.lang.String r3 = r3.getBeforeTime()
                r2.f20270d = r3
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r3 = r1.data
                if (r3 == 0) goto L_0x00b1
                java.util.ArrayList r3 = r3.getScratchCardList()
                goto L_0x00b2
            L_0x00b1:
                r3 = r5
            L_0x00b2:
                if (r3 == 0) goto L_0x02ef
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Iterator r7 = r3.iterator()
            L_0x00bd:
                r8 = r5
            L_0x00be:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x02a8
                java.lang.Object r9 = r7.next()
                net.one97.paytm.common.entity.vipcashback.ScratchCard r9 = (net.one97.paytm.common.entity.vipcashback.ScratchCard) r9
                java.lang.String r10 = "item.id"
                r11 = 1
                if (r9 == 0) goto L_0x016b
                java.lang.String r12 = r9.getScratchCardStatus()
                if (r12 == 0) goto L_0x016b
                net.one97.paytm.vipcashback.d.a$j$a r13 = net.one97.paytm.vipcashback.d.a.j.f20817a
                java.lang.String r13 = net.one97.paytm.vipcashback.d.a.j.f20821e
                boolean r12 = r12.equals(r13)
                if (r12 != r11) goto L_0x016b
                net.one97.paytm.vipcashback.f.d$a r8 = net.one97.paytm.vipcashback.f.d.f20859a
                boolean r8 = net.one97.paytm.vipcashback.f.d.a.a((net.one97.paytm.common.entity.vipcashback.ScratchCard) r9)
                if (r8 == 0) goto L_0x00f0
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20770c
                goto L_0x00f6
            L_0x00f0:
                net.one97.paytm.vipcashback.d.a$a$a r8 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r8 = net.one97.paytm.vipcashback.d.a.C0382a.l
            L_0x00f6:
                r16 = r8
                net.one97.paytm.v2.features.cashbacklanding.model.a r8 = new net.one97.paytm.v2.features.cashbacklanding.model.a
                java.lang.String r13 = r9.getId()
                kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
                r14 = 0
                r15 = 0
                r17 = 0
                r12 = r8
                r12.<init>(r13, r14, r15, r16, r17)
                java.lang.String r10 = r9.getExpireAt()
                r12 = r10
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                if (r12 == 0) goto L_0x011b
                int r12 = r12.length()
                if (r12 != 0) goto L_0x0119
                goto L_0x011b
            L_0x0119:
                r12 = 0
                goto L_0x011c
            L_0x011b:
                r12 = 1
            L_0x011c:
                if (r12 == 0) goto L_0x011f
                goto L_0x0146
            L_0x011f:
                long r12 = java.lang.System.currentTimeMillis()
                net.one97.paytm.vipcashback.f.f r14 = net.one97.paytm.vipcashback.f.f.a()
                java.lang.String r15 = "GTMHelper.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
                int r14 = net.one97.paytm.vipcashback.f.f.P()
                int r14 = r14 * 60
                int r14 = r14 * 60
                int r14 = r14 * 1000
                if (r10 != 0) goto L_0x013b
                kotlin.g.b.k.a()
            L_0x013b:
                long r15 = java.lang.Long.parseLong(r10)
                long r15 = r15 - r12
                long r12 = (long) r14
                int r10 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
                if (r10 >= 0) goto L_0x0146
                goto L_0x0147
            L_0x0146:
                r11 = 0
            L_0x0147:
                r8.f20296i = r11
                java.lang.String r10 = r9.getExpiryText()
                if (r10 != 0) goto L_0x0150
                r10 = r5
            L_0x0150:
                r8.l = r10
                java.lang.Boolean r10 = r9.getLuckyDraw()
                if (r10 == 0) goto L_0x015d
                boolean r10 = r10.booleanValue()
                goto L_0x015e
            L_0x015d:
                r10 = 0
            L_0x015e:
                r8.j = r10
                java.lang.String r9 = r9.getRedemptionMaxAmount()
                if (r9 != 0) goto L_0x0167
                r9 = r5
            L_0x0167:
                r8.k = r9
                goto L_0x02a1
            L_0x016b:
                if (r9 == 0) goto L_0x01b2
                java.lang.String r12 = r9.getScratchCardStatus()
                if (r12 == 0) goto L_0x01b2
                net.one97.paytm.vipcashback.d.a$j$a r13 = net.one97.paytm.vipcashback.d.a.j.f20817a
                java.lang.String r13 = net.one97.paytm.vipcashback.d.a.j.f20824h
                boolean r12 = r12.equals(r13)
                if (r12 != r11) goto L_0x01b2
                net.one97.paytm.v2.features.cashbacklanding.model.a r8 = new net.one97.paytm.v2.features.cashbacklanding.model.a
                java.lang.String r14 = r9.getId()
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
                r15 = 0
                java.lang.String r16 = r9.getUnlockText()
                net.one97.paytm.vipcashback.d.a$a$a r10 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r17 = net.one97.paytm.vipcashback.d.a.C0382a.f20772e
                r18 = 0
                r13 = r8
                r13.<init>(r14, r15, r16, r17, r18)
                java.lang.Boolean r10 = r9.getLuckyDraw()
                if (r10 == 0) goto L_0x01a4
                boolean r10 = r10.booleanValue()
                goto L_0x01a5
            L_0x01a4:
                r10 = 0
            L_0x01a5:
                r8.j = r10
                java.lang.String r9 = r9.getRedemptionMaxAmount()
                if (r9 != 0) goto L_0x01ae
                r9 = r5
            L_0x01ae:
                r8.k = r9
                goto L_0x02a1
            L_0x01b2:
                java.lang.String r10 = "item"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
                java.lang.String r10 = r9.getRedemptionType()
                net.one97.paytm.vipcashback.d.a$f$a r12 = net.one97.paytm.vipcashback.d.a.f.f20792a
                java.lang.String r12 = net.one97.paytm.vipcashback.d.a.f.f20794c
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                java.lang.String r13 = "item.sourceMetaData"
                if (r12 != 0) goto L_0x024d
                java.lang.String r12 = "UPI"
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r12 != 0) goto L_0x024d
                java.lang.String r12 = "PPBL"
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r12 != 0) goto L_0x024d
                net.one97.paytm.vipcashback.d.a$f$a r12 = net.one97.paytm.vipcashback.d.a.f.f20792a
                java.lang.String r12 = net.one97.paytm.vipcashback.d.a.f.f20793b
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r12 != 0) goto L_0x024d
                java.lang.String r12 = "GV_CASHBACK"
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r12 != 0) goto L_0x024d
                java.lang.String r12 = "PG_CASHBACK"
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r12 == 0) goto L_0x01f6
                goto L_0x024d
            L_0x01f6:
                java.lang.String r12 = "COINS"
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r12)
                if (r10 == 0) goto L_0x02a1
                java.lang.String r8 = r9.getScratchCardStatus()
                if (r8 == 0) goto L_0x0213
                net.one97.paytm.vipcashback.d.a$j$a r10 = net.one97.paytm.vipcashback.d.a.j.f20817a
                java.lang.String r10 = net.one97.paytm.vipcashback.d.a.j.f20823g
                boolean r8 = r8.equals(r10)
                if (r8 != 0) goto L_0x0213
                r20 = 1
                goto L_0x0215
            L_0x0213:
                r20 = 0
            L_0x0215:
                net.one97.paytm.v2.features.cashbacklanding.model.a r8 = new net.one97.paytm.v2.features.cashbacklanding.model.a
                r15 = 0
                net.one97.paytm.common.entity.vipcashback.SourceMetaData r10 = r9.getSourceMetaData()
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r13)
                java.lang.String r16 = r10.getOfferIconUrl()
                java.lang.String r17 = r9.getEarnedFor()
                net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r10 = r9.getRedemptionMetaData()
                if (r10 == 0) goto L_0x0234
                java.lang.String r10 = r10.getAmount()
                r18 = r10
                goto L_0x0236
            L_0x0234:
                r18 = r5
            L_0x0236:
                net.one97.paytm.vipcashback.d.a$a$a r10 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r19 = net.one97.paytm.vipcashback.d.a.C0382a.j
                r14 = r8
                r14.<init>((java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (boolean) r20)
                java.lang.String r10 = r9.getId()
                r8.f20294g = r10
                java.lang.Long r9 = r9.getCreatedAt()
                r8.m = r9
                goto L_0x02a1
            L_0x024d:
                java.lang.String r8 = r9.getScratchCardStatus()
                if (r8 == 0) goto L_0x0262
                net.one97.paytm.vipcashback.d.a$j$a r10 = net.one97.paytm.vipcashback.d.a.j.f20817a
                java.lang.String r10 = net.one97.paytm.vipcashback.d.a.j.f20823g
                boolean r8 = r8.equals(r10)
                if (r8 != 0) goto L_0x0262
                r20 = 1
                goto L_0x0264
            L_0x0262:
                r20 = 0
            L_0x0264:
                net.one97.paytm.v2.features.cashbacklanding.model.a r8 = new net.one97.paytm.v2.features.cashbacklanding.model.a
                r15 = 0
                net.one97.paytm.common.entity.vipcashback.SourceMetaData r10 = r9.getSourceMetaData()
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r13)
                java.lang.String r16 = r10.getOfferIconUrl()
                java.lang.String r17 = r9.getEarnedFor()
                net.one97.paytm.common.entity.vipcashback.RedemptionMetaData r10 = r9.getRedemptionMetaData()
                if (r10 == 0) goto L_0x0283
                java.lang.String r10 = r10.getAmount()
                r18 = r10
                goto L_0x0285
            L_0x0283:
                r18 = r5
            L_0x0285:
                net.one97.paytm.vipcashback.d.a$a$a r10 = net.one97.paytm.vipcashback.d.a.C0382a.f20768a
                int r19 = net.one97.paytm.vipcashback.d.a.C0382a.f20776i
                r14 = r8
                r14.<init>((java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (int) r19, (boolean) r20)
                java.lang.Long r10 = r9.getCreatedAt()
                r8.m = r10
                java.lang.String r10 = r9.getId()
                r8.f20294g = r10
                java.lang.String r9 = r9.getCashbackDestinationIconUrl()
                r8.o = r9
            L_0x02a1:
                if (r8 == 0) goto L_0x00be
                r6.add(r8)
                goto L_0x00bd
            L_0x02a8:
                boolean r7 = r2.f20273g
                if (r7 == 0) goto L_0x02ba
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r7 = r2.f20267a
                r7.clear()
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r7 = r2.f20268b
                if (r7 == 0) goto L_0x02b8
                r7.clear()
            L_0x02b8:
                r2.f20273g = r4
            L_0x02ba:
                int r4 = r6.size()
                if (r4 == 0) goto L_0x02dc
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r4 = r2.f20268b
                java.util.Collection r6 = (java.util.Collection) r6
                r4.addAll(r6)
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r4 = r2.f20267a
                java.util.Collection r3 = (java.util.Collection) r3
                r4.addAll(r3)
                net.one97.paytm.v2.b.b r3 = r2.f20272f
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r3 = r3.f20054a
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r4 = r2.f20268b
                net.one97.paytm.vipcashback.f.h r4 = net.one97.paytm.vipcashback.f.h.a(r4)
                r3.setValue(r4)
                goto L_0x02ef
            L_0x02dc:
                java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> r3 = r2.f20268b
                int r3 = r3.size()
                if (r3 != 0) goto L_0x02ef
                net.one97.paytm.v2.b.b r3 = r2.f20272f
                androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r3 = r3.f20054a
                net.one97.paytm.vipcashback.f.h r4 = net.one97.paytm.vipcashback.f.h.b()
                r3.setValue(r4)
            L_0x02ef:
                net.one97.paytm.v2.b.b r2 = r2.f20272f
                androidx.lifecycle.y<java.lang.Boolean> r2 = r2.f20058e
                net.one97.paytm.common.entity.vipcashback.ScratchCardSectionListData r1 = r1.data
                if (r1 == 0) goto L_0x02ff
                boolean r1 = r1.isNext()
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            L_0x02ff:
                r2.setValue(r5)
            L_0x0302:
                java.lang.String r1 = "result"
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.d.d.a.apply(java.lang.Object):java.lang.Object");
        }
    }

    public d() {
        LiveData<String> a2 = ah.a(this.f20272f.f20055b, new a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20274h = a2;
    }

    public final void a(String str) {
        k.c(str, "offerTag");
        this.f20273g = true;
        this.f20272f.f20058e.setValue(Boolean.FALSE);
        b(str);
    }

    public final LiveData<h<Object>> b() {
        return this.f20272f.f20054a;
    }

    public final LiveData<Boolean> c() {
        return this.f20272f.f20056c;
    }

    public final void b(String str) {
        k.c(str, "offerTag");
        b bVar = this.f20271e;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.a(this.f20272f.f20055b, (String) null, (String) null, Boolean.TRUE);
    }

    public final LiveData<Boolean> e() {
        return this.f20272f.f20058e;
    }

    public final LiveData<String> d() {
        return this.f20274h;
    }

    public final LiveData<String> a() {
        return this.f20272f.f20057d;
    }

    public final void f() {
        this.f20272f.f20056c.setValue(Boolean.TRUE);
        b bVar = this.f20271e;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.a(this.f20272f.f20055b, this.f20269c, this.f20270d, (Boolean) null);
    }

    public final LiveData<Object> a(int i2) {
        y yVar = new y();
        if (i2 >= 0 && i2 < this.f20267a.size()) {
            yVar.setValue(this.f20267a.get(i2));
        }
        return yVar;
    }

    public final void a(ScratchCard scratchCard) {
        String str;
        String scratchCardStatus = scratchCard != null ? scratchCard.getScratchCardStatus() : null;
        a.j.C0391a aVar = a.j.f20817a;
        boolean z = true;
        if (p.a(scratchCardStatus, a.j.f20822f, true)) {
            Collection arrayList = new ArrayList();
            Iterator it2 = this.f20267a.iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                String id = ((ScratchCard) next).getId();
                if (id != null) {
                    if (id.equals(scratchCard != null ? scratchCard.getId() : null)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (list.size() > 0) {
                this.f20267a.remove(list.get(0));
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : this.f20268b) {
                String str2 = ((net.one97.paytm.v2.features.cashbacklanding.model.a) next2).f20294g;
                if (scratchCard != null) {
                    str = scratchCard.getId();
                } else {
                    str = null;
                }
                if (!p.a(str2, str, false)) {
                    arrayList2.add(next2);
                }
            }
            this.f20268b.clear();
            this.f20268b.addAll((List) arrayList2);
            Collection collection = this.f20268b;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (z) {
                this.f20272f.f20054a.setValue(h.b());
            } else if (this.f20268b.size() != 0) {
                this.f20272f.f20054a.setValue(h.a(this.f20268b));
            }
        }
    }
}

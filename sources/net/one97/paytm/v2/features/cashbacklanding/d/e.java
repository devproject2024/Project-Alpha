package net.one97.paytm.v2.features.cashbacklanding.d;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.CashbackVoucher;
import net.one97.paytm.common.entity.vipcashback.CashbackVoucherListModal;
import net.one97.paytm.common.entity.vipcashback.CashbackVoucherResponse;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.h;

public final class e extends ai implements net.one97.paytm.v2.features.cashbackoffers.c.a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20276a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f20277b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CashbackVoucher> f20278c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f20279d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f20280e = 1;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<VoucherFilterItem> f20281f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.v2.b.b f20282g = new net.one97.paytm.v2.b.b();

    /* renamed from: h  reason: collision with root package name */
    private boolean f20283h;

    /* renamed from: i  reason: collision with root package name */
    private LiveData<String> f20284i;

    public final LiveData<String> a() {
        return null;
    }

    public final void b(String str) {
        k.c(str, "offerTag");
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f20285a;

        a(e eVar) {
            this.f20285a = eVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            switch (hVar.f20893a) {
                case 101:
                    T t = hVar.f20894b;
                    if (!(t instanceof CashbackVoucherListModal)) {
                        return "result";
                    }
                    e.a(this.f20285a, (CashbackVoucherListModal) t);
                    return "result";
                case 102:
                case 104:
                    this.f20285a.f20282g.f20054a.setValue(hVar);
                    return "result";
                case 103:
                    if (this.f20285a.f20276a.size() != 0) {
                        return "result";
                    }
                    this.f20285a.f20282g.f20054a.setValue(hVar);
                    return "result";
                default:
                    return "result";
            }
        }
    }

    public e() {
        LiveData<String> a2 = ah.a(this.f20282g.f20055b, new a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20284i = a2;
    }

    public final LiveData<h<Object>> b() {
        return this.f20282g.f20054a;
    }

    public final LiveData<Boolean> c() {
        return this.f20282g.f20056c;
    }

    public final LiveData<String> d() {
        return this.f20284i;
    }

    public final void a(String str) {
        k.c(str, "offerTag");
        this.f20283h = true;
        this.f20280e = 1;
        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList = this.f20276a;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f20282g.f20058e.setValue(Boolean.FALSE);
        g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r0 = r8.f20281f
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r0 == 0) goto L_0x0068
            if (r0 != 0) goto L_0x000d
            kotlin.g.b.k.a()
        L_0x000d:
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0068
            java.lang.String r0 = "filter[category]="
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r4 = r8.f20281f
            r5 = -1
            if (r4 == 0) goto L_0x0020
            int r4 = r4.size()
            int r4 = r4 - r3
            goto L_0x0021
        L_0x0020:
            r4 = -1
        L_0x0021:
            if (r4 < 0) goto L_0x0069
            r6 = 0
        L_0x0024:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r0 = r8.f20281f
            if (r0 == 0) goto L_0x003d
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.common.entity.vipcashback.VoucherFilterItem r0 = (net.one97.paytm.common.entity.vipcashback.VoucherFilterItem) r0
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r0.getId()
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.VoucherFilterItem> r7 = r8.f20281f
            if (r7 == 0) goto L_0x004f
            int r7 = r7.size()
            int r7 = r7 - r3
            goto L_0x0050
        L_0x004f:
            r7 = -1
        L_0x0050:
            if (r6 == r7) goto L_0x0063
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r0 = 44
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x0063:
            if (r6 == r4) goto L_0x0069
            int r6 = r6 + 1
            goto L_0x0024
        L_0x0068:
            r0 = r2
        L_0x0069:
            int r4 = r8.f20279d
            if (r4 != r3) goto L_0x0070
            java.lang.String r4 = "&sort=validUpto,asc"
            goto L_0x0071
        L_0x0070:
            r4 = r2
        L_0x0071:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0080
            r1 = 1
        L_0x0080:
            if (r1 == 0) goto L_0x0093
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "&"
            r1.append(r0)
            java.lang.String r2 = r1.toString()
        L_0x0093:
            r5.append(r2)
            java.lang.String r0 = "filter[status]="
            r5.append(r0)
            int r0 = r8.f20279d
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            net.one97.paytm.v2.a.b r1 = r8.f20277b
            if (r1 != 0) goto L_0x00b0
            java.lang.String r2 = "repository"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00b0:
            if (r1 == 0) goto L_0x00bf
            net.one97.paytm.v2.b.b r2 = r8.f20282g
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r2 = r2.f20055b
            int r3 = r8.f20280e
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.a(r2, r0, r3)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.d.e.g():void");
    }

    public final void f() {
        this.f20282g.f20056c.setValue(Boolean.TRUE);
        g();
    }

    public final LiveData<Object> a(int i2) {
        y yVar = new y();
        if (i2 >= 0 && i2 < this.f20278c.size() && this.f20278c.get(i2) != null) {
            yVar.setValue(this.f20278c.get(i2));
        }
        return yVar;
    }

    public final LiveData<Boolean> e() {
        return this.f20282g.f20058e;
    }

    public final void a(int i2, ArrayList<VoucherFilterItem> arrayList) {
        this.f20279d = i2;
        this.f20281f = arrayList;
        this.f20280e = 1;
        this.f20278c.clear();
        this.f20276a.clear();
        g();
    }

    public static final /* synthetic */ void a(e eVar, CashbackVoucherListModal cashbackVoucherListModal) {
        int i2;
        eVar.f20280e++;
        eVar.f20282g.f20056c.setValue(Boolean.FALSE);
        CashbackVoucherResponse response = cashbackVoucherListModal.getResponse();
        Boolean bool = null;
        ArrayList<CashbackVoucher> voucherList = response != null ? response.getVoucherList() : null;
        if (voucherList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<CashbackVoucher> it2 = voucherList.iterator();
            while (it2.hasNext()) {
                CashbackVoucher next = it2.next();
                k.a((Object) next, "item");
                String icon = next.getIcon();
                String title = next.getTitle();
                String savingsText = next.getSavingsText();
                if (next.getRedemptionType().equals("DEAL")) {
                    a.C0382a.C0383a aVar = a.C0382a.f20768a;
                    i2 = a.C0382a.f20775h;
                } else {
                    a.C0382a.C0383a aVar2 = a.C0382a.f20768a;
                    i2 = a.C0382a.k;
                }
                net.one97.paytm.v2.features.cashbacklanding.model.a aVar3 = new net.one97.paytm.v2.features.cashbacklanding.model.a((String) null, icon, title, savingsText, i2, 32);
                String bgImage = next.getBgImage();
                if (bgImage == null) {
                    bgImage = "";
                }
                aVar3.p = bgImage;
                arrayList.add(aVar3);
            }
            if (eVar.f20283h) {
                eVar.f20278c.clear();
                ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList2 = eVar.f20276a;
                if (arrayList2 != null) {
                    arrayList2.clear();
                }
                eVar.f20283h = false;
            }
            if (voucherList.size() > 0) {
                eVar.f20278c.addAll(voucherList);
            }
            if (arrayList.size() != 0) {
                eVar.f20276a.addAll(arrayList);
                eVar.f20282g.f20054a.setValue(h.a(eVar.f20276a));
            } else if (eVar.f20276a.size() == 0) {
                eVar.f20282g.f20054a.setValue(h.b());
            }
            y<Boolean> yVar = eVar.f20282g.f20058e;
            CashbackVoucherResponse response2 = cashbackVoucherListModal.getResponse();
            k.a((Object) response2, "response.response");
            String isNext = response2.getIsNext();
            if (isNext != null) {
                bool = Boolean.valueOf(isNext.equals("true"));
            }
            yVar.setValue(bool);
        }
    }
}

package net.one97.paytm.v2.features.cashbacklanding.d;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.TotalCashbackModel;
import net.one97.paytm.common.entity.vipcashback.TotalCashbackResponseModel;
import net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary;
import net.one97.paytm.v2.features.cashbacklanding.model.ScratchCardPromo;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.v2.b.b f20249a = new net.one97.paytm.v2.b.b();

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbacklanding.b.b f20250b;

    /* renamed from: c  reason: collision with root package name */
    public LiveData<String> f20251c;

    /* renamed from: d  reason: collision with root package name */
    private ScratchCardPromo f20252d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f20253e;

    /* renamed from: f  reason: collision with root package name */
    private int f20254f = 1;

    /* renamed from: g  reason: collision with root package name */
    private String f20255g;

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20256a;

        a(b bVar) {
            this.f20256a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            switch (hVar.f20893a) {
                case 101:
                    T t = hVar.f20894b;
                    b bVar = this.f20256a;
                    bVar.f20253e = bVar.f20253e + 1;
                    if (t instanceof ScratchCardPromo) {
                        b.a(this.f20256a, (ScratchCardPromo) t);
                    }
                    if (!(t instanceof TotalCashbackResponseModel)) {
                        return "result";
                    }
                    b.a(this.f20256a, (TotalCashbackResponseModel) t);
                    return "result";
                case 102:
                case 104:
                    b bVar2 = this.f20256a;
                    bVar2.f20253e = bVar2.f20253e + 1;
                    this.f20256a.f20249a.f20054a.setValue(hVar);
                    return "result";
                case 103:
                    this.f20256a.f20249a.f20054a.setValue(h.a());
                    return "result";
                default:
                    return "result";
            }
        }
    }

    public b() {
        LiveData<String> a2 = ah.a(this.f20249a.f20055b, new a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20251c = a2;
    }

    public final void a(Context context) {
        k.c(context, "appContext");
        this.f20254f = 1;
        this.f20253e = 0;
        this.f20250b = new net.one97.paytm.v2.features.cashbacklanding.b.b(new net.one97.paytm.v2.features.cashbacklanding.b.a());
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        Boolean H = f.H();
        k.a((Object) H, "GTMHelper.getInstance().isGetCashbackFromWeb");
        if (H.booleanValue()) {
            if (this.f20250b == null) {
                k.a("scratchCardRepository");
            }
            net.one97.paytm.v2.features.cashbacklanding.b.b.b(this.f20249a.f20055b, context);
            this.f20254f = 2;
        }
        if (this.f20250b == null) {
            k.a("scratchCardRepository");
        }
        net.one97.paytm.v2.features.cashbacklanding.b.b.a(this.f20249a.f20055b, context);
    }

    public static final /* synthetic */ void a(b bVar, ScratchCardPromo scratchCardPromo) {
        ScratchCardPromo.a data;
        ArrayList<CashbackSummary> arrayList;
        ScratchCardPromo.a data2;
        ArrayList<CashbackSummary> arrayList2;
        int i2 = bVar.f20253e;
        int i3 = bVar.f20254f;
        if (i2 < i3) {
            bVar.f20252d = scratchCardPromo;
            return;
        }
        bVar.f20252d = scratchCardPromo;
        boolean z = true;
        if (i3 != 1) {
            CharSequence charSequence = bVar.f20255g;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (z) {
                ScratchCardPromo scratchCardPromo2 = bVar.f20252d;
                if (!(scratchCardPromo2 == null || (data2 = scratchCardPromo2.getData()) == null || (arrayList2 = data2.f20286a) == null)) {
                    arrayList2.get(0).setAmount("0");
                }
            } else {
                ScratchCardPromo scratchCardPromo3 = bVar.f20252d;
                if (!(scratchCardPromo3 == null || (data = scratchCardPromo3.getData()) == null || (arrayList = data.f20286a) == null)) {
                    arrayList.get(0).setAmount(bVar.f20255g);
                }
            }
        }
        bVar.f20249a.f20054a.setValue(h.a(bVar.f20252d));
    }

    public static final /* synthetic */ void a(b bVar, TotalCashbackResponseModel totalCashbackResponseModel) {
        ArrayList<CashbackSummary> arrayList;
        ScratchCardPromo.a data;
        ArrayList<CashbackSummary> arrayList2;
        ScratchCardPromo.a data2;
        if (bVar.f20253e < bVar.f20254f) {
            List<TotalCashbackModel> response = totalCashbackResponseModel.getResponse();
            if (response == null) {
                k.a();
            }
            bVar.f20255g = String.valueOf((int) response.get(0).getAmt());
            return;
        }
        ScratchCardPromo scratchCardPromo = bVar.f20252d;
        if (scratchCardPromo == null || (data2 = scratchCardPromo.getData()) == null) {
            arrayList = null;
        } else {
            arrayList = data2.f20286a;
        }
        if (arrayList != null) {
            ScratchCardPromo scratchCardPromo2 = bVar.f20252d;
            if (!(scratchCardPromo2 == null || (data = scratchCardPromo2.getData()) == null || (arrayList2 = data.f20286a) == null)) {
                CashbackSummary cashbackSummary = arrayList2.get(0);
                List<TotalCashbackModel> response2 = totalCashbackResponseModel.getResponse();
                if (response2 == null) {
                    k.a();
                }
                cashbackSummary.setAmount(String.valueOf((int) response2.get(0).getAmt()));
            }
        } else {
            bVar.f20252d = new ScratchCardPromo();
            CashbackSummary cashbackSummary2 = new CashbackSummary();
            cashbackSummary2.setAmount(bVar.f20255g);
            a.c.C0385a aVar = a.c.f20786a;
            cashbackSummary2.setCategoryType(a.c.f20787b);
            CashbackSummary cashbackSummary3 = new CashbackSummary();
            cashbackSummary3.setAmount("0");
            a.c.C0385a aVar2 = a.c.f20786a;
            cashbackSummary3.setCategoryType(a.c.f20788c);
            ArrayList<CashbackSummary> arrayList3 = new ScratchCardPromo.a().f20286a;
            if (arrayList3 != null) {
                arrayList3.add(cashbackSummary2);
            }
            ArrayList<CashbackSummary> arrayList4 = new ScratchCardPromo.a().f20286a;
            if (arrayList4 != null) {
                arrayList4.add(cashbackSummary3);
            }
        }
        bVar.f20249a.f20054a.setValue(h.a(bVar.f20252d));
    }
}

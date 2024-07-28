package net.one97.paytm.upi.requestmoney.presenter;

import java.util.ArrayList;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.e;
import net.one97.paytm.upi.requestmoney.a.c;
import net.one97.paytm.upi.requestmoney.b.a.b;

public final class c implements c.a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<UpiDBTransactionModel> f69181a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    c.C1401c f69182b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<UpiDBTransactionModel> f69183c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private b f69184d;

    public c(c.C1401c cVar, b bVar) {
        this.f69184d = bVar;
        this.f69182b = cVar;
    }

    public final void a() {
        this.f69184d.a((e) new e() {
            public final void a(ArrayList<UpiDBTransactionModel> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                c.this.f69181a.addAll(arrayList);
                if (arrayList.size() > 4) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        arrayList2.add(arrayList.get(i2));
                    }
                    c.this.f69182b.a(true);
                } else {
                    arrayList2.addAll(arrayList);
                    c.this.f69182b.a(false);
                }
                c.this.f69181a.removeAll(arrayList2);
                c.this.f69182b.a((ArrayList<UpiDBTransactionModel>) arrayList2);
                c.this.f69182b.c(arrayList);
            }
        });
    }

    public final void a(int i2, c.b bVar) {
        UpiDBTransactionModel upiDBTransactionModel = this.f69183c.get(i2);
        bVar.a(upiDBTransactionModel.getBeneficiary_name());
        bVar.b(upiDBTransactionModel.getTxn_mode());
        bVar.a();
    }

    public final void a(ArrayList<UpiDBTransactionModel> arrayList) {
        this.f69183c.clear();
        this.f69183c = arrayList;
    }

    public final void a(int i2) {
        this.f69182b.a(this.f69183c.get(i2));
    }

    public final void b(ArrayList<UpiDBTransactionModel> arrayList) {
        this.f69183c.addAll(arrayList);
    }

    public final void c() {
        this.f69182b.b(this.f69181a);
    }

    public final int b() {
        return this.f69183c.size();
    }
}

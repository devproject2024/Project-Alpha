package net.one97.paytm.v2.features.cashbacklanding.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public final class ScratchCardPromo extends CashBackBaseModal {
    @b(a = "data")
    private a data;

    public final a getData() {
        return this.data;
    }

    public final void setData(a aVar) {
        this.data = aVar;
    }

    public final class a {
        @b(a = "summary")

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<CashbackSummary> f20286a = new ArrayList<>();

        public a() {
        }
    }
}

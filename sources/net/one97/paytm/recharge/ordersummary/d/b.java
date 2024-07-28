package net.one97.paytm.recharge.ordersummary.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.e.a;
import net.one97.paytm.recharge.ordersummary.e.c;

public class b extends f {
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    /* access modifiers changed from: protected */
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 != 6) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_status_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…atus_item, parent, false)");
            return new a(inflate, r(), d(), this.f64114d, this.f64111a, this.f64115e, this);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_refund_status_list, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…atus_list, parent, false)");
        return new net.one97.paytm.recharge.ordersummary.e.b(inflate2, r(), d(), this.f64114d, this.f64111a, this.f64115e, this);
    }

    /* access modifiers changed from: protected */
    public final void a(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof c) {
            ((c) vVar).a(b(i2));
        } else if (vVar instanceof net.one97.paytm.recharge.ordersummary.e.b) {
            b(i2);
            ((net.one97.paytm.recharge.ordersummary.e.b) vVar).a();
        }
    }
}

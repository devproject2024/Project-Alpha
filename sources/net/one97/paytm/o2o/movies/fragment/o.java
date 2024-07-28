package net.one97.paytm.o2o.movies.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.utils.g;

public class o extends n {

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f75407d;

    public static n d() {
        return new o();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f75407d = (LinearLayout) onCreateView.findViewById(R.id.id_no_selected_ll);
        e();
        return onCreateView;
    }

    private void e() {
        if (this.f75401a != null) {
            this.f75407d.setVisibility(this.f75401a.size() > 0 ? 8 : 0);
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f75401a = g.a().f75925b;
        if (this.f75401a != null && this.f75401a.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f75401a.size(); i2++) {
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = (CJRFoodBeverageItemV2) this.f75401a.get(i2);
                if (cJRFoodBeverageItemV2.getmFoodQauntitySelected() > 0) {
                    arrayList.add(cJRFoodBeverageItemV2);
                }
            }
            this.f75401a = arrayList;
            if (this.f75403c != null) {
                this.f75403c.f74697b = this.f75401a;
            }
        }
    }

    public final void c() {
        b();
        e();
        super.c();
    }
}

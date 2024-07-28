package net.one97.paytm.o2o.amusementpark.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.g;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f73560a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f73561b;

    /* renamed from: c  reason: collision with root package name */
    private g f73562c;

    public f(g gVar) {
        this.f73562c = gVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.filter_layout, viewGroup, false);
        this.f73560a = (RelativeLayout) inflate.findViewById(R.id.relativeLayoutSortByPrice);
        this.f73561b = (RelativeLayout) inflate.findViewById(R.id.relativeLayoutSortByLocation);
        this.f73560a.setOnClickListener(this);
        this.f73561b.setOnClickListener(this);
        return inflate;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.relativeLayoutSortByPrice) {
            this.f73562c.a();
            dismiss();
        } else if (view.getId() == R.id.relativeLayoutSortByLocation) {
            this.f73562c.b();
            dismiss();
        }
    }
}

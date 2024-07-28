package net.one97.paytm.paymentsBank.updateInfo.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f19437a;

    private View a(int i2) {
        if (this.f19437a == null) {
            this.f19437a = new HashMap();
        }
        View view = (View) this.f19437a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f19437a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_cersai_required_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) a(R.id.proceed)).setOnClickListener(new a(this));
        ((ImageView) a(R.id.cross_iv)).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19438a;

        a(c cVar) {
            this.f19438a = cVar;
        }

        public final void onClick(View view) {
            o.a().checkDeepLink(this.f19438a.getContext(), "paytmmp://edit_cersai");
            this.f19438a.dismiss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19439a;

        b(c cVar) {
            this.f19439a = cVar;
        }

        public final void onClick(View view) {
            this.f19439a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19437a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

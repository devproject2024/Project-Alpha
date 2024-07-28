package net.one97.paytm.packageScanner.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f57048a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.whitelist_apps_bottomsheet_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((LinearLayout) view.findViewById(R.id.proceed_layout)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f57049a;

        a(b bVar) {
            this.f57049a = bVar;
        }

        public final void onClick(View view) {
            if (d.a() != null) {
                d.a().F(this.f57049a.getActivity());
            }
            this.f57049a.dismiss();
            FragmentActivity activity = this.f57049a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57048a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

package net.one97.paytm.upi.profile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f68260a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_unverified_bottom_sheet, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.upi_close_button)).setOnClickListener(new a(this));
        return inflate;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f68261a;

        a(h hVar) {
            this.f68261a = hVar;
        }

        public final void onClick(View view) {
            this.f68261a.dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f68260a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

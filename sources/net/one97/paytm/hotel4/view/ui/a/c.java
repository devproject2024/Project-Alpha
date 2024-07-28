package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.ErrorViewModel;
import net.one97.paytm.hotels2.b.gq;
import net.one97.paytm.i.h;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    public gq f28798a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        gq a2 = gq.a(layoutInflater, viewGroup);
        k.a((Object) a2, "LayoutErrorFragmentBindi…flater, container, false)");
        this.f28798a = a2;
        gq gqVar = this.f28798a;
        if (gqVar == null) {
            k.a("layoutErrorFragmentBinding");
        }
        return gqVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(ErrorViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…rorViewModel::class.java]");
            ErrorViewModel errorViewModel = (ErrorViewModel) a2;
            gq gqVar = this.f28798a;
            if (gqVar == null) {
                k.a("layoutErrorFragmentBinding");
            }
            gqVar.a(errorViewModel);
            a.C0498a aVar = a.f28631a;
            gq gqVar2 = this.f28798a;
            if (gqVar2 == null) {
                k.a("layoutErrorFragmentBinding");
            }
            a.C0498a.a(gqVar2.f29868a, f.c("noroomsavailable"));
            gq gqVar3 = this.f28798a;
            if (gqVar3 == null) {
                k.a("layoutErrorFragmentBinding");
            }
            gqVar3.invalidateAll();
        }
    }
}

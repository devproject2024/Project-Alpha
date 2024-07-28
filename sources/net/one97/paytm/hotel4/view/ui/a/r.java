package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.utility.b.b.e;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.a;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.co;

public final class r extends ab {

    /* renamed from: a  reason: collision with root package name */
    public co f28942a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28943b;

    /* renamed from: c  reason: collision with root package name */
    public DetailsViewModel f28944c;

    static final class a<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f28945a;

        a(r rVar) {
            this.f28945a = rVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            r rVar = this.f28945a;
            k.a((Object) bool, "flag");
            r.a(rVar, bool.booleanValue());
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window == null) {
            k.a();
        }
        k.a((Object) window, "dialog?.window!!");
        window.getAttributes().windowAnimations = R.style.H4BottomSheet;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        DetailsViewModel detailsViewModel = this.f28944c;
        if (detailsViewModel == null) {
            k.a("viewModel");
        }
        detailsViewModel.get_closeNoRoomsBottomSheetClose().observe(this, new a(this));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28943b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28943b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(DetailsViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…ilsViewModel::class.java)");
            this.f28944c = (DetailsViewModel) a3;
        }
        co a4 = co.a(layoutInflater, viewGroup);
        k.a((Object) a4, "H4NoRoomsBottomSheetBind…flater, container, false)");
        this.f28942a = a4;
        co coVar = this.f28942a;
        if (coVar == null) {
            k.a("dataBinding");
        }
        DetailsViewModel detailsViewModel = this.f28944c;
        if (detailsViewModel == null) {
            k.a("viewModel");
        }
        coVar.a(detailsViewModel);
        co coVar2 = this.f28942a;
        if (coVar2 == null) {
            k.a("dataBinding");
        }
        coVar2.setLifecycleOwner(this);
        a.C0498a aVar = net.one97.paytm.hotel4.utils.a.f28631a;
        co coVar3 = this.f28942a;
        if (coVar3 == null) {
            k.a("dataBinding");
        }
        a.C0498a.a(coVar3.f29390b, f.c("noroomsavailable"), e.HIGH);
        co coVar4 = this.f28942a;
        if (coVar4 == null) {
            k.a("dataBinding");
        }
        return coVar4.getRoot();
    }

    public static final /* synthetic */ void a(r rVar, boolean z) {
        if (z) {
            rVar.dismiss();
            DetailsViewModel detailsViewModel = rVar.f28944c;
            if (detailsViewModel == null) {
                k.a("viewModel");
            }
            detailsViewModel.get_closeNoRoomsBottomSheetClose().postValue(Boolean.FALSE);
        }
    }
}

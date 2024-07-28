package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.b;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.au;
import net.one97.paytm.i.h;

public final class aa extends h implements e {

    /* renamed from: a  reason: collision with root package name */
    private DetailsViewModel f28780a;

    /* renamed from: b  reason: collision with root package name */
    private au f28781b;

    public final void a(c cVar) {
        DetailsViewModel detailsViewModel = this.f28780a;
        if (detailsViewModel == null) {
            k.a("detailsViewModel");
        }
        if (detailsViewModel.getSelectedData().getValue() != null) {
            DetailsViewModel detailsViewModel2 = this.f28780a;
            if (detailsViewModel2 == null) {
                k.a("detailsViewModel");
            }
            SRPDataItem value = detailsViewModel2.getSelectedData().getValue();
            if (value == null) {
                k.a();
            }
            double latitude = value.getLatitude();
            DetailsViewModel detailsViewModel3 = this.f28780a;
            if (detailsViewModel3 == null) {
                k.a("detailsViewModel");
            }
            SRPDataItem value2 = detailsViewModel3.getSelectedData().getValue();
            if (value2 == null) {
                k.a();
            }
            LatLng latLng = new LatLng(latitude, value2.getLongitude());
            MarkerOptions a2 = new MarkerOptions().a(latLng);
            DetailsViewModel detailsViewModel4 = this.f28780a;
            if (detailsViewModel4 == null) {
                k.a("detailsViewModel");
            }
            SRPDataItem value3 = detailsViewModel4.getSelectedData().getValue();
            if (value3 == null) {
                k.a();
            }
            cVar.a(a2.a(value3.getName()));
            cVar.a();
            cVar.b();
            cVar.a(b.a(latLng, 14.0f));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        au a2 = au.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4FragmentFullMapBinding…flater, container, false)");
        this.f28781b = a2;
        if (getActivity() != null) {
            SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().c(R.id.gmap);
            if (supportMapFragment == null) {
                k.a();
            }
            supportMapFragment.a(this);
        }
        au auVar = this.f28781b;
        if (auVar == null) {
            k.a("binding");
        }
        return auVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        au auVar = this.f28781b;
        if (auVar == null) {
            k.a("binding");
        }
        auVar.f29193a.setOnClickListener(new a(this));
        ai a2 = am.a(activity).a(SharedViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
        ai a3 = am.a(activity, (al.b) new ViewModelFactory((SharedViewModel) a2)).a(DetailsViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(it…ilsViewModel::class.java)");
        this.f28780a = (DetailsViewModel) a3;
        au auVar2 = this.f28781b;
        if (auVar2 == null) {
            k.a("binding");
        }
        DetailsViewModel detailsViewModel = this.f28780a;
        if (detailsViewModel == null) {
            k.a("detailsViewModel");
        }
        auVar2.a(detailsViewModel);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f28782a;

        a(aa aaVar) {
            this.f28782a = aaVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f28782a.getActivity();
            if (activity == null) {
                k.a();
            }
            activity.onBackPressed();
        }
    }
}

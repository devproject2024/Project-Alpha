package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.view.a.e;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.b.bi;

public final class l extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private bi f28882a;

    /* renamed from: b  reason: collision with root package name */
    private GalleryViewModel f28883b;

    /* renamed from: c  reason: collision with root package name */
    private PagerGalleryViewModel f28884c;

    /* renamed from: d  reason: collision with root package name */
    private e f28885d;

    /* renamed from: e  reason: collision with root package name */
    private int f28886e;

    /* renamed from: f  reason: collision with root package name */
    private HotelRoomTypeImages f28887f;

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        bi biVar = this.f28882a;
        if (biVar == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = biVar.f29256a;
        k.a((Object) recyclerView, "this.dataBinding.recycleImage");
        recyclerView.setLayoutManager(linearLayoutManager);
        PagerGalleryViewModel pagerGalleryViewModel = this.f28884c;
        if (pagerGalleryViewModel == null) {
            k.a("pagerGalleryViewModel");
        }
        this.f28885d = new e(pagerGalleryViewModel);
        bi biVar2 = this.f28882a;
        if (biVar2 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = biVar2.f29256a;
        k.a((Object) recyclerView2, "this.dataBinding.recycleImage");
        recyclerView2.setAdapter(this.f28885d);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f28886e = arguments.getInt(CLPConstants.ARGUMENT_KEY_POSITION, 0);
        GalleryViewModel galleryViewModel = this.f28883b;
        if (galleryViewModel == null) {
            k.a("galleryViewModel");
        }
        this.f28887f = galleryViewModel.getSelectedPosRoomImages(this.f28886e);
        e eVar = this.f28885d;
        if (eVar != null) {
            HotelRoomTypeImages hotelRoomTypeImages = this.f28887f;
            eVar.a(hotelRoomTypeImages != null ? hotelRoomTypeImages.getImageUrl() : null);
        }
        GalleryViewModel galleryViewModel2 = this.f28883b;
        if (galleryViewModel2 == null) {
            k.a("galleryViewModel");
        }
        Integer value = galleryViewModel2.getStateImageIndex().getValue();
        if (value != null) {
            bi biVar3 = this.f28882a;
            if (biVar3 == null) {
                k.a("dataBinding");
            }
            RecyclerView recyclerView3 = biVar3.f29256a;
            k.a((Object) value, "imageIndex");
            recyclerView3.smoothScrollToPosition(value.intValue());
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            al.b viewModelFactory = new ViewModelFactory((SharedViewModel) a2);
            ai a3 = am.a(activity, viewModelFactory).a(GalleryViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28883b = (GalleryViewModel) a3;
            ai a4 = am.a(activity, viewModelFactory).a(PagerGalleryViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28884c = (PagerGalleryViewModel) a4;
        }
        bi a5 = bi.a(layoutInflater, viewGroup);
        k.a((Object) a5, "H4GalleryListFragmentBin…flater, container, false)");
        this.f28882a = a5;
        bi biVar = this.f28882a;
        if (biVar == null) {
            k.a("dataBinding");
        }
        return biVar.getRoot();
    }

    public final void onResume() {
        e eVar = this.f28885d;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
        super.onResume();
    }
}

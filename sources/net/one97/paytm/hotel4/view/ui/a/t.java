package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.travel.customViews.d;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.view.a.f;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.b.bg;

public final class t extends b {

    /* renamed from: a  reason: collision with root package name */
    private bg f28963a;

    /* renamed from: b  reason: collision with root package name */
    private SharedViewModel f28964b;

    /* renamed from: c  reason: collision with root package name */
    private ViewModelFactory f28965c;

    /* renamed from: d  reason: collision with root package name */
    private GalleryViewModel f28966d;

    /* renamed from: e  reason: collision with root package name */
    private PagerGalleryViewModel f28967e;

    /* renamed from: f  reason: collision with root package name */
    private f f28968f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f28969g;

    public final void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        bg bgVar = this.f28963a;
        if (bgVar == null) {
            k.a("dataBinding");
        }
        bgVar.invalidateAll();
        bg bgVar2 = this.f28963a;
        if (bgVar2 == null) {
            k.a("dataBinding");
        }
        PagerGalleryViewModel pagerGalleryViewModel = this.f28967e;
        if (pagerGalleryViewModel == null) {
            k.a("pagerGalleryViewModel");
        }
        bgVar2.a(pagerGalleryViewModel);
        bg bgVar3 = this.f28963a;
        if (bgVar3 == null) {
            k.a("dataBinding");
        }
        q qVar = this;
        bgVar3.setLifecycleOwner(qVar);
        PagerGalleryViewModel pagerGalleryViewModel2 = this.f28967e;
        if (pagerGalleryViewModel2 == null) {
            k.a("pagerGalleryViewModel");
        }
        this.f28969g = pagerGalleryViewModel2.getAllImagesURL();
        this.f28968f = new f(getActivity(), this.f28969g);
        bg bgVar4 = this.f28963a;
        if (bgVar4 == null) {
            k.a("dataBinding");
        }
        ViewPager viewPager = bgVar4.f29247a;
        k.a((Object) viewPager, "dataBinding.galleryListPager");
        viewPager.setAdapter(this.f28968f);
        bg bgVar5 = this.f28963a;
        if (bgVar5 == null) {
            k.a("dataBinding");
        }
        bgVar5.f29247a.setPageTransformer(true, new d());
        bg bgVar6 = this.f28963a;
        if (bgVar6 == null) {
            k.a("dataBinding");
        }
        bgVar6.f29247a.addOnPageChangeListener(new b(this));
        PagerGalleryViewModel pagerGalleryViewModel3 = this.f28967e;
        if (pagerGalleryViewModel3 == null) {
            k.a("pagerGalleryViewModel");
        }
        Integer value = pagerGalleryViewModel3.getPagerGalleryImageIndex().getValue();
        if (value != null && (list = this.f28969g) != null && k.a(value.intValue(), 1) >= 0 && k.a(value.intValue(), list.size()) <= 0) {
            bg bgVar7 = this.f28963a;
            if (bgVar7 == null) {
                k.a("dataBinding");
            }
            ViewPager viewPager2 = bgVar7.f29247a;
            k.a((Object) viewPager2, "dataBinding.galleryListPager");
            viewPager2.setCurrentItem(value.intValue() - 1);
        }
        PagerGalleryViewModel pagerGalleryViewModel4 = this.f28967e;
        if (pagerGalleryViewModel4 == null) {
            k.a("pagerGalleryViewModel");
        }
        String currentScreenName = pagerGalleryViewModel4.getCurrentScreenName();
        int hashCode = currentScreenName.hashCode();
        if (hashCode != 54) {
            if (hashCode != 55 || currentScreenName.equals("7")) {
            }
        } else if (currentScreenName.equals("6")) {
            PagerGalleryViewModel pagerGalleryViewModel5 = this.f28967e;
            if (pagerGalleryViewModel5 == null) {
                k.a("pagerGalleryViewModel");
            }
            pagerGalleryViewModel5.getPagerGalleryImageIndex().observe(qVar, new a(this));
        }
    }

    public static final class b extends ViewPager.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f28971a;

        b(t tVar) {
            this.f28971a = tVar;
        }

        public final void onPageSelected(int i2) {
            t.a(this.f28971a, i2);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28964b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28964b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            this.f28965c = new ViewModelFactory(sharedViewModel);
            ViewModelFactory viewModelFactory = this.f28965c;
            if (viewModelFactory == null) {
                k.a("viewModelFactory");
            }
            ai a3 = am.a(activity, (al.b) viewModelFactory).a(GalleryViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28966d = (GalleryViewModel) a3;
            ViewModelFactory viewModelFactory2 = this.f28965c;
            if (viewModelFactory2 == null) {
                k.a("viewModelFactory");
            }
            ai a4 = am.a(activity, (al.b) viewModelFactory2).a(PagerGalleryViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28967e = (PagerGalleryViewModel) a4;
        }
        bg a5 = bg.a(layoutInflater, viewGroup);
        k.a((Object) a5, "H4GalleryItemSelectionFr…flater, container, false)");
        this.f28963a = a5;
        bg bgVar = this.f28963a;
        if (bgVar == null) {
            k.a("dataBinding");
        }
        return bgVar.getRoot();
    }

    static final class a<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f28970a;

        a(t tVar) {
            this.f28970a = tVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            t.a(this.f28970a);
        }
    }

    public static final /* synthetic */ void a(t tVar, int i2) {
        if (tVar.f28969g != null) {
            PagerGalleryViewModel pagerGalleryViewModel = tVar.f28967e;
            if (pagerGalleryViewModel == null) {
                k.a("pagerGalleryViewModel");
            }
            pagerGalleryViewModel.getPagerGalleryImageIndex().postValue(Integer.valueOf(i2 + 1));
        }
    }

    public static final /* synthetic */ void a(t tVar) {
        PagerGalleryViewModel pagerGalleryViewModel = tVar.f28967e;
        if (pagerGalleryViewModel == null) {
            k.a("pagerGalleryViewModel");
        }
        Integer value = pagerGalleryViewModel.getPagerGalleryImageIndex().getValue();
        if (value != null) {
            PagerGalleryViewModel pagerGalleryViewModel2 = tVar.f28967e;
            if (pagerGalleryViewModel2 == null) {
                k.a("pagerGalleryViewModel");
            }
            List value2 = pagerGalleryViewModel2.getRoomTypeImages().getValue();
            if (value2 != null) {
                PagerGalleryViewModel pagerGalleryViewModel3 = tVar.f28967e;
                if (pagerGalleryViewModel3 == null) {
                    k.a("pagerGalleryViewModel");
                }
                List<String> allImagesURL = pagerGalleryViewModel3.getAllImagesURL();
                String str = allImagesURL != null ? allImagesURL.get(value.intValue() - 1) : null;
                k.a((Object) value2, "roomTypes");
                int size = value2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    List<String> imageUrl = ((HotelRoomTypeImages) value2.get(i2)).getImageUrl();
                    Integer valueOf = imageUrl != null ? Integer.valueOf(kotlin.a.k.a(imageUrl, str)) : null;
                    if (valueOf == null || valueOf.intValue() != -1) {
                        GalleryViewModel galleryViewModel = tVar.f28966d;
                        if (galleryViewModel == null) {
                            k.a("galleryViewModel");
                        }
                        galleryViewModel.getStatePageIndex().postValue(Integer.valueOf(i2));
                        GalleryViewModel galleryViewModel2 = tVar.f28966d;
                        if (galleryViewModel2 == null) {
                            k.a("galleryViewModel");
                        }
                        galleryViewModel2.getStateImageIndex().postValue(valueOf);
                    }
                }
            }
        }
    }
}

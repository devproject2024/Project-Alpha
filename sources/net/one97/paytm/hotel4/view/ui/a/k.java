package net.one97.paytm.hotel4.view.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.view.a.g;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.bc;

public final class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public DetailsViewModel f28874a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f28875b;

    /* renamed from: c  reason: collision with root package name */
    private bc f28876c;

    /* renamed from: d  reason: collision with root package name */
    private GalleryViewModel f28877d;

    /* renamed from: e  reason: collision with root package name */
    private PagerGalleryViewModel f28878e;

    static final class a<T> implements z<List<HotelRoomTypeImages>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f28879a;

        a(k kVar) {
            this.f28879a = kVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                k.a(this.f28879a, list);
                k.b(this.f28879a, list);
            }
        }
    }

    static final class b<T> implements z<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f28880a;

        b(k kVar) {
            this.f28880a = kVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Map map = (Map) obj;
            k kVar = this.f28880a;
            kotlin.g.b.k.a((Object) map, "it");
            k.a(kVar, map);
        }
    }

    public static final /* synthetic */ GalleryViewModel a(k kVar) {
        GalleryViewModel galleryViewModel = kVar.f28877d;
        if (galleryViewModel == null) {
            kotlin.g.b.k.a("galleryViewModel");
        }
        return galleryViewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        r3 = r3.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r5, r0)
            super.onViewCreated(r5, r6)
            net.one97.paytm.hotels2.b.bc r5 = r4.f28876c
            java.lang.String r6 = "dataBinding"
            if (r5 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0012:
            r5.invalidateAll()
            net.one97.paytm.hotels2.b.bc r5 = r4.f28876c
            if (r5 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x001c:
            net.one97.paytm.hotel4.viewmodel.GalleryViewModel r0 = r4.f28877d
            java.lang.String r1 = "galleryViewModel"
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0025:
            r5.a((net.one97.paytm.hotel4.viewmodel.GalleryViewModel) r0)
            net.one97.paytm.hotels2.b.bc r5 = r4.f28876c
            if (r5 != 0) goto L_0x002f
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x002f:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r0 = r4.f28874a
            java.lang.String r2 = "detailsViewModel"
            if (r0 != 0) goto L_0x0038
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0038:
            r5.a((net.one97.paytm.hotel4.viewmodel.DetailsViewModel) r0)
            net.one97.paytm.hotels2.b.bc r5 = r4.f28876c
            if (r5 != 0) goto L_0x0042
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0042:
            r6 = r4
            androidx.lifecycle.q r6 = (androidx.lifecycle.q) r6
            r5.setLifecycleOwner(r6)
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r5 = r4.f28874a
            if (r5 != 0) goto L_0x004f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x004f:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r5 = r5.getDetailsResponse()
            if (r5 == 0) goto L_0x0084
            net.one97.paytm.hotel4.service.model.details.Data r5 = r5.getData()
            if (r5 == 0) goto L_0x0084
            java.util.List r5 = r5.getRoomOptions()
            if (r5 == 0) goto L_0x0084
            net.one97.paytm.hotel4.viewmodel.GalleryViewModel r0 = r4.f28877d
            if (r0 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0068:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r3 = r4.f28874a
            if (r3 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x006f:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r3 = r3.getDetailsResponse()
            if (r3 == 0) goto L_0x0080
            net.one97.paytm.hotel4.service.model.details.Data r3 = r3.getData()
            if (r3 == 0) goto L_0x0080
            net.one97.paytm.hotel4.service.model.details.PaytmImages r3 = r3.getPaytmImages()
            goto L_0x0081
        L_0x0080:
            r3 = 0
        L_0x0081:
            r0.setRoomOptions(r5, r3)
        L_0x0084:
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r5 = r4.f28874a
            if (r5 != 0) goto L_0x008b
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x008b:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r5 = r5.getDetailsResponse()
            if (r5 == 0) goto L_0x00a7
            net.one97.paytm.hotel4.service.model.details.Data r5 = r5.getData()
            if (r5 == 0) goto L_0x00a7
            java.lang.String r5 = r5.getName()
            if (r5 == 0) goto L_0x00a7
            net.one97.paytm.hotel4.viewmodel.GalleryViewModel r0 = r4.f28877d
            if (r0 != 0) goto L_0x00a4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00a4:
            r0.setTitle(r5)
        L_0x00a7:
            net.one97.paytm.hotel4.viewmodel.GalleryViewModel r5 = r4.f28877d
            if (r5 != 0) goto L_0x00ae
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00ae:
            androidx.lifecycle.y r5 = r5.getRoomTypeImages()
            net.one97.paytm.hotel4.view.ui.a.k$a r0 = new net.one97.paytm.hotel4.view.ui.a.k$a
            r0.<init>(r4)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r5.observe(r6, r0)
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r5 = r4.f28874a
            if (r5 != 0) goto L_0x00c3
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00c3:
            com.travel.utils.l r5 = r5.getSharePressed()
            net.one97.paytm.hotel4.view.ui.a.k$b r0 = new net.one97.paytm.hotel4.view.ui.a.k$b
            r0.<init>(r4)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r5.observe(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.k.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onResume() {
        super.onResume();
    }

    public static final class c extends ViewPager.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f28881a;

        c(k kVar) {
            this.f28881a = kVar;
        }

        public final void onPageSelected(int i2) {
            k.a(this.f28881a).getStatePageIndex().postValue(Integer.valueOf(i2));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28875b = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28875b;
            if (sharedViewModel == null) {
                kotlin.g.b.k.a("sharedViewModel");
            }
            al.b viewModelFactory = new ViewModelFactory(sharedViewModel);
            ai a3 = am.a(activity, viewModelFactory).a(DetailsViewModel.class);
            kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(it…ilsViewModel::class.java)");
            this.f28874a = (DetailsViewModel) a3;
            ai a4 = am.a(activity, viewModelFactory).a(GalleryViewModel.class);
            kotlin.g.b.k.a((Object) a4, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28877d = (GalleryViewModel) a4;
            ai a5 = am.a(activity, viewModelFactory).a(PagerGalleryViewModel.class);
            kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(it…eryViewModel::class.java)");
            this.f28878e = (PagerGalleryViewModel) a5;
        }
        bc a6 = bc.a(layoutInflater, viewGroup);
        kotlin.g.b.k.a((Object) a6, "H4GalleryFragmentBinding…flater, container, false)");
        this.f28876c = a6;
        bc bcVar = this.f28876c;
        if (bcVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return bcVar.getRoot();
    }

    public static final /* synthetic */ void a(k kVar, List list) {
        List arrayList = new ArrayList();
        List<String> imageUrl = ((HotelRoomTypeImages) list.get(0)).getImageUrl();
        if (imageUrl != null) {
            arrayList.addAll(imageUrl);
        }
        PagerGalleryViewModel pagerGalleryViewModel = kVar.f28878e;
        if (pagerGalleryViewModel == null) {
            kotlin.g.b.k.a("pagerGalleryViewModel");
        }
        pagerGalleryViewModel.setRoomTypeImages((List<HotelRoomTypeImages>) list);
        PagerGalleryViewModel pagerGalleryViewModel2 = kVar.f28878e;
        if (pagerGalleryViewModel2 == null) {
            kotlin.g.b.k.a("pagerGalleryViewModel");
        }
        pagerGalleryViewModel2.setAllImagesURL(arrayList);
    }

    public static final /* synthetic */ void b(k kVar, List list) {
        if (!list.isEmpty()) {
            bc bcVar = kVar.f28876c;
            if (bcVar == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            ViewPager viewPager = bcVar.f29232d;
            kotlin.g.b.k.a((Object) viewPager, "dataBinding.viewPager");
            if (viewPager != null) {
                j childFragmentManager = kVar.getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                GalleryViewModel galleryViewModel = kVar.f28877d;
                if (galleryViewModel == null) {
                    kotlin.g.b.k.a("galleryViewModel");
                }
                viewPager.setAdapter(new g(childFragmentManager, galleryViewModel));
                viewPager.setOffscreenPageLimit(3);
            }
            bc bcVar2 = kVar.f28876c;
            if (bcVar2 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            bcVar2.f29230b.setupWithViewPager(viewPager);
            bc bcVar3 = kVar.f28876c;
            if (bcVar3 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            bcVar3.f29230b.setSelectedTabIndicatorColor(Color.parseColor("#00baf2"));
            bc bcVar4 = kVar.f28876c;
            if (bcVar4 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            bcVar4.f29230b.setSelectedTabIndicatorHeight(8);
            GalleryViewModel galleryViewModel2 = kVar.f28877d;
            if (galleryViewModel2 == null) {
                kotlin.g.b.k.a("galleryViewModel");
            }
            Integer value = galleryViewModel2.getStatePageIndex().getValue();
            if (value != null) {
                bc bcVar5 = kVar.f28876c;
                if (bcVar5 == null) {
                    kotlin.g.b.k.a("dataBinding");
                }
                ViewPager viewPager2 = bcVar5.f29232d;
                kotlin.g.b.k.a((Object) viewPager2, "dataBinding.viewPager");
                kotlin.g.b.k.a((Object) value, "pageIndex");
                viewPager2.setCurrentItem(value.intValue());
            }
            bc bcVar6 = kVar.f28876c;
            if (bcVar6 == null) {
                kotlin.g.b.k.a("dataBinding");
            }
            bcVar6.f29232d.addOnPageChangeListener(new c(kVar));
        }
    }

    public static final /* synthetic */ void a(k kVar, Map map) {
        String string = kVar.getResources().getString(R.string.h4_sharing_message);
        kotlin.g.b.k.a((Object) string, "resources.getString(R.string.h4_sharing_message)");
        net.one97.paytm.hotels2.utils.c.b().a((Context) kVar.getActivity(), (Map<String, String>) map, string);
    }
}

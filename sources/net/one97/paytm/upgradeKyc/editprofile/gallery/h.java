package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.v;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.landingpage.R;

public final class h extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.g f65868a = v.a(this, y.b(j.class), new a(this), new b(this));

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65869b;

    /* access modifiers changed from: private */
    public final j a() {
        return (j) this.f65868a.getValue();
    }

    public final View a(int i2) {
        if (this.f65869b == null) {
            this.f65869b = new HashMap();
        }
        View view = (View) this.f65869b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65869b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends l implements kotlin.g.a.b<ArrayList<GalleryData>, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList<GalleryData>) (ArrayList) obj);
            return x.f47997a;
        }

        public final void invoke(ArrayList<GalleryData> arrayList) {
            RecyclerView recyclerView = (RecyclerView) this.this$0.a(R.id.photoRv);
            k.a((Object) recyclerView, "photoRv");
            recyclerView.setLayoutManager(new GridLayoutManager(this.this$0.requireContext(), 3));
            RecyclerView recyclerView2 = (RecyclerView) this.this$0.a(R.id.photoRv);
            k.a((Object) recyclerView2, "photoRv");
            k.a((Object) arrayList, "galleryDataArrayList");
            recyclerView2.setAdapter(new i(arrayList, new kotlin.g.a.b<String, x>(this) {
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return x.f47997a;
                }

                public final void invoke(String str) {
                    k.c(str, "it");
                    j a2 = this.this$0.this$0.a();
                    k.c(str, "photoUri");
                    if (k.a((Object) str, (Object) "camera_icon")) {
                        a2.m.setValue(x.f47997a);
                    } else {
                        a2.k.setValue(Uri.parse(str));
                    }
                }
            }));
        }
    }

    static final class d extends l implements kotlin.g.a.b<ArrayList<g>, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList<g>) (ArrayList) obj);
            return x.f47997a;
        }

        public final void invoke(ArrayList<g> arrayList) {
            RecyclerView recyclerView = (RecyclerView) this.this$0.a(R.id.albumRv);
            k.a((Object) recyclerView, "albumRv");
            recyclerView.setLayoutManager(new LinearLayoutManager(this.this$0.requireContext()));
            RecyclerView recyclerView2 = (RecyclerView) this.this$0.a(R.id.albumRv);
            k.a((Object) recyclerView2, "albumRv");
            k.a((Object) arrayList, "albumList");
            recyclerView2.setAdapter(new a(arrayList, new kotlin.g.a.b<g, x>(this) {
                final /* synthetic */ d this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((g) obj);
                    return x.f47997a;
                }

                public final void invoke(g gVar) {
                    k.c(gVar, "galleryAlbums");
                    j a2 = this.this$0.this$0.a();
                    k.c(gVar, "galleryAlbums");
                    a2.f65885c.clear();
                    int i2 = 0;
                    if (!gVar.f65867d.isEmpty()) {
                        a2.f65885c.addAll(gVar.f65867d);
                        if (!k.a((Object) a2.f65885c.get(0).f65838c, (Object) "camera_icon")) {
                            a2.f65885c.add(0, new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION));
                        }
                    } else {
                        a2.f65885c.add(new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION));
                    }
                    a2.f65886d.setValue(a2.f65885c);
                    a2.f65888f.setValue(gVar.f65865b);
                    MaterialCardView materialCardView = (MaterialCardView) this.this$0.this$0.a(R.id.albumCl);
                    k.a((Object) materialCardView, "albumCl");
                    MaterialCardView materialCardView2 = (MaterialCardView) this.this$0.this$0.a(R.id.albumCl);
                    k.a((Object) materialCardView2, "albumCl");
                    if (net.one97.paytm.upi.f.d(materialCardView2)) {
                        i2 = 8;
                    }
                    materialCardView.setVisibility(i2);
                }
            }));
        }
    }

    static final class e extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            TextView textView = (TextView) this.this$0.a(R.id.albumNameTv);
            k.a((Object) textView, "albumNameTv");
            textView.setText(str);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_gallery, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        GalleryData galleryData;
        ArrayList<GalleryData> arrayList;
        GalleryData galleryData2;
        ArrayList<GalleryData> arrayList2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (androidx.core.content.b.a(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            j a2 = a();
            a2.f65884b.clear();
            a2.f65890h.clear();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Context context = a2.f65883a;
            k.a((Object) context, "application");
            Cursor query = context.getContentResolver().query(uri, new String[]{"_id", "date_added", "bucket_display_name", "title"}, (String) null, (String[]) null, "datetaken DESC");
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query.moveToFirst()) {
                            int columnIndex = query.getColumnIndex("_id");
                            int columnIndex2 = query.getColumnIndex("date_added");
                            do {
                                String string = query.getString(query.getColumnIndex("bucket_display_name"));
                                String string2 = query.getString(columnIndex);
                                String string3 = query.getString(columnIndex2);
                                GalleryData galleryData3 = r15;
                                GalleryData galleryData4 = new GalleryData((String) null, (String) null, false, 0, (String) null, (String) null, 1023);
                                String uri2 = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, query.getString(columnIndex)).toString();
                                k.a((Object) uri2, "Uri.withAppendedPath(\n  …ing(idColumn)).toString()");
                                k.a((Object) string, "bucketName");
                                k.c(string, "<set-?>");
                                GalleryData galleryData5 = galleryData3;
                                galleryData5.f65837b = string;
                                Integer valueOf = Integer.valueOf(string2);
                                k.a((Object) valueOf, "Integer.valueOf(id)");
                                galleryData5.f65836a = valueOf.intValue();
                                k.c(uri2, "<set-?>");
                                galleryData5.f65838c = uri2;
                                galleryData5.f65840e = 1;
                                k.a((Object) string3, "dateAdded");
                                k.c(string3, "<set-?>");
                                galleryData5.f65841f = string3;
                                if (arrayList4.contains(galleryData5.f65837b)) {
                                    Iterator it2 = arrayList3.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        g gVar = (g) it2.next();
                                        if (k.a((Object) gVar.f65865b, (Object) galleryData5.f65837b)) {
                                            galleryData5.f65839d = gVar.f65864a;
                                            gVar.f65867d.add(galleryData5);
                                            a2.f65884b.add(galleryData5);
                                            break;
                                        }
                                    }
                                } else {
                                    g gVar2 = new g((String) null, (String) null, (ArrayList) null, 15);
                                    gVar2.f65864a = galleryData5.f65836a;
                                    galleryData5.f65839d = galleryData5.f65836a;
                                    String str = galleryData5.f65837b;
                                    k.c(str, "<set-?>");
                                    gVar2.f65865b = str;
                                    String str2 = galleryData5.f65838c;
                                    k.c(str2, "<set-?>");
                                    gVar2.f65866c = str2;
                                    gVar2.f65867d.add(galleryData5);
                                    a2.f65884b.add(galleryData5);
                                    arrayList3.add(gVar2);
                                    arrayList4.add(galleryData5.f65837b);
                                }
                            } while (query.moveToNext());
                        }
                        query.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (!(!a2.f65884b.isEmpty()) || !(!k.a((Object) a2.f65884b.get(0).f65838c, (Object) "camera_icon"))) {
                        arrayList = a2.f65884b;
                        galleryData = new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION);
                    } else {
                        arrayList2 = a2.f65884b;
                        galleryData2 = new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION);
                    }
                } catch (Throwable th) {
                    if (!(!a2.f65884b.isEmpty()) || !(!k.a((Object) a2.f65884b.get(0).f65838c, (Object) "camera_icon"))) {
                        a2.f65884b.add(new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION));
                    } else {
                        a2.f65884b.add(0, new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION));
                    }
                    a2.f65886d.setValue(a2.f65884b);
                    a2.a(arrayList3);
                    throw th;
                }
            }
            if (!(!a2.f65884b.isEmpty()) || !(!k.a((Object) a2.f65884b.get(0).f65838c, (Object) "camera_icon"))) {
                arrayList = a2.f65884b;
                galleryData = new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION);
                arrayList.add(galleryData);
                a2.f65886d.setValue(a2.f65884b);
                a2.a(arrayList3);
            } else {
                arrayList2 = a2.f65884b;
                galleryData2 = new GalleryData((String) null, "camera_icon", false, 0, (String) null, (String) null, SharedHomeVM.GET_NAV_POSITION);
                arrayList2.add(0, galleryData2);
                a2.f65886d.setValue(a2.f65884b);
                a2.a(arrayList3);
            }
        }
        a().f65887e.observe(getViewLifecycleOwner(), new e(new c(this)));
        a().j.observe(getViewLifecycleOwner(), new e(new d(this)));
        a().f65889g.observe(getViewLifecycleOwner(), new e(new e(this)));
        ((ImageView) a(R.id.allPhotosIv)).setOnClickListener(new f(this));
        ((TextView) a(R.id.albumNameTv)).setOnClickListener(new g(this));
        ((TextView) a(R.id.cancelTv)).setOnClickListener(new C1311h(this));
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f65870a;

        f(h hVar) {
            this.f65870a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f65870a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f65871a;

        g(h hVar) {
            this.f65871a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f65871a);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.gallery.h$h  reason: collision with other inner class name */
    static final class C1311h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f65872a;

        C1311h(h hVar) {
            this.f65872a = hVar;
        }

        public final void onClick(View view) {
            this.f65872a.a().r.setValue(x.f47997a);
        }
    }

    public static final class a extends l implements kotlin.g.a.a<an> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final an invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            an viewModelStore = requireActivity.getViewModelStore();
            k.a((Object) viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class b extends l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final al.b invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            al.b defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            k.a((Object) defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final /* synthetic */ void b(h hVar) {
        MaterialCardView materialCardView = (MaterialCardView) hVar.a(R.id.albumCl);
        k.a((Object) materialCardView, "albumCl");
        MaterialCardView materialCardView2 = (MaterialCardView) hVar.a(R.id.albumCl);
        k.a((Object) materialCardView2, "albumCl");
        materialCardView.setVisibility(net.one97.paytm.upi.f.d(materialCardView2) ? 8 : 0);
        MaterialCardView materialCardView3 = (MaterialCardView) hVar.a(R.id.albumCl);
        k.a((Object) materialCardView3, "albumCl");
        if (net.one97.paytm.upi.f.d(materialCardView3)) {
            j a2 = hVar.a();
            a2.f65891i.setValue(a2.f65890h);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65869b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

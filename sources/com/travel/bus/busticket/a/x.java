package com.travel.bus.busticket.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.fragment.c;
import com.travel.bus.busticket.fragment.f;
import com.travel.bus.busticket.fragment.g;
import com.travel.bus.busticket.fragment.h;
import com.travel.bus.busticket.fragment.i;
import com.travel.bus.busticket.i.e;
import com.travel.bus.busticket.i.w;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.photos.CJRBusPhoto;
import com.travel.bus.pojo.photos.CJRBusPhotoWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class x extends m {

    /* renamed from: a  reason: collision with root package name */
    public CJRBusSearchItem f21794a;

    /* renamed from: b  reason: collision with root package name */
    public Context f21795b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f21796c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<Fragment> f21797d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public h f21798e;

    /* renamed from: f  reason: collision with root package name */
    public c f21799f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21800g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21801h;

    /* renamed from: i  reason: collision with root package name */
    private String f21802i;
    private String j;
    private CJRBusSearchInput k;
    private HashMap<String, CJRBusSearchAmenitiesInfo> l;
    private boolean m;
    private f n;
    private i o;

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public x(j jVar, Context context, CJRBusSearchItem cJRBusSearchItem, String str, boolean z, String str2, CJRBusSearchInput cJRBusSearchInput, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, boolean z2) {
        super(jVar);
        this.f21795b = context;
        this.f21794a = cJRBusSearchItem;
        this.f21802i = str;
        this.k = cJRBusSearchInput;
        this.l = hashMap;
        this.m = z2;
        this.f21800g = z;
        this.f21801h = cJRBusSearchItem.getPhotos() != null && cJRBusSearchItem.getPhotos().size() > 0;
        this.j = str2;
        a();
    }

    public final void a() {
        this.f21796c = new Bundle();
        this.f21796c.putBoolean("bundle_dropping_point", false);
        this.f21796c.putSerializable("intent_extra_bus_search_result_item", this.f21794a);
        this.f21796c.putString("intent_extra_bus_search", this.f21802i);
        this.f21796c.putSerializable("intent_extra_bus_search_input", this.k);
        this.f21796c.putSerializable("amenity", this.l);
        if (this.f21801h) {
            this.f21796c.putSerializable("extra_photos", a(this.f21794a.getPhotos()));
        }
        this.f21796c.putString("route", this.j);
        if (this.m) {
            this.f21796c.putBoolean("intent_extra_flag_bp_dp_required", true);
        } else {
            this.f21796c.putBoolean("intent_extra_flag_bp_dp_required", false);
        }
    }

    private static ArrayList<CJRBusPhoto> a(ArrayList<CJRBusPhotoWrapper> arrayList) {
        ArrayList<CJRBusPhoto> arrayList2 = new ArrayList<>();
        Iterator<CJRBusPhotoWrapper> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRBusPhotoWrapper next = it2.next();
            if (!(next == null || next.getApp() == null || com.travel.bus.pojo.busticket.f.f22810b == null)) {
                CJRBusPhoto cJRBusPhoto = new CJRBusPhoto();
                cJRBusPhoto.setThumbnail(com.travel.bus.pojo.busticket.f.f22810b + next.getApp().getThumbnail());
                cJRBusPhoto.setPhoto(com.travel.bus.pojo.busticket.f.f22810b + next.getApp().getPhoto());
                arrayList2.add(cJRBusPhoto);
            }
        }
        return arrayList2;
    }

    public final Fragment getItem(int i2) {
        if (!this.f21800g || !this.f21801h) {
            if (this.f21800g) {
                if (i2 == 0) {
                    return a(w.busSelectSeat, i2);
                }
                if (i2 == 1) {
                    return a(w.busReviews, i2);
                }
                if (i2 == 2) {
                    return a(w.busRoute, i2);
                }
                if (i2 != 3) {
                    return null;
                }
                return a(w.busCancellation, i2);
            } else if (this.f21801h) {
                if (i2 == 0) {
                    return a(w.busSelectSeat, i2);
                }
                if (i2 == 1) {
                    return a(w.busPhotos, i2);
                }
                if (i2 == 2) {
                    return a(w.busRoute, i2);
                }
                if (i2 != 3) {
                    return null;
                }
                return a(w.busCancellation, i2);
            } else if (i2 == 0) {
                return a(w.busSelectSeat, i2);
            } else {
                if (i2 == 1) {
                    return a(w.busRoute, i2);
                }
                if (i2 != 2) {
                    return null;
                }
                return a(w.busCancellation, i2);
            }
        } else if (i2 == 0) {
            return a(w.busSelectSeat, i2);
        } else {
            if (i2 == 1) {
                return a(w.busPhotos, i2);
            }
            if (i2 == 2) {
                return a(w.busReviews, i2);
            }
            if (i2 == 3) {
                return a(w.busRoute, i2);
            }
            if (i2 != 4) {
                return null;
            }
            return a(w.busCancellation, i2);
        }
    }

    public final int getCount() {
        if (!this.f21800g || !this.f21801h) {
            return (this.f21800g || this.f21801h) ? 4 : 3;
        }
        return 5;
    }

    public final Fragment a(int i2) {
        try {
            return this.f21797d.get(i2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    private void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_seat");
        hashMap.put("event_action", "seat_selection_cancellation_policy");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n(this.f21795b));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, this.f21795b);
    }

    public final void a(boolean z) {
        for (int i2 = 0; i2 < this.f21797d.size(); i2++) {
            if (a(i2) != null && !(a(i2) instanceof g)) {
                ((com.travel.bus.busticket.f.f) a(i2)).a(z);
            }
        }
    }

    /* renamed from: com.travel.bus.busticket.a.x$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21803a = new int[w.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.travel.bus.busticket.i.w[] r0 = com.travel.bus.busticket.i.w.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21803a = r0
                int[] r0 = f21803a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f21803a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busPhotos     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f21803a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busReviews     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f21803a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f21803a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.a.x.AnonymousClass1.<clinit>():void");
        }
    }

    private Fragment a(w wVar, int i2) {
        int i3 = AnonymousClass1.f21803a[wVar.ordinal()];
        if (i3 == 1) {
            if (this.o == null) {
                this.o = new i();
                this.o.setArguments(this.f21796c);
                this.f21797d.put(i2, this.o);
            }
            return this.o;
        } else if (i3 == 2) {
            this.n = new f();
            this.n.setArguments(this.f21796c);
            this.f21797d.put(i2, this.n);
            return this.n;
        } else if (i3 == 3) {
            g gVar = new g(this.j);
            gVar.setArguments(this.f21796c);
            this.f21797d.put(i2, gVar);
            return gVar;
        } else if (i3 == 4) {
            this.f21798e = new h();
            this.f21798e.setArguments(this.f21796c);
            this.f21797d.put(i2, this.f21798e);
            return this.f21798e;
        } else if (i3 != 5) {
            return null;
        } else {
            this.f21799f = new c();
            this.f21799f.setArguments(this.f21796c);
            this.f21797d.put(i2, this.f21799f);
            return this.f21799f;
        }
    }

    public final void a(TabLayout.f fVar) {
        TextView textView = (TextView) fVar.f36766f.findViewById(R.id.tab_title);
        textView.setTypeface(Typeface.DEFAULT_BOLD, 1);
        textView.setTextColor(androidx.core.content.b.c(this.f21795b, R.color.bus_tab_selected_text));
        textView.setBackground(androidx.core.content.b.a(this.f21795b, R.drawable.travel_res_bus_rating_button_background_pressed));
        if (fVar.f36765e == e.a(w.busCancellation, this.f21800g, this.f21801h)) {
            b();
        }
    }
}

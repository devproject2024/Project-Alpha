package com.travel.travels.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.sale.f;
import com.travel.utils.e;
import com.travel.utils.p;
import com.travel.widget.CJRPagerSlidingTabStrip;
import java.lang.ref.WeakReference;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends o implements CJRPagerSlidingTabStrip.b {
    private static String l = "CJRTravelHomeAdapter";

    /* renamed from: a  reason: collision with root package name */
    public List<CJRHomePageItem> f28427a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Fragment> f28428b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public CJRItem f28429c;

    /* renamed from: d  reason: collision with root package name */
    public String f28430d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f28431e;

    /* renamed from: f  reason: collision with root package name */
    public j f28432f;

    /* renamed from: g  reason: collision with root package name */
    public String f28433g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28434h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28435i;
    public SparseArray<WeakReference<Fragment>> j;
    public int k;
    private DeepLinkData m;
    private a n;

    public interface a {
        void b();
    }

    public static String a() {
        return "com.travel.citybus.brts.CityBusHomeFragment";
    }

    public static String b() {
        return "net.one97.travelpass.ui.fragment.TravelPassHomeFragment";
    }

    public final Parcelable saveState() {
        return null;
    }

    public b(j jVar, List<CJRHomePageItem> list, CJRItem cJRItem, String str, String str2, Bundle bundle, DeepLinkData deepLinkData, a aVar) {
        super(jVar);
        this.f28432f = jVar;
        this.f28427a = list;
        this.f28429c = cJRItem;
        this.f28430d = str;
        this.f28433g = str2;
        this.f28431e = bundle;
        this.m = deepLinkData;
        this.j = new SparseArray<>();
        this.n = aVar;
        this.k = 0;
    }

    public final int getCount() {
        return this.f28427a.size();
    }

    public final String a(int i2) {
        return this.f28427a.get(i2).getImageUrl();
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f28427a.get(i2).getName();
    }

    private synchronized void a(int i2, Fragment fragment) {
        this.j.put(i2, new WeakReference(fragment));
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        try {
            this.f28428b.remove(i2);
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                fragment.onDestroyView();
            }
            viewGroup.removeView(fragment.getView());
            try {
                if (i2 <= getCount()) {
                    q a2 = ((Fragment) obj).getFragmentManager().a();
                    a2.a((Fragment) obj);
                    a2.b();
                }
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        super.destroyItem(viewGroup, i2, obj);
    }

    public final Fragment getItem(int i2) {
        Fragment fragment;
        com.travel.d.a aVar;
        Fragment fVar;
        CJRHomePageItem cJRHomePageItem;
        Bundle bundle = new Bundle();
        CJRHomePageItem cJRHomePageItem2 = this.f28427a.get(i2);
        CJRItem cJRItem = this.f28429c;
        if (cJRItem != null) {
            bundle.putSerializable("extra_home_data", cJRItem);
        }
        DeepLinkData deepLinkData = this.m;
        if (deepLinkData != null) {
            bundle.putString("deeplink-data", deepLinkData.f50283a);
            this.m = null;
        }
        SparseArray<Fragment> sparseArray = this.f28428b;
        if (sparseArray == null || sparseArray.get(i2) == null) {
            String str = this.f28430d;
            if (str != null) {
                bundle.putSerializable("origin", str);
            }
            if (!TextUtils.isEmpty(this.f28433g)) {
                bundle.putString(UpiConstants.FROM, this.f28433g);
                this.f28433g = "";
            }
            bundle.putSerializable("bundle_extra_category_item", this.f28427a.get(i2));
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            if (cJRHomePageItem2 == null) {
                aVar = new com.travel.d.a();
                Bundle bundle2 = new Bundle();
                bundle2.putString("url_type", cJRHomePageItem2.getURLType());
                aVar.setArguments(bundle2);
            } else if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase("busticket")) {
                fragment = e.c("com.travel.bus.busticket.fragment.FJRBusTicketFragment");
                new StringBuilder("inside getItem returning ").append(fragment.getClass().getName());
                Bundle bundle3 = this.f28431e;
                if (bundle3 != null) {
                    bundle.putAll(bundle3);
                }
                StringBuilder sb = new StringBuilder(" pageref position ");
                sb.append(i2);
                sb.append(" object ");
                sb.append(this.f28428b.get(i2));
                sb.append(" current fragment ");
                sb.append(fragment);
                if (fragment != null) {
                    if (fragment.getArguments() != null) {
                        fragment.getArguments().putAll(bundle);
                    } else {
                        fragment.setArguments(bundle);
                    }
                }
                this.f28428b.put(i2, fragment);
                a(i2, fragment);
                this.f28435i = true;
                this.n.b();
                return fragment;
            } else if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase("flightticket")) {
                fragment = e.c("com.travel.flight.flightticket.fragment.FJRFlightTicketFragment");
                fragment.setArguments(bundle);
                c();
                this.f28428b.put(i2, fragment);
                a(i2, fragment);
                this.f28435i = true;
                this.n.b();
                return fragment;
            } else if (cJRHomePageItem2.getURLType() == null || (!cJRHomePageItem2.getURLType().equalsIgnoreCase("trainticket") && !cJRHomePageItem2.getURLType().equalsIgnoreCase("trainticketv2"))) {
                if ("internationalflights".equalsIgnoreCase(cJRHomePageItem2.getURLType())) {
                    bundle.putBoolean("isInternational", true);
                    bundle.putSerializable("bundle_extra_category_item", a(cJRHomePageItem2));
                    fragment = e.c("com.travel.flight.flightticket.fragment.FJRFlightTicketFragment");
                    fragment.setArguments(bundle);
                    c();
                } else {
                    if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase(CLPConstants.GA_CHANNEL_NAME)) {
                        fVar = new com.travel.travels.b.b();
                        bundle.putSerializable("catalogItem", a(cJRHomePageItem2));
                        fVar.setArguments(bundle);
                    } else if (cJRHomePageItem2.getURLType() != null && (cJRHomePageItem2.getURLType().equalsIgnoreCase("travelpass") || cJRHomePageItem2.getURLType().equalsIgnoreCase("travel-pass-about") || cJRHomePageItem2.getURLType().equalsIgnoreCase("travel-pass-details") || cJRHomePageItem2.getURLType().equalsIgnoreCase("travel-my-pass"))) {
                        fragment = e.c("net.one97.travelpass.ui.fragment.TravelPassHomeFragment");
                        bundle.putString("origin", bundle.getString("origin"));
                        if (bundle.containsKey("extra_home_data") && (cJRHomePageItem = (CJRHomePageItem) bundle.getSerializable("extra_home_data")) != null) {
                            if (!TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
                                bundle.putString("deeplink", cJRHomePageItem.getDeeplink());
                            }
                            if (!TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                                bundle.putString("deepLinkUrl", cJRHomePageItem.getURL());
                            }
                        }
                        fragment.setArguments(bundle);
                        new StringBuilder("inside getItem returning ").append(fragment);
                    } else if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase("hotel-booking")) {
                        Fragment c2 = e.c("net.one97.paytm.hotels2.fragment.HotelHomeFragment");
                        bundle.putSerializable("bundle_extra_category_item", a(cJRHomePageItem2));
                        bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                        bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                        c2.setArguments(bundle);
                        fragment = c2;
                    } else if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase("travelmetro")) {
                        fragment = e.c("com.travel.train.fragment.FJRMetroHomeFragment");
                        fragment.setArguments(bundle);
                    } else if (cJRHomePageItem2.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase("travelcampaign")) {
                        fVar = new f();
                        bundle.putString("deeplink", cJRHomePageItem2.getURL());
                        fVar.setArguments(bundle);
                        new StringBuilder("inside getItem returning ").append(fVar);
                    } else if (cJRHomePageItem2.getURLType() == null || !cJRHomePageItem2.getURLType().equalsIgnoreCase("citybus")) {
                        aVar = new com.travel.d.a();
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("url_type", cJRHomePageItem2.getURLType());
                        aVar.setArguments(bundle4);
                    } else {
                        Fragment c3 = e.c("com.travel.citybus.brts.CityBusHomeFragment");
                        bundle.putBoolean("tab", true);
                        c3.setArguments(bundle);
                        this.f28428b.put(i2, c3);
                        return c3;
                    }
                    fragment = fVar;
                }
                this.f28428b.put(i2, fragment);
                a(i2, fragment);
                if (!this.f28435i && i2 == this.k) {
                    this.f28435i = true;
                    this.n.b();
                }
                return fragment;
            } else {
                fragment = e.c("com.travel.train.fragment.FJRTrainHomeFragment");
                fragment.setArguments(bundle);
                CJRItem cJRItem2 = this.f28429c;
                if (cJRItem2 != null && !TextUtils.isEmpty(cJRItem2.getURLType()) && p.b(this.f28429c.getURLType())) {
                    this.f28429c = null;
                }
                new StringBuilder("inside getItem returning ").append(fragment);
                this.f28428b.put(i2, fragment);
                a(i2, fragment);
                this.f28435i = true;
                this.n.b();
                return fragment;
            }
            fragment = aVar;
            this.f28428b.put(i2, fragment);
            a(i2, fragment);
            this.f28435i = true;
            this.n.b();
            return fragment;
        }
        a(i2, this.f28428b.get(i2));
        return this.f28428b.get(i2);
    }

    private void c() {
        CJRItem cJRItem;
        if (this.f28434h && (cJRItem = this.f28429c) != null && !TextUtils.isEmpty(cJRItem.getURLType()) && p.f(this.f28429c.getURLType())) {
            this.f28429c = null;
        }
    }

    private static CJRCatalogItem a(CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem == null) {
            return null;
        }
        CJRCatalogItem cJRCatalogItem = new CJRCatalogItem();
        cJRCatalogItem.setName(cJRHomePageItem.getName());
        cJRCatalogItem.setListId(cJRHomePageItem.getListId());
        cJRCatalogItem.setURLType(cJRHomePageItem.getURLType());
        cJRCatalogItem.setUrl(cJRHomePageItem.getURL());
        return cJRCatalogItem;
    }
}

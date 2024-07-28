package com.travel.bus.busticket.busfilter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.busticket.busfilter.a.d;
import com.travel.bus.busticket.busfilter.b.b;
import com.travel.bus.busticket.busfilter.b.c;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRTravelName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;

public final class BusFilterSortActivity extends PaytmActivity implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    public d f21991a;

    /* renamed from: b  reason: collision with root package name */
    public TabLayout f21992b;

    /* renamed from: c  reason: collision with root package name */
    public Toolbar f21993c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21994d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21995e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f21996f;

    /* renamed from: g  reason: collision with root package name */
    private String f21997g = "BusFilterSortActivity";

    /* renamed from: h  reason: collision with root package name */
    private a f21998h = new a();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f21999i;
    private CJRBusTicketFilters j;
    private String k = "";
    private String l = "";
    private boolean m;
    private HashMap<String, CJRBusSearchAmenitiesInfo> n;
    private HashMap<String, CJRBusSearchOperatorTagInfo> o;
    private ArrayList<CJRBusSearchAmenitiesInfo> p = new ArrayList<>();
    private boolean q;
    private String r = "";
    private boolean s;

    public final void onCreate(Bundle bundle) {
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList;
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap;
        HashMap<String, CJRBusSearchOperatorTagInfo> hashMap2;
        String str;
        CJRBusTicketFilters cJRBusTicketFilters2;
        String str2;
        CJRBusTicketFilters cJRBusTicketFilters3;
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList2;
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap3;
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap4;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        HashMap<String, CJRBusSearchOperatorTagInfo> hashMap5;
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap6;
        super.onCreate(bundle);
        setContentView(R.layout.bus_filter_sort_activity);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("intent_extra_bus_start_city")) {
            String stringExtra = intent.getStringExtra("intent_extra_bus_start_city");
            k.a((Object) stringExtra, "intent.getStringExtra(CJ…ENT_EXTRA_BUS_START_CITY)");
            this.k = stringExtra;
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_dest_city")) {
            String stringExtra2 = intent.getStringExtra("intent_extra_bus_dest_city");
            k.a((Object) stringExtra2, "intent.getStringExtra(CJ…TENT_EXTRA_BUS_DEST_CITY)");
            this.l = stringExtra2;
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_items")) {
            Serializable serializableExtra = intent.getSerializableExtra("intent_extra_bus_search_filter_items");
            if (serializableExtra != null) {
                this.j = (CJRBusTicketFilters) serializableExtra;
            } else {
                throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
            }
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_on_no_bus")) {
            this.m = intent.getBooleanExtra("intent_extra_bus_search_filter_on_no_bus", false);
        }
        if (intent != null && intent.hasExtra("amenity_info")) {
            Serializable serializableExtra2 = intent.getSerializableExtra("amenity_info");
            if (serializableExtra2 != null) {
                this.n = (HashMap) serializableExtra2;
            } else {
                throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo>");
            }
        }
        if (intent != null && intent.hasExtra("operatortag_info")) {
            Serializable serializableExtra3 = intent.getSerializableExtra("operatortag_info");
            if (serializableExtra3 != null) {
                this.o = (HashMap) serializableExtra3;
            } else {
                throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo>");
            }
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_amenity_items")) {
            Serializable serializableExtra4 = intent.getSerializableExtra("intent_extra_bus_search_filter_amenity_items");
            if (serializableExtra4 != null) {
                this.p = (ArrayList) serializableExtra4;
            } else {
                throw new u("null cannot be cast to non-null type java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo>");
            }
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_is_deals_available")) {
            this.q = intent.getBooleanExtra("intent_extra_bus_search_filter_is_deals_available", false);
        }
        if (intent != null && intent.hasExtra("intent_extra_bus_search_filter_is_popular_choice")) {
            String stringExtra3 = intent.getStringExtra("intent_extra_bus_search_filter_is_popular_choice");
            k.a((Object) stringExtra3, "intent.getStringExtra(CJ…TER_POPULAR_CHOICE_ITEMS)");
            this.r = stringExtra3;
        }
        if (intent != null && intent.hasExtra("intent_extra_flag_bp_dp_required")) {
            this.s = intent.getBooleanExtra("intent_extra_flag_bp_dp_required", false);
        }
        this.f21998h = new a();
        a aVar = this.f21998h;
        String str9 = this.k;
        k.c(str9, "value");
        aVar.f22002b = str9;
        a aVar2 = this.f21998h;
        String str10 = this.l;
        k.c(str10, "value");
        aVar2.f22003c = str10;
        a aVar3 = this.f21998h;
        aVar3.f22001a = this.j;
        aVar3.f22004d = this.m;
        aVar3.f22005e = this.n;
        aVar3.f22006f = this.o;
        aVar3.f22007g = this.p;
        aVar3.f22008h = this.s;
        View findViewById = findViewById(R.id.filter_toolbar);
        k.a((Object) findViewById, "findViewById(R.id.filter_toolbar)");
        this.f21993c = (Toolbar) findViewById;
        View findViewById2 = findViewById(R.id.img_close_filter);
        k.a((Object) findViewById2, "findViewById(R.id.img_close_filter)");
        this.f21995e = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.text_reset_all_filter);
        k.a((Object) findViewById3, "findViewById(R.id.text_reset_all_filter)");
        this.f21994d = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.filter_tab_layout);
        k.a((Object) findViewById4, "findViewById(R.id.filter_tab_layout)");
        this.f21992b = (TabLayout) findViewById4;
        View findViewById5 = findViewById(R.id.filter_view_pager);
        k.a((Object) findViewById5, "findViewById(R.id.filter_view_pager)");
        this.f21996f = (ViewPager) findViewById5;
        ImageView imageView = this.f21995e;
        if (imageView == null) {
            k.a("mClose");
        }
        View.OnClickListener onClickListener = this;
        imageView.setOnClickListener(onClickListener);
        TextView textView = this.f21994d;
        if (textView == null) {
            k.a("mClearAll");
        }
        textView.setOnClickListener(onClickListener);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        this.f21991a = new d(this, supportFragmentManager);
        d dVar = this.f21991a;
        if (dVar == null) {
            k.a("mBusFilterPagerAdapter");
        }
        Fragment cVar = new c();
        Bundle bundle2 = new Bundle();
        a aVar4 = this.f21998h;
        if (aVar4 != null) {
            cJRBusTicketFilters = aVar4.f22001a;
        } else {
            cJRBusTicketFilters = null;
        }
        bundle2.putSerializable("intent_extra_bus_search_filter_items", cJRBusTicketFilters);
        a aVar5 = this.f21998h;
        if (aVar5 == null) {
            k.a();
        }
        bundle2.putBoolean("intent_extra_bus_search_filter_on_no_bus", aVar5.f22004d);
        a aVar6 = this.f21998h;
        if (aVar6 != null) {
            arrayList = aVar6.f22007g;
        } else {
            arrayList = null;
        }
        bundle2.putSerializable("intent_extra_bus_search_filter_amenity_items", arrayList);
        bundle2.putBoolean("intent_extra_bus_search_filter_is_deals_available", this.q);
        bundle2.putString("intent_extra_bus_search_filter_is_popular_choice", this.r);
        a aVar7 = this.f21998h;
        if (aVar7 != null) {
            hashMap = aVar7.f22005e;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            a aVar8 = this.f21998h;
            if (aVar8 != null) {
                hashMap6 = aVar8.f22005e;
            } else {
                hashMap6 = null;
            }
            bundle2.putSerializable("amenity_info", hashMap6);
        }
        a aVar9 = this.f21998h;
        if (aVar9 != null) {
            hashMap2 = aVar9.f22006f;
        } else {
            hashMap2 = null;
        }
        if (hashMap2 != null) {
            a aVar10 = this.f21998h;
            if (aVar10 != null) {
                hashMap5 = aVar10.f22006f;
            } else {
                hashMap5 = null;
            }
            bundle2.putSerializable("operatortag_info", hashMap5);
        }
        a aVar11 = this.f21998h;
        if (aVar11 != null) {
            str = aVar11.f22002b;
        } else {
            str = null;
        }
        if (str != null) {
            a aVar12 = this.f21998h;
            if (aVar12 != null) {
                str6 = aVar12.f22003c;
            } else {
                str6 = null;
            }
            if (str6 != null) {
                a aVar13 = this.f21998h;
                if (aVar13 != null) {
                    str7 = aVar13.f22002b;
                } else {
                    str7 = null;
                }
                bundle2.putString("intent_extra_bus_start_city", str7);
                a aVar14 = this.f21998h;
                if (aVar14 != null) {
                    str8 = aVar14.f22003c;
                } else {
                    str8 = null;
                }
                bundle2.putString("intent_extra_bus_dest_city", str8);
            }
        }
        String string = getString(R.string.filters);
        k.a((Object) string, "getString(R.string.filters)");
        dVar.a(cVar, bundle2, string);
        d dVar2 = this.f21991a;
        if (dVar2 == null) {
            k.a("mBusFilterPagerAdapter");
        }
        Bundle c2 = c(1);
        String string2 = getString(R.string.boarding_points);
        k.a((Object) string2, "getString(R.string.boarding_points)");
        dVar2.a(new b(), c2, string2);
        d dVar3 = this.f21991a;
        if (dVar3 == null) {
            k.a("mBusFilterPagerAdapter");
        }
        Fragment dVar4 = new com.travel.bus.busticket.busfilter.b.d();
        Bundle bundle3 = new Bundle();
        a aVar15 = this.f21998h;
        if (aVar15 != null) {
            cJRBusTicketFilters2 = aVar15.f22001a;
        } else {
            cJRBusTicketFilters2 = null;
        }
        bundle3.putSerializable("intent_extra_bus_search_filter_items", cJRBusTicketFilters2);
        a aVar16 = this.f21998h;
        if (aVar16 != null) {
            str2 = aVar16.f22002b;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            a aVar17 = this.f21998h;
            if (aVar17 != null) {
                str3 = aVar17.f22003c;
            } else {
                str3 = null;
            }
            if (str3 != null) {
                a aVar18 = this.f21998h;
                if (aVar18 != null) {
                    str4 = aVar18.f22002b;
                } else {
                    str4 = null;
                }
                bundle3.putString("intent_extra_bus_start_city", str4);
                a aVar19 = this.f21998h;
                if (aVar19 != null) {
                    str5 = aVar19.f22003c;
                } else {
                    str5 = null;
                }
                bundle3.putString("intent_extra_bus_dest_city", str5);
            }
        }
        String string3 = getString(R.string.bus_operators);
        k.a((Object) string3, "getString(R.string.bus_operators)");
        dVar3.a(dVar4, bundle3, string3);
        d dVar5 = this.f21991a;
        if (dVar5 == null) {
            k.a("mBusFilterPagerAdapter");
        }
        Fragment aVar20 = new com.travel.bus.busticket.busfilter.b.a();
        Bundle bundle4 = new Bundle();
        a aVar21 = this.f21998h;
        if (aVar21 != null) {
            cJRBusTicketFilters3 = aVar21.f22001a;
        } else {
            cJRBusTicketFilters3 = null;
        }
        bundle4.putSerializable("intent_extra_bus_search_filter_items", cJRBusTicketFilters3);
        a aVar22 = this.f21998h;
        if (aVar22 != null) {
            arrayList2 = aVar22.f22007g;
        } else {
            arrayList2 = null;
        }
        bundle4.putSerializable("intent_extra_bus_search_filter_amenity_items", arrayList2);
        a aVar23 = this.f21998h;
        if (aVar23 != null) {
            hashMap3 = aVar23.f22005e;
        } else {
            hashMap3 = null;
        }
        if (hashMap3 != null) {
            a aVar24 = this.f21998h;
            if (aVar24 != null) {
                hashMap4 = aVar24.f22005e;
            } else {
                hashMap4 = null;
            }
            bundle4.putSerializable("amenity_info", hashMap4);
        }
        String string4 = getString(R.string.title_amenities);
        k.a((Object) string4, "getString(R.string.title_amenities)");
        dVar5.a(aVar20, bundle4, string4);
        d dVar6 = this.f21991a;
        if (dVar6 == null) {
            k.a("mBusFilterPagerAdapter");
        }
        Bundle c3 = c(2);
        String string5 = getString(R.string.dropping_points);
        k.a((Object) string5, "getString(R.string.dropping_points)");
        dVar6.a(new b(), c3, string5);
        ViewPager viewPager = this.f21996f;
        if (viewPager == null) {
            k.a("mViewPager");
        }
        d dVar7 = this.f21991a;
        if (dVar7 == null) {
            k.a("mBusFilterPagerAdapter");
        }
        viewPager.setAdapter(dVar7);
        ViewPager viewPager2 = this.f21996f;
        if (viewPager2 == null) {
            k.a("mViewPager");
        }
        viewPager2.setOffscreenPageLimit(4);
        TabLayout tabLayout = this.f21992b;
        if (tabLayout == null) {
            k.a("mTabLayout");
        }
        ViewPager viewPager3 = this.f21996f;
        if (viewPager3 == null) {
            k.a("mViewPager");
        }
        tabLayout.setupWithViewPager(viewPager3);
        TabLayout tabLayout2 = this.f21992b;
        if (tabLayout2 == null) {
            k.a("mTabLayout");
        }
        int tabCount = tabLayout2.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            TabLayout tabLayout3 = this.f21992b;
            if (tabLayout3 == null) {
                k.a("mTabLayout");
            }
            TabLayout.f a2 = tabLayout3.a(i2);
            if (a2 != null) {
                d dVar8 = this.f21991a;
                if (dVar8 == null) {
                    k.a("mBusFilterPagerAdapter");
                }
                View inflate = LayoutInflater.from(dVar8.f22050b).inflate(R.layout.bus_custom_filter_tab, (ViewGroup) null);
                k.a((Object) inflate, "LayoutInflater.from(mCon…_custom_filter_tab, null)");
                View findViewById6 = inflate.findViewById(R.id.tab_title);
                if (findViewById6 != null) {
                    ((TextView) findViewById6).setText(dVar8.f22049a.get(i2));
                    a2.a(inflate);
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
        TabLayout tabLayout4 = this.f21992b;
        if (tabLayout4 == null) {
            k.a("mTabLayout");
        }
        tabLayout4.setSelectedTabIndicatorColor(getResources().getColor(R.color.blue));
        TabLayout tabLayout5 = this.f21992b;
        if (tabLayout5 == null) {
            k.a("mTabLayout");
        }
        tabLayout5.setTabIndicatorFullWidth(false);
        b(0);
        ViewPager viewPager4 = this.f21996f;
        if (viewPager4 == null) {
            k.a("mViewPager");
        }
        viewPager4.addOnPageChangeListener(new a(this));
    }

    public static final class a implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BusFilterSortActivity f22000a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        a(BusFilterSortActivity busFilterSortActivity) {
            this.f22000a = busFilterSortActivity;
        }

        public final void onPageSelected(int i2) {
            BusFilterSortActivity.a(this.f22000a);
            this.f22000a.b(i2);
            this.f22000a.f21999i = i2;
            d dVar = this.f22000a.f21991a;
            if (dVar == null) {
                k.a("mBusFilterPagerAdapter");
            }
            Fragment item = dVar.getItem(this.f22000a.f21999i);
            if (item instanceof c) {
                this.f22000a.a(((c) item).e(), this.f22000a.f21999i);
            } else if (item instanceof b) {
                BusFilterSortActivity busFilterSortActivity = this.f22000a;
                b bVar = (b) item;
                com.travel.bus.busticket.busfilter.a.b bVar2 = bVar.f22064a;
                if (bVar2 == null) {
                    k.a("mBusFilterBPDPAdapter");
                }
                busFilterSortActivity.a(b.a((ArrayList<CJRLocation>) new ArrayList(bVar2.f22022a)), this.f22000a.f21999i);
                bVar.b();
            } else if (item instanceof com.travel.bus.busticket.busfilter.b.a) {
                BusFilterSortActivity busFilterSortActivity2 = this.f22000a;
                com.travel.bus.busticket.busfilter.b.a aVar = (com.travel.bus.busticket.busfilter.b.a) item;
                com.travel.bus.busticket.busfilter.a.a aVar2 = aVar.f22053a;
                if (aVar2 == null) {
                    k.a("mBusFilterAmenitiesAdapter");
                }
                busFilterSortActivity2.a(com.travel.bus.busticket.busfilter.b.a.a((ArrayList<CJRBusSearchAmenitiesInfo>) new ArrayList(aVar2.f22009a)), this.f22000a.f21999i);
                aVar.a();
            } else if (item instanceof com.travel.bus.busticket.busfilter.b.d) {
                BusFilterSortActivity busFilterSortActivity3 = this.f22000a;
                com.travel.bus.busticket.busfilter.b.d dVar2 = (com.travel.bus.busticket.busfilter.b.d) item;
                com.travel.bus.busticket.busfilter.a.c cVar = dVar2.f22095a;
                if (cVar == null) {
                    k.a("mBusFilterOperatorAdapter");
                }
                busFilterSortActivity3.a(com.travel.bus.busticket.busfilter.b.d.a((ArrayList<CJRTravelName>) new ArrayList(cVar.f22036a)), this.f22000a.f21999i);
                dVar2.a();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r7) {
        /*
            r6 = this;
            com.google.android.material.tabs.TabLayout r0 = r6.f21992b
            java.lang.String r1 = "mTabLayout"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            int r0 = r0.getTabCount()
            r2 = 0
        L_0x000e:
            if (r2 >= r0) goto L_0x0059
            com.google.android.material.tabs.TabLayout r3 = r6.f21992b
            if (r3 != 0) goto L_0x0017
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0017:
            com.google.android.material.tabs.TabLayout$f r3 = r3.a((int) r2)
            r4 = 0
            if (r3 == 0) goto L_0x0023
            android.view.View r3 = r3.a()
            goto L_0x0024
        L_0x0023:
            r3 = r4
        L_0x0024:
            if (r3 == 0) goto L_0x002f
            int r4 = com.travel.bus.R.id.tab_title
            android.view.View r3 = r3.findViewById(r4)
            r4 = r3
            android.widget.TextView r4 = (android.widget.TextView) r4
        L_0x002f:
            if (r4 == 0) goto L_0x0051
            if (r2 != r7) goto L_0x0041
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.color.blue
            int r3 = r3.getColor(r5)
            r4.setTextColor(r3)
            goto L_0x004e
        L_0x0041:
            android.content.res.Resources r3 = r6.getResources()
            int r5 = com.travel.bus.R.color.color_323232
            int r3 = r3.getColor(r5)
            r4.setTextColor(r3)
        L_0x004e:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0051:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
            r7.<init>(r0)
            throw r7
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.BusFilterSortActivity.b(int):void");
    }

    private final Bundle c(int i2) {
        CJRBusTicketFilters cJRBusTicketFilters;
        String str;
        Bundle bundle = new Bundle();
        bundle.putInt("intent_extra_location_type", i2);
        a aVar = this.f21998h;
        String str2 = null;
        if (aVar != null) {
            cJRBusTicketFilters = aVar.f22001a;
        } else {
            cJRBusTicketFilters = null;
        }
        bundle.putSerializable("intent_extra_bus_search_filter_items", cJRBusTicketFilters);
        a aVar2 = this.f21998h;
        bundle.putSerializable("intent_extra_flag_bp_dp_required", aVar2 != null ? Boolean.valueOf(aVar2.f22008h) : null);
        a aVar3 = this.f21998h;
        if (aVar3 != null) {
            str = aVar3.f22002b;
        } else {
            str = null;
        }
        bundle.putString("intent_extra_bus_start_city", str);
        a aVar4 = this.f21998h;
        if (aVar4 != null) {
            str2 = aVar4.f22003c;
        }
        bundle.putString("intent_extra_bus_dest_city", str2);
        return bundle;
    }

    public final void a(int i2) {
        ViewPager viewPager = this.f21996f;
        if (viewPager == null) {
            k.a("mViewPager");
        }
        viewPager.setCurrentItem(i2);
    }

    public final void a(boolean z, int i2) {
        if (this.f21999i == i2) {
            TextView textView = this.f21994d;
            if (textView == null) {
                k.a("mClearAll");
            }
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public final void onClick(View view) {
        ArrayList<CJRBusTicketFilterItem> arrayList = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.text_reset_all_filter;
        if (valueOf != null && valueOf.intValue() == i2) {
            d dVar = this.f21991a;
            if (dVar == null) {
                k.a("mBusFilterPagerAdapter");
            }
            Fragment item = dVar.getItem(this.f21999i);
            if (item instanceof c) {
                c cVar = (c) item;
                if (cVar.f22077c != null) {
                    cVar.a();
                    cVar.f22075a = true;
                    CJRBusTicketFilters cJRBusTicketFilters = cVar.f22077c;
                    if (cJRBusTicketFilters != null) {
                        cJRBusTicketFilters.setmNightBusesFlag(false);
                    }
                    cVar.a("key_bus_search_sort_by_none", 0);
                    CJRBusTicketFilters cJRBusTicketFilters2 = cVar.f22077c;
                    if (cJRBusTicketFilters2 != null) {
                        arrayList = cJRBusTicketFilters2.getBusTicketFilterItems();
                    }
                    if (arrayList != null) {
                        CJRBusTicketFilters cJRBusTicketFilters3 = cVar.f22077c;
                        if (cJRBusTicketFilters3 == null) {
                            k.a();
                        }
                        if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                            CJRBusTicketFilters cJRBusTicketFilters4 = cVar.f22077c;
                            if (cJRBusTicketFilters4 == null) {
                                k.a();
                            }
                            cJRBusTicketFilters4.getBusTicketFilterItems().clear();
                            if (cVar.f22076b != null) {
                                cVar.f22076b.clear();
                            }
                        }
                    }
                }
                if (cVar.f22078d != null) {
                    cVar.f22078d.clear();
                }
                cVar.f22079e = false;
                cVar.b();
                cVar.c();
                cVar.d();
                d dVar2 = this.f21991a;
                if (dVar2 == null) {
                    k.a("mBusFilterPagerAdapter");
                }
                Fragment item2 = dVar2.getItem(1);
                if (item2 instanceof b) {
                    ((b) item2).a();
                }
                d dVar3 = this.f21991a;
                if (dVar3 == null) {
                    k.a("mBusFilterPagerAdapter");
                }
                Fragment item3 = dVar3.getItem(2);
                if (item3 instanceof com.travel.bus.busticket.busfilter.b.d) {
                    ((com.travel.bus.busticket.busfilter.b.d) item3).b();
                }
                d dVar4 = this.f21991a;
                if (dVar4 == null) {
                    k.a("mBusFilterPagerAdapter");
                }
                Fragment item4 = dVar4.getItem(3);
                if (item4 instanceof com.travel.bus.busticket.busfilter.b.a) {
                    ((com.travel.bus.busticket.busfilter.b.a) item4).b();
                }
                d dVar5 = this.f21991a;
                if (dVar5 == null) {
                    k.a("mBusFilterPagerAdapter");
                }
                Fragment item5 = dVar5.getItem(4);
                if (item5 instanceof b) {
                    ((b) item5).c();
                }
            } else {
                boolean z = item instanceof b;
                if (z && this.f21999i == 1) {
                    ((b) item).a();
                } else if (item instanceof com.travel.bus.busticket.busfilter.b.d) {
                    ((com.travel.bus.busticket.busfilter.b.d) item).b();
                } else if (item instanceof com.travel.bus.busticket.busfilter.b.a) {
                    ((com.travel.bus.busticket.busfilter.b.a) item).b();
                } else if (z && this.f21999i == 4) {
                    ((b) item).c();
                }
            }
            Map hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(this.k);
            sb.append("/");
            String str = this.l;
            if (str != null) {
                sb.append(str);
                hashMap.put("event_label2", sb.toString());
                Context context = this;
                if (!TextUtils.isEmpty(com.paytm.utility.b.n(context))) {
                    String n2 = com.paytm.utility.b.n(context);
                    k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                    hashMap.put("userid", n2);
                }
                com.travel.bus.a.a();
                com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "reset_all_clicked", hashMap);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
        int i3 = R.id.img_close_filter;
        if (valueOf != null && valueOf.intValue() == i3) {
            finish();
        }
    }

    public final void attachBaseContext(Context context) {
        com.google.android.play.core.splitcompat.a.a(context);
        super.attachBaseContext(context);
    }

    public static final /* synthetic */ void a(BusFilterSortActivity busFilterSortActivity) {
        try {
            Object systemService = busFilterSortActivity.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                View currentFocus = busFilterSortActivity.getCurrentFocus();
                if (currentFocus == null) {
                    currentFocus = new View(busFilterSortActivity);
                }
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}

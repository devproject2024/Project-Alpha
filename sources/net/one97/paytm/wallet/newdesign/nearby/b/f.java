package net.one97.paytm.wallet.newdesign.nearby.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.g;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.f;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;
import net.one97.paytm.wallet.newdesign.nearby.a.a;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.CityStorefrontModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyCategorySubCategoryModal;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.NearbyOffersBannerModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.c;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public class f extends b implements AdapterView.OnItemClickListener, b, a.C1437a {

    /* renamed from: a  reason: collision with root package name */
    public NearbyOffersBannerModal f71098a;

    /* renamed from: b  reason: collision with root package name */
    public CityStorefrontModal f71099b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f71100c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71101d;

    /* renamed from: e  reason: collision with root package name */
    Map<Integer, Boolean> f71102e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f71103f;

    /* renamed from: g  reason: collision with root package name */
    private TabLayout f71104g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f71105h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71106i;
    private Context j;
    private NearbyCategorySubCategoryModal k;
    private net.one97.paytm.wallet.newdesign.nearby.a.b l;
    private ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> m;
    private boolean n;
    private ViewPager o;
    private CirclePageIndicator p;

    public interface a {
        void a(int i2, ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("isForFastTag")) {
            this.n = getArguments().getBoolean("isForFastTag", false);
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
        }
        if (getActivity() != null && (getActivity() instanceof NearByMainActivity)) {
            NearByMainActivity nearByMainActivity = (NearByMainActivity) getActivity();
            if (nearByMainActivity.f70991b != null) {
                nearByMainActivity.f70991b.clear();
            }
        }
        c.a aVar = c.f71128a;
        c.a.a();
        this.f71101d = c.b("do_show_nearby_banner");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.nb_fragment_nearby_withoutfilter, (ViewGroup) null);
        this.f71106i = (TextView) inflate.findViewById(R.id.tv_more_less_categories);
        this.f71105h = (RecyclerView) inflate.findViewById(R.id.rv_category_list);
        this.f71105h.setLayoutManager(new GridLayoutManager(this.j, 4));
        this.l = new net.one97.paytm.wallet.newdesign.nearby.a.b(this.j, this.m, this);
        this.f71105h.setAdapter(this.l);
        ((ImageView) inflate.findViewById(R.id.iv_back_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.b(view);
            }
        });
        this.f71103f = (ViewPager) inflate.findViewById(R.id.vp_nearby_pager);
        this.f71104g = (TabLayout) inflate.findViewById(R.id.tl_nearby_tabs);
        ((TextView) inflate.findViewById(R.id.tv_toolbar_title)).setText(getString(this.n ? R.string.nearby_heading_name_fastag : R.string.nearby_heading_name));
        this.f71100c = (FrameLayout) inflate.findViewById(R.id.deals_banner_nearby_view_pager_layout);
        this.o = (ViewPager) inflate.findViewById(R.id.deals_banner_nearby_view_pager_event_image);
        this.p = (CirclePageIndicator) inflate.findViewById(R.id.deals_banner_nearby_view_page_indicator);
        b();
        this.f71106i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.a(view);
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String charSequence = this.f71106i.getText().toString();
        if (charSequence.equalsIgnoreCase(getString(R.string.nearby_more_category_text))) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("new_wallet_screen_type", "nearby");
                d.a aVar = d.f71130b;
                d.a.b().a("new_wallet_nearby_more_clicked", (HashMap<String, Object>) hashMap, this.j);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            this.f71106i.setText(getString(R.string.nearby_less_category_text));
            this.f71106i.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_collapse, 0);
            this.l.a(true, false);
        } else if (charSequence.equalsIgnoreCase(getString(R.string.nearby_less_category_text))) {
            this.f71106i.setText(getString(R.string.nearby_more_category_text));
            this.f71106i.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand, 0);
            this.l.a(false, false);
        }
    }

    private static ArrayList<String> a(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            return new ArrayList<>(Arrays.asList(strArr));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return arrayList;
        }
    }

    public final void a(final ArrayList<NearbyOffersBannerModal.Item> arrayList) {
        this.o.setAdapter(new net.one97.paytm.wallet.newdesign.nearby.a.a(getContext(), arrayList, this));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.f71102e.put(Integer.valueOf(i2), Boolean.FALSE);
        }
        if (arrayList.size() > 0 && !this.f71102e.get(0).booleanValue()) {
            d.a aVar = d.f71130b;
            d.a.b().b(arrayList.get(0), getActivity(), 0, "/nearby-C1");
            this.f71102e.put(0, Boolean.TRUE);
        }
        this.o.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                NearbyOffersBannerModal.Item item = (NearbyOffersBannerModal.Item) arrayList.get(i2);
                if (!f.this.f71102e.get(Integer.valueOf(i2)).booleanValue()) {
                    d.a aVar = d.f71130b;
                    d.a.b().b(item, f.this.getActivity(), i2, "/nearby-C1");
                    f.this.f71102e.put(Integer.valueOf(i2), Boolean.TRUE);
                }
            }
        });
        this.p.setViewPager(this.o);
    }

    private void b() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.f71101d) {
                String b2 = net.one97.paytm.wallet.newdesign.nearby.c.a.a(getContext().getApplicationContext(), f.a.PREF_NEARBY_CITY_STORE_FRONT).b("naerby_city_store_front", "", false);
                if (b2.equals("")) {
                    b2 = null;
                }
                if (!TextUtils.isEmpty(b2)) {
                    this.f71099b = (CityStorefrontModal) new g().a().a(b2, CityStorefrontModal.class);
                }
            }
            a();
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        String urlType;
        try {
            if (iJRDataModel instanceof NearbyOffersBannerModal.Item) {
                NearbyOffersBannerModal.Item item = (NearbyOffersBannerModal.Item) iJRDataModel;
                CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                cJRHomePageItem.setUrl(item.getUrl());
                StringBuilder sb = new StringBuilder();
                sb.append(item.getId());
                cJRHomePageItem.setItemID(sb.toString());
                cJRHomePageItem.setName(item.getName());
                if (item != null) {
                    String url = item.getUrl();
                    if (!TextUtils.isEmpty(url) && url.startsWith("paytmmp://")) {
                        a(item.getUrlType());
                    } else if (Patterns.WEB_URL.matcher(url).matches() && (urlType = item.getUrlType()) != null && !TextUtils.isEmpty(urlType) && url != null && URLUtil.isValidUrl(url)) {
                        if (urlType.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED)) {
                            a(item.getUrlType());
                        } else if ((urlType.equalsIgnoreCase(CLPConstants.DEFAULT_GRID_VIEW_TYPE) || urlType.equalsIgnoreCase("product")) && url != null && URLUtil.isValidUrl(url)) {
                            a(item.getUrlType());
                        }
                    }
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(String str) {
        if (getActivity() != null && !isDetached() && !TextUtils.isEmpty(str)) {
            str.equalsIgnoreCase("nolink");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (getActivity() != null && (getActivity() instanceof a)) {
            ((a) getActivity()).a(i2, this.k.getResponse().getCategoryDetails());
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (iJRPaytmDataModel instanceof NearbyOffersBannerModal) {
                this.f71098a = (NearbyOffersBannerModal) iJRPaytmDataModel;
                if (this.f71098a.getHomepageLayout() != null && this.f71098a.getHomepageLayout().size() > 0) {
                    a(this.f71098a.getHomepageLayout().get(0).getItems());
                    this.f71100c.setVisibility(0);
                }
            } else if (iJRPaytmDataModel instanceof CityStorefrontModal) {
                net.one97.paytm.wallet.newdesign.nearby.c.a.a(getContext().getApplicationContext(), f.a.PREF_NEARBY_CITY_STORE_FRONT).a("naerby_city_store_front", new g().a().b(iJRPaytmDataModel), false);
                b();
            } else if (iJRPaytmDataModel instanceof NearbyCategorySubCategoryModal) {
                NearbyCategorySubCategoryModal nearbyCategorySubCategoryModal = (NearbyCategorySubCategoryModal) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(nearbyCategorySubCategoryModal.getStatusCode()) && nearbyCategorySubCategoryModal.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                    this.k = nearbyCategorySubCategoryModal;
                    this.m.clear();
                    NearbyCategorySubCategoryModal nearbyCategorySubCategoryModal2 = this.k;
                    if (!(nearbyCategorySubCategoryModal2 == null || nearbyCategorySubCategoryModal2.getResponse() == null)) {
                        this.m = this.k.getResponse().getCategoryDetails();
                    }
                    if (this.m.size() > 8) {
                        this.f71106i.setVisibility(0);
                    } else {
                        this.f71106i.setVisibility(8);
                    }
                    this.f71105h.setVisibility(0);
                    net.one97.paytm.wallet.newdesign.nearby.a.b bVar = this.l;
                    ArrayList<NearbyCategorySubCategoryModal.CategoryDetail> arrayList = this.m;
                    bVar.f71007a.clear();
                    bVar.f71007a.addAll(arrayList);
                    this.l.a(false, true);
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (getActivity() != null) {
            getActivity().isFinishing();
        }
    }

    private void a() {
        int i2;
        Resources resources;
        String[] strArr = new String[1];
        if (this.n) {
            resources = getResources();
            i2 = R.string.nearby_buy_fastag_from_seller;
        } else {
            resources = getResources();
            i2 = R.string.verify_adhaar_at_below_points;
        }
        strArr[0] = resources.getString(i2);
        ArrayList<String> a2 = a(strArr);
        this.f71103f.setAdapter(new net.one97.paytm.wallet.newdesign.nearby.a.f(getContext(), getChildFragmentManager(), a2, this.n));
        this.f71103f.setOffscreenPageLimit(a2.size());
        this.f71104g.setupWithViewPager(this.f71103f);
        for (int i3 = 0; i3 < this.f71104g.getTabCount(); i3++) {
            TabLayout.f a3 = this.f71104g.a(i3);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.nb_item_tab_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_tab_title);
            textView.setText(a2.get(i3));
            if (i3 == 0) {
                textView.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_222222));
                textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            }
            a3.a(inflate);
        }
        this.f71104g.setOnTabSelectedListener((TabLayout.c) new TabLayout.c() {
            public final void onTabReselected(TabLayout.f fVar) {
            }

            public final void onTabSelected(TabLayout.f fVar) {
                TextView textView = (TextView) fVar.f36766f.findViewById(R.id.tv_tab_title);
                textView.setTextColor(androidx.core.content.b.c(f.this.getActivity(), R.color.color_222222));
                textView.setTypeface(Typeface.create("sans-serif-medium", 0));
                f.a(f.this, textView.getText().toString());
                if (f.this.f71103f != null) {
                    f.this.f71103f.setCurrentItem(fVar.f36765e);
                }
            }

            public final void onTabUnselected(TabLayout.f fVar) {
                View view;
                if (fVar != null && (view = fVar.f36766f) != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
                    textView.setTextColor(androidx.core.content.b.c(f.this.getActivity(), R.color.color_4a4a4a));
                    textView.setTypeface(Typeface.create("sans-serif", 0));
                }
            }
        });
    }

    static /* synthetic */ void a(f fVar, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "nearby");
            hashMap.put("new_wallet_nearby_tab_name", str);
            d.a aVar = d.f71130b;
            d.a.b().a("new_wallet_nearby_tab_clicked", (HashMap<String, Object>) hashMap, fVar.j);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}

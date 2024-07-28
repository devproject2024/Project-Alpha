package net.one97.paytm.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.i.e;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.a.a;
import net.one97.paytm.landingpage.fragment.FJRUpdatesFragment;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.k;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.manager.CJRCustomObservableRecyclerView;
import net.one97.paytm.utils.t;

public class e extends b implements SwipeRefreshLayout.b, a.C0941a {

    /* renamed from: g  reason: collision with root package name */
    private static final String f50573g = e.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private static final Interpolator f50574h = new androidx.interpolator.a.a.b();
    private boolean A = false;
    private String B;
    private String C;
    private String D;
    private String E;
    private int F = 0;
    private float G = 0.0f;
    private a H;
    private boolean I = false;
    private ImageView J;
    private String K;
    private final String L = "Mall";
    private String M = "";
    private String N = "";
    private String O = "";
    private View P;
    /* access modifiers changed from: private */
    public RelativeLayout Q;
    private boolean R;
    private boolean S;
    private final int T = 1;
    private final int U = 100;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    public CJRHomePageV2 f50575a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.landingpage.a.a f50576b;

    /* renamed from: c  reason: collision with root package name */
    public String f50577c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f50578d;

    /* renamed from: e  reason: collision with root package name */
    public b f50579e = b.UNINITIALIZED;

    /* renamed from: f  reason: collision with root package name */
    public Handler f50580f = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (e.this.isAdded() && !e.this.isDetached() && e.this.f50579e != b.IS_PROCESSING) {
                b unused = e.this.f50579e = b.IS_PROCESSING;
                if (message.what == 1) {
                    e.b(e.this);
                }
                b unused2 = e.this.f50579e = b.IDLE;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<View> f50581i;
    private String j;
    private CJRItem k;
    private ViewPager l;
    private View m;
    /* access modifiers changed from: private */
    public CJRCustomObservableRecyclerView n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    /* access modifiers changed from: private */
    public String r;
    private ViewGroup s;
    private HashMap<String, Object> t = new HashMap<>();
    private CJRItem u;
    private String v;
    private boolean w = false;
    private boolean x = false;
    private boolean y = true;
    private boolean z = false;

    public interface a {
    }

    public enum b {
        UNINITIALIZED,
        IDLE,
        IS_PROCESSING,
        TERMINATED
    }

    public void onEditViewClick(View view) {
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
    }

    public void onServerDataLoaded() {
    }

    public e() {
    }

    public e(WeakReference<View> weakReference) {
        this.f50581i = weakReference;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    public void loadData() {
        if (!TextUtils.isEmpty(this.M) && this.M.equalsIgnoreCase(FJRUpdatesFragment.class.getSimpleName())) {
            this.o = false;
            this.p = false;
        }
        if (getActivity() != null && !isDetached() && !this.o && !this.p) {
            this.p = true;
            com.paytm.utility.a.c();
            if (!TextUtils.isEmpty(this.f50577c)) {
                b();
            } else {
                a();
            }
        }
    }

    public final void a() {
        if (this.k != null) {
            String e2 = e();
            if (e2 != null) {
                String d2 = d();
                HashMap<String, String> i2 = com.paytm.utility.a.i();
                i2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getActivity()));
                if (com.paytm.utility.a.m(getActivity())) {
                    a(e2, d2, (Map<String, String>) i2);
                } else if (!this.z) {
                    this.p = false;
                    this.o = false;
                    ViewGroup viewGroup = this.s;
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                    }
                    f();
                }
            }
        } else {
            f();
        }
    }

    public final void b() {
        String i2 = i();
        if (i2 != null && !TextUtils.isEmpty(this.f50577c)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getActivity()));
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.a.m(getActivity())) {
                a(i2, (String) null, (Map<String, String>) hashMap);
            } else if (!this.z) {
                this.p = false;
                this.o = false;
                ViewGroup viewGroup = this.s;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                f();
            }
        }
    }

    private void a(String str, String str2, Map<String, String> map) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = CJRJarvisApplication.getAppContext();
        bVar.f42880d = str;
        bVar.o = e.class.getName();
        bVar.n = a.b.SILENT;
        bVar.f42885i = new CJRHomePageV2();
        bVar.f42878b = a.c.HOME;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42884h = str2;
        bVar.f42882f = map;
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (e.this.isAdded() && !e.this.isDetached() && (iJRPaytmDataModel instanceof CJRHomePageV2)) {
                    e.this.c();
                    CJRHomePageV2 unused = e.this.f50575a = (CJRHomePageV2) iJRPaytmDataModel;
                    com.paytm.utility.d.a.a(new kotlin.g.a.a<x>(new f().a((Object) iJRPaytmDataModel)) {
                        /* access modifiers changed from: private */
                        public /* synthetic */ void b(SanitizedResponseModel sanitizedResponseModel) {
                            if (e.this.isAdded() && !e.this.isDetached()) {
                                e eVar = e.this;
                                net.one97.paytm.landingpage.a.a unused = eVar.f50576b = new net.one97.paytm.landingpage.a.a(eVar.getActivity(), sanitizedResponseModel.getRvWidgets(), e.this.getChildFragmentManager(), e.this.f50581i, e.this);
                                b unused2 = e.this.f50579e = b.IDLE;
                                if (e.this.V) {
                                    e.k(e.this);
                                }
                                e.this.n.setAdapter(e.this.f50576b);
                            }
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
                            if (e.this.isAdded() && !e.this.isDetached()) {
                                net.one97.paytm.landingpage.a.a i2 = e.this.f50576b;
                                List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
                                int size = i2.f52644a.size();
                                if (rvWidgets != null) {
                                    for (com.paytmmall.clpartifact.modal.clpCommon.View next : rvWidgets) {
                                        boolean z = false;
                                        if (i2.f52644a != null) {
                                            Iterator<com.paytmmall.clpartifact.modal.clpCommon.View> it2 = i2.f52644a.iterator();
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    if (next.getId().longValue() == it2.next().getId().longValue()) {
                                                        z = true;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                            if (!z) {
                                                i2.f52644a.add(next);
                                            }
                                        }
                                    }
                                }
                                i2.a();
                                i2.notifyItemRangeInserted(size, i2.f52644a.size() - size);
                            }
                        }

                        public final /* synthetic */ Object invoke() {
                            SanitizedResponseModel sanitizedResponse;
                            if (!TextUtils.isEmpty(r2) && e.this.isAdded() && !e.this.isDetached() && (sanitizedResponse = SFInterface.INSTANCE.getSanitizedResponse((HomeResponse) new com.google.gson.f().a(r2, HomeResponse.class), false)) != null) {
                                if (!(sanitizedResponse == null || sanitizedResponse.getRvWidgets() == null || sanitizedResponse.getRvWidgets().size() <= 0)) {
                                    sanitizedResponse.getRvWidgets();
                                    for (com.paytmmall.clpartifact.modal.clpCommon.View next : sanitizedResponse.getRvWidgets()) {
                                        if (TextUtils.isEmpty(e.this.r)) {
                                            String unused = e.this.r = next.getGaKey();
                                        }
                                        if (next.getType().equalsIgnoreCase(ViewHolderFactory.TYPE_H1_BANNER)) {
                                            next.setAuto_scroll("true");
                                            next.setClassName(ViewHolderFactory.CLASS_HOME);
                                            for (Item item : next.getItems()) {
                                                item.setmClassName(ViewHolderFactory.CLASS_HOME);
                                            }
                                        }
                                    }
                                }
                                if (e.this.n != null) {
                                    if (e.this.f50576b == null) {
                                        e.this.n.post(new Runnable(sanitizedResponse) {
                                            private final /* synthetic */ SanitizedResponseModel f$1;

                                            {
                                                this.f$1 = r2;
                                            }

                                            public final void run() {
                                                e.AnonymousClass5.this.b(this.f$1);
                                            }
                                        });
                                    } else {
                                        e.this.n.post(new Runnable(sanitizedResponse) {
                                            private final /* synthetic */ SanitizedResponseModel f$1;

                                            {
                                                this.f$1 = r2;
                                            }

                                            public final void run() {
                                                e.AnonymousClass5.this.a(this.f$1);
                                            }
                                        });
                                    }
                                }
                            }
                            return null;
                        }
                    });
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (e.this.getActivity() != null) {
                    if (e.this.f50575a == null) {
                        e.this.Q.setVisibility(8);
                    }
                    e eVar = e.this;
                    e.a(eVar, eVar.getActivity().getResources().getString(R.string.unexpected_error_title), e.this.getActivity().getResources().getString(R.string.unexpected_error_message));
                    e.this.c();
                }
            }
        };
        bVar.l().a();
    }

    public final void c() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private String d() {
        this.j = this.k.getName();
        String str = "Mall";
        if (str.equalsIgnoreCase(this.j)) {
            str = "paytm-home";
        }
        return l.a(getContext(), str, this.k.getName());
    }

    private String e() {
        String url = this.k.getURL();
        if (!URLUtil.isValidUrl(url)) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return null;
        }
        ag.a(getActivity().getApplicationContext()).a("home_url", url, true);
        if (url != null) {
            url = url.trim();
        }
        try {
            Uri.Builder buildUpon = Uri.parse(url).buildUpon();
            buildUpon.appendQueryParameter("page_count", "1");
            buildUpon.appendQueryParameter("views_per_page", String.valueOf(j()));
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return url;
        }
    }

    private void f() {
        if (this.homepage_loading != null && this.homepage_loading.getVisibility() == 0) {
            this.homepage_loading.setVisibility(8);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onDestroyView() {
        this.m = null;
        this.J = null;
        this.s = null;
        this.mProgessBarItemLoading = null;
        try {
            if (this.f50576b != null) {
                q.d("calling disable impressio events");
                net.one97.paytm.landingpage.a.a aVar = this.f50576b;
                if (aVar.f52647d != null) {
                    aVar.f52647d.clear();
                    aVar.f52647d = null;
                }
                if (aVar.f52648e != null) {
                    aVar.f52648e.clear();
                    aVar.f52648e = null;
                }
                if (aVar.f52649f != null) {
                    aVar.f52649f.clear();
                    aVar.f52649f = null;
                }
                if (aVar.f52650g != null) {
                    aVar.f52650g.clear();
                    aVar.f52650g = null;
                }
            }
            if (this.f50575a != null) {
                this.f50575a.getmPage().clear();
                ArrayList<CJRHomePageLayoutV2> mobileLayoutList = this.f50575a.getMobileLayoutList();
                Iterator<CJRHomePageLayoutV2> it2 = mobileLayoutList.iterator();
                while (it2.hasNext()) {
                    it2.next().getHomePageItemList().clear();
                }
                mobileLayoutList.clear();
            }
            if (this.l != null) {
                this.l.removeAllViews();
                this.l = null;
            }
            this.f50575a = null;
            this.homepage_loading = null;
            if (this.f50576b != null) {
                this.f50576b = null;
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        KycStatusInstanceCleanup();
        super.onDestroyView();
    }

    public void onRefresh() {
        this.o = false;
        this.p = false;
        this.f50576b = null;
        loadData();
    }

    public void updateData(CJRItem cJRItem) {
        if (this.q) {
            this.o = false;
            this.k = cJRItem;
            loadData();
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putSerializable("bundle_extra_category_item", cJRItem);
                arguments.putBoolean("EXTRA_IS_CATALOG_UPDATED", true);
            }
        }
    }

    public final void a(CJRHomePageItem cJRHomePageItem, int i2, String str, String str2) {
        String a2 = l.a((CJRItem) cJRHomePageItem);
        if (!TextUtils.isEmpty(a2)) {
            cJRHomePageItem.setCategoryId(a2);
        }
        if (cJRHomePageItem != null && TextUtils.isEmpty(cJRHomePageItem.getParentItem())) {
            cJRHomePageItem.setParentItem(str2);
        }
        if (!(getActivity() == null || getActivity().getApplicationContext() == null)) {
            if (str != null) {
                cJRHomePageItem.setmContainerInstanceID(str);
            } else {
                cJRHomePageItem.setmContainerInstanceID("");
            }
            Context applicationContext = getActivity().getApplicationContext();
            net.one97.paytm.j.a.e(cJRHomePageItem, applicationContext, i2, this.r + "-");
        }
        if (cJRHomePageItem.getLayoutType().equals(LayoutType.LAYOUT_THIN_BANNER.getName())) {
            k.a(getContext(), "/travel-offers", "travel_offers", "thin_banner_clicked", cJRHomePageItem.getItemID());
        } else if (cJRHomePageItem.getLayoutType().equals(LayoutType.LAYOUT_BANNER_2XN.getName())) {
            Context context = getContext();
            String itemID = cJRHomePageItem.getItemID();
            StringBuilder sb = new StringBuilder();
            sb.append(i2 + 1);
            k.a(context, "/travel-offers", "travel_offers", "grid_clicked", itemID, sb.toString());
        } else if (cJRHomePageItem.getLayoutType().equals(LayoutType.LAYOUT_H1_BANNER.getName())) {
            Context context2 = getContext();
            String itemID2 = cJRHomePageItem.getItemID();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2 + 1);
            k.a(context2, "/travel-offers", "travel_offers", "carousel_clicked", itemID2, sb2.toString());
        }
        if (cJRHomePageItem.getURLType().equalsIgnoreCase("native")) {
            loadPage(cJRHomePageItem.getURLType(), cJRHomePageItem, this.j, 0, (ArrayList<? extends CJRItem>) null, false, CLPConstants.GA_CHANNEL_NAME);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    public void setUserVisibleHint(boolean z2) {
        String name;
        super.setUserVisibleHint(z2);
        if (z2) {
            if (this.q) {
                this.w = true;
                try {
                    String R2 = com.paytm.utility.b.R(getActivity().getApplicationContext());
                    if (R2 == null) {
                        R2 = "";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("gdr_referrer", R2);
                    if (!(this.k == null || (name = this.k.getName()) == null)) {
                        hashMap.put("CATEGORY_NAME", name);
                    }
                    net.one97.paytm.j.a.b("screen_loaded_category", (Map<String, Object>) hashMap, (Context) getActivity());
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            if (isResumed() && this.W) {
                g();
            }
        }
    }

    private void g() {
        if (this.q || this.x) {
            loadData();
        } else if (h()) {
            this.o = false;
            this.p = false;
            loadData();
        }
    }

    public void onResume() {
        if (this.mProgessBarItemLoading != null) {
            this.mProgessBarItemLoading.setVisibility(8);
        }
        super.onResume();
        if (getUserVisibleHint() && this.W) {
            g();
        }
    }

    private boolean h() {
        String b2 = t.b((Context) getActivity());
        boolean z2 = true;
        if ((!TextUtils.isEmpty(this.v) || TextUtils.isEmpty(b2)) && ((TextUtils.isEmpty(this.v) || !TextUtils.isEmpty(b2)) && (TextUtils.isEmpty(this.v) || TextUtils.isEmpty(b2) || this.v.equalsIgnoreCase(b2)))) {
            z2 = false;
        }
        this.v = b2;
        return z2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!this.W) {
            g();
        }
        k.a(getContext(), "/travel-offers", "travel_offers", "on_screen_load", (String) null);
    }

    public void onActivityResult(int i2, Intent intent) {
        super.onActivityResult(i2, intent);
    }

    public void setiReffData(CJRHomePageItem cJRHomePageItem) {
        super.setiReffData(cJRHomePageItem);
    }

    public void setOperatorClickable(boolean z2) {
        super.setOperatorClickable(z2);
    }

    public void clearFields() {
        super.clearFields();
    }

    public void onRefreshFragment() {
        loadData();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.H = (a) activity;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.H = null;
    }

    private String i() {
        String str;
        if (!TextUtils.isEmpty(this.f50577c)) {
            c.a();
            str = c.a(this.f50577c, (String) null);
        } else {
            str = "";
        }
        if (str == null || TextUtils.isEmpty(str)) {
            str = this.O;
        }
        if (str != null) {
            str = str.trim();
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("page_count", "1");
            buildUpon.appendQueryParameter("views_per_page", String.valueOf(j()));
            return buildUpon.build().toString();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private int j() throws IllegalStateException {
        if (k()) {
            if (this.f50578d == 0) {
                this.f50578d = 5;
            }
            return this.f50578d;
        }
        throw new IllegalStateException("Pagination Not Supported");
    }

    private boolean k() {
        return !this.R;
    }

    public void onDestroy() {
        if (this.n != null) {
            this.n = null;
        }
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("bundle_extra_category_item") && arguments.getSerializable("bundle_extra_category_item") != null) {
                this.k = (CJRItem) arguments.getSerializable("bundle_extra_category_item");
            }
            if (arguments.containsKey(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST)) {
                this.q = arguments.getBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST);
            }
            if (arguments.containsKey("bundle_extra_secondary_home")) {
                this.x = arguments.getBoolean("bundle_extra_secondary_home");
            }
            if (arguments.containsKey("bundle_extra_clp_parallax_animation_required")) {
                this.y = arguments.getBoolean("bundle_extra_clp_parallax_animation_required");
            }
            if (arguments.containsKey("bundle_extra_secondary_home_user_visible")) {
                this.A = arguments.getBoolean("bundle_extra_secondary_home_user_visible");
            }
            if (arguments.containsKey("qrcode_id")) {
                this.B = (String) arguments.getSerializable("qrcode_id");
            }
            if (arguments.containsKey("affiliateID")) {
                this.D = (String) arguments.getSerializable("affiliateID");
            }
            if (arguments.containsKey("timestamp")) {
                this.E = (String) arguments.getSerializable("timestamp");
            }
            if (arguments.containsKey("deeplink")) {
                this.C = (String) arguments.getSerializable("deeplink");
            }
            if (arguments.containsKey("source")) {
                this.K = arguments.getString("source", (String) null);
            }
            if (arguments.containsKey(net.one97.paytm.common.utility.b.bn)) {
                this.M = arguments.getString(net.one97.paytm.common.utility.b.bn, "");
            }
            if (arguments.containsKey("origin")) {
                this.N = arguments.getString("origin", "");
            }
            if (arguments.containsKey("store_front_url_key")) {
                this.f50577c = arguments.getString("store_front_url_key", "");
            }
            if (arguments.containsKey("EXTRA_STORE_FRONT_ALTERNATE_URL")) {
                this.O = arguments.getString("EXTRA_STORE_FRONT_ALTERNATE_URL");
            }
            if (arguments.containsKey("DISABLE_PAGINATION")) {
                this.R = arguments.getBoolean("DISABLE_PAGINATION");
            }
            this.u = (CJRItem) getArguments().getSerializable("extra_home_data");
            CJRItem cJRItem = this.u;
            if (cJRItem != null) {
                this.t.put("search_type", cJRItem.getSearchType());
                this.t.put("search_category", this.u.getSearchCategory());
                this.t.put("search_term", this.u.getSearchTerm());
                this.t.put("search_result_type", this.u.getSearchResultType());
            }
        }
        this.m = layoutInflater.inflate(R.layout.secondary_home_layout_travel, (ViewGroup) null);
        this.Q = (RelativeLayout) this.m.findViewById(R.id.container);
        this.n = (CJRCustomObservableRecyclerView) this.m.findViewById(R.id.home_list);
        this.n.setNestedScrollingEnabled(false);
        l.a(f50573g, "");
        this.s = (ViewGroup) this.m.findViewById(R.id.no_network);
        this.J = (ImageView) this.m.findViewById(R.id.iv_scroll_to_top);
        this.J.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (e.this.f50581i == null) {
                    return;
                }
                if (e.this.f50581i.get() instanceof ScrollView) {
                    ((ScrollView) e.this.f50581i.get()).scrollTo(0, 0);
                } else if (e.this.f50581i.get() instanceof NestedScrollView) {
                    ((NestedScrollView) e.this.f50581i.get()).scrollTo(0, 0);
                }
            }
        });
        this.mProgessBarItemLoading = (ProgressBar) this.m.findViewById(R.id.secondary_home_page_item_loading);
        this.homepage_loading = (RelativeLayout) this.m.findViewById(R.id.rel_homepage_loading);
        this.homepage_loading.setVisibility(8);
        this.P = this.m.findViewById(R.id.progress_bar_recycler);
        this.n.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        this.m.findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.loadData();
            }
        });
        if (getArguments() != null) {
            if (getArguments().containsKey("bundle_extra_category_item") && getArguments().getSerializable("bundle_extra_category_item") != null) {
                this.k = (CJRItem) getArguments().getSerializable("bundle_extra_category_item");
            }
            this.V = getArguments().getBoolean("trigger-impression-on-visibility", false);
            this.R = getArguments().getBoolean("disable-pagination", false);
            this.W = getArguments().getBoolean("is-offer", false);
        }
        TypedValue typedValue = new TypedValue();
        if (getActivity() != null && getActivity().getTheme().resolveAttribute(16843499, typedValue, true)) {
            this.F = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
            this.G = (float) (this.F * 3);
        }
        if (getArguments() != null) {
            if (getArguments().getBoolean("key_actionbar_height_padding_required") && getArguments().getBoolean("key_actionbar_height_padding_required_at_bottom")) {
                View view = this.m;
                int i2 = this.F;
                view.setPadding(0, i2, 0, i2);
            } else if (getArguments().getBoolean("key_actionbar_height_padding_required")) {
                this.m.setPadding(0, this.F, 0, 0);
            }
        }
        this.v = t.b((Context) getActivity());
        return this.m;
    }

    static /* synthetic */ void b(e eVar) {
        net.one97.paytm.landingpage.a.a aVar = eVar.f50576b;
        if (aVar != null && aVar.f52646c && aVar.f52648e != null && aVar.f52648e.size() > 0) {
            Iterator<Map.Entry<RecyclerView.v, com.paytmmall.clpartifact.modal.clpCommon.View>> it2 = aVar.f52648e.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                RecyclerView.v vVar = (RecyclerView.v) next.getKey();
                com.paytmmall.clpartifact.modal.clpCommon.View view = (com.paytmmall.clpartifact.modal.clpCommon.View) next.getValue();
                Rect rect = new Rect();
                if (!(aVar.f52645b == null || aVar.f52645b.get() == null || !(aVar.f52645b.get() instanceof View))) {
                    ((View) aVar.f52645b.get()).getHitRect(rect);
                    if (vVar.itemView.getLocalVisibleRect(rect)) {
                        int i2 = -1;
                        for (com.paytmmall.clpartifact.modal.clpCommon.View id : aVar.f52644a) {
                            i2++;
                            if (id.getId().longValue() == view.getId().longValue()) {
                                break;
                            }
                        }
                        aVar.f52647d.put(Integer.valueOf(i2), Boolean.TRUE);
                        aVar.f52651h.fireImpression(view, i2);
                        it2.remove();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(e eVar, String str, String str2) {
        ViewGroup viewGroup = eVar.s;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ((TextView) eVar.s.findViewById(R.id.no_network_title)).setText(str);
        ((TextView) eVar.s.findViewById(R.id.no_network_message)).setText(str2);
    }

    static /* synthetic */ void k(e eVar) {
        eVar.S = true;
        net.one97.paytm.landingpage.a.a aVar = eVar.f50576b;
        if (aVar != null) {
            aVar.f52646c = true;
        }
    }
}

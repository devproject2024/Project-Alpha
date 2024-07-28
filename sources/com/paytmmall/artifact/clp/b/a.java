package com.paytmmall.artifact.clp.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.NoConnectionError;
import com.android.volley.VolleyError;
import com.google.gson.o;
import com.paytm.utility.b.b;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.clp.b.a;
import com.paytmmall.artifact.d.c;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.customViews.CartBottomSheetFragment;
import com.paytmmall.clpartifact.ga.GAJobModel;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IClientListener;
import com.paytmmall.clpartifact.listeners.IClpFragment;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.OnChildFragmentRVScrollListener;
import com.paytmmall.clpartifact.listeners.RVScrollDispatchListener;
import com.paytmmall.clpartifact.modal.cart.CJRCart;
import com.paytmmall.clpartifact.modal.clpCommon.CLPNetworkResponse;
import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.CLPCacheUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPGTMConstants;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.EndlessRecyclerViewScrollListener;
import com.paytmmall.clpartifact.utils.FileUtils;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import com.paytmmall.clpartifact.view.adapter.InfiniteGridViewPagerAdapter;
import com.paytmmall.clpartifact.view.viewHolder.InfiniteGridRowViewHolder;
import com.paytmmall.clpartifact.view.viewmodel.InfiniteGridViewModel;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.MallSdkVHListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;

public class a extends h implements IClpFragment, OnChildFragmentRVScrollListener, RVScrollDispatchListener, MallSdkVHListener {
    private static final String x = a.class.getSimpleName();
    private BroadcastReceiver A = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (!TextUtils.isEmpty(intent.getAction())) {
                if (TextUtils.equals(CLPConstants.ACTION_UPDATE_CLP, intent.getAction())) {
                    if (a.this.q) {
                        boolean unused = a.this.r = true;
                    } else {
                        a.this.l();
                    }
                }
                if (TextUtils.equals(CLPConstants.Action.ONSUCCESS_CART_UPDATE, intent.getAction())) {
                    a.o(a.this);
                }
                if (TextUtils.equals("action_update_login_status", intent.getAction())) {
                    a.p(a.this);
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f15587a = 1;

    /* renamed from: b  reason: collision with root package name */
    String f15588b = "isMall";

    /* renamed from: c  reason: collision with root package name */
    private final int f15589c = 318;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.paytmmall.artifact.b.a f15590d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.paytmmall.artifact.clp.c.a f15591e;

    /* renamed from: f  reason: collision with root package name */
    private int f15592f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f15593g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CLPResponse f15594h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f15595i;
    private List<Page> j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public CLPResponse l;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public boolean n = false;
    private com.paytmmall.artifact.clp.a.a o;
    /* access modifiers changed from: private */
    public InfiniteGridViewModel p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public boolean r;
    private boolean s = true;
    /* access modifiers changed from: private */
    public boolean t;
    private InfiniteGridViewPagerAdapter.ITabVisibilityListener u;
    private boolean v;
    private boolean w;
    private Map<String, Object> y;
    private final RecyclerView.l z = new RecyclerView.l() {
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if ((a.this.x() || (a.this.z() && !a.this.f15591e.f15615b && !a.this.h())) && (!a.this.y() || !a.this.x())) {
                if (a.this.m <= 0) {
                    if (i3 > 0) {
                        if (!a.this.c()) {
                            a.h(a.this);
                            androidx.localbroadcastmanager.a.a.a(a.this.getContext()).a(new Intent(CLPConstants.ACTION_ANIMATE_BOTTOMBAR_OUT));
                        }
                    }
                } else if (i3 < 0) {
                    a.i(a.this);
                    androidx.localbroadcastmanager.a.a.a(a.this.getContext()).a(new Intent(CLPConstants.ACTION_ANIMATE_BOTTOMBAR_IN));
                }
                int unused = a.this.m = i3;
            }
            a.a(a.this, recyclerView);
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                a.this.a();
            }
        }
    };

    public Object getWXSDKInstance() {
        return null;
    }

    public boolean isRendered() {
        return true;
    }

    public static a a(final String str, final int i2) {
        return a((HashMap<String, Object>) new HashMap<String, Object>() {
            {
                put("url", str);
                put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
            }
        });
    }

    private static Bundle b(HashMap<String, Object> hashMap) {
        Bundle bundle = new Bundle();
        if (hashMap != null && !hashMap.isEmpty()) {
            if (hashMap.containsKey("url")) {
                bundle.putString("url", String.valueOf(hashMap.get("url")));
            }
            if (hashMap.containsKey(CLPConstants.ARGUMENT_IS_BOTTOM_TAB)) {
                bundle.putBoolean(CLPConstants.ARGUMENT_IS_BOTTOM_TAB, Boolean.parseBoolean(String.valueOf(hashMap.get(CLPConstants.ARGUMENT_IS_BOTTOM_TAB))));
            }
            if (hashMap.containsKey(CLPConstants.ARGUMENT_KEY_POSITION)) {
                bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, Integer.parseInt(String.valueOf(hashMap.get(CLPConstants.ARGUMENT_KEY_POSITION))));
            }
            if (hashMap.containsKey(CLPConstants.IS_SECONDARY_HOME_CLP)) {
                bundle.putBoolean(CLPConstants.IS_SECONDARY_HOME_CLP, ((Boolean) hashMap.get(CLPConstants.IS_SECONDARY_HOME_CLP)).booleanValue());
            }
        }
        return bundle;
    }

    public static a a(HashMap<String, Object> hashMap) {
        a aVar = new a();
        aVar.setArguments(b(hashMap));
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        RVScrollDispatchListener b2 = b();
        if (b2 == null || !b2.isDispatchRequired()) {
            a(c());
        } else {
            a(false);
        }
    }

    private RVScrollDispatchListener b() {
        List<Fragment> d2 = getChildFragmentManager().f3424a.d();
        if (d2.isEmpty()) {
            return null;
        }
        for (Fragment next : d2) {
            if (next != null && next.getView() != null && next.getUserVisibleHint() && (next instanceof RVScrollDispatchListener)) {
                return (RVScrollDispatchListener) next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f15590d.f15397e.getLayoutManager();
        if (linearLayoutManager == null || linearLayoutManager.findFirstVisibleItemPosition() == 0) {
            return true;
        }
        return false;
    }

    private boolean d() {
        return getArguments() != null && getArguments().getBoolean(CLPConstants.IS_NESTED, false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        int i2 = 0;
        this.f15590d = (com.paytmmall.artifact.b.a) f.a(layoutInflater, R.layout.fragment_clp, viewGroup, false);
        this.f15595i = t();
        FragmentActivity activity = getActivity();
        View view = this.f15590d.f15399g;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f15590d.getRoot().findViewById(R.id.clp_toolbar_search);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.f15590d.getRoot().findViewById(R.id.clp_cart_view);
        if (z()) {
            textView = (TextView) this.f15590d.getRoot().findViewById(R.id.secondary_home_cart_items);
        } else {
            textView = (TextView) this.f15590d.getRoot().findViewById(R.id.items_in_cart);
        }
        this.f15593g = textView;
        if (activity != null) {
            if (x()) {
                this.f15591e = (com.paytmmall.artifact.clp.c.a) am.a((Fragment) this).a(com.paytmmall.artifact.clp.c.a.class);
            } else {
                this.f15591e = (com.paytmmall.artifact.clp.c.a) am.a(getActivity()).a(com.paytmmall.artifact.clp.c.a.class);
                this.v = true;
            }
            this.p = (InfiniteGridViewModel) am.a((Fragment) this).a(InfiniteGridViewModel.class);
        }
        if (CLPArtifact.getInstance().getCommunicationListener().isMallApp()) {
            if (getActivity() != null) {
                Window window = getActivity().getWindow();
                window.getDecorView().setSystemUiVisibility(0);
                if (Build.VERSION.SDK_INT >= 21 && getActivity() != null) {
                    window.setStatusBarColor(-16777216);
                }
            }
        } else if (this.f15591e.f15615b) {
            view.setVisibility(8);
        } else {
            e();
        }
        this.f15590d.getRoot().findViewById(R.id.clp_home_toolbar).setVisibility((!x() || !CLPArtifact.getInstance().getCommunicationListener().isMallApp()) ? 8 : 0);
        View findViewById = this.f15590d.getRoot().findViewById(R.id.toolbar_secondary_home);
        if (!f()) {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        if (z()) {
            this.f15590d.getRoot().findViewById(R.id.secondary_home_back).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.i(view);
                }
            });
            this.f15590d.getRoot().findViewById(R.id.img_humburger_icon).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.h(view);
                }
            });
            this.f15590d.getRoot().findViewById(R.id.ll_search_bar).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.g(view);
                }
            });
            this.f15590d.getRoot().findViewById(R.id.secondary_home_heart).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f(view);
                }
            });
            this.f15590d.getRoot().findViewById(R.id.secondary_home_search).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.e(view);
                }
            });
            this.f15590d.getRoot().findViewById(R.id.secondary_home_cart).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.d(view);
                }
            });
        }
        m();
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.l(view);
            }
        });
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.k(view);
            }
        });
        this.f15590d.getRoot().findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.n();
            }
        });
        this.f15590d.f15398f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.j(view);
            }
        });
        return this.f15590d.getRoot();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        u();
    }

    private void e() {
        if (this.f15590d.f15399g != null) {
            this.f15590d.f15399g.setVisibility(g() ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        String gTMUrl = CLPArtifact.getInstance().getCommunicationListener().getGTMUrl(CLPGTMConstants.MALL_HOME_MENU_URL);
        if (TextUtils.isEmpty(gTMUrl)) {
            gTMUrl = "paytmmall://flyout?targetPage=home";
        }
        if (getActivity() != null) {
            Item item = new Item();
            item.setUrlType("flyout");
            item.setmUrl(gTMUrl);
            if (CLPArtifact.getInstance().getCommunicationListener() != null) {
                CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(getActivity(), item);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        Item item = new Item();
        item.setUrlType(CLPConstants.WISHLIST);
        if (CLPArtifact.getInstance().getCommunicationListener() != null) {
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(getActivity(), item);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        u();
    }

    private boolean f() {
        if (!x() && z() && !h() && !this.f15591e.f15615b) {
            return true;
        }
        return false;
    }

    private boolean g() {
        return y() ? !x() && f() : !d() && (x() || f());
    }

    /* access modifiers changed from: private */
    public boolean h() {
        String t2 = t();
        if (TextUtils.isEmpty(t2)) {
            return false;
        }
        if (t2.toLowerCase().contains("discoverability=offline") || t2.toLowerCase().contains("storewid")) {
            return true;
        }
        return false;
    }

    private boolean i() {
        return x() || z();
    }

    private boolean j() {
        CLPResponse cLPResponse = this.f15594h;
        return CLPUtils.isFlashSale(cLPResponse != null ? cLPResponse.getPage() : null);
    }

    private void k() {
        TextView textView;
        CLPResponse cLPResponse;
        if (z() && (textView = (TextView) this.f15590d.getRoot().findViewById(R.id.secondary_home_title)) != null && (cLPResponse = this.f15594h) != null) {
            textView.setText(cLPResponse.getPageName());
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (!i()) {
            return;
        }
        if (z2) {
            this.f15590d.f15398f.setVisibility(8);
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15590d.f15398f.getLayoutParams();
        if (isAdded()) {
            if (this.f15590d.f15393a.getVisibility() == 0) {
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.dimen_80dp);
            } else {
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.dimen_10dp);
            }
        }
        this.f15590d.f15398f.setVisibility(0);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter(CLPConstants.Action.ONSUCCESS_CART_UPDATE);
            intentFilter.addAction(CLPConstants.ACTION_UPDATE_CLP);
            intentFilter.addAction("action_update_login_status");
            androidx.localbroadcastmanager.a.a.a(context).a(this.A, intentFilter);
        }
        this.f15590d.f15393a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.c(view);
            }
        });
        this.f15590d.f15393a.findViewById(R.id.goToCartBtn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.f15590d.f15397e.addOnItemTouchListener(new GridRVOnTouchListener(r()));
        if (z() && !CartUtils.hasCartDetails()) {
            LogUtils.d("onViewCreated", "loading Cart");
            new CLPRepository().loadCartDetails(getContext().getApplicationContext());
        }
        this.f15591e.f15617d.observe(this, new z() {
            public final void onChanged(Object obj) {
                a.this.a((RedirectorModel) obj);
            }
        });
        b(getUserVisibleHint());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        u();
    }

    private static int a(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.containsKey(CLPConstants.ARGUMENT_KEY_POSITION)) {
                    return ((Integer) map.get(CLPConstants.ARGUMENT_KEY_POSITION)).intValue();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (view.getId() == R.id.goToCartBtn) {
            u();
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        com.paytmmall.artifact.clp.a.a aVar = this.o;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            if (this.n) {
                w();
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.q = true;
    }

    public void onStop() {
        super.onStop();
        GaHandler.getInstance().emptyPendingQueue();
    }

    private void b(boolean z2) {
        if (z2 && getView() != null && (getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
            ((OnChildFragmentRVScrollListener) getParentFragment()).onChildFragmentChange(true, false);
        }
    }

    private void m() {
        if (this.f15593g != null) {
            this.f15592f = CLPArtifact.getInstance().getCommunicationListener().getCartCount(getActivity());
            if (this.f15592f == 0) {
                this.f15593g.setVisibility(8);
                return;
            }
            this.f15593g.setVisibility(0);
            this.f15593g.setText(String.valueOf(this.f15592f));
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        c(false);
        if (getArguments() == null || !getArguments().containsKey(CLPConstants.CLP_RESPONSE)) {
            final int r2 = r();
            CLPCacheUtils.getInstance().loadFromCache(this.f15595i, new CLPNetworkService.IResponseListener() {
                public final void onSuccess(String str, o oVar) {
                    CLPResponse unused = a.this.l = (CLPResponse) new com.google.gson.f().a(str, CLPResponse.class);
                    boolean unused2 = a.this.k = false;
                    a aVar = a.this;
                    aVar.a(aVar.l);
                }

                public final void onError(VolleyError volleyError) {
                    if (a.b(r2)) {
                        FileUtils.readFileFromAsset(a.this.getContext(), "clpResponse.json", new CLPNetworkService.IResponseListener() {
                            public final void onSuccess(String str, o oVar) {
                                if (!a.this.k) {
                                    CLPResponse unused = a.this.l = (CLPResponse) new com.google.gson.f().a(str, CLPResponse.class);
                                    a aVar = a.this;
                                    aVar.a(aVar.l);
                                }
                            }

                            public final void onError(VolleyError volleyError) {
                                boolean unused = a.this.k = true;
                                a.b(a.this, false);
                                a.this.s();
                            }
                        });
                    } else {
                        boolean unused = a.this.k = true;
                        a.b(a.this, false);
                    }
                    a.this.s();
                }
            });
            a(false, false);
            return;
        }
        CLPResponse cLPResponse = new CLPResponse();
        cLPResponse.setPage((ArrayList) getArguments().getSerializable(CLPConstants.CLP_RESPONSE));
        b(cLPResponse);
        a(false, (CLPNetworkResponse) cLPResponse, false);
    }

    /* access modifiers changed from: private */
    public static boolean b(int i2) {
        return i2 == CLPArtifact.getInstance().getCommunicationListener().getHomeTabCacheSupportIndex();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3) {
        this.f15591e.a(this.f15595i).observe(this, new z(z2, z3) {
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                a.this.a(this.f$1, this.f$2, (CLPNetworkResponse) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, CLPNetworkResponse cLPNetworkResponse, boolean z3) {
        this.k = true;
        if (cLPNetworkResponse instanceof CLPResponse) {
            c(false);
            CLPResponse cLPResponse = (CLPResponse) cLPNetworkResponse;
            if (z2) {
                d(cLPResponse);
                b(cLPResponse.getPage());
            } else if (!cLPResponse.equals(this.l)) {
                a(cLPResponse);
            }
            if (!this.t) {
                a(cLPResponse.getPage());
            }
            if (z3) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        a.this.A();
                    }
                }, 200);
            }
        } else if (cLPNetworkResponse != null && !cLPNetworkResponse.isSuccess()) {
            s();
            int i2 = this.f15587a;
            if (i2 > 1) {
                i2--;
            }
            this.f15587a = i2;
            VolleyError error = cLPNetworkResponse.getError();
            if (!(error instanceof NoConnectionError) && c.m(getActivity())) {
                LogUtils.printStackTrace(error);
                Toast.makeText(getActivity(), "Something went wrong, please try again later", 0).show();
            } else if (z2) {
                Toast.makeText(getActivity(), "Please connect to internet", 0).show();
            } else if (r() != CLPArtifact.getInstance().getCommunicationListener().getHomeTabCacheSupportIndex()) {
                c(true);
            }
        }
        if (cLPNetworkResponse != null && cLPNetworkResponse.getError() != null) {
            s();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.f15591e.a();
    }

    private void a(final List<Page> list) {
        new Thread() {
            public final void run() {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (a.a(list, i2).equals(ViewHolderFactory.TYPE_ACTIVE_ORDER)) {
                        boolean unused = a.this.t = true;
                        a.this.o();
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void o() {
        String defaultParams = CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(getContext(), CLPArtifact.getInstance().getCommunicationListener().getURL(CLPConstants.CONFIG_KEY_MY_ORDERS, CLPConstants.URL.MY_ORDERS) + "?entityType=marketplace&type=shopping&item_tracking=1");
        if (getActivity() != null && !TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(getActivity()))) {
            this.p.fetchActiveOrder(getActivity(), defaultParams);
        }
    }

    private void c(boolean z2) {
        this.f15590d.getRoot().findViewById(R.id.no_network).setVisibility(z2 ? 0 : 4);
    }

    private void b(final List<Page> list) {
        new Thread(new Runnable() {
            public final void run() {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (a.a(list, i2).equals(ViewHolderFactory.TYPE_ITEM_TABBED)) {
                        if (TextUtils.isEmpty(((Page) list.get(i2)).getViews().get(0).getItems().get(0).getUrl())) {
                            String a2 = a.a(a.this, ((Page) list.get(i2)).getViews().get(0).getItems().get(0).getUrl());
                            a.this.p.fetchGridResponse(a.this.getActivity(), a2).observe(a.this, new z(a2) {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onChanged(Object obj) {
                                    a.AnonymousClass15.this.a(this.f$1, (CJRGrid) obj);
                                }
                            });
                        } else {
                            return;
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(String str, CJRGrid cJRGrid) {
                if (cJRGrid != null) {
                    a.a(str, cJRGrid);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void a(CLPResponse cLPResponse) {
        this.f15594h = cLPResponse;
        b(cLPResponse);
        k();
        p();
        this.f15591e.a(cLPResponse);
        if (this.k && this.f15587a == 1 && b(r())) {
            CLPCacheUtils.getInstance().saveResponseInCache(this.f15595i, new com.google.gson.f().b(cLPResponse));
        }
        this.f15590d.getRoot().findViewById(R.id.secondary_home_title).setVisibility(8);
        this.f15590d.getRoot().findViewById(R.id.clp_paytm_mall_logo).setVisibility(8);
        FragmentActivity activity = getActivity();
        if (!(cLPResponse == null || activity == null || activity.isFinishing())) {
            if (cLPResponse.getPageId() == null || cLPResponse.getPageId().longValue() != 318) {
                this.f15590d.getRoot().findViewById(R.id.secondary_home_title).setVisibility(0);
            } else {
                this.f15590d.getRoot().findViewById(R.id.clp_paytm_mall_logo).setVisibility(0);
            }
            this.j = cLPResponse.getPage();
            RecyclerView recyclerView = this.f15590d.f15397e;
            recyclerView.setHasFixedSize(true);
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.o = new com.paytmmall.artifact.clp.a.a(getChildFragmentManager(), x(), this.y, new IGAHandlerListener() {
                public /* synthetic */ boolean IsClickEnable() {
                    return IGAClickListener.CC.$default$IsClickEnable(this);
                }

                public final void OnItemClick(Item item, int i2) {
                }

                public /* synthetic */ void OnItemClick(Item item, int i2, boolean z) {
                    IGAClickListener.CC.$default$OnItemClick(this, item, i2, z);
                }

                public /* synthetic */ int getClient() {
                    return IClientListener.CC.$default$getClient(this);
                }

                public /* synthetic */ String getClientRequestID() {
                    return IAdListener.CC.$default$getClientRequestID(this);
                }

                public final void fireImpression(Item item, int i2) {
                    if (item != null) {
                        a.a(a.this, item, i2);
                    }
                }

                public final void fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
                    if (view != null) {
                        a.a(a.this, view, i2);
                    }
                }

                public final void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
                    a.a(a.this, cJRGridProduct, i2);
                }
            }, new CustomAction.Builder().hostMallSdkVhListener(this).build());
            this.f15591e.a(this.o.a(this.j, cLPResponse));
            e();
            this.o.f15570b = q();
            this.o.setHasStableIds(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()) {
                public final boolean canScrollVertically() {
                    return a.x(a.this);
                }
            });
            recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) recyclerView.getLayoutManager()) {
                public final void onLoadMore(int i2, int i3, RecyclerView recyclerView) {
                    if (a.this.k && !a.this.f15591e.f15616c && a.this.f15594h != null && a.this.f15594h.getHasMore()) {
                        a.this.f15587a++;
                        a aVar = a.this;
                        String unused = aVar.f15595i = UrlUtils.getUpdatedUrl(aVar.f15595i, "page_count", String.valueOf(a.this.f15587a));
                        a.b(a.this, true);
                        a.this.a(true, false);
                    }
                }
            });
            this.f15590d.a(this.o);
            this.f15590d.executePendingBindings();
            this.o.f15569a.observe(activity, new z() {
                public final void onChanged(Object obj) {
                    a.this.a((Boolean) obj);
                }
            });
        }
        s();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        s();
    }

    private void p() {
        CLPResponse cLPResponse = this.f15594h;
        if (cLPResponse != null) {
            GAUtil.setGAKey(cLPResponse);
            e(this.f15594h);
            GAUtil.setFlashSaleSlotInfo("");
        }
    }

    private void b(CLPResponse cLPResponse) {
        String c2 = c(cLPResponse);
        if (!TextUtils.isEmpty(c2) && getContext() != null && this.f15590d.f15397e != null && !ImageUtility.isActivitydestroyed(this.f15590d.f15397e)) {
            b.a.C0750a a2 = b.a(getContext());
            a2.f43753a = c2;
            a2.l = true;
            a2.a((Object) Integer.valueOf(R.color.clp_light_grey_border)).a((ImageView) null, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                public final void onError(Exception exc) {
                }

                public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
                    Drawable drawable = (Drawable) obj;
                    if (a.this.f15590d != null && a.this.f15590d.f15397e != null) {
                        a.this.f15590d.f15397e.setBackground(drawable);
                    }
                }
            });
        }
    }

    private static String c(CLPResponse cLPResponse) {
        if (cLPResponse == null || cLPResponse.getLayout() == null) {
            return null;
        }
        return cLPResponse.getLayout().getBgImageUrl();
    }

    private boolean q() {
        if (g()) {
            return true;
        }
        if (y()) {
            return j() || z() || x();
        }
        return false;
    }

    private void d(CLPResponse cLPResponse) {
        List<Page> page;
        s();
        if (cLPResponse != null && (page = cLPResponse.getPage()) != null) {
            this.f15594h = cLPResponse;
            com.paytmmall.artifact.clp.a.a aVar = this.o;
            if (aVar != null) {
                this.f15591e.a(aVar.a(page, cLPResponse));
                e();
                this.o.f15570b = q();
            }
        }
    }

    private int r() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(CLPConstants.ARGUMENT_KEY_POSITION, -1);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void s() {
        ProgressBar progressBar;
        if (!this.f15591e.f15616c && (progressBar = this.f15590d.f15396d) != null && progressBar.getVisibility() == 0) {
            progressBar.setVisibility(8);
        }
    }

    private String t() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString("url");
        }
        return null;
    }

    private void u() {
        Item item = new Item();
        item.setUrlType("cart");
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.DISCOVERABILITY, Boolean.valueOf(UrlUtils.isOfflineFlow(this.f15595i)));
        item.setGaData(hashMap);
        CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(requireActivity(), item);
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        FragmentActivity activity = getActivity();
        communicationListener.sendCustomGTMEvents(activity, GAUtil.getGakey() + " cart_widget", "cart_widget_clicked", (String) null, (String) null, CLPConstants.GA_CHANNEL_NAME, "homescreen");
    }

    private void v() {
        try {
            Intent intent = new Intent(getActivity(), CLPArtifact.getInstance().getCommunicationListener().getSearchActivity());
            intent.putExtra("ga_data", (HashMap) this.y);
            intent.putExtra(this.f15588b, true);
            startActivity(intent);
        } catch (Exception e2) {
            LogUtils.printStackTrace(e2);
        }
    }

    public void onResume() {
        super.onResume();
        boolean z2 = true;
        if (!this.w) {
            n();
            this.w = !this.w;
        }
        this.v = true;
        p();
        com.paytmmall.artifact.clp.c.a aVar = this.f15591e;
        if (aVar != null) {
            while (!aVar.f15620g.isEmpty()) {
                GAJobModel poll = aVar.f15620g.poll();
                if (poll != null) {
                    int type = poll.getType();
                    if (type == 1001) {
                        GaHandler.getInstance().fireImpression(poll.getData(), poll.getPosition());
                    } else if (type == 1002) {
                        GaHandler.getInstance().fireImpression(poll.getViewData(), poll.getPosition());
                    } else if (type == 1003) {
                        GaHandler.getInstance().fireInfiniteGridProductImpression(poll.getProductData(), poll.getPosition());
                    }
                }
            }
        }
        if (getView() != null && !CartUtils.hasCartDetails()) {
            new CLPRepository().loadCartDetails(getContext().getApplicationContext());
        }
        b(true);
        String str = this.f15595i;
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(CLPConstants.IS_MGV);
                ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
                if (queryParameter == null || !Boolean.parseBoolean(queryParameter)) {
                    z2 = false;
                }
                communicationListener.setMGV(z2);
            } catch (Exception e2) {
                LogUtils.printStackTrace(e2);
            }
        }
        this.q = false;
        p();
        m();
        if (this.r) {
            l();
        }
        this.f15590d.f15393a.setVisibility(8);
        a(c());
        ICLPCommunicationListener communicationListener2 = CLPArtifact.getInstance().getCommunicationListener();
        if (communicationListener2 != null && getContext() != null && !TextUtils.isEmpty(communicationListener2.getSSOToken(getContext())) && communicationListener2.getWishListProductsCache() == null) {
            communicationListener2.fetchWishList(getContext());
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        CJRCart cartCache = CartUtils.getCartCache();
        if (cartCache != null) {
            int size = cartCache.getCartItems().size();
            int i2 = 8;
            this.f15590d.f15393a.setVisibility(size > 0 ? 0 : 8);
            TextView textView = (TextView) this.f15590d.f15393a.findViewById(R.id.priceValue);
            TextView textView2 = (TextView) this.f15590d.f15393a.findViewById(R.id.itemLabel);
            TextView textView3 = (TextView) this.f15590d.f15393a.findViewById(R.id.effective_price_tag);
            if (cartCache.getEffectivePrice() >= 1.0d) {
                i2 = 0;
            }
            textView3.setVisibility(i2);
            textView3.setText(String.format(getResources().getString(R.string.effective_price_tag), new Object[]{StringUtils.getRupeesFormat(String.valueOf(cartCache.getEffectivePrice()))}));
            textView.setText(StringUtils.getRupeesFormat(String.valueOf(cartCache.getFinalPrice())));
            textView2.setText(String.format(getResources().getQuantityString(R.plurals.cart_item, size), new Object[]{Integer.valueOf(size)}));
            a();
        }
    }

    public boolean getUserVisibleHint() {
        if (this.s) {
            this.s = false;
            CLPResponse cLPResponse = this.f15594h;
            CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(getActivity(), CLPConstants.GA_CHANNEL_NAME, "homepage_category_loaded", cLPResponse != null ? cLPResponse.getGaCategory() : "", (String) null, CLPConstants.CHANNEL_NAME, "homescreen");
        }
        return super.getUserVisibleHint();
    }

    public Fragment getCLPFragment(IClpFragment iClpFragment) {
        if (iClpFragment instanceof Fragment) {
            return (Fragment) iClpFragment;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean x() {
        return !z();
    }

    /* access modifiers changed from: private */
    public boolean y() {
        return r() == 1001;
    }

    /* access modifiers changed from: private */
    public boolean z() {
        return getArguments() != null && getArguments().getBoolean(CLPConstants.IS_SECONDARY_HOME_CLP, false);
    }

    public void onChildFragmentRVScroll(boolean z2) {
        a(z2 && c());
    }

    public void onChildFragmentChange(boolean z2, boolean z3) {
        boolean z4 = true;
        if (!z2 && (!z3 || !c())) {
            z4 = false;
        }
        a(z4);
    }

    public void onDispatchScroll() {
        if (this.f15590d.f15397e != null) {
            this.f15590d.f15397e.smoothScrollToPosition(0);
        }
    }

    public boolean isDispatchRequired() {
        if (this.f15590d.f15397e != null && (this.f15590d.f15397e.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f15590d.f15397e.getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition != 0 && findFirstVisibleItemPosition > 0) {
                return true;
            }
        }
        return false;
    }

    private void e(CLPResponse cLPResponse) {
        if (cLPResponse != null) {
            if (this.y == null) {
                this.y = new HashMap();
            }
            this.y.put(GAUtil.KEY_PREV_SCREEN_NAME, cLPResponse.getGaKey());
            this.y.put(GAUtil.KEY_PREV_SCREEN_TYPE, ViewHolderFactory.CLASS_HOME);
        }
    }

    public void passAdapterPosFromVH(int i2) {
        com.paytmmall.artifact.clp.c.a aVar = this.f15591e;
        aVar.f15617d.setValue(new RedirectorModel(IuserActions.SCROLL_MAIN_RV, new HashMap<String, Object>(i2) {
            final /* synthetic */ int val$adapterPosition;
        }));
    }

    public void openSearch(FragmentActivity fragmentActivity, String str, int i2) {
        com.paytmmall.artifact.clp.c.a aVar = this.f15591e;
        Class<? extends Activity> searchActivity = CLPArtifact.getInstance().getCommunicationListener().getSearchActivity();
        if (searchActivity != null) {
            GaHandler.getInstance().fireSearchEvent();
            Intent intent = new Intent(fragmentActivity, searchActivity);
            if (aVar.f15614a.getValue() instanceof CLPResponse) {
                intent.putExtra(CLPConstants.EXTRA_INTENT_CONTEXT_PARAMS_OBJECT, ((CLPResponse) aVar.f15614a.getValue()).getContextParams());
            }
            intent.putExtra(CLPConstants.CONTEXT_STORE_CATEGORY_NAME, str);
            intent.putExtra(CLPConstants.IS_SEARCH_CURATED, i2);
            intent.putExtra(CLPConstants.EXTRA_INTENT_HEADER_EDITABLE, str);
            fragmentActivity.startActivity(intent);
        }
    }

    public HashMap<String, String> getContextParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        return (this.f15591e.f15614a == null || this.f15591e.f15614a.getValue() == null || !(this.f15591e.f15614a.getValue() instanceof CLPResponse)) ? hashMap : ((CLPResponse) this.f15591e.f15614a.getValue()).getContextParams();
    }

    public com.paytmmall.clpartifact.modal.clpCommon.View getFlashView() {
        return this.f15591e.f15618e;
    }

    public String getGAKey() {
        return this.f15591e.f15619f;
    }

    public void openAllStoresTab() {
        this.f15591e.f15617d.setValue(new RedirectorModel(1009));
    }

    public void openReviewsTab() {
        this.f15591e.a();
    }

    public void setReDirectorValue(RedirectorModel redirectorModel) {
        this.f15591e.f15617d.setValue(redirectorModel);
    }

    public y<RedirectorModel> getReDirector() {
        return this.f15591e.f15617d;
    }

    public Fragment getCLPFragment(String str, int i2, Bundle bundle, InfiniteGridViewPagerAdapter.ITabVisibilityListener iTabVisibilityListener) {
        a a2 = a(t(), i2);
        a2.setArguments(bundle);
        a2.u = iTabVisibilityListener;
        return a2;
    }

    public void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            androidx.localbroadcastmanager.a.a.a(context).a(this.A);
        }
        GaHandler.getInstance().clearFiredPromoSet();
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RedirectorModel redirectorModel) {
        if (redirectorModel == null) {
            return;
        }
        if (redirectorModel.getRequest() == 1010) {
            this.f15590d.f15397e.smoothScrollToPosition(a(redirectorModel.getDataMap()));
        } else if (redirectorModel.getRequest() == 1012) {
            Map<String, Object> dataMap = redirectorModel.getDataMap();
            com.paytmmall.clpartifact.modal.clpCommon.View view = (com.paytmmall.clpartifact.modal.clpCommon.View) dataMap.get("infiniteGridData");
            boolean booleanValue = ((Boolean) dataMap.get(CLPConstants.SHOW_GRID_PRODUCT_PRICE)).booleanValue();
            ((com.paytmmall.artifact.clp.c.a) am.a(getActivity()).a(com.paytmmall.artifact.clp.c.a.class)).f15618e = view;
            RecyclerView.v findViewHolderForLayoutPosition = this.f15590d.f15397e.findViewHolderForLayoutPosition(((LinearLayoutManager) this.f15590d.f15397e.getLayoutManager()).findLastVisibleItemPosition());
            if (findViewHolderForLayoutPosition instanceof InfiniteGridRowViewHolder) {
                ((InfiniteGridRowViewHolder) findViewHolderForLayoutPosition).reloadAdapterContents(view, booleanValue);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        CartBottomSheetFragment cartBottomSheetFragment = new CartBottomSheetFragment();
        cartBottomSheetFragment.setCancelable(true);
        cartBottomSheetFragment.show(getChildFragmentManager(), cartBottomSheetFragment.getTag());
        cartBottomSheetFragment.setOnViewClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        w();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        RVScrollDispatchListener b2 = b();
        if (b2 == null || !b2.isDispatchRequired()) {
            this.f15590d.f15397e.smoothScrollToPosition(0);
            return;
        }
        b2.onDispatchScroll();
        a(c());
    }

    static /* synthetic */ void a(a aVar, RecyclerView recyclerView) {
        if (aVar.d()) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                InfiniteGridViewPagerAdapter.ITabVisibilityListener iTabVisibilityListener = aVar.u;
                if (iTabVisibilityListener != null) {
                    iTabVisibilityListener.onVisbilityChange(0);
                    return;
                }
                return;
            }
            InfiniteGridViewPagerAdapter.ITabVisibilityListener iTabVisibilityListener2 = aVar.u;
            if (iTabVisibilityListener2 != null) {
                iTabVisibilityListener2.onVisbilityChange(8);
            }
            StringBuilder sb = new StringBuilder("show ");
            sb.append(findFirstVisibleItemPosition);
            sb.append(" ");
            sb.append(findLastVisibleItemPosition);
        }
    }

    static /* synthetic */ void h(a aVar) {
        if (aVar.g()) {
            x a2 = u.s(aVar.f15590d.f15399g).c((float) (-aVar.f15590d.f15399g.getBottom())).a((Interpolator) new LinearInterpolator());
            View view = (View) a2.f3139a.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.animate().withLayer();
                } else {
                    a2.f3142d = view.getLayerType();
                    a2.a(view, new x.a(a2));
                }
            }
            a2.a(200).a((androidx.core.h.y) new androidx.core.h.z() {
                public final void onAnimationEnd(View view) {
                    a.this.a(false);
                    if (a.this.n) {
                        a.this.w();
                        if (a.this.f15590d.f15393a.getVisibility() == 0) {
                            a aVar = a.this;
                            a.a(aVar, aVar.f15590d.f15393a);
                        }
                    }
                }
            }).c();
        }
    }

    static /* synthetic */ void i(a aVar) {
        if (aVar.g()) {
            aVar.f15590d.f15399g.setVisibility(0);
            u.s(aVar.f15590d.f15399g).c((float) aVar.f15590d.f15399g.getTop()).a(200).a((Interpolator) new LinearInterpolator()).a((androidx.core.h.y) new androidx.core.h.z() {
                public final void onAnimationEnd(View view) {
                    a.this.f15590d.f15399g.setVisibility(0);
                }

                public final void onAnimationStart(View view) {
                    if (a.this.n && a.this.f15590d.f15393a.getVisibility() == 0) {
                        a aVar = a.this;
                        u.s(aVar.f15590d.f15393a).a(200).a((Interpolator) new LinearInterpolator()).a(0.0f).a((androidx.core.h.y) new androidx.core.h.z() {
                            public final void onAnimationEnd(View view) {
                                view.setVisibility(0);
                                a.this.a(false);
                            }
                        }).c();
                    }
                }
            }).c();
        }
    }

    static /* synthetic */ void o(a aVar) {
        if (aVar.x()) {
            boolean z2 = true;
            if (aVar.r() != 1) {
                z2 = false;
            }
            if (z2 && aVar.m > 0) {
                aVar.w();
            }
        } else if (aVar.z()) {
            aVar.w();
        }
        aVar.m();
    }

    static /* synthetic */ void p(a aVar) {
        if (aVar.t) {
            aVar.o();
        }
        if (aVar.z() && aVar.f15591e.f15615b) {
            aVar.a(false, true);
        }
    }

    static /* synthetic */ void b(a aVar, boolean z2) {
        ProgressBar progressBar = aVar.f15590d.f15396d;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) progressBar.getLayoutParams();
        if (z2) {
            layoutParams.gravity = 81;
        } else {
            layoutParams.gravity = 17;
        }
        progressBar.setLayoutParams(layoutParams);
        progressBar.setVisibility(0);
    }

    static /* synthetic */ String a(List list, int i2) {
        return (list == null || list.get(i2) == null || ((Page) list.get(i2)).getViews() == null || ((Page) list.get(0)).getViews().get(0) == null) ? "" : ((Page) list.get(i2)).getViews().get(0).getType();
    }

    static /* synthetic */ String a(a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return UrlUtils.appendGridQueryParameter(UrlUtils.appendGridQueryParameter(CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(aVar.getActivity(), str), "page_count", 1), "items_per_page", 16);
    }

    static /* synthetic */ void a(String str, CJRGrid cJRGrid) {
        if (cJRGrid != null) {
            CLPCacheUtils.getInstance().saveResponseInCache(str, new com.google.gson.f().b(cJRGrid));
        }
    }

    static /* synthetic */ void a(a aVar, Item item, int i2) {
        if (aVar.v) {
            GaHandler.getInstance().fireImpression(item, i2);
            return;
        }
        com.paytmmall.artifact.clp.c.a aVar2 = aVar.f15591e;
        if (aVar2 != null) {
            aVar2.f15620g.add(new GAJobModel(item, i2));
        }
    }

    static /* synthetic */ void a(a aVar, com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (aVar.v) {
            GaHandler.getInstance().fireImpression(view, i2);
            return;
        }
        com.paytmmall.artifact.clp.c.a aVar2 = aVar.f15591e;
        if (aVar2 != null) {
            aVar2.f15620g.add(new GAJobModel(view, i2));
        }
    }

    static /* synthetic */ void a(a aVar, CJRGridProduct cJRGridProduct, int i2) {
        if (aVar.v) {
            GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, i2);
            return;
        }
        com.paytmmall.artifact.clp.c.a aVar2 = aVar.f15591e;
        if (aVar2 != null) {
            aVar2.f15620g.add(new GAJobModel(cJRGridProduct, i2));
        }
    }

    static /* synthetic */ boolean x(a aVar) {
        return (aVar.getArguments() != null && aVar.getArguments().getBoolean(CLPConstants.CAN_CLP_SCROLL, false)) || !aVar.f15591e.f15615b;
    }

    static /* synthetic */ void a(a aVar, View view) {
        view.setVisibility(0);
        u.s(view).a(200).a((Interpolator) new LinearInterpolator()).a((androidx.core.h.y) new androidx.core.h.z() {
            public final void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                a.this.a(false);
            }
        }).a(1.0f).c();
    }
}

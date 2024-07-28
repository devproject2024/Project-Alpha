package com.paytmmall.clpartifact.view.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.ICashBackListener;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.appwidgets.PayGridWidgetProvider;
import com.paytmmall.clpartifact.appwidgets.singleservice.SingleServiceWidgetProvider;
import com.paytmmall.clpartifact.appwidgets.utils.WidgetUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.FragmentHomeBinding;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.RVLayoutListener;
import com.paytmmall.clpartifact.utils.SFHomeHelper;
import com.paytmmall.clpartifact.view.actionmodel.HomeActionModel;
import com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel;
import com.paytmmall.clpartifact.view.actionmodel.IActionModel;
import com.paytmmall.clpartifact.view.adapter.SFHomeAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.view.viewmodel.SFHomeVM;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import com.paytmmall.clpartifact.view.viewmodel.SingleEventLiveData;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmall.clpartifact.widgets.callback.ActivityListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class SFHomeFragment extends BaseTracingFragment implements View.OnClickListener, ActivityListener {
    static final /* synthetic */ i[] $$delegatedProperties;
    private final String APP_FOREGROUND_REFRESH_TAG = H5Param.MENU_REFRESH;
    private final String USER_PROFILE_PIC_FILENAME = UpiConstants.USER_PROFILE_PIC_FILENAME;
    private HashMap _$_findViewCache;
    private final g adapter$delegate = h.a(new SFHomeFragment$adapter$2(this));
    private boolean bottomViewHidden;
    private final BroadcastReceiver broadCastReceiver = new SFHomeFragment$broadCastReceiver$1(this);
    private ICashBackListener cashbackListener;
    private CustomAction customActionModel;
    private IStaticWidget floatingWidget;
    /* access modifiers changed from: private */
    public IGAHandlerListener homeGAListener;
    /* access modifiers changed from: private */
    public boolean isBottomToTop;
    private boolean isCacheWorking;
    private boolean isPulseEventEnabled = true;
    /* access modifiers changed from: private */
    public boolean isTopToBottom = true;
    /* access modifiers changed from: private */
    public int mOffset;
    /* access modifiers changed from: private */
    public View noNetworkLayout;
    private final BroadcastReceiver refreshHomeReceiver = new SFHomeFragment$refreshHomeReceiver$1(this);
    private final g scanButtonGlobalLayoutListener$delegate = h.a(new SFHomeFragment$scanButtonGlobalLayoutListener$2(this));
    private HashMap<String, String> searchMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SharedHomeVM sharedViewModel;
    private final BroadcastReceiver updateProfile = new SFHomeFragment$updateProfile$1(this);
    /* access modifiers changed from: private */
    public FragmentHomeBinding viewBinding;
    /* access modifiers changed from: private */
    public SFHomeVM viewModel;

    static {
        Class<SFHomeFragment> cls = SFHomeFragment.class;
        $$delegatedProperties = new i[]{y.a((v) new w(y.b(cls), "adapter", "getAdapter()Lcom/paytmmall/clpartifact/view/adapter/SFHomeAdapter;")), y.a((v) new w(y.b(cls), "scanButtonGlobalLayoutListener", "getScanButtonGlobalLayoutListener()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;"))};
    }

    private final ViewTreeObserver.OnGlobalLayoutListener getScanButtonGlobalLayoutListener() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.scanButtonGlobalLayoutListener$delegate.getValue();
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final SFHomeAdapter getAdapter() {
        return (SFHomeAdapter) this.adapter$delegate.getValue();
    }

    public static final /* synthetic */ FragmentHomeBinding access$getViewBinding$p(SFHomeFragment sFHomeFragment) {
        FragmentHomeBinding fragmentHomeBinding = sFHomeFragment.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        return fragmentHomeBinding;
    }

    public static final /* synthetic */ SFHomeVM access$getViewModel$p(SFHomeFragment sFHomeFragment) {
        SFHomeVM sFHomeVM = sFHomeFragment.viewModel;
        if (sFHomeVM == null) {
            k.a("viewModel");
        }
        return sFHomeVM;
    }

    public final IStaticWidget getFloatingWidget() {
        return this.floatingWidget;
    }

    public final void setFloatingWidget(IStaticWidget iStaticWidget) {
        this.floatingWidget = iStaticWidget;
    }

    public final boolean getBottomViewHidden() {
        return this.bottomViewHidden;
    }

    public final void setBottomViewHidden(boolean z) {
        this.bottomViewHidden = z;
    }

    public final ICashBackListener getCashbackListener() {
        return this.cashbackListener;
    }

    public final void setCashbackListener(ICashBackListener iCashBackListener) {
        this.cashbackListener = iCashBackListener;
    }

    public final CustomAction getCustomActionModel() {
        return this.customActionModel;
    }

    public final void setCustomActionModel(CustomAction customAction) {
        this.customActionModel = customAction;
    }

    public final String getAPP_FOREGROUND_REFRESH_TAG() {
        return this.APP_FOREGROUND_REFRESH_TAG;
    }

    public final BroadcastReceiver getBroadCastReceiver() {
        return this.broadCastReceiver;
    }

    public final BroadcastReceiver getUpdateProfile() {
        return this.updateProfile;
    }

    public final BroadcastReceiver getRefreshHomeReceiver() {
        return this.refreshHomeReceiver;
    }

    public final HashMap<String, String> getSearchMap() {
        return this.searchMap;
    }

    public final void setSearchMap(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.searchMap = hashMap;
    }

    public final void onDestroyView() {
        onParentViewDestroyed();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final Activity getHostActivity() {
        return getActivity();
    }

    public final void onDestroy() {
        ICLPCommunicationListener communicationListener;
        Context context = getContext();
        if (context != null) {
            a.a(context).a(this.broadCastReceiver);
            a.a(context).a(this.refreshHomeReceiver);
            a.a(context).a(this.updateProfile);
        }
        CLPArtifact instance = CLPArtifact.getInstance();
        if (!(instance == null || (communicationListener = instance.getCommunicationListener()) == null)) {
            communicationListener.setSFPrewarmedResponseAvailableListener((ISFPrewarmedResponseAvailableListener) null, false);
        }
        super.onDestroy();
    }

    private final void onParentViewDestroyed() {
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        RecyclerView recyclerView = fragmentHomeBinding.homeRv;
        k.a((Object) recyclerView, "viewBinding.homeRv");
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i2));
            if (childViewHolder instanceof CLPBaseViewHolder) {
                CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) childViewHolder;
                cLPBaseViewHolder.onViewDetachedFromWindow(cLPBaseViewHolder, (com.paytmmall.clpartifact.modal.clpCommon.View) null);
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        a.a(context).a(this.broadCastReceiver, new IntentFilter("action_update_login_status"));
        a.a(context).a(this.refreshHomeReceiver, new IntentFilter(CLPConstants.ACTION_REFRESH_HOME));
        a.a(context).a(this.updateProfile, new IntentFilter(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
        super.onAttach(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai a2 = am.a((Fragment) this).a(SFHomeVM.class);
        k.a((Object) a2, "ViewModelProviders.of(th…get(SFHomeVM::class.java)");
        this.viewModel = (SFHomeVM) a2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.sharedViewModel = (SharedHomeVM) am.a(activity).a(SharedHomeVM.class);
        }
        CategoryImpressionAndApiHandler.INSTANCE.resetAll();
        AsyncTask.SERIAL_EXECUTOR.execute(new SFHomeFragment$onCreate$2(this));
        Context context = getContext();
        if (context != null) {
            a.a(context).a(this.broadCastReceiver, new IntentFilter("action_update_login_status"));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (SFHomeHelper.INSTANCE.getHomeView() == null) {
            this.viewBinding = getFragmentHomeBinding(layoutInflater, R.layout.fragment_home, viewGroup, false);
        } else {
            View homeView = SFHomeHelper.INSTANCE.getHomeView();
            if (homeView == null) {
                k.a();
            }
            FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) f.a(homeView);
            if (fragmentHomeBinding == null) {
                fragmentHomeBinding = getFragmentHomeBinding(layoutInflater, R.layout.fragment_home, viewGroup, false);
            }
            this.viewBinding = fragmentHomeBinding;
            SFHomeHelper.INSTANCE.resetHomeView();
        }
        FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
        if (fragmentHomeBinding2 == null) {
            k.a("viewBinding");
        }
        TextView textView = fragmentHomeBinding2.scanBtn;
        k.a((Object) textView, "viewBinding.scanBtn");
        textView.getViewTreeObserver().addOnGlobalLayoutListener(getScanButtonGlobalLayoutListener());
        FragmentHomeBinding fragmentHomeBinding3 = this.viewBinding;
        if (fragmentHomeBinding3 == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding3.progressLoader.setAnimation("Payments-Loader.json");
        this.customActionModel = new CustomAction.Builder().hostActivityListener(this).build();
        FragmentHomeBinding fragmentHomeBinding4 = this.viewBinding;
        if (fragmentHomeBinding4 == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding4.setLifecycleOwner(getViewLifecycleOwner());
        FragmentHomeBinding fragmentHomeBinding5 = this.viewBinding;
        if (fragmentHomeBinding5 == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding5.setAdapter(getAdapter());
        FragmentHomeBinding fragmentHomeBinding6 = this.viewBinding;
        if (fragmentHomeBinding6 == null) {
            k.a("viewBinding");
        }
        SFHomeVM sFHomeVM = this.viewModel;
        if (sFHomeVM == null) {
            k.a("viewModel");
        }
        fragmentHomeBinding6.setViewModel(sFHomeVM);
        FragmentHomeBinding fragmentHomeBinding7 = this.viewBinding;
        if (fragmentHomeBinding7 == null) {
            k.a("viewBinding");
        }
        return fragmentHomeBinding7.getRoot();
    }

    private final FragmentHomeBinding getFragmentHomeBinding(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z) {
        ViewDataBinding a2 = f.a(layoutInflater, i2, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…layoutId,container,false)");
        return (FragmentHomeBinding) a2;
    }

    /* access modifiers changed from: private */
    public final void setScanButtonGlobalLayoutListener() {
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        TextView textView = fragmentHomeBinding.scanBtn;
        k.a((Object) textView, "viewBinding.scanBtn");
        if (textView.isShown()) {
            PrintStream printStream = System.out;
            printStream.println("scanButtonVisibleTimestamp: " + System.currentTimeMillis());
            FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
            if (fragmentHomeBinding2 == null) {
                k.a("viewBinding");
            }
            TextView textView2 = fragmentHomeBinding2.scanBtn;
            k.a((Object) textView2, "viewBinding.scanBtn");
            textView2.getViewTreeObserver().removeOnGlobalLayoutListener(getScanButtonGlobalLayoutListener());
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        SingleEventLiveData<HomeParentActionModel> actionLiveData;
        k.c(view, "view");
        HomeUtils.d$default("onViewCreated called", false, 2, (Object) null);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            SFHomeVM sFHomeVM = this.viewModel;
            if (sFHomeVM == null) {
                k.a("viewModel");
            }
            sFHomeVM.setPrewarmResponseFetchInitiated(arguments.getBoolean(CLPConstants.IS_PREWARMING_INITIALISED));
        }
        SFHomeVM sFHomeVM2 = this.viewModel;
        if (sFHomeVM2 == null) {
            k.a("viewModel");
        }
        sFHomeVM2.getResponseLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$2(this));
        setActionImage();
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        RecyclerView recyclerView = fragmentHomeBinding.homeRv;
        k.a((Object) recyclerView, "viewBinding.homeRv");
        FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
        if (fragmentHomeBinding2 == null) {
            k.a("viewBinding");
        }
        RecyclerView recyclerView2 = fragmentHomeBinding2.homeRv;
        k.a((Object) recyclerView2, "viewBinding.homeRv");
        addGlobalLayoutListener(recyclerView, getLayoutListener(recyclerView2));
        SFHomeVM sFHomeVM3 = this.viewModel;
        if (sFHomeVM3 == null) {
            k.a("viewModel");
        }
        sFHomeVM3.setProgressVisibility(0);
        showHideNoNetworkLayout(false);
        SFHomeVM sFHomeVM4 = this.viewModel;
        if (sFHomeVM4 == null) {
            k.a("viewModel");
        }
        sFHomeVM4.getSanitizeModelLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$3(this));
        SharedHomeVM sharedHomeVM = this.sharedViewModel;
        if (!(sharedHomeVM == null || (actionLiveData = sharedHomeVM.getActionLiveData()) == null)) {
            actionLiveData.observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$4(this));
        }
        SFHomeVM sFHomeVM5 = this.viewModel;
        if (sFHomeVM5 == null) {
            k.a("viewModel");
        }
        sFHomeVM5.getActionLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$5(this));
        SFHomeVM sFHomeVM6 = this.viewModel;
        if (sFHomeVM6 == null) {
            k.a("viewModel");
        }
        sFHomeVM6.getCategoryActionLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$6(this));
        setupNoNetworkListener();
        SFHomeVM sFHomeVM7 = this.viewModel;
        if (sFHomeVM7 == null) {
            k.a("viewModel");
        }
        sFHomeVM7.getFloatinWidgetPresentLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$7(this));
        FragmentHomeBinding fragmentHomeBinding3 = this.viewBinding;
        if (fragmentHomeBinding3 == null) {
            k.a("viewBinding");
        }
        View view2 = fragmentHomeBinding3.commonToolbar;
        k.a((Object) view2, "viewBinding.commonToolbar");
        View.OnClickListener onClickListener = this;
        ((AppCompatImageView) view2.findViewById(R.id.ic_user_img)).setOnClickListener(onClickListener);
        FragmentHomeBinding fragmentHomeBinding4 = this.viewBinding;
        if (fragmentHomeBinding4 == null) {
            k.a("viewBinding");
        }
        View view3 = fragmentHomeBinding4.commonToolbar;
        k.a((Object) view3, "viewBinding.commonToolbar");
        ((AppCompatImageView) view3.findViewById(R.id.searchIcon)).setOnClickListener(onClickListener);
        FragmentHomeBinding fragmentHomeBinding5 = this.viewBinding;
        if (fragmentHomeBinding5 == null) {
            k.a("viewBinding");
        }
        View view4 = fragmentHomeBinding5.commonToolbar;
        k.a((Object) view4, "viewBinding.commonToolbar");
        ((AppCompatImageView) view4.findViewById(R.id.update_icon)).setOnClickListener(onClickListener);
        FragmentHomeBinding fragmentHomeBinding6 = this.viewBinding;
        if (fragmentHomeBinding6 == null) {
            k.a("viewBinding");
        }
        View view5 = fragmentHomeBinding6.commonToolbar;
        k.a((Object) view5, "viewBinding.commonToolbar");
        ((TextView) view5.findViewById(R.id.paytm_username)).setOnClickListener(onClickListener);
        FragmentHomeBinding fragmentHomeBinding7 = this.viewBinding;
        if (fragmentHomeBinding7 == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding7.homeRv.addOnScrollListener(new SFHomeFragment$onViewCreated$8(this));
        FragmentHomeBinding fragmentHomeBinding8 = this.viewBinding;
        if (fragmentHomeBinding8 == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding8.homeAppBar.a((AppBarLayout.b) new SFHomeFragment$onViewCreated$9(this));
        SFHomeVM sFHomeVM8 = this.viewModel;
        if (sFHomeVM8 == null) {
            k.a("viewModel");
        }
        sFHomeVM8.getFloatingNavLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$onViewCreated$10(this));
        HomeUtils.d$default("onViewCreated finished", false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showBottomNav(ViewGroup viewGroup) {
        new Handler().postDelayed(new SFHomeFragment$showBottomNav$1(this, viewGroup), 200);
    }

    /* access modifiers changed from: private */
    public final void hideView(View view) {
        logUtils("Hiding view " + view + "height = " + view.getMeasuredHeight());
        translateView(view, (float) (view.getMeasuredHeight() * 2), new AccelerateInterpolator(2.0f));
    }

    private final void translateView(View view, float f2, Interpolator interpolator) {
        view.animate().translationY(f2).setInterpolator(interpolator).start();
    }

    /* access modifiers changed from: private */
    public final void showView(View view) {
        logUtils("Showing view " + view + "height = " + view.getMeasuredHeight());
        translateView(view, 0.0f, new DecelerateInterpolator());
    }

    public final View getgestureView() {
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        RecyclerView recyclerView = fragmentHomeBinding.homeRv;
        k.a((Object) recyclerView, "viewBinding.homeRv");
        return recyclerView;
    }

    /* access modifiers changed from: private */
    public final void handleModelAction(IActionModel iActionModel) {
        SharedHomeVM sharedHomeVM;
        if (iActionModel instanceof HomeParentActionModel) {
            HomeParentActionModel homeParentActionModel = (HomeParentActionModel) iActionModel;
            if (homeParentActionModel.getActionType() == SharedHomeVM.UPDATE_CATEGORY_MAPS) {
                SharedHomeVM sharedHomeVM2 = this.sharedViewModel;
                if (sharedHomeVM2 != null) {
                    sharedHomeVM2.addCategoryUrlMap(homeParentActionModel);
                }
            } else if (homeParentActionModel.getActionType() == SharedHomeVM.UPDATE_NON_RV_WIDGETS) {
                SharedHomeVM sharedHomeVM3 = this.sharedViewModel;
                if (sharedHomeVM3 != null) {
                    sharedHomeVM3.updateWidgetDetails(homeParentActionModel);
                }
            } else if (homeParentActionModel.getActionType() == SFHomeVM.Companion.getACTION_DISABLE_GA()) {
                HomeUtils.d$default("Pulse disabled", false, 2, (Object) null);
                this.isPulseEventEnabled = false;
            } else if (homeParentActionModel.getActionType() == SFHomeVM.Companion.getACTION_ENABLE_GA()) {
                HomeUtils.d$default("Pulse Enabled", false, 2, (Object) null);
                this.isPulseEventEnabled = true;
            } else if (homeParentActionModel.getActionType() == SharedHomeVM.SCAN_CLICK && (sharedHomeVM = this.sharedViewModel) != null) {
                sharedHomeVM.openScanScreen(homeParentActionModel);
            }
        } else if (iActionModel instanceof HomeActionModel) {
            HomeActionModel homeActionModel = (HomeActionModel) iActionModel;
            if (homeActionModel.getActionType() == SFHomeVM.Companion.getSHOW_POPUP()) {
                handleShowPopup(homeActionModel);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateBottomNav(ViewGroup viewGroup, IWidgetProvider iWidgetProvider) {
        if (iWidgetProvider instanceof IWidgetProvider) {
            SFWidget widget = iWidgetProvider.getWidget(getActivity(), this.homeGAListener);
            if (widget instanceof IStaticWidget) {
                logUtils("FLoating Nav detected");
                IStaticWidget iStaticWidget = (IStaticWidget) widget;
                this.floatingWidget = iStaticWidget;
                viewGroup.removeAllViews();
                viewGroup.addView(iStaticWidget.getView());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void logUtils(String str) {
        LogUtils.d("FloatingNav", str);
    }

    private final void handleShowPopup(HomeActionModel homeActionModel) {
        SharedHomeVM sharedHomeVM;
        try {
            Object obj = homeActionModel.getActionData().get(CLPConstants.POPUP_WIDGET);
            if (obj != null) {
                IWidgetProvider iWidgetProvider = (IWidgetProvider) obj;
                if (isResumed() && iWidgetProvider.getWidgetType() == 101) {
                    SFWidget widget = iWidgetProvider.getWidget(getActivity(), (IGAHandlerListener) null);
                    if (widget != null) {
                        widget.showWidget(new HashMap());
                    }
                } else if (iWidgetProvider.getWidgetType() == 102 && (sharedHomeVM = this.sharedViewModel) != null) {
                    sharedHomeVM.addPopupProvider(new HomeParentActionModel(SharedHomeVM.SHOW_POPUP, homeActionModel.getActionData()));
                }
            } else {
                throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider");
            }
        } catch (Exception unused) {
        }
    }

    private final void setupNoNetworkListener() {
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        fragmentHomeBinding.noNetwork.a(new SFHomeFragment$setupNoNetworkListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void handleAction(HomeParentActionModel homeParentActionModel) {
        if (homeParentActionModel.getActionType() == SharedHomeVM.Companion.getSCROLL_TO_TOP()) {
            FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
            if (fragmentHomeBinding == null) {
                k.a("viewBinding");
            }
            RecyclerView recyclerView = fragmentHomeBinding.homeRv;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(0);
            }
        } else if (homeParentActionModel.getActionType() == SharedHomeVM.UPDATE_NOTIFICATION_ICON) {
            setNotificationIcon(homeParentActionModel.getActionData());
        } else if (homeParentActionModel.getActionType() == SharedHomeVM.GET_NAV_POSITION) {
            getFloatingNavPosition(homeParentActionModel);
        } else if (homeParentActionModel.getActionType() == SharedHomeVM.ANIMATE_FLOATING_NAV) {
            animateFloatingWidget(homeParentActionModel);
        } else if (homeParentActionModel.getActionType() == SharedHomeVM.Companion.getSETIMAGE()) {
            setActionImage();
        } else if (homeParentActionModel.getActionType() == SharedHomeVM.Companion.getUSER_GREETINGS()) {
            Object obj = homeParentActionModel.getActionData().get(CLPConstants.PROFILE_NAME);
            if (obj != null) {
                setUserThumbnail(getUserNameInitial((String) obj));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.String");
        }
    }

    private final void animateFloatingWidget(HomeParentActionModel homeParentActionModel) {
        IStaticWidget iStaticWidget;
        Object obj = homeParentActionModel.getActionData().get(CLPConstants.FLOATING_NAV_KEY);
        if ((obj instanceof String) && (iStaticWidget = this.floatingWidget) != null) {
            iStaticWidget.AnimateView((String) obj);
        }
    }

    private final void getFloatingNavPosition(HomeParentActionModel homeParentActionModel) {
        IStaticWidget iStaticWidget;
        SharedHomeVM sharedHomeVM;
        Object obj = homeParentActionModel.getActionData().get(CLPConstants.FLOATING_NAV_KEY);
        if ((obj instanceof String) && (iStaticWidget = this.floatingWidget) != null && (sharedHomeVM = this.sharedViewModel) != null) {
            Point viewPoint = iStaticWidget.getViewPoint((String) obj);
            k.a((Object) viewPoint, "it.getViewPoint(key)");
            sharedHomeVM.setAnimationPoint(viewPoint);
        }
    }

    private final void setNotificationIcon(Map<String, ? extends Object> map) {
        Object obj = map.get(CLPConstants.FLAG_NOTIFICATIONS_UNREAD_COUNT);
        if (obj == null || k.a((Object) obj, (Object) 0) || !com.paytm.utility.a.p(getContext())) {
            FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
            if (fragmentHomeBinding == null) {
                k.a("viewBinding");
            }
            View view = fragmentHomeBinding.commonToolbar;
            k.a((Object) view, "viewBinding.commonToolbar");
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.noti_count_circle);
            k.a((Object) appCompatTextView, "viewBinding.commonToolbar.noti_count_circle");
            appCompatTextView.setVisibility(8);
            return;
        }
        FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
        if (fragmentHomeBinding2 == null) {
            k.a("viewBinding");
        }
        View view2 = fragmentHomeBinding2.commonToolbar;
        k.a((Object) view2, "viewBinding.commonToolbar");
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view2.findViewById(R.id.noti_count_circle);
        k.a((Object) appCompatTextView2, "viewBinding.commonToolbar.noti_count_circle");
        appCompatTextView2.setVisibility(0);
        FragmentHomeBinding fragmentHomeBinding3 = this.viewBinding;
        if (fragmentHomeBinding3 == null) {
            k.a("viewBinding");
        }
        View view3 = fragmentHomeBinding3.commonToolbar;
        k.a((Object) view3, "viewBinding.commonToolbar");
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) view3.findViewById(R.id.noti_count_circle);
        k.a((Object) appCompatTextView3, "viewBinding.commonToolbar.noti_count_circle");
        appCompatTextView3.setText((!(obj instanceof Integer) || ((Number) obj).intValue() >= 100) ? CLPConstants.NOTIFICATION_OVERFLOW_TEXT : obj.toString());
    }

    /* access modifiers changed from: private */
    public final void handleSFResponse(Resource<List<com.paytmmall.clpartifact.modal.clpCommon.View>> resource) {
        HomeUtils.d$default("handleSFResponse called", false, 2, (Object) null);
        if ((resource != null ? resource.getStatus() : null) != Status.FAIL) {
            if ((resource != null ? resource.getStatus() : null) == Status.SUCCESS) {
                this.isCacheWorking = true;
                showHideNoNetworkLayout(false);
                SFHomeVM sFHomeVM = this.viewModel;
                if (sFHomeVM == null) {
                    k.a("viewModel");
                }
                sFHomeVM.setProgressVisibility(8);
                getAdapter().updateAdapter(resource.getData());
                setGradientValue(resource.getData());
                updateWidgets();
            }
        } else if (resource.getRequestType() == RequestType.REFRESH && !this.isCacheWorking) {
            showHideNoNetworkLayout(true);
        }
        HomeUtils.d$default("handleSFResponse finished", false, 2, (Object) null);
    }

    private final void updateWidgets() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            Intent intent = new Intent(activity.getApplicationContext(), SingleServiceWidgetProvider.class);
            intent.setAction(WidgetUtils.INSTANCE.getACTION_UPDATE_SINGLE_SERVICE_WIDGET());
            activity.sendBroadcast(intent);
            Intent intent2 = new Intent(activity.getApplicationContext(), PayGridWidgetProvider.class);
            intent2.setAction(WidgetUtils.INSTANCE.getACTION_UPDATE_MULTI_SERVICE_WIDGET());
            activity.sendBroadcast(intent2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setGradientValue(java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x006b
            java.util.List r5 = java.util.Collections.synchronizedList(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x000a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r5.next()
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = (com.paytmmall.clpartifact.modal.clpCommon.View) r0
            java.lang.String r1 = "item"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r0.getType()
            r2 = 0
            java.lang.String r3 = "smart-icon-header-v2"
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x000a
            com.paytmmall.clpartifact.modal.clpCommon.MetaLayout r5 = r0.getmMetaLayout()
            if (r5 == 0) goto L_0x006b
            java.lang.String[] r0 = r5.getMBgGradient()
            r1 = 1
            if (r0 == 0) goto L_0x0041
            int r0 = r0.length
            if (r0 != 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r0 = 0
            goto L_0x0042
        L_0x0041:
            r0 = 1
        L_0x0042:
            if (r0 != 0) goto L_0x0066
            java.lang.String[] r0 = r5.getMBgGradient()
            int r0 = r0.length
            if (r0 <= r1) goto L_0x0066
            java.lang.String[] r0 = r5.getMBgGradient()
            r0 = r0[r2]
            java.lang.String[] r5 = r5.getMBgGradient()
            r5 = r5[r1]
            java.lang.String r1 = "startColor"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "endColor"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            r4.setGradientOnHeader(r0, r5)
            return
        L_0x0066:
            java.lang.String r5 = "#FFFFFF"
            r4.setGradientOnHeader(r5, r5)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.fragment.SFHomeFragment.setGradientValue(java.util.List):void");
    }

    private final void setGradientOnHeader(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(str), Color.parseColor(str2)});
        gradientDrawable.setCornerRadius(0.0f);
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        View view = fragmentHomeBinding.commonToolbar;
        k.a((Object) view, "viewBinding.commonToolbar");
        view.setBackground(gradientDrawable);
    }

    private final void showErrorDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            b.b((Context) activity, activity.getResources().getString(R.string.sf_no_network_heading), activity.getResources().getString(R.string.sf_network_error_message));
        }
    }

    /* access modifiers changed from: private */
    public final void refreshPage() {
        if (com.paytm.utility.a.m(getContext())) {
            SFHomeVM sFHomeVM = this.viewModel;
            if (sFHomeVM == null) {
                k.a("viewModel");
            }
            sFHomeVM.refreshHome();
            return;
        }
        showErrorDialog();
        showHideNoNetworkLayout(true);
    }

    private final void showHideNoNetworkLayout(boolean z) {
        int i2 = z ? 0 : 8;
        SFHomeVM sFHomeVM = this.viewModel;
        if (sFHomeVM == null) {
            k.a("viewModel");
        }
        sFHomeVM.setNoNetworkVisibility(i2);
        View view = this.noNetworkLayout;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    /* access modifiers changed from: private */
    public final void sendGAforAppLaunch() {
        ICLPCommunicationListener communicationListener;
        ICLPCommunicationListener communicationListener2;
        Context context = getContext();
        if (context != null) {
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("event_category", "app_open");
            map.put("event_action", "" + CLPConstants.NETWORK + com.paytm.utility.a.l(context) + ";" + "root_status=false");
            map.put("event_label", "" + CLPConstants.NETWORK_RPOVIDER + com.paytm.utility.a.s(context) + ";" + CLPConstants.CURRENT_LANGUAGE + com.paytm.utility.a.j(context));
            map.put(CLPConstants.NETWORK, com.paytm.utility.a.l(context));
            map.put(CLPConstants.ROOT_STATUS, Boolean.FALSE);
            map.put(CLPConstants.NETWORK_RPOVIDER, com.paytm.utility.a.s(context));
            map.put(CLPConstants.CURRENT_LANGUAGE, com.paytm.utility.a.j(context));
            map.put("vertical_name", "app_open");
            map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "sessional event");
            CLPArtifact instance = CLPArtifact.getInstance();
            if (!(instance == null || (communicationListener2 = instance.getCommunicationListener()) == null)) {
                communicationListener2.sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
            }
            CLPArtifact instance2 = CLPArtifact.getInstance();
            if (instance2 != null && (communicationListener = instance2.getCommunicationListener()) != null) {
                communicationListener.sendOpenScreenWithDeviceInfo("/", "homescreen", context);
            }
        }
    }

    private final void addGlobalLayoutListener(RecyclerView recyclerView, RVLayoutListener rVLayoutListener) {
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(rVLayoutListener);
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
            if (fragmentHomeBinding == null) {
                k.a("viewBinding");
            }
            View view2 = fragmentHomeBinding.commonToolbar;
            k.a((Object) view2, "viewBinding.commonToolbar");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view2.findViewById(R.id.searchIcon);
            k.a((Object) appCompatImageView, "viewBinding.commonToolbar.searchIcon");
            LiveData<HomeParentActionModel> liveData = null;
            if (id == appCompatImageView.getId()) {
                this.searchMap.put("action", CLPConstants.ACTION_SEARCH_CLICKED);
                SharedHomeVM sharedHomeVM = this.sharedViewModel;
                if (sharedHomeVM != null) {
                    liveData = sharedHomeVM.getParentActionLiveData();
                }
                if (liveData != null) {
                    ((androidx.lifecycle.y) liveData).setValue(new HomeParentActionModel(SharedHomeVM.SEARCH_SCREEN, this.searchMap));
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
            }
            FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
            if (fragmentHomeBinding2 == null) {
                k.a("viewBinding");
            }
            View view3 = fragmentHomeBinding2.commonToolbar;
            k.a((Object) view3, "viewBinding.commonToolbar");
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view3.findViewById(R.id.update_icon);
            k.a((Object) appCompatImageView2, "viewBinding.commonToolbar.update_icon");
            if (id == appCompatImageView2.getId()) {
                SharedHomeVM sharedHomeVM2 = this.sharedViewModel;
                if (sharedHomeVM2 != null) {
                    liveData = sharedHomeVM2.getParentActionLiveData();
                }
                if (liveData != null) {
                    ((androidx.lifecycle.y) liveData).setValue(new HomeParentActionModel(SharedHomeVM.UPDATE_SCREEN, new HashMap()));
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
            }
            FragmentHomeBinding fragmentHomeBinding3 = this.viewBinding;
            if (fragmentHomeBinding3 == null) {
                k.a("viewBinding");
            }
            View view4 = fragmentHomeBinding3.commonToolbar;
            k.a((Object) view4, "viewBinding.commonToolbar");
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) view4.findViewById(R.id.ic_user_img);
            k.a((Object) appCompatImageView3, "viewBinding.commonToolbar.ic_user_img");
            if (id != appCompatImageView3.getId()) {
                FragmentHomeBinding fragmentHomeBinding4 = this.viewBinding;
                if (fragmentHomeBinding4 == null) {
                    k.a("viewBinding");
                }
                View view5 = fragmentHomeBinding4.commonToolbar;
                k.a((Object) view5, "viewBinding.commonToolbar");
                TextView textView = (TextView) view5.findViewById(R.id.paytm_username);
                k.a((Object) textView, "viewBinding.commonToolbar.paytm_username");
                if (id != textView.getId()) {
                    return;
                }
            }
            SharedHomeVM sharedHomeVM3 = this.sharedViewModel;
            if (sharedHomeVM3 != null) {
                liveData = sharedHomeVM3.getParentActionLiveData();
            }
            if (liveData != null) {
                ((androidx.lifecycle.y) liveData).setValue(new HomeParentActionModel(SharedHomeVM.OPEN_LEFT, new HashMap()));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>");
        }
    }

    private final String getUserNameInitial(String str) {
        if (TextUtils.isEmpty(str)) {
            Context context = getContext();
            str = b.aa(context != null ? context.getApplicationContext() : null);
            if (str == null) {
                str = "";
            }
        }
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        List<String> b2 = p.a(charSequence, new String[]{" "});
        if (!b2.isEmpty()) {
            int i2 = 0;
            for (String str2 : b2) {
                if (!(str2.length() == 0)) {
                    if (i2 >= 2) {
                        break;
                    }
                    sb.append(str2.charAt(0));
                    i2++;
                }
            }
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "initials.toString()");
        return sb2;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [androidx.lifecycle.LiveData] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setActionImage() {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            android.content.Context r0 = r0.getApplicationContext()
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            boolean r0 = com.paytm.utility.a.p(r0)
            if (r0 != 0) goto L_0x0017
            r5.setDefaultImage()
            return
        L_0x0017:
            android.content.Context r0 = r5.getContext()
            if (r0 == 0) goto L_0x0022
            android.content.Context r0 = r0.getApplicationContext()
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.lang.String r0 = com.paytm.utility.a.x(r0)
            if (r0 == 0) goto L_0x00ae
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            r3 = 1
            if (r2 != 0) goto L_0x0035
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = 0
        L_0x0036:
            if (r2 != 0) goto L_0x00ae
            com.paytmmall.clpartifact.databinding.FragmentHomeBinding r2 = r5.viewBinding
            if (r2 != 0) goto L_0x0042
            java.lang.String r4 = "viewBinding"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0042:
            android.view.View r2 = r2.commonToolbar
            java.lang.String r4 = "viewBinding.commonToolbar"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r4 = com.paytmmall.clpartifact.R.id.ic_user_name_img
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r4 = "viewBinding.commonToolbar.ic_user_name_img"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            r4 = 8
            r2.setVisibility(r4)
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            java.lang.String r4 = "mounted"
            boolean r2 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r3)
            if (r2 == 0) goto L_0x00cb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            android.content.Context r3 = r5.getContext()
            if (r3 == 0) goto L_0x0084
            android.content.Context r3 = r3.getApplicationContext()
            goto L_0x0085
        L_0x0084:
            r3 = r1
        L_0x0085:
            java.lang.String r3 = com.paytm.utility.a.y(r3)
            r2.append(r3)
            java.lang.String r3 = r5.USER_PROFILE_PIC_FILENAME
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.paytmmall.clpartifact.utils.HomeUtils r3 = com.paytmmall.clpartifact.utils.HomeUtils.INSTANCE
            android.content.Context r4 = r5.getContext()
            if (r4 == 0) goto L_0x00a1
            android.content.Context r1 = r4.getApplicationContext()
        L_0x00a1:
            if (r1 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            android.graphics.Bitmap r1 = r3.decodeSampledBitmapFromResource(r2, r1)
            r5.setUserImageOnHeader(r0, r1)
            return
        L_0x00ae:
            com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM r0 = r5.sharedViewModel
            if (r0 == 0) goto L_0x00b6
            androidx.lifecycle.LiveData r1 = r0.getParentActionLiveData()
        L_0x00b6:
            if (r1 == 0) goto L_0x00cc
            androidx.lifecycle.y r1 = (androidx.lifecycle.y) r1
            com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel r0 = new com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel
            int r2 = com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM.SET_NAME
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r3 = (java.util.Map) r3
            r0.<init>(r2, r3)
            r1.setValue(r0)
        L_0x00cb:
            return
        L_0x00cc:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel>"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.fragment.SFHomeFragment.setActionImage():void");
    }

    private final void setUserThumbnail(String str) {
        CharSequence charSequence = str;
        if (!(charSequence.length() == 0)) {
            FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
            if (fragmentHomeBinding == null) {
                k.a("viewBinding");
            }
            View view = fragmentHomeBinding.commonToolbar;
            k.a((Object) view, "viewBinding.commonToolbar");
            TextView textView = (TextView) view.findViewById(R.id.ic_user_name_img);
            k.a((Object) textView, "viewBinding.commonToolbar.ic_user_name_img");
            textView.setVisibility(0);
            FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
            if (fragmentHomeBinding2 == null) {
                k.a("viewBinding");
            }
            View view2 = fragmentHomeBinding2.commonToolbar;
            k.a((Object) view2, "viewBinding.commonToolbar");
            TextView textView2 = (TextView) view2.findViewById(R.id.ic_user_name_img);
            k.a((Object) textView2, "viewBinding.commonToolbar.ic_user_name_img");
            textView2.setText(charSequence);
            return;
        }
        setDefaultImage();
    }

    private final void setUserImageOnHeader(String str, Bitmap bitmap) {
        try {
            Context context = getContext();
            if (!com.paytm.utility.a.z(context != null ? context.getApplicationContext() : null) || bitmap == null) {
                b.a aVar = com.paytm.utility.b.b.f43744a;
                Context context2 = getContext();
                Context applicationContext = context2 != null ? context2.getApplicationContext() : null;
                if (applicationContext == null) {
                    k.a();
                }
                b.a.C0750a a2 = b.a.a(applicationContext);
                a2.f43753a = str;
                b.a.C0750a a3 = a2.a((Object) Integer.valueOf(R.drawable.sf_home_profile_default));
                a3.n = true;
                FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
                if (fragmentHomeBinding == null) {
                    k.a("viewBinding");
                }
                View view = fragmentHomeBinding.commonToolbar;
                k.a((Object) view, "viewBinding.commonToolbar");
                b.a.C0750a.a(a3, (AppCompatImageView) view.findViewById(R.id.ic_user_img), (com.paytm.utility.b.b.b) null, 2);
                return;
            }
            b.a aVar2 = com.paytm.utility.b.b.f43744a;
            Context context3 = getContext();
            Context applicationContext2 = context3 != null ? context3.getApplicationContext() : null;
            if (applicationContext2 == null) {
                k.a();
            }
            b.a.C0750a a4 = b.a.a(applicationContext2);
            a4.f43753a = bitmap;
            a4.n = true;
            FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
            if (fragmentHomeBinding2 == null) {
                k.a("viewBinding");
            }
            View view2 = fragmentHomeBinding2.commonToolbar;
            k.a((Object) view2, "viewBinding.commonToolbar");
            b.a.C0750a.a(a4, (AppCompatImageView) view2.findViewById(R.id.ic_user_img), (com.paytm.utility.b.b.b) null, 2);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private final void setDefaultImage() {
        FragmentHomeBinding fragmentHomeBinding = this.viewBinding;
        if (fragmentHomeBinding == null) {
            k.a("viewBinding");
        }
        View view = fragmentHomeBinding.commonToolbar;
        k.a((Object) view, "viewBinding.commonToolbar");
        TextView textView = (TextView) view.findViewById(R.id.ic_user_name_img);
        k.a((Object) textView, "viewBinding.commonToolbar.ic_user_name_img");
        textView.setVisibility(8);
        b.a aVar = com.paytm.utility.b.b.f43744a;
        Context context = getContext();
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext == null) {
            k.a();
        }
        b.a.C0750a a2 = b.a.a(applicationContext);
        a2.f43753a = Integer.valueOf(R.drawable.sf_home_profile_default);
        FragmentHomeBinding fragmentHomeBinding2 = this.viewBinding;
        if (fragmentHomeBinding2 == null) {
            k.a("viewBinding");
        }
        View view2 = fragmentHomeBinding2.commonToolbar;
        k.a((Object) view2, "viewBinding.commonToolbar");
        b.a.C0750a.a(a2, (AppCompatImageView) view2.findViewById(R.id.ic_user_img), (com.paytm.utility.b.b.b) null, 2);
    }

    public final void onResume() {
        super.onResume();
        fireHomeLaunchGA();
    }

    private final void fireHomeLaunchGA() {
        getActivity();
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        instance.getCommunicationListener().sendCustomGTMEvents(getContext(), getString(R.string.verticalCategory), getString(R.string.home_screen_loaded), (String) null, "/", "", getString(R.string.verticalId));
    }

    /* access modifiers changed from: protected */
    public final void runHomeSettle() {
        super.runHomeSettle();
        HomeUtils.INSTANCE.getForceRefreshLiveData().observe(getViewLifecycleOwner(), new SFHomeFragment$runHomeSettle$1(this));
    }
}

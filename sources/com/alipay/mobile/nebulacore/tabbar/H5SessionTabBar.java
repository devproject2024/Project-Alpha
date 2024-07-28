package com.alipay.mobile.nebulacore.tabbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5TabbarItem;
import com.alipay.mobile.nebula.view.H5TabbarLayout;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackagePool;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabInfoParser;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import com.alipay.mobile.nebulacore.ui.H5FragmentManager;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5SessionTabBar extends H5BaseTabBar {
    private static final String SET_TABBAR = "setTabBar";
    private static final int SPACE_TIME = 500;
    private static final String SWITCH_TAB = "switchTab";
    private static final String TABANIM_DURATION = "tabanimduration";
    private static final String TABANIM_STARTOFF = "tabanimstartoff";
    private boolean enableAutoRender = true;
    /* access modifiers changed from: private */
    public boolean enableTabbarClick = true;
    private boolean enableWaitRender = true;
    /* access modifiers changed from: private */
    public H5SessionImpl h5Session;
    private boolean hasShowTab = false;
    private SparseArray<String> index2Tag = new SparseArray<>(4);
    private long lastClickTime = 0;
    private RelativeLayout sessionTabContainer;
    private SparseArray<Bundle> tabDatas = new SparseArray<>(4);

    public void setPageViewHolder(H5ViewHolder h5ViewHolder) {
    }

    public H5SessionTabBar(H5SessionImpl h5SessionImpl) {
        this.h5Session = h5SessionImpl;
    }

    private void initConfig() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_tabBarOptimizeConfig"));
        this.enableAutoRender = TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(parseObject, "enableAutoRender", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        this.enableWaitRender = TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(parseObject, "enableWaitRender", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        H5Log.d(H5BaseTabBar.TAG, "enableAutoRender " + this.enableAutoRender + ", enableWaitRender " + this.enableWaitRender);
    }

    public void addTabBar() {
        if (this.context.get() instanceof H5Activity) {
            this.sessionTabContainer = (RelativeLayout) ((H5Activity) this.context.get()).getSessionTabContainer();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.sessionTabContainer.removeAllViews();
            this.sessionTabContainer.addView(getContent(), layoutParams);
            return;
        }
        H5Log.w(H5BaseTabBar.TAG, "not in h5activity");
    }

    private void inflateTabData(int i2, e eVar, Bundle bundle) {
        if (eVar != null && !eVar.isEmpty()) {
            String string = H5Utils.getString(eVar, "url");
            e jSONObject = H5Utils.getJSONObject(eVar, H5Param.LAUNCHER_PARAM, (e) null);
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            bundle2.putAll(H5Utils.toBundle(jSONObject));
            String string2 = H5Utils.getString(eVar, H5StartParamManager.launchParamsTag);
            Bundle h5StartParam = H5StartParamManager.getInstance().getH5StartParam(H5Utils.getString(bundle, "appId"), string2);
            if (h5StartParam != null && !h5StartParam.isEmpty()) {
                H5Log.d(H5BaseTabBar.TAG, "launchParamsTag ".concat(String.valueOf(h5StartParam)));
                bundle2.putAll(h5StartParam);
            }
            bundle2.putString("url", string);
            bundle2.putInt(TABANIM_STARTOFF, H5Utils.getInt(eVar, H5Param.WAIT_RENDER));
            bundle2.putInt(TABANIM_DURATION, H5Utils.getInt(eVar, "transDuration"));
            this.tabDatas.put(i2, bundle2);
            this.index2Tag.put(i2, H5Utils.getString(eVar, "tag"));
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(SWITCH_TAB);
        h5EventFilter.addAction(SET_TABBAR);
    }

    public void onRelease() {
        super.onRelease();
        this.sessionTabContainer = null;
        this.pageViewHolder = null;
        this.tabHost = null;
        this.tabBarView = null;
        SparseArray<Bundle> sparseArray = this.tabDatas;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        SparseArray<String> sparseArray2 = this.index2Tag;
        if (sparseArray2 != null) {
            sparseArray2.clear();
        }
    }

    public boolean handleEvent(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        H5SessionImpl h5SessionImpl;
        String action = h5Event.getAction();
        if (SWITCH_TAB.equals(action)) {
            this.enableTabbarClick = true;
            e param = h5Event.getParam();
            final String string = H5Utils.getString(param, "tag");
            if (!H5Utils.getBoolean(param, "recreate", false) || !enableReCreateTabBar() || (h5SessionImpl = this.h5Session) == null || h5SessionImpl.getH5SessionTabManager() == null) {
                performSwitchTab(h5Event, h5BridgeContext, string);
                return true;
            }
            H5Log.d(H5BaseTabBar.TAG, "tabBar recreate");
            this.h5Session.getH5SessionTabManager().clearTabFragments();
            this.hasShowTab = false;
            Iterator it2 = this.h5Session.getPages().iterator();
            while (it2.hasNext()) {
                H5Page h5Page = (H5Page) it2.next();
                if (!(h5Page == null || h5Page.getParams() == null)) {
                    Bundle params = h5Page.getParams();
                    if (TextUtils.equals(H5Utils.getString(params, H5Fragment.fragmentType, "normal"), H5Fragment.subtab) && !H5Utils.getBoolean(param, H5Param.LONG_ISPRERENDER, false)) {
                        h5Page.sendExitEvent();
                        params.putString(H5Fragment.fragmentType, "normal");
                    }
                }
            }
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5SessionTabBar.this.performSwitchTab(h5Event, h5BridgeContext, string);
                }
            }, 500);
            return true;
        } else if (!SET_TABBAR.equals(action)) {
            return super.handleEvent(h5Event, h5BridgeContext);
        } else {
            e param2 = h5Event.getParam();
            String string2 = H5Utils.getString(param2, "actionType");
            if (TextUtils.equals(string2, "redDot")) {
                createTabBadge(param2, (H5BridgeContext) null);
            }
            if (TextUtils.equals(string2, "enable")) {
                this.enableTabbarClick = true;
            }
            if (TextUtils.equals(string2, "disable")) {
                this.enableTabbarClick = false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void performSwitchTab(H5Event h5Event, H5BridgeContext h5BridgeContext, String str) {
        if (this.h5Session.getH5SessionTabManager() == null || this.h5Session.getH5SessionTabManager().getCurrentIndex() != -1) {
            switchTab(h5Event, h5Event.getActivity(), h5BridgeContext);
            return;
        }
        final H5Page h5Page = (H5Page) h5Event.getTarget();
        if (h5Page != null) {
            Bundle params = h5Page.getParams();
            String string = H5Utils.getString(params, "tabBarJson");
            if (!TextUtils.isEmpty(string)) {
                final H5Event h5Event2 = h5Event;
                final String str2 = str;
                final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
                H5SessionTabInfoParser.getOnlineData(string, new H5SessionTabInfoParser.H5SessionTabInfoListener() {
                    public void onGetSyncData(e eVar) {
                    }

                    public void onGetAsyncData(e eVar) {
                        H5SessionTabBar.this.beginShowTab(eVar, h5Event2, str2, h5BridgeContext2);
                    }

                    public void onShowDefaultTab() {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                if (h5Page != null) {
                                    e eVar = new e();
                                    eVar.put("delay", (Object) "0");
                                    h5Page.sendEvent("showLoading", eVar);
                                }
                            }
                        });
                    }
                }, H5Utils.getString(params, "appId"));
                return;
            }
            final H5Event h5Event3 = h5Event;
            final String str3 = str;
            final H5BridgeContext h5BridgeContext3 = h5BridgeContext;
            H5SessionTabInfoParser.getOfflineData(this.h5Session, new H5SessionTabInfoParser.H5SessionTabInfoListener() {
                public void onGetSyncData(e eVar) {
                    H5SessionTabBar.this.beginShowTab(eVar, h5Event3, str3, h5BridgeContext3);
                }

                public void onGetAsyncData(e eVar) {
                    H5SessionTabBar.this.beginShowTab(eVar, h5Event3, str3, h5BridgeContext3);
                }

                public void onShowDefaultTab() {
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            if (h5Page != null) {
                                e eVar = new e();
                                eVar.put("delay", (Object) "0");
                                h5Page.sendEvent("showLoading", eVar);
                            }
                        }
                    });
                }
            }, H5Utils.getString(params, "appId"));
        }
    }

    /* access modifiers changed from: private */
    public void beginShowTab(e eVar, H5Event h5Event, String str, H5BridgeContext h5BridgeContext) {
        if (!this.hasShowTab) {
            this.hasShowTab = true;
            final H5Event h5Event2 = h5Event;
            final e eVar2 = eVar;
            final String str2 = str;
            final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5Page h5Page = (H5Page) h5Event2.getTarget();
                    if (h5Page != null) {
                        h5Page.sendEvent(H5Plugin.CommonEvents.HIDE_LOADING, (e) null);
                        e eVar = eVar2;
                        if (eVar == null) {
                            e eVar2 = new e();
                            eVar2.put("error", (Object) 10);
                            eVar2.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) "invalid config");
                            h5BridgeContext2.sendBridgeResult(eVar2);
                        } else if (!H5SessionTabBar.this.createSessionTabInternal(eVar, h5Event2.getActivity(), h5Page.getParams(), true, str2)) {
                            h5BridgeContext2.sendError(h5Event2, H5Event.Error.INVALID_PARAM);
                        }
                    }
                }
            });
        }
    }

    public boolean createSessionTab(e eVar, Activity activity, Bundle bundle) {
        return createSessionTabInternal(eVar, activity, bundle, false, "default");
    }

    /* access modifiers changed from: private */
    public boolean createSessionTabInternal(e eVar, Activity activity, Bundle bundle, boolean z, String str) {
        int i2;
        e eVar2 = eVar;
        Bundle bundle2 = bundle;
        if (this.h5Session.getH5SessionTabManager() == null) {
            return false;
        }
        this.context = new WeakReference(activity);
        if (!(this.context.get() instanceof H5Activity)) {
            return true;
        }
        if (bundle2 != null) {
            String string = H5Utils.getString(bundle2, "url");
            String string2 = H5Utils.getString(bundle2, "appId");
            boolean z2 = H5Utils.getBoolean(eVar2, "disableOnInit", false);
            H5Log.d(H5BaseTabBar.TAG, "disableOnInit ".concat(String.valueOf(z2)));
            if (z2 && !z) {
                this.enableTabbarClick = false;
            }
            b jSONArray = H5Utils.getJSONArray(eVar2, "items", (b) null);
            int ifUrlMatch = H5TabbarUtils.ifUrlMatch(string2, string, bundle2);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                int size = jSONArray.size();
                int i3 = 0;
                while (i3 < size && i3 < 5) {
                    e jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null && !jSONObject.isEmpty()) {
                        jSONObject.put("url", (Object) H5TabbarUtils.getAbsoluteUrl(jSONObject.getString("url"), bundle2));
                        String string3 = jSONObject.getString(H5Param.MENU_ICON);
                        String string4 = jSONObject.getString("activeIcon");
                        try {
                            if (H5ImageUtil.base64ToBitmap(string3) == null) {
                                jSONObject.put(H5Param.MENU_ICON, (Object) H5TabbarUtils.getAbsoluteUrl(string3, bundle2));
                            }
                        } catch (Throwable unused) {
                            jSONObject.put(H5Param.MENU_ICON, (Object) H5TabbarUtils.getAbsoluteUrl(string3, bundle2));
                        }
                        try {
                            if (H5ImageUtil.base64ToBitmap(string4) == null) {
                                jSONObject.put("activeIcon", (Object) H5TabbarUtils.getAbsoluteUrl(string4, bundle2));
                            }
                        } catch (Throwable unused2) {
                            jSONObject.put("activeIcon", (Object) H5TabbarUtils.getAbsoluteUrl(string4, bundle2));
                        }
                        inflateTabData(i3, jSONObject, bundle2);
                    }
                    i3++;
                }
            }
            i2 = z ? getindexByTag(str) : ifUrlMatch;
            H5Log.d(H5BaseTabBar.TAG, "selectedIndex ".concat(String.valueOf(i2)));
            if (i2 == -1) {
                return false;
            }
        } else {
            i2 = -1;
        }
        eVar2.put("selectedIndex", (Object) Integer.valueOf(i2));
        super.createTabBar(eVar2, (H5BridgeContext) null, bundle2);
        final H5FragmentManager h5FragmentManager = ((H5Activity) this.context.get()).getH5FragmentManager();
        Bundle bundle3 = this.tabDatas.get(i2);
        bundle3.putString(H5Fragment.fragmentType, H5Fragment.subtab);
        h5FragmentManager.addFragment(bundle3, false, false);
        this.h5Session.getH5SessionTabManager().addTabFragment(i2, (H5Fragment) h5FragmentManager.peekFragment());
        this.h5Session.getH5SessionTabManager().setCurrentIndex(i2);
        final String string5 = H5Utils.getString(bundle3, H5Param.SESSION_ID);
        H5Log.d(H5BaseTabBar.TAG, "finalSessionId is ".concat(String.valueOf(string5)));
        String string6 = H5Utils.getString(eVar2, "autoPreRender");
        boolean z3 = H5Utils.getBoolean(bundle2, H5Param.isTinyApp, false);
        initConfig();
        H5Log.d(H5BaseTabBar.TAG, "autoPreRender " + string6 + ", isTinyApp " + z3 + ", enableAutoRender " + this.enableAutoRender);
        if (TextUtils.equals(string6, H5Param.DEFAULT_LONG_PRESSO_LOGIN) && !z3 && this.enableAutoRender) {
            int size2 = this.tabDatas.size();
            for (int i4 = 0; i4 < size2; i4++) {
                int keyAt = this.tabDatas.keyAt(i4);
                if (keyAt != i2) {
                    H5Log.d(H5BaseTabBar.TAG, "##h5prerender## add prerender in sessiontabbar");
                    Bundle bundle4 = (Bundle) this.tabDatas.get(keyAt).clone();
                    bundle4.putBoolean(H5Param.LONG_ISPRERENDER, true);
                    bundle4.putString(H5Fragment.fragmentType, H5Fragment.subtab);
                    h5FragmentManager.addPreFragment(bundle4, 0);
                }
            }
        }
        this.tabHost.setTabListener(new H5TabbarLayout.H5TabListener() {
            public void onTabItemClicked(int i2, View view) {
                H5Page h5Page;
                H5Bridge bridge;
                if (H5SessionTabBar.this.tabHost != null && H5SessionTabBar.this.enableTabbarClick && !H5SessionTabBar.this.isFastClick()) {
                    String str = (String) view.getTag();
                    H5Fragment currentFragment = H5SessionTabBar.this.h5Session.getH5SessionTabManager().getCurrentFragment();
                    if (currentFragment != null && (h5Page = currentFragment.getH5Page()) != null && (bridge = h5Page.getBridge()) != null) {
                        e eVar = new e();
                        eVar.put("tag", (Object) str);
                        e eVar2 = new e();
                        eVar2.put("data", (Object) eVar);
                        H5Log.d(H5BaseTabBar.TAG, "tabClick :".concat(String.valueOf(eVar2)));
                        bridge.sendToWeb("tabClick", eVar2, (H5CallBack) null);
                        H5SessionTabBar.this.onTabClickInternal(i2, h5FragmentManager, string5);
                    }
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public void onTabClickInternal(int i2, H5FragmentManager h5FragmentManager, String str) {
        this.h5Session.getH5SessionTabManager().setCurrentIndex(i2);
        this.tabHost.selectTab(i2);
        H5Fragment tabFragmentByIndex = this.h5Session.getH5SessionTabManager().getTabFragmentByIndex(i2);
        if (tabFragmentByIndex == null) {
            Bundle bundle = this.tabDatas.get(i2);
            bundle.putString(H5Param.SESSION_ID, str);
            bundle.putString(H5Fragment.fragmentType, H5Fragment.subtab);
            if (h5FragmentManager != null) {
                boolean needWithAnim = needWithAnim(bundle);
                h5FragmentManager.addFragment(bundle, needWithAnim, false);
                H5Fragment h5Fragment = (H5Fragment) h5FragmentManager.peekFragment();
                this.h5Session.getH5SessionTabManager().addTabFragment(i2, h5Fragment);
                H5Log.d(H5BaseTabBar.TAG, "add new sub fragment index " + i2 + ", obj " + h5Fragment + ", withAnim " + needWithAnim);
            }
        } else if (h5FragmentManager != null) {
            h5FragmentManager.attachFragment(tabFragmentByIndex, false, false);
            H5Log.d(H5BaseTabBar.TAG, "reuse sub fragment index " + i2 + ", obj " + tabFragmentByIndex);
        }
        detachOtherFragment(i2, h5FragmentManager);
    }

    private boolean needWithAnim(Bundle bundle) {
        initConfig();
        return !(H5Utils.getInt(bundle, TABANIM_STARTOFF) == 0 && H5Utils.getInt(bundle, TABANIM_DURATION) == 0) && this.enableWaitRender;
    }

    public void switchTab(H5Event h5Event, Activity activity, H5BridgeContext h5BridgeContext) {
        if (activity == null) {
            H5Log.d(H5BaseTabBar.TAG, "activity == null");
            return;
        }
        H5Activity h5Activity = (H5Activity) activity;
        if (h5Activity.getSessionTabContainer() != null) {
            int i2 = getindexByTag(H5Utils.getString(h5Event.getParam(), "tag"));
            if (i2 != -1) {
                String id = Nebula.getService().getTopSession().getId();
                H5FragmentManager h5FragmentManager = h5Activity.getH5FragmentManager();
                H5Fragment tabFragmentByIndex = this.h5Session.getH5SessionTabManager().getTabFragmentByIndex(i2);
                this.h5Session.getH5SessionTabManager().setCurrentIndex(i2);
                this.tabHost.selectTab(i2);
                if (tabFragmentByIndex == null) {
                    Bundle bundle = this.tabDatas.get(i2);
                    bundle.putString(H5Param.SESSION_ID, id);
                    bundle.putString(H5Fragment.fragmentType, H5Fragment.subtab);
                    if (h5FragmentManager != null) {
                        boolean needWithAnim = needWithAnim(bundle);
                        h5FragmentManager.addFragment(bundle, needWithAnim, false);
                        H5Fragment h5Fragment = (H5Fragment) h5FragmentManager.peekFragment();
                        this.h5Session.getH5SessionTabManager().addTabFragment(i2, h5Fragment);
                        H5Log.d(H5BaseTabBar.TAG, "add new sub fragment index " + i2 + ", obj " + h5Fragment + ", withAnim " + needWithAnim);
                    }
                } else if (h5FragmentManager != null) {
                    h5FragmentManager.attachFragment(tabFragmentByIndex, false, false);
                    H5Log.d(H5BaseTabBar.TAG, "reuse sub fragment index " + i2 + ", obj " + tabFragmentByIndex);
                }
                detachOtherFragment(i2, h5FragmentManager);
                return;
            }
            H5Log.d(H5BaseTabBar.TAG, "invalid tag name");
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
        }
    }

    private void detachOtherFragment(int i2, H5FragmentManager h5FragmentManager) {
        Map<Integer, H5Fragment> tabFragments = this.h5Session.getH5SessionTabManager().getTabFragments();
        for (Integer next : tabFragments.keySet()) {
            if (!(next.intValue() == i2 || h5FragmentManager == null)) {
                H5Log.d(H5BaseTabBar.TAG, "detachOtherFragment index ".concat(String.valueOf(next)));
                h5FragmentManager.detachFragment(tabFragments.get(next), false);
            }
        }
    }

    private int getindexByTag(String str) {
        int size = this.index2Tag.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.index2Tag.keyAt(i2);
            if (TextUtils.equals(this.index2Tag.get(keyAt), str)) {
                return keyAt;
            }
        }
        return -1;
    }

    public void createDefaultSessionTab(Context context, int i2) {
        if (i2 >= 2) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            H5TabbarLayout h5TabbarLayout = new H5TabbarLayout(context);
            int i3 = 0;
            while (i3 < i2 && i3 < 5) {
                H5TabbarItem h5TabbarItem = new H5TabbarItem(context);
                TextView textView = (TextView) h5TabbarItem.getIconAreaView();
                textView.setText("".trim());
                Drawable drawable = H5Environment.getResources().getDrawable(R.drawable.h5_sessiontab_defaultitem);
                int dimensionPixelSize = H5Environment.getResources().getDimensionPixelSize(R.dimen.h5_bottom_height_tab_icon);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawables((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                h5TabbarLayout.addTab(h5TabbarItem.getRootView());
                i3++;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            View view = new View(context);
            view.setBackgroundColor(-5526610);
            linearLayout.addView(view, layoutParams);
            h5TabbarLayout.setBackgroundColor(-460551);
            linearLayout.addView(h5TabbarLayout, new LinearLayout.LayoutParams(-1, -1));
            if (context instanceof H5Activity) {
                this.sessionTabContainer = (RelativeLayout) ((H5Activity) context).getSessionTabContainer();
                this.sessionTabContainer.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
                this.sessionTabContainer.setVisibility(0);
                return;
            }
            H5Log.w(H5BaseTabBar.TAG, "not in h5activity");
            return;
        }
        H5Log.w(H5BaseTabBar.TAG, "createDefaultSessionTab num < 2");
    }

    /* access modifiers changed from: protected */
    public void loadImageAsync(String str, H5TabbarItem h5TabbarItem, StateListDrawable stateListDrawable, Context context, int i2, boolean z, Bundle bundle) {
        byte[] bArr;
        String str2 = str;
        H5TabbarItem h5TabbarItem2 = h5TabbarItem;
        StateListDrawable stateListDrawable2 = stateListDrawable;
        if (!TextUtils.isEmpty(str)) {
            H5ContentPackage h5ContentPackage = H5ContentPackagePool.getPackage(H5Utils.getString(bundle, H5Param.SESSION_ID));
            if (h5ContentPackage == null || (bArr = h5ContentPackage.get(str)) == null) {
                int i3 = i2;
                H5SessionImpl h5SessionImpl = this.h5Session;
                if (h5SessionImpl != null) {
                    H5ContentProvider webProvider = h5SessionImpl.getWebProvider();
                    if (webProvider != null) {
                        final Context context2 = context;
                        final int i4 = i2;
                        final boolean z2 = z;
                        final H5TabbarItem h5TabbarItem3 = h5TabbarItem;
                        final StateListDrawable stateListDrawable3 = stateListDrawable;
                        final String str3 = str;
                        final Bundle bundle2 = bundle;
                        webProvider.getContent(str, (H5ContentProvider.ResponseListen) new H5ContentProvider.ResponseListen() {
                            public void onGetResponse(WebResourceResponse webResourceResponse) {
                                H5Log.d(H5BaseTabBar.TAG, "loadImageAsync offlinepkg already exist package");
                                if (webResourceResponse == null || webResourceResponse.getData() == null) {
                                    H5SessionTabBar.super.loadImageAsync(str3, h5TabbarItem3, stateListDrawable3, context2, i4, z2, bundle2);
                                    return;
                                }
                                Bitmap decodeStream = BitmapFactory.decodeStream(webResourceResponse.getData());
                                if (decodeStream != null) {
                                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(context2.getResources(), decodeStream);
                                    int i2 = i4;
                                    bitmapDrawable.setBounds(0, 0, i2, i2);
                                    H5Utils.runOnMain(new Runnable() {
                                        public void run() {
                                            if (z2) {
                                                h5TabbarItem3.addCheckedState(stateListDrawable3, bitmapDrawable);
                                            } else {
                                                h5TabbarItem3.addNormalState(stateListDrawable3, bitmapDrawable);
                                            }
                                            ((TextView) h5TabbarItem3.getIconAreaView()).setCompoundDrawables((Drawable) null, stateListDrawable3, (Drawable) null, (Drawable) null);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    super.loadImageAsync(str, h5TabbarItem, stateListDrawable, context, i2, z, bundle);
                    return;
                }
                super.loadImageAsync(str, h5TabbarItem, stateListDrawable, context, i2, z, bundle);
                return;
            }
            H5Log.d(H5BaseTabBar.TAG, "loadImageAsync offlinepkg preFetchPackage");
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            int i5 = i2;
            bitmapDrawable.setBounds(0, 0, i5, i5);
            if (z) {
                h5TabbarItem.addCheckedState(stateListDrawable2, bitmapDrawable);
            } else {
                h5TabbarItem.addNormalState(stateListDrawable2, bitmapDrawable);
            }
            ((TextView) h5TabbarItem.getIconAreaView()).setCompoundDrawables((Drawable) null, stateListDrawable2, (Drawable) null, (Drawable) null);
        }
    }

    public synchronized boolean isFastClick() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        z = currentTimeMillis - this.lastClickTime <= 500;
        this.lastClickTime = currentTimeMillis;
        return z;
    }

    public void setHasShowTab(boolean z) {
        this.hasShowTab = z;
    }

    private boolean enableReCreateTabBar() {
        return !"no".equalsIgnoreCase(H5Environment.getConfig("h5_enableReCreateTabBar"));
    }
}

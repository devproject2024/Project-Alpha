package com.alipay.mobile.nebulacore.dev.bugme;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5DimensionUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class H5BugmeConsole {
    static final String[] LOG_KEYS = {H5Param.PAGE, "jsBridge", "console", ContactsConstant.NETWORK};
    private static final String TAG = "H5BugmeConsole";
    private WeakReference<APWebView> mApWebViewRef;
    /* access modifiers changed from: private */
    public List<H5BugMeListView> mContentViewList;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public AlertDialog mDebugDialog;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private View mInfoView;
    private boolean mInitialized = false;
    /* access modifiers changed from: private */
    public List<List<H5BugMeLogMsg>> mLogDataList;
    private View mTabView;
    private H5TabLayout mTabs;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;

    public H5BugmeConsole(APWebView aPWebView, Context context) {
        this.mContext = context;
        this.mApWebViewRef = new WeakReference<>(aPWebView);
    }

    public void startup() {
        if (!this.mInitialized) {
            try {
                initTabView();
                showFloatTriggerButton();
                this.mInitialized = true;
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    private void initTabView() {
        H5Page topPage;
        WeakReference<APWebView> weakReference;
        String userAgentString;
        this.mLogDataList = new ArrayList();
        this.mContentViewList = new ArrayList();
        for (int i2 = 0; i2 < LOG_KEYS.length; i2++) {
            this.mLogDataList.add(new ArrayList());
            this.mContentViewList.add(new H5BugMeListView(this.mContext, this, i2));
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.mTabView = from.inflate(R.layout.h5_bugme_tabview, (ViewGroup) null);
        this.mTabs = (H5TabLayout) this.mTabView.findViewById(R.id.h5_bugme_tabs);
        this.mViewPager = (ViewPager) this.mTabView.findViewById(R.id.h5_bugme_viewPager);
        this.mViewPager.setAdapter(new H5BugMeViewPageAdapter(this));
        this.mTabs.setupWithViewPager(this.mViewPager);
        this.mTabView.findViewById(R.id.h5_bugme_clear_tab).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int currentItem = H5BugmeConsole.this.mViewPager.getCurrentItem();
                ((List) H5BugmeConsole.this.mLogDataList.get(currentItem)).clear();
                ((H5BugMeListView) H5BugmeConsole.this.mContentViewList.get(currentItem)).refresh();
            }
        });
        this.mTabView.findViewById(R.id.h5_bugme_clear_all).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (List clear : H5BugmeConsole.this.mLogDataList) {
                    clear.clear();
                }
                for (H5BugMeListView refresh : H5BugmeConsole.this.mContentViewList) {
                    refresh.refresh();
                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (H5BugmeConsole.this.mDebugDialog != null) {
                    H5BugmeConsole.this.mDebugDialog.dismiss();
                }
            }
        });
        this.mDebugDialog = builder.create();
        this.mDebugDialog.setView(this.mTabView);
        this.mDebugDialog.setCanceledOnTouchOutside(false);
        if (this.mDebugDialog.getWindow() != null) {
            this.mDebugDialog.getWindow().setDimAmount(0.0f);
        }
        this.mInfoView = from.inflate(R.layout.h5_bugme_info, (ViewGroup) null);
        if (Nebula.getService() != null && Nebula.getService().getTopSession() != null && Nebula.getService().getTopSession().getTopPage() != null && (topPage = Nebula.getService().getTopSession().getTopPage()) != null) {
            String string = H5Utils.getString(topPage.getParams(), H5AppUtil.package_nick);
            String string2 = H5Utils.getString(topPage.getParams(), "appVersion");
            String string3 = H5Utils.getString(topPage.getParams(), "appId");
            ((TextView) this.mInfoView.findViewById(R.id.h5_bugme_info_appid)).setText(string3);
            ((TextView) this.mInfoView.findViewById(R.id.h5_bugme_info_pkg_nick)).setText(string);
            ((TextView) this.mInfoView.findViewById(R.id.h5_bugme_info_version)).setText(string2);
            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
            if (h5AppProvider != null) {
                ((TextView) this.mInfoView.findViewById(R.id.h5_bugme_info_name)).setText(h5AppProvider.getAppName(string3, string2));
            }
            TextView textView = (TextView) this.mInfoView.findViewById(R.id.h5_bugme_info_webview);
            if (!(textView == null || (weakReference = this.mApWebViewRef) == null || weakReference.get() == null || (userAgentString = ((APWebView) this.mApWebViewRef.get()).getSettings().getUserAgentString()) == null)) {
                int indexOf = userAgentString.indexOf("Chrome/");
                String substring = indexOf > 0 ? userAgentString.substring(indexOf + 7, userAgentString.indexOf(" ", indexOf)) : "";
                if (userAgentString.contains("UCBS") || userAgentString.contains("UWS")) {
                    textView.setText("U4 ".concat(String.valueOf(substring)));
                } else if (userAgentString.contains("u3")) {
                    textView.setText("U3 ".concat(String.valueOf(substring)));
                } else {
                    textView.setText("System WebView ".concat(String.valueOf(substring)));
                }
            }
            this.mInfoView.findViewById(R.id.h5_bugme_info_button_screenshot).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (Nebula.getService() != null && Nebula.getService().getTopSession() != null && Nebula.getService().getTopSession().getTopPage() != null) {
                        Nebula.getService().getTopSession().getTopPage().sendEvent(H5Plugin.CommonEvents.H5_DEV_SCREENSHOT_UPLOAD, (e) null);
                        H5Environment.showToast(H5BugmeConsole.this.mContext, "upload success", 0);
                    }
                }
            });
        }
    }

    private void showFloatTriggerButton() {
        APWebView aPWebView = (APWebView) this.mApWebViewRef.get();
        this.mApWebViewRef = new WeakReference<>(aPWebView);
        H5BugmeConsoleButton h5BugmeConsoleButton = new H5BugmeConsoleButton(this.mContext);
        h5BugmeConsoleButton.setImageDrawable(H5Environment.getResources().getDrawable(R.drawable.h5_btn_debug_console));
        h5BugmeConsoleButton.setBackgroundColor(0);
        h5BugmeConsoleButton.setTag(Integer.valueOf(aPWebView.hashCode()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        h5BugmeConsoleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (H5BugmeConsole.this.mDebugDialog != null) {
                    H5BugmeConsole.this.mDebugDialog.show();
                    if (H5BugmeConsole.this.mDebugDialog.getWindow() != null) {
                        H5BugmeConsole.this.mDebugDialog.getWindow().setLayout(H5DimensionUtil.getScreenWidth(H5BugmeConsole.this.mContext), Math.min(H5DimensionUtil.getScreenHeight(H5BugmeConsole.this.mContext), H5DimensionUtil.dip2px(H5BugmeConsole.this.mContext, 500.0f)));
                    }
                }
            }
        });
        ((ViewGroup) aPWebView.getView()).addView(h5BugmeConsoleButton, layoutParams);
    }

    public void recordLog(final e eVar) {
        String string = eVar.getString("type");
        if ("jsapi".equals(string) || AppConstants.NOTIFICATION_DETAILS.EVENT.equals(string)) {
            string = "jsBridge";
        }
        final int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = LOG_KEYS;
            if (i3 >= strArr.length) {
                break;
            } else if (string.equals(strArr[i3])) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                if (H5BugmeConsole.this.mLogDataList != null) {
                    ((List) H5BugmeConsole.this.mLogDataList.get(i2)).add(new H5BugMeLogMsg(eVar));
                }
                if (H5BugmeConsole.this.mContentViewList != null && H5BugmeConsole.this.mDebugDialog != null && H5BugmeConsole.this.mDebugDialog.isShowing()) {
                    ((H5BugMeListView) H5BugmeConsole.this.mContentViewList.get(i2)).refresh();
                }
            }
        });
    }

    public void release() {
        this.mContentViewList.clear();
        this.mLogDataList.clear();
        this.mContentViewList = null;
        this.mLogDataList = null;
        this.mDebugDialog = null;
        this.mTabView = null;
        this.mTabs = null;
        this.mViewPager = null;
    }

    public List<H5BugMeLogMsg> getLogDataList(int i2) {
        return this.mLogDataList.get(i2);
    }

    public int getTabSize() {
        return this.mContentViewList.size();
    }

    public View getSubContentView(int i2) {
        if (i2 == 0) {
            return this.mInfoView;
        }
        return this.mContentViewList.get(i2);
    }
}

package com.alipay.mobile.nebulacore.core;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.factory.H5PageFactory;
import com.alipay.mobile.nebulacore.tabbar.H5PageTabBar;
import com.alipay.mobile.nebulacore.ui.H5TransWebContent;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import com.alipay.mobile.nebulacore.ui.H5WebContent;
import com.alipay.mobile.nebulacore.util.KeyboardUtil;
import com.alipay.mobile.nebulacore.view.H5FontBar;
import com.alipay.mobile.nebulacore.view.H5NavigationBar;

public class H5PageFactoryImpl implements H5PageFactory {
    public static final String TAG = "H5PageFactoryImpl";
    private Activity activity;

    public H5PageFactoryImpl(Activity activity2) {
        this.activity = activity2;
    }

    public H5ViewHolder createPage(Activity activity2, final Bundle bundle) {
        H5Log.d(TAG, "start create page");
        long currentTimeMillis = System.currentTimeMillis();
        H5ViewHolder h5ViewHolder = new H5ViewHolder();
        boolean z = H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false);
        H5Log.d(TAG, "transActivity ".concat(String.valueOf(z)));
        if (!z) {
            H5Log.d(TAG, "init nav bar");
            try {
                h5ViewHolder.setH5NavBar(new H5NavigationBar(activity2, bundle, h5ViewHolder));
            } catch (Throwable th) {
                H5Log.e(TAG, "init exception", th);
            }
            H5Log.d(TAG, "init nav bar end");
        }
        final H5PageImpl h5PageImpl = new H5PageImpl(this.activity, bundle, h5ViewHolder);
        h5PageImpl.setHandler(new H5Page.H5PageHandler() {
            public boolean shouldExit() {
                return true;
            }
        });
        h5PageImpl.setH5ErrorHandler(new H5Page.H5ErrorHandler() {
            public boolean shouldInterceptError(String str, int i2) {
                return false;
            }
        });
        h5ViewHolder.setH5Page(h5PageImpl);
        if (!z) {
            try {
                H5Log.d(TAG, "init web content");
                H5WebContent h5WebContent = new H5WebContent(h5PageImpl);
                h5ViewHolder.setH5WebContainer(h5WebContent);
                h5PageImpl.getPluginManager().register((H5Plugin) h5WebContent);
                H5Log.d(TAG, "init web content end");
                H5Log.d(TAG, "init font bar");
                H5FontBar h5FontBar = new H5FontBar(h5PageImpl);
                h5PageImpl.getPluginManager().register((H5Plugin) h5FontBar);
                h5ViewHolder.setH5FontBar(h5FontBar);
                H5Log.d(TAG, "init font bar end");
                H5Log.d(TAG, "init tab bar");
                H5PageTabBar h5PageTabBar = new H5PageTabBar();
                h5PageTabBar.setPageViewHolder(h5ViewHolder);
                h5PageImpl.getPluginManager().register((H5Plugin) h5PageTabBar);
                h5ViewHolder.setH5Tabbar(h5PageTabBar);
                H5Log.d(TAG, "init tab bar end");
                H5NavigationBar h5NavBar = h5ViewHolder.getH5NavBar();
                if (h5NavBar != null) {
                    h5NavBar.setHdivider(h5ViewHolder.getH5WebContainer().getHdivider());
                    h5NavBar.setPage(h5PageImpl);
                    h5PageImpl.getPluginManager().register((H5Plugin) h5NavBar);
                }
            } catch (Throwable th2) {
                H5Log.e(TAG, "init exception", th2);
            }
        } else {
            try {
                H5TransWebContent h5TransWebContent = new H5TransWebContent(h5PageImpl);
                h5ViewHolder.setH5TransWebContainer(h5TransWebContent);
                h5PageImpl.getPluginManager().register((H5Plugin) h5TransWebContent);
            } catch (Throwable th3) {
                H5Log.e(TAG, "init exception", th3);
            }
        }
        new KeyboardUtil(this.activity).setListener(new KeyboardUtil.KeyboardListener() {
            public void onKeyboardVisible(boolean z) {
                H5Log.d(H5PageFactoryImpl.TAG, "onKeyboardVisible ".concat(String.valueOf(z)));
                if (z) {
                    String string = H5Utils.getString(bundle, H5Param.PUBLIC_ID, "");
                    String url = h5PageImpl.getUrl();
                    e eVar = new e();
                    eVar.put(H5Param.PUBLIC_ID, (Object) string);
                    eVar.put("url", (Object) url);
                    h5PageImpl.sendEvent(H5Plugin.CommonEvents.KEY_BOARD_BECOME_VISIBLE, eVar);
                }
            }
        });
        H5Log.d(TAG, "create page elapse ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return h5ViewHolder;
    }
}

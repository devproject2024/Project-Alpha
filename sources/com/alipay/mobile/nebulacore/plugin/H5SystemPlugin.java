package com.alipay.mobile.nebulacore.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class H5SystemPlugin extends H5SimplePlugin {
    public static final String TAG = "H5SystemPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction("openInBrowser");
        h5EventFilter.addAction(H5Plugin.CommonEvents.SEND_SMS);
        h5EventFilter.addAction(H5Plugin.CommonEvents.IS_INSTALLED_APP);
        h5EventFilter.addAction(H5Plugin.CommonEvents.CHECK_JS_API);
        h5EventFilter.addAction(H5Plugin.CommonEvents.START_PACKAGE);
        h5EventFilter.addAction("openSystemSetting");
    }

    public boolean handleEvent(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.SEND_SMS.equals(action)) {
            sendSMS(h5Event);
            return true;
        } else if (H5Plugin.CommonEvents.IS_INSTALLED_APP.equals(action)) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    try {
                        H5SystemPlugin.this.installedApp(h5Event, h5BridgeContext);
                    } catch (Throwable th) {
                        H5Log.e(H5SystemPlugin.TAG, th);
                    }
                }
            });
            return true;
        } else if (H5Plugin.CommonEvents.CHECK_JS_API.equals(action)) {
            checkJsAPI(h5Event, h5BridgeContext);
            return true;
        } else if ("openInBrowser".equals(action)) {
            openInBrowser(h5Event, h5BridgeContext);
            return true;
        } else if (H5Plugin.CommonEvents.START_PACKAGE.equals(action)) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    try {
                        H5SystemPlugin.this.startPackage(h5Event, h5BridgeContext);
                    } catch (Throwable th) {
                        H5Log.e(H5SystemPlugin.TAG, th);
                    }
                }
            });
            return true;
        } else if (!"openSystemSetting".equals(action)) {
            return true;
        } else {
            openSystemSetting(h5Event, h5BridgeContext);
            return true;
        }
    }

    private void openInBrowser(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String string = H5Utils.getString(h5Event.getParam(), "url");
        H5CoreNode target = h5Event.getTarget();
        Nebula.openInBrowser(target instanceof H5Page ? (H5Page) target : null, string, h5BridgeContext);
    }

    /* access modifiers changed from: private */
    public void installedApp(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        if (param != null && param.containsKey("packagename")) {
            PackageInfo packageInfo = H5Utils.getPackageInfo(H5Environment.getContext(), param.getString("packagename"));
            e eVar = new e();
            eVar.put("installed", (Object) Boolean.valueOf(packageInfo != null));
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    private void sendSMS(H5Event h5Event) {
        e param = h5Event.getParam();
        String string = param.getString("mobile");
        String string2 = param.getString("content");
        Intent intent = new Intent("android.intent.action.SENDTO", H5UrlHelper.parseUrl("smsto:".concat(String.valueOf(string))));
        intent.putExtra("sms_body", string2);
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setFlags(268435456);
        H5Environment.startActivity((H5Context) null, intent);
    }

    private void checkJsAPI(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String string = H5Utils.getString(h5Event.getParam(), SDKConstants.KEY_API, (String) null);
        H5CoreNode target = h5Event.getTarget();
        boolean z = false;
        while (!TextUtils.isEmpty(string) && !z && target != null) {
            H5PluginManager pluginManager = target.getPluginManager();
            target = target.getParent();
            z = pluginManager.canHandle(string);
        }
        e eVar = new e();
        eVar.put("available", (Object) Boolean.valueOf(z));
        h5BridgeContext.sendBridgeResult(eVar);
    }

    /* access modifiers changed from: private */
    public void startPackage(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e eVar = new e();
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "packagename");
        Context context = H5Environment.getContext();
        if (H5Utils.getPackageInfo(context, string) != null) {
            if (H5Utils.getBoolean(param, "closeCurrentApp", false)) {
                H5CoreNode target = h5Event.getTarget();
                if (target instanceof H5Page) {
                    ((H5Page) target).getSession().exitSession();
                }
            }
            H5Environment.startActivity((H5Context) null, context.getPackageManager().getLaunchIntentForPackage(string));
            eVar.put(H5Plugin.CommonEvents.START_PACKAGE, (Object) "true");
            h5BridgeContext.sendBridgeResult(eVar);
            return;
        }
        h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
    }

    private void openSystemSetting(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "url");
        String string2 = H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_EXT);
        Intent intent = new Intent(string);
        if (!TextUtils.isEmpty(string2)) {
            intent.setData(H5UrlHelper.parseUrl(string2));
        }
        if (intent.resolveActivity(H5Environment.getContext().getPackageManager()) != null) {
            H5Environment.startActivity((H5Context) null, intent);
            if (h5BridgeContext != null) {
                h5BridgeContext.sendSuccess();
            }
        } else if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult("success", Boolean.FALSE);
        }
    }
}

package com.alipay.mobile.nebulacore.wallet;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.framework.a.a;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import java.lang.ref.WeakReference;

public class H5WalletPageNotifyPlugin extends H5SimplePlugin {
    public static final String TAG = "H5WalletPageNotifyPlugin";
    private WeakReference<Activity> activityWeakReference;
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private BroadcastReceiver handleListen = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            H5Log.debug(H5WalletPageNotifyPlugin.TAG, "received handleResumeListen");
            if (intent != null && intent.getExtras() != null && intent.getAction() != null && H5WalletPageNotifyPlugin.this.h5Page != null) {
                H5Log.d(H5WalletPageNotifyPlugin.TAG, "onReceive:" + intent.getAction() + " " + intent.getExtras().getString("app_id"));
                if (a.f14951a.equalsIgnoreCase(intent.getAction())) {
                    if (TextUtils.isEmpty(H5WalletPageNotifyPlugin.this.receiverAppId)) {
                        String unused = H5WalletPageNotifyPlugin.this.receiverAppId = intent.getExtras().getString("app_id");
                    }
                    if (TextUtils.equals(intent.getExtras().getString("app_id"), H5WalletPageNotifyPlugin.this.receiverAppId) && H5WalletPageNotifyPlugin.this.topMatch()) {
                        H5Log.d(H5WalletPageNotifyPlugin.TAG, "createPage resume");
                        H5WalletPageNotifyPlugin.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RESUME, (e) null);
                    }
                } else if (a.f14952b.equalsIgnoreCase(intent.getAction()) && H5WalletPageNotifyPlugin.this.topMatch()) {
                    H5Log.d(H5WalletPageNotifyPlugin.TAG, "createPage pause");
                    H5WalletPageNotifyPlugin.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_PAUSE, (e) null);
                }
            }
        }
    };
    private boolean hasRegistered = false;
    /* access modifiers changed from: private */
    public String receiverAppId;

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return false;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
    }

    public void onRelease() {
        this.h5Page = null;
        if (this.hasRegistered) {
            try {
                H5Log.d(TAG, "unregister broadcastreceiver");
                unregisterListen();
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event.getTarget() instanceof H5Page) {
            this.h5Page = (H5Page) h5Event.getTarget();
        }
        this.activityWeakReference = new WeakReference<>(h5Event.getActivity());
        if (this.activityWeakReference.get() == null || ((Activity) this.activityWeakReference.get()).isFinishing() || !(this.activityWeakReference.get() instanceof H5Activity)) {
            H5Log.debug(TAG, "current activity is not H5Activity registerListen");
            registerListen();
            return false;
        }
        H5Log.debug(TAG, "current activity is H5Activity");
        return false;
    }

    private void registerListen() {
        if (this.hasRegistered) {
            H5Log.e(TAG, "hasRegistered not register");
            return;
        }
        this.hasRegistered = true;
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a(H5Utils.getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(a.f14951a);
        intentFilter.addAction(a.f14952b);
        H5Log.d(TAG, "registerFrameWorkListen");
        a2.a(this.handleListen, intentFilter);
    }

    private boolean useTopMatch() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("H5_createPage_listen"));
    }

    /* access modifiers changed from: private */
    public boolean topMatch() {
        try {
            if (!useTopMatch()) {
                return true;
            }
            b.a();
            WeakReference weakReference = null;
            Activity activity = (Activity) weakReference.get();
            if (activity == null || this.activityWeakReference == null || this.activityWeakReference.get() == null) {
                H5Log.d(TAG, "not match: " + activity + ", weakRef: " + this.activityWeakReference);
                return false;
            }
            String className = H5Utils.getClassName(activity);
            String className2 = H5Utils.getClassName(this.activityWeakReference.get());
            H5Log.d(TAG, "top " + className + " page:" + className2);
            if (TextUtils.equals(className, className2)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return false;
        }
    }

    private void unregisterListen() {
        if (this.handleListen != null) {
            androidx.localbroadcastmanager.a.a.a(H5Utils.getContext()).a(this.handleListen);
            this.handleListen = null;
        }
    }
}

package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.framework.loading.LoadingView;
import com.alipay.mobile.framework.loading.a;
import com.alipay.mobile.framework.loading.b;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;
import com.alipay.mobile.nebula.appcenter.appsync.H5PageStatues;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class H5LoadingFrameworkImpl implements H5LoadingManager, H5LoadingTypeListen {
    public static final String ANIMATION_TYPE_STOP_LOADING = "ANIMATION_STOP_LOADING_PREPARE";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_ICON = "UPDATE_APPEARANCE_LOADING_ICON";
    public static final String DATA_UPDATE_APPEARANCE_LOADING_TEXT = "UPDATE_APPEARANCE_LOADING_TEXT";
    public static final String MSG_UPDATE_APPEARANCE = "UPDATE_APPEARANCE";
    private static final String TAG = "H5LoadingFrameworkImpl";
    /* access modifiers changed from: private */
    public H5StartAppInfo mH5StartAppInfo;
    private a mLoadingPageHandler;
    private H5PageStatues mPageStatues;
    /* access modifiers changed from: private */
    public boolean mPlayingExitAnim = false;
    private long mStartLoadingTime = 0;
    private Timer mTimer;
    /* access modifiers changed from: private */
    public boolean needShown = true;

    public void open(Bundle bundle, String str, String str2, H5StartAppInfo h5StartAppInfo, int i2) {
        this.mStartLoadingTime = System.currentTimeMillis();
        this.mLoadingPageHandler = new a() {
            public int getPriority() {
                return 0;
            }

            public boolean needShowLoadingPage(String str, String str2, Bundle bundle) {
                H5Log.d(H5LoadingFrameworkImpl.TAG, "needShowLoadingPage");
                if (!H5LoadingFrameworkImpl.this.needShown) {
                    return false;
                }
                boolean unused = H5LoadingFrameworkImpl.this.needShown = false;
                return true;
            }

            public void onCancelLoadingPage(String str, String str2, Bundle bundle) {
                H5Log.d(H5LoadingFrameworkImpl.TAG, "onCancelLoadingPage");
                b unused = H5LoadingFrameworkImpl.this.getLoadingManager();
            }

            public void onStartLoadingPage(String str, String str2, Bundle bundle) {
                H5Log.d(H5LoadingFrameworkImpl.TAG, "onStartLoadingPage");
            }

            public void onStopLoadingPage(String str, String str2, Bundle bundle) {
                H5Log.d(H5LoadingFrameworkImpl.TAG, "onStopLoadingPage");
                b unused = H5LoadingFrameworkImpl.this.getLoadingManager();
            }

            public LoadingView createLoadingView(String str, String str2, Bundle bundle) {
                H5Log.d(H5LoadingFrameworkImpl.TAG, "createLoadingView");
                return null;
            }
        };
        this.mH5StartAppInfo = h5StartAppInfo;
        this.mPageStatues = new H5PageStatues();
        this.mPageStatues.currentPageStatues = 1;
        H5LoadingUtil.setH5LoadingTypeListen(this);
        H5LoadingUtil.setH5LoadingManager(this);
        final String string = H5Utils.getString(bundle, "appName");
        String string2 = H5Utils.getString(bundle, H5AppHandler.sAppIcon);
        H5Log.d(TAG, "appName " + string + " logo:" + string2 + " timeout:" + i2 + " type:" + str2);
        getLoadingManager();
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                b unused = H5LoadingFrameworkImpl.this.getLoadingManager();
                H5StartAppInfo unused2 = H5LoadingFrameworkImpl.this.mH5StartAppInfo;
                H5StartAppInfo unused3 = H5LoadingFrameworkImpl.this.mH5StartAppInfo;
                H5StartAppInfo unused4 = H5LoadingFrameworkImpl.this.mH5StartAppInfo;
                H5LoadingFrameworkImpl.this.setLoadingName(string);
            }
        });
        if (!TextUtils.isEmpty(string2)) {
            H5ImageUtil.loadImage(string2, new H5ImageListener() {
                public void onImage(final Bitmap bitmap) {
                    if (bitmap != null) {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                H5LoadingFrameworkImpl.this.setLoadingImage(bitmap);
                            }
                        });
                    }
                }
            });
        }
        if (i2 > 0 && this.mTimer == null) {
            try {
                this.mTimer = new Timer();
                this.mTimer.schedule(new MyTimeTask(str2, str, i2), (long) (i2 * 1000));
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    public long getStartLoadingTime() {
        return this.mStartLoadingTime;
    }

    /* access modifiers changed from: private */
    public b getLoadingManager() {
        com.alipay.mobile.framework.b.a();
        return null;
    }

    public void exit() {
        H5Log.d(TAG, "loading exit");
        if (!TextUtils.isEmpty(this.mH5StartAppInfo.targetAppId)) {
            getLoadingManager();
            getLoadingManager();
            return;
        }
        H5Log.d(TAG, "exit targetAppId is null");
    }

    public void sendToWebFail() {
        H5Log.d(TAG, "sendToWebFail");
        H5PageStatues h5PageStatues = this.mPageStatues;
        if (h5PageStatues != null) {
            h5PageStatues.currentPageStatues = 2;
        }
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                if (H5LoadingFrameworkImpl.this.isReady() && !H5LoadingFrameworkImpl.this.mPlayingExitAnim) {
                    b access$100 = H5LoadingFrameworkImpl.this.getLoadingManager();
                    H5StartAppInfo unused = H5LoadingFrameworkImpl.this.mH5StartAppInfo;
                    if (access$100.a() != null) {
                        b access$1002 = H5LoadingFrameworkImpl.this.getLoadingManager();
                        H5StartAppInfo unused2 = H5LoadingFrameworkImpl.this.mH5StartAppInfo;
                        access$1002.a().stop();
                        H5LoadingFrameworkImpl.this.setLoadingName(H5Utils.getNebulaResources().getString(R.string.h5_network_poor));
                    }
                }
            }
        });
    }

    public boolean isReady() {
        return getLoadingManager().a() != null;
    }

    public boolean pageDestroy() {
        return getLoadingManager().a() == null;
    }

    public int getPageStatues() {
        return this.mPageStatues.currentPageStatues;
    }

    public void setPageStatue(int i2) {
        this.mPageStatues.currentPageStatues = i2;
    }

    public void playExitAnimation() {
        if (this.mPageStatues.currentPageStatues != 2) {
            if (TextUtils.isEmpty(this.mH5StartAppInfo.targetAppId) || getLoadingManager().a() == null) {
                H5Log.d(TAG, "exit targetAppId is null");
                return;
            }
            this.mPlayingExitAnim = true;
            getLoadingManager().a().performAnimation(ANIMATION_TYPE_STOP_LOADING, (Animator.AnimatorListener) null);
        }
    }

    public void onGetType(String str, int i2, String str2) {
        H5Log.d(TAG, "onGetType " + str + " timeout:" + i2 + " " + this.mTimer);
        Timer timer = this.mTimer;
        if (timer != null && i2 > 0) {
            try {
                timer.cancel();
                this.mTimer = new Timer();
                this.mTimer.schedule(new MyTimeTask(str, str2, i2), (long) (i2 * 1000));
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setLoadingName(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DATA_UPDATE_APPEARANCE_LOADING_TEXT, str);
        if (getLoadingManager().a() != null) {
            getLoadingManager().a().sendMessage(MSG_UPDATE_APPEARANCE, hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void setLoadingImage(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        HashMap hashMap = new HashMap();
        hashMap.put(DATA_UPDATE_APPEARANCE_LOADING_ICON, bitmapDrawable);
        if (getLoadingManager().a() != null) {
            getLoadingManager().a().sendMessage(MSG_UPDATE_APPEARANCE, hashMap);
        }
    }

    class MyTimeTask extends TimerTask {
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public int timeout;
        /* access modifiers changed from: private */
        public String type;

        MyTimeTask(String str, String str2, int i2) {
            this.type = str;
            this.appId = str2;
            this.timeout = i2;
        }

        public void run() {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5Log.d(H5LoadingFrameworkImpl.TAG, "timeout " + MyTimeTask.this.timeout + " type " + MyTimeTask.this.type);
                    if (H5AppHandler.isSyncType(MyTimeTask.this.type)) {
                        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            String access$800 = MyTimeTask.this.appId;
                            String access$700 = MyTimeTask.this.type;
                            StringBuilder sb = new StringBuilder();
                            sb.append(MyTimeTask.this.timeout);
                            h5LogProvider.log("h5_show_nebulaApp_timeout_page", access$800, access$700, sb.toString(), (String) null);
                        }
                        H5LoadingFrameworkImpl.this.sendToWebFail();
                        return;
                    }
                    H5AppHandler.exitAndStartApp(H5LoadingFrameworkImpl.this.mH5StartAppInfo, H5LoadingUtil.getH5LoadingManager());
                }
            });
        }
    }
}

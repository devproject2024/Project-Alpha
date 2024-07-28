package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;
import com.alipay.mobile.nebula.appcenter.appsync.H5PageStatues;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5WebLoadingView;
import java.util.Timer;
import java.util.TimerTask;

public class H5LoadingActivity extends BaseFragmentActivity implements H5LoadingTypeListen {
    private static final String TAG = "H5LoadingActivity";
    /* access modifiers changed from: private */
    public H5WebLoadingView loadingView;
    private H5PageStatues pageStatues;
    private Timer timer;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pageStatues = new H5PageStatues();
        this.pageStatues.currentPageStatues = 1;
        H5LoadingUtil.setH5LoadingActivity(this);
        H5LoadingUtil.setH5LoadingTypeListen(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        String string = H5Utils.getString(extras, "appName");
        String string2 = H5Utils.getString(extras, H5AppHandler.sAppIcon);
        String string3 = H5Utils.getString(extras, "appId");
        int i2 = H5Utils.getInt(extras, H5LoadingViewImpl.LOADING_TIMEOUT);
        String string4 = H5Utils.getString(extras, H5LoadingViewImpl.LOADING_TYPE);
        H5Log.d(TAG, "appName " + string + " logo:" + string2 + " timeout:" + i2 + " type:" + string4);
        this.loadingView = new H5WebLoadingView(this);
        this.loadingView.setLoadingInfo(string, (String) null, (String) null);
        this.loadingView.getBackButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5LoadingActivity.this.finish();
            }
        });
        try {
            setContentView((View) this.loadingView);
            if (!TextUtils.isEmpty(string2)) {
                H5ImageUtil.loadImage(string2, new H5ImageListener() {
                    public void onImage(Bitmap bitmap) {
                        if (bitmap != null && !H5LoadingActivity.this.isFinishing() && H5LoadingActivity.this.loadingView != null) {
                            H5LoadingActivity.this.loadingView.setLoadingBitmap(bitmap);
                        }
                    }
                });
            }
            this.loadingView.startLoadingAnimation();
            if (i2 > 0 && this.timer == null) {
                try {
                    this.timer = new Timer();
                    this.timer.schedule(new MyTimeTask(string4, string3, i2), (long) (i2 * 1000));
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        } catch (Throwable th2) {
            H5Log.e(TAG, th2);
            finish();
        }
    }

    public void sendToWebFail() {
        if (this.loadingView != null) {
            H5PageStatues h5PageStatues = this.pageStatues;
            if (h5PageStatues != null) {
                h5PageStatues.currentPageStatues = 2;
            }
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    if (!H5LoadingActivity.this.isFinishing()) {
                        H5LoadingActivity.this.loadingView.stopLoadingAnimation();
                        H5LoadingActivity.this.loadingView.setLoadingInfo(H5Utils.getNebulaResources().getString(R.string.h5_network_poor), (String) null, (String) null);
                    }
                }
            });
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
                    if (H5LoadingActivity.this.isFinishing()) {
                        H5Log.d(H5LoadingActivity.TAG, "isFinishing not handler timeout");
                        return;
                    }
                    H5Log.d(H5LoadingActivity.TAG, "timeout  type " + MyTimeTask.this.type);
                    if (H5AppHandler.isSyncType(MyTimeTask.this.type)) {
                        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            String access$200 = MyTimeTask.this.appId;
                            String access$100 = MyTimeTask.this.type;
                            StringBuilder sb = new StringBuilder();
                            sb.append(MyTimeTask.this.timeout);
                            h5LogProvider.log("h5_show_nebulaApp_timeout_page", access$200, access$100, sb.toString(), (String) null);
                        }
                        H5LoadingActivity.this.sendToWebFail();
                        return;
                    }
                    H5AppHandler.exitAndStartApp(H5LoadingUtil.getH5StartAppInfo(), H5LoadingUtil.getH5LoadingManager());
                }
            });
        }
    }

    public int getPageStatues() {
        H5PageStatues h5PageStatues = this.pageStatues;
        if (h5PageStatues != null) {
            return h5PageStatues.currentPageStatues;
        }
        return 0;
    }

    public void setPageStatue(int i2) {
        H5PageStatues h5PageStatues = this.pageStatues;
        if (h5PageStatues != null) {
            h5PageStatues.currentPageStatues = i2;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        H5LoadingUtil.setH5LoadingActivity((H5LoadingActivity) null);
        H5LoadingUtil.setH5LoadingManager((H5LoadingManager) null);
        H5LoadingUtil.setH5StartAppInfo((H5StartAppInfo) null);
        H5LoadingUtil.setH5LoadingTypeListen((H5LoadingTypeListen) null);
    }

    public void onGetType(String str, int i2, String str2) {
        H5Log.d(TAG, "onGetType " + str + " timeout:" + i2 + " " + this.timer);
        Timer timer2 = this.timer;
        if (timer2 != null && i2 > 0) {
            try {
                timer2.cancel();
                this.timer = new Timer();
                this.timer.schedule(new MyTimeTask(str, str2, i2), (long) (i2 * 1000));
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        H5SplitCompatUtils.doInstall(this);
    }
}

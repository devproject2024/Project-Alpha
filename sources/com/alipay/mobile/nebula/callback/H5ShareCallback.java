package com.alipay.mobile.nebula.callback;

import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5WalletWrapper;

public class H5ShareCallback implements H5CallBack, Runnable {
    private static final String TAG = "H5ShareCallback";
    public static int TIMEOUT = 1000;
    private H5Page h5Page;
    private boolean shareCallBack = false;
    private ShareResult shareResult;

    public interface ShareResult {
        void shareResult(e eVar);

        @Deprecated
        void shareResult(String str, String str2, String str3, String str4);
    }

    public H5ShareCallback(H5Page h5Page2, ShareResult shareResult2) {
        this.h5Page = h5Page2;
        this.shareResult = shareResult2;
        H5Utils.runOnMain(this, (long) TIMEOUT);
    }

    public void onCallBack(e eVar) {
        if (!this.shareCallBack) {
            this.shareCallBack = true;
            H5Log.d(TAG, "getShare or getCollect from share.js");
            if (this.h5Page != null) {
                if (eVar == null) {
                    H5Log.d(TAG, "getShare or getCollect from share.js but get nothing");
                    String shareUrl = this.h5Page.getShareUrl();
                    String string = TextUtils.isEmpty(this.h5Page.getTitle()) ? getResources().getString(R.string.h5_shareurl) : this.h5Page.getTitle();
                    e eVar2 = new e();
                    eVar2.put("imgUrl", (Object) "");
                    eVar2.put("desc", (Object) shareUrl);
                    eVar2.put("title", (Object) string);
                    eVar2.put("link", (Object) null);
                    eVar2.put("fromMeta", (Object) Boolean.FALSE);
                    this.shareResult.shareResult(eVar2);
                    return;
                }
                this.shareResult.shareResult(eVar);
            }
        }
    }

    public void run() {
        if (!this.shareCallBack) {
            this.shareCallBack = true;
            H5Log.d(TAG, "getShare or getCollect timeout return default");
            H5Page h5Page2 = this.h5Page;
            if (h5Page2 != null) {
                String shareUrl = h5Page2.getShareUrl();
                String string = TextUtils.isEmpty(this.h5Page.getTitle()) ? getResources().getString(R.string.h5_shareurl) : this.h5Page.getTitle();
                e eVar = new e();
                eVar.put("imgUrl", (Object) "");
                eVar.put("desc", (Object) shareUrl);
                eVar.put("title", (Object) string);
                eVar.put("link", (Object) null);
                eVar.put("fromMeta", (Object) Boolean.FALSE);
                this.shareResult.shareResult(eVar);
            }
        }
    }

    private Resources getResources() {
        return H5WalletWrapper.getNebulaResources();
    }
}

package com.alipay.mobile.nebulacore.biz;

import android.util.Pair;
import com.alipay.mobile.a.a;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.ui.H5Activity;

class H5BizServiceAdvice implements a {
    private static final String TAG = "H5BizServiceAdvice";
    private String mKey;

    H5BizServiceAdvice(String str) {
        this.mKey = str;
    }

    public void onCallBefore(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onCallBefore: " + str + ", thisPoint: " + obj);
    }

    public Pair<Boolean, Object> onCallAround(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onCallAround: " + str + ", thisPoint: " + obj);
        return null;
    }

    public void onCallAfter(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onCallAfter: " + str + ", thisPoint: " + obj);
    }

    public void onExecutionBefore(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onExecutionBefore: " + str + ", thisPoint: " + obj);
    }

    public Pair<Boolean, Object> onExecutionAround(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onExecutionAround: " + str + ", thisPoint: " + obj);
        return null;
    }

    public void onExecutionAfter(String str, Object obj, Object[] objArr) {
        H5Log.d(TAG, "onExecutionAfter: " + str + ", thisPoint: " + obj);
        if (obj instanceof H5Activity) {
            H5Activity h5Activity = (H5Activity) obj;
            String str2 = h5Activity.getActivityApplication().getAppId() + h5Activity.getActivityApplication().getSourceId();
            if (str2.equals(this.mKey)) {
                H5Log.d(TAG, "result poped: ".concat(String.valueOf(str2)));
                H5BizUtil.popResult(this.mKey);
            }
        }
    }
}

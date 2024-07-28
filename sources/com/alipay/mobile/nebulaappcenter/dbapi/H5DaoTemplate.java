package com.alipay.mobile.nebulaappcenter.dbapi;

import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5DBUtil;

public class H5DaoTemplate {
    private static final String TAG = "H5DaoTemplate";

    /* access modifiers changed from: protected */
    public <T> T execute(H5DaoExecutor<T> h5DaoExecutor) {
        try {
            return h5DaoExecutor.execute(H5DBUtil.getOnLineDBHelperInstance());
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public <T> T executeDB(H5DaoExecutor<T> h5DaoExecutor, boolean z) {
        H5BaseDBHelper h5BaseDBHelper;
        if (z) {
            h5BaseDBHelper = H5DBUtil.getDevDBHelperInstance();
        } else {
            h5BaseDBHelper = H5DBUtil.getOnLineDBHelperInstance();
        }
        try {
            return h5DaoExecutor.execute(h5BaseDBHelper);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }
}

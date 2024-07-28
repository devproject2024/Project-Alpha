package com.alipay.mobile.nebulaappcenter.dbhelp;

import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulaappcenter.dbapi.H5Transaction;

public class H5DBUtil {
    private static final int CONFUSION_DB_VERSION = 10;
    private static final String TAG = "H5DBUtil";
    private static boolean sIsDevDbInUse = false;

    private H5DBUtil() {
    }

    public static H5BaseDBHelper getOnLineDBHelperInstance() {
        return OnlineDbSingletonHolder.INSTANCE;
    }

    public static H5Transaction getH5TransactionInstance() {
        return H5TransactionHelp.INSTANCE;
    }

    public static H5BaseDBHelper getDevDBHelperInstance() {
        sIsDevDbInUse = true;
        return DevDbHelperHolder.INSTANCE;
    }

    public static boolean devDBIsUsing() {
        return sIsDevDbInUse;
    }

    static class OnlineDbSingletonHolder {
        /* access modifiers changed from: private */
        public static H5BaseDBHelper INSTANCE = new H5OnLineDBHelper();

        private OnlineDbSingletonHolder() {
        }

        /* access modifiers changed from: private */
        public static void reset() {
            INSTANCE = new H5OnLineDBHelper();
        }
    }

    static class DevDbHelperHolder {
        /* access modifiers changed from: private */
        public static final H5BaseDBHelper INSTANCE = new H5DevDBOpenHelper();

        private DevDbHelperHolder() {
        }
    }

    static class H5TransactionHelp {
        /* access modifiers changed from: private */
        public static final H5Transaction INSTANCE = new H5TransactionImpl();

        private H5TransactionHelp() {
        }
    }

    private static synchronized void reset() {
        synchronized (H5DBUtil.class) {
            try {
                if (H5Utils.getContext() != null) {
                    H5Log.d(TAG, "start to reset database");
                    long currentTimeMillis = System.currentTimeMillis();
                    getOnLineDBHelperInstance().close();
                    H5Utils.getContext().deleteDatabase(getOnLineDBHelperInstance().getDBName());
                    H5Log.d(TAG, "online database delete succeeded");
                    OnlineDbSingletonHolder.reset();
                    H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_RESET_DATABASE).appendCostTime(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e2) {
                H5Log.e(TAG, "reset database exception", e2);
                H5Monitor.exception(new H5MonitorModel().fail().exceptionType(H5MonitorModel.EXCEPTION_RESET_DATABASE).appendExceptionName(e2.getClass().getName()).appendExceptionMessage(e2.getMessage()).appendMessage("reset database failed"));
            }
        }
    }

    public static void checkDatabase() {
        try {
            getOnLineDBHelperInstance().getReadableDatabase().execSQL("select * from nebula_app_info_table limit 1");
        } catch (Throwable th) {
            H5Log.e(TAG, "query nebula_app_info exception, should recreate", th);
            reset();
        }
    }
}

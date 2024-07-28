package com.alipay.mobile.nebulaappcenter.dbhelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService;
import com.alipay.mobile.nebulaappcenter.dbapi.H5Transaction;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppInfoBean;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppInstallBean;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppPoolBean;
import com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean;
import com.alipay.mobile.nebulaappcenter.service.H5MemoryCache;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public abstract class H5BaseDBHelper extends OrmLiteSqliteOpenHelper {
    public static final int DATABASE_VERSION = 10;
    private final String TAG = getDBLogTag();
    private Dao<H5AppConfigBean, Integer> h5AppConfigDao;
    private Dao<H5NebulaAppBean, Integer> h5AppInfoDao;
    private Dao<H5AppInstallBean, Integer> h5AppInstallDao;

    public abstract String getDBLogTag();

    public abstract String getDBName();

    public H5BaseDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, H5NebulaAppBean.class);
            H5Log.d(this.TAG, "createTable H5NebulaAppBean");
        } catch (Exception e2) {
            H5Log.e(this.TAG, "Can't create database".concat(String.valueOf(e2)));
            logDbError(e2.toString());
        }
        try {
            TableUtils.createTable(connectionSource, H5AppConfigBean.class);
            H5Log.d(this.TAG, "createTable H5AppConfigBean");
        } catch (Exception e3) {
            H5Log.e(this.TAG, "Can't create database".concat(String.valueOf(e3)));
            logDbError(e3.toString());
        }
        try {
            TableUtils.createTable(connectionSource, H5AppInstallBean.class);
            H5Log.d(this.TAG, "createTable H5AppInstallBean");
        } catch (Exception e4) {
            H5Log.e(this.TAG, "Can't create database".concat(String.valueOf(e4)));
            logDbError(e4.toString());
        }
        try {
            H5NebulaDBService.getInstance().setDefaultConfig();
            H5Log.d(this.TAG, "createTable setDefaultConfig");
        } catch (Exception e5) {
            H5Log.e(this.TAG, "Can't create database".concat(String.valueOf(e5)));
            logDbError(e5.toString());
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        String str = this.TAG;
        H5Log.d(str, "database onDowngrade oldVersion " + i2 + " newVersion:" + i3);
        onUpgrade(sQLiteDatabase, i2, i3);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i2, int i3) {
        String str = this.TAG;
        H5Log.d(str, "onUpgrade, oldVersion:" + i2 + ",newVersion:" + i3);
        if (i2 == 5 && i3 == 6) {
            try {
                sQLiteDatabase.execSQL("ALTER table nebula_config add column extra TEXT;");
                H5Log.d(this.TAG, "ALTER table nebula_config add column extra TEXT");
            } catch (Exception e2) {
                logDbError(e2.toString());
                H5Log.e(this.TAG, (Throwable) e2);
            }
        } else if (i2 == 6 && i3 == 7) {
            try {
                sQLiteDatabase.execSQL("ALTER table nebula_app_info_table add column localReport integer;");
                H5Log.d(this.TAG, "ALTER table nebula_app_info_table add column localReport integer");
            } catch (Exception e3) {
                logDbError(e3.toString());
                H5Log.e(this.TAG, (Throwable) e3);
            }
        } else if (i2 == 7 && i3 == 8) {
            addFor8(sQLiteDatabase);
        } else if ((i2 == 7 || i2 == 8) && i3 == 9) {
            if (i2 == 7) {
                addFor8(sQLiteDatabase);
            }
            addFor9(sQLiteDatabase);
        } else if (i2 == 9 && i3 == 10) {
            try {
                sQLiteDatabase.execSQL("ALTER table nebula_app_info_table add column nbl_id TEXT;");
                H5Log.d(this.TAG, "ALTER table nebula_app_info_table add column nbl_id TEXT");
            } catch (Exception e4) {
                logDbError(e4.toString());
                H5Log.e(this.TAG, (Throwable) e4);
            }
        } else if (i2 != i3) {
            try {
                TableUtils.dropTable(connectionSource, H5AppInfoBean.class, true);
                H5Log.d(this.TAG, "dropTable H5AppInfoBean");
            } catch (Exception e5) {
                H5Log.e(this.TAG, "Can't dropTable database".concat(String.valueOf(e5)));
                logDbError(e5.toString());
            }
            try {
                TableUtils.dropTable(connectionSource, H5AppConfigBean.class, true);
                H5Log.d(this.TAG, "dropTable H5AppConfigBean");
            } catch (Exception e6) {
                H5Log.e(this.TAG, "Can't dropTable database".concat(String.valueOf(e6)));
                logDbError(e6.toString());
            }
            try {
                TableUtils.dropTable(connectionSource, H5AppInstallBean.class, true);
                H5Log.d(this.TAG, "dropTable H5AppInstallBean");
            } catch (Exception e7) {
                H5Log.e(this.TAG, "Can't dropTable database".concat(String.valueOf(e7)));
                logDbError(e7.toString());
            }
            try {
                TableUtils.dropTable(connectionSource, H5AppPoolBean.class, true);
                H5Log.d(this.TAG, "dropTable H5AppPoolBean");
            } catch (Exception e8) {
                H5Log.e(this.TAG, "Can't dropTable database".concat(String.valueOf(e8)));
                logDbError(e8.toString());
            }
            try {
                TableUtils.dropTable(connectionSource, H5NebulaAppBean.class, true);
                H5Log.d(this.TAG, "dropTable H5NebulaAppBean");
            } catch (Exception e9) {
                H5Log.e(this.TAG, (Throwable) e9);
                logDbError(e9.toString());
            }
            try {
                onCreate(sQLiteDatabase, connectionSource);
            } catch (Exception e10) {
                H5Log.e(this.TAG, (Throwable) e10);
                logDbError(e10.toString());
            }
        }
    }

    private void addFor8(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER table nebula_app_info_table add column nbAppType integer;");
            H5Log.d(this.TAG, "ALTER table nebula_app_info_table add column nbAppType integer");
        } catch (Exception e2) {
            logDbError(e2.toString());
            H5Log.e(this.TAG, (Throwable) e2);
        }
    }

    private void addFor9(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER table nebula_app_install add column installPath TEXT;");
            H5Log.d(this.TAG, "ALTER table nebula_app_install add column installPath TEXT");
        } catch (Exception e2) {
            logDbError(e2.toString());
            H5Log.e(this.TAG, (Throwable) e2);
        }
    }

    public Dao<H5NebulaAppBean, Integer> getH5AppInfoDao() throws SQLException {
        if (this.h5AppInfoDao == null) {
            try {
                this.h5AppInfoDao = getDao(H5NebulaAppBean.class);
            } catch (Throwable th) {
                H5Log.e(this.TAG, th);
                logDbError(th.toString());
            }
        }
        return this.h5AppInfoDao;
    }

    public Dao<H5AppConfigBean, Integer> getH5AppConfigDao() throws SQLException {
        if (this.h5AppConfigDao == null) {
            try {
                this.h5AppConfigDao = getDao(H5AppConfigBean.class);
            } catch (Throwable th) {
                H5Log.e(this.TAG, th);
                logDbError(th.toString());
            }
        }
        return this.h5AppConfigDao;
    }

    public Dao<H5AppInstallBean, Integer> getH5AppInstallDao() throws SQLException {
        if (this.h5AppInstallDao == null) {
            try {
                this.h5AppInstallDao = getDao(H5AppInstallBean.class);
            } catch (Throwable th) {
                H5Log.e(this.TAG, th);
                logDbError(th.toString());
            }
        }
        return this.h5AppInstallDao;
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        String str = this.TAG;
        H5Log.d(str, getDBName() + " onOpen !");
    }

    public void close() {
        super.close();
        String str = this.TAG;
        H5Log.d(str, getDBName() + " onClose !");
        this.h5AppInfoDao = null;
        this.h5AppInstallDao = null;
        this.h5AppConfigDao = null;
    }

    public synchronized void clearAllTable() {
        H5Transaction h5TransactionInstance;
        H5DBUtil.getH5TransactionInstance().beginTransaction();
        try {
            TableUtils.clearTable((ConnectionSource) this.connectionSource, H5NebulaAppBean.class);
            TableUtils.clearTable((ConnectionSource) this.connectionSource, H5AppInstallBean.class);
            H5Log.d(this.TAG, "clearAllTable");
            H5DBUtil.getH5TransactionInstance().setTransactionSuccessful();
            h5TransactionInstance = H5DBUtil.getH5TransactionInstance();
        } catch (Exception e2) {
            try {
                H5Log.e(this.TAG, "Can't clearTable database".concat(String.valueOf(e2)));
                h5TransactionInstance = H5DBUtil.getH5TransactionInstance();
            } catch (Throwable th) {
                H5DBUtil.getH5TransactionInstance().endTransaction();
                throw th;
            }
        }
        h5TransactionInstance.endTransaction();
        try {
            H5MemoryCache.getInstance().clearMemory();
        } catch (Exception e3) {
            H5Log.e(this.TAG, (Throwable) e3);
        }
    }

    private void logDbError(String str) {
        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
        if (h5LogProvider != null) {
            h5LogProvider.log("h5_nebula_db_exception", (String) null, (String) null, (String) null, "exception=".concat(String.valueOf(str)));
        }
    }
}

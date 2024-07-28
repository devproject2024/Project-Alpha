package com.alipay.mobile.nebulaappcenter.dbhelp;

import android.database.sqlite.SQLiteDatabase;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5DevDBOpenHelper extends H5BaseDBHelper {
    private static final String DATABASE_NAME = "nebula_app_dev.db";

    public String getDBLogTag() {
        return "H5DBHelper_dev";
    }

    public String getDBName() {
        return DATABASE_NAME;
    }

    public H5DevDBOpenHelper() {
        super(H5Utils.getContext(), DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 10);
    }
}

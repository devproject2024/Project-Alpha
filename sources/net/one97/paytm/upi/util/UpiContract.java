package net.one97.paytm.upi.util;

import android.net.Uri;
import android.provider.BaseColumns;

public class UpiContract {
    public static final String AUTHORITY = "net.one97.paytm.upi.provider";
    public static final Uri BASE_CONTENT_URI = new Uri.Builder().scheme("content").authority(AUTHORITY).build();

    public interface DeviceInfoColumns extends BaseColumns {
        public static final String ANDROID_ID = "android_id";
    }

    public static final class UPI_ACCOUNT_PROVIDER {
        public static final String ACCOUNT_PROVIDER = "accountProvider";
        public static final Uri ACCOUNT_PROVIDER_URI = UpiContract.BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        public static final String BANK_LOGO_URL = "bankLogoUrl";
        public static final String ID = "id";
        public static final String IFSC = "ifsc";
        public static final String IIN = "iin";
        public static final String REG_MOB_FORMAT = "regMobFormat";
        public static final String TABLE_NAME = "account_providers";
        public static final String _ID = "_id";
    }

    public static final class DeviceInfo implements DeviceInfoColumns {
        public static final String BASE_PATH = "deviceinfo";
        private static final String BASE_TYPE = "vnd.paytm.app-upi";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.paytm.app-upi";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.paytm.app-upi";
        public static final Uri CONTENT_URI = UpiContract.BASE_CONTENT_URI.buildUpon().appendPath(BASE_PATH).build();
        public static final String SORT_ORDER_DEFAULT = "_id ASC";

        private DeviceInfo() {
        }
    }
}

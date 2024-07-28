package com.google.android.datatransport.cct.a;

import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.datatransport.cct.a.e;

public abstract class k {

    public static abstract class a {
        public abstract a a(a aVar);

        public abstract a a(b bVar);

        public abstract k a();
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        static {
            UNKNOWN = new b(H5Utils.NETWORK_TYPE_UNKNOWN, 0, 0);
            ANDROID_FIREBASE = new b("ANDROID_FIREBASE", 1, 23);
            b[] bVarArr = {UNKNOWN, ANDROID_FIREBASE};
        }

        private b(int i2) {
        }
    }

    public static a c() {
        return new e.a();
    }

    public abstract b a();

    public abstract a b();
}

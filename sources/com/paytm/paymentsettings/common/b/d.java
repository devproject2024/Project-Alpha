package com.paytm.paymentsettings.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.mobile.nebula.util.H5Utils;
import kotlin.g.b.k;
import kotlin.u;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43432a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(Context context) {
            k.c(context, "context");
            try {
                Object systemService = context.getSystemService("connectivity");
                if (systemService != null) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        if (activeNetworkInfo.isConnected()) {
                            if (activeNetworkInfo.getType() == 1) {
                                return H5Utils.NETWORK_TYPE_WIFI;
                            }
                            if (activeNetworkInfo.getType() == 0) {
                                switch (activeNetworkInfo.getSubtype()) {
                                    case 1:
                                    case 2:
                                    case 4:
                                    case 7:
                                    case 11:
                                        return H5Utils.NETWORK_TYPE_2G;
                                    case 3:
                                    case 5:
                                    case 6:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 12:
                                    case 14:
                                    case 15:
                                        return H5Utils.NETWORK_TYPE_3G;
                                    case 13:
                                        return H5Utils.NETWORK_TYPE_4G;
                                    default:
                                        return null;
                                }
                            }
                            return null;
                        }
                    }
                    return null;
                }
                throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
            } catch (Exception e2) {
                b.a(e2);
            }
        }

        public static String a(String str) {
            k.c(str, "bankCode");
            switch (str.hashCode()) {
                case 79364:
                    return str.equals("PNB") ? "Punjab National Bank" : "";
                case 81882:
                    if (str.equals("SBI")) {
                        return "State Bank of India";
                    }
                    return "";
                case 2023329:
                    if (str.equals("AXIS")) {
                        return "AXIS Bank";
                    }
                    return "";
                case 2212537:
                    if (str.equals("HDFC")) {
                        return "HDFC Bank";
                    }
                    return "";
                case 2398226:
                    if (str.equals("NKMB")) {
                        return "Kotak Mahindra Bank";
                    }
                    return "";
                case 69485333:
                    if (str.equals("ICICI")) {
                        return "ICICI Bank";
                    }
                    return "";
                default:
                    return "";
            }
        }
    }
}

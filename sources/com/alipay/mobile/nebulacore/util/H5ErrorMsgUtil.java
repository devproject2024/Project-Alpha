package com.alipay.mobile.nebulacore.util;

import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5ErrorMsgUtil {
    public static final int H5_NETWORK_AUTH_ERROR = 8;
    public static final int H5_NETWORK_CANCEL_ERROR = 13;
    public static final int H5_NETWORK_CONNECTION_EXCEPTION = 3;
    public static final int H5_NETWORK_DNS_ERROR = 9;
    public static final int H5_NETWORK_IO_EXCEPTION = 6;
    public static final int H5_NETWORK_SCHEDULE_ERROR = 7;
    public static final int H5_NETWORK_SERVER_EXCEPTION = 5;
    public static final int H5_NETWORK_SOCKET_EXCEPTION = 4;
    public static final int H5_NETWORK_SSL_EXCEPTION = 2;
    public static final int H5_NETWORK_TRAFIC_BEYOND_LIMIT = 11;
    public static final int H5_NETWORK_UNAVAILABLE = 1;
    public static final int H5_NETWORK_UNKNOWN_ERROR = 0;
    public static final int H5_UC_NETWORK_UNAVAILABLE = -80;
    public static final int H5_URL_ERROR = 10;

    public static String getErrorPageMsg(int i2) {
        if (i2 == -6 || i2 == -7 || i2 == -80 || i2 == 1) {
            return H5Environment.getResources().getString(R.string.h5_network_unavailable);
        }
        if (i2 == -2 || i2 == 9) {
            return H5Environment.getResources().getString(R.string.h5_DNS_resolution_failed_new);
        }
        if (i2 == -4 || i2 == -12 || i2 == -5 || i2 == -10 || i2 == -11 || i2 == 10 || i2 == 8 || i2 == 7) {
            return H5Environment.getResources().getString(R.string.h5_URL_error_new);
        }
        if (i2 == -8 || i2 == 3 || i2 == 4) {
            return H5Environment.getResources().getString(R.string.h5_error_timeout_new);
        }
        if (i2 == -9) {
            return H5Environment.getResources().getString(R.string.h5_redirect_loop);
        }
        if (i2 == 2) {
            return H5Environment.getResources().getString(R.string.h5_SSL_certificate_error_new);
        }
        if (i2 == -1 || i2 == -3 || i2 == -13 || i2 == -14 || i2 == -15 || i2 == 0 || i2 == 5 || i2 == 6 || i2 == 11 || i2 == 13) {
            return H5Environment.getResources().getString(R.string.h5_network_error_new);
        }
        if (i2 == 400 || i2 == 503 || i2 == 401 || i2 == 409 || i2 == 410 || i2 == 411 || i2 == 412 || i2 == 500 || i2 == 501 || i2 == 502) {
            return H5Environment.getResources().getString(R.string.h5_server_error_new);
        }
        return H5Environment.getResources().getString(R.string.h5_unknown_error);
    }
}

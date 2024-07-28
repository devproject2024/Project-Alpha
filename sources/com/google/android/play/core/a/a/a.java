package com.google.android.play.core.a.a;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f36892a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, String> f36893b = new HashMap();

    static {
        f36892a.put(-2, "An unknown error occurred.");
        f36892a.put(-3, "The API is not available on this device.");
        f36892a.put(-4, "The request that was sent by the app is malformed.");
        f36892a.put(-5, "The install is unavailable to this user or device.");
        f36892a.put(-6, "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        f36892a.put(-7, "The install/update has not been (fully) downloaded yet.");
        f36892a.put(-8, "The install is already in progress and there is no UI flow to resume.");
        f36892a.put(-100, "An internal error happened in the Play Store.");
        f36893b.put(-2, "ERROR_UNKNOWN");
        f36893b.put(-3, "ERROR_API_NOT_AVAILABLE");
        f36893b.put(-4, "ERROR_INVALID_REQUEST");
        f36893b.put(-5, "ERROR_INSTALL_UNAVAILABLE");
        f36893b.put(-6, "ERROR_INSTALL_NOT_ALLOWED");
        f36893b.put(-7, "ERROR_DOWNLOAD_NOT_PRESENT");
        f36893b.put(-8, "ERROR_INSTALL_IN_PROGRESS");
        f36893b.put(-100, "ERROR_INTERNAL_ERROR");
        f36893b.put(-9, "ERROR_PLAY_STORE_NOT_FOUND");
    }

    public static String a(int i2) {
        Map<Integer, String> map = f36892a;
        Integer valueOf = Integer.valueOf(i2);
        if (!map.containsKey(valueOf) || !f36893b.containsKey(valueOf)) {
            return "";
        }
        String str = f36892a.get(valueOf);
        String str2 = f36893b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 103 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}

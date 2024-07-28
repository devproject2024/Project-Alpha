package com.google.android.play.core.assetpacks.a;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f36944a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, String> f36945b = new HashMap();

    static {
        f36944a.put(-1, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        f36944a.put(-2, "The requested pack is not available.");
        f36944a.put(-3, "The request is invalid.");
        f36944a.put(-4, "The requested download is not found.");
        f36944a.put(-5, "The Asset Delivery API is not available.");
        f36944a.put(-6, "Network error. Unable to obtain the asset pack details.");
        f36944a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f36944a.put(-10, "Asset pack download failed due to insufficient storage.");
        f36944a.put(-11, "The Play Store app is either not installed or not the official version.");
        f36944a.put(-12, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        f36944a.put(-100, "Unknown error downloading an asset pack.");
        f36945b.put(-1, "APP_UNAVAILABLE");
        f36945b.put(-2, "PACK_UNAVAILABLE");
        f36945b.put(-3, "INVALID_REQUEST");
        f36945b.put(-4, "DOWNLOAD_NOT_FOUND");
        f36945b.put(-5, "API_NOT_AVAILABLE");
        f36945b.put(-6, "NETWORK_ERROR");
        f36945b.put(-7, "ACCESS_DENIED");
        f36945b.put(-10, "INSUFFICIENT_STORAGE");
        f36945b.put(-11, "PLAY_STORE_NOT_FOUND");
        f36945b.put(-12, "NETWORK_UNRESTRICTED");
        f36945b.put(-100, "INTERNAL_ERROR");
    }

    public static String a(int i2) {
        Map<Integer, String> map = f36944a;
        Integer valueOf = Integer.valueOf(i2);
        if (!map.containsKey(valueOf)) {
            return "";
        }
        String str = f36944a.get(valueOf);
        String str2 = f36945b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 113 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}

package com.google.android.play.core.d.a;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f37339a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, String> f37340b = new HashMap();

    static {
        f37339a.put(-1, "Too many sessions are running for current app, existing sessions must be resolved first.");
        f37339a.put(-2, "A requested module is not available (to this user/device, for the installed apk).");
        f37339a.put(-3, "Request is otherwise invalid.");
        f37339a.put(-4, "Requested session is not found.");
        f37339a.put(-5, "Split Install API is not available.");
        f37339a.put(-6, "Network error: unable to obtain split details.");
        f37339a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f37339a.put(-8, "Requested session contains modules from an existing active session and also new");
        f37339a.put(-9, "Service handling split install has died.");
        f37339a.put(-10, "Install failed due to insufficient storage.");
        f37339a.put(-11, "Signature verification error when invoking SplitCompat.");
        f37339a.put(-12, "Error in SplitCompat emulation.");
        f37339a.put(-13, "Error in copying files for SplitCompat.");
        f37339a.put(-100, "Unknown error processing split install.");
        f37340b.put(-1, "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        f37340b.put(-2, "MODULE_UNAVAILABLE");
        f37340b.put(-3, "INVALID_REQUEST");
        f37340b.put(-4, "DOWNLOAD_NOT_FOUND");
        f37340b.put(-5, "API_NOT_AVAILABLE");
        f37340b.put(-6, "NETWORK_ERROR");
        f37340b.put(-7, "ACCESS_DENIED");
        f37340b.put(-8, "INCOMPATIBLE_WITH_EXISTING_SESSION");
        f37340b.put(-9, "SERVICE_DIED");
        f37340b.put(-10, "INSUFFICIENT_STORAGE");
        f37340b.put(-11, "SPLITCOMPAT_VERIFICATION_ERROR");
        f37340b.put(-12, "SPLITCOMPAT_EMULATION_ERROR");
        f37340b.put(-13, "SPLITCOMPAT_COPY_ERROR");
        f37340b.put(-14, "PLAY_STORE_NOT_FOUND");
    }

    public static String a(int i2) {
        Map<Integer, String> map = f37339a;
        Integer valueOf = Integer.valueOf(i2);
        if (!map.containsKey(valueOf) || !f37340b.containsKey(valueOf)) {
            return "";
        }
        String str = f37339a.get(valueOf);
        String str2 = f37340b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 118 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}

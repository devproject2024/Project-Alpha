package com.paytmmall.clpartifact.utils;

import com.paytmmall.clpartifact.common.CLPArtifact;

public class LogUtils {
    public static void d(String str, String str2) {
        boolean z = CLPArtifact.isDebug;
    }

    public static void e(String str, String str2, Throwable th) {
        boolean z = CLPArtifact.isDebug;
    }

    public static void e(String str, String str2) {
        boolean z = CLPArtifact.isDebug;
    }

    public static void w(String str, String str2) {
        boolean z = CLPArtifact.isDebug;
    }

    public static void printStackTrace(Exception exc) {
        if (CLPArtifact.isDebug) {
            exc.printStackTrace();
        }
    }
}

package com.appsflyer.internal;

import com.appsflyer.AFLogger;

public final class ag {

    /* renamed from: ı  reason: contains not printable characters */
    private a f169 = new a() {
        /* renamed from: ǃ  reason: contains not printable characters */
        public final Class<?> m132(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    interface a {
        /* renamed from: ǃ  reason: contains not printable characters */
        Class<?> m133(String str) throws ClassNotFoundException;
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final String m131() {
        for (c cVar : c.values()) {
            if (m130(cVar.f179)) {
                return cVar.f180;
            }
        }
        return c.DEFAULT.f180;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private boolean m130(String str) {
        try {
            this.f169.m133(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    enum c {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT("android_native", "android_native"),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin");
        
        /* access modifiers changed from: private */

        /* renamed from: і  reason: contains not printable characters */
        public String f179;
        /* access modifiers changed from: private */

        /* renamed from: Ӏ  reason: contains not printable characters */
        public String f180;

        private c(String str, String str2) {
            this.f180 = str;
            this.f179 = str2;
        }
    }
}

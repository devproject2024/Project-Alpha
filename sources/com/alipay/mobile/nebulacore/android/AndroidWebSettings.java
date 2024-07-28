package com.alipay.mobile.nebulacore.android;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.webview.APWebSettings;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AndroidWebSettings implements APWebSettings {
    public static final String TAG = "AndroidWebSettings";
    private static Method setMixedContentModeMethod;
    private WebSettings webSettings;

    public final String getDefaultUserAgent(Context context) {
        return null;
    }

    public final void setEnableFastScroller(boolean z) {
    }

    public final void setPageCacheCapacity(int i2) {
    }

    AndroidWebSettings(WebSettings webSettings2) {
        this.webSettings = webSettings2;
        if (this.webSettings != null && Build.VERSION.SDK_INT >= 21) {
            if (setMixedContentModeMethod == null) {
                try {
                    setMixedContentModeMethod = this.webSettings.getClass().getMethod("setMixedContentMode", new Class[]{Integer.TYPE});
                } catch (NoSuchMethodException e2) {
                    H5Log.e(TAG, "Exception", e2);
                }
            }
            Method method = setMixedContentModeMethod;
            if (method != null) {
                try {
                    method.invoke(this.webSettings, new Object[]{0});
                } catch (IllegalAccessException e3) {
                    H5Log.e(TAG, "AndroidWebSettings IllegalAccessException", e3);
                } catch (InvocationTargetException e4) {
                    H5Log.e(TAG, "AndroidWebSettings InvocationTargetException", e4);
                }
            }
        }
    }

    public final void setSupportZoom(boolean z) {
        this.webSettings.setSupportZoom(z);
    }

    public final boolean supportZoom() {
        return this.webSettings.supportZoom();
    }

    public final boolean getMediaPlaybackRequiresUserGesture() {
        if (Build.VERSION.SDK_INT >= 17) {
            return this.webSettings.getMediaPlaybackRequiresUserGesture();
        }
        return false;
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.webSettings.setMediaPlaybackRequiresUserGesture(z);
            } catch (NoSuchMethodError e2) {
                H5Log.e(TAG, "There is no method some models.", e2);
            }
        }
    }

    public final boolean getBuiltInZoomControls() {
        return this.webSettings.getBuiltInZoomControls();
    }

    public final void setBuiltInZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webSettings.setBuiltInZoomControls(z);
        }
    }

    public final boolean getDisplayZoomControls() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.webSettings.getDisplayZoomControls();
        }
        return false;
    }

    public final void setDisplayZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webSettings.setDisplayZoomControls(z);
        }
    }

    public final boolean getAllowFileAccess() {
        return this.webSettings.getAllowFileAccess();
    }

    public final void setAllowFileAccess(boolean z) {
        this.webSettings.setAllowFileAccess(z);
    }

    public final boolean getAllowContentAccess() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.webSettings.getAllowContentAccess();
        }
        return false;
    }

    public final void setAllowContentAccess(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.webSettings.setAllowContentAccess(z);
        }
    }

    public final boolean getLoadWithOverviewMode() {
        return this.webSettings.getLoadWithOverviewMode();
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.webSettings.setLoadWithOverviewMode(z);
    }

    public final boolean getSaveFormData() {
        return this.webSettings.getSaveFormData();
    }

    public final void setSaveFormData(boolean z) {
        this.webSettings.setSaveFormData(z);
    }

    public final boolean getSavePassword() {
        return this.webSettings.getSavePassword();
    }

    public final void setSavePassword(boolean z) {
        this.webSettings.setSavePassword(z);
    }

    public final int getTextZoom() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.webSettings.getTextZoom();
        }
        return 10;
    }

    public final void setTextZoom(int i2) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.webSettings.setTextZoom(i2);
        }
    }

    public final APWebSettings.TextSize getTextSize() {
        return APWebSettings.TextSize.valueOf(this.webSettings.getTextSize().name());
    }

    public final void setTextSize(APWebSettings.TextSize textSize) {
        WebSettings.TextSize textSize2;
        int i2 = AnonymousClass1.$SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize[textSize.ordinal()];
        if (i2 == 1) {
            textSize2 = WebSettings.TextSize.LARGER;
        } else if (i2 == 2) {
            textSize2 = WebSettings.TextSize.LARGEST;
        } else if (i2 == 3) {
            textSize2 = WebSettings.TextSize.NORMAL;
        } else if (i2 != 4) {
            textSize2 = i2 != 5 ? null : WebSettings.TextSize.SMALLEST;
        } else {
            textSize2 = WebSettings.TextSize.SMALLER;
        }
        if (textSize2 != null) {
            this.webSettings.setTextSize(textSize2);
        }
    }

    public final APWebSettings.ZoomDensity getDefaultZoom() {
        return APWebSettings.ZoomDensity.valueOf(this.webSettings.getDefaultZoom().name());
    }

    public final boolean getUseWideViewPort() {
        return this.webSettings.getUseWideViewPort();
    }

    public final void setUseWideViewPort(boolean z) {
        this.webSettings.setUseWideViewPort(z);
    }

    public final void setSupportMultipleWindows(boolean z) {
        this.webSettings.setSupportMultipleWindows(z);
    }

    public final boolean supportMultipleWindows() {
        return this.webSettings.supportMultipleWindows();
    }

    public final APWebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return APWebSettings.LayoutAlgorithm.valueOf(this.webSettings.getLayoutAlgorithm().name());
    }

    public final void setLayoutAlgorithm(APWebSettings.LayoutAlgorithm layoutAlgorithm) {
        WebSettings.LayoutAlgorithm layoutAlgorithm2;
        int i2 = AnonymousClass1.$SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm[layoutAlgorithm.ordinal()];
        if (i2 == 1) {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
        } else if (i2 == 2) {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.NORMAL;
        } else if (i2 != 3) {
            layoutAlgorithm2 = (i2 == 4 && Build.VERSION.SDK_INT >= 19) ? WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING : null;
        } else {
            layoutAlgorithm2 = WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        }
        if (layoutAlgorithm2 != null) {
            this.webSettings.setLayoutAlgorithm(layoutAlgorithm2);
        }
    }

    public final String getStandardFontFamily() {
        return this.webSettings.getStandardFontFamily();
    }

    public final void setStandardFontFamily(String str) {
        this.webSettings.setStandardFontFamily(str);
    }

    public final String getFixedFontFamily() {
        return this.webSettings.getFixedFontFamily();
    }

    public final void setFixedFontFamily(String str) {
        this.webSettings.setFixedFontFamily(str);
    }

    public final String getSansSerifFontFamily() {
        return this.webSettings.getSansSerifFontFamily();
    }

    public final void setSansSerifFontFamily(String str) {
        this.webSettings.setSansSerifFontFamily(str);
    }

    public final String getSerifFontFamily() {
        return this.webSettings.getSerifFontFamily();
    }

    public final void setSerifFontFamily(String str) {
        this.webSettings.setSerifFontFamily(str);
    }

    public final String getCursiveFontFamily() {
        return this.webSettings.getCursiveFontFamily();
    }

    public final void setCursiveFontFamily(String str) {
        this.webSettings.setCursiveFontFamily(str);
    }

    public final String getFantasyFontFamily() {
        return this.webSettings.getFantasyFontFamily();
    }

    public final void setFantasyFontFamily(String str) {
        this.webSettings.setFantasyFontFamily(str);
    }

    public final int getMinimumFontSize() {
        return this.webSettings.getMinimumFontSize();
    }

    public final void setMinimumFontSize(int i2) {
        this.webSettings.setMinimumFontSize(i2);
    }

    public final int getMinimumLogicalFontSize() {
        return this.webSettings.getMinimumLogicalFontSize();
    }

    public final void setMinimumLogicalFontSize(int i2) {
        this.webSettings.setMinimumLogicalFontSize(i2);
    }

    public final int getDefaultFontSize() {
        return this.webSettings.getDefaultFontSize();
    }

    public final void setDefaultFontSize(int i2) {
        this.webSettings.setDefaultFontSize(i2);
    }

    public final int getDefaultFixedFontSize() {
        return this.webSettings.getDefaultFixedFontSize();
    }

    public final void setDefaultFixedFontSize(int i2) {
        this.webSettings.setDefaultFixedFontSize(i2);
    }

    public final boolean getLoadsImagesAutomatically() {
        return this.webSettings.getLoadsImagesAutomatically();
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.webSettings.setLoadsImagesAutomatically(z);
    }

    public final boolean getBlockNetworkImage() {
        return this.webSettings.getBlockNetworkImage();
    }

    public final void setBlockNetworkImage(boolean z) {
        this.webSettings.setBlockNetworkImage(z);
    }

    public final boolean getJavaScriptEnabled() {
        return this.webSettings.getJavaScriptEnabled();
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.webSettings.setJavaScriptEnabled(z);
    }

    public final void setGeolocationDatabasePath(String str) {
        this.webSettings.setGeolocationDatabasePath(str);
    }

    public final void setAppCacheEnabled(boolean z) {
        this.webSettings.setAppCacheEnabled(z);
    }

    public final void setAppCachePath(String str) {
        this.webSettings.setAppCachePath(str);
    }

    public final boolean getDatabaseEnabled() {
        return this.webSettings.getDatabaseEnabled();
    }

    public final void setDatabaseEnabled(boolean z) {
        this.webSettings.setDatabaseEnabled(z);
    }

    public final boolean getDomStorageEnabled() {
        return this.webSettings.getDomStorageEnabled();
    }

    public final void setDomStorageEnabled(boolean z) {
        this.webSettings.setDomStorageEnabled(z);
    }

    public final String getDatabasePath() {
        return this.webSettings.getDatabasePath();
    }

    public final void setDatabasePath(String str) {
        this.webSettings.setDatabasePath(str);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.webSettings.setGeolocationEnabled(z);
    }

    public final boolean getAllowUniversalAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.webSettings.getAllowUniversalAccessFromFileURLs();
        }
        return false;
    }

    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.webSettings.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    public final boolean getAllowFileAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.webSettings.getAllowFileAccessFromFileURLs();
        }
        return false;
    }

    public final void setAllowFileAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.webSettings.setAllowFileAccessFromFileURLs(z);
        }
    }

    public final APWebSettings.PluginState getPluginState() {
        return APWebSettings.PluginState.valueOf(this.webSettings.getPluginState().name());
    }

    /* renamed from: com.alipay.mobile.nebulacore.android.AndroidWebSettings$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm = new int[APWebSettings.LayoutAlgorithm.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState = new int[APWebSettings.PluginState.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize = new int[APWebSettings.TextSize.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008d */
        static {
            /*
                com.alipay.mobile.nebula.webview.APWebSettings$PluginState[] r0 = com.alipay.mobile.nebula.webview.APWebSettings.PluginState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.alipay.mobile.nebula.webview.APWebSettings$PluginState r2 = com.alipay.mobile.nebula.webview.APWebSettings.PluginState.OFF     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState     // Catch:{ NoSuchFieldError -> 0x001f }
                com.alipay.mobile.nebula.webview.APWebSettings$PluginState r3 = com.alipay.mobile.nebula.webview.APWebSettings.PluginState.ON     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState     // Catch:{ NoSuchFieldError -> 0x002a }
                com.alipay.mobile.nebula.webview.APWebSettings$PluginState r4 = com.alipay.mobile.nebula.webview.APWebSettings.PluginState.ON_DEMAND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.alipay.mobile.nebula.webview.APWebSettings$LayoutAlgorithm[] r3 = com.alipay.mobile.nebula.webview.APWebSettings.LayoutAlgorithm.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm = r3
                int[] r3 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm     // Catch:{ NoSuchFieldError -> 0x003d }
                com.alipay.mobile.nebula.webview.APWebSettings$LayoutAlgorithm r4 = com.alipay.mobile.nebula.webview.APWebSettings.LayoutAlgorithm.NARROW_COLUMNS     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.alipay.mobile.nebula.webview.APWebSettings$LayoutAlgorithm r4 = com.alipay.mobile.nebula.webview.APWebSettings.LayoutAlgorithm.NORMAL     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.alipay.mobile.nebula.webview.APWebSettings$LayoutAlgorithm r4 = com.alipay.mobile.nebula.webview.APWebSettings.LayoutAlgorithm.SINGLE_COLUMN     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r3 = 4
                int[] r4 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$LayoutAlgorithm     // Catch:{ NoSuchFieldError -> 0x005c }
                com.alipay.mobile.nebula.webview.APWebSettings$LayoutAlgorithm r5 = com.alipay.mobile.nebula.webview.APWebSettings.LayoutAlgorithm.TEXT_AUTOSIZING     // Catch:{ NoSuchFieldError -> 0x005c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize[] r4 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize = r4
                int[] r4 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize     // Catch:{ NoSuchFieldError -> 0x006f }
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize r5 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.LARGER     // Catch:{ NoSuchFieldError -> 0x006f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize r4 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.LARGEST     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize r1 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.NORMAL     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize     // Catch:{ NoSuchFieldError -> 0x008d }
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize r1 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.SMALLER     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$TextSize     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.alipay.mobile.nebula.webview.APWebSettings$TextSize r1 = com.alipay.mobile.nebula.webview.APWebSettings.TextSize.SMALLEST     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.android.AndroidWebSettings.AnonymousClass1.<clinit>():void");
        }
    }

    public final void setPluginState(APWebSettings.PluginState pluginState) {
        int i2 = AnonymousClass1.$SwitchMap$com$alipay$mobile$nebula$webview$APWebSettings$PluginState[pluginState.ordinal()];
        if (i2 == 1) {
            this.webSettings.setPluginState(WebSettings.PluginState.OFF);
        } else if (i2 == 2) {
            this.webSettings.setPluginState(WebSettings.PluginState.ON);
        } else if (i2 == 3) {
            this.webSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        }
    }

    public final boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.webSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.webSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final String getDefaultTextEncodingName() {
        return this.webSettings.getDefaultTextEncodingName();
    }

    public final void setDefaultTextEncodingName(String str) {
        this.webSettings.setDefaultTextEncodingName(str);
    }

    public final String getUserAgentString() {
        return this.webSettings.getUserAgentString();
    }

    public final void setUserAgentString(String str) {
        this.webSettings.setUserAgentString(str);
    }

    public final void setNeedInitialFocus(boolean z) {
        this.webSettings.setNeedInitialFocus(z);
    }

    public final int getCacheMode() {
        return this.webSettings.getCacheMode();
    }

    public final void setCacheMode(int i2) {
        this.webSettings.setCacheMode(i2);
    }
}

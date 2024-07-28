package com.alipay.mobile.nebula.config;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H5PluginConfig {
    public static final boolean DEFAULT_LAZY_INIT = true;
    public static final String TAG = "H5PluginConfig";
    public String bundleName;
    public String className;
    public List<String> eventList;
    public boolean lazyInit;
    public String scope;

    public H5PluginConfig(String str, String str2, String str3, String str4, boolean z) {
        init();
        this.bundleName = str;
        this.className = str2;
        this.scope = str3;
        this.lazyInit = z;
        setEvents(str4);
    }

    public H5PluginConfig(String str, String str2, String str3, String str4) {
        init();
        this.bundleName = str;
        this.className = str2;
        this.scope = str3;
        setEvents(str4);
    }

    public H5PluginConfig(String str, String str2, String str3, List<String> list) {
        init();
        this.bundleName = str;
        this.className = str2;
        this.scope = str3;
        setEventsList(list);
    }

    public H5PluginConfig() {
        init();
    }

    private void init() {
        this.eventList = new ArrayList();
        this.lazyInit = true;
    }

    public void setEventsList(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.eventList.addAll(list);
        }
    }

    public void setEvents(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String trim : Arrays.asList(str.split("\\|"))) {
                String trim2 = trim.trim();
                if (TextUtils.isEmpty(trim2)) {
                    H5Log.d(TAG, "invalid empty event");
                } else {
                    H5Log.debug(TAG, "add event config ".concat(String.valueOf(trim2)));
                    this.eventList.add(trim2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r1.eventList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean configInvalid() {
        /*
            r1 = this;
            java.lang.String r0 = r1.bundleName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = r1.className
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001d
            java.util.List<java.lang.String> r0 = r1.eventList
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            return r0
        L_0x001d:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.config.H5PluginConfig.configInvalid():boolean");
    }
}

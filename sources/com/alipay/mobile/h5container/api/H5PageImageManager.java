package com.alipay.mobile.h5container.api;

import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5PageImageManager {
    private static final String TAG = "H5PageImageManager";
    private static H5PageImageManager instance;
    private String lastMainUrl = "";
    private Map<String, List<H5PageImage>> providerMap = new ConcurrentHashMap();

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.alipay.mobile.h5container.api.H5PageImageManager getInstance() {
        /*
            java.lang.Class<com.alipay.mobile.h5container.api.H5PageImageManager> r0 = com.alipay.mobile.h5container.api.H5PageImageManager.class
            monitor-enter(r0)
            monitor-enter(r0)     // Catch:{ all -> 0x0017 }
            com.alipay.mobile.h5container.api.H5PageImageManager r1 = instance     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x000f
            com.alipay.mobile.h5container.api.H5PageImageManager r1 = new com.alipay.mobile.h5container.api.H5PageImageManager     // Catch:{ all -> 0x0014 }
            r1.<init>()     // Catch:{ all -> 0x0014 }
            instance = r1     // Catch:{ all -> 0x0014 }
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            com.alipay.mobile.h5container.api.H5PageImageManager r1 = instance     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)
            return r1
        L_0x0014:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r1     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.h5container.api.H5PageImageManager.getInstance():com.alipay.mobile.h5container.api.H5PageImageManager");
    }

    private H5PageImageManager() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.lang.String r6, com.alipay.mobile.h5container.api.H5PageImage r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r0 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            if (r0 == 0) goto L_0x0052
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r0 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            boolean r0 = r0.containsKey(r6)     // Catch:{ Exception -> 0x0056 }
            if (r0 == 0) goto L_0x001e
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r0 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x0056 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x0056 }
            if (r0 == 0) goto L_0x001a
            r0.add(r7)     // Catch:{ Exception -> 0x0056 }
        L_0x001a:
            r5.lastMainUrl = r6     // Catch:{ Exception -> 0x0056 }
            monitor-exit(r5)
            return
        L_0x001e:
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r0 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            java.lang.String r1 = r5.lastMainUrl     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0056 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x0056 }
            if (r0 == 0) goto L_0x0043
            java.lang.String r1 = r5.getParam(r0)     // Catch:{ Exception -> 0x0056 }
            com.alipay.mobile.h5container.api.H5PageImageManager$Monitor r2 = new com.alipay.mobile.h5container.api.H5PageImageManager$Monitor     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = r5.lastMainUrl     // Catch:{ Exception -> 0x0056 }
            r4 = 0
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0056 }
            r2.doPerformanceLogger()     // Catch:{ Exception -> 0x0056 }
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r1 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            java.lang.String r2 = r5.lastMainUrl     // Catch:{ Exception -> 0x0056 }
            r1.remove(r2)     // Catch:{ Exception -> 0x0056 }
            r0.clear()     // Catch:{ Exception -> 0x0056 }
        L_0x0043:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0056 }
            r0.<init>()     // Catch:{ Exception -> 0x0056 }
            r0.add(r7)     // Catch:{ Exception -> 0x0056 }
            java.util.Map<java.lang.String, java.util.List<com.alipay.mobile.h5container.api.H5PageImage>> r7 = r5.providerMap     // Catch:{ Exception -> 0x0056 }
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0056 }
            r5.lastMainUrl = r6     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            monitor-exit(r5)
            return
        L_0x0054:
            r6 = move-exception
            goto L_0x005e
        L_0x0056:
            r6 = move-exception
            java.lang.String r7 = "H5PageImageManager"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0054 }
            monitor-exit(r5)
            return
        L_0x005e:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.h5container.api.H5PageImageManager.put(java.lang.String, com.alipay.mobile.h5container.api.H5PageImage):void");
    }

    private String getParam(List<H5PageImage> list) {
        int size = list.size();
        if (size == 0) {
            return "";
        }
        String str = "";
        for (int i2 = 0; i2 < size; i2++) {
            if (!"".equals(str)) {
                str = str + "|";
            }
            str = str + "url=" + list.get(i2).url + "^statusCode=" + list.get(i2).statusCode + "^size=" + list.get(i2).size + "^costTime=" + list.get(i2).costTime;
        }
        return str;
    }

    class Monitor {
        private String param3;
        private String param4;

        private Monitor(String str, String str2) {
            this.param3 = "";
            this.param4 = "";
            this.param3 = str;
            this.param4 = str2;
        }

        /* access modifiers changed from: private */
        public void doPerformanceLogger() {
            H5LogProvider h5LogProvider = H5AppUtil.getH5LogProvider();
            if (h5LogProvider != null) {
                h5LogProvider.log("H5_AL_PAGE_ONLINE_IMAGE", (String) null, (String) null, this.param3, this.param4, (String) null);
            }
        }
    }
}

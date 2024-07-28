package net.one97.paytm.nativesdk.NetworkHandler;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import net.one97.paytm.nativesdk.Utils.LogUtility;

public class VolleyRequestQueue {
    private static Context mCtx;
    private static VolleyRequestQueue mInstance;
    private RequestQueue mRequestQueue = getRequestQueue();

    private VolleyRequestQueue(Context context) {
        mCtx = context;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue getInstance(android.content.Context r2) {
        /*
            java.lang.Class<net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue> r0 = net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue.class
            monitor-enter(r0)
            net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue r1 = mInstance     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0014
            monitor-enter(r0)     // Catch:{ all -> 0x0018 }
            net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue r1 = new net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue     // Catch:{ all -> 0x0011 }
            r1.<init>(r2)     // Catch:{ all -> 0x0011 }
            mInstance = r1     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0014:
            net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue r2 = mInstance     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return r2
        L_0x0018:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue.getInstance(android.content.Context):net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue");
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            HurlStack hurlStack = null;
            try {
                hurlStack = new HurlStack((HurlStack.UrlRewriter) null, new TLSSocketFactory());
            } catch (KeyManagementException e2) {
                LogUtility.printStackTrace(e2);
            } catch (NoSuchAlgorithmException e3) {
                LogUtility.printStackTrace(e3);
            }
            this.mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(), (BaseHttpStack) hurlStack);
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public static void destroyInstance() {
        synchronized (VolleyRequestQueue.class) {
            mCtx = null;
            mInstance = null;
        }
    }
}

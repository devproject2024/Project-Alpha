package com.alipay.mobile.nebulacore.core;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventDispatchHandler;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;

public class H5EventDispatcher {
    public static final String TAG = "H5EventDispatcher";

    public enum Policy {
        SYNC,
        UI,
        IO
    }

    public H5Event.Error sendEvent(String str) {
        return sendEvent(str, (e) null);
    }

    public H5Event.Error sendEvent(String str, e eVar) {
        return sendEvent(str, eVar, (H5CoreNode) null);
    }

    public H5Event.Error sendEvent(String str, e eVar, H5CoreNode h5CoreNode) {
        if (TextUtils.isEmpty(str)) {
            return H5Event.Error.INVALID_PARAM;
        }
        H5Event.Builder builder = new H5Event.Builder();
        builder.action(str);
        builder.param(eVar);
        builder.target(h5CoreNode);
        return dispatch(builder.build(), (H5BridgeContext) null);
    }

    public H5Event.Error dispatch(H5Event h5Event) {
        return dispatch(h5Event, (H5BridgeContext) null, Policy.UI);
    }

    public H5Event.Error dispatch(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return dispatch(h5Event, h5BridgeContext, Policy.UI);
    }

    public H5Event.Error dispatch(final H5Event h5Event, final H5BridgeContext h5BridgeContext, Policy policy) {
        if (!verifyEvent(h5Event) || policy == null) {
            return H5Event.Error.INVALID_PARAM;
        }
        if (h5Event.isDispatcherOnWorkThread()) {
            policy = Policy.IO;
        }
        int i2 = AnonymousClass3.$SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy[policy.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        H5EventDispatcher.this.beginDispatch(h5Event, h5BridgeContext);
                    }
                });
            } else if (i2 == 3) {
                if (H5Utils.isMain()) {
                    H5EventDispatchHandler.getAsyncHandler().post(new Runnable() {
                        public void run() {
                            H5EventDispatcher.this.beginDispatch(h5Event, h5BridgeContext);
                        }
                    });
                } else {
                    beginDispatch(h5Event, h5BridgeContext);
                }
            }
        }
        return H5Event.Error.NONE;
    }

    /* renamed from: com.alipay.mobile.nebulacore.core.H5EventDispatcher$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy = new int[Policy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.alipay.mobile.nebulacore.core.H5EventDispatcher$Policy[] r0 = com.alipay.mobile.nebulacore.core.H5EventDispatcher.Policy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy = r0
                int[] r0 = $SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.alipay.mobile.nebulacore.core.H5EventDispatcher$Policy r1 = com.alipay.mobile.nebulacore.core.H5EventDispatcher.Policy.SYNC     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy     // Catch:{ NoSuchFieldError -> 0x001f }
                com.alipay.mobile.nebulacore.core.H5EventDispatcher$Policy r1 = com.alipay.mobile.nebulacore.core.H5EventDispatcher.Policy.UI     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$alipay$mobile$nebulacore$core$H5EventDispatcher$Policy     // Catch:{ NoSuchFieldError -> 0x002a }
                com.alipay.mobile.nebulacore.core.H5EventDispatcher$Policy r1 = com.alipay.mobile.nebulacore.core.H5EventDispatcher.Policy.IO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5EventDispatcher.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void beginDispatch(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            dispatchInternal(h5Event, h5BridgeContext);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            if (Nebula.enableThrow()) {
                throw th;
            }
        }
        if (Nebula.DEBUG) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String action = h5Event.getAction();
            if (currentTimeMillis2 > 10) {
                H5Log.d(TAG, "Nebula cost time [" + action + "] dispatch elapse " + currentTimeMillis2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchInternal(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event == null) {
            H5Log.e(TAG, "invalid params, event: ".concat(String.valueOf(h5Event)));
            return false;
        }
        if (h5BridgeContext == null && h5Event.getTarget() != null && (h5Event.getTarget() instanceof H5Page)) {
            h5BridgeContext = new H5BridgeContextImpl(((H5Page) h5Event.getTarget()).getBridge(), h5Event.getId(), h5Event.getAction());
        }
        String action = h5Event.getAction();
        if (TextUtils.isEmpty(action)) {
            H5Log.w(TAG, "invalid action name");
            if (h5BridgeContext != null) {
                h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            }
            return false;
        } else if (Nebula.dispatchProcess(h5Event, h5BridgeContext)) {
            return true;
        } else {
            ArrayList arrayList = new ArrayList();
            for (H5CoreNode target = h5Event.getTarget(); target != null; target = target.getParent()) {
                arrayList.add(target);
            }
            if (arrayList.isEmpty()) {
                H5Log.w(TAG, "no event target!");
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                }
                return false;
            }
            if (Nebula.DEBUG) {
                H5Log.d(TAG, "routing event ".concat(String.valueOf(action)));
            }
            int size = arrayList.size();
            int i2 = size - 1;
            while (i2 >= 0) {
                H5Plugin h5Plugin = (H5Plugin) arrayList.get(i2);
                if (h5Event.isCanceled()) {
                    H5Log.d(TAG, "event been canceled on intercept!");
                    return false;
                } else if (h5Plugin.interceptEvent(h5Event, h5BridgeContext)) {
                    return true;
                } else {
                    i2--;
                }
            }
            int i3 = 0;
            while (i3 < size) {
                if (h5Event.isCanceled()) {
                    H5Log.d(TAG, "event been canceled on handle!");
                    return false;
                } else if (((H5Plugin) arrayList.get(i3)).handleEvent(h5Event, h5BridgeContext)) {
                    return true;
                } else {
                    i3++;
                }
            }
            if (h5BridgeContext != null) {
                h5BridgeContext.sendError(h5Event, H5Event.Error.NOT_FOUND);
            }
            H5Log.d(TAG, "[" + action + "] handled by nobody");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r3 != null) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean verifyEvent(com.alipay.mobile.h5container.api.H5Event r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "H5EventDispatcher"
            if (r5 != 0) goto L_0x000b
            java.lang.String r5 = "invalid event body!"
            com.alipay.mobile.nebula.util.H5Log.w(r1, r5)
            return r0
        L_0x000b:
            com.alipay.mobile.h5container.api.H5CoreNode r2 = r5.getTarget()
            if (r2 != 0) goto L_0x0024
            com.alipay.mobile.nebulacore.api.NebulaService r3 = com.alipay.mobile.nebulacore.Nebula.getService()
            if (r3 == 0) goto L_0x0024
            com.alipay.mobile.h5container.api.H5Session r2 = r3.getTopSession()
            if (r2 == 0) goto L_0x0023
            com.alipay.mobile.h5container.api.H5Page r3 = r2.getTopPage()
            if (r3 == 0) goto L_0x0024
        L_0x0023:
            r2 = r3
        L_0x0024:
            if (r2 != 0) goto L_0x002c
            java.lang.String r5 = "invalid event target!"
            com.alipay.mobile.nebula.util.H5Log.w(r1, r5)
            return r0
        L_0x002c:
            r5.setTarget(r2)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.H5EventDispatcher.verifyEvent(com.alipay.mobile.h5container.api.H5Event):boolean");
    }
}

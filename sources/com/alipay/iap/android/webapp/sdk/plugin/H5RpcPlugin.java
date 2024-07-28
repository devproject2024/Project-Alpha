package com.alipay.iap.android.webapp.sdk.plugin;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Random;

public class H5RpcPlugin extends H5SimplePlugin {
    private static final double DEFAULT_NETWORK_SAMPLE_RATE = 0.5d;
    private static final String KEY_NETWORK_SAMPLE_RATE = "h5_rpc_sample_rate";
    public static final String RPC = "rpc";
    public static final String TAG = "H5RpcPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(RPC);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!RPC.equals(h5Event.getAction())) {
            return false;
        }
        H5Log.d(TAG, "handle rpc ation");
        rpc(h5Event, h5BridgeContext);
        return true;
    }

    private void rpc(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5Utils.getExecutor(H5ThreadType.URGENT).execute(new RpcRequest(h5Event, h5BridgeContext));
    }

    public static class RpcRequest implements Runnable {
        public static final int H5_APP_ERROR_CODE = 2003;
        private static final int H5_LIMIT_CODE = 100201;
        private static final int LIMIT_CODE = 1002;
        private static final String TAG = "H5RpcRequest";
        private final H5BridgeContext bridgeContext;
        private String errorCode = "";
        private final H5Event event;
        private int failCode = 0;
        private String lastRpcMd5;
        private Random random;
        private boolean rpcFailed = false;
        private String rpcOperationType;

        public interface RpcParam {
            public static final String COMPRESS = "compress";
            public static final String DISABLE_LIMIT_VIEW = "disableLimitView";
            public static final String GATEWAY = "gateway";
            public static final String HEADERS = "headers";
            public static final String OPERATION_TYPE = "operationType";
            public static final String REQUEST_DATA = "requestData";
            public static final String RETRYABLE = "retryable";
            public static final String TIMEOUT = "timeout";
        }

        public RpcRequest(H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.event = h5Event;
            this.bridgeContext = h5BridgeContext;
            this.random = new Random(System.currentTimeMillis());
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x014a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0194  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x01c3  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r25 = this;
                r1 = r25
                java.lang.String r0 = "\""
                java.lang.String r2 = "10"
                java.lang.String r3 = "exception detail"
                long r4 = java.lang.System.currentTimeMillis()
                com.alipay.mobile.h5container.api.H5Event r6 = r1.event
                com.alibaba.a.e r6 = r6.getParam()
                com.alipay.mobile.h5container.api.H5Event r7 = r1.event
                com.alipay.mobile.h5container.api.H5CoreNode r7 = r7.getTarget()
                boolean r8 = r7 instanceof com.alipay.mobile.h5container.api.H5Page
                if (r8 != 0) goto L_0x0026
                com.alipay.mobile.h5container.api.H5BridgeContext r0 = r1.bridgeContext
                com.alipay.mobile.h5container.api.H5Event r2 = r1.event
                com.alipay.mobile.h5container.api.H5Event$Error r3 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
                r0.sendError((com.alipay.mobile.h5container.api.H5Event) r2, (com.alipay.mobile.h5container.api.H5Event.Error) r3)
                return
            L_0x0026:
                java.lang.String r8 = "operationType"
                java.lang.String r9 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r8)
                r1.rpcOperationType = r9
                boolean r10 = android.text.TextUtils.isEmpty(r9)
                if (r10 == 0) goto L_0x003e
                com.alipay.mobile.h5container.api.H5BridgeContext r0 = r1.bridgeContext
                com.alipay.mobile.h5container.api.H5Event r2 = r1.event
                com.alipay.mobile.h5container.api.H5Event$Error r3 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
                r0.sendError((com.alipay.mobile.h5container.api.H5Event) r2, (com.alipay.mobile.h5container.api.H5Event.Error) r3)
                return
            L_0x003e:
                com.alipay.mobile.h5container.api.H5Page r7 = (com.alipay.mobile.h5container.api.H5Page) r7
                java.lang.String r15 = r7.getUrl()
                com.alipay.mobile.h5container.api.H5AvailablePageData r17 = r7.getAvailablePageData()
                r17.reportReqStart()
                java.lang.String r10 = java.lang.String.valueOf(r15)
                java.lang.String r11 = "rpc from url "
                java.lang.String r10 = r11.concat(r10)
                java.lang.String r14 = "H5RpcRequest"
                com.alipay.mobile.nebula.util.H5Log.d(r14, r10)
                r10 = 0
                java.lang.String r11 = "requestData"
                com.alibaba.a.b r11 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r6, r11, r10)
                java.lang.String r11 = com.alipay.iap.android.webapp.sdk.utils.JsonUtils.toJSONString(r11)
                java.lang.String r12 = "gateway"
                java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r12)
                java.lang.String r13 = "headers"
                com.alibaba.a.e r13 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r6, r13, r10)
                r10 = 1
                r16 = r14
                java.lang.String r14 = "compress"
                boolean r14 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((com.alibaba.a.e) r6, (java.lang.String) r14, (boolean) r10)
                r10 = 0
                r18 = r15
                java.lang.String r15 = "disableLimitView"
                boolean r19 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((com.alibaba.a.e) r6, (java.lang.String) r15, (boolean) r10)
                java.lang.String r15 = "retryable"
                boolean r15 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((com.alibaba.a.e) r6, (java.lang.String) r15, (boolean) r10)
                r20 = r4
                java.lang.String r4 = "timeout"
                int r4 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r6, (java.lang.String) r4, (int) r10)
                java.lang.String r5 = "funcName"
                r6.remove(r5)
                com.alibaba.a.e r5 = new com.alibaba.a.e
                r5.<init>()
                android.os.Bundle r22 = r7.getParams()     // Catch:{ a -> 0x0133, InterruptedException -> 0x0115, all -> 0x00f9 }
                r6 = 1
                r10 = r11
                r11 = r12
                r12 = r14
                r23 = r16
                r14 = r15
                r24 = r18
                r15 = r22
                r16 = r4
                java.lang.String r4 = com.alipay.iap.android.webapp.sdk.network.toolbox.H5RpcProcessor.rpcCall(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                com.alibaba.a.e r9 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                if (r9 != 0) goto L_0x00e4
                com.alibaba.a.e r9 = new com.alibaba.a.e     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                r9.<init>()     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                if (r10 != 0) goto L_0x00df
                boolean r10 = r4.startsWith(r0)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                if (r10 == 0) goto L_0x00df
                boolean r0 = r4.endsWith(r0)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                if (r0 == 0) goto L_0x00df
                int r0 = r4.length()     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                int r0 = r0 - r6
                java.lang.String r0 = r4.substring(r6, r0)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                java.lang.String r4 = "\\\\"
                java.lang.String r10 = ""
                java.lang.String r4 = r0.replaceAll(r4, r10)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
            L_0x00df:
                java.lang.String r0 = "resData"
                r9.put((java.lang.String) r0, (java.lang.Object) r4)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
            L_0x00e4:
                com.alipay.mobile.h5container.api.H5BridgeContext r0 = r1.bridgeContext     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                r0.sendBridgeResult(r9)     // Catch:{ a -> 0x00f5, InterruptedException -> 0x00f1, all -> 0x00ed }
                r4 = r23
                goto L_0x0179
            L_0x00ed:
                r0 = move-exception
                r4 = r23
                goto L_0x00ff
            L_0x00f1:
                r0 = move-exception
                r4 = r23
                goto L_0x011b
            L_0x00f5:
                r0 = move-exception
                r4 = r23
                goto L_0x0139
            L_0x00f9:
                r0 = move-exception
                r24 = r18
                r6 = 1
                r4 = r16
            L_0x00ff:
                com.alipay.mobile.nebula.util.H5Log.e(r4, r3, r0)
                com.alipay.mobile.h5container.api.H5BridgeContext r3 = r1.bridgeContext
                r9 = 10
                java.lang.String r0 = r0.toString()
                r3.sendError((int) r9, (java.lang.String) r0)
                r9 = 2
                r1.failCode = r9
                r1.rpcFailed = r6
                r1.errorCode = r2
                goto L_0x0179
            L_0x0115:
                r0 = move-exception
                r4 = r16
                r24 = r18
                r6 = 1
            L_0x011b:
                r9 = 2
                com.alipay.mobile.nebula.util.H5Log.e(r4, r3, r0)
                com.alipay.mobile.h5container.api.H5BridgeContext r2 = r1.bridgeContext
                r3 = 11
                java.lang.String r0 = r0.toString()
                r2.sendError((int) r3, (java.lang.String) r0)
                r1.failCode = r9
                r1.rpcFailed = r6
                java.lang.String r0 = "11"
                r1.errorCode = r0
                goto L_0x0179
            L_0x0133:
                r0 = move-exception
                r4 = r16
                r24 = r18
                r6 = 1
            L_0x0139:
                int r9 = r0.getCode()
                java.lang.String r10 = java.lang.String.valueOf(r9)
                java.lang.String r11 = "2"
                boolean r11 = r11.equals(r10)
                if (r11 == 0) goto L_0x014a
                goto L_0x014b
            L_0x014a:
                r2 = r10
            L_0x014b:
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.String r10 = "error code:"
                java.lang.String r2 = r10.concat(r2)
                com.alipay.mobile.nebula.util.H5Log.d(r4, r2)
                com.alipay.mobile.nebula.util.H5Log.e(r4, r3, r0)
                r2 = 2
                r1.failCode = r2
                r1.rpcFailed = r6
                java.lang.String r2 = r0.getMessage()
                r3 = 1002(0x3ea, float:1.404E-42)
                if (r9 != r3) goto L_0x0174
                if (r19 == 0) goto L_0x016b
                goto L_0x0174
            L_0x016b:
                com.alipay.mobile.h5container.api.H5BridgeContext r3 = r1.bridgeContext
                r4 = 100201(0x18769, float:1.40412E-40)
                r3.sendError((int) r4, (java.lang.String) r2)
                throw r0
            L_0x0174:
                com.alipay.mobile.h5container.api.H5BridgeContext r0 = r1.bridgeContext
                r0.sendError((int) r9, (java.lang.String) r2)
            L_0x0179:
                int r0 = r1.failCode
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.String r2 = "failCode"
                r5.put((java.lang.String) r2, (java.lang.Object) r0)
                java.lang.String r0 = r1.errorCode
                java.lang.String r3 = "errorCode"
                r5.put((java.lang.String) r3, (java.lang.Object) r0)
                java.lang.String r0 = r1.rpcOperationType
                r5.put((java.lang.String) r8, (java.lang.Object) r0)
                boolean r0 = r1.rpcFailed
                if (r0 == 0) goto L_0x0199
                java.lang.String r0 = "H5_RPC_FAILED"
                r7.sendEvent(r0, r5)
            L_0x0199:
                r17.reportReqEnd()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r5 = "rpc request time "
                r0.<init>(r5)
                long r5 = java.lang.System.currentTimeMillis()
                long r5 = r5 - r20
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
                r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
                java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
                java.lang.String r0 = r0.getName()
                java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
                com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0
                if (r0 == 0) goto L_0x01d5
                java.lang.String r7 = "h5_rpc_sample_rate"
                java.lang.String r0 = r0.getConfig(r7)
                double r5 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x01ce }
                goto L_0x01d5
            L_0x01ce:
                r0 = move-exception
                r7 = r0
                java.lang.String r0 = "parse sample config failed"
                com.alipay.mobile.nebula.util.H5Log.e(r4, r0, r7)
            L_0x01d5:
                java.util.Random r0 = r1.random
                if (r0 == 0) goto L_0x022d
                double r9 = r0.nextDouble()
                int r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                if (r0 > 0) goto L_0x022d
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
                r0.<init>()
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.success()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r20
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendCostTime(r4)
                r4 = r24
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendUrl(r4)
                java.lang.String r4 = r1.rpcOperationType
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r8, r4)
                java.lang.String r4 = "H5_CONTAINER_RPC"
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.seedId(r4)
                boolean r4 = r1.rpcFailed
                java.lang.String r4 = java.lang.String.valueOf(r4)
                java.lang.String r5 = "rpcFailed"
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r5, r4)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                int r5 = r1.failCode
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r2, r4)
                java.lang.String r2 = r1.errorCode
                com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r3, r2)
                com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r0)
            L_0x022d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin.RpcRequest.run():void");
        }
    }
}

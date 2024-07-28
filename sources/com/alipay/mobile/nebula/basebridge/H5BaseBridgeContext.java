package com.alipay.mobile.nebula.basebridge;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5JSApiMonitorFilter;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public abstract class H5BaseBridgeContext implements H5BridgeContext {
    public static final String FORBIDDEN = "forbidden!";
    public static final String INVALID_PARAM = "invalid parameter!";
    public static final String NONE_ERROR = "none error!";
    public static final String NOT_FOUND = "not implemented!";
    private static final String TAG = "H5BridgeContextImpl";
    public static final String UNKNOWN_ERROR = "unknown error!";
    public H5Bridge bridge;
    public String id;

    public String getInvokeType() {
        return "h5";
    }

    public abstract boolean sendBack(e eVar, boolean z);

    /* renamed from: com.alipay.mobile.nebula.basebridge.H5BaseBridgeContext$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error = new int[H5Event.Error.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.alipay.mobile.h5container.api.H5Event$Error[] r0 = com.alipay.mobile.h5container.api.H5Event.Error.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error = r0
                int[] r0 = $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.alipay.mobile.h5container.api.H5Event$Error r1 = com.alipay.mobile.h5container.api.H5Event.Error.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error     // Catch:{ NoSuchFieldError -> 0x001f }
                com.alipay.mobile.h5container.api.H5Event$Error r1 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error     // Catch:{ NoSuchFieldError -> 0x002a }
                com.alipay.mobile.h5container.api.H5Event$Error r1 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.alipay.mobile.h5container.api.H5Event$Error r1 = com.alipay.mobile.h5container.api.H5Event.Error.FORBIDDEN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.basebridge.H5BaseBridgeContext.AnonymousClass1.<clinit>():void");
        }
    }

    private static String getErrorMsg(H5Event.Error error) {
        int i2 = AnonymousClass1.$SwitchMap$com$alipay$mobile$h5container$api$H5Event$Error[error.ordinal()];
        if (i2 == 1) {
            return "not implemented!";
        }
        if (i2 == 2) {
            return "invalid parameter!";
        }
        if (i2 != 3) {
            return i2 != 4 ? "none error!" : "forbidden!";
        }
        return "unknown error!";
    }

    public boolean sendBridgeResult(e eVar) {
        return sendBack(eVar, false);
    }

    public boolean sendBridgeResult(String str, Object obj) {
        e eVar = new e();
        eVar.put(str, obj);
        return sendBridgeResult(eVar);
    }

    public void sendToWeb(String str, e eVar, H5CallBack h5CallBack) {
        H5Bridge h5Bridge = this.bridge;
        if (h5Bridge != null) {
            h5Bridge.sendToWeb(str, eVar, h5CallBack);
        } else {
            H5Log.e(TAG, "[FATAL ERROR] in sendToWeb() bridge is null");
        }
    }

    public boolean sendBridgeResultWithCallbackKept(e eVar) {
        return sendBack(eVar, true);
    }

    public boolean sendBridgeResultWithCallbackKept(String str, Object obj) {
        e eVar = new e();
        eVar.put(str, obj);
        return sendBridgeResultWithCallbackKept(eVar);
    }

    public boolean sendError(H5Event h5Event, H5Event.Error error) {
        String str;
        H5AppProvider h5AppProvider;
        String action = h5Event == null ? null : h5Event.getAction();
        H5Log.w(TAG, "sendError " + error + " [action] " + action);
        e eVar = new e();
        eVar.put("message", (Object) getErrorMsg(error));
        eVar.put("error", (Object) Integer.valueOf(error.ordinal()));
        if (h5Event != null && !H5JSApiMonitorFilter.shouldFilter(h5Event.getAction())) {
            String id2 = h5Event.getId();
            if (!TextUtils.isEmpty(id2) && !id2.startsWith("native_") && H5Monitor.isJSApiMonitorEnabled()) {
                String str2 = "";
                if (h5Event.getTarget() instanceof H5Page) {
                    str = H5Utils.getString(((H5Page) h5Event.getTarget()).getParams(), "appId");
                    if (!TextUtils.isEmpty(str) && (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) != null) {
                        str2 = h5AppProvider.getVersion(str);
                    }
                } else {
                    str = str2;
                }
                H5MonitorModel appendPackageVersion = new H5MonitorModel().fail().appendJSApi(h5Event.getAction()).exceptionType(H5MonitorModel.EXCEPTION_JSAPI_CALL).appendSubappId(str).appendPackageVersion(str2);
                H5Monitor.exception(appendPackageVersion.appendMessage("call " + h5Event.getAction() + " failed because " + getErrorMsg(error)));
            }
        }
        return sendBridgeResult(eVar);
    }

    public String getId() {
        return this.id;
    }

    public void sendSuccess() {
        sendBridgeResult("success", Boolean.TRUE);
    }

    public void sendError(int i2, String str) {
        e eVar = new e();
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) str);
        eVar.put("error", (Object) Integer.valueOf(i2));
        sendBridgeResult(eVar);
    }

    public void sendNoRightToInvoke() {
        String string = H5Utils.getNebulaResources().getString(R.string.h5_no_right_to_invoke);
        e eVar = new e();
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) string);
        eVar.put("error", (Object) 4);
        sendBridgeResult(eVar);
    }

    public void sendNotGrantPermission() {
        e eVar = new e();
        eVar.put("error", (Object) 10);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Utils.getNebulaResources().getString(R.string.h5_no_grant_permission));
        sendBridgeResult(eVar);
    }

    public void userCancel() {
        e eVar = new e();
        eVar.put("error", (Object) 11);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Utils.getNebulaResources().getString(R.string.h5_default_cancel));
        sendBridgeResult(eVar);
    }
}

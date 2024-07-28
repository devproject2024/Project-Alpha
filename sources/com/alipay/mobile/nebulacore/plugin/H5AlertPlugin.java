package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5DialogManagerProvider;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.view.H5Alert;

public class H5AlertPlugin extends H5SimplePlugin {
    public static final String SHOW_UC_FAIL_DIALOG = "showUCFailDialog";
    public static final String TAG = "H5AlertPlugin";
    /* access modifiers changed from: private */
    public H5Alert h5Alert;

    public void onRelease() {
        this.h5Alert = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.ALERT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.CONFIRM);
        h5EventFilter.addAction(SHOW_UC_FAIL_DIALOG);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.SHOW_ALERT.equals(action) || H5Plugin.CommonEvents.ALERT.equals(action)) {
            alert(h5Event, h5BridgeContext);
            return true;
        } else if (H5Plugin.CommonEvents.CONFIRM.equals(action)) {
            confirm(h5Event, h5BridgeContext);
            return true;
        } else if (!SHOW_UC_FAIL_DIALOG.equals(action) || !(h5Event.getTarget() instanceof H5Page)) {
            return true;
        } else {
            showDialog(h5Event, (H5Page) h5Event.getTarget(), h5BridgeContext);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void alert(com.alipay.mobile.h5container.api.H5Event r11, final com.alipay.mobile.h5container.api.H5BridgeContext r12) {
        /*
            r10 = this;
            com.alibaba.a.e r0 = r11.getParam()
            java.lang.String r1 = "H5AlertPlugin"
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "none params"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r0)
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            r12.sendError((com.alipay.mobile.h5container.api.H5Event) r11, (com.alipay.mobile.h5container.api.H5Event.Error) r0)
            return
        L_0x0013:
            java.lang.String r2 = "title"
            java.lang.String r5 = r0.getString(r2)
            java.lang.String r2 = "message"
            java.lang.String r6 = r0.getString(r2)
            java.lang.String r2 = "button"
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = "align"
            java.lang.String r9 = r0.getString(r3)
            r3 = 0
            r4 = 0
            java.lang.String r7 = "buttons"
            com.alibaba.a.b r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r0, r7, r3)     // Catch:{ Exception -> 0x0069 }
            int r7 = r0.size()     // Catch:{ Exception -> 0x0069 }
            if (r7 <= 0) goto L_0x0052
            int r2 = r0.size()     // Catch:{ Exception -> 0x0069 }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0069 }
            r7 = 0
        L_0x0041:
            int r8 = r0.size()     // Catch:{ Exception -> 0x0050 }
            if (r7 == r8) goto L_0x006e
            java.lang.String r8 = r0.getString(r7)     // Catch:{ Exception -> 0x0050 }
            r2[r7] = r8     // Catch:{ Exception -> 0x0050 }
            int r7 = r7 + 1
            goto L_0x0041
        L_0x0050:
            r0 = move-exception
            goto L_0x006b
        L_0x0052:
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0069 }
            if (r0 == 0) goto L_0x0062
            android.content.res.Resources r0 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()     // Catch:{ Exception -> 0x0069 }
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_default_confirm     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x0069 }
        L_0x0062:
            r0 = 1
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0069 }
            r0[r4] = r2     // Catch:{ Exception -> 0x0069 }
            r2 = r0
            goto L_0x006e
        L_0x0069:
            r0 = move-exception
            r2 = r3
        L_0x006b:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x006e:
            android.app.Activity r11 = r11.getActivity()
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r0 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5DialogManagerProvider> r1 = com.alipay.mobile.nebula.provider.H5DialogManagerProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.getProvider(r1)
            com.alipay.mobile.nebula.provider.H5DialogManagerProvider r0 = (com.alipay.mobile.nebula.provider.H5DialogManagerProvider) r0
            if (r0 == 0) goto L_0x00a3
            r7 = r2[r4]
            r8 = 0
            r3 = r0
            r4 = r11
            android.app.Dialog r11 = r3.createDialog(r4, r5, r6, r7, r8, r9)
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$1 r1 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$1
            r1.<init>(r0, r12)
            r0.setPositiveListener(r1)
            r0.showDialog()
            if (r11 == 0) goto L_0x00a2
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$2 r1 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$2
            r1.<init>(r12, r0)
            r11.setOnCancelListener(r1)
        L_0x00a2:
            return
        L_0x00a3:
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$3 r0 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$3
            r0.<init>(r12)
            com.alipay.mobile.nebulacore.view.H5Alert r12 = r10.h5Alert
            if (r12 == 0) goto L_0x00b1
            r12.dismiss()
            r10.h5Alert = r3
        L_0x00b1:
            com.alipay.mobile.nebulacore.view.H5Alert r12 = new com.alipay.mobile.nebulacore.view.H5Alert
            r12.<init>(r11)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r12.cancelable(r4)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r11.title(r5)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r11.message(r6)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r11.buttons(r2)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r11.listener(r0)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r11.show()
            r10.h5Alert = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5AlertPlugin.alert(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }

    private void confirm(H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        e param;
        if (h5Event != null && (param = h5Event.getParam()) != null) {
            String string = param.getString("title");
            String string2 = param.getString("message");
            String string3 = param.getString("okButton");
            Resources resources = H5Environment.getResources();
            if (TextUtils.isEmpty(string3)) {
                string3 = resources.getString(R.string.h5_default_confirm);
            }
            String string4 = param.getString("cancelButton");
            if (TextUtils.isEmpty(string4)) {
                string4 = resources.getString(R.string.h5_default_cancel);
            }
            String[] strArr = {string3, string4};
            String string5 = param.getString("align");
            Activity activity = h5Event.getActivity();
            final H5DialogManagerProvider h5DialogManagerProvider = (H5DialogManagerProvider) H5ProviderManagerImpl.getInstance().getProvider(H5DialogManagerProvider.class.getName());
            if (h5DialogManagerProvider != null) {
                Dialog createDialog = h5DialogManagerProvider.createDialog(activity, string, string2, strArr[0], strArr[1], string5);
                h5DialogManagerProvider.setPositiveListener(new H5DialogManagerProvider.OnClickPositiveListener() {
                    public void onClick() {
                        h5DialogManagerProvider.disMissDialog();
                        e eVar = new e();
                        eVar.put("ok", (Object) Boolean.TRUE);
                        h5BridgeContext.sendBridgeResult(eVar);
                        h5DialogManagerProvider.release();
                    }
                });
                h5DialogManagerProvider.setNegativeListener(new H5DialogManagerProvider.OnClickNegativeListener() {
                    public void onClick() {
                        h5DialogManagerProvider.disMissDialog();
                        e eVar = new e();
                        eVar.put("ok", (Object) Boolean.FALSE);
                        h5BridgeContext.sendBridgeResult(eVar);
                        h5DialogManagerProvider.release();
                    }
                });
                if (createDialog != null) {
                    createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            e eVar = new e();
                            eVar.put("ok", (Object) Boolean.FALSE);
                            h5BridgeContext.sendBridgeResult(eVar);
                            h5DialogManagerProvider.release();
                        }
                    });
                }
                h5DialogManagerProvider.showDialog();
                return;
            }
            AnonymousClass7 r10 = new H5Alert.H5AlertListener() {
                public void onClick(H5Alert h5Alert, int i2) {
                    boolean z = i2 == 0;
                    e eVar = new e();
                    eVar.put("ok", (Object) Boolean.valueOf(z));
                    h5BridgeContext.sendBridgeResult(eVar);
                    H5Alert unused = H5AlertPlugin.this.h5Alert = null;
                }

                public void onCancel(H5Alert h5Alert) {
                    e eVar = new e();
                    eVar.put("ok", (Object) Boolean.FALSE);
                    h5BridgeContext.sendBridgeResult(eVar);
                    H5Alert unused = H5AlertPlugin.this.h5Alert = null;
                }
            };
            H5Alert h5Alert2 = this.h5Alert;
            if (h5Alert2 != null) {
                h5Alert2.dismiss();
                this.h5Alert = null;
            }
            this.h5Alert = new H5Alert(activity).cancelable(false).title(string).message(string2).buttons(strArr).listener(r10).show();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showAlert(com.alipay.mobile.h5container.api.H5Event r10, final com.alipay.mobile.h5container.api.H5BridgeContext r11) {
        /*
            r9 = this;
            com.alibaba.a.e r0 = r10.getParam()
            java.lang.String r1 = "H5AlertPlugin"
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "none params"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r0)
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            r11.sendError((com.alipay.mobile.h5container.api.H5Event) r10, (com.alipay.mobile.h5container.api.H5Event.Error) r0)
            return
        L_0x0013:
            r2 = 0
            java.lang.String r3 = "title"
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r4 = "message"
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r4, (java.lang.String) r2)
            r5 = 0
            java.lang.String r6 = "buttons"
            com.alibaba.a.b r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r0, r6, r2)     // Catch:{ Exception -> 0x004c }
            int r6 = r0.size()     // Catch:{ Exception -> 0x004c }
            if (r6 <= 0) goto L_0x0046
            int r6 = r0.size()     // Catch:{ Exception -> 0x004c }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x004c }
            r7 = 0
        L_0x0035:
            int r8 = r0.size()     // Catch:{ Exception -> 0x0044 }
            if (r7 == r8) goto L_0x0051
            java.lang.String r8 = r0.getString(r7)     // Catch:{ Exception -> 0x0044 }
            r6[r7] = r8     // Catch:{ Exception -> 0x0044 }
            int r7 = r7 + 1
            goto L_0x0035
        L_0x0044:
            r0 = move-exception
            goto L_0x004e
        L_0x0046:
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM     // Catch:{ Exception -> 0x004c }
            r11.sendError((com.alipay.mobile.h5container.api.H5Event) r10, (com.alipay.mobile.h5container.api.H5Event.Error) r0)     // Catch:{ Exception -> 0x004c }
            return
        L_0x004c:
            r0 = move-exception
            r6 = r2
        L_0x004e:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x0051:
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$8 r0 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$8
            r0.<init>(r11)
            com.alipay.mobile.nebulacore.view.H5Alert r11 = r9.h5Alert
            if (r11 == 0) goto L_0x005f
            r11.dismiss()
            r9.h5Alert = r2
        L_0x005f:
            android.app.Activity r10 = r10.getActivity()
            com.alipay.mobile.nebulacore.view.H5Alert r11 = new com.alipay.mobile.nebulacore.view.H5Alert
            r11.<init>(r10)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r11.cancelable(r5)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r10.title(r3)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r10.message(r4)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r10.buttons(r6)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r10.listener(r0)
            com.alipay.mobile.nebulacore.view.H5Alert r10 = r10.show()
            r9.h5Alert = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5AlertPlugin.showAlert(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r8 = r10.getActivity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showDialog(final com.alipay.mobile.h5container.api.H5Event r10, final com.alipay.mobile.h5container.api.H5Page r11, final com.alipay.mobile.h5container.api.H5BridgeContext r12) {
        /*
            r9 = this;
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0
            if (r0 == 0) goto L_0x001d
            java.lang.String r1 = "h5_show_uc_fail_dialog"
            java.lang.String r0 = r0.getConfigWithProcessCache(r1)
            java.lang.String r1 = "no"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x001d
            return
        L_0x001d:
            if (r11 != 0) goto L_0x0020
            return
        L_0x0020:
            android.os.Bundle r0 = r11.getParams()
            java.lang.String r1 = "nburl"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0055
            boolean r12 = com.alipay.mobile.nebula.util.H5Utils.isInTinyProcess()
            if (r12 == 0) goto L_0x0048
            android.app.Activity r12 = r10.getActivity()
            com.alipay.mobile.nebulacore.Nebula.moveTaskToBack(r12)
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$9 r12 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$9
            r12.<init>(r10, r11, r0)
            r10 = 500(0x1f4, double:2.47E-321)
            com.alipay.mobile.nebula.util.H5Utils.runOnMain(r12, r10)
            return
        L_0x0048:
            android.app.Activity r10 = r10.getActivity()
            if (r10 == 0) goto L_0x0051
            r10.finish()
        L_0x0051:
            com.alipay.mobile.nebula.util.H5Utils.openUrl(r0)
            return
        L_0x0055:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5DialogManagerProvider> r0 = com.alipay.mobile.nebula.provider.H5DialogManagerProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5DialogManagerProvider r0 = (com.alipay.mobile.nebula.provider.H5DialogManagerProvider) r0
            if (r0 == 0) goto L_0x008b
            android.app.Activity r8 = r10.getActivity()
            if (r8 == 0) goto L_0x008b
            boolean r1 = r8.isFinishing()
            if (r1 != 0) goto L_0x008b
            android.app.Activity r2 = r10.getActivity()
            r3 = 0
            r6 = 0
            r7 = 0
            java.lang.String r4 = "系统异常，暂时无法启动，请稍后再试。"
            java.lang.String r5 = "确认"
            r1 = r0
            r1.createDialog(r2, r3, r4, r5, r6, r7)
            com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$10 r10 = new com.alipay.mobile.nebulacore.plugin.H5AlertPlugin$10
            r10.<init>(r12, r11, r8)
            r0.setPositiveListener(r10)
            r0.showDialog()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5AlertPlugin.showDialog(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5Page, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }
}

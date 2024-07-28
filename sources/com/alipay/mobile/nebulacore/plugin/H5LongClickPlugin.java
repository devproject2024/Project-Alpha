package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.provider.H5ListPopDialogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APHitTestResult;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class H5LongClickPlugin extends H5SimplePlugin implements View.OnLongClickListener {
    public static final String SAVE_IMAGE = "saveImage";
    public static final String TAG = "H5LongClickPlugin";
    public static final String privateSaveImage = "privateSaveImage";
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public H5PageImpl h5Page;
    private View webView;

    public H5LongClickPlugin(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
        Context context = h5PageImpl.getContext().getContext();
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        this.webView = h5PageImpl.getWebView().getView();
        this.webView.setOnLongClickListener(this);
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(SAVE_IMAGE);
    }

    public void onRelease() {
        H5Log.d(TAG, "onRelease");
        View view = this.webView;
        if (view != null) {
            view.setOnLongClickListener((View.OnLongClickListener) null);
            this.webView = null;
        }
        this.h5Page = null;
        this.activity = null;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5Log.d(TAG, "handleEvent event is " + h5Event.getAction());
        if (!SAVE_IMAGE.equals(h5Event.getAction())) {
            return false;
        }
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "src");
        if (TextUtils.isEmpty(string)) {
            h5BridgeContext.sendBridgeResult("error", "2");
            return true;
        }
        handleSaveImg(string, H5Utils.getBoolean(param, "showActionSheet", true), h5BridgeContext, H5Utils.getBoolean(param, "cusHandleResult", false), H5Utils.getString(param, "savePath", "default"));
        return true;
    }

    private void handleSaveImg(String str, boolean z, H5BridgeContext h5BridgeContext, boolean z2, String str2) {
        if (!z) {
            saveImage(str, h5BridgeContext, z2, str2);
            return;
        }
        String string = H5Environment.getResources().getString(R.string.h5_save_to_phone);
        String[] strArr = {string};
        H5ListPopDialogProvider h5ListPopDialogProvider = (H5ListPopDialogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ListPopDialogProvider.class.getName());
        if (h5ListPopDialogProvider != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(string);
            h5ListPopDialogProvider.createDialog(this.activity, arrayList);
            h5ListPopDialogProvider.showDialog();
            final String str3 = str;
            final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
            final boolean z3 = z2;
            final String str4 = str2;
            h5ListPopDialogProvider.setOnItemClickListener(new H5ListPopDialogProvider.OnItemClickListener() {
                public void onItemClick(int i2) {
                    if (i2 == 0) {
                        H5LongClickPlugin.this.saveImage(str3, h5BridgeContext2, z3, str4);
                    }
                }
            });
            return;
        }
        final String str5 = str;
        final H5BridgeContext h5BridgeContext3 = h5BridgeContext;
        final boolean z4 = z2;
        final String str6 = str2;
        AlertDialog create = new AlertDialog.Builder(this.activity).setItems(strArr, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 0) {
                    H5LongClickPlugin.this.saveImage(str5, h5BridgeContext3, z4, str6);
                }
                if (dialogInterface != null && H5LongClickPlugin.this.activity != null && !H5LongClickPlugin.this.activity.isFinishing()) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Throwable unused) {
                        H5Log.e(H5LongClickPlugin.TAG, "dismiss exception.");
                    }
                }
            }
        }).create();
        create.setCanceledOnTouchOutside(true);
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing()) {
            create.show();
        }
    }

    public boolean onLongClick(View view) {
        H5Log.d(TAG, "onLongClick");
        H5PageImpl h5PageImpl = this.h5Page;
        if (!(h5PageImpl == null || h5PageImpl.getWebView() == null || this.activity == null)) {
            APHitTestResult hitTestResult = this.h5Page.getWebView().getHitTestResult();
            if ((hitTestResult != null && (hitTestResult.getType() == 5 || hitTestResult.getType() == 8)) && !TextUtils.isEmpty(hitTestResult.getExtra())) {
                try {
                    String extra = hitTestResult.getExtra();
                    H5Log.d(TAG, "imgUrl:".concat(String.valueOf(extra)));
                    if (!extra.startsWith("http")) {
                        return false;
                    }
                    e eVar = new e();
                    eVar.put("imgUrl", (Object) extra);
                    this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_PAGE_LONG_CLICK, eVar);
                    return true;
                } catch (Exception e2) {
                    H5Log.e(TAG, "getExtras Exception", e2);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void saveImage(String str, H5BridgeContext h5BridgeContext, boolean z, String str2) {
        H5Utils.getExecutor(H5ThreadType.URGENT).execute(new ImageSaveRunner(str, h5BridgeContext, z, str2));
    }

    class ImageSaveRunner implements Runnable {
        H5BridgeContext bridgeContext;
        boolean cusHandleResult;
        String filePath;
        String savePath;
        String toastPath;
        String url;

        public ImageSaveRunner(String str, H5BridgeContext h5BridgeContext, boolean z, String str2) {
            this.url = str;
            this.bridgeContext = h5BridgeContext;
            this.cusHandleResult = z;
            this.savePath = str2;
        }

        public void run() {
            final boolean download = download();
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    String str;
                    if (H5LongClickPlugin.this.activity != null) {
                        if (download) {
                            str = H5Environment.getResources().getString(R.string.h5_save_image_to, new Object[]{ImageSaveRunner.this.toastPath});
                            if (ImageSaveRunner.this.bridgeContext != null) {
                                ImageSaveRunner.this.bridgeContext.sendSuccess();
                            }
                        } else {
                            str = H5Environment.getResources().getString(R.string.h5_save_image_failed);
                            if (ImageSaveRunner.this.bridgeContext != null) {
                                ImageSaveRunner.this.bridgeContext.sendBridgeResult("error", "17");
                                return;
                            }
                        }
                        if (ImageSaveRunner.this.cusHandleResult) {
                            H5Log.d(H5LongClickPlugin.TAG, "cusHandleResult true not show toast");
                        } else {
                            H5Environment.showToast(H5LongClickPlugin.this.activity, str, 0);
                        }
                    }
                }
            });
        }

        private InputStream loadResponse(String str) {
            H5ContentProvider webProvider;
            WebResourceResponse content;
            UcService ucService = H5Environment.getUcService();
            WebResourceResponse response = (ucService == null || !H5Flag.ucReady) ? null : ucService.getResponse(str);
            if (response != null && response.getData() != null) {
                H5Log.d(H5LongClickPlugin.TAG, "load response from uc cache");
                return response.getData();
            } else if (H5LongClickPlugin.this.h5Page == null || H5LongClickPlugin.this.h5Page.getSession() == null || (webProvider = H5LongClickPlugin.this.h5Page.getSession().getWebProvider()) == null || (content = webProvider.getContent(str)) == null) {
                try {
                    H5Log.d(H5LongClickPlugin.TAG, "load response from net");
                    URLConnection openConnection = new URL(str).openConnection();
                    openConnection.setConnectTimeout(AppConstants.START_OTP_FLOW);
                    openConnection.setReadTimeout(AppConstants.START_OTP_FLOW);
                    H5Log.d(H5LongClickPlugin.TAG, "load response length " + openConnection.getContentLength());
                    return openConnection.getInputStream();
                } catch (Throwable th) {
                    H5Log.e(H5LongClickPlugin.TAG, "load response exception", th);
                    return null;
                }
            } else {
                H5Log.d(H5LongClickPlugin.TAG, "get from H5pkg ".concat(String.valueOf(str)));
                return content.getData();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.FileOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.io.InputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean download() {
            /*
                r9 = this;
                java.lang.String r0 = "http"
                java.lang.String r1 = "H5LongClickPlugin"
                r2 = 0
                r3 = 0
                java.lang.String r4 = r9.url     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
                boolean r4 = r4.startsWith(r0)     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
                if (r4 == 0) goto L_0x0015
                java.lang.String r4 = r9.url     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
                java.io.InputStream r4 = r9.loadResponse(r4)     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
                goto L_0x001b
            L_0x0015:
                java.lang.String r4 = r9.url     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
                java.io.InputStream r4 = com.alipay.mobile.nebula.util.H5ImageUtil.base64ToInputStream(r4)     // Catch:{ Exception -> 0x0108, all -> 0x0105 }
            L_0x001b:
                if (r4 != 0) goto L_0x0024
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
                return r2
            L_0x0024:
                java.lang.String r5 = "/DCIM/Alipay/"
                java.lang.String r6 = r9.savePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r7 = "default"
                boolean r6 = android.text.TextUtils.equals(r6, r7)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                if (r6 != 0) goto L_0x0032
                java.lang.String r5 = r9.savePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
            L_0x0032:
                java.lang.String r6 = ""
                java.lang.String r7 = r9.url     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                boolean r0 = r7.startsWith(r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r7 = "jpg"
                if (r0 == 0) goto L_0x004e
                java.lang.String r0 = r9.url     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                boolean r0 = com.alipay.mobile.nebula.util.H5Utils.isImage(r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                if (r0 == 0) goto L_0x004d
                java.lang.String r0 = r9.url     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r6 = com.alipay.mobile.nebula.util.H5FileUtil.getExtension((java.lang.String) r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                goto L_0x004e
            L_0x004d:
                r6 = r7
            L_0x004e:
                boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                if (r0 == 0) goto L_0x0055
                r6 = r7
            L_0x0055:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.<init>()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.io.File r7 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r7)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r9.toastPath = r0     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.<init>()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = r9.toastPath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r7)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = "."
                r0.append(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r6)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r9.filePath = r0     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = "filePath "
                r0.<init>(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = r9.filePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                com.alipay.mobile.nebula.util.H5Log.d(r1, r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r0 = r9.filePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                boolean r0 = com.alipay.mobile.nebula.util.H5FileUtil.create(r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                if (r0 != 0) goto L_0x00be
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = "failed to create file "
                r0.<init>(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = r9.filePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.append(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                com.alipay.mobile.nebula.util.H5Log.w(r1, r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
                return r2
            L_0x00be:
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.lang.String r5 = r9.filePath     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0.<init>(r5)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r5.<init>(r0)     // Catch:{ Exception -> 0x0101, all -> 0x00ff }
                r0 = 1024(0x400, float:1.435E-42)
                byte[] r0 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r0)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
            L_0x00d0:
                int r6 = r4.read(r0)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                if (r6 <= 0) goto L_0x00da
                r5.write(r0, r2, r6)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                goto L_0x00d0
            L_0x00da:
                com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r0)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                r5.flush()     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                android.content.Context r0 = com.alipay.mobile.nebulacore.env.H5Environment.getContext()     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                r6 = 1
                java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                java.lang.String r8 = r9.filePath     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                r7[r2] = r8     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                java.lang.String r8 = "image/*"
                java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                android.media.MediaScannerConnection.scanFile(r0, r7, r8, r3)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
                return r6
            L_0x00fb:
                r0 = move-exception
                goto L_0x0118
            L_0x00fd:
                r0 = move-exception
                goto L_0x0103
            L_0x00ff:
                r0 = move-exception
                goto L_0x0119
            L_0x0101:
                r0 = move-exception
                r5 = r3
            L_0x0103:
                r3 = r4
                goto L_0x010a
            L_0x0105:
                r0 = move-exception
                r4 = r3
                goto L_0x0119
            L_0x0108:
                r0 = move-exception
                r5 = r3
            L_0x010a:
                java.lang.String r4 = "save image exception"
                com.alipay.mobile.nebula.util.H5Log.e(r1, r4, r0)     // Catch:{ all -> 0x0116 }
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
                return r2
            L_0x0116:
                r0 = move-exception
                r4 = r3
            L_0x0118:
                r3 = r5
            L_0x0119:
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r4)
                com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5LongClickPlugin.ImageSaveRunner.download():boolean");
        }
    }
}

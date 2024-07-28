package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.util.H5CommonScreenshotListener;
import com.alipay.mobile.nebulacore.util.H5ScreenShotObserver;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5SnapshotPlugin extends H5SimplePlugin {
    private static final String ADD_SCREENSHOT = "addScreenshotListener";
    private static final String DATATYPE = "dataType";
    private static final String DATAURL = "dataURL";
    private static final String FILEURL = "fileURL";
    private static final String IMAGEFORMAT = "imageFormat";
    private static final String MAXHEIGHT = "maxHeight";
    private static final String MAXWIDTH = "maxWidth";
    private static final String QUALLTY = "quality";
    private static final String RANGE = "range";
    private static final String RANGE_DOCUMENT = "document";
    private static final String RANGE_EMBEDVIEW = "embedview";
    private static final String RANGE_SCREEN = "screen";
    private static final String RANGE_VIEWPORT = "viewport";
    private static final String SAVETOGALLERY = "saveToGallery";
    private static final String SNAPSHOT = "snapshot";
    private static final String SNOPSHOT_JPG = "jpg";
    public static final String TAG = "H5SnapshotPlugin";
    /* access modifiers changed from: private */
    public List<BroadcastReceiver> embedViewSnapshotBroadcastReceivers;
    /* access modifiers changed from: private */
    public final Set<H5Page> foregroundPages = new HashSet();
    private String imagePath;
    /* access modifiers changed from: private */
    public a localBroadcastManager;
    private final Set<H5Page> registerScreenshotPages = new HashSet();
    private H5ScreenShotObserver screenShotObserver;
    /* access modifiers changed from: private */
    public H5Session session;

    public H5SnapshotPlugin(H5Session h5Session) {
        this.session = h5Session;
        this.screenShotObserver = new H5ScreenShotObserver(H5Environment.getContext());
        this.screenShotObserver.setCommonListener(new H5CommonScreenshotListener());
        this.localBroadcastManager = a.a(H5Environment.getContext());
        this.embedViewSnapshotBroadcastReceivers = new ArrayList();
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction("snapshot");
        h5EventFilter.addAction(ADD_SCREENSHOT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RESUME);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PAUSE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_CLOSED);
    }

    public void onRelease() {
        H5ScreenShotObserver h5ScreenShotObserver = this.screenShotObserver;
        if (h5ScreenShotObserver != null) {
            h5ScreenShotObserver.release();
        }
        Set<H5Page> set = this.registerScreenshotPages;
        if (set != null) {
            set.clear();
        }
        Set<H5Page> set2 = this.foregroundPages;
        if (set2 != null) {
            set2.clear();
        }
        List<BroadcastReceiver> list = this.embedViewSnapshotBroadcastReceivers;
        if (list != null) {
            for (BroadcastReceiver a2 : list) {
                this.localBroadcastManager.a(a2);
            }
            this.embedViewSnapshotBroadcastReceivers.clear();
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (h5Event.getTarget() instanceof H5Page) {
            H5Page h5Page = (H5Page) h5Event.getTarget();
            if (this.registerScreenshotPages.contains(h5Page)) {
                char c2 = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -1689332344) {
                    if (hashCode != -1266238391) {
                        if (hashCode == -1151189414 && action.equals(H5Plugin.InternalEvents.H5_PAGE_PAUSE)) {
                            c2 = 1;
                        }
                    } else if (action.equals(H5Plugin.InternalEvents.H5_PAGE_RESUME)) {
                        c2 = 0;
                    }
                } else if (action.equals(H5Plugin.InternalEvents.H5_PAGE_CLOSED)) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    this.foregroundPages.add(h5Page);
                } else if (c2 == 1) {
                    this.foregroundPages.remove(h5Page);
                } else if (c2 == 2) {
                    this.registerScreenshotPages.remove(h5Page);
                    this.foregroundPages.remove(h5Page);
                }
            }
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (TextUtils.equals("snapshot", action)) {
            snapshot(h5Event, h5BridgeContext);
            return true;
        } else if (!TextUtils.equals(ADD_SCREENSHOT, action)) {
            return false;
        } else {
            H5CoreNode target = h5Event.getTarget();
            if (target == null || !(target instanceof H5Page)) {
                h5BridgeContext.sendSuccess();
                return true;
            }
            final H5Page h5Page = (H5Page) target;
            if (this.registerScreenshotPages.contains(h5Page)) {
                h5BridgeContext.sendError(-1, "already listening!");
                return true;
            }
            this.registerScreenshotPages.add(h5Page);
            this.foregroundPages.add(h5Page);
            this.screenShotObserver.registerListener(new H5ScreenShotObserver.H5ScreenShotListener() {
                public void onScreenShot() {
                    H5Bridge bridge;
                    H5Page topPage = H5SnapshotPlugin.this.session.getTopPage();
                    if (topPage != null && topPage == h5Page && H5SnapshotPlugin.this.foregroundPages.contains(h5Page) && (bridge = h5Page.getBridge()) != null) {
                        H5Log.d(H5SnapshotPlugin.TAG, "send screenshotbyuser event");
                        bridge.sendToWeb("screenshotbyuser", (e) null, (H5CallBack) null);
                    }
                }
            });
            h5BridgeContext.sendSuccess();
            return true;
        }
    }

    private void snapshot(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Bitmap bitmap;
        Bitmap captureDocument;
        H5Page h5Page = h5Event.getTarget() instanceof H5Page ? (H5Page) h5Event.getTarget() : null;
        if (h5Page != null) {
            Activity activity = h5Page.getContext().getContext() instanceof Activity ? (Activity) h5Page.getContext().getContext() : null;
            e param = h5Event.getParam();
            e eVar = new e();
            int i2 = H5Utils.getInt(param, MAXWIDTH, -1);
            int i3 = H5Utils.getInt(param, MAXHEIGHT, -1);
            String string = H5Utils.getString(param, "range", RANGE_SCREEN);
            boolean z = H5Utils.getBoolean(param, SAVETOGALLERY, true);
            String string2 = H5Utils.getString(param, DATATYPE, "none");
            String string3 = H5Utils.getString(param, IMAGEFORMAT, SNOPSHOT_JPG);
            int i4 = H5Utils.getInt(param, QUALLTY, 75);
            if (TextUtils.equals(string, RANGE_SCREEN)) {
                captureDocument = captureScreen(activity);
            } else if (TextUtils.equals(string, RANGE_VIEWPORT)) {
                captureDocument = captureWebView(h5Page.getWebView(), activity);
            } else if (TextUtils.equals(string, RANGE_DOCUMENT)) {
                captureDocument = captureDocument(h5Page.getWebView(), activity);
            } else if (TextUtils.equals(string, RANGE_EMBEDVIEW)) {
                captureEmbedView(activity, h5Event, h5BridgeContext, eVar, i2, i3, z, string2, string3, i4, (Bitmap) null);
                return;
            } else {
                bitmap = null;
                handleSnapshot(h5BridgeContext, activity, eVar, i2, i3, z, string2, string3, i4, bitmap);
            }
            bitmap = captureDocument;
            handleSnapshot(h5BridgeContext, activity, eVar, i2, i3, z, string2, string3, i4, bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void handleSnapshot(final H5BridgeContext h5BridgeContext, Activity activity, e eVar, int i2, int i3, boolean z, String str, final String str2, int i4, final Bitmap bitmap) {
        if (bitmap == null) {
            eVar.put("success", (Object) Boolean.FALSE);
            eVar.put("error", (Object) "2");
            eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Environment.getResources().getString(R.string.h5_getpicfailed));
            h5BridgeContext.sendBridgeResult(eVar);
            return;
        }
        if (i2 < 0) {
            i2 = bitmap.getWidth();
        }
        if (i3 < 0) {
            i3 = bitmap.getHeight();
        }
        if (!(i3 == bitmap.getHeight() && i2 == bitmap.getWidth())) {
            bitmap = H5ImageUtil.scaleBitmap(bitmap, i2, i3);
        }
        if (!(bitmap == null || !SNOPSHOT_JPG.equals(str2) || i4 == 100)) {
            bitmap = H5ImageUtil.imageQuality(bitmap, i4);
        }
        if (z) {
            int saveImage = saveImage(bitmap, str2);
            if (saveImage != 0) {
                String string = H5Environment.getResources().getString(R.string.h5_save_image_failed);
                if (activity != null && !activity.isFinishing()) {
                    if (saveImage == 1) {
                        string = H5Environment.getResources().getString(R.string.h5_snap_sd_error);
                    } else if (saveImage == 10 || saveImage == 3) {
                        string = H5Environment.getResources().getString(R.string.h5_snap_error);
                    }
                }
                eVar.put("success", (Object) Boolean.FALSE);
                eVar.put("error", (Object) Integer.valueOf(saveImage));
                eVar.put("errorMsg", (Object) string);
                h5BridgeContext.sendBridgeResult(eVar);
                return;
            } else if (activity != null && !activity.isFinishing()) {
                H5Environment.getResources().getString(R.string.h5_save_image_to, new Object[]{this.imagePath});
            }
        }
        if (FILEURL.equals(str)) {
            String imageTempDir = H5ImageUtil.getImageTempDir(H5Environment.getContext());
            String str3 = System.currentTimeMillis() + AppUtility.CENTER_DOT + str2;
            H5FileUtil.mkdirs(imageTempDir);
            H5ImageUtil.writeImage(bitmap, str2.equals(SNOPSHOT_JPG) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, imageTempDir + str3);
            if (!H5FileUtil.exists(imageTempDir + str3)) {
                eVar.put("success", (Object) Boolean.FALSE);
                eVar.put("error", (Object) 11);
                eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Environment.getResources().getString(R.string.h5_savepicfailed));
            } else {
                eVar.put("success", (Object) Boolean.TRUE);
                eVar.put(FILEURL, (Object) imageTempDir + str3);
            }
            h5BridgeContext.sendBridgeResult(eVar);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } else if (DATAURL.equals(str)) {
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public void run() {
                    String bitmapToString = H5ImageUtil.bitmapToString(bitmap, str2);
                    e eVar = new e();
                    eVar.put(H5SnapshotPlugin.DATAURL, (Object) bitmapToString);
                    eVar.put("success", (Object) Boolean.TRUE);
                    h5BridgeContext.sendBridgeResult(eVar);
                    Bitmap bitmap = bitmap;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                }
            });
        } else {
            h5BridgeContext.sendBridgeResult("success", Boolean.TRUE);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    public Bitmap captureScreen(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.buildDrawingCache();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            decorView.setDrawingCacheEnabled(true);
            if (height > decorView.getDrawingCache().getHeight()) {
                return decorView.getDrawingCache();
            }
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, i2, width, height - i2);
            decorView.destroyDrawingCache();
            return createBitmap;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
            if (h5LogProvider == null) {
                return null;
            }
            h5LogProvider.log(TAG, (String) null, (String) null, (String) null, (String) null, "H5SnapshotPlugin^captureScreenException=".concat(String.valueOf(e2)));
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void captureEmbedView(android.app.Activity r17, com.alipay.mobile.h5container.api.H5Event r18, com.alipay.mobile.h5container.api.H5BridgeContext r19, com.alibaba.a.e r20, int r21, int r22, boolean r23, java.lang.String r24, java.lang.String r25, int r26, android.graphics.Bitmap r27) {
        /*
            r16 = this;
            r15 = r16
            com.alipay.mobile.h5container.api.H5CoreNode r0 = r18.getTarget()     // Catch:{ Exception -> 0x0093 }
            com.alipay.mobile.h5container.api.H5Page r0 = (com.alipay.mobile.h5container.api.H5Page) r0     // Catch:{ Exception -> 0x0093 }
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            boolean r1 = r0.ifContainsEmbedView()     // Catch:{ Exception -> 0x0093 }
            if (r1 == 0) goto L_0x0074
            android.view.WindowManager r1 = r17.getWindowManager()     // Catch:{ Exception -> 0x0093 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception -> 0x0093 }
            int r4 = r1.getWidth()     // Catch:{ Exception -> 0x0093 }
            com.alipay.mobile.nebula.webview.APWebView r1 = r0.getWebView()     // Catch:{ Exception -> 0x0093 }
            android.view.View r1 = r1.getView()     // Catch:{ Exception -> 0x0093 }
            int r5 = r1.getMeasuredHeight()     // Catch:{ Exception -> 0x0093 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0093 }
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r4, r5, r1)     // Catch:{ Exception -> 0x0093 }
            android.content.IntentFilter r14 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0093 }
            r14.<init>()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r1 = "embedview.snapshot.complete"
            r14.addAction(r1)     // Catch:{ Exception -> 0x0093 }
            com.alipay.mobile.nebulacore.plugin.H5SnapshotPlugin$3 r13 = new com.alipay.mobile.nebulacore.plugin.H5SnapshotPlugin$3     // Catch:{ Exception -> 0x0093 }
            r1 = r13
            r2 = r16
            r3 = r0
            r7 = r19
            r8 = r17
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r18 = r0
            r0 = r13
            r13 = r24
            r17 = r0
            r0 = r14
            r14 = r25
            r15 = r26
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0070 }
            r12 = r16
            androidx.localbroadcastmanager.a.a r1 = r12.localBroadcastManager     // Catch:{ Exception -> 0x0091 }
            r2 = r17
            r1.a(r2, r0)     // Catch:{ Exception -> 0x0091 }
            java.util.List<android.content.BroadcastReceiver> r0 = r12.embedViewSnapshotBroadcastReceivers     // Catch:{ Exception -> 0x0091 }
            r0.add(r2)     // Catch:{ Exception -> 0x0091 }
            com.alipay.mobile.nebula.provider.H5EmbededViewProvider r0 = r18.getEmbededViewProvider()     // Catch:{ Exception -> 0x0091 }
            r0.triggerPreSnapshot()     // Catch:{ Exception -> 0x0091 }
            return
        L_0x0070:
            r0 = move-exception
            r12 = r16
            goto L_0x0095
        L_0x0074:
            r12 = r15
            android.graphics.Bitmap r11 = r16.captureScreen(r17)     // Catch:{ Exception -> 0x0091 }
            r1 = r16
            r2 = r19
            r3 = r17
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r1.handleSnapshot(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0091 }
            return
        L_0x0091:
            r0 = move-exception
            goto L_0x0095
        L_0x0093:
            r0 = move-exception
            r12 = r15
        L_0x0095:
            java.lang.String r1 = "H5SnapshotPlugin"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r1 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r2 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r1 = r1.getProvider(r2)
            com.alipay.mobile.nebula.provider.H5LogProvider r1 = (com.alipay.mobile.nebula.provider.H5LogProvider) r1
            if (r1 == 0) goto L_0x00cd
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "H5SnapshotPlugin^captureScreenException="
            java.lang.String r0 = r2.concat(r0)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r6 = "H5SnapshotPlugin"
            r17 = r1
            r18 = r6
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r0
            r17.log(r18, r19, r20, r21, r22, r23)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5SnapshotPlugin.captureEmbedView(android.app.Activity, com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext, com.alibaba.a.e, int, int, boolean, java.lang.String, java.lang.String, int, android.graphics.Bitmap):void");
    }

    private Bitmap captureWebView(APWebView aPWebView, Activity activity) {
        try {
            View view = aPWebView.getView();
            view.setDrawingCacheEnabled(true);
            Bitmap copy = view.getDrawingCache().copy(view.getDrawingCache().getConfig(), false);
            view.setDrawingCacheEnabled(false);
            return copy;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log(TAG, (String) null, (String) null, (String) null, (String) null, "H5SnapshotPlugin^captureWebViewException=".concat(String.valueOf(e2)));
            }
            return captureScreen(activity);
        }
    }

    private Bitmap captureDocument(APWebView aPWebView, Activity activity) {
        try {
            Picture capturePicture = aPWebView.capturePicture();
            if (capturePicture == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log(TAG, (String) null, (String) null, (String) null, (String) null, "H5SnapshotPlugin^captureDocumentException=".concat(String.valueOf(e2)));
            }
            return captureWebView(aPWebView, activity);
        }
    }

    private int saveImage(Bitmap bitmap, String str) {
        if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
            return 1;
        }
        try {
            H5EnvProvider h5EnvProvider = (H5EnvProvider) H5Utils.getProvider(H5EnvProvider.class.getName());
            String snapshotJsapiSavePath = h5EnvProvider != null ? h5EnvProvider.getSnapshotJsapiSavePath() : null;
            if (TextUtils.isEmpty(snapshotJsapiSavePath)) {
                snapshotJsapiSavePath = "/DCIM/Alipay/";
            }
            this.imagePath = Environment.getExternalStorageDirectory() + snapshotJsapiSavePath + System.currentTimeMillis() + AppUtility.CENTER_DOT + str;
            H5FileUtil.create(this.imagePath);
            FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
            boolean compress = bitmap.compress(SNOPSHOT_JPG.equals(str) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            if (!compress) {
                return 10;
            }
            MediaScannerConnection.scanFile(H5Environment.getContext(), new String[]{this.imagePath}, new String[]{"image/*"}, (MediaScannerConnection.OnScanCompletedListener) null);
            return 0;
        } catch (Exception e2) {
            H5Log.e(TAG, "saveImage exception.", e2);
            return 3;
        }
    }

    class EmbedViewSnapshotBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
        }

        private EmbedViewSnapshotBroadcastReceiver() {
        }
    }
}

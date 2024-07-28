package com.alipay.iap.android.webapp.sdk.plugin;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class LoadLocalImagePlugin extends H5SimplePlugin {
    private static final String ACTION = "loadLocalImage";
    public static final int ERR_FILE_NOT_FOUND_OR_NOT_READABLE = 103;
    public static final int ERR_INVALID_FILE_PATH = 101;
    public static final int ERR_MISSING_FILE_PATH = 100;
    public static final int ERR_UNKNOWN_IMAGE_FORMAT = 104;
    public static final int ERR_UNSUPPORTED_FILE_PATH = 102;
    private static final String KEY_FILEPATH = "filePath";
    public static final int NO_ERROR = 0;
    private static final String TAG = "LoadLocalImagePlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(ACTION);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event.getParam() == null || !h5Event.getParam().containsKey("filePath") || !(h5Event.getParam().get("filePath") instanceof String)) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return false;
        }
        String str = (String) h5Event.getParam().get("filePath");
        if (!TextUtils.isEmpty(str)) {
            loadLocalImage(str, h5BridgeContext);
            return true;
        }
        h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
        return true;
    }

    /* access modifiers changed from: package-private */
    public byte[] retrieveImageBytesFromFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[((int) file.length())];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read > 0) {
                return bArr;
            }
            return null;
        } catch (FileNotFoundException unused) {
            c.j();
            return null;
        } catch (IOException unused2) {
            c.j();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String encodeImageBytesToString(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(Base64.encode(bArr, 0), AppConstants.UTF_8);
            } catch (UnsupportedEncodingException unused) {
                c.j();
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CheckFilePathResult checkFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return new CheckFilePathResult(100, "Missing filePath");
        }
        if (str.contains("/../")) {
            return new CheckFilePathResult(101, "Invalid filePath");
        }
        if (!str.startsWith("/") && !str.startsWith("file://")) {
            return new CheckFilePathResult(102, "Unsupported filePath");
        }
        File file = new File(URI.create(str).getPath());
        if (!file.exists() || !file.canRead()) {
            return new CheckFilePathResult(103, "File not found or not readable");
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
            fileInputStream.close();
            String str2 = options.outMimeType;
            if (str2 == null || !str2.contains(H5ResourceHandlerUtil.IMAGE)) {
                return new CheckFilePathResult(104, "Unknown image format");
            }
        } catch (FileNotFoundException unused) {
            return new CheckFilePathResult(103, "File not found or not readable");
        } catch (IOException unused2) {
            c.j();
        }
        return new CheckFilePathResult(file);
    }

    /* access modifiers changed from: package-private */
    public void sendErrorBridgeResult(H5BridgeContext h5BridgeContext, int i2, String str) {
        e eVar = new e();
        eVar.put("error", (Object) Integer.valueOf(i2));
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) str);
        h5BridgeContext.sendBridgeResult(eVar);
    }

    /* access modifiers changed from: package-private */
    public void loadLocalImage(final String str, final H5BridgeContext h5BridgeContext) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                CheckFilePathResult checkFilePath = LoadLocalImagePlugin.this.checkFilePath(str);
                if (checkFilePath.isSuccessful()) {
                    String encodeImageBytesToString = LoadLocalImagePlugin.this.encodeImageBytesToString(LoadLocalImagePlugin.this.retrieveImageBytesFromFile(checkFilePath.file));
                    if (encodeImageBytesToString != null) {
                        h5BridgeContext.sendBridgeResult("data", encodeImageBytesToString);
                        return;
                    }
                    return;
                }
                LoadLocalImagePlugin.this.sendErrorBridgeResult(h5BridgeContext, checkFilePath.errorCode, checkFilePath.errorMessage);
            }
        });
    }

    static class CheckFilePathResult {
        public final int errorCode;
        public final String errorMessage;
        public final File file;

        /* access modifiers changed from: package-private */
        public boolean isSuccessful() {
            return this.errorCode == 0;
        }

        CheckFilePathResult(File file2) {
            this.errorCode = 0;
            this.errorMessage = "";
            this.file = file2;
        }

        CheckFilePathResult(int i2, String str) {
            this.file = null;
            this.errorCode = i2;
            this.errorMessage = str;
        }
    }
}

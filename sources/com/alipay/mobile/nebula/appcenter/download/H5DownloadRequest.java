package com.alipay.mobile.nebula.appcenter.download;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.appcenter.util.H5ZExternalFile;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5DownloadRequest implements Parcelable {
    public static final String AUTO_LOGIN = "auto_login";
    public static final Parcelable.Creator<H5DownloadRequest> CREATOR = new Parcelable.Creator<H5DownloadRequest>() {
        public final H5DownloadRequest createFromParcel(Parcel parcel) {
            return new H5DownloadRequest(parcel);
        }

        public final H5DownloadRequest[] newArray(int i2) {
            return new H5DownloadRequest[i2];
        }
    };
    public static final String FULL_RPC_SCENE = "full_rpc_scene";
    public static final String NET_CHANGE = "net_change";
    public static final String SYNC_SCENE = "sync_scene";
    private static final String TAG = "H5DownloadRequest";
    public static final String USER_LEAVE_HINT_SCENE = "user_leave_hint_scene";
    public static final String nebulaDownload = "nebulaDownload";
    public static final String nebulaH5App = "nebulaH5App";
    private String appId;
    private boolean autoInstall;
    private boolean autoLaunch;
    private String description;
    private String downloadUrl;
    private String fileName;
    private boolean needProgress;
    private String scene;
    private boolean showRunningNotification;
    private String targetFileName;
    private String title;
    private String version;

    public int describeContents() {
        return 0;
    }

    public static boolean isFromPreDownload(String str) {
        return FULL_RPC_SCENE.equals(str) || SYNC_SCENE.equals(str) || USER_LEAVE_HINT_SCENE.equals(str) || AUTO_LOGIN.equals(str) || NET_CHANGE.equals(str);
    }

    public H5DownloadRequest() {
        this.targetFileName = "";
        this.needProgress = true;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getTargetFileName() {
        return this.targetFileName;
    }

    public void setTargetFileName(String str) {
        this.targetFileName = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isShowRunningNotification() {
        return this.showRunningNotification;
    }

    public void setShowRunningNotification(boolean z) {
        this.showRunningNotification = z;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public boolean isAutoInstall() {
        return this.autoInstall;
    }

    public void setAutoInstall(boolean z) {
        this.autoInstall = z;
    }

    public boolean isNeedProgress() {
        return this.needProgress;
    }

    public void setNeedProgress(boolean z) {
        this.needProgress = z;
    }

    public boolean isAutoLaunch() {
        return this.autoLaunch;
    }

    public void setAutoLaunch(boolean z) {
        this.autoLaunch = z;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public static String getDefaultDownloadDir(Context context) {
        H5ZExternalFile h5ZExternalFile = new H5ZExternalFile(context, nebulaDownload, "downloads");
        String absolutePath = h5ZExternalFile.getAbsolutePath();
        H5Log.d(TAG, "downloadDir:".concat(String.valueOf(absolutePath)));
        if (!h5ZExternalFile.exists() && !h5ZExternalFile.mkdirs()) {
            H5Log.e(TAG, "path not exist but fail to create: ".concat(String.valueOf(absolutePath)));
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_CREATE_FILE).appendMessage("path not exist and fail to create").appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, absolutePath));
            return null;
        } else if (h5ZExternalFile.isDirectory()) {
            return absolutePath;
        } else {
            H5Log.e(TAG, absolutePath + " dir exist,but not directory.");
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_CREATE_FILE).appendMessage("dir exist,but not directory").appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, absolutePath));
            return null;
        }
    }

    public static String getOldDownloadDir(Context context) {
        H5ZExternalFile h5ZExternalFile = new H5ZExternalFile(context, "nebulaH5App", "downloads");
        String absolutePath = h5ZExternalFile.getAbsolutePath();
        H5Log.d(TAG, "downloadDir:".concat(String.valueOf(absolutePath)));
        if (!h5ZExternalFile.exists() && !h5ZExternalFile.mkdirs()) {
            H5Log.e(TAG, "path not exist but fail to create: ".concat(String.valueOf(absolutePath)));
            return absolutePath;
        } else if (h5ZExternalFile.isDirectory()) {
            return absolutePath;
        } else {
            H5Log.e(TAG, absolutePath + " dir exist,but not directory.");
            return null;
        }
    }

    private H5DownloadRequest(Parcel parcel) {
        this.targetFileName = "";
        boolean z = true;
        this.needProgress = true;
        this.downloadUrl = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.showRunningNotification = parcel.readInt() != 0;
        this.appId = parcel.readString();
        this.fileName = parcel.readString();
        this.targetFileName = parcel.readString();
        this.autoInstall = parcel.readInt() != 0;
        this.needProgress = parcel.readInt() != 0;
        this.autoLaunch = parcel.readInt() == 0 ? false : z;
        this.version = parcel.readString();
        this.scene = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeInt(this.showRunningNotification ? 1 : 0);
        parcel.writeString(this.appId);
        parcel.writeString(this.fileName);
        parcel.writeString(this.targetFileName);
        parcel.writeInt(this.autoInstall ? 1 : 0);
        parcel.writeInt(this.needProgress ? 1 : 0);
        parcel.writeInt(this.autoLaunch ? 1 : 0);
        parcel.writeString(this.version);
        parcel.writeString(this.scene);
    }
}

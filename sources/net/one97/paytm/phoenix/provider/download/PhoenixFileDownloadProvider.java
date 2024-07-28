package net.one97.paytm.phoenix.provider.download;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PhoenixFileDownloadProvider {
    public static final Companion Companion = new Companion((g) null);
    public static final String FILES_DIR_NAME = "PHOENIX_DOWNLOADS";

    public interface OnFileDeletedInterface {
        void onFileDeletionOperationFinished(String str, boolean z, FileDownloadError fileDownloadError);
    }

    public interface OnFileDownloadedInterface {
        void onDownloadOperationFinished(String str, String str2, String str3, FileDownloadError fileDownloadError);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void enqueueFileDownload(Context context, String str, String str2, boolean z, OnFileDownloadedInterface onFileDownloadedInterface) {
        k.c(context, "context");
        k.c(onFileDownloadedInterface, "downloadHandler");
        if (z && !hasExternalStoragePermissions(context)) {
            onFileDownloadedInterface.onDownloadOperationFinished(str, str2, (String) null, createDownloadErrorForNoExternalStoragePermissions());
        } else if (!z || isExternalStorageMounted()) {
            String absolutePath = createFile(context, z, str).getAbsolutePath();
            PhoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1 phoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1 = new PhoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1(absolutePath, onFileDownloadedInterface, str, str2);
            k.a((Object) absolutePath, "outputFilePath");
            new FileDownloadTask(str2, absolutePath, FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT, phoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1).execute(new Void[0]);
        } else {
            onFileDownloadedInterface.onDownloadOperationFinished(str, str2, (String) null, createDownloadErrorForNoExternalStorageMounted());
        }
    }

    public final void enqueueFileRemoval(Context context, String str, boolean z, OnFileDeletedInterface onFileDeletedInterface) {
        k.c(context, "context");
        k.c(onFileDeletedInterface, "deletionHandler");
        AsyncTask.execute(new PhoenixFileDownloadProvider$enqueueFileRemoval$runnable$1(this, context, str, z, onFileDeletedInterface));
    }

    /* access modifiers changed from: private */
    public final void removeFile(Context context, String str, boolean z, OnFileDeletedInterface onFileDeletedInterface) {
        if (z && !hasExternalStoragePermissions(context)) {
            onFileDeletedInterface.onFileDeletionOperationFinished(str, false, createDownloadErrorForNoExternalStoragePermissions());
        } else if (!z || isExternalStorageMounted()) {
            File createFile = createFile(context, z, str);
            if (!createFile.exists()) {
                onFileDeletedInterface.onFileDeletionOperationFinished(str, false, createDownloadErrorForFileNotFound());
            } else if (createFile.delete()) {
                onFileDeletedInterface.onFileDeletionOperationFinished(str, true, (FileDownloadError) null);
            } else {
                onFileDeletedInterface.onFileDeletionOperationFinished(str, false, createDownloadErrorForFileNotDeleted());
            }
        } else {
            onFileDeletedInterface.onFileDeletionOperationFinished(str, false, createDownloadErrorForNoExternalStorageMounted());
        }
    }

    public final String getFilePath(Context context, boolean z, String str) {
        k.c(context, "context");
        File createFile = createFile(context, z, str);
        if (createFile.exists()) {
            return createFile.getAbsolutePath();
        }
        return null;
    }

    private final File createFile(Context context, boolean z, String str) {
        return new File(getDir(context, z), str);
    }

    private final File getDir(Context context, boolean z) {
        File file;
        if (z) {
            StringBuilder sb = new StringBuilder();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            k.a((Object) externalStorageDirectory, "Environment.getExternalStorageDirectory()");
            sb.append(externalStorageDirectory.getAbsolutePath());
            sb.append("/PHOENIX_DOWNLOADS");
            file = new File(sb.toString());
        } else {
            file = new File(context.getFilesDir(), FILES_DIR_NAME);
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final boolean hasExternalStoragePermissions(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    private final boolean isExternalStorageMounted() {
        return k.a((Object) Environment.getExternalStorageState(), (Object) "mounted");
    }

    private final FileDownloadError createDownloadErrorForNoExternalStoragePermissions() {
        return new FileDownloadError(4, FileDownloadErrorCodesKt.EXTERNAL_STORAGE_NO_PERMISSIONS_ERR_MSG);
    }

    private final FileDownloadError createDownloadErrorForNoExternalStorageMounted() {
        return new FileDownloadError(5, FileDownloadErrorCodesKt.EXTERNAL_STORAGE_NOT_MOUNTED_ERR_MSG);
    }

    private final FileDownloadError createDownloadErrorForFileNotFound() {
        return new FileDownloadError(6, FileDownloadErrorCodesKt.FILE_NOT_FOUND_ERR_MSG);
    }

    private final FileDownloadError createDownloadErrorForFileNotDeleted() {
        return new FileDownloadError(7, FileDownloadErrorCodesKt.FILE_NOT_DELETED_ERR_MSG);
    }
}

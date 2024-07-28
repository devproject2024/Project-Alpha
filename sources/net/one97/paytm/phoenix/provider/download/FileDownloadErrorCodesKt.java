package net.one97.paytm.phoenix.provider.download;

public final class FileDownloadErrorCodesKt {
    public static final int CANCELLATION_ERR_CODE = 3;
    public static final String CANCELLATION_ERR_MSG = "The download operation was cancelled.";
    public static final int EXCEPTION_ERR_CODE = 2;
    public static final int EXTERNAL_STORAGE_NOT_MOUNTED_ERR_CODE = 5;
    public static final String EXTERNAL_STORAGE_NOT_MOUNTED_ERR_MSG = "External storage is not mounted.";
    public static final int EXTERNAL_STORAGE_NO_PERMISSIONS_ERR_CODE = 4;
    public static final String EXTERNAL_STORAGE_NO_PERMISSIONS_ERR_MSG = "Either or both of read and write to external storage permissions were not detected.";
    public static final int FILE_NOT_DELETED_ERR_CODE = 7;
    public static final String FILE_NOT_DELETED_ERR_MSG = "File could not be deleted.";
    public static final int FILE_NOT_FOUND_ERR_CODE = 6;
    public static final String FILE_NOT_FOUND_ERR_MSG = "File not found.";
    public static final int NOT_OK_HTTP_STATUS_ERR_CODE = 1;
    public static final String NOT_OK_HTTP_STATUS_ERR_MSG_PREFIX = "The server returned a not OK HTTP Response Code: ";
    public static final int SOCKET_TIMEOUT_EXCEPTION_ERR_CODE = 9;
    public static final int UNKNOWN_HOST_EXCEPTION_ERR_CODE = 8;
    public static final int WRITE_ERR_CODE = 10;
    public static final String WRITE_ERR_MSG = "An error occurred while writing file.";
}

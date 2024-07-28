package net.one97.paytm.phoenix.provider.download;

import kotlin.g.b.k;

public final class FileDownloadError {
    private final int code;
    private final String message;

    public static /* synthetic */ FileDownloadError copy$default(FileDownloadError fileDownloadError, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = fileDownloadError.code;
        }
        if ((i3 & 2) != 0) {
            str = fileDownloadError.message;
        }
        return fileDownloadError.copy(i2, str);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final FileDownloadError copy(int i2, String str) {
        k.c(str, "message");
        return new FileDownloadError(i2, str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FileDownloadError) {
                FileDownloadError fileDownloadError = (FileDownloadError) obj;
                if (!(this.code == fileDownloadError.code) || !k.a((Object) this.message, (Object) fileDownloadError.message)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.code).hashCode() * 31;
        String str = this.message;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FileDownloadError(code=" + this.code + ", message=" + this.message + ")";
    }

    public FileDownloadError(int i2, String str) {
        k.c(str, "message");
        this.code = i2;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}

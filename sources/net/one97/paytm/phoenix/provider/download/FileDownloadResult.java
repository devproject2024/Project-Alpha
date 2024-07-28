package net.one97.paytm.phoenix.provider.download;

import kotlin.g.b.k;

public final class FileDownloadResult {
    private final FileDownloadError error;
    private final boolean success;

    public static /* synthetic */ FileDownloadResult copy$default(FileDownloadResult fileDownloadResult, boolean z, FileDownloadError fileDownloadError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = fileDownloadResult.success;
        }
        if ((i2 & 2) != 0) {
            fileDownloadError = fileDownloadResult.error;
        }
        return fileDownloadResult.copy(z, fileDownloadError);
    }

    public final boolean component1() {
        return this.success;
    }

    public final FileDownloadError component2() {
        return this.error;
    }

    public final FileDownloadResult copy(boolean z, FileDownloadError fileDownloadError) {
        return new FileDownloadResult(z, fileDownloadError);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FileDownloadResult) {
                FileDownloadResult fileDownloadResult = (FileDownloadResult) obj;
                if (!(this.success == fileDownloadResult.success) || !k.a((Object) this.error, (Object) fileDownloadResult.error)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.success;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        FileDownloadError fileDownloadError = this.error;
        return i2 + (fileDownloadError != null ? fileDownloadError.hashCode() : 0);
    }

    public final String toString() {
        return "FileDownloadResult(success=" + this.success + ", error=" + this.error + ")";
    }

    public FileDownloadResult(boolean z, FileDownloadError fileDownloadError) {
        this.success = z;
        this.error = fileDownloadError;
    }

    public final FileDownloadError getError() {
        return this.error;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}

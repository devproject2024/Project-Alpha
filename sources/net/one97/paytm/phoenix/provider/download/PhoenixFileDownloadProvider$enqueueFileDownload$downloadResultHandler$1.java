package net.one97.paytm.phoenix.provider.download;

import kotlin.g.b.k;
import net.one97.paytm.phoenix.provider.download.FileDownloadTask;
import net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider;

public final class PhoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1 implements FileDownloadTask.OnFileDownloadResultHandler {
    final /* synthetic */ PhoenixFileDownloadProvider.OnFileDownloadedInterface $downloadHandler;
    final /* synthetic */ String $fileDownloadUrl;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $outputFilePath;

    PhoenixFileDownloadProvider$enqueueFileDownload$downloadResultHandler$1(String str, PhoenixFileDownloadProvider.OnFileDownloadedInterface onFileDownloadedInterface, String str2, String str3) {
        this.$outputFilePath = str;
        this.$downloadHandler = onFileDownloadedInterface;
        this.$fileName = str2;
        this.$fileDownloadUrl = str3;
    }

    public final void onDownloadResult(FileDownloadResult fileDownloadResult) {
        k.c(fileDownloadResult, "result");
        this.$downloadHandler.onDownloadOperationFinished(this.$fileName, this.$fileDownloadUrl, fileDownloadResult.getSuccess() ? this.$outputFilePath : null, fileDownloadResult.getError());
    }
}

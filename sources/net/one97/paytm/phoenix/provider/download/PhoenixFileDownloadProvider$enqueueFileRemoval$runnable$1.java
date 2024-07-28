package net.one97.paytm.phoenix.provider.download;

import android.content.Context;
import net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider;

final class PhoenixFileDownloadProvider$enqueueFileRemoval$runnable$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhoenixFileDownloadProvider.OnFileDeletedInterface $deletionHandler;
    final /* synthetic */ String $fileName;
    final /* synthetic */ boolean $useExternalStorage;
    final /* synthetic */ PhoenixFileDownloadProvider this$0;

    PhoenixFileDownloadProvider$enqueueFileRemoval$runnable$1(PhoenixFileDownloadProvider phoenixFileDownloadProvider, Context context, String str, boolean z, PhoenixFileDownloadProvider.OnFileDeletedInterface onFileDeletedInterface) {
        this.this$0 = phoenixFileDownloadProvider;
        this.$context = context;
        this.$fileName = str;
        this.$useExternalStorage = z;
        this.$deletionHandler = onFileDeletedInterface;
    }

    public final void run() {
        this.this$0.removeFile(this.$context, this.$fileName, this.$useExternalStorage, this.$deletionHandler);
    }
}

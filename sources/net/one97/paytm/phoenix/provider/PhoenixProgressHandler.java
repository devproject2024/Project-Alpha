package net.one97.paytm.phoenix.provider;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.k;

public final class PhoenixProgressHandler {
    private int progress;
    private Set<ProgressCallback> progressObservers = new LinkedHashSet();

    public interface ProgressCallback {
        void onPageFinished();

        void onPageStarted();

        void onProgressUpdate(int i2);
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress$phoenix_debug(int i2) {
        this.progress = i2;
        for (ProgressCallback onProgressUpdate : this.progressObservers) {
            onProgressUpdate.onProgressUpdate(i2);
        }
    }

    public final void onPageFinished$phoenix_debug() {
        for (ProgressCallback onPageFinished : this.progressObservers) {
            onPageFinished.onPageFinished();
        }
    }

    public final void onPageStarted$phoenix_debug() {
        for (ProgressCallback onPageStarted : this.progressObservers) {
            onPageStarted.onPageStarted();
        }
    }

    public final void registerObserver(ProgressCallback progressCallback) {
        k.c(progressCallback, "progressCallback");
        if (!this.progressObservers.contains(progressCallback)) {
            this.progressObservers.add(progressCallback);
        }
    }

    public final void unregisterObserver(ProgressCallback progressCallback) {
        k.c(progressCallback, "progressCallback");
        if (this.progressObservers.contains(progressCallback)) {
            this.progressObservers.remove(progressCallback);
            return;
        }
        throw new IllegalStateException("Must register observer before unregister");
    }
}

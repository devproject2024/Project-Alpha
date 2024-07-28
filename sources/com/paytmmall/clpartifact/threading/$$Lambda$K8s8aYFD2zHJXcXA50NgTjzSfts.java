package com.paytmmall.clpartifact.threading;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.paytmmall.clpartifact.threading.-$$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts implements ThreadFactory {
    public static final /* synthetic */ $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts INSTANCE = new $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts();

    private /* synthetic */ $$Lambda$K8s8aYFD2zHJXcXA50NgTjzSfts() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }
}

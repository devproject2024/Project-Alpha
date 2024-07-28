package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bl;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class dj implements bl<Executor> {
    public final /* synthetic */ Object a() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(cz.f37185a);
        an.a(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }
}

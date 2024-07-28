package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bl;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class dc implements bl<Executor> {
    public final /* synthetic */ Object a() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(cy.f37184a);
        an.a(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }
}

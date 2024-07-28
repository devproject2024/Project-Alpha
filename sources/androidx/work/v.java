package androidx.work;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.j;
import com.google.b.a.a.a;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class v {
    public abstract LiveData<u> a(UUID uuid);

    public abstract o a(String str);

    public abstract o a(String str, f fVar, p pVar);

    public abstract o a(String str, g gVar, List<n> list);

    public abstract o a(List<? extends w> list);

    public abstract o b();

    public abstract o b(String str);

    public abstract t b(List<n> list);

    public abstract a<List<u>> c(String str);

    @Deprecated
    public static v a() {
        j c2 = j.c();
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    public static v a(Context context) {
        return j.b(context);
    }

    public final o a(w wVar) {
        return a((List<? extends w>) Collections.singletonList(wVar));
    }

    public final o a(String str, g gVar, n nVar) {
        return a(str, gVar, (List<n>) Collections.singletonList(nVar));
    }

    protected v() {
    }
}

package com.google.android.play.core.d;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.e.e;
import java.util.List;
import java.util.Set;

public interface b {
    e<List<d>> a();

    e<Void> a(int i2);

    e<Integer> a(c cVar);

    e<Void> a(List<String> list);

    void a(e eVar);

    boolean a(d dVar, Activity activity, int i2) throws IntentSender.SendIntentException;

    e<Void> b(List<String> list);

    Set<String> b();
}

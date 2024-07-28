package com.airbnb.lottie.a.a;

import android.graphics.Path;
import com.airbnb.lottie.f.h;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private List<s> f5652a = new ArrayList();

    /* access modifiers changed from: package-private */
    public final void a(s sVar) {
        this.f5652a.add(sVar);
    }

    public final void a(Path path) {
        for (int size = this.f5652a.size() - 1; size >= 0; size--) {
            h.a(path, this.f5652a.get(size));
        }
    }
}

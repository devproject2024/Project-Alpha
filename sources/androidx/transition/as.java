package androidx.transition;

import android.view.View;
import android.view.WindowId;

final class as implements at {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f4770a;

    as(View view) {
        this.f4770a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof as) && ((as) obj).f4770a.equals(this.f4770a);
    }

    public final int hashCode() {
        return this.f4770a.hashCode();
    }
}

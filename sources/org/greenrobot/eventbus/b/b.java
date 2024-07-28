package org.greenrobot.eventbus.b;

import android.os.Bundle;
import org.greenrobot.eventbus.c;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final a f72835a;

    /* access modifiers changed from: protected */
    public abstract T a();

    /* access modifiers changed from: protected */
    public final T a(f fVar, boolean z, Bundle bundle) {
        Bundle bundle2;
        int i2;
        if (fVar.a()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", this.f72835a.f72826a.getString(this.f72835a.f72827b));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            a aVar = this.f72835a;
            Throwable th = fVar.f72845a;
            Integer a2 = aVar.f72829d.a(th);
            if (a2 != null) {
                i2 = a2.intValue();
            } else {
                String str = c.f72848a;
                new StringBuilder("No specific message ressource ID found for ").append(th);
                i2 = aVar.f72828c;
            }
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", this.f72835a.f72826a.getString(i2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.f72835a.f72834i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.f72835a.f72834i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.f72835a.f72833h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.f72835a.f72833h);
        }
        return a();
    }
}

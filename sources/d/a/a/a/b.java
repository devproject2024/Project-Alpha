package d.a.a.a;

import android.os.Bundle;
import d.a.a.c;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final a f45926a;

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
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", this.f45926a.f45917a.getString(this.f45926a.f45918b));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            a aVar = this.f45926a;
            Throwable th = fVar.f45936a;
            Integer a2 = aVar.f45920d.a(th);
            if (a2 != null) {
                i2 = a2.intValue();
            } else {
                String str = c.f45942a;
                new StringBuilder("No specific message ressource ID found for ").append(th);
                i2 = aVar.f45919c;
            }
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", this.f45926a.f45917a.getString(i2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.f45926a.f45925i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.f45926a.f45925i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.f45926a.f45924h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.f45926a.f45924h);
        }
        return a();
    }
}

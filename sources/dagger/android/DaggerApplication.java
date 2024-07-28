package dagger.android;

import android.app.Application;

public abstract class DaggerApplication extends Application implements c {

    /* renamed from: a  reason: collision with root package name */
    volatile b<Object> f46002a;

    /* access modifiers changed from: protected */
    public abstract a<? extends DaggerApplication> a();

    public void onCreate() {
        super.onCreate();
        if (this.f46002a == null) {
            synchronized (this) {
                if (this.f46002a == null) {
                    a().a(this);
                    if (this.f46002a == null) {
                        throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
                    }
                }
            }
        }
    }
}

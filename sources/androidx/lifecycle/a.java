package androidx.lifecycle;

import android.app.Application;

public class a extends ai {
    private Application mApplication;

    public a(Application application) {
        this.mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return this.mApplication;
    }
}

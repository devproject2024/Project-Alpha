package io.branch.referral;

import android.app.Application;
import android.content.Context;

public class BranchApp extends Application {
    public void onCreate() {
        super.onCreate();
        if (!j.a((Context) this)) {
            c.a((Context) this);
        } else {
            c.b((Context) this);
        }
    }
}

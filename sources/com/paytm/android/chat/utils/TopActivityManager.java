package com.paytm.android.chat.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TopActivityManager implements Application.ActivityLifecycleCallbacks {
    private List<Activity> activityList;
    private boolean background;
    private ActivityCallBacks backs;
    private WeakReference<Activity> mCurrentActivity;

    public interface ActivityCallBacks {
        void onPause();

        void onResume();
    }

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TopActivityManager f42365a = new TopActivityManager();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void setCallBacks(ActivityCallBacks activityCallBacks) {
        this.backs = activityCallBacks;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.activityList.add(activity);
    }

    public void onActivityResumed(Activity activity) {
        setCurrentActivity(activity);
        this.background = false;
        ActivityCallBacks activityCallBacks = this.backs;
        if (activityCallBacks != null) {
            activityCallBacks.onResume();
        }
    }

    public void onActivityPaused(Activity activity) {
        this.background = true;
        ActivityCallBacks activityCallBacks = this.backs;
        if (activityCallBacks != null) {
            activityCallBacks.onPause();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.activityList.remove(activity);
    }

    public static TopActivityManager getInstance() {
        return a.f42365a;
    }

    private TopActivityManager() {
        this.background = false;
        this.activityList = Collections.synchronizedList(new ArrayList());
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = new WeakReference<>(activity);
    }

    public boolean isBackground() {
        return this.background;
    }

    public void setBackground(boolean z) {
        this.background = z;
    }

    public List<Activity> getActivityList() {
        return this.activityList;
    }

    public void exit() {
        Iterator<Activity> it2 = this.activityList.iterator();
        while (it2.hasNext()) {
            it2.next().finish();
            it2.remove();
        }
        this.activityList.clear();
    }
}

package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class fr {

    /* renamed from: b  reason: collision with root package name */
    private static final Method f10661b = a();

    /* renamed from: c  reason: collision with root package name */
    private static final Method f10662c = b();

    /* renamed from: a  reason: collision with root package name */
    private final JobScheduler f10663a;

    private static Method a() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
        } catch (NoSuchMethodException unused) {
            Log.isLoggable("JobSchedulerCompat", 6);
            return null;
        }
    }

    private static Method b() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", (Class[]) null);
            } catch (NoSuchMethodException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return null;
    }

    private static int c() {
        Method method = f10662c;
        if (method != null) {
            try {
                return ((Integer) method.invoke((Object) null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                Log.isLoggable("JobSchedulerCompat", 6);
            }
        }
        return 0;
    }

    private fr(JobScheduler jobScheduler) {
        this.f10663a = jobScheduler;
    }

    private final int a(JobInfo jobInfo, String str, int i2, String str2) {
        Method method = f10661b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f10663a, new Object[]{jobInfo, str, Integer.valueOf(i2), str2})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return this.f10663a.schedule(jobInfo);
    }

    public static int a(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (f10661b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new fr(jobScheduler).a(jobInfo, str, c(), str2);
    }
}

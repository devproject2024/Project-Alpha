package com.google.android.datatransport.runtime.scheduling.jobscheduling;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final b f7901a = new b();

    private b() {
    }

    public static Runnable a() {
        return f7901a;
    }

    public final void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}

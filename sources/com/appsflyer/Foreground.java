package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Foreground {
    public static long CHECK_DELAY = 500;
    public static Listener listener;

    public interface Listener {
        void onBecameBackground(Context context);

        void onBecameForeground(Activity activity);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static void m112(Context context, final Listener listener2) {
        listener = listener2;
        AnonymousClass4 r0 = new Application.ActivityLifecycleCallbacks() {

            /* renamed from: ɩ  reason: contains not printable characters */
            boolean f134 = true;

            /* renamed from: Ι  reason: contains not printable characters */
            boolean f135;

            /* renamed from: ι  reason: contains not printable characters */
            private Executor f136 = Executors.newSingleThreadExecutor();

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }

            public final void onActivityResumed(final Activity activity) {
                this.f136.execute(new Runnable() {
                    public final void run() {
                        if (!AnonymousClass4.this.f135) {
                            try {
                                listener2.onBecameForeground(activity);
                            } catch (Exception e2) {
                                AFLogger.afErrorLog("Listener thrown an exception: ", e2);
                            }
                        }
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        r0.f134 = false;
                        r0.f135 = true;
                    }
                });
            }

            public final void onActivityPaused(final Activity activity) {
                this.f136.execute(new Runnable() {
                    public final void run() {
                        AnonymousClass4.this.f134 = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    if (AnonymousClass4.this.f135 && AnonymousClass4.this.f134) {
                                        AnonymousClass4.this.f135 = false;
                                        try {
                                            listener2.onBecameBackground(applicationContext);
                                        } catch (Exception e2) {
                                            AFLogger.afErrorLog("Listener threw exception! ", e2);
                                        }
                                    }
                                }
                            }, Foreground.CHECK_DELAY);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
                        }
                    }
                });
            }

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                this.f136.execute(new Runnable() {
                    public final void run() {
                        AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
                    }
                });
            }
        };
        if (context instanceof Activity) {
            r0.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r0);
    }
}

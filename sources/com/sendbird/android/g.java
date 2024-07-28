package com.sendbird.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.sendbird.android.Command;
import com.sendbird.android.SendBird;
import com.sendbird.android.log.Logger;
import com.sendbird.android.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.TimeUnit;

final class g implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final l f44710a = new l();

    /* renamed from: b  reason: collision with root package name */
    private boolean f44711b;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    g() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!SendBird.getAutoBackgroundDetection()) {
            Logger.d("getAutoBackgroundDetection() : " + SendBird.getAutoBackgroundDetection());
            return;
        }
        this.f44710a.a();
        if (a(false)) {
            SendBird.getInstance().mIsAppBackgroundAndDisconnected = false;
            if (SendBird.getConnectionState() == SendBird.ConnectionState.CLOSED && this.f44711b && SendBird.getCurrentUser() != null) {
                u.a().a(false);
            } else if (SendBird.getConnectionState() == SendBird.ConnectionState.OPEN && SendBird.getCurrentUser() != null) {
                Logger.d("Application goes foreground with connected status.");
                Logger.d("sendCommand(UNRD)");
                SendBird.getInstance().sendCommand(Command.e(), false, new Command.SendCommandHandler() {
                    public final void onResult(Command command, SendBirdException sendBirdException) {
                        StringBuilder sb = new StringBuilder("sendCommand(UNRD) => ");
                        sb.append(sendBirdException != null ? sendBirdException.getMessage() : Payload.RESPONSE_OK);
                        Logger.d(sb.toString());
                    }
                });
                u a2 = u.a();
                a2.a(u.a.START);
                try {
                    k.c();
                    a2.b(false);
                    a2.a(u.a.SUCCESS);
                } catch (Exception unused) {
                    a2.a(false, (SendBird.DisconnectHandler) null);
                    a2.a(u.a.FAIL);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean a(boolean z) {
        Logger.d("setIsAppBackground. current : " + SendBird.getInstance().mIsAppBackground + ", set : " + z);
        if (SendBird.getInstance().mIsAppBackground == z) {
            return false;
        }
        SendBird.getInstance().mIsAppBackground = z;
        if (z) {
            Logger.d("Application is on background.");
        } else {
            Logger.d("Application is on foreground.");
        }
        u.a().g();
        return true;
    }

    public final void onActivityResumed(Activity activity) {
        Logger.d("onActivityResumed: " + activity.getPackageName() + AppConstants.COLON + activity.getLocalClassName());
        this.f44710a.execute(new Runnable() {
            public final void run() {
                g.this.a();
            }
        });
    }

    public final void onActivityPaused(Activity activity) {
        Logger.d("onActivityPaused: " + activity.getPackageName() + AppConstants.COLON + activity.getLocalClassName());
        this.f44710a.execute(new Runnable() {
            public final void run() {
                g gVar = g.this;
                if (SendBird.getAutoBackgroundDetection()) {
                    gVar.f44710a.a();
                    n a2 = Connection.a();
                    Logger.d("++ bcDuration: " + a2.f44845h);
                    if (a2.f44845h > 500) {
                        gVar.f44710a.schedule((Runnable) new Runnable() {
                            public final void run() {
                                boolean unused = g.a(true);
                            }
                        }, 500, TimeUnit.MILLISECONDS);
                    }
                    if (a2.f44845h >= 0) {
                        gVar.f44710a.schedule((Runnable) new Runnable() {
                            public final void run() {
                                g.a(g.this);
                            }
                        }, a2.f44845h, TimeUnit.MILLISECONDS);
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(g gVar) {
        a(true);
        Logger.d("++ getConnectionState(): " + SendBird.getConnectionState());
        Logger.d("++ ConnectManager.getInstance().isReconnecting(): " + u.a().f45286c.get());
        if (SendBird.getConnectionState() != SendBird.ConnectionState.CLOSED || u.a().f45286c.get()) {
            u.a().a(false, (SendBird.DisconnectHandler) null);
            gVar.f44711b = true;
        } else {
            gVar.f44711b = false;
        }
        SendBird.getInstance().mIsAppBackgroundAndDisconnected = true;
    }
}

package com.paytm.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.callback.PushManagerReadyCallback;
import kotlin.g.b.k;

public final class ActionReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        String action;
        k.c(context, "context");
        if (intent != null && intent.getAction() != null && (action = intent.getAction()) != null) {
            int hashCode = action.hashCode();
            if (hashCode != -381691876) {
                if (hashCode == 731387914 && action.equals("com.paytm.notification.OPENED_INTERNAL")) {
                    try {
                        e.f43014a.a("Notification Opened", new Object[0]);
                        Bundle extras = intent.getExtras();
                        a(context, extras != null ? Integer.valueOf(extras.getInt("NOTIFICATION_ID")) : null);
                        new Thread(new a(intent)).start();
                        Intent intent2 = new Intent("com.paytm.notification.OPENED");
                        Bundle extras2 = intent.getExtras();
                        if (extras2 == null) {
                            k.a();
                        }
                        Intent putExtras = intent2.putExtras(extras2);
                        Context applicationContext = context.getApplicationContext();
                        k.a((Object) applicationContext, "context.applicationContext");
                        Intent addCategory = putExtras.addCategory(applicationContext.getPackageName());
                        Context applicationContext2 = context.getApplicationContext();
                        k.a((Object) applicationContext2, "context.applicationContext");
                        Intent intent3 = addCategory.setPackage(applicationContext2.getPackageName());
                        k.a((Object) intent3, "Intent(ACTION_NOTIFICATI…ationContext.packageName)");
                        context.sendOrderedBroadcast(intent3, (String) null);
                    } catch (Exception e2) {
                        e.f43014a.b(e2);
                    }
                }
            } else if (action.equals("com.paytm.notification.DISMISSED_INTERNAL")) {
                try {
                    e.f43014a.a("Notification Dismissed", new Object[0]);
                    Bundle extras3 = intent.getExtras();
                    a(context, extras3 != null ? Integer.valueOf(extras3.getInt("NOTIFICATION_ID")) : null);
                    new Thread(new b(intent)).start();
                    Intent intent4 = new Intent("com.paytm.notification.DISMISSED");
                    Bundle extras4 = intent.getExtras();
                    if (extras4 == null) {
                        k.a();
                    }
                    Intent putExtras2 = intent4.putExtras(extras4);
                    Context applicationContext3 = context.getApplicationContext();
                    k.a((Object) applicationContext3, "context.applicationContext");
                    Intent addCategory2 = putExtras2.addCategory(applicationContext3.getPackageName());
                    Context applicationContext4 = context.getApplicationContext();
                    k.a((Object) applicationContext4, "context.applicationContext");
                    Intent intent5 = addCategory2.setPackage(applicationContext4.getPackageName());
                    k.a((Object) intent5, "Intent(ACTION_NOTIFICATI…ationContext.packageName)");
                    context.sendOrderedBroadcast(intent5, (String) null);
                } catch (Exception e3) {
                    e.f43014a.b(e3);
                }
            }
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f42976a;

        a(Intent intent) {
            this.f42976a = intent;
        }

        public final void run() {
            g.c cVar = g.f43191a;
            g.c.a((PushManagerReadyCallback) new PushManagerReadyCallback(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f42977a;

                {
                    this.f42977a = r1;
                }

                public final void onCallbackReady(h hVar) {
                    k.c(hVar, "pushHandler");
                    Bundle extras = this.f42977a.f42976a.getExtras();
                    hVar.a(extras != null ? Integer.valueOf(extras.getInt("NOTIFICATION_ID")) : null);
                }
            });
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f42978a;

        b(Intent intent) {
            this.f42978a = intent;
        }

        public final void run() {
            g.c cVar = g.f43191a;
            g.c.a((PushManagerReadyCallback) new PushManagerReadyCallback(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f42979a;

                {
                    this.f42979a = r1;
                }

                public final void onCallbackReady(h hVar) {
                    k.c(hVar, "pushHandler");
                    Bundle extras = this.f42979a.f42978a.getExtras();
                    hVar.b(extras != null ? Integer.valueOf(extras.getInt("NOTIFICATION_ID")) : null);
                }
            });
        }
    }

    private static void a(Context context, Integer num) {
        if (num != null) {
            androidx.core.app.k.a(context).a(num.intValue());
        }
    }
}

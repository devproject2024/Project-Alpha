package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f38785a = g.b();

    static final /* synthetic */ void a(boolean z, BroadcastReceiver.PendingResult pendingResult, Task task) {
        if (z) {
            pendingResult.setResultCode(task.b() ? ((Integer) task.d()).intValue() : 500);
        }
        pendingResult.finish();
    }

    public final void onReceive(Context context, Intent intent) {
        a aVar;
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                intent = intent2;
            }
            intent.setComponent((ComponentName) null);
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT <= 18) {
                intent.removeCategory(context.getPackageName());
            }
            if ("google.com/iid".equals(intent.getStringExtra("from"))) {
                aVar = new u(this.f38785a);
            } else {
                aVar = new b(context, this.f38785a);
            }
            aVar.a(intent).a((Executor) this.f38785a, new p(isOrderedBroadcast(), goAsync()));
        }
    }
}

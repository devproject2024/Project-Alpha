package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.j;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.l;
import androidx.work.n;
import androidx.work.w;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5310a = l.a("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            l.a();
            try {
                j.b(context).a((w) (n) new n.a(DiagnosticsWorker.class).c());
            } catch (IllegalStateException e2) {
                l.a();
                new Throwable[1][0] = e2;
            }
        }
    }
}

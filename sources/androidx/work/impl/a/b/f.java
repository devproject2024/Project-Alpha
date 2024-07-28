package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.b.a;
import androidx.work.l;

public final class f extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5139d = l.a("StorageNotLowTracker");

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    public final IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public final void a(Intent intent) {
        if (intent.getAction() != null) {
            l.a();
            String.format("Received %s", new Object[]{intent.getAction()});
            String action = intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                c2 = 1;
            }
            if (c2 == 0) {
                a(Boolean.TRUE);
            } else if (c2 == 1) {
                a(Boolean.FALSE);
            }
        }
    }

    public final /* synthetic */ Object b() {
        Intent registerReceiver = this.f5127b.registerReceiver((BroadcastReceiver) null, a());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        char c2 = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c2 = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c2 = 1;
        }
        if (c2 == 0) {
            return Boolean.TRUE;
        }
        if (c2 != 1) {
            return null;
        }
        return Boolean.FALSE;
    }
}

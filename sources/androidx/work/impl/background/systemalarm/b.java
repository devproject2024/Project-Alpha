package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.l;
import java.util.HashMap;
import java.util.Map;

public final class b implements androidx.work.impl.b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5251d = l.a("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    final Context f5252a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, androidx.work.impl.b> f5253b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Object f5254c = new Object();

    static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    b(Context context) {
        this.f5252a = context;
    }

    public final void a(String str, boolean z) {
        synchronized (this.f5254c) {
            androidx.work.impl.b remove = this.f5253b.remove(str);
            if (remove != null) {
                remove.a(str, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        boolean z;
        synchronized (this.f5254c) {
            z = !this.f5253b.isEmpty();
        }
        return z;
    }

    static boolean a(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 <= 0; i2++) {
            if (bundle.get(strArr[0]) == null) {
                return false;
            }
        }
        return true;
    }
}

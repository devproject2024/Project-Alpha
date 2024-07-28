package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.p;
import androidx.work.impl.j;
import androidx.work.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements c, androidx.work.impl.b {

    /* renamed from: a  reason: collision with root package name */
    static final String f5328a = l.a("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    j f5329b = j.b(this.l);

    /* renamed from: c  reason: collision with root package name */
    final androidx.work.impl.utils.b.a f5330c = this.f5329b.f5362d;

    /* renamed from: d  reason: collision with root package name */
    final Object f5331d = new Object();

    /* renamed from: e  reason: collision with root package name */
    String f5332e = null;

    /* renamed from: f  reason: collision with root package name */
    h f5333f = null;

    /* renamed from: g  reason: collision with root package name */
    final Map<String, h> f5334g = new LinkedHashMap();

    /* renamed from: h  reason: collision with root package name */
    final Map<String, p> f5335h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    final Set<p> f5336i = new HashSet();
    final d j = new d(this.l, this.f5330c, this);
    a k;
    private Context l;

    interface a {
        void a();

        void a(int i2);

        void a(int i2, int i3, Notification notification);

        void a(int i2, Notification notification);
    }

    public final void a(List<String> list) {
    }

    b(Context context) {
        this.l = context;
        this.f5329b.f5364f.a((androidx.work.impl.b) this);
    }

    public final void a(String str, boolean z) {
        a aVar;
        Map.Entry entry;
        synchronized (this.f5331d) {
            p remove = this.f5335h.remove(str);
            if (remove != null ? this.f5336i.remove(remove) : false) {
                this.j.a((Iterable<p>) this.f5336i);
            }
        }
        this.f5333f = this.f5334g.remove(str);
        if (!str.equals(this.f5332e)) {
            h hVar = this.f5333f;
            if (hVar != null && (aVar = this.k) != null) {
                aVar.a(hVar.f5096a);
            }
        } else if (this.f5334g.size() > 0) {
            Iterator it2 = this.f5334g.entrySet().iterator();
            Object next = it2.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it2.hasNext()) {
                    break;
                }
                next = it2.next();
            }
            this.f5332e = (String) entry.getKey();
            if (this.k != null) {
                h hVar2 = (h) entry.getValue();
                this.k.a(hVar2.f5096a, hVar2.f5097b, hVar2.f5098c);
                this.k.a(hVar2.f5096a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        if (this.k != null) {
            l.a();
        } else {
            this.k = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.k = null;
        synchronized (this.f5331d) {
            this.j.a();
        }
        this.f5329b.f5364f.b((androidx.work.impl.b) this);
    }

    /* access modifiers changed from: package-private */
    public final void a(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        l.a();
        String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)});
        if (notification != null && this.k != null) {
            this.f5334g.put(stringExtra, new h(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f5332e)) {
                this.f5332e = stringExtra;
                this.k.a(intExtra, intExtra2, notification);
                return;
            }
            this.k.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, h> value : this.f5334g.entrySet()) {
                    i2 |= ((h) value.getValue()).f5097b;
                }
                h hVar = this.f5334g.get(this.f5332e);
                if (hVar != null) {
                    this.k.a(hVar.f5096a, i2, hVar.f5098c);
                }
            }
        }
    }

    public final void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                l.a();
                String.format("Constraints unmet for WorkSpec %s", new Object[]{next});
                j jVar = this.f5329b;
                jVar.f5362d.a(new androidx.work.impl.utils.j(jVar, next, true));
            }
        }
    }

    public static Intent a(Context context, String str, h hVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", hVar.f5096a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", hVar.f5097b);
        intent.putExtra("KEY_NOTIFICATION", hVar.f5098c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent b(Context context, String str, h hVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", hVar.f5096a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", hVar.f5097b);
        intent.putExtra("KEY_NOTIFICATION", hVar.f5098c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }
}

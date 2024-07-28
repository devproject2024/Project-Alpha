package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.g;
import androidx.work.impl.b.h;
import androidx.work.impl.b.k;
import androidx.work.impl.b.p;
import androidx.work.impl.b.q;
import androidx.work.impl.b.t;
import androidx.work.impl.j;
import androidx.work.l;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5502a = l.a("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.a doWork() {
        WorkDatabase workDatabase = j.b(getApplicationContext()).f5361c;
        q b2 = workDatabase.b();
        k f2 = workDatabase.f();
        t d2 = workDatabase.d();
        h e2 = workDatabase.e();
        List<p> a2 = b2.a(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<p> e3 = b2.e();
        List<p> c2 = b2.c();
        if (!a2.isEmpty()) {
            l.a();
            l.a();
            a(f2, d2, e2, a2);
        }
        if (!e3.isEmpty()) {
            l.a();
            l.a();
            a(f2, d2, e2, e3);
        }
        if (!c2.isEmpty()) {
            l.a();
            l.a();
            a(f2, d2, e2, c2);
        }
        return new ListenableWorker.a.c();
    }

    private static String a(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        for (p next : list) {
            Integer num = null;
            g a2 = hVar.a(next.f5180a);
            if (a2 != null) {
                num = Integer.valueOf(a2.f5160b);
            }
            sb.append(a(next, TextUtils.join(AppConstants.COMMA, kVar.a(next.f5180a)), num, TextUtils.join(AppConstants.COMMA, tVar.a(next.f5180a))));
        }
        return sb.toString();
    }

    private static String a(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{pVar.f5180a, pVar.f5182c, num, pVar.f5181b.name(), str, str2});
    }
}

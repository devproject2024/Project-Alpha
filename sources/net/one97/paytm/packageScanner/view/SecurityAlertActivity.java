package net.one97.paytm.packageScanner.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.packageScanner.PackageScanManager;
import net.one97.paytm.packageScanner.RemoteAppDataModel;
import net.one97.paytm.paytm_finance.R;

public final class SecurityAlertActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57040a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final g f57041b = h.a(new b(this));

    /* renamed from: c  reason: collision with root package name */
    private final g f57042c = h.a(new c(this));

    private final DangerousAppRemovedReceiver a() {
        return (DangerousAppRemovedReceiver) this.f57041b.getValue();
    }

    public final void onBackPressed() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b extends l implements kotlin.g.a.a<DangerousAppRemovedReceiver> {
        final /* synthetic */ SecurityAlertActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SecurityAlertActivity securityAlertActivity) {
            super(0);
            this.this$0 = securityAlertActivity;
        }

        public final DangerousAppRemovedReceiver invoke() {
            return new DangerousAppRemovedReceiver();
        }
    }

    static final class c extends l implements kotlin.g.a.a<PackageScanManager> {
        final /* synthetic */ SecurityAlertActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SecurityAlertActivity securityAlertActivity) {
            super(0);
            this.this$0 = securityAlertActivity;
        }

        public final PackageScanManager invoke() {
            return new PackageScanManager(this.this$0);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        setContentView((int) R.layout.layout_security_activity);
        androidx.localbroadcastmanager.a.a.a((Context) this).a(a(), new IntentFilter("NoDangerousAppFound"));
        b();
    }

    public final void onStart() {
        super.onStart();
        ((PackageScanManager) this.f57042c.getValue()).a(this, true);
    }

    private final void b() {
        c cVar = new c();
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        bundle.putAll(intent != null ? intent.getExtras() : null);
        cVar.setArguments(bundle);
        getSupportFragmentManager().a().a((int) R.id.container, (Fragment) cVar).a(c.class.getName()).c();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Fragment c2 = getSupportFragmentManager().c((int) R.id.container);
        if ((c2 instanceof c) && intent != null && intent.hasExtra("InstalledAppList")) {
            Bundle extras = intent.getExtras();
            Serializable serializable = extras != null ? extras.getSerializable("InstalledAppList") : null;
            if (serializable != null && (serializable instanceof ArrayList)) {
                ArrayList arrayList = (ArrayList) serializable;
                net.one97.paytm.packageScanner.a.a aVar = ((c) c2).f57050a;
                if (aVar != null && arrayList != null) {
                    ArrayList<RemoteAppDataModel> arrayList2 = aVar.f57032a;
                    if (arrayList2 != null) {
                        arrayList2.clear();
                    }
                    ArrayList<RemoteAppDataModel> arrayList3 = aVar.f57032a;
                    if (arrayList3 != null) {
                        arrayList3.addAll(arrayList);
                    }
                    aVar.notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
        getSupportFragmentManager().d();
        b();
    }

    public final class DangerousAppRemovedReceiver extends BroadcastReceiver {
        public DangerousAppRemovedReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            q.d("NoDangerousAppFound event received");
            SecurityAlertActivity.this.finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        androidx.localbroadcastmanager.a.a.a((Context) this).a((BroadcastReceiver) a());
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(e.a(context));
    }
}

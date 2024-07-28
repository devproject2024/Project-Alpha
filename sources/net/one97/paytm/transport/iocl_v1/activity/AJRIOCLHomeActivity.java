package net.one97.paytm.transport.iocl_v1.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.GAUtil;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.g;
import net.one97.paytm.transport.iocl_v1.a.b;
import net.one97.paytm.transport.iocl_v1.a.f;
import net.one97.paytm.transport.iocl_v1.data.c;
import net.one97.paytm.transport.iocl_v1.others.CJRSmsReceiver;
import net.one97.paytm.transport.iocl_v1.others.a;

public class AJRIOCLHomeActivity extends IOCLBaseActivity implements z<c>, a {

    /* renamed from: a  reason: collision with root package name */
    public CJRSmsReceiver f14392a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.transport.iocl_v1.c.c f14393b;

    /* renamed from: c  reason: collision with root package name */
    private g f14394c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f14395d;

    public void onPointerCaptureChanged(boolean z) {
    }

    public /* synthetic */ void onChanged(Object obj) {
        c cVar = (c) obj;
        if (cVar != null) {
            int i2 = AnonymousClass1.f14396a[cVar.ordinal()];
            if (i2 == 1) {
                Bundle bundle = new Bundle();
                if (b() instanceof net.one97.paytm.transport.iocl_v1.c.c) {
                    net.one97.paytm.transport.iocl_v1.c.c cVar2 = (net.one97.paytm.transport.iocl_v1.c.c) b();
                    long j = 0;
                    if (!(cVar2 == null || cVar2.c().get() == null)) {
                        j = cVar2.c().get().longValue();
                    }
                    bundle.putLong("reward_point", j);
                }
                super.a((Fragment) net.one97.paytm.transport.iocl_v1.a.g.a(bundle));
            } else if (i2 == 2) {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("IOCL_DATA", b().a());
                super.a((Fragment) b.a(bundle2));
            } else if (i2 == 3) {
                c();
            } else if (i2 != 4 && i2 == 5) {
                super.a((Fragment) f.a());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14394c = (g) androidx.databinding.f.a(LayoutInflater.from(this), R.layout.iocl_base_activity_v1, (ViewGroup) null, false);
        setContentView(this.f14394c.getRoot());
        this.f14395d = (ProgressBar) findViewById(R.id.load_more_history_progress);
        if (!com.paytm.utility.b.c((Context) this)) {
            com.paytm.utility.g.b(this, getString(R.string.iocl_no_connection), getString(R.string.iocl_no_internet), new g.c() {
                public final void onDialogDismissed() {
                    IOCLBaseActivity.this.finish();
                }
            });
        } else if (com.paytm.utility.b.r((Context) this)) {
            h();
        } else {
            Intent intent = new Intent(this, net.one97.paytm.transport.iocl.a.b().getAJRAuthActivity());
            intent.putExtra("authError", false);
            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
            startActivityForResult(intent, 4);
        }
    }

    private void g() {
        this.f14393b.f14440h.observe(this, this);
        this.f14393b.f14435c.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRIOCLHomeActivity.this.b((String) obj);
            }
        });
        this.f14393b.f14436d.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRIOCLHomeActivity.this.a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (str != null && str.equalsIgnoreCase("AUTH FAILED")) {
            e();
        } else if (str != null) {
            com.paytm.utility.b.a((Context) this, str, false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            f();
        }
    }

    private void h() {
        this.f14393b = new net.one97.paytm.transport.iocl_v1.c.c(getApplication());
        this.f14394c.a(this.f14393b);
        g();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 4 && i3 == -1) {
            h();
        }
    }

    public final void a() {
        try {
            if (this.f14392a != null) {
                unregisterReceiver(this.f14392a);
                this.f14392a.f14457a = null;
                this.f14392a = null;
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : unregister");
                com.paytm.utility.b.j();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2) {
        if (!isFinishing() && !TextUtils.isEmpty(com.paytm.utility.b.h(str, str2))) {
            a();
        }
    }

    /* renamed from: net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14396a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                net.one97.paytm.transport.iocl_v1.data.c[] r0 = net.one97.paytm.transport.iocl_v1.data.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14396a = r0
                int[] r0 = f14396a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.transport.iocl_v1.data.c r1 = net.one97.paytm.transport.iocl_v1.data.c.CONGRATULATIONS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f14396a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.transport.iocl_v1.data.c r1 = net.one97.paytm.transport.iocl_v1.data.c.DETAILS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f14396a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.transport.iocl_v1.data.c r1 = net.one97.paytm.transport.iocl_v1.data.c.USER_FORM     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f14396a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.transport.iocl_v1.data.c r1 = net.one97.paytm.transport.iocl_v1.data.c.VALIDATE_OTP     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f14396a     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.transport.iocl_v1.data.c r1 = net.one97.paytm.transport.iocl_v1.data.c.USER_REQUESTED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity.AnonymousClass1.<clinit>():void");
        }
    }

    public final void a(boolean z) {
        this.f14395d.setVisibility(z ? 0 : 8);
    }

    public final net.one97.paytm.transport.iocl_v1.c.b b() {
        return this.f14393b;
    }

    public /* synthetic */ Context getApplicationContext() {
        return getApplication();
    }
}

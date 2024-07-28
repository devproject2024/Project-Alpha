package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.redeemFd.e;
import net.one97.paytm.paymentsBank.utils.o;

public final class RedeemFdListActivity extends SlfdBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19291b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f19292c;

    public final View a(int i2) {
        if (this.f19292c == null) {
            this.f19292c = new HashMap();
        }
        View view = (View) this.f19292c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f19292c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int e() {
        return R.layout.slfd_activity_framelayout;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("slfd_amount");
        String stringExtra2 = getIntent().getStringExtra("account_num");
        if (getSupportFragmentManager().c("RedeemFdListFragment") == null) {
            e.a aVar = e.m;
            k.a((Object) stringExtra, "amount");
            k.a((Object) stringExtra2, "account");
            k.c(stringExtra, "amount");
            k.c(stringExtra2, "accountNum");
            e eVar = new e();
            Bundle bundle2 = new Bundle();
            bundle2.putString("slfd_amount", stringExtra);
            bundle2.putString("account_num", stringExtra2);
            eVar.setArguments(bundle2);
            Fragment fragment = eVar;
            int i2 = R.id.fragment_container;
            k.c(this, "receiver$0");
            k.c(fragment, "fragment");
            k.c("RedeemFdListFragment", "tag");
            getSupportFragmentManager().a().b(i2, fragment, "RedeemFdListFragment").b();
        }
    }
}

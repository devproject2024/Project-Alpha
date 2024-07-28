package net.one97.paytm.moneytransferv4.invite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferBaseActivity;
import net.one97.paytm.moneytransferv4.invite.b;

public final class InviteContactActivity extends MoneyTransferBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55648a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f55649b;

    public final View a(int i2) {
        if (this.f55649b == null) {
            this.f55649b = new HashMap();
        }
        View view = (View) this.f55649b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f55649b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invite_contact);
        m.a(b.c(this, R.color.white), (Activity) this);
        b.a aVar = b.f55654a;
        String stringExtra = getIntent().getStringExtra("number");
        k.a((Object) stringExtra, "intent.getStringExtra(NUMBER)");
        m.a(R.id.fragment_container, (Fragment) b.a.a(stringExtra, getIntent().getStringExtra("name")), "InviteContactFragment", getSupportFragmentManager());
    }

    public final void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public static final Intent a(Context context, String str, String str2) {
        k.c(context, "context");
        Intent intent = new Intent(context, InviteContactActivity.class);
        intent.putExtra("name", str);
        intent.putExtra("number", str2);
        return intent;
    }
}

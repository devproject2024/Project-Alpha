package net.one97.paytm.paymentsBank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;

public final class BlockedActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f17385a;

    private View a(int i2) {
        if (this.f17385a == null) {
            this.f17385a = new HashMap();
        }
        View view = (View) this.f17385a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17385a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        setContentView(R.layout.blocked_user_layout);
        ((RoboTextView) a(R.id.btn_got_it)).setOnClickListener(new a(this));
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra = intent.getStringExtra("message")) == null)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.textView4);
            k.a((Object) roboTextView, "textView4");
            roboTextView.setText(stringExtra);
        }
        a(R.id.block_help).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockedActivity f17386a;

        a(BlockedActivity blockedActivity) {
            this.f17386a = blockedActivity;
        }

        public final void onClick(View view) {
            this.f17386a.a();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockedActivity f17387a;

        b(BlockedActivity blockedActivity) {
            this.f17387a = blockedActivity;
        }

        public final void onClick(View view) {
            o.a().checkDeepLinking(this.f17387a, n.q());
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        a();
    }

    /* access modifiers changed from: private */
    public final void a() {
        o.a().openLandingActivity(this);
    }
}

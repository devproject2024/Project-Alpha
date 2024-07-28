package net.one97.paytm.paymentsBank.cifCreation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.cifCreation.view.a.c;
import net.one97.paytm.paymentsBank.utils.o;

public final class FdCalculaterActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f18048a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fd_calculater);
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.fragment_container;
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        a2.a(i2, c.a(intent.getExtras()), c.class.getName()).c();
        int i3 = R.id.iv_back_arrow;
        if (this.f18048a == null) {
            this.f18048a = new HashMap();
        }
        View view = (View) this.f18048a.get(Integer.valueOf(i3));
        if (view == null) {
            view = findViewById(i3);
            this.f18048a.put(Integer.valueOf(i3), view);
        }
        ImageView imageView = (ImageView) view;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 1);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FdCalculaterActivity f18049a;

        a(FdCalculaterActivity fdCalculaterActivity) {
            this.f18049a = fdCalculaterActivity;
        }

        public final void onClick(View view) {
            this.f18049a.onBackPressed();
        }
    }

    public final void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}

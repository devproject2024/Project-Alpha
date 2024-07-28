package net.one97.paytm.feed.ui.base;

import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.feed.events.f;

public class FeedNoBindingBaseActivity extends PaytmActivity {
    public void onResume() {
        f fVar = f.f34346d;
        Context context = this;
        f.a(context);
        f fVar2 = f.f34346d;
        f.h();
        super.onResume();
        a.a(context);
        a.b(context);
    }

    public void onPause() {
        f fVar = f.f34346d;
        f.g();
        f fVar2 = f.f34346d;
        f.i();
        super.onPause();
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        a.a(context2);
        a.b(context2);
    }
}

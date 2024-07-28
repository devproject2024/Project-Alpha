package net.one97.paytm.feed.ui.feed.sheroes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.ui.base.FeedNoBindingBaseActivity;

public final class SheroesActivity extends FeedNoBindingBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35174a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Toolbar f35175b;

    public interface c {
        void getSheroesFragment(Fragment fragment);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.feed_sheroes_activity);
        this.f35175b = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar = this.f35175b;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setContentInsetStartWithNavigation(0);
            toolbar.setNavigationOnClickListener(new d(this));
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.a(true);
            supportActionBar.c(false);
        }
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a((Context) this, (c) new b(this));
    }

    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SheroesActivity f35176a;

        b(SheroesActivity sheroesActivity) {
            this.f35176a = sheroesActivity;
        }

        public final void getSheroesFragment(Fragment fragment) {
            if (fragment != null) {
                try {
                    j supportFragmentManager = this.f35176a.getSupportFragmentManager();
                    q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
                    k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
                    if (a2 != null) {
                        a2.a(R.id.fragment_container, fragment, "sheroes");
                    }
                    if (a2 != null) {
                        a2.c();
                    }
                } catch (Exception unused) {
                }
            } else {
                this.f35176a.finish();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SheroesActivity f35177a;

        d(SheroesActivity sheroesActivity) {
            this.f35177a = sheroesActivity;
        }

        public final void onClick(View view) {
            this.f35177a.onBackPressed();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context) {
            k.c(context, "context");
            context.startActivity(new Intent(context, SheroesActivity.class));
        }
    }
}

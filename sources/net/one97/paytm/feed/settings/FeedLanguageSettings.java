package net.one97.paytm.feed.settings;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.ui.base.FeedNoBindingBaseActivity;

public final class FeedLanguageSettings extends FeedNoBindingBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34806a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.feed.ui.a.b f34807b;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f34808c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.feed_language_settings);
        this.f34808c = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar = this.f34808c;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setContentInsetStartWithNavigation(0);
            toolbar.setNavigationOnClickListener(new b(this));
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
            supportActionBar.a(true);
        }
        this.f34807b = new net.one97.paytm.feed.ui.a.b();
        j supportFragmentManager = getSupportFragmentManager();
        q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
        k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
        if (a2 != null) {
            int i2 = R.id.container;
            net.one97.paytm.feed.ui.a.b bVar = this.f34807b;
            if (bVar == null) {
                k.a();
            }
            a2.a(i2, bVar, "settings");
        }
        if (a2 != null) {
            a2.c();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedLanguageSettings f34809a;

        b(FeedLanguageSettings feedLanguageSettings) {
            this.f34809a = feedLanguageSettings;
        }

        public final void onClick(View view) {
            this.f34809a.onBackPressed();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

package net.one97.paytm.dynamic.module.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.q;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.i.a;
import java.util.concurrent.Callable;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.dynamic.module.movie.deeplink.MoviesDeeplinkConfig;
import net.one97.paytm.paytm_finance.R;

public class MovieInitActivity extends AppCompatActivity {
    private c deeplinkHandlerDisposable;
    private LottieAnimationView loader;

    public void onCreate(Bundle bundle) {
        DeepLinkData deepLinkData;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_movie_init);
        this.loader = (LottieAnimationView) findViewById(R.id.loader_movie_init);
        startLoader();
        initialize();
        try {
            deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        } catch (Exception e2) {
            q.b(e2.getMessage());
            deepLinkData = null;
        }
        if (deepLinkData != null) {
            handleDeeplink(deepLinkData);
        } else if (getIntent() != null) {
            launchUsingIntent(getIntent());
            finishActivity();
        }
    }

    public void initialize() {
        MovieHelper.initMoviesLib(getApplication());
    }

    private void handleDeeplink(DeepLinkData deepLinkData) {
        c cVar = this.deeplinkHandlerDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.deeplinkHandlerDisposable = null;
        }
        MoviesDeeplinkConfig moviesDeeplinkConfig = new MoviesDeeplinkConfig(this);
        this.deeplinkHandlerDisposable = y.a(new Callable(deepLinkData) {
            private final /* synthetic */ DeepLinkData f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return MoviesDeeplinkConfig.this.resolveDeeplink(this.f$1);
            }
        }).b(a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
            public final void accept(Object obj) {
                MovieInitActivity.this.lambda$handleDeeplink$1$MovieInitActivity((Intent) obj);
            }
        }, (g<? super Throwable>) new g(moviesDeeplinkConfig) {
            private final /* synthetic */ MoviesDeeplinkConfig f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                MovieInitActivity.this.lambda$handleDeeplink$2$MovieInitActivity(this.f$1, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$handleDeeplink$1$MovieInitActivity(Intent intent) throws Throwable {
        startActivity(intent);
        finishActivity();
    }

    public /* synthetic */ void lambda$handleDeeplink$2$MovieInitActivity(MoviesDeeplinkConfig moviesDeeplinkConfig, Throwable th) throws Throwable {
        startActivity(moviesDeeplinkConfig.getDeeplinkIntent());
        finishActivity();
    }

    private void launchUsingIntent(Intent intent) {
        if (intent.hasExtra("RESULTANT_ACTIVITY_NAME")) {
            intent.setClassName(this, intent.getStringExtra("RESULTANT_ACTIVITY_NAME"));
            startActivity(intent);
        }
    }

    private void startLoader() {
        try {
            net.one97.paytm.common.widgets.a.a(this.loader);
        } catch (Exception unused) {
        }
    }

    private void finishActivity() {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.deeplinkHandlerDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.deeplinkHandlerDisposable = null;
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }
}

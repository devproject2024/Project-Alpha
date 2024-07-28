package com.google.androidbrowserhelper.trusted;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.browser.customtabs.f;
import androidx.browser.trusted.g;
import androidx.browser.trusted.h;
import com.google.androidbrowserhelper.trusted.a.c;
import com.google.androidbrowserhelper.trusted.d;
import com.google.androidbrowserhelper.trusted.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f37662a = $$Lambda$d$K9s4bxrKhw5H7CQl6rPLhHCnL0.INSTANCE;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f37663b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final String f37664c;

    /* renamed from: d  reason: collision with root package name */
    b f37665d;

    /* renamed from: e  reason: collision with root package name */
    boolean f37666e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37667f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f37668g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public f f37669h;

    /* renamed from: i  reason: collision with root package name */
    private c f37670i;

    public interface a {
        void launch(Context context, h hVar, String str, Runnable runnable);
    }

    public d(Context context) {
        this(context, (String) null);
    }

    public d(Context context, String str) {
        this(context, str, new c(context));
    }

    private d(Context context, String str, c cVar) {
        this.f37663b = context;
        this.f37668g = 96375;
        this.f37670i = cVar;
        if (str == null) {
            e.a a2 = e.a(context.getPackageManager());
            this.f37664c = a2.f37676b;
            this.f37667f = a2.f37675a;
            return;
        }
        this.f37664c = str;
        this.f37667f = 0;
    }

    public final void a(Uri uri) {
        a(new h(uri), (c) null, (Runnable) null, f37662a);
    }

    public final void a(h hVar, c cVar, Runnable runnable, a aVar) {
        if (this.f37666e) {
            throw new IllegalStateException("TwaLauncher already destroyed");
        } else if (this.f37667f == 0) {
            b(hVar, cVar, runnable, aVar);
        } else {
            aVar.launch(this.f37663b, hVar, this.f37664c, runnable);
        }
    }

    private void b(h hVar, c cVar, Runnable runnable, a aVar) {
        if (cVar != null) {
            cVar.a(this.f37664c, hVar);
        }
        $$Lambda$d$ybUiN53ihnWNqf_wPapuBwa_tk r0 = new Runnable(hVar, cVar, runnable) {
            private final /* synthetic */ h f$1;
            private final /* synthetic */ c f$2;
            private final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                d.this.a(this.f$1, this.f$2, this.f$3);
            }
        };
        if (this.f37669h != null) {
            r0.run();
            return;
        }
        $$Lambda$d$lhn5XRpe_VfnJYop9eKQbCWd2g0 r3 = new Runnable(aVar, hVar, runnable) {
            private final /* synthetic */ d.a f$1;
            private final /* synthetic */ h f$2;
            private final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                d.this.a(this.f$1, this.f$2, this.f$3);
            }
        };
        if (this.f37665d == null) {
            this.f37665d = new b(this, (byte) 0);
        }
        b.a(this.f37665d, r0, r3);
        androidx.browser.customtabs.c.a(this.f37663b, this.f37664c, this.f37665d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, h hVar, Runnable runnable) {
        aVar.launch(this.f37663b, hVar, this.f37664c, runnable);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void b(h hVar, Runnable runnable) {
        if (!this.f37666e) {
            f fVar = this.f37669h;
            if (fVar != null) {
                hVar.f1944b.a(fVar);
                Intent intent = hVar.f1944b.c().f1901a;
                intent.setData(hVar.f1943a);
                intent.putExtra("android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY", true);
                if (hVar.f1945c != null) {
                    intent.putExtra("android.support.customtabs.extra.ADDITIONAL_TRUSTED_ORIGINS", new ArrayList(hVar.f1945c));
                }
                if (hVar.f1946d != null) {
                    intent.putExtra("androidx.browser.trusted.EXTRA_SPLASH_SCREEN_PARAMS", hVar.f1946d);
                }
                List<Uri> emptyList = Collections.emptyList();
                if (!(hVar.f1948f == null || hVar.f1947e == null)) {
                    androidx.browser.trusted.a.b bVar = hVar.f1948f;
                    Bundle bundle = new Bundle();
                    bundle.putString("androidx.browser.trusted.sharing.KEY_ACTION", bVar.f1928a);
                    bundle.putString("androidx.browser.trusted.sharing.KEY_METHOD", bVar.f1929b);
                    bundle.putString("androidx.browser.trusted.sharing.KEY_ENCTYPE", bVar.f1930c);
                    bundle.putBundle("androidx.browser.trusted.sharing.KEY_PARAMS", bVar.f1931d.a());
                    intent.putExtra("androidx.browser.trusted.extra.SHARE_TARGET", bundle);
                    androidx.browser.trusted.a.a aVar = hVar.f1947e;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("androidx.browser.trusted.sharing.KEY_TITLE", aVar.f1925a);
                    bundle2.putString("androidx.browser.trusted.sharing.KEY_TEXT", aVar.f1926b);
                    if (aVar.f1927c != null) {
                        bundle2.putParcelableArrayList("androidx.browser.trusted.sharing.KEY_URIS", new ArrayList(aVar.f1927c));
                    }
                    intent.putExtra("androidx.browser.trusted.extra.SHARE_DATA", bundle2);
                    if (hVar.f1947e.f1927c != null) {
                        emptyList = hVar.f1947e.f1927c;
                    }
                }
                intent.putExtra("androidx.browser.trusted.extra.DISPLAY_MODE", hVar.f1949g.a());
                Intent intent2 = new g(intent, emptyList).f1941a;
                FocusActivity.a(intent2, this.f37663b);
                androidx.core.content.b.a(this.f37663b, intent2, (Bundle) null);
                c cVar = this.f37670i;
                androidx.browser.trusted.c a2 = androidx.browser.trusted.c.a(this.f37664c, this.f37663b.getPackageManager());
                SharedPreferences sharedPreferences = cVar.f37661a.getSharedPreferences("com.google.androidbrowserhelper", 0);
                if (a2 == null) {
                    sharedPreferences.edit().remove("SharedPreferencesTokenStore.TOKEN").apply();
                } else {
                    androidx.browser.trusted.d dVar = a2.f1937a;
                    sharedPreferences.edit().putString("SharedPreferencesTokenStore.TOKEN", Base64.encodeToString(Arrays.copyOf(dVar.f1938a, dVar.f1938a.length), 3)).apply();
                }
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            throw new NullPointerException("CustomTabsSession is required for launching a TWA");
        }
    }

    class b extends androidx.browser.customtabs.e {

        /* renamed from: c  reason: collision with root package name */
        private Runnable f37672c;

        /* renamed from: d  reason: collision with root package name */
        private Runnable f37673d;

        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final void a(ComponentName componentName, androidx.browser.customtabs.c cVar) {
            Runnable runnable;
            Runnable runnable2;
            if (!a.c(d.this.f37663b.getPackageManager(), d.this.f37664c)) {
                cVar.a();
            }
            d dVar = d.this;
            f unused = dVar.f37669h = cVar.a((androidx.browser.customtabs.b) null, PendingIntent.getActivity(cVar.f1879a, dVar.f37668g, new Intent(), 0));
            if (d.this.f37669h != null && (runnable2 = this.f37672c) != null) {
                runnable2.run();
            } else if (d.this.f37669h == null && (runnable = this.f37673d) != null) {
                runnable.run();
            }
            this.f37672c = null;
            this.f37673d = null;
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            f unused = d.this.f37669h = null;
        }

        static /* synthetic */ void a(b bVar, Runnable runnable, Runnable runnable2) {
            bVar.f37672c = runnable;
            bVar.f37673d = runnable2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, c cVar, Runnable runnable) {
        f fVar = this.f37669h;
        if (fVar == null) {
            throw new IllegalStateException("mSession is null in launchWhenSessionEstablished");
        } else if (cVar != null) {
            cVar.a(hVar, fVar, new Runnable(hVar, runnable) {
                private final /* synthetic */ h f$1;
                private final /* synthetic */ Runnable f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    d.this.b(this.f$1, this.f$2);
                }
            });
        } else {
            b(hVar, runnable);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, h hVar, String str, Runnable runnable) {
        androidx.browser.customtabs.d c2 = hVar.f1944b.c();
        if (str != null) {
            c2.f1901a.setPackage(str);
        }
        c2.a(context, hVar.f1943a);
        if (runnable != null) {
            runnable.run();
        }
    }
}

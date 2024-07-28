package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.app.l;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.ai;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.q;
import androidx.core.content.b.f;
import androidx.core.h.ab;
import androidx.core.h.q;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;
import androidx.lifecycle.k;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDelegateImpl extends e implements LayoutInflater.Factory2, g.a {
    private static final int[] A = {16842836};
    private static final boolean B = (!"robolectric".equals(Build.FINGERPRINT));
    private static final boolean C;
    private static boolean D = true;
    private static final androidx.a.g<String, Integer> y = new androidx.a.g<>();
    private static final boolean z = (Build.VERSION.SDK_INT < 21);
    private d E;
    private CharSequence F;
    private n G;
    private b H;
    private i I;
    private boolean J;
    private TextView K;
    private View L;
    private boolean M;
    private boolean N;
    private boolean O;
    private PanelFeatureState[] P;
    private PanelFeatureState Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private int W;
    private boolean X;
    private boolean Y;
    private f Z;
    private f aa;
    private final Runnable ab;
    private boolean ac;
    private Rect ad;
    private Rect ae;
    private h af;

    /* renamed from: d  reason: collision with root package name */
    final Object f1038d;

    /* renamed from: e  reason: collision with root package name */
    final Context f1039e;

    /* renamed from: f  reason: collision with root package name */
    Window f1040f;

    /* renamed from: g  reason: collision with root package name */
    final d f1041g;

    /* renamed from: h  reason: collision with root package name */
    ActionBar f1042h;

    /* renamed from: i  reason: collision with root package name */
    MenuInflater f1043i;
    androidx.appcompat.view.b j;
    ActionBarContextView k;
    PopupWindow l;
    Runnable m;
    x n;
    boolean o;
    ViewGroup p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    int x;

    private static int i(int i2) {
        if (i2 == 8) {
            return 108;
        }
        if (i2 == 9) {
            return 109;
        }
        return i2;
    }

    static {
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 17) {
            z2 = true;
        }
        C = z2;
        if (z && !D) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public final void uncaughtException(Thread thread, Throwable th) {
                    String message;
                    boolean z = false;
                    if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                        z = true;
                    }
                    if (z) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    AppCompatDelegateImpl(Activity activity, d dVar) {
        this(activity, (Window) null, dVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, d dVar, Object obj) {
        Integer num;
        AppCompatActivity appCompatActivity = null;
        this.n = null;
        this.o = true;
        this.V = -100;
        this.ab = new Runnable() {
            public final void run() {
                if ((AppCompatDelegateImpl.this.x & 1) != 0) {
                    AppCompatDelegateImpl.this.g(0);
                }
                if ((AppCompatDelegateImpl.this.x & 4096) != 0) {
                    AppCompatDelegateImpl.this.g(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.w = false;
                appCompatDelegateImpl.x = 0;
            }
        };
        this.f1039e = context;
        this.f1041g = dVar;
        this.f1038d = obj;
        if (this.V == -100 && (this.f1038d instanceof Dialog)) {
            Context context2 = this.f1039e;
            while (true) {
                if (context2 != null) {
                    if (!(context2 instanceof AppCompatActivity)) {
                        if (!(context2 instanceof ContextWrapper)) {
                            break;
                        }
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context2;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.V = appCompatActivity.getDelegate().l();
            }
        }
        if (this.V == -100 && (num = y.get(this.f1038d.getClass().getName())) != null) {
            this.V = num.intValue();
            y.remove(this.f1038d.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        androidx.appcompat.widget.f.a();
    }

    public final Context a(Context context) {
        this.S = true;
        int a2 = a(context, z());
        Configuration configuration = null;
        if (C && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!B) {
            return super.a(context);
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (!(configuration3 == null || configuration2.diff(configuration3) == 0)) {
                    if (configuration2.fontScale != configuration3.fontScale) {
                        configuration.fontScale = configuration3.fontScale;
                    }
                    if (configuration2.mcc != configuration3.mcc) {
                        configuration.mcc = configuration3.mcc;
                    }
                    if (configuration2.mnc != configuration3.mnc) {
                        configuration.mnc = configuration3.mnc;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        LocaleList locales = configuration2.getLocales();
                        LocaleList locales2 = configuration3.getLocales();
                        if (!locales.equals(locales2)) {
                            configuration.setLocales(locales2);
                            configuration.locale = configuration3.locale;
                        }
                    } else if (!androidx.core.g.c.a(configuration2.locale, configuration3.locale)) {
                        configuration.locale = configuration3.locale;
                    }
                    if (configuration2.touchscreen != configuration3.touchscreen) {
                        configuration.touchscreen = configuration3.touchscreen;
                    }
                    if (configuration2.keyboard != configuration3.keyboard) {
                        configuration.keyboard = configuration3.keyboard;
                    }
                    if (configuration2.keyboardHidden != configuration3.keyboardHidden) {
                        configuration.keyboardHidden = configuration3.keyboardHidden;
                    }
                    if (configuration2.navigation != configuration3.navigation) {
                        configuration.navigation = configuration3.navigation;
                    }
                    if (configuration2.navigationHidden != configuration3.navigationHidden) {
                        configuration.navigationHidden = configuration3.navigationHidden;
                    }
                    if (configuration2.orientation != configuration3.orientation) {
                        configuration.orientation = configuration3.orientation;
                    }
                    if ((configuration2.screenLayout & 15) != (configuration3.screenLayout & 15)) {
                        configuration.screenLayout |= configuration3.screenLayout & 15;
                    }
                    if ((configuration2.screenLayout & 192) != (configuration3.screenLayout & 192)) {
                        configuration.screenLayout |= configuration3.screenLayout & 192;
                    }
                    if ((configuration2.screenLayout & 48) != (configuration3.screenLayout & 48)) {
                        configuration.screenLayout |= configuration3.screenLayout & 48;
                    }
                    if ((configuration2.screenLayout & 768) != (configuration3.screenLayout & 768)) {
                        configuration.screenLayout |= configuration3.screenLayout & 768;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        if ((configuration2.colorMode & 3) != (configuration3.colorMode & 3)) {
                            configuration.colorMode |= configuration3.colorMode & 3;
                        }
                        if ((configuration2.colorMode & 12) != (configuration3.colorMode & 12)) {
                            configuration.colorMode |= configuration3.colorMode & 12;
                        }
                    }
                    if ((configuration2.uiMode & 15) != (configuration3.uiMode & 15)) {
                        configuration.uiMode |= configuration3.uiMode & 15;
                    }
                    if ((configuration2.uiMode & 48) != (configuration3.uiMode & 48)) {
                        configuration.uiMode |= configuration3.uiMode & 48;
                    }
                    if (configuration2.screenWidthDp != configuration3.screenWidthDp) {
                        configuration.screenWidthDp = configuration3.screenWidthDp;
                    }
                    if (configuration2.screenHeightDp != configuration3.screenHeightDp) {
                        configuration.screenHeightDp = configuration3.screenHeightDp;
                    }
                    if (configuration2.smallestScreenWidthDp != configuration3.smallestScreenWidthDp) {
                        configuration.smallestScreenWidthDp = configuration3.smallestScreenWidthDp;
                    }
                    if (Build.VERSION.SDK_INT >= 17 && configuration2.densityDpi != configuration3.densityDpi) {
                        configuration.densityDpi = configuration3.densityDpi;
                    }
                }
            }
            Configuration a3 = a(context, a2, configuration);
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R.style.Theme_AppCompat_Empty);
            dVar.a(a3);
            boolean z2 = false;
            try {
                if (context.getTheme() != null) {
                    z2 = true;
                }
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                Resources.Theme theme = dVar.getTheme();
                if (Build.VERSION.SDK_INT >= 29) {
                    theme.rebase();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    f.b.a.a(theme);
                }
            }
            return super.a((Context) dVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    public final void c() {
        this.S = true;
        a(false);
        t();
        Object obj = this.f1038d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.f1042h;
                if (actionBar == null) {
                    this.ac = true;
                } else {
                    actionBar.d(true);
                }
            }
            synchronized (e.f1099c) {
                e.a((e) this);
                e.f1098b.add(new WeakReference(this));
            }
        }
        this.T = true;
    }

    public final void d() {
        u();
    }

    public final ActionBar a() {
        s();
        return this.f1042h;
    }

    private void s() {
        u();
        if (this.q && this.f1042h == null) {
            Object obj = this.f1038d;
            if (obj instanceof Activity) {
                this.f1042h = new m((Activity) obj, this.r);
            } else if (obj instanceof Dialog) {
                this.f1042h = new m((Dialog) obj);
            }
            ActionBar actionBar = this.f1042h;
            if (actionBar != null) {
                actionBar.d(this.ac);
            }
        }
    }

    public final void a(Toolbar toolbar) {
        if (this.f1038d instanceof Activity) {
            ActionBar a2 = a();
            if (!(a2 instanceof m)) {
                this.f1043i = null;
                if (a2 != null) {
                    a2.m();
                }
                if (toolbar != null) {
                    j jVar = new j(toolbar, x(), this.E);
                    this.f1042h = jVar;
                    this.f1040f.setCallback(jVar.f1120c);
                } else {
                    this.f1042h = null;
                    this.f1040f.setCallback(this.E);
                }
                h();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        ActionBar a2 = a();
        Context g2 = a2 != null ? a2.g() : null;
        return g2 == null ? this.f1039e : g2;
    }

    public final MenuInflater b() {
        if (this.f1043i == null) {
            s();
            ActionBar actionBar = this.f1042h;
            this.f1043i = new androidx.appcompat.view.g(actionBar != null ? actionBar.g() : this.f1039e);
        }
        return this.f1043i;
    }

    public final <T extends View> T b(int i2) {
        u();
        return this.f1040f.findViewById(i2);
    }

    public final void a(Configuration configuration) {
        ActionBar a2;
        if (this.q && this.J && (a2 = a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.f.b().a(this.f1039e);
        a(false);
    }

    public final void e() {
        this.U = true;
        a(true);
    }

    public final void f() {
        this.U = false;
        ActionBar a2 = a();
        if (a2 != null) {
            a2.e(false);
        }
    }

    public final void g() {
        ActionBar a2 = a();
        if (a2 != null) {
            a2.e(true);
        }
    }

    public final void a(View view) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.p.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.E.f1257b.onContentChanged();
    }

    public final void c(int i2) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.p.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1039e).inflate(i2, viewGroup);
        this.E.f1257b.onContentChanged();
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.p.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.E.f1257b.onContentChanged();
    }

    public final void b(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        ((ViewGroup) this.p.findViewById(16908290)).addView(view, layoutParams);
        this.E.f1257b.onContentChanged();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1038d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = androidx.appcompat.app.e.f1099c
            monitor-enter(r0)
            androidx.appcompat.app.e.a((androidx.appcompat.app.e) r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            goto L_0x0011
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        L_0x0011:
            boolean r0 = r3.w
            if (r0 == 0) goto L_0x0020
            android.view.Window r0 = r3.f1040f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.ab
            r0.removeCallbacks(r1)
        L_0x0020:
            r0 = 0
            r3.U = r0
            r0 = 1
            r3.v = r0
            int r0 = r3.V
            r1 = -100
            if (r0 == r1) goto L_0x0050
            java.lang.Object r0 = r3.f1038d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0050
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0050
            androidx.a.g<java.lang.String, java.lang.Integer> r0 = y
            java.lang.Object r1 = r3.f1038d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.V
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x005f
        L_0x0050:
            androidx.a.g<java.lang.String, java.lang.Integer> r0 = y
            java.lang.Object r1 = r3.f1038d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x005f:
            androidx.appcompat.app.ActionBar r0 = r3.f1042h
            if (r0 == 0) goto L_0x0066
            r0.m()
        L_0x0066:
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = r3.Z
            if (r0 == 0) goto L_0x006d
            r0.e()
        L_0x006d:
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = r3.aa
            if (r0 == 0) goto L_0x0074
            r0.e()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i():void");
    }

    public final void a(int i2) {
        this.W = i2;
    }

    private void t() {
        if (this.f1040f == null) {
            Object obj = this.f1038d;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f1040f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.f1040f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof d)) {
                this.E = new d(callback);
                window.setCallback(this.E);
                ac a2 = ac.a(this.f1039e, (AttributeSet) null, A);
                Drawable b2 = a2.b(0);
                if (b2 != null) {
                    window.setBackgroundDrawable(b2);
                }
                a2.f1669a.recycle();
                this.f1040f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void u() {
        if (!this.J) {
            this.p = v();
            CharSequence x2 = x();
            if (!TextUtils.isEmpty(x2)) {
                n nVar = this.G;
                if (nVar != null) {
                    nVar.setWindowTitle(x2);
                } else {
                    ActionBar actionBar = this.f1042h;
                    if (actionBar != null) {
                        actionBar.b(x2);
                    } else {
                        TextView textView = this.K;
                        if (textView != null) {
                            textView.setText(x2);
                        }
                    }
                }
            }
            w();
            this.J = true;
            PanelFeatureState f2 = f(0);
            if (this.v) {
                return;
            }
            if (f2 == null || f2.j == null) {
                h(108);
            }
        }
    }

    private ViewGroup v() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f1039e.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                d(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                d(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                d(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                d(10);
            }
            this.t = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            t();
            this.f1040f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f1039e);
            if (this.u) {
                viewGroup = this.s ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.t) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.r = false;
                this.q = false;
            } else if (this.q) {
                TypedValue typedValue = new TypedValue();
                this.f1039e.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.f1039e, typedValue.resourceId);
                } else {
                    context = this.f1039e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.G = (n) viewGroup.findViewById(R.id.decor_content_parent);
                this.G.setWindowCallback(this.f1040f.getCallback());
                if (this.r) {
                    this.G.a(109);
                }
                if (this.M) {
                    this.G.a(2);
                }
                if (this.N) {
                    this.G.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    u.a((View) viewGroup, (q) new q() {
                        public final ab a(View view, ab abVar) {
                            int i2 = abVar.f3061b.g().f2974c;
                            int a2 = AppCompatDelegateImpl.this.a(abVar, (Rect) null);
                            if (i2 != a2) {
                                abVar = abVar.a(abVar.f3061b.g().f2973b, a2, abVar.f3061b.g().f2975d, abVar.f3061b.g().f2976e);
                            }
                            return u.a(view, abVar);
                        }
                    });
                } else if (viewGroup instanceof androidx.appcompat.widget.q) {
                    ((androidx.appcompat.widget.q) viewGroup).setOnFitSystemWindowsListener(new q.a() {
                        public final void a(Rect rect) {
                            rect.top = AppCompatDelegateImpl.this.a((ab) null, rect);
                        }
                    });
                }
                if (this.G == null) {
                    this.K = (TextView) viewGroup.findViewById(R.id.title);
                }
                ai.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f1040f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f1040f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
                    public final void a() {
                        AppCompatDelegateImpl.this.r();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.q + ", windowActionBarOverlay: " + this.r + ", android:windowIsFloating: " + this.t + ", windowActionModeOverlay: " + this.s + ", windowNoTitle: " + this.u + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.p.findViewById(16908290);
        View decorView = this.f1040f.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1039e.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean d(int i2) {
        int i3 = i(i2);
        if (this.u && i3 == 108) {
            return false;
        }
        if (this.q && i3 == 1) {
            this.q = false;
        }
        if (i3 == 1) {
            y();
            this.u = true;
            return true;
        } else if (i3 == 2) {
            y();
            this.M = true;
            return true;
        } else if (i3 == 5) {
            y();
            this.N = true;
            return true;
        } else if (i3 == 10) {
            y();
            this.s = true;
            return true;
        } else if (i3 == 108) {
            y();
            this.q = true;
            return true;
        } else if (i3 != 109) {
            return this.f1040f.requestFeature(i3);
        } else {
            y();
            this.r = true;
            return true;
        }
    }

    public final void a(CharSequence charSequence) {
        this.F = charSequence;
        n nVar = this.G;
        if (nVar != null) {
            nVar.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.f1042h;
        if (actionBar != null) {
            actionBar.b(charSequence);
            return;
        }
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private CharSequence x() {
        Object obj = this.f1038d;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.F;
    }

    /* access modifiers changed from: package-private */
    public final void e(int i2) {
        if (i2 == 108) {
            ActionBar a2 = a();
            if (a2 != null) {
                a2.f(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState f2 = f(i2);
            if (f2.o) {
                a(f2, false);
            }
        }
    }

    public final androidx.appcompat.view.b a(b.a aVar) {
        d dVar;
        if (aVar != null) {
            androidx.appcompat.view.b bVar = this.j;
            if (bVar != null) {
                bVar.c();
            }
            c cVar = new c(aVar);
            ActionBar a2 = a();
            if (a2 != null) {
                this.j = a2.a((b.a) cVar);
                androidx.appcompat.view.b bVar2 = this.j;
                if (!(bVar2 == null || (dVar = this.f1041g) == null)) {
                    dVar.onSupportActionModeStarted(bVar2);
                }
            }
            if (this.j == null) {
                this.j = b((b.a) cVar);
            }
            return this.j;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final void h() {
        ActionBar a2 = a();
        if (a2 == null || !a2.k()) {
            h(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.b b(androidx.appcompat.view.b.a r8) {
        /*
            r7 = this;
            r7.p()
            androidx.appcompat.view.b r0 = r7.j
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            androidx.appcompat.app.d r0 = r7.f1041g
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r2 = r7.v
            if (r2 != 0) goto L_0x0018
            androidx.appcompat.view.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 == 0) goto L_0x001f
            r7.j = r0
            goto L_0x015c
        L_0x001f:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.k
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00cc
            boolean r0 = r7.t
            if (r0 == 0) goto L_0x00ad
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f1039e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x005e
            android.content.Context r5 = r7.f1039e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f1039e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x0060
        L_0x005e:
            android.content.Context r4 = r7.f1039e
        L_0x0060:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.k = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.l = r5
            android.widget.PopupWindow r5 = r7.l
            r6 = 2
            androidx.core.widget.g.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.l
            androidx.appcompat.widget.ActionBarContextView r6 = r7.k
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.l
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.k
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.l
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.m = r0
            goto L_0x00cc
        L_0x00ad:
            android.view.ViewGroup r0 = r7.p
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00cc
            android.content.Context r4 = r7.n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.k = r0
        L_0x00cc:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.k
            if (r0 == 0) goto L_0x015c
            r7.p()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.k
            r0.c()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.k
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.k
            android.widget.PopupWindow r6 = r7.l
            if (r6 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r3 = 0
        L_0x00e8:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.b()
            boolean r8 = r8.a((androidx.appcompat.view.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x015a
            r0.d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            r8.a(r0)
            r7.j = r0
            boolean r8 = r7.o()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0124
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            androidx.core.h.x r8 = androidx.core.h.u.s(r8)
            androidx.core.h.x r8 = r8.a((float) r0)
            r7.n = r8
            androidx.core.h.x r8 = r7.n
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.a((androidx.core.h.y) r0)
            goto L_0x014a
        L_0x0124:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x014a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.k
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.h.u.z(r8)
        L_0x014a:
            android.widget.PopupWindow r8 = r7.l
            if (r8 == 0) goto L_0x015c
            android.view.Window r8 = r7.f1040f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.m
            r8.post(r0)
            goto L_0x015c
        L_0x015a:
            r7.j = r1
        L_0x015c:
            androidx.appcompat.view.b r8 = r7.j
            if (r8 == 0) goto L_0x0167
            androidx.appcompat.app.d r0 = r7.f1041g
            if (r0 == 0) goto L_0x0167
            r0.onSupportActionModeStarted(r8)
        L_0x0167:
            androidx.appcompat.view.b r8 = r7.j
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.p;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean o() {
        /*
            r1 = this;
            boolean r0 = r1.J
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.p
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.h.u.J(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.o():boolean");
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        x xVar = this.n;
        if (xVar != null) {
            xVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2, KeyEvent keyEvent) {
        ActionBar a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.Q;
        if (panelFeatureState == null || !a(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Q == null) {
                PanelFeatureState f2 = f(0);
                b(f2, keyEvent);
                boolean a3 = a(f2, keyEvent.getKeyCode(), keyEvent);
                f2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.Q;
        if (panelFeatureState2 != null) {
            panelFeatureState2.n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0110 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.KeyEvent r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1038d
            boolean r1 = r0 instanceof androidx.core.h.f.a
            r2 = 1
            if (r1 != 0) goto L_0x000b
            boolean r0 = r0 instanceof androidx.appcompat.app.f
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            android.view.Window r0 = r6.f1040f
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x001a
            boolean r0 = androidx.core.h.f.a((android.view.View) r0, (android.view.KeyEvent) r7)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r0 = r7.getKeyCode()
            r1 = 82
            if (r0 != r1) goto L_0x002d
            androidx.appcompat.app.AppCompatDelegateImpl$d r0 = r6.E
            android.view.Window$Callback r0 = r0.f1257b
            boolean r0 = r0.dispatchKeyEvent(r7)
            if (r0 == 0) goto L_0x002d
            return r2
        L_0x002d:
            int r0 = r7.getKeyCode()
            int r3 = r7.getAction()
            r4 = 0
            if (r3 != 0) goto L_0x003a
            r3 = 1
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            r5 = 4
            if (r3 == 0) goto L_0x0062
            if (r0 == r5) goto L_0x0055
            if (r0 == r1) goto L_0x0043
            goto L_0x0061
        L_0x0043:
            int r0 = r7.getRepeatCount()
            if (r0 != 0) goto L_0x0054
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.f(r4)
            boolean r1 = r0.o
            if (r1 != 0) goto L_0x0054
            r6.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (android.view.KeyEvent) r7)
        L_0x0054:
            return r2
        L_0x0055:
            int r7 = r7.getFlags()
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r2 = 0
        L_0x005f:
            r6.R = r2
        L_0x0061:
            return r4
        L_0x0062:
            if (r0 == r5) goto L_0x00e3
            if (r0 == r1) goto L_0x0068
            goto L_0x0111
        L_0x0068:
            androidx.appcompat.view.b r0 = r6.j
            if (r0 != 0) goto L_0x00e2
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.f(r4)
            androidx.appcompat.widget.n r1 = r6.G
            if (r1 == 0) goto L_0x00a6
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x00a6
            android.content.Context r1 = r6.f1039e
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            boolean r1 = r1.hasPermanentMenuKey()
            if (r1 != 0) goto L_0x00a6
            androidx.appcompat.widget.n r1 = r6.G
            boolean r1 = r1.c()
            if (r1 != 0) goto L_0x009f
            boolean r1 = r6.v
            if (r1 != 0) goto L_0x00c6
            boolean r7 = r6.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (android.view.KeyEvent) r7)
            if (r7 == 0) goto L_0x00c6
            androidx.appcompat.widget.n r7 = r6.G
            boolean r7 = r7.e()
            goto L_0x00cd
        L_0x009f:
            androidx.appcompat.widget.n r7 = r6.G
            boolean r7 = r7.f()
            goto L_0x00cd
        L_0x00a6:
            boolean r1 = r0.o
            if (r1 != 0) goto L_0x00c8
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x00af
            goto L_0x00c8
        L_0x00af:
            boolean r1 = r0.m
            if (r1 == 0) goto L_0x00c6
            boolean r1 = r0.r
            if (r1 == 0) goto L_0x00be
            r0.m = r4
            boolean r1 = r6.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (android.view.KeyEvent) r7)
            goto L_0x00bf
        L_0x00be:
            r1 = 1
        L_0x00bf:
            if (r1 == 0) goto L_0x00c6
            r6.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (android.view.KeyEvent) r7)
            r7 = 1
            goto L_0x00cd
        L_0x00c6:
            r7 = 0
            goto L_0x00cd
        L_0x00c8:
            boolean r7 = r0.o
            r6.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (boolean) r2)
        L_0x00cd:
            if (r7 == 0) goto L_0x00e2
            android.content.Context r7 = r6.f1039e
            android.content.Context r7 = r7.getApplicationContext()
            java.lang.String r0 = "audio"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.media.AudioManager r7 = (android.media.AudioManager) r7
            if (r7 == 0) goto L_0x00e2
            r7.playSoundEffect(r4)
        L_0x00e2:
            return r2
        L_0x00e3:
            boolean r7 = r6.R
            r6.R = r4
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.f(r4)
            if (r0 == 0) goto L_0x00f7
            boolean r1 = r0.o
            if (r1 == 0) goto L_0x00f7
            if (r7 != 0) goto L_0x00f6
            r6.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r0, (boolean) r2)
        L_0x00f6:
            return r2
        L_0x00f7:
            androidx.appcompat.view.b r7 = r6.j
            if (r7 == 0) goto L_0x0100
            r7.c()
        L_0x00fe:
            r7 = 1
            goto L_0x010e
        L_0x0100:
            androidx.appcompat.app.ActionBar r7 = r6.a()
            if (r7 == 0) goto L_0x010d
            boolean r7 = r7.l()
            if (r7 == 0) goto L_0x010d
            goto L_0x00fe
        L_0x010d:
            r7 = 0
        L_0x010e:
            if (r7 == 0) goto L_0x0111
            return r2
        L_0x0111:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a(android.view.KeyEvent):boolean");
    }

    private View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.af == null) {
            String string = this.f1039e.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.af = new h();
            } else {
                try {
                    this.af = (h) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb = new StringBuilder("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    this.af = new h();
                }
            }
        }
        if (z) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.af.a(view, str, context, attributeSet, z2, z, ah.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1040f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || u.M((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final void k() {
        LayoutInflater from = LayoutInflater.from(this.f1039e);
        if (from.getFactory() == null) {
            androidx.core.h.g.a(from, this);
        } else {
            from.getFactory2();
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.o && !this.v) {
            if (panelFeatureState.f1052a == 0) {
                if ((this.f1039e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback callback = this.f1040f.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.f1052a, panelFeatureState.j)) {
                WindowManager windowManager = (WindowManager) this.f1039e.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f1058g == null || panelFeatureState.q) {
                        if (panelFeatureState.f1058g == null) {
                            a(panelFeatureState);
                            if (panelFeatureState.f1058g == null) {
                                return;
                            }
                        } else if (panelFeatureState.q && panelFeatureState.f1058g.getChildCount() > 0) {
                            panelFeatureState.f1058g.removeAllViews();
                        }
                        if (!c(panelFeatureState) || !panelFeatureState.a()) {
                            panelFeatureState.q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f1059h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.f1058g.setBackgroundResource(panelFeatureState.f1053b);
                        ViewParent parent = panelFeatureState.f1059h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f1059h);
                        }
                        panelFeatureState.f1058g.addView(panelFeatureState.f1059h, layoutParams2);
                        if (!panelFeatureState.f1059h.hasFocus()) {
                            panelFeatureState.f1059h.requestFocus();
                        }
                    } else if (!(panelFeatureState.f1060i == null || (layoutParams = panelFeatureState.f1060i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        panelFeatureState.n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f1055d, panelFeatureState.f1056e, 1002, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.f1054c;
                        layoutParams3.windowAnimations = panelFeatureState.f1057f;
                        windowManager.addView(panelFeatureState.f1058g, layoutParams3);
                        panelFeatureState.o = true;
                        return;
                    }
                    i2 = -2;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f1055d, panelFeatureState.f1056e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f1054c;
                    layoutParams32.windowAnimations = panelFeatureState.f1057f;
                    windowManager.addView(panelFeatureState.f1058g, layoutParams32);
                    panelFeatureState.o = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.f1058g = new h(panelFeatureState.l);
        panelFeatureState.f1054c = 81;
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.f1039e;
        if ((panelFeatureState.f1052a == 0 || panelFeatureState.f1052a == 108) && this.G != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.a((g.a) this);
        panelFeatureState.a(gVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f1060i != null) {
            panelFeatureState.f1059h = panelFeatureState.f1060i;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.I == null) {
                this.I = new i();
            }
            panelFeatureState.f1059h = (View) panelFeatureState.a((m.a) this.I);
            if (panelFeatureState.f1059h != null) {
                return true;
            }
            return false;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        n nVar;
        n nVar2;
        n nVar3;
        if (this.v) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.Q;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            a(panelFeatureState2, false);
        }
        Window.Callback callback = this.f1040f.getCallback();
        if (callback != null) {
            panelFeatureState.f1060i = callback.onCreatePanelView(panelFeatureState.f1052a);
        }
        boolean z2 = panelFeatureState.f1052a == 0 || panelFeatureState.f1052a == 108;
        if (z2 && (nVar3 = this.G) != null) {
            nVar3.setMenuPrepared();
        }
        if (panelFeatureState.f1060i == null && (!z2 || !(this.f1042h instanceof j))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null) {
                    b(panelFeatureState);
                    if (panelFeatureState.j == null) {
                        return false;
                    }
                }
                if (z2 && this.G != null) {
                    if (this.H == null) {
                        this.H = new b();
                    }
                    this.G.setMenu(panelFeatureState.j, this.H);
                }
                panelFeatureState.j.e();
                if (!callback.onCreatePanelMenu(panelFeatureState.f1052a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.g) null);
                    if (z2 && (nVar2 = this.G) != null) {
                        nVar2.setMenu((Menu) null, this.H);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.e();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.d(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (!callback.onPreparePanel(0, panelFeatureState.f1060i, panelFeatureState.j)) {
                if (z2 && (nVar = this.G) != null) {
                    nVar.setMenu((Menu) null, this.H);
                }
                panelFeatureState.j.f();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.f();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.Q = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b(androidx.appcompat.view.menu.g gVar) {
        if (!this.O) {
            this.O = true;
            this.G.g();
            Window.Callback callback = this.f1040f.getCallback();
            if (callback != null && !this.v) {
                callback.onPanelClosed(108, gVar);
            }
            this.O = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        a(f(0), true);
    }

    /* access modifiers changed from: package-private */
    public final void a(PanelFeatureState panelFeatureState, boolean z2) {
        n nVar;
        if (!z2 || panelFeatureState.f1052a != 0 || (nVar = this.G) == null || !nVar.c()) {
            WindowManager windowManager = (WindowManager) this.f1039e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.o || panelFeatureState.f1058g == null)) {
                windowManager.removeView(panelFeatureState.f1058g);
                if (z2) {
                    a(panelFeatureState.f1052a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.m = false;
            panelFeatureState.n = false;
            panelFeatureState.o = false;
            panelFeatureState.f1059h = null;
            panelFeatureState.q = true;
            if (this.Q == panelFeatureState) {
                this.Q = null;
                return;
            }
            return;
        }
        b(panelFeatureState.j);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.P;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.v) {
            this.E.f1257b.onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.P;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final PanelFeatureState f(int i2) {
        PanelFeatureState[] panelFeatureStateArr = this.P;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.P = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            return panelFeatureState.j.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    private void h(int i2) {
        this.x = (1 << i2) | this.x;
        if (!this.w) {
            u.a(this.f1040f.getDecorView(), this.ab);
            this.w = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i2) {
        PanelFeatureState f2;
        PanelFeatureState f3 = f(i2);
        if (f3.j != null) {
            Bundle bundle = new Bundle();
            f3.j.c(bundle);
            if (bundle.size() > 0) {
                f3.s = bundle;
            }
            f3.j.e();
            f3.j.clear();
        }
        f3.r = true;
        f3.q = true;
        if ((i2 == 108 || i2 == 0) && this.G != null && (f2 = f(0)) != null) {
            f2.m = false;
            b(f2, (KeyEvent) null);
        }
    }

    private void y() {
        if (this.J) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        n nVar = this.G;
        if (nVar != null) {
            nVar.g();
        }
        if (this.l != null) {
            this.f1040f.getDecorView().removeCallbacks(this.m);
            if (this.l.isShowing()) {
                try {
                    this.l.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.l = null;
        }
        p();
        PanelFeatureState f2 = f(0);
        if (f2 != null && f2.j != null) {
            f2.j.close();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(boolean z2) {
        if (this.v) {
            return false;
        }
        int z3 = z();
        boolean a2 = a(a(this.f1039e, z3), z2);
        if (z3 == 0) {
            b(this.f1039e).d();
        } else {
            f fVar = this.Z;
            if (fVar != null) {
                fVar.e();
            }
        }
        if (z3 == 3) {
            c(this.f1039e).d();
        } else {
            f fVar2 = this.aa;
            if (fVar2 != null) {
                fVar2.e();
            }
        }
        return a2;
    }

    public final int l() {
        return this.V;
    }

    private int a(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        return c(context).a();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return b(context).a();
            } else {
                return -1;
            }
        }
        return i2;
    }

    private int z() {
        int i2 = this.V;
        return i2 != -100 ? i2 : e.f1097a;
    }

    private static Configuration a(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r6, boolean r7) {
        /*
            r5 = this;
            android.content.Context r0 = r5.f1039e
            r1 = 0
            android.content.res.Configuration r0 = a((android.content.Context) r0, (int) r6, (android.content.res.Configuration) r1)
            boolean r1 = r5.A()
            android.content.Context r2 = r5.f1039e
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r3 = 1
            if (r2 == r0) goto L_0x0047
            if (r7 == 0) goto L_0x0047
            if (r1 != 0) goto L_0x0047
            boolean r7 = r5.S
            if (r7 == 0) goto L_0x0047
            boolean r7 = B
            if (r7 != 0) goto L_0x0030
            boolean r7 = r5.T
            if (r7 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r7 = r5.f1038d
            boolean r4 = r7 instanceof android.app.Activity
            if (r4 == 0) goto L_0x0047
            android.app.Activity r7 = (android.app.Activity) r7
            boolean r7 = r7.isChild()
            if (r7 != 0) goto L_0x0047
            java.lang.Object r7 = r5.f1038d
            android.app.Activity r7 = (android.app.Activity) r7
            androidx.core.app.a.e(r7)
            r7 = 1
            goto L_0x0048
        L_0x0047:
            r7 = 0
        L_0x0048:
            if (r7 != 0) goto L_0x0050
            if (r2 == r0) goto L_0x0050
            r5.b((int) r0, (boolean) r1)
            r7 = 1
        L_0x0050:
            if (r7 == 0) goto L_0x005d
            java.lang.Object r0 = r5.f1038d
            boolean r1 = r0 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x005d
            androidx.appcompat.app.AppCompatActivity r0 = (androidx.appcompat.app.AppCompatActivity) r0
            r0.onNightModeChanged(r6)
        L_0x005d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a(int, boolean):boolean");
    }

    private void b(int i2, boolean z2) {
        Resources resources = this.f1039e.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            i.a(resources);
        }
        int i3 = this.W;
        if (i3 != 0) {
            this.f1039e.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f1039e.getTheme().applyStyle(this.W, true);
            }
        }
        if (z2) {
            Object obj = this.f1038d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.q) {
                    if (((androidx.lifecycle.q) activity).getLifecycle().a().isAtLeast(k.b.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.U) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    private f b(Context context) {
        if (this.Z == null) {
            this.Z = new g(l.a(context));
        }
        return this.Z;
    }

    private f c(Context context) {
        if (this.aa == null) {
            this.aa = new e(context);
        }
        return this.aa;
    }

    private boolean A() {
        int i2;
        if (!this.Y && (this.f1038d instanceof Activity)) {
            PackageManager packageManager = this.f1039e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f1039e, this.f1038d.getClass()), i2);
                this.X = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.X = false;
            }
        }
        this.Y = true;
        return this.X;
    }

    class c implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private b.a f1067b;

        public c(b.a aVar) {
            this.f1067b = aVar;
        }

        public final boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f1067b.a(bVar, menu);
        }

        public final boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            u.z(AppCompatDelegateImpl.this.p);
            return this.f1067b.b(bVar, menu);
        }

        public final boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f1067b.a(bVar, menuItem);
        }

        public final void a(androidx.appcompat.view.b bVar) {
            this.f1067b.a(bVar);
            if (AppCompatDelegateImpl.this.l != null) {
                AppCompatDelegateImpl.this.f1040f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.m);
            }
            if (AppCompatDelegateImpl.this.k != null) {
                AppCompatDelegateImpl.this.p();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.n = u.s(appCompatDelegateImpl.k).a(0.0f);
                AppCompatDelegateImpl.this.n.a((y) new z() {
                    public final void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.k.setVisibility(8);
                        if (AppCompatDelegateImpl.this.l != null) {
                            AppCompatDelegateImpl.this.l.dismiss();
                        } else if (AppCompatDelegateImpl.this.k.getParent() instanceof View) {
                            u.z((View) AppCompatDelegateImpl.this.k.getParent());
                        }
                        AppCompatDelegateImpl.this.k.removeAllViews();
                        AppCompatDelegateImpl.this.n.a((y) null);
                        AppCompatDelegateImpl.this.n = null;
                        u.z(AppCompatDelegateImpl.this.p);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.f1041g != null) {
                AppCompatDelegateImpl.this.f1041g.onSupportActionModeFinished(AppCompatDelegateImpl.this.j);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl2.j = null;
            u.z(appCompatDelegateImpl2.p);
        }
    }

    final class i implements m.a {
        i() {
        }

        public final void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g l = gVar.l();
            boolean z2 = l != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                gVar = l;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) gVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.a(a2.f1052a, a2, (Menu) l);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z);
        }

        public final boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback;
            if (gVar != gVar.l() || !AppCompatDelegateImpl.this.q || (callback = AppCompatDelegateImpl.this.f1040f.getCallback()) == null || AppCompatDelegateImpl.this.v) {
                return true;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }
    }

    final class b implements m.a {
        b() {
        }

        public final boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = AppCompatDelegateImpl.this.f1040f.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }

        public final void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            AppCompatDelegateImpl.this.b(gVar);
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f1052a;

        /* renamed from: b  reason: collision with root package name */
        int f1053b;

        /* renamed from: c  reason: collision with root package name */
        int f1054c;

        /* renamed from: d  reason: collision with root package name */
        int f1055d;

        /* renamed from: e  reason: collision with root package name */
        int f1056e;

        /* renamed from: f  reason: collision with root package name */
        int f1057f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f1058g;

        /* renamed from: h  reason: collision with root package name */
        View f1059h;

        /* renamed from: i  reason: collision with root package name */
        View f1060i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i2) {
            this.f1052a = i2;
        }

        public final boolean a() {
            if (this.f1059h == null) {
                return false;
            }
            if (this.f1060i == null && this.k.c().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f1053b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f1057f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public final void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.b((m) this.k);
                }
                this.j = gVar;
                if (gVar != null && (eVar = this.k) != null) {
                    gVar.a((m) eVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.e(this.l, R.layout.abc_list_menu_item_layout);
                androidx.appcompat.view.menu.e eVar = this.k;
                eVar.f1325h = aVar;
                this.j.a((m) eVar);
            }
            return this.k.a(this.f1058g);
        }

        static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                    return new SavedState[i2];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f1061a;

            /* renamed from: b  reason: collision with root package name */
            boolean f1062b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f1063c;

            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f1061a);
                parcel.writeInt(this.f1062b ? 1 : 0);
                if (this.f1062b) {
                    parcel.writeBundle(this.f1063c);
                }
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1061a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f1062b = z;
                if (savedState.f1062b) {
                    savedState.f1063c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    class h extends ContentFrameLayout {
        public h(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl.this.q();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i2) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
        }
    }

    class d extends androidx.appcompat.view.i {
        public final void onContentChanged() {
        }

        d(Window.Callback callback) {
            super(callback);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public final boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.k = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.k = false;
            }
            return onPreparePanel;
        }

        public final boolean onMenuOpened(int i2, Menu menu) {
            ActionBar a2;
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i2 == 108 && (a2 = appCompatDelegateImpl.a()) != null) {
                a2.f(true);
            }
            return true;
        }

        public final void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.e(i2);
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.o) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        private ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f1039e, callback);
            androidx.appcompat.view.b a2 = AppCompatDelegateImpl.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (!AppCompatDelegateImpl.this.o || i2 != 0) {
                return super.onWindowStartingActionMode(callback, i2);
            }
            return a(callback);
        }

        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            PanelFeatureState f2 = AppCompatDelegateImpl.this.f(0);
            if (f2 == null || f2.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, f2.j, i2);
            }
        }
    }

    abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f1072a;

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract IntentFilter c();

        f() {
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            e();
            IntentFilter c2 = c();
            if (c2 != null && c2.countActions() != 0) {
                if (this.f1072a == null) {
                    this.f1072a = new BroadcastReceiver() {
                        public final void onReceive(Context context, Intent intent) {
                            f.this.b();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f1039e.registerReceiver(this.f1072a, c2);
            }
        }

        /* access modifiers changed from: package-private */
        public final void e() {
            if (this.f1072a != null) {
                try {
                    AppCompatDelegateImpl.this.f1039e.unregisterReceiver(this.f1072a);
                } catch (IllegalArgumentException unused) {
                }
                this.f1072a = null;
            }
        }
    }

    class g extends f {

        /* renamed from: c  reason: collision with root package name */
        private final l f1076c;

        g(l lVar) {
            super();
            this.f1076c = lVar;
        }

        public final int a() {
            long j;
            l lVar = this.f1076c;
            l.a aVar = lVar.f1138b;
            boolean z = false;
            if (lVar.f1138b.f1145f > System.currentTimeMillis()) {
                z = aVar.f1140a;
            } else {
                Location location = null;
                Location a2 = androidx.core.content.c.a(lVar.f1137a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? lVar.a(ContactsConstant.NETWORK) : null;
                if (androidx.core.content.c.a(lVar.f1137a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    location = lVar.a("gps");
                }
                if (location == null || a2 == null ? location != null : location.getTime() > a2.getTime()) {
                    a2 = location;
                }
                if (a2 != null) {
                    l.a aVar2 = lVar.f1138b;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (k.f1132a == null) {
                        k.f1132a = new k();
                    }
                    k kVar = k.f1132a;
                    k kVar2 = kVar;
                    kVar2.a(currentTimeMillis - 86400000, a2.getLatitude(), a2.getLongitude());
                    long j2 = kVar.f1133b;
                    kVar2.a(currentTimeMillis, a2.getLatitude(), a2.getLongitude());
                    if (kVar.f1135d == 1) {
                        z = true;
                    }
                    long j3 = kVar.f1134c;
                    long j4 = kVar.f1133b;
                    l.a aVar3 = aVar;
                    long j5 = j3;
                    kVar.a(currentTimeMillis + 86400000, a2.getLatitude(), a2.getLongitude());
                    long j6 = kVar.f1134c;
                    long j7 = j4;
                    if (j5 == -1 || j7 == -1) {
                        j = 43200000 + currentTimeMillis;
                    } else {
                        j = (currentTimeMillis > j7 ? 0 + j6 : currentTimeMillis > j5 ? 0 + j7 : 0 + j5) + 60000;
                    }
                    aVar2.f1140a = z;
                    aVar2.f1141b = j2;
                    aVar2.f1142c = j5;
                    aVar2.f1143d = j7;
                    aVar2.f1144e = j6;
                    aVar2.f1145f = j;
                    z = aVar3.f1140a;
                } else {
                    int i2 = Calendar.getInstance().get(11);
                    if (i2 < 6 || i2 >= 22) {
                        z = true;
                    }
                }
            }
            if (z) {
                return 2;
            }
            return 1;
        }

        public final void b() {
            AppCompatDelegateImpl.this.a(true);
        }

        /* access modifiers changed from: package-private */
        public final IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    class e extends f {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f1071c;

        e(Context context) {
            super();
            this.f1071c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public final int a() {
            if (Build.VERSION.SDK_INT < 21 || !this.f1071c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public final void b() {
            AppCompatDelegateImpl.this.a(true);
        }

        /* access modifiers changed from: package-private */
        public final IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    public final a.C0021a j() {
        return new a();
    }

    class a implements a.C0021a {
        a() {
        }

        public final Context b() {
            return AppCompatDelegateImpl.this.n();
        }

        public final boolean c() {
            ActionBar a2 = AppCompatDelegateImpl.this.a();
            return (a2 == null || (a2.c() & 4) == 0) ? false : true;
        }

        public final void a(Drawable drawable, int i2) {
            ActionBar a2 = AppCompatDelegateImpl.this.a();
            if (a2 != null) {
                a2.b(drawable);
                a2.f(i2);
            }
        }

        public final void a(int i2) {
            ActionBar a2 = AppCompatDelegateImpl.this.a();
            if (a2 != null) {
                a2.f(i2);
            }
        }

        public final Drawable a() {
            ac a2 = ac.a(AppCompatDelegateImpl.this.n(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
            Drawable a3 = a2.a(0);
            a2.f1669a.recycle();
            return a3;
        }
    }

    public final boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback callback = this.f1040f.getCallback();
        if (callback == null || this.v || (a2 = a((Menu) gVar.l())) == null) {
            return false;
        }
        return callback.onMenuItemSelected(a2.f1052a, menuItem);
    }

    public final void a(androidx.appcompat.view.menu.g gVar) {
        n nVar = this.G;
        if (nVar == null || !nVar.b() || (ViewConfiguration.get(this.f1039e).hasPermanentMenuKey() && !this.G.d())) {
            PanelFeatureState f2 = f(0);
            f2.q = true;
            a(f2, false);
            a(f2, (KeyEvent) null);
            return;
        }
        Window.Callback callback = this.f1040f.getCallback();
        if (this.G.c()) {
            this.G.f();
            if (!this.v) {
                callback.onPanelClosed(108, f(0).j);
            }
        } else if (callback != null && !this.v) {
            if (this.w && (1 & this.x) != 0) {
                this.f1040f.getDecorView().removeCallbacks(this.ab);
                this.ab.run();
            }
            PanelFeatureState f3 = f(0);
            if (f3.j != null && !f3.r && callback.onPreparePanel(0, f3.f1060i, f3.j)) {
                callback.onMenuOpened(108, f3.j);
                this.G.e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(ab abVar, Rect rect) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (abVar != null) {
            i2 = abVar.f3061b.g().f2974c;
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.k;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            boolean z4 = true;
            if (this.k.isShown()) {
                if (this.ad == null) {
                    this.ad = new Rect();
                    this.ae = new Rect();
                }
                Rect rect2 = this.ad;
                Rect rect3 = this.ae;
                if (abVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(abVar.f3061b.g().f2973b, abVar.f3061b.g().f2974c, abVar.f3061b.g().f2975d, abVar.f3061b.g().f2976e);
                }
                ai.a(this.p, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                ab B2 = u.B(this.p);
                if (B2 == null) {
                    i3 = 0;
                } else {
                    i3 = B2.f3061b.g().f2973b;
                }
                if (B2 == null) {
                    i4 = 0;
                } else {
                    i4 = B2.f3061b.g().f2975d;
                }
                if (marginLayoutParams.topMargin == i7 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i9) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i7;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i9;
                    z3 = true;
                }
                if (i7 <= 0 || this.L != null) {
                    View view = this.L;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == i3 && marginLayoutParams2.rightMargin == i4)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = i3;
                            marginLayoutParams2.rightMargin = i4;
                            this.L.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    this.L = new View(this.f1039e);
                    this.L.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i3;
                    layoutParams.rightMargin = i4;
                    this.p.addView(this.L, -1, layoutParams);
                }
                z2 = this.L != null;
                if (z2 && this.L.getVisibility() != 0) {
                    View view2 = this.L;
                    if ((u.y(view2) & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        i5 = androidx.core.content.b.c(this.f1039e, R.color.abc_decor_view_status_guard_light);
                    } else {
                        i5 = androidx.core.content.b.c(this.f1039e, R.color.abc_decor_view_status_guard);
                    }
                    view2.setBackgroundColor(i5);
                }
                if (!this.s && z2) {
                    i2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (z3) {
                this.k.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.L;
        if (view3 != null) {
            if (!z2) {
                i6 = 8;
            }
            view3.setVisibility(i6);
        }
        return i2;
    }
}

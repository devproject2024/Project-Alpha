package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

public final class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public int f1212a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f1213b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f1214c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f1215d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f1216e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i2) {
        super(context);
        this.f1212a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1213b = theme;
    }

    /* access modifiers changed from: protected */
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void a(Configuration configuration) {
        if (this.f1216e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f1215d == null) {
            this.f1215d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public final void setTheme(int i2) {
        if (this.f1212a != i2) {
            this.f1212a = i2;
            a();
        }
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f1213b;
        if (theme != null) {
            return theme;
        }
        if (this.f1212a == 0) {
            this.f1212a = R.style.Theme_AppCompat_Light;
        }
        a();
        return this.f1213b;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1214c == null) {
            this.f1214c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1214c;
    }

    private void a() {
        if (this.f1213b == null) {
            this.f1213b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1213b.setTo(theme);
            }
        }
        this.f1213b.applyStyle(this.f1212a, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    public final Resources getResources() {
        if (this.f1216e == null) {
            if (this.f1215d == null) {
                this.f1216e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f1216e = createConfigurationContext(this.f1215d).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.f1215d);
                this.f1216e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.f1216e;
    }
}

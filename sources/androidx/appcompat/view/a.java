package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f1209a;

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.f1209a = context;
    }

    public final int a() {
        Configuration configuration = this.f1209a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i3 > 720) {
            return 5;
        }
        if (i2 > 720 && i3 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i3 > 480) {
            return 4;
        }
        if (i2 <= 480 || i3 <= 640) {
            return i2 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public final boolean b() {
        return this.f1209a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public final int c() {
        TypedArray obtainStyledAttributes = this.f1209a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f1209a.getResources();
        if (!b()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public final boolean d() {
        return this.f1209a.getApplicationInfo().targetSdkVersion < 14;
    }

    public final int e() {
        return this.f1209a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}

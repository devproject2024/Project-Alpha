package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1090a = {16843531};

    public static a a(Activity activity, Drawable drawable, int i2) {
        a aVar = new a(activity);
        if (aVar.f1091a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f1091a.invoke(actionBar, new Object[]{drawable});
                aVar.f1092b.invoke(actionBar, new Object[]{Integer.valueOf(i2)});
            } catch (Exception unused) {
            }
        } else if (aVar.f1093c != null) {
            aVar.f1093c.setImageDrawable(drawable);
        }
        return aVar;
    }

    public static a a(a aVar, Activity activity, int i2) {
        if (aVar == null) {
            aVar = new a(activity);
        }
        if (aVar.f1091a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f1092b.invoke(actionBar, new Object[]{Integer.valueOf(i2)});
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception unused) {
            }
        }
        return aVar;
    }

    public static Drawable a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f1090a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public Method f1091a;

        /* renamed from: b  reason: collision with root package name */
        public Method f1092b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f1093c;

        a(Activity activity) {
            try {
                this.f1091a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f1092b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                        if (childAt2 instanceof ImageView) {
                            this.f1093c = (ImageView) childAt2;
                        }
                    }
                }
            }
        }
    }
}

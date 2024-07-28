package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.f.c;
import androidx.core.g.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static Field f3198a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3199b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f3200c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f3201d;

    private static Field a(String str) {
        Field field;
        try {
            field = TextView.class.getDeclaredField(str);
            try {
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        } catch (NoSuchFieldException unused2) {
            field = null;
            StringBuilder sb = new StringBuilder("Could not retrieve ");
            sb.append(str);
            sb.append(" field.");
            return field;
        }
        return field;
    }

    private static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            return -1;
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static int a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f3201d) {
            f3200c = a("mMaxMode");
            f3201d = true;
        }
        Field field = f3200c;
        if (field == null || a(field, textView) != 1) {
            return -1;
        }
        if (!f3199b) {
            f3198a = a("mMaximum");
            f3199b = true;
        }
        Field field2 = f3198a;
        if (field2 != null) {
            return a(field2, textView);
        }
        return -1;
    }

    public static void a(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static Drawable[] b(TextView textView) {
        if (Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = true;
        if (textView.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static ActionMode.Callback a(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }

    static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f3202a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f3203b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f3204c;

        /* renamed from: d  reason: collision with root package name */
        private Method f3205d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3206e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3207f = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.f3202a = callback;
            this.f3203b = textView;
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3202a.onCreateActionMode(actionMode, menu);
        }

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3202a.onActionItemClicked(actionMode, menuItem);
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f3202a.onDestroyActionMode(actionMode);
        }

        private static Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Method method;
            boolean z;
            Context context = this.f3203b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f3207f) {
                this.f3207f = true;
                try {
                    this.f3204c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3205d = this.f3204c.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f3206e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3204c = null;
                    this.f3205d = null;
                    this.f3206e = false;
                }
            }
            try {
                if (!this.f3206e || !this.f3204c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f3205d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                        if (!context.getPackageName().equals(next.activityInfo.packageName) && (!next.activityInfo.exported || !(next.activityInfo.permission == null || context.checkSelfPermission(next.activityInfo.permission) == 0))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            arrayList.add(next);
                        }
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i2);
                    MenuItem add = menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager));
                    TextView textView = this.f3203b;
                    add.setIntent(a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled())).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
            return this.f3202a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static void b(TextView textView, int i2) {
        int i3;
        f.a(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c(TextView textView, int i2) {
        int i3;
        f.a(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void d(TextView textView, int i2) {
        f.a(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static c.a c(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new c.a(textView.getTextMetricsParams());
        }
        c.a.C0043a aVar = new c.a.C0043a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            aVar.f2946b = textView.getBreakStrategy();
            aVar.f2947c = textView.getHyphenationFrequency();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            aVar.f2945a = d(textView);
        }
        return aVar.a();
    }

    public static void a(TextView textView, c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(cVar.a());
        } else if (c(textView).a(cVar.f2937a)) {
            textView.setText(cVar);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    private static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    public static void a(TextView textView, ColorStateList colorStateList) {
        f.a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof k) {
            ((k) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void a(TextView textView, PorterDuff.Mode mode) {
        f.a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof k) {
            ((k) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }
}

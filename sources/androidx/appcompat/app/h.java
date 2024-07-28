package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.a.g;
import androidx.appcompat.R;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.z;
import androidx.core.h.u;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f1101a = {Context.class, AttributeSet.class};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1102b = {16843375};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f1103c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d  reason: collision with root package name */
    private static final g<String, Constructor<? extends View>> f1104d = new g<>();

    /* renamed from: e  reason: collision with root package name */
    private final Object[] f1105e = new Object[2];

    /* access modifiers changed from: package-private */
    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int resourceId = z2 ? obtainStyledAttributes.getResourceId(R.styleable.View_android_theme, 0) : 0;
        if (resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0);
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0 && (!(context2 instanceof d) || ((d) context2).f1212a != resourceId)) {
            context2 = new d(context2, resourceId);
        }
        if (z3) {
            context2 = z.a(context2);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view2 = a(context2, attributeSet);
                a(view2, str);
                break;
            case 1:
                view2 = new AppCompatImageView(context2, attributeSet);
                a(view2, str);
                break;
            case 2:
                view2 = b(context2, attributeSet);
                a(view2, str);
                break;
            case 3:
                view2 = new AppCompatEditText(context2, attributeSet);
                a(view2, str);
                break;
            case 4:
                view2 = new AppCompatSpinner(context2, attributeSet);
                a(view2, str);
                break;
            case 5:
                view2 = new AppCompatImageButton(context2, attributeSet);
                a(view2, str);
                break;
            case 6:
                view2 = c(context2, attributeSet);
                a(view2, str);
                break;
            case 7:
                view2 = d(context2, attributeSet);
                a(view2, str);
                break;
            case 8:
                view2 = new AppCompatCheckedTextView(context2, attributeSet);
                a(view2, str);
                break;
            case 9:
                view2 = e(context2, attributeSet);
                a(view2, str);
                break;
            case 10:
                view2 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                a(view2, str);
                break;
            case 11:
                view2 = new AppCompatRatingBar(context2, attributeSet);
                a(view2, str);
                break;
            case 12:
                view2 = new AppCompatSeekBar(context2, attributeSet);
                a(view2, str);
                break;
            case 13:
                view2 = new AppCompatToggleButton(context2, attributeSet);
                a(view2, str);
                break;
            default:
                view2 = null;
                break;
        }
        if (view2 == null && context != context2) {
            view2 = a(context2, str, attributeSet);
        }
        if (view2 != null) {
            Context context3 = view2.getContext();
            if ((context3 instanceof ContextWrapper) && (Build.VERSION.SDK_INT < 15 || u.N(view2))) {
                TypedArray obtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, f1102b);
                String string = obtainStyledAttributes2.getString(0);
                if (string != null) {
                    view2.setOnClickListener(new a(view2, string));
                }
                obtainStyledAttributes2.recycle();
            }
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public AppCompatTextView a(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatCheckBox c(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatRadioButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public AppCompatAutoCompleteTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    private void a(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    private View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, Item.KEY_CLASS);
        }
        try {
            this.f1105e[0] = context;
            this.f1105e[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1103c) {
                    View a3 = a(context, str, a2);
                    if (a3 != null) {
                        return a3;
                    }
                }
                Object[] objArr = this.f1105e;
                objArr[0] = null;
                objArr[1] = null;
                return null;
            }
            View a4 = a(context, str, (String) null);
            Object[] objArr2 = this.f1105e;
            objArr2[0] = null;
            objArr2[1] = null;
            return a4;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr3 = this.f1105e;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    private View a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends U> constructor = f1104d.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f1101a);
            f1104d.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1105e);
    }

    static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f1106a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1107b;

        /* renamed from: c  reason: collision with root package name */
        private Method f1108c;

        /* renamed from: d  reason: collision with root package name */
        private Context f1109d;

        public a(View view, String str) {
            this.f1106a = view;
            this.f1107b = str;
        }

        public final void onClick(View view) {
            String str;
            Method method;
            if (this.f1108c == null) {
                for (Context context = this.f1106a.getContext(); context != null; context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1107b, new Class[]{View.class})) != null) {
                            this.f1108c = method;
                            this.f1109d = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
                int id = this.f1106a.getId();
                if (id == -1) {
                    str = "";
                } else {
                    str = " with id '" + this.f1106a.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + this.f1107b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1106a.getClass() + str);
            }
            try {
                this.f1108c.invoke(this.f1109d, new Object[]{view});
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }
}

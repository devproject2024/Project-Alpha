package androidx.databinding.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.g;
import androidx.databinding.library.baseAdapters.R;

public final class d {

    public interface a {
        void afterTextChanged(Editable editable);
    }

    public interface b {
    }

    public interface c {
        void onTextChanged(CharSequence charSequence, int i2, int i3, int i4);
    }

    public static void a(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence == text) {
            return;
        }
        if (charSequence != null || text.length() != 0) {
            if (!(charSequence instanceof Spanned)) {
                boolean z = true;
                if ((charSequence == null) == (text == null)) {
                    if (charSequence != null) {
                        int length = charSequence.length();
                        if (length == text.length()) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                } else if (charSequence.charAt(i2) != text.charAt(i2)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                    z = false;
                }
                if (!z) {
                    return;
                }
            } else if (charSequence.equals(text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    private static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        a(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
    }

    public static void b(TextView textView, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17) {
            a(drawable);
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            return;
        }
        a(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static void a(TextView textView, int i2) {
        boolean z;
        InputFilter[] filters = textView.getFilters();
        if (filters == null) {
            filters = new InputFilter[]{new InputFilter.LengthFilter(i2)};
        } else {
            int i3 = 0;
            while (true) {
                if (i3 >= filters.length) {
                    z = false;
                    break;
                }
                InputFilter inputFilter = filters[i3];
                if (inputFilter instanceof InputFilter.LengthFilter) {
                    if (Build.VERSION.SDK_INT < 21 || ((InputFilter.LengthFilter) inputFilter).getMax() != i2) {
                        filters[i3] = new InputFilter.LengthFilter(i2);
                    }
                    z = true;
                } else {
                    i3++;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                inputFilterArr[inputFilterArr.length - 1] = new InputFilter.LengthFilter(i2);
                filters = inputFilterArr;
            }
        }
        textView.setFilters(filters);
    }

    public static void a(TextView textView, final c cVar, final a aVar, final g gVar) {
        AnonymousClass1 r2;
        if (aVar == null && cVar == null && gVar == null) {
            r2 = null;
        } else {
            r2 = new TextWatcher() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f3261a = null;

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onTextChanged(charSequence, i2, i3, i4);
                    }
                    g gVar = gVar;
                    if (gVar != null) {
                        gVar.onChange();
                    }
                }

                public final void afterTextChanged(Editable editable) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.afterTextChanged(editable);
                    }
                }
            };
        }
        TextWatcher textWatcher = (TextWatcher) c.a(textView, r2, R.id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (r2 != null) {
            textView.addTextChangedListener(r2);
        }
    }
}

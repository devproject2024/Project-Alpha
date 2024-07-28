package net.one97.paytm.bankOpen.ica.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f16584a = new b();

    private b() {
    }

    public static String a(String str, int i2, int i3) {
        k.c(str, "str");
        if (str.charAt(0) == '.') {
            str = "0".concat(String.valueOf(str));
        }
        int length = str.length();
        String str2 = "";
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt != '.' && !z) {
                i5++;
                if (i5 > i2) {
                    return str2;
                }
            } else if (charAt == '.') {
                z = true;
            } else {
                i4++;
                if (i4 > i3) {
                    return str2;
                }
            }
            str2 = str2 + charAt;
        }
        return str2;
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f16585a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16586b = 7;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16587c = 2;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        a(EditText editText) {
            this.f16585a = editText;
        }

        public final void afterTextChanged(Editable editable) {
            String obj = this.f16585a.getText().toString();
            if (!(obj.length() == 0)) {
                b bVar = b.f16584a;
                String a2 = b.a(obj, this.f16586b, this.f16587c);
                if (!a2.equals(obj)) {
                    this.f16585a.setText(a2);
                    this.f16585a.setSelection(this.f16585a.getText().length());
                }
            }
        }
    }

    public static void a(EditText editText) {
        k.c(editText, "cop_et");
        editText.addTextChangedListener(new a(editText));
    }
}

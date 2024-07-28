package net.one97.paytm.recharge.mobile.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;

public class CJRMobileInputFieldWidgetV8 extends CJRInputFieldWithActionWidgetV8 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private boolean f63710a;

    /* renamed from: f  reason: collision with root package name */
    private boolean f63711f;

    /* renamed from: g  reason: collision with root package name */
    private a f63712g;

    /* renamed from: h  reason: collision with root package name */
    private final Typeface f63713h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f63714i;

    public interface a {
        void F();

        void a(CharSequence charSequence, int i2, int i3, int i4);

        void b(CharSequence charSequence, int i2, int i3, int i4);
    }

    public View a(int i2) {
        if (this.f63714i == null) {
            this.f63714i = new HashMap();
        }
        View view = (View) this.f63714i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63714i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMobileInputFieldWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f63713h = Typeface.create("sans-serif", 1);
        ((TextView) a(R.id.hint_amount)).setTextSize(2, 21.0f);
        TextView textView = (TextView) a(R.id.hint_amount);
        k.a((Object) textView, "hint_amount");
        textView.setTypeface(this.f63713h);
        if (Build.VERSION.SDK_INT >= 23) {
            TextView textView2 = (TextView) a(R.id.hint_amount);
            k.a((Object) textView2, "hint_amount");
            textView2.setLetterSpacing(0.03f);
        }
        ((CJRRechargeEditText) a(R.id.txt_input)).setTextSize(2, 21.0f);
        CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a(R.id.txt_input);
        k.a((Object) cJRRechargeEditText, "txt_input");
        cJRRechargeEditText.setTypeface(this.f63713h);
        if (Build.VERSION.SDK_INT >= 23) {
            CJRRechargeEditText cJRRechargeEditText2 = (CJRRechargeEditText) a(R.id.txt_input);
            k.a((Object) cJRRechargeEditText2, "txt_input");
            cJRRechargeEditText2.setLetterSpacing(0.03f);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRMobileInputFieldWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void setMInputFieldTextChangeListener(a aVar) {
        this.f63712g = aVar;
        super.setInputFieldTextChangeListener(this);
    }

    public String getInputText() {
        String a2 = a((CharSequence) super.getInputText());
        return a2 == null ? "" : a2;
    }

    private static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return new l("\\s").replace(charSequence, "");
        }
        return null;
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String a2 = a(charSequence);
        a aVar = this.f63712g;
        if (aVar != null) {
            aVar.a(a2, i2, i3, i4);
        }
    }

    public void afterTextChanged(Editable editable) {
        a aVar;
        if (editable != null && editable.length() == 0) {
            setSecondaryInputText("");
            this.f63711f = false;
        }
        TextWatcher textWatcher = this;
        a(textWatcher);
        if (editable == null) {
            k.a();
        }
        if (editable.length() > 10 && !p.a((CharSequence) editable, (CharSequence) " ", false)) {
            String obj = editable.toString();
            if (obj != null) {
                String substring = obj.substring(0, 10);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                editable.clear();
                editable.insert(0, substring);
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        setInputFieldTextChangeListener(textWatcher);
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= (editable != null ? editable.length() : 0)) {
                break;
            }
            int i3 = i2 + 1;
            if (i3 % 6 == 0) {
                if (editable == null) {
                    k.a();
                }
                if (editable.charAt(i2) != ' ') {
                    editable.insert(i2, " ");
                    z = true;
                }
            } else {
                if (editable == null) {
                    k.a();
                }
                if (editable.charAt(i2) == ' ') {
                    editable.replace(i2, i3, "");
                    i2--;
                }
            }
            i2++;
        }
        this.f63710a = z;
        if (!this.f63710a && (aVar = this.f63712g) != null) {
            aVar.F();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!this.f63711f) {
            c();
            setSecondaryInputText("+ 91");
            setDividerColor(R.color.color_00b9f5);
        }
        a aVar = this.f63712g;
        if (aVar != null) {
            aVar.b(charSequence, i2, i3, i4);
        }
    }

    public final void b(String str) {
        this.f63711f = false;
        super.b(str);
    }

    public final void c() {
        this.f63711f = true;
        super.c();
    }

    public void onDetachedFromWindow() {
        this.f63712g = null;
        a((TextWatcher) this);
        super.onDetachedFromWindow();
    }
}

package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.mobile.widget.CJRMobileInputFieldWidgetV8;
import net.one97.paytm.recharge.mobile_v3.d.b;

public class CJRMobileInputFieldWidgetV3 extends CJRMobileInputFieldWidgetV8 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private ViewFlipper f63951a;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f63952f;

    /* renamed from: g  reason: collision with root package name */
    private b f63953g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f63954h;

    public final View a(int i2) {
        if (this.f63954h == null) {
            this.f63954h = new HashMap();
        }
        View view = (View) this.f63954h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63954h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMobileInputFieldWidgetV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRMobileInputFieldWidgetV3(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void b(int i2) {
        super.b(R.layout.v3_content_input_field_with_action);
        this.f63951a = (ViewFlipper) findViewById(R.id.view_flipper_info_secondary);
        TextView textView = (TextView) findViewById(R.id.hint_amount);
        textView.setTextSize(2, 18.0f);
        Typeface create = Typeface.create("sans-serif", 1);
        k.a((Object) textView, "hint_amount");
        textView.setTypeface(create);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setLetterSpacing(0.03f);
        }
        EditText editText = (EditText) findViewById(R.id.txt_input);
        editText.setTextSize(2, 18.0f);
        k.a((Object) editText, "txt_input");
        editText.setTypeface(create);
        if (Build.VERSION.SDK_INT >= 23) {
            editText.setLetterSpacing(0.03f);
        }
        this.f63952f = (FrameLayout) findViewById(R.id.lyt_divider);
    }

    public final void e(String str) {
        k.c(str, "msg");
        getTxt_error().setVisibility(8);
        d(false);
        ViewFlipper viewFlipper = this.f63951a;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(0);
        }
        ViewFlipper viewFlipper2 = this.f63951a;
        if (viewFlipper2 == null) {
            k.a();
        }
        View findViewById = viewFlipper2.findViewById(R.id.lyt_info_secondary_checking);
        ViewFlipper viewFlipper3 = this.f63951a;
        if (viewFlipper3 != null) {
            if (viewFlipper3 == null) {
                k.a();
            }
            viewFlipper3.setDisplayedChild(viewFlipper3.indexOfChild(findViewById));
        }
        TextView textView = (TextView) findViewById.findViewById(R.id.txt_checking);
        k.a((Object) textView, "msgView");
        textView.setText(str);
        textView.setVisibility(0);
        View findViewById2 = findViewById.findViewById(R.id.lyt_lottie_checking);
        k.a((Object) findViewById2, "checkingLottieView");
        findViewById2.setVisibility(0);
    }

    private void d(boolean z) {
        FrameLayout frameLayout = this.f63952f;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, z ? com.paytm.utility.b.c(12) : 0);
        }
    }

    public final void g() {
        d(true);
        ViewFlipper viewFlipper = this.f63951a;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(8);
        }
    }

    public final void setOnKeyUpDownListener(b bVar) {
        k.c(bVar, "onKeyListener");
        this.f63953g = bVar;
        ((CJRRechargeEditText) findViewById(R.id.txt_input)).setOnKeyUpDownListener(bVar);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        b bVar = this.f63953g;
        if (bVar != null) {
            if (bVar == null) {
                k.a();
            }
            bVar.a("dispatch.key.event", keyEvent);
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final void a() {
        super.a();
        this.f63953g = null;
    }
}

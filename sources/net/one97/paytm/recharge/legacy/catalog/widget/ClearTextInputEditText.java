package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.f;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class ClearTextInputEditText extends AppCompatEditText implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f62989a;

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
    }

    public final void afterTextChanged(Editable editable) {
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (editable != null ? editable.length() : 0) > 0 ? this.f62989a : null, (Drawable) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClearTextInputEditText(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClearTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearTextInputEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        addTextChangedListener(this);
        this.f62989a = f.b().a(context, R.drawable.ic_clear_text_input_edit_text);
        setOnTouchListener(new View.OnTouchListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ClearTextInputEditText f62990a;

            {
                this.f62990a = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                k.a((Object) motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
                if (motionEvent.getAction() != 1 || this.f62990a.getCompoundDrawables()[2] == null) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                int right = this.f62990a.getRight();
                Drawable drawable = this.f62990a.getCompoundDrawables()[2];
                k.a((Object) drawable, "compoundDrawables[DRAWABLE_RIGHT]");
                if (rawX < ((float) (right - drawable.getBounds().width()))) {
                    return false;
                }
                this.f62990a.setText("");
                return true;
            }
        });
    }
}

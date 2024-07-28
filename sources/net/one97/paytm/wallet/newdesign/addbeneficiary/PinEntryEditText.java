package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import net.one97.paytm.wallet.R;

public class PinEntryEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    float f70576a = 4.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f70577b = 24.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f70578c;

    /* renamed from: d  reason: collision with root package name */
    private float f70579d = 8.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f70580e = 4;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f70581f;

    /* renamed from: g  reason: collision with root package name */
    private float f70582g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f70583h = 2.0f;

    /* renamed from: i  reason: collision with root package name */
    private Paint f70584i;
    private float j;
    private int k;
    private int l = 0;

    public PinEntryEditText(Context context) {
        super(context);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f70582g *= f2;
        this.f70583h *= f2;
        this.f70584i = new Paint(getPaint());
        this.f70584i.setStrokeWidth(this.f70582g);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PinEntryEditText, 0, 0);
        this.j = obtainStyledAttributes.getFloat(R.styleable.PinEntryEditText_paytmsdkCircleRadius, 10.0f);
        this.k = obtainStyledAttributes.getColor(R.styleable.PinEntryEditText_lineColor, Color.parseColor("#e2ebee"));
        this.f70584i.setColor(this.k);
        obtainStyledAttributes.recycle();
        setBackgroundResource(0);
        this.f70577b *= f2;
        this.f70579d = f2 * this.f70579d;
        this.f70580e = attributeSet.getAttributeIntValue(net.one97.paytm.nativesdk.otp.view.PinEntryEditText.XML_NAMESPACE_ANDROID, "maxLength", 4);
        this.f70576a = (float) this.f70580e;
        setCursorVisible(false);
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        super.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                if (PinEntryEditText.this.f70581f != null) {
                    PinEntryEditText.this.f70581f.onClick(view);
                }
            }
        });
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f70581f = onClickListener;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        float f4 = this.f70577b;
        if (f4 < 0.0f) {
            this.f70578c = ((float) width) / ((this.f70576a * 2.0f) - 1.0f);
        } else {
            float f5 = this.f70576a;
            this.f70578c = (((float) width) - (f4 * (f5 - 1.0f))) / f5;
        }
        int paddingLeft = getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        Editable text = getText();
        int length = text.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(getText(), 0, length, fArr);
        int i2 = paddingLeft;
        int i3 = 0;
        while (((float) i3) < this.f70576a) {
            boolean z = i3 == length;
            if (isFocused()) {
                this.f70584i.setColor(-16777216);
                if (z) {
                    this.f70584i.setColor(Color.parseColor("#00baf2"));
                }
            } else {
                this.f70584i.setColor(-16777216);
            }
            float f6 = (float) i2;
            float f7 = (float) height;
            canvas.drawLine(f6, f7, f6 + this.f70578c, f7, this.f70584i);
            if (getText().length() > i3) {
                f2 = f6;
                canvas.drawText(text, i3, i3 + 1, ((this.f70578c / 2.0f) + f6) - (fArr[0] / 2.0f), f7 - this.f70579d, getPaint());
            } else {
                f2 = f6;
            }
            float f8 = this.f70577b;
            if (f8 < 0.0f) {
                f3 = f2 + (this.f70578c * 2.0f);
            } else {
                f3 = f2 + this.f70578c + f8;
            }
            i2 = (int) f3;
            i3++;
        }
    }
}

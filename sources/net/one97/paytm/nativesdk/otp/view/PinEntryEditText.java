package net.one97.paytm.nativesdk.otp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import net.one97.paytm.nativesdk.R;

public class PinEntryEditText extends AppCompatEditText {
    public static final String CIRCLE_RADIUS = "circle_radius";
    public static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private int changeColor = 0;
    private float mCharSize;
    private float mCircleRadius;
    /* access modifiers changed from: private */
    public View.OnClickListener mClickListener;
    private int mLineColor;
    private float mLineSpacing = 8.0f;
    private float mLineStroke = 1.0f;
    private float mLineStrokeSelected = 2.0f;
    private Paint mLinesPaint;
    private int mMaxLength = 4;
    private float mNumChars = 4.0f;
    private float mSpace = 24.0f;
    private CountDownTimer timer;

    private boolean isPasswordInputType(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    public PinEntryEditText(Context context) {
        super(context);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mLineStroke *= f2;
        this.mLineStrokeSelected *= f2;
        this.mLinesPaint = new Paint(getPaint());
        this.mLinesPaint.setStrokeWidth(this.mLineStroke);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PinEntryEditText, 0, 0);
        this.mCircleRadius = obtainStyledAttributes.getFloat(R.styleable.PinEntryEditText_paytmsdkCircleRadius, 10.0f);
        this.mLineColor = obtainStyledAttributes.getColor(R.styleable.PinEntryEditText_lineColor, Color.parseColor("#e2ebee"));
        this.mLinesPaint.setColor(this.mLineColor);
        obtainStyledAttributes.recycle();
        setBackgroundResource(0);
        this.mSpace *= f2;
        this.mLineSpacing = f2 * this.mLineSpacing;
        this.mMaxLength = attributeSet.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4);
        this.mNumChars = (float) this.mMaxLength;
        setCursorVisible(false);
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        super.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                if (PinEntryEditText.this.mClickListener != null) {
                    PinEntryEditText.this.mClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        float f3 = this.mSpace;
        if (f3 < 0.0f) {
            this.mCharSize = ((float) width) / ((this.mNumChars * 2.0f) - 1.0f);
        } else {
            float f4 = this.mNumChars;
            this.mCharSize = (((float) width) - (f3 * (f4 - 1.0f))) / f4;
        }
        int paddingLeft = getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        int length = getText().length();
        getPaint().getTextWidths(getText(), 0, length, new float[length]);
        int i2 = paddingLeft;
        int i3 = 0;
        while (((float) i3) < this.mNumChars) {
            updateColorForLines(i3 == length);
            float f5 = (float) i2;
            float f6 = (float) height;
            canvas.drawLine(f5, f6, f5 + this.mCharSize, f6, this.mLinesPaint);
            if (getText().length() > i3) {
                canvas.drawCircle((this.mCharSize / 2.0f) + f5, (f6 - this.mLineSpacing) - 50.0f, this.mCircleRadius, getPaint());
            } else {
                Canvas canvas2 = canvas;
            }
            float f7 = this.mSpace;
            if (f7 < 0.0f) {
                f2 = f5 + (this.mCharSize * 2.0f);
            } else {
                f2 = f5 + this.mCharSize + f7;
            }
            i2 = (int) f2;
            i3++;
        }
    }

    private void updateColorForLines(boolean z) {
        if (isFocused()) {
            this.mLinesPaint.setColor(-16777216);
            if (z) {
                this.mLinesPaint.setColor(Color.parseColor("#00baf2"));
                return;
            }
            return;
        }
        this.mLinesPaint.setColor(-16777216);
    }

    public void refresh(int i2) {
        this.mNumChars = (float) i2;
        invalidate();
    }
}

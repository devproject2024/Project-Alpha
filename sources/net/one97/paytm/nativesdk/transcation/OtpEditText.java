package net.one97.paytm.nativesdk.transcation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.f.f;
import androidx.core.h.u;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.Locale;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;

public class OtpEditText extends AppCompatEditText {
    private static final String TAG = "OtpEditText";
    private boolean isActive = true;
    protected boolean mActivateError = false;
    protected float mAllowedNumChars = 6.0f;
    protected boolean mAnimateOnError = false;
    protected boolean mAnimateOnInput = false;
    protected Drawable mCharBackground;
    protected float[] mCharBottom;
    private float[] mCharDrawSize;
    protected Paint mCharPaint;
    protected float mCharSize;
    protected float mCharsSpace = 24.0f;
    protected View.OnClickListener mClickListener;
    protected int mErrorAnimationType = 0;
    protected boolean mHasError = false;
    protected int mInputAnimationType = 0;
    protected boolean mIsCharInSquare = false;
    protected Paint mLastCharPaint;
    protected RectF[] mLineCoords;
    protected int mLineErrorTextColor;
    protected int mLineFocusedColor;
    protected int mLineNextCharColor;
    protected int mLineUnFocusedColor;
    protected Paint mLinesPaint;
    protected View.OnLongClickListener mLongClickListener;
    protected String mMask = null;
    protected StringBuilder mMaskChars = null;
    protected int mMaxCharLength = 6;
    protected OnOtpEnteredListener mOnPinEnteredListener = null;
    protected OnTextChangedListener mOnTextChangedListener = null;
    protected ColorStateList mOriginalTextColors;
    protected int mOtpErrorColor = 0;
    protected float mStrokeLineSelectedWidth = 2.0f;
    protected float mStrokeLineWidth = 1.0f;
    protected float mTextBottomLinePadding = 8.0f;
    protected Rect mTextHeight = new Rect();

    public interface OnOtpEnteredListener {
        void onOtpCompleted(CharSequence charSequence);
    }

    public interface OnTextChangedListener {
        void onTextChanged();

        void onTextPasted();
    }

    public void setError(CharSequence charSequence) {
    }

    public void setError(CharSequence charSequence, Drawable drawable) {
    }

    public OtpEditText(Context context) {
        super(context);
    }

    public OtpEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    public void setMaxLength(int i2) {
        this.mMaxCharLength = i2;
        this.mAllowedNumChars = (float) i2;
        this.mCharDrawSize = new float[((int) this.mAllowedNumChars)];
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        setText((CharSequence) null);
        invalidate();
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    /* JADX INFO: finally extract failed */
    private void init(Context context, AttributeSet attributeSet) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mStrokeLineWidth *= f2;
        this.mStrokeLineSelectedWidth *= f2;
        this.mCharsSpace *= f2;
        this.mTextBottomLinePadding = f2 * this.mTextBottomLinePadding;
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OtpEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(R.styleable.OtpEditText_otpInputAnimStyle, typedValue);
            this.mInputAnimationType = typedValue.data;
            obtainStyledAttributes.getValue(R.styleable.OtpEditText_otpErrorAnimStyle, typedValue);
            this.mErrorAnimationType = typedValue.data;
            this.mStrokeLineWidth = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineHeight, this.mStrokeLineWidth);
            this.mStrokeLineSelectedWidth = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineSelectedHeight, this.mStrokeLineSelectedWidth);
            this.mCharsSpace = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpCharacterSpacing, this.mCharsSpace);
            this.mTextBottomLinePadding = obtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpTextBottomLinePadding, this.mTextBottomLinePadding);
            this.mIsCharInSquare = obtainStyledAttributes.getBoolean(R.styleable.OtpEditText_otpBackgroundIsSquare, this.mIsCharInSquare);
            this.mCharBackground = obtainStyledAttributes.getDrawable(R.styleable.OtpEditText_otpBackgroundDrawable);
            this.mOtpErrorColor = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpErrorTextColor, -7829368);
            this.mLineErrorTextColor = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineErrorColor, getTextColors().getColorForState(new int[]{16842914}, Color.parseColor("#fd5c5c")));
            this.mLineFocusedColor = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineFocusedColor, getTextColors().getColorForState(new int[]{16842908}, -12303292));
            this.mLineNextCharColor = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineNextCharColor, getTextColors().getColorForState(new int[]{16842908}, -12303292));
            this.mLineUnFocusedColor = obtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineUnFocusedColor, getTextColors().getColorForState(new int[]{16842914}, -7829368));
            obtainStyledAttributes.recycle();
            this.mCharPaint = new Paint(getPaint());
            this.mLastCharPaint = new Paint(getPaint());
            this.mLinesPaint = new Paint(getPaint());
            this.mLinesPaint.setStrokeWidth(this.mStrokeLineWidth);
            setBackgroundResource(0);
            this.mMaxCharLength = attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "maxLength", 6);
            this.mAllowedNumChars = (float) this.mMaxCharLength;
            this.mCharDrawSize = new float[((int) this.mAllowedNumChars)];
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
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.mClickListener != null) {
                        OtpEditText.this.mClickListener.onClick(view);
                    }
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.mLongClickListener == null) {
                        return false;
                    }
                    return OtpEditText.this.mLongClickListener.onLongClick(view);
                }
            });
            if ((getInputType() & 128) == 128) {
                this.mMask = "●";
            } else if ((getInputType() & 16) == 16) {
                this.mMask = "●";
            }
            if (!TextUtils.isEmpty(this.mMask)) {
                this.mMaskChars = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.mTextHeight);
            this.mAnimateOnInput = this.mInputAnimationType >= 0;
            if (this.mErrorAnimationType >= 0) {
                z = true;
            }
            this.mAnimateOnError = z;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        super.onSizeChanged(i2, i3, i4, i5);
        this.mOriginalTextColors = getTextColors();
        ColorStateList colorStateList = this.mOriginalTextColors;
        if (colorStateList != null) {
            this.mLastCharPaint.setColor(colorStateList.getDefaultColor());
            this.mCharPaint.setColor(this.mOriginalTextColors.getDefaultColor());
        }
        int width = (getWidth() - u.n(this)) - u.m(this);
        float f3 = this.mCharsSpace;
        if (f3 < 0.0f) {
            this.mCharSize = ((float) width) / ((this.mAllowedNumChars * 2.0f) - 1.0f);
        } else {
            float f4 = this.mAllowedNumChars;
            this.mCharSize = ((((float) width) - (f3 * (f4 - 1.0f))) / f4) + ((float) convertDpToPixel(2));
        }
        float f5 = this.mAllowedNumChars;
        this.mLineCoords = new RectF[((int) f5)];
        this.mCharBottom = new float[((int) f5)];
        int height = getHeight() - getPaddingBottom();
        int i7 = 1;
        if (f.a(Locale.getDefault()) == 1) {
            i7 = -1;
            i6 = (int) (((float) (getWidth() - u.m(this))) - this.mCharSize);
        } else {
            i6 = u.m(this) + convertDpToPixel(2);
        }
        for (int i8 = 0; ((float) i8) < this.mAllowedNumChars; i8++) {
            float f6 = (float) i6;
            float f7 = (float) height;
            this.mLineCoords[i8] = new RectF(f6, f7, this.mCharSize + f6, f7);
            if (this.mCharBackground != null) {
                if (this.mIsCharInSquare) {
                    this.mLineCoords[i8].top = (float) getPaddingTop();
                    RectF[] rectFArr = this.mLineCoords;
                    rectFArr[i8].right = rectFArr[i8].height() + f6;
                } else {
                    this.mLineCoords[i8].top -= ((float) this.mTextHeight.height()) + (this.mTextBottomLinePadding * 2.0f);
                }
            }
            float f8 = this.mCharsSpace;
            if (f8 < 0.0f) {
                f2 = f6 + (((float) i7) * this.mCharSize * 2.0f);
            } else {
                f2 = f6 + (((float) i7) * (this.mCharSize + f8));
            }
            i6 = (int) f2;
            this.mCharBottom[i8] = this.mLineCoords[i8].bottom - this.mTextBottomLinePadding;
        }
    }

    private int convertDpToPixel(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getContext().getApplicationContext().getResources().getDisplayMetrics());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() is not allowed.");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = this.mCharDrawSize;
        if (length > fArr.length) {
            length = fArr.length;
        }
        int i2 = length;
        getPaint().getTextWidths(fullText, 0, i2, this.mCharDrawSize);
        int i3 = 0;
        while (((float) i3) < this.mAllowedNumChars) {
            if (this.mCharBackground != null) {
                boolean z = true;
                boolean z2 = i3 < i2;
                if (i3 != i2) {
                    z = false;
                }
                updateDrawableState(z2, z);
                this.mCharBackground.setBounds((int) this.mLineCoords[i3].left, (int) this.mLineCoords[i3].top, (int) this.mLineCoords[i3].right, (int) this.mLineCoords[i3].bottom);
                this.mCharBackground.draw(canvas);
            }
            float f2 = this.mLineCoords[i3].left + (this.mCharSize / 2.0f);
            if (i2 > i3) {
                if (!this.mAnimateOnInput || i3 != i2 - 1) {
                    canvas.drawText(fullText, i3, i3 + 1, f2 - (this.mCharDrawSize[i3] / 2.0f), this.mCharBottom[i3], this.mCharPaint);
                } else {
                    canvas.drawText(fullText, i3, i3 + 1, f2 - (this.mCharDrawSize[i3] / 2.0f), this.mCharBottom[i3], this.mLastCharPaint);
                }
            }
            if (this.mCharBackground == null) {
                updateColorForLines(i3, i2);
                canvas.drawLine(this.mLineCoords[i3].left, this.mLineCoords[i3].top, this.mLineCoords[i3].right, this.mLineCoords[i3].bottom, this.mLinesPaint);
            }
            i3++;
        }
    }

    private CharSequence getFullText() {
        if (this.mMask == null) {
            return getText();
        }
        return getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.mMaskChars == null) {
            this.mMaskChars = new StringBuilder();
        }
        int length = getText().length();
        while (this.mMaskChars.length() != length) {
            if (this.mMaskChars.length() < length) {
                this.mMaskChars.append(this.mMask);
            } else {
                StringBuilder sb = this.mMaskChars;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return this.mMaskChars;
    }

    private void updateColorForLines(int i2, int i3) {
        int i4;
        if (this.mHasError) {
            this.mLinesPaint.setColor(this.mLineErrorTextColor);
        } else if (isFocused()) {
            this.mLinesPaint.setStrokeWidth(this.mStrokeLineSelectedWidth);
            if (i2 == i3 || (i3 == (i4 = this.mMaxCharLength) && i2 == i4 - 1 && this.isActive)) {
                this.mLinesPaint.setColor(this.mLineNextCharColor);
            } else if (i2 < i3) {
                this.mLinesPaint.setColor(this.mLineFocusedColor);
            } else {
                this.mLinesPaint.setColor(this.mLineUnFocusedColor);
            }
        } else {
            this.mLinesPaint.setStrokeWidth(this.mStrokeLineWidth);
            this.mLinesPaint.setColor(this.mLineUnFocusedColor);
        }
    }

    /* access modifiers changed from: protected */
    public void updateDrawableState(boolean z, boolean z2) {
        if (this.mHasError) {
            this.mCharBackground.setState(new int[]{16842914});
        } else if (isFocused()) {
            this.mCharBackground.setState(new int[]{16842908});
            if (z2) {
                this.mCharBackground.setState(new int[]{16842908, 16842913});
            } else if (z) {
                this.mCharBackground.setState(new int[]{16842908, 16842912});
            }
        } else {
            this.mCharBackground.setState(new int[]{-16842908});
        }
    }

    public void setError(boolean z) {
        this.mHasError = z;
    }

    public boolean isError() {
        return this.mHasError;
    }

    public void focus() {
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public boolean onTextContextMenuItem(int i2) {
        OnTextChangedListener onTextChangedListener;
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908322 && (onTextChangedListener = this.mOnTextChangedListener) != null) {
            onTextChangedListener.onTextPasted();
        }
        return onTextContextMenuItem;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.mOnTextChangedListener = onTextChangedListener;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        setError(false);
        OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged();
        }
        if (this.mActivateError || this.mHasError) {
            this.mActivateError = false;
            this.mHasError = false;
            ColorStateList colorStateList = this.mOriginalTextColors;
            if (colorStateList != null) {
                this.mLastCharPaint.setColor(colorStateList.getDefaultColor());
                this.mCharPaint.setColor(this.mOriginalTextColors.getDefaultColor());
            }
        }
        if (this.mLineCoords != null && this.mAnimateOnInput) {
            int i5 = this.mInputAnimationType;
            if (i5 == -1) {
                invalidate();
            } else if (i4 <= i3) {
            } else {
                if (i5 == 0) {
                    animatePopIn();
                } else {
                    animateBottomUp(charSequence, i2);
                }
            }
        } else if (this.mOnPinEnteredListener != null && charSequence.length() == this.mMaxCharLength) {
            this.mOnPinEnteredListener.onOtpCompleted(charSequence);
        }
    }

    private void animatePopIn() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, getPaint().getTextSize()});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mLastCharPaint.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                OtpEditText.this.invalidate();
            }
        });
        if (getText().length() == this.mMaxCharLength && this.mOnPinEnteredListener != null) {
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    OtpEditText.this.mOnPinEnteredListener.onOtpCompleted(OtpEditText.this.getText());
                }
            });
        }
        ofFloat.start();
    }

    private void animateBottomUp(CharSequence charSequence, final int i2) {
        this.mCharBottom[i2] = this.mLineCoords[i2].bottom - this.mTextBottomLinePadding;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mCharBottom[i2] + getPaint().getTextSize(), this.mCharBottom[i2]});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mCharBottom[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OtpEditText.this.invalidate();
            }
        });
        this.mLastCharPaint.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, PriceRangeSeekBar.INVALID_POINTER_ID});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mLastCharPaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.mMaxCharLength && this.mOnPinEnteredListener != null) {
            animatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    OtpEditText.this.mOnPinEnteredListener.onOtpCompleted(OtpEditText.this.getText());
                }
            });
        }
        animatorSet.playTogether(new Animator[]{ofFloat, ofInt});
        animatorSet.start();
    }

    public void animateText(boolean z) {
        this.mAnimateOnInput = z;
    }

    public void setOnPinEnteredListener(OnOtpEnteredListener onOtpEnteredListener) {
        this.mOnPinEnteredListener = onOtpEnteredListener;
    }

    public CharSequence getError() {
        return super.getError();
    }

    public void activateOtpError() {
        this.mActivateError = true;
        this.mHasError = true;
        this.mCharPaint.setColor(this.mOtpErrorColor);
        this.mLastCharPaint.setColor(this.mOtpErrorColor);
        invalidate();
        if (!this.mAnimateOnError) {
            return;
        }
        if (this.mErrorAnimationType == 0) {
            animateShakeOnError();
        } else {
            animateBounceOnError();
        }
    }

    private void animateShakeOnError() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f})});
        animatorSet.start();
    }

    private void animateBounceOnError() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, 0.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f})});
        animatorSet.start();
    }
}

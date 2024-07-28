package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.f.c;
import androidx.core.graphics.d;
import androidx.core.h.t;
import androidx.core.widget.b;
import androidx.core.widget.i;
import androidx.core.widget.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements t, b, k {
    private final d mBackgroundTintHelper;
    private Future<c> mPrecomputedTextFuture;
    private final k mTextClassifierHelper;
    private final l mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.mBackgroundTintHelper = new d(this);
        this.mBackgroundTintHelper.a(attributeSet, i2);
        this.mTextHelper = new l(this);
        this.mTextHelper.a(attributeSet, i2);
        this.mTextHelper.a();
        this.mTextClassifierHelper = new k(this);
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.d();
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.b();
        }
    }

    public void setTextSize(int i2, float f2) {
        if (f3188d) {
            super.setTextSize(i2, f2);
            return;
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a(i2, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.mTextHelper != null && !f3188d && this.mTextHelper.f1759a.b()) {
            this.mTextHelper.f1759a.a();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (f3188d) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a(i2);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (f3188d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (f3188d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a(iArr, i2);
        }
    }

    public int getAutoSizeTextType() {
        if (!f3188d) {
            l lVar = this.mTextHelper;
            if (lVar != null) {
                return lVar.f1759a.f1775a;
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f3188d) {
            return super.getAutoSizeStepGranularity();
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1776b);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f3188d) {
            return super.getAutoSizeMinTextSize();
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1777c);
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f3188d) {
            return super.getAutoSizeMaxTextSize();
        }
        l lVar = this.mTextHelper;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1778d);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f3188d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        l lVar = this.mTextHelper;
        return lVar != null ? lVar.f1759a.f1779e : new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            i.b(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            i.c(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        i.d(this, i2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }

    public c.a getTextMetricsParamsCompat() {
        return i.c(this);
    }

    public void setPrecomputedText(c cVar) {
        i.a((TextView) this, cVar);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                i.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        k kVar;
        if (Build.VERSION.SDK_INT >= 28 || (kVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            kVar.f1757a = textClassifier;
        }
    }

    public TextClassifier getTextClassifier() {
        k kVar;
        if (Build.VERSION.SDK_INT >= 28 || (kVar = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return kVar.a();
    }

    public void setTextFuture(Future<c> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i2, i3);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = a.b(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? a.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? a.b(context, i4) : null;
        if (i5 != 0) {
            drawable = a.b(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        l lVar = this.mTextHelper;
        if (lVar != null) {
            lVar.a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.c();
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.a(colorStateList);
        this.mTextHelper.a();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.d();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.a(mode);
        this.mTextHelper.a();
    }

    public void setTypeface(Typeface typeface, int i2) {
        Typeface a2 = (typeface == null || i2 <= 0) ? null : d.a(getContext(), typeface, i2);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i2);
    }

    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        int i2;
        if (Build.VERSION.SDK_INT >= 18) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.f2941b;
            if (!(textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
                if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                    i2 = 2;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                    i2 = 3;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                    i2 = 4;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                    i2 = 5;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                    i2 = 6;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                    i2 = 7;
                }
                setTextDirection(i2);
            }
            i2 = 1;
            setTextDirection(i2);
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.f2940a.getTextScaleX();
            getPaint().set(aVar.f2940a);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(aVar.f2940a);
        setBreakStrategy(aVar.f2942c);
        setHyphenationFrequency(aVar.f2943d);
    }
}

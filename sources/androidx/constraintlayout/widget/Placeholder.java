package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;

public class Placeholder extends View {

    /* renamed from: a  reason: collision with root package name */
    int f2502a = -1;

    /* renamed from: b  reason: collision with root package name */
    View f2503b = null;

    /* renamed from: c  reason: collision with root package name */
    int f2504c = 4;

    public Placeholder(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f2504c);
        this.f2502a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f2502a = obtainStyledAttributes.getResourceId(index, this.f2502a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f2504c = obtainStyledAttributes.getInt(index, this.f2504c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f2504c = i2;
    }

    public int getEmptyVisibility() {
        return this.f2504c;
    }

    public View getContent() {
        return this.f2503b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(Constants.EASY_PAY_VISIBLE_ASSIST, Constants.EASY_PAY_VISIBLE_ASSIST, Constants.EASY_PAY_VISIBLE_ASSIST);
            Paint paint = new Paint();
            paint.setARGB(PriceRangeSeekBar.INVALID_POINTER_ID, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f2502a != i2) {
            View view = this.f2503b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.f2503b.getLayoutParams()).ab = false;
                this.f2503b = null;
            }
            this.f2502a = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }
}

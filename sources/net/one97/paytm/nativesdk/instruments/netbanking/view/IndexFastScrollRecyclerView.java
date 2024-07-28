package net.one97.paytm.nativesdk.instruments.netbanking.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.nativesdk.R;

public class IndexFastScrollRecyclerView extends RecyclerView {
    private boolean mEnabled = true;
    private GestureDetector mGestureDetector = null;
    public int mIndexBarCornerRadius = 5;
    public float mIndexBarTransparentValue = 0.6f;
    public String mIndexbarBackgroudColor = "#000000";
    public String mIndexbarHighLateTextColor = "#000000";
    public float mIndexbarMargin = 5.0f;
    public String mIndexbarTextColor = "#FFFFFF";
    public float mIndexbarWidth = 20.0f;
    public int mPreviewPadding = 5;
    private IndexFastScrollRecyclerSection mScroller = null;
    public int setIndexTextSize = 12;

    public IndexFastScrollRecyclerView(Context context) {
        super(context);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public IndexFastScrollRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.mScroller = new IndexFastScrollRecyclerSection(context, this);
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndexFastScrollRecyclerView, 0, 0)) != null) {
            try {
                this.setIndexTextSize = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexTextSize, this.setIndexTextSize);
                this.mIndexbarWidth = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarWidth, this.mIndexbarWidth);
                this.mIndexbarMargin = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexbarMargin, this.mIndexbarMargin);
                this.mPreviewPadding = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setPreviewPadding, this.mPreviewPadding);
                this.mIndexBarCornerRadius = obtainStyledAttributes.getInt(R.styleable.IndexFastScrollRecyclerView_setIndexBarCornerRadius, this.mIndexBarCornerRadius);
                this.mIndexBarTransparentValue = obtainStyledAttributes.getFloat(R.styleable.IndexFastScrollRecyclerView_setIndexBarTransparentValue, this.mIndexBarTransparentValue);
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor) != null) {
                    this.mIndexbarBackgroudColor = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarColor);
                }
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor) != null) {
                    this.mIndexbarTextColor = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarTextColor);
                }
                if (obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor) != null) {
                    this.mIndexbarHighLateTextColor = obtainStyledAttributes.getString(R.styleable.IndexFastScrollRecyclerView_setIndexBarHighlightTextColor);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
            if (indexFastScrollRecyclerSection != null && indexFastScrollRecyclerSection.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.mGestureDetector == null) {
                this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                        return super.onFling(motionEvent, motionEvent2, f2, f3);
                    }
                });
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection;
        if (!this.mEnabled || (indexFastScrollRecyclerSection = this.mScroller) == null || !indexFastScrollRecyclerSection.contains(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAdapter(RecyclerView.a aVar) {
        super.setAdapter(aVar);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.setAdapter(aVar);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        IndexFastScrollRecyclerSection indexFastScrollRecyclerSection = this.mScroller;
        if (indexFastScrollRecyclerSection != null) {
            indexFastScrollRecyclerSection.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void setIndexTextSize(int i2) {
        this.mScroller.setIndexTextSize(i2);
    }

    public void setIndexbarWidth(float f2) {
        this.mScroller.setIndexbarWidth(f2);
    }

    public void setCustomIndexbarHeight(float f2) {
        this.mScroller.setCustomIndexbarHeight(f2);
    }

    public void setIndexbarTopMargin(float f2) {
        this.mScroller.setIndexbarTopMargin(f2);
    }

    public void setIndexbarMargin(float f2) {
        this.mScroller.setIndexbarMargin(f2);
    }

    public void setPreviewPadding(int i2) {
        this.mScroller.setPreviewPadding(i2);
    }

    public void setIndexBarCornerRadius(int i2) {
        this.mScroller.setIndexBarCornerRadius(i2);
    }

    public void setIndexBarTransparentValue(float f2) {
        this.mScroller.setIndexBarTransparentValue(f2);
    }

    public void setTypeface(Typeface typeface) {
        this.mScroller.setTypeface(typeface);
    }

    public void setIndexBarVisibility(boolean z) {
        this.mScroller.setIndexBarVisibility(z);
        this.mEnabled = z;
    }

    public void setPreviewVisibility(boolean z) {
        this.mScroller.setPreviewVisibility(z);
    }

    public void setIndexBarColor(String str) {
        this.mScroller.setIndexBarColor(str);
    }

    public void setIndexBarTextColor(String str) {
        this.mScroller.setIndexBarTextColor(str);
    }

    public void setIndexbarHighLateTextColor(String str) {
        this.mScroller.setIndexBarHighLateTextColor(str);
    }

    public void setIndexBarHighLateTextVisibility(boolean z) {
        this.mScroller.setIndexBarHighLateTextVisibility(z);
    }
}

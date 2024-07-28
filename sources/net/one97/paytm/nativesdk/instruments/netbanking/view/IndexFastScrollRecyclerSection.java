package net.one97.paytm.nativesdk.instruments.netbanking.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SectionIndexer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IndexFastScrollRecyclerSection extends RecyclerView.c {
    private static final int WHAT_FADE_PREVIEW = 1;
    AttributeSet attrs;
    private int indexPaintPaintColor = -1;
    private int indexbarBackgroudAlpha;
    private String indexbarBackgroudColor;
    private String indexbarHighLateTextColor;
    private String indexbarTextColor;
    private int mCurrentSection = -1;
    private float mCustomIndexbarHeight;
    private float mDensity;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                IndexFastScrollRecyclerSection.this.mRecyclerView.invalidate();
            }
        }
    };
    private float mIndexbarMargin;
    private float mIndexbarMarginTop = 150.0f;
    private RectF mIndexbarRect;
    private float mIndexbarWidth;
    private SectionIndexer mIndexer = null;
    private boolean mIsIndexing = false;
    private int mListViewHeight;
    private int mListViewWidth;
    private float mPreviewPadding;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView = null;
    private float mScaledDensity;
    private String[] mSections = null;
    private boolean previewVisibility = true;
    private int setIndexBarCornerRadius;
    private Boolean setIndexBarVisibility = Boolean.TRUE;
    private int setIndexTextSize;
    private float setIndexbarMargin;
    private float setIndexbarWidth;
    private int setPreviewPadding;
    private Boolean setSetIndexBarHighLateTextVisibility = Boolean.FALSE;
    private Typeface setTypeface = null;

    private int convertTransparentValueToBackgroundAlpha(float f2) {
        return (int) (f2 * 255.0f);
    }

    public IndexFastScrollRecyclerSection(Context context, IndexFastScrollRecyclerView indexFastScrollRecyclerView) {
        this.setIndexTextSize = indexFastScrollRecyclerView.setIndexTextSize;
        this.setIndexbarWidth = indexFastScrollRecyclerView.mIndexbarWidth;
        this.setIndexbarMargin = indexFastScrollRecyclerView.mIndexbarMargin;
        this.setPreviewPadding = indexFastScrollRecyclerView.mPreviewPadding;
        this.setIndexBarCornerRadius = indexFastScrollRecyclerView.mIndexBarCornerRadius;
        this.indexbarBackgroudColor = indexFastScrollRecyclerView.mIndexbarBackgroudColor;
        this.indexbarTextColor = indexFastScrollRecyclerView.mIndexbarTextColor;
        this.indexbarHighLateTextColor = indexFastScrollRecyclerView.mIndexbarHighLateTextColor;
        this.indexbarBackgroudAlpha = convertTransparentValueToBackgroundAlpha(indexFastScrollRecyclerView.mIndexBarTransparentValue);
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        this.mRecyclerView = indexFastScrollRecyclerView;
        setAdapter(this.mRecyclerView.getAdapter());
        float f2 = this.setIndexbarWidth;
        float f3 = this.mDensity;
        this.mIndexbarWidth = f2 * f3;
        this.mIndexbarMargin = this.setIndexbarMargin * f3;
        this.mPreviewPadding = ((float) this.setPreviewPadding) * f3;
    }

    public void draw(Canvas canvas) {
        float f2;
        int i2;
        if (this.setIndexBarVisibility.booleanValue()) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.indexbarBackgroudColor));
            paint.setAlpha(this.indexbarBackgroudAlpha);
            paint.setAntiAlias(true);
            if (this.mIndexbarRect == null) {
                this.mIndexbarRect = new RectF();
            }
            RectF rectF = this.mIndexbarRect;
            int i3 = this.setIndexBarCornerRadius;
            float f3 = this.mDensity;
            canvas.drawRoundRect(rectF, ((float) i3) * f3, ((float) i3) * f3, paint);
            String[] strArr = this.mSections;
            if (strArr != null && strArr.length > 0) {
                if (this.previewVisibility && (i2 = this.mCurrentSection) >= 0 && i2 < strArr.length && strArr[i2] != "") {
                    Paint paint2 = new Paint();
                    paint2.setColor(-16777216);
                    paint2.setAlpha(96);
                    paint2.setAntiAlias(true);
                    paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                    Paint paint3 = new Paint();
                    paint3.setColor(-1);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(this.mScaledDensity * 50.0f);
                    paint3.setTypeface(this.setTypeface);
                    float measureText = paint3.measureText(this.mSections[this.mCurrentSection]);
                    float descent = ((this.mPreviewPadding * 2.0f) + paint3.descent()) - paint3.ascent();
                    int i4 = this.mListViewWidth;
                    int i5 = this.mListViewHeight;
                    RectF rectF2 = new RectF((((float) i4) - descent) / 2.0f, (((float) i5) - descent) / 2.0f, ((((float) i4) - descent) / 2.0f) + descent, ((((float) i5) - descent) / 2.0f) + descent);
                    float f4 = this.mDensity;
                    canvas.drawRoundRect(rectF2, f4 * 5.0f, f4 * 5.0f, paint2);
                    canvas.drawText(this.mSections[this.mCurrentSection], (rectF2.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF2.top + this.mPreviewPadding) - paint3.ascent()) + 1.0f, paint3);
                    fade(300);
                }
                Paint paint4 = new Paint();
                paint4.setColor(Color.parseColor(this.indexbarTextColor));
                paint4.setAntiAlias(true);
                paint4.setTextSize(((float) this.setIndexTextSize) * this.mScaledDensity);
                paint4.setTypeface(this.setTypeface);
                float f5 = this.mCustomIndexbarHeight;
                if (f5 == 0.0f) {
                    f2 = (this.mIndexbarRect.height() - (this.mIndexbarMargin * 2.0f)) / 26.0f;
                } else {
                    f2 = f5 * this.mScaledDensity;
                }
                float descent2 = (f2 - (paint4.descent() - paint4.ascent())) / 2.0f;
                for (int i6 = 0; i6 < this.mSections.length; i6++) {
                    if (this.setSetIndexBarHighLateTextVisibility.booleanValue()) {
                        int i7 = this.mCurrentSection;
                        if (i7 < 0 || i6 != i7) {
                            paint4.setTypeface(this.setTypeface);
                            paint4.setTextSize(((float) this.setIndexTextSize) * this.mScaledDensity);
                            paint4.setColor(Color.parseColor(this.indexbarTextColor));
                        } else {
                            paint4.setTypeface(Typeface.create(this.setTypeface, 1));
                            paint4.setTextSize(((float) (this.setIndexTextSize + 3)) * this.mScaledDensity);
                            paint4.setColor(Color.parseColor(this.indexbarHighLateTextColor));
                        }
                        canvas.drawText(this.mSections[i6], this.mIndexbarRect.left + ((this.mIndexbarWidth - paint4.measureText(this.mSections[i6])) / 2.0f), (((this.mIndexbarRect.top + this.mIndexbarMargin) + (((float) i6) * f2)) + descent2) - paint4.ascent(), paint4);
                    } else {
                        canvas.drawText(this.mSections[i6], this.mIndexbarRect.left + ((this.mIndexbarWidth - paint4.measureText(this.mSections[i6])) / 2.0f), (((this.mIndexbarRect.top + this.mIndexbarMargin) + (((float) i6) * f2)) + descent2) - paint4.ascent(), paint4);
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.mIsIndexing) {
                    if (contains(motionEvent.getX(), motionEvent.getY())) {
                        this.mCurrentSection = getSectionByPoint(motionEvent.getY());
                        int i2 = this.mCurrentSection;
                        String[] strArr = this.mSections;
                        if (i2 > strArr.length - 1) {
                            this.mCurrentSection = strArr.length - 1;
                        }
                        scrollToPosition();
                    }
                    return true;
                }
            } else if (this.mIsIndexing) {
                this.mIsIndexing = false;
                this.mCurrentSection = -1;
            }
        } else if (this.mSections != null && contains(motionEvent.getX(), motionEvent.getY())) {
            this.mIsIndexing = true;
            this.mCurrentSection = getSectionByPoint(motionEvent.getY());
            int i3 = this.mCurrentSection;
            String[] strArr2 = this.mSections;
            if (i3 > strArr2.length - 1) {
                this.mCurrentSection = strArr2.length - 1;
            }
            scrollToPosition();
            return true;
        }
        return false;
    }

    private void scrollToPosition() {
        try {
            int positionForSection = this.mIndexer.getPositionForSection(this.mCurrentSection);
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(positionForSection, 0);
            } else {
                layoutManager.scrollToPosition(positionForSection);
            }
        } catch (Exception unused) {
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.mListViewWidth = i2;
        this.mListViewHeight = i3;
        float f2 = (float) i2;
        float f3 = this.mIndexbarMargin;
        this.mIndexbarRect = new RectF((f2 - f3) - this.mIndexbarWidth, this.mIndexbarMarginTop, f2 - f3, ((float) i3) - f3);
    }

    public void setAdapter(RecyclerView.a aVar) {
        if (aVar instanceof SectionIndexer) {
            aVar.registerAdapterDataObserver(this);
            this.mIndexer = (SectionIndexer) aVar;
            this.mSections = (String[]) this.mIndexer.getSections();
        }
    }

    public void onChanged() {
        super.onChanged();
        this.mSections = (String[]) this.mIndexer.getSections();
    }

    public boolean contains(float f2, float f3) {
        return f2 >= this.mIndexbarRect.left && f3 >= this.mIndexbarRect.top && f3 <= this.mIndexbarRect.top + this.mIndexbarRect.height();
    }

    private int getSectionByPoint(float f2) {
        String[] strArr = this.mSections;
        if (strArr == null || strArr.length == 0 || f2 < this.mIndexbarRect.top + this.mIndexbarMargin) {
            return 0;
        }
        if (f2 >= (this.mIndexbarRect.top + this.mIndexbarRect.height()) - this.mIndexbarMargin) {
            return this.mSections.length - 1;
        }
        return (int) (((f2 - this.mIndexbarRect.top) - this.mIndexbarMargin) / ((this.mIndexbarRect.height() - (this.mIndexbarMargin * 2.0f)) / 26.0f));
    }

    private void fade(long j) {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageAtTime(1, SystemClock.uptimeMillis() + j);
    }

    public void setIndexTextSize(int i2) {
        this.setIndexTextSize = i2;
    }

    public void setIndexbarWidth(float f2) {
        this.mIndexbarWidth = f2;
    }

    public void setCustomIndexbarHeight(float f2) {
        this.mCustomIndexbarHeight = f2;
    }

    public void setIndexbarTopMargin(float f2) {
        this.mIndexbarMarginTop = f2;
    }

    public void setIndexbarMargin(float f2) {
        this.mIndexbarMargin = f2;
    }

    public void setPreviewPadding(int i2) {
        this.setPreviewPadding = i2;
    }

    public void setIndexBarCornerRadius(int i2) {
        this.setIndexBarCornerRadius = i2;
    }

    public void setIndexBarTransparentValue(float f2) {
        this.indexbarBackgroudAlpha = convertTransparentValueToBackgroundAlpha(f2);
    }

    public void setTypeface(Typeface typeface) {
        this.setTypeface = typeface;
    }

    public void setIndexBarVisibility(boolean z) {
        this.setIndexBarVisibility = Boolean.valueOf(z);
    }

    public void setPreviewVisibility(boolean z) {
        this.previewVisibility = z;
    }

    public void setIndexBarColor(String str) {
        this.indexbarBackgroudColor = str;
    }

    public void setIndexBarTextColor(String str) {
        this.indexbarTextColor = str;
    }

    public void setIndexBarHighLateTextColor(String str) {
        this.indexbarHighLateTextColor = str;
    }

    public void setIndexBarHighLateTextVisibility(boolean z) {
        this.setSetIndexBarHighLateTextVisibility = Boolean.valueOf(z);
    }
}

package com.paytm.android.chat.IndexBar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytm.android.chat.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public class IndexBar extends View {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f41015a = {"A", "B", AppConstants.FEED_COMMUNITY, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, "E", AppConstants.FEED_SUB_TYPE, "G", "H", AppConstants.IMAGE_SUBTYPE, "J", AppConstants.THOUSANDS, "L", "M", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, "O", AppConstants.FEED_COMMUNITY_POST, "Q", "R", "S", "T", AppConstants.USER_SUB_TYPE, "V", AppConstants.CAROUSEL_SUB_TYPE, "X", "Y", "Z", "#"};

    /* renamed from: b  reason: collision with root package name */
    private List<String> f41016b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41017c;

    /* renamed from: d  reason: collision with root package name */
    private int f41018d;

    /* renamed from: e  reason: collision with root package name */
    private int f41019e;

    /* renamed from: f  reason: collision with root package name */
    private int f41020f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f41021g;

    /* renamed from: h  reason: collision with root package name */
    private int f41022h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f41023i;
    private List<? extends com.paytm.android.chat.IndexBar.a.a> j;
    /* access modifiers changed from: private */
    public LinearLayoutManager k;
    private a l;

    public interface a {
        void a();

        void a(String str);
    }

    public IndexBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public IndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndexBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        int applyDimension = (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics());
        this.f41022h = -16777216;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.IndexBar, i2, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.IndexBar_indexBarTextSize) {
                applyDimension = obtainStyledAttributes.getDimensionPixelSize(index, applyDimension);
            } else if (index == R.styleable.IndexBar_indexBarPressBackground) {
                this.f41022h = obtainStyledAttributes.getColor(index, this.f41022h);
            }
        }
        obtainStyledAttributes.recycle();
        if (!this.f41017c) {
            this.f41016b = Arrays.asList(f41015a);
        }
        this.f41021g = new Paint();
        this.f41021g.setAntiAlias(true);
        this.f41021g.setTextSize((float) applyDimension);
        this.f41021g.setColor(-16777216);
        setmOnIndexPressedListener(new a() {
            public final void a(String str) {
                int a2;
                if (IndexBar.this.f41023i != null) {
                    IndexBar.this.f41023i.setVisibility(0);
                    IndexBar.this.f41023i.setText(str);
                }
                if (IndexBar.this.k != null && (a2 = IndexBar.a(IndexBar.this, str)) != -1) {
                    IndexBar.this.k.scrollToPositionWithOffset(a2, 0);
                }
            }

            public final void a() {
                if (IndexBar.this.f41023i != null) {
                    IndexBar.this.f41023i.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        Rect rect = new Rect();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.f41016b.size(); i6++) {
            String str = this.f41016b.get(i6);
            this.f41021g.getTextBounds(str, 0, str.length(), rect);
            i5 = Math.max(rect.width(), i5);
            i4 = Math.max(rect.width(), i4);
        }
        int size3 = this.f41016b.size() * i4;
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(i5, size);
        } else if (mode != 1073741824) {
            size = i5;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size3, size2);
        } else if (mode2 != 1073741824) {
            size2 = size3;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int paddingTop = getPaddingTop();
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.f41016b.size(); i2++) {
            String str = this.f41016b.get(i2);
            this.f41021g.getTextBounds(str, 0, str.length(), rect);
            Paint.FontMetrics fontMetrics = this.f41021g.getFontMetrics();
            canvas.drawText(str, (float) ((this.f41018d / 2) - (rect.width() / 2)), (float) ((this.f41020f * i2) + paddingTop + ((int) (((((float) this.f41020f) - fontMetrics.bottom) - fontMetrics.top) / 2.0f))), this.f41021g);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(this.f41022h);
        } else if (action != 2) {
            setBackgroundResource(17170445);
            a aVar = this.l;
            if (aVar != null) {
                aVar.a();
            }
            return true;
        }
        int y = (int) ((motionEvent.getY() - ((float) getPaddingTop())) / ((float) this.f41020f));
        if (y < 0) {
            y = 0;
        } else if (y >= this.f41016b.size()) {
            y = this.f41016b.size() - 1;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.a(this.f41016b.get(y));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        List<String> list = this.f41016b;
        if (list != null && !list.isEmpty()) {
            this.f41018d = i2;
            this.f41019e = i3;
            this.f41020f = ((this.f41019e - getPaddingTop()) - getPaddingBottom()) / this.f41016b.size();
        }
    }

    public a getmOnIndexPressedListener() {
        return this.l;
    }

    public void setmOnIndexPressedListener(a aVar) {
        this.l = aVar;
    }

    static /* synthetic */ int a(IndexBar indexBar, String str) {
        List<? extends com.paytm.android.chat.IndexBar.a.a> list = indexBar.j;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < indexBar.j.size(); i2++) {
                if (str.equals(((com.paytm.android.chat.IndexBar.a.a) indexBar.j.get(i2)).f41014a)) {
                    return i2;
                }
            }
        }
        return -1;
    }
}

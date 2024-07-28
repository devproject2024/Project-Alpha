package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected String f2461a = null;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2462b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f2463c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private Paint f2464d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private boolean f2465e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2466f = true;

    /* renamed from: g  reason: collision with root package name */
    private Rect f2467g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private int f2468h = Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 0, 0, 0);

    /* renamed from: i  reason: collision with root package name */
    private int f2469i = Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 200, 200, 200);
    private int j = Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, 50, 50, 50);
    private int k = 4;

    public MockView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.f2461a = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f2465e = obtainStyledAttributes.getBoolean(index, this.f2465e);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f2468h = obtainStyledAttributes.getColor(index, this.f2468h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.j = obtainStyledAttributes.getColor(index, this.j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f2469i = obtainStyledAttributes.getColor(index, this.f2469i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f2466f = obtainStyledAttributes.getBoolean(index, this.f2466f);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f2461a == null) {
            try {
                this.f2461a = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f2462b.setColor(this.f2468h);
        this.f2462b.setAntiAlias(true);
        this.f2463c.setColor(this.f2469i);
        this.f2463c.setAntiAlias(true);
        this.f2464d.setColor(this.j);
        this.k = Math.round(((float) this.k) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2465e) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f2, f3, this.f2462b);
            Canvas canvas2 = canvas;
            float f4 = f2;
            canvas2.drawLine(0.0f, f3, f4, 0.0f, this.f2462b);
            canvas2.drawLine(0.0f, 0.0f, f4, 0.0f, this.f2462b);
            float f5 = f2;
            float f6 = f3;
            canvas2.drawLine(f5, 0.0f, f4, f6, this.f2462b);
            float f7 = f3;
            canvas2.drawLine(f5, f7, 0.0f, f6, this.f2462b);
            canvas2.drawLine(0.0f, f7, 0.0f, 0.0f, this.f2462b);
        }
        String str = this.f2461a;
        if (str != null && this.f2466f) {
            this.f2463c.getTextBounds(str, 0, str.length(), this.f2467g);
            float width2 = ((float) (width - this.f2467g.width())) / 2.0f;
            float height2 = (((float) (height - this.f2467g.height())) / 2.0f) + ((float) this.f2467g.height());
            this.f2467g.offset((int) width2, (int) height2);
            Rect rect = this.f2467g;
            rect.set(rect.left - this.k, this.f2467g.top - this.k, this.f2467g.right + this.k, this.f2467g.bottom + this.k);
            canvas.drawRect(this.f2467g, this.f2464d);
            canvas.drawText(this.f2461a, width2, height2, this.f2463c);
        }
    }
}

package net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.a.a;
import net.one97.paytm.paymentsBank.utils.photocrop.photoview.d;

public class CropOverlayView extends View implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private int f19534a = H5PullContainer.DEFALUT_DURATION;

    /* renamed from: b  reason: collision with root package name */
    private Paint f19535b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f19536c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19537d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19538e;

    /* renamed from: f  reason: collision with root package name */
    private int f19539f;

    /* renamed from: g  reason: collision with root package name */
    private int f19540g;

    /* renamed from: h  reason: collision with root package name */
    private int f19541h;

    /* renamed from: i  reason: collision with root package name */
    private int f19542i;
    private Context j;
    private Path k;
    private RectF l;
    private float m;

    public CropOverlayView(Context context) {
        super(context);
        a(context);
        this.j = context;
    }

    /* JADX INFO: finally extract failed */
    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropOverlayView, 0, 0);
        try {
            this.f19537d = obtainStyledAttributes.getBoolean(R.styleable.CropOverlayView_guideLines, false);
            this.f19538e = obtainStyledAttributes.getBoolean(R.styleable.CropOverlayView_drawCircle, false);
            this.f19539f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_marginTop, 100);
            this.f19540g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CropOverlayView_marginSide, 50);
            this.f19541h = obtainStyledAttributes.getColor(R.styleable.CropOverlayView_borderColor, -1);
            this.f19542i = obtainStyledAttributes.getColor(R.styleable.CropOverlayView_overlayColor, -1);
            this.m = obtainStyledAttributes.getDimension(R.styleable.CropOverlayView_cornerRadius, 6.0f);
            obtainStyledAttributes.recycle();
            a(context);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19538e) {
            float coordinate = (a.LEFT.getCoordinate() + a.RIGHT.getCoordinate()) / 2.0f;
            float coordinate2 = (a.TOP.getCoordinate() + a.BOTTOM.getCoordinate()) / 2.0f;
            float coordinate3 = (a.RIGHT.getCoordinate() - a.LEFT.getCoordinate()) / 2.0f;
            this.k.addCircle(coordinate, coordinate2, coordinate3, Path.Direction.CW);
            canvas.clipPath(this.k, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f19542i);
            if (Build.VERSION.SDK_INT < 23) {
                canvas.restore();
            }
            canvas.drawCircle(coordinate, coordinate2, coordinate3, this.f19535b);
        } else {
            float applyDimension = TypedValue.applyDimension(1, this.m, this.j.getResources().getDisplayMetrics());
            this.k.addRoundRect(this.l, applyDimension, applyDimension, Path.Direction.CW);
            canvas.clipPath(this.k, Region.Op.DIFFERENCE);
            canvas.drawColor(this.f19542i);
            if (Build.VERSION.SDK_INT < 23) {
                canvas.restore();
            }
            canvas.drawRoundRect(this.l, applyDimension, applyDimension, this.f19535b);
        }
        if (this.f19537d) {
            float coordinate4 = a.LEFT.getCoordinate();
            float coordinate5 = a.TOP.getCoordinate();
            float coordinate6 = a.RIGHT.getCoordinate();
            float coordinate7 = a.BOTTOM.getCoordinate();
            float width = a.getWidth() / 3.0f;
            float f2 = coordinate4 + width;
            Canvas canvas2 = canvas;
            float f3 = coordinate5;
            float f4 = coordinate7;
            canvas2.drawLine(f2, f3, f2, f4, this.f19536c);
            float f5 = coordinate6 - width;
            canvas2.drawLine(f5, f3, f5, f4, this.f19536c);
            float height = a.getHeight() / 3.0f;
            float f6 = coordinate5 + height;
            Canvas canvas3 = canvas;
            float f7 = coordinate4;
            float f8 = coordinate6;
            canvas3.drawLine(f7, f6, f8, f6, this.f19536c);
            float f9 = coordinate7 - height;
            canvas3.drawLine(f7, f9, f8, f9, this.f19536c);
        }
    }

    public Rect getImageBounds() {
        return new Rect((int) a.LEFT.getCoordinate(), (int) a.TOP.getCoordinate(), (int) a.RIGHT.getCoordinate(), (int) a.BOTTOM.getCoordinate());
    }

    private void a(Context context) {
        this.k = new Path();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = this.f19540g;
        int i4 = i2 - (i3 * 2);
        int i5 = this.f19539f;
        int i6 = i5 + i4;
        int i7 = i4 + i3;
        net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.b.a.b().setColor(this.f19542i);
        this.f19535b = net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.b.a.a(context);
        this.f19535b.setColor(this.f19541h);
        this.f19536c = net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.b.a.a();
        a.TOP.setCoordinate((float) i5);
        a.BOTTOM.setCoordinate((float) i6);
        a.LEFT.setCoordinate((float) i3);
        a.RIGHT.setCoordinate((float) i7);
        new Rect(i3, i5, i7, i6);
        new Rect(i3, i5, i7, i6);
        this.l = new RectF(a.LEFT.getCoordinate(), a.TOP.getCoordinate(), a.RIGHT.getCoordinate(), a.BOTTOM.getCoordinate());
    }
}

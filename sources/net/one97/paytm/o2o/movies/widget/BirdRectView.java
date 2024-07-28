package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.paytm.utility.q;
import net.one97.paytm.o2o.movies.R;

public class BirdRectView extends View {

    /* renamed from: e  reason: collision with root package name */
    private static final String f76105e = BirdRectView.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public int f76106a;

    /* renamed from: b  reason: collision with root package name */
    public final int f76107b;

    /* renamed from: c  reason: collision with root package name */
    public int f76108c;

    /* renamed from: d  reason: collision with root package name */
    public int f76109d;

    /* renamed from: f  reason: collision with root package name */
    private Paint f76110f = new Paint();

    public BirdRectView(Context context, int i2, int i3) {
        super(context);
        this.f76106a = i2;
        this.f76107b = i3;
        this.f76110f.setColor(context.getResources().getColor(R.color.red));
        this.f76110f.setStyle(Paint.Style.STROKE);
        this.f76110f.setStrokeWidth(2.0f);
        this.f76108c = 0;
        this.f76109d = 0;
    }

    public void setRectH(int i2) {
        q.d("prev " + this.f76106a + " new " + i2);
        this.f76106a = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.f76108c;
        int i3 = this.f76109d;
        canvas.drawRect((float) i2, (float) i3, (float) (i2 + this.f76107b), (float) (i3 + this.f76106a), this.f76110f);
    }
}

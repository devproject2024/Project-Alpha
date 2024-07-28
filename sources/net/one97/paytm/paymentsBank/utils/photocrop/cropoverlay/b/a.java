package net.one97.paytm.paymentsBank.utils.photocrop.cropoverlay.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

public final class a {
    public static Paint a(Context context) {
        float applyDimension = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        paint.setStrokeWidth(applyDimension);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    public static Paint a() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AAFFFFFF"));
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public static Paint b() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#B029303F"));
        return paint;
    }
}

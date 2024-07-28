package net.one97.paytm.fastag.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;

public class RoundedRectangularImageView extends ImageView {
    public RoundedRectangularImageView(Context context) {
        super(context);
    }

    public RoundedRectangularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundedRectangularImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public RoundedRectangularImageView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void setImageDrawable(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        b a2 = d.a(getResources(), bitmap);
        a2.a(((float) bitmap.getWidth()) * 0.1f);
        super.setImageDrawable(a2);
    }
}

package net.one97.paytm.recharge.automatic.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;

public final class CJRAutomaticDisabledView extends AppCompatTextView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRAutomaticDisabledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
        setCompoundDrawablesWithIntrinsicBounds(f.b().a(context, R.drawable.ic_utility_automatic_disabled), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}

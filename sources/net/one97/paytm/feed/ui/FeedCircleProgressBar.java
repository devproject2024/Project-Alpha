package net.one97.paytm.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.b.f;
import net.one97.paytm.feed.R;

public class FeedCircleProgressBar extends ProgressBar {
    public FeedCircleProgressBar(Context context) {
        super(context);
        setStyle(context);
    }

    public FeedCircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setStyle(context);
    }

    public FeedCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStyle(context);
    }

    private void setStyle(Context context) {
        setIndeterminateDrawable(f.a(context.getResources(), R.drawable.feed_cricle_progress, (Resources.Theme) null));
    }
}

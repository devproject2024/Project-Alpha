package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.o2o.movies.R;

public class CJRMoviePaymentSummaryItem extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f75883a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f75884b;

    public CJRMoviePaymentSummaryItem(Context context, boolean z) {
        super(context);
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.movie_order_payment_summary_title, this);
            a(false);
            return;
        }
        a(context);
    }

    public CJRMoviePaymentSummaryItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CJRMoviePaymentSummaryItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.movie_order_payment_summary_amount_layout, this);
        a(true);
    }

    private void a(boolean z) {
        this.f75883a = (RoboTextView) findViewById(R.id.titleTv);
        if (z) {
            this.f75884b = (RoboTextView) findViewById(R.id.valueTv);
        }
    }

    public void setData(String str, String str2) {
        RoboTextView roboTextView;
        if (!TextUtils.isEmpty(str)) {
            this.f75883a.setText(str);
        }
        if (!TextUtils.isEmpty(str2) && (roboTextView = this.f75884b) != null) {
            roboTextView.setText(str2);
        }
    }
}

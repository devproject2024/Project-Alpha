package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.o2o.movies.R;

public class CJRMovieOrderPaymentItemView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f75880a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f75881b;

    /* renamed from: c  reason: collision with root package name */
    private Context f75882c;

    public CJRMovieOrderPaymentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CJRMovieOrderPaymentItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.movie_order_payment_item, this);
        b(context);
    }

    private void b(Context context) {
        this.f75882c = context;
        this.f75880a = (RoboTextView) findViewById(R.id.paymentTypeTv);
        this.f75881b = (RoboTextView) findViewById(R.id.paymentAmountTv);
    }

    public void setData(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f75880a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f75881b.setText(str2);
        }
    }
}

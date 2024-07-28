package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppUtility;
import net.one97.paytm.o2o.movies.R;

public class CJRDisclaimerView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f75876a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f75877b;

    /* renamed from: c  reason: collision with root package name */
    private Context f75878c;

    public CJRDisclaimerView(Context context) {
        super(context);
        a(context);
    }

    public CJRDisclaimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CJRDisclaimerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.disclaimer_item_layout, this);
        this.f75878c = context;
        a();
    }

    private void a() {
        this.f75876a = (TextView) findViewById(R.id.countTv);
        this.f75877b = (TextView) findViewById(R.id.disclaimerTv);
    }

    public void setData(int i2, String str) {
        TextView textView = this.f75876a;
        textView.setText(i2 + AppUtility.CENTER_DOT);
        if (!TextUtils.isEmpty(str)) {
            this.f75877b.setText(str);
        }
    }
}

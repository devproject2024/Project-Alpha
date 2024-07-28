package com.travel.flight.flightorder.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.flight.R;

public class NotificationView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f24587a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24588b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f24589c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f24590d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f24591e;

    public interface a {
        void setNotificationViewClick(View view);
    }

    public NotificationView(Context context) {
        super(context);
        a(context);
    }

    public NotificationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public NotificationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pre_f_cart_view, this, true);
        this.f24590d = (ImageView) findViewById(R.id.icon_cart);
        this.f24590d.setBackgroundResource(R.drawable.pre_f_ic_cart_dark_smiley);
        this.f24587a = (TextView) findViewById(R.id.txt_number_of_items_in_cart);
        this.f24588b = (TextView) findViewById(R.id.txt_number_of_items_in_cart_decoy);
        this.f24589c = (RelativeLayout) findViewById(R.id.container_cart_icon);
        this.f24589c.setClickable(true);
        this.f24589c.setBackgroundColor(0);
        this.f24589c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NotificationView.this.f24591e.setNotificationViewClick(view);
            }
        });
    }
}

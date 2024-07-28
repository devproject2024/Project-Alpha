package com.travel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.R;

public class NotificationView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28581a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28582b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f28583c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f28584d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f28585e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28586f;

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
        LayoutInflater.from(context).inflate(R.layout.pre_td_cart_view, this, true);
        this.f28584d = (ImageView) findViewById(R.id.icon_cart);
        this.f28584d.setBackgroundResource(R.drawable.pre_td_ic_cart_dark_smiley);
        this.f28586f = true;
        this.f28581a = (TextView) findViewById(R.id.txt_number_of_items_in_cart);
        this.f28582b = (TextView) findViewById(R.id.txt_number_of_items_in_cart_decoy);
        this.f28583c = (RelativeLayout) findViewById(R.id.container_cart_icon);
        this.f28583c.setClickable(true);
        this.f28583c.setBackgroundColor(0);
        this.f28583c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NotificationView.this.f28585e.setNotificationViewClick(view);
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        ((RelativeLayout.LayoutParams) this.f28581a.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f28582b.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f28584d.getLayoutParams()).addRule(15);
    }

    public void setNotificationTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28581a.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f28582b.getLayoutParams();
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f28583c.setBackgroundResource(i2);
    }

    public void setMainLayoutTag(String str) {
        this.f28583c.setTag(str);
    }

    public String getMainLayoutTag() {
        return (String) this.f28583c.getTag();
    }

    public void setImageBackground(int i2) {
        this.f28584d.setBackgroundResource(i2);
    }

    public void setNotificationTextBackground(int i2) {
        this.f28581a.setBackgroundResource(i2);
    }

    public void setNotificationTextColor(int i2) {
        this.f28581a.setTextColor(i2);
    }

    public void setNotificationText(String str, int i2) {
        if (str == null || str.trim().length() <= 0) {
            setNotificationTextVisibility(8);
            return;
        }
        setNotificationTextVisibility(0);
        this.f28581a.setText(str);
        this.f28582b.setText(str);
        int i3 = i2 / 4;
        setNotificationTextMargin(0, i3, i3, 0);
    }

    public void setNotificationTextVisibility(int i2) {
        this.f28581a.setVisibility(i2);
        this.f28582b.setVisibility(i2);
        ImageView imageView = this.f28584d;
        if (imageView == null) {
            return;
        }
        if (i2 == 0) {
            if (this.f28586f) {
                imageView.setBackgroundResource(R.drawable.pre_td_ic_cart_dark_smiley);
            } else {
                imageView.setBackgroundResource(R.drawable.pre_td_ic_cart_white_smiley);
            }
        } else if (this.f28586f) {
            imageView.setBackgroundResource(R.drawable.pre_td_ic_cart_dark_smiley);
        } else {
            imageView.setBackgroundResource(R.drawable.pre_td_mybag_icon);
        }
    }

    public void setOnNotificationViewClickListener(a aVar) {
        this.f28585e = aVar;
    }

    public void setWhiteThemeforCartIcon() {
        this.f28584d.setBackgroundResource(R.drawable.pre_td_ic_cart_white_smiley);
    }

    public void setWhiteBagIcon() {
        this.f28586f = false;
        TextView textView = this.f28581a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f28584d.setBackgroundResource(R.drawable.pre_td_mybag_icon);
        } else {
            this.f28584d.setBackgroundResource(R.drawable.pre_td_ic_cart_white_smiley);
        }
    }

    public void setDarkThemeforCartIcon() {
        this.f28586f = true;
        TextView textView = this.f28581a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f28584d.setBackgroundResource(R.drawable.pre_td_ic_cart_dark);
        } else {
            this.f28584d.setBackgroundResource(R.drawable.pre_td_ic_cart_dark_smiley);
        }
    }
}

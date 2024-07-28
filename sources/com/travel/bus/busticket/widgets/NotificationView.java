package com.travel.bus.busticket.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.bus.R;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;

public class NotificationView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f22509a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22510b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f22511c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f22512d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f22513e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22514f;

    public interface a {
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
        LayoutInflater.from(context).inflate(R.layout.pre_b_cart_view, this, true);
        this.f22512d = (ImageView) findViewById(R.id.icon_cart);
        ResourceUtils.loadBusImagesFromCDN(this.f22512d, "ic_cart_dark_smiley.png", false, false, n.a.V1);
        this.f22514f = true;
        this.f22509a = (TextView) findViewById(R.id.txt_number_of_items_in_cart);
        this.f22510b = (TextView) findViewById(R.id.txt_number_of_items_in_cart_decoy);
        this.f22511c = (RelativeLayout) findViewById(R.id.container_cart_icon);
        this.f22511c.setClickable(true);
        this.f22511c.setBackgroundColor(0);
        this.f22511c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a unused = NotificationView.this.f22513e;
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        ((RelativeLayout.LayoutParams) this.f22509a.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f22510b.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f22512d.getLayoutParams()).addRule(15);
    }

    public void setNotificationTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22509a.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22510b.getLayoutParams();
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f22511c.setBackgroundResource(i2);
    }

    public void setMainLayoutTag(String str) {
        this.f22511c.setTag(str);
    }

    public String getMainLayoutTag() {
        return (String) this.f22511c.getTag();
    }

    public void setImageBackground(int i2) {
        this.f22512d.setBackgroundResource(i2);
    }

    public void setNotificationTextBackground(int i2) {
        this.f22509a.setBackgroundResource(i2);
    }

    public void setNotificationTextColor(int i2) {
        this.f22509a.setTextColor(i2);
    }

    public void setNotificationText(String str, int i2) {
        if (str == null || str.trim().length() <= 0) {
            setNotificationTextVisibility(8);
            return;
        }
        setNotificationTextVisibility(0);
        this.f22509a.setText(str);
        this.f22510b.setText(str);
        int i3 = i2 / 4;
        setNotificationTextMargin(0, i3, i3, 0);
    }

    public void setNotificationTextVisibility(int i2) {
        this.f22509a.setVisibility(i2);
        this.f22510b.setVisibility(i2);
        ImageView imageView = this.f22512d;
        if (imageView == null) {
            return;
        }
        if (i2 == 0) {
            if (this.f22514f) {
                ResourceUtils.loadBusImagesFromCDN(imageView, "ic_cart_dark_smiley.png", false, false, n.a.V1);
            } else {
                ResourceUtils.loadBusImagesFromCDN(imageView, "ic_cart_white_smiley.png", false, false, n.a.V1);
            }
        } else if (this.f22514f) {
            ResourceUtils.loadBusImagesFromCDN(imageView, "ic_cart_dark_smiley.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadBusImagesFromCDN(imageView, "mybag_icon.png", false, false, n.a.V1);
        }
    }

    public void setOnNotificationViewClickListener(a aVar) {
        this.f22513e = aVar;
    }

    public void setWhiteThemeforCartIcon() {
        ResourceUtils.loadBusImagesFromCDN(this.f22512d, "ic_cart_white_smiley.png", false, false, n.a.V1);
    }

    public void setWhiteBagIcon() {
        this.f22514f = false;
        TextView textView = this.f22509a;
        if (textView == null || textView.getVisibility() != 0) {
            ResourceUtils.loadBusImagesFromCDN(this.f22512d, "mybag_icon.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadBusImagesFromCDN(this.f22512d, "ic_cart_white_smiley.png", false, false, n.a.V1);
        }
    }

    public void setDarkThemeforCartIcon() {
        this.f22514f = true;
        TextView textView = this.f22509a;
        if (textView == null || textView.getVisibility() != 0) {
            ResourceUtils.loadBusImagesFromCDN(this.f22512d, "ic_cart_dark.png", false, false, n.a.V1);
        } else {
            ResourceUtils.loadBusImagesFromCDN(this.f22512d, "ic_cart_dark_smiley.png", false, false, n.a.V1);
        }
    }
}

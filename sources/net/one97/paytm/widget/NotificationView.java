package net.one97.paytm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.paytm_finance.R;

public class NotificationView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f72348a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f72349b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f72350c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f72351d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f72352e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f72353f;

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
        LayoutInflater.from(context).inflate(R.layout.cart_view, this, true);
        this.f72351d = (ImageView) findViewById(R.id.icon_cart);
        this.f72351d.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        this.f72353f = true;
        this.f72348a = (TextView) findViewById(R.id.txt_number_of_items_in_cart);
        this.f72349b = (TextView) findViewById(R.id.txt_number_of_items_in_cart_decoy);
        this.f72350c = (RelativeLayout) findViewById(R.id.container_cart_icon);
        this.f72350c.setClickable(true);
        this.f72350c.setBackgroundColor(0);
        this.f72350c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NotificationView.this.f72352e.setNotificationViewClick(view);
            }
        });
    }

    public void setMainLayoutParams(int i2, int i3) {
        ((RelativeLayout.LayoutParams) this.f72348a.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f72349b.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f72351d.getLayoutParams()).addRule(15);
    }

    public void setNotificationTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f72348a.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f72349b.getLayoutParams();
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f72350c.setBackgroundResource(i2);
    }

    public void setMainLayoutTag(String str) {
        this.f72350c.setTag(str);
    }

    public String getMainLayoutTag() {
        return (String) this.f72350c.getTag();
    }

    public void setImageBackground(int i2) {
        this.f72351d.setBackgroundResource(i2);
    }

    public void setNotificationTextBackground(int i2) {
        this.f72348a.setBackgroundResource(i2);
    }

    public void setNotificationTextColor(int i2) {
        this.f72348a.setTextColor(i2);
    }

    public void setNotificationText(String str, int i2) {
        if (str == null || str.trim().length() <= 0) {
            setNotificationTextVisibility(8);
            return;
        }
        setNotificationTextVisibility(0);
        this.f72348a.setText(str);
        this.f72349b.setText(str);
        int i3 = i2 / 4;
        setNotificationTextMargin(0, i3, i3, 0);
    }

    public void setNotificationTextVisibility(int i2) {
        this.f72348a.setVisibility(i2);
        this.f72349b.setVisibility(i2);
        ImageView imageView = this.f72351d;
        if (imageView == null) {
            return;
        }
        if (i2 == 0) {
            if (this.f72353f) {
                imageView.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
            } else {
                imageView.setBackgroundResource(R.drawable.ic_cart_white_smiley);
            }
        } else if (this.f72353f) {
            imageView.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        } else {
            imageView.setBackgroundResource(R.drawable.mybag_icon);
        }
    }

    public void setOnNotificationViewClickListener(a aVar) {
        this.f72352e = aVar;
    }

    public void setWhiteThemeforCartIcon() {
        this.f72351d.setBackgroundResource(R.drawable.ic_cart_white_smiley);
    }

    public void setWhiteBagIcon() {
        this.f72353f = false;
        TextView textView = this.f72348a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f72351d.setBackgroundResource(R.drawable.mybag_icon);
        } else {
            this.f72351d.setBackgroundResource(R.drawable.ic_cart_white_smiley);
        }
    }

    public void setDarkThemeforCartIcon() {
        this.f72353f = true;
        TextView textView = this.f72348a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f72351d.setBackgroundResource(R.drawable.ic_cart_dark);
        } else {
            this.f72351d.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        }
    }
}

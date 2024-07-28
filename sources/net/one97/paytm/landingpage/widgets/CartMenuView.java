package net.one97.paytm.landingpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.utils.ag;

public class CartMenuView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f53035a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f53036b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f53037c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f53038d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f53039e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f53040f;

    /* renamed from: g  reason: collision with root package name */
    private Context f53041g;

    public interface a {
        void setCartMenuViewClick(View view);
    }

    public CartMenuView(Context context) {
        super(context);
        this.f53041g = context;
        a(context);
    }

    public CartMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f53041g = context;
        a(context);
    }

    public CartMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f53041g = context;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cart_view, this, true);
        this.f53038d = (ImageView) findViewById(R.id.icon_cart);
        this.f53038d.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        this.f53040f = true;
        this.f53035a = (TextView) findViewById(R.id.txt_number_of_items_in_cart);
        this.f53036b = (TextView) findViewById(R.id.txt_number_of_items_in_cart_decoy);
        this.f53037c = (RelativeLayout) findViewById(R.id.container_cart_icon);
        this.f53037c.setClickable(true);
        this.f53037c.setBackgroundColor(0);
        this.f53037c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CartMenuView.this.f53039e.setCartMenuViewClick(view);
            }
        });
    }

    public void setMainLayoutParams() {
        ((RelativeLayout.LayoutParams) this.f53035a.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f53036b.getLayoutParams()).addRule(11);
        ((RelativeLayout.LayoutParams) this.f53038d.getLayoutParams()).addRule(15);
    }

    public void setCartMenuTextMargin(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53035a.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53036b.getLayoutParams();
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.bottomMargin = i5;
    }

    public void setMainLayoutBackground(int i2) {
        this.f53037c.setBackgroundResource(i2);
    }

    public void setMainLayoutTag(String str) {
        this.f53037c.setTag(str);
    }

    public String getMainLayoutTag() {
        return (String) this.f53037c.getTag();
    }

    public void setImageBackground(int i2) {
        this.f53038d.setBackgroundResource(i2);
    }

    public void setCartMenuTextBackground(int i2) {
        this.f53035a.setBackgroundResource(i2);
    }

    public void setCartMenuTextColor(int i2) {
        this.f53035a.setTextColor(i2);
    }

    public void setCartMenuText(String str, int i2) {
        if (str == null || str.trim().length() <= 0) {
            setCartMenuTextVisibility(8);
            return;
        }
        setCartMenuTextVisibility(0);
        this.f53035a.setText(str);
        this.f53036b.setText(str);
        int i3 = i2 / 4;
        setCartMenuTextMargin(0, i3, i3, 0);
    }

    public void setCartMenuTextVisibility(int i2) {
        this.f53035a.setVisibility(i2);
        this.f53036b.setVisibility(i2);
        if (ag.a(this.f53041g.getApplicationContext()).b("cart_item_qty", 0, true) > 0) {
            this.f53035a.setVisibility(0);
            this.f53036b.setVisibility(0);
        } else {
            this.f53035a.setVisibility(8);
            this.f53036b.setVisibility(8);
        }
        ImageView imageView = this.f53038d;
        if (imageView == null) {
            return;
        }
        if (i2 == 0) {
            if (this.f53040f) {
                imageView.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
            } else {
                imageView.setBackgroundResource(R.drawable.ic_cart_white_smiley);
            }
        } else if (this.f53040f) {
            imageView.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        } else {
            imageView.setBackgroundResource(R.drawable.mybag_icon);
        }
    }

    public void setOnCartMenuClickListener(a aVar) {
        this.f53039e = aVar;
    }

    public void setWhiteThemeforCartIcon() {
        this.f53038d.setBackgroundResource(R.drawable.ic_cart_white_smiley);
    }

    public void setWhiteBagIcon() {
        this.f53040f = false;
        TextView textView = this.f53035a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f53038d.setBackgroundResource(R.drawable.mybag_icon);
        } else {
            this.f53038d.setBackgroundResource(R.drawable.ic_cart_white_smiley);
        }
    }

    public void setDarkThemeforCartIcon() {
        this.f53040f = true;
        TextView textView = this.f53035a;
        if (textView == null || textView.getVisibility() != 0) {
            this.f53038d.setBackgroundResource(R.drawable.ic_cart_dark);
        } else {
            this.f53038d.setBackgroundResource(R.drawable.ic_cart_dark_smiley);
        }
    }
}

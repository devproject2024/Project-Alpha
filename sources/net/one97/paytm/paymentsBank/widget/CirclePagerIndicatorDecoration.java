package net.one97.paytm.paymentsBank.widget;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import net.one97.paytm.paymentsBank.R;

public class CirclePagerIndicatorDecoration extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f19620a;

    /* renamed from: b  reason: collision with root package name */
    private int f19621b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<ImageView> f19622c;

    public CirclePagerIndicatorDecoration(Context context, int i2) {
        super(context);
        this.f19620a = context;
        this.f19621b = i2;
        setGravity(17);
        this.f19622c = new ArrayList<>(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            ImageView imageView = new ImageView(this.f19620a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 25, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.pb_circle_bg_deselect);
            this.f19622c.add(imageView);
            addView(imageView);
        }
        setIndicator(0);
    }

    public void setIndicator(int i2) {
        for (int i3 = 0; i3 < this.f19621b; i3++) {
            ImageView imageView = this.f19622c.get(i3);
            if (i2 == i3) {
                imageView.setImageResource(R.drawable.bank_circle_bg);
            } else {
                imageView.setImageResource(R.drawable.pb_circle_bg_deselect);
            }
        }
    }
}

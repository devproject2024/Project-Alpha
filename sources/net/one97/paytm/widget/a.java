package net.one97.paytm.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paytm_finance.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    C1466a f72394a;

    /* renamed from: b  reason: collision with root package name */
    int f72395b;

    /* renamed from: c  reason: collision with root package name */
    IJRDataModel f72396c;

    /* renamed from: d  reason: collision with root package name */
    int f72397d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f72398e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f72399f;

    /* renamed from: g  reason: collision with root package name */
    private int f72400g;

    /* renamed from: h  reason: collision with root package name */
    private int f72401h;

    /* renamed from: i  reason: collision with root package name */
    private int f72402i;
    private int j = 8;
    private int k;
    private ArrayList<String> l;
    private LinearLayout m;
    private String n;

    /* renamed from: net.one97.paytm.widget.a$a  reason: collision with other inner class name */
    public interface C1466a {
        void a(int i2, int i3, IJRDataModel iJRDataModel);
    }

    public a(Context context, C1466a aVar, ArrayList<String> arrayList, LinearLayout linearLayout, int i2, int i3, IJRDataModel iJRDataModel, String str) {
        this.l = arrayList;
        this.f72395b = i3;
        this.f72399f = context;
        this.m = linearLayout;
        this.f72398e = LayoutInflater.from(context);
        this.f72394a = aVar;
        this.f72401h = com.paytm.utility.a.t(context);
        int i4 = this.f72401h;
        this.f72400g = i4 / 2;
        this.k = (int) (((double) i4) * 0.5d);
        this.f72402i = i2;
        this.f72396c = iJRDataModel;
        this.n = str;
        a(this.m);
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.f72399f);
        linearLayout2.setOrientation(0);
        LinearLayout linearLayout3 = linearLayout2;
        int i2 = 0;
        for (final int i3 = 0; i3 < this.l.size(); i3++) {
            String str = this.l.get(i3);
            Button button = new Button(this.f72399f);
            button.setText(str);
            button.setTag(str);
            button.setTextColor(this.f72399f.getResources().getColor(R.color.paytm_blue));
            button.setTextSize(2, 13.0f);
            int i4 = this.j;
            button.setPadding(i4, 0, i4, 0);
            button.setTransformationMethod((TransformationMethod) null);
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f72394a.a(i3, a.this.f72395b, a.this.f72396c);
                }
            });
            b.c((TextView) button);
            Rect rect = new Rect();
            button.getPaint().getTextBounds(str, 0, str.length(), rect);
            int width = rect.width();
            int i5 = this.f72402i;
            if (width <= i5) {
                i5 = (this.k * 2) + width + ((int) (((double) this.j) * 2.5d));
            }
            LinearLayout linearLayout4 = new LinearLayout(this.f72399f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout4.setPadding(0, 0, this.k, 0);
            linearLayout4.addView(button, layoutParams);
            button.getLayoutParams().width = i5;
            if (str.equalsIgnoreCase(this.n)) {
                button.setBackgroundResource(0);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.invoice_icon, 0, 0, 0);
            } else {
                button.setBackgroundResource(R.drawable.bg_btn_transaction);
            }
            this.f72397d = (int) ((this.f72399f.getResources().getDisplayMetrics().density * 35.0f) + 0.5f);
            button.getLayoutParams().height = this.f72397d;
            i2 += i5;
            if (i2 >= this.f72402i) {
                if (linearLayout3.getChildCount() > 0) {
                    linearLayout.addView(linearLayout3);
                    linearLayout3 = new LinearLayout(this.f72399f);
                    linearLayout3.setOrientation(0);
                }
                linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(-2, -2));
                int i6 = this.f72402i;
                if (i5 < i6) {
                    i2 = i5;
                } else {
                    button.getLayoutParams().width = i6 - (this.f72400g * 2);
                    linearLayout.addView(linearLayout3);
                    linearLayout3 = new LinearLayout(this.f72399f);
                    linearLayout3.setOrientation(0);
                    i2 = 0;
                }
            } else {
                linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(-2, -2));
            }
        }
        if (linearLayout3.getChildCount() > 0) {
            linearLayout.addView(linearLayout3);
        }
    }
}

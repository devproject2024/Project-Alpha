package net.one97.paytm.passbook.customview;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    C1069a f57200a;

    /* renamed from: b  reason: collision with root package name */
    int f57201b;

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f57202c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f57203d;

    /* renamed from: e  reason: collision with root package name */
    private int f57204e;

    /* renamed from: f  reason: collision with root package name */
    private int f57205f;

    /* renamed from: g  reason: collision with root package name */
    private int f57206g;

    /* renamed from: h  reason: collision with root package name */
    private int f57207h = 8;

    /* renamed from: i  reason: collision with root package name */
    private int f57208i;
    private ArrayList<String> j;
    private LinearLayout k;
    private IJRDataModel l;
    private String m;
    private boolean n;

    /* renamed from: net.one97.paytm.passbook.customview.a$a  reason: collision with other inner class name */
    public interface C1069a {
        void a(int i2, int i3);
    }

    public a(Context context, C1069a aVar, ArrayList<String> arrayList, LinearLayout linearLayout, int i2, int i3, IJRDataModel iJRDataModel, String str) {
        this.j = arrayList;
        this.f57201b = i3;
        this.f57203d = context;
        this.k = linearLayout;
        this.f57202c = LayoutInflater.from(context);
        this.f57200a = aVar;
        this.f57205f = b.f(context);
        int i4 = this.f57205f;
        this.f57204e = i4 / 2;
        this.f57208i = (int) (((double) i4) * 0.5d);
        this.f57206g = i2;
        this.l = iJRDataModel;
        this.m = str;
        this.n = true;
        a(this.k);
    }

    private void a(LinearLayout linearLayout) {
        for (final int i2 = 0; i2 < this.j.size(); i2++) {
            String str = this.j.get(i2);
            TextView textView = (TextView) this.f57202c.inflate(R.layout.pass_passbook_actionbutton, (ViewGroup) null);
            textView.setTransformationMethod((TransformationMethod) null);
            textView.setText(str);
            textView.setTag(str);
            if (str.equalsIgnoreCase(this.m)) {
                textView.setTextColor(this.f57203d.getResources().getColor(R.color.gray));
            } else {
                textView.setTextColor(this.f57203d.getResources().getColor(R.color.paytm_blue));
            }
            textView.setTextSize(2, 13.0f);
            int i3 = this.f57207h;
            textView.setPadding(i3, 0, i3, 0);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f57200a.a(i2, a.this.f57201b);
                }
            });
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            rect.width();
            textView.setBackgroundColor(0);
            textView.setPadding(0, 0, 0, 30);
            linearLayout.addView(textView);
        }
    }
}

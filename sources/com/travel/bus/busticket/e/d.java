package com.travel.bus.busticket.e;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.busticket.widgets.BusHorizontalProgress;
import com.travel.bus.busticket.widgets.BusRatingProgress;
import com.travel.bus.pojo.busticket.a;
import java.math.BigDecimal;

public final class d extends RecyclerView.v {
    public BusHorizontalProgress A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public RoboTextView H;

    /* renamed from: a  reason: collision with root package name */
    public Context f22143a;

    /* renamed from: b  reason: collision with root package name */
    public int f22144b;

    /* renamed from: c  reason: collision with root package name */
    public int f22145c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f22146d;

    /* renamed from: e  reason: collision with root package name */
    public BusRatingProgress f22147e;

    /* renamed from: f  reason: collision with root package name */
    public RoboTextView f22148f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f22149g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f22150h;

    /* renamed from: i  reason: collision with root package name */
    public RoboTextView f22151i;
    public RoboTextView j;
    public BusHorizontalProgress k;
    public RelativeLayout l;
    public RoboTextView m;
    public RoboTextView n;
    public BusHorizontalProgress o;
    public RelativeLayout p;
    public RoboTextView q;
    public RoboTextView r;
    public BusHorizontalProgress s;
    public RelativeLayout t;
    public RoboTextView u;
    public RoboTextView v;
    public BusHorizontalProgress w;
    public RelativeLayout x;
    public RoboTextView y;
    public RoboTextView z;

    public d(View view, Context context) {
        super(view);
        this.f22143a = context;
        this.f22147e = (BusRatingProgress) view.findViewById(R.id.rating_bar_circular);
        this.f22148f = (RoboTextView) view.findViewById(R.id.rating_bar_text);
        this.f22149g = (LinearLayout) view.findViewById(R.id.rating_graph_lyt);
        this.H = (RoboTextView) view.findViewById(R.id.avg_rating);
        this.f22149g.setVisibility(8);
        this.f22147e.setProgress(Float.valueOf(2.0f));
        this.f22147e.setStrokeWidth(20);
    }

    public final int a(int i2) {
        int i3 = this.f22145c;
        if (i3 != 0) {
            return (i2 * 100) / i3;
        }
        return (i2 * 100) / this.f22144b;
    }

    public static float a(float f2) {
        return new BigDecimal((double) f2).setScale(1, 4).floatValue();
    }
}

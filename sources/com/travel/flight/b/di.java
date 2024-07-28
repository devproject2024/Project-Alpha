package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightorder.j.e;
import com.travel.flight.pojo.b;

public abstract class di extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23920a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23921b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23922c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23923d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23924e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f23925f;

    /* renamed from: g  reason: collision with root package name */
    public final RoboTextView f23926g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f23927h;

    /* renamed from: i  reason: collision with root package name */
    protected b f23928i;
    protected e.a j;

    public abstract void a(e.a aVar);

    public abstract void a(b bVar);

    protected di(Object obj, View view, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, View view2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, 0);
        this.f23920a = imageView;
        this.f23921b = imageView2;
        this.f23922c = linearLayout;
        this.f23923d = linearLayout2;
        this.f23924e = view2;
        this.f23925f = roboTextView;
        this.f23926g = roboTextView2;
        this.f23927h = roboTextView3;
    }
}

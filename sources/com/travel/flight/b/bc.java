package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public abstract class bc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f23672a;

    /* renamed from: b  reason: collision with root package name */
    public final RoboTextView f23673b;

    /* renamed from: c  reason: collision with root package name */
    public final View f23674c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23675d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23676e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23677f;

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f23678g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f23679h;

    /* renamed from: i  reason: collision with root package name */
    public final RoboTextView f23680i;
    public final RoboTextView j;
    public final RoboTextView k;
    public final RoboTextView l;
    public final RoboTextView m;
    protected CJRFlightDetailsItem n;
    protected IRTSplitViewModel o;
    protected Boolean p;
    protected Integer q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bc(Object obj, View view, RelativeLayout relativeLayout, RoboTextView roboTextView, View view2, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ConstraintLayout constraintLayout, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, RoboTextView roboTextView6, RoboTextView roboTextView7) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view3 = view;
        this.f23672a = relativeLayout;
        this.f23673b = roboTextView;
        this.f23674c = view2;
        this.f23675d = linearLayout;
        this.f23676e = imageView;
        this.f23677f = linearLayout2;
        this.f23678g = constraintLayout;
        this.f23679h = roboTextView2;
        this.f23680i = roboTextView3;
        this.j = roboTextView4;
        this.k = roboTextView5;
        this.l = roboTextView6;
        this.m = roboTextView7;
    }
}

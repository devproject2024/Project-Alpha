package com.travel.flight.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.travel.flight.flightticket.e.f;
import com.travel.flight.flightticket.k.b;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import java.util.List;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23536a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23537b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23538c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f23539d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f23540e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f23541f;

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f23542g;

    /* renamed from: h  reason: collision with root package name */
    protected b f23543h;

    /* renamed from: i  reason: collision with root package name */
    protected CJRFlightMBChargesRoot f23544i;
    protected List<f> j;

    public abstract void a(b bVar);

    public abstract void a(CJRFlightMBChargesRoot cJRFlightMBChargesRoot);

    public abstract void a(List<f> list);

    protected a(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, ConstraintLayout constraintLayout, FrameLayout frameLayout) {
        super(obj, view, 1);
        this.f23536a = imageView;
        this.f23537b = textView;
        this.f23538c = textView2;
        this.f23539d = lottieAnimationView;
        this.f23540e = recyclerView;
        this.f23541f = constraintLayout;
        this.f23542g = frameLayout;
    }

    public final CJRFlightMBChargesRoot a() {
        return this.f23544i;
    }
}

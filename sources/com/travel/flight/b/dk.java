package com.travel.flight.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.flightorder.j.f;
import com.travel.flight.pojo.CJRHotelOptions;

public abstract class dk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f23929a;

    /* renamed from: b  reason: collision with root package name */
    public final RoboTextView f23930b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f23931c;

    /* renamed from: d  reason: collision with root package name */
    protected CJRHotelOptions f23932d;

    /* renamed from: e  reason: collision with root package name */
    protected f.a f23933e;

    public abstract void a(f.a aVar);

    public abstract void a(CJRHotelOptions cJRHotelOptions);

    protected dk(Object obj, View view, RecyclerView recyclerView, RoboTextView roboTextView, RoboTextView roboTextView2) {
        super(obj, view, 0);
        this.f23929a = recyclerView;
        this.f23930b = roboTextView;
        this.f23931c = roboTextView2;
    }
}

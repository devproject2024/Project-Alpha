package com.travel.flight.flightticket.widget;

import android.content.Context;
import com.travel.flight.flightticket.widget.RangeSeekBarFlight;
import java.lang.Number;

public class DiscreteRangeSeekBarFlight<T extends Number> extends RangeSeekBarFlight<T> {

    /* renamed from: e  reason: collision with root package name */
    private double f25302e;

    /* renamed from: f  reason: collision with root package name */
    private RangeSeekBarFlight.b f25303f;

    public DiscreteRangeSeekBarFlight(T t, T t2, T t3, Context context) throws IllegalArgumentException {
        super(t, t2, context);
        this.f25302e = a(this.f25305a.toNumber(t.doubleValue() + t3.doubleValue()));
    }

    public void setOnRangeSeekBarChangeListener(RangeSeekBarFlight.b<T> bVar) {
        super.setOnRangeSeekBarChangeListener(bVar);
        this.f25303f = bVar;
    }

    public RangeSeekBarFlight.b getCustomRangeSeekBarListener() {
        return this.f25303f;
    }
}

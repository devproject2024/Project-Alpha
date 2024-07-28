package net.one97.paytm.common.widgets;

import java.lang.Number;
import net.one97.paytm.common.widgets.RangeSeekBar;

public class DiscreteRangeSeekBar<T extends Number> extends RangeSeekBar<T> {

    /* renamed from: e  reason: collision with root package name */
    private RangeSeekBar.b f49784e;

    public void setOnRangeSeekBarChangeListener(RangeSeekBar.b<T> bVar) {
        super.setOnRangeSeekBarChangeListener(bVar);
        this.f49784e = bVar;
    }

    public RangeSeekBar.b getCustomRangeSeekBarListener() {
        return this.f49784e;
    }
}

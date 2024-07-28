package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import java.lang.Number;
import net.one97.paytm.o2o.movies.widget.CJRSliderRangeSeekBar;

public class CJRMovieShowTimeRangeSeekBar<T extends Number> extends CJRSliderRangeSeekBar<T> {
    public CJRMovieShowTimeRangeSeekBar(T t, T t2, Context context) throws IllegalArgumentException {
        super(t, t2, context);
    }

    public void setOnRangeSeekBarChangeListener(CJRSliderRangeSeekBar.b<T> bVar) {
        super.setOnRangeSeekBarChangeListener(bVar);
    }

    public final Integer a(Integer num) {
        return (Integer) this.f76145a.toNumber((double) num.intValue());
    }

    public final Long a(Long l) {
        return (Long) this.f76145a.toNumber((double) l.longValue());
    }
}

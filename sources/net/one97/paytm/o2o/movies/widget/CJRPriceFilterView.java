package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.d.f;
import net.one97.paytm.o2o.movies.widget.CJRSliderRangeSeekBar;

public class CJRPriceFilterView extends LinearLayout implements CJRSliderRangeSeekBar.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f76119a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f76120b;

    /* renamed from: c  reason: collision with root package name */
    private a f76121c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f76122d;

    /* renamed from: e  reason: collision with root package name */
    private int f76123e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f76124f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f76125g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f76126h;

    /* renamed from: i  reason: collision with root package name */
    private CJRMovieShowTimeSearchFilterItem f76127i;
    /* access modifiers changed from: private */
    public f j;
    private int[] k;
    private int l;
    private int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    private CJRSliderRangeSeekBar p;
    private Handler q = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                CJRPriceFilterView.this.f76124f.setText(CJRPriceFilterView.this.f76124f.getContext().getString(R.string.rs_showtime_price, new Object[]{String.valueOf(CJRPriceFilterView.this.f76122d)}));
                CJRPriceFilterView cJRPriceFilterView = CJRPriceFilterView.this;
                int unused = cJRPriceFilterView.f76119a = cJRPriceFilterView.f76122d;
            } else if (i2 == 2) {
                CJRPriceFilterView.this.f76125g.setText(CJRPriceFilterView.this.f76125g.getContext().getString(R.string.rs_showtime_price, new Object[]{String.valueOf(CJRPriceFilterView.this.o)}));
                CJRPriceFilterView cJRPriceFilterView2 = CJRPriceFilterView.this;
                int unused2 = cJRPriceFilterView2.f76120b = cJRPriceFilterView2.o;
            }
            boolean unused3 = CJRPriceFilterView.this.f76126h = false;
            if (CJRPriceFilterView.this.j != null) {
                CJRPriceFilterView.this.j.a(CJRPriceFilterView.this.n, CJRPriceFilterView.this.o);
            }
        }
    };

    public CJRPriceFilterView(Context context, f fVar, CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem, CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage) {
        super(context);
        setOrientation(1);
        this.j = fVar;
        this.f76127i = cJRMovieShowTimeSearchFilterItem;
        CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem2 = this.f76127i;
        if (cJRMovieShowTimeSearchFilterItem2 != null && !TextUtils.isEmpty(cJRMovieShowTimeSearchFilterItem2.getMinVal()) && !TextUtils.isEmpty(this.f76127i.getMaxVal())) {
            a();
            CJRMovieShowTimeRangeSeekBar cJRMovieShowTimeRangeSeekBar = new CJRMovieShowTimeRangeSeekBar(Integer.valueOf(this.l), Integer.valueOf(this.m), getContext());
            cJRMovieShowTimeRangeSeekBar.setNotifyWhileDragging(true);
            cJRMovieShowTimeRangeSeekBar.setOnRangeSeekBarChangeListener(this);
            addView(cJRMovieShowTimeRangeSeekBar);
            View inflate = inflate(getContext(), R.layout.slider_min_max_value_view, (ViewGroup) null);
            this.f76124f = (TextView) inflate.findViewById(R.id.min_value);
            this.f76125g = (TextView) inflate.findViewById(R.id.max_value);
            if (cJRMovieShowTimeFilterDataStorage == null || (TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage.f75179a) && TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage.f75180b))) {
                this.f76124f.setText(context.getString(R.string.rs_showtime_price, new Object[]{this.f76127i.getMinVal()}));
                this.f76125g.setText(context.getString(R.string.rs_showtime_price, new Object[]{this.f76127i.getMaxVal()}));
                this.n = Integer.parseInt(this.f76127i.getMinVal());
                this.o = Integer.parseInt(this.f76127i.getMaxVal());
                this.f76119a = this.n;
                this.f76120b = this.o;
            } else {
                if (!TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage.f75179a)) {
                    cJRMovieShowTimeRangeSeekBar.setSelectedMinValue(cJRMovieShowTimeRangeSeekBar.a(Integer.valueOf(Integer.parseInt(cJRMovieShowTimeFilterDataStorage.f75179a))));
                    this.n = Integer.parseInt(cJRMovieShowTimeFilterDataStorage.f75179a);
                    this.f76124f.setText(context.getString(R.string.rs_showtime_price, new Object[]{cJRMovieShowTimeFilterDataStorage.f75179a}));
                    this.f76119a = this.n;
                }
                if (!TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage.f75180b)) {
                    cJRMovieShowTimeRangeSeekBar.setSelectedMaxValue(cJRMovieShowTimeRangeSeekBar.a(Integer.valueOf(Integer.parseInt(cJRMovieShowTimeFilterDataStorage.f75180b))));
                    this.o = Integer.parseInt(cJRMovieShowTimeFilterDataStorage.f75180b);
                    this.f76125g.setText(context.getString(R.string.rs_showtime_price, new Object[]{cJRMovieShowTimeFilterDataStorage.f75180b}));
                    this.f76120b = this.o;
                }
                this.f76126h = true;
            }
            addView(inflate);
            if (this.k.length == 1) {
                cJRMovieShowTimeRangeSeekBar.setClickable(false);
                cJRMovieShowTimeRangeSeekBar.setFocusable(false);
                cJRMovieShowTimeRangeSeekBar.setEnabled(false);
            }
        }
    }

    private void a() {
        try {
            this.l = Integer.parseInt(this.f76127i.getMinVal());
            this.m = Integer.parseInt(this.f76127i.getMaxVal());
            int ceil = ((int) Math.ceil(((double) (this.m - this.l)) / ((double) this.f76127i.getInterval()))) + 1;
            if (ceil <= 0) {
                ceil = 1;
            }
            this.k = new int[ceil];
            for (int i2 = 0; i2 < this.k.length; i2++) {
                int interval = this.l + (this.f76127i.getInterval() * i2);
                if (interval <= this.m) {
                    this.k[i2] = interval;
                } else {
                    this.k[i2] = this.m;
                }
            }
        } catch (Exception unused) {
            if (this.k == null) {
                this.k = new int[1];
            }
        }
    }

    public final void a(CJRSliderRangeSeekBar cJRSliderRangeSeekBar, Object obj, Object obj2) {
        this.p = cJRSliderRangeSeekBar;
        if (((Integer) obj2).intValue() - ((Integer) obj).intValue() >= this.f76127i.getInterval() || this.f76126h) {
            this.f76121c = new a(obj, obj2);
            this.f76121c.start();
            return;
        }
        CJRMovieShowTimeRangeSeekBar cJRMovieShowTimeRangeSeekBar = (CJRMovieShowTimeRangeSeekBar) cJRSliderRangeSeekBar;
        cJRSliderRangeSeekBar.setSelectedMinValue(cJRMovieShowTimeRangeSeekBar.a(Integer.valueOf(this.f76119a)));
        TextView textView = this.f76124f;
        textView.setText(textView.getContext().getString(R.string.rs_showtime_price, new Object[]{String.valueOf(this.f76119a)}));
        cJRSliderRangeSeekBar.setSelectedMaxValue(cJRMovieShowTimeRangeSeekBar.a(Integer.valueOf(this.f76120b)));
        TextView textView2 = this.f76125g;
        textView2.setText(textView2.getContext().getString(R.string.rs_showtime_price, new Object[]{String.valueOf(this.f76120b)}));
    }

    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        Object f76129a;

        /* renamed from: b  reason: collision with root package name */
        Object f76130b;

        public a(Object obj, Object obj2) {
            this.f76130b = obj2;
            this.f76129a = obj;
        }

        public final void run() {
            super.run();
            CJRPriceFilterView.a(CJRPriceFilterView.this, this.f76129a, this.f76130b);
        }
    }

    static /* synthetic */ void a(CJRPriceFilterView cJRPriceFilterView, Object obj, Object obj2) {
        boolean z;
        int i2;
        int i3;
        Integer num = (Integer) obj;
        cJRPriceFilterView.f76122d = num.intValue();
        Integer num2 = (Integer) obj2;
        cJRPriceFilterView.f76123e = num2.intValue();
        int i4 = 0;
        if (cJRPriceFilterView.n != cJRPriceFilterView.f76122d) {
            int i5 = cJRPriceFilterView.l;
            int[] iArr = cJRPriceFilterView.k;
            int length = iArr.length;
            int i6 = i5;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                int i8 = iArr[i7];
                if (cJRPriceFilterView.o - cJRPriceFilterView.f76122d < cJRPriceFilterView.f76127i.getInterval()) {
                    cJRPriceFilterView.f76122d = cJRPriceFilterView.o - cJRPriceFilterView.f76127i.getInterval();
                    int i9 = cJRPriceFilterView.f76122d;
                    int i10 = cJRPriceFilterView.l;
                    if (i9 < i10) {
                        cJRPriceFilterView.f76122d = i10;
                    }
                } else if (cJRPriceFilterView.f76122d > i8 || i8 >= (i3 = cJRPriceFilterView.o)) {
                    i7++;
                    i6 = i8;
                } else if (i3 - i8 < cJRPriceFilterView.f76127i.getInterval()) {
                    cJRPriceFilterView.f76122d = cJRPriceFilterView.o - cJRPriceFilterView.f76127i.getInterval();
                    int i11 = cJRPriceFilterView.f76122d;
                    int i12 = cJRPriceFilterView.l;
                    if (i11 < i12) {
                        cJRPriceFilterView.f76122d = i12;
                    } else if (Math.abs(i11 - num.intValue()) > Math.abs(num.intValue() - i6)) {
                        cJRPriceFilterView.f76122d = i6;
                    }
                } else {
                    cJRPriceFilterView.f76122d = i8;
                }
            }
            cJRPriceFilterView.n = cJRPriceFilterView.f76122d;
            cJRPriceFilterView.q.sendEmptyMessage(1);
            z = true;
        } else {
            z = false;
        }
        if (cJRPriceFilterView.o != cJRPriceFilterView.f76123e) {
            int[] iArr2 = cJRPriceFilterView.k;
            int length2 = iArr2.length;
            int i13 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                int i14 = iArr2[i4];
                if (cJRPriceFilterView.f76123e - cJRPriceFilterView.n < cJRPriceFilterView.f76127i.getInterval()) {
                    cJRPriceFilterView.f76123e = cJRPriceFilterView.n + cJRPriceFilterView.f76127i.getInterval();
                    int i15 = cJRPriceFilterView.f76123e;
                    int i16 = cJRPriceFilterView.m;
                    if (i15 > i16) {
                        cJRPriceFilterView.f76123e = i16;
                    }
                    cJRPriceFilterView.q.sendEmptyMessage(2);
                } else {
                    int i17 = cJRPriceFilterView.f76123e;
                    if (i17 > i14 || i14 <= (i2 = cJRPriceFilterView.n)) {
                        cJRPriceFilterView.o = cJRPriceFilterView.f76123e;
                        i4++;
                        i13 = i14;
                    } else {
                        if (i17 == i14) {
                            cJRPriceFilterView.o = i14;
                        } else if (i13 - i2 < cJRPriceFilterView.f76127i.getInterval()) {
                            cJRPriceFilterView.o = cJRPriceFilterView.n + cJRPriceFilterView.f76127i.getInterval();
                        } else {
                            cJRPriceFilterView.o = i13;
                        }
                        if (Math.abs(cJRPriceFilterView.o - num2.intValue()) > Math.abs(i14 - num2.intValue())) {
                            cJRPriceFilterView.o = i14;
                        }
                        cJRPriceFilterView.q.sendEmptyMessage(2);
                    }
                }
            }
            z = true;
        }
        if (!z) {
            cJRPriceFilterView.n = cJRPriceFilterView.f76122d;
            cJRPriceFilterView.o = cJRPriceFilterView.f76123e;
        }
    }
}

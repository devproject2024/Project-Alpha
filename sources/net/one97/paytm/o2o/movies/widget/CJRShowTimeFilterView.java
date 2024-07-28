package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.d.f;
import net.one97.paytm.o2o.movies.widget.CJRSliderRangeSeekBar;

public class CJRShowTimeFilterView extends LinearLayout implements CJRSliderRangeSeekBar.b {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public long f76132a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public long f76133b;

    /* renamed from: c  reason: collision with root package name */
    long f76134c;

    /* renamed from: d  reason: collision with root package name */
    long f76135d;

    /* renamed from: e  reason: collision with root package name */
    long f76136e;

    /* renamed from: f  reason: collision with root package name */
    long[] f76137f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public long f76138g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public long f76139h;

    /* renamed from: i  reason: collision with root package name */
    long f76140i;
    long j;
    Handler k = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                CJRShowTimeFilterView.this.r.setText(CJRShowTimeFilterView.b(CJRShowTimeFilterView.this.f76132a));
                CJRShowTimeFilterView cJRShowTimeFilterView = CJRShowTimeFilterView.this;
                long unused = cJRShowTimeFilterView.o = cJRShowTimeFilterView.f76132a;
            } else if (i2 == 2) {
                CJRShowTimeFilterView.this.r.setText(CJRShowTimeFilterView.b(CJRShowTimeFilterView.this.f76138g));
                CJRShowTimeFilterView cJRShowTimeFilterView2 = CJRShowTimeFilterView.this;
                long unused2 = cJRShowTimeFilterView2.o = cJRShowTimeFilterView2.f76138g;
            } else if (i2 == 3) {
                CJRShowTimeFilterView.this.s.setText(CJRShowTimeFilterView.b(CJRShowTimeFilterView.this.f76133b));
                CJRShowTimeFilterView cJRShowTimeFilterView3 = CJRShowTimeFilterView.this;
                long unused3 = cJRShowTimeFilterView3.p = cJRShowTimeFilterView3.f76133b;
            } else if (i2 == 4) {
                CJRShowTimeFilterView.this.s.setText(CJRShowTimeFilterView.b(CJRShowTimeFilterView.this.f76139h));
                CJRShowTimeFilterView cJRShowTimeFilterView4 = CJRShowTimeFilterView.this;
                long unused4 = cJRShowTimeFilterView4.p = cJRShowTimeFilterView4.f76139h;
            }
            if (CJRShowTimeFilterView.this.t != null) {
                CJRShowTimeFilterView.this.t.a(Long.valueOf(CJRShowTimeFilterView.this.o), Long.valueOf(CJRShowTimeFilterView.this.p));
            }
        }
    };
    private long l;
    private long m;
    private CJRSliderRangeSeekBar n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public long p;
    private a q;
    /* access modifiers changed from: private */
    public TextView r;
    /* access modifiers changed from: private */
    public TextView s;
    /* access modifiers changed from: private */
    public f t;
    private CJRMovieShowTimeSearchFilterItem u;
    private CJRMovieShowTimeFilterDataStorage v;

    public CJRShowTimeFilterView(Context context, f fVar, CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem, CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage) {
        super(context);
        setOrientation(1);
        this.t = fVar;
        this.u = cJRMovieShowTimeSearchFilterItem;
        this.v = cJRMovieShowTimeFilterDataStorage;
        CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem2 = this.u;
        if (cJRMovieShowTimeSearchFilterItem2 != null && !TextUtils.isEmpty(cJRMovieShowTimeSearchFilterItem2.getMinVal()) && !TextUtils.isEmpty(this.u.getMaxVal())) {
            a();
            CJRMovieShowTimeRangeSeekBar cJRMovieShowTimeRangeSeekBar = new CJRMovieShowTimeRangeSeekBar(Long.valueOf(this.f76135d), Long.valueOf(this.f76136e), getContext());
            cJRMovieShowTimeRangeSeekBar.setNotifyWhileDragging(true);
            cJRMovieShowTimeRangeSeekBar.setOnRangeSeekBarChangeListener(this);
            addView(cJRMovieShowTimeRangeSeekBar);
            View inflate = inflate(getContext(), R.layout.slider_min_max_value_view, (ViewGroup) null);
            this.r = (TextView) inflate.findViewById(R.id.min_value);
            this.s = (TextView) inflate.findViewById(R.id.max_value);
            CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage2 = this.v;
            if (cJRMovieShowTimeFilterDataStorage2 == null || (cJRMovieShowTimeFilterDataStorage2.f75181c == 0 && this.v.f75182d == 0)) {
                this.r.setText(b(a(this.u.getMinVal())));
                this.s.setText(b(a(this.u.getMaxVal())));
                this.f76138g = a(this.u.getMinVal());
                this.f76139h = a(this.u.getMaxVal());
                this.o = this.f76138g;
                this.p = this.f76139h;
            } else {
                if (cJRMovieShowTimeFilterDataStorage.f75181c != 0) {
                    cJRMovieShowTimeRangeSeekBar.setSelectedMinValue(cJRMovieShowTimeRangeSeekBar.a(Long.valueOf(cJRMovieShowTimeFilterDataStorage.f75181c)));
                    this.f76134c = cJRMovieShowTimeFilterDataStorage.f75181c;
                    this.f76138g = cJRMovieShowTimeFilterDataStorage.f75181c;
                    this.r.setText(b(cJRMovieShowTimeFilterDataStorage.f75181c));
                    this.o = cJRMovieShowTimeFilterDataStorage.f75181c;
                } else {
                    this.f76138g = a(this.u.getMinVal());
                    this.r.setText(b(a(this.u.getMinVal())));
                }
                if (cJRMovieShowTimeFilterDataStorage.f75182d != 0) {
                    cJRMovieShowTimeRangeSeekBar.setSelectedMaxValue(cJRMovieShowTimeRangeSeekBar.a(Long.valueOf(cJRMovieShowTimeFilterDataStorage.f75182d)));
                    this.s.setText(b(cJRMovieShowTimeFilterDataStorage.f75182d));
                    this.f76139h = cJRMovieShowTimeFilterDataStorage.f75182d;
                    this.p = cJRMovieShowTimeFilterDataStorage.f75182d;
                } else {
                    this.f76139h = a(this.u.getMaxVal());
                    this.s.setText(b(a(this.u.getMaxVal())));
                }
                f fVar2 = this.t;
                if (fVar2 != null) {
                    fVar2.a(Long.valueOf(cJRMovieShowTimeFilterDataStorage.f75181c), Long.valueOf(cJRMovieShowTimeFilterDataStorage.f75182d));
                }
            }
            addView(inflate);
            if (this.f76137f.length == 1 || this.f76136e - this.f76135d <= this.f76140i) {
                cJRMovieShowTimeRangeSeekBar.setClickable(false);
                cJRMovieShowTimeRangeSeekBar.setFocusable(false);
                cJRMovieShowTimeRangeSeekBar.setEnabled(false);
            }
        }
    }

    private void a() {
        try {
            this.f76135d = a(this.u.getMinVal());
            this.f76136e = a(this.u.getMaxVal());
            this.f76140i = ((long) this.u.getInterval()) * 60 * 1000;
            int ceil = ((int) Math.ceil(((double) (this.f76136e - this.f76135d)) / ((double) this.f76140i))) + 1;
            if (ceil <= 0) {
                ceil = 1;
            }
            this.f76137f = new long[ceil];
            for (int i2 = 0; i2 < this.f76137f.length; i2++) {
                long j2 = this.f76135d;
                long j3 = (long) i2;
                long j4 = this.f76140i;
                Long.signum(j3);
                long j5 = j2 + (j3 * j4);
                if (j5 <= this.f76136e) {
                    this.f76137f[i2] = j5;
                } else {
                    this.f76137f[i2] = this.f76136e;
                }
            }
        } catch (Exception unused) {
            if (this.f76137f == null) {
                this.f76137f = new long[1];
            }
        }
    }

    public final void a(CJRSliderRangeSeekBar cJRSliderRangeSeekBar, Object obj, Object obj2) {
        this.n = cJRSliderRangeSeekBar;
        Long l2 = (Long) obj2;
        Long l3 = (Long) obj;
        if (l2.longValue() - l3.longValue() >= this.f76140i) {
            this.q = new a(obj, obj2);
            this.q.start();
        } else {
            CJRMovieShowTimeRangeSeekBar cJRMovieShowTimeRangeSeekBar = (CJRMovieShowTimeRangeSeekBar) cJRSliderRangeSeekBar;
            cJRSliderRangeSeekBar.setSelectedMinValue(cJRMovieShowTimeRangeSeekBar.a(Long.valueOf(this.o)));
            this.r.setText(b(this.o));
            cJRSliderRangeSeekBar.setSelectedMaxValue(cJRMovieShowTimeRangeSeekBar.a(Long.valueOf(this.p)));
            this.s.setText(b(this.p));
        }
        this.l = l3.longValue();
        this.m = l2.longValue();
    }

    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        Object f76142a;

        /* renamed from: b  reason: collision with root package name */
        Object f76143b;

        public a(Object obj, Object obj2) {
            this.f76143b = obj2;
            this.f76142a = obj;
        }

        public final void run() {
            boolean z;
            super.run();
            CJRShowTimeFilterView cJRShowTimeFilterView = CJRShowTimeFilterView.this;
            Object obj = this.f76142a;
            Object obj2 = this.f76143b;
            Long l = (Long) obj;
            cJRShowTimeFilterView.f76132a = l.longValue();
            cJRShowTimeFilterView.f76133b = ((Long) obj2).longValue();
            long[] jArr = cJRShowTimeFilterView.f76137f;
            int length = jArr.length;
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                z = true;
                if (i2 >= length) {
                    z = z2;
                    break;
                }
                long j = jArr[i2];
                if (cJRShowTimeFilterView.f76134c == l.longValue() || cJRShowTimeFilterView.f76132a > j || j >= cJRShowTimeFilterView.f76133b) {
                    if (cJRShowTimeFilterView.f76138g != cJRShowTimeFilterView.f76132a && j >= cJRShowTimeFilterView.f76133b) {
                        cJRShowTimeFilterView.k.sendEmptyMessage(2);
                        z2 = true;
                    }
                    if (cJRShowTimeFilterView.f76139h == cJRShowTimeFilterView.f76133b || cJRShowTimeFilterView.f76133b > j || j <= cJRShowTimeFilterView.f76132a) {
                        if (cJRShowTimeFilterView.f76139h != cJRShowTimeFilterView.f76133b && cJRShowTimeFilterView.f76133b <= j && j <= cJRShowTimeFilterView.f76132a) {
                            cJRShowTimeFilterView.k.sendEmptyMessage(4);
                            z2 = true;
                        }
                        cJRShowTimeFilterView.j = j;
                        i2++;
                    } else {
                        if (cJRShowTimeFilterView.f76133b - cJRShowTimeFilterView.f76138g < cJRShowTimeFilterView.f76140i) {
                            cJRShowTimeFilterView.f76133b = cJRShowTimeFilterView.f76138g + cJRShowTimeFilterView.f76140i;
                            if (cJRShowTimeFilterView.f76133b > cJRShowTimeFilterView.f76136e) {
                                cJRShowTimeFilterView.f76133b = cJRShowTimeFilterView.f76136e;
                            }
                        } else if (cJRShowTimeFilterView.f76133b == j) {
                            cJRShowTimeFilterView.f76133b = j;
                        } else {
                            cJRShowTimeFilterView.f76133b = cJRShowTimeFilterView.j;
                        }
                        if (cJRShowTimeFilterView.f76133b - cJRShowTimeFilterView.f76132a < cJRShowTimeFilterView.f76140i) {
                            cJRShowTimeFilterView.f76133b = cJRShowTimeFilterView.f76132a + cJRShowTimeFilterView.f76140i;
                        } else {
                            cJRShowTimeFilterView.f76139h = cJRShowTimeFilterView.f76133b;
                        }
                        cJRShowTimeFilterView.k.sendEmptyMessage(3);
                    }
                } else {
                    if (cJRShowTimeFilterView.f76139h - cJRShowTimeFilterView.f76132a < cJRShowTimeFilterView.f76140i) {
                        cJRShowTimeFilterView.f76132a = cJRShowTimeFilterView.f76139h - cJRShowTimeFilterView.f76140i;
                        if (cJRShowTimeFilterView.f76132a < cJRShowTimeFilterView.f76135d) {
                            cJRShowTimeFilterView.f76132a = cJRShowTimeFilterView.f76135d;
                        }
                    } else if (cJRShowTimeFilterView.f76139h - j < cJRShowTimeFilterView.f76140i) {
                        cJRShowTimeFilterView.f76132a = cJRShowTimeFilterView.f76139h - cJRShowTimeFilterView.f76140i;
                        if (cJRShowTimeFilterView.f76132a < cJRShowTimeFilterView.f76135d) {
                            cJRShowTimeFilterView.f76132a = cJRShowTimeFilterView.f76135d;
                        }
                    } else {
                        cJRShowTimeFilterView.f76132a = j;
                    }
                    cJRShowTimeFilterView.f76138g = cJRShowTimeFilterView.f76132a;
                    cJRShowTimeFilterView.k.sendEmptyMessage(1);
                }
            }
            if (!z) {
                cJRShowTimeFilterView.f76138g = cJRShowTimeFilterView.f76132a;
                cJRShowTimeFilterView.f76139h = cJRShowTimeFilterView.f76133b;
            }
            cJRShowTimeFilterView.f76134c = l.longValue();
        }
    }

    private static long a(String str) {
        Date date;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            date = simpleDateFormat2.parse(simpleDateFormat2.format(parse));
        } catch (ParseException unused) {
            date = null;
        }
        if (date != null) {
            return date.getTime();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static String b(long j2) {
        if (j2 == 0) {
            return null;
        }
        return new SimpleDateFormat("h:mm a").format(new Date(j2));
    }
}

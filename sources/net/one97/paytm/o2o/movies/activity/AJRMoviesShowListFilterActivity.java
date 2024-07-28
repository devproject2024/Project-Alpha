package net.one97.paytm.o2o.movies.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.q;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.d.f;
import net.one97.paytm.o2o.movies.widget.CJRPriceFilterView;
import net.one97.paytm.o2o.movies.widget.CJRShowTimeFilterView;

public class AJRMoviesShowListFilterActivity extends AppBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, f {
    private boolean A = false;
    /* access modifiers changed from: private */
    public CJRMovieShowTimeFilterDataStorage B;
    private Map<String, CJRMovieDateWiseFactor> C;
    /* access modifiers changed from: private */
    public Handler D = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Intent intent = new Intent();
                intent.putExtra("action_code", 1);
                intent.putExtra("filter_data", AJRMoviesShowListFilterActivity.this.B);
                AJRMoviesShowListFilterActivity.this.setResult(234, intent);
                AJRMoviesShowListFilterActivity.this.finish();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    CJRMovieDateWiseFactor f74068a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f74069b;

    /* renamed from: c  reason: collision with root package name */
    private View f74070c;

    /* renamed from: d  reason: collision with root package name */
    private View f74071d;

    /* renamed from: e  reason: collision with root package name */
    private View f74072e;

    /* renamed from: f  reason: collision with root package name */
    private View f74073f;

    /* renamed from: g  reason: collision with root package name */
    private View f74074g;

    /* renamed from: h  reason: collision with root package name */
    private CJRMovieShowTimeFilterDataStorage f74075h;

    /* renamed from: i  reason: collision with root package name */
    private int f74076i = 0;
    private TextView j;
    private boolean k;
    private boolean l;
    private ArrayList<String> m;
    private LinearLayout n;
    private LinearLayout o;
    private TextView p;
    private RecyclerView q;
    private int r;
    private int s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private String z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movies_showlist_filter);
        findViewById(R.id.btn_clear_all).setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        this.j = (TextView) findViewById(R.id.btn_apply);
        this.j.setOnClickListener(this);
        this.f74070c = findViewById(R.id.movie_formatLy);
        this.f74071d = findViewById(R.id.premiumLy);
        this.f74072e = findViewById(R.id.price_sliderLy);
        this.f74073f = findViewById(R.id.show_sliderLy);
        this.f74074g = findViewById(R.id.cinemaChain_Ly);
        this.f74074g.setVisibility(8);
        this.f74070c.setVisibility(8);
        this.f74071d.setVisibility(8);
        this.f74072e.setVisibility(8);
        this.f74073f.setVisibility(8);
        this.f74075h = new CJRMovieShowTimeFilterDataStorage();
        Intent intent = getIntent();
        this.B = (CJRMovieShowTimeFilterDataStorage) intent.getParcelableExtra("filter_data");
        this.C = (Map) intent.getSerializableExtra("filter_list");
        this.z = intent.getStringExtra("selected_date");
        CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage = this.f74075h;
        String str = this.z;
        cJRMovieShowTimeFilterDataStorage.f75184f = str;
        if (!TextUtils.isEmpty(str)) {
            CJRMovieDateWiseFactor cJRMovieDateWiseFactor = this.C.get(this.z);
            if (cJRMovieDateWiseFactor != null) {
                CJRMovieShowTimeSearchFilterItem price = cJRMovieDateWiseFactor.getPrice();
                if (price != null) {
                    if (!TextUtils.isEmpty(price.getMinVal()) && !"undefined".equalsIgnoreCase(price.getMinVal())) {
                        this.v = Integer.parseInt(price.getMinVal());
                    }
                    if (!TextUtils.isEmpty(price.getMaxVal()) && !"undefined".equalsIgnoreCase(price.getMaxVal())) {
                        this.w = Integer.parseInt(price.getMaxVal());
                    }
                }
                CJRMovieShowTimeSearchFilterItem showTime = cJRMovieDateWiseFactor.getShowTime();
                if (showTime != null) {
                    if (!TextUtils.isEmpty(showTime.getMinVal())) {
                        this.x = c(showTime.getMinVal());
                    }
                    if (!TextUtils.isEmpty(showTime.getMaxVal())) {
                        this.y = c(showTime.getMaxVal());
                    }
                }
            }
            CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage2 = this.B;
            if (cJRMovieShowTimeFilterDataStorage2 != null) {
                String str2 = this.z;
                String str3 = cJRMovieShowTimeFilterDataStorage2.f75184f;
                if (!TextUtils.isEmpty(str3)) {
                    if (str2.equalsIgnoreCase(str3)) {
                        if (!(cJRMovieShowTimeFilterDataStorage2.f75181c == 0 || cJRMovieShowTimeFilterDataStorage2.f75182d == 0)) {
                            String a2 = a(cJRMovieShowTimeFilterDataStorage2.f75181c);
                            String str4 = str2 + " " + a2;
                            cJRMovieShowTimeFilterDataStorage2.f75181c = d(str4);
                            cJRMovieShowTimeFilterDataStorage2.f75182d = d(str2 + " " + a(cJRMovieShowTimeFilterDataStorage2.f75182d));
                        }
                        int a3 = a(cJRMovieShowTimeFilterDataStorage2.f75179a);
                        int b2 = b(cJRMovieShowTimeFilterDataStorage2.f75180b);
                        if (a3 <= 0) {
                            cJRMovieShowTimeFilterDataStorage2.f75179a = String.valueOf(this.v);
                            this.r = 0;
                        } else {
                            cJRMovieShowTimeFilterDataStorage2.f75179a = String.valueOf(a3);
                            this.r = a3;
                        }
                        if (b2 <= 0) {
                            cJRMovieShowTimeFilterDataStorage2.f75180b = String.valueOf(this.w);
                            this.s = 0;
                        } else {
                            cJRMovieShowTimeFilterDataStorage2.f75180b = String.valueOf(b2);
                            this.s = b2;
                        }
                    } else {
                        if (!TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage2.f75179a) && !TextUtils.isEmpty(cJRMovieShowTimeFilterDataStorage2.f75180b)) {
                            int a4 = a(cJRMovieShowTimeFilterDataStorage2.f75179a);
                            int b3 = b(cJRMovieShowTimeFilterDataStorage2.f75180b);
                            if (a4 == 0 && b3 == 0) {
                                cJRMovieShowTimeFilterDataStorage2.f75179a = String.valueOf(this.v);
                                this.r = 0;
                                cJRMovieShowTimeFilterDataStorage2.f75180b = String.valueOf(this.w);
                                this.s = 0;
                            } else {
                                if (this.v > a4 || a4 > this.w) {
                                    cJRMovieShowTimeFilterDataStorage2.f75179a = String.valueOf(this.v);
                                } else {
                                    cJRMovieShowTimeFilterDataStorage2.f75179a = String.valueOf(a4);
                                }
                                if (this.v > b3 || b3 > this.w) {
                                    cJRMovieShowTimeFilterDataStorage2.f75180b = String.valueOf(this.w);
                                } else {
                                    cJRMovieShowTimeFilterDataStorage2.f75180b = String.valueOf(b3);
                                }
                                this.r = Integer.parseInt(cJRMovieShowTimeFilterDataStorage2.f75179a);
                                this.s = Integer.parseInt(cJRMovieShowTimeFilterDataStorage2.f75180b);
                            }
                        }
                        if (!(cJRMovieShowTimeFilterDataStorage2.f75181c == 0 || cJRMovieShowTimeFilterDataStorage2.f75182d == 0)) {
                            String a5 = a(cJRMovieShowTimeFilterDataStorage2.f75181c);
                            String a6 = a(cJRMovieShowTimeFilterDataStorage2.f75182d);
                            long d2 = d(str2 + " " + a5);
                            long d3 = d(str2 + " " + a6);
                            if (this.x > d2 || d2 > this.y) {
                                cJRMovieShowTimeFilterDataStorage2.f75181c = this.x;
                            } else {
                                cJRMovieShowTimeFilterDataStorage2.f75181c = d2;
                            }
                            if (this.x > d3 || d3 > this.y) {
                                cJRMovieShowTimeFilterDataStorage2.f75182d = this.y;
                            } else {
                                cJRMovieShowTimeFilterDataStorage2.f75182d = d3;
                            }
                            this.t = cJRMovieShowTimeFilterDataStorage2.f75181c;
                            this.u = cJRMovieShowTimeFilterDataStorage2.f75182d;
                        }
                    }
                }
                b();
                return;
            }
            b();
        }
    }

    private void b() {
        this.f74068a = this.C.get(this.z);
        CJRMovieDateWiseFactor cJRMovieDateWiseFactor = this.f74068a;
        if (cJRMovieDateWiseFactor != null) {
            if (cJRMovieDateWiseFactor.getPremium() != null) {
                c();
            }
            if (!(this.f74068a.getFormat() == null || this.f74068a.getFormat().listOfVal == null || this.f74068a.getFormat().listOfVal.size() <= 1)) {
                f();
            }
            if (this.f74068a.getPrice() != null) {
                d();
            }
            if (this.f74068a.getShowTime() != null) {
                e();
            }
            g();
        }
    }

    private void c() {
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.premiumSwitcher);
        this.f74069b = (TextView) findViewById(R.id.premiumDescriptionTv);
        if (this.f74068a.getPremium().getDescription() != null && !this.f74068a.getPremium().getDescription().equals("null")) {
            this.f74069b.setText(this.f74068a.getPremium().getDescription());
        }
        this.f74071d.setVisibility(0);
        CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage = this.B;
        if (cJRMovieShowTimeFilterDataStorage != null && cJRMovieShowTimeFilterDataStorage.f75185g == 1) {
            switchCompat.setChecked(true);
            this.f74076i = 1;
        }
        switchCompat.setOnCheckedChangeListener(this);
    }

    private void d() {
        this.n = (LinearLayout) findViewById(R.id.root_price_range_slider);
        this.f74072e.setVisibility(0);
        this.n.addView(new CJRPriceFilterView(this, this, this.f74068a.getPrice(), this.B));
    }

    private void e() {
        this.o = (LinearLayout) findViewById(R.id.root_show_timing_slider);
        this.f74073f.setVisibility(0);
        this.o.addView(new CJRShowTimeFilterView(this, this, this.f74068a.getShowTime(), this.B));
    }

    private void f() {
        this.p = (TextView) findViewById(R.id.movie_format_heading);
        this.q = (RecyclerView) findViewById(R.id.movie_format_recycler_view);
        this.f74070c.setVisibility(0);
        this.q.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.q.setHasFixedSize(true);
        this.q.addItemDecoration(new RecyclerView.h() {
            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                if (recyclerView.getChildAdapterPosition(view) < recyclerView.getLayoutManager().getItemCount() - 1) {
                    rect.right = AJRMoviesShowListFilterActivity.a();
                }
            }
        });
        TextView textView = this.p;
        textView.setText(textView.getContext().getString(R.string.movie_format));
        this.q.setAdapter(new q(this.f74068a.getFormat().getListOfVal(), this.B, this));
    }

    public static int a() {
        try {
            return (int) (Resources.getSystem().getDisplayMetrics().density * 11.0f);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return (int) Double.parseDouble(str);
        }
    }

    private static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return (int) Double.parseDouble(str);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_clear_all) {
            if (!this.A) {
                this.A = true;
                Intent intent = new Intent();
                intent.putExtra("action_code", 0);
                setResult(123, intent);
                finish();
            }
        } else if (id == R.id.btn_apply) {
            if (!this.A) {
                this.A = true;
                new a(this, (byte) 0).start();
            }
        } else if (id == R.id.back_button) {
            onBackPressed();
        }
    }

    public final void a(int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            this.r = i2;
            this.s = i3;
            this.k = i2 > this.v || i3 < this.w;
            h();
        }
    }

    public final void a(Long l2, Long l3) {
        if (l2.longValue() != 0 && l3.longValue() != 0) {
            this.t = l2.longValue();
            this.u = l3.longValue();
            this.l = l2.longValue() > this.x || l3.longValue() < this.y;
            h();
        }
    }

    public final void a(ArrayList<String> arrayList) {
        this.m = arrayList;
        this.f74075h.f75183e = this.m;
        runOnUiThread(new Runnable() {
            public final void run() {
                AJRMoviesShowListFilterActivity.this.h();
            }
        });
    }

    private static long c(String str) {
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

    private static String a(long j2) {
        return new SimpleDateFormat("HH:mm").format(new Date(j2));
    }

    private static long d(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException unused) {
            return 0;
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.f74076i = 1;
        } else {
            this.f74076i = 0;
        }
        h();
    }

    public void onDestroy() {
        this.A = false;
        this.D = null;
        super.onDestroy();
    }

    class a extends Thread {
        private a() {
        }

        /* synthetic */ a(AJRMoviesShowListFilterActivity aJRMoviesShowListFilterActivity, byte b2) {
            this();
        }

        public final void run() {
            super.run();
            AJRMoviesShowListFilterActivity.c(AJRMoviesShowListFilterActivity.this);
            AJRMoviesShowListFilterActivity.this.D.sendEmptyMessage(1);
        }
    }

    private void g() {
        this.j.setEnabled(false);
        this.j.setBackgroundColor(getResources().getColor(R.color.separators));
    }

    /* access modifiers changed from: private */
    public void h() {
        this.j.setEnabled(true);
        this.j.setBackgroundColor(getResources().getColor(R.color.color_00b9f5_re));
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("action_code", 2);
        setResult(345, intent);
        super.onBackPressed();
    }

    static /* synthetic */ void c(AJRMoviesShowListFilterActivity aJRMoviesShowListFilterActivity) {
        aJRMoviesShowListFilterActivity.f74075h.f75179a = String.valueOf(aJRMoviesShowListFilterActivity.r);
        aJRMoviesShowListFilterActivity.f74075h.f75180b = String.valueOf(aJRMoviesShowListFilterActivity.s);
        CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage = aJRMoviesShowListFilterActivity.f74075h;
        cJRMovieShowTimeFilterDataStorage.f75181c = aJRMoviesShowListFilterActivity.t;
        cJRMovieShowTimeFilterDataStorage.f75182d = aJRMoviesShowListFilterActivity.u;
        cJRMovieShowTimeFilterDataStorage.f75185g = aJRMoviesShowListFilterActivity.f74076i;
        aJRMoviesShowListFilterActivity.B = cJRMovieShowTimeFilterDataStorage;
    }
}

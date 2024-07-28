package com.travel.flight.flightticket.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.travel.flight.R;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class c implements View.OnClickListener {
    private RelativeLayout A;
    private GridView B;
    private a C;
    private Calendar D;
    private int E;
    private String F = "MMMM yyyy";
    private LinearLayout G;
    private LinearLayout H;
    private Calendar I;
    private Calendar J;
    private Calendar K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private b Q;
    private String R;
    private boolean S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;

    /* renamed from: a  reason: collision with root package name */
    protected Activity f24879a;

    /* renamed from: b  reason: collision with root package name */
    int f24880b;

    /* renamed from: c  reason: collision with root package name */
    int f24881c;

    /* renamed from: d  reason: collision with root package name */
    int f24882d;

    /* renamed from: e  reason: collision with root package name */
    int f24883e;

    /* renamed from: f  reason: collision with root package name */
    int f24884f;

    /* renamed from: g  reason: collision with root package name */
    int f24885g;

    /* renamed from: h  reason: collision with root package name */
    int f24886h;

    /* renamed from: i  reason: collision with root package name */
    int f24887i;
    int j;
    String k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    String u;
    boolean v;
    Locale w;
    String x;
    private RelativeLayout y;
    private RelativeLayout z;

    public interface b {
    }

    public final void a(View view) {
        int g2 = com.paytm.utility.b.g((Context) this.f24879a);
        Activity activity = this.f24879a;
        if (activity != null) {
            this.Q = (b) activity;
        }
        this.w = new Locale(n.a());
        if (this.U == null && this.V == null) {
            this.U = (TextView) view.findViewById(R.id.todays_date);
            this.V = (TextView) view.findViewById(R.id.tomorrows_date);
            this.W = (TextView) view.findViewById(R.id.label_today);
            this.X = (TextView) view.findViewById(R.id.label_tommorrow);
            int g3 = com.paytm.utility.b.g((Context) this.f24879a);
            this.U.setPadding(g3, 0, g3, g3);
            this.V.setPadding(g3, 0, g3, g3);
            view.findViewById(R.id.sep).setPadding(0, 0, 0, g3 + g3);
            view.findViewById(R.id.label_today).setPadding(g3, g3, g3, 0);
            view.findViewById(R.id.label_tommorrow).setPadding(g3, g3, g3, 0);
        }
        String str = this.M;
        if (str == null || !str.equalsIgnoreCase("intent_extra_selected_return_date")) {
            a("CheckIN", (String) null);
        } else {
            a("CheckOUT", this.N);
        }
        this.D = Calendar.getInstance(this.w);
        int i2 = g2 + g2;
        view.findViewById(R.id.calendar_header).setPadding(0, i2, 0, i2);
        Intent intent = this.f24879a.getIntent();
        this.k = intent.getStringExtra(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        this.M = intent.getStringExtra("intent_type");
        this.N = intent.getStringExtra("flight_ticket_date_next_type");
        if (intent.hasExtra("intent_one_way_trip")) {
            this.v = intent.getBooleanExtra("intent_one_way_trip", false);
        }
        if (this.v) {
            this.u = this.k;
        }
        if (intent.hasExtra("intent_extra_updated_depart_date") && intent.hasExtra("intent_extra_updated_return_date")) {
            this.O = intent.getStringExtra("intent_extra_updated_depart_date");
            this.P = intent.getStringExtra("intent_extra_updated_return_date");
            String str2 = this.M;
            if (str2 == null || !str2.equalsIgnoreCase("intent_extra_selected_depart_date")) {
                this.u = this.P;
            } else {
                this.u = this.O;
            }
            c();
        }
        String str3 = this.k;
        if ((str3 == null || !str3.equalsIgnoreCase("Depart Date")) && !this.k.equalsIgnoreCase("Return Date")) {
            this.L = this.k;
        } else {
            this.L = "empty_date";
        }
        this.f24882d = this.D.get(2) + 1;
        this.f24885g = this.D.get(1);
        this.f24883e = this.D.get(5);
        if (this.u == null) {
            this.E = this.D.get(2) + 1;
            this.f24881c = this.E;
            this.f24880b = this.D.get(1);
            this.f24884f = this.f24880b;
        } else {
            b();
        }
        this.z = (RelativeLayout) view.findViewById(R.id.footer_lyt);
        String str4 = this.M;
        if (str4 == null || !str4.equalsIgnoreCase("intent_extra_selected_return_date")) {
            this.z.setVisibility(8);
            this.W.setText("Today");
            this.X.setText("Tomorrow");
            a("CheckIN", (String) null);
        } else if (this.U == null || this.V == null) {
            this.z.setVisibility(8);
        } else {
            this.W.setText("1 Night");
            this.X.setText("2 Nights");
            a("CheckOUT", (String) null);
        }
        this.G = (LinearLayout) view.findViewById(R.id.todays_date_selector);
        this.G.setOnClickListener(this);
        this.H = (LinearLayout) view.findViewById(R.id.tomorrows_date_selector);
        this.H.setOnClickListener(this);
        this.y = (RelativeLayout) view.findViewById(R.id.prevMonthlyt);
        view.findViewById(R.id.sep_1).setVisibility(8);
        if (this.u == null) {
            this.y.setVisibility(4);
        } else if (this.f24880b == this.f24885g && this.f24886h == this.D.get(2) + 1) {
            this.y.setVisibility(4);
        } else {
            this.y.setVisibility(0);
        }
        this.y.setOnClickListener(this);
        this.T = (TextView) view.findViewById(R.id.currentMonth);
        this.T.setText(DateFormat.format(this.F, this.D.getTime()));
        this.A = (RelativeLayout) view.findViewById(R.id.nextMonthlyt);
        this.A.setOnClickListener(this);
        this.B = (GridView) view.findViewById(R.id.calendar);
        this.B.setHorizontalSpacing(com.paytm.utility.b.a(0, (Context) this.f24879a));
        Activity activity2 = this.f24879a;
        int i3 = R.id.calendar_day_gridcell;
        this.C = new a(activity2, this.E, this.f24880b);
        this.C.notifyDataSetChanged();
        this.B.setAdapter(this.C);
        if (this.u != null) {
            a(this.f24886h, this.f24887i, true);
        }
        this.z.setVisibility(8);
    }

    private void b() {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.w);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd", this.w);
        try {
            date = simpleDateFormat.parse(this.u);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            date = null;
        }
        if (date != null) {
            String format = simpleDateFormat2.format(date);
            this.f24886h = Integer.parseInt(format.substring(4, 6));
            this.f24887i = Integer.parseInt(format.substring(0, 4));
            this.j = Integer.parseInt(format.substring(6));
            this.E = this.f24886h;
            this.f24880b = this.f24887i;
            return;
        }
        this.E = this.D.get(2) + 1;
        this.f24881c = this.E;
        this.f24880b = this.D.get(1);
        this.f24884f = this.f24880b;
    }

    private void c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.w);
        try {
            Date parse = simpleDateFormat.parse(this.O);
            Date parse2 = simpleDateFormat.parse(this.P);
            Calendar instance = Calendar.getInstance(this.w);
            instance.setTime(parse);
            this.n = instance.get(2);
            this.l = instance.get(5);
            this.p = instance.get(1);
            Calendar instance2 = Calendar.getInstance(this.w);
            instance2.setTime(parse2);
            this.o = instance2.get(2);
            this.m = instance2.get(5);
            this.q = instance2.get(1);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(String str, String str2) {
        try {
            Calendar instance = Calendar.getInstance(this.w);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", this.w);
            if (str2 != null) {
                if (!str2.equalsIgnoreCase("Check-in Date")) {
                    Calendar instance2 = Calendar.getInstance(this.w);
                    instance2.setTime(simpleDateFormat.parse(str2));
                    instance2.add(5, 1);
                    this.J = instance2;
                    String format = simpleDateFormat.format(instance2.getTime());
                    Calendar instance3 = Calendar.getInstance(this.w);
                    instance3.setTime(simpleDateFormat.parse(str2));
                    instance3.add(5, 2);
                    this.K = instance3;
                    String format2 = simpleDateFormat.format(instance3.getTime());
                    this.U.setText(com.paytm.utility.b.d(format, "dd MMM yy", "dd MMM, E"));
                    this.V.setText(com.paytm.utility.b.d(format2, "dd MMM yy", "dd MMM, E"));
                    return;
                }
            }
            this.I = instance;
            Calendar instance4 = Calendar.getInstance(this.w);
            instance4.add(5, 1);
            this.J = instance4;
            String format3 = simpleDateFormat.format(instance4.getTime());
            if (str.equalsIgnoreCase("CheckIN")) {
                this.U.setText(com.paytm.utility.b.d(simpleDateFormat.format(instance.getTime()), "dd MMM yy", "dd MMM, E"));
                this.V.setText(com.paytm.utility.b.d(format3, "dd MMM yy", "dd MMM, E"));
            }
            Calendar instance5 = Calendar.getInstance(this.w);
            instance5.add(5, 2);
            this.K = instance5;
            String format4 = simpleDateFormat.format(instance5.getTime());
            if (str.equalsIgnoreCase("CheckOUT")) {
                this.U.setText(com.paytm.utility.b.d(format3, "dd MMM yy", "dd MMM, E"));
                this.V.setText(com.paytm.utility.b.d(format4, "dd MMM yy", "dd MMM, E"));
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private static String a(int i2) {
        return new DateFormatSymbols().getMonths()[i2 - 1];
    }

    private void a(int i2, int i3, boolean z2) {
        Activity activity = this.f24879a;
        int i4 = R.id.calendar_day_gridcell;
        this.C = new a(activity, i2, i3);
        if (z2) {
            this.D.set(i3, i2 - 1, this.j);
        } else {
            Calendar calendar = this.D;
            calendar.set(i3, i2 - 1, calendar.get(5));
        }
        if (i3 != 0) {
            try {
                TextView textView = this.T;
                textView.setText(a(i2) + " " + i3);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        this.C.notifyDataSetChanged();
        this.B.setAdapter(this.C);
        this.B.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                String.valueOf(i2);
                com.paytm.utility.b.j();
            }
        });
    }

    public final void onClick(View view) {
        if (view == this.y) {
            if (this.u != null) {
                int i2 = this.E;
                if (i2 <= 1) {
                    this.E = 12;
                    this.f24880b--;
                } else {
                    this.E = i2 - 1;
                }
                if (this.E == Calendar.getInstance(this.w).get(2) + 1 && this.f24880b == Calendar.getInstance(this.w).get(1)) {
                    this.y.setVisibility(4);
                } else {
                    this.y.setVisibility(0);
                }
            } else {
                int i3 = this.E;
                if (i3 <= 1) {
                    this.E = 12;
                    this.f24880b--;
                } else {
                    this.E = i3 - 1;
                }
                if (this.E == this.f24881c && this.f24880b == this.f24884f) {
                    this.y.setVisibility(4);
                } else {
                    this.y.setVisibility(0);
                }
            }
            a(this.E, this.f24880b, false);
        }
        if (view == this.A) {
            this.y.setVisibility(0);
            int i4 = this.E;
            if (i4 > 11) {
                this.E = 1;
                this.f24880b++;
            } else {
                this.E = i4 + 1;
            }
            a(this.E, this.f24880b, false);
        }
        if (view == this.G) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.w);
            String str = this.M;
            if (str == null || !str.equalsIgnoreCase("intent_extra_selected_depart_date")) {
                b(simpleDateFormat.format(this.J.getTime()));
            } else {
                b(simpleDateFormat.format(this.I.getTime()));
            }
        }
        if (view == this.H) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yy", this.w);
            String str2 = this.M;
            if (str2 == null || !str2.equalsIgnoreCase("intent_extra_selected_depart_date")) {
                b(simpleDateFormat2.format(this.K.getTime()));
            } else {
                b(simpleDateFormat2.format(this.J.getTime()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(String str) {
        try {
            Date parse = new SimpleDateFormat("dd MMM yy", this.w).parse(str);
            Calendar instance = Calendar.getInstance(this.w);
            instance.setTime(parse);
            return instance.get(5);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            return Calendar.getInstance(this.w).get(5);
        }
    }

    public class a extends BaseAdapter implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Context f24892b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f24893c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f24894d = net.one97.paytmflight.common.b.b.f30015e;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f24895e = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /* renamed from: f  reason: collision with root package name */
        private int f24896f;

        /* renamed from: g  reason: collision with root package name */
        private int f24897g;

        /* renamed from: h  reason: collision with root package name */
        private int f24898h;

        /* renamed from: i  reason: collision with root package name */
        private Button f24899i;
        private RelativeLayout j;
        private final SimpleDateFormat k = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(Context context, int i2, int i3) {
            this.f24892b = context;
            this.f24893c = new ArrayList();
            Calendar instance = Calendar.getInstance(c.this.w);
            if (c.this.u == null) {
                if (c.this.v) {
                    this.f24897g = c.this.a(c.this.k);
                    instance.set(c.this.f24887i, c.this.f24886h, c.this.j);
                } else {
                    this.f24897g = instance.get(5);
                }
                this.f24898h = instance.get(7);
            } else {
                this.f24897g = c.this.j;
                instance.set(c.this.f24887i, c.this.f24886h, c.this.j);
                this.f24898h = instance.get(7);
            }
            if (i2 == 0) {
                int i4 = Calendar.getInstance(c.this.w).get(2) + 1;
                if (c.this.v) {
                    a(i4, i3);
                } else {
                    b(i4, i3);
                }
            } else if (c.this.v) {
                a(i2, i3);
            } else {
                b(i2, i3);
            }
        }

        public final int getCount() {
            return this.f24893c.size();
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f24892b.getSystemService("layout_inflater")).inflate(R.layout.pre_f_flight_calender_cell, viewGroup, false);
            }
            this.j = (RelativeLayout) view.findViewById(R.id.calender_item_lyt);
            this.f24899i = (Button) view.findViewById(R.id.calendar_day_gridcell);
            this.f24899i.setTag(Integer.valueOf(i2));
            this.f24899i.setOnClickListener(this);
            String[] split = this.f24893c.get(i2).split("-");
            String str = split[0];
            String str2 = split[2];
            String str3 = split[3];
            this.f24899i.setText(str);
            Button button = this.f24899i;
            button.setTag(str + "-" + str2 + "-" + str3);
            if (split[1].equals("BLUE")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                }
            }
            if (split[1].equals("GREY")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.gray));
                this.f24899i.setBackgroundColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setEnabled(false);
            } else if (split[1].equals("ORANGE")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setBackgroundColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setEnabled(false);
            } else if (split[1].equals("LEADING_DAYS")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setBackgroundColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setEnabled(false);
            } else if (split[1].equals("WHITE")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
            } else if (split[1].equals("SELECTED_CHECKIN_DATE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                    if (!(c.this.l == c.this.m || (i2 + 1) % 7 == 0)) {
                        this.j.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                    }
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                    if (!(c.this.l == c.this.m || (i2 + 1) % 7 == 0)) {
                        this.j.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                    }
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
            } else if (split[1].equals("RESETED_CHECKIN_DATE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
            } else if (split[1].equals("SELECTED_CHECKOUT_DATE")) {
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                    if (i2 % 7 != 0) {
                        this.j.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                    }
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_circle));
                    if (i2 % 7 != 0) {
                        this.j.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                    }
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.color_000000));
            } else if (split[1].equals("INTERMEDIATE_BLUE")) {
                this.f24899i.setBackgroundColor(c.this.f24879a.getResources().getColor(R.color.paytm_blue_flight));
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
                if (i2 % 7 == 0) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                    } else {
                        this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                    }
                }
                if ((i2 + 1) % 7 == 0) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                    } else {
                        this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                    }
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
            } else if (split[1].equals("MONTH_END_BLUE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_left_rounded_background));
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
            } else if (split[1].equals("MONTH_START_BLUE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f24899i.setBackground(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                } else {
                    this.f24899i.setBackgroundDrawable(c.this.f24879a.getResources().getDrawable(R.drawable.pre_f_flight_hotel_calender_right_rounded_background));
                }
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
                this.f24899i.setTextColor(c.this.f24879a.getResources().getColor(R.color.white));
            }
            return view;
        }

        public final void onClick(View view) {
            try {
                Date parse = this.k.parse((String) view.getTag());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", c.this.w);
                c.this.x = simpleDateFormat.format(Long.valueOf(parse.getTime()));
                c.this.b(c.this.x);
            } catch (ParseException e2) {
                q.b(e2.getMessage());
            }
        }

        private void a(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = i2;
            int i9 = i3;
            int i10 = i8 - 1;
            try {
                this.f24896f = this.f24895e[i10];
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i9, i10, 1);
                int i11 = 11;
                if (i10 == 11) {
                    i11 = i10 - 1;
                    i4 = i9 + 1;
                    i5 = 0;
                    i6 = this.f24895e[i11];
                    i7 = i9;
                } else if (i10 == 0) {
                    i7 = i9 - 1;
                    i6 = this.f24895e[11];
                    i4 = i9;
                    i5 = 1;
                } else {
                    i11 = i10 - 1;
                    i6 = this.f24895e[i11];
                    i4 = i9;
                    i5 = i10 + 1;
                    i7 = i4;
                }
                int i12 = gregorianCalendar.get(7) - 1;
                if (gregorianCalendar.isLeapYear(gregorianCalendar.get(1))) {
                    if (i8 == 2) {
                        this.f24896f++;
                    } else if (i8 == 3) {
                        i6++;
                    }
                }
                for (int i13 = 0; i13 < i12; i13++) {
                    this.f24893c.add(String.valueOf((i6 - i12) + 1 + i13) + "-ORANGE-" + this.f24894d[i11] + "-" + i7);
                }
                for (int i14 = 1; i14 <= this.f24896f; i14++) {
                    if (c.this.k.equalsIgnoreCase("Pick Date")) {
                        if (i10 != c.this.f24881c - 1 || c.this.f24880b != c.this.f24884f) {
                            this.f24893c.add(String.valueOf(i14) + "-WHITE-" + this.f24894d[i10] + "-" + i9);
                        } else if (i14 == this.f24897g) {
                            this.f24893c.add(String.valueOf(i14) + "-BLUE-" + this.f24894d[i10] + "-" + i9);
                        } else if (i14 < this.f24897g) {
                            this.f24893c.add(String.valueOf(i14) + "-GREY-" + this.f24894d[i10] + "-" + i9);
                        } else {
                            this.f24893c.add(String.valueOf(i14) + "-WHITE-" + this.f24894d[i10] + "-" + i9);
                        }
                    } else if (i10 == c.this.f24886h - 1 && c.this.f24880b == c.this.f24887i) {
                        if (i14 == this.f24897g) {
                            this.f24893c.add(String.valueOf(i14) + "-BLUE-" + this.f24894d[i10] + "-" + i9);
                        }
                        if (i14 < Calendar.getInstance(c.this.w).get(5) && i10 == Calendar.getInstance(c.this.w).get(2) && i9 == Calendar.getInstance(c.this.w).get(1)) {
                            this.f24893c.add(String.valueOf(i14) + "-GREY-" + this.f24894d[Calendar.getInstance(c.this.w).get(2)] + "-" + Calendar.getInstance(c.this.w).get(1));
                        } else if (i14 != this.f24897g) {
                            this.f24893c.add(String.valueOf(i14) + "-WHITE-" + this.f24894d[i10] + "-" + i9);
                        }
                    } else if (i14 < Calendar.getInstance(c.this.w).get(5) && i10 == Calendar.getInstance(c.this.w).get(2) && i9 == Calendar.getInstance(c.this.w).get(1)) {
                        this.f24893c.add(String.valueOf(i14) + "-GREY-" + this.f24894d[Calendar.getInstance(c.this.w).get(2)] + "-" + Calendar.getInstance(c.this.w).get(1));
                    } else {
                        this.f24893c.add(String.valueOf(i14) + "-WHITE-" + this.f24894d[i10] + "-" + i9);
                    }
                }
                int i15 = 0;
                while (i15 < this.f24893c.size() % 7) {
                    List<String> list = this.f24893c;
                    StringBuilder sb = new StringBuilder();
                    i15++;
                    sb.append(String.valueOf(i15));
                    sb.append("-LEADING_DAYS-");
                    sb.append(this.f24894d[i5]);
                    sb.append("-");
                    sb.append(i4);
                    list.add(sb.toString());
                }
            } catch (IndexOutOfBoundsException e2) {
                q.b(e2.getMessage());
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:126:0x03f7 A[SYNTHETIC, Splitter:B:126:0x03f7] */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x06d3 A[Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x06fa A[Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(int r20, int r21) {
            /*
                r19 = this;
                r1 = r19
                r2 = r20
                r3 = r21
                int r4 = r2 + -1
                int[] r5 = r1.f24895e     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017 }
                r5 = r5[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017 }
                r1.f24896f = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017 }
                goto L_0x0020
            L_0x000f:
                r0 = move-exception
                r2 = r0
                goto L_0x0b7b
            L_0x0013:
                r0 = move-exception
                r2 = r0
                goto L_0x0b83
            L_0x0017:
                r0 = move-exception
                r5 = r0
                java.lang.String r5 = r5.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.paytm.utility.q.b(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
            L_0x0020:
                java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = 1
                r5.<init>(r3, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = 11
                if (r4 != r8) goto L_0x0037
                int r8 = r4 + -1
                int[] r9 = r1.f24895e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r8]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r10 = r3 + 1
                r12 = r10
                r11 = 0
                r10 = r9
                r9 = r3
                goto L_0x004d
            L_0x0037:
                if (r4 != 0) goto L_0x0042
                int r9 = r3 + -1
                int[] r10 = r1.f24895e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r10 = r10[r8]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r12 = r3
                r11 = 1
                goto L_0x004d
            L_0x0042:
                int r8 = r4 + -1
                int r9 = r4 + 1
                int[] r10 = r1.f24895e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r10 = r10[r8]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r12 = r3
                r11 = r9
                r9 = r12
            L_0x004d:
                r13 = 7
                int r14 = r5.get(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r14 = r14 - r6
                int r15 = r5.get(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                boolean r5 = r5.isLeapYear(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r5 == 0) goto L_0x006b
                r5 = 2
                if (r2 != r5) goto L_0x0066
                int r2 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r2 = r2 + r6
                r1.f24896f = r2     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x006b
            L_0x0066:
                r5 = 3
                if (r2 != r5) goto L_0x006b
                int r10 = r10 + 1
            L_0x006b:
                r2 = 0
            L_0x006c:
                java.lang.String r5 = "-"
                if (r2 >= r14) goto L_0x00a1
                java.util.List<java.lang.String> r15 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r16 = r10 - r14
                int r16 = r16 + 1
                int r16 = r16 + r2
                java.lang.String r13 = java.lang.String.valueOf(r16)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r13 = "-ORANGE-"
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r13 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r13 = r13[r8]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r5 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r15.add(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r2 = r2 + 1
                r13 = 7
                goto L_0x006c
            L_0x00a1:
                r2 = 1
            L_0x00a2:
                int r7 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 > r7) goto L_0x0b3d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24881c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7 - r6
                java.lang.String r8 = "-MONTH_END_BLUE-"
                java.lang.String r9 = "-SELECTED_CHECKIN_DATE-"
                java.lang.String r10 = "-SELECTED_CHECKOUT_DATE-"
                java.lang.String r13 = "-RESETED_CHECKIN_DATE-"
                java.lang.String r14 = "-WHITE-"
                java.lang.String r15 = "-INTERMEDIATE_BLUE-"
                java.lang.String r6 = "-GREY-"
                if (r4 != r7) goto L_0x03e7
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r17 = r12
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.f24884f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r12) goto L_0x03e9
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 == r7) goto L_0x00fb
                int r7 = r1.f24897g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x00fb
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
            L_0x00f6:
                r18 = r11
            L_0x00f8:
                r7 = 1
                goto L_0x0b34
            L_0x00fb:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x029d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x029d
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r4) goto L_0x0233
                int r6 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r6) goto L_0x0143
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 <= r4) goto L_0x0143
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 <= r6) goto L_0x0143
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x0143:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r6) goto L_0x0175
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r4) goto L_0x0175
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x0175:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r6) goto L_0x01a8
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r4) goto L_0x01a8
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x01a8:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 <= r6) goto L_0x01d5
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x01d5:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 <= r6) goto L_0x020c
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 <= r4) goto L_0x020c
                int r6 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 > r6) goto L_0x020c
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x020c:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x0233:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == 0) goto L_0x0276
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r6) goto L_0x0276
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r4) goto L_0x0276
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r7) goto L_0x0276
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x0276:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x029d:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x02e0
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x02e0
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x02e0
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x02e0
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x02e0:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.u     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != 0) goto L_0x031f
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != 0) goto L_0x031f
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != 0) goto L_0x031f
                int r7 = r1.f24897g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x031f
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = "-BLUE-"
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x031f:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x0356
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r4 >= r7) goto L_0x0356
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x0356:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 >= r8) goto L_0x038f
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = 1
                int r7 = r7 + r8
                if (r4 != r7) goto L_0x038f
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x038f:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 >= r8) goto L_0x03c0
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x03c0:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f6
            L_0x03e7:
                r17 = r12
            L_0x03e9:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r18 = r11
                java.lang.String r11 = "-MONTH_START_BLUE-"
                if (r7 != r12) goto L_0x069a
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r12) goto L_0x040f
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r16 = 1
                int r12 = r12 + 1
                if (r7 != r12) goto L_0x069a
            L_0x040f:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r4) goto L_0x041b
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x069a
            L_0x041b:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x0466
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x0466
                int r7 = r4 + 1
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r12) goto L_0x0466
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x0466
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r12 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r12 = r12.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r12) goto L_0x0466
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0466:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x0507
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x0507
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x04ad
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x04ad
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x04ad
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x04ad:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x04da
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x04da:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r6) goto L_0x00f8
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0507:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r4) goto L_0x053d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x053d
                r7 = 1
                if (r2 != r7) goto L_0x053d
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x053d:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x0574
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r4) goto L_0x0574
                int r7 = r1.f24896f     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x0574
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0574:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r4) goto L_0x0580
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 < r7) goto L_0x05be
            L_0x0580:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x0592
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x0592
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 > r7) goto L_0x05be
            L_0x0592:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 <= r7) goto L_0x05a8
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x05a8
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 > r8) goto L_0x05be
            L_0x05a8:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.l     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 <= r7) goto L_0x05e5
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x05e5
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 <= r8) goto L_0x05e5
            L_0x05be:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x05e5:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x0642
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x0642
                r7 = 1
                if (r2 != r7) goto L_0x061b
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x061b:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0642:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 >= r8) goto L_0x0673
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0673:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x069a:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = 1
                int r8 = r8 + r9
                if (r7 == r8) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7 - r9
                if (r4 != r7) goto L_0x06fa
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x06fa
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x06fa:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x081d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x081d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x073d
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x073d
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x073d:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.r     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x0774
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x0774
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0774:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x07b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x07b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = 1
                int r7 = r7 - r8
                if (r4 != r7) goto L_0x07b3
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x07b3:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x07f6
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r8) goto L_0x07f6
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = 1
                int r7 = r7 - r8
                if (r4 != r7) goto L_0x07f6
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x07f6:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x081d:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x0854
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.t     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r4 >= r7) goto L_0x0854
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x0854:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r8) goto L_0x08b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r8) goto L_0x08b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 >= r8) goto L_0x08b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x08b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == 0) goto L_0x08b3
                int r7 = r4 + 1
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24882d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x08b3
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24883e     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r7) goto L_0x08b3
                java.util.List<java.lang.String> r7 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x08b3:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x08fd
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x08fd
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r8) goto L_0x08fd
                r7 = 1
                if (r2 != r7) goto L_0x08fd
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r7) goto L_0x08fd
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r8 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x00f8
            L_0x08fd:
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r4) goto L_0x0941
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 != r8) goto L_0x0941
                com.travel.flight.flightticket.e.c r7 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r7 = r7.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r7 == r8) goto L_0x0941
                r7 = 1
                if (r2 != r7) goto L_0x0942
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0941:
                r7 = 1
            L_0x0942:
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 != r4) goto L_0x0989
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r9 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r9 = r9.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 != r9) goto L_0x0989
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 >= r8) goto L_0x0989
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r9 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r9 = r9.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 == r9) goto L_0x0989
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0989:
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 != r4) goto L_0x09d0
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r9 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r9 = r9.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 != r9) goto L_0x09d0
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.m     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r2 != r8) goto L_0x09d0
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r9 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r9 = r9.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 == r9) goto L_0x09d0
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x09d0:
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r9 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r9 = r9.s     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r8 >= r9) goto L_0x0a01
                java.util.List<java.lang.String> r8 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r6 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6 = r6[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0a01:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r4) goto L_0x0a58
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r4) goto L_0x0a58
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 <= r8) goto L_0x0a58
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 >= r4) goto L_0x0a58
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r8) goto L_0x0a58
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r8) goto L_0x0a58
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0a58:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r4) goto L_0x0ab5
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 < r8) goto L_0x0ab5
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 >= r8) goto L_0x0ab5
                int r6 = r4 + 1
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 > r8) goto L_0x0ab5
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r8) goto L_0x0ab5
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r8) goto L_0x0ab5
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0ab5:
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r8) goto L_0x0b0f
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.f24885g     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 == r8) goto L_0x0b0f
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.q     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r8) goto L_0x0b0f
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.p     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                com.travel.flight.flightticket.e.c r8 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r8 = r8.f24880b     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 != r8) goto L_0x0b0f
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.n     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 >= r4) goto L_0x0b0f
                com.travel.flight.flightticket.e.c r6 = com.travel.flight.flightticket.e.c.this     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r6 = r6.o     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                if (r6 <= r4) goto L_0x0b0f
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                goto L_0x0b34
            L_0x0b0f:
                java.util.List<java.lang.String> r6 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r9 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r9 = r9[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r8.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r8 = r8.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.add(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
            L_0x0b34:
                int r2 = r2 + 1
                r12 = r17
                r11 = r18
                r6 = 1
                goto L_0x00a2
            L_0x0b3d:
                r18 = r11
                r17 = r12
                r2 = 0
            L_0x0b42:
                java.util.List<java.lang.String> r3 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r3 = r3.size()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r4 = 7
                int r3 = r3 % r4
                if (r2 >= r3) goto L_0x0b7a
                java.util.List<java.lang.String> r3 = r1.f24893c     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                int r2 = r2 + 1
                java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.append(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r7 = "-LEADING_DAYS-"
                r6.append(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String[] r7 = r1.f24894d     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r7 = r7[r18]     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.append(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r6.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r10 = r17
                r6.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                java.lang.String r6 = r6.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r3.add(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0013, Exception -> 0x000f }
                r17 = r10
                goto L_0x0b42
            L_0x0b7a:
                return
            L_0x0b7b:
                java.lang.String r2 = r2.getMessage()
                com.paytm.utility.q.b(r2)
                return
            L_0x0b83:
                java.lang.String r2 = r2.getMessage()
                com.paytm.utility.q.b(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.e.c.a.b(int, int):void");
        }

        public final /* synthetic */ Object getItem(int i2) {
            return this.f24893c.get(i2);
        }
    }

    public final void b(String str) {
        try {
            if (this.M != null) {
                if (this.M.equalsIgnoreCase("intent_extra_selected_depart_date")) {
                    if (c(str)) {
                    }
                    return;
                }
            }
            Intent intent = new Intent();
            if (this.M != null) {
                if (this.M.equalsIgnoreCase("intent_extra_selected_depart_date")) {
                    intent.putExtra("intent_extra_selected_depart_date", str);
                } else if (this.N != null && this.N.equalsIgnoreCase(this.f24879a.getResources().getString(R.string.flight_select_return_date))) {
                    com.paytm.utility.b.b((Context) this.f24879a, this.f24879a.getResources().getString(R.string.error), this.f24879a.getResources().getString(R.string.flight_depart_date_before_return_date_validation));
                    return;
                } else if (!a(str, this.N, "Check_out")) {
                    intent.putExtra("intent_extra_selected_return_date", str);
                } else {
                    return;
                }
            }
            if (this.R != null) {
                intent.putExtra("intent_extra_selected_depart_date", this.R);
                a(str, this.R, intent);
                return;
            }
            a(str, (String) null, intent);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(String str, String str2, final Intent intent) {
        b(str, str2);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                c.a(c.this, intent);
            }
        }, 300);
    }

    private boolean c(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.w);
            String format = simpleDateFormat.format(Calendar.getInstance(this.w).getTime());
            Date parse = simpleDateFormat.parse(str);
            Calendar instance = Calendar.getInstance(this.w);
            instance.setTime(simpleDateFormat.parse(format));
            instance.add(5, -1);
            instance.add(1, 1);
            if (parse.compareTo(simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()))) != 0) {
                return false;
            }
            com.paytm.utility.b.b((Context) this.f24879a, this.f24879a.getResources().getString(R.string.error), this.f24879a.getResources().getString(R.string.flight_select_other_depart_date));
            return true;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return false;
        }
    }

    private boolean a(String str, String str2, String str3) {
        Date date;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", this.w);
            Date parse = simpleDateFormat.parse(str);
            if (!this.S || this.O == null) {
                date = simpleDateFormat.parse(str2);
            } else {
                date = simpleDateFormat.parse(this.O);
            }
            if (str3.equalsIgnoreCase("Check_out")) {
                if (parse.compareTo(date) >= 0) {
                    return false;
                }
                com.paytm.utility.b.b((Context) this.f24879a, this.f24879a.getResources().getString(R.string.error), this.f24879a.getResources().getString(R.string.flight_return_date_before_depart));
                return true;
            } else if (parse.compareTo(date) <= 0) {
                return false;
            } else {
                com.paytm.utility.b.b((Context) this.f24879a, this.f24879a.getResources().getString(R.string.error), this.f24879a.getResources().getString(R.string.flight_depart_date_after_return_validation));
                return true;
            }
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public final void a(Activity activity) {
        this.f24879a = activity;
    }

    public final void a() {
        this.f24879a = null;
    }

    private void b(String str, String str2) {
        this.P = str;
        if (str2 != null) {
            this.O = str2;
        }
        this.u = str;
        this.f24884f = 0;
        this.f24881c = 0;
        c();
        b();
        if (this.u != null) {
            a(this.f24886h, this.f24887i, true);
        }
    }

    static /* synthetic */ void a(c cVar, Intent intent) {
        cVar.f24879a.setResult(-1, intent);
        cVar.f24879a.finish();
    }
}

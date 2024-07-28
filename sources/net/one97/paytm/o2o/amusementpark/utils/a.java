package net.one97.paytm.o2o.amusementpark.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.utility.e;
import com.paytm.utility.n;
import com.squareup.timessquare.CalendarPickerView;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.d;

public final class a implements View.OnClickListener, CalendarPickerView.h {

    /* renamed from: a  reason: collision with root package name */
    protected Context f73629a;

    /* renamed from: b  reason: collision with root package name */
    int f73630b;

    /* renamed from: c  reason: collision with root package name */
    int f73631c;

    /* renamed from: d  reason: collision with root package name */
    int f73632d;

    /* renamed from: e  reason: collision with root package name */
    int f73633e;

    /* renamed from: f  reason: collision with root package name */
    int f73634f;

    /* renamed from: g  reason: collision with root package name */
    int f73635g;

    /* renamed from: h  reason: collision with root package name */
    int f73636h;

    /* renamed from: i  reason: collision with root package name */
    String f73637i;
    public d j;
    public CalendarPickerView k;
    public Date l;
    Locale m;
    public String n;
    public String o;
    private RelativeLayout p;
    private RelativeLayout q;
    private GridView r;
    private C1477a s;
    private Calendar t;
    private int u;
    private int v;
    private String w = "MMMM yyyy";
    private TextView x;
    private List<String> y;

    public final void b(Date date) {
    }

    private void a(int i2, int i3) {
        if (i2 == 0) {
            i2 = Calendar.getInstance(this.m).get(2) + 1;
        }
        Context context = this.f73629a;
        int i4 = R.id.calendar_day_gridcell;
        this.s = new C1477a(context, i2, i3);
        Calendar calendar = this.t;
        int i5 = i2 - 1;
        calendar.set(i3, i5, calendar.get(5));
        if (i3 != 0) {
            try {
                this.x.setText(new DateFormatSymbols().getMonths()[i5] + " " + i3);
            } catch (Exception | IndexOutOfBoundsException unused) {
            }
        }
        this.s.notifyDataSetChanged();
        this.r.setAdapter(this.s);
    }

    public final void onClick(View view) {
        RelativeLayout relativeLayout = this.p;
        if (view == relativeLayout) {
            if (this.f73637i != null) {
                int i2 = this.u;
                if (i2 <= 1) {
                    this.u = 12;
                    this.v--;
                } else {
                    this.u = i2 - 1;
                }
            } else {
                int i3 = this.u;
                if (i3 <= 1) {
                    this.u = 12;
                    this.v--;
                } else {
                    this.u = i3 - 1;
                }
            }
            a(this.u, this.v);
        } else if (view == this.q) {
            relativeLayout.setVisibility(0);
            int i4 = this.u;
            if (i4 > 11) {
                this.u = 1;
                this.v++;
            } else {
                this.u = i4 + 1;
            }
            a(this.u, this.v);
        }
    }

    public final void a(Date date) {
        this.m = new Locale(n.a());
        a(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date));
    }

    /* renamed from: net.one97.paytm.o2o.amusementpark.utils.a$a  reason: collision with other inner class name */
    public class C1477a extends BaseAdapter implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Context f73639b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f73640c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f73641d = e.l;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f73642e = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /* renamed from: f  reason: collision with root package name */
        private int f73643f;

        /* renamed from: g  reason: collision with root package name */
        private int f73644g;

        /* renamed from: h  reason: collision with root package name */
        private int f73645h;

        /* renamed from: i  reason: collision with root package name */
        private Button f73646i;
        private RelativeLayout j;
        private final SimpleDateFormat k = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public C1477a(Context context, int i2, int i3) {
            this.f73639b = context;
            this.f73640c = new ArrayList();
            Calendar instance = Calendar.getInstance();
            if (a.this.f73637i == null) {
                this.f73644g = instance.get(5);
                this.f73645h = instance.get(7);
            } else {
                this.f73644g = a.this.f73636h;
                instance.set(a.this.f73635g, a.this.f73634f, a.this.f73636h);
                this.f73645h = instance.get(7);
            }
            if (i2 != 0) {
                a(i2, i3);
            } else {
                a(Calendar.getInstance(a.this.m).get(2) + 1, i3);
            }
        }

        public final int getCount() {
            return this.f73640c.size();
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f73639b.getSystemService("layout_inflater")).inflate(R.layout.park_screen_gridcell, viewGroup, false);
            }
            this.j = (RelativeLayout) view.findViewById(R.id.calender_item_lyt);
            this.f73646i = (Button) view.findViewById(R.id.calendar_day_gridcell);
            this.f73646i.setTag(Integer.valueOf(i2));
            this.f73646i.setOnClickListener(this);
            String[] split = this.f73640c.get(i2).split("-");
            String str = split[0];
            String str2 = split[2];
            String str3 = split[3];
            this.f73646i.setText(str);
            Button button = this.f73646i;
            button.setTag(str + "-" + str2 + "-" + str3);
            if (split[1].equals("DATE_BEFORE_TODAY")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.gray));
                this.f73646i.setBackgroundColor(b.c(a.this.f73629a, R.color.white));
                this.f73646i.setEnabled(false);
            }
            if (split[1].equals("GREY")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.gray));
                this.f73646i.setBackgroundColor(b.c(a.this.f73629a, R.color.white));
                this.f73646i.setEnabled(false);
            } else if (split[1].equals("ORANGE")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.white));
                this.f73646i.setBackgroundColor(b.c(a.this.f73629a, R.color.white));
                this.f73646i.setEnabled(false);
            } else if (split[1].equals("LEADING_DAYS")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.white));
                this.f73646i.setBackgroundColor(b.c(a.this.f73629a, R.color.white));
            } else if (split[1].equals("WHITE")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.color_000000));
            } else if (split[1].equals("SELECTED_CHECKIN_DATE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                    if ((i2 + 1) % 7 != 0) {
                        this.j.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                    }
                } else {
                    this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                    if ((i2 + 1) % 7 != 0) {
                        this.j.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                    }
                }
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.color_000000));
            } else if (split[1].equals("RESETED_CHECKIN_DATE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                } else {
                    this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                }
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.color_000000));
                this.f73646i.setEnabled(false);
            } else if (split[1].equals("SELECTED_CHECKOUT_DATE")) {
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.color_000000));
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                    if (i2 % 7 != 0) {
                        this.j.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                    }
                } else {
                    this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.circle));
                    if (i2 % 7 != 0) {
                        this.j.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                    }
                }
            } else if (split[1].equals("INTERMEDIATE_BLUE")) {
                this.f73646i.setBackgroundColor(b.c(a.this.f73629a, R.color.paytm_blue));
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.white));
                if (i2 % 7 == 0) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                    } else {
                        this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                    }
                }
                if ((i2 + 1) % 7 == 0) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                    } else {
                        this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                    }
                }
            } else if (split[1].equals("MONTH_END_BLUE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                } else {
                    this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_left_rounded_background));
                }
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.white));
            } else if (split[1].equals("MONTH_START_BLUE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f73646i.setBackground(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                } else {
                    this.f73646i.setBackgroundDrawable(a.this.f73629a.getResources().getDrawable(net.one97.paytm.common.assets.R.drawable.hotel_calender_right_rounded_background));
                }
                this.f73646i.setTextColor(b.c(a.this.f73629a, R.color.white));
            }
            return view;
        }

        public final void onClick(View view) {
            try {
                if (!net.one97.paytm.o2o.amparkeventcommonlib.b.a.INSTANCE.validateIsAlreadyClicked(this, view)) {
                    String str = (String) view.getTag();
                    String format = new SimpleDateFormat("yyyy-MM-dd", a.this.m).format(this.k.parse(str));
                    StringBuilder sb = new StringBuilder("selected date  by user is ");
                    sb.append(str);
                    sb.append(" formated date is ");
                    sb.append(format);
                    com.paytm.utility.b.j();
                    a.this.a(format);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|(1:6)(1:(12:9|11|(1:13)|14|(1:(1:17)(2:18|(1:20)))|21|(3:24|25|22)|48|26|(7:29|30|(3:32|33|(3:35|(2:37|51)(2:38|(2:40|52)(2:41|53))|46))|42|(2:44|54)(2:45|50)|46|27)|49|56)(1:10))|7|11|(0)|14|(0)|21|(1:22)|48|26|(1:27)|49|56) */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0044 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[SYNTHETIC, Splitter:B:24:0x0056] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: Exception | IndexOutOfBoundsException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0008] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0012 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(int r11, int r12) {
            /*
                r10 = this;
                int r0 = r11 + -1
                int[] r1 = r10.f73642e     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0008 }
                r1 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0008 }
                r10.f73643f = r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0008 }
            L_0x0008:
                java.util.GregorianCalendar r1 = new java.util.GregorianCalendar     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r2 = 1
                r1.<init>(r12, r0, r2)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3 = 11
                if (r0 != r3) goto L_0x001b
                int r3 = r0 + -1
                int[] r4 = r10.f73642e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4 = r4[r3]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
            L_0x0018:
                r5 = r3
                r3 = r12
                goto L_0x002f
            L_0x001b:
                if (r0 != 0) goto L_0x0028
                int r4 = r12 + -1
                int[] r5 = r10.f73642e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5 = r5[r3]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3 = r4
                r4 = r5
                r5 = 11
                goto L_0x002f
            L_0x0028:
                int r3 = r0 + -1
                int[] r4 = r10.f73642e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4 = r4[r3]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x0018
            L_0x002f:
                r6 = 7
                int r6 = r1.get(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r7 = 2
                int r6 = r6 - r7
                if (r6 >= 0) goto L_0x003a
                int r6 = r6 + 7
            L_0x003a:
                int r8 = r1.get(r2)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                boolean r1 = r1.isLeapYear(r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r1 == 0) goto L_0x0051
                if (r11 != r7) goto L_0x004c
                int r11 = r10.f73643f     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r11 = r11 + r2
                r10.f73643f = r11     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x0051
            L_0x004c:
                r1 = 3
                if (r11 != r1) goto L_0x0051
                int r4 = r4 + 1
            L_0x0051:
                r11 = 0
            L_0x0052:
                java.lang.String r1 = "-"
                if (r11 >= r6) goto L_0x0084
                java.util.List<java.lang.String> r7 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r8.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r9 = r4 - r6
                int r9 = r9 + r2
                int r9 = r9 + r11
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r9 = "-ORANGE-"
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r9 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r9 = r9[r5]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r8.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r8.append(r3)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r1 = r8.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r7.add(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r11 = r11 + 1
                goto L_0x0052
            L_0x0084:
                r11 = 1
            L_0x0085:
                int r3 = r10.f73643f     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r11 > r3) goto L_0x0193
                net.one97.paytm.o2o.amusementpark.utils.a r3 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r3 = r3.f73630b     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r3 = r3 - r2
                java.lang.String r4 = "-WHITE-"
                java.lang.String r5 = "-GREY-"
                if (r0 != r3) goto L_0x012e
                net.one97.paytm.o2o.amusementpark.utils.a r3 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r3 = r3.f73633e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r12 != r3) goto L_0x012e
                net.one97.paytm.o2o.amusementpark.utils.a r3 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r3 = r3.f73631c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r11 >= r3) goto L_0x00c7
                java.util.List<java.lang.String> r3 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r5 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5 = r5[r0]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x018f
            L_0x00c7:
                net.one97.paytm.o2o.amusementpark.utils.a r3 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                net.one97.paytm.o2o.amusementpark.utils.a r6 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r6 = r6.f73632d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r7 = r0 + 1
                java.lang.String r7 = java.lang.String.format("%02d", new java.lang.Object[]{java.lang.Integer.valueOf(r7)})     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r8 = java.lang.String.format("%02d", new java.lang.Object[]{java.lang.Integer.valueOf(r11)})     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                boolean r3 = r3.y.contains(r6 + "-" + r7 + "-" + r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r3 == 0) goto L_0x0108
                java.util.List<java.lang.String> r3 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r4 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4 = r4[r0]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r4 = r5.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x018f
            L_0x0108:
                java.util.List<java.lang.String> r3 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r5 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5 = r5[r0]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x018f
            L_0x012e:
                net.one97.paytm.o2o.amusementpark.utils.a r3 = net.one97.paytm.o2o.amusementpark.utils.a.this     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                int r7 = r0 + 1
                java.lang.String r7 = java.lang.String.format("%02d", new java.lang.Object[]{java.lang.Integer.valueOf(r7)})     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r8 = java.lang.String.format("%02d", new java.lang.Object[]{java.lang.Integer.valueOf(r11)})     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                boolean r3 = r3.y.contains(r6 + "-" + r7 + "-" + r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                if (r3 == 0) goto L_0x016a
                java.util.List<java.lang.String> r3 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r4 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4 = r4[r0]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5.append(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r4 = r5.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                goto L_0x018f
            L_0x016a:
                java.util.List<java.lang.String> r3 = r10.f73640c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String[] r5 = r10.f73641d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r5 = r5[r0]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r4.append(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
                r3.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0193, Exception | IndexOutOfBoundsException -> 0x0193 }
            L_0x018f:
                int r11 = r11 + 1
                goto L_0x0085
            L_0x0193:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.utils.a.C1477a.a(int, int):void");
        }

        public final /* synthetic */ Object getItem(int i2) {
            return this.f73640c.get(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public final void a(Activity activity) {
        this.f73629a = activity;
    }

    public final void a() {
        this.f73629a = null;
    }
}

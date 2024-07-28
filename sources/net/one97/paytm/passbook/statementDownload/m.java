package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.e;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.passbook.R;

public final class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    int f58725a;

    /* renamed from: b  reason: collision with root package name */
    int f58726b;

    /* renamed from: c  reason: collision with root package name */
    int f58727c;

    /* renamed from: d  reason: collision with root package name */
    int f58728d;

    /* renamed from: e  reason: collision with root package name */
    int f58729e;

    /* renamed from: f  reason: collision with root package name */
    protected Activity f58730f;

    /* renamed from: g  reason: collision with root package name */
    b f58731g;

    /* renamed from: h  reason: collision with root package name */
    Locale f58732h;

    /* renamed from: i  reason: collision with root package name */
    String f58733i;
    boolean j;
    final SimpleDateFormat k = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    private RelativeLayout l;
    private RelativeLayout m;
    private GridView n;
    private a o;
    private Calendar p;
    private String q = "dd MMM yyyy";
    private TextView r;

    public interface b {
        boolean a(String str);

        boolean a(String str, int i2);
    }

    public final void a(View view, boolean z) {
        int g2 = com.paytm.utility.b.g((Context) this.f58730f);
        this.j = z;
        Activity activity = this.f58730f;
        if (activity != null) {
            this.f58731g = (b) activity;
        }
        this.f58732h = this.f58730f.getResources().getConfiguration().locale;
        this.p = Calendar.getInstance(this.f58732h);
        int i2 = g2 + g2;
        view.findViewById(R.id.calendar_header).setPadding(0, i2, 0, i2);
        this.l = (RelativeLayout) view.findViewById(R.id.prevMonthlyt);
        this.l.setOnClickListener(this);
        this.r = (TextView) view.findViewById(R.id.currentMonth);
        this.r.setText(DateFormat.format(this.q, this.p.getTime()).toString());
        this.m = (RelativeLayout) view.findViewById(R.id.nextMonthlyt);
        this.m.setOnClickListener(this);
        this.n = (GridView) view.findViewById(R.id.calendar);
        if (z) {
            this.m.setVisibility(4);
        }
    }

    private static String a(int i2) {
        return new DateFormatSymbols().getMonths()[i2 - 1];
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4) {
        if (i2 != 0) {
            try {
                TextView textView = this.r;
                textView.setText(a(i3) + " " + i2);
            } catch (Exception | IndexOutOfBoundsException unused) {
                return;
            }
        }
        this.o.a(i4, i3, i2);
        this.o.notifyDataSetChanged();
    }

    public final void b(int i2, int i3, int i4) {
        if (i2 != 0) {
            try {
                TextView textView = this.r;
                textView.setText(a(i3) + " " + i2);
            } catch (Exception | IndexOutOfBoundsException unused) {
            }
        }
        this.f58726b = i3;
        this.f58725a = i2;
        this.f58727c = i4;
        this.o = new a(i4, i3, i2, this.f58730f);
        this.n.setAdapter(this.o);
        this.o.notifyDataSetChanged();
    }

    public final void onClick(View view) {
        if (view == this.l) {
            this.m.setVisibility(0);
            int i2 = this.f58729e;
            if (i2 <= 1) {
                this.f58729e = 12;
                this.f58728d--;
            } else {
                this.f58729e = i2 - 1;
            }
            if (this.f58729e == 1 && this.f58728d == 2014) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
            }
            a(this.f58728d, this.f58729e, 0);
        }
        if (view == this.m) {
            this.l.setVisibility(0);
            int i3 = this.f58729e;
            if (i3 > 11) {
                this.f58729e = 1;
                this.f58728d++;
            } else {
                this.f58729e = i3 + 1;
            }
            if (this.p.get(2) + 1 == this.f58729e && this.p.get(1) == this.f58728d) {
                this.m.setVisibility(4);
            } else {
                this.m.setVisibility(0);
            }
            a(this.f58728d, this.f58729e, 0);
        }
    }

    public class a extends BaseAdapter implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final Context f58735b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f58736c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f58737d = e.l;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f58738e = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /* renamed from: f  reason: collision with root package name */
        private int f58739f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f58740g;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public a(int i2, int i3, int i4, Context context) {
            this.f58735b = context;
            this.f58736c = new ArrayList();
            a(i2, i3, i4);
        }

        public final void a(int i2, int i3, int i4) {
            m mVar = m.this;
            mVar.f58729e = i3;
            mVar.f58728d = i4;
            if (mVar.f58725a == i4 && m.this.f58726b == i3) {
                i2 = m.this.f58727c;
            }
            b(i2, i3, i4);
        }

        public final int getCount() {
            return this.f58736c.size();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0017 */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[SYNTHETIC, Splitter:B:26:0x0068] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009e A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00fd A[Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }, LOOP:2: B:36:0x00f4->B:38:0x00fd, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[ExcHandler: Exception | IndexOutOfBoundsException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0006] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(int r18, int r19, int r20) {
            /*
                r17 = this;
                r0 = r17
                r1 = r19
                r2 = r20
                java.util.List<java.lang.String> r3 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                if (r3 == 0) goto L_0x000f
                java.util.List<java.lang.String> r3 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r3.clear()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
            L_0x000f:
                int r3 = r1 + -1
                int[] r4 = r0.f58738e     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017, Exception | IndexOutOfBoundsException -> 0x0127 }
                r4 = r4[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017, Exception | IndexOutOfBoundsException -> 0x0127 }
                r0.f58739f = r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017, Exception | IndexOutOfBoundsException -> 0x0127 }
            L_0x0017:
                java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r5 = 1
                r4.<init>(r2, r3, r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r6 = 0
                r7 = 11
                if (r3 != r7) goto L_0x002f
                int r7 = r3 + -1
                int[] r8 = r0.f58738e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8 = r8[r7]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r9 = r2 + 1
                r11 = r9
                r10 = 0
                r9 = r8
                r8 = r2
                goto L_0x0045
            L_0x002f:
                if (r3 != 0) goto L_0x003a
                int r8 = r2 + -1
                int[] r9 = r0.f58738e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r9 = r9[r7]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r11 = r2
                r10 = 1
                goto L_0x0045
            L_0x003a:
                int r7 = r3 + -1
                int r8 = r3 + 1
                int[] r9 = r0.f58738e     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r9 = r9[r7]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r11 = r2
                r10 = r8
                r8 = r11
            L_0x0045:
                r12 = 7
                int r13 = r4.get(r12)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r13 = r13 - r5
                int r14 = r4.get(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                boolean r4 = r4.isLeapYear(r14)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                if (r4 == 0) goto L_0x0063
                r4 = 2
                if (r1 != r4) goto L_0x005e
                int r1 = r0.f58739f     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r1 = r1 + r5
                r0.f58739f = r1     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                goto L_0x0063
            L_0x005e:
                r4 = 3
                if (r1 != r4) goto L_0x0063
                int r9 = r9 + 1
            L_0x0063:
                r1 = 0
            L_0x0064:
                java.lang.String r4 = "-"
                if (r1 >= r13) goto L_0x0099
                java.util.List<java.lang.String> r14 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r15.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r16 = r9 - r13
                int r16 = r16 + 1
                int r16 = r16 + r1
                java.lang.String r5 = java.lang.String.valueOf(r16)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r15.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r5 = "-ORANGE-"
                r15.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String[] r5 = r0.f58737d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r5 = r5[r7]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r15.append(r5)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r15.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r15.append(r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r4 = r15.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r14.add(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r1 = r1 + 1
                r5 = 1
                goto L_0x0064
            L_0x0099:
                r1 = 1
            L_0x009a:
                int r5 = r0.f58739f     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                if (r1 > r5) goto L_0x00f4
                r5 = r18
                if (r1 != r5) goto L_0x00ca
                java.util.List<java.lang.String> r7 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r9 = java.lang.String.valueOf(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r9 = "-RESETED_CHECKIN_DATE-"
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String[] r9 = r0.f58737d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r9 = r9[r3]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r2)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r7.add(r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                goto L_0x00f1
            L_0x00ca:
                java.util.List<java.lang.String> r7 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r9 = java.lang.String.valueOf(r1)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r9 = "-WHITE-"
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String[] r9 = r0.f58737d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r9 = r9[r3]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r9)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r8.append(r2)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r7.add(r8)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
            L_0x00f1:
                int r1 = r1 + 1
                goto L_0x009a
            L_0x00f4:
                java.util.List<java.lang.String> r1 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r1 = r1.size()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r1 = r1 % r12
                if (r6 >= r1) goto L_0x0127
                java.util.List<java.lang.String> r1 = r0.f58736c     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r2.<init>()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                int r6 = r6 + 1
                java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r2.append(r3)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r3 = "-LEADING_DAYS-"
                r2.append(r3)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String[] r3 = r0.f58737d     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r3 = r3[r10]     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r2.append(r3)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r2.append(r4)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r2.append(r11)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                r1.add(r2)     // Catch:{ Exception | IndexOutOfBoundsException -> 0x0127 }
                goto L_0x00f4
            L_0x0127:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.statementDownload.m.a.b(int, int, int):void");
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AnonymousClass1 r7 = view;
            if (view == null) {
                AnonymousClass1 r72 = new TextView(m.this.f58730f) {
                    /* access modifiers changed from: protected */
                    public final void onMeasure(int i2, int i3) {
                        int size = View.MeasureSpec.getSize(i2);
                        setMeasuredDimension(size, size);
                    }
                };
                r72.setGravity(17);
                r72.setTextSize(2, 16.0f);
                r7 = r72;
            }
            this.f58740g = (TextView) r7;
            this.f58740g.setTag(Integer.valueOf(i2));
            this.f58740g.setOnClickListener(this);
            String[] split = this.f58736c.get(i2).split("-");
            String str = split[0];
            String str2 = split[2];
            String str3 = split[3];
            this.f58740g.setText(str);
            TextView textView = this.f58740g;
            textView.setTag(str + "-" + str2 + "-" + str3);
            if (split[1].equals("ORANGE")) {
                this.f58740g.setTextColor(Color.parseColor("#ffffff"));
                this.f58740g.setBackgroundColor(Color.parseColor("#ffffff"));
            } else if (split[1].equals("LEADING_DAYS")) {
                this.f58740g.setTextColor(Color.parseColor("#ffffff"));
                this.f58740g.setBackgroundColor(Color.parseColor("#ffffff"));
            } else if (split[1].equals("WHITE")) {
                this.f58740g.setTextColor(Color.parseColor("#000000"));
                this.f58740g.setBackgroundColor(Color.parseColor("#ffffff"));
            } else if (split[1].equals("RESETED_CHECKIN_DATE")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f58740g.setBackground(m.this.f58730f.getResources().getDrawable(R.drawable.pass_circle_filled));
                } else {
                    this.f58740g.setBackgroundDrawable(m.this.f58730f.getResources().getDrawable(R.drawable.pass_circle_filled));
                }
                this.f58740g.setTextColor(Color.parseColor("#ffffff"));
            }
            return r7;
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            try {
                if (m.this.f58731g != null) {
                    if (m.this.f58731g.a(str.replace("-", " "), m.this.j ? 1 : 0)) {
                        Date parse = m.this.k.parse(str);
                        String str2 = "dd MMM yy";
                        if (!TextUtils.isEmpty(m.this.f58733i)) {
                            str2 = m.this.f58733i;
                        }
                        String format = new SimpleDateFormat(str2, m.this.f58732h).format(parse);
                        Calendar instance = Calendar.getInstance(m.this.f58732h);
                        instance.setTime(parse);
                        m.this.f58726b = instance.get(2) + 1;
                        m.this.f58725a = instance.get(1);
                        m.this.f58727c = instance.get(5);
                        m.this.f58731g.a(format);
                        m.this.a(instance.get(1), instance.get(2) + 1, instance.get(5));
                    }
                }
            } catch (ParseException unused) {
            }
        }

        public final /* synthetic */ Object getItem(int i2) {
            return this.f58736c.get(i2);
        }
    }

    public final void a(Activity activity) {
        this.f58730f = activity;
    }

    public final void a() {
        this.f58730f = null;
    }
}

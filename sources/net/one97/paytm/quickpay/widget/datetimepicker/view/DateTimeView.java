package net.one97.paytm.quickpay.widget.datetimepicker.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.one97.paytm.common.entity.quick_pay.ReminderItem;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.widget.datetimepicker.b.a;
import net.one97.paytm.quickpay.widget.datetimepicker.b.b;
import net.one97.paytm.utils.ao;

public class DateTimeView extends View implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ReminderItem> f60151a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f60152b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f60153c = "";

    /* renamed from: d  reason: collision with root package name */
    private Context f60154d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f60155e;

    /* renamed from: f  reason: collision with root package name */
    private j f60156f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f60157g;

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f60158h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f60159i;
    private RadioGroup j;
    private float k = 0.0f;
    private String l = "";
    private RelativeLayout m;
    private RelativeLayout n;

    public DateTimeView(Context context) {
        super(context);
    }

    public DateTimeView(Context context, j jVar, b bVar) {
        super(context);
        this.f60154d = context;
        this.f60156f = jVar;
        this.f60157g = bVar;
        this.f60152b = 2;
        a();
        setSelectedDateDay(2);
        ((TextView) this.f60155e.findViewById(R.id.txt_selected_date)).setText(Html.fromHtml(getDateString()));
        b();
    }

    public DateTimeView(Context context, j jVar, b bVar, int i2, String str, float f2, String str2) {
        super(context);
        this.f60154d = context;
        this.f60156f = jVar;
        this.f60157g = bVar;
        this.f60152b = i2;
        this.f60153c = str;
        this.k = f2;
        this.l = str2;
        a();
        int i3 = 1;
        if (i2 == 0) {
            ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDateString()));
            a(true);
            i3 = 0;
        } else if (i2 == 2) {
            ((TextView) this.f60155e.findViewById(R.id.txt_selected_date)).setText(Html.fromHtml(getDateString()));
            i3 = 2;
        } else {
            ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDayString()));
            a(false);
        }
        bVar.a(str, i3);
        if (i3 != 2) {
            b();
        }
    }

    public View getDateView() {
        return this.f60155e;
    }

    private void a() {
        this.f60155e = ((LayoutInflater) this.f60154d.getSystemService("layout_inflater")).inflate(R.layout.remind_payment_main_lyt, (ViewGroup) null, false);
        this.f60155e.findViewById(R.id.picker).setOnClickListener(this);
        this.f60155e.findViewById(R.id.txt_change_date).setOnClickListener(this);
        this.m = (RelativeLayout) this.f60155e.findViewById(R.id.ll_reminder_v2);
        this.n = (RelativeLayout) this.f60155e.findViewById(R.id.rl_reminder);
        if (this.f60152b == 2) {
            this.m.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
        }
        this.f60159i = (RadioButton) this.f60155e.findViewById(R.id.monthly_radio_button);
        this.f60158h = (RadioButton) this.f60155e.findViewById(R.id.weekly_radio_button);
        this.j = (RadioGroup) this.f60155e.findViewById(R.id.date_day_group);
        TextView textView = (TextView) this.f60155e.findViewById(R.id.txt_remind_payment);
        float f2 = this.k;
        if (f2 != 0.0f) {
            textView.setTextSize(0, f2);
        }
        if (!TextUtils.isEmpty(this.l)) {
            textView.setText(this.l);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.picker || id == R.id.txt_change_date) {
            this.f60151a = new ArrayList<>();
            int i2 = this.f60152b;
            if (i2 == 0 || i2 == 2) {
                for (int i3 = 1; i3 <= 31; i3++) {
                    this.f60151a.add(new ReminderItem(String.valueOf(i3), false));
                }
            } else {
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_monday), this.f60154d.getString(R.string.mon), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_tuesday), this.f60154d.getString(R.string.tue), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_wednesday), this.f60154d.getString(R.string.wed), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_thursday), this.f60154d.getString(R.string.thu), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_friday), this.f60154d.getString(R.string.fri), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_saturday), this.f60154d.getString(R.string.sat), false));
                this.f60151a.add(new ReminderItem(this.f60154d.getString(R.string.qp_sunday), this.f60154d.getString(R.string.sun), false));
            }
            a a2 = a.a(new a() {
                public final void a(String str) {
                    String unused = DateTimeView.this.f60153c = str;
                    if (DateTimeView.this.f60152b == 0) {
                        ((TextView) DateTimeView.this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(DateTimeView.this.getDateString()));
                    } else if (DateTimeView.this.f60152b == 2) {
                        ((TextView) DateTimeView.this.f60155e.findViewById(R.id.txt_selected_date)).setText(Html.fromHtml(DateTimeView.this.getDateString()));
                    } else {
                        ((TextView) DateTimeView.this.f60155e.findViewById(R.id.day_moth_txt)).setText(DateTimeView.this.getDayString());
                    }
                    DateTimeView.this.f60157g.a(str, DateTimeView.this.f60152b);
                }
            }, this.f60151a, this.f60152b, this.f60153c);
            ao.a(getClass(), getClass().getName());
            a2.show(this.f60156f.a(), (String) null);
        } else if (id == R.id.monthly_container) {
            this.f60152b = 0;
            setSelectedDateDay(this.f60152b);
            a(true);
            ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDateString()));
        } else if (id == R.id.weekly_container) {
            this.f60152b = 1;
            setSelectedDateDay(this.f60152b);
            a(false);
            ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDayString()));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f60152b = 0;
            this.f60159i.setChecked(true);
            this.f60159i.setTypeface((Typeface) null, 1);
            this.f60158h.setTypeface((Typeface) null, 0);
            ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDateString()));
            return;
        }
        this.f60152b = 1;
        this.f60158h.setChecked(true);
        this.f60159i.setTypeface((Typeface) null, 0);
        this.f60158h.setTypeface((Typeface) null, 1);
        ((TextView) this.f60155e.findViewById(R.id.day_moth_txt)).setText(Html.fromHtml(getDayString()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDateString() {
        /*
            r7 = this;
            java.lang.String r0 = r7.f60153c
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case 49: goto L_0x0044;
                case 50: goto L_0x003a;
                case 51: goto L_0x0030;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r1) {
                case 1599: goto L_0x0026;
                case 1600: goto L_0x001c;
                case 1601: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x004e
        L_0x0012:
            java.lang.String r1 = "23"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 4
            goto L_0x004f
        L_0x001c:
            java.lang.String r1 = "22"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 5
            goto L_0x004f
        L_0x0026:
            java.lang.String r1 = "21"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 3
            goto L_0x004f
        L_0x003a:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 2
            goto L_0x004f
        L_0x0044:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = 0
            goto L_0x004f
        L_0x004e:
            r0 = -1
        L_0x004f:
            r1 = 2131954911(0x7f130cdf, float:1.9546335E38)
            if (r0 == 0) goto L_0x00e4
            if (r0 == r6) goto L_0x00cf
            if (r0 == r5) goto L_0x00ba
            if (r0 == r4) goto L_0x00a5
            if (r0 == r3) goto L_0x0090
            if (r0 == r2) goto L_0x007b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r7.f60153c
            r0.append(r2)
            java.lang.String r2 = "<sup><small>th</small></sup> "
            r0.append(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x007b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "22<sup><small>nd</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0090:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "23<sup><small>rd</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00a5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "3<sup><small>rd</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00ba:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "2<sup><small>nd</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00cf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "21<sup><small>st</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00e4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "1<sup><small>st</small></sup> "
            r0.<init>(r2)
            android.content.Context r2 = r7.f60154d
            java.lang.String r1 = r2.getString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.widget.datetimepicker.view.DateTimeView.getDateString():java.lang.String");
    }

    /* access modifiers changed from: private */
    public String getDayString() {
        return this.f60153c + " " + this.f60154d.getString(R.string.every_week);
    }

    /* access modifiers changed from: private */
    public void setSelectedDateDay(int i2) {
        String str;
        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if (i2 == 0 || i2 == 2) {
            str = String.valueOf(date.getDate());
        } else {
            str = "MONDAY";
        }
        this.f60153c = str;
        b bVar = this.f60157g;
        if (bVar != null) {
            bVar.a(this.f60153c, this.f60152b);
        }
    }

    public String getSelectedDateDay() {
        return this.f60153c;
    }

    private void b() {
        this.j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == R.id.monthly_radio_button) {
                    int unused = DateTimeView.this.f60152b = 0;
                    DateTimeView dateTimeView = DateTimeView.this;
                    dateTimeView.setSelectedDateDay(dateTimeView.f60152b);
                    DateTimeView.this.a(true);
                } else if (i2 == R.id.weekly_radio_button) {
                    int unused2 = DateTimeView.this.f60152b = 1;
                    DateTimeView dateTimeView2 = DateTimeView.this;
                    dateTimeView2.setSelectedDateDay(dateTimeView2.f60152b);
                    DateTimeView.this.a(false);
                }
            }
        });
    }
}

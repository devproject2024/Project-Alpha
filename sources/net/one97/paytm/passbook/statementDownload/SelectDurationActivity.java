package net.one97.paytm.passbook.statementDownload;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.j;
import com.paytm.utility.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.mapping.a;
import net.one97.paytm.passbook.statementDownload.k;
import net.one97.paytm.passbook.statementDownload.m;
import net.one97.paytm.upi.util.UpiConstants;

public class SelectDurationActivity extends BaseActivity implements View.OnClickListener, k.a, m.b {

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f58596a;

    /* renamed from: b  reason: collision with root package name */
    TabPageIndicator f58597b;

    /* renamed from: c  reason: collision with root package name */
    private k f58598c;

    /* renamed from: d  reason: collision with root package name */
    private CJRSmoothScrollViewPager f58599d;

    /* renamed from: e  reason: collision with root package name */
    private String f58600e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f58601f = "";

    /* renamed from: g  reason: collision with root package name */
    private SimpleDateFormat f58602g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f58603h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f58604i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_w_passbook_module_calender);
        this.f58603h = getIntent().getBooleanExtra("removeDurationLimit", false);
        this.f58604i = getIntent().getBooleanExtra("45daysCheck", false);
        this.f58596a = (LayoutInflater) getSystemService("layout_inflater");
        this.f58599d = (CJRSmoothScrollViewPager) findViewById(R.id.id_passbook_calender_view_pager);
        j supportFragmentManager = getSupportFragmentManager();
        ArrayList arrayList = new ArrayList();
        l lVar = new l();
        lVar.f58721a = UpiConstants.FROM;
        arrayList.add(lVar);
        l lVar2 = new l();
        lVar2.f58721a = "To";
        arrayList.add(lVar2);
        this.f58598c = new k(this, supportFragmentManager, arrayList);
        this.f58599d.setAdapter(this.f58598c);
        findViewById(R.id.id_passbook_calendar_cancel_tv).setOnClickListener(this);
        findViewById(R.id.id_passbook_calendar_proceed_tv).setOnClickListener(this);
        this.f58597b = (TabPageIndicator) findViewById(R.id.id_passbook_indicator);
        this.f58597b.setViewPager(this.f58599d);
        Locale locale = getResources().getConfiguration().locale;
        Calendar instance = Calendar.getInstance();
        this.f58602g = new SimpleDateFormat("dd MMM yyyy", locale);
        this.f58601f = this.f58602g.format(instance.getTime());
        instance.add(2, -1);
        this.f58600e = this.f58602g.format(instance.getTime());
        a(0, this.f58600e);
        a(1, this.f58601f);
        this.f58599d.setCurrentItem(0);
    }

    public final boolean a(String str) {
        if (str != null) {
            if (this.f58599d.getCurrentItem() != 0 || this.f58597b == null) {
                a(1, str);
                this.f58601f = str;
            } else {
                this.f58600e = str;
                this.f58599d.setCurrentItem(1);
                a(0, str);
                return true;
            }
        }
        return true;
    }

    private void a(int i2, String str) {
        View a2 = this.f58597b.a(i2);
        String[] split = str.split(" ");
        if (split.length >= 3) {
            ((TextView) a2.findViewById(R.id.datepicker_tab_date_tv)).setText(split[0]);
            ((TextView) a2.findViewById(R.id.datepicker_tab_month_tv)).setText(split[1]);
            ((TextView) a2.findViewById(R.id.datepicker_tab_year_tv)).setText(split[2]);
            this.f58597b.invalidate();
        }
    }

    public final boolean a(String str, int i2) {
        try {
            Date parse = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(str);
            String format = this.f58602g.format(parse);
            String str2 = i2 == 0 ? format : this.f58600e;
            if (i2 != 1) {
                format = this.f58601f;
            }
            Date date = new Date();
            Date date2 = null;
            Date parse2 = !TextUtils.isEmpty(str2) ? this.f58602g.parse(str2) : null;
            if (!TextUtils.isEmpty(format)) {
                date2 = this.f58602g.parse(format);
            }
            if (parse.compareTo(date) > 0) {
                Toast.makeText(this, getString(R.string.error_choose_date_g_today), 0).show();
                return false;
            } else if (parse2.compareTo(date2) <= 0) {
                return true;
            } else {
                Toast.makeText(this, getString(R.string.error_to_g_from), 0).show();
                return false;
            }
        } catch (ParseException unused) {
            return false;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.id_passbook_calendar_cancel_tv) {
            setResult(0);
            finish();
        } else if (id != R.id.id_passbook_calendar_proceed_tv) {
        } else {
            if (!a.c((Context) this)) {
                a();
            } else if (TextUtils.isEmpty(this.f58600e) || TextUtils.isEmpty(this.f58601f)) {
                b();
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
                try {
                    int a2 = b.a(simpleDateFormat.parse(this.f58600e), simpleDateFormat.parse(this.f58601f));
                    if (!this.f58603h && a2 > 12) {
                        Toast.makeText(this, getString(R.string.error_to_date_range_merchant_from), 0).show();
                    } else if (!this.f58604i || a.c(simpleDateFormat.parse(this.f58600e), simpleDateFormat.parse(this.f58601f)) <= 44) {
                        b();
                    } else {
                        Toast.makeText(this, getString(R.string.pass_fastag_45_days_error), 0).show();
                    }
                } catch (ParseException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent();
        intent.putExtra("from", this.f58600e);
        intent.putExtra("to", this.f58601f);
        setResult(-1, intent);
        finish();
    }

    public final void a() {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (a.c((Context) SelectDurationActivity.this)) {
                        SelectDurationActivity.this.b();
                    } else {
                        SelectDurationActivity.this.a();
                    }
                }
            });
            builder.show();
        }
    }
}

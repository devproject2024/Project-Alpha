package net.one97.paytm.upi.requestmoney.view.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.google.android.material.tabs.TabLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.one97.paytm.i.g;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.requestmoney.view.a.a;
import net.one97.paytm.upi.requestmoney.view.a.d;
import net.one97.paytm.upi.util.CustomViewPager;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends g implements a.C1404a, d.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static c f69356a;

    /* renamed from: b  reason: collision with root package name */
    private Context f69357b;

    /* renamed from: c  reason: collision with root package name */
    private CustomViewPager f69358c;

    /* renamed from: d  reason: collision with root package name */
    private a f69359d;

    /* renamed from: e  reason: collision with root package name */
    private TabLayout f69360e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f69361f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f69362g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f69363h;

    /* renamed from: i  reason: collision with root package name */
    private Date f69364i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public Date k;
    /* access modifiers changed from: private */
    public Date l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public Calendar n;
    private int o = 524308;

    public static b a(c cVar, Date date, Date date2, Date date3, int i2) {
        f69356a = cVar;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("initialDate", date);
        bundle.putSerializable("minDate", date2);
        bundle.putSerializable("maxDate", date3);
        bundle.putBoolean("is24HourTime", false);
        bundle.putInt("theme", i2);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f69357b = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        this.f69364i = (Date) arguments.getSerializable("initialDate");
        this.k = (Date) arguments.getSerializable("minDate");
        this.l = (Date) arguments.getSerializable("maxDate");
        this.m = arguments.getBoolean("is24HourTime");
        this.j = arguments.getInt("theme");
        this.n = Calendar.getInstance();
        this.n.setTime(this.f69364i);
        int i2 = this.j;
        if (i2 == 1) {
            setStyle(1, 16973937);
        } else if (i2 != 2) {
            setStyle(1, 16973941);
        } else {
            setStyle(1, 16973941);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.upi_slide_date_time_picker, viewGroup);
        this.f69358c = (CustomViewPager) inflate.findViewById(R.id.viewPager);
        this.f69360e = (TabLayout) inflate.findViewById(R.id.tl_upi_tabs);
        this.f69361f = (TextView) inflate.findViewById(R.id.tv_setExpiry);
        this.f69362g = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.f69363h = (TextView) inflate.findViewById(R.id.tv_header);
        this.f69359d = new a(getChildFragmentManager());
        this.f69358c.setAdapter(this.f69359d);
        this.f69360e.setupWithViewPager(this.f69358c);
        float applyDimension = TypedValue.applyDimension(1, 45.0f, getResources().getDisplayMetrics());
        TabLayout tabLayout = this.f69360e;
        int i2 = (int) applyDimension;
        View childAt = tabLayout.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) childAt;
            for (int i3 = 0; i3 < viewGroup2.getChildCount(); i3++) {
                View childAt2 = viewGroup2.getChildAt(i3);
                if (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) childAt2.getLayoutParams()).leftMargin = i2;
                    ((ViewGroup.MarginLayoutParams) childAt2.getLayoutParams()).rightMargin = i2;
                }
            }
            tabLayout.requestLayout();
        }
        this.f69361f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.f69356a != null) {
                    long minutesfromDate = UpiUtils.getMinutesfromDate(b.this.n.getTime());
                    if (minutesfromDate > 64800) {
                        Toast.makeText(b.this.getActivity(), "Maximum Expire Time is 45 days.", 0).show();
                    } else if (minutesfromDate < 1) {
                        Toast.makeText(b.this.getActivity(), "Minimum Expire time is 1 min.", 0).show();
                    } else {
                        b.f69356a.a(b.this.n.getTime(), b.this.f69363h.getText().toString().trim());
                        b.this.dismiss();
                    }
                } else {
                    throw new NullPointerException("Listener no longer exists for mOkButton");
                }
            }
        });
        this.f69362g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.f69356a != null) {
                    c unused = b.f69356a;
                    b.this.dismiss();
                    return;
                }
                throw new NullPointerException("Listener no longer exists for mCancelButton");
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public final void a(int i2, int i3, int i4) {
        this.n.set(i2, i3, i4);
        b();
    }

    public final void a(int i2, int i3) {
        this.n.set(11, i2);
        this.n.set(12, i3);
        b();
    }

    private void b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm aa");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy");
        TextView textView = this.f69363h;
        textView.setText(simpleDateFormat2.format(this.n.getTime()) + ", " + simpleDateFormat.format(this.n.getTime()));
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (f69356a == null) {
            throw new NullPointerException("Listener no longer exists in onCancel()");
        }
    }

    class a extends o {
        public final int getCount() {
            return 2;
        }

        public a(j jVar) {
            super(jVar);
        }

        public final Fragment getItem(int i2) {
            if (i2 == 0) {
                return a.a(b.this.j, b.this.n.get(1), b.this.n.get(2), b.this.n.get(5), b.this.k, b.this.l);
            }
            if (i2 != 1) {
                return null;
            }
            return d.a(b.this.j, b.this.n.get(11), b.this.n.get(12), b.this.m);
        }

        public final CharSequence getPageTitle(int i2) {
            if (i2 == 0) {
                return b.this.getResources().getString(R.string.upi_date_label);
            }
            return b.this.getResources().getString(R.string.upi_time_label);
        }
    }
}

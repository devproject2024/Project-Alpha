package net.one97.paytm.recharge.presentation.c;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.w;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.b.h;

public final class d extends net.one97.paytm.i.h implements net.one97.paytm.recharge.presentation.d.e {

    /* renamed from: a  reason: collision with root package name */
    public static final b f64827a = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.b.h f64828b;

    /* renamed from: c  reason: collision with root package name */
    private DatePickerDialog f64829c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f64830d;

    public enum a {
        EMPTY,
        LESS,
        EXCEED,
        REGEX_NOT_MATCHED
    }

    public final View a(int i2) {
        if (this.f64830d == null) {
            this.f64830d = new HashMap();
        }
        View view = (View) this.f64830d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64830d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_prepaid_automatic_payment_plan_select, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        Toolbar toolbar = (Toolbar) a(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle((CharSequence) "");
        }
        ((Toolbar) a(R.id.toolbar)).setNavigationIcon(R.drawable.ic_back);
        ((Toolbar) a(R.id.toolbar)).setNavigationOnClickListener(new C1280d(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView = (TextView) a(R.id.txt_operator_number);
            if (textView != null) {
                textView.setText(arguments.getString("recharge_number"));
            }
            TextView textView2 = (TextView) a(R.id.txt_operator_name);
            if (textView2 != null) {
                textView2.setText(arguments.getString("operator_name"));
            }
            w.a().a(arguments.getString("operator_logo")).a((ImageView) a(R.id.ic_operator_icon));
        }
        EditText editText = (EditText) a(R.id.edt_amount);
        if (editText != null) {
            editText.setOnFocusChangeListener(new e(this));
        }
        TextView textView3 = (TextView) a(R.id.edt_days);
        if (textView3 != null) {
            textView3.setOnClickListener(new f(this));
        }
        ImageView imageView = (ImageView) a(R.id.ic_calender);
        if (imageView != null) {
            imageView.setOnClickListener(new g(this));
        }
        TextView textView4 = (TextView) a(R.id.btn_proceed);
        if (textView4 != null) {
            textView4.setOnClickListener(new h(this));
        }
    }

    /* renamed from: net.one97.paytm.recharge.presentation.c.d$d  reason: collision with other inner class name */
    static final class C1280d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64833a;

        C1280d(d dVar) {
            this.f64833a = dVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f64833a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class e implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64834a;

        e(d dVar) {
            this.f64834a = dVar;
        }

        public final void onFocusChange(View view, boolean z) {
            TextView textView;
            if (z && (textView = (TextView) this.f64834a.a(R.id.txt_amount_error)) != null) {
                textView.setVisibility(8);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64835a;

        f(d dVar) {
            this.f64835a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.presentation.b.h a2;
            TextView textView = (TextView) this.f64835a.a(R.id.txt_days_error);
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (this.f64835a.f64828b == null || ((a2 = this.f64835a.f64828b) != null && !a2.isVisible())) {
                d dVar = this.f64835a;
                h.a aVar = net.one97.paytm.recharge.presentation.b.h.f64776a;
                d dVar2 = this.f64835a;
                net.one97.paytm.recharge.presentation.d.e eVar = dVar2;
                TextView textView2 = (TextView) dVar2.a(R.id.edt_days);
                String a3 = d.a(String.valueOf(textView2 != null ? textView2.getText() : null));
                k.c(eVar, "daySelectListener");
                k.c(a3, "preSelectedVal");
                Bundle bundle = new Bundle();
                bundle.putString("pre_selected_recharge_days", a3);
                net.one97.paytm.recharge.presentation.b.h.f64777c = eVar;
                net.one97.paytm.recharge.presentation.b.h hVar = new net.one97.paytm.recharge.presentation.b.h();
                hVar.setArguments(bundle);
                dVar.f64828b = hVar;
                net.one97.paytm.recharge.presentation.b.h a4 = this.f64835a.f64828b;
                if (a4 != null) {
                    a4.show(this.f64835a.getChildFragmentManager(), "");
                }
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64836a;

        g(d dVar) {
            this.f64836a = dVar;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f64836a.a(R.id.txt_start_recharge_error);
            if (textView != null) {
                textView.setVisibility(8);
            }
            d.b(this.f64836a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64837a;

        h(d dVar) {
            this.f64837a = dVar;
        }

        public final void onClick(View view) {
            EditText editText = (EditText) this.f64837a.a(R.id.edt_amount);
            if (editText != null) {
                editText.clearFocus();
            }
            if (d.c(this.f64837a)) {
                d.d(this.f64837a);
            }
        }
    }

    private final void a(a aVar, String str) {
        TextView textView = (TextView) a(R.id.txt_amount_error);
        if (textView != null) {
            textView.setVisibility(0);
        }
        int i2 = e.f64838a[aVar.ordinal()];
        if (i2 == 1) {
            TextView textView2 = (TextView) a(R.id.txt_amount_error);
            k.a((Object) textView2, "txt_amount_error");
            textView2.setText("Empty");
        } else if (i2 == 2) {
            TextView textView3 = (TextView) a(R.id.txt_amount_error);
            k.a((Object) textView3, "txt_amount_error");
            textView3.setText("Amount should not be less than ".concat(String.valueOf(str)));
        } else if (i2 == 3) {
            TextView textView4 = (TextView) a(R.id.txt_amount_error);
            k.a((Object) textView4, "txt_amount_error");
            textView4.setText("Amount should not be greater than ".concat(String.valueOf(str)));
        } else if (i2 == 4) {
            TextView textView5 = (TextView) a(R.id.txt_amount_error);
            k.a((Object) textView5, "txt_amount_error");
            textView5.setText("Please enter the valid amount");
        }
    }

    static final class c implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64831a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Calendar f64832b;

        c(d dVar, Calendar calendar) {
            this.f64831a = dVar;
            this.f64832b = calendar;
        }

        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            this.f64832b.set(1, i2);
            this.f64832b.set(2, i3);
            this.f64832b.set(5, i4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            TextView textView = (TextView) this.f64831a.a(R.id.edt_start_recharge);
            k.a((Object) textView, "edt_start_recharge");
            Calendar calendar = this.f64832b;
            k.a((Object) calendar, "calendar");
            String format = simpleDateFormat.format(calendar.getTime());
            textView.setText(format != null ? format.toString() : null);
        }
    }

    public final void a(int i2, String str) {
        k.c(str, "selectedDay");
        TextView textView = (TextView) a(R.id.edt_days);
        if (textView != null) {
            textView.setText(getString(R.string.recharge_days_select, str));
        }
        net.one97.paytm.recharge.presentation.b.h hVar = this.f64828b;
        if (hVar != null) {
            hVar.dismissAllowingStateLoss();
        }
    }

    public static final /* synthetic */ String a(String str) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || !p.a(charSequence, (CharSequence) "Days", false)) {
            return "";
        }
        int length = str.length() - 4;
        int length2 = str.length();
        if (str != null) {
            return p.a(charSequence, length, length2).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final /* synthetic */ void b(d dVar) {
        DatePicker datePicker;
        DatePickerDialog datePickerDialog;
        Calendar instance = Calendar.getInstance();
        if (dVar.getContext() != null || (datePickerDialog = dVar.f64829c) == null || (datePickerDialog != null && !datePickerDialog.isShowing())) {
            Context context = dVar.getContext();
            if (context == null) {
                k.a();
            }
            dVar.f64829c = new DatePickerDialog(context, new c(dVar, instance), instance.get(1), instance.get(2), instance.get(5));
            DatePickerDialog datePickerDialog2 = dVar.f64829c;
            if (!(datePickerDialog2 == null || (datePicker = datePickerDialog2.getDatePicker()) == null)) {
                k.a((Object) instance, "calendar");
                datePicker.setMinDate(instance.getTimeInMillis());
            }
            DatePickerDialog datePickerDialog3 = dVar.f64829c;
            if (datePickerDialog3 == null) {
                k.a();
            }
            datePickerDialog3.show();
        }
    }

    public static final /* synthetic */ boolean c(d dVar) {
        Bundle arguments = dVar.getArguments();
        if (arguments == null) {
            return false;
        }
        String string = arguments.getString("min_amount");
        String string2 = arguments.getString("max_amount");
        String string3 = arguments.getString("amount_field_regex");
        EditText editText = (EditText) dVar.a(R.id.edt_amount);
        CharSequence charSequence = null;
        String valueOf = String.valueOf(editText != null ? editText.getText() : null);
        CharSequence charSequence2 = valueOf;
        if (TextUtils.isEmpty(charSequence2)) {
            dVar.a(a.EMPTY, "");
            return false;
        }
        if (!TextUtils.isEmpty(string)) {
            double parseDouble = Double.parseDouble(valueOf);
            if (string == null) {
                k.a();
            }
            if (parseDouble < Double.parseDouble(string)) {
                dVar.a(a.LESS, string);
                return false;
            }
        }
        if (!TextUtils.isEmpty(string2)) {
            double parseDouble2 = Double.parseDouble(valueOf);
            if (string2 == null) {
                k.a();
            }
            if (parseDouble2 > Double.parseDouble(string2)) {
                dVar.a(a.EXCEED, string2);
                return false;
            }
        }
        if (!TextUtils.isEmpty(string3)) {
            if (string3 == null) {
                string3 = "";
            }
            if (!new l(string3).matches(charSequence2)) {
                dVar.a(a.REGEX_NOT_MATCHED, "");
                return false;
            }
        }
        TextView textView = (TextView) dVar.a(R.id.edt_days);
        CharSequence valueOf2 = String.valueOf(textView != null ? textView.getText() : null);
        if (TextUtils.isEmpty(valueOf2)) {
            if (TextUtils.isEmpty(valueOf2)) {
                TextView textView2 = (TextView) dVar.a(R.id.txt_days_error);
                if (textView2 != null) {
                    textView2.setText("Please select the days");
                }
                TextView textView3 = (TextView) dVar.a(R.id.txt_days_error);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            } else {
                TextView textView4 = (TextView) dVar.a(R.id.txt_days_error);
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            }
            return false;
        }
        TextView textView5 = (TextView) dVar.a(R.id.edt_start_recharge);
        if (textView5 != null) {
            charSequence = textView5.getText();
        }
        CharSequence valueOf3 = String.valueOf(charSequence);
        if (!TextUtils.isEmpty(valueOf3)) {
            return true;
        }
        if (TextUtils.isEmpty(valueOf3)) {
            TextView textView6 = (TextView) dVar.a(R.id.txt_start_recharge_error);
            if (textView6 != null) {
                textView6.setText("Please select the recharge date");
            }
            TextView textView7 = (TextView) dVar.a(R.id.txt_start_recharge_error);
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        } else {
            TextView textView8 = (TextView) dVar.a(R.id.txt_start_recharge_error);
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
        }
        return false;
    }

    public static final /* synthetic */ void d(d dVar) {
        Intent intent = new Intent(dVar.getActivity(), AJRAutomaticSetupActivity.class);
        CJRFrequentOrder cJRFrequentOrder = new CJRFrequentOrder();
        Bundle arguments = dVar.getArguments();
        CharSequence charSequence = null;
        cJRFrequentOrder.setRechargeNumber(arguments != null ? arguments.getString("recharge_number") : null);
        Bundle arguments2 = dVar.getArguments();
        cJRFrequentOrder.setOperatorLogoURL(arguments2 != null ? arguments2.getString("operator_logo") : null);
        Bundle arguments3 = dVar.getArguments();
        intent.putExtra(CLPConstants.PRODUCT_ID, arguments3 != null ? arguments3.getString(CLPConstants.PRODUCT_ID) : null);
        intent.putExtra("selected_recent", cJRFrequentOrder);
        intent.putExtra("is_postpaid", false);
        EditText editText = (EditText) dVar.a(R.id.edt_amount);
        intent.putExtra("recharge_amount", String.valueOf(editText != null ? editText.getText() : null));
        TextView textView = (TextView) dVar.a(R.id.edt_days);
        String valueOf = String.valueOf(textView != null ? textView.getText() : null);
        if (valueOf != null) {
            String substring = valueOf.substring(0, 2);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            intent.putExtra("recharge_days", substring);
            TextView textView2 = (TextView) dVar.a(R.id.edt_start_recharge);
            if (textView2 != null) {
                charSequence = textView2.getText();
            }
            intent.putExtra("recharge_date", String.valueOf(charSequence));
            dVar.startActivity(intent);
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64830d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

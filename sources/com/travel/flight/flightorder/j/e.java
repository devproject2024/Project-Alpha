package com.travel.flight.flightorder.j;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.travel.flight.b.di;
import com.travel.flight.pojo.b;
import java.text.NumberFormat;
import java.util.Locale;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public di f24477a;

    /* renamed from: b  reason: collision with root package name */
    public b f24478b;

    /* renamed from: c  reason: collision with root package name */
    public a f24479c = new a();

    public e(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.f24477a = (di) viewDataBinding;
    }

    public static void a(TextView textView, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
            return;
        }
        char upperCase = Character.toUpperCase(str.charAt(0));
        if (str.length() > 1) {
            str2 = upperCase + str.substring(1);
        } else {
            str2 = String.valueOf(upperCase);
        }
        textView.setText(str2);
    }

    public static void b(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String format = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format((long) ((int) Math.round(Double.parseDouble(str))));
                SpannableString spannableString = new SpannableString(format);
                int indexOf = format.indexOf(FilterPriceSliderFragment.RUPEE_SYMBOL);
                spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif-light", 0)), indexOf, indexOf + 1, 33);
                textView.setText(spannableString);
            } catch (Exception e2) {
                e2.printStackTrace();
                textView.setText("");
            }
        }
    }

    public class a {
        public a() {
        }
    }
}

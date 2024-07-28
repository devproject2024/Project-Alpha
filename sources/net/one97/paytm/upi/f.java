package net.one97.paytm.upi;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.upi.common.ShimmerFrameLayout;

public final class f {
    public static final void a(Context context, int i2, int i3) {
        if (context != null) {
            Toast.makeText(context, context.getString(i2), i3).show();
        }
    }

    public static final void a(Context context, String str, int i2) {
        k.c(str, "msg");
        Toast.makeText(context, str, i2).show();
    }

    public static final void a(View view) {
        k.c(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final void b(View view) {
        k.c(view, "$this$show");
        view.setVisibility(0);
    }

    public static final void c(View view) {
        k.c(view, "$this$invisible");
        view.setVisibility(4);
    }

    public static final String a(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        l lVar = new l(" ");
        Collection arrayList = new ArrayList();
        for (Object next : lVar.split(str, 0)) {
            if (true ^ (((String) next).length() == 0)) {
                arrayList.add(next);
            }
        }
        for (String str2 : (List) arrayList) {
            sb.append(Character.toUpperCase(str2.charAt(0)));
            if (str2 != null) {
                String substring = str2.substring(1);
                k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb.append(lowerCase);
                    sb.append(" ");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "ret.toString()");
        if (sb2 != null) {
            return p.b(sb2).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final boolean d(View view) {
        k.c(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    public static final String b(String str) {
        k.c(str, "$this$toRupee");
        return FilterPriceSliderFragment.RUPEE_SYMBOL + str;
    }

    public static final int c(String str) {
        k.c(str, "$this$toColorInt");
        return Color.parseColor(str);
    }

    public static final void a(View view, boolean z) {
        k.c(view, "$this$setVisible");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final SpannableString a(CharSequence charSequence) {
        k.c(charSequence, "$this$toSpannable");
        return new SpannableString(charSequence);
    }

    public static SpannableString a(SpannableString spannableString, int i2, int i3, int i4) {
        k.c(spannableString, "$this$setForegroundColor");
        spannableString.setSpan(new ForegroundColorSpan(i2), i3, i4, 33);
        return spannableString;
    }

    public static SpannableString a(SpannableString spannableString, int i2, int i3) {
        k.c(spannableString, "$this$boldify");
        spannableString.setSpan(new StyleSpan(1), i2, i3, 33);
        return spannableString;
    }

    public static final boolean b(CharSequence charSequence) {
        k.c(charSequence, "$this$isDigitOnly");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final void a(TextView textView, int i2) {
        k.c(textView, "$this$setDrawableStart");
        textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    }

    public static final void b(TextView textView, int i2) {
        k.c(textView, "$this$setDrawableEnd");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
    }

    public static final int a(Fragment fragment, int i2) {
        k.c(fragment, "$this$getColor");
        return b.c(fragment.requireContext(), i2);
    }

    public static final int a(RadioGroup radioGroup) {
        Integer num;
        k.c(radioGroup, "$this$getCheckedRadioButtonPosition");
        Map linkedHashMap = new LinkedHashMap();
        int childCount = radioGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = radioGroup.getChildAt(i2);
            if (childAt instanceof RadioButton) {
                linkedHashMap.put(Integer.valueOf(i2), childAt);
            }
        }
        Map linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((RadioButton) entry.getValue()).isChecked()) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        o oVar = (o) kotlin.a.k.e(ae.c(linkedHashMap2));
        if (oVar == null || (num = (Integer) oVar.getFirst()) == null) {
            return -1;
        }
        return num.intValue();
    }

    public static final RadioButton a(RadioGroup radioGroup, int i2) {
        k.c(radioGroup, "$this$findRadioButtonAt");
        Map linkedHashMap = new LinkedHashMap();
        int childCount = radioGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = radioGroup.getChildAt(i3);
            if (childAt instanceof RadioButton) {
                linkedHashMap.put(Integer.valueOf(i3), childAt);
            }
        }
        return (RadioButton) linkedHashMap.get(Integer.valueOf(i2));
    }

    public static final void a(View view, int i2) {
        k.c(view, "$this$setHeight");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void b(View view, int i2) {
        k.c(view, "$this$setPaddingBottom");
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), i2);
    }

    public static final void a(ShimmerFrameLayout shimmerFrameLayout) {
        k.c(shimmerFrameLayout, "$this$show");
        b((View) shimmerFrameLayout);
        shimmerFrameLayout.startShimmerAnimation();
    }

    public static final void b(ShimmerFrameLayout shimmerFrameLayout) {
        k.c(shimmerFrameLayout, "$this$gone");
        a((View) shimmerFrameLayout);
        shimmerFrameLayout.stopShimmerAnimation();
    }
}

package com.travel.flight.flightticket.b;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.h;
import com.travel.flight.flightticket.e.f;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBTravelerCharges;
import com.travel.flight.utils.c;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24840a = new a();

    private a() {
    }

    public static final void a(LottieAnimationView lottieAnimationView, LiveData<Boolean> liveData) {
        k.c(lottieAnimationView, "animationView");
        if (liveData == null || liveData.getValue() == null || !k.a((Object) liveData.getValue(), (Object) Boolean.TRUE)) {
            lottieAnimationView.setVisibility(8);
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(0);
        net.one97.paytm.common.widgets.a.a(lottieAnimationView);
    }

    public static final void a(RecyclerView recyclerView, CJRFlightMBChargesRoot cJRFlightMBChargesRoot, List<f> list) {
        k.c(recyclerView, "recyclerView");
        if ((cJRFlightMBChargesRoot != null ? cJRFlightMBChargesRoot.getBody() : null) != null) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof h)) {
                CJRFlightMBChargesBody body = cJRFlightMBChargesRoot.getBody();
                if (body == null) {
                    k.a();
                }
                if (list == null) {
                    k.a();
                }
                recyclerView.setAdapter(new h(body, list));
                return;
            }
            h hVar = (h) adapter;
            CJRFlightMBChargesBody body2 = cJRFlightMBChargesRoot.getBody();
            if (body2 == null) {
                k.a();
            }
            if (list == null) {
                k.a();
            }
            hVar.a(body2, list);
            recyclerView.scrollToPosition(0);
        }
    }

    public static final void a(RecyclerView recyclerView, List<? extends Object> list) {
        k.c(recyclerView, "recyclerView");
        if (list != null && !list.isEmpty()) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null || !(adapter instanceof h)) {
                recyclerView.setAdapter(new h((CJRFlightMBChargesBody) null, list));
                return;
            }
            ((h) adapter).a((CJRFlightMBChargesBody) null, list);
            recyclerView.scrollToPosition(0);
        }
    }

    public static final void a(TextView textView, String str) {
        k.c(textView, "txtView");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            textView.setText(c.a(str));
        }
    }

    public static final void b(TextView textView, String str) {
        k.c(textView, "txtView");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            textView.setText(c.c(str));
        }
    }

    public static final void a(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        if (URLUtil.isValidUrl(str)) {
            b.a aVar = b.f43744a;
            Context context = imageView.getContext();
            k.a((Object) context, "imageView.getContext()");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = str;
            b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public static final void a(ImageView imageView, Context context) {
        k.c(imageView, "imageView");
        k.c(context, "context");
        if (URLUtil.isValidUrl("http://assets.paytm.com/travel/flights-backend/icons/v1/order_actions/small/ModifyBooking.png")) {
            b.a aVar = b.f43744a;
            Context context2 = imageView.getContext();
            k.a((Object) context2, "imageView.getContext()");
            b.a.C0750a a2 = b.a.a(context2);
            a2.f43753a = "http://assets.paytm.com/travel/flights-backend/icons/v1/order_actions/small/ModifyBooking.png";
            b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public static final void a(TextView textView, CJRFlightMBPassenger cJRFlightMBPassenger) {
        k.c(textView, "txtView");
        if (cJRFlightMBPassenger != null) {
            aa aaVar = aa.f47921a;
            Context context = textView.getContext();
            k.a((Object) context, "txtView.context");
            String string = context.getResources().getString(R.string.flight_traveler_name);
            k.a((Object) string, "txtView.context.resource…ing.flight_traveler_name)");
            String format = String.format(string, Arrays.copyOf(new Object[]{cJRFlightMBPassenger.getTitle(), cJRFlightMBPassenger.getFirstname(), cJRFlightMBPassenger.getLastname()}, 3));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
    }

    public static final void a(ImageView imageView, CJRFlightMBPassenger cJRFlightMBPassenger) {
        k.c(imageView, "imageView");
        if (cJRFlightMBPassenger != null) {
            if (p.a(cJRFlightMBPassenger.getType(), "adult", true)) {
                if (p.a(cJRFlightMBPassenger.getTitle(), "Mr", true)) {
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.flight_child_male_revamp_img));
                } else {
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.flight_child_female_revamp_img));
                }
            } else if (p.a(cJRFlightMBPassenger.getType(), "child", true)) {
                if (p.a(cJRFlightMBPassenger.getTitle(), "Mstr", true)) {
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.flight_child_male_revamp_img));
                } else {
                    imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.flight_child_female_revamp_img));
                }
            } else if (p.a(cJRFlightMBPassenger.getType(), "infant", true)) {
                imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.flight_infant_revamp_img));
            }
        }
    }

    public static final void a(TextView textView, CJRFlightMBTravelerCharges cJRFlightMBTravelerCharges, String str, Boolean bool) {
        String str2;
        k.c(textView, "txtView");
        if (cJRFlightMBTravelerCharges != null) {
            if (p.a(str, "adult", true)) {
                Context context = textView.getContext();
                k.a((Object) context, "txtView.context");
                str2 = context.getResources().getString(R.string.flight_per_adult_child);
            } else {
                Context context2 = textView.getContext();
                k.a((Object) context2, "txtView.context");
                str2 = context2.getResources().getString(R.string.flight_per_infant);
            }
            k.a((Object) str2, "if(type.equals(\"adult\", …string.flight_per_infant)");
            if (bool == null) {
                k.a();
            }
            if (!bool.booleanValue() || !p.a(str, "adult", true)) {
                StringBuilder sb = new StringBuilder();
                Context context3 = textView.getContext();
                k.a((Object) context3, "txtView.context");
                sb.append(context3.getResources().getString(R.string.rupee_plain));
                sb.append(' ');
                sb.append(c.h(Integer.toString(cJRFlightMBTravelerCharges.getModificationCharge())));
                sb.append(' ');
                sb.append(str2);
                CharSequence sb2 = sb.toString();
                Context context4 = textView.getContext();
                k.a((Object) context4, "txtView.context");
                String string = context4.getResources().getString(R.string.rupee_plain);
                k.a((Object) string, "txtView.context.resource…ing(R.string.rupee_plain)");
                int a2 = p.a(sb2, string, p.d(sb2));
                int a3 = p.a(sb2, str2, p.d(sb2));
                Spannable spannableString = new SpannableString(sb2);
                int i2 = a2 + 1;
                spannableString.setSpan(new RelativeSizeSpan(0.6f), a2, i2, 33);
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(textView.getContext(), R.color.color_323232)), a2, i2, 33);
                spannableString.setSpan(new RelativeSizeSpan(0.7f), a3, str2.length() + a3, 33);
                spannableString.setSpan(new com.travel.flight.span.a(), a3, str2.length() + a3, 33);
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(textView.getContext(), R.color.color_666666)), a3, str2.length() + a3, 33);
                textView.setText(spannableString);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            Context context5 = textView.getContext();
            k.a((Object) context5, "txtView.context");
            sb3.append(context5.getResources().getString(R.string.rupee_plain));
            sb3.append(' ');
            sb3.append(c.h(Integer.toString(cJRFlightMBTravelerCharges.getModificationCharge())));
            sb3.append(' ');
            Context context6 = textView.getContext();
            k.a((Object) context6, "txtView.context");
            sb3.append(context6.getResources().getString(R.string.rupee_plain));
            sb3.append(" 0 ");
            sb3.append(str2);
            CharSequence sb4 = sb3.toString();
            int a4 = p.a(sb4, str2, p.d(sb4));
            Context context7 = textView.getContext();
            k.a((Object) context7, "txtView.context");
            String string2 = context7.getResources().getString(R.string.rupee_plain);
            k.a((Object) string2, "txtView.context.resource…ing(R.string.rupee_plain)");
            int a5 = p.a(sb4, string2, p.d(sb4));
            Spannable spannableString2 = new SpannableString(sb4);
            spannableString2.setSpan(new RelativeSizeSpan(0.6f), 0, c.h(Integer.toString(cJRFlightMBTravelerCharges.getModificationCharge())).length() + 2, 33);
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(textView.getContext(), R.color.color_666666)), 0, c.h(Integer.toString(cJRFlightMBTravelerCharges.getModificationCharge())).length() + 2, 33);
            spannableString2.setSpan(new StrikethroughSpan(), 2, c.h(Integer.toString(cJRFlightMBTravelerCharges.getModificationCharge())).length() + 2, 33);
            spannableString2.setSpan(new RelativeSizeSpan(0.6f), a5, a5 + 1, 33);
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(textView.getContext(), R.color.color_666666)), a4, str2.length() + a4, 33);
            spannableString2.setSpan(new RelativeSizeSpan(0.7f), a4, str2.length() + a4, 33);
            spannableString2.setSpan(new com.travel.flight.span.a(), a4, str2.length() + a4, 33);
            textView.setText(spannableString2);
        }
    }

    public static final void a(FrameLayout frameLayout, String str) {
        k.c(frameLayout, "frameLayout");
        if (URLUtil.isValidUrl(str)) {
            WebView webView = new WebView(frameLayout.getContext());
            webView.setWebViewClient(new WebViewClient());
            frameLayout.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
            webView.loadUrl(str);
        }
    }

    public static final void b(ImageView imageView, CJRFlightMBPassenger cJRFlightMBPassenger) {
        if (imageView != null && cJRFlightMBPassenger != null) {
            imageView.setImageDrawable(c.a(cJRFlightMBPassenger.getType(), cJRFlightMBPassenger.getTitle(), imageView.getContext()));
        }
    }
}

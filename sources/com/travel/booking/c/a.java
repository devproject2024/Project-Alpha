package com.travel.booking.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.travel.R;
import com.travel.d;
import kotlin.g.b.k;

public final class a {
    public static final void a(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.transparent_border_travel);
            return;
        }
        b.a aVar = com.paytm.utility.b.b.f43744a;
        Context context = imageView.getContext();
        k.a((Object) context, "imageView.context");
        b.a.C0750a a2 = b.a.a(context);
        a2.f43753a = str;
        b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21475a = new b();

        b() {
        }

        public final void onClick(View view) {
            if (view != null) {
                d.a();
                d.a(view.getContext(), "paytmmp://flightticket");
            }
        }
    }

    public static final void a(View view, String str) {
        k.c(view, "view");
        if (!TextUtils.isEmpty(str)) {
            b.a aVar = com.paytm.utility.b.b.f43744a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            b.a.C0750a a2 = b.a.a(context);
            a2.f43753a = str;
            a2.a(5, b.a.ALL).a((ImageView) null, (com.paytm.utility.b.b.b<?>) new C0426a(view));
        }
    }

    /* renamed from: com.travel.booking.c.a$a  reason: collision with other inner class name */
    public static final class C0426a implements com.paytm.utility.b.b.b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f21474a;

        public final void onError(Exception exc) {
        }

        C0426a(View view) {
            this.f21474a = view;
        }

        public final /* synthetic */ void onSuccess(Object obj, c cVar) {
            Drawable drawable = (Drawable) obj;
            if (Build.VERSION.SDK_INT >= 16) {
                this.f21474a.setBackground(drawable);
            }
        }
    }

    public static final void a(TextView textView, String str) {
        k.c(textView, "txtView");
        if (!TextUtils.isEmpty(str) && str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
    }
}

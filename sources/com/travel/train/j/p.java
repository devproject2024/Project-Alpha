package com.travel.train.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.activity.AJRAppWebView;
import com.travel.train.i.g;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f27588a;

    /* renamed from: b  reason: collision with root package name */
    public CJRTrainSearchResultsTrain f27589b;

    /* renamed from: c  reason: collision with root package name */
    public String f27590c;

    /* renamed from: d  reason: collision with root package name */
    public String f27591d;

    /* renamed from: e  reason: collision with root package name */
    public String f27592e;

    /* renamed from: f  reason: collision with root package name */
    public String f27593f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f27594g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f27595h;

    /* renamed from: i  reason: collision with root package name */
    public String f27596i;
    public String j;
    private View k;
    private Activity l;
    private g m;
    private String n = "CreateAccountSpan";

    public p(Activity activity, View view, g gVar) {
        this.l = activity;
        this.f27588a = this.l.getApplicationContext();
        this.k = view;
        this.k.setOnClickListener(this);
        this.m = gVar;
    }

    public final void onClick(View view) {
        String str = d.dy;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", b.n(this.f27588a) != null ? b.n(this.f27588a) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/traveller-details");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, this.f27588a);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        com.travel.train.b.a();
        String ab = com.travel.train.b.b().ab();
        if (!TextUtils.isEmpty(ab)) {
            String str2 = ab + "class=" + this.f27590c + "&fare=" + this.j + "&boarding_date=" + this.f27593f + "&boarding_time=" + this.f27594g + "&quota=" + this.f27591d + "&train_number=" + this.f27595h + "&train_type=" + this.f27596i;
            try {
                str2 = str2 + "&status=" + URLEncoder.encode(this.f27592e, AppConstants.UTF_8).replace("+", "%20");
            } catch (Exception unused) {
            }
            this.m.a(str2);
            return;
        }
        com.travel.train.b.a();
        String ac = com.travel.train.b.b().ac();
        if (TextUtils.isEmpty(ac)) {
            ac = "http://contents.irctc.co.in/en/REFUND%20RULES%20wef%2012-Nov-15.pdf";
        }
        Intent intent = new Intent(this.l, AJRAppWebView.class);
        intent.putExtra("url", ac);
        this.l.startActivity(intent);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                return i.a(simpleDateFormat.format(new Date(simpleDateFormat.parse(str).getTime())), "yyyy-MM-dd");
            } catch (ParseException e2) {
                q.c(e2.getMessage());
            }
        }
        return null;
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale(n.a(context, n.a())));
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }
}

package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class bg extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27961a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27962b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27963c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f27964d;

    /* renamed from: e  reason: collision with root package name */
    v f27965e;

    /* renamed from: f  reason: collision with root package name */
    private Context f27966f;

    /* renamed from: g  reason: collision with root package name */
    private String f27967g = "CJRTrainPNRSearchItemViewHolder";

    public bg(Context context, v vVar, View view) {
        super(view);
        this.f27966f = context;
        this.f27965e = vVar;
        this.f27964d = (ConstraintLayout) view.findViewById(R.id.main_lyt);
        this.f27961a = (TextView) view.findViewById(R.id.pnr_no_txt);
        this.f27962b = (TextView) view.findViewById(R.id.org_dest_txt);
        this.f27963c = (TextView) view.findViewById(R.id.date_txt);
    }

    public static String a(String str) {
        String str2;
        boolean z;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            int i2 = instance.get(5);
            String displayName = instance.getDisplayName(2, 1, Locale.getDefault());
            str2 = instance.getDisplayName(7, 2, Locale.getDefault()) + ", " + i2 + " " + displayName;
            z = true;
        } catch (ParseException unused) {
            z = false;
            str2 = "";
        }
        if (z) {
            return str2;
        }
        try {
            Date parse2 = simpleDateFormat.parse(str);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(parse2);
            int i3 = instance2.get(5);
            String displayName2 = instance2.getDisplayName(2, 1, Locale.getDefault());
            return instance2.getDisplayName(7, 2, Locale.getDefault()) + ", " + i3 + " " + displayName2;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return str2;
        }
    }
}

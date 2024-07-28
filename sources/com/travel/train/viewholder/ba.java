package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.t;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class ba extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f27916a;

    /* renamed from: b  reason: collision with root package name */
    t f27917b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27918c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27919d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27920e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27921f;

    /* renamed from: g  reason: collision with root package name */
    private Context f27922g;

    /* renamed from: h  reason: collision with root package name */
    private String f27923h = "CJRTrainLSUpcomingViewHolder";

    public ba(View view, Context context, t tVar) {
        super(view);
        this.f27922g = context;
        this.f27917b = tVar;
        this.f27916a = (RelativeLayout) view.findViewById(R.id.main_lyt);
        this.f27918c = (TextView) view.findViewById(R.id.top_lyt_txt1);
        this.f27919d = (TextView) view.findViewById(R.id.top_lyt_txt2);
        this.f27920e = (TextView) view.findViewById(R.id.train_name_txt);
        this.f27921f = (TextView) view.findViewById(R.id.date_txt);
    }

    public static String a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            int i2 = instance.get(5);
            String displayName = instance.getDisplayName(2, 2, Locale.getDefault());
            String displayName2 = instance.getDisplayName(7, 2, Locale.getDefault());
            return displayName2 + ", " + i2 + " " + displayName;
        } catch (ParseException e2) {
            q.c(e2.getMessage());
            return "";
        }
    }
}

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

public final class bh extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f27970a;

    /* renamed from: b  reason: collision with root package name */
    t f27971b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27972c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27973d;

    /* renamed from: e  reason: collision with root package name */
    private Context f27974e;

    /* renamed from: f  reason: collision with root package name */
    private String f27975f = "CJRPassengerDestDetailViewHolder";

    public bh(View view, Context context, t tVar) {
        super(view);
        this.f27974e = context;
        this.f27971b = tVar;
        this.f27970a = (RelativeLayout) view.findViewById(R.id.main_lyt);
        this.f27972c = (TextView) view.findViewById(R.id.top_lyt_txt1);
        this.f27973d = (TextView) view.findViewById(R.id.date_txt);
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

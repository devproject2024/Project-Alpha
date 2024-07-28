package com.travel.flight.seatancillary.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatPClass;
import java.util.List;

public final class a extends RecyclerView.a<C0475a> {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRSeatPClass> f25467a;

    /* renamed from: b  reason: collision with root package name */
    private Context f25468b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0475a aVar = (C0475a) vVar;
        CJRSeatPClass cJRSeatPClass = this.f25467a.get(i2);
        aVar.f25469a.setText(cJRSeatPClass.getTitle());
        aVar.f25470b.setColorFilter(Color.parseColor(cJRSeatPClass.getCJRSeatLegend().getColor()), PorterDuff.Mode.SRC_ATOP);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f25468b).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        aVar.f25471c.setLayoutParams(new ConstraintLayout.LayoutParams((displayMetrics.widthPixels - ((int) ((((float) this.f25468b.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 32.0f))) / this.f25467a.size(), -2));
    }

    public a(Context context, List<CJRSeatPClass> list) {
        this.f25467a = list;
        this.f25468b = context;
    }

    public final int getItemCount() {
        return this.f25467a.size();
    }

    /* renamed from: com.travel.flight.seatancillary.a.a$a  reason: collision with other inner class name */
    public class C0475a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f25469a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f25470b;

        /* renamed from: c  reason: collision with root package name */
        public ConstraintLayout f25471c;

        public C0475a(View view) {
            super(view);
            this.f25469a = (TextView) view.findViewById(R.id.myText);
            this.f25470b = (ImageView) view.findViewById(R.id.myImg);
            this.f25471c = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0475a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_layout_legend_menu, viewGroup, false));
    }
}

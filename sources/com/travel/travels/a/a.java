package com.travel.travels.a;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.R;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public final class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRHomePageItem> f28420a;

    /* renamed from: b  reason: collision with root package name */
    C0493a f28421b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28422c;

    /* renamed from: com.travel.travels.a.a$a  reason: collision with other inner class name */
    public interface C0493a {
        void a(CJRHomePageItem cJRHomePageItem);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        CJRHomePageItem cJRHomePageItem = this.f28420a.get(i2);
        bVar.f28423a.setText(cJRHomePageItem.getName());
        b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f28422c);
        a2.f43753a = cJRHomePageItem.getImageUrl();
        b.a.C0750a.a(a2, bVar.f28424b, (com.paytm.utility.b.b.b) null, 2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f28422c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int size = displayMetrics.widthPixels / this.f28420a.size();
        new ConstraintLayout(this.f28422c);
        bVar.f28425c.setLayoutParams(new ConstraintLayout.LayoutParams(size, -2));
    }

    public a(Context context, List<CJRHomePageItem> list, C0493a aVar) {
        this.f28420a = list;
        this.f28422c = context;
        this.f28421b = aVar;
    }

    public final int getItemCount() {
        return this.f28420a.size();
    }

    public class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public TextView f28423a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f28424b;

        /* renamed from: c  reason: collision with root package name */
        public ConstraintLayout f28425c;

        public b(View view) {
            super(view);
            view.setOnClickListener(this);
            this.f28423a = (TextView) view.findViewById(R.id.myText);
            this.f28424b = (ImageView) view.findViewById(R.id.myImg);
            this.f28425c = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        }

        public final void onClick(View view) {
            a.this.f28421b.a(a.this.f28420a.get(getAdapterPosition()));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_td_layout_travel_bottom_menu, viewGroup, false));
    }
}

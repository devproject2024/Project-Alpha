package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRTrainTicketStatusGuideTemplate;
import java.util.ArrayList;

public final class r extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f26538a;

    /* renamed from: b  reason: collision with root package name */
    a f26539b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRTrainTicketStatusGuideTemplate> f26540c;

    public r(Context context, ArrayList<CJRTrainTicketStatusGuideTemplate> arrayList) {
        this.f26538a = context;
        this.f26540c = arrayList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(((LayoutInflater) this.f26538a.getSystemService("layout_inflater")).inflate(R.layout.pre_t_train_ticket_status_guide_lyt, viewGroup, false));
    }

    public final long getItemId(int i2) {
        return super.getItemId(i2);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRTrainTicketStatusGuideTemplate cJRTrainTicketStatusGuideTemplate = this.f26540c.get(i2);
        a aVar = (a) vVar;
        aVar.f26541a.setText(cJRTrainTicketStatusGuideTemplate.getTitle());
        aVar.f26542b.setText(cJRTrainTicketStatusGuideTemplate.getDescription());
    }

    public final int getItemCount() {
        return this.f26540c.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f26541a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f26542b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f26543c;

        /* renamed from: e  reason: collision with root package name */
        private RelativeLayout f26545e;

        public a(View view) {
            super(view);
            this.f26545e = (RelativeLayout) view.findViewById(R.id.ticket_guide_title_lyt);
            this.f26541a = (RoboTextView) view.findViewById(R.id.ticket_guide_title);
            this.f26542b = (RoboTextView) view.findViewById(R.id.ticket_guide_detail);
            this.f26543c = (ImageView) view.findViewById(R.id.ticket_guide_arrow);
            this.f26545e.setOnClickListener(new View.OnClickListener(r.this) {
                public final void onClick(View view) {
                    if (a.this.f26542b.getVisibility() == 8) {
                        a.this.f26541a.setSelected(true);
                        a.this.f26542b.setVisibility(0);
                        a.this.f26543c.setImageDrawable(r.this.f26538a.getResources().getDrawable(R.drawable.sqaure_minus));
                        a aVar = a.this;
                        if (r.this.f26539b == null || aVar.equals(r.this.f26539b)) {
                            r.this.f26539b = aVar;
                            return;
                        }
                        r.this.f26539b.f26543c.setImageDrawable(r.this.f26538a.getResources().getDrawable(R.drawable.sqaure_plus));
                        r.this.f26539b.f26542b.setVisibility(8);
                        r.this.f26539b.f26541a.setSelected(false);
                        r.this.f26539b = aVar;
                        return;
                    }
                    a.this.f26541a.setSelected(false);
                    a.this.f26542b.setVisibility(8);
                    a.this.f26543c.setImageDrawable(r.this.f26538a.getResources().getDrawable(R.drawable.sqaure_plus));
                }
            });
        }
    }
}

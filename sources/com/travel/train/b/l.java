package com.travel.train.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.v;
import com.travel.train.R;
import com.travel.train.i.u;
import com.travel.train.model.trainticket.CJRTrainInfantInfo;
import com.travel.train.model.trainticket.CJRTrainQuickBookPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainUserFavourite;
import java.util.ArrayList;
import java.util.Iterator;

public final class l extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Activity f26462a;

    /* renamed from: b  reason: collision with root package name */
    u f26463b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRTrainUserFavourite> f26464c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26465d = true;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f26466e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        boolean z = this.f26465d;
        aVar.j = this.f26464c.get(i2);
        aVar.k = z;
        aVar.l = l.this.f26462a.getResources().getInteger(17694720);
        if (aVar.j != null) {
            if (!TextUtils.isEmpty(aVar.j.getTrainNumber())) {
                aVar.f26468b.setText(aVar.j.getTrainNumber());
            }
            if (!TextUtils.isEmpty(aVar.j.getTrainName())) {
                aVar.f26467a.setText(aVar.j.getTrainName());
            }
            if (!TextUtils.isEmpty(aVar.j.getmDepartureDate())) {
                aVar.f26469c.setText(aVar.j.getmDepartureDate());
            }
            if (!TextUtils.isEmpty(aVar.j.getmArrivalDate())) {
                aVar.f26470d.setText(aVar.j.getmArrivalDate());
            }
            if (!TextUtils.isEmpty(aVar.j.getClassFullName())) {
                aVar.f26471e.setText(aVar.j.getClassFullName());
            } else {
                aVar.f26471e.setText("");
            }
            if (!TextUtils.isEmpty(aVar.j.getmAvailabilityStatus())) {
                aVar.f26473g.setVisibility(0);
                aVar.f26473g.setText(aVar.j.getmAvailabilityStatus());
            } else {
                aVar.f26473g.setText("");
            }
            if (!TextUtils.isEmpty(aVar.j.getFareDetail())) {
                TextView textView = aVar.f26472f;
                textView.setText(l.this.f26462a.getString(R.string.rupee_symbol) + " " + aVar.j.getFareDetail());
            } else {
                aVar.f26472f.setText("");
            }
            aVar.a(aVar.j);
            if (!TextUtils.isEmpty(aVar.j.getmStatusTime())) {
                aVar.f26475i.setVisibility(0);
                aVar.f26475i.setText(aVar.j.getmStatusTime());
            }
            if (aVar.k) {
                aVar.f26474h.setAlpha(0.0f);
                aVar.f26474h.setVisibility(0);
                aVar.f26474h.animate().alpha(1.0f).setDuration((long) aVar.l).setListener((Animator.AnimatorListener) null);
                aVar.f26475i.setVisibility(0);
            } else {
                aVar.f26474h.setAlpha(1.0f);
                aVar.f26474h.setVisibility(0);
                aVar.f26474h.animate().alpha(0.0f).setDuration((long) aVar.l).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        a.this.f26474h.setVisibility(8);
                    }
                });
                aVar.f26475i.setVisibility(8);
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (l.this.f26463b != null) {
                        l.this.f26463b.a(a.this.j);
                    }
                }
            });
        }
    }

    public l(Activity activity, ArrayList<CJRTrainUserFavourite> arrayList, u uVar) {
        this.f26462a = activity;
        this.f26464c = arrayList;
        this.f26463b = uVar;
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f26466e = recyclerView;
    }

    public final void a(boolean z) {
        this.f26465d = z;
        RecyclerView recyclerView = this.f26466e;
        if (recyclerView != null) {
            v.a((ViewGroup) recyclerView);
        }
        this.f26466e.getRecycledViewPool().a();
        notifyDataSetChanged();
    }

    public final boolean a() {
        return this.f26465d;
    }

    public final int getItemCount() {
        return this.f26464c.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f26467a;

        /* renamed from: b  reason: collision with root package name */
        TextView f26468b;

        /* renamed from: c  reason: collision with root package name */
        TextView f26469c;

        /* renamed from: d  reason: collision with root package name */
        TextView f26470d;

        /* renamed from: e  reason: collision with root package name */
        TextView f26471e;

        /* renamed from: f  reason: collision with root package name */
        TextView f26472f;

        /* renamed from: g  reason: collision with root package name */
        TextView f26473g;

        /* renamed from: h  reason: collision with root package name */
        ConstraintLayout f26474h;

        /* renamed from: i  reason: collision with root package name */
        TextView f26475i;
        CJRTrainUserFavourite j;
        boolean k;
        int l;
        private TextView n;
        private TextView o;

        /* synthetic */ a(l lVar, View view, byte b2) {
            this(view);
        }

        private a(View view) {
            super(view);
            this.f26467a = (TextView) view.findViewById(R.id.train_name);
            this.f26468b = (TextView) view.findViewById(R.id.train_number);
            this.f26469c = (TextView) view.findViewById(R.id.dept_time);
            this.f26470d = (TextView) view.findViewById(R.id.arr_time);
            this.f26474h = (ConstraintLayout) view.findViewById(R.id.container_availability);
            this.f26471e = (TextView) view.findViewById(R.id.class_name);
            this.f26472f = (TextView) view.findViewById(R.id.price_text);
            this.f26473g = (TextView) view.findViewById(R.id.available_count);
            this.n = (TextView) view.findViewById(R.id.name_list);
            this.o = (TextView) view.findViewById(R.id.traveller_count);
            this.f26475i = (TextView) view.findViewById(R.id.available_time);
        }

        public final void a(CJRTrainUserFavourite cJRTrainUserFavourite) {
            ArrayList arrayList = new ArrayList();
            if (cJRTrainUserFavourite.getPaxInfo() != null && cJRTrainUserFavourite.getPaxInfo().size() > 0) {
                for (CJRTrainQuickBookPassengerInfo next : cJRTrainUserFavourite.getPaxInfo()) {
                    if (!TextUtils.isEmpty(next.getPassengerName())) {
                        arrayList.add(next.getPassengerName());
                    }
                }
            }
            if (cJRTrainUserFavourite.getmInfantInfo() != null && cJRTrainUserFavourite.getmInfantInfo().size() > 0) {
                Iterator<CJRTrainInfantInfo> it2 = cJRTrainUserFavourite.getmInfantInfo().iterator();
                while (it2.hasNext()) {
                    CJRTrainInfantInfo next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.getName())) {
                        arrayList.add(next2.getName());
                    }
                }
            }
            a((ArrayList<String>) arrayList);
        }

        private void a(ArrayList<String> arrayList) {
            String str;
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    str = "";
                    break;
                }
                String str2 = arrayList.get(i2);
                if (!TextUtils.isEmpty(str2)) {
                    if (i2 > 1) {
                        StringBuilder sb2 = new StringBuilder("+");
                        sb2.append(arrayList.size() - 2);
                        str = sb2.toString();
                        break;
                    } else if (i2 != 0) {
                        sb.append(", ");
                        sb.append(str2);
                    } else {
                        sb.append(str2);
                    }
                }
                i2++;
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                this.n.setText(sb.toString());
                if (this.k) {
                    this.n.setVisibility(0);
                } else {
                    this.n.setVisibility(8);
                }
            } else {
                this.n.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.o.setText(str);
                if (this.k) {
                    this.o.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                }
            } else {
                this.o.setVisibility(8);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(this.f26462a).inflate(R.layout.pre_t_quick_book, viewGroup, false), (byte) 0);
    }
}

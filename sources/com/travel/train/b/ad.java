package com.travel.train.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.model.trainticket.f;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;

public final class ad extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<f.a> f26188a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f26189b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f26190c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, String> f26191d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Activity f26192e;

    public ad(Activity activity) {
        k.c(activity, "mActivity");
        this.f26192e = activity;
        ArrayList<f.a> arrayList = this.f26188a;
        if (arrayList == null || (arrayList != null && arrayList.isEmpty())) {
            this.f26188a = new ArrayList<>();
            f.a aVar = new f.a();
            aVar.a(this.f26192e.getString(R.string.train_early_morning));
            aVar.b(this.f26192e.getString(R.string.train_early_morning_timing));
            aVar.a(R.drawable.pre_t_train_time_early_morning_selector);
            ArrayList<f.a> arrayList2 = this.f26188a;
            if (arrayList2 == null) {
                k.a();
            }
            arrayList2.add(aVar);
            f.a aVar2 = new f.a();
            aVar2.a(this.f26192e.getString(R.string.train_morning));
            aVar2.b(this.f26192e.getString(R.string.train_morning_timing));
            aVar2.a(R.drawable.pre_t_train_time_morning_selector);
            ArrayList<f.a> arrayList3 = this.f26188a;
            if (arrayList3 == null) {
                k.a();
            }
            arrayList3.add(aVar2);
            f.a aVar3 = new f.a();
            aVar3.a(this.f26192e.getString(R.string.train_afternoon));
            aVar3.b(this.f26192e.getString(R.string.train_afternoon_timing));
            aVar3.a(R.drawable.pre_t_train_time_afternoon_selector);
            ArrayList<f.a> arrayList4 = this.f26188a;
            if (arrayList4 == null) {
                k.a();
            }
            arrayList4.add(aVar3);
            f.a aVar4 = new f.a();
            aVar4.a(this.f26192e.getString(R.string.train_night));
            aVar4.b(this.f26192e.getString(R.string.train_night_timing));
            aVar4.a(R.drawable.pre_t_train_time_night_selector);
            ArrayList<f.a> arrayList5 = this.f26188a;
            if (arrayList5 == null) {
                k.a();
            }
            arrayList5.add(aVar4);
        }
        Activity activity2 = this.f26192e;
        if (activity2 != null) {
            Object systemService = activity2.getSystemService("layout_inflater");
            if (systemService != null) {
                this.f26190c = (LayoutInflater) systemService;
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        ArrayList<f.a> arrayList = this.f26188a;
        if (arrayList == null || !arrayList.isEmpty()) {
            if (i2 == 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.paytm.utility.b.a(92.0f, (Context) this.f26192e));
                layoutParams.setMargins(com.paytm.utility.b.a(19.0f, (Context) this.f26192e), com.paytm.utility.b.a(0.0f, (Context) this.f26192e), com.paytm.utility.b.a(14.0f, (Context) this.f26192e), com.paytm.utility.b.a(0.0f, (Context) this.f26192e));
                aVar.f26196d.setLayoutParams(layoutParams);
            }
            TextView textView = aVar.f26193a;
            ArrayList<f.a> arrayList2 = this.f26188a;
            if (arrayList2 == null) {
                k.a();
            }
            f.a aVar2 = arrayList2.get(i2);
            k.a((Object) aVar2, "mSessionListItem!!.get(position)");
            textView.setText(aVar2.a());
            TextView textView2 = aVar.f26194b;
            ArrayList<f.a> arrayList3 = this.f26188a;
            if (arrayList3 == null) {
                k.a();
            }
            f.a aVar3 = arrayList3.get(i2);
            k.a((Object) aVar3, "mSessionListItem!!.get(position)");
            textView2.setText(aVar3.b());
            ImageView imageView = aVar.f26195c;
            Resources resources = this.f26192e.getResources();
            ArrayList<f.a> arrayList4 = this.f26188a;
            if (arrayList4 == null) {
                k.a();
            }
            f.a aVar4 = arrayList4.get(i2);
            k.a((Object) aVar4, "mSessionListItem!!.get(position)");
            imageView.setImageDrawable(resources.getDrawable(aVar4.c()));
            HashMap<String, String> hashMap = this.f26191d;
            ArrayList<f.a> arrayList5 = this.f26188a;
            if (arrayList5 == null) {
                k.a();
            }
            f.a aVar5 = arrayList5.get(i2);
            k.a((Object) aVar5, "mSessionListItem!!.get(position)");
            if (hashMap.containsKey(aVar5.a())) {
                aVar.f26196d.setSelected(true);
                HashMap<String, String> hashMap2 = this.f26189b;
                ArrayList<f.a> arrayList6 = this.f26188a;
                if (arrayList6 == null) {
                    k.a();
                }
                f.a aVar6 = arrayList6.get(i2);
                k.a((Object) aVar6, "mSessionListItem!!.get(position)");
                String a2 = aVar6.a();
                ArrayList<f.a> arrayList7 = this.f26188a;
                if (arrayList7 == null) {
                    k.a();
                }
                f.a aVar7 = arrayList7.get(i2);
                k.a((Object) aVar7, "mSessionListItem!!.get(position)");
                hashMap2.put(a2, aVar7.a());
            }
            aVar.f26196d.setOnClickListener(new b(this, aVar, i2));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater layoutInflater = this.f26190c;
        View inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.pre_t_lyt_train_filter_session_item, viewGroup, false) : null;
        if (inflate == null) {
            k.a();
        }
        return new a(inflate);
    }

    public final void a(HashMap<String, String> hashMap) {
        k.c(hashMap, "selectedMap");
        this.f26191d = hashMap;
        notifyDataSetChanged();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26197a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f26198b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26199c;

        b(ad adVar, a aVar, int i2) {
            this.f26197a = adVar;
            this.f26198b = aVar;
            this.f26199c = i2;
        }

        public final void onClick(View view) {
            if (!this.f26198b.f26196d.isSelected()) {
                this.f26198b.f26196d.setSelected(true);
                ArrayList<f.a> arrayList = this.f26197a.f26188a;
                if (arrayList == null) {
                    k.a();
                }
                f.a aVar = arrayList.get(this.f26199c);
                k.a((Object) aVar, "mSessionListItem!!.get(position)");
                aVar.a(true);
                HashMap<String, String> hashMap = this.f26197a.f26189b;
                ArrayList<f.a> arrayList2 = this.f26197a.f26188a;
                if (arrayList2 == null) {
                    k.a();
                }
                f.a aVar2 = arrayList2.get(this.f26199c);
                k.a((Object) aVar2, "mSessionListItem!!.get(position)");
                String a2 = aVar2.a();
                ArrayList<f.a> arrayList3 = this.f26197a.f26188a;
                if (arrayList3 == null) {
                    k.a();
                }
                f.a aVar3 = arrayList3.get(this.f26199c);
                k.a((Object) aVar3, "mSessionListItem!!.get(position)");
                hashMap.put(a2, aVar3.a());
                return;
            }
            this.f26198b.f26196d.setSelected(false);
            ArrayList<f.a> arrayList4 = this.f26197a.f26188a;
            if (arrayList4 == null) {
                k.a();
            }
            f.a aVar4 = arrayList4.get(this.f26199c);
            k.a((Object) aVar4, "mSessionListItem!!.get(position)");
            aVar4.a(false);
            HashMap<String, String> hashMap2 = this.f26197a.f26189b;
            ArrayList<f.a> arrayList5 = this.f26197a.f26188a;
            if (arrayList5 == null) {
                k.a();
            }
            f.a aVar5 = arrayList5.get(this.f26199c);
            k.a((Object) aVar5, "mSessionListItem!!.get(position)");
            hashMap2.remove(aVar5.a());
        }
    }

    public final int getItemCount() {
        ArrayList<f.a> arrayList = this.f26188a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f26193a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f26194b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f26195c;

        /* renamed from: d  reason: collision with root package name */
        final RelativeLayout f26196d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.session_name);
            if (findViewById != null) {
                this.f26193a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.session_time);
                if (findViewById2 != null) {
                    this.f26194b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.session_image);
                    if (findViewById3 != null) {
                        this.f26195c = (ImageView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.session_layout);
                        if (findViewById4 != null) {
                            this.f26196d = (RelativeLayout) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}

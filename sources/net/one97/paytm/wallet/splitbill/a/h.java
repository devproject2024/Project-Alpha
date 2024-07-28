package net.one97.paytm.wallet.splitbill.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.utils.z;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBGroupDetailActivity;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;

public final class h extends RecyclerView.a<a> implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<SBGroupDetailsDtoList> f71812a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<SBGroupDetailsDtoList> f71813b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Activity f71814c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f71815d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f71816e = false;

    /* renamed from: f  reason: collision with root package name */
    private z f71817f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        aVar.f71822a.setText(this.f71812a.get(i2).getName());
        aVar.f71823b.setBackgroundColor(Color.parseColor(this.f71815d.get(i2 % 10)));
        String a2 = b.a(this.f71812a.get(i2).getName());
        TextView textView = aVar.f71823b;
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        textView.setText(a2);
        SBGroupDetailsDtoList sBGroupDetailsDtoList = this.f71812a.get(i2);
        String str = sBGroupDetailsDtoList.getTotalUser().intValue() > 2 ? "others" : "other";
        StringBuilder sb = new StringBuilder("You and ");
        sb.append(sBGroupDetailsDtoList.getTotalUser().intValue() - 1);
        sb.append(" ");
        sb.append(str);
        aVar.f71824c.setText(sb.toString());
        aVar.f71825d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Toast.makeText(h.this.f71814c, "Group Delete not working as of now!", 0).show();
            }
        });
        aVar.f71826e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!h.this.f71816e) {
                    Intent intent = new Intent(h.this.f71814c, SBGroupDetailActivity.class);
                    intent.putExtra("group_detail", (Serializable) h.this.f71812a.get(i2));
                    h.this.f71814c.startActivity(intent);
                }
            }
        });
    }

    public h(List<SBGroupDetailsDtoList> list, Activity activity, boolean z) {
        this.f71812a = list;
        this.f71813b.addAll(list);
        this.f71814c = activity;
        this.f71816e = z;
        this.f71817f = new z(this.f71814c);
        this.f71817f.setCancelable(false);
        this.f71817f.setCanceledOnTouchOutside(false);
    }

    public final int getItemCount() {
        if (this.f71812a.size() > 0) {
            return this.f71812a.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71822a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71823b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71824c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71825d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71826e;

        /* renamed from: g  reason: collision with root package name */
        private View f71828g;

        public a(View view) {
            super(view);
            this.f71822a = (TextView) view.findViewById(R.id.name);
            this.f71823b = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71828g = view.findViewById(R.id.line);
            this.f71824c = (TextView) view.findViewById(R.id.balancegroupList);
            this.f71825d = (TextView) view.findViewById(R.id.delete_group_tv);
            this.f71826e = (RelativeLayout) view.findViewById(R.id.rl_outer_container);
            this.f71828g.setVisibility(0);
        }
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    h hVar = h.this;
                    List unused = hVar.f71812a = hVar.f71813b;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (SBGroupDetailsDtoList sBGroupDetailsDtoList : h.this.f71813b) {
                        if (sBGroupDetailsDtoList.getName().toLowerCase().contains(charSequence2)) {
                            arrayList.add(sBGroupDetailsDtoList);
                        }
                    }
                    List unused2 = h.this.f71812a = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = h.this.f71812a;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = h.this.f71812a = (ArrayList) filterResults.values;
                h.this.notifyDataSetChanged();
            }
        };
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_group_item, (ViewGroup) null));
    }
}

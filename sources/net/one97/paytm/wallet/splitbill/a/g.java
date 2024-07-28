package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBUserToUserDetailActivity;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f71801a;

    /* renamed from: b  reason: collision with root package name */
    String f71802b;

    /* renamed from: c  reason: collision with root package name */
    List<SBUserList> f71803c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f71804d = new ArrayList<String>() {
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

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final a aVar = (a) vVar;
        aVar.f71808a.setText(this.f71803c.get(i2).getName());
        aVar.f71809b.setBackgroundColor(Color.parseColor(this.f71804d.get(i2 % 10)));
        String a2 = b.a(this.f71803c.get(i2).getName());
        TextView textView = aVar.f71809b;
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        textView.setText(a2);
        aVar.f71810c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!aVar.f71808a.getText().toString().equalsIgnoreCase("You") && !TextUtils.isEmpty(g.this.f71803c.get(i2).getUserId())) {
                    Intent intent = new Intent(g.this.f71801a, SBUserToUserDetailActivity.class);
                    intent.putExtra("user_id", g.this.f71803c.get(i2).getUserId());
                    intent.putExtra("your_id", g.this.f71802b);
                    g.this.f71801a.startActivity(intent);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("bottomSheet");
                    arrayList.add(g.this.f71803c.get(i2).getUserId());
                    b.a(g.this.f71801a, "split_bill", "splitbill_user2user", arrayList, "", "/splitbill/user2user", "split_bill");
                }
            }
        });
    }

    public g(Context context, List<SBUserList> list, String str) {
        this.f71801a = context;
        this.f71803c = list;
        this.f71802b = str;
    }

    public final int getItemCount() {
        return this.f71803c.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71808a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71809b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f71810c;

        public a(View view) {
            super(view);
            this.f71808a = (TextView) view.findViewById(R.id.name);
            this.f71809b = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71810c = (RelativeLayout) view.findViewById(R.id.outer_layout);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_bottom_sheet_group_member_list_item, viewGroup, false));
    }
}

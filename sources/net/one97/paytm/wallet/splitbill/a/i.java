package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.b.d;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f71829a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<SBContactDetail> f71830b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    d f71831c;

    /* renamed from: d  reason: collision with root package name */
    boolean f71832d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f71833e = new ArrayList<String>() {
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
        String str;
        final a aVar = (a) vVar;
        aVar.f71838b.setText(this.f71830b.get(i2).getmName());
        aVar.f71839c.setBackgroundColor(Color.parseColor(this.f71833e.get(i2 % 10)));
        if (this.f71830b.get(i2).getmName() != null) {
            str = b.a(this.f71830b.get(i2).getmName());
        } else {
            str = "";
        }
        TextView textView = aVar.f71839c;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        textView.setText(str);
        if (this.f71830b.get(i2).isSelected()) {
            aVar.f71837a.setVisibility(0);
        }
        aVar.f71837a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (i.this.f71832d) {
                    i.this.f71831c.a(i.this.f71830b.get(i2));
                } else if (i.this.f71830b.size() <= 2) {
                    Toast.makeText(i.this.f71829a, i.this.f71829a.getResources().getString(R.string.sb_delete_member_policy), 1).show();
                } else if (!i.this.f71830b.get(i2).isAdmin()) {
                    aVar.f71837a.setVisibility(8);
                    i.this.f71830b.get(i2).setSelected(false);
                    i.this.f71830b.remove(i2);
                    i.this.notifyItemRemoved(i2);
                    i iVar = i.this;
                    iVar.notifyItemRangeChanged(i2, iVar.f71830b.size());
                    i.this.f71831c.a(i.this.f71830b.get(i2));
                }
            }
        });
    }

    public i(Context context, d dVar, boolean z) {
        this.f71829a = context;
        this.f71831c = dVar;
        this.f71832d = z;
    }

    public final int getItemCount() {
        if (this.f71830b.size() > 0) {
            return this.f71830b.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71837a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71838b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71839c;

        /* renamed from: e  reason: collision with root package name */
        private LinearLayout f71841e;

        public a(View view) {
            super(view);
            this.f71838b = (TextView) view.findViewById(R.id.tvName);
            this.f71839c = (TextView) view.findViewById(R.id.mp_initial_name_tv);
            this.f71841e = (LinearLayout) view.findViewById(R.id.parentLayout);
            this.f71837a = (ImageView) view.findViewById(R.id.cross);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_group_contact_item, (ViewGroup) null));
    }
}

package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBUserToUserDetailActivity;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupSnapshot;

public final class f extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<SBGroupSnapshot> f71792a;

    /* renamed from: b  reason: collision with root package name */
    Context f71793b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f71794c = false;

    public f(Context context, List<SBGroupSnapshot> list, boolean z) {
        this.f71792a = list;
        this.f71793b = context;
        this.f71794c = z;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sb_bottom_sheet_pay_receive_list_fragment, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        if (this.f71794c) {
            a aVar = (a) vVar;
            aVar.f71797a.setText(String.valueOf(Math.abs(Float.parseFloat(this.f71792a.get(i2).getAmount()))));
            RoboTextView roboTextView = aVar.f71798b;
            roboTextView.setText("To " + this.f71792a.get(i2).getPayeeName().split(" ")[0]);
        } else {
            a aVar2 = (a) vVar;
            aVar2.f71797a.setText(String.valueOf(Math.abs(Float.parseFloat(this.f71792a.get(i2).getAmount()))));
            RoboTextView roboTextView2 = aVar2.f71798b;
            roboTextView2.setText("From " + this.f71792a.get(i2).getPayeeName().split(" ")[0]);
        }
        ((a) vVar).f71799c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(f.this.f71793b, SBUserToUserDetailActivity.class);
                if (Float.parseFloat(f.this.f71792a.get(i2).getAmount()) > 0.0f) {
                    intent.putExtra("user_id", f.this.f71792a.get(i2).getPayeeId());
                } else {
                    intent.putExtra("user_id", f.this.f71792a.get(i2).getPayerId());
                }
                f.this.f71793b.startActivity(intent);
            }
        });
    }

    public final int getItemCount() {
        return this.f71792a.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f71797a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f71798b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f71799c;

        public a(View view) {
            super(view);
            this.f71797a = (RoboTextView) view.findViewById(R.id.to_from_amount);
            this.f71798b = (RoboTextView) view.findViewById(R.id.to_from_name);
            this.f71799c = (RelativeLayout) view.findViewById(R.id.to_from_name_layout);
        }
    }
}

package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.requestmoney.a.c;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    c.a f69427a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f69428b = new ArrayList<String>() {
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

    /* renamed from: c  reason: collision with root package name */
    private Context f69429c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f69427a.a(i2, (a) vVar);
    }

    public e(Context context, c.a aVar) {
        this.f69429c = context;
        this.f69427a = aVar;
    }

    public final int getItemCount() {
        return this.f69427a.b();
    }

    public class a extends RecyclerView.v implements View.OnClickListener, c.b {

        /* renamed from: b  reason: collision with root package name */
        private ImageView f69431b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f69432c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f69433d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f69434e;

        /* renamed from: f  reason: collision with root package name */
        private FrameLayout f69435f;

        /* renamed from: g  reason: collision with root package name */
        private RelativeLayout f69436g;

        a(View view) {
            super(view);
            this.f69433d = (TextView) view.findViewById(R.id.beneficiary_name);
            this.f69432c = (TextView) view.findViewById(R.id.beneficiary_number);
            this.f69431b = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.f69435f = (FrameLayout) view.findViewById(R.id.root_view);
            this.f69436g = (RelativeLayout) view.findViewById(R.id.layer_contact_list_backgrnd);
            this.f69434e = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.f69435f.setOnClickListener(this);
        }

        public final void a(String str) {
            this.f69432c.setText(str);
            this.f69434e.setText(UpiAppUtils.getInitialsSingle(str));
        }

        public final void b(String str) {
            this.f69433d.setText(str);
        }

        public final void a() {
            this.f69436g.setVisibility(0);
            this.f69434e.setVisibility(0);
            this.f69434e.setBackgroundColor(Color.parseColor(e.this.f69428b.get(getAdapterPosition() % 10)));
        }

        public final void onClick(View view) {
            if (view.getId() == R.id.root_view) {
                e.this.f69427a.a(getAdapterPosition());
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f69429c).inflate(R.layout.mt_request_money_beneficiary_swipe_item, viewGroup, false));
    }
}

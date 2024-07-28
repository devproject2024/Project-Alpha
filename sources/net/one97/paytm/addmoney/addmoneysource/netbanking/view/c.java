package net.one97.paytm.addmoney.addmoneysource.netbanking.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.netbanking.a.a;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    a.C0844a f48381a;

    /* renamed from: b  reason: collision with root package name */
    View f48382b;

    /* renamed from: c  reason: collision with root package name */
    private Context f48383c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f48381a.a(i2, (a) vVar);
    }

    public c(Context context, a.C0844a aVar) {
        this.f48383c = context;
        this.f48381a = aVar;
    }

    public final int getItemCount() {
        return this.f48381a.c();
    }

    public class a extends RecyclerView.v implements a.b {

        /* renamed from: b  reason: collision with root package name */
        private RadioButton f48385b;

        /* renamed from: c  reason: collision with root package name */
        private RoboTextView f48386c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f48387d;

        /* renamed from: e  reason: collision with root package name */
        private LinearLayout f48388e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f48389f;

        public a(final View view) {
            super(view);
            this.f48385b = (RadioButton) view.findViewById(R.id.rb_bank_select);
            this.f48386c = (RoboTextView) view.findViewById(R.id.tv_bank_name);
            this.f48387d = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.f48389f = (TextView) view.findViewById(R.id.tv_msg);
            this.f48388e = (LinearLayout) view.findViewById(R.id.ll_proceed_securely);
            view.setOnClickListener(new View.OnClickListener(c.this) {
                public final void onClick(View view) {
                    if (c.this.f48382b != null) {
                        c.this.f48382b.findViewById(R.id.ll_proceed_securely).setVisibility(8);
                        c.this.f48382b.findViewById(R.id.checkIcon).setVisibility(8);
                        c.this.f48382b.findViewById(R.id.tv_msg).setVisibility(8);
                        ((RoboTextView) c.this.f48382b.findViewById(R.id.tv_bank_name)).setFontType(2);
                    }
                    view.findViewById(R.id.ll_proceed_securely).setVisibility(0);
                    view.findViewById(R.id.checkIcon).setVisibility(0);
                    int adapterPosition = a.this.getAdapterPosition();
                    if (!c.this.f48381a.b(adapterPosition) || TextUtils.isEmpty(c.this.f48381a.c(adapterPosition))) {
                        view.findViewById(R.id.tv_msg).setVisibility(8);
                    } else {
                        view.findViewById(R.id.tv_msg).setVisibility(0);
                        ((TextView) view.findViewById(R.id.tv_msg)).setText(c.this.f48381a.c(adapterPosition));
                    }
                    ((RoboTextView) view.findViewById(R.id.tv_bank_name)).setFontType(4);
                    c.this.f48382b = view;
                }
            });
            this.f48388e.setOnClickListener(new View.OnClickListener(c.this) {
                public final void onClick(View view) {
                    c.this.f48381a.a(a.this.getAdapterPosition());
                }
            });
        }

        public final void a(String str, String str2) {
            this.f48386c.setText(str2);
            if (!TextUtils.isEmpty(str)) {
                w.a().a(str).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.f48387d, (e) null);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uam_item_source_nb, viewGroup, false));
    }
}

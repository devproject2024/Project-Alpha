package net.one97.paytm.addmoney.addmoneysource.d.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.d.a.a;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f48270a;

    /* renamed from: b  reason: collision with root package name */
    a.C0842a f48271b;

    /* renamed from: c  reason: collision with root package name */
    int f48272c;

    /* renamed from: d  reason: collision with root package name */
    int f48273d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f48274e;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f48271b.a(i2, (a) vVar);
    }

    public b(Context context, a.C0842a aVar, int i2, int i3) {
        this.f48270a = context;
        this.f48271b = aVar;
        this.f48274e = i3;
        this.f48272c = i2;
    }

    public final int getItemCount() {
        return this.f48271b.c();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RadioButton f48275a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48276b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f48277c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f48278d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f48279e;

        public a(View view) {
            super(view);
            this.f48275a = (RadioButton) view.findViewById(R.id.rb_bank_select);
            this.f48275a.setClickable(false);
            this.f48276b = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f48277c = (TextView) view.findViewById(R.id.tv_vpa);
            this.f48278d = (ImageView) view.findViewById(R.id.iv_bank_icon);
            this.f48279e = (LinearLayout) view.findViewById(R.id.ll_proceed_securely);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uam_item_source_upi, viewGroup, false));
    }
}

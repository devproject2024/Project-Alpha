package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.profile.a.k;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f68323a;

    /* renamed from: b  reason: collision with root package name */
    k.a f68324b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f68324b.a(i2, (a) vVar);
    }

    public n(Context context, k.a aVar) {
        this.f68323a = context;
        this.f68324b = aVar;
    }

    public final int getItemCount() {
        return this.f68324b.a();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public RadioButton f68325a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68326b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f68327c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68328d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f68329e;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintLayout f68330f;

        public a(View view) {
            super(view);
            this.f68325a = (RadioButton) view.findViewById(R.id.rb_bank);
            this.f68326b = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f68327c = (TextView) view.findViewById(R.id.tv_account_number);
            this.f68328d = (TextView) view.findViewById(R.id.tv_primary_account);
            this.f68329e = (ImageView) view.findViewById(R.id.iv_info);
            this.f68330f = (ConstraintLayout) view.findViewById(R.id.root_layout);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_linked_account, viewGroup, false));
    }
}

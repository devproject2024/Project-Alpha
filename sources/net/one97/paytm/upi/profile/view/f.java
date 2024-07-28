package net.one97.paytm.upi.profile.view;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.profile.a.f;

public final class f extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    a f68241a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f68242b;

    public interface a {
        void a(int i2);

        void b(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f68242b.a(i2, (f.b) (b) vVar);
    }

    public f(f.a aVar, a aVar2) {
        this.f68242b = aVar;
        this.f68241a = aVar2;
    }

    public final int getItemCount() {
        return this.f68242b.a();
    }

    public static class b extends RecyclerView.v implements f.b {

        /* renamed from: a  reason: collision with root package name */
        private AppCompatRadioButton f68247a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f68248b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f68249c;

        public b(View view) {
            super(view);
            this.f68247a = (AppCompatRadioButton) view.findViewById(R.id.rb_bank_select);
            this.f68248b = (TextView) view.findViewById(R.id.tv_bank_name);
            this.f68249c = (TextView) view.findViewById(R.id.tv_bank_acc_no);
            this.f68247a.setSupportButtonTintList(androidx.core.content.b.b(view.getContext(), R.color.radio_state_list));
        }

        public final void a(boolean z) {
            this.f68247a.setChecked(z);
            if (z) {
                this.f68248b.setTypeface(Typeface.create("sans-serif-medium", 0));
            } else {
                this.f68248b.setTypeface(Typeface.create("sans-serif", 0));
            }
            this.f68248b.requestLayout();
        }

        public final void a(String str) {
            this.f68248b.setText(str);
        }

        public final void b(String str) {
            this.f68249c.setText(str);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_upi_profile_account, viewGroup, false);
        final b bVar = new b(inflate);
        ((AppCompatRadioButton) inflate.findViewById(R.id.rb_bank_select)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int adapterPosition = bVar.getAdapterPosition();
                if (adapterPosition != -1) {
                    f.this.f68241a.a(adapterPosition);
                }
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int adapterPosition = bVar.getAdapterPosition();
                if (adapterPosition != -1) {
                    f.this.f68241a.b(adapterPosition);
                }
            }
        });
        return bVar;
    }
}

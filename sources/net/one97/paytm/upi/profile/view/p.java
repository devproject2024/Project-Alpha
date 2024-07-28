package net.one97.paytm.upi.profile.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.upi.R;

public final class p extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    int f68349a = -1;

    /* renamed from: b  reason: collision with root package name */
    a f68350b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f68351c;

    public interface a {
        void c(String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        bVar.f68352a.setText(this.f68351c.get(i2));
        bVar.f68352a.setChecked(this.f68349a == i2);
    }

    public p(ArrayList<String> arrayList, a aVar) {
        this.f68351c = arrayList;
        this.f68350b = aVar;
    }

    public final int getItemCount() {
        return this.f68351c.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RadioButton f68352a;

        public b(View view) {
            super(view);
            this.f68352a = (RadioButton) view.findViewById(R.id.suggestion_row_text);
            this.f68352a.setOnClickListener(new View.OnClickListener(p.this) {
                public final void onClick(View view) {
                    p.this.f68349a = b.this.getAdapterPosition();
                    p.this.notifyDataSetChanged();
                    p.this.f68350b.c(b.this.f68352a.getText().toString());
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_va_suggestions_row, viewGroup, false));
    }
}

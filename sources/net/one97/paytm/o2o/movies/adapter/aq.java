package net.one97.paytm.o2o.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;

public final class aq extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final List<String> f74455a;

    public aq(List<String> list) {
        k.c(list, "list");
        this.f74455a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        String str = (String) kotlin.a.k.a(aVar.f74457b.f74455a, i2);
        if (str != null) {
            RoboTextView roboTextView = aVar.f74456a;
            k.a((Object) roboTextView, "tnc");
            roboTextView.setText(str);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_cp_tnc, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…vh_cp_tnc, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74455a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f74456a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ aq f74457b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(aq aqVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74457b = aqVar;
            this.f74456a = (RoboTextView) view.findViewById(R.id.txt_tnc);
        }
    }
}

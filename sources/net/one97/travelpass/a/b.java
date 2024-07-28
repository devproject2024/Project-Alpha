package net.one97.travelpass.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.travelpass.R;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f30040a;

    /* renamed from: b  reason: collision with root package name */
    private Context f30041b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f30042c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.travelpass.ordersummary.e.a f30043d;

    /* renamed from: net.one97.travelpass.a.b$b  reason: collision with other inner class name */
    static final class C0510b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f30046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f30047b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30048c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f30049d;

        C0510b(b bVar, a aVar, int i2, x.e eVar) {
            this.f30046a = bVar;
            this.f30047b = aVar;
            this.f30048c = i2;
            this.f30049d = eVar;
        }

        public final void onClick(View view) {
        }
    }

    public b(Context context, List<String> list, net.one97.travelpass.ordersummary.e.a aVar) {
        k.c(list, "arrayList");
        this.f30040a = list;
        this.f30042c = Integer.valueOf(list.size());
        this.f30043d = aVar;
        this.f30041b = context;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "viewHolder");
        x.e eVar = new x.e();
        eVar.element = (String) this.f30040a.get(i2);
        TextView textView = aVar.f30044a;
        if (textView == null) {
            k.a();
        }
        textView.setText((String) eVar.element);
        RelativeLayout relativeLayout = aVar.f30045b;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new C0510b(this, aVar, i2, eVar));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f30041b).inflate(R.layout.vh_offer_tc_item_tp, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…_item_tp,viewGroup,false)");
        return new a(inflate);
    }

    public final int getItemCount() {
        Integer num = this.f30042c;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f30044a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f30045b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            View findViewById = view.findViewById(R.id.tv_title);
            this.f30044a = (TextView) (!(findViewById instanceof TextView) ? null : findViewById);
            View findViewById2 = view.findViewById(R.id.item_container);
            this.f30045b = (RelativeLayout) (!(findViewById2 instanceof RelativeLayout) ? null : findViewById2);
        }
    }
}

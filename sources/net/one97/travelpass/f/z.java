package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.ui.c.j;

public final class z extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30465a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30465a = (TextView) view.findViewById(R.id.tns_view);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30467b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30468c;

        a(c cVar, j jVar, int i2) {
            this.f30466a = cVar;
            this.f30467b = jVar;
            this.f30468c = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f30466a;
            if (cVar != null) {
                c.a.a(cVar, this.f30467b, Integer.valueOf(this.f30468c), (Integer) null, 4);
            }
        }
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        TextView textView = this.f30465a;
        if (textView != null) {
            textView.setOnClickListener(new a(cVar, jVar, i2));
        }
    }
}

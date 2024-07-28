package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ui.c.j;

public final class o extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private Button f30392a;

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        View findViewById = view.findViewById(R.id.checkout_btn);
        if (findViewById != null) {
            this.f30392a = (Button) findViewById;
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.Button");
    }
}

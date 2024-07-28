package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;

public final class f extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f30638a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f30639b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30640c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30641d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.info_container);
        if (relativeLayout != null) {
            this.f30638a = relativeLayout;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.next_button);
            if (relativeLayout2 != null) {
                this.f30639b = relativeLayout2;
                TextView textView = (TextView) view.findViewById(R.id.button_text);
                if (textView != null) {
                    this.f30640c = textView;
                    TextView textView2 = (TextView) view.findViewById(R.id.info_text);
                    if (textView2 != null) {
                        this.f30641d = textView2;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30643b;

        a(c cVar, j jVar) {
            this.f30642a = cVar;
            this.f30643b = jVar;
        }

        public final void onClick(View view) {
            c cVar = this.f30642a;
            if (cVar != null) {
                c.a.a(cVar, this.f30643b, (Integer) null, (Integer) null, 6);
            }
        }
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        this.f30638a.setOnClickListener(new a(cVar, jVar));
    }
}

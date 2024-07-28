package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.e.d;
import net.one97.travelpass.ui.b.a;

public final class e extends RecyclerView.v implements View.OnClickListener, d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30632a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30633b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f30634c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<j> f30635d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f30636e;

    /* renamed from: f  reason: collision with root package name */
    private j f30637f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30635d = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            this.f30632a = recyclerView;
            ImageView imageView = (ImageView) view.findViewById(R.id.btn_expand);
            if (imageView != null) {
                this.f30633b = imageView;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_expand_view);
                if (relativeLayout != null) {
                    this.f30634c = relativeLayout;
                    RelativeLayout relativeLayout2 = this.f30634c;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setOnClickListener(this);
                    }
                    TextView textView = (TextView) view.findViewById(R.id.tv_heading);
                    if (textView != null) {
                        this.f30636e = textView;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void onClick(View view) {
        if (view == null) {
            k.a();
        }
        if (view.getId() != R.id.rel_expand_view) {
            return;
        }
        if (this.f30632a.getVisibility() == 8) {
            this.f30632a.setVisibility(0);
            ImageView imageView = this.f30633b;
            if (imageView == null) {
                k.a();
            }
            imageView.setImageResource(R.drawable.ic_remove_black_24dp);
            j jVar = this.f30637f;
            if (jVar == null) {
                k.a();
            }
            a i2 = jVar.i();
            k.a((Object) i2, "viewHolderModel!!.subType");
            if (i2 == a.TRAVEL_PASS_ABOUT_HOW_TO_BUY) {
                d.a aVar = net.one97.travelpass.e.d.f30331a;
                d.a.a("custom-event", "/travel-pass/about", "travel_pass_about", "howtobuy_expanded", (String) null, (String) null, 112);
            } else if (i2 == a.TRAVEL_PASS_ABOUT_HOW_TO_USE) {
                d.a aVar2 = net.one97.travelpass.e.d.f30331a;
                d.a.a("custom-event", "/travel-pass/about", "travel_pass_about", "howtouse_expanded", (String) null, (String) null, 112);
            }
        } else {
            this.f30632a.setVisibility(8);
            ImageView imageView2 = this.f30633b;
            if (imageView2 == null) {
                k.a();
            }
            imageView2.setImageResource(R.drawable.ic_add_black_24dp);
        }
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        this.f30637f = jVar;
        ArrayList<j> a2 = jVar.a();
        k.a((Object) a2, "viewHolderModel.viewHolderData");
        this.f30635d = a2;
        this.f30632a.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.f30632a.setAdapter(new net.one97.travelpass.a.c(context, this.f30635d, cVar));
        a i3 = jVar.i();
        k.a((Object) i3, "viewHolderModel.subType");
        if (a(i3) != -1) {
            TextView textView = this.f30636e;
            a i4 = jVar.i();
            k.a((Object) i4, "viewHolderModel.subType");
            textView.setText(a(i4));
        }
    }

    private static int a(a aVar) {
        if (aVar == a.TRAVEL_PASS_ABOUT_HOW_TO_BUY) {
            return R.string.how_to_buy_title;
        }
        if (aVar == a.TRAVEL_PASS_ABOUT_HOW_TO_USE) {
            return R.string.how_to_use_title;
        }
        return -1;
    }
}

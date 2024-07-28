package net.one97.travelpass.f;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.d;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;

public final class y extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30461a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f30462b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f30463c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30464d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_pass_details);
        if (recyclerView != null) {
            this.f30461a = recyclerView;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_cashback_process);
            if (relativeLayout != null) {
                this.f30462b = relativeLayout;
                ImageView imageView = (ImageView) view.findViewById(R.id.warning_icon_image);
                if (imageView != null) {
                    this.f30463c = imageView;
                    TextView textView = (TextView) view.findViewById(R.id.warning_text);
                    if (textView != null) {
                        this.f30464d = textView;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r6, int r7, net.one97.travelpass.ui.c.j r8, com.one97.travelpass.a.c r9) {
        /*
            r5 = this;
            java.lang.String r7 = "viewHolderModel"
            kotlin.g.b.k.c(r8, r7)
            java.lang.String r7 = "itemClickListener"
            kotlin.g.b.k.c(r9, r7)
            java.lang.String r7 = r8.o()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x001d
            int r7 = r7.length()
            if (r7 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r7 = 0
            goto L_0x001e
        L_0x001d:
            r7 = 1
        L_0x001e:
            if (r7 != 0) goto L_0x0069
            java.lang.String r7 = r8.n()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0031
            int r7 = r7.length()
            if (r7 != 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r7 = 0
            goto L_0x0032
        L_0x0031:
            r7 = 1
        L_0x0032:
            if (r7 != 0) goto L_0x0069
            android.widget.RelativeLayout r7 = r5.f30462b
            if (r7 == 0) goto L_0x003b
            r7.setVisibility(r1)
        L_0x003b:
            android.widget.ImageView r7 = r5.f30463c
            if (r7 == 0) goto L_0x005b
            com.paytm.utility.b.b$a r2 = com.paytm.utility.b.b.f43744a
            android.content.Context r7 = r7.getContext()
            java.lang.String r2 = "it.context"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            com.paytm.utility.b.b$a$a r7 = com.paytm.utility.b.b.a.a(r7)
            java.lang.String r2 = r8.o()
            r7.f43753a = r2
            android.widget.ImageView r2 = r5.f30463c
            r3 = 0
            r4 = 2
            com.paytm.utility.b.b.a.C0750a.a(r7, r2, r3, r4)
        L_0x005b:
            android.widget.TextView r7 = r5.f30464d
            if (r7 == 0) goto L_0x0072
            java.lang.String r2 = r8.n()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
            goto L_0x0072
        L_0x0069:
            android.widget.RelativeLayout r7 = r5.f30462b
            if (r7 == 0) goto L_0x0072
            r2 = 8
            r7.setVisibility(r2)
        L_0x0072:
            net.one97.travelpass.a.c r7 = new net.one97.travelpass.a.c
            java.util.ArrayList r8 = r8.a()
            java.lang.String r2 = "viewHolderModel.viewHolderData"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)
            r7.<init>(r6, r8, r9)
            androidx.recyclerview.widget.LinearLayoutManager r8 = new androidx.recyclerview.widget.LinearLayoutManager
            r8.<init>(r6, r0, r1)
            androidx.recyclerview.widget.RecyclerView r6 = r5.f30461a
            if (r6 == 0) goto L_0x008e
            androidx.recyclerview.widget.RecyclerView$LayoutManager r8 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r8
            r6.setLayoutManager(r8)
        L_0x008e:
            androidx.recyclerview.widget.RecyclerView r6 = r5.f30461a
            if (r6 == 0) goto L_0x0097
            androidx.recyclerview.widget.RecyclerView$a r7 = (androidx.recyclerview.widget.RecyclerView.a) r7
            r6.setAdapter(r7)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.f.y.a(android.content.Context, int, net.one97.travelpass.ui.c.j, com.one97.travelpass.a.c):void");
    }
}

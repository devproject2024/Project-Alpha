package net.one97.paytm.wallet.p2p.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.p2p.c;

public final class a extends RecyclerView.a<C1453a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f71553a;

    /* renamed from: b  reason: collision with root package name */
    c f71554b;

    /* renamed from: c  reason: collision with root package name */
    private ThemeData f71555c;

    /* renamed from: d  reason: collision with root package name */
    private Context f71556d;

    public a(Context context, ArrayList<String> arrayList, ThemeData themeData, c cVar) {
        k.c(context, "context");
        k.c(arrayList, "listdata");
        k.c(cVar, "tagChatListner");
        this.f71553a = arrayList;
        this.f71554b = cVar;
        this.f71555c = themeData;
        this.f71556d = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r5, int r6) {
        /*
            r4 = this;
            net.one97.paytm.wallet.p2p.a.a$a r5 = (net.one97.paytm.wallet.p2p.a.a.C1453a) r5
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r5, r0)
            android.widget.TextView r0 = r5.f71557a
            java.util.ArrayList<java.lang.String> r1 = r4.f71553a
            java.lang.Object r1 = r1.get(r6)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r5.f71557a
            net.one97.paytm.wallet.p2p.a.a$b r1 = new net.one97.paytm.wallet.p2p.a.a$b
            r1.<init>(r4, r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.content.Context r6 = r4.f71556d
            android.content.res.Resources r6 = r6.getResources()
            int r0 = net.one97.paytm.wallet.R.drawable.p2p_curve_combine
            r1 = 0
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r0, r1)
            if (r6 == 0) goto L_0x00bc
            r0 = r6
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0
            net.one97.paytm.p2p.theme.ThemeData r1 = r4.f71555c
            r2 = 0
            if (r1 == 0) goto L_0x0073
            if (r1 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            java.lang.String r1 = r1.getColor()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0073
            android.widget.TextView r1 = r5.f71557a
            net.one97.paytm.p2p.theme.ThemeData r3 = r4.f71555c
            if (r3 != 0) goto L_0x0051
            kotlin.g.b.k.a()
        L_0x0051:
            java.lang.String r3 = r3.getColor()
            int r3 = android.graphics.Color.parseColor(r3)
            r1.setTextColor(r3)
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r2)
            net.one97.paytm.p2p.theme.ThemeData r2 = r4.f71555c
            if (r2 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            java.lang.String r2 = r2.getColor()
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTint(r2)
            goto L_0x0081
        L_0x0073:
            android.widget.TextView r1 = r5.f71557a
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setTextColor(r3)
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r2)
            r1.setTint(r3)
        L_0x0081:
            net.one97.paytm.p2p.theme.ThemeData r1 = r4.f71555c
            r2 = 1
            if (r1 == 0) goto L_0x00ae
            if (r1 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            java.lang.String r1 = r1.getBgcolor()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00ae
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
            net.one97.paytm.p2p.theme.ThemeData r1 = r4.f71555c
            if (r1 != 0) goto L_0x00a2
            kotlin.g.b.k.a()
        L_0x00a2:
            java.lang.String r1 = r1.getBgcolor()
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setTint(r1)
            goto L_0x00b6
        L_0x00ae:
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
            r1 = -1
            r0.setTint(r1)
        L_0x00b6:
            android.widget.TextView r5 = r5.f71557a
            r5.setBackground(r6)
            return
        L_0x00bc:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.p2p.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p2p_tag_chat_list_row, viewGroup, false);
        k.a((Object) inflate, "listItem");
        return new C1453a(inflate);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f71558a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f71559b;

        b(a aVar, int i2) {
            this.f71558a = aVar;
            this.f71559b = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f71558a.f71554b;
            String str = this.f71558a.f71553a.get(this.f71559b);
            k.a((Object) str, "listdata[position]");
            cVar.a(str);
        }
    }

    public final int getItemCount() {
        return this.f71553a.size();
    }

    /* renamed from: net.one97.paytm.wallet.p2p.a.a$a  reason: collision with other inner class name */
    public static final class C1453a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71557a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1453a(View view) {
            super(view);
            k.c(view, "itemView");
            RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.row_tv_tag_chat);
            k.a((Object) roboTextView, "itemView.row_tv_tag_chat");
            this.f71557a = roboTextView;
        }
    }
}

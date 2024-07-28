package net.one97.paytm.passbook.mlv.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MerchantItem;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<UserMLVTemplateDetail> f58007a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<MerchantItem> f58008b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public c f58009c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f58010d;

    /* renamed from: e  reason: collision with root package name */
    private final int f58011e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f58012f = 2;

    /* renamed from: g  reason: collision with root package name */
    private final int f58013g = 3;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.passbook.mgv.a.a f58014h;

    public interface c {
        void b(int i2);
    }

    public b(net.one97.paytm.passbook.mgv.a.a aVar) {
        k.c(aVar, "listener");
        this.f58014h = aVar;
    }

    public final int getItemCount() {
        if (this.f58007a.size() == 0 && this.f58008b.size() == 0 && this.f58010d) {
            return 1;
        }
        return this.f58007a.size() + this.f58008b.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0048, code lost:
        r17 = r12.getTotalBalance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "holder"
            kotlin.g.b.k.c(r1, r3)
            boolean r3 = r1 instanceof net.one97.paytm.passbook.mlv.a.b.d
            java.lang.String r4 = "50"
            java.lang.String r5 = "6456F1"
            java.lang.String r6 = "itemView.root_container"
            java.lang.String r7 = "itemView.nameTv"
            r8 = 1
            java.lang.String r9 = "itemView.amountTv"
            java.lang.String r11 = "itemView"
            if (r3 == 0) goto L_0x00f8
            r3 = r1
            net.one97.paytm.passbook.mlv.a.b$d r3 = (net.one97.paytm.passbook.mlv.a.b.d) r3
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail> r12 = r0.f58007a
            java.lang.Object r12 = r12.get(r2)
            net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail r12 = (net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail) r12
            android.view.View r13 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r11)
            int r14 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r13 = r13.findViewById(r14)
            android.widget.TextView r13 = (android.widget.TextView) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r9)
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            android.content.Context r9 = r9.getContext()
            int r14 = net.one97.paytm.passbook.R.string.rs_balance
            java.lang.Object[] r15 = new java.lang.Object[r8]
            r16 = 0
            if (r12 == 0) goto L_0x0053
            net.one97.paytm.passbook.beans.mlv.MLVAmount r17 = r12.getTotalBalance()
            if (r17 == 0) goto L_0x0053
            java.lang.String r17 = r17.getAmount()
            goto L_0x0055
        L_0x0053:
            r17 = 0
        L_0x0055:
            java.lang.String r17 = net.one97.paytm.passbook.utility.c.b((java.lang.String) r17)
            r15[r16] = r17
            java.lang.String r9 = r9.getString(r14, r15)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r13.setText(r9)
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            int r13 = net.one97.paytm.passbook.R.id.nameTv
            android.view.View r9 = r9.findViewById(r13)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            net.one97.paytm.passbook.mlv.d.a$a r7 = net.one97.paytm.passbook.mlv.d.a.f58098a
            if (r12 == 0) goto L_0x007d
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r7 = r12.getMlvCardTemplate()
            goto L_0x007e
        L_0x007d:
            r7 = 0
        L_0x007e:
            java.lang.String r7 = net.one97.paytm.passbook.mlv.d.a.C1111a.a(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r9.setText(r7)
            if (r12 == 0) goto L_0x009a
            net.one97.paytm.passbook.beans.mlv.MLVCardTemplate r7 = r12.getMlvCardTemplate()
            if (r7 == 0) goto L_0x009a
            net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo r7 = r7.getMerchantLogoInfo()
            if (r7 == 0) goto L_0x009a
            java.lang.String r10 = r7.getMerchantImageName()
            goto L_0x009b
        L_0x009a:
            r10 = 0
        L_0x009b:
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00c2
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r10)
            int r9 = net.one97.paytm.passbook.R.drawable.pass_merchant_icon_xxhdpi
            com.squareup.picasso.aa r7 = r7.a((int) r9)
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            int r10 = net.one97.paytm.passbook.R.id.mgvIcon
            android.view.View r9 = r9.findViewById(r10)
            net.one97.paytm.passbook.customview.CircularImageView r9 = (net.one97.paytm.passbook.customview.CircularImageView) r9
            r7.a((android.widget.ImageView) r9)
        L_0x00c2:
            android.view.View r7 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            int r9 = net.one97.paytm.passbook.R.id.root_container
            android.view.View r7 = r7.findViewById(r9)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            android.view.View r7 = (android.view.View) r7
            java.util.ArrayList<java.lang.String> r6 = r3.f58018a
            if (r6 == 0) goto L_0x00e6
            int r3 = r3.getAdapterPosition()
            int r3 = r3 % 8
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x00e7
        L_0x00e6:
            r3 = r5
        L_0x00e7:
            a(r7, r3, r4)
            android.view.View r1 = r1.itemView
            net.one97.paytm.passbook.mlv.a.b$e r3 = new net.one97.paytm.passbook.mlv.a.b$e
            r3.<init>(r0, r2)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
            goto L_0x01d3
        L_0x00f8:
            boolean r3 = r1 instanceof net.one97.paytm.passbook.mlv.a.b.a
            if (r3 == 0) goto L_0x01d3
            r3 = r1
            net.one97.paytm.passbook.mlv.a.b$a r3 = (net.one97.paytm.passbook.mlv.a.b.a) r3
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.MerchantItem> r12 = r0.f58008b
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail> r13 = r0.f58007a
            int r13 = r13.size()
            int r13 = r2 - r13
            java.lang.Object r12 = r12.get(r13)
            net.one97.paytm.passbook.beans.mlv.MerchantItem r12 = (net.one97.paytm.passbook.beans.mlv.MerchantItem) r12
            android.view.View r13 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r11)
            int r14 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r13 = r13.findViewById(r14)
            android.widget.TextView r13 = (android.widget.TextView) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r9)
            if (r12 == 0) goto L_0x0126
            java.lang.String r9 = r12.getBalancePoints()
            goto L_0x0127
        L_0x0126:
            r9 = 0
        L_0x0127:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            android.view.View r15 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            android.content.Context r15 = r15.getContext()
            int r10 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r10 = r15.getString(r10)
            r14.append(r10)
            java.lang.String r10 = " "
            r14.append(r10)
            java.lang.String r9 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r9)
            r14.append(r9)
            java.lang.String r9 = r14.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r13.setText(r9)
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            int r10 = net.one97.paytm.passbook.R.id.nameTv
            android.view.View r9 = r9.findViewById(r10)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            if (r12 == 0) goto L_0x016a
            java.lang.String r10 = r12.getName()
            goto L_0x016b
        L_0x016a:
            r10 = 0
        L_0x016b:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            if (r12 == 0) goto L_0x0177
            java.lang.String r10 = r12.getLogo()
            goto L_0x0178
        L_0x0177:
            r10 = 0
        L_0x0178:
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x019f
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r10)
            int r9 = net.one97.paytm.passbook.R.drawable.pass_merchant_icon_xxhdpi
            com.squareup.picasso.aa r7 = r7.a((int) r9)
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            int r10 = net.one97.paytm.passbook.R.id.mgvIcon
            android.view.View r9 = r9.findViewById(r10)
            net.one97.paytm.passbook.customview.CircularImageView r9 = (net.one97.paytm.passbook.customview.CircularImageView) r9
            r7.a((android.widget.ImageView) r9)
        L_0x019f:
            android.view.View r7 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            int r9 = net.one97.paytm.passbook.R.id.root_container
            android.view.View r7 = r7.findViewById(r9)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            android.view.View r7 = (android.view.View) r7
            java.util.ArrayList<java.lang.String> r6 = r3.f58015a
            if (r6 == 0) goto L_0x01c3
            int r3 = r3.getAdapterPosition()
            int r3 = r3 % 8
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x01c4
        L_0x01c3:
            r3 = r5
        L_0x01c4:
            a(r7, r3, r4)
            android.view.View r1 = r1.itemView
            net.one97.paytm.passbook.mlv.a.b$f r3 = new net.one97.paytm.passbook.mlv.a.b$f
            r3.<init>(r0, r2)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x01d3:
            java.util.ArrayList<net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail> r1 = r0.f58007a
            int r1 = r1.size()
            int r1 = r1 - r8
            if (r2 != r1) goto L_0x01e3
            if (r2 == 0) goto L_0x01e3
            net.one97.paytm.passbook.mgv.a.a r1 = r0.f58014h
            r1.b()
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mlv.a.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58020a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58021b;

        e(b bVar, int i2) {
            this.f58020a = bVar;
            this.f58021b = i2;
        }

        public final void onClick(View view) {
            c cVar = this.f58020a.f58009c;
            if (cVar != null) {
                cVar.b(this.f58021b);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58023b;

        f(b bVar, int i2) {
            this.f58022a = bVar;
            this.f58023b = i2;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a(net.one97.paytm.passbook.d.b().a("passMLoyalH5URL"), this.f58022a.f58008b.get(this.f58023b - this.f58022a.f58007a.size()));
            q.b(this.f58022a.f58008b.get(this.f58023b - this.f58022a.f58007a.size()).getName());
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f58011e) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_loyality_adpater_row, viewGroup, false);
            k.a((Object) inflate, "view");
            return new d(this, inflate);
        } else if (i2 == this.f58013g) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_loyality_adpater_row, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new a(this, inflate2);
        } else if (i2 == this.f58012f) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_no_data, viewGroup, false);
            k.a((Object) inflate3, "view");
            return new C1104b(this, inflate3);
        } else {
            throw new RuntimeException("Invalid view type");
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<String> f58018a = kotlin.a.k.d("A6EA5E", "F9A71C", "00b6c9", "20C1BC", "6456F1", "4790FB", "F27447", "F352A4", "ECAF15", "00ACED", "11BF80");

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f58019b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58019b = bVar;
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<String> f58015a = kotlin.a.k.d("A6EA5E", "F9A71C", "00b6c9", "20C1BC", "6456F1", "4790FB", "F27447", "F352A4", "ECAF15", "00ACED", "11BF80");

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f58016b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58016b = bVar;
        }
    }

    public final void a(ArrayList<UserMLVTemplateDetail> arrayList) {
        k.c(arrayList, "templateList");
        this.f58007a = arrayList;
        notifyDataSetChanged();
    }

    /* renamed from: net.one97.paytm.passbook.mlv.a.b$b  reason: collision with other inner class name */
    public final class C1104b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58017a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1104b(b bVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f58017a = bVar;
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f58010d) {
            return this.f58012f;
        }
        if (i2 >= this.f58007a.size()) {
            return this.f58013g;
        }
        return this.f58011e;
    }

    private static void a(View view, String str, String str2) {
        k.c(view, "view");
        k.c(str, CLConstants.FIELD_FONT_COLOR);
        k.c(str2, "alpha");
        String str3 = "#" + str2 + str;
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            Paint paint = ((ShapeDrawable) background).getPaint();
            k.a((Object) paint, "(background as ShapeDrawable).paint");
            paint.setColor(Color.parseColor(str3));
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(Color.parseColor(str3));
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(Color.parseColor(str3));
        }
    }
}

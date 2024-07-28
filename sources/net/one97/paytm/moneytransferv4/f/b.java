package net.one97.paytm.moneytransferv4.f;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.p2p.theme.ThemeData;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRGridProduct> f55415a;

    /* renamed from: b  reason: collision with root package name */
    C1023b f55416b;

    /* renamed from: c  reason: collision with root package name */
    int f55417c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f55418d = 0;

    /* renamed from: e  reason: collision with root package name */
    String f55419e = "#000000";

    /* renamed from: f  reason: collision with root package name */
    int f55420f = 3;

    /* renamed from: net.one97.paytm.moneytransferv4.f.b$b  reason: collision with other inner class name */
    public interface C1023b {
        void a(ThemeData themeData);

        void j();
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        ThemeData themeData;
        a aVar = (a) vVar;
        if (i2 != -1) {
            int i3 = this.f55420f;
            if (i2 < i3) {
                aVar.f55423c.setVisibility(4);
                aVar.f55422b.setVisibility(4);
                aVar.f55424d.setText("");
                return;
            }
            int i4 = i2 - i3;
            if (i4 != 0) {
                themeData = (ThemeData) new f().a(this.f55415a.get(i4).getName(), ThemeData.class);
                themeData.setThemeId(this.f55415a.get(i4).getProductID());
                themeData.setJsonData(this.f55415a.get(i4).getJsonValue());
                str = themeData.getThemeName();
            } else {
                str = this.f55415a.get(0).getName();
                themeData = null;
            }
            if (str.equalsIgnoreCase("Classic")) {
                aVar.f55423c.setImageDrawable(aVar.f55423c.getContext().getResources().getDrawable(R.drawable.ic_classic_theme_p2p_themes));
                if (this.f55415a.get(0).isHasBorder()) {
                    aVar.f55422b.setVisibility(0);
                } else {
                    aVar.f55422b.setVisibility(4);
                }
                aVar.f55424d.setText(str);
                aVar.f55424d.setTextColor(Color.parseColor(this.f55419e));
                if (this.f55415a.get(0).isSelected()) {
                    aVar.f55424d.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    aVar.f55424d.setTypeface(Typeface.DEFAULT);
                }
                aVar.f55423c.setVisibility(0);
            } else if (themeData != null) {
                w.a().a(this.f55415a.get(i4).getImageUrl()).a(aVar.f55423c.getContext().getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a(aVar.f55423c, (e) null);
                if (this.f55415a.get(i4).isHasBorder()) {
                    aVar.f55422b.setVisibility(0);
                } else {
                    aVar.f55422b.setVisibility(4);
                }
                aVar.f55424d.setText(themeData.getThemeName());
                if (!TextUtils.isEmpty(this.f55419e) && this.f55419e.startsWith("#")) {
                    aVar.f55424d.setTextColor(Color.parseColor(this.f55419e));
                }
                if (this.f55415a.get(i4).isSelected()) {
                    aVar.f55424d.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    aVar.f55424d.setTypeface(Typeface.DEFAULT);
                }
                aVar.f55423c.setVisibility(0);
            }
        }
    }

    public b(List<CJRGridProduct> list, C1023b bVar) {
        this.f55415a = list;
        this.f55416b = bVar;
    }

    public final int getItemCount() {
        List<CJRGridProduct> list = this.f55415a;
        if (list != null) {
            return list.size() + this.f55420f;
        }
        return 0;
    }

    public class a extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CircularImageView f55422b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55423c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f55424d;

        /* synthetic */ a(b bVar, View view, byte b2) {
            this(view);
        }

        private a(View view) {
            super(view);
            this.f55423c = (ImageView) view.findViewById(R.id.imag);
            this.f55424d = (TextView) view.findViewById(R.id.tvTitle);
            this.f55422b = (CircularImageView) view.findViewById(R.id.circular_outer_bg);
            this.f55423c.setOnClickListener(this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: net.one97.paytm.p2p.theme.ThemeData} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                int r6 = r6.getId()
                int r0 = net.one97.paytm.moneytransfer.R.id.imag
                if (r6 != r0) goto L_0x00ff
                int r6 = r5.getAdapterPosition()
                r0 = -1
                if (r6 == r0) goto L_0x00ff
                int r6 = r5.getAdapterPosition()
                net.one97.paytm.moneytransferv4.f.b r1 = net.one97.paytm.moneytransferv4.f.b.this
                int r1 = r1.f55420f
                if (r6 < r1) goto L_0x00ff
                int r6 = r5.getAdapterPosition()
                net.one97.paytm.moneytransferv4.f.b r1 = net.one97.paytm.moneytransferv4.f.b.this
                int r1 = r1.f55420f
                int r6 = r6 - r1
                r1 = 0
                r2 = 0
                if (r6 == 0) goto L_0x006b
                if (r6 == r0) goto L_0x006b
                com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
                r0.<init>()
                net.one97.paytm.moneytransferv4.f.b r1 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r1 = r1.f55415a
                java.lang.Object r1 = r1.get(r6)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r1 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r1
                java.lang.String r1 = r1.getName()
                java.lang.Class<net.one97.paytm.p2p.theme.ThemeData> r3 = net.one97.paytm.p2p.theme.ThemeData.class
                java.lang.Object r0 = r0.a((java.lang.String) r1, r3)
                r1 = r0
                net.one97.paytm.p2p.theme.ThemeData r1 = (net.one97.paytm.p2p.theme.ThemeData) r1
                net.one97.paytm.moneytransferv4.f.b r0 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r0 = r0.f55415a
                java.lang.Object r0 = r0.get(r6)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r0 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r0
                java.lang.String r0 = r0.getProductID()
                r1.setThemeId(r0)
                net.one97.paytm.moneytransferv4.f.b r0 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r0 = r0.f55415a
                java.lang.Object r0 = r0.get(r6)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r0 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r0
                java.lang.String r0 = r0.getJsonValue()
                r1.setJsonData(r0)
                java.lang.String r0 = r1.getThemeName()
                goto L_0x0079
            L_0x006b:
                net.one97.paytm.moneytransferv4.f.b r0 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r0 = r0.f55415a
                java.lang.Object r0 = r0.get(r2)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r0 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r0
                java.lang.String r0 = r0.getName()
            L_0x0079:
                net.one97.paytm.moneytransferv4.f.b r3 = net.one97.paytm.moneytransferv4.f.b.this
                int r3 = r3.f55417c
                if (r3 == r6) goto L_0x00ff
                net.one97.paytm.moneytransferv4.f.b r3 = net.one97.paytm.moneytransferv4.f.b.this
                r3.f55418d = r6
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r6 = r3.f55415a
                net.one97.paytm.moneytransferv4.f.b r3 = net.one97.paytm.moneytransferv4.f.b.this
                int r3 = r3.f55418d
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r6 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r6
                r3 = 1
                r6.setSelected(r3)
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r6 = r6.f55415a
                net.one97.paytm.moneytransferv4.f.b r4 = net.one97.paytm.moneytransferv4.f.b.this
                int r4 = r4.f55417c
                java.lang.Object r6 = r6.get(r4)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r6 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r6
                r6.setSelected(r2)
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r6 = r6.f55415a
                net.one97.paytm.moneytransferv4.f.b r4 = net.one97.paytm.moneytransferv4.f.b.this
                int r4 = r4.f55418d
                java.lang.Object r6 = r6.get(r4)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r6 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r6
                r6.setHasBorder(r3)
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                java.util.List<net.one97.paytm.common.entity.shopping.CJRGridProduct> r6 = r6.f55415a
                net.one97.paytm.moneytransferv4.f.b r3 = net.one97.paytm.moneytransferv4.f.b.this
                int r3 = r3.f55417c
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.common.entity.shopping.CJRGridProduct r6 = (net.one97.paytm.common.entity.shopping.CJRGridProduct) r6
                r6.setHasBorder(r2)
                if (r1 == 0) goto L_0x00d7
                java.lang.String r6 = r1.getColor()
                if (r6 == 0) goto L_0x00d7
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                java.lang.String r2 = r1.getColor()
                r6.f55419e = r2
                goto L_0x00dd
            L_0x00d7:
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                java.lang.String r2 = "#000000"
                r6.f55419e = r2
            L_0x00dd:
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                int r2 = r6.f55418d
                r6.f55417c = r2
                java.lang.String r6 = "Classic"
                boolean r6 = r0.equalsIgnoreCase(r6)
                if (r6 == 0) goto L_0x00f3
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                net.one97.paytm.moneytransferv4.f.b$b r6 = r6.f55416b
                r6.j()
                goto L_0x00fa
            L_0x00f3:
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                net.one97.paytm.moneytransferv4.f.b$b r6 = r6.f55416b
                r6.a(r1)
            L_0x00fa:
                net.one97.paytm.moneytransferv4.f.b r6 = net.one97.paytm.moneytransferv4.f.b.this
                r6.notifyDataSetChanged()
            L_0x00ff:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.f.b.a.onClick(android.view.View):void");
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mt_v4_theme_item_layout, viewGroup, false), (byte) 0);
    }
}

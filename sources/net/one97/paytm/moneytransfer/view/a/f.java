package net.one97.paytm.moneytransfer.view.a;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.p2p.theme.ThemeData;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<CJRGridProduct> f54262a;

    /* renamed from: b  reason: collision with root package name */
    b f54263b;

    /* renamed from: c  reason: collision with root package name */
    int f54264c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f54265d = 0;

    /* renamed from: e  reason: collision with root package name */
    String f54266e = "#000000";

    public interface b {
        void a(ThemeData themeData);

        void c();
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        ThemeData themeData;
        a aVar = (a) vVar;
        if (i2 != -1) {
            if (i2 != 0) {
                themeData = (ThemeData) new com.google.gsonhtcfix.f().a(this.f54262a.get(i2).getName(), ThemeData.class);
                themeData.setThemeId(this.f54262a.get(i2).getProductID());
                themeData.setJsonData(this.f54262a.get(i2).getJsonValue());
                str = themeData.getThemeName();
            } else {
                str = this.f54262a.get(0).getName();
                themeData = null;
            }
            if (str.equalsIgnoreCase("Classic")) {
                aVar.f54269c.setImageDrawable(aVar.f54269c.getContext().getResources().getDrawable(R.drawable.ic_classic_theme_p2p_themes));
                if (this.f54262a.get(0).isHasBorder()) {
                    aVar.f54268b.setVisibility(0);
                    aVar.f54270d.setVisibility(0);
                } else {
                    aVar.f54268b.setVisibility(4);
                    aVar.f54270d.setVisibility(4);
                }
                aVar.f54271e.setText(str);
                aVar.f54271e.setTextColor(Color.parseColor(this.f54266e));
                if (this.f54262a.get(0).isSelected()) {
                    aVar.f54271e.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    aVar.f54271e.setTypeface(Typeface.DEFAULT);
                }
            } else if (themeData != null) {
                w.a().a(this.f54262a.get(i2).getImageUrl()).a(aVar.f54269c.getContext().getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a(aVar.f54269c, (e) null);
                if (this.f54262a.get(i2).isHasBorder()) {
                    aVar.f54268b.setVisibility(0);
                    aVar.f54270d.setVisibility(0);
                } else {
                    aVar.f54268b.setVisibility(4);
                    aVar.f54270d.setVisibility(4);
                }
                aVar.f54271e.setText(themeData.getThemeName());
                if (!TextUtils.isEmpty(this.f54266e) && this.f54266e.startsWith("#")) {
                    aVar.f54271e.setTextColor(Color.parseColor(this.f54266e));
                }
                if (this.f54262a.get(i2).isSelected()) {
                    aVar.f54271e.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    aVar.f54271e.setTypeface(Typeface.DEFAULT);
                }
            }
        }
    }

    public f(List<CJRGridProduct> list, b bVar) {
        this.f54262a = list;
        this.f54263b = bVar;
    }

    public final int getItemCount() {
        List<CJRGridProduct> list = this.f54262a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CircularImageView f54268b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54269c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ImageView f54270d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public TextView f54271e;

        /* synthetic */ a(f fVar, View view, byte b2) {
            this(view);
        }

        private a(View view) {
            super(view);
            this.f54269c = (ImageView) view.findViewById(R.id.imag);
            this.f54271e = (TextView) view.findViewById(R.id.tvTitle);
            this.f54268b = (CircularImageView) view.findViewById(R.id.circular_outer_bg);
            this.f54270d = (ImageView) view.findViewById(R.id.ic_tick);
            this.f54269c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            String str;
            if (view.getId() == R.id.imag) {
                int adapterPosition = getAdapterPosition();
                ThemeData themeData = null;
                if (adapterPosition != 0) {
                    themeData = (ThemeData) new com.google.gsonhtcfix.f().a(f.this.f54262a.get(adapterPosition).getName(), ThemeData.class);
                    themeData.setThemeId(f.this.f54262a.get(adapterPosition).getProductID());
                    themeData.setJsonData(f.this.f54262a.get(adapterPosition).getJsonValue());
                    str = themeData.getThemeName();
                } else {
                    str = f.this.f54262a.get(0).getName();
                }
                if (f.this.f54264c != adapterPosition) {
                    f fVar = f.this;
                    fVar.f54265d = adapterPosition;
                    fVar.f54262a.get(f.this.f54265d).setSelected(true);
                    f.this.f54262a.get(f.this.f54264c).setSelected(false);
                    f.this.f54262a.get(f.this.f54265d).setHasBorder(true);
                    f.this.f54262a.get(f.this.f54264c).setHasBorder(false);
                    if (themeData == null || themeData.getColor() == null) {
                        f.this.f54266e = "#000000";
                    } else {
                        f.this.f54266e = themeData.getColor();
                    }
                    f fVar2 = f.this;
                    fVar2.f54264c = fVar2.f54265d;
                    if (str.equalsIgnoreCase("Classic")) {
                        f.this.f54263b.c();
                    } else {
                        f.this.f54263b.a(themeData);
                    }
                    f.this.notifyDataSetChanged();
                }
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p2p_image_layout, viewGroup, false), (byte) 0);
    }
}

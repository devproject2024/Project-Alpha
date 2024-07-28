package net.one97.paytm.p2p.theme;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.wallet.R;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRGridProduct> f56991a;

    /* renamed from: b  reason: collision with root package name */
    d f56992b;

    /* renamed from: c  reason: collision with root package name */
    int f56993c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f56994d = 0;

    /* renamed from: e  reason: collision with root package name */
    String f56995e = "#000000";

    /* renamed from: f  reason: collision with root package name */
    private Activity f56996f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final String str;
        final ThemeData themeData;
        a aVar = (a) vVar;
        if (i2 != 0) {
            themeData = (ThemeData) new com.google.gsonhtcfix.f().a(this.f56991a.get(i2).getName(), ThemeData.class);
            themeData.setThemeId(this.f56991a.get(i2).getProductID());
            themeData.setJsonData(this.f56991a.get(i2).getJsonValue());
            str = themeData.getThemeName();
        } else {
            str = this.f56991a.get(0).getName();
            themeData = null;
        }
        if (str.equalsIgnoreCase("Classic")) {
            try {
                aVar.f57003c.setImageDrawable(b.a((Context) this.f56996f, R.drawable.ic_classic_theme_p2p_themes));
            } catch (Exception unused) {
            }
            if (this.f56991a.get(0).isHasBorder()) {
                aVar.f57001a.setVisibility(0);
                aVar.f57004d.setVisibility(0);
            } else {
                aVar.f57001a.setVisibility(4);
                aVar.f57004d.setVisibility(4);
            }
            aVar.f57005e.setText(str);
            aVar.f57005e.setTextColor(Color.parseColor(this.f56995e));
            if (this.f56991a.get(0).isSelected()) {
                aVar.f57005e.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                aVar.f57005e.setTypeface(Typeface.DEFAULT);
            }
        } else {
            w.a().a(this.f56991a.get(i2).getImageUrl()).a(this.f56996f.getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a(aVar.f57003c, (e) null);
            if (this.f56991a.get(i2).isHasBorder()) {
                aVar.f57001a.setVisibility(0);
                aVar.f57004d.setVisibility(0);
            } else {
                aVar.f57001a.setVisibility(4);
                aVar.f57004d.setVisibility(4);
            }
            aVar.f57005e.setText(themeData.getThemeName());
            if (!TextUtils.isEmpty(this.f56995e) && this.f56995e.startsWith("#")) {
                aVar.f57005e.setTextColor(Color.parseColor(this.f56995e));
            }
            if (this.f56991a.get(i2).isSelected()) {
                aVar.f57005e.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                aVar.f57005e.setTypeface(Typeface.DEFAULT);
            }
        }
        aVar.f57003c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int i2 = f.this.f56993c;
                int i3 = i2;
                if (i2 != i3) {
                    f fVar = f.this;
                    fVar.f56994d = i3;
                    fVar.f56991a.get(f.this.f56994d).setSelected(true);
                    f.this.f56991a.get(f.this.f56993c).setSelected(false);
                    f.this.f56991a.get(f.this.f56994d).setHasBorder(true);
                    f.this.f56991a.get(f.this.f56993c).setHasBorder(false);
                    ThemeData themeData = themeData;
                    if (themeData == null || themeData.getColor() == null) {
                        f.this.f56995e = "#000000";
                    } else {
                        f.this.f56995e = themeData.getColor();
                    }
                    f fVar2 = f.this;
                    fVar2.f56993c = fVar2.f56994d;
                    if (str.equalsIgnoreCase("Classic")) {
                        f.this.f56992b.a();
                    } else {
                        f.this.f56992b.a(themeData);
                    }
                    f.this.notifyDataSetChanged();
                }
            }
        });
    }

    public f(ArrayList<CJRGridProduct> arrayList, Activity activity, d dVar) {
        this.f56991a = arrayList;
        this.f56996f = activity;
        this.f56992b = dVar;
    }

    public final int getItemCount() {
        if (this.f56991a.size() > 0) {
            return this.f56991a.size();
        }
        return 0;
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CircularImageView f57001a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f57002b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f57003c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f57004d;

        /* renamed from: e  reason: collision with root package name */
        TextView f57005e;

        public a(View view) {
            super(view);
            this.f57003c = (ImageView) view.findViewById(R.id.imag);
            this.f57005e = (TextView) view.findViewById(R.id.tvTitle);
            this.f57001a = (CircularImageView) view.findViewById(R.id.circular_outer_bg);
            this.f57002b = (RelativeLayout) view.findViewById(R.id.inner_layout_icon);
            this.f57004d = (ImageView) view.findViewById(R.id.ic_tick);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                }
            });
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.p2p_image_layout, viewGroup, false));
    }
}

package net.one97.paytm.wallet.newdesign.postcard.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.g;

public final class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<ThemesMetaDataModel> f71227a;

    /* renamed from: b  reason: collision with root package name */
    g.a f71228b;

    /* renamed from: c  reason: collision with root package name */
    private Context f71229c;

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.a(r1.getUrl1()).a((android.graphics.drawable.Drawable) new android.graphics.drawable.ColorDrawable(a(r8))).a(r7.f71234b, (com.squareup.picasso.e) new net.one97.paytm.wallet.newdesign.postcard.a.e.AnonymousClass1(r6));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0082 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r7, final int r8) {
        /*
            r6 = this;
            net.one97.paytm.wallet.newdesign.postcard.a.e$a r7 = (net.one97.paytm.wallet.newdesign.postcard.a.e.a) r7
            android.widget.TextView r0 = r7.f71233a     // Catch:{ NotFoundException -> 0x00e8 }
            java.util.List<net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel> r1 = r6.f71227a     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r1 = (net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel) r1     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.String r1 = r1.getThemeName()     // Catch:{ NotFoundException -> 0x00e8 }
            r0.setText(r1)     // Catch:{ NotFoundException -> 0x00e8 }
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()     // Catch:{ NotFoundException -> 0x00e8 }
            java.util.List<net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel> r1 = r6.f71227a     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r1 = (net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel) r1     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesIconsDataModel r1 = r1.getThemes()     // Catch:{ NotFoundException -> 0x00e8 }
            java.util.ArrayList r1 = r1.getThumbnailView()     // Catch:{ NotFoundException -> 0x00e8 }
            android.content.Context r2 = r6.f71229c     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.String r2 = net.one97.paytm.wallet.d.l.a((android.content.Context) r2)     // Catch:{ NotFoundException -> 0x00e8 }
            r3 = 0
            r4 = 0
        L_0x002f:
            int r5 = r1.size()     // Catch:{ NotFoundException -> 0x00e8 }
            if (r4 >= r5) goto L_0x004f
            java.lang.Object r5 = r1.get(r4)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r5 = (net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel) r5     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.String r5 = r5.getResolution()     // Catch:{ NotFoundException -> 0x00e8 }
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ NotFoundException -> 0x00e8 }
            if (r5 == 0) goto L_0x004c
            java.lang.Object r1 = r1.get(r4)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r1 = (net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel) r1     // Catch:{ NotFoundException -> 0x00e8 }
            goto L_0x0055
        L_0x004c:
            int r4 = r4 + 1
            goto L_0x002f
        L_0x004f:
            java.lang.Object r1 = r1.get(r3)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel r1 = (net.one97.paytm.common.entity.wallet.postcard.data.IconMetaDataModel) r1     // Catch:{ NotFoundException -> 0x00e8 }
        L_0x0055:
            android.widget.ImageView r2 = r7.f71234b     // Catch:{ NotFoundException -> 0x00e8 }
            android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable     // Catch:{ NotFoundException -> 0x00e8 }
            int r5 = r6.a(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            r4.<init>(r5)     // Catch:{ NotFoundException -> 0x00e8 }
            r2.setImageDrawable(r4)     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.String r2 = r1.getCacheURL1()     // Catch:{ Exception -> 0x0082 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ Exception -> 0x0082 }
            if (r2 == 0) goto L_0x0073
            android.widget.ImageView r4 = r7.f71234b     // Catch:{ Exception -> 0x0082 }
            r4.setImageBitmap(r2)     // Catch:{ Exception -> 0x0082 }
            goto L_0x00a1
        L_0x0073:
            android.widget.ImageView r2 = r7.f71234b     // Catch:{ Exception -> 0x0082 }
            android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x0082 }
            int r5 = r6.a(r8)     // Catch:{ Exception -> 0x0082 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0082 }
            r2.setImageDrawable(r4)     // Catch:{ Exception -> 0x0082 }
            goto L_0x00a1
        L_0x0082:
            java.lang.String r1 = r1.getUrl1()     // Catch:{ NotFoundException -> 0x00e8 }
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)     // Catch:{ NotFoundException -> 0x00e8 }
            android.graphics.drawable.ColorDrawable r1 = new android.graphics.drawable.ColorDrawable     // Catch:{ NotFoundException -> 0x00e8 }
            int r2 = r6.a(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            r1.<init>(r2)     // Catch:{ NotFoundException -> 0x00e8 }
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r1)     // Catch:{ NotFoundException -> 0x00e8 }
            android.widget.ImageView r1 = r7.f71234b     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.wallet.newdesign.postcard.a.e$1 r2 = new net.one97.paytm.wallet.newdesign.postcard.a.e$1     // Catch:{ NotFoundException -> 0x00e8 }
            r2.<init>()     // Catch:{ NotFoundException -> 0x00e8 }
            r0.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r2)     // Catch:{ NotFoundException -> 0x00e8 }
        L_0x00a1:
            java.util.List<net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel> r0 = r6.f71227a     // Catch:{ NotFoundException -> 0x00e8 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel r0 = (net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel) r0     // Catch:{ NotFoundException -> 0x00e8 }
            boolean r0 = r0.isSelected()     // Catch:{ NotFoundException -> 0x00e8 }
            if (r0 == 0) goto L_0x00c6
            android.widget.TextView r0 = r7.f71233a     // Catch:{ NotFoundException -> 0x00e8 }
            android.content.Context r1 = r6.f71229c     // Catch:{ NotFoundException -> 0x00e8 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ NotFoundException -> 0x00e8 }
            int r2 = net.one97.paytm.wallet.R.color.black     // Catch:{ NotFoundException -> 0x00e8 }
            int r1 = r1.getColor(r2)     // Catch:{ NotFoundException -> 0x00e8 }
            r0.setTextColor(r1)     // Catch:{ NotFoundException -> 0x00e8 }
            android.widget.RelativeLayout r0 = r7.f71236d     // Catch:{ NotFoundException -> 0x00e8 }
            r0.setVisibility(r3)     // Catch:{ NotFoundException -> 0x00e8 }
            goto L_0x00dd
        L_0x00c6:
            android.widget.TextView r0 = r7.f71233a     // Catch:{ NotFoundException -> 0x00e8 }
            android.content.Context r1 = r6.f71229c     // Catch:{ NotFoundException -> 0x00e8 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ NotFoundException -> 0x00e8 }
            int r2 = net.one97.paytm.wallet.R.color.warm_grey     // Catch:{ NotFoundException -> 0x00e8 }
            int r1 = r1.getColor(r2)     // Catch:{ NotFoundException -> 0x00e8 }
            r0.setTextColor(r1)     // Catch:{ NotFoundException -> 0x00e8 }
            android.widget.RelativeLayout r0 = r7.f71236d     // Catch:{ NotFoundException -> 0x00e8 }
            r1 = 4
            r0.setVisibility(r1)     // Catch:{ NotFoundException -> 0x00e8 }
        L_0x00dd:
            android.widget.RelativeLayout r7 = r7.f71235c     // Catch:{ NotFoundException -> 0x00e8 }
            net.one97.paytm.wallet.newdesign.postcard.a.e$2 r0 = new net.one97.paytm.wallet.newdesign.postcard.a.e$2     // Catch:{ NotFoundException -> 0x00e8 }
            r0.<init>(r8)     // Catch:{ NotFoundException -> 0x00e8 }
            r7.setOnClickListener(r0)     // Catch:{ NotFoundException -> 0x00e8 }
            return
        L_0x00e8:
            r7 = move-exception
            java.lang.String r7 = java.lang.String.valueOf(r7)
            com.paytm.utility.q.d(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.postcard.a.e.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public e(Context context, List<ThemesMetaDataModel> list, g.a aVar) {
        this.f71229c = context;
        this.f71227a = list;
        this.f71228b = aVar;
    }

    private int a(int i2) {
        switch (i2) {
            case 0:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme1);
            case 1:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme2);
            case 2:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme3);
            case 3:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme4);
            case 4:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme5);
            case 5:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme1);
            case 6:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme2);
            case 7:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme3);
            case 8:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme4);
            case 9:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme5);
            default:
                return this.f71229c.getResources().getColor(R.color.color_postcard_theme1);
        }
    }

    public final int getItemCount() {
        List<ThemesMetaDataModel> list = this.f71227a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f71233a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f71234b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f71235c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f71236d;

        public a(View view) {
            super(view);
            this.f71233a = (TextView) view.findViewById(R.id.tv_thumbnail_text);
            this.f71234b = (ImageView) view.findViewById(R.id.iv_theme_thumbnail);
            this.f71235c = (RelativeLayout) view.findViewById(R.id.rl_main_row);
            this.f71236d = (RelativeLayout) view.findViewById(R.id.lyt_user_image_border);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.postcard_theme_item, viewGroup, false));
    }
}

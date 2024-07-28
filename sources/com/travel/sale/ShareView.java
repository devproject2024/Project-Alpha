package com.travel.sale;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.f;
import com.travel.R;
import com.travel.c.g;
import com.travel.sale.data.model.CampaignDetailsResponse;
import kotlin.g.b.k;
import kotlin.u;

public final class ShareView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    final int f25703a;

    /* renamed from: b  reason: collision with root package name */
    private g f25704b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25705c;

    /* renamed from: d  reason: collision with root package name */
    private int f25706d;

    /* renamed from: e  reason: collision with root package name */
    private CampaignDetailsResponse f25707e;

    /* renamed from: f  reason: collision with root package name */
    private a f25708f;

    public interface a {
    }

    public ShareView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (kotlin.g.b.g) null);
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (kotlin.g.b.g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.g.b.g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f25703a = 1;
        this.f25706d = this.f25705c;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.f25704b = (g) f.a((LayoutInflater) systemService, R.layout.custom_share_view, (ViewGroup) this, true);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final g getBinding() {
        return this.f25704b;
    }

    public final void setBinding(g gVar) {
        this.f25704b = gVar;
    }

    public final int getSHARE_VIEW_TYPE_BASIC() {
        return this.f25705c;
    }

    public final int getSHARE_VIEW_TYPE_CUSTOM() {
        return this.f25703a;
    }

    public final int getSHARE_VIEW_TYPE() {
        return this.f25706d;
    }

    public final void setSHARE_VIEW_TYPE(int i2) {
        this.f25706d = i2;
    }

    public final CampaignDetailsResponse getCampaignDetailsResponse() {
        return this.f25707e;
    }

    public final void setCampaignDetailsResponse(CampaignDetailsResponse campaignDetailsResponse) {
        this.f25707e = campaignDetailsResponse;
    }

    public final a getShareActionListener() {
        return this.f25708f;
    }

    public final void setShareActionListener(a aVar) {
        this.f25708f = aVar;
    }

    public final void a(CampaignDetailsResponse campaignDetailsResponse, a aVar, Integer num) {
        CampaignDetailsResponse.CampaignDetails body;
        this.f25707e = campaignDetailsResponse;
        this.f25708f = aVar;
        if (num == null) {
            k.a();
        }
        this.f25706d = num.intValue();
        CampaignDetailsResponse campaignDetailsResponse2 = this.f25707e;
        if (!(campaignDetailsResponse2 == null || (body = campaignDetailsResponse2.getBody()) == null)) {
            body.isInterested();
        }
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f25706d == this.f25705c) {
            b();
        } else {
            c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r3 = this;
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0015
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x0015
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.color.color_f6f8fc
            int r1 = r1.getColor(r2)
            r0.setCardBackgroundColor((int) r1)
        L_0x0015:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x002a
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x002a
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.dimen.dimen_0dp
            float r1 = r1.getDimension(r2)
            r0.setCardElevation(r1)
        L_0x002a:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x003f
            android.widget.RelativeLayout r0 = r0.f22881b
            if (r0 == 0) goto L_0x003f
            android.content.Context r1 = r3.getContext()
            int r2 = com.travel.R.drawable.travel_oval_non_selected_button
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setBackground(r1)
        L_0x003f:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0054
            android.widget.TextView r0 = r0.f22882c
            if (r0 == 0) goto L_0x0054
            android.content.Context r1 = r3.getContext()
            int r2 = com.travel.R.color.tc_color_0db4ea
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
        L_0x0054:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0069
            android.widget.TextView r0 = r0.f22886g
            if (r0 == 0) goto L_0x0069
            android.content.Context r1 = r3.getContext()
            int r2 = com.travel.R.color.color_222222
            int r1 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r1)
        L_0x0069:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x007b
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x007b
            com.travel.sale.ShareView$b r1 = new com.travel.sale.ShareView$b
            r1.<init>(r3)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x007b:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0098
            android.widget.TextView r0 = r0.f22885f
            if (r0 == 0) goto L_0x0098
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25707e
            if (r1 == 0) goto L_0x0092
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = r1.getShareCTAText()
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.ShareView.b():void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareView f25709a;

        b(ShareView shareView) {
            this.f25709a = shareView;
        }

        public final void onClick(View view) {
            this.f25709a.getShareActionListener();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0088, code lost:
        r2 = r2.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r3 = this;
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0015
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x0015
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.color.white
            int r1 = r1.getColor(r2)
            r0.setCardBackgroundColor((int) r1)
        L_0x0015:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x002a
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x002a
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.dimen.dimen_3dp
            float r1 = r1.getDimension(r2)
            r0.setCardElevation(r1)
        L_0x002a:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x003f
            android.widget.RelativeLayout r0 = r0.f22881b
            if (r0 == 0) goto L_0x003f
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.drawable.travel_oval_button
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r0.setBackground(r1)
        L_0x003f:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0054
            android.widget.TextView r0 = r0.f22882c
            if (r0 == 0) goto L_0x0054
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.color.white
            int r1 = r1.getColor(r2)
            r0.setTextColor(r1)
        L_0x0054:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x0069
            android.widget.TextView r0 = r0.f22886g
            if (r0 == 0) goto L_0x0069
            android.content.res.Resources r1 = r3.getResources()
            int r2 = com.travel.R.color.color_303030
            int r1 = r1.getColor(r2)
            r0.setTextColor(r1)
        L_0x0069:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x007b
            androidx.cardview.widget.CardView r0 = r0.f22884e
            if (r0 == 0) goto L_0x007b
            com.travel.sale.ShareView$c r1 = new com.travel.sale.ShareView$c
            r1.<init>(r3)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x007b:
            com.travel.c.g r0 = r3.f25704b
            r1 = 0
            if (r0 == 0) goto L_0x0099
            android.widget.TextView r0 = r0.f22886g
            if (r0 == 0) goto L_0x0099
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r3.f25707e
            if (r2 == 0) goto L_0x0093
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0093
            java.lang.String r2 = r2.getShareButtonHeader()
            goto L_0x0094
        L_0x0093:
            r2 = r1
        L_0x0094:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0099:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x00b4
            android.widget.TextView r0 = r0.f22885f
            if (r0 == 0) goto L_0x00b4
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r3.f25707e
            if (r2 == 0) goto L_0x00af
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x00af
            java.lang.String r1 = r2.getShareButtonText()
        L_0x00af:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00b4:
            com.travel.c.g r0 = r3.f25704b
            if (r0 == 0) goto L_0x00c0
            android.widget.TextView r0 = r0.f22885f
            if (r0 == 0) goto L_0x00c0
            r1 = 0
            r0.setVisibility(r1)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.ShareView.c():void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareView f25710a;

        c(ShareView shareView) {
            this.f25710a = shareView;
        }

        public final void onClick(View view) {
            this.f25710a.getShareActionListener();
        }
    }

    public static /* synthetic */ void setShareViewType$default(ShareView shareView, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = Integer.valueOf(shareView.f25705c);
        }
        shareView.setShareViewType(num);
    }

    public final void setShareViewType(Integer num) {
        if (num == null) {
            k.a();
        }
        this.f25706d = num.intValue();
    }
}

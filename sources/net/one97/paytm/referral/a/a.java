package net.one97.paytm.referral.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.referral.model.RefereeInfo;
import net.one97.paytm.vipcashback.R;

public final class a extends RecyclerView.a<C0350a> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<RefereeInfo> f19892a;

    public a(ArrayList<RefereeInfo> arrayList) {
        k.c(arrayList, "refereeList");
        this.f19892a = arrayList;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        C0350a aVar = (C0350a) vVar;
        k.c(aVar, "holder");
        RefereeInfo refereeInfo = this.f19892a.get(i2);
        k.a((Object) refereeInfo, "mRefereeList[position]");
        RefereeInfo refereeInfo2 = refereeInfo;
        CharSequence image_url = refereeInfo2.getImage_url();
        if (!(image_url == null || p.a(image_url))) {
            w.a().a(refereeInfo2.getImage_url()).b().c().a(R.drawable.ic_referral_referee_no_image).a(aVar.f19894b, (e) new b(this, aVar, i2, refereeInfo2));
            aVar.f19896d.setVisibility(8);
        } else {
            a(aVar, i2, refereeInfo2);
        }
        TextView textView = aVar.f19893a;
        if (refereeInfo2 != null) {
            str = refereeInfo2.getDisplay_name();
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = aVar.f19895c;
        textView2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + this.f19892a.get(i2).getBonus());
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bonus_refrees, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…s_refrees, parent, false)");
        return new C0350a(this, inflate);
    }

    public final int getItemCount() {
        return this.f19892a.size();
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19899a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0350a f19900b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19901c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RefereeInfo f19902d;

        public final void onSuccess() {
        }

        b(a aVar, C0350a aVar2, int i2, RefereeInfo refereeInfo) {
            this.f19899a = aVar;
            this.f19900b = aVar2;
            this.f19901c = i2;
            this.f19902d = refereeInfo;
        }

        public final void onError(Exception exc) {
            this.f19899a.a(this.f19900b, this.f19901c, this.f19902d);
        }
    }

    /* renamed from: net.one97.paytm.referral.a.a$a  reason: collision with other inner class name */
    public final class C0350a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f19893a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f19894b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19895c;

        /* renamed from: d  reason: collision with root package name */
        TextView f19896d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f19897e;

        /* renamed from: f  reason: collision with root package name */
        private CardView f19898f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0350a(a aVar, View view) {
            super(view);
            k.c(view, "view");
            this.f19897e = aVar;
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            AppCompatTextView appCompatTextView = (AppCompatTextView) view2.findViewById(R.id.refree_name);
            k.a((Object) appCompatTextView, "itemView.refree_name");
            this.f19893a = appCompatTextView;
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view3.findViewById(R.id.refree_image);
            k.a((Object) appCompatImageView, "itemView.refree_image");
            this.f19894b = appCompatImageView;
            View view4 = this.itemView;
            k.a((Object) view4, "itemView");
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view4.findViewById(R.id.refree_amount);
            k.a((Object) appCompatTextView2, "itemView.refree_amount");
            this.f19895c = appCompatTextView2;
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) view5.findViewById(R.id.image_text);
            k.a((Object) appCompatTextView3, "itemView.image_text");
            this.f19896d = appCompatTextView3;
            View view6 = this.itemView;
            k.a((Object) view6, "itemView");
            CardView cardView = (CardView) view6.findViewById(R.id.card_view_referee_image);
            k.a((Object) cardView, "itemView.card_view_referee_image");
            this.f19898f = cardView;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(C0350a aVar, int i2, RefereeInfo refereeInfo) {
        try {
            aVar.f19894b.setBackgroundColor(Color.parseColor(refereeInfo.getImage_bg_color()));
        } catch (Exception unused) {
            aVar.f19894b.setBackgroundColor(androidx.core.content.b.c(aVar.f19894b.getContext(), R.color.color_51768d));
        }
        CharSequence display_name_initial = this.f19892a.get(i2).getDisplay_name_initial();
        if (display_name_initial == null || p.a(display_name_initial)) {
            w.a().a(R.drawable.ic_referral_referee_no_image).a(R.drawable.ic_referral_referee_no_image).a(aVar.f19894b);
            aVar.f19896d.setVisibility(8);
            return;
        }
        aVar.f19894b.setImageDrawable((Drawable) null);
        aVar.f19896d.setText(this.f19892a.get(i2).getDisplay_name_initial());
        aVar.f19896d.setVisibility(0);
    }
}

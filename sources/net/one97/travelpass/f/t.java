package net.one97.travelpass.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b.b;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.model.InternalOfferData;
import net.one97.travelpass.ui.c.j;

public final class t extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30422a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.offer_image_internal);
        if (imageView != null) {
            this.f30422a = imageView;
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (b2 != null) {
            InternalOfferData internalOfferData = (InternalOfferData) b2;
            String imageUrl = internalOfferData.getImageUrl();
            CharSequence charSequence = imageUrl;
            if (!(charSequence == null || charSequence.length() == 0) && context != null) {
                b.a aVar = b.f43744a;
                b.a.C0750a a2 = b.a.a(context);
                a2.f43753a = imageUrl;
                Drawable a3 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                if (a3 == null) {
                    k.a();
                }
                k.a((Object) a3, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                b.a.C0750a b3 = a2.b(a3);
                Drawable a4 = androidx.core.content.b.a(context, R.drawable.travelpass_placeholder_default);
                if (a4 == null) {
                    k.a();
                }
                k.a((Object) a4, "ContextCompat.getDrawabl…ss_placeholder_default)!!");
                b.a.C0750a.a(b3.a((Object) a4), this.f30422a, (com.paytm.utility.b.b.b) null, 2);
            }
            ImageView imageView = this.f30422a;
            if (imageView != null) {
                imageView.setOnClickListener(new a(internalOfferData, cVar, jVar));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.travelpass.model.InternalOfferData");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InternalOfferData f30423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f30424b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f30425c;

        a(InternalOfferData internalOfferData, c cVar, j jVar) {
            this.f30423a = internalOfferData;
            this.f30424b = cVar;
            this.f30425c = jVar;
        }

        public final void onClick(View view) {
            c cVar;
            if (this.f30423a.isClickable() && (cVar = this.f30424b) != null) {
                c.a.a(cVar, this.f30425c, (Integer) null, (Integer) null, 6);
            }
        }
    }
}

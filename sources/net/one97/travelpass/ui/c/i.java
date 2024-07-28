package net.one97.travelpass.ui.c;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.model.TravelPassMetaData;

public final class i extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f30654a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30655b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30656c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30657d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f30658e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.info_container);
        this.f30654a = !(linearLayout instanceof LinearLayout) ? null : linearLayout;
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_group);
        this.f30655b = !(imageView instanceof ImageView) ? null : imageView;
        ResourceUtils.loadTPassImagesFromCDN$default(this.f30655b, "group_cards.png", false, false, (n.a) null, 16, (Object) null);
        TextView textView = (TextView) view.findViewById(R.id.info_header);
        this.f30656c = !(textView instanceof TextView) ? null : textView;
        TextView textView2 = (TextView) view.findViewById(R.id.info_desc);
        this.f30657d = !(textView2 instanceof TextView) ? null : textView2;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.next_arrow);
        this.f30658e = !(imageView2 instanceof ImageView) ? null : imageView2;
        ResourceUtils.loadTPassImagesFromCDN$default(this.f30658e, "arrow_right.png", false, true, (n.a) null, 16, (Object) null);
        ImageView imageView3 = this.f30658e;
        if (imageView3 != null) {
            imageView3.setColorFilter(Color.parseColor("#FFFFFF"));
        }
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof TravelPassMetaData.UserPassInfo)) {
            b2 = null;
        }
        TravelPassMetaData.UserPassInfo userPassInfo = (TravelPassMetaData.UserPassInfo) b2;
        LinearLayout linearLayout = this.f30654a;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new a(cVar, jVar));
        }
        if (userPassInfo != null) {
            String str = userPassInfo.getTotalActivePasses() + "   ";
            SpannableString spannableString = new SpannableString(str + "• " + userPassInfo.getMessage());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ebfaff")), str.length(), str.length() + 1, 33);
            TextView textView = this.f30657d;
            if (textView != null) {
                textView.setText(spannableString);
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30659a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30660b;

        a(c cVar, j jVar) {
            this.f30659a = cVar;
            this.f30660b = jVar;
        }

        public final void onClick(View view) {
            c cVar = this.f30659a;
            if (cVar != null) {
                c.a.a(cVar, this.f30660b, (Integer) null, (Integer) null, 6);
            }
        }
    }
}

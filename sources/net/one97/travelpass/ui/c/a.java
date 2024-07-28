package net.one97.travelpass.ui.c;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.model.TravelPassMetaData;

public final class a extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f30616a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30617b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.info_container);
        if (relativeLayout != null) {
            this.f30616a = relativeLayout;
            TextView textView = (TextView) view.findViewById(R.id.info_text);
            if (textView != null) {
                this.f30617b = textView;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof TravelPassMetaData.UserPassInfo)) {
            b2 = null;
        }
        TravelPassMetaData.UserPassInfo userPassInfo = (TravelPassMetaData.UserPassInfo) b2;
        this.f30616a.setOnClickListener(new C0521a(cVar, jVar));
        if (userPassInfo != null) {
            String str = userPassInfo.getTotalActivePasses() + "   ";
            SpannableString spannableString = new SpannableString(str + "• " + userPassInfo.getMessage());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ebfaff")), str.length(), str.length() + 1, 33);
            this.f30617b.setText(spannableString);
        }
    }

    /* renamed from: net.one97.travelpass.ui.c.a$a  reason: collision with other inner class name */
    static final class C0521a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30618a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30619b;

        C0521a(c cVar, j jVar) {
            this.f30618a = cVar;
            this.f30619b = jVar;
        }

        public final void onClick(View view) {
            c cVar = this.f30618a;
            if (cVar != null) {
                c.a.a(cVar, this.f30619b, (Integer) null, (Integer) null, 6);
            }
        }
    }
}

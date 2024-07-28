package com.travel.flight.flightticket.j;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.n;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import com.travel.utils.n;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class e extends RecyclerView.v implements r {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f25140a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f25141b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f25142c;

    /* renamed from: d  reason: collision with root package name */
    private View f25143d;

    public e(View view) {
        super(view);
        this.f25140a = (ImageView) view.findViewById(R.id.fr_icon_view);
        this.f25142c = (RoboTextView) view.findViewById(R.id.fr_icon_message);
        this.f25143d = view.findViewById(R.id.fr_icon_divider);
        this.f25141b = (ImageView) view.findViewById(R.id.cancellation_fr_icon_view);
    }

    public final void a(Context context, IJRDataModel iJRDataModel, String str, boolean z, List<CJRFlightStops> list) {
        if (iJRDataModel != null && (iJRDataModel instanceof CJRMiniRulesLayoutItem)) {
            CJRMiniRulesLayoutItem cJRMiniRulesLayoutItem = (CJRMiniRulesLayoutItem) iJRDataModel;
            String windowMessage = cJRMiniRulesLayoutItem.getWindowMessage();
            String str2 = cJRMiniRulesLayoutItem.getmLayoutType();
            if (windowMessage != null && !TextUtils.isEmpty(windowMessage.trim())) {
                if (str2 == null || !str2.equalsIgnoreCase(n.ITEM_CANCELLATION_WINDOW.getName())) {
                    ImageView imageView = this.f25140a;
                    if (imageView != null) {
                        ResourceUtils.loadFlightImagesFromCDN(imageView, "fr_timer.png", false, false, n.a.V1);
                    }
                } else {
                    this.f25141b.setVisibility(0);
                    this.f25140a.setVisibility(8);
                    ResourceUtils.loadFlightImagesFromCDN(this.f25141b, "fr_timer.png", false, false, n.a.V1);
                }
                RoboTextView roboTextView = this.f25142c;
                if (roboTextView != null) {
                    roboTextView.setText(Html.fromHtml(windowMessage));
                }
            }
        }
    }
}

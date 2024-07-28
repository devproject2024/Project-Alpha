package net.one97.paytm.p2mNewDesign.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import net.one97.paytm.common.entity.offline_pg.UpiHelpModel;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;

public class k extends h {

    /* renamed from: a  reason: collision with root package name */
    private UpiHelpModel f51198a;

    /* renamed from: b  reason: collision with root package name */
    private View f51199b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f51200c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f51201d;

    public static k a(UpiHelpModel upiHelpModel) {
        k kVar = new k();
        kVar.f51198a = upiHelpModel;
        return kVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f51199b = layoutInflater.inflate(R.layout.upi_help_card_layout_new, viewGroup, false);
        this.f51200c = (ImageView) this.f51199b.findViewById(R.id.iv_upi_help_logo);
        this.f51201d = (TextView) this.f51199b.findViewById(R.id.tv_upi_help_title);
        this.f51201d.setText(this.f51198a.getDescription());
        this.f51200c.setImageDrawable(b.a(getContext(), this.f51198a.getImageViewId()));
        return this.f51199b;
    }
}

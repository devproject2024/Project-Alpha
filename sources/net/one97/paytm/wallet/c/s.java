package net.one97.paytm.wallet.c;

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

public class s extends h {

    /* renamed from: a  reason: collision with root package name */
    private UpiHelpModel f70123a;

    /* renamed from: b  reason: collision with root package name */
    private View f70124b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f70125c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70126d;

    public static s a(UpiHelpModel upiHelpModel) {
        s sVar = new s();
        sVar.f70123a = upiHelpModel;
        return sVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f70124b = layoutInflater.inflate(R.layout.upi_help_card_layout_new, viewGroup, false);
        this.f70125c = (ImageView) this.f70124b.findViewById(R.id.iv_upi_help_logo);
        this.f70126d = (TextView) this.f70124b.findViewById(R.id.tv_upi_help_title);
        this.f70126d.setText(this.f70123a.getDescription());
        this.f70125c.setImageDrawable(b.a(getContext(), this.f70123a.getImageViewId()));
        return this.f70124b;
    }
}

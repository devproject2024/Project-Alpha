package net.one97.paytm.wallet.newdesign.addbeneficiary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    Activity f70609a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f70610b;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static c a() {
        return new c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ab_know_more_bottom_sheet, viewGroup, false);
        this.f70610b = (ImageView) inflate.findViewById(R.id.iv_cross);
        this.f70610b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        return inflate;
    }
}

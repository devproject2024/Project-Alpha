package net.one97.paytm.locale.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.landingpage.R;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f53090a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f53091b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f53092c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f53093d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f53094e;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.language_setup_completed_bottom_sheet, (ViewGroup) null, false);
        this.f53091b = (TextView) inflate.findViewById(R.id.status);
        this.f53093d = (ImageView) inflate.findViewById(R.id.image_status);
        this.f53094e = (TextView) inflate.findViewById(R.id.message_no_internet);
        this.f53094e.setVisibility(8);
        if (this.f53092c) {
            if (TextUtils.isEmpty(this.f53090a)) {
                this.f53090a = "en";
            }
            this.f53091b.setText(R.string.lang_setup_complete);
            this.f53093d.setImageResource(R.drawable.language_done);
        } else {
            if (TextUtils.isEmpty(this.f53090a)) {
                this.f53090a = "en";
            }
            this.f53091b.setText(R.string.lang_setup_failed);
            this.f53093d.setImageResource(R.drawable.ic_failed_copy);
            this.f53094e.setVisibility(0);
        }
        return inflate;
    }
}

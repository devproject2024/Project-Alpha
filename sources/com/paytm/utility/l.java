package com.paytm.utility;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.b;

public class l extends b {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f43836a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f43837b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f43838c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f43838c = onClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_dismiss);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    l.this.dismiss();
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        View inflate2 = layoutInflater.inflate(R.layout.generic_bottom_sheet_alert, (ViewGroup) null);
        this.f43836a = (RoboTextView) inflate2.findViewById(R.id.error_title);
        this.f43837b = (RoboTextView) inflate2.findViewById(R.id.error_description);
        inflate2.findViewById(R.id.ok_button_text).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (l.this.f43838c != null) {
                    l.this.f43838c.onClick(view);
                }
                l.this.dismiss();
            }
        });
        if (getArguments() != null) {
            if (getArguments().containsKey("error_title")) {
                this.f43836a.setText(getArguments().getString("error_title"));
            } else {
                this.f43836a.setVisibility(8);
            }
            if (getArguments().containsKey("error_desc")) {
                this.f43837b.setText(getArguments().getString("error_desc"));
            } else {
                this.f43837b.setVisibility(8);
            }
        }
        linearLayout.addView(inflate2, layoutParams);
        return inflate;
    }
}

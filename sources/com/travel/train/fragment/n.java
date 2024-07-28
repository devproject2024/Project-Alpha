package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.play.core.splitcompat.a;
import com.travel.train.j.g;
import net.one97.paytm.i.f;

public class n extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f27075a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27076b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27077c;

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public static n a(Bundle bundle) {
        n nVar = new n();
        nVar.setArguments(bundle);
        return nVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                BottomSheetBehavior.from(frameLayout).setState(3);
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.travel.train.R.layout.train_berth_info_alert_lyt, viewGroup, false);
        this.f27075a = (ImageView) inflate.findViewById(com.travel.train.R.id.detail_close);
        this.f27076b = (TextView) inflate.findViewById(com.travel.train.R.id.tv_title);
        this.f27077c = (TextView) inflate.findViewById(com.travel.train.R.id.info_txt);
        this.f27075a.setOnClickListener(this);
        if (g.f27551a != null) {
            if (!TextUtils.isEmpty(g.f27551a.getBerthTitle())) {
                this.f27076b.setText(g.f27551a.getBerthTitle());
            }
            if (!TextUtils.isEmpty(g.f27551a.getBerthMsg())) {
                this.f27077c.setText(g.f27551a.getBerthMsg());
            }
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onClick(View view) {
        if (view.getId() == com.travel.train.R.id.detail_close) {
            dismiss();
        }
    }
}

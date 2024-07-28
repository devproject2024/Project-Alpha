package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.play.core.splitcompat.a;
import com.travel.cdn.ResourceUtils;
import com.travel.train.model.trainticket.CJRTrainTDRSubmitResponse;
import com.travel.utils.n;
import net.one97.paytm.i.f;

public final class aj extends f {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26874a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26875b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f26876c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f26877d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainTDRSubmitResponse.CJRTrainTDRSubmitBody f26878e;

    public final void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public final void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public final Dialog onCreateDialog(Bundle bundle) {
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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public aj(CJRTrainTDRSubmitResponse.CJRTrainTDRSubmitBody cJRTrainTDRSubmitBody) {
        this.f26878e = cJRTrainTDRSubmitBody;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.travel.train.R.layout.pre_t_tdr_submit_bottom_sheet_lyt, viewGroup, false);
        this.f26874a = (TextView) inflate.findViewById(com.travel.train.R.id.submit_header);
        this.f26875b = (TextView) inflate.findViewById(com.travel.train.R.id.success_txt);
        this.f26876c = (ImageView) inflate.findViewById(com.travel.train.R.id.detail_close);
        this.f26877d = (ImageView) inflate.findViewById(com.travel.train.R.id.success_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.f26877d, "tdr_submit.png", false, false, n.a.V1);
        this.f26876c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aj.this.getDialog().dismiss();
                aj.this.getActivity().finish();
            }
        });
        CJRTrainTDRSubmitResponse.CJRTrainTDRSubmitBody cJRTrainTDRSubmitBody = this.f26878e;
        if (cJRTrainTDRSubmitBody != null) {
            this.f26874a.setText(cJRTrainTDRSubmitBody.getTitleText());
            this.f26875b.setText(Html.fromHtml(this.f26878e.getMessageHtml()));
        }
        return inflate;
    }
}

package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.play.core.splitcompat.a;
import com.travel.train.R;
import net.one97.paytm.i.f;

public class d extends f {
    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.train_irctc_confirmation_backpress_popup, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.negative_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.dismiss();
                if (d.this.getActivity() != null) {
                    d.this.getActivity().finish();
                }
            }
        });
        view.findViewById(R.id.positive_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.dismiss();
            }
        });
    }
}

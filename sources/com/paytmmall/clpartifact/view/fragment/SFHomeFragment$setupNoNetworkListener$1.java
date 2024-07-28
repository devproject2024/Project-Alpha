package com.paytmmall.clpartifact.view.fragment;

import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import com.paytmmall.clpartifact.R;

final class SFHomeFragment$setupNoNetworkListener$1 implements ViewStub.OnInflateListener {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$setupNoNetworkListener$1(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        Button button;
        this.this$0.noNetworkLayout = view != null ? view.findViewById(R.id.no_network) : null;
        View access$getNoNetworkLayout$p = this.this$0.noNetworkLayout;
        if (access$getNoNetworkLayout$p != null) {
            access$getNoNetworkLayout$p.setVisibility(0);
        }
        View access$getNoNetworkLayout$p2 = this.this$0.noNetworkLayout;
        if (access$getNoNetworkLayout$p2 != null && (button = (Button) access$getNoNetworkLayout$p2.findViewById(R.id.network_retry_btn)) != null) {
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ SFHomeFragment$setupNoNetworkListener$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.refreshPage();
                }
            });
        }
    }
}

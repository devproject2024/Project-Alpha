package net.one97.paytm.phoenix.provider;

import android.view.View;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

final class LoadingViewProvider$showLoadingView$1$$special$$inlined$apply$lambda$1 implements Runnable {
    final /* synthetic */ View $this_apply;
    final /* synthetic */ LoadingViewProvider$showLoadingView$1 this$0;

    LoadingViewProvider$showLoadingView$1$$special$$inlined$apply$lambda$1(View view, LoadingViewProvider$showLoadingView$1 loadingViewProvider$showLoadingView$1) {
        this.$this_apply = view;
        this.this$0 = loadingViewProvider$showLoadingView$1;
    }

    public final void run() {
        if (this.this$0.$activity instanceof PhoenixActivity) {
            this.$this_apply.setBackgroundColor(((PhoenixActivity) this.this$0.$activity).getResources().getColor(17170445));
        }
        this.$this_apply.setVisibility(0);
    }
}

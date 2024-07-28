package com.paytmmall.clpartifact.view.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.vectordrawable.a.a.i;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import kotlin.g.b.k;

public final class SFHomeFragment$onViewCreated$7 implements z<Boolean> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$7(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final /* synthetic */ void onChanged(Object obj) {
        onChanged(((Boolean) obj).booleanValue());
    }

    public final void onChanged(boolean z) {
        y<Boolean> isScanBtnVisible;
        this.this$0.logUtils("FLoating Nav boolean set to ".concat(String.valueOf(z)));
        if (z) {
            if (this.this$0.getBottomViewHidden()) {
                this.this$0.logUtils("hiding the floating nav button as state is hide");
                SFHomeFragment sFHomeFragment = this.this$0;
                FrameLayout frameLayout = SFHomeFragment.access$getViewBinding$p(sFHomeFragment).floatingNavContainer;
                k.a((Object) frameLayout, "viewBinding.floatingNavContainer");
                sFHomeFragment.hideView(frameLayout);
            }
            TextView textView = SFHomeFragment.access$getViewBinding$p(this.this$0).scanBtn;
            k.a((Object) textView, "viewBinding.scanBtn");
            textView.setVisibility(4);
            FrameLayout frameLayout2 = SFHomeFragment.access$getViewBinding$p(this.this$0).floatingNavContainer;
            k.a((Object) frameLayout2, "viewBinding.floatingNavContainer");
            frameLayout2.setVisibility(0);
        } else {
            if (this.this$0.getBottomViewHidden()) {
                this.this$0.logUtils("hiding the scan button as state is hide");
                SFHomeFragment sFHomeFragment2 = this.this$0;
                TextView textView2 = SFHomeFragment.access$getViewBinding$p(sFHomeFragment2).scanBtn;
                k.a((Object) textView2, "viewBinding.scanBtn");
                sFHomeFragment2.hideView(textView2);
            }
            TextView textView3 = SFHomeFragment.access$getViewBinding$p(this.this$0).scanBtn;
            k.a((Object) textView3, "viewBinding.scanBtn");
            textView3.setVisibility(0);
            FrameLayout frameLayout3 = SFHomeFragment.access$getViewBinding$p(this.this$0).floatingNavContainer;
            k.a((Object) frameLayout3, "viewBinding.floatingNavContainer");
            frameLayout3.setVisibility(4);
            if (Build.VERSION.SDK_INT < 21) {
                Context context = this.this$0.getContext();
                if (context != null) {
                    k.a((Object) context, "it");
                    SFHomeFragment.access$getViewBinding$p(this.this$0).scanBtn.setCompoundDrawablesWithIntrinsicBounds(i.a(context.getResources(), R.drawable.sf_scan_image, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else {
                SFHomeFragment.access$getViewBinding$p(this.this$0).scanBtn.setCompoundDrawablesWithIntrinsicBounds(i.a(this.this$0.getResources(), R.drawable.sf_scan_image, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        SharedHomeVM access$getSharedViewModel$p = this.this$0.sharedViewModel;
        if (access$getSharedViewModel$p != null && (isScanBtnVisible = access$getSharedViewModel$p.isScanBtnVisible()) != null) {
            isScanBtnVisible.setValue(Boolean.TRUE);
        }
    }
}

package com.paytmmall.clpartifact.widgets.component.viewholder;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public abstract class FabBaseVH extends ClickableRVChildViewHolder {
    public static int ITEM_TYPE_MULTI = 101;
    public static int ITEM_TYPE_SINGLE = 100;
    private final int ANIMATION_DURATION = 300;
    private final float FINAL_SCALE = 1.5f;
    private final float INITIAL_SCALE = 1.0f;

    public abstract void bindItem(Item item, View view);

    public abstract android.view.View getAnimationView();

    public FabBaseVH(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding, iGAHandlerListener, customAction);
    }

    public void playAnimation(Animation.AnimationListener animationListener) {
        playAnimation(getAnimationView(), animationListener);
    }

    private void playAnimation(android.view.View view, Animation.AnimationListener animationListener) {
        final android.view.View view2 = view;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300);
        scaleAnimation2.setFillAfter(true);
        final Animation.AnimationListener animationListener2 = animationListener;
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                Animation.AnimationListener animationListener = animationListener2;
                if (animationListener != null) {
                    scaleAnimation2.setAnimationListener(animationListener);
                }
                view2.startAnimation(scaleAnimation2);
            }
        });
        view2.startAnimation(scaleAnimation);
    }

    public void handleDeepLink(android.view.View view, Item item, int i2) {
        super.handleDeepLink(item, i2);
        if (item.isNotificationActive()) {
            item.setNotificationActive(false);
        }
    }
}

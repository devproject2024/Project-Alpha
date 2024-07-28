package com.paytmmall.clpartifact.widgets.callback;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CustomAction {
    private ActivityListener activityListener;
    private MallSdkVHListener mallSdkVHListener;

    private CustomAction(ActivityListener activityListener2, MallSdkVHListener mallSdkVHListener2) {
        this.activityListener = activityListener2;
        this.mallSdkVHListener = mallSdkVHListener2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ CustomAction(ActivityListener activityListener2, MallSdkVHListener mallSdkVHListener2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : activityListener2, (i2 & 2) != 0 ? null : mallSdkVHListener2);
    }

    public final ActivityListener getActivityListener() {
        return this.activityListener;
    }

    public final MallSdkVHListener getMallSdkVHListener() {
        return this.mallSdkVHListener;
    }

    public final void setActivityListener(ActivityListener activityListener2) {
        this.activityListener = activityListener2;
    }

    public final void setMallSdkVHListener(MallSdkVHListener mallSdkVHListener2) {
        this.mallSdkVHListener = mallSdkVHListener2;
    }

    public static final class Builder {
        private ActivityListener activityListener;
        private MallSdkVHListener mallSdkVHListener;

        public final Builder hostActivityListener(ActivityListener activityListener2) {
            Builder builder = this;
            builder.activityListener = activityListener2;
            return builder;
        }

        public final Builder hostMallSdkVhListener(MallSdkVHListener mallSdkVHListener2) {
            k.c(mallSdkVHListener2, "mallSdkVHListener");
            Builder builder = this;
            builder.mallSdkVHListener = mallSdkVHListener2;
            return builder;
        }

        public final CustomAction build() {
            CustomAction customAction = new CustomAction((ActivityListener) null, (MallSdkVHListener) null, 3, (g) null);
            customAction.setActivityListener(this.activityListener);
            customAction.setMallSdkVHListener(this.mallSdkVHListener);
            return customAction;
        }
    }
}

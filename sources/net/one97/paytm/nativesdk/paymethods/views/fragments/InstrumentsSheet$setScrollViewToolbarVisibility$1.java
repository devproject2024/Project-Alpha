package net.one97.paytm.nativesdk.paymethods.views.fragments;

import androidx.core.widget.NestedScrollView;

final class InstrumentsSheet$setScrollViewToolbarVisibility$1 implements NestedScrollView.b {
    final /* synthetic */ int $y;
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$setScrollViewToolbarVisibility$1(InstrumentsSheet instrumentsSheet, int i2) {
        this.this$0 = instrumentsSheet;
        this.$y = i2;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        if (this.$y > i3) {
            if (this.this$0.getStickyToolbar().isToolbarVisible() != 8) {
                this.this$0.getStickyToolbar().toggleToolbarVisibility();
            }
        } else if (this.this$0.getStickyToolbar().isToolbarVisible() != 0) {
            this.this$0.getStickyToolbar().toggleToolbarVisibility();
        }
    }
}

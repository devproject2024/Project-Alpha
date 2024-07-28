package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.clpCommon.Item;

public interface IGAClickListener {
    boolean IsClickEnable();

    void OnItemClick(Item item, int i2);

    void OnItemClick(Item item, int i2, boolean z);

    /* renamed from: com.paytmmall.clpartifact.listeners.IGAClickListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$IsClickEnable(IGAClickListener iGAClickListener) {
            return false;
        }

        public static void $default$OnItemClick(IGAClickListener iGAClickListener, Item item, int i2, boolean z) {
        }

        public static void $default$OnItemClick(IGAClickListener _this, Item item, int i2) {
            _this.OnItemClick(item, i2, false);
        }
    }
}

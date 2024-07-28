package com.paytm.android.chat.bean;

import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.view.d;
import java.util.List;

public final class UserExtendedMetaData {
    @b(a = "metadata")
    private MetaData metadata;

    public final MetaData getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(MetaData metaData) {
        this.metadata = metaData;
    }

    public final class MetaData {
        @b(a = "menu_items")
        private List<d> menuItems;

        public MetaData() {
        }

        public final List<d> getMenuItems() {
            return this.menuItems;
        }

        public final void setMenuItems(List<d> list) {
            this.menuItems = list;
        }
    }
}

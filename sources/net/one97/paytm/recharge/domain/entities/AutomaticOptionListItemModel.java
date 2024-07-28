package net.one97.paytm.recharge.domain.entities;

import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;

public final class AutomaticOptionListItemModel {
    private final String description;
    private final int iconId;
    private final int id;
    private final String title;

    public static /* synthetic */ AutomaticOptionListItemModel copy$default(AutomaticOptionListItemModel automaticOptionListItemModel, int i2, String str, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = automaticOptionListItemModel.id;
        }
        if ((i4 & 2) != 0) {
            str = automaticOptionListItemModel.title;
        }
        if ((i4 & 4) != 0) {
            str2 = automaticOptionListItemModel.description;
        }
        if ((i4 & 8) != 0) {
            i3 = automaticOptionListItemModel.iconId;
        }
        return automaticOptionListItemModel.copy(i2, str, str2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.iconId;
    }

    public final AutomaticOptionListItemModel copy(int i2, String str, String str2, int i3) {
        k.c(str, "title");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        return new AutomaticOptionListItemModel(i2, str, str2, i3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AutomaticOptionListItemModel) {
                AutomaticOptionListItemModel automaticOptionListItemModel = (AutomaticOptionListItemModel) obj;
                if ((this.id == automaticOptionListItemModel.id) && k.a((Object) this.title, (Object) automaticOptionListItemModel.title) && k.a((Object) this.description, (Object) automaticOptionListItemModel.description)) {
                    if (this.iconId == automaticOptionListItemModel.iconId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.id * 31;
        String str = this.title;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + this.iconId;
    }

    public final String toString() {
        return "AutomaticOptionListItemModel(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", iconId=" + this.iconId + ")";
    }

    public AutomaticOptionListItemModel(int i2, String str, String str2, int i3) {
        k.c(str, "title");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        this.id = i2;
        this.title = str;
        this.description = str2;
        this.iconId = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getIconId() {
        return this.iconId;
    }
}

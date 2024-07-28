package net.one97.paytm.hotel4.viewmodel;

import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;

public final class SRPSortListItemViewModel extends BaseItemViewModel {
    private int isSelected = 8;
    private int position = -1;
    public SortKeysItem sortKeysItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPSortListItemViewModel(BaseViewModel baseViewModel) {
        super(baseViewModel);
        k.c(baseViewModel, "parent");
    }

    public final SortKeysItem getSortKeysItem() {
        SortKeysItem sortKeysItem2 = this.sortKeysItem;
        if (sortKeysItem2 == null) {
            k.a("sortKeysItem");
        }
        return sortKeysItem2;
    }

    public final void setSortKeysItem(SortKeysItem sortKeysItem2) {
        k.c(sortKeysItem2, "<set-?>");
        this.sortKeysItem = sortKeysItem2;
    }

    public final int isSelected() {
        return this.isSelected;
    }

    public final void setSelected(int i2) {
        this.isSelected = i2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final void setData(SortKeysItem sortKeysItem2) {
        k.c(sortKeysItem2, "data");
        this.sortKeysItem = sortKeysItem2;
        SortKeysItem sortKeysItem3 = this.sortKeysItem;
        if (sortKeysItem3 == null) {
            k.a("sortKeysItem");
        }
        if (sortKeysItem3.isSelected()) {
            this.isSelected = 0;
        } else {
            this.isSelected = 8;
        }
    }

    public final void onRecyclerItemClick() {
        SortKeysItem sortKeysItem2 = this.sortKeysItem;
        if (sortKeysItem2 == null) {
            k.a("sortKeysItem");
        }
        sortKeysItem2.setSelected(true);
        BaseViewModel parent = getParent();
        if (parent != null) {
            SRPSortViewModel sRPSortViewModel = (SRPSortViewModel) parent;
            SortKeysItem sortKeysItem3 = this.sortKeysItem;
            if (sortKeysItem3 == null) {
                k.a("sortKeysItem");
            }
            sRPSortViewModel.sortItemClickHandler(sortKeysItem3, this.position);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.viewmodel.SRPSortViewModel");
    }
}

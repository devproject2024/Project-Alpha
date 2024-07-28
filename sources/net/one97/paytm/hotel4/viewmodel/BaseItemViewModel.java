package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import kotlin.g.b.k;

public class BaseItemViewModel extends ai {
    private BaseViewModel parent;

    public BaseItemViewModel(BaseViewModel baseViewModel) {
        k.c(baseViewModel, "parent");
        this.parent = baseViewModel;
    }

    public final BaseViewModel getParent() {
        return this.parent;
    }

    public final void setParent(BaseViewModel baseViewModel) {
        k.c(baseViewModel, "<set-?>");
        this.parent = baseViewModel;
    }
}

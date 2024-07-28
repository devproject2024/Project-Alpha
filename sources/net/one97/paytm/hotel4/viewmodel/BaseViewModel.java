package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import kotlin.g.b.k;

public class BaseViewModel extends ai {
    private SharedViewModel parent;

    public BaseViewModel(SharedViewModel sharedViewModel) {
        k.c(sharedViewModel, "parent");
        this.parent = sharedViewModel;
    }

    public final SharedViewModel getParent() {
        return this.parent;
    }

    public final void setParent(SharedViewModel sharedViewModel) {
        k.c(sharedViewModel, "<set-?>");
        this.parent = sharedViewModel;
    }
}

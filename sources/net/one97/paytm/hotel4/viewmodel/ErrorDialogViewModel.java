package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import com.travel.utils.l;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.utils.b;

public final class ErrorDialogViewModel extends ai {
    private l<b.a> errorObject = new l<>();
    private l<String> tag = new l<>();

    public final l<String> getTag() {
        return this.tag;
    }

    public final void setTag(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.tag = lVar;
    }

    public final l<b.a> getErrorObject() {
        return this.errorObject;
    }

    public final void setErrorObject(l<b.a> lVar) {
        k.c(lVar, "<set-?>");
        this.errorObject = lVar;
    }
}

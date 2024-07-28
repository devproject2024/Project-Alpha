package com.paytmmall.clpartifact.view.viewmodel;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;

final class SFHomeVM$handleFilteredResponse$1 implements Runnable {
    final /* synthetic */ x.e $newList;
    final /* synthetic */ x.e $oldResponse;
    final /* synthetic */ SFHomeVM this$0;

    SFHomeVM$handleFilteredResponse$1(SFHomeVM sFHomeVM, x.e eVar, x.e eVar2) {
        this.this$0 = sFHomeVM;
        this.$newList = eVar;
        this.$oldResponse = eVar2;
    }

    public final void run() {
        ArrayList arrayList;
        View view;
        ArrayList arrayList2;
        ArrayList arrayList3;
        View view2;
        for (View view3 : (ArrayList) this.$newList.element) {
            int access$getIndex = this.this$0.getIndex(view3, (ArrayList) this.$oldResponse.element);
            if (access$getIndex != -1) {
                if (!this.this$0.isSmartHeaderPresent((ArrayList) this.$oldResponse.element)) {
                    ArrayList arrayList4 = (ArrayList) this.$oldResponse.element;
                    if (arrayList4 != null) {
                        arrayList4.remove(access$getIndex);
                    }
                    if (!(view3.getItems().size() == 0 || access$getIndex >= ((ArrayList) this.$newList.element).size() || (arrayList2 = (ArrayList) this.$oldResponse.element) == null)) {
                        arrayList2.add(access$getIndex, ((ArrayList) this.$newList.element).get(access$getIndex));
                    }
                } else if (!(access$getIndex >= ((ArrayList) this.$newList.element).size() || (arrayList3 = (ArrayList) this.$oldResponse.element) == null || (view2 = (View) arrayList3.get(access$getIndex)) == null)) {
                    view2.setmView((View) ((ArrayList) this.$newList.element).get(access$getIndex));
                }
            } else if (k.a((Object) view3.getType(), (Object) ViewHolderFactory.TYPE_CAROUSEL_ICON_4X) && view3.mItems.size() > 0 && this.this$0.isHeaderV2InOldRes((ArrayList) this.$oldResponse.element) && (arrayList = (ArrayList) this.$oldResponse.element) != null && (view = (View) arrayList.get(0)) != null) {
                view.setmView(view3);
            }
        }
    }
}

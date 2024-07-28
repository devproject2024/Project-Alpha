package com.paytmmall.clpartifact.common;

import android.content.Context;
import com.google.android.gms.common.util.f;
import com.paytmmall.clpartifact.ga.GaBuilder;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IClientDataListener;
import com.paytmmall.clpartifact.listeners.IClientListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.Promotion;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;

public abstract class StoreFrontGAHandler implements IClientDataListener, IGAHandlerListener {
    private final int DEFAULT_ROW_ITEMS = 1;
    private final int SMART_HEADER_ROW_ITEMS = 3;
    private final HashSet<String> duplicateIdMap = new HashSet<>();

    public boolean IsClickEnable() {
        return true;
    }

    public /* synthetic */ void OnItemClick(Item item, int i2) {
        IGAClickListener.CC.$default$OnItemClick(this, item, i2);
    }

    public void fireImpression(View view, int i2) {
        k.c(view, "view");
    }

    public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
    }

    public /* synthetic */ int getClient() {
        return IClientListener.CC.$default$getClient(this);
    }

    public /* synthetic */ String getClientRequestID() {
        return IAdListener.CC.$default$getClientRequestID(this);
    }

    public final HashSet<String> getDuplicateIdMap() {
        return this.duplicateIdMap;
    }

    public final int getSMART_HEADER_ROW_ITEMS() {
        return this.SMART_HEADER_ROW_ITEMS;
    }

    public final int getDEFAULT_ROW_ITEMS() {
        return this.DEFAULT_ROW_ITEMS;
    }

    public void fireImpression(Item item, int i2) {
        if (item != null) {
            List<Item> actualItems = getActualItems(item);
            int i3 = actualItems.size() > 1 ? this.SMART_HEADER_ROW_ITEMS : this.DEFAULT_ROW_ITEMS;
            int i4 = 0;
            for (Item item2 : actualItems) {
                if (!this.duplicateIdMap.contains(item2.getId())) {
                    this.duplicateIdMap.add(item2.getId());
                    fireItemImpression(item2, item.getParentBindPosition(), i3 != this.DEFAULT_ROW_ITEMS ? (i3 * i2) + i4 : i2);
                }
                i4++;
            }
        }
    }

    private final List<Item> getActualItems(Item item) {
        if (!p.a(ViewHolderFactory.LAYOUT_SMART_ICON_HEADER, item.getParentType(), true) || f.a(item.getItems())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(item);
            return arrayList;
        }
        List<Item> items = item.getItems();
        k.a((Object) items, "item.items");
        return items;
    }

    private final void fireItemImpression(Item item, int i2, int i3) {
        Promotion buildPromotion = GaBuilder.buildPromotion(item, i3, i2);
        k.a((Object) buildPromotion, "promotion");
        buildPromotion.setName(GaBuilder.getPromotionName(item));
        GaHandler instance = GaHandler.getInstance();
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildPromotion);
        instance.submitImpressionList(arrayList, (Map<String, Object>) null, this);
    }

    public void OnItemClick(Item item, int i2, boolean z) {
        String str;
        ICLPCommunicationListener communicationListener;
        ICLPCommunicationListener communicationListener2;
        CLPArtifact instance = CLPArtifact.getInstance();
        String str2 = null;
        Context context = instance != null ? instance.getContext() : null;
        if (z) {
            if (item != null) {
                str = item.getUrlType();
            } else {
                str = null;
            }
            boolean z2 = false;
            if (p.a(str, CLPConstants.URL_TYPE_EMBED, false)) {
                if (item != null) {
                    z2 = item.isMore();
                }
                if (z2) {
                    CLPArtifact instance2 = CLPArtifact.getInstance();
                    if (instance2 != null && (communicationListener2 = instance2.getCommunicationListener()) != null) {
                        String parentType = item != null ? item.getParentType() : null;
                        if (item != null) {
                            str2 = item.getName();
                        }
                        communicationListener2.sendCustomGTMEvents(context, parentType, k.a(str2, (Object) "_clicked"), (String) null, (String) null, getScreenName(), getVerticalID());
                        return;
                    }
                    return;
                }
            }
            CLPArtifact instance3 = CLPArtifact.getInstance();
            if (instance3 != null && (communicationListener = instance3.getCommunicationListener()) != null) {
                StringBuilder sb = new StringBuilder();
                if (item != null) {
                    str2 = item.getName();
                }
                sb.append(str2);
                sb.append("_clicked");
                communicationListener.sendCustomGTMEvents(context, CLPConstants.GTM_SHORTCUT_MENU, sb.toString(), (String) null, (String) null, getScreenName(), getVerticalID());
                return;
            }
            return;
        }
        GaHandler instance4 = GaHandler.getInstance();
        if (instance4 != null) {
            instance4.firePromotionClickEvent(item, i2, this);
        }
    }
}

package com.paytmmall.clpartifact.utils;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.ga.GaBuilder;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridConstants;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DeeplLinkHandler {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void handleDeepLink(Activity activity, Item item) {
            k.c(activity, "activity");
            k.c(item, "item");
            Companion companion = this;
            if (!companion.isHomeItem(item)) {
                CLPArtifact instance = CLPArtifact.getInstance();
                k.a((Object) instance, "CLPArtifact.getInstance()");
                instance.getCommunicationListener().handleDeepLink(activity, item);
            } else if (companion.isGroupIDArrayPresent(item) && (activity instanceof FragmentActivity)) {
                companion.openPopup((FragmentActivity) activity, item);
            }
        }

        private final boolean isHomeItem(Item item) {
            return isGroupIDArrayPresent(item);
        }

        private final boolean isGroupIDArrayPresent(Item item) {
            if (item == null || item.getmGroupViewId() == null) {
                return false;
            }
            Item.GroupViewId groupViewId = item.getmGroupViewId();
            k.a((Object) groupViewId, "item.getmGroupViewId()");
            if (groupViewId.getIcon_view_id() == null) {
                return false;
            }
            Item.GroupViewId groupViewId2 = item.getmGroupViewId();
            k.a((Object) groupViewId2, "item.getmGroupViewId()");
            return !groupViewId2.getIcon_view_id().isEmpty();
        }

        private final void openPopup(FragmentActivity fragmentActivity, Item item) {
            Companion companion = this;
            Item.GroupViewId groupViewId = item.getmGroupViewId();
            k.a((Object) groupViewId, "item.getmGroupViewId()");
            SFSmartIconFragment.OnItemClickListner deeplLinkHandler$Companion$openPopup$1 = new DeeplLinkHandler$Companion$openPopup$1(item, fragmentActivity);
            String parentType = item.getParentType();
            if (parentType == null) {
                parentType = "";
            }
            companion.showPopup(fragmentActivity, groupViewId, deeplLinkHandler$Companion$openPopup$1, parentType);
        }

        private final void showPopup(FragmentActivity fragmentActivity, Item.GroupViewId groupViewId, SFSmartIconFragment.OnItemClickListner onItemClickListner, String str) {
            if (!fragmentActivity.isFinishing() || !fragmentActivity.isDestroyed()) {
                q a2 = fragmentActivity.getSupportFragmentManager().a();
                k.a((Object) a2, "activity.supportFragmentManager.beginTransaction()");
                SFSmartIconFragment sFSmartIconFragment = new SFSmartIconFragment();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(SmartIconGridConstants.KEY_HOME_ICON_VIEW_ID, groupViewId.getIcon_view_id());
                bundle.putStringArrayList(SmartIconGridConstants.KEY_HOME_TICKER_ID, groupViewId.getTicker_view_id());
                bundle.putString(SmartIconGridConstants.VIEW_TYPE, str);
                sFSmartIconFragment.setArguments(bundle);
                Fragment c2 = fragmentActivity.getSupportFragmentManager().c(DeeplLinkHandlerKt.KEY_HOME_POP_UP_TAG);
                if (c2 != null) {
                    a2.a(c2);
                    if (c2 instanceof SFSmartIconFragment) {
                        ((SFSmartIconFragment) c2).dismissAllowingStateLoss();
                    }
                }
                sFSmartIconFragment.setItemClickListner(onItemClickListner);
                a2.a((Fragment) sFSmartIconFragment, DeeplLinkHandlerKt.KEY_HOME_POP_UP_TAG).c();
            }
        }

        public final void handleDeepLink(Item item, int i2, IGAHandlerListener iGAHandlerListener, Map<String, Object> map, Activity activity) {
            k.c(item, "item");
            k.c(activity, "hostActivity");
            item.setDeepLinkfired(true);
            item.setPosition(i2);
            if (map == null) {
                map = item.getGaData();
            }
            if (iGAHandlerListener != null && iGAHandlerListener.IsClickEnable()) {
                iGAHandlerListener.OnItemClick(item, i2);
            } else if (isClpImplementationAvailable()) {
                GaHandler.getInstance().fireClickEvent(item, i2);
            }
            GAUtil.setPrevListName(GaBuilder.getPromotionName(map));
            if (map != null) {
                String dimension24ForInfiniteGrid = GaBuilder.getDimension24ForInfiniteGrid(map);
                k.a((Object) dimension24ForInfiniteGrid, "GaBuilder.getDimension24ForInfiniteGrid(gaData)");
                map.put(GAUtil.KEY_PREV_GA_KEY, dimension24ForInfiniteGrid);
            }
            item.setGaData(map);
            Companion companion = this;
            companion.addToRecents(item);
            if (companion.isClpImplementationAvailable()) {
                companion.handleDeepLink(activity, item);
            }
        }

        /* access modifiers changed from: private */
        public final void addToRecents(Item item) {
            if (item.getmRecentServices()) {
                RecentsManager recentsManager = RecentsManager.INSTANCE;
                String name = item.getName();
                k.a((Object) name, "item.name");
                recentsManager.addItemInRecents(name);
            }
        }

        private final boolean isClpImplementationAvailable() {
            if (CLPArtifact.getInstance() == null) {
                return false;
            }
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            return instance.getCommunicationListener() != null;
        }
    }
}

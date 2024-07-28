package com.paytmmall.clpartifact.view.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.JSONUtils;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ImageUtility;
import java.util.List;
import org.json.JSONException;

public class PopupMenuListAdpater extends RecyclerView.a<PopupMenuVH> {
    private static final int MAX_ITEM_COUNT = 6;
    private IGAHandlerListener igaHandlerListener;
    private boolean iscolor = true;
    private List<Item> mPageItem;

    public PopupMenuListAdpater(List<Item> list, IGAHandlerListener iGAHandlerListener) {
        this.mPageItem = list;
        this.igaHandlerListener = iGAHandlerListener;
    }

    public PopupMenuVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new PopupMenuVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clp_header_menu_item, viewGroup, false));
    }

    public void onBindViewHolder(PopupMenuVH popupMenuVH, int i2) {
        Item item = this.mPageItem.get(i2);
        if (item != null) {
            item.setParentType("shortcut-menu");
            popupMenuVH.title.setText(item.getmName());
            setImageView(popupMenuVH, item);
            popupMenuVH.linearLayout.setOnClickListener(new View.OnClickListener(item, i2) {
                private final /* synthetic */ Item f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    PopupMenuListAdpater.this.lambda$onBindViewHolder$0$PopupMenuListAdpater(this.f$1, this.f$2, view);
                }
            });
            setNotificationCount(popupMenuVH, item);
            IGAHandlerListener iGAHandlerListener = this.igaHandlerListener;
            if (iGAHandlerListener != null) {
                iGAHandlerListener.fireImpression(item, i2);
            }
            addEmptyView(popupMenuVH, i2);
        }
    }

    private void setNotificationCount(PopupMenuVH popupMenuVH, Item item) {
        String str = "";
        String urlType = !TextUtils.isEmpty(item.getUrlType()) ? item.getUrlType() : str;
        if (!TextUtils.isEmpty(item.getName())) {
            str = item.getName();
        }
        if (!isNotificountUnread(urlType, str)) {
            popupMenuVH.notificationCount.setVisibility(8);
        } else if (!TextUtils.isEmpty(item.getAltImageUrl())) {
            ImageUtility.getInstance().loadImageWithPlaceHolder(popupMenuVH.imageView, item.getAltImageUrl(), false);
        } else {
            popupMenuVH.notificationCount.setVisibility(0);
        }
    }

    private boolean isNotificountUnread(String str, String str2) {
        if (CLPArtifact.getInstance().getCommunicationListener() == null || !CLPArtifact.getInstance().getCommunicationListener().isNotificationUnread()) {
            return false;
        }
        return CLPConstants.NOTIFICATION_NAME.equalsIgnoreCase(str2) || CLPConstants.NOTIFICATION_URLTYPE.equalsIgnoreCase(str);
    }

    private void addEmptyView(PopupMenuVH popupMenuVH, int i2) {
        if (this.mPageItem.size() <= 0 || i2 != this.mPageItem.size() - 1) {
            popupMenuVH.emptyTxt.setVisibility(8);
        } else {
            popupMenuVH.emptyTxt.setVisibility(0);
        }
    }

    private Item getItem(int i2) {
        try {
            return JSONUtils.getItem(new f().a((Object) this.mPageItem.get(i2)));
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleClick */
    public void lambda$onBindViewHolder$0$PopupMenuListAdpater(View view, Item item, int i2) {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        if (item != null && (view.getContext() instanceof Activity)) {
            if (communicationListener != null) {
                CLPArtifact.getInstance().getCommunicationListener().handleDeepLink((Activity) view.getContext(), item);
            }
            IGAHandlerListener iGAHandlerListener = this.igaHandlerListener;
            if (iGAHandlerListener != null) {
                iGAHandlerListener.OnItemClick(item, i2, true);
            } else if (communicationListener != null) {
                CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(view.getContext(), view.getContext().getString(R.string.menu_widget), !TextUtils.isEmpty(item.getName()) ? item.getName() : "_clicked", (String) null, (String) null, "/", view.getContext().getString(R.string.verticalId));
            }
        }
    }

    private void setImageView(PopupMenuVH popupMenuVH, Item item) {
        ImageUtility.getInstance().loadImageWithPlaceHolder(popupMenuVH.imageView, item.getImageUrl(), false);
    }

    public int getItemCount() {
        List<Item> list = this.mPageItem;
        if (list == null) {
            return 0;
        }
        if (list.size() < 6) {
            return this.mPageItem.size();
        }
        return 6;
    }

    class PopupMenuVH extends RecyclerView.v {
        /* access modifiers changed from: private */
        public TextView emptyTxt;
        /* access modifiers changed from: private */
        public ImageView imageView;
        /* access modifiers changed from: private */
        public LinearLayout linearLayout;
        /* access modifiers changed from: private */
        public ImageView notificationCount;
        /* access modifiers changed from: private */
        public TextView title;

        PopupMenuVH(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.menuText);
            this.imageView = (ImageView) view.findViewById(R.id.menuImage);
            this.linearLayout = (LinearLayout) view.findViewById(R.id.menuLatout);
            this.notificationCount = (ImageView) view.findViewById(R.id.notificationImg);
            this.emptyTxt = (TextView) view.findViewById(R.id.empty_text);
        }
    }
}

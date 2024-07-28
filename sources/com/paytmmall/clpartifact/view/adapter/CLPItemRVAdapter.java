package com.paytmmall.clpartifact.view.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemRVViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import java.util.Map;

public class CLPItemRVAdapter extends RecyclerView.a<CLPItemRVViewHolder> {
    private CustomAction customAction;
    private IGAHandlerListener igaHandlerListener;
    private String mClassType;
    public Map<String, Object> mGAData;
    private List<Item> mItemList;
    private String mType;
    private String requestID = getRequestId();
    private Long viewId;

    public CLPItemRVAdapter(View view, List<Item> list, IGAHandlerListener iGAHandlerListener, Long l, CustomAction customAction2) {
        this.mType = view.getType();
        this.mItemList = list;
        this.mGAData = view.getGaData();
        this.igaHandlerListener = iGAHandlerListener;
        this.viewId = l;
        this.customAction = customAction2;
        this.mClassType = view.getClassName();
    }

    private String getRequestId() {
        return (CLPArtifact.getInstance() == null || CLPArtifact.getInstance().getCommunicationListener() == null) ? "" : CLPArtifact.getInstance().getCommunicationListener().getClientRequestID();
    }

    public CLPItemRVViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return ViewHolderFactory.getCLPItemRVViewHolder(viewGroup, this.mType, this.igaHandlerListener, this.customAction, this.mClassType);
    }

    public void onBindViewHolder(CLPItemRVViewHolder cLPItemRVViewHolder, int i2) {
        if (cLPItemRVViewHolder != null) {
            Item item = this.mItemList.get(i2);
            item.setGaData(this.mGAData);
            List<Item> list = this.mItemList;
            item.setSpanCount(list != null ? list.size() : 0);
            cLPItemRVViewHolder.bindItem(item, i2);
        }
    }

    public void onViewAttachedToWindow(CLPItemRVViewHolder cLPItemRVViewHolder) {
        super.onViewAttachedToWindow(cLPItemRVViewHolder);
        try {
            if (this.mItemList != null && cLPItemRVViewHolder.getAdapterPosition() < this.mItemList.size()) {
                String parentType = this.mItemList.get(cLPItemRVViewHolder.getAdapterPosition()).getParentType();
                if (!ViewHolderFactory.LAYOUT_SMART_ICON_HEADER.equalsIgnoreCase(parentType) && !ViewHolderFactory.TYPE_BANNER_3.equalsIgnoreCase(parentType)) {
                    cLPItemRVViewHolder.handleGAImpression(this.mItemList.get(cLPItemRVViewHolder.getAdapterPosition()), cLPItemRVViewHolder.getAdapterPosition());
                }
            }
        } catch (Exception e2) {
            LogUtils.printStackTrace(e2);
        }
    }

    public void onViewDetachedFromWindow(CLPItemRVViewHolder cLPItemRVViewHolder) {
        super.onViewDetachedFromWindow(cLPItemRVViewHolder);
    }

    public int getItemCount() {
        if (this.mItemList == null) {
            return 0;
        }
        if (this.mType.equals(ViewHolderFactory.TYPE_ROW_1XN)) {
            if (this.mItemList.size() < 3) {
                return this.mItemList.size();
            }
            return 3;
        } else if (this.mType.equals(ViewHolderFactory.TYPE_ROW_2XN)) {
            if (this.mItemList.size() < 4) {
                return this.mItemList.size();
            }
            return 4;
        } else if (this.mType.equals(ViewHolderFactory.TYPE_ROW_3XN)) {
            if (this.mItemList.size() < 6) {
                return this.mItemList.size();
            }
            return 6;
        } else if (!this.mType.equals(ViewHolderFactory.TYPE_SMART_ICON_GRID) || this.mItemList.size() < 8) {
            return this.mItemList.size();
        } else {
            return 8;
        }
    }

    public void setData(View view, List<Item> list, IGAHandlerListener iGAHandlerListener, Long l) {
        String requestId = getRequestId();
        String type = view.getType();
        Map<String, Object> gaData = view.getGaData();
        if (!isSameRequest(requestId)) {
            this.requestID = requestId;
            resetAdapterData(type, list, gaData, iGAHandlerListener, l, view.getClassName());
        } else if (isDifferentView(l) || isDifferentItems(list)) {
            resetAdapterData(type, list, gaData, iGAHandlerListener, l, view.getClassName());
        }
    }

    private void resetAdapterData(String str, List<Item> list, Map<String, Object> map, IGAHandlerListener iGAHandlerListener, Long l, String str2) {
        this.mType = str;
        this.mGAData = map;
        this.igaHandlerListener = iGAHandlerListener;
        this.viewId = l;
        this.mItemList.clear();
        this.mItemList.addAll(list);
        this.mClassType = str2;
        notifyDataSetChanged();
    }

    private boolean isSameRequest(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.requestID);
    }

    private boolean isDifferentItems(List<Item> list) {
        return (list == null || list.size() == this.mItemList.size()) ? false : true;
    }

    private boolean isDifferentView(Long l) {
        Long l2 = this.viewId;
        return l2 == null || l == null || !l2.equals(l);
    }
}

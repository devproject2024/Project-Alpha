package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.JSONUtils;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public abstract class CLPBaseViewHolder extends RecyclerView.v {
    private IGAHandlerListener igaHandlerListener;
    private Map<String, Object> mGAData;

    public interface IParentListProvider {
        List<Page> getParentList();
    }

    /* access modifiers changed from: protected */
    public abstract void doBinding(View view);

    public void onViewAttachedToWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
    }

    public void onViewDetachedFromWindow(CLPBaseViewHolder cLPBaseViewHolder, View view) {
    }

    public CLPBaseViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding.getRoot());
        this.igaHandlerListener = iGAHandlerListener;
    }

    public CLPBaseViewHolder(android.view.View view) {
        super(view);
    }

    public void bind(String str, IParentListProvider iParentListProvider) {
        try {
            View view = JSONUtils.getView(str, iParentListProvider);
            this.mGAData = view.getGaData();
            doBinding(view);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void bind(View view, IParentListProvider iParentListProvider) {
        this.mGAData = view.getGaData();
        prepateView(view, iParentListProvider);
        doBinding(view);
    }

    private void prepateView(View view, IParentListProvider iParentListProvider) {
        View h1StoreBannerView;
        if ((view.getStoreInfo() == null || view.getRatingReview() == null) && ViewHolderFactory.TYPE_ITEM_TABBED_2.equalsIgnoreCase(view.getType()) && iParentListProvider != null && (h1StoreBannerView = getH1StoreBannerView(iParentListProvider)) != null) {
            view.setStoreInfo(h1StoreBannerView.getStoreInfo());
            view.setRatingReview(h1StoreBannerView.getRatingReview());
        }
    }

    private static View getH1StoreBannerView(IParentListProvider iParentListProvider) {
        List<View> viewStrings = getViewStrings(iParentListProvider.getParentList());
        if (viewStrings == null) {
            return null;
        }
        for (View next : viewStrings) {
            if (ViewHolderFactory.TYPE_H1_STORE_BANNER.equalsIgnoreCase(next.getType())) {
                return next;
            }
        }
        return null;
    }

    private static List<View> getViewStrings(List<Page> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Page next : list) {
                if (next.getViews() != null && next.getViews().size() > 0) {
                    arrayList.add(next.getViews().get(0));
                }
            }
        }
        return arrayList;
    }

    public Map<String, Object> getGAData() {
        return this.mGAData;
    }

    public IGAHandlerListener getIgaHandlerListener() {
        return this.igaHandlerListener;
    }

    public void setGAData(Map<String, Object> map) {
        this.mGAData = map;
    }

    public void handleGAImpression(Item item, int i2) {
        if (this.igaHandlerListener != null) {
            if (item != null) {
                item.setParentPosition(this.mGAData);
                item.setGaData(this.mGAData);
                this.igaHandlerListener.fireImpression(item, i2);
            }
        } else if (isClpImplementationAvailable()) {
            GaHandler.getInstance().fireImpression(item, getAdapterPosition());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isClpImplementationAvailable() {
        return (CLPArtifact.getInstance() == null || CLPArtifact.getInstance().getCommunicationListener() == null) ? false : true;
    }
}

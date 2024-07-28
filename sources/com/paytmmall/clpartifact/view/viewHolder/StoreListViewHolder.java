package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.FragmentItemBinding;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.stores.CJRStoreList;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.Locale;

public class StoreListViewHolder extends RecyclerView.v {
    private final String googleMap = "com.google.android.apps.maps";
    private FragmentItemBinding mViewDataBinding;
    private String storeName;

    public StoreListViewHolder(FragmentItemBinding fragmentItemBinding) {
        super(fragmentItemBinding.getRoot());
        this.mViewDataBinding = fragmentItemBinding;
    }

    public void bind(CJRStoreList cJRStoreList, String str) {
        this.storeName = str;
        this.mViewDataBinding.setItem(cJRStoreList);
        this.mViewDataBinding.setHandler(this);
        if (this.mViewDataBinding.direction != null) {
            this.mViewDataBinding.direction.setPaintFlags(8);
        }
        if (this.mViewDataBinding.call != null) {
            this.mViewDataBinding.call.setPaintFlags(8);
        }
    }

    public void openDialer(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:".concat(String.valueOf(str))));
            this.mViewDataBinding.getRoot().getContext().startActivity(intent);
            fireCallGA();
        }
    }

    public void openGoogleMaps(CJRStoreList cJRStoreList) {
        if (cJRStoreList != null) {
            try {
                double doubleValue = (cJRStoreList.getLocation() == null || cJRStoreList.getLocation().getLat() == null) ? 0.0d : cJRStoreList.getLocation().getLat().doubleValue();
                double doubleValue2 = (cJRStoreList.getLocation() == null || cJRStoreList.getLocation().getLon() == null) ? 0.0d : cJRStoreList.getLocation().getLon().doubleValue();
                if (!TextUtils.isEmpty(cJRStoreList.getAddress())) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + Uri.encode(cJRStoreList.getAddress())));
                    intent.setPackage("com.google.android.apps.maps");
                    if (isMapFound(intent)) {
                        this.mViewDataBinding.getRoot().getContext().startActivity(intent);
                    } else {
                        showToast();
                    }
                    fireDirectionGA();
                } else if (doubleValue == 0.0d || doubleValue2 == 0.0d) {
                    this.mViewDataBinding.direction.setVisibility(4);
                } else {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.ENGLISH, "geo:%f,%f", new Object[]{Double.valueOf(doubleValue), Double.valueOf(doubleValue2)})));
                    if (isMapFound(intent2)) {
                        this.mViewDataBinding.getRoot().getContext().startActivity(intent2);
                    } else {
                        showToast();
                    }
                    fireDirectionGA();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                showToast();
            }
        }
    }

    private boolean isMapFound(Intent intent) throws PackageManager.NameNotFoundException {
        if (intent.resolveActivity(this.mViewDataBinding.getRoot().getContext().getPackageManager()) == null && this.mViewDataBinding.getRoot().getContext().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0) == null) {
            return false;
        }
        return true;
    }

    private void showToast() {
        Toast.makeText(this.mViewDataBinding.getRoot().getContext(), this.mViewDataBinding.getRoot().getContext().getString(R.string.feature_not_found), 1).show();
    }

    private void fireCallGA() {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Context context = this.mViewDataBinding.getRoot().getContext();
        communicationListener.sendCustomGTMEvents(context, "brand_clp", "get_directions_clicked", "{name =" + this.storeName + "}", (String) null, CLPConstants.GA_CHANNEL_NAME, "homescreen");
    }

    private void fireDirectionGA() {
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        Context context = this.mViewDataBinding.getRoot().getContext();
        communicationListener.sendCustomGTMEvents(context, "brand_clp", "call_store_clicked", "{name =" + this.storeName + "}", (String) null, CLPConstants.GA_CHANNEL_NAME, "homescreen");
    }
}

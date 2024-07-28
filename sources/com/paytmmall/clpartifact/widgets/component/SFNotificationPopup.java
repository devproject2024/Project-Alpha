package com.paytmmall.clpartifact.widgets.component;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.SfNotificationPopupBinding;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.util.UpiConstants;

public final class SFNotificationPopup implements SFWidget {
    private final String HTTP = "http";
    private final FragmentActivity activity;
    private final SfNotificationPopupBinding binding;
    private SFWidget.DismissListener dimissListener;
    private final IGAHandlerListener gaListener;
    private final Item item;

    public SFNotificationPopup(FragmentActivity fragmentActivity, Item item2, IGAHandlerListener iGAHandlerListener) {
        k.c(fragmentActivity, "activity");
        k.c(item2, "item");
        this.activity = fragmentActivity;
        this.item = item2;
        this.gaListener = iGAHandlerListener;
        ViewDataBinding a2 = f.a(this.activity.getLayoutInflater(), R.layout.sf_notification_popup, (ViewGroup) null, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…ation_popup, null, false)");
        this.binding = (SfNotificationPopupBinding) a2;
        this.binding.setItem(this.item);
        this.binding.setClickhandler(this);
        this.binding.executePendingBindings();
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final IGAHandlerListener getGaListener() {
        return this.gaListener;
    }

    public final Item getItem() {
        return this.item;
    }

    public final void setOnDismissListener(SFWidget.DismissListener dismissListener) {
        this.dimissListener = dismissListener;
    }

    public final void dismissWidget() {
        View root = this.binding.getRoot();
        k.a((Object) root, "binding.root");
        root.setVisibility(8);
        SFWidget.DismissListener dismissListener = this.dimissListener;
        if (dismissListener != null) {
            dismissListener.onDismiss();
        }
    }

    public final void showWidget(HashMap<String, Object> hashMap) {
        View root = this.binding.getRoot();
        k.a((Object) root, "binding.root");
        root.setVisibility(0);
        IGAHandlerListener iGAHandlerListener = this.gaListener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.fireImpression(this.item, 0);
        }
    }

    public final void handleDeeplink(Item item2) {
        String str;
        ICLPCommunicationListener communicationListener;
        k.c(item2, "item");
        IGAHandlerListener iGAHandlerListener = this.gaListener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.OnItemClick(item2, 0);
        }
        String url = item2.getUrl();
        if (!TextUtils.isEmpty(url)) {
            CLPArtifact instance = CLPArtifact.getInstance();
            if (instance == null || (communicationListener = instance.getCommunicationListener()) == null || (str = communicationListener.getHostScheme()) == null) {
                str = "paytmmp://";
            }
            k.a((Object) str, "CLPArtifact.getInstance(…tScheme() ?: \"paytmmp://\"");
            k.a((Object) url, "url");
            handleDeeplink(item2, url, str);
        }
    }

    private final Intent getTargetIntent(String str) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra(UpiConstants.FROM, "");
        intent.putExtra("Maintenance", false);
        intent.putExtra("maintaince_error_503", false);
        intent.putExtra("Close", false);
        intent.putExtra("alert_title", "");
        intent.putExtra("alert_message", "");
        return intent;
    }

    public final View getView() {
        IGAHandlerListener iGAHandlerListener = this.gaListener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.fireImpression(this.item, 0);
        }
        View root = this.binding.getRoot();
        k.a((Object) root, "binding.root");
        return root;
    }

    private final void handleDeeplink(Item item2, String str, String str2) {
        CLPArtifact instance;
        ICLPCommunicationListener communicationListener;
        ICLPCommunicationListener communicationListener2;
        if (p.b(str, str2, false)) {
            CLPArtifact instance2 = CLPArtifact.getInstance();
            if (instance2 != null && (communicationListener2 = instance2.getCommunicationListener()) != null) {
                communicationListener2.handleDeepLink(this.activity, item2);
            }
        } else if (p.b(str, this.HTTP, false) && (instance = CLPArtifact.getInstance()) != null && (communicationListener = instance.getCommunicationListener()) != null) {
            communicationListener.openTargetScreen(this.activity, CLPConstants.TargetScreenType.SCREEN_TYPE_EMBED, getTargetIntent(str));
        }
    }
}

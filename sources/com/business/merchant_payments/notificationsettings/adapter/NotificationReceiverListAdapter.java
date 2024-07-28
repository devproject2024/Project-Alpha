package com.business.merchant_payments.notificationsettings.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpEmailSmsListItemBinding;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;
import java.util.List;
import kotlin.g.b.k;

public final class NotificationReceiverListAdapter extends RecyclerView.a<ViewHolder> {
    public List<NotificationReceiverModel> mSecondaryReceiverList;
    public final EmailAndSmsNotificationViewModel viewModel;

    public NotificationReceiverListAdapter(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        k.d(emailAndSmsNotificationViewModel, "viewModel");
        this.viewModel = emailAndSmsNotificationViewModel;
    }

    public final EmailAndSmsNotificationViewModel getViewModel() {
        return this.viewModel;
    }

    public static final class ViewHolder extends RecyclerView.v {
        public final MpEmailSmsListItemBinding itemRowBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(MpEmailSmsListItemBinding mpEmailSmsListItemBinding) {
            super(mpEmailSmsListItemBinding.getRoot());
            k.d(mpEmailSmsListItemBinding, "itemRowBinding");
            this.itemRowBinding = mpEmailSmsListItemBinding;
        }

        public final MpEmailSmsListItemBinding getItemRowBinding() {
            return this.itemRowBinding;
        }

        public final void bind(NotificationReceiverModel notificationReceiverModel, EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel, int i2) {
            k.d(notificationReceiverModel, "dataModel");
            k.d(emailAndSmsNotificationViewModel, "mViewModel");
            this.itemRowBinding.setDataModel(notificationReceiverModel);
            this.itemRowBinding.setViewModel(emailAndSmsNotificationViewModel);
            this.itemRowBinding.setPosition(Integer.valueOf(i2));
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            k.b(appContext, "PaymentsConfig.getInstance().appContext");
            int[] intArray = appContext.getResources().getIntArray(R.array.contacts);
            k.b(intArray, "PaymentsConfig.getInstan…ntArray(R.array.contacts)");
            if (i2 < intArray.length) {
                setContactsBackgroundColor(intArray[i2]);
            } else {
                setContactsBackgroundColor(intArray[i2 % intArray.length]);
            }
            this.itemRowBinding.executePendingBindings();
        }

        private final void setContactsBackgroundColor(int i2) {
            View view = this.itemRowBinding.bgCircle;
            k.b(view, "itemRowBinding.bgCircle");
            Drawable background = view.getBackground();
            if (background != null) {
                ((GradientDrawable) background).setColor(i2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.d(viewGroup, "parent");
        MpEmailSmsListItemBinding mpEmailSmsListItemBinding = (MpEmailSmsListItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.mp_email_sms_list_item, viewGroup, false);
        k.b(mpEmailSmsListItemBinding, "binding");
        return new ViewHolder(mpEmailSmsListItemBinding);
    }

    public final int getItemCount() {
        List<NotificationReceiverModel> list = this.mSecondaryReceiverList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void onBindViewHolder(ViewHolder viewHolder, int i2) {
        k.d(viewHolder, "holder");
        List<NotificationReceiverModel> list = this.mSecondaryReceiverList;
        NotificationReceiverModel notificationReceiverModel = list != null ? list.get(i2) : null;
        if (notificationReceiverModel != null) {
            viewHolder.bind(notificationReceiverModel, this.viewModel, i2);
        }
    }

    public final void addAllSecondaryReceivers(List<NotificationReceiverModel> list) {
        k.d(list, "list");
        this.mSecondaryReceiverList = list;
        notifyDataSetChanged();
    }

    public final void addReceiverToList() {
        List<NotificationReceiverModel> list = this.mSecondaryReceiverList;
        k.a((Object) list);
        notifyItemInserted(list.size() - 1);
    }

    public final void addPrimaryReceiver() {
        notifyItemInserted(0);
    }

    public final void itemRemovedFromPosition(int i2) {
        notifyItemRemoved(i2);
    }
}

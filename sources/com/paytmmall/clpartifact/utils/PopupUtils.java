package com.paytmmall.clpartifact.utils;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.PopupUtils;
import com.paytmmall.clpartifact.view.fragment.CustomDialogFragment;

public class PopupUtils {

    public interface ICancelListener {
        void onCancelClick();
    }

    public interface IOkListener {
        void onOkClick();
    }

    public static void showPopup(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, ICancelListener iCancelListener, IOkListener iOkListener) {
        q a2 = fragmentActivity.getSupportFragmentManager().a();
        a2.a((String) null);
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        customDialogFragment.setCancelable(false);
        customDialogFragment.setDataModel(getDataModel(str, str2, str3, str4, new ICancelListener(customDialogFragment) {
            private final /* synthetic */ CustomDialogFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onCancelClick() {
                PopupUtils.lambda$showPopup$0(PopupUtils.ICancelListener.this, this.f$1);
            }
        }, new IOkListener(customDialogFragment) {
            private final /* synthetic */ CustomDialogFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onOkClick() {
                PopupUtils.lambda$showPopup$1(PopupUtils.IOkListener.this, this.f$1);
            }
        }));
        customDialogFragment.show(a2, "dialog");
    }

    static /* synthetic */ void lambda$showPopup$0(ICancelListener iCancelListener, CustomDialogFragment customDialogFragment) {
        iCancelListener.onCancelClick();
        dismiss(customDialogFragment);
    }

    static /* synthetic */ void lambda$showPopup$1(IOkListener iOkListener, CustomDialogFragment customDialogFragment) {
        iOkListener.onOkClick();
        dismiss(customDialogFragment);
    }

    private static void dismiss(CustomDialogFragment customDialogFragment) {
        customDialogFragment.dismissAllowingStateLoss();
    }

    private static DialogDataModel getDataModel(String str, String str2, String str3, String str4, ICancelListener iCancelListener, IOkListener iOkListener) {
        DialogDataModel dialogDataModel = new DialogDataModel();
        dialogDataModel.setTitle(str);
        dialogDataModel.setContent(str2);
        dialogDataModel.setCancelButton(str3);
        dialogDataModel.setOkButton(str4);
        dialogDataModel.setCancelListener(iCancelListener);
        dialogDataModel.setOkListener(iOkListener);
        return dialogDataModel;
    }

    public static class DialogDataModel {
        private String cancelButton;
        private ICancelListener cancelListener;
        private String content;
        private String okButton;
        private IOkListener okListener;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getOkButton() {
            return this.okButton;
        }

        public void setOkButton(String str) {
            this.okButton = str;
        }

        public String getCancelButton() {
            return this.cancelButton;
        }

        public void setCancelButton(String str) {
            this.cancelButton = str;
        }

        public IOkListener getOkListener() {
            return this.okListener;
        }

        public void setOkListener(IOkListener iOkListener) {
            this.okListener = iOkListener;
        }

        public ICancelListener getCancelListener() {
            return this.cancelListener;
        }

        public void setCancelListener(ICancelListener iCancelListener) {
            this.cancelListener = iCancelListener;
        }
    }
}

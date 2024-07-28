package com.alipay.mobile.nebula.view;

import android.os.Handler;
import android.os.Message;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ManagerToastLikeDialog extends Handler {
    private static final String TAG = "ManagerToastLikeDialog";
    private static ManagerToastLikeDialog mManagerDialog;
    private final Queue<H5ToastLikeDialog> mQueue = new LinkedBlockingQueue();

    static final class Messages {
        private static final int ADD_DIALOG = 4608852;
        private static final int DISPLAY_DIALOG = 4543316;
        private static final int REMOVE_DIALOG = 4674388;

        private Messages() {
        }
    }

    private ManagerToastLikeDialog() {
    }

    public static synchronized ManagerToastLikeDialog getInstance() {
        synchronized (ManagerToastLikeDialog.class) {
            if (mManagerDialog != null) {
                ManagerToastLikeDialog managerToastLikeDialog = mManagerDialog;
                return managerToastLikeDialog;
            }
            ManagerToastLikeDialog managerToastLikeDialog2 = new ManagerToastLikeDialog();
            mManagerDialog = managerToastLikeDialog2;
            return managerToastLikeDialog2;
        }
    }

    /* access modifiers changed from: protected */
    public void add(H5ToastLikeDialog h5ToastLikeDialog) {
        this.mQueue.add(h5ToastLikeDialog);
        showNextSuperToast();
    }

    private void showNextSuperToast() {
        if (!this.mQueue.isEmpty()) {
            H5ToastLikeDialog peek = this.mQueue.peek();
            if (!peek.isShowing()) {
                Message obtainMessage = obtainMessage(4608852);
                obtainMessage.obj = peek;
                sendMessage(obtainMessage);
                return;
            }
            sendMessageDelayed(peek, 4543316, getDuration(peek));
        }
    }

    private void sendMessageDelayed(H5ToastLikeDialog h5ToastLikeDialog, int i2, long j) {
        Message obtainMessage = obtainMessage(i2);
        obtainMessage.obj = h5ToastLikeDialog;
        sendMessageDelayed(obtainMessage, j);
    }

    private long getDuration(H5ToastLikeDialog h5ToastLikeDialog) {
        return (long) h5ToastLikeDialog.getDuration();
    }

    public void handleMessage(Message message) {
        H5ToastLikeDialog h5ToastLikeDialog = (H5ToastLikeDialog) message.obj;
        int i2 = message.what;
        if (i2 == 4543316) {
            showNextSuperToast();
        } else if (i2 == 4608852) {
            displayToastLikeDialog(h5ToastLikeDialog);
        } else if (i2 != 4674388) {
            super.handleMessage(message);
        } else {
            removeToastLikeDialog(h5ToastLikeDialog);
        }
    }

    private void displayToastLikeDialog(H5ToastLikeDialog h5ToastLikeDialog) {
        if (!h5ToastLikeDialog.isShowing()) {
            try {
                h5ToastLikeDialog.show();
                sendMessageDelayed(h5ToastLikeDialog, 4674388, (long) h5ToastLikeDialog.getDuration());
            } catch (Throwable th) {
                H5Log.e(TAG, th.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeToastLikeDialog(H5ToastLikeDialog h5ToastLikeDialog) {
        h5ToastLikeDialog.dismiss();
    }

    /* access modifiers changed from: protected */
    public void confirmRemoveDialog(H5ToastLikeDialog h5ToastLikeDialog) {
        if (this.mQueue.peek() == h5ToastLikeDialog) {
            H5Log.d(TAG, "remove dialog");
            this.mQueue.poll();
            sendMessageDelayed(h5ToastLikeDialog, 4543316, 500);
        }
    }

    public static boolean hasManagerInstance() {
        return mManagerDialog != null;
    }

    public void cancelAllToastLikeDialogs() {
        removeMessages(4608852);
        removeMessages(4543316);
        removeMessages(4674388);
        for (H5ToastLikeDialog h5ToastLikeDialog : this.mQueue) {
            if (h5ToastLikeDialog.isShowing()) {
                h5ToastLikeDialog.dismiss();
            }
        }
        this.mQueue.clear();
    }
}

package com.alipay.mobile.nebulacore.dev.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.dev.bugme.H5BugmeApplogUploader;

public class H5BugMeExtFragment extends Fragment {
    private static final int UPLOADAPPLOG_COMPLETE = 10;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 10) {
                H5BugMeExtFragment.this.uploadApplog.setText("upload applog");
                H5BugMeExtFragment.this.uploadApplog.setEnabled(true);
            }
        }
    };
    /* access modifiers changed from: private */
    public Button uploadApplog;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.h5_bugme_ext, viewGroup, false);
        this.uploadApplog = (Button) inflate.findViewById(R.id.h5_bugme_ext_uploadapplog);
        this.uploadApplog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5BugMeExtFragment.this.uploadApplog.setText("uploading...");
                H5BugMeExtFragment.this.uploadApplog.setEnabled(false);
                H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
                    public void run() {
                        if (H5BugMeExtFragment.this.getActivity() != null) {
                            new H5BugmeApplogUploader(H5BugMeExtFragment.this.getActivity(), "Android-Nebula").uploadLog();
                            H5BugMeExtFragment.this.mHandler.sendEmptyMessage(10);
                            return;
                        }
                        H5Log.e("H5BugmeApplogUploader", "mContext == null");
                    }
                });
            }
        });
        return inflate;
    }
}

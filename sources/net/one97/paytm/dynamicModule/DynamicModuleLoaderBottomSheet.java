package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytm.utility.q;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.g.c;
import net.one97.paytm.i.f;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleLoaderBottomSheet extends f implements DynamicModuleManager.Listener {
    private static final String KEY_DEEPLINK = "deeplink";
    private static final String KEY_MODULE = "module";
    private static final String TAG = "PlayCore-DFMBottomSheet";
    private DynamicModuleLoaderAdapter mAdapter;
    private c mBinding;
    private Context mContext;
    private String mDeeplink;
    private DynamicModuleLoaderListener mListener;
    private String mModuleName;

    private void log(String str) {
    }

    public int getTheme() {
        return R.style.DdBottomSheetDialogTheme;
    }

    public void onPending(String str) {
    }

    public static DynamicModuleLoaderBottomSheet newInstance(String str) {
        return newInstance(str, "");
    }

    public static DynamicModuleLoaderBottomSheet newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MODULE, str);
        bundle.putString(KEY_DEEPLINK, str2);
        DynamicModuleLoaderBottomSheet dynamicModuleLoaderBottomSheet = new DynamicModuleLoaderBottomSheet();
        dynamicModuleLoaderBottomSheet.setArguments(bundle);
        return dynamicModuleLoaderBottomSheet;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getActivity();
        initUI();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mModuleName = getArguments().getString(KEY_MODULE);
            this.mDeeplink = getArguments().getString(KEY_DEEPLINK);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (c) androidx.databinding.f.a(layoutInflater, (int) R.layout.fragment_dynamic_module_loader_bottomsheet, viewGroup, false);
        return this.mBinding.getRoot();
    }

    private void initUI() {
        this.mAdapter = new DynamicModuleLoaderAdapter(this.mContext, getActivity(), DynamicModuleHelper.downloadSourceBottomSheet);
        this.mBinding.f50486d.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.mBinding.f50486d.setAdapter(this.mAdapter);
    }

    public void dismiss() {
        this.mListener = null;
        super.dismissAllowingStateLoss();
    }

    public void onStart() {
        super.onStart();
        DynamicModuleManager.getInstance().registerListener(this);
        if (DynamicModuleManager.getInstance().isInstalled(this.mModuleName)) {
            dismiss();
            return;
        }
        DynamicModuleManager.getInstance().startInstall(this.mModuleName, (Activity) getActivity());
        this.mAdapter.refreshCurrentQueue();
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter = this.mAdapter;
        if (dynamicModuleLoaderAdapter == null || dynamicModuleLoaderAdapter.getItemCount() <= 1) {
            this.mBinding.f50488f.setVisibility(8);
        } else {
            this.mBinding.f50488f.setVisibility(0);
        }
    }

    public void onStop() {
        super.onStop();
        DynamicModuleManager.getInstance().unRegisterListener(this);
    }

    public void onRequestSuccess(String str) {
        if (isAdded()) {
            log(str + ": onRequestSuccess: Download will start soon.");
            this.mAdapter.updateItemData(str, false, this.mContext.getString(R.string.msg_request_started_but_not_download), 0);
        }
    }

    public void onDownloading(String str, int i2) {
        if (isAdded()) {
            log(str + ": onDownloading: " + i2 + "%");
            this.mAdapter.updateItemData(str, false, this.mContext.getString(R.string.lbl_downloading), i2);
        }
    }

    public void onDownloaded(String str) {
        if (isAdded()) {
            log(str + ": onDownloaded");
            this.mAdapter.updateItemData(str, false, this.mContext.getString(R.string.lbl_installing), 100);
        }
    }

    public void onInstalled(String str) {
        if (isAdded()) {
            log(str + ": onInstalled");
            this.mAdapter.updateItemData(str, false, this.mContext.getString(R.string.lbl_installed), 100);
            if (this.mModuleName.equalsIgnoreCase(str)) {
                DynamicModuleLoaderListener dynamicModuleLoaderListener = this.mListener;
                if (dynamicModuleLoaderListener != null) {
                    dynamicModuleLoaderListener.onInstalled();
                } else if (!TextUtils.isEmpty(this.mDeeplink)) {
                    try {
                        a.a(this.mContext, this.mDeeplink);
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
                dismiss();
            }
        }
    }

    public void onCancelled(String str) {
        if (isAdded()) {
            log(str + ": onCancelled");
            this.mAdapter.updateItemData(str, true, this.mContext.getString(R.string.lbl_cancelled), 0);
        }
    }

    public void onRequestFailed(String str, DynamicModuleManager.REQUEST_FAILED request_failed, int i2, String str2) {
        if (isAdded()) {
            log(str + ": onRequestFailed: " + request_failed);
            this.mAdapter.updateItemData(str, true, DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, request_failed), 0);
            if (request_failed == DynamicModuleManager.REQUEST_FAILED.ACCESS_DENIED) {
                if (request_failed == DynamicModuleManager.REQUEST_FAILED.MODULE_UNAVAILABLE) {
                    showErrorUI(request_failed, i2, str2);
                } else if (request_failed != DynamicModuleManager.REQUEST_FAILED.NETWORK_ERROR && request_failed != DynamicModuleManager.REQUEST_FAILED.SERVICE_DIED) {
                    showErrorUI(request_failed, i2, str2);
                }
            }
        }
    }

    private void showErrorUI(DynamicModuleManager.REQUEST_FAILED request_failed, int i2, String str) {
        this.mBinding.f50483a.setVisibility(0);
        this.mBinding.f50487e.setVisibility(0);
        this.mBinding.f50489g.setVisibility(0);
        this.mBinding.f50484b.setVisibility(0);
        this.mBinding.f50486d.setVisibility(4);
        this.mBinding.f50488f.setVisibility(4);
        if (request_failed == DynamicModuleManager.REQUEST_FAILED.INSUFFICIENT_STORAGE) {
            this.mBinding.f50483a.setText(getString(R.string.error_lbl_storage));
            this.mBinding.f50483a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DynamicModuleLoaderBottomSheet.this.lambda$showErrorUI$0$DynamicModuleLoaderBottomSheet(view);
                }
            });
            this.mBinding.f50487e.setText(getString(R.string.dd_no_space_error_lbl));
            this.mBinding.f50489g.setText(getString(R.string.dd_no_space_error_desc));
        } else if (request_failed == DynamicModuleManager.REQUEST_FAILED.MODULE_UNAVAILABLE) {
            this.mBinding.f50483a.setText(getString(R.string.error_lbl_feedback));
            this.mBinding.f50483a.setOnClickListener(new View.OnClickListener(i2, str) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    DynamicModuleLoaderBottomSheet.this.lambda$showErrorUI$1$DynamicModuleLoaderBottomSheet(this.f$1, this.f$2, view);
                }
            });
            this.mBinding.f50487e.setText(getString(R.string.dd_other_error_lbl));
            this.mBinding.f50489g.setText(getString(R.string.dd_other_error_desc));
        } else if (request_failed == DynamicModuleManager.REQUEST_FAILED.OTHER) {
            this.mBinding.f50483a.setText(getString(R.string.error_lbl_playstore));
            this.mBinding.f50483a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DynamicModuleLoaderBottomSheet.this.lambda$showErrorUI$2$DynamicModuleLoaderBottomSheet(view);
                }
            });
            this.mBinding.f50487e.setText(getString(R.string.dd_beta_error_lbl));
            this.mBinding.f50489g.setText(getString(R.string.dd_beta_error_message));
        } else {
            this.mBinding.f50483a.setVisibility(8);
        }
        this.mBinding.f50484b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DynamicModuleLoaderBottomSheet.this.lambda$showErrorUI$3$DynamicModuleLoaderBottomSheet(view);
            }
        });
    }

    public /* synthetic */ void lambda$showErrorUI$0$DynamicModuleLoaderBottomSheet(View view) {
        DynamicModuleManager.getInstance().openStorageSettings(view.getContext());
        dismiss();
    }

    public /* synthetic */ void lambda$showErrorUI$1$DynamicModuleLoaderBottomSheet(int i2, String str, View view) {
        DynamicModuleManager.getInstance().sendFeedBack(view.getContext(), this.mModuleName, i2, str);
        dismiss();
    }

    public /* synthetic */ void lambda$showErrorUI$2$DynamicModuleLoaderBottomSheet(View view) {
        DynamicModuleManager.getInstance().openPaytmInPlaystore(view.getContext());
        dismiss();
    }

    public /* synthetic */ void lambda$showErrorUI$3$DynamicModuleLoaderBottomSheet(View view) {
        dismiss();
    }

    public void onRequestRetry(String str, DynamicModuleManager.REQUEST_FAILED request_failed) {
        if (isAdded()) {
            log(str + ": onRequestRetry: " + str);
            this.mAdapter.updateItemData(str, false, DynamicModuleUtils.getRequestFailedErrorMsg(this.mContext, request_failed), 0);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public void setListener(DynamicModuleLoaderListener dynamicModuleLoaderListener) {
        this.mListener = dynamicModuleLoaderListener;
    }
}

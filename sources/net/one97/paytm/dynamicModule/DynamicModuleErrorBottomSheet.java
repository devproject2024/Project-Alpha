package net.one97.paytm.dynamicModule;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public class DynamicModuleErrorBottomSheet extends f {
    private static String ERRORCODE = "errorcode";
    private static String ERRORTYPE = "errortype";
    private static String EXCEPTIONSTATE = "exception";
    private static String MODULENAME = "modulename";
    private TextView actionLabel;
    private ImageView close;
    private TextView errorHeader;
    private TextView errorInfo;

    public int getTheme() {
        return R.style.DdBottomSheetDialogTheme;
    }

    public static DynamicModuleErrorBottomSheet newInstance(String str, String str2, int i2, String str3) {
        DynamicModuleErrorBottomSheet dynamicModuleErrorBottomSheet = new DynamicModuleErrorBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putString(ERRORTYPE, str);
        bundle.putInt(ERRORCODE, i2);
        bundle.putString(MODULENAME, str2);
        bundle.putString(EXCEPTIONSTATE, str3);
        dynamicModuleErrorBottomSheet.setArguments(bundle);
        return dynamicModuleErrorBottomSheet;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dynamic_error_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.actionLabel = (TextView) view.findViewById(R.id.action_label);
        this.errorInfo = (TextView) view.findViewById(R.id.tv_info);
        this.errorHeader = (TextView) view.findViewById(R.id.tv_header);
        this.close = (ImageView) view.findViewById(R.id.close);
        if (getArguments() != null && getArguments().getString(ERRORTYPE) != null && getArguments().getString(ERRORTYPE).equalsIgnoreCase(DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.INSUFFICIENT_STORAGE.name())) {
            this.actionLabel.setText(getString(R.string.error_lbl_storage));
            this.actionLabel.setOnClickListener($$Lambda$DynamicModuleErrorBottomSheet$Yzuvsw5YiiO2PF3Lzw_swE77C0.INSTANCE);
            this.errorHeader.setText(getString(R.string.dd_no_space_error_lbl));
            this.errorInfo.setText(getString(R.string.dd_no_space_error_desc));
        } else if (getArguments() != null && getArguments().getString(ERRORTYPE) != null && getArguments().getString(ERRORTYPE).equalsIgnoreCase(DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.OTHER.name())) {
            this.actionLabel.setText(getString(R.string.error_lbl_feedback));
            this.actionLabel.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DynamicModuleErrorBottomSheet.this.lambda$onViewCreated$1$DynamicModuleErrorBottomSheet(view);
                }
            });
            this.errorHeader.setText(getString(R.string.dd_other_error_lbl));
            this.errorInfo.setText(getString(R.string.dd_other_error_desc));
        } else if (getArguments() == null || getArguments().getString(ERRORTYPE) == null || (!getArguments().getString(ERRORTYPE).equalsIgnoreCase(DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.MODULE_UNAVAILABLE.name()) && !getArguments().getString(ERRORTYPE).equalsIgnoreCase(DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.MODULE_UNAVAILABLE.name()))) {
            this.actionLabel.setVisibility(8);
        } else {
            this.actionLabel.setText(getString(R.string.error_lbl_playstore));
            this.actionLabel.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DynamicModuleErrorBottomSheet.this.lambda$onViewCreated$2$DynamicModuleErrorBottomSheet(view);
                }
            });
            this.errorHeader.setText(getString(R.string.dd_beta_error_lbl));
            this.errorInfo.setText(getString(R.string.dd_beta_error_message));
        }
        this.close.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DynamicModuleErrorBottomSheet.this.lambda$onViewCreated$3$DynamicModuleErrorBottomSheet(view);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$1$DynamicModuleErrorBottomSheet(View view) {
        DynamicModuleManager.getInstance().sendFeedBack(view.getContext(), getArguments().getString(MODULENAME), getArguments().getInt(ERRORCODE), getArguments().getString(EXCEPTIONSTATE));
        dismiss();
    }

    public /* synthetic */ void lambda$onViewCreated$2$DynamicModuleErrorBottomSheet(View view) {
        DynamicModuleManager.getInstance().openPaytmInPlaystore(view.getContext());
        dismiss();
    }

    public /* synthetic */ void lambda$onViewCreated$3$DynamicModuleErrorBottomSheet(View view) {
        dismiss();
    }

    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new a(requireContext(), getTheme());
    }
}

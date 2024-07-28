package com.alipay.mobile.nebula.provider;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import java.util.ArrayList;

public interface H5ActionSheetProvider {
    Dialog getAntUIActionSheet();

    void onRelease();

    void setContextAndContent(Context context, ArrayList<String> arrayList, String str, H5BridgeContext h5BridgeContext, View.OnClickListener onClickListener);
}

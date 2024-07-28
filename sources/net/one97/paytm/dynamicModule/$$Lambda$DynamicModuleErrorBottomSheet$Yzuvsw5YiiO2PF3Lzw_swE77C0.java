package net.one97.paytm.dynamicModule;

import android.view.View;

/* renamed from: net.one97.paytm.dynamicModule.-$$Lambda$DynamicModuleErrorBottomSheet$Yzuv-sw5YiiO2PF3Lzw_swE77C0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DynamicModuleErrorBottomSheet$Yzuvsw5YiiO2PF3Lzw_swE77C0 implements View.OnClickListener {
    public static final /* synthetic */ $$Lambda$DynamicModuleErrorBottomSheet$Yzuvsw5YiiO2PF3Lzw_swE77C0 INSTANCE = new $$Lambda$DynamicModuleErrorBottomSheet$Yzuvsw5YiiO2PF3Lzw_swE77C0();

    private /* synthetic */ $$Lambda$DynamicModuleErrorBottomSheet$Yzuvsw5YiiO2PF3Lzw_swE77C0() {
    }

    public final void onClick(View view) {
        DynamicModuleManager.getInstance().openStorageSettings(view.getContext());
    }
}

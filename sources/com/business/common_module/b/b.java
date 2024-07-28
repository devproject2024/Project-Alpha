package com.business.common_module.b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;

public interface b {
    ContextWrapper a(Context context);

    void a(Activity activity, String str, Bundle bundle);

    String b(Context context);
}

package androidx.browser.customtabs;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

public final class h {
    public static boolean a(Context context, File file, String str, String str2, f fVar) {
        Uri uriForFile = FileProvider.getUriForFile(context, str, file);
        context.grantUriPermission(str2, uriForFile, 1);
        return fVar.b(uriForFile);
    }
}

package net.one97.paytm.paymentsBank.utils.photocrop.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class InternalStorageContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f19581a = Uri.parse("content://com.albinmathew.samples.photocrop/");

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f19582b;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f19582b = hashMap;
        hashMap.put(".jpg", "image/jpeg");
        f19582b.put(".jpeg", "image/jpeg");
    }

    public boolean onCreate() {
        try {
            File file = new File(getContext().getFilesDir(), "temp_photo.jpg");
            if (file.exists()) {
                return true;
            }
            file.createNewFile();
            getContext().getContentResolver().notifyChange(f19581a, (ContentObserver) null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getType(Uri uri) {
        String uri2 = uri.toString();
        for (String next : f19582b.keySet()) {
            if (uri2.endsWith(next)) {
                return f19582b.get(next);
            }
        }
        return null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        File file = new File(getContext().getFilesDir(), "temp_photo.jpg");
        if (file.exists()) {
            return ParcelFileDescriptor.open(file, 805306368);
        }
        throw new FileNotFoundException(uri.getPath());
    }
}

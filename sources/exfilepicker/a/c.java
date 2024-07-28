package exfilepicker.a;

import java.io.File;
import java.io.IOException;

public class c {
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8, android.net.Uri r9) {
        /*
            boolean r0 = android.provider.DocumentsContract.isDocumentUri(r8, r9)
            r1 = 0
            if (r0 == 0) goto L_0x0152
            java.lang.String r0 = r9.getAuthority()
            java.lang.String r2 = "com.android.externalstorage.documents"
            boolean r0 = r2.equals(r0)
            java.lang.String r2 = ":"
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0044
            java.lang.String r8 = android.provider.DocumentsContract.getDocumentId(r9)
            java.lang.String[] r8 = r8.split(r2)
            r9 = r8[r3]
            java.lang.String r0 = "primary"
            boolean r9 = r0.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x0174
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r9.append(r0)
            java.lang.String r0 = "/"
            r9.append(r0)
            r8 = r8[r4]
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            return r8
        L_0x0044:
            java.lang.String r0 = r9.getAuthority()
            java.lang.String r5 = "com.android.providers.downloads.documents"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x010e
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r9)
            java.lang.Class<exfilepicker.a.c> r2 = exfilepicker.a.c.class
            r2.getSimpleName()
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "id="
            java.lang.String r2 = r5.concat(r2)
            com.paytm.utility.q.a(r2)
            java.lang.String r2 = "raw:"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x0074
            r8 = 4
            java.lang.String r8 = r0.substring(r8)
            return r8
        L_0x0074:
            java.lang.String r2 = "content://downloads/public_downloads"
            java.lang.String r5 = "content://downloads/my_downloads"
            java.lang.String[] r2 = new java.lang.String[]{r2, r5}
        L_0x007c:
            r5 = 2
            if (r3 >= r5) goto L_0x009b
            r5 = r2[r3]
            android.net.Uri r5 = android.net.Uri.parse(r5)
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            long r6 = r6.longValue()
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r5, r6)
            java.lang.String r5 = a(r8, r5, r1, r1)     // Catch:{ Exception -> 0x0098 }
            if (r5 == 0) goto L_0x0098
            return r5
        L_0x0098:
            int r3 = r3 + 1
            goto L_0x007c
        L_0x009b:
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.lang.String r0 = r0.getType(r9)
            if (r0 != 0) goto L_0x00ca
            if (r8 == 0) goto L_0x00ca
            java.lang.String r0 = a((android.content.Context) r8, (android.net.Uri) r9)
            if (r0 != 0) goto L_0x00c0
            java.lang.String r0 = r9.toString()
            if (r0 != 0) goto L_0x00b4
            goto L_0x00eb
        L_0x00b4:
            r2 = 47
            int r2 = r0.lastIndexOf(r2)
            int r2 = r2 + r4
            java.lang.String r0 = r0.substring(r2)
            goto L_0x00ec
        L_0x00c0:
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            java.lang.String r0 = r2.getName()
            goto L_0x00ec
        L_0x00ca:
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x00eb
            java.lang.String r2 = "_display_name"
            int r2 = r0.getColumnIndex(r2)
            r0.moveToFirst()
            java.lang.String r2 = r0.getString(r2)
            r0.close()
            r0 = r2
            goto L_0x00ec
        L_0x00eb:
            r0 = r1
        L_0x00ec:
            java.io.File r2 = new java.io.File
            java.io.File r3 = r8.getCacheDir()
            java.lang.String r4 = "documents"
            r2.<init>(r3, r4)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0100
            r2.mkdirs()
        L_0x0100:
            java.io.File r0 = a((java.lang.String) r0, (java.io.File) r2)
            if (r0 == 0) goto L_0x010d
            java.lang.String r1 = r0.getAbsolutePath()
            a(r8, r9, r1)
        L_0x010d:
            return r1
        L_0x010e:
            java.lang.String r0 = r9.getAuthority()
            java.lang.String r5 = "com.android.providers.media.documents"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0174
            java.lang.String r9 = android.provider.DocumentsContract.getDocumentId(r9)
            java.lang.String[] r9 = r9.split(r2)
            r0 = r9[r3]
            java.lang.String r2 = "image"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x012f
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x0145
        L_0x012f:
            java.lang.String r2 = "video"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x013b
            android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x0145
        L_0x013b:
            java.lang.String r2 = "audio"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0145
            android.net.Uri r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        L_0x0145:
            java.lang.String[] r0 = new java.lang.String[r4]
            r9 = r9[r4]
            r0[r3] = r9
            java.lang.String r9 = "_id=?"
            java.lang.String r8 = a(r8, r1, r9, r0)
            return r8
        L_0x0152:
            java.lang.String r0 = r9.getScheme()
            java.lang.String r2 = "content"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0163
            java.lang.String r8 = a(r8, r9, r1, r1)
            return r8
        L_0x0163:
            java.lang.String r8 = r9.getScheme()
            java.lang.String r0 = "file"
            boolean r8 = r0.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0174
            java.lang.String r8 = r9.getPath()
            return r8
        L_0x0174:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: exfilepicker.a.c.a(android.content.Context, android.net.Uri):java.lang.String");
    }

    private static File a(String str, File file) {
        String str2;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int lastIndexOf = str.lastIndexOf(46);
            int i2 = 0;
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                str2 = str.substring(lastIndexOf);
                str = substring;
            } else {
                str2 = "";
            }
            while (file2.exists()) {
                i2++;
                file2 = new File(file, str + '(' + i2 + ')' + str2);
            }
        }
        try {
            if (!file2.createNewFile()) {
                return null;
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC, Splitter:B:24:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003e A[Catch:{ IOException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0045 A[SYNTHETIC, Splitter:B:34:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004a A[Catch:{ IOException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ IOException -> 0x0042, all -> 0x0035 }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ IOException -> 0x0042, all -> 0x0035 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0043, all -> 0x0033 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0043, all -> 0x0033 }
            r2 = 0
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x0043, all -> 0x0033 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0043, all -> 0x0033 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            r3.read(r5)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
        L_0x001b:
            r4.write(r5)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            int r0 = r3.read(r5)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            r1 = -1
            if (r0 != r1) goto L_0x001b
            if (r3 == 0) goto L_0x002a
            r3.close()     // Catch:{ IOException -> 0x002d }
        L_0x002a:
            r4.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            return
        L_0x002e:
            r5 = move-exception
            r0 = r4
            goto L_0x0037
        L_0x0031:
            r0 = r4
            goto L_0x0043
        L_0x0033:
            r5 = move-exception
            goto L_0x0037
        L_0x0035:
            r5 = move-exception
            r3 = r0
        L_0x0037:
            if (r3 == 0) goto L_0x003c
            r3.close()     // Catch:{ IOException -> 0x0041 }
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            throw r5
        L_0x0042:
            r3 = r0
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x004e }
        L_0x0048:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: exfilepicker.a.c.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0031 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x002b
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x002b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x0033
        L_0x002b:
            if (r8 == 0) goto L_0x0030
            r8.close()
        L_0x0030:
            return r7
        L_0x0031:
            r9 = move-exception
            r8 = r7
        L_0x0033:
            if (r8 == 0) goto L_0x0038
            r8.close()
        L_0x0038:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: exfilepicker.a.c.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }
}

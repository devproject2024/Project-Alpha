package net.one97.paytm.fastag.f;

public final class i {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r11, android.net.Uri r12) throws java.net.URISyntaxException {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 19
            if (r0 < r3) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            r3 = 0
            if (r0 == 0) goto L_0x00af
            android.content.Context r0 = r11.getApplicationContext()
            boolean r0 = android.provider.DocumentsContract.isDocumentUri(r0, r12)
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r12.getAuthority()
            java.lang.String r4 = "com.android.externalstorage.documents"
            boolean r0 = r4.equals(r0)
            java.lang.String r4 = ":"
            if (r0 == 0) goto L_0x0049
            java.lang.String r11 = android.provider.DocumentsContract.getDocumentId(r12)
            java.lang.String[] r11 = r11.split(r4)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r12.append(r0)
            java.lang.String r0 = "/"
            r12.append(r0)
            r11 = r11[r2]
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            return r11
        L_0x0049:
            java.lang.String r0 = r12.getAuthority()
            java.lang.String r5 = "com.android.providers.downloads.documents"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x006c
            java.lang.String r12 = android.provider.DocumentsContract.getDocumentId(r12)
            java.lang.String r0 = "content://downloads/public_downloads"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            long r1 = r12.longValue()
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r0, r1)
            goto L_0x00af
        L_0x006c:
            java.lang.String r0 = r12.getAuthority()
            java.lang.String r5 = "com.android.providers.media.documents"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r12)
            java.lang.String[] r0 = r0.split(r4)
            r4 = r0[r1]
            java.lang.String r5 = "image"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x008d
            android.net.Uri r12 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a3
        L_0x008d:
            java.lang.String r5 = "video"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0099
            android.net.Uri r12 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x00a3
        L_0x0099:
            java.lang.String r5 = "audio"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a3
            android.net.Uri r12 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        L_0x00a3:
            java.lang.String[] r4 = new java.lang.String[r2]
            r0 = r0[r2]
            r4[r1] = r0
            java.lang.String r0 = "_id=?"
            r6 = r12
            r8 = r0
            r9 = r4
            goto L_0x00b2
        L_0x00af:
            r6 = r12
            r8 = r3
            r9 = r8
        L_0x00b2:
            java.lang.String r12 = r6.getScheme()
            java.lang.String r0 = "content"
            boolean r12 = r0.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x00dc
            java.lang.String r12 = "_data"
            java.lang.String[] r7 = new java.lang.String[]{r12}
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x00ed }
            r10 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ed }
            int r12 = r11.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x00ed }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x00ed
            java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception -> 0x00ed }
            return r11
        L_0x00dc:
            java.lang.String r11 = r6.getScheme()
            java.lang.String r12 = "file"
            boolean r11 = r12.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x00ed
            java.lang.String r11 = r6.getPath()
            return r11
        L_0x00ed:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.f.i.a(android.content.Context, android.net.Uri):java.lang.String");
    }
}

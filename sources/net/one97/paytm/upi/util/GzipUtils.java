package net.one97.paytm.upi.util;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.PaytmLogs;

public class GzipUtils {
    public static Reader convertReader(byte[] bArr) {
        try {
            return new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String convertString(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
            while (true) {
                int read = reader.read(cArr, 0, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            reader.close();
        } catch (Exception e2) {
            PaytmLogs.e("VolleyUtils", e2.getMessage());
        }
        return sb.toString();
    }
}

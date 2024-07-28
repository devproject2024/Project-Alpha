package net.one97.paytm.nativesdk.Utils;

import com.business.merchant_payments.utility.StringUtility;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

public class GzipUtils {
    public static Reader convertReader(byte[] bArr) {
        try {
            return new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr)));
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    public static String convertString(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(StringUtility.NEW_LINE);
            }
            reader.close();
            bufferedReader.close();
        } catch (IOException e2) {
            e2.getMessage();
        }
        return sb.toString();
    }
}

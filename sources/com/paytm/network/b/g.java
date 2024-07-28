package com.paytm.network.b;

import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.q;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

public final class g {
    public static Reader a(byte[] bArr) {
        try {
            return new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr)));
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return null;
        }
    }

    public static String a(Reader reader) {
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
            q.b(e2.getMessage());
        }
        return sb.toString();
    }
}

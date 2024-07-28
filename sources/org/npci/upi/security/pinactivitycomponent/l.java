package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class l {
    private static ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream;
            }
        }
    }

    public static byte[] a(String str, Context context) {
        try {
            return a(new ByteArrayOutputStream(), context.getAssets().open("npci/".concat(String.valueOf(str)))).toByteArray();
        } catch (FileNotFoundException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}

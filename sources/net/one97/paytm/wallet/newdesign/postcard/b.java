package net.one97.paytm.wallet.newdesign.postcard;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.InputStream;
import java.io.OutputStream;

public final class b {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[TarConstants.EOF_BLOCK];
            while (true) {
                int read = inputStream.read(bArr, 0, TarConstants.EOF_BLOCK);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }
}

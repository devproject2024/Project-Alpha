package net.one97.paytm.appManager.d;

import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import net.one97.paytm.appManager.beans.Data;

public final class d {
    public static Data a(InputStream inputStream) {
        try {
            Data data = (Data) new f().a((Reader) new BufferedReader(new InputStreamReader(inputStream)), Data.class);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    q.b(e2.getMessage());
                }
            }
            return data;
        } catch (Exception e3) {
            q.b(e3.getMessage());
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (IOException e4) {
                q.b(e4.getMessage());
                return null;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    q.b(e5.getMessage());
                }
            }
            throw th;
        }
    }
}

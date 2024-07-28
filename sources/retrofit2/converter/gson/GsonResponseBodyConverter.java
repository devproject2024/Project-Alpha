package retrofit2.converter.gson;

import com.google.gson.f;
import com.google.gson.m;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final w<T> adapter;
    private final f gson;

    GsonResponseBodyConverter(f fVar, w<T> wVar) {
        this.gson = fVar;
        this.adapter = wVar;
    }

    public final T convert(ResponseBody responseBody) throws IOException {
        JsonReader a2 = this.gson.a(responseBody.charStream());
        try {
            T read = this.adapter.read(a2);
            if (a2.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new m("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}

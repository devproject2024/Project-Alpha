package retrofit2.converter.gson;

import com.google.gson.b.a;
import com.google.gson.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class GsonConverterFactory extends Converter.Factory {
    private final f gson;

    public static GsonConverterFactory create() {
        return create(new f());
    }

    public static GsonConverterFactory create(f fVar) {
        if (fVar != null) {
            return new GsonConverterFactory(fVar);
        }
        throw new NullPointerException("gson == null");
    }

    private GsonConverterFactory(f fVar) {
        this.gson = fVar;
    }

    public final Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.a(a.get(type)));
    }

    public final Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.a(a.get(type)));
    }
}

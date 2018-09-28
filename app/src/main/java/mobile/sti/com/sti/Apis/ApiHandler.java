package mobile.sti.com.sti.Apis;

import io.reactivex.Observable;
import mobile.sti.com.sti.model.Berita.Berita;
import retrofit2.http.GET;

public interface ApiHandler {

    @GET("get_berita")
    Observable<Berita> getBerita();
}

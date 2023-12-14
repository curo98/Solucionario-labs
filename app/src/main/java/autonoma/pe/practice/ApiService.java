package autonoma.pe.practice;

import java.util.ArrayList;

import autonoma.pe.practice.crud.model.Person;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("people")
    Call<ArrayList<Person>> getPeople();

    @POST("person/{id}/destroy")
    @Headers("Accept: application/json")
    Call<Void> destroyPerson(@Path("id") int id);

    @POST("person/{id}/update")
    @Headers("Accept: application/json")
    Call<Void> updatePerson(@Path("id") int id,
                          @Query("first_name") String first_name,
                          @Query("last_name") String last_name);

    @GET("person/{id}/edit")
    @Headers("Accept: application/json")
    Call<Person> editPerson(@Path("id") int id);

    @GET("person/{id}/show")
    @Headers("Accept: application/json")
    Call<Person> getPersonDetails(@Path("id") int id);
    @POST("person/store")
    @FormUrlEncoded
    @Headers("Accept: application/json")
    Call<Void> postPerson(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name
    );

    class Factory {
        private static final String BASE_URL = "https://gespro-iberoplast.tech/api/";

        public static ApiService create() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(ApiService.class);
        }
    }
}

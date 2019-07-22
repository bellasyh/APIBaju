package pnj.ac.bajuapi;

import pnj.ac.bajuapi.Model.DataResponse;
import pnj.ac.bajuapi.Model.ErrorMessage;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("baju")
    Call<DataResponse> getData();

    @FormUrlEncoded

    @POST("baju")

    Call<ErrorMessage> tambahBaju(@Field("nama") String nama,

                                   @Field("merek") String merek,

                                   @Field("jenis_baju") String jenis_baju,

                                   @Field("harga") Integer harga,

                                   @Field("jumlah_beli") Integer jumlah_beli

    );

    @FormUrlEncoded

    @PUT("baju/{id}")

    Call<ErrorMessage> ubahBaju(@Path("id") Integer id,
                                 @Field("nama") String nama,

                                 @Field("merek") String merek,

                                 @Field("jenis_baju") String jenis_baju,

                                 @Field("harga") Integer harga,

                                 @Field("jumlah_beli") Integer jumlah_beli

    );



    @DELETE("baju/{id}")

    Call<ErrorMessage> hapusBaju(@Path("id") Integer id);
}

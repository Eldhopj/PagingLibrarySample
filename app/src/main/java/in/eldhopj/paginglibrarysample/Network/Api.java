package in.eldhopj.paginglibrarysample.Network;

import in.eldhopj.paginglibrarysample.ModelClasses.StackOverflow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("answers")
    Call<StackOverflow> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int size,
            @Query("site") String site
    );
}

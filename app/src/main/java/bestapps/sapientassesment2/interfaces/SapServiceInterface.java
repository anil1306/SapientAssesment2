package bestapps.sapientassesment2.interfaces;



/**
 * Created by Anil on 4/3/2018.
 */

import bestapps.sapientassesment2.model.SapModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * SapServiceInterface defines HTTP operations
 */
public interface SapServiceInterface {
    /**
     * @return :Api Endpoints providing callback to enqueue
     * The return value wraps the response in a Call object with the type of the expected(SapModel) result.
     */
    @SuppressWarnings("JavaDoc")
    @GET("facts.json")
    Call<SapModel> getServerData();
}

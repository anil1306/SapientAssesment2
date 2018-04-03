package bestapps.sapientassesment2;

import org.junit.Test;

import java.io.IOException;


import bestapps.sapientassesment2.interfaces.SapServiceInterface;
import bestapps.sapientassesment2.model.SapModel;
import bestapps.sapientassesment2.remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ResponseTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /**
     * Test to validate response
     */
    @Test
    public void apiResponse_Success() {
        SapServiceInterface apiEndpoints = RetrofitClient.getClient().create(SapServiceInterface.class);
        Call<SapModel> call = apiEndpoints.getServerData();
        try {
            Response<SapModel> response = call.execute();
            SapModel authResponse = response.body();
            assertTrue(response.isSuccessful() && authResponse.getTitle().startsWith("About Canada"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
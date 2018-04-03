package bestapps.sapientassesment2.remote;

import bestapps.sapientassesment2.interfaces.SapServiceInterface;

/**
 * Created by Anil on 4/3/2018.
 */
@SuppressWarnings("DefaultFileTemplate")
public class ApiUtils {
    public static final String Main_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    /**
     * @return : provide an interface to our application through the getSapService()
     */
    public static SapServiceInterface getSapService() {
        return RetrofitClient.getClient().create(SapServiceInterface.class);
    }

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author arjun
 */
public class Test {

    /**
     * User ID associated with a user, find this in the Accounts page
     */
    private static final String MY_USER_ID = "steve";
    /**
     * User Secret key, find this in the Accounts page
     */
    private static final String MY_SECRET_KEY =
            "KJG6987AASDFSDF/234ASDF=";
    /**
     * Name of the Group owned by the User
     */
    private static final String MY_GROUP_NAME = "apple";
    /**
     * Secret Key associated with the Group owned by User
     */
    private static final String MY_GROUP_SECRET_KEY = "HUJMK876FTYHN009=";

    /**
     * Secret Key associated with the Group owned by User
     */
    private static final String MY_MESSAGE = "This is insanely Great!";
    /**
     * Password of the Group to be created
     * It is advised not to store password in the code. Use Txtweb's mobile service to create a group instead.
     */
    private static final String GROUP_PASSWORD = "jobs!";
    
    /**
     * Password of the User for Login
     * It is advised not to store password in the code.
     */
    private static final String USER_PASSWORD = "jobs!";
    
    /**
     * Description of the group to be created
     */
    private static final String MY_GROUP_DESCRIPTION = "All Apple News update";

    public static void main(String[] args) throws JSONException {
        JSONObject responseJSONObject = TxtwebGroupRESTAPI
                .loginUser(MY_USER_ID, USER_PASSWORD);
        System.out.println(responseJSONObject.toString());
    }
}

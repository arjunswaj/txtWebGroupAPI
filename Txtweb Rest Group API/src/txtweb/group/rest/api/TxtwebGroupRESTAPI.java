/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author arjun
 */
public class TxtwebGroupRESTAPI {

    /**
     * Get List of all the Public Groups
     * @return JSONObject of list of Groups
     * @throws JSONException 
     */
    public static JSONObject listPublicGroups() throws JSONException {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.LIST)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }

    /**
     * Get list of all the groups owned by Me
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException 
     */
    public static JSONObject getMyGroups(String myUserID, String mySecretKey) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.MY_GROUPS)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }

    /**
     * List the Members of the groups
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupSecretKey Secret Key associated with Group owned by the user
     * @return JSONObject of list of Members of the Group
     * @throws JSONException 
     */
    public static JSONObject listMembersOfMyGroup(String myUserID, String mySecretKey,
            String myGroupName, String myGroupSecretKey) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, myGroupName);
        jsonInput.put(TxtwebConstants.GROUP_SECRET, myGroupSecretKey);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.MEMBERS)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }
    /**
     * Broadcast message to the Members of the group
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupSecretKey Secret Key associated with Group owned by the user
     * @param myMessage Message that has to be broadcast to the Group
     * @return JSONObject of list of Members and their Broadcast Status
     * @throws JSONException 
     */
    public static JSONObject broadcastMessageToMembersOfMyGroup(String myUserID, String mySecretKey,
            String myGroupName, String myGroupSecretKey, String myMessage) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, myGroupName);
        jsonInput.put(TxtwebConstants.GROUP_SECRET, myGroupSecretKey);
        jsonInput.put(TxtwebConstants.MESSAGE, myMessage);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.BROADCAST)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }
    /**
     * Create a Chat Group
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupPassword Password for the Group to be created
     * @param myGroupDescription Description of the group
     * @return JSONObject of the creation status
     * @throws JSONException 
     */
    public static JSONObject createAChatGroup(String myUserID, String mySecretKey,
            String myGroupName, String myGroupPassword, String myGroupDescription) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, myGroupName);
        jsonInput.put(TxtwebConstants.GROUP_PASSWORD, myGroupPassword);
        jsonInput.put(TxtwebConstants.GROUP_TYPE, TxtwebConstants.CHAT_TYPE);
        jsonInput.put(TxtwebConstants.GROUP_DESCRIPTION, myGroupDescription);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.CREATE)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }

    /**
     * Create a Broadcast Group
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupPassword Password for the Group to be created
     * @param myGroupDescription Description of the group
     * @return JSONObject of the creation status
     * @throws JSONException 
     */
    public static JSONObject createABroadcastGroup(String myUserID, String mySecretKey,
            String myGroupName, String myGroupPassword, String myGroupDescription) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, myGroupName);
        jsonInput.put(TxtwebConstants.GROUP_PASSWORD, myGroupPassword);
        jsonInput.put(TxtwebConstants.GROUP_TYPE, TxtwebConstants.BROADCAST_TYPE);
        jsonInput.put(TxtwebConstants.GROUP_DESCRIPTION, myGroupDescription);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP)
                .path(TxtwebConstants.CREATE)
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }
    /**
     * Base URI for the Rest APIs
     * @return Base URI
     */
    private static URI getBaseURI() {
        return UriBuilder.fromUri(TxtwebConstants.BASE_URL).build();
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility Class for accessing REST APIs using Jersey Client
 *
 * @author arjun
 */
public class TxtwebGroupRESTAPI {

    /**
     * Get List of all the Public Groups
     *
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject listPublicGroups() throws JSONException {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.LIST).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

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
     *
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
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.MY_GROUPS).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

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
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupSecretKey Secret Key associated with Group owned by the
     * user
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
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.MEMBERS).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

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
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupSecretKey Secret Key associated with Group owned by the
     * user
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
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.BROADCAST).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

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
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with user
     * @param myGroupName Group Name of Group owned by user
     * @param myGroupSecretKey Secret Key associated with Group owned by the
     * user
     * @param myMessage Message that has to be broadcast to the Group
     * @param recipientIds Recipients of the message
     * @return JSONObject of list of Members and their Broadcast Status
     * @throws JSONException
     */
    public static JSONObject multicastMessageToSelectedMembersOfMyGroup(String myUserID, String mySecretKey,
            String myGroupName, String myGroupSecretKey, String myMessage, String[] recipientIds) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        JSONArray recipients = new JSONArray();
        for (String recipientId : recipientIds) {
            recipients.put(recipientId);
        }

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, myGroupName);
        jsonInput.put(TxtwebConstants.GROUP_SECRET, myGroupSecretKey);
        jsonInput.put(TxtwebConstants.MESSAGE, myMessage);
        jsonInput.put(TxtwebConstants.RECIPIENT_IDS, recipients);
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.MULTICAST).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

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
     *
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
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.CREATE).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

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
     *
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
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.CREATE).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }

    /**
     * Login the User
     *
     * @param myUserID User ID associated with user
     * @param myPassword User Password associated with User
     * @return JSONObject of User Secret & List of all Groups & Group Secrets
     * @throws JSONException
     */
    public static JSONObject loginUser(String myUserID, String myPassword) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_PASSWORD, myPassword);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.LOGIN).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;
    }

    /**
     * Get list of all the groups by Pagination
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @param isAscending Is the Results sorted in Ascending Order
     * @param offset The offset to be used
     * @param limit The no. of results to be shown
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject getAllPublicGroupsByPagination(String myUserID, String mySecretKey,
            Boolean isAscending, Integer offset, Integer limit) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        JSONObject searchOpt = new JSONObject();
        if (isAscending) {
            searchOpt.put(TxtwebConstants.SORT_ON_NAME, TxtwebConstants.ASCENDING);
        } else {
            searchOpt.put(TxtwebConstants.SORT_ON_NAME, TxtwebConstants.DESCENDING);
        }

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.SEARCH_OPTIONS, searchOpt);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.PAGINATED_LIST_PATH).path(TxtwebConstants.OFFSET).path(offset.toString()).path(TxtwebConstants.LIMIT).path(limit.toString()).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;

    }

    /**
     * Get list of all the groups I Follow
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject groupsIFollow(String myUserID, String mySecretKey) throws JSONException {

        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.FOLLOWED).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;

    }

    /**
     * Get Details of the Group
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject getGroupDetails(String myUserID, String mySecretKey, String groupName) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, groupName);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.GROUP_DETAILS).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;


    }

    /**
     * Follow a Group
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @param groupName Name of the Group
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject followGroup(String myUserID, String mySecretKey, String groupName) throws JSONException {

        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, groupName);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.FOLLOW).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;

    }

    /**
     * Unfollow a Group
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @param groupName Name of the Group
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject unfollowGroup(String myUserID, String mySecretKey, String groupName) throws JSONException {

        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, groupName);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.UNFOLLOW).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;

    }

    /**
     * Edit a Group
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @param groupName Name of the Group
     * @param groupData Group Data to be edited in JSON Format
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject editGroup(String myUserID, String mySecretKey, String groupName, JSONObject groupData) throws JSONException {
        JSONObject jsonInput = new JSONObject();

        jsonInput.put(TxtwebConstants.USER_ID, myUserID);
        jsonInput.put(TxtwebConstants.USER_SECRET, mySecretKey);
        jsonInput.put(TxtwebConstants.GROUP_NAME, groupName);
        jsonInput.put(TxtwebConstants.GROUP_DATA, groupData);

        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI());
        ClientResponse response = webResource.path(TxtwebConstants.GROUP).path(TxtwebConstants.EDIT).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonInput.toString());

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JSONObject responseJSONObject = new JSONObject(output);

        return responseJSONObject;

    }

    /**
     * Utility method to generate JSONObject for editing Group
     *
     * @param description Description Of the Group
     * @param isPrivate Privacy Settings
     * @return
     */
    public static JSONObject editDescriptionAndChangePrivacy(String description, Boolean isPrivate) {
        try {
            JSONObject groupData = new JSONObject();
            if (null != description) {
                groupData.put(TxtwebConstants.GROUP_DESCRIPTION_FOR_EDIT, description);
            }
            if (null != isPrivate) {
                groupData.put(TxtwebConstants.GROUP_IS_PRIVATE, isPrivate);
            }
            return groupData;
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Base URI for the Rest APIs
     *
     * @return Base URI
     */
    private static URI getBaseURI() {
        return UriBuilder.fromUri(TxtwebConstants.BASE_URL).build();
    }
}

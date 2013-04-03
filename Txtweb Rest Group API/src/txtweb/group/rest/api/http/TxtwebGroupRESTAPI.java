/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Utility Class for accessing REST APIs using Apache HTTP Client
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
    public static JSONObject listPublicGroups() {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP + TxtwebApacheConstants.LIST;
            HttpGet getRequest = new HttpGet(url);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }
    
    /**
     * Get List of all the Public Groups
     *
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject listFeaturedGroups() {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP + TxtwebApacheConstants.FEATURED_LIST;
            HttpGet getRequest = new HttpGet(url);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Login the User
     *
     * @param myUserID User ID associated with user
     * @param myPassword User Password associated with User
     * @return JSONObject of User Secret & List of all Groups & Group Secrets
     * @throws JSONException
     */
    public static JSONObject loginUser(String myUserID, String myPassword) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_PASSWORD, myPassword);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP + TxtwebApacheConstants.LOGIN;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Get list of all the groups owned by Me
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject getMyGroups(String myUserID, String mySecretKey) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.MY_GROUPS;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject broadcastMessageToMembersOfMyGroup(
            String myUserID, String mySecretKey, String myGroupName,
            String myGroupSecretKey, String myMessage) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, myGroupName);
            jsonInput.put(TxtwebApacheConstants.GROUP_SECRET, myGroupSecretKey);
            jsonInput.put(TxtwebApacheConstants.MESSAGE, myMessage);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.BROADCAST;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Multicast message to the Members of the group
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
    public static JSONObject multicastMessageToSelectedMembersOfMyGroup(
            String myUserID, String mySecretKey, String myGroupName,
            String myGroupSecretKey, String myMessage, String[] recipientIds) {
        try {
            JSONObject jsonInput = new JSONObject();
            JSONArray recipients = new JSONArray();
            for (String recipientId : recipientIds) {
                recipients.put(recipientId);
            }
            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, myGroupName);
            jsonInput.put(TxtwebApacheConstants.GROUP_SECRET, myGroupSecretKey);
            jsonInput.put(TxtwebApacheConstants.MESSAGE, myMessage);
            jsonInput.put(TxtwebApacheConstants.RECIPIENT_IDS, recipients);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.MULTICAST;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject createAChatGroup(String myUserID,
            String mySecretKey, String myGroupName, String myGroupPassword,
            String myGroupDescription) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, myGroupName);
            jsonInput.put(TxtwebApacheConstants.GROUP_PASSWORD, myGroupPassword);
            jsonInput.put(TxtwebApacheConstants.GROUP_TYPE,
                    TxtwebApacheConstants.CHAT_TYPE);
            jsonInput.put(TxtwebApacheConstants.GROUP_DESCRIPTION,
                    myGroupDescription);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.CREATE;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject createABroadcastGroup(String myUserID,
            String mySecretKey, String myGroupName, String myGroupPassword,
            String myGroupDescription) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, myGroupName);
            jsonInput.put(TxtwebApacheConstants.GROUP_PASSWORD, myGroupPassword);
            jsonInput.put(TxtwebApacheConstants.GROUP_TYPE,
                    TxtwebApacheConstants.BROADCAST_TYPE);
            jsonInput.put(TxtwebApacheConstants.GROUP_DESCRIPTION,
                    myGroupDescription);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.CREATE;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
            Boolean isAscending, Integer offset, Integer limit) {
        try {
            JSONObject jsonInput = new JSONObject();

            JSONObject searchOpt = new JSONObject();
            if (isAscending) {
                searchOpt.put(TxtwebApacheConstants.SORT_ON_NAME, TxtwebApacheConstants.ASCENDING);
            } else {
                searchOpt.put(TxtwebApacheConstants.SORT_ON_NAME, TxtwebApacheConstants.DESCENDING);
            }

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.SEARCH_OPTIONS, searchOpt);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.PAGINATED_LIST_PATH
                    + TxtwebApacheConstants.OFFSET
                    + TxtwebApacheConstants.SEPARATOR
                    + offset
                    + TxtwebApacheConstants.LIMIT
                    + TxtwebApacheConstants.SEPARATOR
                    + limit;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Get list of all the groups I Follow
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject groupsIFollow(String myUserID, String mySecretKey) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.FOLLOWED;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Get Details of the Group
     *
     * @param myUserID User ID associated with user
     * @param mySecretKey Secret Key associated with User
     * @return JSONObject of list of Groups
     * @throws JSONException
     */
    public static JSONObject getGroupDetails(String myUserID, String mySecretKey, String groupName) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, groupName);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.GROUP_DETAILS;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject followGroup(String myUserID, String mySecretKey, String groupName) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, groupName);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.FOLLOW;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject unfollowGroup(String myUserID, String mySecretKey, String groupName) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, groupName);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.UNFOLLOW;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
    public static JSONObject editGroup(String myUserID, String mySecretKey, String groupName, JSONObject groupData) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, myUserID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, mySecretKey);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, groupName);
            jsonInput.put(TxtwebApacheConstants.GROUP_DATA, groupData);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.EDIT;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
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
                groupData.put(TxtwebApacheConstants.GROUP_DESCRIPTION_FOR_EDIT, description);
            }
            if (null != isPrivate) {
                groupData.put(TxtwebApacheConstants.GROUP_IS_PRIVATE, isPrivate);
            }
            return groupData;
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * List all the members of My Groups
     * @param userID User ID associated with user
     * @param userSecret Secret Key associated with User
     * @param groupName Name of the Group
     * @param groupSecret Secret Key Associated with Group
     * @return 
     */
    public static JSONObject listMembersOfMyGroup(String userID,
            String userSecret, String groupName, String groupSecret) {
        try {
            JSONObject jsonInput = new JSONObject();

            jsonInput.put(TxtwebApacheConstants.USER_ID, userID);
            jsonInput.put(TxtwebApacheConstants.USER_SECRET, userSecret);
            jsonInput.put(TxtwebApacheConstants.GROUP_SECRET, groupSecret);
            jsonInput.put(TxtwebApacheConstants.GROUP_NAME, groupName);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = TxtwebApacheConstants.BASE_URL
                    + TxtwebApacheConstants.GROUP
                    + TxtwebApacheConstants.MEMBERS;
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonInput.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            httpClient.getConnectionManager().shutdown();
            JSONObject responseJSONObject = new JSONObject(output.toString());

            return responseJSONObject;
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}

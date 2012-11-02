/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api.http;

/**
 *
 * @author arjun
 */
public class TxtwebApacheConstants {

    /**
     * Domain of the Web Service
     */
    public static final String DOMAIN = "http://cal-reminder.appspot.com";
    /**
     * Base Path
     */
    public static final String BASE = "/api/rest/v1";
    /**
     * Base URL of the Web Service
     */
    public static final String BASE_URL = DOMAIN + BASE;
    /**
     * Path for Web Services related to Groups
     */
    public static final String GROUP = "/group";
    /**
     * List all Groups
     */
    public static final String LIST = "/list";
    /**
     * List all Groups Owned By Me
     */
    public static final String MY_GROUPS = "/mygroups";
    /**
     * List all members of the Group Owned By Me
     */
    public static final String MEMBERS = "/members";
    /**
     * Broadcast to members of group
     */
    public static final String BROADCAST = "/broadcast";
    /**
     * Multicast to Selected members of group
     */
    public static final String MULTICAST = "/multicast";
    /**
     * Create a Chat group or a Broadcast Group
     */
    public static final String CREATE = "/create";
    /**
     * Login Path
     */
    public static final String LOGIN = "/login";
    /**
     * Paginated List Path
     */
    public static final String PAGINATED_LIST_PATH = "/paginatedlist";
    /**
     * Offset
     */
    public static final String OFFSET = "/offset";
    /**
     * Limit
     */
    public static final String LIMIT = "/limit";
    /**
     * Separator
     */
    public static final String SEPARATOR = "/";
    /**
     * Groups I Follow
     */
    public static final String FOLLOWED = "/followed";
    /**
     * Groups Details
     */
    public static final String GROUP_DETAILS = "/groupdetails";
    /**
     * Follow Group
     */
    public static final String FOLLOW = "/follow";
    /**
     * Unfollow Group
     */
    public static final String UNFOLLOW = "/unfollow";
    /**
     * Edit Group
     */
    public static final String EDIT = "/edit";
    /**
     * User Id
     */
    public static final String USER_ID = "USER_ID";
    /**
     * Secret Key
     */
    public static final String USER_SECRET = "USER_SECRET";
    /**
     * Group Name
     */
    public static final String GROUP_NAME = "GROUP_NAME";
    /**
     * Group Secret
     */
    public static final String GROUP_SECRET = "GROUP_SECRET";
    /**
     * Message
     */
    public static final String MESSAGE = "MESSAGE";
    /**
     * Group Password
     */
    public static final String GROUP_PASSWORD = "GROUP_PASSWORD";
    /**
     * Type of the Group that is created
     */
    public static final String GROUP_TYPE = "GROUP_TYPE";
    /**
     * Description of the Group
     */
    public static final String GROUP_DESCRIPTION = "GROUP_DESC";
    /**
     * Description of the Group
     */
    public static final String GROUP_DESCRIPTION_FOR_EDIT = "GROUP_DESCRIPTION";
    /**
     * Chat Group
     */
    public static final String CHAT_TYPE = "CHAT";
    /**
     * Broadcast Group
     */
    public static final String BROADCAST_TYPE = "BROADCAST";
    /**
     * User Password
     */
    public static final String USER_PASSWORD = "USER_PASSWORD";
    /**
     * User Data
     */
    public static final String USER_DATA = "USER_DATA";
    /**
     * Group Data
     */
    public static final String GROUP_DATA = "GROUP_DATA";
    /**
     * Response Code
     */
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    /**
     * Group Created
     */
    public static final String TICKR_200 = "TICKR-200";
    /**
     * Response Message
     */
    public static final String RESPONSE_MESSAGE = "RESPONSE_MESSAGE";
    /**
     * Recipient IDs
     */
    public static final String RECIPIENT_IDS = "RECIPIENT_IDS";
    /**
     * Search Options
     */
    public static final String SEARCH_OPTIONS = "SEARCH_OPTIONS";
    /**
     * Sort On Name
     */
    public static final String SORT_ON_NAME = "SORT_ON_NAME";
    /**
     * Ascending Order
     */
    public static final String ASCENDING = "ASCENDING";
    /**
     * Descending Order
     */
    public static final String DESCENDING = "DESCENDING";
    /**
     * Group Is Private
     */
    public static final String GROUP_IS_PRIVATE = "GROUP_IS_PRIVATE";
}

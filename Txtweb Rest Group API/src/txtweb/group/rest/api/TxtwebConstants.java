/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txtweb.group.rest.api;

/**
 *
 * @author arjun
 */
public class TxtwebConstants {
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
    public static final String GROUP = "group";
    /**
     * List all Groups
     */
    public static final String LIST = "list";
    /**
     * List all Groups Owned By Me
     */
    public static final String MY_GROUPS = "mygroups";
    /**
     * List all members of the Group Owned By Me
     */
    public static final String MEMBERS = "members";
    /**
     * List all members of the Group Owned By Me
     */
    public static final String BROADCAST = "broadcast";
    /**
     * Create a Chat group or a Broadcast Group
     */
    public static final String CREATE = "create";
    
    
    
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
     * Chat Group
     */
    public static final String CHAT_TYPE = "CHAT";
    /**
     * Broadcast Group
     */
    public static final String BROADCAST_TYPE = "BROADCAST";
}

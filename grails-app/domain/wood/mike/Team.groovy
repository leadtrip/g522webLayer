package wood.mike

/**
 * Team uses a Map for the hasMany relationship
 *
 * This creates a table structure like
 *  ______   ___________________
 * |TEAM |  | TEAM_MEMBERS      |
 * |ID   |  | TEAM_MEMBERS_ID   |
 * |NAME |  | MEMBER_ID         |
 * ______   | NAME              |
 *          ____________________
 */
class Team {
    String name
    static hasMany = [members: Member]
    Map members
}

class Member {
    String name
}
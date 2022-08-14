package wood.mike

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

/**
 * Domain Team has a hasMany relationship with Member using a Map rather than the default Set
 */
class TeamControllerSpec extends Specification implements ControllerUnitTest<TeamController>, DomainUnitTest<Team> {

    static final TEAM_NAME = 'Ineos'
    static final MANAGER = 'Dave'
    static final DS = 'Charles'
    static final COACH = 'Andy'
    static final DOCTOR = 'Bob'
    static final SOIGNEUR = 'Chris'

    def populateValidParams(params) {
        assert params != null

        params['name'] = TEAM_NAME
        params['members.manager'] = MANAGER
        params['members.ds'] = DS
        params['members.coach'] = COACH
        params['members.doctor'] = DOCTOR
        params['members.soigneur'] = SOIGNEUR
    }

    /**
     * TeamController uses a data service, because we want to use the real thing in this test we look it up in the
     * data store as opposed to creating a spock Spy in BookControllerSpec where a non-data service is used
     */
    void setup() {
        controller.teamService = getDatastore().getService(TeamService)
    }

    void "test create team"() {
        given:
            populateValidParams(params)
        and:
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
        when:
            controller.save()   // NOT BUILDING A Team DOMAIN IN THE TEST, GRAILS WILL DO THIS EN ROUTE TO THE CONTROLLER ACTION
        then:
            def allTeams = Team.all
            allTeams.size() == 1
            def team1 = allTeams[0]
            team1.name == TEAM_NAME
            def team1Members = team1.members
            team1Members.manager == MANAGER
            team1Members.ds == DS
            team1Members.coach == COACH
            team1Members.doctor == DOCTOR
            team1Members.soigneur == SOIGNEUR
    }
}







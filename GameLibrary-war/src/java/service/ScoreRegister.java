/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Score;
import entity.UserData;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import session.ScoreFacade;
import session.UserDataFacade;

@WebService(serviceName = "ScoreRegister")
public class ScoreRegister {

    private static final String REGISTER_SUCCESSFULL = "Register successfull!";
    private static final String NO_USERDATA_FOUND = "There is no user data matching your criterias!";

    @EJB
    private UserDataFacade userDataFacade;

    @EJB
    private ScoreFacade scoreFacade;

    @WebMethod()
    public String registerByPlayerNameAndGameTitle(
            @WebParam(name = "gameTitle") @XmlElement(required = true) String gameTitle,
            @WebParam(name = "playerName") @XmlElement(required = true) String playerName,
            @WebParam(name = "scoreValue") @XmlElement(required = true) Integer scoreValue
    ) throws Exception {
        final UserData userData = userDataFacade.find(gameTitle, playerName);
        if (userData == null) {
            throw new Exception(NO_USERDATA_FOUND);
        }

        final Score newScore = new Score();
        newScore.setUserData(userData);
        newScore.setScoreValue(scoreValue);
        scoreFacade.create(newScore);

        return REGISTER_SUCCESSFULL;
    }
}

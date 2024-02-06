package no.jib.lagpagegenerator.helpers;
/************************************************************************
 ** Copyright (c) JIB 2024 -                                           **
 **                                                                    **
 ** This source is licensed under :                                    **
 **                                                                    **
 **                   GNU GENERAL PUBLIC LICENSE                       **
 **                    Version 3, 29 June 2007                         **
 **                                                                    **
 **            Copyright (C) 2007 Free Software Foundation,            **
 **                    Inc. <https://fsf.org/>                         **
 **                                                                    **
 ** Complete license descriptiom at:                                   **
 **             <https://www.gnu.org/licenses/gpl-3.0.txt>             **
 **                                                                    **
 ************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

    Properties props;
    String hometext = new String();
    String homepage = new String();
    String infotext = new String();
    String clubname = new String();
    String clublogo = new String();
    String traininghead = new String();
    String leaderhead = new String();
    String playerhead = new String();
    String leaderA = new String();
    String leaderB = new String();
    String leaderC = new String();
    String leaderD = new String();
    String leaderE = new String();

    public boolean ifExist() {
        File propsFile = new File("config/config.properties");
        return propsFile.exists();
    }

    public void dataLoad() throws IOException {
        File propsFile = new File("config/config.properties");
        props = new Properties();
        FileInputStream fis = new FileInputStream(propsFile);
        props.load(fis);
        fis.close();
        hometext = props.getProperty("hometext");
        homepage = props.getProperty("homepage");
        infotext = props.getProperty("infotext");
        clubname = props.getProperty("clubname");
        clublogo = props.getProperty("clublogo");
        traininghead = props.getProperty("traininghead");
        leaderhead = props.getProperty("leaderhead");
        playerhead = props.getProperty("playerhead");
        leaderA = props.getProperty("leaderA");
        leaderB = props.getProperty("leaderB");
        leaderC = props.getProperty("leaderC");
        leaderD = props.getProperty("leaderD");
        leaderE = props.getProperty("leaderE");
    }

    public String getHometext() {
        return hometext;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getInfotext() {
        return infotext;
    }

    public String getClubname() {
        return clubname;
    }

    public String getClublogo() {
        return clublogo;
    }

    public String getTraininghead() {
        return traininghead;
    }

    public String getLeaderhead() {
        return leaderhead;
    }

    public String getPlayerhead() {
        return playerhead;
    }

    public String getLeaderA() {
        return leaderA;
    }

    public String getLeaderB() {
        return leaderB;
    }

    public String getLeaderC() {
        return leaderC;
    }

    public String getLeaderD() {
        return leaderD;
    }

    public String getLeaderE() {
        return leaderE;
    }
}

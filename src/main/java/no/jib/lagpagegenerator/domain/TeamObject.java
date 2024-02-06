package no.jib.lagpagegenerator.domain;
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

public class TeamObject {
    private PlayerList PL = new PlayerList();
    private String teamName = new String();
    private String background = new String();
    private String heading = new String();
    private String description = new String();
    private String place = new String();
    private String time = new String();
    private String leaderA = new String();
    private String leaderB = new String();
    private String leaderC = new String();
    private String leaderD = new String();
    private String leaderE = new String();
    private boolean advanced = false;
    private String subtext = new String();

    public void initObject() {
        background = "$";
        heading = "$";
        teamName = "$";
        description = "$";
        place = "$";
        time = "$";
        leaderA = "$";
        leaderB = "$";
        leaderC = "$";
        leaderD = "$";
        leaderE = "$";
        subtext = "$";
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLeaderA(String leaderA) {
        this.leaderA = leaderA;
    }

    public void setLeaderB(String leaderB) {
        this.leaderB = leaderB;
    }

    public void setLeaderC(String leaderC) {
        this.leaderC = leaderC;
    }

    public void setLeaderD(String leaderD) {
        this.leaderD = leaderD;
    }

    public void setLeaderE(String leaderE) {
        this.leaderE = leaderE;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public void setPL(PlayerList PL) {
        this.PL = PL;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getBackground() {
        if(background.charAt(0) == '$') {
            return null;
        }
        return background;
    }

    public String getTeamName() {
        if(teamName.charAt(0) == '$') {
            return null;
        }
        return teamName;
    }

    public String getTeamFileName() {
        if(teamName.charAt(0) == '$') {
            return null;
        }
        return teamName.replaceAll("\\s", "");
    }

    public String getHeading() {
        if(heading.charAt(0) == '$') {
            return null;
        }
        return heading;
    }

    public String getDescription() {
        if(description.charAt(0) == '$') {
            return null;
        }
        return description;
    }

    public String getPlace() {
        if(place.charAt(0) == '$') {
            return null;
        }
        return place;
    }

    public String getTime() {
        if(time.charAt(0) == '$') {
            return null;
        }
        return time;
    }

    public String getLeaderA() {
        if(leaderA.charAt(0) == '$') {
            return null;
        }
        return leaderA;
    }

    public String getLeaderB() {
        if(leaderB.charAt(0) == '$') {
            return null;
        }
        return leaderB;
    }

    public String getLeaderC() {
        if(leaderC.charAt(0) == '$') {
            return null;
        }
        return leaderC;
    }

    public String getLeaderD() {
        if(leaderD.charAt(0) == '$') {
            return null;
        }
        return leaderD;
    }

    public String getLeaderE() {
        if(leaderE.charAt(0) == '$') {
            return null;
        }
        return leaderE;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public String getSubtext() {
        if(subtext.charAt(0) == '$') {
            return null;
        }
        return subtext;
    }

    public PlayerList getPL() {
        return PL;
    }

    public String getRec(int type) {
        if(type == 1) {
            return String.format("REC01;%s;%s;%s;", background, heading,teamName);
        } else if(type == 2) {
            return String.format("REC02;%s;", description);
        } else if(type == 3) {
            String temp = new String();
            if(advanced) {
                temp = "true";
            } else {
                temp = "false";
            }
            return String.format("REC03;%s;%s;%s;", place, time, temp);
        } else if(type == 4) {
            return String.format("REC04;%s;%s;%s;%s;%s;", leaderA, leaderB, leaderC, leaderD, leaderE);
        } else if(type == 5) {
            return String.format("REC05;%s;", subtext);
        }
        return null;
    }

    public int playerListSize() {
        return PL.size();
    }

    public String getPlayerRec(int ix) {
        return PL.getRecord(ix);
    }

    public void addRec(String rec) {
        String [] base = rec.split(";");
        if(base[0].equalsIgnoreCase("REC01")) {
            background = base[1];
            heading = base[2];
            teamName = base[3];
        } else if(base[0].equalsIgnoreCase("REC02")) {
            description = base[1];
        } else if(base[0].equalsIgnoreCase("REC03")) {
            place = base[1];
            time = base[2];
            System.out.println("***** " + base[3]);
            if(base[3].equalsIgnoreCase("true")) {
                advanced = true;
            } else {
                advanced = false;
            }
        } else if(base[0].equalsIgnoreCase("REC04")) {
            leaderA = base[1];
            leaderB = base[2];
            leaderC = base[3];
            leaderD = base[4];
            leaderE = base[5];
        } else if(base[0].equalsIgnoreCase("REC05")) {
            subtext = base[1];
        } else if(base[0].equalsIgnoreCase("REC06")) {
            PL.addRecord(rec);
        }
    }
}

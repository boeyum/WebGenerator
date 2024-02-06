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

public class HtmlLibrary {
    private Translater TL = new Translater();

    public String openHtml(String heading) {
        String tempStr = new String();
        tempStr = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>";
        tempStr += TL.fix(heading);
        tempStr += "</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "</head>\n" +
                "<body style=\"background-color:light_gray;\">\n\n";
        return tempStr;
    }

    public String closeHtml() {
        return "<!-- Footer -->\n" +
                "<footer class=\"w3-center w3-gray w3-padding-16\">\n" +
                "  <p>Generert av LagPageGenerator version 1.x - (c) JIB 2024 -</p>\n" +
                "  <p>Powered by <a href=\"https://www.w3schools.com/w3css/default.asp\" title=\"W3.CSS\" target=\"_blank\" class=\"w3-hover-text-green\">w3.css</a></p>\n" +
                "</footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    public String makeMenu(String heading, String pointer,String sheading, String logo) {
        String tempStr = new String();
        tempStr = "<!-- Navbar (sit on top) -->\n" +
                "<div class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-white w3-wide w3-padding w3-card\">\n" +
                "    <a href=\"#home\" class=\"w3-bar-item w3-button\"><img height=\"40px\" src=\"";
        tempStr += logo;
        tempStr += "\"> ";
        tempStr += TL.fix(heading);
        tempStr += "</a>\n" +
                "    <div class=\"w3-right w3-hide-small\">\n" +
                "      <a href=\"";
        tempStr += pointer;
        tempStr += "\" class=\"w3-bar-item w3-button\">HJEM</a>\n" +
                "      <a href=\"#about\" class=\"w3-bar-item w3-button\">";
        tempStr += TL.fix(sheading);
        tempStr += "</a>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n\n";
        return tempStr;
    }

    public String makeHeading(String team, String image) {
        String tempStr = new String();
        tempStr = "<!-- Header -->\n" +
                "<header class=\"w3-display-container w3-content w3-wide\" style=\"max-width:1500px;\" id=\"home\">\n" +
                "  <img class=\"w3-image\" src=\"";
        tempStr += image;
        tempStr += "\" alt=\"Lagbilde\" width=\"1500\" height=\"800\" style=\"opacity: 0.6;\">\n" +
                "  <div class=\"w3-display-middle w3-margin-top w3-center\">\n" +
                "    <h1 class=\"w3-xxxlarge\"><span class=\"w3-text-grey\" style=\"text-shadow:1px 1px 0 #444\"><b>";
        tempStr += TL.fix(team);
        tempStr += "</b></span></h1>\n" +
                "  </div>\n" +
                "</header>\n\n";
        return tempStr;
    }

    public String startPageInfo() {
        return "<!-- Page content -->\n" +
                "<div class=\"w3-content w3-padding\" style=\"max-width:1564px\">\n\n";
    }

    public String endPageInfo() {
        return "<!-- End page content -->\n" +
                "</div>\n\n";
    }

    public String aboutInfo(String head, String text) {
        String tempStr = new String();
        tempStr = "  <!-- About Section -->\n" +
                "  <div class=\"w3-container w3-padding-32\" id=\"about\">\n" +
                "    <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">";
        tempStr += TL.fix(head);
        tempStr += "</h3>\n" +
                "    <p>";
        tempStr += TL.fix(text);
        tempStr += "\n" +
                "    </p>\n" +
                "  </div>\n\n";
        return tempStr;
    }

    public String traingingInfo(String headtxt, String sted, String tid) {
        String tempStr = new String();
        tempStr = "  <!-- Treningstid Section -->\n" +
                "  <div class=\"w3-container w3-padding-32\" id=\"trening\">\n" +
                "    <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">";
        tempStr += TL.fix(headtxt);
        tempStr += "</h3>\n" +
                "    <center>\n" +
                "    \t<table width=\"100%\">\n" +
                "    \t\t<tr>\n" +
                "    \t\t\t<td>";
        tempStr += TL.fix(sted);
        tempStr += "</td>\n" +
                "    \t\t\t<td>";
        tempStr += TL.fix(tid);
        tempStr += "</td>\n" +
                "    \t\t</tr>\n" +
                "    \t</table>\n" +
                "    </center>\n" +
                "  </div>\n\n";
        return tempStr;
    }

    public String startSimpleLeader(String header) {
        return "  <!-- Lagleder Section -->\n" +
                "  <div class=\"w3-container w3-padding-32\" id=\"lagleder\">\n" +
                String.format("    <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">%s</h3>\n",header) +
                "    <center>\n" +
                "    \t<table width=\"100%\">\n";
    }

    public String entrySimpleLeader(String head, String name) {

        return "    \t\t<tr>\n" +
                String.format("    \t\t\t<td><b>%s</b></td>\n",TL.fix(head)) +
                String.format("    \t\t\t<td>%s</td>\n",TL.fix(name)) +
                "    \t\t</tr>\n";
    }

    public String endSimpleLeader() {
        return "    \t</table>\n" +
                "    </center>\n" +
                "  </div>\n\n";
    }

    public String startPlayer(String head) {
        String tempstr = new String();
        tempstr = "<!-- player Section -->\n" +
                " <div class=\"w3-container w3-padding-32\" id=\"players\">\n" +
                "\t<h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">";
        tempstr += TL.fix(head);
        tempstr += "</h3>\n" +
                "\t  <div class=\"w3-row-padding\">\n";
        return tempstr;
    }

    public String playerRow(String [] sett, boolean siste) {
        String tempstr = new String();
        for(int x = 0; x < sett.length; x++) {
            String [] base = sett[x].split(";");
            tempstr += "\t\t<div class=\"w3-col l3 m6 w3-margin-bottom\">\n" +
                    "\t\t  <img src=\"";
            tempstr += base[2];
            tempstr += "\" alt=\"Portrait photo\" style=\"height:100%\">\n" +
                    "\t\t  <h3>";
            tempstr += TL.fix(base[0]);
            tempstr += "</h3>\n" +
                    "\t\t  <p class=\"w3-opacity\">";
            tempstr += TL.fix(base[1]);
            tempstr += "</p>\n" +
                    "\t\t</div>\n";
        }
        if(!siste) {
            tempstr += "\t  </div>\n" +
                    "\t  <div class=\"w3-row-padding\">\n";
        }
        return tempstr;
    }

    public String endPlayer() {
        return "  \t</div>\n" +
                "  </div>\n\n";
    }

    public String startLeader(String head) {
        String tempstr = new String();
        tempstr = "<!-- leader Section -->\n" +
                " <div class=\"w3-container w3-padding-32\" id=\"leaders\">\n" +
                "\t<h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">";
        tempstr += TL.fix(head);
        tempstr += "</h3>\n" +
                "\t  <div class=\"w3-row-padding\">\n";
        return tempstr;
    }

    public String leaderRow(String [] sett, boolean siste) {
        String tempstr = new String();
        for(int x = 0; x < sett.length; x++) {
            String [] base = sett[x].split(";");
            tempstr += "\t\t<div class=\"w3-col l3 m6 w3-margin-bottom\">\n" +
                    "\t\t  <img src=\"";
            tempstr += base[2];
            tempstr += "\" alt=\"John\" style=\"height:100%\">\n" +
                    "\t\t  <h3>";
            tempstr += TL.fix(base[0]);
            tempstr += "</h3>\n" +
                    "\t\t  <p class=\"w3-opacity\">";
            tempstr +=TL.fix(base[1]);
            tempstr += "</p>\n" +
                    "\t\t</div>\n";
        }
        if(!siste) {
            tempstr += "\t  </div>\n" +
                    "\t  <div class=\"w3-row-padding\">\n";
        }
        return tempstr;
    }

    public String endLeader() {
        return "  \t</div>\n" +
                "  </div>\n\n";
    }

    public String subText(String text) {
        String tempStr = new String();
        tempStr = "<!-- subtekst Section -->\n" +
                "  <div class=\"w3-container w3-padding-32 w3-center\" id=\"subtext\">\n" +
                "    <p>";
        tempStr += TL.fix(text);
        tempStr += "    </p>\n" +
                "  </div>\n";
        return tempStr;
    }
}

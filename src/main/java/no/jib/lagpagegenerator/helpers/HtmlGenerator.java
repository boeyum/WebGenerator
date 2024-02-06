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

import no.jib.lagpagegenerator.domain.PlayerList;
import no.jib.lagpagegenerator.domain.PlayerObject;
import no.jib.lagpagegenerator.domain.TeamObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class HtmlGenerator {
    private PropertyHandler PO = new PropertyHandler();
    private ImageHandler IH = new ImageHandler();
    private HtmlLibrary HL = new HtmlLibrary();
    private File inf;
    private BufferedWriter bw;

    public void makeHtmlFileSet(TeamObject TO) throws Exception {
        if(!PO.ifExist()) {
            throw new Exception("Missing configuration file");
        }
        PO.dataLoad();
        inf = new File(String.format("html/%s.html",TO.getTeamName()));
        openHtml();
        writeData(HL.openHtml(TO.getHeading()));
        writeData(HL.makeMenu(String.format("%s - %s",PO.clubname,TO.getTeamName()),PO.homepage,PO.getInfotext(),PO.clublogo));
        String imgName = new String();
        String lnkName = new String();
        if(IH.isPng(TO.getBackground())) {
            imgName = String.format("html/image/%s.png", TO.getTeamFileName());
            lnkName = String.format("image/%s.png", TO.getTeamFileName());
        } else {
            imgName = String.format("html/image/%s.jpg", TO.getTeamFileName());
            lnkName = String.format("image/%s.jpg", TO.getTeamFileName());
        }
        IH.moveImage(TO.getBackground(),imgName);
        writeData(HL.makeHeading(TO.getTeamName(),lnkName));
        writeData(HL.startPageInfo());
        writeData(HL.aboutInfo(TO.getHeading(),TO.getDescription()));
        writeData(HL.traingingInfo(PO.getTraininghead(),TO.getPlace(),TO.getTime()));
        if(!TO.isAdvanced()) {
            writeData(HL.startSimpleLeader(PO.getLeaderhead()));
            writeData(HL.entrySimpleLeader(PO.getLeaderA(),TO.getLeaderA()));
            if(TO.getLeaderB() != null) {
                writeData(HL.entrySimpleLeader(PO.getLeaderB(),TO.getLeaderB()));
            }
            if(TO.getLeaderC() != null) {
                writeData(HL.entrySimpleLeader(PO.getLeaderC(),TO.getLeaderC()));
            }
            if(TO.getLeaderD() != null) {
                writeData(HL.entrySimpleLeader(PO.getLeaderD(),TO.getLeaderD()));
            }
            if(TO.getLeaderE() != null) {
                writeData(HL.entrySimpleLeader(PO.getLeaderE(),TO.getLeaderE()));
            }
            writeData(HL.endSimpleLeader());
        } else {
            lnkName = "";
            writeData(HL.startPlayer(PO.getPlayerhead()));
            PlayerList PL = TO.getPL();
            ArrayList<PlayerObject> spiller = PL.getPlayers();
            int ant = spiller.size();
            int val = (ant / 4);
            int lst = ant - (val * 4);
            int ptr = 0;
            BufferedImage foto;
            BufferedImage nfoto;
            String fname = new String();
            for(int x = 0; x < val; x++) {
                String [] sett = new String[4];
                foto = IH.readImage(spiller.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(spiller.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[0] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(spiller.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(spiller.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[1] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(spiller.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(spiller.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[2] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(spiller.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(spiller.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[3] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                ptr++;
                if(lst == 0) {
                    writeData(HL.playerRow(sett,true));
                } else {
                    writeData(HL.playerRow(sett,false));
                }
            }
            lnkName = "";
            if(lst > 0) {
                String [] sett = new String[lst];
                if(lst == 1) {
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                } else if(lst == 2) {
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[1] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                } else if(lst == 3) {
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[1] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(spiller.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(spiller.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02d.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02d.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[2] = String.format("%s;%s;%s;",spiller.get(ptr).getName(),spiller.get(ptr).getInfo(),lnkName);
                }
                writeData(HL.playerRow(sett,true));
            }
            writeData(HL.endPlayer());
            writeData(HL.startLeader(PO.leaderhead));
            ArrayList<PlayerObject> leder = PL.getLeaders();
            ant = leder.size();
            val = (ant / 4);
            lst = ant - (val * 4);
            ptr = 0;
            for(int x = 0; x < val; x++) {
                lnkName = "";
                String [] sett = new String[4];
                foto = IH.readImage(leder.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(leder.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[0] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(leder.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(leder.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[1] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(leder.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(leder.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[2] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                ptr++;
                foto = IH.readImage(leder.get(ptr).getPhoto());
                nfoto = IH.resizeImageByHeight(foto, 250);
                if(IH.isPng(leder.get(ptr).getPhoto())) {
                    lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                } else {
                    lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                }
                IH.writeImage(nfoto,fname);
                sett[3] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                ptr++;
                if(lst == 0) {
                    writeData(HL.leaderRow(sett,true));
                } else {
                    writeData(HL.leaderRow(sett,false));
                }
            }
            lnkName = "";
            if(lst > 0) {
                String [] sett = new String[lst];
                if(lst == 1) {
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                } else if(lst == 2) {
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[1] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                } else if(lst == 3) {
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[0] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[1] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                    ptr++;
                    foto = IH.readImage(leder.get(ptr).getPhoto());
                    nfoto = IH.resizeImageByHeight(foto, 250);
                    if(IH.isPng(leder.get(ptr).getPhoto())) {
                        lnkName = String.format("image/%s%02dL.png",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.png",TO.getTeamFileName(),ptr);
                    } else {
                        lnkName = String.format("image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                        fname = String.format("html/image/%s%02dL.jpg",TO.getTeamFileName(),ptr);
                    }
                    IH.writeImage(nfoto,fname);
                    sett[2] = String.format("%s;%s;%s;",leder.get(ptr).getName(),leder.get(ptr).getInfo(),lnkName);
                }
                writeData(HL.leaderRow(sett,true));
            }
            writeData(HL.endLeader());
        }

        writeData(HL.subText(TO.getSubtext()));
        writeData(HL.closeHtml());
        closeHtml();
    }

    private void openHtml() throws IOException {
        bw = new BufferedWriter(new FileWriter(inf));
    }

    private void writeData(String data) throws IOException {
        bw.write(data);
    }

    private void closeHtml() throws IOException {
        bw.close();
    }

}

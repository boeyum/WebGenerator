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
import no.jib.lagpagegenerator.domain.TeamObject;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StorageService {

    public boolean storeTeamFile(String fname, TeamObject TO) throws IOException {
        String dataBuffer = new String();
        dataBuffer += TO.getRec(1);
        dataBuffer += "\n";
        dataBuffer += TO.getRec(2);
        dataBuffer += "\n";
        dataBuffer += TO.getRec(3);
        dataBuffer += "\n";
        dataBuffer += TO.getRec(4);
        dataBuffer += "\n";
        dataBuffer += TO.getRec(5);
        dataBuffer += "\n";
        if(TO.isAdvanced()) {
            PlayerList PL = TO.getPL();
            for(int x = 0; x < PL.size(); x++) {
                dataBuffer += PL.getRecord(x);
                dataBuffer += "\n";
            }
        }

        File fileToSave = new File(fname);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave.getAbsolutePath()));
        byte[] bytes = dataBuffer.getBytes(StandardCharsets.UTF_8);
        writer.write(new String(bytes, StandardCharsets.UTF_8));

        writer.close();

        return true;
    }

    public boolean teamFileExist(String fnavn) {
        File fileToSave = new File(fnavn);
        return fileToSave.exists();
    }

    public TeamObject readTeamFile(String fname) throws IOException {
        TeamObject TO = new TeamObject();
        File fileToRead = new File(fname);
        if(!fileToRead.exists()) {
            return null;
        }
        BufferedReader in;
        in = new BufferedReader(new FileReader(fileToRead));
        String line = in.readLine();
        while (line != null) {
            TO.addRec(line);
            line = in.readLine();
        }
        in.close();
        return TO;
    }
}

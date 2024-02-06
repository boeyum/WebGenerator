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

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ProgramCash {
    private String filename = new String();
    private int players = -1;

    private boolean open = false;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getFilename() {
        return filename;
    }

    public int getPlayers() {
        return players;
    }

    public boolean isOpen() {
        return open;
    }

    public void storeCash() throws IOException {
        String dataBuffer = new String();
        String temp = new String();
        String fn = new String();
        String pl = new String();
        if((filename == null) || (filename.length() < 2)) {
            fn = "$";
        } else {
            fn = filename;
        }
        if(open) {
            temp = "true";
        } else {
            temp = "false";
        }
        dataBuffer = String.format("%s;%s;%d;\n",temp,fn,players);
        File cc = new File("work/data.cc");
        BufferedWriter writer = new BufferedWriter(new FileWriter(cc.getAbsolutePath()));
        byte[] bytes = dataBuffer.getBytes(StandardCharsets.UTF_8);
        writer.write(new String(bytes, StandardCharsets.UTF_8));
        writer.close();
    }

    public void openCash() throws IOException {
        File cc = new File("work/data.cc");
        if(!cc.exists()) {
            return;
        }
        BufferedReader in;
        in = new BufferedReader(new FileReader(cc));
        String line = in.readLine();
        in.close();
        String [] base = line.split(";");
        if(base[0].equalsIgnoreCase("true")) {
            open = true;
        } else {
            open = false;
        }
        if(base[1].charAt(0) == '$') {
            filename = null;
        } else {
            filename = base[1];
        }
        players = Integer.parseInt(base[2]);
    }

    public void cleanCash() {
        File cc = new File("work/data.cc");
        if(cc.exists()) {
            cc.delete();
        }
    }

    public String workCashFile() {
        return "work/work.dat";
    }
}

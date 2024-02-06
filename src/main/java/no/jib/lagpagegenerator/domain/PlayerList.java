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

import java.util.ArrayList;

public class PlayerList {
    private ArrayList<PlayerObject> DB = new ArrayList<PlayerObject>();

    public void add(int type, String photo, String name, String info) {
        DB.add(new PlayerObject(type, photo, name, info));
    }

    public int size() {
        return DB.size();
    }

    public void delete(int index) {
        DB.remove(index);
    }

    public String getPhoto(int index) {
        return DB.get(index).getPhoto();
    }

    public String getName(int index) {
        return DB.get(index).getName();
    }

    public String getInfo(int index) {
        return DB.get(index).getInfo();
    }

    public PlayerObject getObject(int ix) {
        return DB.get(ix);
    }

    public String getRecord(int index) {
        String xphoto = DB.get(index).getPhoto();
        String xname = DB.get(index).getName();
        String xinfo = DB.get(index).getInfo();
        return String.format("REC06;%d;%s;%s;%s;", DB.get(index).getType(), xphoto, xname, xinfo);
    }

    public void addRecord(String rec) {
        String[] base = rec.split(";");
        if (base[0].equalsIgnoreCase("REC06")) {
            int xtype = Integer.parseInt(base[1]);
            String xphoto = base[2];
            String xname = base[3];
            String xinfo = base[4];
            DB.add(new PlayerObject(xtype, xphoto, xname, xinfo));
        }
    }

    public String[] getPlayerList(int type) {
        ArrayList<String> koder = new ArrayList<>();
        for (int x = 0; x < DB.size(); x++) {
            if (type == GruppeType.SPILLER.getCode()) {
                if (DB.get(x).getType() == type) {
                    koder.add(DB.get(x).getName());
                }
            } else {
                if (DB.get(x).getType() == type) {
                    koder.add(DB.get(x).getName());
                }
            }
        }
        String[] str = new String[koder.size()];
        for (int x = 0; x < koder.size(); x++) {
            str[x] = koder.get(x);
        }
        return str;
    }

    public int getPlayerSize() {
        int num = 0;
        for (int x = 0; x < DB.size(); x++) {
            if (DB.get(x).getType() == GruppeType.SPILLER.getCode()) {
                num++;
            }
        }
        return num;
    }

    public ArrayList<PlayerObject> getPlayers() {
        ArrayList<PlayerObject> ny = new ArrayList<PlayerObject>();
        for (int x = 0; x < DB.size(); x++) {
            if(DB.get(x).getType() == GruppeType.SPILLER.getCode()) {
                ny.add(DB.get(x));
            }
        }
        return ny;
    }

    public ArrayList<PlayerObject> getLeaders() {
        ArrayList<PlayerObject> ny = new ArrayList<PlayerObject>();
        for (int x = 0; x < DB.size(); x++) {
            if(DB.get(x).getType() == GruppeType.LEDER.getCode()) {
                ny.add(DB.get(x));
            }
        }
        return ny;
    }

}

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

public class PlayerObject {
    private String photo = new String();
    private String name = new String();
    private String info = new String();
    private int type = 0;

    public PlayerObject(int type, String photo, String name, String info) {
        this.type = type;
        if(photo == null) {
            this.photo = "$";
        } else {
            this.photo = photo;
        }
        if(name == null) {
            this.name ="$";
        } else {
            this.name = name;
        }
        if(info == null) {
            this.info = "$";
        } else {
            this.info = info;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhoto() {
        if(photo.charAt(0) == '$') {
            return null;
        }
        return photo;
    }

    public void setPhoto(String photo) {
        if(photo == null) {
            this.photo = "$";
        } else {
            this.photo = photo;
        }
    }

    public String getName() {
        if(name.charAt(0) == '$') {
            return null;
        }
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            this.name = "$";
        } else {
            this.name = name;
        }
    }

    public String getInfo() {
        if(info.charAt(0) == '$') {
            return null;
        }
        return info;
    }

    public void setInfo(String info) {
        if(info == null) {
            this.info = "$";
        } else {
            this.info = info;
        }
    }
}

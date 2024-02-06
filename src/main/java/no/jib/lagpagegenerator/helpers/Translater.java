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

public class Translater {

    public String fix(String in) {
        String out = new String();
        for(int x = 0; x < in.length();x++) {
            String kode = charCheck(in.charAt(x));
            if(kode == null) {
                out += String.format("%c", in.charAt(x));
            } else {
                out += kode;
            }
        }
        return out;
    }

    private String charCheck(char val) {
        switch(val) {
            case 'æ':return "&aelig;";
            case 'ø':return "&oslash;";
            case 'å':return "&aring;";
            case 'Æ':return "&AElig;";
            case 'Ø':return "&Oslash;";
            default:return null;
        }
    }
}

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

public enum TeamFileType {
    NORMAL (0, false),
    ADVANCED (1, true);

    private int type;
    private boolean advanced;

    TeamFileType(int type,  boolean advanced) {
        this.type = type;
        this.advanced = advanced;
    }

    public int getType() {
        return type;
    }

    public boolean isAdvanced() {
        return advanced;
    }
}

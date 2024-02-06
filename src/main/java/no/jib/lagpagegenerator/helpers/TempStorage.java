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

import no.jib.lagpagegenerator.domain.TeamObject;

import java.io.IOException;

public class TempStorage {
    private StorageService SS = new StorageService();

    public void tempStoreSave(String fname, TeamObject TO) {
        try {
            SS.storeTeamFile(fname,TO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

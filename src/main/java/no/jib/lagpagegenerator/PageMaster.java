package no.jib.lagpagegenerator;
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

import no.jib.lagpagegenerator.domain.PBLib;
import no.jib.lagpagegenerator.forms.LagMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PageMaster {
    private PBLib BG = new PBLib();
    private JFrame frame;
    private BufferedImage bgImage;
    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PageMaster window = new PageMaster();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PageMaster() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        int baseWidth = (screenWidth/2)-250;
        int baseHeight = (screenHeight/2)-150;
        frame = new JFrame("");
        frame.setBounds(baseWidth, baseHeight, 400, 265);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        try {
            bgImage = BG.getLogo();
            imageIcon = new ImageIcon(bgImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel(imageIcon);
        frame.getContentPane().add(label);

        frame.setVisible(true);
        Timer timer = new Timer(5000, new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                frame.dispose();
                frame.setVisible(false);
                LagMain web = new LagMain();
                web.main(null);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

}
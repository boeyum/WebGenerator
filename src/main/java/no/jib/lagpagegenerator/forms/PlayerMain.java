package no.jib.lagpagegenerator.forms;
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

import no.jib.lagpagegenerator.domain.*;
import no.jib.lagpagegenerator.helpers.StorageService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerMain {
    private ProgramCash PC = new ProgramCash();
    private StorageService SS = new StorageService();
    private TeamObject TO = new TeamObject();
    private PlayerList PL = new PlayerList();
    private PBLLib logo = new PBLLib();
    private EmptyLib tomt = new EmptyLib();
    private JFrame frame;
    private JList basis;
    private JList leder;
    private JLabel fotolab;
    private JTextField navn;
    private JTextField data;
    private JButton playerIn;
    private JButton playerOut;
    private JButton leaderIn;
    private JButton leaderOut;
    private JButton loadimage;
    private JButton saveexit;
    private JButton objdelete;
    private ImageIcon imageIcon;
    private ImageIcon emptyIcon;
    private PlayerObject PO = new PlayerObject(0, null, null, null);
    private String currentPhoto = new String();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlayerMain window = new PlayerMain();
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
    public PlayerMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Player Registration");
        frame.setBounds(150, 20, 1000, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        try {
            PC.openCash();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "CASH Error!", JOptionPane.ERROR_MESSAGE);
        }

        if(PC.isOpen()) {
            try {
                TO = SS.readTeamFile(PC.workCashFile());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "READ Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        PL = TO.getPL();

        JLabel dummy1 = new JLabel("Player list");
        dummy1.setBounds(20, 20, 100, 20);
        frame.getContentPane().add(dummy1);

        basis = new JList();
        listModel(GruppeType.SPILLER.getCode(), PL.getPlayerList(GruppeType.SPILLER.getCode()));
        basis.setBounds(20,50,400,400);
        frame.getContentPane().add(basis);

        JLabel dummy2 = new JLabel("Leader list");
        dummy2.setBounds(20, 470, 100, 20);
        frame.getContentPane().add(dummy2);

        leder = new JList();
        listModel(GruppeType.LEDER.getCode(), PL.getPlayerList(GruppeType.LEDER.getCode()));
        leder.setBounds(20,500,400,150);
        frame.getContentPane().add(leder);

        try {
            BufferedImage bgImage = logo.getLogo();
            imageIcon = new ImageIcon(bgImage);
            BufferedImage emptyImage = tomt.getLogo();
            emptyIcon = new ImageIcon(emptyImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel logolabel = new JLabel(imageIcon);
        logolabel.setBounds(450, 300, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        frame.getContentPane().add(logolabel);

        playerOut = new JButton(">>>>");
        playerOut.setBounds(455, 150, 100, 25);
        frame.getContentPane().add(playerOut);

        playerIn = new JButton("<<<<");
        playerIn.setBounds(455, 200, 100, 25);
        frame.getContentPane().add(playerIn);

        leaderOut = new JButton(">>>>");
        leaderOut.setBounds(455, 520, 100, 25);
        frame.getContentPane().add(leaderOut);

        leaderIn = new JButton("<<<<");
        leaderIn.setBounds(455, 570, 100, 25);
        frame.getContentPane().add(leaderIn);

        fotolab = new JLabel(emptyIcon);
        fotolab.setBounds(720,120, 110,160);
        frame.getContentPane().add(fotolab);

        loadimage = new JButton("Load picture");
        loadimage.setBounds(600, 300, 350, 25);
        frame.getContentPane().add(loadimage);

        JLabel dummy3 = new JLabel("Name");
        dummy3.setBounds(600, 350, 100, 20);
        frame.getContentPane().add(dummy3);

        navn = new JTextField();
        navn.setBounds(600, 380, 350, 20);
        frame.getContentPane().add(navn);

        JLabel dummy4 = new JLabel("Description");
        dummy4.setBounds(600, 430, 100, 20);
        frame.getContentPane().add(dummy4);

        data = new JTextField();
        data.setBounds(600, 450, 350, 20);
        frame.getContentPane().add(data);

        objdelete = new JButton("Delete person");
        objdelete.setBounds(600, 500, 350, 25);
        frame.getContentPane().add(objdelete);

        saveexit = new JButton("Back to team-web builder");
        saveexit.setBounds(20, 680, 940, 25);
        frame.getContentPane().add(saveexit);

        loadimage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser();
                j.setDialogTitle("Select an image");
                j.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPEG images", "png", "jpg");
                j.addChoosableFileFilter(filter);
                int result = j.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = j.getSelectedFile();
                    PO.setPhoto(selectedFile.getAbsolutePath());
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File(PO.getPhoto()));
                        imageIcon = new ImageIcon(bufferedImage);
                        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 150,Image.SCALE_DEFAULT);
                        BufferedImage newBuff = myCreateImage(scaleImage);
                        ImageIcon IO = new ImageIcon(newBuff);
                        fotolab.setIcon(IO);
                        frame.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        playerOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ix = basis.getSelectedIndex();
                if(ix == -1) {
                    JOptionPane.showMessageDialog(null, "No player selected!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                PO = PL.getObject(ix);
                if(PO.getPhoto() != null) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File(PO.getPhoto()));
                        imageIcon = new ImageIcon(bufferedImage);
                        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 150,Image.SCALE_DEFAULT);
                        BufferedImage newBuff = myCreateImage(scaleImage);
                        ImageIcon IO = new ImageIcon(newBuff);
                        fotolab.setIcon(IO);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                navn.setText(PO.getName());
                data.setText(PO.getInfo());
                PL.delete(ix);
                TO.setPL(PL);
                listModel(GruppeType.SPILLER.getCode(), PL.getPlayerList(GruppeType.SPILLER.getCode()));
                frame.repaint();
            }
        });

        playerIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PO.setType(GruppeType.SPILLER.getCode());
                PO.setName(navn.getText());
                PO.setInfo(data.getText());
                PL.add(GruppeType.SPILLER.getCode(),PO.getPhoto(),navn.getText(),data.getText());
                TO.setPL(PL);
                PO = new PlayerObject(-1,"","","");
                navn.setText("");
                data.setText("");
                try {
                    BufferedImage bgImage = logo.getLogo();
                    imageIcon = new ImageIcon(bgImage);
                    BufferedImage emptyImage = tomt.getLogo();
                    emptyIcon = new ImageIcon(emptyImage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fotolab.setIcon(emptyIcon);
                listModel(GruppeType.SPILLER.getCode(), PL.getPlayerList(GruppeType.SPILLER.getCode()));
                frame.repaint();
            }
        });

        leaderIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PO.setType(GruppeType.LEDER.getCode());
                PO.setName(navn.getText());
                PO.setInfo(data.getText());
                PL.add(GruppeType.LEDER.getCode(),PO.getPhoto(),navn.getText(),data.getText());
                TO.setPL(PL);
                PO = new PlayerObject(-1,"","","");
                navn.setText("");
                data.setText("");
                try {
                    BufferedImage bgImage = logo.getLogo();
                    imageIcon = new ImageIcon(bgImage);
                    BufferedImage emptyImage = tomt.getLogo();
                    emptyIcon = new ImageIcon(emptyImage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fotolab.setIcon(emptyIcon);
                listModel(GruppeType.LEDER.getCode(), PL.getPlayerList(GruppeType.LEDER.getCode()));
                frame.repaint();
            }
        });

        leaderOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ix = leder.getSelectedIndex();
                if(ix == -1) {
                    JOptionPane.showMessageDialog(null, "No leader selected!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                PO = PL.getObject(ix);
                if(PO.getPhoto() != null) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File(PO.getPhoto()));
                        imageIcon = new ImageIcon(bufferedImage);
                        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 150,Image.SCALE_DEFAULT);
                        BufferedImage newBuff = myCreateImage(scaleImage);
                        ImageIcon IO = new ImageIcon(newBuff);
                        fotolab.setIcon(IO);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                navn.setText(PO.getName());
                data.setText(PO.getInfo());
                PL.delete(ix);
                TO.setPL(PL);
                listModel(GruppeType.LEDER.getCode(), PL.getPlayerList(GruppeType.LEDER.getCode()));
                frame.repaint();
            }
        });

        objdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navn.setText("");
                data.setText("");
                try {
                    BufferedImage bgImage = logo.getLogo();
                    imageIcon = new ImageIcon(bgImage);
                    BufferedImage emptyImage = tomt.getLogo();
                    emptyIcon = new ImageIcon(emptyImage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                fotolab.setIcon(emptyIcon);
                frame.repaint();
            }
        });

        saveexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TO.setPL(PL);
                try {
                    SS.storeTeamFile(PC.workCashFile(),TO);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
                frame.setVisible(false);
                LagMain web = new LagMain();
                web.main(null);
            }
        });
    }

    public void listModel(int type, String [] list) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < list.length; i++) {
            model.addElement(list[i]);
        }
        if(type == GruppeType.SPILLER.getCode()) {
            basis.setModel(model);
        } else {
            leder.setModel(model);
        }
    }
    // Returns a generated image.
    public BufferedImage myCreateImage(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        // Create a buffered image in which to draw
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Draw image into bufferedImage.
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }
}

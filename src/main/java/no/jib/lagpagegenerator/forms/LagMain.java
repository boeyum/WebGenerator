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

import no.jib.lagpagegenerator.domain.ProgramCash;
import no.jib.lagpagegenerator.domain.TeamObject;
import no.jib.lagpagegenerator.helpers.HtmlGenerator;
import no.jib.lagpagegenerator.helpers.StorageService;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LagMain {
    private ProgramCash PC = new ProgramCash();
    private StorageService SS = new StorageService();
    private HtmlGenerator HG = new HtmlGenerator();
    private TeamObject TO = new TeamObject();
    private Scalr SI = new Scalr();
    private JFrame frame;
    private JButton btnImage;
    private JButton btnAdvanced;
    private JButton btnPlayer;
    private JButton btnSave;
    private JButton btnSlutt;
    private JButton btnOpen;
    private JButton btnGenerate;
    private JTextField heading;
    private JTextField hall;
    private JTextField tid;
    private JTextField lederA;
    private JTextField lederB;
    private JTextField lederC;
    private JTextField lederD;
    private JTextField lederE;
    private JTextField players;
    private JTextField teamN;
    private JTextArea basis;
    private JTextArea subs;
    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;
    private String teamName = new String();
    private boolean advanced = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LagMain window = new LagMain();
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
    public LagMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Team-Web Builder");
        frame.setBounds(150, 20, 600, 1000);
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
        } else {
            TO = new TeamObject();
            TO.initObject();
        }

        btnImage = new JButton("Team Pic.");
        btnImage.setBounds(20, 40, 100, 25);
        frame.getContentPane().add(btnImage);

        JLabel nlabel = new JLabel("Team name");
        nlabel.setBounds(340,40,70,20);
        frame.getContentPane().add(nlabel);

        teamN = new JTextField();
        teamN.setBounds(420, 40, 140, 20);
        frame.getContentPane().add(teamN);
        teamN.setColumns(10);

        JLabel hlabel = new JLabel("Heading");
        hlabel.setBounds(20,100,50,20);
        frame.getContentPane().add(hlabel);

        heading = new JTextField();
        heading.setBounds(160, 100, 400, 20);
        frame.getContentPane().add(heading);
        heading.setColumns(10);

        JLabel tlabel = new JLabel("Text");
        tlabel.setBounds(20,130,50,20);
        frame.getContentPane().add(tlabel);

        basis = new JTextArea();
        basis.setBounds(20,150,540,300);
        basis.setLineWrap(true);
        basis.setWrapStyleWord(true);
        frame.getContentPane().add(basis);

        JLabel blabel = new JLabel("Place");
        blabel.setBounds(20,470,50,20);
        frame.getContentPane().add(blabel);

        hall = new JTextField();
        hall.setBounds(20, 490, 260, 20);
        frame.getContentPane().add(hall);

        JLabel clabel = new JLabel("Time");
        clabel.setBounds(300,470,50,20);
        frame.getContentPane().add(clabel);

        tid = new JTextField();
        tid.setBounds(300, 490, 260, 20);
        frame.getContentPane().add(tid);

        JLabel alabel = new JLabel("Leder A");
        alabel.setBounds(20,520,50,20);
        frame.getContentPane().add(alabel);

        lederA = new JTextField();
        lederA.setBounds(160, 520, 400, 20);
        frame.getContentPane().add(lederA);

        JLabel bblabel = new JLabel("Leder B");
        bblabel.setBounds(20,550,50,20);
        frame.getContentPane().add(bblabel);

        lederB = new JTextField();
        lederB.setBounds(160, 550, 400, 20);
        frame.getContentPane().add(lederB);

        JLabel ccabel = new JLabel("Leder C");
        ccabel.setBounds(20,580,50,20);
        frame.getContentPane().add(ccabel);

        lederC = new JTextField();
        lederC.setBounds(160, 580, 400, 20);
        frame.getContentPane().add(lederC);

        JLabel dlabel = new JLabel("Leder D");
        dlabel.setBounds(20,610,50,20);
        frame.getContentPane().add(dlabel);

        lederD = new JTextField();
        lederD.setBounds(160, 610, 400, 20);
        frame.getContentPane().add(lederD);

        JLabel elabel = new JLabel("Leder E");
        elabel.setBounds(20,640,50,20);
        frame.getContentPane().add(elabel);

        lederE = new JTextField();
        lederE.setBounds(160, 640, 400, 20);
        frame.getContentPane().add(lederE);

        btnAdvanced = new JButton("Advanced page");
        btnAdvanced.setBounds(20, 670, 250, 25);
        frame.getContentPane().add(btnAdvanced);

        players = new JTextField();
        players.setBounds(300, 670, 50, 25);
        players.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(players);
        players.setText("--");

        btnPlayer = new JButton("Add player");
        btnPlayer.setBounds(390, 670, 170, 25);
        frame.getContentPane().add(btnPlayer);
        btnPlayer.setEnabled(false);

        JLabel slabel = new JLabel("Subtext");
        slabel.setBounds(20,700,50,20);
        frame.getContentPane().add(slabel);

        subs = new JTextArea();
        subs.setBounds(20,730,540,150);
        subs.setLineWrap(true);
        subs.setWrapStyleWord(true);
        frame.getContentPane().add(subs);

        if(PC.isOpen()) {
            try {
                if(TO.getBackground() != null) {
                    bufferedImage = ImageIO.read(new File(TO.getBackground()));
                    imageIcon = new ImageIcon(bufferedImage);
                    Image scaleImage = imageIcon.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);
                    BufferedImage newBuff = myCreateImage(scaleImage);
                    ImageIcon IO = new ImageIcon(newBuff);
                    JLabel ilabel = new JLabel(IO);
                    ilabel.setBounds(200, 10, 110, 80);
                    frame.getContentPane().add(ilabel);
                    frame.repaint();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
            }
            heading.setText(TO.getHeading());
            basis.setText(TO.getDescription());
            hall.setText(TO.getPlace());
            tid.setText(TO.getTime());
            lederA.setText(TO.getLeaderA());
            lederB.setText(TO.getLeaderB());
            lederC.setText(TO.getLeaderC());
            lederD.setText(TO.getLeaderD());
            lederE.setText(TO.getLeaderE());
            advanced = TO.isAdvanced();
            if(advanced) {
                players.setText(String.format("%d",TO.getPL().getPlayerSize()));
                btnPlayer.setEnabled(true);
            }
            subs.setText(TO.getSubtext());
            frame.repaint();
        }

        btnOpen = new JButton("Open");
        btnOpen.setBounds(20, 900, 120, 25);
        frame.getContentPane().add(btnOpen);

        btnSave = new JButton("Save");
        btnSave.setBounds(160, 900, 120, 25);
        frame.getContentPane().add(btnSave);

        btnGenerate = new JButton("Generate");
        btnGenerate.setBounds(300, 900, 120, 25);
        frame.getContentPane().add(btnGenerate);

        btnSlutt = new JButton("Exit");
        btnSlutt.setBounds(440, 900, 120, 25);
        frame.getContentPane().add(btnSlutt);

        JLabel xlabel = new JLabel("(Note: Remember to save work before exit.)");
        xlabel.setBounds(20,940,540,20);
        xlabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(xlabel);

        btnImage.addActionListener(new ActionListener() {
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
                    TO.setBackground(selectedFile.getAbsolutePath());
                    try {
                        bufferedImage = ImageIO.read(new File(TO.getBackground()));
                        imageIcon = new ImageIcon(bufferedImage);
                        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 75,Image.SCALE_DEFAULT);
                        BufferedImage newBuff = myCreateImage(scaleImage);
                        ImageIcon IO = new ImageIcon(newBuff);
                        JLabel ilabel = new JLabel(IO);
                        ilabel.setBounds(200,10, 110,80);
                        frame.getContentPane().add(ilabel);
                        frame.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnAdvanced.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!advanced) {
                    btnPlayer.setEnabled(true);
                    players.setText("0");
                    advanced = true;
                    TO.setAdvanced(true);
                } else {
                    btnPlayer.setEnabled(false);
                    players.setText("--");
                    advanced = false;
                    TO.setAdvanced(false);
                }
            }
        });

        btnPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teamN.getText().length() > 1) {
                    TO.setTeamName(teamN.getText());
                }
                if (heading.getText().length() > 1) {
                    TO.setHeading(heading.getText());
                }
                if (basis.getText().length() > 1) {
                    TO.setDescription(basis.getText());
                }
                if (hall.getText().length() > 1) {
                    TO.setPlace(hall.getText());
                }
                if (tid.getText().length() > 1) {
                    TO.setTime(tid.getText());
                }
                if(lederA.getText().length() > 1) {
                    TO.setLeaderA(lederA.getText());
                }
                if(lederB.getText().length() > 1) {
                    TO.setLeaderB(lederB.getText());
                }
                if(lederC.getText().length() > 1) {
                    TO.setLeaderC(lederC.getText());
                }
                if(lederD.getText().length() > 1) {
                    TO.setLeaderD(lederD.getText());
                }
                if(lederE.getText().length() > 1) {
                    TO.setLeaderE(lederE.getText());
                }
                if(subs.getText().length() > 1) {
                    TO.setSubtext(subs.getText());
                }
                try {
                    PC.setOpen(true);
                    PC.storeCash();
                    SS.storeTeamFile(PC.workCashFile(),TO);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "WRITE Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                frame.dispose();
                frame.setVisible(false);
                PlayerMain web = new PlayerMain();
                web.main(null);
            }
        });

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HG.makeHtmlFileSet(TO);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Generate Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser();
                j.setDialogTitle("Select a team file");
                j.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Team page file", "tpf");
                j.addChoosableFileFilter(filter);
                int result = j.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = j.getSelectedFile();
                    try {
                        TO = SS.readTeamFile(selectedFile.getAbsolutePath());
                        PC.setFilename(selectedFile.getAbsolutePath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "READ Error!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    PC.setOpen(true);
                    try {
                        bufferedImage = ImageIO.read(new File(TO.getBackground()));
                        imageIcon = new ImageIcon(bufferedImage);
                        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 75,Image.SCALE_DEFAULT);
                        BufferedImage newBuff = myCreateImage(scaleImage);
                        ImageIcon IO = new ImageIcon(newBuff);
                        JLabel ilabel = new JLabel(IO);
                        ilabel.setBounds(200,10, 110,80);
                        frame.getContentPane().add(ilabel);
                        frame.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IMAGE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    teamN.setText(TO.getTeamName());
                    heading.setText(TO.getHeading());
                    basis.setText(TO.getDescription());
                    hall.setText(TO.getPlace());
                    tid.setText(TO.getTime());
                    lederA.setText(TO.getLeaderA());
                    lederB.setText(TO.getLeaderB());
                    lederC.setText(TO.getLeaderC());
                    lederD.setText(TO.getLeaderD());
                    lederE.setText(TO.getLeaderE());
                    advanced = TO.isAdvanced();
                    if(advanced) {
                        players.setText(String.format("%d",TO.getPL().getPlayerSize()));
                        btnPlayer.setEnabled(true);
                    }
                    subs.setText(TO.getSubtext());
                    frame.repaint();
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PC.isOpen()) {
                    try {
                        if (teamN.getText().length() > 1) {
                            TO.setTeamName(teamN.getText());
                        }
                        if (heading.getText().length() > 1) {
                            TO.setHeading(heading.getText());
                        }
                        if (basis.getText().length() > 1) {
                            TO.setDescription(basis.getText());
                        }
                        if (hall.getText().length() > 1) {
                            TO.setPlace(hall.getText());
                        }
                        if (tid.getText().length() > 1) {
                            TO.setTime(tid.getText());
                        }
                        if(lederA.getText().length() > 1) {
                            TO.setLeaderA(lederA.getText());
                        }
                        if(lederB.getText().length() > 1) {
                            TO.setLeaderB(lederB.getText());
                        }
                        if(lederC.getText().length() > 1) {
                            TO.setLeaderC(lederC.getText());
                        }
                        if(lederD.getText().length() > 1) {
                            TO.setLeaderD(lederD.getText());
                        }
                        if(lederE.getText().length() > 1) {
                            TO.setLeaderE(lederE.getText());
                        }
                        if(subs.getText().length() > 1) {
                            TO.setSubtext(subs.getText());
                        }
                        SS.storeTeamFile(PC.getFilename(), TO);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "STORE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    return;
                }
                if (teamN.getText().length() > 1) {
                    TO.setTeamName(teamN.getText());
                }
                if (heading.getText().length() > 1) {
                    TO.setHeading(heading.getText());
                }
                if (basis.getText().length() > 1) {
                    TO.setDescription(basis.getText());
                }
                if (hall.getText().length() > 1) {
                    TO.setPlace(hall.getText());
                }
                if (tid.getText().length() > 1) {
                    TO.setTime(tid.getText());
                }
                if(lederA.getText().length() > 1) {
                    TO.setLeaderA(lederA.getText());
                }
                if(lederB.getText().length() > 1) {
                    TO.setLeaderB(lederB.getText());
                }
                if(lederC.getText().length() > 1) {
                     TO.setLeaderC(lederC.getText());
                }
                if(lederD.getText().length() > 1) {
                    TO.setLeaderD(lederD.getText());
                }
                if(lederE.getText().length() > 1) {
                    TO.setLeaderE(lederE.getText());
                }
                if(subs.getText().length() > 1) {
                    TO.setSubtext(subs.getText());
                }

                JFileChooser j = new JFileChooser();
                j.setDialogTitle("Save a team file");
                j.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Team page file", "tpf");
                j.addChoosableFileFilter(filter);
                String tfil = String.format("%s.tpf",TO.getTeamFileName());
                j.setSelectedFile(new File(tfil));
                int result = j.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    if(j.getSelectedFile().toString().contains(".tpf")) {
                        PC.setFilename(j.getSelectedFile().toString());
                    } else {
                        PC.setFilename(j.getSelectedFile().toString() + ".tpf");
                    }
                    try {
                        SS.storeTeamFile(PC.getFilename(),TO);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "STORE Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnSlutt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PC.cleanCash();
                System.exit(0);
            }
        });
    }

    public void getFile() {
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

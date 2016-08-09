/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binnaryencryption;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author user
 */
public class EncryptFileView extends JPanel {

    private static JLabel firstStatementLabel;
    private static JLabel secondStatementLabel;
    private static JLabel thirdStatmentLabel;
    private static JFileChooser selectAFileChooser;
    private static JButton selectAFileButton;
    private static JPanel filePropertiesPanel;
    private static JLabel fileNameLabel;
    private static JLabel fileNameLabelValueLabel;
    private static JLabel fileExtension;
    private static JLabel fileExtensionValueLabel;
    private static JLabel sizeBeforeEncryptionLabel;
    private static JLabel sizeBeforeEncryptionValueLabel;
    private static JLabel sizeAfterEncryptionLabel;
    private static JLabel sizeAfterEncryptionValueLabel;
    private static JLabel locationLabel;
    private static JLabel locationValueLabel;
    private static JButton encryptButton;
    private static JButton cancelButton;
    private static JButton chooseADifferentFileButton;
    private static JLabel chosenFileImageIcon;
    private static JLabel fileNameAndExtensionLabel;
    private static File fileName;

    public EncryptFileView() {

        setSize(600, 600);
        setLocation(0, 0);
        setBackground(Color.white);
        setLayout(null);
        setBorder(new LineBorder(Color.decode("#1e90ff")));

        firstStatementLabel = new JLabel("Alpha crypto: Helps you easily encrypt your ");
        secondStatementLabel = new JLabel("important files with no hustle.");
        thirdStatmentLabel = new JLabel("Get started by ");
        selectAFileButton = new JButton("selecting a file.");
        selectAFileChooser = new JFileChooser();
        filePropertiesPanel = new JPanel(null);
        fileNameLabel = new JLabel("File Name:");
        fileNameLabelValueLabel = new JLabel("");
        fileExtension = new JLabel("Extension:");
        fileExtensionValueLabel = new JLabel("");
        sizeBeforeEncryptionValueLabel = new JLabel("");
        sizeBeforeEncryptionLabel = new JLabel("Size before encryption:");
        sizeAfterEncryptionLabel = new JLabel("Size after encryption:");
        sizeAfterEncryptionValueLabel = new JLabel("");
        locationLabel = new JLabel("File Location:");
        locationValueLabel = new JLabel("\\file\\path\\name.extension");
        encryptButton = new JButton("Encrypt");
        cancelButton = new JButton("Exit");
        chooseADifferentFileButton = new JButton("Choose a different File");
        fileNameAndExtensionLabel = new JLabel("");

        chosenFileImageIcon = new JLabel(new ImageIcon("C:\\Users\\user\\Documents\\"
                + "NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\receiptsTrials.PNG"));

        List<JLabel> statements = Arrays.asList(
                firstStatementLabel, secondStatementLabel, thirdStatmentLabel,
                fileNameAndExtensionLabel
        );

        List<JLabel> inlineFilePropertiesStatement = Arrays.asList(
                fileNameLabel, sizeAfterEncryptionLabel, sizeBeforeEncryptionLabel, locationLabel, fileExtension
        );

        List<JLabel> inlineTextValueStatements = Arrays.asList(
                fileNameLabelValueLabel, fileExtensionValueLabel, sizeAfterEncryptionValueLabel,
                sizeBeforeEncryptionValueLabel, locationValueLabel
        );

        firstStatementLabel.setBounds(10, 5, 400, 25);
        secondStatementLabel.setBounds(10, 30, 400, 25);
        thirdStatmentLabel.setBounds(10, 60, 400, 25);
        selectAFileButton.setBounds(105, 60, 100, 25);
        filePropertiesPanel.setBounds(10, 90, 400, 300);
        encryptButton.setBounds(50, 400, 150, 35);
        cancelButton.setBounds(230, 400, 150, 35);
        chooseADifferentFileButton.setBounds(120, 460, 200, 35);
        chosenFileImageIcon.setBounds(400, 150, 250, 120);
        fileNameAndExtensionLabel.setBounds(440, 270, 200, 25);
        fileNameLabel.setBounds(5, 10, 100, 25);
        fileNameLabelValueLabel.setBounds(80, 10, 300, 25);
        fileExtension.setBounds(5, 40, 200, 25);
        fileExtensionValueLabel.setBounds(80, 40, 300, 25);
        sizeBeforeEncryptionLabel.setBounds(5, 70, 200, 25);
        sizeBeforeEncryptionValueLabel.setBounds(160, 70, 200, 25);
        sizeAfterEncryptionLabel.setBounds(5, 100, 200, 25);
        sizeAfterEncryptionValueLabel.setBounds(145, 100, 200, 25);
        locationLabel.setBounds(5, 130, 200, 25);
        locationValueLabel.setBounds(100, 130, 300, 25);

        setTextProperties(statements);
        setInlineTextProperties(inlineFilePropertiesStatement);
        setInlineTextValuesProperties(inlineTextValueStatements);

        filePropertiesPanel.setBorder(new LineBorder(Color.decode("#696969")));
        filePropertiesPanel.setBackground(Color.white);
        encryptButton.setForeground(Color.white);
        encryptButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        cancelButton.setForeground(Color.white);
        cancelButton.setBorder(new LineBorder(Color.red));
        chooseADifferentFileButton.setForeground(Color.white);
        chooseADifferentFileButton.setBorder(new LineBorder(Color.decode("#32cd32")));
        cancelButton.setBackground(Color.red);
        chooseADifferentFileButton.setBackground(Color.decode("#32cd32"));
        encryptButton.setBackground(Color.decode("#1E90FF"));
        selectAFileButton.setBackground(Color.white);
        selectAFileButton.setBorder(new LineBorder(Color.white));
        selectAFileButton.setForeground(Color.decode("#1e90ff"));

        selectAFileButton.addActionListener(e -> {
            selectAFileChooser.showDialog(filePropertiesPanel, "Choose File To Encrypt");
            fileName = selectAFileChooser.getSelectedFile();
            try {

                if (fileName.getName().endsWith(".pdf")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\Screenshot (1803).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".pdf");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".txt")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\Screenshot (1806).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".txt");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".mp4") || fileName.getName().endsWith(".mkv")
                        || fileName.getName().endsWith(".mp3")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\Screenshot (1804).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".mp4");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".docx") || fileName.getName().endsWith(".doc")) {
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\Screenshot (1807).png"));
                    fileExtensionValueLabel.setText(".docx");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown File Extension type", "Windows Cryptomax", JOptionPane.ERROR_MESSAGE);
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\receiptsTrials.PNG"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileNameAndExtensionLabel.setText("unknown File");
                    fileExtensionValueLabel.setText("unknown");
                }

                locationValueLabel.setText(fileName.getPath());
                fileNameLabelValueLabel.setText(fileName.getName());
                sizeBeforeEncryptionValueLabel.setText("" + fileName.getTotalSpace());

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.",
                        "Binnary Encryptor", JOptionPane.WARNING_MESSAGE);
            }

        });

        encryptButton.addActionListener(e -> {
            try {
               // String path = selectAFileChooser.getSelectedFile().getPath();

                //  File output = new File("C:\\Users\\user\\Desktop\\test1.txt");
                // writeEncryptedBinarryDigitsToFile();
                readFileContents();

                JOptionPane.showMessageDialog(null, "File Encryption in progress...", ""
                        + "Binnary Encryptor", JOptionPane.INFORMATION_MESSAGE);

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.", ""
                        + "Binnary Encryptor", JOptionPane.WARNING_MESSAGE);
            }

        });

        chooseADifferentFileButton.addActionListener((ActionEvent e) -> {
            selectAFileChooser.showDialog(filePropertiesPanel, "Choose File To Encrypt");
            fileName = selectAFileChooser.getSelectedFile();
            try {

                if (fileName.getName().endsWith(".pdf")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\Screenshot (1803).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".pdf");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".txt")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\Screenshot (1806).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".txt");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".mp4") || fileName.getName().endsWith(".mkv")
                        || fileName.getName().endsWith(".mp3")) {
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\Screenshot (1804).png"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileExtensionValueLabel.setText(".mp4");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else if (fileName.getName().endsWith(".docx") || fileName.getName().endsWith(".doc")) {
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\Screenshot (1807).png"));
                    fileExtensionValueLabel.setText(".docx");
                    fileNameAndExtensionLabel.setText(fileName.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown File Extension type", "Windows Cryptomax", JOptionPane.ERROR_MESSAGE);
                    chosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\receiptsTrials.PNG"));
                    JOptionPane.showMessageDialog(null, "" + fileName.getPath());
                    fileNameAndExtensionLabel.setText("unknown File");
                    fileExtensionValueLabel.setText("unknown");
                }

                locationValueLabel.setText(fileName.getPath());
                fileNameLabelValueLabel.setText(fileName.getName());
                sizeBeforeEncryptionValueLabel.setText("" + fileName.getTotalSpace());

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.",
                        "Binnary Encryptor", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> initiateExitProtocol());

        add(chosenFileImageIcon);
        add(filePropertiesPanel);
        add(encryptButton);
        add(cancelButton);
        add(chooseADifferentFileButton);
        add(selectAFileButton);

        add(fileNameAndExtensionLabel);

        repaint();
        setVisible(true);

    }

    /**
     *Create a decoy file in the current directory
     * @return File object
     */
    public final File createADecoiFile() {
        File decoiFile = new File("decoid.txt");
        try {
            decoiFile.createNewFile();
            JOptionPane.showMessageDialog(fileExtension, "File creation was succefull...");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(filePropertiesPanel, e.getMessage());
        }
        
        return decoiFile;
    }

    public final void readFileContents() {
        //read file using path
        try {
            List<String> cipherTextLines = new ArrayList<>();
            List<String> plainTextLines = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\test1.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                plainTextLines.add(line);  // collection of lines of plainText
                String cipherText = BinnaryEncryption.generateBinnaryCipher(line); //execute hash function to get binnary
                cipherTextLines.add(cipherText); //collection of line of ciphertext in binnary
            }
            writeEncryptedBinarryDigitsToFile(cipherTextLines); //write the encryted content as the new contents of the file.
            plainTextLines.stream()
                    .forEach(e -> {
                        System.out.println(e);
                    });
            File decoyFile = createADecoiFile();
            writeBackUpDataToDecoid(plainTextLines,decoyFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        }

    }

    public final void writeBackUpDataToDecoid(List<String> backUpData, File decoidFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(decoidFile));

            backUpData.stream()
                    .forEach(e -> {
                        try {
                            bufferedWriter.write(e);
                            bufferedWriter.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Write the binary digits to the encrypted file
     *
     * @param binnaryDigits
     */
    public final void writeEncryptedBinarryDigitsToFile(List<String> LinesOfEncryptedContent) {
        try {
            //setCursor(new Cursor(Cursor.WAIT_CURSOR));
            FileWriter writer = new FileWriter("C:\\Users\\user\\Desktop\\test1.txt");

            BufferedWriter b_writer = new BufferedWriter(writer);

            LinesOfEncryptedContent.stream()
                    .forEach(e -> {
                        try {
                            b_writer.write(e);
                            b_writer.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            b_writer.flush();

            b_writer.close();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Encryption failed" + ex.getMessage(), ""
                    + "Try again later", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(EncryptFileView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void setTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    add(e);

                });
    }

    public final void setInlineTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    filePropertiesPanel.add(e);

                });
    }

    public final void setInlineTextValuesProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.black);
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    filePropertiesPanel.add(e);

                });
    }

    public static void initiateExitProtocol() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Binnary Encryptor", JOptionPane.INFORMATION_MESSAGE);
        switch (option) {
            case JOptionPane.NO_OPTION:
                //do nothing
                break;
            case JOptionPane.CANCEL_OPTION:
                //do nothing
                break;
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(filePropertiesPanel, "An unexpected error occured.", "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

}

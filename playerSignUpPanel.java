
import java.awt.CardLayout;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Evome
 */
public class playerSignUpPanel extends javax.swing.JPanel {

    PlayerSignUp signUp;

    /**
     * Creates new form playerSignUpPanel
     */
    public playerSignUpPanel() {
        initComponents();
        signUp = new PlayerSignUp();
        if (signUp.players == null) { // if players are not successfully retrieved
            JOptionPane.showMessageDialog(null, "Failed to retrieve players from player_log.txt", "File Reading Error", JOptionPane.ERROR_MESSAGE);
            CardLayout card = (CardLayout) this.getParent().getLayout();
            card.show(this.getParent(), "mainMenu");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        displayButton.setText("Display Players");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });

        signUpButton.setText("Sign Up Player");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove Player");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleLabel.setText("Player Sign-Up");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpButton)
                            .addComponent(displayButton)
                            .addComponent(removeButton)
                            .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titleLabel)
                .addGap(29, 29, 29)
                .addComponent(displayButton)
                .addGap(18, 18, 18)
                .addComponent(signUpButton)
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(18, 18, 18)
                .addComponent(returnButton)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        PlayerIO.updateUsers(signUp.players); // update user list to player_log.txt
        JOptionPane.showMessageDialog(null, "Player list saved to player_log.txt", "Save", JOptionPane.INFORMATION_MESSAGE);
        CardLayout card = (CardLayout) this.getParent().getLayout();
        card.show(this.getParent(), "mainMenu");
    }//GEN-LAST:event_returnButtonActionPerformed

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, signUp.getPlayerList(), "Player List", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_displayButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter name of new player:", "Sign-up", JOptionPane.QUESTION_MESSAGE); // show user text box for student to search
            if (input != null) {
                if (!input.isBlank()) { // if a valid name is entered
                    input = input.trim();
                    if (!signUp.players.containsKey(input)) { // if player does not already exist in list
                        signUp.players.put(input, 0); // add new player to list with zero wins
                        JOptionPane.showMessageDialog(null, input + " was successfully added", "Sign-up", JOptionPane.INFORMATION_MESSAGE); // show message with the student name and their mark
                    } else { // if player already exists, do nothing
                        JOptionPane.showMessageDialog(null, input + " already exists", "Sign-up", JOptionPane.WARNING_MESSAGE); // show message with the student name and their mark
                    }
                    break;
                } else { // if name is blank
                    JOptionPane.showMessageDialog(null, "Please enter a valid name", "Sign-up", JOptionPane.WARNING_MESSAGE); // show message with the student name and their mark
                }
            } else {
                break;
            }
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter name of player you wish to remove:", "Remove", JOptionPane.QUESTION_MESSAGE); // show user text box for student to search
            if (input != null) {
                if (!input.isBlank()) { // if a valid name is entered
                    input = input.trim();
                    if (signUp.players.containsKey(input)) { // if player does not already exist in list
                        signUp.players.keySet().remove(input); // add new player to list with zero wins
                        JOptionPane.showMessageDialog(null, input + " successfully removed", "Remove", JOptionPane.INFORMATION_MESSAGE); // show message with the student name and their mark
                    } else { // if player already exists, do nothing
                        JOptionPane.showMessageDialog(null, input + " cannot be found", "Remove", JOptionPane.WARNING_MESSAGE); // show message with the student name and their mark
                    }
                    break;
                } else { // if name is blank
                    JOptionPane.showMessageDialog(null, "Please enter a valid name", "Remove", JOptionPane.WARNING_MESSAGE); // show message with the student name and their mark
                }
            } else {
                break;
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displayButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

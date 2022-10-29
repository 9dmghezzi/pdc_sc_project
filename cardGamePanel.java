
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Evome
 */
public class cardGamePanel extends javax.swing.JPanel {

    GoFish goFishGame;
    PlayerSignUpCUI signUp;
    DefaultComboBoxModel playerNamesModel;

    /**
     * Creates new form cardGamePanel
     */
    public cardGamePanel() {
        signUp = new PlayerSignUpCUI();
        if (signUp.players == null) { // if players are not successfully retrieved
            JOptionPane.showMessageDialog(this, "Failed to retrieve players from player_log.txt", "File Reading Error", JOptionPane.ERROR_MESSAGE);
            CardLayout card = (CardLayout) this.getParent().getLayout();
            card.show(this.getParent(), "mainMenu");
        } else {
            playerNamesModel = new DefaultComboBoxModel(signUp.players.keySet().toArray()); // get array of player names
        }

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        generalPanel = new javax.swing.JPanel();
        numPlayerPanel = new javax.swing.JPanel();
        numPlayerSlider = new javax.swing.JSlider();
        numPlayerButton = new javax.swing.JButton();
        numPlayerLabel = new javax.swing.JLabel();
        numPlayerSliderLabel = new javax.swing.JLabel();
        loadButton = new javax.swing.JButton();
        playerNamePanel = new javax.swing.JPanel();
        playerNameGrid = new javax.swing.JPanel();
        playerNameLabel1 = new javax.swing.JLabel();
        playerNameComboBox1 = new javax.swing.JComboBox<>();
        playerNameLabel2 = new javax.swing.JLabel();
        playerNameComboBox2 = new javax.swing.JComboBox<>();
        playerNameLabel3 = new javax.swing.JLabel();
        playerNameComboBox3 = new javax.swing.JComboBox<>();
        playerNameLabel4 = new javax.swing.JLabel();
        playerNameComboBox4 = new javax.swing.JComboBox<>();
        playerNameLabel5 = new javax.swing.JLabel();
        playerNameComboBox5 = new javax.swing.JComboBox<>();
        playerNameButton = new javax.swing.JButton();
        gamePanel = new javax.swing.JPanel();
        cardComboBox = new javax.swing.JComboBox<>();
        opponentComboBox = new javax.swing.JComboBox<>();
        currentPlayerLabel = new javax.swing.JLabel();
        StaticPlayerLabel = new javax.swing.JLabel();
        staticFishCardLabel = new javax.swing.JLabel();
        staticFishPlayerLabel = new javax.swing.JLabel();
        FishButton = new javax.swing.JButton();
        gamePanelSeparator = new javax.swing.JSeparator();
        staticHandLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentHandList = new javax.swing.JList<>();
        currentBooksLabel = new javax.swing.JLabel();
        staticBookLabel = new javax.swing.JLabel();
        mainMenuButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("Go Fish Game");

        generalPanel.setLayout(new java.awt.CardLayout());

        numPlayerSlider.setMaximum(5);
        numPlayerSlider.setMinimum(2);
        numPlayerSlider.setPaintLabels(true);
        numPlayerSlider.setSnapToTicks(true);
        numPlayerSlider.setToolTipText("");
        numPlayerSlider.setValue(2);
        numPlayerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPlayerSliderStateChanged(evt);
            }
        });

        numPlayerButton.setText("Confirm");
        numPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayerButtonActionPerformed(evt);
            }
        });

        numPlayerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numPlayerLabel.setText("How many players?");
        numPlayerLabel.setToolTipText("");

        numPlayerSliderLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numPlayerSliderLabel.setText(""+numPlayerSlider.getValue());

        loadButton.setText("Load Game");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numPlayerPanelLayout = new javax.swing.GroupLayout(numPlayerPanel);
        numPlayerPanel.setLayout(numPlayerPanelLayout);
        numPlayerPanelLayout.setHorizontalGroup(
            numPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numPlayerPanelLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(numPlayerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numPlayerSliderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(numPlayerPanelLayout.createSequentialGroup()
                .addGroup(numPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(numPlayerPanelLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(numPlayerButton))
                    .addGroup(numPlayerPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(numPlayerLabel))
                    .addGroup(numPlayerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        numPlayerPanelLayout.setVerticalGroup(
            numPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numPlayerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadButton)
                .addGap(44, 44, 44)
                .addComponent(numPlayerLabel)
                .addGap(18, 18, 18)
                .addGroup(numPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPlayerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numPlayerSliderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numPlayerButton)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        generalPanel.add(numPlayerPanel, "numPlayer");

        playerNameGrid.setLayout(new java.awt.GridLayout(5, 2));

        playerNameLabel1.setText("Player 1 Name:");
        playerNameGrid.add(playerNameLabel1);

        playerNameComboBox1.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox1.setEnabled(false);
        playerNameGrid.add(playerNameComboBox1);

        playerNameLabel2.setText("Player 2 Name:");
        playerNameGrid.add(playerNameLabel2);

        playerNameComboBox2.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox2.setEnabled(false);
        playerNameGrid.add(playerNameComboBox2);

        playerNameLabel3.setText("Player 3 Name:");
        playerNameGrid.add(playerNameLabel3);

        playerNameComboBox3.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox3.setEnabled(false);
        playerNameGrid.add(playerNameComboBox3);

        playerNameLabel4.setText("Player 4 Name:");
        playerNameGrid.add(playerNameLabel4);

        playerNameComboBox4.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox4.setEnabled(false);
        playerNameGrid.add(playerNameComboBox4);

        playerNameLabel5.setText("Player 5 Name:");
        playerNameGrid.add(playerNameLabel5);

        playerNameComboBox5.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox5.setEnabled(false);
        playerNameGrid.add(playerNameComboBox5);

        playerNameButton.setText("Confirm");
        playerNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerNamePanelLayout = new javax.swing.GroupLayout(playerNamePanel);
        playerNamePanel.setLayout(playerNamePanelLayout);
        playerNamePanelLayout.setHorizontalGroup(
            playerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerNamePanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(playerNameButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerNameGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        playerNamePanelLayout.setVerticalGroup(
            playerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerNamePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(playerNameGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerNameButton)
                .addGap(17, 17, 17))
        );

        generalPanel.add(playerNamePanel, "playerName");

        currentPlayerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        currentPlayerLabel.setText("name");

        StaticPlayerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StaticPlayerLabel.setText("Current Player Turn:");

        staticFishCardLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staticFishCardLabel.setText("Fish for Card:");

        staticFishPlayerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staticFishPlayerLabel.setText("Fish From Player:");

        FishButton.setText("Fish!");
        FishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FishButtonActionPerformed(evt);
            }
        });

        staticHandLabel.setText("Current Hand:");

        currentHandList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(currentHandList);

        currentBooksLabel.setText("0");

        staticBookLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staticBookLabel.setText("Books:");

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(FishButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gamePanelSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(StaticPlayerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentPlayerLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gamePanelLayout.createSequentialGroup()
                                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(staticHandLabel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(gamePanelLayout.createSequentialGroup()
                                .addComponent(staticBookLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentBooksLabel)))))
                .addContainerGap())
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staticFishPlayerLabel)
                    .addComponent(staticFishCardLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opponentComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaticPlayerLabel)
                    .addComponent(currentPlayerLabel)
                    .addComponent(currentBooksLabel)
                    .addComponent(staticBookLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staticHandLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gamePanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staticFishCardLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opponentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staticFishPlayerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FishButton)
                .addGap(30, 30, 30))
        );

        generalPanel.add(gamePanel, "game");

        mainMenuButton.setLabel("Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save Game");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(saveButton)
                        .addGap(20, 20, 20)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenuButton)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(mainMenuButton)
                    .addComponent(saveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numPlayerSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPlayerSliderStateChanged
        // TODO add your handling code here:
        numPlayerSliderLabel.setText("" + numPlayerSlider.getValue());

        playerNameComboBox1.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox2.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox3.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox4.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
        playerNameComboBox5.setModel(new DefaultComboBoxModel(signUp.players.keySet().toArray()));
    }//GEN-LAST:event_numPlayerSliderStateChanged

    private void numPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayerButtonActionPerformed
        // TODO add your handling code here:
        switch (numPlayerSlider.getValue()) {
            case 2 -> {
                playerNameComboBox1.setEnabled(true);
                playerNameComboBox2.setEnabled(true);
            }
            case 3 -> {
                playerNameComboBox1.setEnabled(true);
                playerNameComboBox2.setEnabled(true);
                playerNameComboBox3.setEnabled(true);
            }
            case 4 -> {
                playerNameComboBox1.setEnabled(true);
                playerNameComboBox2.setEnabled(true);
                playerNameComboBox3.setEnabled(true);
                playerNameComboBox4.setEnabled(true);
            }
            case 5 -> {
                playerNameComboBox1.setEnabled(true);
                playerNameComboBox2.setEnabled(true);
                playerNameComboBox3.setEnabled(true);
                playerNameComboBox4.setEnabled(true);
                playerNameComboBox5.setEnabled(true);
            }
        }
        CardLayout card = (CardLayout) generalPanel.getLayout();
        card.show(generalPanel, "playerName");
    }//GEN-LAST:event_numPlayerButtonActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) generalPanel.getLayout();
        card.show(generalPanel, "numPlayer");
        card = (CardLayout) this.getParent().getLayout();
        card.show(this.getParent(), "mainMenu");
        saveButton.setEnabled(false);
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    private void playerNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Player> players = new ArrayList<>();
        switch (numPlayerSlider.getValue()) {
            case 2 -> {
                players.add(new GoFishPlayer(playerNameComboBox1.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox2.getSelectedItem().toString()));
            }
            case 3 -> {
                players.add(new GoFishPlayer(playerNameComboBox1.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox2.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox3.getSelectedItem().toString()));
            }
            case 4 -> {
                players.add(new GoFishPlayer(playerNameComboBox1.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox2.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox3.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox4.getSelectedItem().toString()));
            }
            case 5 -> {
                players.add(new GoFishPlayer(playerNameComboBox1.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox2.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox3.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox4.getSelectedItem().toString()));
                players.add(new GoFishPlayer(playerNameComboBox5.getSelectedItem().toString()));
            }
        }
        for (Player player : players) {
            player.setWins(signUp.players.get(player.getName()));
        }
        PlayerIO.checkForExistingUser(players); // check if enter user exists
        goFishGame = new GoFish(players);
        goFishGame.dealCards(); // deal cards to all players
        for (Player player : goFishGame.getPlayers()) { // for each player
            if (goFishGame.checkForBook(((GoFishPlayer) player))) { // check if a matching book was dealt to them
                JOptionPane.showMessageDialog(this, "Player " + goFishGame.getCurrentPlayerTurn() + " has collected a book of " + goFishGame.getDiscarded().checkTop().toString() + "s", "LUCKY!", JOptionPane.INFORMATION_MESSAGE);
            }
            goFishGame.nextPlayer();
        }
        currentHandList.setListData(goFishGame.getCurrentPlayerCardArray());
        currentPlayerLabel.setText(goFishGame.getCurrentPlayer().toString());
        currentBooksLabel.setText("" + ((GoFishPlayer) goFishGame.getCurrentPlayer()).getBooks());
        cardComboBox.setModel(new DefaultComboBoxModel(goFishGame.getCurrentPlayer().getHand().getCards().toArray()));
        opponentComboBox.setModel(new DefaultComboBoxModel(goFishGame.players.toArray()));
        saveButton.setEnabled(true);
        CardLayout card = (CardLayout) generalPanel.getLayout();
        card.show(generalPanel, "game");
    }//GEN-LAST:event_playerNameButtonActionPerformed

    private void FishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FishButtonActionPerformed
        // TODO add your handling code here:
        if (opponentComboBox.getSelectedItem().equals(goFishGame.getCurrentPlayer())) {
            JOptionPane.showMessageDialog(this, "Please choose a player other than yourself", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int oldCardCount = goFishGame.getCurrentPlayer().cardCount();
            if (goFishGame.fishFromPlayer((Player) opponentComboBox.getSelectedItem(), (Card) cardComboBox.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Caught " + (goFishGame.getCurrentPlayer().cardCount() - oldCardCount) + " " + cardComboBox.getSelectedItem().toString() + "s from player " + opponentComboBox.getSelectedItem().toString(), "Fish", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (goFishGame.getStock().getPile().empty()) {
                    JOptionPane.showMessageDialog(this, "Stock Pile is empty", "Go Fish!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    goFishGame.goFish();
                    JOptionPane.showMessageDialog(this, "Picked up " + goFishGame.getCurrentPlayer().getHand().getCards().get(goFishGame.getCurrentPlayer().cardCount() - 1).toString(), "Go Fish!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (goFishGame.checkForBook(goFishGame.getCurrentPlayer())) {
                JOptionPane.showMessageDialog(this, "Book of " + goFishGame.getDiscarded().getPile().peek().getRanking().toString() + "s has been collected\nYou now have " + ((GoFishPlayer) goFishGame.getCurrentPlayer()).getBooks() + " Books", "Book Collected!", JOptionPane.INFORMATION_MESSAGE);
            }
            goFishGame.nextPlayer(); // move onto next player
            currentHandList.setListData(goFishGame.getCurrentPlayerCardArray());
            currentPlayerLabel.setText(goFishGame.getCurrentPlayer().toString());
            currentBooksLabel.setText("" + ((GoFishPlayer) goFishGame.getCurrentPlayer()).getBooks());
            cardComboBox.setModel(new DefaultComboBoxModel(goFishGame.getCurrentPlayer().getHand().getCards().toArray()));
            opponentComboBox.setModel(new DefaultComboBoxModel(goFishGame.players.toArray()));
        }
    }//GEN-LAST:event_FishButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if (GameFileIO.saveGoFishGameState(goFishGame)) {
            JOptionPane.showMessageDialog(this, "Game Successfully Saved", "Save Game", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error Saving Game", "Save Game", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        goFishGame = GameFileIO.loadGoFishGameState();
        if (goFishGame == null) {
            JOptionPane.showMessageDialog(this, "Error Loading Game", "Load Game", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Game Successfully Loaded", "Load Game", JOptionPane.INFORMATION_MESSAGE);
            currentHandList.setListData(goFishGame.getCurrentPlayerCardArray());
            currentPlayerLabel.setText(goFishGame.getCurrentPlayer().toString());
            currentBooksLabel.setText("" + ((GoFishPlayer) goFishGame.getCurrentPlayer()).getBooks());
            cardComboBox.setModel(new DefaultComboBoxModel(goFishGame.getCurrentPlayer().getHand().getCards().toArray()));
            opponentComboBox.setModel(new DefaultComboBoxModel(goFishGame.players.toArray()));
            saveButton.setEnabled(true);
            CardLayout card = (CardLayout) generalPanel.getLayout();
            card.show(generalPanel, "game");
        }
    }//GEN-LAST:event_loadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FishButton;
    private javax.swing.JLabel StaticPlayerLabel;
    private javax.swing.JComboBox<String> cardComboBox;
    private javax.swing.JLabel currentBooksLabel;
    private javax.swing.JList<String> currentHandList;
    private javax.swing.JLabel currentPlayerLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JSeparator gamePanelSeparator;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton numPlayerButton;
    private javax.swing.JLabel numPlayerLabel;
    private javax.swing.JPanel numPlayerPanel;
    private javax.swing.JSlider numPlayerSlider;
    private javax.swing.JLabel numPlayerSliderLabel;
    private javax.swing.JComboBox<String> opponentComboBox;
    private javax.swing.JButton playerNameButton;
    private javax.swing.JComboBox<String> playerNameComboBox1;
    private javax.swing.JComboBox<String> playerNameComboBox2;
    private javax.swing.JComboBox<String> playerNameComboBox3;
    private javax.swing.JComboBox<String> playerNameComboBox4;
    private javax.swing.JComboBox<String> playerNameComboBox5;
    private javax.swing.JPanel playerNameGrid;
    private javax.swing.JLabel playerNameLabel1;
    private javax.swing.JLabel playerNameLabel2;
    private javax.swing.JLabel playerNameLabel3;
    private javax.swing.JLabel playerNameLabel4;
    private javax.swing.JLabel playerNameLabel5;
    private javax.swing.JPanel playerNamePanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel staticBookLabel;
    private javax.swing.JLabel staticFishCardLabel;
    private javax.swing.JLabel staticFishPlayerLabel;
    private javax.swing.JLabel staticHandLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

package moppydesk.ui;

import java.awt.Component;
import moppydesk.inputs.MoppySequencer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Transmitter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.Timer;
import moppydesk.*;

/**
 *
 * @author Sammy1Am
 */
public final class SequencerControls extends InputPanel implements MoppyStatusConsumer {

    MoppySequencer seq;
    MoppyControlWindow controlWindow;
    MoppyUI app;
    final JFileChooser sequenceChooser = new JFileChooser();
    Timer progressTimer;
    private boolean isConnected = false;
    private boolean fileLoaded = false;

    /**
     * Creates new form SequencerControls
     */
    public SequencerControls(MoppyUI app, MoppyControlWindow mcw, MoppySequencer newSequencer) {
        this.seq = newSequencer;
        this.app = app;
        this.controlWindow = mcw;

        initComponents();        
        
        progressTimer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateProgressDisplay();
            }
        });       
    }

    @Override
    public void loadPreferences() {
        ResetDrivesCB.setSelected(app.prefs.getBoolean(Constants.PREF_RESET_DRIVES, false));
        RepeatCB.setSelected(app.prefs.getBoolean(Constants.PREF_REPEAT_SEQ, false));
        DelayResetSpinner.setValue(app.prefs.getInt(Constants.PREF_DELAY_RESET, 0));
        DelayResetSpinner.setEnabled(ResetDrivesCB.isSelected());
    }
    
    @Override
    public void savePreferences() {
        app.prefs.putBoolean(Constants.PREF_RESET_DRIVES, ResetDrivesCB.isSelected());
        app.prefs.putBoolean(Constants.PREF_REPEAT_SEQ, RepeatCB.isSelected());
        app.prefs.putInt(Constants.PREF_DELAY_RESET, (Integer)DelayResetSpinner.getValue());                
    }
    
    private void updateProgressDisplay() {
        long currentSeconds = seq.getSecondsPosition();
        sequenceProgressSlider.setValue((int) (currentSeconds));
        String currentPosition = String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(currentSeconds),
                currentSeconds % 60);
        String totalPosition = String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(seq.getSecondsLength()),
                seq.getSecondsLength() % 60);
        currentPositionLabel.setText(currentPosition);
        totalPositionLabel.setText(totalPosition);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sequenceNameLabel = new javax.swing.JLabel();
        bpmLabel = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        sequenceProgressSlider = new javax.swing.JSlider();
        currentPositionLabel = new javax.swing.JLabel();
        totalPositionLabel = new javax.swing.JLabel();
        RepeatCB = new javax.swing.JCheckBox();
        ResetDrivesCB = new javax.swing.JCheckBox();
        DelayResetSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("Fichier MIDI:");

        sequenceNameLabel.setText("<Aucun fichier>");

        bpmLabel.setText(jSlider1.getValue() + " bpm");

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(310);
        jSlider1.setMinimum(20);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(120);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1tempoSliderChanged(evt);
            }
        });

        startButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        startButton.setText("Démarrer");
        startButton.setEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonClicked(evt);
            }
        });

        stopButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        stopButton.setText("Arreter/Reset");
        stopButton.setToolTipText("STOP !!");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonstopResetClicked(evt);
            }
        });

        loadButton.setText("Charger un fichier...");
        loadButton.setToolTipText("");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonloadSequence(evt);
            }
        });

        sequenceProgressSlider.setToolTipText("");
        sequenceProgressSlider.setValue(0);
        sequenceProgressSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sequenceProgressDragged(evt);
            }
        });
        sequenceProgressSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sequenceProgressDragged(evt);
            }
        });

        currentPositionLabel.setText("00:00");

        totalPositionLabel.setText("00:00");

        RepeatCB.setText("Loop");
        RepeatCB.setToolTipText("Boucle du MIDI");

        ResetDrivesCB.setText("Reset lecteurs");
        ResetDrivesCB.setToolTipText("RAZ Lecteurs");
        ResetDrivesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetDrivesCBActionPerformed(evt);
            }
        });

        DelayResetSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 600, 1));
        DelayResetSpinner.setToolTipText("Delais avant le reset quand la sequence est terminée.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Retard du reset:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(bpmLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(sequenceNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(loadButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DelayResetSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ResetDrivesCB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RepeatCB))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(currentPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(sequenceProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(totalPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loadButton)
                            .addComponent(sequenceNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bpmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(stopButton))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RepeatCB)
                    .addComponent(ResetDrivesCB)
                    .addComponent(DelayResetSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sequenceProgressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1tempoSliderChanged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1tempoSliderChanged
        JSlider s = (JSlider) evt.getSource();
        seq.setTempo(s.getValue());
        bpmLabel.setText(s.getValue() + " bpm");
    }//GEN-LAST:event_jSlider1tempoSliderChanged

    private void startButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonClicked
        if (startButton.getText().equals("Start")) {
            playSequencer();
        } else {
            pauseSequencer();
        }
    }//GEN-LAST:event_startButtonClicked

    private void playSequencer() {
        seq.startSequencer();
        seq.setTempo(jSlider1.getValue());
        controlWindow.setStatus("Joue!");
        startButton.setText("Pause");
    }

    private void pauseSequencer() {
        seq.stopSequencer();
        startButton.setText("Start");
        controlWindow.setStatus("...Pause");
    }

    private void stopResetSequencer() {
        if (seq.isRunning()) {
            stopSeq();
        } else {
            resetSeq();           
        }
        updateProgressDisplay(); // Always update the progress here in case we're not connected but want to reset the sequencer
    }
    
    private void stopSeq(){
        controlWindow.setStatus("Arrêt...");
            seq.stopSequencer();
            seq.resetSequencer();
            startButton.setText("Start");
            controlWindow.setStatus("Arrêté.");
    }
    
    private void resetSeq(){
        app.rm.reset();
            seq.resetSequencer();
            controlWindow.setStatus("RAZ."); 
    }

    private void stopButtonstopResetClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonstopResetClicked
        stopResetSequencer();
    }//GEN-LAST:event_stopButtonstopResetClicked

    private void loadButtonloadSequence(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonloadSequence
        String previouslyLoaded = app.prefs.get(Constants.PREF_LOADED_SEQ, null);
        if (previouslyLoaded != null) {
            sequenceChooser.setCurrentDirectory(new File(previouslyLoaded));
        }
        int returnVal = sequenceChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            loadSequenceFile(sequenceChooser.getSelectedFile());
        } else {
            //Cancelled
        }
    }//GEN-LAST:event_loadButtonloadSequence

    private void sequenceProgressDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sequenceProgressDragged
        int seconds = ((JSlider) evt.getSource()).getValue();
        seq.setSecondsPosition(seconds);
        currentPositionLabel.setText(String.format("%d:%02d",
                TimeUnit.SECONDS.toMinutes(seconds),
                seconds % 60));
    }//GEN-LAST:event_sequenceProgressDragged

    private void ResetDrivesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetDrivesCBActionPerformed
        DelayResetSpinner.setEnabled(ResetDrivesCB.isSelected());
    }//GEN-LAST:event_ResetDrivesCBActionPerformed

    @Override
    public void tempoChanged(int newTempo) {
        jSlider1.setValue(newTempo);
        bpmLabel.setText(newTempo + " bpm");
    }

    private void loadSequenceFile(File sequenceFile) {
        try {
            stopSeq();
            controlWindow.setStatus("Chargement du fichier...");
            seq.loadFile(sequenceFile.getPath());
            sequenceNameLabel.setText(sequenceFile.getName());
            sequenceProgressSlider.setMaximum((int) (seq.getSecondsLength()));
            app.prefs.put(Constants.PREF_LOADED_SEQ, sequenceFile.getPath());
            fileLoaded = true;
            controlWindow.setStatus("Chargé: " + sequenceFile.getName());
            updateProgressDisplay();
            if (isConnected) {
                startButton.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(MoppyControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            controlWindow.setStatus("Erreur MIDI!");
            JOptionPane.showMessageDialog(this.getRootPane(), ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner DelayResetSpinner;
    private javax.swing.JCheckBox RepeatCB;
    private javax.swing.JCheckBox ResetDrivesCB;
    private javax.swing.JLabel bpmLabel;
    private javax.swing.JLabel currentPositionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel sequenceNameLabel;
    private javax.swing.JSlider sequenceProgressSlider;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel totalPositionLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Transmitter getTransmitter() {
        return seq;
    }

    @Override
    public void connected() {
        progressTimer.start();
        isConnected = true;
        if (fileLoaded) {
            startButton.setEnabled(true);
        }        
    }

    @Override
    public void disconnected() {
        startButton.setEnabled(false);
        pauseSequencer();
        isConnected = false;
        progressTimer.stop();
        seq.setReceiver(null); //Clear receiver so there's no connection here.
    }

    //MrSolidSnake745: Simple use for the SequenceEnded event
    //Resets the sequence and drives if ResetDrivesCB is selected once the song has finished    
    @Override
    public void sequenceEnded() {  
        controlWindow.setStatus("MIDI terminé.");       
        app.rm.silence(); //In case there are any stuck notes, most likely from pooling, silence all receivers
        seq.resetSequencer();        
        startButton.setText("Start");
        if(ResetDrivesCB.isSelected()) {
            int y = ((Integer)DelayResetSpinner.getValue());
            if(y > 0) {
                try {
                    setEnabledAllControls(false); //Don't want users messing with controls while we delay                
                    controlWindow.setStatus("Attendez " + y + " secondes avant le reset...");
                    Thread.sleep(y * 1000); //Thread is sooooo sleepy...
                }
                catch(Exception x){}
                finally{setEnabledAllControls(true);}
            }            
            controlWindow.setStatus("RAZ!");
            app.rm.reset();
            controlWindow.setStatus("RAZ.");
        }
        if(RepeatCB.isSelected()) { playSequencer(); }
    }
    
    public void setEnabledAllControls(boolean value) {
        for (Component c : this.getComponents()) {c.setEnabled(value);}
    }

    // <editor-fold defaultstate="collapsed" desc="Key Events">  
    
    @Override
    public boolean enterKeyAction(KeyEvent e) { 
        //Simulate clicking start button
        startButtonClicked(null);
        return true;
    }

    @Override
    public boolean tabKeyAction(KeyEvent e) { 
        //Simulate clicking stop button
        stopButtonstopResetClicked(null);
        return true;
    }

    @Override
    public boolean upKeyAction(KeyEvent e) { 
        //Skip ahead 10 seconds                
        seq.stopSequencer();        
        long newPosition = seq.getSecondsPosition() + 10;
        if(newPosition > seq.getSecondsLength()) newPosition = seq.getSecondsLength();
        seq.setSecondsPosition(newPosition);        
        seq.startSequencer();
        return true;
    }

    @Override
    public boolean downKeyAction(KeyEvent e) { 
        //Go back 10 seconds         
        seq.stopSequencer();
        long newPosition = seq.getSecondsPosition() - 10;
        if(newPosition < 0) newPosition = 0;
        seq.setSecondsPosition(newPosition);        
        seq.startSequencer();
        return true;
    }
    
    // </editor-fold>           
}

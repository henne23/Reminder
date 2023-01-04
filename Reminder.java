/*
 *
 * @author hpieres
 * 
 * GUI created with Netbeans
 */

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reminder extends javax.swing.JFrame {
	
	boolean stop = false;
	
    /**
     * Creates new form Reminder
     */
    public Reminder() {
        initComponents();
    }

    private void initComponents() {

        timeToMsgLabel = new javax.swing.JLabel();
        minutesSlider = new javax.swing.JSlider();
        minutesLabel = new javax.swing.JLabel();
        remainingLabel = new javax.swing.JLabel();
        remainingMinLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        convertStartButton = new javax.swing.JButton();
        minutesTextField = new javax.swing.JTextField();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timeToMsgLabel.setText("Time to notification:");

        minutesSlider.setMaximum(600);
        minutesSlider.setMinimum(1);

        minutesTextField.addCaretListener(new TextListener());
        
        minutesLabel.setText("Minutes");

        remainingLabel.setText("Remaining time:");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Close");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        convertStartButton.setText("Convert time & start");
        convertStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertStartButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		stopButtonActionPerformed(evt);
        	}
        });

        // Automatic layout from Apache Netbeans
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeToMsgLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(minutesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(remainingLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(remainingMinLabel)))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(stopButton)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(convertStartButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(minutesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minutesLabel)))
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeToMsgLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minutesSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(minutesTextField)
                        .addComponent(minutesLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(remainingLabel)
                            .addComponent(remainingMinLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(convertStartButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(exitButton)
                    .addComponent(stopButton))
                .addContainerGap())
        );

        pack();
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private class TextListener implements CaretListener{

		@Override
		public void caretUpdate(CaretEvent e) {
			String s = minutesTextField.getText();
			s.trim();
			if(s.isEmpty() == false)
				try {
					minutesSlider.setValue(Integer.parseInt(s));
					if(Integer.parseInt(s) > 600) {
						JOptionPane.showMessageDialog(null, "No number bigger than 600.");
					}else if(Integer.parseInt(s) < 0)
						JOptionPane.showMessageDialog(null, "Please use a number greater than 0.");
				}catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Please only use numbers (between 0 & 600)");
				}
		}
    	
    }

    public void start() {
    	startButton.setEnabled(false);
    	convertStartButton.setEnabled(false);
    	
    	stopButton.setEnabled(true);
        setState(Frame.ICONIFIED);		// frame moves to the background
        
        final long start = System.currentTimeMillis();
        final long end = start + minutesSlider.getValue() * 60 * 1000;
        
        final Timer timer = new Timer(100, null);	
        timer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                long now = System.currentTimeMillis();
                if(stop) {
                	stop = false;
                	remainingMinLabel.setText("");
                	startButton.setEnabled(true);
                	convertStartButton.setEnabled(true);
                	setState(Frame.NORMAL);
                	timer.stop();
                	stopButton.setEnabled(false);
                }else if(now>=end){
                    remainingMinLabel.setText("");
                    startButton.setEnabled(true);
                    convertStartButton.setEnabled(true);
                    setState(Frame.NORMAL);			// frame moves back to the screen
                    setAlwaysOnTop(true);
                    int val = JOptionPane.showOptionDialog(null, "Did you drink anything recently?", "Reminder", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] {"OK",  "Again"}, "Again");
                    timer.stop();
                    stopButton.setEnabled(false);
                    if(val == JOptionPane.NO_OPTION) {
                       	start();			
                    }
                }else {
                    remainingMinLabel.setText((end-now)/1000+" Seconds");
                }
            }
        });	
        timer.start();
        
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        start();
    }

    private void stopButtonActionPerformed(ActionEvent evt) {
    	stop = true;
    }
    
    private void convertStartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            minutesSlider.setValue(Integer.parseInt(minutesTextField.getText()));
            start();
        }catch (NumberFormatException e){}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reminder nf = new Reminder();
                JRootPane rootPane = nf.getRootPane();
                minutesTextField.requestFocus();	
                rootPane.setDefaultButton(convertStartButton);
                stopButton.setEnabled(false);
                nf.setVisible(true);
            }
        });
    }

    private javax.swing.JButton exitButton;
    private static javax.swing.JButton convertStartButton;
    private static javax.swing.JButton stopButton;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JSlider minutesSlider;
    private static javax.swing.JTextField minutesTextField;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JLabel remainingMinLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel timeToMsgLabel;
}

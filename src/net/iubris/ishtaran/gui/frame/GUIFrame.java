package net.iubris.ishtaran.gui.frame;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.iubris.ishtaran.gui._di.annotations.GUIButtons;
import net.iubris.ishtaran.gui._di.annotations.JLabelGlobal;
import net.iubris.ishtaran.gui._di.annotations.JLabelRelative;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobal;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelative;
import net.iubris.ishtaran.gui._di.annotations.JTextAreaGlobal;

@Singleton
public class GUIFrame extends JFrame {

	private static final long serialVersionUID = 911459125402212299L;

//	private BerkeleyDBHelperManager berkeleyDBHelperManager;
	
	public static JFrame instance;

	@Inject
	public GUIFrame(
			@GUIButtons Set<JButton> buttons,
			@JTextAreaGlobal JTextArea jTextArea,
			@JLabelRelative JLabel jLabelRelative,
			@ProgressBarRelative JProgressBar jProgressBarRelative,
			@JLabelGlobal JLabel jLabelGlobal,
			@ProgressBarGlobal JProgressBar jProgressBarGlobal
//			,BerkeleyDBHelperManager berkeleyDBHelperManager
			) {
		super("TweetMining");
//		this.berkeleyDBHelperManager = berkeleyDBHelperManager;
		buildGUI(buttons, jTextArea, jLabelRelative, jProgressBarRelative, jLabelGlobal, jProgressBarGlobal);
		instance = this;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// here close db connections
//		berkeleyDBHelperManager.close();
		
		super.finalize();
	}
	
	public static JFrame getInstance() {
		return instance;
	}
	
	private void buildGUI(Collection<JButton> buttons, final JTextArea jTextArea, JLabel jLabelRelative, JProgressBar jProgressBarRelative, JLabel jLabelGlobal, JProgressBar jProgressBarGlobal) {
		super.pack();
		super.setLocationByPlatform(true);
		super.setVisible(true);
		super.requestFocus();

		super.setSize(800, 600); // sets the size of the window

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null); // centers on screen
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel extPanel = new JPanel(gridBagLayout);
//		JScrollPane extPanel = new JScrollPane(gridBagLayout);

		JPanel buttonPanel = new JPanel( new FlowLayout() );
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		for (JButton jButton : buttons) {
			jButton.setSize(20, 10);
			buttonPanel.add(jButton);
		}
		
		c.gridx = 0;
		int gridy = 0;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = gridy;
		extPanel.add(buttonPanel,c);
		
		c.gridy = ++gridy;
		extPanel.add(jLabelGlobal,c);
		
		c.gridy = ++gridy;
		extPanel.add(jProgressBarGlobal,c);
		
		c.gridy = ++gridy;
		extPanel.add(jLabelRelative,c);
		
		c.gridy = ++gridy;
		extPanel.add(jProgressBarRelative,c);

		
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBorder(BorderFactory.createEtchedBorder());
		jScrollPane.setViewportView(jTextArea);
		jScrollPane.setWheelScrollingEnabled(true);
		

		c.ipadx = 800;
		c.ipady = 450;
		c.gridy = ++gridy;
		c.fill = GridBagConstraints.VERTICAL;
		extPanel.add(jScrollPane,c);
		
		super.getContentPane().add(extPanel);
	}
}

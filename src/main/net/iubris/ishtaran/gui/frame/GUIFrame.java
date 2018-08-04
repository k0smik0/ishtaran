package net.iubris.ishtaran.gui.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.ScrollPaneConstants;

import net.iubris.ishtaran.gui._di.annotations.GUIButtons;
import net.iubris.ishtaran.gui._di.annotations.JLabelGlobal;
import net.iubris.ishtaran.gui._di.annotations.JLabelRelative;
import net.iubris.ishtaran.gui._di.annotations.JTextAreaGlobal;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobal;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelative;

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
			,String title
			) {
		super(title);
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

//		super.setSize(800, 600); // sets the size of the window
		int globalHeight = 600;
		int globalWidth = 800;
		super.setMinimumSize(new Dimension(globalWidth, globalHeight));

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null); // centers on screen
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		JPanel extPanel = new JPanel(gridBagLayout);
//		JScrollPane extPanel = new JScrollPane(gridBagLayout);

//		BasicHorizontalLayoutManager buttonsLayout = new BasicHorizontalLayoutManager();
//		springLayout.
		GridLayout buttonsLayout = new GridLayout(Math.floorDiv(buttons.size(), 1), 2, 2, 2);
//		buttonsLayout.
//		FlowLayout flowLayout = new FlowLayout();
//		flowLayout.setAlignOnBaseline(false);
//		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel buttonPanel = new JPanel( 
//				new FlowLayout(FlowLayout.CENTER,10,1)
				buttonsLayout
//				flowLayout
				);
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		int buttonWidth = 30;
		for (JButton button : buttons) {
			button.setSize(10, buttonWidth);
			buttonPanel.add(button);
		}
		Dimension buttonPanelDimension = new Dimension(600, buttonWidth*buttons.size() );
		buttonPanel.setMinimumSize( buttonPanelDimension );
		
		
		gridBagConstraints.gridx = 0;
		int gridy = 0;
		
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		gridBagConstraints.gridx = gridy;
		extPanel.add(buttonPanel,gridBagConstraints);
		
		gridBagConstraints.gridy = ++gridy;
		extPanel.add(jLabelGlobal,gridBagConstraints);
		
		gridBagConstraints.gridy = ++gridy;
		extPanel.add(jProgressBarGlobal,gridBagConstraints);
		
		gridBagConstraints.gridy = ++gridy;
		extPanel.add(jLabelRelative,gridBagConstraints);
		
		gridBagConstraints.gridy = ++gridy;
		extPanel.add(jProgressBarRelative,gridBagConstraints);

		
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
//		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setWheelScrollingEnabled(true);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBorder(BorderFactory.createEtchedBorder());
		jScrollPane.setViewportView(jTextArea);
		jScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });

		
		gridBagConstraints.ipadx = (globalWidth-30);
		gridBagConstraints.ipady = (int) (globalHeight-buttonPanelDimension.getHeight()-120);
		gridBagConstraints.gridy = ++gridy;
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		extPanel.add(jScrollPane,gridBagConstraints);
		
		super.getContentPane().add(extPanel);
	}
}

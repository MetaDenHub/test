package AppPackage;

import java.awt.DisplayMode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JLabel;
import java.awt.Font;

public class MP3PlayerGUI {

	public static int count;
	private JFrame frame;
	private JButton btnStop;
	static JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MP3PlayerGUI window = new MP3PlayerGUI();
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
	public MP3PlayerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
				
		MainClass MC = new MainClass();
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MC.Resume();
				//MC.Play("D:\\kirill_komarov_-_111_(zf.fm).mp3");
			}
			
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 2;
		frame.getContentPane().add(btnStart, gbc_btnStart);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MC.Pause();
			}
		});
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPause.gridx = 1;
		gbc_btnPause.gridy = 2;
		frame.getContentPane().add(btnPause, gbc_btnPause);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MC.Stop();
			}
		});
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 2;
		gbc_btnStop.gridy = 2;
		frame.getContentPane().add(btnStop, gbc_btnStop);
		
		JButton btnSelectFile = new JButton("SelectFile");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
				
				JFileChooser chooser = new JFileChooser("D:\\");
				chooser.addChoosableFileFilter((javax.swing.filechooser.FileFilter) filter);
				
				int returnVal = chooser.showOpenDialog(null);
				
				if (returnVal == JFileChooser.APPROVE_OPTION){
					File myFile = chooser.getSelectedFile();
					String song = myFile + "";
					
					String name = chooser.getSelectedFile().getName();
					lblNewLabel.setText(name);
					MC.Play(song);
				}
			}
		});
		GridBagConstraints gbc_btnSelectFile = new GridBagConstraints();
		gbc_btnSelectFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelectFile.gridx = 3;
		gbc_btnSelectFile.gridy = 2;
		frame.getContentPane().add(btnSelectFile, gbc_btnSelectFile);
		
		JButton btnForever = new JButton("Forever");
		btnForever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(count)
				{
					case 0:
						count = 1;
						System.out.println(count);
						break;
					case 1:
						count = 0;
						System.out.println(count);
						break;
				}
			}
		});
		GridBagConstraints gbc_btnForever = new GridBagConstraints();
		gbc_btnForever.insets = new Insets(0, 0, 0, 5);
		gbc_btnForever.gridx = 0;
		gbc_btnForever.gridy = 3;
		frame.getContentPane().add(btnForever, gbc_btnForever);
	}

	public JButton getBtnStop() {
		return btnStop;
	}
	public static JLabel getLblNewLabel() {
		return lblNewLabel;
	}
}

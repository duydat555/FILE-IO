package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.desktop.OpenFilesEvent;

public class NOTEPAD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected Component frame;
	private TextArea textArea;
	 private File file;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NOTEPAD frame = new NOTEPAD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NOTEPAD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 946, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("FILE");
		menuBar.add(mnNewMenu);
		JFileChooser chooser = new JFileChooser();
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mở file");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    // do something
                	 file = chooser.getSelectedFile();
     
                	readFile(file);
                	
                }
				
			}

		

			private void readFile(File file) {
				// TODO Auto-generated method stub
				try (BufferedReader br  =new BufferedReader(new FileReader(file))) {
					textArea.setText(" ");
					String line;
					while ((line = br.readLine()) != null) {
						textArea.append(line+ "\n");
						br.close();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lưu đề file");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(e -> saveToFile());
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lưu file");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					 file = chooser.getSelectedFile();
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
						bw.write(textArea.getText());
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
				}
			}
		});
		textArea = new TextArea();
		textArea.setBounds(10, 28, 936, 499);
		contentPane.add(textArea);
		
		
	}

	private void saveToFile() {
	    if (file != null) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
	            bw.write(textArea.getText());
	            bw.flush(); 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



	

	
}

package ru.ulstu.vt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Lab8GUI {

	private JFrame frame;
	private static JTextField txtBookName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private static JTextField txtAuthor;
	private static JTextField txtIsdat;
	private static JTextField txtCollStr;
	private JButton leftButton;
	private JButton rightButton;
	private static List<String []> lst = new ArrayList<String[]>();
	private static int ARRAY_NUMBER= 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab8GUI window = new Lab8GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		lst.add(new String[] {"Последний день","Маслов Е.С.","Общага","999"});
		lst.add(new String[] {"Как поссорить всех и вся","Винтерман","Печатная машинка","800"});
		lst.add(new String[] {"Изучение Java","Гоголь","Скотный двор","3451"});
		lst.add(new String[] {"1000 и 1 способ страдать","Жизнь","Адам и Ева","10100"});
		lst.add(new String[] {"Вопросы на ночь","Анатоль Толя","Кровать по соседству","314"});
		
		
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(4000);	
					Open(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		 
	}
	
	public static void Open(int index) {
	String arr[] = lst.get(index);
	txtBookName.setText(arr[0]);
	txtAuthor.setText(arr[1]);
	txtIsdat.setText(arr[2]);
	txtCollStr.setText(arr[3]);
	
	}

	/**
	 * Create the application.
	 */
	public Lab8GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u043A\u043D\u0438\u0433\u0438: ");
		lblNewLabel.setBounds(48, 14, 123, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(204, 14, 182, 20);
		frame.getContentPane().add(txtBookName);
		txtBookName.setColumns(10);
		
		label = new JLabel("\u0410\u0432\u0442\u043E\u0440: ");
		label.setBounds(48, 52, 123, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("\u0418\u0437\u0434\u0430\u0442\u0435\u043B\u044C\u0441\u0442\u0432\u043E: ");
		label_1.setBounds(48, 94, 123, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u0412\u0441\u0435\u0433\u043E \u0441\u0442\u0440\u0430\u043D\u0438\u0446: ");
		label_2.setBounds(48, 131, 123, 14);
		frame.getContentPane().add(label_2);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(204, 52, 182, 20);
		frame.getContentPane().add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtIsdat = new JTextField();
		txtIsdat.setBounds(204, 94, 182, 20);
		frame.getContentPane().add(txtIsdat);
		txtIsdat.setColumns(10);
		
		txtCollStr = new JTextField();
		txtCollStr.setBounds(204, 131, 182, 20);
		frame.getContentPane().add(txtCollStr);
		txtCollStr.setColumns(10);
		
		JButton redButton = new JButton("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] arr1 = new String[] {txtBookName.getText(),txtAuthor.getText(), txtIsdat.getText(), txtCollStr.getText()};
				
				lst.set(ARRAY_NUMBER,arr1);
			}
		});
		redButton.setBounds(300, 171, 132, 23);
		frame.getContentPane().add(redButton);
		
		JButton delButton = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lst.size()>1) {
				lst.remove(ARRAY_NUMBER);
				ARRAY_NUMBER=0;
				Open(0);}
			 else {
				txtBookName.setText("");
				txtAuthor.setText("");
				txtIsdat.setText("");
				txtCollStr.setText("");
			}}}
		);
		delButton.setBounds(300, 205, 132, 23);
		frame.getContentPane().add(delButton);
		
		JButton createButton = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] arr1 = new String[] {txtBookName.getText(),txtAuthor.getText(), txtIsdat.getText(), txtCollStr.getText()};
				ARRAY_NUMBER+=1;
				lst.add(arr1);
			}
		});
		createButton.setBounds(300, 239, 132, 23);
		frame.getContentPane().add(createButton);
		
		leftButton = new JButton("<<");
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ARRAY_NUMBER>0) {
					ARRAY_NUMBER-=1;
				    Open(ARRAY_NUMBER);
				}
			}
		});
		leftButton.setBounds(10, 239, 58, 23);
		frame.getContentPane().add(leftButton);
		
		rightButton = new JButton(">>");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ARRAY_NUMBER<lst.size()-1) {
					ARRAY_NUMBER+=1;
				    Open(ARRAY_NUMBER);
				}
			}
		});
		rightButton.setBounds(92, 239, 58, 23);
		frame.getContentPane().add(rightButton);
	}
}

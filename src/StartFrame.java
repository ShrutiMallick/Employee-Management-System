import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class StartFrame extends JFrame{

	JRadioButton btnadmin,btnuser;

	StartFrame(){
		super(" Start Frame ");
		setSize(500,100);
		setResizable(false);    //the resize option is greyed out
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		btnadmin=new JRadioButton("Admin");
		btnuser=new JRadioButton("General user");
		

		setLayout(new FlowLayout());//default centre
		add(btnadmin);
		add(btnuser);
		
		setLocationRelativeTo(null);   //y not setLayout(centre)?doubt
		setVisible(true);

		//navigation to add
		btnadmin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				HomeFrame h=new HomeFrame();
				dispose();//dispose the current frame
			}
	});

	//navigation to modify
	btnuser.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			ViewFrame v= new ViewFrame();
			dispose();//dispose the current frame
		}
	});

}


public static void main(String args[]){
			StartFrame h=new StartFrame();
	}

}



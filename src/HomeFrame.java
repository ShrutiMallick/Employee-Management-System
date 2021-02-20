import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class HomeFrame extends JFrame{

	JButton btnAdd,btnModify,btnDelete,btnView;

	HomeFrame(){
		super("  Home Frame  ");
		setSize(500,100);
		setResizable(false);    //the resize option is greyed out
				

		btnAdd=new JButton("Add");
		btnModify=new JButton("Modify");
		btnDelete=new JButton("Delete");
		btnView=new JButton("View");

		setLayout(new FlowLayout());//default centre
		add(btnAdd);
		add(btnModify);
		add(btnDelete);
		add(btnView);

		setLocationRelativeTo(null);   //y not setLayout(centre)?doubt
		setVisible(true);
		
		

		//navigation to add
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddFrame a = new AddFrame();
				dispose();//dispose the current frame
			}
	});

	//navigation to modify
	btnModify.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			ModifyFrame f = new ModifyFrame();
			dispose();//dispose the current frame
		}
	});

	btnDelete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DeleteFrame d = new DeleteFrame();
			dispose();//dispose the current frame
		}

	});

	btnView.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			ViewFrame v= new ViewFrame();
			dispose();//dispose the current frame
		}

	});
	
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			StartFrame h= new StartFrame();
			dispose();
		}
	});

}


}



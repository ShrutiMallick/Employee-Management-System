import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.regex.*;
import java.sql.*;

import javax.swing.*;
class AddFrame extends JFrame{
	JPanel jp1,jp2;
	JLabel lbl1ID,lbl2Name,lbl3Dept,lbl4Sal;
	JTextField txtID,txtName,txtDept,txtSal;
	JButton btnSave,btnBack;

	AddFrame(){
	super("  Add Employee  ");
	setSize(600,150);
	setResizable(false);    //the resize option is greyed out

	jp1=new JPanel();
	jp1.setLayout(new FlowLayout());

	lbl1ID=new JLabel("ID");
	txtID=new JTextField(5);//that is 3 coloumns

	lbl2Name=new JLabel("Name");
	txtName=new JTextField(40);//that is 10 coloumns
	lbl3Dept=new JLabel("Department");
	txtDept=new JTextField(10);//that is 8 coloumns
	
	lbl4Sal=new JLabel("Salary");
	txtSal=new JTextField(5);//that is 5 coloumns	
	

	//now add all this to Jpane
	jp1.add(lbl1ID);
	jp1.add(txtID);
	jp1.add(lbl2Name);
	jp1.add(txtName);
	jp1.add(lbl3Dept);
	jp1.add(txtDept);
	jp1.add(lbl4Sal);
	jp1.add(txtSal);

	//now add the pane to frame
	add(jp1);

	jp2=new JPanel();
	jp2.setLayout(new FlowLayout());

	//save and back buttons

	btnSave=new JButton("Save");
	btnBack=new JButton("Back");

	jp2.add(btnSave);
	jp2.add(btnBack);

	add(jp2,BorderLayout.SOUTH);
	setLocationRelativeTo(null);   //SETS THE WHOLE FRAME AT CENTRE
	setVisible(true);

	//back button should take us back to homeframe
	btnBack.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)	{
			HomeFrame h= new HomeFrame();
			dispose();
		}
	});


	//close button also should take us back to homeframe
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			HomeFrame h= new HomeFrame();
			dispose();
		}
	});

	btnSave.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			int id=0;
			String name="";
			String dept="";
			double sal=0;

			//id validation
			try	{
				id=Integer.parseInt(txtID.getText());
			}//end try
			catch(NumberFormatException e)	{
				JOptionPane.showMessageDialog(new JDialog()," Invalid id ");
				//gets the focus back to id feild
				txtID.setText("");
				txtID.requestFocus();
				return;
			}//end catch

			//id validation.id less than 0
			if(id<=9999){
				JOptionPane.showMessageDialog(new JDialog()," Invalid id.ID should contain 5 digit ");
				txtID.setText("");
				txtID.requestFocus();
				return;
			}

			name=txtName.getText();
			dept=txtDept.getText();
			sal=Double.parseDouble(txtSal.getText());

			//name validation
			if(name.length()==0){
				JOptionPane.showMessageDialog(new JDialog()," Invalid name.Enter name ");
				txtName.setText("");
				txtName.requestFocus();
				return;
			}

			try	{
				if(!name.matches("[a-zA-Z0-9_.-]{3,}"))	{
					JOptionPane.showMessageDialog(new JDialog()," Invalid name. ");
					txtName.setText("");
					txtName.requestFocus();
					return;
				}
			}//end try
			catch(PatternSyntaxException pse)
			{
			}
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root"); 
			String q="insert into emp (id,name,department,salary) values (?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.setString(3, dept);
			pst.setDouble(4,sal);
			int i=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog()," 1 record added");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(new JDialog(),e);
		}		
			txtID.setText("");
			txtName.setText("");
			txtDept.setText("");
			txtSal.setText("");

			}

		});//end of btnsave actionhandler

	}
}



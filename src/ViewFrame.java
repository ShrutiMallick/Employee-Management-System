import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.regex.*;
import java.sql.*;


public class ViewFrame extends JFrame{
	JTextArea ta;
	JScrollPane sp1;

	ViewFrame(){
		super("  View all Employees  ");
		setSize(600,150);
		setResizable(false);    //the resize option is greyed out
		ta=new JTextArea(20,20);
		ta.setEditable(false);

		sp1=new JScrollPane(ta);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(sp1);


		setLocationRelativeTo(null);   //SETS THE WHOLE FRAME AT CENTRE
		setVisible(true);
		
		 addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					StartFrame h= new StartFrame();
					dispose();
				}
			});


		StringBuffer sb=new StringBuffer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
			String view="select * from emp order by id";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(view);
			sb.append("ID"+"\t"+"NAME"+"\t"+"DEPARMENT"+"\t"+"SALARY"+"\n");
			while(rs.next()){
			sb.append(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\n");
			}
			
			rs.close();
			String s=sb.toString();
			ta.setText(s);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(new JDialog()," "+e);
		}
	}
}
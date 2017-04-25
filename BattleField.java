package flyweight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BattleField extends JFrame
{
	ArrayList<Soldier>soldiers = new ArrayList<Soldier>();
	
	public BattleField()
	{
		Factory factory = new Factory();
		this.setTitle("BattleField");
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setLayout(null);
		
		JTextField defField = new JTextField();
		JTextField flyField = new JTextField();
		
		JButton defButton = new JButton("add soldiers using default");
		defButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = defField.getText();
				if(str!=null & str!="")
				{
					int n = Integer.parseInt(str);
					
					for(int i=0; i<n; i++)
					{
						soldiers.add(factory.getNewSoldierDefault());
					}
					double tm = System.nanoTime();
					//JOptionPane.showMessageDialog(null, "time: "+(System.nanoTime()-tm)/1000+" ms");
					System.out.println((System.nanoTime()-tm)/1000);
				}
			}
		});
		
		JButton flyButton = new JButton("add soldiers using fly weight");
		flyButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = flyField.getText();
				if(str!=null & str!="")
				{
					int n = Integer.parseInt(str);
					
					for(int i=0; i<n; i++)
					{
						factory.getNewSoldierFlyWeight();
					}
					double tm = System.nanoTime();
					//JOptionPane.showMessageDialog(null, "time: "+(System.nanoTime()-tm)/1000+" ms");
					System.out.println((System.nanoTime()-tm)/1000);
				}
			}
		});
		
		add(defField);
		add(flyField);
		add(defButton);
		add(flyButton);
		
		defField.setBounds(100, 20, 100, 30);
		flyField.setBounds(600, 20, 100, 30);
		defButton.setBounds(200, 20, 300, 30);
		flyButton.setBounds(700, 20, 300, 30);
		
		this.setVisible(true);		
	}
	public static void main(String [] args)
	{
		new BattleField();
	}
}

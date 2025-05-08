import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class Expt11_StopWatch extends JFrame implements ActionListener,Runnable
{
 JLabel disp;
 JButton btn,bt;
 boolean stop=false;
 int i,j,k,l;
 Container c;
 public Expt11_StopWatch()
 {
  disp=new JLabel();
  btn=new JButton("Start");
  bt=new JButton("Lap");
  disp.setFont(new Font("Helvetica",Font.PLAIN,20));
  disp.setBackground(Color.cyan);
  disp.setForeground(Color.red);
  c=getContentPane();
  c.setLayout(new FlowLayout());
  c.add(disp);
  c.add(bt);
  c.add(btn);
  bt.addActionListener(this);
  btn.addActionListener(this);
 }
 public void run()
 {
  for(i=0;;i++)
  {
   for(j=0;j< 60;j++)
   {
    for(k=0;k< 60;k++)
    {
     for(l=0;l< 100;l++)
     {
      while(stop)
      {
	try{Thread.sleep(1);}catch(Exception e){}
      }
      NumberFormat nf = new DecimalFormat("00");
      disp.setText(nf.format(i)+":"+nf.format(j)+":"+nf.format(k)+":"+nf.format(l));
      try{
       Thread.sleep(10);
      }catch(Exception e){}
     }
    }
   }
  }
 }
 public void actionPerformed(ActionEvent ae)
 {
  Thread t=new Thread(this);
  stop=true;
  //if(l==0&&i==0&&j==0&&k==0)
  
  if(ae.getActionCommand().equals("Start"))
  {
   stop=false;
   t.start();
   btn.setText("Stop");
  }
  else if(ae.getActionCommand().equals("Stop"))
  {
   stop=true;
   btn.setText("Start");
  }
  else if(ae.getActionCommand().equals("Lap"))
  {
      stop=false;
      NumberFormat nf = new DecimalFormat("00");
      c.add(new JLabel(nf.format(i)+":"+nf.format(j)+":"+nf.format(k)+":"+nf.format(l)));

  }
else{}
 }
 public static void main(String[] args) 
 {
  Expt11_StopWatch s=new Expt11_StopWatch();
  s.setSize(500,100);
  s.setVisible(true);
  s.setTitle("StopWatch");
  s.setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
}
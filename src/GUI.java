import org.jfree.chart.JFreeChart;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI implements ActionListener{
    JFrame f;
    JButton b1,b2,b3,b4,b5,b6,b7;
    ArrayList<ArrayList<Integer>> Sequence;
    XYLineChart_AWT chart;

    GUI(ArrayList<ArrayList<Integer>> sequence) {
        Sequence=sequence;
        f = new JFrame("Disk Scheduling");//creating instance of JFrame

        JLabel discklable = new JLabel("Disk Scheduling Algorithms");
        discklable.setBounds(250,50,250,30);
        f.add(discklable);


        b1 = new JButton("FCFS Algorithm");//creating instance of JButton
        b1.setBounds(200, 100, 250, 40);

        b2 = new JButton("SSTF Algorithm");//creating instance of JButton
        b2.setBounds(200, 160, 250, 40);

        b3 = new JButton("SCAN Algorithm");//creating instance of JButton
        b3.setBounds(200, 220, 250, 40);

        b4 = new JButton("C-SCAN Algorithm");//creating instance of JButton
        b4.setBounds(200, 280, 250, 40);

        b5 = new JButton("LOOK Algorithm");//creating instance of JButton
        b5.setBounds(200, 340, 250, 40);

        b6 = new JButton("C-LOOK Algorithm");//creating instance of JButton
        b6.setBounds(200, 400, 250, 40);

        b7 = new JButton("The newly optimized Algorithm");//creating instance of JButton
        b7.setBounds(200, 460, 250, 40);

        f.add(b1);//adding button in JFrame
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);

        f.setSize(600, 600);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            chart = new XYLineChart_AWT("Scheduling",
                        "FCFS Algorithm",Sequence.get(0));
                chart.pack( );
                RefineryUtilities.centerFrameOnScreen( chart );
                chart.setVisible( true );
        }
        else if(e.getSource()==b2)
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "SSTF Algorithm",Sequence.get(1));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
        else if(e.getSource()==b3)
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "SCAN Algorithm",Sequence.get(2));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
        else if(e.getSource()==b4)
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "C_SCAN Algorithm",Sequence.get(3));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
        else if(e.getSource()==b5)
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "LOOK Algorithm",Sequence.get(4));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
        else if(e.getSource()==b6)
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "C_LOOK Algorithm",Sequence.get(5));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
        else
        {
            chart = new XYLineChart_AWT("Scheduling",
                    "The newly optimized Algorithm",Sequence.get(6));
            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }
    }
}

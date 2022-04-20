import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Gui_Input extends JFrame implements ActionListener {
    ArrayList<Integer> devices=new ArrayList<>();

    public ArrayList<JTextField>jTextFields=new ArrayList<>();

    int counter=0, n =0, start =1;


    String label;
    JTextField TextFieldPanel1=new JTextField();
    JLabel jLabel;
    JPanel jPanel = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JTextArea jTextArea=new JTextArea();
    JScrollPane scrollPane1=new JScrollPane(jPanel2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


    Gui_Input() {
        Frame_Setting();
        this.add(setJPanel1());
    }

    JPanel setJPanel1() {
        jPanel.setLayout(null);
        jPanel.setSize(500,120);
        jPanel.setBounds(0,0,getWidth(),getHeight());
        label="Enter number of requests: ";
        jPanel.add(LabelSetting(label));
        jPanel.add(TextFieldSetting(TextFieldPanel1,40));
        jPanel.add(ButtonSetting(80));
        jPanel.setBackground(Color.gray);
        return jPanel;
    }
    void Frame_Setting() {
        this.setTitle("Disk Scheduling Algorithms");
        this.setSize(400, 400);
       this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocation(40, 100);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setForeground(Color.gray);
        this.setBackground(Color.gray);
    }

    JLabel LabelSetting(String LabelName) {
        Border Bevel = BorderFactory.createEtchedBorder();
        Border Bevel2=BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        Border Line=BorderFactory.createLineBorder(Color.magenta);
        jLabel = new JLabel(LabelName);
        jLabel.setBounds(0, 0, getWidth(), 30);
        jLabel.setForeground(Color.black);
        jLabel.setBackground(Color.YELLOW);
        jLabel.setOpaque(true);
        jLabel.setFont(new Font(jLabel.getFont().getName(), Font.ITALIC, 16));
        jLabel.setBorder(Bevel);
        return jLabel;
    }

    JLabel LabelSetting1(String LabelName) {
        JLabel jLabel1=new JLabel(LabelName);
        Border Bevel = BorderFactory.createEtchedBorder();
        jLabel1.setBounds(0, 0, getWidth(), 30);
        jLabel1.setForeground(Color.white);
        jLabel1.setBackground(Color.blue);
        jLabel1.setOpaque(true);
        jLabel1.setFont(new Font(jLabel.getFont().getName(), Font.ITALIC, 16));
        jLabel1.setBorder(Bevel);
        return jLabel1;
    }

    JTextField TextFieldSetting(JTextField jTextField1,int y){
        Border Bevel = BorderFactory.createEtchedBorder();
        jTextField1.setBounds(0,y,getWidth(),30);
        jTextField1.setForeground(Color.RED);
        jTextField1.setBackground(Color.white);
        jTextField1.setOpaque(true);
        jTextField1.setFont(new Font(jTextField1.getFont().getName(), Font.ITALIC, 16));
        jTextField1.setBorder(Bevel);
        jTextField1.addActionListener(this);
        return  jTextField1;
    }


    JButton ButtonSetting(int y){
        JButton jButton=new JButton("Next");
        jButton.addActionListener(this);
        jButton.setBounds(0,90,getWidth(),30);
        jButton.setBackground(Color.pink);
        return jButton;
    }

    void setPanel2(int ch2) {
        if (ch2*50>getHeight()){
            jPanel2.setLayout(new GridLayout(0,1));
        }
        else {
            jPanel2.setLayout(null);
        }

        jPanel2.setSize(500,120);
        jPanel2.setBounds(0,0,getWidth(),getHeight());
        jPanel2.setVisible(false);

        label="Enter "+ch2+" requests:";
        jPanel2.add(LabelSetting1(label));
        int y=40;

        for (int i=0;i<ch2;i++){
            JTextField jTextField1=new JTextField();
            jPanel2.add(TextFieldSetting(jTextField1,y));
            jTextFields.add(jTextField1);
            y=y+40;
        }
        jPanel2.setBackground(Color.gray);
        this.add(scrollPane1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")&& counter==0){
            label="Enter position of head pointer: ";
            jLabel.setText(label);
            counter++;
            n =Integer.parseInt(TextFieldPanel1.getText());
            TextFieldPanel1.setText("");
        }
        else if (e.getActionCommand().equals("Next")&& counter==1){
            start =Integer.parseInt(TextFieldPanel1.getText());
            TextFieldPanel1.setText("");
            jPanel.setVisible(false);
            setPanel2(n);
            jPanel2.setVisible(true);
        }
        else if (e.getSource()==TextFieldPanel1){
            JOptionPane.showMessageDialog(null,"Please Enter Next");
        }
        else{

            for (int i=0;i<n;i++){
                if (e.getSource()==jTextFields.get(i)){
                    devices.add(Integer.parseInt(jTextFields.get(i).getText()));
                    jTextFields.get(i).setEditable(false);
                    if (i==n-1){
                        jPanel2.setVisible(false);
                        scrollPane1.setVisible(false);
                        Disk_Scheduling_Algorithm look=new Look_algorithm(devices,start);
                        Disk_Scheduling_Algorithm C_look=new C_look_algorithm(devices,start);
                        Disk_Scheduling_Algorithm FCFS=new FCFS_algorithm(devices,start);

                        Disk_Scheduling_Algorithm NewlyOptimized = new NewlyOptimizedAlgorithm(devices);
                        Disk_Scheduling_Algorithm SSTF = new SSTF(devices,start);

                        Disk_Scheduling_Algorithm Scan=new Scan_algorithm(devices,start);
                        Disk_Scheduling_Algorithm C_scan=new C_scan_algorithm(devices,start);
                        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
                        ArrayList<Integer> output;
                        output = FCFS.scheduling();
                        input.add(output);

                        output = SSTF.scheduling();
                        input.add(output);

                        output = Scan.scheduling();
                        input.add(output);

                        output = C_scan.scheduling();
                        input.add(output);

                        output = look.scheduling();
                        input.add(output);

                        output = C_look.scheduling();
                        input.add(output);

                        output = NewlyOptimized.scheduling();
                        input.add(output);
                        this.setVisible(false);
                        new GUI(input);
                    }
                }
            }

        }
    }
}
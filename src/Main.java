import java.awt.*;
public class Main{
    public static void main(String[] args) {
        Frame f=new Frame("management system");
        Label l=new Label("Employee Id");
        TextArea ta=new TextArea();
        TextField tf=new TextField(10);
        Button b=new Button("submit");
        Button b1=new Button("reset");
        Button b2=new Button();
        b2.setLabel("button2");
        b2.setBounds(280,370,50,20);
        l.setBounds(20,320,100,20);
        tf.setBounds(20,340,100,20);
        ta.setBounds(25,30,325,300);
        f.setLayout(new FlowLayout());
        b.setBounds(130,340,80,30);
        b1.setBounds(280,340,80,30);

        f.add(b);
        f.add(b1);
        f.add(l);
        f.add(tf);
        f.add(ta);
        f.add(b2);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}

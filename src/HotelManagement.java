import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagement {
    public static void main(String[] args) {


        Frame frame = new Frame("Event Handling Example");

        // Create a Button
        Button button = new Button("Click Me");

        // Add action listener to the button
        button.addActionListener((ActionListener) e -> System.out.println("Button Clicked!"));

        // Add the button to the frame
        frame.add(button);

        // Set frame layout
        frame.setLayout(new FlowLayout());

        // Set frame size
        frame.setSize(300, 200);

        // Make the frame visible
        frame.setVisible(true);
    }
}

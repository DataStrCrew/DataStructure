/**
 * Reader of the library
 * @author Mustafa Gurler
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class StandartReader  extends JFrame implements ActionListener{
    JPanel panel1;
    /**
     * Reader of the library
     * @author Mustafa Gurler
     */
    JButton searchBook;
    JButton borrowBook;
    JButton returnTheBook;
    JButton commentForBook;
    JButton viewEvents;
    JButton participateEvent;
    URL book = new URL("https://i.pinimg.com/originals/2c/fc/93/2cfc93d7665f5d7728782700e50596e3.png");
    final ArrayList<Image> icons = new ArrayList<Image>();


    public StandartReader() throws Exception {
        super("Reader System");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        setLocationRelativeTo( null );
        icons.add(ImageIO.read(book));
        setIconImages(icons);
        searchBook = new JButton("Search Book");
        searchBook.setPreferredSize(new Dimension(150, 35));
        borrowBook = new JButton(("Borrow Book"));
        borrowBook.setPreferredSize(new Dimension(150,35));
        returnTheBook = new JButton(("Return The Book"));
        returnTheBook.setPreferredSize(new Dimension(150,35));
        commentForBook = new JButton(("Comment For Book"));
        commentForBook.setPreferredSize(new Dimension(150,35));
        viewEvents = new JButton(("View Events"));
        viewEvents.setPreferredSize(new Dimension(150,35));
        participateEvent = new JButton(("Participate Event"));
        participateEvent.setPreferredSize(new Dimension(150,35));
        panel1.add(searchBook);
        panel1.add(borrowBook);
        panel1.add(returnTheBook);
        panel1.add(commentForBook);
        panel1.add(viewEvents);
        panel1.add(participateEvent);

        add(panel1,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350,400);
        setLocationByPlatform(true);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == ){
            Admin admin = new Admin();
        }*/
    }
}

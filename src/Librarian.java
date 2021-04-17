import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class Librarian extends JFrame implements ActionListener {
    JPanel panel1;
    JButton lendBook;
    JButton relendBook;
    JButton searchBook;
    JButton demandBook;
    URL book = new URL("https://i.pinimg.com/originals/2c/fc/93/2cfc93d7665f5d7728782700e50596e3.png");
    final ArrayList<Image> icons = new ArrayList<Image>();

    public Librarian() throws Exception {
        super("Librarian System");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1));
        setLocationRelativeTo( null );
        icons.add(ImageIO.read(book));
        setIconImages(icons);
        lendBook = new JButton("Lend Book");
        lendBook.setPreferredSize(new Dimension(150, 35));
        relendBook = new JButton(("Relend Book"));
        relendBook.setPreferredSize(new Dimension(150,35));
        searchBook = new JButton(("Search Book"));
        searchBook.setPreferredSize(new Dimension(150,35));
        demandBook = new JButton(("Demand Book"));
        demandBook.setPreferredSize(new Dimension(150,35));

        panel1.add(lendBook);
        panel1.add(relendBook);
        panel1.add(searchBook);
        panel1.add(demandBook);

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

package headfirst.proxy.virtualproxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTestDrive {
  Hashtable<String, String> cds = new Hashtable<String, String>();
  JFrame frame = new JFrame("CD Cover Viewer");
  ImageComponent imageComponent;
  JMenu menu;
  JMenuBar menuBar;

  public ImageProxyTestDrive() throws Exception {
    cds.put("Ambient: Music for Airports",
            "http://ecx.images-amazon.com/images/I/51uowOr-2PL._SL500_AA300_.jpg");
    cds.put("Selected Ambient Works, Vol. 2",
            "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
    cds.put("Buddha Bar", "http://ecx.images-amazon.com/images/I/61ZN%2BBfxsoL._SS500_.jpg");

    URL initialURL = new URL((String) cds.get("Selected Ambient Works, Vol. 2"));
    menuBar = new JMenuBar();
    menu = new JMenu("Favorite CDs");
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
    for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
      String name = e.nextElement();
      JMenuItem menuItem = new JMenuItem(name);
      menu.add(menuItem);
      menuItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
          frame.repaint();
        }
      });
    }
    // set up frame and menus
    Icon icon = new ImageProxy(initialURL);
    imageComponent = new ImageComponent(icon);
    frame.getContentPane().add(imageComponent);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
  }

  URL getCDUrl(String name) {
    try {
      return new URL((String) cds.get(name));
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }
}

package view;

import javax.swing.*;

/**
 * Created by Razvan-Stefan on 19.05.2015.
 */
public class ApplicationContext
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame(false, null));
    }
}

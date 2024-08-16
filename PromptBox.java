package Advanced_java.Student_Information_Management_System;

import javax.swing.*;
public class PromptBox extends JOptionPane
{
    public PromptBox(String text,String title)
    {
        showMessageDialog(this, text, title, JOptionPane.INFORMATION_MESSAGE);
    }
}

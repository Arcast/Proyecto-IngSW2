/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.view;

import javax.swing.JFrame;

/**
 *
 * @author ricardocasanova
 */
public class MyOwnJFrame extends JFrame
{
    private JFrame fatherWindow;
    private boolean isFatherWindowHide;
    private boolean isFatherWindowDisable;
    

    public JFrame getFatherWindow()
    {
        return fatherWindow;
    }

    public void setFatherWindow(JFrame fatherWindow, boolean hideFatherWindow)
    {
        this.fatherWindow = fatherWindow;
        
        if (hideFatherWindow)
        {
            /*this.fatherWindow.setVisible(false); 
            this.isFatherWindowHide = true;
            this.isFatherWindowDisable = false;*/
        }
        else
        {
            this.fatherWindow.setEnabled(false);
            this.setAlwaysOnTop(true);
            this.isFatherWindowHide = false;
            this.isFatherWindowDisable = true;
        }
    }
    
    public void restoreFatherWindow()
    {
        if (this.isFatherWindowHide)
            this.fatherWindow.setVisible(true);
        
        if (this.isFatherWindowDisable)
            this.fatherWindow.setEnabled(true);
        
        this.dispose();
    }
    
    public void setEnableWindow(boolean setEnable)
    {
        this.setEnabled(setEnable);
        this.setAlwaysOnTop(true);       
    }
}

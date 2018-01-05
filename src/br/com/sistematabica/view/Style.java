
package br.com.sistematabica.view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**Classe controlar o visual das view.
 * 
 * @author Joel Henrique
 * @author Evelyn Mayara
 * @author Lucas Gabriel
 * 
 * @version 1.00
 * 
 */
public class Style {

    private final String COLOR_DEFAULT_BACKGROUND_GREY = "54,52,66";
    private final String COLOR_DEFAULT_FOREGROUND_GREY = "115,115,115";
    
    /**Metodo que define a cor [115,115,115] em um foreground de um label qualquer
     * 
     * @param jlabel JLabel - O Label que será feito a modificação
     * 
     */
    public void default_JLabelForeground(JLabel jlabel) {

        int red = Integer.parseInt(this.COLOR_DEFAULT_FOREGROUND_GREY.substring(0, 3));
        int green = Integer.parseInt(this.COLOR_DEFAULT_FOREGROUND_GREY.substring(4, 7));
        int blue = Integer.parseInt(this.COLOR_DEFAULT_FOREGROUND_GREY.substring(8, 11));
        
        jlabel.setForeground(new Color(red,green,blue));
    }
    
    /**Metodo que define a cor [54,52,66] em um background de um Panel qualquer
     * 
     * @param jPanel JPanel - O Panel que será feito a modificação
     * 
     */
    public void default_JPanelBackground(JPanel jPanel) {
        
        int red = Integer.parseInt(this.COLOR_DEFAULT_BACKGROUND_GREY.substring(0, 2));
        int green = Integer.parseInt(this.COLOR_DEFAULT_BACKGROUND_GREY.substring(3, 5));
        int blue = Integer.parseInt(this.COLOR_DEFAULT_BACKGROUND_GREY.substring(6, 8));
        
        jPanel.setBackground(new Color(red,green,blue));
    }

    
    /**Metodo que edita a cor de um Panel qualquer
     * 
     * @param jpanel Jpanel - O Panel que será feito a modificação
     * @param red Int - a cor red do RGB
     * @param green Int - a cor green do RGB
     * @param blue Int - a cor blue do RBG
     * 
     */
    public void jPanelEditColor(JPanel jpanel, int red, int green, int blue) {
        jpanel.setBackground(new Color(red,green,blue));
    }
    
    /**Metodo que edita a cor de um label qualquer
     * 
     * @param jlabel JLabel -  O Label que será feito a modificação
     * @param red Int - a cor red do RGB
     * @param green Int - a cor green do RGB
     * @param blue Int - a cor blue do RBG
     * 
     */
    public void jLabelEditColor(JLabel jlabel, int red, int green, int blue) {
        jlabel.setBackground(new Color(red,green,blue));
    }
    
    /**Metodo que edita um icon em um label qualquer
     * 
     * @param jlabel Jlabel - O Label que será feito a modificação
     * @param url String - A url que a imagem esta localizada
     * 
     */
    public void jLabelEditImage(JLabel jlabel, String url) {
        jlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
    }

}

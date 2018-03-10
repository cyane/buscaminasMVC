package utiles;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImageFondo extends JPanel{
    private Image fondo=null;
    
    public ImageFondo(String image) {
    	setImage(image);
	}
	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setOpaque(false);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }
    public void setImage(String image){
   	 if (image!=null) {
         fondo=new ImageIcon(getClass().getResource(image)).getImage();
         repaint();
     }
    }
    
}
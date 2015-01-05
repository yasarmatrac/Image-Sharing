import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

public class Improvement {	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("src/originalImage.png");	
		File file2 = new File("src/improvedImage.png");		
		ImageInputStream in = new FileImageInputStream(file);		
		BufferedImage image = ImageIO.read(in);		
		BufferedImage image2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);		
		Color whiteColor = Color.WHITE;
		Color blackColor = Color.BLACK;		
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				int tempColor = image.getRGB(j, i);
				if(tempColor == blackColor.getRGB()){
					image2.setRGB(j, i, blackColor.getRGB());
				}				
				else{
					image2.setRGB(j, i, whiteColor.getRGB());
				}
			}
		}		
		ImageIO.write(image2, "png", file2);	
	}
}

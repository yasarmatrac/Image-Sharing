import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

public class Decrypt {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File cryptImageFile1 = new File("src/share1.png");
		File cryptImageFile2 = new File("src/share2.png");
		File decryptImageFile = new File("src/recoveredImage.png");		
		ImageInputStream in1 = new FileImageInputStream(cryptImageFile1);
		ImageInputStream in2 = new FileImageInputStream(cryptImageFile2);		
		Color whiteColor = Color.WHITE;
		Color blackColor = Color.BLACK;		
		BufferedImage cryptImage1 = ImageIO.read(in1);
		BufferedImage cryptImage2 = ImageIO.read(in2);
		BufferedImage decryptImage = new BufferedImage(cryptImage1.getWidth(), cryptImage1.getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < cryptImage1.getHeight(); i++) {
			for (int j = 0; j < cryptImage1.getWidth(); j++) {	
				if(cryptImage1.getRGB(j, i) == blackColor.getRGB() || cryptImage2.getRGB(j, i) == blackColor.getRGB()){
					decryptImage.setRGB(j, i, blackColor.getRGB());
				}
				else{
					decryptImage.setRGB(j, i, whiteColor.getRGB());
				}
			}
		}
		ImageIO.write(decryptImage, "png", decryptImageFile);		
	}
}

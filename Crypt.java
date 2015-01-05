import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

public class Crypt {
	public static void main(String[] args) throws IOException {
		File file = new File("src/improvedImage.png");
		File cryptFile1 = new File("src/share1.png");
		File cryptFile2 = new File("src/share2.png");		
		ImageInputStream in = new FileImageInputStream(file);		
		BufferedImage image = ImageIO.read(in);		
		BufferedImage crypt1 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		BufferedImage crypt2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);		
		Color whiteColor = Color.WHITE;
		Color blackColor = Color.BLACK;			
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				crypt2.setRGB(j, i, whiteColor.getRGB());
				crypt1.setRGB(j, i, whiteColor.getRGB());
				int tempColor = image.getRGB(j, i);				
				if(tempColor == blackColor.getRGB()){
					int random = (int) (Math.random() * 100);
					if (random < 50){
						crypt1.setRGB(j , i, blackColor.getRGB());
						crypt2.setRGB(j , i, whiteColor.getRGB());
					}
					else {
						crypt1.setRGB(j , i, whiteColor.getRGB());
						crypt2.setRGB(j , i, blackColor.getRGB());
					}				
				}
				else if(tempColor == whiteColor.getRGB()){
					if (Math.random() * 100 < 50){
						crypt1.setRGB(j , i, whiteColor.getRGB());
						crypt2.setRGB(j , i, whiteColor.getRGB());
					}
					else{
						crypt1.setRGB(j , i, blackColor.getRGB());
						crypt2.setRGB(j , i, blackColor.getRGB());
					}
				}	
			}
		}		
		ImageIO.write(crypt2, "png", cryptFile2);
		ImageIO.write(crypt1, "png", cryptFile1);
	}
}

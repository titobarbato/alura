package com.alura.aula;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Stickers {
	public static boolean makeStrickerFromFile(String filePath) throws IOException {
		BufferedImage image = ImageIO.read(new File(filePath));
		
		if(image == null || (image.getWidth() == 0 && image.getHeight() == 0))
			return false;
		
		BufferedImage stickerImage = new BufferedImage(image.getWidth(), (image.getHeight() + 20), BufferedImage.TRANSLUCENT);
		
		Graphics g = stickerImage.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.BLUE);
		g.drawString("TESTE", 0, stickerImage.getHeight());
		
		String newFileName = removeFileExtension(filePath, false);
		
		return ImageIO.write(stickerImage, "PNG", new File(newFileName.concat("_sticker.png")));
	}
	
	public static String removeFileExtension(String fileName, boolean removeAllExtensions) {
	    if (fileName == null || fileName.isEmpty()) {
	        return fileName;
	    }

	    String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
	    return fileName.replaceAll(extPattern, "");
	}
}

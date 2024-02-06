package no.jib.lagpagegenerator.domain;
/************************************************************************
 ** Copyright (c) JIB 2024 -                                           **
 **                                                                    **
 ** This source is licensed under :                                    **
 **                                                                    **
 **                   GNU GENERAL PUBLIC LICENSE                       **
 **                    Version 3, 29 June 2007                         **
 **                                                                    **
 **            Copyright (C) 2007 Free Software Foundation,            **
 **                    Inc. <https://fsf.org/>                         **
 **                                                                    **
 ** Complete license descriptiom at:                                   **
 **             <https://www.gnu.org/licenses/gpl-3.0.txt>             **
 **                                                                    **
 ************************************************************************/

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class EmptyLib {
	private String logodata = "iVBORw0KGgoAAAANSUhEUgAAAGQAAACWCAYAAAAouC1GAAAC40lEQVR42u3d7U7DMAxGYV83F78hEEhIY2NAm5zXPpH6Y2PSHD9raNp81OVyeamq6+fx9tpj3fE19x/HzRtXy5ryXe7rzptmaw+GIDCMaz36gGUtyPvfnvmQZQ2GIKCm6gZElP1nhyAwjBsQUfY1VXdBRNl3dggCw7gLIsoejIcgoggyHuNHEFHWYjwFIoogYzGeBhFlXY5q9RcKIkgMxq9BRDk/J7U7AEEEwWL8GUSU83JQtIAEEQRV96IGNhHjEJCJKIIMwTgMZArKijpWWsCCCLK0bpUaeEeMU0A6oggyFOM0kC4oO+pQ3SokSFOQXbFX14qlxlzdK3hUrIIMPDuWgaSgEGIUBNJULQeho1Biq6kVp8Y0HoTSVG0Dwf0iaT+Q0Vc0xOZz7PU+9AJjawRbe8SCcBKDvvyeBoLvoE7rlAkCSlTE/bQpICl3nFERnTpmVhBO4qKex3QHSXuEjIzs0EmUgnBQIgdYdAVJHYKEjvBfq+oIwkGJHqDXDSR++GpEkL9ZZlUQDkqLEfddQLrMSYmK+OG+G4KwUNrM2OoKkloiIxckDCW5tANJL54hgvg/xKssQfb3QeyH2FOfBeK9rMArKu/2wvocggA7gD6gAnb+fKYOuz0iCAgjHaX1UFJHLgrSD8TR740xElEEEWRP0pzSBkyWs3AFyQNxJQcQyLbFil3rRBA8iOtlgUAwK4C6opwgOJCUVUlHgGDb7anLxAoCAkld+70lSMyNvSmL8QsCAol7Ytd5Q5fYkR9dtzwSBATiHoYgkDZTA7psLCkICMSdokEgbeeOJ27f3XXeeDuQLmXZyBgxWPWss4IUBAbStZw+5FWMJiCTmqqVKOXZwap/iREOIsa5uRAEhlJihIKIsSY3gsBQSowwEDHWoggCQykxQkDE2IMiCAylxICDiLEXRRAYSokBBRGDgSIIDKXEgIGIwUIRBIZSYsBBLHtRBIGhlBhQEAsGRRAYihgkkFdZMOAqPt2GCQAAAABJRU5ErkJggg==";

	public BufferedImage getLogo() throws IOException {
		byte[] imageBytes = Base64.getDecoder().decode(logodata);
		BufferedImage imgtmp = ImageIO.read(new ByteArrayInputStream(imageBytes));
		return imgtmp;
	}

	public byte[] getLogoBytes() {
		byte[] imageBytes = Base64.getDecoder().decode(logodata);
		return imageBytes;
	}
}

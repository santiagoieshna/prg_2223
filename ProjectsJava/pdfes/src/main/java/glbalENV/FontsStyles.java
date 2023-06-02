package glbalENV;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;

public class FontsStyles {
	public static final Font NORMAL = new Font(FontFamily.HELVETICA, 12 ,Font.NORMAL);
	public static final Font BOLD = new Font(FontFamily.HELVETICA, 12 ,Font.BOLD);
	public static final Font ITALIC = new Font(FontFamily.HELVETICA, 12 ,Font.ITALIC);
	public static final Font BOLDITALICL = new Font(FontFamily.HELVETICA, 12 ,Font.BOLDITALIC);
    public static final Font CHAPTER_FONT = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    public static final Font PARAGRPH_FONT = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    public static final Font CATEGORY_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    public static final Font SUBCATEGORY_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    public static final Font BLUEFONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    public static final Font SMALLBOLD = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
}

package com.team.ecobuilders.utils.makepdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.*;
import java.nio.charset.Charset;

//	각종 파일들 경로수정 필요
public class makePDF {
	public static void makePDFs(String exPdfName, String pdfName, String htmlCode) {
		String SRC = "ex_springboot.pdf";
		String IMG = "ci_logo.jpg";
		String DESC = "springboot.pdf";
		Document document = new Document(PageSize.A4, 50, 50, 50, 50); // 용지 및 여백 설정
		try {

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(SRC)); // 현재상대경로에 ex_springboot.pdf
																							// 생성
			writer.setInitialLeading(12.5f);

			document.open(); // 생성된 파일을 오픈
			XMLWorkerHelper helper = XMLWorkerHelper.getInstance();

			// 사용할 CSS 를 준비한다.
			CSSResolver cssResolver = new StyleAttrCSSResolver();
			CssFile cssFile = null;
			try {
				cssFile = helper.getCSS(new FileInputStream("pdf.css"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			cssResolver.addCss(cssFile);

			// HTML 과 폰트준비
			XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			fontProvider.register("MALGUN.ttf", "MalgunGothic"); // MalgunGothic 은 alias,
			CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
			HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
			htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

			// Pipelines
			PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
			HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
			CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

			XMLWorker worker = new XMLWorker(css, true);
			XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));

			// 폰트 설정에서 별칭으로 줬던 "MalgunGothic"을 html 안에 폰트로 지정한다.
			String htmlStr = "<html><head><body style='font-family: MalgunGothic;'>"
					+ "<p>itextpdf 라이브러리를 사용해 pdf 파일을 만들어 봅니다.</p>" + "<p>1. pdf 파일을 만들고</p>" + "<p>2. css도 붙이고</p>"
					+ "<p>3. html을 만들어서 pdf에 쓰는 형태입니다.</p>" + "</body></head></html>";

			StringReader strReader = new StringReader(htmlStr);
			xmlParser.parse(strReader);
			document.close();
			writer.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// PDF 파일에 이미지를 넣어본다.
		try {
			PdfReader reader = new PdfReader(SRC);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DESC));
			Image image = Image.getInstance(IMG);
			PdfImage stream = new PdfImage(image, "", null);

			stream.put(new PdfName("logo"), new PdfName("logo"));
			PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
			image.setDirectReference(ref.getIndirectReference());
			image.setAbsolutePosition(20, 600);
			PdfContentByte over = stamper.getOverContent(1);

			over.addImage(image);
			stamper.close();
			reader.close();

		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadPdfFormatException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}

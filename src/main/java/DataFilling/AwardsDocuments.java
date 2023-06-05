package DataFilling;

import java.util.Arrays;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.aspose.html.internal.ms.System.Threading.Thread;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.spire.doc.FileFormat;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.*; // for file I/O

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class AwardsDocuments {

	private boolean loading = true;
	private boolean downloading = true;
	@SuppressWarnings("deprecation")
	public AwardsDocuments() throws IOException, AWTException, InterruptedException {
		
//		WebDriver driver = new EdgeDriver();
//
//		String df = "https://dynamicforms.ngwebsolutions.com/casAuthentication.ashx?InstID=64949c53-6905-4008-b806-f223f1cc8476&targetURL=https%3A%2F%2Fdynamicforms.ngwebsolutions.com	";
//
//		driver.get(df);
//
//		login(driver);
//		getForm(driver);
		
//		String [] fileParts = {"Part1", "Part10", "Part11", "Part12", "Part13", "Part14", "Part15", "Part16", "Part17", "Part18", "Part19", "Part2", "Part20", "Part21", "Part22", "Part23", "Part24", "Part25", "Part26", "Part27", "Part28", "Part29", "Part3", "Part30", "Part31", "Part32", "Part33", "Part34", "Part35", "Part36", "Part37", "Part38", "Part39", "Part4", "Part40", "Part41", "Part41", "Part43", "Part44", "Part45", "Part46", "Part48", "Part49", "Part5", "Part50", "Part51", "Part52", "Part53", "Part55", "Part56", "Part57", "Part58", "Part6", "Part60", "Part61", "Part62", "Part63", "Part64", "Part65", "Part66", "Part66", "Part68", "Part69", "Part7", "Part71", "Part73", "Part8"};
//		String [] w9 = {"C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\MIGUEL, GALLARDO 06-4-23 Inv# SCHOFF1005.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ANDREA, SOMERSEL 06-4-23 Inv# SCHOFF1014.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ANNA, FISCHER 06-4-23 Inv# SCHOFF1015.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\PATRICE, EATON 06-4-23 Inv# SCHOFF1016.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\EUGENE, EMONO 06-4-23 Inv# SCHOFF1017.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\MELISSA, FISHMAN 06-4-23 Inv# SCHOFF1018.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\KIMBERLY, CHEN 06-4-23 Inv# SCHOFF1019.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SADIA, SIDDIQUE 06-4-23 Inv# SCHOFF1020.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\MOHAMED, ZUBAR 06-4-23 Inv# SCHOFF1021.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ELENA, TIMCHENKO 06-4-23 Inv# SCHOFF1022.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SARAH, ALTOHAMI 06-4-23 Inv# SCHOFF1024.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\CELESTE, SASSER 06-4-23 Inv# SCHOFF1006.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JESSICA, WONG 06-4-23 Inv# SCHOFF1025.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\MICHELA, ARLIA 06-4-23 Inv# SCHOFF1026.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ZAHRA, JAMIL 06-4-23 Inv# SCHOFF1027.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\KRYSTYNA, BORSHCHEVSKAYA 06-4-23 Inv# SCHOFF1028.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\Gabriela, Perez 06-4-23 Inv# SCHOFF1029.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\RHONEA, SCOTT 06-4-23 Inv# SCHOFF1030.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\BETH, ROCCO 06-4-23 Inv# SCHOFF1031.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\REEBA, BUTT 06-4-23 Inv# SCHOFF1032.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\DIANA, ATHENA 06-4-23 Inv# SCHOFF1033.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\FAITH, CUMMINGS 06-4-23 Inv# SCHOFF1034.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SHAUNETTE, PITMAN 06-4-23 Inv# SCHOFF1007.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\YAAKOV, GOFFSTEIN 06-4-23 Inv# SCHOFF1035.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\TASNEEM, IBRAHIM 06-4-23 Inv# SCHOFF1036.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\CHAIM, JANANI 06-4-23 Inv# SCHOFF1037.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JACOB, SCHLAMOWITZ 06-4-23 Inv# SCHOFF1038.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\VASILISA, TOLKACHEVA 06-4-23 Inv# SCHOFF1039.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JOSHUA, KOEGEL 06-4-23 Inv# SCHOFF1040.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\DIANDREA, GREENAWAY 06-4-23 Inv# SCHOFF1041.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\MARIAM, ALEX 06-4-23 Inv# SCHOFF1042.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JOHNNY, PALACIOS 06-4-23 Inv# SCHOFF1043.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JALOL, ABDURAKHMONOV 06-4-23 Inv# SCHOFF1044.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\CLARE, SEIDEL 06-4-23 Inv# SCHOFF1008.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ELIEL, MIZRAHI 06-4-23 Inv# SCHOFF1045.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SALAMA, PATRICK 06-4-23 Inv# SCHOFF1046.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SALAMA, PATRICK 06-4-23 Inv# SCHOFF1047.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\REBECCA, TURAY 06-4-23 Inv# SCHOFF1048.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\HUIJUAN, NIE 06-4-23 Inv# SCHOFF1049.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\GLENDA, WILLIAMS 06-4-23 Inv# SCHOFF1050.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\VU, THAI 06-4-23 Inv# SCHOFF1051.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JIE, LIN 06-4-23 Inv# SCHOFF1053.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\TEHILA, WILLNER 06-4-23 Inv# SCHOFF1054.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SHANELL, ROBERTS 06-4-23 Inv# SCHOFF1009.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\TAYA, HIGGS 06-4-23 Inv# SCHOFF1055.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JUSTYNA, KITTEL-KUREK 06-4-23 Inv# SCHOFF1056.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\GABRIELLA, POLGUR 06-4-23 Inv# SCHOFF1057.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ANQI, WEN 06-4-23 Inv# SCHOFF1058.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\RYAN, CHEN 06-4-23 Inv# SCHOFF1060.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\LEO, KOUKLANAKIS 06-4-23 Inv# SCHOFF1061.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\DEBORAH, RAPPOPORT 06-4-23 Inv# SCHOFF1062.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\GABRIEL, WASSIF 06-4-23 Inv# SCHOFF1063.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\LISELLE, FERDINAND 06-4-23 Inv# SCHOFF1010.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\NANA, KIZIRIYA 06-4-23 Inv# SCHOFF1065.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JOE, CHAPPEL 06-4-23 Inv# SCHOFF1067.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\TOMOKO, KERN 06-4-23 Inv# SCHOFF1068.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\THOMAS, MARTINEZ 06-4-23 Inv# SCHOFF1069.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\GRAYSON, SCOTT 06-4-23 Inv# SCHOFF1070.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ABIGAIL, KHANIS 06-4-23 Inv# SCHOFF1071.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JULIETTE, CAMPBELL 06-4-23 Inv# SCHOFF1072.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JULIETTE, CAMPBELL 06-4-23 Inv# SCHOFF1073.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\TIFFANY, HINCHEY 06-4-23 Inv# SCHOFF1074.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SUNELI, SVERDLOV 06-4-23 Inv# SCHOFF1075.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\WILLIAMBURYAT, TAKAHASHI 06-4-23 Inv# SCHOFF1011.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\DAN, TREFETHEN 06-4-23 Inv# SCHOFF1076.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ISABELLE, CACHIA-RIEDL 06-4-23 Inv# SCHOFF1077.pdf", "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\SHAO, CHEN 06-4-23 Inv# SCHOFF1012.pdf"};
		
		String [] fileParts = {"Part59", "Part54", "Part9","Part47"};
		String [] w9 = {"C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\JAY SYMON, ABRERA 06-4-23 Inv# SCHOFF1064.pdf","C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\DIANA, ORTIZ CRUZ 06-4-23 Inv# SCHOFF1059.pdf","C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ZIFENG MICHAEL, ZHENG 06-4-23 Inv# SCHOFF1013.pdf","C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\ZHI JIE, CHEN 06-4-23 Inv# SCHOFF1052.pdf"};
		
		paymentRequestMerge(fileParts, w9);
		
//		for(String s : w9) {
//			String tem[] = s.split("\\\\");
//			String sp [] = tem[tem.length-1].split(" ");
//			System.out.println(sp[0]);
//		}
		

	}

	public void login(WebDriver driver) {

		String userName = "cory5952097";
		String passWrd = "benten2014";

		WebElement loginName = driver.findElement(By.cssSelector("input[id*='username']"));
		loginName.clear();
		loginName.sendKeys(userName);

		WebElement loginPassword = driver.findElement(By.cssSelector("input[id*='password']"));
		loginPassword.sendKeys(passWrd);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"fm1\"]/div[4]/input[4]"));
		loginBtn.click();
	}

	public void getForm(WebDriver driver) throws IOException, AWTException, InterruptedException {
//		String uniqueIDs[] = {"D2187C1D-2C16-4678-993E-7B55455204B3", "1E9C6B26-5AF1-4AC1-8B6B-6F264379F0DF", "069E46AF-5181-4396-A387-2FEFD444315A", "BB9FCBE2-8F73-4390-B539-0A93996310E9", "E57B6940-A658-4951-8327-24159AA44257", "05FDA9E9-F96E-40A1-BC43-7D666A1B2F2E", "5A1494A4-E94F-4369-A94F-822C82097C22", "3800134D-E9EC-4C2C-8046-4ED722CC3CBE", "7EF7CC7B-BC09-4D85-8282-FC98901206B6", "6FFC68F5-3FF4-493A-996E-5945E0583823", "014E8CF5-7425-4DF7-9F8E-CB90CE59E194", "C72C1CF6-BF22-464C-9C95-CBDFB6FC0346", "9DA0732B-5BDA-4D46-827C-3BB1DC2BF602", "6BC917C3-7D24-4C83-8B09-AB33DFB39E25", "D94AD1F1-7673-4CB2-BAE7-0519D226468A", "7FAF07F1-D563-4E17-A89B-5C24C0C3B81A", "53670EC3-36D9-47AA-BF81-1E607E216098", "FA915210-EEB3-48BF-9710-1592FF733F1C", "14BAC828-09B4-44FF-93A1-34BB4A0855AD", "D94367EB-5460-49C5-945B-A8B55813D382", "055ECC8F-CF1A-4520-858F-CA41AC74AE9B", "0654F239-7B5F-4F0D-89A6-34C403CE62B8", "0EF288AE-942D-4B85-9A3D-2FA2D2B06405", "61E2AA5E-57C1-4F48-825C-D236388A27E3", "D468F31C-0E1C-42B6-A856-0753716C1C48", "137524AF-F24D-40F8-AFCD-A3A4D61815ED", "18FB3B43-EBED-4E27-9897-E66E50A21054", "CA93F70D-FD54-4546-8CEC-107F0FEBF8BD", "FDBF2054-2777-440E-82ED-DA94E391F1BD", "F94B4334-68D3-4C1D-BDA0-1B3416D889E3", "0D71CC2C-48B5-422E-B686-FF03551FC789", "B9A3ABE0-24BA-43BD-9AFF-DC714EDF0F5C", "C2C02EC0-A5F6-4B6E-916C-FE0F3E534E90", "7F5FB99A-190F-48B6-9AB9-B59ACEF87CBA", "DD60850D-5ABB-4073-BF9A-BFDC79CC6E1F", "16FFD3D2-72F7-47F7-8C6C-FD3131BB3298", "2C2C7F63-38BD-4194-88F2-717359779BDD", "487E700A-7513-4050-B7C7-A43048D8143B", "CEBB9FA9-46F8-4EEC-9350-549FD3CD2A10", "CE57F59F-5D37-4467-8CEF-BB4BE66446F6", "CA484B23-BDA4-4D59-B3CC-A060467E8A05", "FE07EE70-3688-42E1-B478-C81964ED76B1", "FE07EE70-3688-42E1-B478-C81964ED76B1", "4EF2715A-1420-4BDA-9861-56159997B223", "F4D26FCB-8C2E-44B3-8107-B3C82311D16F", "515154C5-DBAC-4E39-9906-5DDF9527EAD4", "B04F5885-B032-4200-9653-5F70C4BADE5A", "131D479A-8A90-41ED-A072-477DC5B7CE3C", "09B27105-6FF2-446C-9451-4527A8CC6BC3", "2604935A-17E3-4D65-AB2C-796A2497C414", "A57E6246-3AD0-44FA-B3B3-744C21B9C172", "9E1DE96D-967B-4D73-B3AC-621B54AF0A08", "288D8982-2898-419B-AB4C-089130915407", "277FE68E-5BCC-42CC-AE41-2AE30C159626", "3534BA08-14AB-4BF3-ADA9-B2BAC6251C7F", "D12E694C-7769-401B-B05B-A24FBE5790FC", "C8850268-8EBE-451C-BA19-F6115693E585", "646FD8E4-C8CA-4A03-B289-DA2C744280B1", "A35BFE97-3165-4340-B131-8967984BDA21", "335B95E8-817C-4B1B-8C8D-CCF879B7767F", "083E41A0-13F6-48A5-AE39-ED0E17E586D9", "C74BAA80-E46D-4818-AD05-877BEE2BC1A2", "F68E9227-B152-47BD-8A0A-EB1DD860A8D0", "7A223883-502F-4E47-B710-1E31ED4BE0D2", "A03188C8-2119-4241-83E4-73E71280FB55", "8BC8EC45-888F-41C6-AD1B-55FA904DD961", "F1013C3C-AA7C-48CD-8C06-BFF12A88E6C7", "B21509C9-EDFF-4322-A006-57CC1E592215", "B21509C9-EDFF-4322-A006-57CC1E592215", "16BCDBA6-072C-4793-9FFA-0FB9A0A3F289", "F6CB95B6-096A-4B4E-8732-F44BC3451C4D", "EE314B9C-2581-4063-BDBC-7089CBE65F12", "92F40F80-0485-4BE1-963D-0868516A91DA"};
//		String fileId[]= {"n", "n", "bebfa8c2-5184-4631-9d5a-af2cea83ca5e", "4258a283-a784-423e-b8df-eb6790662544", "n", "458ad3e7-c6bf-4e13-9ee5-e7dc736be8e0", "n", "n", "n", "b330f285-07a7-4aa9-af51-a17ea49e03a7", "n", "4b77348e-2b22-42a7-88c5-346363f0618b", "6b670dd9-5069-4739-879c-47a2b9a81334", "n", "n", "n", "5252ca3e-4914-4769-a869-74113b5791e2", "n", "c34c82f6-ca36-454d-bbac-067d9d02c6f8", "6ba476e9-ac3b-4314-a8f9-9f7904404bc9", "61501ee7-23df-43b1-8988-43019680167e", "3cd3077b-1277-4c4a-8c19-3def683be95f", "n", "e728f528-2c98-4ffc-b9e2-08646c5e0a68", "2d50fdc9-ba74-4d47-8621-6814643a05da", "n", "n", "469b32ec-9cf5-4fd3-bc10-5a674f407764", "87177907-3c24-484b-8140-cc51d36812b7", "29d8d9c0-cddc-4539-a90a-7017b3b68347", "e3fc6f3c-207c-446d-9c2f-469ee1fa5b94", "2135aea1-c456-41bc-bd82-291405723a73", "983b0f93-e369-4d57-b44a-c4fa0bf39755", "2cbfdaa2-8d8e-46f1-8425-0c2a76a06ec8", "886d8154-2114-4a87-b3b9-84028d8017be", "866a8202-08ce-476f-a96c-9ba734b63eea", "c58c1251-71bc-405d-b482-a63a509f965c", "6246f40c-e174-43d2-b52f-144537b7ab2c", "n", "n", "n", "c9473a91-f161-432c-81fa-2a5d2b54e09d", "c9473a91-f161-432c-81fa-2a5d2b54e09d", "n", "n", "8570124b-f89c-489f-b4e0-1bfb4e12bda6", "b35e3574-9e33-4d8c-ba29-f7254c74f5a0", "n", "84e00bde-08ea-4d25-b099-80a0c15521a3", "9e94fc7b-7140-478f-a66f-153c3487901e", "n", "n", "n", "51e291fc-6495-4cc2-b350-04a3f9e0ec8c", "bfb1f788-39dc-4f24-8cb2-77f581baadd7", "be802681-9d82-42a7-ad23-235f33b1bb6f", "623bd583-be80-405b-894c-15ebf3b08480", "n", "554c77b8-53eb-4243-b397-1b260728fbb1", "15454908-ba80-4573-98f5-7d8f057e44af", "n", "757216f2-0bff-4db4-9cde-705528f4790b", "022aa56b-a3f3-4983-91f0-bd663fa63e76", "n", "n", "cb081e99-ad4c-4a7e-bbaf-207a79fe265e", "c04e48c6-4db2-40dc-a5b2-73cc9060c78e", "419be880-9e67-4a3c-9461-cd63b9e02259", "419be880-9e67-4a3c-9461-cd63b9e02259", "9bc51876-da28-4267-a979-010b33095831", "9feb40f0-c5d0-4ab9-b46f-b25c9857fcea", "72643c29-4717-4079-afaf-e6d7f5e18bbe", "n"};

		String uniqueIDs[] = {"D2187C1D-2C16-4678-993E-7B55455204B3", "1E9C6B26-5AF1-4AC1-8B6B-6F264379F0DF", "069E46AF-5181-4396-A387-2FEFD444315A", "BB9FCBE2-8F73-4390-B539-0A93996310E9", "E57B6940-A658-4951-8327-24159AA44257", "05FDA9E9-F96E-40A1-BC43-7D666A1B2F2E", "5A1494A4-E94F-4369-A94F-822C82097C22", "3800134D-E9EC-4C2C-8046-4ED722CC3CBE", "7EF7CC7B-BC09-4D85-8282-FC98901206B6", "6FFC68F5-3FF4-493A-996E-5945E0583823", "014E8CF5-7425-4DF7-9F8E-CB90CE59E194", "C72C1CF6-BF22-464C-9C95-CBDFB6FC0346", "9DA0732B-5BDA-4D46-827C-3BB1DC2BF602", "6BC917C3-7D24-4C83-8B09-AB33DFB39E25", "D94AD1F1-7673-4CB2-BAE7-0519D226468A", "7FAF07F1-D563-4E17-A89B-5C24C0C3B81A", "53670EC3-36D9-47AA-BF81-1E607E216098", "FA915210-EEB3-48BF-9710-1592FF733F1C", "14BAC828-09B4-44FF-93A1-34BB4A0855AD", "D94367EB-5460-49C5-945B-A8B55813D382", "055ECC8F-CF1A-4520-858F-CA41AC74AE9B", "0654F239-7B5F-4F0D-89A6-34C403CE62B8", "0EF288AE-942D-4B85-9A3D-2FA2D2B06405", "61E2AA5E-57C1-4F48-825C-D236388A27E3", "D468F31C-0E1C-42B6-A856-0753716C1C48", "137524AF-F24D-40F8-AFCD-A3A4D61815ED", "18FB3B43-EBED-4E27-9897-E66E50A21054", "CA93F70D-FD54-4546-8CEC-107F0FEBF8BD", "FDBF2054-2777-440E-82ED-DA94E391F1BD", "F94B4334-68D3-4C1D-BDA0-1B3416D889E3", "0D71CC2C-48B5-422E-B686-FF03551FC789", "B9A3ABE0-24BA-43BD-9AFF-DC714EDF0F5C", "C2C02EC0-A5F6-4B6E-916C-FE0F3E534E90", "7F5FB99A-190F-48B6-9AB9-B59ACEF87CBA", "DD60850D-5ABB-4073-BF9A-BFDC79CC6E1F", "16FFD3D2-72F7-47F7-8C6C-FD3131BB3298", "2C2C7F63-38BD-4194-88F2-717359779BDD", "487E700A-7513-4050-B7C7-A43048D8143B", "CEBB9FA9-46F8-4EEC-9350-549FD3CD2A10", "CE57F59F-5D37-4467-8CEF-BB4BE66446F6", "CA484B23-BDA4-4D59-B3CC-A060467E8A05", "FE07EE70-3688-42E1-B478-C81964ED76B1", "FE07EE70-3688-42E1-B478-C81964ED76B1", "4EF2715A-1420-4BDA-9861-56159997B223", "F4D26FCB-8C2E-44B3-8107-B3C82311D16F", "515154C5-DBAC-4E39-9906-5DDF9527EAD4", "B04F5885-B032-4200-9653-5F70C4BADE5A", "131D479A-8A90-41ED-A072-477DC5B7CE3C", "09B27105-6FF2-446C-9451-4527A8CC6BC3", "2604935A-17E3-4D65-AB2C-796A2497C414", "A57E6246-3AD0-44FA-B3B3-744C21B9C172", "9E1DE96D-967B-4D73-B3AC-621B54AF0A08", "288D8982-2898-419B-AB4C-089130915407", "277FE68E-5BCC-42CC-AE41-2AE30C159626", "3534BA08-14AB-4BF3-ADA9-B2BAC6251C7F", "D12E694C-7769-401B-B05B-A24FBE5790FC", "C8850268-8EBE-451C-BA19-F6115693E585", "646FD8E4-C8CA-4A03-B289-DA2C744280B1", "A35BFE97-3165-4340-B131-8967984BDA21", "335B95E8-817C-4B1B-8C8D-CCF879B7767F", "083E41A0-13F6-48A5-AE39-ED0E17E586D9", "C74BAA80-E46D-4818-AD05-877BEE2BC1A2", "F68E9227-B152-47BD-8A0A-EB1DD860A8D0", "7A223883-502F-4E47-B710-1E31ED4BE0D2", "A03188C8-2119-4241-83E4-73E71280FB55", "8BC8EC45-888F-41C6-AD1B-55FA904DD961", "F1013C3C-AA7C-48CD-8C06-BFF12A88E6C7", "B21509C9-EDFF-4322-A006-57CC1E592215", "B21509C9-EDFF-4322-A006-57CC1E592215", "16BCDBA6-072C-4793-9FFA-0FB9A0A3F289", "F6CB95B6-096A-4B4E-8732-F44BC3451C4D", "EE314B9C-2581-4063-BDBC-7089CBE65F12", "92F40F80-0485-4BE1-963D-0868516A91DA"};
		String fileId[]= {"bfb1f788-39dc-4f24-8cb2-77f581baadd7", "n", "886d8154-2114-4a87-b3b9-84028d8017be", "n", "n", "4258a283-a784-423e-b8df-eb6790662544", "n", "n", "022aa56b-a3f3-4983-91f0-bd663fa63e76", "757216f2-0bff-4db4-9cde-705528f4790b", "n", "n", "87177907-3c24-484b-8140-cc51d36812b7", "n", "n", "a1251fc7-cc07-4874-bf4a-1d20b1861bd3", "n", "8570124b-f89c-489f-b4e0-1bfb4e12bda6", "2135aea1-c456-41bc-bd82-291405723a73", "458ad3e7-c6bf-4e13-9ee5-e7dc736be8e0", "9feb40f0-c5d0-4ab9-b46f-b25c9857fcea", "c04e48c6-4db2-40dc-a5b2-73cc9060c78e", "e3fc6f3c-207c-446d-9c2f-469ee1fa5b94", "6b670dd9-5069-4739-879c-47a2b9a81334", "n", "61501ee7-23df-43b1-8988-43019680167e", "84e00bde-08ea-4d25-b099-80a0c15521a3", "6246f40c-e174-43d2-b52f-144537b7ab2c", "419be880-9e67-4a3c-9461-cd63b9e02259", "n", "bebfa8c2-5184-4631-9d5a-af2cea83ca5e", "n", "n", "b330f285-07a7-4aa9-af51-a17ea49e03a7", "c34c82f6-ca36-454d-bbac-067d9d02c6f8", "n", "29d8d9c0-cddc-4539-a90a-7017b3b68347", "n", "4b77348e-2b22-42a7-88c5-346363f0618b", "866a8202-08ce-476f-a96c-9ba734b63eea", "cb081e99-ad4c-4a7e-bbaf-207a79fe265e", "n", "n", "n", "5252ca3e-4914-4769-a869-74113b5791e2", "554c77b8-53eb-4243-b397-1b260728fbb1", "n", "n", "be802681-9d82-42a7-ad23-235f33b1bb6f", "n", "15454908-ba80-4573-98f5-7d8f057e44af", "n", "9e94fc7b-7140-478f-a66f-153c3487901e", "983b0f93-e369-4d57-b44a-c4fa0bf39755", "b35e3574-9e33-4d8c-ba29-f7254c74f5a0", "c58c1251-71bc-405d-b482-a63a509f965c", "c9473a91-f161-432c-81fa-2a5d2b54e09d", "469b32ec-9cf5-4fd3-bc10-5a674f407764", "n", "623bd583-be80-405b-894c-15ebf3b08480", "6ba476e9-ac3b-4314-a8f9-9f7904404bc9", "51e291fc-6495-4cc2-b350-04a3f9e0ec8c", "n", "2d50fdc9-ba74-4d47-8621-6814643a05da", "9bc51876-da28-4267-a979-010b33095831", "3cd3077b-1277-4c4a-8c19-3def683be95f", "n", "2cbfdaa2-8d8e-46f1-8425-0c2a76a06ec8", "2cbfdaa2-8d8e-46f1-8425-0c2a76a06ec8", "n", "n", "72643c29-4717-4079-afaf-e6d7f5e18bbe", "e728f528-2c98-4ffc-b9e2-08646c5e0a68"};

		String 	names[] = {"MIGUEL, GALLARDO 06-4-23 Inv# SCHOFF1005", "CELESTE, SASSER 06-4-23 Inv# SCHOFF1006", "SHAUNETTE, PITMAN 06-4-23 Inv# SCHOFF1007", "CLARE, SEIDEL 06-4-23 Inv# SCHOFF1008", "SHANELL, ROBERTS 06-4-23 Inv# SCHOFF1009", "LISELLE, FERDINAND 06-4-23 Inv# SCHOFF1010", "WILLIAMBURYAT, TAKAHASHI 06-4-23 Inv# SCHOFF1011", "SHAO, CHEN 06-4-23 Inv# SCHOFF1012", "ZIFENG MICHAEL, ZHENG 06-4-23 Inv# SCHOFF1013", "ANDREA, SOMERSEL 06-4-23 Inv# SCHOFF1014", "ANNA, FISCHER 06-4-23 Inv# SCHOFF1015", "PATRICE, EATON 06-4-23 Inv# SCHOFF1016", "EUGENE, EMONO 06-4-23 Inv# SCHOFF1017", "MELISSA, FISHMAN 06-4-23 Inv# SCHOFF1018", "KIMBERLY, CHEN 06-4-23 Inv# SCHOFF1019", "SADIA, SIDDIQUE 06-4-23 Inv# SCHOFF1020", "MOHAMED, ZUBAR 06-4-23 Inv# SCHOFF1021", "ELENA, TIMCHENKO 06-4-23 Inv# SCHOFF1022", "Oliver, Turque 06-4-23 Inv# SCHOFF1023", "SARAH, ALTOHAMI 06-4-23 Inv# SCHOFF1024", "JESSICA, WONG 06-4-23 Inv# SCHOFF1025", "MICHELA, ARLIA 06-4-23 Inv# SCHOFF1026", "ZAHRA, JAMIL 06-4-23 Inv# SCHOFF1027", "KRYSTYNA, BORSHCHEVSKAYA 06-4-23 Inv# SCHOFF1028", "Gabriela, Perez 06-4-23 Inv# SCHOFF1029", "RHONEA, SCOTT 06-4-23 Inv# SCHOFF1030", "BETH, ROCCO 06-4-23 Inv# SCHOFF1031", "REEBA, BUTT 06-4-23 Inv# SCHOFF1032", "DIANA, ATHENA 06-4-23 Inv# SCHOFF1033", "FAITH, CUMMINGS 06-4-23 Inv# SCHOFF1034", "YAAKOV, GOFFSTEIN 06-4-23 Inv# SCHOFF1035", "TASNEEM, IBRAHIM 06-4-23 Inv# SCHOFF1036", "CHAIM, JANANI 06-4-23 Inv# SCHOFF1037", "JACOB, SCHLAMOWITZ 06-4-23 Inv# SCHOFF1038", "VASILISA, TOLKACHEVA 06-4-23 Inv# SCHOFF1039", "JOSHUA, KOEGEL 06-4-23 Inv# SCHOFF1040", "DIANDREA, GREENAWAY 06-4-23 Inv# SCHOFF1041", "MARIAM, ALEX 06-4-23 Inv# SCHOFF1042", "JOHNNY, PALACIOS 06-4-23 Inv# SCHOFF1043", "JALOL, ABDURAKHMONOV 06-4-23 Inv# SCHOFF1044", "ELIEL, MIZRAHI 06-4-23 Inv# SCHOFF1045", "SALAMA, PATRICK 06-4-23 Inv# SCHOFF1046", "SALAMA, PATRICK 06-4-23 Inv# SCHOFF1047", "REBECCA, TURAY 06-4-23 Inv# SCHOFF1048", "HUIJUAN, NIE 06-4-23 Inv# SCHOFF1049", "GLENDA, WILLIAMS 06-4-23 Inv# SCHOFF1050", "VU, THAI 06-4-23 Inv# SCHOFF1051", "ZHI JIE, CHEN 06-4-23 Inv# SCHOFF1052", "JIE, LIN 06-4-23 Inv# SCHOFF1053", "TEHILA, WILLNER 06-4-23 Inv# SCHOFF1054", "TAYA, HIGGS 06-4-23 Inv# SCHOFF1055", "JUSTYNA, KITTEL-KUREK 06-4-23 Inv# SCHOFF1056", "GABRIELLA, POLGUR 06-4-23 Inv# SCHOFF1057", "ANQI, WEN 06-4-23 Inv# SCHOFF1058", "DIANA, ORTIZ CRUZ 06-4-23 Inv# SCHOFF1059", "RYAN, CHEN 06-4-23 Inv# SCHOFF1060", "LEO, KOUKLANAKIS 06-4-23 Inv# SCHOFF1061", "DEBORAH, RAPPOPORT 06-4-23 Inv# SCHOFF1062", "GABRIEL, WASSIF 06-4-23 Inv# SCHOFF1063", "JAY SYMON, ABRERA 06-4-23 Inv# SCHOFF1064", "NANA, KIZIRIYA 06-4-23 Inv# SCHOFF1065", "David, Amoh-Boateng 06-4-23 Inv# SCHOFF1066", "JOE, CHAPPEL 06-4-23 Inv# SCHOFF1067", "TOMOKO, KERN 06-4-23 Inv# SCHOFF1068", "THOMAS, MARTINEZ 06-4-23 Inv# SCHOFF1069", "GRAYSON, SCOTT 06-4-23 Inv# SCHOFF1070", "ABIGAIL, KHANIS 06-4-23 Inv# SCHOFF1071", "JULIETTE, CAMPBELL 06-4-23 Inv# SCHOFF1072", "JULIETTE, CAMPBELL 06-4-23 Inv# SCHOFF1073", "TIFFANY, HINCHEY 06-4-23 Inv# SCHOFF1074", "SUNELI, SVERDLOV 06-4-23 Inv# SCHOFF1075", "DAN, TREFETHEN 06-4-23 Inv# SCHOFF1076", "ISABELLE, CACHIA-RIEDL 06-4-23 Inv# SCHOFF1077"};
		// Unique Id, pageItemId, fileId, timestamp
	
		
		String attachments[] = new String[uniqueIDs.length];
		String w9[] = new String[uniqueIDs.length];
//		
		getAttachments(driver, attachments, fileId, uniqueIDs);
		getW9(driver, w9, uniqueIDs);

		for(int i = 0; i < w9.length;i++) {
			System.out.println(names[i]+ "\t" + w9[i] + "\t" + attachments[i]);
		}
		
		mergeW9s(w9,attachments,names);
		
//		String testattach[] = {"C:\\Users\\campb\\Downloads\\This is a test.docx", "C:\\Users\\campb\\Downloads\\Direct Deposit Form (1).pdf"};
//		String testw9[] = {"C:\\Users\\campb\\Downloads\\ViewPDF.pdf", "C:\\Users\\campb\\Downloads\\ViewPDF (1).pdf"};
//		String testName[] = {"test1","test2"};
//		
//		mergeW9s(testw9,testattach,testName);
	}
	
	public synchronized void getAttachments(WebDriver driver, String [] attachments, String [] fileId, String [] uniqueIDs) throws InterruptedException {
		String proof = "https://dynamicforms.ngwebsolutions.com/FileAttachmentViewer?formInstanceUniqueId=";
		
		for(int i = 0; i < uniqueIDs.length-1;i++) {
			downloading = true;
			if(fileId[i].length()>1) {
				driver.get(proof + uniqueIDs[i]+"&fileId="+fileId[i]);
				handleDownload(driver, i);
				if(downloading)
					wait();
				File file = getLastModified("C:\\Users\\campb\\Downloads");
				attachments[i]=file.getPath();
				System.out.println(file.getPath());
			}else {
				attachments[i]="empty";
			}
		}
	}
	
	public synchronized void getW9(WebDriver driver, String[]w9, String [] uniqueIDs) throws IOException, AWTException, InterruptedException {
		
		String formLocation = "https://dynamicforms.ngwebsolutions.com/Submit/ViewPDF?form=";
		
		for(int i = 0; i <= uniqueIDs.length-1;i++) {
			
			String destinationW9 = "";
			loading = true;
			
			driver.get(formLocation + uniqueIDs[i] + "&archived=False");
			if(i<1)
				clickSaveAs(driver, 1);
			else
				clickSaveAs(driver, 2);
			if(loading)
				wait();				
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			System.out.println("finish Saving");
			
			File file = getTheNewestFile("C:\\Users\\campb\\Downloads","pdf");
			destinationW9 = file.getPath();
			w9[i]=destinationW9;
		}		
	}

	public synchronized void clickSaveAs(WebDriver driver, int pos) throws IOException, AWTException, InterruptedException {
		
		
		// saveAs
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(2000);
		robot.delay(20);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(20);
		if(pos == 1) {
			Thread.sleep(2000);
			robot.delay(20);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(20);
		}
		
		Thread.sleep(2000);
		System.out.println("here");
		loading = false;
	}
	
	public void handleDownload(WebDriver driver, int pos) {
		try {
			WebElement download = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/a"));
			download.click();
		}catch(Exception e) {
			try {
				WebElement download = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/a"));
				download.click();
			}catch(Exception f) {
				WebElement download = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/a"));
				download.click();
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(15000);
		downloading = false;
	}
	
	public static File getLastModified(String directoryFilePath)
	{
		System.out.println("here");
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}
	
	public File getTheNewestFile(String filePath, String ext) {
	    File theNewestFile = null;
	    File dir = new File(filePath);
	    @SuppressWarnings("deprecation")
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
	    File[] files = dir.listFiles(fileFilter);

	    if (files.length > 0) {
	        /** The newest file comes first **/
	        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	        theNewestFile = files[0];
	    }

	    return theNewestFile;
	}
	
	public void mergeW9s(String [] w9, String [] attachments, String [] fileName) throws IOException {
		for(int i = 0; i < w9.length; i++) {
			String fileLocation = "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\mergedW9s\\"+fileName[i]+".pdf";
			Boolean flag = true;
			if(attachments[i].equals("empty")) {
				flag = false;
			}
			fileMerger(w9[i], attachments[i], fileLocation, flag);
		}
	}
	
	public void fileMerger(String w9, String attachment, String fileLocation, Boolean flag) throws IOException {
		String location = "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\imageToPdf\\imageToPDF.pdf"; 
		
		try {
			PDFMergerUtility pdfMerger = new PDFMergerUtility();
			pdfMerger.setDestinationFileName(fileLocation);
			pdfMerger.addSource(w9);
			if(flag) {
				pdfMerger.addSource(attachment);
			}
			
			pdfMerger.mergeDocuments(null);
		}catch(Exception e) {
			try {
			createPDF(attachment, location);
			
			PDFMergerUtility pdfMerger = new PDFMergerUtility();
			pdfMerger.setDestinationFileName(fileLocation);
			pdfMerger.addSource(w9);
			if(flag) {
				pdfMerger.addSource(location);
			}
			
			pdfMerger.mergeDocuments(null);
			}catch(Exception f) {
				convertToPDF(attachment,location);
				PDFMergerUtility pdfMerger = new PDFMergerUtility();
				pdfMerger.setDestinationFileName(fileLocation);
				pdfMerger.addSource(w9);
				if(flag) {
					pdfMerger.addSource(location);
				}
				
				pdfMerger.mergeDocuments(null);
			}
		}
		
	}
	
	public void paymentRequestMerge(String [] pr, String [] w9) throws IOException {
		
		String saveLocation = "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\Completed Merge\\";
		String prLocation = "C:\\Users\\campb\\OneDrive\\Documents\\Scholarship Office\\W9\\";
		String [] fileLocation = {"JAY SYMON, ABRERA 06-4-23 Inv# SCHOFF1064.pdf", "DIANA, ORTIZ CRUZ 06-4-23 Inv# SCHOFF1059.pdf", "ZIFENG MICHAEL, ZHENG 06-4-23 Inv# SCHOFF1013.pdf", "ZHI JIE, CHEN 06-4-23 Inv# SCHOFF1052.pdf"};
		
		for(int i = 0; i < pr.length; i++) {
			PDFMergerUtility pdfMerger = new PDFMergerUtility();
			pdfMerger.setDestinationFileName(saveLocation+fileLocation[i]+".pdf");
			pdfMerger.addSource(prLocation+"Original_"+pr[i]+".pdf");
			pdfMerger.addSource(w9[i]);
			
			pdfMerger.mergeDocuments(null);
		}
		
	}
	
	 public void convertToPDF(String docPath, String pdfPath) {
	        try {
	            InputStream doc = new FileInputStream(new File(docPath));
	            XWPFDocument document = new XWPFDocument(doc);
	            PdfOptions options = PdfOptions.create();
	            OutputStream out = new FileOutputStream(new File(pdfPath));
	            PdfConverter.getInstance().convert(document, out, options);
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
	
	public void createPDF(String fileName, String location) throws IOException {

		// Creating a pdf for image
		PDDocument doc = new PDDocument();
		PDPage page = new PDPage();
		doc.addPage(page);
		
		PDImageXObject image = PDImageXObject.createFromFile(fileName, doc);
		
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		contentStream.drawImage(image, 25,250,550,500);
		contentStream.close();
		
		doc.save(location);
		doc.close();
		System.out.println("PDF Created");
	}
}
package san.com.onlineshopping.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "G:\\project\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");
		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			file.transferTo(new File(REAL_PATH+code+".png"));
			//project directory upload
			file.transferTo(new File(ABS_PATH+code+".png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		

	}

}

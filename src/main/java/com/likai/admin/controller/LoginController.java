package com.likai.admin.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.likai.admin.po.User;
import com.likai.admin.vo.CommonResult;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/admin/auth/v1")
public class LoginController {

	@Autowired
	private Producer producer;

	@RequestMapping(value = "/get/captcha.jpg", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control","no-store,no-cache");
		response.setContentType("image/jpeg");
		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存验证码到session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image,"jpg",out);
		IOUtils.closeQuietly(out);
	}
}

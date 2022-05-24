package com.UserManagementSystem.UserManagementSystemSpringBoot.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.User;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.UserAddress;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.UserImage;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Dao.UserAddressDao;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Dao.UserDao;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Dao.UserImageDao;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Service.UserService;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Service.UserServiceImpl;
import com.UserManagementSystem.UserManagementSystemSpringBoot.UtilityClass.CheckValidation;
import com.UserManagementSystem.UserManagementSystemSpringBoot.UtilityClass.EncryptPwd;

@WebMvcTest(MVCController.class)
class MVCControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userservice;

	@MockBean
	private CheckValidation val;

	@MockBean
	private EncryptPwd encrypt;

	private User user;

	private UserAddress add;

	private UserImage userimage;
	@BeforeEach
	void setUp() throws Exception {
		user = new User();
		add = new UserAddress();
		userimage = new UserImage();
		user.setFirstname("Brijesh");
		user.setLastname("Rajput");
		user.setEmail("abc@gmail.com");
		user.setGender("Male");
		user.setAnswer1("Hello");
		user.setAnswer2("Hello");
		user.setDateofbirth("22/03/2000");
		user.setLanguage("English");
		String pwd = encrypt.encryption("12345");
		user.setPassword(pwd);
		user.setPhone(9898990074L);
		user.setRole("user");
		user.setUserID(1);
		List<UserAddress> addlist = new ArrayList<UserAddress>();
		add.setAdd1("Narol");
		add.setAdd2("NarolRoad");
		add.setAddressid(2);
		add.setCity("Ahmedabad");
		add.setCountry("India");
		add.setState("Gujarat");
		add.setPincode("382405");
		add.setUser(user);
		addlist.add(add);
		user.setAddress(addlist);
		List<UserImage> imglist = new ArrayList<UserImage>();
		userimage.setImgid(3);
		userimage.setUser(user);
		BufferedImage bufferimage = ImageIO.read(new File("C:\\Users\\BRIJESH RAJPUT\\Downloads\\download.png"));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(bufferimage, "png", output);
		byte[] data = output.toByteArray();
		userimage.setImgbytes(data);
		imglist.add(userimage);
		user.setPic(imglist);
	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	void testIndex() throws Exception {
		mockMvc.perform(get("/"));
	}

	@Test
	void testRegister() throws Exception {
		this.mockMvc.perform(get("/registration"));
	}
//
//	@Test
//	void testForgotpwd() {
//		fail("Not yet implemented");
//	}

	@Test
	void testRegisterUser() throws Exception {
		//when(userservice.registerUser(user).;
		//when(userservice.registerUser(user)).thenReturn();
//		mockMvc.perform(post("/userRegistration").accept(MediaType.MULTIPART_FORM_DATA_VALUE).content(objectMapper.writeValueAsString(user)))
//        .andExpect(status().isOk());
	}

	@Test
	void testCheckuserexist() throws Exception {
		boolean status = false;
		when(userservice.userExist(user.getEmail())).thenReturn(status);
		mockMvc.perform(post("/checkUserExistDone")).andDo(print())
		.andExpect(content().string(""));
	}
//
//	@Test
//	void testLogin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAdminPanel() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUserDashBoard() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLogout() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAfterforgotpwd() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testResetpwd() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testChangepwd() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGoingToEdit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEdit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUserData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteUserImage() {
//		fail("Not yet implemented");
//	}

}

// package com.qjs.test;
//
// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;
//
// import org.junit.Test;
//
// import com.qjs.wx.course.model.AccessToken;
// import com.qjs.wx.course.model.Button;
// import com.qjs.wx.course.model.ComplexButton;
// import com.qjs.wx.course.model.Menu;
// import com.qjs.wx.course.model.ViewButton;
// import com.qjs.wx.course.util.WeixinUtil;
//
// import net.glxn.qrgen.QRCode;
// import net.glxn.qrgen.image.ImageType;
// import net.glxn.qrgen.vcard.VCard;
//
// public class QrCodeTest {
// @Test
// public void test1() throws IOException {
// // file = QRCode.from("Hello World").to(ImageType.JPG).file();
// ByteArrayOutputStream stream =
// QRCode.from("http://weixin.qq.com/q/02y1qu5sIXcn31M2GM1o18").to(ImageType.JPG)
// .stream();
// FileOutputStream os = new FileOutputStream(new File("F:/a.jpg"));
// os.write(stream.toByteArray());
// os.flush();
// os.close();
// }
//
// @Test
// public void test2() throws IOException {
// VCard johnDoe = new VCard("John Doe").setEmail("john.doe@example.org")
// .setAddress("John Doe Street 1, 5678
// Doestown").setTitle("Mister").setCompany("John Doe Inc.")
// .setWebsite("www.example.org");
// ByteArrayOutputStream stream =
// QRCode.from(johnDoe).to(ImageType.JPG).stream();
// FileOutputStream os = new FileOutputStream(new File("F:/b.jpg"));
// os.write(stream.toByteArray());
// os.flush();
// os.close();
// }
//
// @Test
// public void test3() {
// ViewButton c11 = new ViewButton();
// c11.setName("购车优惠");
// c11.setType("view");
// c11.setUrl("http://qjs.s1.natapp.cc/test/id");
//
// ViewButton c21 = new ViewButton();
// c21.setName("服务大厅");
// c21.setType("view");
// c21.setUrl("http://portal.yonyouqiche.com/wx/views/fp.html");
//
// ViewButton c22 = new ViewButton();
// c22.setName("养修预约");
// c22.setType("view");
// c22.setUrl("http://portal.yonyouqiche.com/wx/views/mt.html");
// ViewButton c23 = new ViewButton();
// c23.setName("问卷调查");
// c23.setType("view");
// c23.setUrl("http://qjs.s1.natapp.cc/test/id");
//
// ViewButton c31 = new ViewButton();
// c31.setName("个人中心");
// c31.setType("view");
// c31.setUrl(
// "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb85ed633e428bafc&redirect_uri=http%3a%2f%2fportal.yonyouqiche.com%2fwx%2fredirect&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
//
// ViewButton c32 = new ViewButton();
// c32.setName("推荐有礼");
// c32.setType("view");
// c32.setUrl("http://portal.yonyouqiche.com/wx/views/td.html");
// ViewButton c33 = new ViewButton();
// c33.setName("活动中心");
// c33.setType("view");
// c33.setUrl("http://qjs.s1.natapp.cc/test/id");
//
// ComplexButton mainBtn1 = new ComplexButton();
// mainBtn1.setName("菱·购车");
// mainBtn1.setSub_button(new ViewButton[] { c11 });
//
// ComplexButton mainBtn2 = new ComplexButton();
// mainBtn2.setName("悦·服务");
// mainBtn2.setSub_button(new ViewButton[] { c21, c22, c23 });
//
// ComplexButton mainBtn3 = new ComplexButton();
// mainBtn3.setName("会·福利");
// mainBtn3.setSub_button(new ViewButton[] { c31, c32, c33 });
// Menu menu = new Menu();
// Button[] button = new Button[] { mainBtn1, mainBtn2, mainBtn3 };
// menu.setButton(button);
//
// // String appId = "wx3b91e1c6c508000b";
// // 第三方用户唯一凭证密钥
// // String appSecret = "b683ff1c8717db66a08504af04275c03";
//
// String appId = "wxb85ed633e428bafc";
// String appSecret = "0a438015c880be2a0c5ea5923652117a";
// // 调用接口获取access_token
// AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
// // String at =
// //
// "DX0aeB5TKmdNkngpU8Ka6MUYKLo0fJZm_fUeTN88HdeGjWFEOQ32Oowlv7RJYLTujZhJpFtb4RrSUeAAVcEFNaex8W1VeSjoB1YK5v4V5WvCyKm17s6c4_5NovO1gcldQJHfAFAZSQ";
// if (null != at) {
// // 调用接口创建菜单
// int result = WeixinUtil.createMenu(menu, at.getToken());
//
// // 判断菜单创建结果
// if (0 == result)
// System.out.println("菜单创建成功！");
// else
// System.out.println("菜单创建失败，错误码：" + result);
// }
// }
// }

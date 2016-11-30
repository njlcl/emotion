package dao;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import domin.User;

/*
 * 数据类
 * 1.按用户名查询用户对象User findByUsername(String username)
 * 2.将一个用户插入数据库中void add(User user)
 * */
//通过一个实现类实现接口
public class UserDaoImpl implements UserDao{
	private String path = "G://user.xml";// 依赖数据文件
	
	//按用户名查询用户对象
	public User findByUsername(String username){
		
	SAXReader reader = new SAXReader();
	try {
		Document document = reader.read(path);
		Element e=(Element)document.selectSingleNode("//user[@name='" + username + "']");
		if(e==null)return null;
		User user=new User();
		String name=e.attributeValue("name");
		String password=e.attributeValue("password");
		
		user.setName(name);
		user.setPassword(password);
		return user;
		
	} catch (DocumentException e) {
		new RuntimeException(e);
		return null;
	}
	}
	
	public void add(User user) throws IOException{
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			Element root=document.getRootElement();
			
			Element users=root.addElement("user");
			users.addAttribute("name", user.getName());
			users.addAttribute("password", user.getPassword());
			
			
			
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),
					OutputFormat.createPrettyPrint());
			writer.write(document);
			writer.close();
			
		} catch (DocumentException e) {
			new RuntimeException(e);
		}
		
	}

}

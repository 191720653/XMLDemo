package com.hand.XMLDemo;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * xml数据操作
 * @author zehao
 *
 */
public class App {
	public static void main(String[] args)
			throws SAXException, IOException, ParserConfigurationException, TransformerException, DocumentException {
		System.out.println("Hello World!");

		// 读取已有的xml文件
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("NewFile.xml"));
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName("lan");
		System.out.println("cat: " + root.getAttribute("cat"));
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element lan = (Element) nodeList.item(i);
			System.out.println("---------------");
			System.out.println("id: " + lan.getAttribute("id"));

			//按节点名读取数据
			// Element name = (Element)
			// lan.getElementsByTagName("name").item(0);
			// Element ide = (Element) lan.getElementsByTagName("ide").item(0);
			// System.out.println("name: "+name.getTextContent());
			// System.out.println("ide: "+ide.getTextContent());

			//循环读取
			NodeList list = lan.getChildNodes();
			for (int j = 0; j < list.getLength(); j++) {
				Node temp = list.item(j);
				if (temp instanceof Element) {
					System.out.println(temp.getNodeName() + ": " + temp.getTextContent());
				}
			}
		}

		// 创建xml文件并且写入数据
		// DocumentBuilderFactory documentBuilderFactory =
		// DocumentBuilderFactory.newInstance();
		// DocumentBuilder documentBuilder =
		// documentBuilderFactory.newDocumentBuilder();
		// Document document = documentBuilder.newDocument();
		// Element root = document.createElement("lanuage");
		// root.setAttribute("cat", "it");
		//
		// Element lan = document.createElement("lan");
		// lan.setAttribute("id", "1");
		// Element name = document.createElement("name");
		// name.setTextContent("java");
		// Element ide = document.createElement("ide");
		// ide.setTextContent("eclipse");
		// lan.appendChild(name);
		// lan.appendChild(ide);
		//
		// root.appendChild(lan);
		//
		// lan = document.createElement("lan");
		// lan.setAttribute("id", "2");
		// name = document.createElement("name");
		// name.setTextContent("swift");
		// ide = document.createElement("ide");
		// ide.setTextContent("xcode");
		// lan.appendChild(name);
		// lan.appendChild(ide);
		//
		// root.appendChild(lan);
		//
		// lan = document.createElement("lan");
		// lan.setAttribute("id", "3");
		// name = document.createElement("name");
		// name.setTextContent("c#");
		// ide = document.createElement("ide");
		// ide.setTextContent("visual studio");
		// lan.appendChild(name);
		// lan.appendChild(ide);
		//
		// root.appendChild(lan);
		// document.appendChild(root);
		// //生成xml文件
		// TransformerFactory transformerFactory =
		// TransformerFactory.newInstance();
		// Transformer transformer = transformerFactory.newTransformer();
		// transformer.transform(new DOMSource(document), new StreamResult(new
		// File("new.xml")));

		// 测试使用dom4j.jar解读xml
		// 在这里要：把上面的import org.w3c.dom.Document;换成import
		// org.dom4j.Document;然后注释上面的代码
		// String xml =
		// "<languages><lan><name>java</name><ide>eclipse</ide></lan></languages>";
		//
		// Document document = DocumentHelper.parseText(xml);
		// System.out.println(document.asXML());

	}
}

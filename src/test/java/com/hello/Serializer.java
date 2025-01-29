package com.hello;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.marshall.Xml;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;




public class Serializer {
	public static void main(String[] args) throws SerializeException, ParseException {
		
		
		//pojo to json
		
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		String sellerNames[]= {"Neon enterprises","Abc software","XYZ IT solution"};
		Product products = new Product("MacroPro",1000,"white",sellerNames);
		String json = jsonSerializer.serialize(products);
		System.out.println(json);
		
		
		
		//pojo to xml
		
		XmlSerializer xmlserilizer = XmlSerializer.DEFAULT_NS_SQ;
		String xml = xmlserilizer.serialize(products);
		System.out.println(xml);
		
		
		//pojo to html
		
		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
		String html = htmlSerializer.serialize(products);
		System.out.println(html);
		
		
		
		
		//DeSerialization
		//json to pojo
		
		JsonParser jsonParser= JsonParser.DEFAULT;
		String jsonVal="{\r\n"
				+ "	\"color\": \"white\",\r\n"
				+ "	\"name\": \"MacroPro\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellerNames\": [\r\n"
				+ "		\"Neon enterprises\",\r\n"
				+ "		\"Abc software\",\r\n"
				+ "		\"XYZ IT solution\"\r\n"
				+ "	]\r\n"
				+ "}";
		
		Product pro=jsonParser.parse(jsonVal,Product.class);
		System.out.println(pro.getColor());
		System.out.println(pro);
				
				
		
		
	}

}

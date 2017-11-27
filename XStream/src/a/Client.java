package a;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String args[]) throws IOException, Exception
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		Marshaller marsh = (Marshaller) context.getBean("xstreamMarshallerBean");
		
		Employee emp = new Employee();
		emp.setUsername("Milind");
		emp.setId(1);
		emp.setAddress("jaipur");
		
		marsh.marshal(emp, new StreamResult(new FileWriter("employee.xml")));
		
		System.out.print("xml created");
	}

}


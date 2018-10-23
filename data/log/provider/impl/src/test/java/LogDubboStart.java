
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogDubboStart {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"conf/dubbo/dubbo.xml"});
		context.start();
		//ITestService bean = (ITestService)context.getBean("iTestService");
		//bean.exectue();
		System.out.println("Pleas print any key ....");
		System.in.read();
	}
}

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import commonFunctionsPackage.Utility_Common_Function;

public class DriverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{

		ArrayList<String> testCaseRun=Utility_Common_Function.readdataexcel("Test_Runner","TestCaseNameToExecute");
		int count=testCaseRun.size();
		System.out.println(count);
		for (int i=1; i<count;i++)
		{
			String testCaseName=testCaseRun.get(i);
			
			Class<?> testClassName=Class.forName("TestCasePackage."+testCaseName);
			
			Method executeMethod = testClassName.getDeclaredMethod("execute");
			
			executeMethod.setAccessible(true);
			
			Object instanceOfTestClass=testClassName.getDeclaredConstructor().newInstance();
			
			executeMethod.invoke(instanceOfTestClass);
		}
	}

}

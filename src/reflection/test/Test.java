package reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import reflection.classes.A;


public class Test {

	public static void main(String[] args) {
		
		Class classA;
		
		// Prvi nacin
		classA = A.class;
		
		// Drugi nacin
		A a = new A();
		classA = a.getClass();
		
		// Treci nacin
		try {
			classA = Class.forName("reflection.classes.A");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Prikaz svih atributa klase:");
		Field[] fields = classA.getDeclaredFields();
		for(Field f : fields){
			String modifier = Modifier.toString(f.getModifiers());
			Class type = f.getType();
			String name = f.getName();
			System.out.println("\t" + modifier + " " + type + " " + name);
		}
		
		
		System.out.println("\nPrikaz svih konstruktora klase:");
		Constructor[] constructors = classA.getDeclaredConstructors();
		for(Constructor c : constructors){
			String modifier = Modifier.toString(c.getModifiers());
			String name = c.getName();
			
			System.out.print("\t" + modifier + " " + name + "(");
			
			Class[] parameters = c.getParameterTypes();
			for(int i=0; i<parameters.length; i++){
				if(i>0)
					System.out.print(", ");
				System.out.print(parameters[i].getName());
			}
			System.out.print(")\n");
		}
		
		
		System.out.println("\nPrikaz svih metoda klase:");
		Method[] methods = classA.getDeclaredMethods();
		for(Method m : methods){
			String modifier = Modifier.toString(m.getModifiers());
			Class returnType = m.getReturnType();
			String name = m.getName();
			
			System.out.print("\t" + modifier + " " + returnType + " " + name + "(");
			Class[] parameters = m.getParameterTypes();
			for(int i=0; i<parameters.length; i++){
				if(i>0)
					System.out.print(", ");
				System.out.print(parameters[i].getName());
			}
			System.out.print(")\n");
		}
		
		
		System.out.println("\nPozivanje metode:");
		try {
			A tmp = (A)classA.newInstance();
			tmp.setField1("dr Branko Perisic");
			tmp.setField2(1000);
			tmp.setField3(true);
			
			// Pozivanje metode nad objektom klase A
			//System.out.println(tmp);
			
			// Pozivanje putem refleksije
			Method method = classA.getMethod("toString", null);
			String methodResult = (String) method.invoke(tmp, null);
			
			System.out.println(methodResult);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

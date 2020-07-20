package org.Spring.Demo;

import org.Spring.Dao.DaoImpl;
import org.Spring.Model.Circle;

public class AppDemo {

	public static void main(String[] args) {
		Circle circle=new DaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}

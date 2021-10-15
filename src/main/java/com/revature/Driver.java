package com.revature;

import com.revature.controllers.MenuController;

public class Driver {

	public static void main(String[] args) {
		try {
		MenuController menuController = new MenuController();
		
		menuController.login();
		System.out.println(" ----------------that is all---------------------- ");
		}catch(java.lang.NullPointerException e) {
		e.printStackTrace();
		System.out.println("Try again when options corrected");
		}
	}

}

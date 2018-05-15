package models;

import java.util.Scanner;

import tools.DBconnection;

public class DadosBanco {
	
	private static Scanner scan = DBconnection.scan;

	public static void main(String[] args) {
		
		DBconnection conn = new DBconnection();

		System.out.println("Email do aluno: ");
		String busca = scan.nextLine();
		conn.executeSQL("select * from Alunos where email = '" + busca + "'");
	}
}

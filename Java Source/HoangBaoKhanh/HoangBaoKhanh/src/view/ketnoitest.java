package view;

import dao.Database;

public class ketnoitest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("LAB401-16", "Ontap5", "sa", "123", 1433 );
		db.connect();
	}

}

package util;

import DAO.TipoFaseDAO;
import model.TipoFase;

import java.sql.SQLException;
import java.util.List;

public class Program {
	
	static TipoFaseDAO tipoFaseDAO = new TipoFaseDAO();

	public static void main(String[] args) {

		TipoFase tipoFase = new TipoFase("Teste");
		
		tipoFase = tipoFaseDAO.selectTipoFase(2);
        System.out.println(tipoFase);

	}

}

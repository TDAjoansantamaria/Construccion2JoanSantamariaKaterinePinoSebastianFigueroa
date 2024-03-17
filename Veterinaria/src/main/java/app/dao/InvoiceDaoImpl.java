package app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import app.config.MYSQLConnection;
import app.dto.InvoiceDto;

public class InvoiceDaoImpl implements InvoiceDao {
	public Connection connection = MYSQLConnection.getConnection();

	public void createInvoice(InvoiceDto invoiceDto) throws Exception {
		String query3 = "SELECT * FROM ORDERHC WHERE IDORDER = ? AND ORDERCANCELLATION = 'ACTIVE'";
		PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
		preparedStatement3.setLong(1, invoiceDto.getIdOrder());
		ResultSet resultSet3 = preparedStatement3.executeQuery();
		if (resultSet3.next()) {
		}

		String query = "SELECT * FROM INVOICE INNER JOIN PET ON INVOICE.IDPET = PET.IDPET INNER JOIN PERSON ON INVOICE.IDOWNER= PERSON.IDPERSON "
				+ "INNER JOIN ORDERHC ON INVOICE.IDORDER = ORDERHC.IDORDER WHERE IDORDER = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, invoiceDto.getIdOrder());
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
		}

		long date = resultSet.getLong("DATAORDER");
		Date date1 = new Date(date);
		String date2 = date1.toString();
		System.out.println("------------------------------------------------------------------------------------ \n"
				+ "                ORDEN # " + invoiceDto.getIdOrder() + "\n"
				+ "-------------------------------------------------------------------------- \n"
				+ " Fecha elaboración: " + date2 + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Codigo mascota:                   " + resultSet3.getLong("PET") + "\n"
				+ " Nombre de mascota:                " + resultSet.getString("NAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Cedula propietario:               " + resultSet3.getLong("OWNER") + "\n"
				+ " Nombre del propietario:           " + resultSet.getString("FULLNAME") + "\n");
		/*
		 * String query =
		 * "INSERT INTO INVOICE (IDINVOICE, IDPET, IDOWNER, IDORDER, PRODUCTNAME, VALUEINVOICE, QUANTITY, INVOICEDATE) VALUES( ?,?,?,?,?,?,?,?)"
		 * ; PreparedStatement preparedStatement = connection.prepareStatement(query);
		 * int i = 1; preparedStatement.setLong(i++, InvoiceDto.getIdinvoice());
		 * preparedStatement.setLong(i++, InvoiceDto.getIdPet());
		 * preparedStatement.setLong(i++, InvoiceDto.getIdOwner());
		 * preparedStatement.setLong(i++, InvoiceDto.getIdOrder());
		 * preparedStatement.setString(i++, InvoiceDto.getProductName());
		 * preparedStatement.setDouble(i++, InvoiceDto.getValueInvoice());
		 * preparedStatement.setInt(i++, InvoiceDto.getQuantity());
		 * preparedStatement.setDate(i++, InvoiceDto.getInvoiceDate());
		 * preparedStatement.execute(); preparedStatement.close();
		 */
	}
}

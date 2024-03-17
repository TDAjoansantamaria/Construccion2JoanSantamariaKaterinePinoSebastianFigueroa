package app.validators;

public class InvoiceInputsValidator extends InputsValidator {

	public long idInvoiceValidator(String longidInvoice) throws Exception {
		return super.longValidator(longidInvoice, "Id de la factura");

	}

	public long idPetValidator(String longidPet) throws Exception {
		return super.longValidator(longidPet, "Id de la mascota");
	}

	public long idOwnerValidator(String longidOwner) throws Exception {
		return super.longValidator(longidOwner, "Id del dueño");
	}

	public void productNameValidator(String productName) throws Exception {
		super.stringValidator(productName, "Nombre del producto");
	}

	public long idOrderValidator(String longidOrder) throws Exception {
		return super.longValidator(longidOrder, "Id de la orden");
	}

	public double valueInvoiceValidator(String valueInvoice) throws Exception {
		return super.doubleValidator(valueInvoice, "valor de la factura");
	}

	public int quantityeValidator(String quantity) throws Exception {
		return super.integerValidator(quantity, "Cantidad");
	}

}

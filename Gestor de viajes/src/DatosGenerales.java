
public class DatosGenerales {
	
	private static String[] textoMonedas = {"Dolares", "Euros", "Libras", "Yenes"};
	private static Float[] valorConversion = {1.13f, 1f, 0.75f, 132.47f};
	int eleccionConversion = 0;
	
	public DatosGenerales(){
		
	}
	
	public boolean esNumero(String name){
		try{
			Float.parseFloat(name);
			return true;
		}catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public float calculoConversion(Float euro, int posicion){
		float conversion = euro * valorConversion[posicion];
		return conversion;
	}
	
	public String muestraMensaje(int posicion){
		String mensaje = "Todo OK. La moneda seleccionada es: "+textoMonedas[posicion];
		return mensaje;
	}

}

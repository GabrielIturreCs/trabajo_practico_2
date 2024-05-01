package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
   JUJUY(811611, 53219.0), SALTA(1441351, 155448.0), TUCUMAN(1731820, 22524.0), CATAMARCA(429562, 102602.0), LA_RIOJA(383865, 89680.0), SANTIAGO_DEL_ESTERO(1060906, 136351.0);
	
	private int poblacion;
	private double superficie;
	
	private Provincia(int poblacion, double superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public long getCantidadPoblacion() {
		return poblacion;
	}

	public double getSuperficie() {
		return superficie;
	}
    
   
    public double densidad() {
    	return poblacion / superficie;
    }
}